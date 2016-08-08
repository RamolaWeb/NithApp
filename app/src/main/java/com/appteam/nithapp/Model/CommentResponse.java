package com.appteam.nithapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by lenovo on 8/2/2016.
 */
public class CommentResponse {
    @SerializedName("comment_forum")
    private ArrayList<Comment> list;

    public CommentResponse(ArrayList<Comment> list) {
        this.list = list;
    }

    public ArrayList<Comment> getList() {
        return list;
    }

    public void setList(ArrayList<Comment> list) {
        this.list = list;
    }
}
