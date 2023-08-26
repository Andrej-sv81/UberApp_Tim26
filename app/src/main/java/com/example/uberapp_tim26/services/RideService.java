package com.example.uberapp_tim26.services;

import com.example.uberapp_tim26.model.RideDTO;
import com.example.uberapp_tim26.model.RideRequestDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RideService {
    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @POST("ride")
    Call<RideDTO> createRide(@Body RideRequestDTO rideRequestDTO);      // ADD USER PRINCIPAL

    @GET("ride/{id}")
    Call<RideDTO> getRide(@Path("id") String id);

    @GET("ride/driver/{driverId}/acceptedRides")
    Call<List<RideDTO>> getDriverAcceptedRides(@Path("driverId") String driverId);
}
