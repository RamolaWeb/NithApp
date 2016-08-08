package com.appteam.nithapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramola on 8/2/2016.
 */
public class topicResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("datetime")
    private String time;
    @SerializedName("topic")
    private String title;
    @SerializedName("detail")
    private String content;

    @SerializedName("email")
    private String email;

    public topicResponse(String name, String time, String title, String content, String email) {
        this.name = name;
        this.time = time;
        this.title = title;
        this.content = content;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
