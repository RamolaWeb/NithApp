package com.appteam.nithapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.appteam.nithapp.Fragment.Comment_Forum;
import com.appteam.nithapp.Fragment.Content_Forum;
import com.appteam.nithapp.Model.AddComment;
import com.appteam.nithapp.Network.RetroCreator;
import com.appteam.nithapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewForum extends AppCompatActivity {

    public static final String ID_TOPIC = "id";
    private LinearLayout l;
    private EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_forum);

        e= (EditText) findViewById(R.id.comment_editext);
        Button show_send_comment = (Button) findViewById(R.id.button_add_comment);
         l = (LinearLayout) findViewById(R.id.comment_layout);

        show_send_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.setVisibility(View.VISIBLE);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            Comment_Forum.newInstance(intent.getIntExtra(ID_TOPIC, -1));
            Content_Forum.newInstance(intent.getIntExtra(ID_TOPIC, -1));
        }

        findViewById(R.id.submit_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment=e.getText().toString();
                 if(!comment.isEmpty()){
                     sendComment(comment);
                 }
            }
        });
    }

    private void sendComment(String e){
        AddComment add=new AddComment();
        Call<AddComment> call= RetroCreator.getService().sendComment(add);
        call.enqueue(new Callback<AddComment>() {
            @Override
            public void onResponse(Call<AddComment> call, Response<AddComment> response) {
                l.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<AddComment> call, Throwable t) {

            }
        });
    }

}
