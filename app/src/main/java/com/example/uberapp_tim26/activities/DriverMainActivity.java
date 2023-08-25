package com.example.uberapp_tim26.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.uberapp_tim26.R;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.URISyntaxException;

import tech.gusavila92.websocketclient.WebSocketClient;

public class DriverMainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button toggleButton;
    private WebSocketClient webSocketClient;
    private SharedPreferences driverSharedPreferences;

    private void createDriverWebSocketSession(){
        URI uri;
        try {
            // Connect to local host


            uri = new URI("ws://" + "192.168.1.8:8080" + "/socket");
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                Log.d("WebSocket", "Session is starting on websocket");
                webSocketClient.send("Hello World!");
            }

            @Override
            public void onTextReceived(String s) {
                Log.d("poruka",s);
                final String message = s;
                // kroz intent se salje string
                // TODO intent za prebacivanje na novi acceptance i da se doda string S u intent , u aktivitiju se kestuje u objekat
            }

            @Override
            public void onBinaryReceived(byte[] data) {
            }

            @Override
            public void onPingReceived(byte[] data) {
            }

            @Override
            public void onPongReceived(byte[] data) {
            }

            @Override
            public void onException(Exception e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onCloseReceived() {
                Log.i("WebSocket", "Closed ");
                System.out.println("onCloseReceived");
            }
        };

        webSocketClient.enableAutomaticReconnection(1000);
        webSocketClient.addHeader("id", String.valueOf(driverSharedPreferences.getLong("id",0)));
        webSocketClient.addHeader("role","ROLE_DRIVER");
        webSocketClient.connect();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        driverSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(R.layout.activity_driver_main);

        Toolbar toolbar = findViewById(R.id.toolbarDriverMain);
        setSupportActionBar(toolbar);

        toggleButton = (Button) findViewById(R.id.toggleBtn);
        toggleButton.setOnClickListener((View.OnClickListener) this);

        createDriverWebSocketSession();
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