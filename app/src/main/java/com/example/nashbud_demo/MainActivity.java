package com.example.nashbud_demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    CardView profilePicCard,nextButton,addButton;
    EditText username,password;
    ImageView profilePic;
    public static final int GET_FROM_GALLERY1 = 3,GET_FROM_GALLERY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profilePicCard=findViewById(R.id.profile_pic_card);
        profilePic=findViewById(R.id.profile_pic);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        nextButton=findViewById(R.id.next_button);
        addButton=findViewById(R.id.add_image);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_PICK);
                    intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, GET_FROM_GALLERY);
            }
        });
        profilePicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GET_FROM_GALLERY1);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 =username.getText().toString().trim();
                String text2=password.getText().toString().trim();
                if(text1.length()!=0 && text2.length()!=0){
                    Intent myIntent = new Intent(MainActivity.this, ApiActivity.class);
                    MainActivity.this.startActivity(myIntent);
                }else {
                    Toast.makeText(getApplicationContext(),"Enter USERNAME AND PASSWORD",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==GET_FROM_GALLERY1 || requestCode==GET_FROM_GALLERY){
                profilePic.setImageURI(data.getData());
            }
        }
    }
}