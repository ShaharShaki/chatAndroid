package com.example.chatandroid.api;


import com.example.chatandroid.ContactUser;
import com.example.chatandroid.MyApplication;
import com.example.chatandroid.R;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;



public class UserAPI {
    //    private MutableLiveData<List<Post>> postListData;
//    private PostDao dao;
    Retrofit retrofit;
    WebAPI webServiceAPI;

    public UserAPI() {
//        this.postListData = postListData;
//        this.dao = dao;

        retrofit = new Retrofit.Builder()
                 .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebAPI.class);
    }

    public static void get() {
        Call<List<ContactUser>> call = WebAPI.getPosts();
        call.enqueue(new Callback<List<ContactUser>>() {
            @Override
            public void onResponse(Call<List<ContactUser>> call, Response<List<ContactUser>> response) {
                List<ContactUser> contacts = response.body();
//                new Thread(() -> {
//                    dao.clear();
//                    dao.insertList(response.body());
//                    postListData.postValue(dao.get());
//                }).start();
            }

            @Override
            public void onFailure(Call<List<ContactUser>> call, Throwable t) {
            }
        });
    }
}