package com.example.nashbud_demo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance instance;
    ApiInterface apiInterface;

    RetrofitInstance(){

        String api="https://dog.ceo";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface=retrofit.create(ApiInterface.class);
    }

    public static RetrofitInstance getInstance(){
        if(instance==null){
            instance=new RetrofitInstance();
        }
        return instance;
    }
}
