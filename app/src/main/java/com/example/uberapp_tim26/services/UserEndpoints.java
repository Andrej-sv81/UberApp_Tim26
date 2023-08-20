package com.example.uberapp_tim26.services;

import com.example.uberapp_tim26.model.CredentialsDTO;
import com.example.uberapp_tim26.model.LoginDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserEndpoints {
    String urlExtension = "user";
    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json",
            "Skip: true"
    })
    @POST(urlExtension + "/login")
    Call<LoginDTO> login(@Body CredentialsDTO credentialsDTO);
}
