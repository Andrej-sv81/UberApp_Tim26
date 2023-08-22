package com.example.uberapp_tim26.services;

import com.example.uberapp_tim26.model.ChangePasswordDTO;
import com.example.uberapp_tim26.model.CredentialsDTO;
import com.example.uberapp_tim26.model.LoginDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserEndpoints {
    String urlExtension = "user";
    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json",
            "Skip: true"
    })

    @POST(urlExtension + "/login")
    Call<LoginDTO> login(@Body CredentialsDTO credentialsDTO);

    @PUT(urlExtension + "/{id}/changePassword")
    Call<ResponseBody> changeUserPassword(@Path("id") String id, @Body ChangePasswordDTO changePasswordDTO);
}
