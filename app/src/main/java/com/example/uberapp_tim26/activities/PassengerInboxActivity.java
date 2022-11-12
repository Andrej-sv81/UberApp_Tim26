package com.example.uberapp_tim26.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.uberapp_tim26.R;

public class PassengerInboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_inbox);

        Toolbar toolbar = findViewById(R.id.toolbarPassengerMain);
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
        getMenuInflater().inflate(R.menu.menu_passenger_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.passengerHome:
                Intent i = new Intent(PassengerInboxActivity.this, PassengerMainActivity.class);
                startActivity(i);
                break;
            case R.id.passengerAccount:
                Intent i2 = new Intent(PassengerInboxActivity.this, PassengerAccountActivity.class);
                startActivity(i2);
                break;
            case R.id.passengerInbox:
                Intent i3 = new Intent(PassengerInboxActivity.this, PassengerInboxActivity.class);
                startActivity(i3);
                break;
            case R.id.passengerHistory:
                Intent i4 = new Intent(PassengerInboxActivity.this, PassengerHistoryActivity.class);
                startActivity(i4);
                break;
        }
        finish();
        return super.onOptionsItemSelected(item);
    }
}