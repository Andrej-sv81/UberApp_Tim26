package com.example.uberapp_tim26.activities;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.adapters.DrawerListAdapter;
import com.example.uberapp_tim26.fragments.passenger.PassengerInboxFragment;
import com.example.uberapp_tim26.fragments.passenger.PassengerMainFragment;
import com.example.uberapp_tim26.fragments.passenger.PassengerProfileFragment;
import com.example.uberapp_tim26.model.NavItem;
import com.example.uberapp_tim26.model.UserInfoDTO;
import com.example.uberapp_tim26.services.ServiceUtils;
import com.example.uberapp_tim26.tools.FragmentTransition;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Response;
import tech.gusavila92.websocketclient.WebSocketClient;


public class PassengerMainActivity extends AppCompatActivity {

    private WebSocketClient webSocketClient;

    private PassengerMainActivity pvm;
    private CharSequence mTitle;
    private DrawerLayout mDrawerLayout;
    private View mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    private RelativeLayout profileLayout;
    private UserInfoDTO passenger;
    SharedPreferences userPrefs;
    NotificationManager notificationManager;

    private int notificationIdNum = 1;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_main);



        userPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        pvm = this;
        Call<UserInfoDTO> driverInfoDTOCall = ServiceUtils.passengerEndpoints.getPassengerById(String.valueOf(userPrefs.getLong("id", 0L)));
        driverInfoDTOCall.enqueue(new Callback<UserInfoDTO>() {
            @Override
            public void onResponse(Call<UserInfoDTO> call, Response<UserInfoDTO> response) {
                passenger = response.body();
                FragmentTransition.to(PassengerMainFragment.newInstance(passenger), pvm, true,R.id.mainContent);


            }

            @Override
            public void onFailure(Call<UserInfoDTO> call, Throwable t) {

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.garigo);
        setSupportActionBar(toolbar);

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.passengerHome:
                FragmentTransition.to(PassengerMainFragment.newInstance(passenger),pvm,true,R.id.mainContent);
                break;
            case R.id.passengerAccount:
                FragmentTransition.to(PassengerProfileFragment.newInstance(passenger),pvm,true,R.id.mainContent);
                break;
            case R.id.passengerInbox:
                //FragmentTransition.to(PassengerInboxFragment.newInstance(),pvm,true,R.id.mainContent);
                break;
            case R.id.passengerHistory:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}