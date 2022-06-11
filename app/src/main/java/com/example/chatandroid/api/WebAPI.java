package com.example.chatandroid.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebAPI {
    @GET("posts")
    Call<List<String>> getPosts();

    @POST("posts")
    Call<Void> createPost(@Body String post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}