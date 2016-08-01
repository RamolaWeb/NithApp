package com.appteam.nithapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.appteam.nithapp.EditorView.EditorView;
import com.appteam.nithapp.R;

public class UploadForum extends AppCompatActivity {
private EditorView editorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_forum);
        editorView= (EditorView) findViewById(R.id.editor);
    }
}
