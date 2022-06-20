package com.example.chatandroid.api;


import com.example.chatandroid.ContactUser;
import com.example.chatandroid.ContactUsersDao;
import com.example.chatandroid.MyApplication;
import com.example.chatandroid.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAPI {
    Retrofit retrofit;
    WebAPI webServiceAPI;
    ContactUsersDao dao;

    public UserAPI(ContactUsersDao dao) {
        this.dao = dao;
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebAPI.class);
    }

    public void get(String username) {
        Call<List<ContactUser>> call = webServiceAPI.getContacts(username);
      //  Call<List<ContactUser>> call = webServiceAPI.getPosts();

        call.enqueue(new Callback<List<ContactUser>>() {
            @Override
            public void onResponse(Call<List<ContactUser>> call, Response<List<ContactUser>> response) {
                List<ContactUser> list = response.body();
                List<ContactUser> tempList = new ArrayList<>();
                tempList = dao.index();
                boolean shouldAddNewUser = true;
                for (int i=0;i<list.size();i++){
                    shouldAddNewUser = true;
                    list.get(i).setCurrentUserLogin(username);
                    for (int j=0; j< tempList.size();j++ ) {
                        if (list.get(i).getName().equals(tempList.get(j).getName()))
                            shouldAddNewUser = false;
                    }
                    if (shouldAddNewUser)
                        dao.insert(list.get(i));
                        dao.update();
                }
             //   dao.insertUsers(list);
            //    dao.update();
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<ContactUser>> call, Throwable t) {
            }
        });
    }

    public void validateLogin(String username, String password) {
        ContactUser user = new ContactUser(username,password);
        Call<String> call = webServiceAPI.checkLogin(user);
        //  Call<List<ContactUser>> call = webServiceAPI.getPosts();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response.body();
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }


}