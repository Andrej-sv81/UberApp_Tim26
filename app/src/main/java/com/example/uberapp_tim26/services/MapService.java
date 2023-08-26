package com.example.uberapp_tim26.services;

import android.util.Log;

import com.example.uberapp_tim26.model.LocationDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MapService {

    public interface LocationCallback {
        void onResponse(LocationDTO geoLocationDTO);
    }

    public static LocationDTO getLocation(String locationName,LocationCallback callback) {
        String apiKey = "5b3ce3597851110001cf6248acf7e99f6e904b6bb968826264133fe3"; //proveri ovo
        String baseUrl = "https://openrouteservice.org/geocode/autocomplete";

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setAddress(locationName);
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.openrouteservice.org")
                .addPathSegment("geocode")
                .addPathSegment("search")
                .addQueryParameter("api_key", apiKey)
                .addQueryParameter("text", locationName)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseString = response.body().string();
                    Log.d("ok","VRACEN STRING JE:" + responseString);
                    try {
                        JSONObject json = new JSONObject(responseString);
                        JSONArray features = json.getJSONArray("features");
                        JSONObject firstFeature = features.getJSONObject(0);
                        JSONObject geometry = firstFeature.getJSONObject("geometry");
                        JSONArray coordinates = geometry.getJSONArray("coordinates");
                        //List<GeoPoint> routePoints = new ArrayList<>();
                        locationDTO.setLongitude(Double.parseDouble(coordinates.get(0).toString()));
                        locationDTO.setLatitude(Double.parseDouble(coordinates.get(0).toString()));
                        callback.onResponse(locationDTO);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.d("error", "Failed with code:" + response.code());
                }
            }
        });
        return locationDTO;
    }
}
