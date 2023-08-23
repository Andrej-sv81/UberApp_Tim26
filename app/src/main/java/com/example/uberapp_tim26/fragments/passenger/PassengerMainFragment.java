package com.example.uberapp_tim26.fragments.passenger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.UserInfoDTO;

import java.io.Serializable;

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
        Context ctx = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_passenger_main, container, false);
    }
}