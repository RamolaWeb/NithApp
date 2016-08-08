package com.appteam.nithapp.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appteam.nithapp.EditorView.EditorView;
import com.appteam.nithapp.Model.AddTopic;
import com.appteam.nithapp.Network.RetroCreator;
import com.appteam.nithapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadForum extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST =1;
    private EditorView editorView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_forum);
        editorView= (EditorView) findViewById(R.id.editor);
        progressBar= (ProgressBar) findViewById(R.id.progress);

    }

    private void createchooser(){
        Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "CHOOSE PHOTO"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(filePath, filePathColumn, null, null, null);
            c.moveToFirst();
            String imgDecodableString = c.getString(c.getColumnIndex(filePathColumn[0]));
            c.close();
            Bitmap bitmap = BitmapFactory.decodeFile(imgDecodableString);
            Bitmap bitmap1=Bitmap.createScaledBitmap(bitmap,getWindow().getWindowManager().getDefaultDisplay().getWidth()/2,getWindow().getWindowManager().getDefaultDisplay().getHeight()/2,true);
            editorView.addImage(bitmap1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_forum,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.send_photo:
                createchooser();
                return true;
            case R.id.send_forum:
                progressBar.setVisibility(View.VISIBLE);
                sendTopic(editorView.buildEditData());
                return true;
            default:
        return super.onOptionsItemSelected(item);}
    }

    private void sendTopic(AddTopic topic){
        Call<AddTopic> call= RetroCreator.getService().sendTopic(topic.getTopic(),topic.getDetail(),topic.getName(),topic.getEmail());
        call.enqueue(new Callback<AddTopic>() {
            @Override
            public void onResponse(Call<AddTopic> call, Response<AddTopic> response) {
                Toast.makeText(UploadForum.this," Forum Succcesfully Uploaded",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<AddTopic> call, Throwable t) {
                Toast.makeText(UploadForum.this,"Pleaae Try Again",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
