package com.example.uberapp_tim26.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uberapp_tim26.R;

public class PassengerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_main);

        Button register = findViewById(R.id.buttonAccount);
        register.setOnClickListener(new AccountListener());

        Button signIn = findViewById(R.id.buttonInbox);
        signIn.setOnClickListener(new InboxListener());
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
}