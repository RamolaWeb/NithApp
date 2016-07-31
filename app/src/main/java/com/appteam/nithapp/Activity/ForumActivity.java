package com.appteam.nithapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.appteam.nithapp.R;

import java.util.ArrayList;

import Model.ForumModel;
import RecyclerViews.ForumRecyclerView;

public class ForumActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ForumRecyclerView adapter;
private ArrayList<ForumModel> list;

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
        adapter=new ForumRecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}
