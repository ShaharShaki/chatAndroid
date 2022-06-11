package com.example.chatandroid.api;

import retrofit2.Retrofit;

public class PostAPI {
//    private MutableLiveData<List<Post>> postListData;
//    private PostDao dao;
    Retrofit retrofit;
    WebAPI webServiceAPI;

    public PostAPI(MutableLiveData<List<Post>> postListData, PostDao dao) {
//        this.postListData = postListData;
//        this.dao = dao;

        retrofit = new Retrofit.Builder()
                .baseUrl(chatandroid.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebAPI.class);
    }

    public void get() {
        Call<List<string>> call = webServiceAPI.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    response.body();
//                new Thread(() -> {
//                    dao.clear();
//                    dao.insertList(response.body());
//                    postListData.postValue(dao.get());
//                }).start();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
    }
}