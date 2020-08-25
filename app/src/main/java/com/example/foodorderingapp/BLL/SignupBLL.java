package com.example.foodorderingapp.BLL;

import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.ServerResponse.UserResponse;
import com.example.foodorderingapp.URL.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class SignupBLL {
    boolean isSuccess = false;

    public boolean login(String name, String email,String phone, String username,String password,String profileimage) {

        User user = new User(name,email,phone,username,password,profileimage);

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<UserResponse> usersCall = usersAPI.signup(user);

        try {
            Response<UserResponse> signupResponse = usersCall.execute();
            if (signupResponse.isSuccessful() &&
                    signupResponse.body().getStatus().equals("Signup success!")) {

                Url.token += signupResponse.body().getToken();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}

