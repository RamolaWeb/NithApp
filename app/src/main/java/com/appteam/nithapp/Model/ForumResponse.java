package com.appteam.nithapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ramola on 7/31/2016.
 */
public class ForumResponse {

    @SerializedName("main_forum")
    private ArrayList<ForumModel> forum;

    public ForumResponse(ArrayList<ForumModel> forum) {
        this.forum = forum;
    }

    public ArrayList<ForumModel> getForum() {
        return forum;
    }

    public void setForum(ArrayList<ForumModel> forum) {
        this.forum = forum;
    }
}
