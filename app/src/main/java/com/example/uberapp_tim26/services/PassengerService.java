package com.example.uberapp_tim26.services;

import com.example.uberapp_tim26.model.UpdatePassengerDTO;
import com.example.uberapp_tim26.model.UserInfoDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PassengerService {
    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("passenger/{id}")
    Call<UserInfoDTO> getPassengerById(@Path("id") String id);


    @PUT("passenger/{id}")
    Call<UserInfoDTO> changePassengerInfo(@Path("id") String id,@Body UpdatePassengerDTO passenger);

}
