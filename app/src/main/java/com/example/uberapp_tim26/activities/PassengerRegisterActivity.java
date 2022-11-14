package com.example.uberapp_tim26.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uberapp_tim26.R;

public class PassengerRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_register);

        Button button = findViewById(R.id.buttonRegister);
        button.setOnClickListener(new RegisterListener2());
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

    protected class RegisterListener2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(PassengerRegisterActivity.this, PassengerMainActivity.class);
            startActivity(i);
        }
    }
}