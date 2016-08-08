package com.appteam.nithapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramola on 8/2/2016.
 */
public class Comment {

    @SerializedName("a_id")
    private String a_id;
    @SerializedName("a_name")
    private String a_name;
    @SerializedName("a_answer")
    private String a_answer;
    @SerializedName("a_datetime")
    private String time;
    @SerializedName("a_email")
    private String email;

    public Comment(String a_id, String a_name, String a_answer, String time, String email) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_answer = a_answer;
        this.time = time;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_answer() {
        return a_answer;
    }

    public void setA_answer(String a_answer) {
        this.a_answer = a_answer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
