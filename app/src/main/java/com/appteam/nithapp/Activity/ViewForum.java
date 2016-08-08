package com.appteam.nithapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.appteam.nithapp.Model.AddComment;
import com.appteam.nithapp.Model.CommentResponse;
import com.appteam.nithapp.Model.topicResponse;
import com.appteam.nithapp.Network.RetroCreator;
import com.appteam.nithapp.R;
import com.appteam.nithapp.RecyclerViews.CommentRecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewForum extends AppCompatActivity {
    private TextView name,title,time,content;
    public static final String ID_TOPIC = "id";
    private LinearLayout l,layout;
    private EditText e;
    private RecyclerView list;
    private CommentRecyclerView adapter;
    private int id;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_forum);

        name= (TextView) findViewById(R.id.name_user_forum);
        title= (TextView) findViewById(R.id.text_title_forum);
        time= (TextView) findViewById(R.id.time_created_forum);
        content= (TextView) findViewById(R.id.text_content_forum);
        layout= (LinearLayout) findViewById(R.id.layout);
        progressBar= (ProgressBar) findViewById(R.id.progress);

        Intent i=getIntent();
        if(i!=null){
            id=i.getIntExtra(ID_TOPIC,-1);
        }

        e= (EditText) findViewById(R.id.comment_editext);
        Button show_send_comment = (Button) findViewById(R.id.button_add_comment);
         l = (LinearLayout) findViewById(R.id.comment_layout);

        show_send_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.setVisibility(View.VISIBLE);
            }
        });



        findViewById(R.id.submit_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment=e.getText().toString();
                 if(!comment.isEmpty()){
                     sendComment(comment);
                 }
            }
        });

        list = (RecyclerView) findViewById(R.id.list_comment);
        adapter = new CommentRecyclerView();
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        getTopicData(id);
        getComment(id);

    }

    private void sendComment(String e){
        AddComment add=new AddComment(""+id,"Sahil","sramola52gmail.com",e);
        Call<AddComment> call= RetroCreator.getService().sendComment(add.getA_id(),add.getA_name(),add.getA_email(),add.getA_answer());
        call.enqueue(new Callback<AddComment>() {
            @Override
            public void onResponse(Call<AddComment> call, Response<AddComment> response) {
                getComment(id);
            }

            @Override
            public void onFailure(Call<AddComment> call, Throwable t) {

            }
        });
    }

    private void getTopicData(int id){
        Call<topicResponse> call= RetroCreator.getService().getTopic(id);
        call.enqueue(new Callback<topicResponse>() {
            @Override
            public void onResponse(Call<topicResponse> call, Response<topicResponse> response) {
                progressBar.setVisibility(View.GONE);
                layout.setVisibility(View.VISIBLE);
                topicResponse t=response.body();
                name.setText(t.getName());
                title.setText(t.getTitle());
                time.setText(t.getTime());
                content.setText(t.getContent());
                layout.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(Call<topicResponse> call, Throwable t) {
                 Toast.makeText(ViewForum.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void getComment(int id){
        Call<CommentResponse> call = RetroCreator.getService().getAllComment(id);
        call.enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                layout.setVisibility(View.VISIBLE);
                adapter.refresh(response.body().getList());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
