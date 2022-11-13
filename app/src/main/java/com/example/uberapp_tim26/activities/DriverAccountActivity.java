package com.example.uberapp_tim26.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.DriverPlaceholder;
import com.example.uberapp_tim26.tools.Mokap;

public class DriverAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_account);

        Toolbar toolbar = findViewById(R.id.toolbarDriverAccount);
        setSupportActionBar(toolbar);

        TextView name = findViewById(R.id.driverName);
        TextView surname = findViewById(R.id.driverSurname);
        TextView id = findViewById(R.id.driverID);
        TextView phone = findViewById(R.id.driverPhone);
        TextView email = findViewById(R.id.driverEmail);
        ImageView img = findViewById(R.id.imageView2);

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
}