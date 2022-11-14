package com.example.uberapp_tim26.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.uberapp_tim26.R;

public class DriverMainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);

        Toolbar toolbar = findViewById(R.id.toolbarDriverMain);
        setSupportActionBar(toolbar);

        toggleButton = (Button) findViewById(R.id.toggleBtn);
        toggleButton.setOnClickListener((View.OnClickListener) this);
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
                Intent i = new Intent(DriverMainActivity.this, DriverMainActivity.class);
                startActivity(i);
                break;
            case R.id.passengerAccount:
                Intent i2 = new Intent(DriverMainActivity.this, DriverAccountActivity.class);
                startActivity(i2);
                break;
            case R.id.passengerInbox:
                Intent i3 = new Intent(DriverMainActivity.this, DriverInboxActivity.class);
                startActivity(i3);
                break;
            case R.id.passengerHistory:
                Intent i4 = new Intent(DriverMainActivity.this, DriverRideHistoryActivity.class);
                startActivity(i4);
                break;
        }
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(toggleButton.getText().equals("Online")){
            toggleButton.setText("Offline");
        } else {
            toggleButton.setText("Online");
        }
    }

}