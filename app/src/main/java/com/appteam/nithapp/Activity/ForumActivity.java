package com.appteam.nithapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appteam.nithapp.Model.ForumModel;
import com.appteam.nithapp.Model.ForumResponse;
import com.appteam.nithapp.Network.RetroCreator;
import com.appteam.nithapp.R;
import com.appteam.nithapp.Utility.DividerItemDecoration;
import com.appteam.nithapp.Utility.RecyclerItemClickListener;
import com.appteam.nithapp.RecyclerViews.ForumRecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ForumRecyclerView adapter;
private ArrayList<ForumModel> list;
private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(ForumActivity.this,UploadForum.class));
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.list);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
        adapter=new ForumRecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        Call<ForumResponse> forumData= RetroCreator.getService().getAllForum();
        forumData.enqueue(new Callback<ForumResponse>() {
            @Override
            public void onResponse(Call<ForumResponse> call, Response<ForumResponse> response) {
                list=response.body().getForum();
                adapter.refresh(list);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ForumResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ForumActivity.this,""+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i=new Intent(ForumActivity.this,ViewForum.class);
                i.putExtra(ViewForum.ID_TOPIC,Integer.parseInt(list.get(position).getId()));
                startActivity(i);
            }
        }));
    }


}
