package com.example.chatandroid.api;


import com.example.chatandroid.ContactUser;
import com.example.chatandroid.MyApplication;
import com.example.chatandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAPI {
    Retrofit retrofit;
    WebAPI webServiceAPI;

    public UserAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebAPI.class);
    }

    public void get() {
        Call<List<ContactUser>> call = webServiceAPI.getContacts("Erel");
      //  Call<List<ContactUser>> call = webServiceAPI.getPosts();

        call.enqueue(new Callback<List<ContactUser>>() {
            @Override
            public void onResponse(Call<List<ContactUser>> call, Response<List<ContactUser>> response) {
                List<ContactUser> list = response.body();
            }

            @Override
            public void onFailure(Call<List<ContactUser>> call, Throwable t) {
            }
        });
    }

}