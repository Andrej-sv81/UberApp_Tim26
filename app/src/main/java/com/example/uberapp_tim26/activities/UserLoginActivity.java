package com.example.uberapp_tim26.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.CredentialsDTO;
import com.example.uberapp_tim26.model.LoginDTO;
import com.example.uberapp_tim26.services.ServiceUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Base64;

public class UserLoginActivity extends AppCompatActivity {
    public static String jwtToken;
    private CredentialsDTO credentialsDTO;
    private SharedPreferences sharedPreferences;
    EditText tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Button register = findViewById(R.id.registerbtn);
        register.setOnClickListener(new RegisterListener());

        Button signIn = findViewById(R.id.loginbtn);
        signIn.setOnClickListener(new SignInListener());

        tw = findViewById(R.id.email);

        TextView password = findViewById(R.id.forgotenpassword);
        password.setOnClickListener(new ForgotPasswordListener());

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
            logInUser();
        }
    }


    private void logInUser() {
        String emailInput = ((EditText) findViewById(R.id.email)).getText().toString();
        if (emailInput.equals("")) {
            return;
        }
        credentialsDTO.setEmail(emailInput);

        String passwordInput = ((EditText) findViewById(R.id.password)).getText().toString();
        if (passwordInput.equals("")) {
            return;
        }
        credentialsDTO.setPassword(passwordInput);

        Call<LoginDTO> call = ServiceUtils.userEndpoints.login(credentialsDTO);
        call.enqueue(new Callback<LoginDTO>() {
            @Override
            public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {
                if (response.code() == 200) {
                    Log.d("PASSED", "radi");
                    redirect(response.body().getAccessToken());
                } else {
                    Log.d("NOT 200", "Meesage recieved: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<LoginDTO> call, Throwable t) {
                Log.d("FAILED", t.getMessage() != null ? t.getMessage() : "error");
            }
        });
    }

    protected  class ForgotPasswordListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent i = new Intent(UserLoginActivity.this, ChangePasswordActivity.class);
            startActivity(i);
        }
    }



    private void redirect(String jwt) {
        String[] chunks = jwt.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        Log.e("jwt", payload);
        String email = payload.split(",")[0].split(":")[1].replace("\"", "");
        String role = payload.split(",")[1].split(":")[1].replace("\"", "");
        String id = payload.split(",")[2].split(":")[1].replace("\"", "");
        Log.e("email", email);
        Log.e("role", role);
        Log.e("id", id);
        setPreferences(jwt, email, role, Long.parseLong(id));
        if (role.equals("ROLE_DRIVER")) {
            startActivity(new Intent(UserLoginActivity.this, DriverMainActivity.class));
        } else if (role.equals("ROLE_PASSENGER")) {
            startActivity(new Intent(UserLoginActivity.this, PassengerMainActivity.class));
        }
        finish();
    }

    private void setPreferences(String jwt, String email, String role, Long id) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor sp_editor = sharedPreferences.edit();
        sp_editor.putString("jwt", jwt);
        jwtToken = jwt;
        sp_editor.putString("email", email);
        sp_editor.putString("role", role);
        sp_editor.putLong("id", id);
        sp_editor.apply();
    }
}