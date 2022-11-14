package com.example.uberapp_tim26.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.DriverPlaceholder;
import com.example.uberapp_tim26.tools.Mokap;

public class PassengerAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_account);

        Toolbar toolbar = findViewById(R.id.toolbarPassengerMain);
        setSupportActionBar(toolbar);

        TextView name = findViewById(R.id.passengerName);
        TextView surname = findViewById(R.id.passengerSurname);
        TextView id = findViewById(R.id.passengerID);
        TextView phone = findViewById(R.id.driverPhone);
        TextView email = findViewById(R.id.passengerEmail);
        ImageView img = findViewById(R.id.imageView2);
        //TODO: PASSSENGER PLACEHOLDER I MOCKUP
        DriverPlaceholder marko = Mokap.getDriver();

        name.setText(marko.getName());
        surname.setText(marko.getSurname());
        id.setText(marko.getId());
        phone.setText(marko.getPhone());
        email.setText(marko.getEmail());
        img.setImageResource(marko.getImg());
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
                Intent i = new Intent(PassengerAccountActivity.this, PassengerMainActivity.class);
                startActivity(i);
                break;
            case R.id.passengerAccount:
                Intent i2 = new Intent(PassengerAccountActivity.this, PassengerAccountActivity.class);
                startActivity(i2);
                break;
            case R.id.passengerInbox:
                Intent i3 = new Intent(PassengerAccountActivity.this, PassengerInboxActivity.class);
                startActivity(i3);
                break;
            case R.id.passengerHistory:
                Intent i4 = new Intent(PassengerAccountActivity.this, PassengerHistoryActivity.class);
                startActivity(i4);
                break;
        }
        finish();
        return super.onOptionsItemSelected(item);
    }
}
