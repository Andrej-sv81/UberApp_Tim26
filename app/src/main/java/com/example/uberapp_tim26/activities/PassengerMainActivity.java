package com.example.uberapp_tim26.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
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
        String channelId = "scheduled_ride_channel";
        String channelName = "Scheduled Ride";

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("This channel is for scheduled ride notifications");
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
        }

        userPrefs = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        pvm = this;
        Call<UserInfoDTO> driverInfoDTOCall = ServiceUtils.passengerEndpoints.getPassengerById(userPrefs.getString("id","nema id"));
        driverInfoDTOCall.enqueue(new Callback<UserInfoDTO>() {
            @Override
            public void onResponse(Call<UserInfoDTO> call, Response<UserInfoDTO> response) {
                passenger = response.body();
                setPassengerInfo(passenger);

                FragmentTransition.to(PassengerMainFragment.newInstance(passenger), pvm, true,R.id.mainContent);


            }

            @Override
            public void onFailure(Call<UserInfoDTO> call, Throwable t) {

            }
        });


        //createPassengerNotifSession();    TODO CREATE NOTIFY SESSION

        Toolbar toolbar = findViewById(R.id.toolbar);
        //toolbar.setLogo(R.drawable.ic_topgo_logo);
        toolbar.setTitle(R.string.garigo);

        View logoView = toolbar.getChildAt(0);


        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragManager = pvm.getSupportFragmentManager();
                int count = pvm.getSupportFragmentManager().getBackStackEntryCount();
                Fragment frag = fragManager.getFragments().get(count > 0 ? count - 1 : count);
                if (frag.getClass().equals(PassengerMainFragment.class)) {

                } else {
                    FragmentTransition.to(PassengerMainFragment.newInstance(passenger), pvm, false, R.id.mainContent);
                }
            }
        });
        setSupportActionBar(toolbar);


        profileLayout = findViewById(R.id.profileBox);
        mTitle = getTitle();
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerList = findViewById(R.id.navList);

        mDrawerPane = findViewById(R.id.drawerPane);

        mNavItems.add(new NavItem("Inbox", "This is your inbox", R.drawable.ic_inbox));
        mNavItems.add(new NavItem("History", "Ride history", R.drawable.ic_history));
        DrawerListAdapter DLA = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerList.setAdapter(DLA);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("iReviewer");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

    }

    private void setPassengerInfo(UserInfoDTO passenger) {

        TextView passengerInfo = findViewById(R.id.passengerInfoTextView);
        passengerInfo.setText(passenger.getName() + " " + passenger.getSurname());

        int index = passenger.getProfilePicture().indexOf(",") + 1;
        String base64 = passenger.getProfilePicture().substring(index);
        byte[] imageBytes = Base64.decode(base64, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        ImageView image = findViewById(R.id.profileIcon);
        image.setImageBitmap(bitmap);

        profileLayout = findViewById(R.id.profileBox);

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransition.to(PassengerProfileFragment.newInstance(passenger), pvm, false,R.id.mainContent);
                mDrawerLayout.closeDrawers();
            }
        });
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

    protected class AccountListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(PassengerMainActivity.this, PassengerAccountActivity.class);
            startActivity(i);
        }
    }

    protected class InboxListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(PassengerMainActivity.this, PassengerInboxActivity.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_logout:
//                SharedPreferences userPrefs = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = userPrefs.edit();
//                editor.clear();
//                editor.apply();
//                startActivity(new Intent(PassengerMainActivity.this, UserLoginActivity.class));
//                finish();
//                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItemFromDrawer(position);
            Log.i("ITEM CLICK:", String.valueOf(position));

        }
    }

    private void selectItemFromDrawer(int position) {
        if (position == 0) {
            //FragmentTransition.to(PassengerInboxFragment.newInstance(passenger), this, false, R.id.mainContent);
        } else if (position == 1) {
            //FragmentTransition.to(PassengerDriveHistoryFragment.newInstance(passenger), this, false, R.id.mainContent);
        } else if (position == 2) {
            //..
        } else if (position == 3) {
            //..
        } else if (position == 4) {
            //..
        } else if (position == 5) {
            //...
        } else {
            Log.e("DRAWER", "Nesto van opsega!");
        }

        mDrawerList.setItemChecked(position, true);
        if (position != 5) // za sve osim za sync
        {
            setTitle(mNavItems.get(position).getmTitle());
        }
        mDrawerLayout.closeDrawer(mDrawerPane);
    }


//    @SuppressLint("NonConstantResourceId")        TODO PRVI TOOLBAR KOJI SMO NAPISALI
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.passengerHome:
//                Intent i = new Intent(PassengerMainActivity.this, PassengerMainActivity.class);
//                startActivity(i);
//                break;
//            case R.id.passengerAccount:
//                Intent i2 = new Intent(PassengerMainActivity.this, PassengerAccountActivity.class);
//                startActivity(i2);
//                break;
//            case R.id.passengerInbox:
//                Intent i3 = new Intent(PassengerMainActivity.this, PassengerInboxActivity.class);
//                startActivity(i3);
//                break;
//            case R.id.passengerHistory:
//                Intent i4 = new Intent(PassengerMainActivity.this, PassengerHistoryActivity.class);
//                startActivity(i4);
//                break;
//        }
//        finish();
//        return super.onOptionsItemSelected(item);
//    }
}