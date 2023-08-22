package com.example.uberapp_tim26.services;

import com.example.uberapp_tim26.model.FavouriteRideInfoDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RideEndpoints {
    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("ride/favorites")
    Call<List<FavouriteRideInfoDTO>> getFavouriteRides();
}
