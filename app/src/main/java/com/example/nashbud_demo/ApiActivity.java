package com.example.nashbud_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiActivity extends AppCompatActivity {

    ImageView image;
    String api="https://dog.ceo";
    model allList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        image=findViewById(R.id.disp_image);
        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                allList=response.body();
                Log.e("api","onResponse:"+allList.getMessage() );
                Glide.with(getBaseContext()).load(allList.getMessage()).into(image);
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {

                Log.e("api","onFailure:"+t.getLocalizedMessage());
            }
        });

    }
}