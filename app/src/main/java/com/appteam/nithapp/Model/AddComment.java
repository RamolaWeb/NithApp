package com.appteam.nithapp.Model;

/**
 * Created by Ramola on 8/2/2016.
 */
public class AddComment {

    private String a_id;
    private String a_name;
    private String a_email;
    private String a_answer;

    public AddComment(String a_id, String a_name, String a_email, String a_answer) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_email = a_email;
        this.a_answer = a_answer;
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

    public String getA_email() {
        return a_email;
    }

    public void setA_email(String a_email) {
        this.a_email = a_email;
    }
}
