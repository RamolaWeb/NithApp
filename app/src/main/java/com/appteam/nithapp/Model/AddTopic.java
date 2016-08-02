package com.appteam.nithapp.Model;

/**
 * Created by Ramola on 8/2/2016.
 */
public class AddTopic {

    private String topic;
    private String detail;
    private String name;
    private String email;

    public AddTopic(String topic, String detail, String name, String email) {
        this.topic = topic;
        this.detail = detail;
        this.name = name;
        this.email = email;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
