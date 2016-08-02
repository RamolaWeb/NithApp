package com.appteam.nithapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramola on 8/2/2016.
 */
public class topicResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("time")
    private String time;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
