package com.example.uberapp_tim26.services;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceUtils {

    private static final String BASE_URL = "http://192.168.1.8:8080/api/";


    static TokenInterceptor interceptor = new TokenInterceptor();

    static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor).build();

    public static Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // SERVICES ON SPRINGBOOT SERVER
    public static UserEndpoints userEndpoints = retrofit.create(UserEndpoints.class);
    public static PassengerEndpoints passengerEndpoints = retrofit.create(PassengerEndpoints.class);
    public static RideEndpoints rideEndpoints = retrofit.create(RideEndpoints.class);


    static OkHttpClient clientReports = new OkHttpClient.Builder()
            .addInterceptor(interceptor).readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS).build();

}
