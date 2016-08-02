package com.appteam.nithapp.Network;

import com.appteam.nithapp.Model.AddComment;
import com.appteam.nithapp.Model.AddTopic;
import com.appteam.nithapp.Model.CommentResponse;
import com.appteam.nithapp.Model.ForumResponse;
import com.appteam.nithapp.Model.topicResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ramola on 7/31/2016.
 */
public interface RetroService {

    @GET("main_forum.php")
    Call<ForumResponse> getAllForum();

    @POST("add_new_topic.php")
    Call<AddTopic> sendTopic(@Body AddTopic topic);

    @POST("add_answer.php")
    Call<AddComment> sendComment(@Body AddComment comment);

    @GET("view_comment.php")
    Call<CommentResponse> getAllComment(@Query("id") int id);

    @GET("view_topic.php")
    Call<topicResponse> getTopic(@Query("id") int id);
}
