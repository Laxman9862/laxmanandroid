package com.example.foodorderingapp.BLL;

import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.ServerResponse.UserResponse;
import com.example.foodorderingapp.URL.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UPdateBLL {
    boolean isSuccess = false;

    public boolean update(String name, String email, String phone) {
        User user = new User(name, email, phone);

        UserApi usersAPI = Url.getInstance().create(UserApi.class);
        Call<User> usersCall = usersAPI.updateuser("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZTM2ZGY1NmEyOGFiNTE2NGE1MzMxZGUiLCJhZG1pbiI6ZmFsc2UsImlhdCI6MTU4MTc3NjQzMH0.ReAET7Z_XZI0wFNi325KFWkVwOKcjrUbmApUJu51vI4", user);


        try {
            Response<User> signupResponse = usersCall.execute();
            if (signupResponse.isSuccessful() &&
                    signupResponse.body().equals("Profile updated Succesfully")) {

                isSuccess = true;
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
