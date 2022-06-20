package com.example.chatandroid.api;

import com.example.chatandroid.ContactUser;
import com.example.chatandroid.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebAPI {

    @GET("contacts")
    Call<List<ContactUser>> getContacts(@Query("id") String username);
    //Call<List<ContactUser>> getPosts();

    @GET("contacts/{id}/messages")
    Call<List<Message>> getMessagess(@Path("id") String id,
                                @Query("currentId") String username);
                                //     @Path("id") String id);
    //Call<List<ContactUser>> getPosts();


    @Headers("content-type: application/json")
    @POST("login/{id}/{password}")
    Call<String> checkLogin
            (@Path("id") String username,
                         @Path("password") String password);
   // (@Body ContactUser user);

    @POST("posts")
    Call<Void> createPost(@Body ContactUser post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
