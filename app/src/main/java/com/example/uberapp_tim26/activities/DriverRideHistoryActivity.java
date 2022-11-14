package com.example.uberapp_tim26.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.adapters.RideHistoryAdapter;

public class DriverRideHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_ride_history);
        RideHistoryAdapter adapter = new RideHistoryAdapter(this);
        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(adapter);
        //lista.setOnItemSelectedListener(new getDetails());
    }

    protected class getDetails implements View.OnClickListener {
        @Override
        //TODO: IZMENI KLASU ZA REGISTER
        public void onClick(View v) {
            Intent i = new Intent(DriverRideHistoryActivity.this,RideHistoryDetailsActivity.class);
            startActivity(i);
        }
    }
}