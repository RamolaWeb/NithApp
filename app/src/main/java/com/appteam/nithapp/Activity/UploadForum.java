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

import com.appteam.nithapp.EditorView.EditorView;
import com.appteam.nithapp.R;

public class UploadForum extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST =1;
    private EditorView editorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_forum);
        editorView= (EditorView) findViewById(R.id.editor);

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
                return true;
            default:
        return super.onOptionsItemSelected(item);}
    }
}
