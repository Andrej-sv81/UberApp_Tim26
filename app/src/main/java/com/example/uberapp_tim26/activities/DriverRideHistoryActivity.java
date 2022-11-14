package com.example.uberapp_tim26.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.adapters.RideHistoryAdapter;

public class DriverRideHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_ride_history);

        Toolbar toolbar = findViewById(R.id.toolbarDriverHistory);
        setSupportActionBar(toolbar);

        RideHistoryAdapter adapter = new RideHistoryAdapter(this);
        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(adapter);
        //TODO: Ovo ne radi. Ne otvara details
        lista.setOnItemSelectedListener(new getDetails());
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
                Intent i = new Intent(DriverRideHistoryActivity.this, DriverMainActivity.class);
                startActivity(i);
                break;
            case R.id.passengerAccount:
                Intent i2 = new Intent(DriverRideHistoryActivity.this, DriverAccountActivity.class);
                startActivity(i2);
                break;
            case R.id.passengerInbox:
                Intent i3 = new Intent(DriverRideHistoryActivity.this, DriverInboxActivity.class);
                startActivity(i3);
                break;
            case R.id.passengerHistory:
                Intent i4 = new Intent(DriverRideHistoryActivity.this, DriverRideHistoryActivity.class);
                startActivity(i4);
                break;
        }
        finish();
        return super.onOptionsItemSelected(item);

    }

    protected class getDetails implements AdapterView.OnItemSelectedListener {


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Intent i = new Intent(DriverRideHistoryActivity.this,RideHistoryDetailsActivity.class);
            startActivity(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    }
}