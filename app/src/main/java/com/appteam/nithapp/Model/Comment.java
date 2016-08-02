package com.appteam.nithapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramola on 8/2/2016.
 */
public class Comment  {
    @SerializedName("")
    private String a_name;
    @SerializedName("")
    private String a_answer;
    @SerializedName("")
    private String time;

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
