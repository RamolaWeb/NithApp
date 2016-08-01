package com.appteam.nithapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramola on 7/31/2016.
 */
public class ForumModel implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("id")
    private String id;
    @SerializedName("author")
    private String author;
    @SerializedName("date")
    private String created_on;
    @SerializedName("upvote")
    private String up_vote;
    @SerializedName("total comment")
    private String total_comment;

    @SerializedName("")
    private String content_image;

    public ForumModel(String title, String id, String author, String created_on, String up_vote, String total_comment) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.created_on = created_on;
        this.up_vote = up_vote;
        this.total_comment = total_comment;
    }

    public ForumModel(String title, String id, String author, String created_on, String up_vote, String total_comment, String content_image) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.created_on = created_on;
        this.up_vote = up_vote;
        this.total_comment = total_comment;
        this.content_image = content_image;
    }

    protected ForumModel(Parcel in) {
        title = in.readString();
        id = in.readString();
        author = in.readString();
        created_on = in.readString();
        up_vote = in.readString();
        total_comment = in.readString();
        content_image = in.readString();
    }

    public static final Creator<ForumModel> CREATOR = new Creator<ForumModel>() {
        @Override
        public ForumModel createFromParcel(Parcel in) {
            return new ForumModel(in);
        }

        @Override
        public ForumModel[] newArray(int size) {
            return new ForumModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(id);
        parcel.writeString(author);
        parcel.writeString(created_on);
        parcel.writeString(up_vote);
        parcel.writeString(total_comment);
        parcel.writeString(content_image);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getUp_vote() {
        return up_vote;
    }

    public void setUp_vote(String up_vote) {
        this.up_vote = up_vote;
    }

    public String getTotal_comment() {
        return total_comment;
    }

    public void setTotal_comment(String total_comment) {
        this.total_comment = total_comment;
    }

    public String getContent_image() {
        return content_image;
    }

    public void setContent_image(String content_image) {
        this.content_image = content_image;
    }
}
