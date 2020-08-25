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

import static com.example.foodorderingapp.Activity.DashboardActivity.globaluser;
import static com.example.foodorderingapp.URL.Url.token;

public class EditProfile extends AppCompatActivity {

    CircleImageView userprofile;
    EditText upname, upemail, upphone, upusername, uppassword;
    private Button btnupdate;
    String imagepath;
    private String imageName = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        //getSupportActionBar().hide();
        getSupportActionBar().setTitle("update profile");


        upname = findViewById(R.id.upd_name);
        upemail = findViewById(R.id.upd_email);
        upphone = findViewById(R.id.upd_phone);
        upusername = findViewById(R.id.upd_username);
        uppassword = findViewById(R.id.password);
        userprofile = findViewById(R.id.upd_userprofile);
        btnupdate = findViewById(R.id.updateuser);


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                updateuser();
            }
        });

        upname.setText(globaluser.getName());
        upemail.setText(globaluser.getEmail());
        upphone.setText(globaluser.getPhone());
        upusername.setText(globaluser.getUsername());

        //uppassword.setText(globaluser.getPassword());


    }


    private void updateuser() {


        String fname = upname.getText().toString();
        String email = upemail.getText().toString();
        String phone = upphone.getText().toString();


        User users = new User(fname, email, phone);

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<User> updateuser = usersAPI.updateuser(token, users);

        updateuser.enqueue(new Callback<User>() {
                               @Override
                               public void onResponse(Call<User> call, Response<User> response) {

                                   if (!response.isSuccessful()) {
                                       Toast.makeText(EditProfile.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                                       return;

                                   }
                                   Toast.makeText(EditProfile.this, "Profile updated Succesfully", Toast.LENGTH_SHORT).show();


                               }

                               @Override
                               public void onFailure(Call<User> call, Throwable t) {

                               }
                           }
        );
    }
}



