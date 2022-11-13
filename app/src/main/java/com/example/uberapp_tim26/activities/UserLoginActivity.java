package com.example.uberapp_tim26.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uberapp_tim26.R;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Button register = findViewById(R.id.buttonRegister);
        register.setOnClickListener(new RegisterListener());

        Button signIn = findViewById(R.id.buttonSignIn);
        signIn.setOnClickListener(new SignInListener());

        //TODO: izbrisati dugme kada se doda ispravan prelazak na Driver Account
        Button account = findViewById(R.id.driverAccountButton);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserLoginActivity.this, DriverAccountActivity.class);
                startActivity(i);
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

    protected class RegisterListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(UserLoginActivity.this, PassengerRegisterActivity.class);
            startActivity(i);
        }
    }

    protected class SignInListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(UserLoginActivity.this, PassengerMainActivity.class);
            startActivity(i);
        }
    }
}