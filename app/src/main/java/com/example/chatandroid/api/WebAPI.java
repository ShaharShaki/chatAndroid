package com.example.chatandroid.api;

import com.example.chatandroid.ContactUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebAPI {

    @GET("contacts")
    Call<List<ContactUser>> getPosts();

    @POST("posts")
    Call<Void> createPost(@Body ContactUser post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
