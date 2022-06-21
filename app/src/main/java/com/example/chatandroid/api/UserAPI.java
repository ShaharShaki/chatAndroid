package com.example.chatandroid.api;


import com.example.chatandroid.ContactUser;
import com.example.chatandroid.ContactUsersDao;
import com.example.chatandroid.MyApplication;
import com.example.chatandroid.R;

import com.example.chatandroid.Message;
import com.example.chatandroid.messagesDao;



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
    messagesDao daoMsg;

    public UserAPI(ContactUsersDao dao) {
        this.dao = dao;
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebAPI.class);
    }

    public UserAPI(messagesDao dao) {
        this.daoMsg = dao;
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
                if (list != null) {
                    List<ContactUser> tempList = new ArrayList<>();
                    tempList = dao.index();
                    boolean shouldAddNewUser = true;
                    for (int i = 0; i < list.size(); i++) {
                        shouldAddNewUser = true;
                        list.get(i).setCurrentUserLogin(username);
                        for (int j = 0; j < tempList.size(); j++) {
                            if (list.get(i).getName().equals(tempList.get(j).getName()))
                                shouldAddNewUser = false;
                        }
                        if (shouldAddNewUser)
                            dao.insert(list.get(i));
                      //  dao.update();
                    }
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


    public void getMessages(String currentUser, String contact) {

        Call<List<Message>> call = webServiceAPI.getMessagess(currentUser,contact);
        //  Call<List<ContactUser>> call = webServiceAPI.getPosts();

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                List<Message> list = response.body();
                if (list != null){
                    List<Message> tempList = new ArrayList<>();
                    tempList = daoMsg.get(contact, currentUser);
                    boolean shouldAddMessage = true;
                    for (int i = 0; i < list.size(); i++) {
                        shouldAddMessage = true;
                        //  list.get(i).setCurrentUserLogin(username);
                        list.get(i).setFirstUser(contact);
                        list.get(i).setSecondUser(currentUser);
                        for (int j = 0; j < tempList.size(); j++) {
                            if (list.get(i).getCreated().equals(tempList.get(j).getCreated()) &&
                                    list.get(i).getContent().equals(tempList.get(j).getContent()))
                                shouldAddMessage = false;
                        }
                        if (shouldAddMessage) {
                            daoMsg.insert(list.get(i));
                            daoMsg.update(list.get(i));
                        }
                    }
                }
                //   dao.insertUsers(list);
                //    dao.update();
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
            }
        });
    }


    public void validateLogin(String username, String password) {
        ContactUser user = new ContactUser(username,password);
        Call<String> call = webServiceAPI.checkLogin(username,password);
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

    public void postContact(ContactUser user, String currentId) {
        Call<Void> call = webServiceAPI.createContact(user, currentId);
        //  Call<List<ContactUser>> call = webServiceAPI.getPosts();

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                response.body();
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
    }


    public void registerUser(String id,String name, String password) {
        //ContactUser user = new ContactUser(id,name,password);
        //user.setCurrentUserLogin(id);
        Call<String> call = webServiceAPI.regiUser(id,name,password);
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