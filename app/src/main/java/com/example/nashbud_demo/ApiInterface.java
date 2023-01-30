package com.example.nashbud_demo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET ("/api/breeds/image/random")
    Call<model> getUsers();

}
