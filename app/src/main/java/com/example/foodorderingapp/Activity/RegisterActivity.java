package com.example.foodorderingapp.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.ServerResponse.ImageResponse;
import com.example.foodorderingapp.ServerResponse.UserResponse;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private CircleImageView imgProfile;
    protected EditText etname, etemail, etphone, etusername, etpassword;
    protected Button btnsignup;
    String imagepath;
    private String imageName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SignUp");

        etname = findViewById(R.id.name);
        etemail = findViewById(R.id.email);
        etphone = findViewById(R.id.phone);
        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        btnsignup = findViewById(R.id.signup);




        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                signup();
            }
        });


    }

    private void signup() {


        String fname = etname.getText().toString();
        String phone = etphone.getText().toString();
        String email = etemail.getText().toString();
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();

        User users = new User(fname,email,phone, username, password);

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<UserResponse> signUpCall = usersAPI.signup(users);

        signUpCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this, "Signup success!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}














