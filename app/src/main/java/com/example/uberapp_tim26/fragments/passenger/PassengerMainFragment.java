package com.example.uberapp_tim26.fragments.passenger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.LocationDTO;
import com.example.uberapp_tim26.model.PassengerCredentialsDTO;
import com.example.uberapp_tim26.model.RideDTO;
import com.example.uberapp_tim26.model.RideRequestDTO;
import com.example.uberapp_tim26.model.RouteDTO;
import com.example.uberapp_tim26.model.UserInfoDTO;
import com.example.uberapp_tim26.services.MapService;
import com.example.uberapp_tim26.services.ServiceUtils;

import java.io.Serializable;
import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.gusavila92.websocketclient.WebSocketClient;


public class PassengerMainFragment extends Fragment {


    private WebSocketClient webSocketClient;
    private static final String ARG_PASSENGER = "arg_PASSENGER";
    private UserInfoDTO passenger;
    private Context context;
    private PassengerMainFragment fragment;
    private SharedPreferences userPrefs;

    public PassengerMainFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static PassengerMainFragment newInstance(UserInfoDTO passenger) {
        PassengerMainFragment fragment = new PassengerMainFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_PASSENGER, passenger);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        passenger = (UserInfoDTO) getArguments().getSerializable(ARG_PASSENGER);
        fragment = this;
        userPrefs = getContext().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //Context ctx = this.getContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_passenger_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button findRide = view.findViewById(R.id.findride);
        CheckBox babyCheckbox = view.findViewById(R.id.babyCheckbox);
        CheckBox petCheckbox  = view.findViewById(R.id.petCheckbox);
        EditText departure = view.findViewById(R.id.fromEditText);
        EditText destination = view.findViewById(R.id.toEditText);
        findRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RideRequestDTO request = new RideRequestDTO();
                request.setVehicleType("STANDARD");     // TODO DODAJ BIRANJE TIPA VOZILA
                request.setScheduledTime("");
                List<RouteDTO> routes = new ArrayList<>();
                RouteDTO route = new RouteDTO();
                List<PassengerCredentialsDTO> passengers = new ArrayList<>();
                PassengerCredentialsDTO requestSender = new PassengerCredentialsDTO(passenger.getId(),passenger.getEmail());
                passengers.add(requestSender);
                request.setPassengers(passengers);
                request.setBabyTransport(babyCheckbox.isChecked());
                request.setPetTransport(petCheckbox.isChecked());
                MapService.getLocation(String.valueOf(departure.getText()), locationDTO ->{
                    route.setDeparture(locationDTO);
                    MapService.getLocation(String.valueOf(destination.getText()), locationDTO2 ->{
                        route.setDestination(locationDTO2);
                        routes.add(route);
                        request.setLocations(routes);
                        Call<RideDTO> call = ServiceUtils.rideEndpoints.createRide(request);
                        call.enqueue(new Callback<RideDTO>() {
                            @Override
                            public void onResponse(Call<RideDTO> call, Response<RideDTO> response) {
                                if (response.isSuccessful()) {
                                    Log.d("NetworkCall", "Success! Ride created");
                                } else {
                                    Log.e("NetworkCall", "Unsuccessful response: " + response.code());
                                }
                            }

                            @Override
                            public void onFailure(Call<RideDTO> call, Throwable t) {
                                Log.e("NetworkCall", "Network call failed: " + t.getMessage(), t);
                            }
                        });});

                    ;});



                //ADD FIELDS TO REQUEST

            }
        });
    }
}