package com.example.profilecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ContactActivity extends AppCompatActivity {


    TextInputEditText email, phoneNumber, city, state;
    MaterialButton btnEnter;
    String firstName, lastName, username, emailSP, phoneNumberSP, citySP, stateSP;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        email = findViewById(R.id.emailInput);
        phoneNumber = findViewById(R.id.phoneInput);
        city = findViewById(R.id.cityInput);
        state = findViewById(R.id.stateInput);
        btnEnter = findViewById(R.id.enterButton);
        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        username = getIntent().getStringExtra("username");
        sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactActivity.this, SocialMediaActivity.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("username",username);
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("phoneNumber", phoneNumber.getText().toString());
                intent.putExtra("city", city.getText().toString());
                intent.putExtra("state", state.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email.getText().toString());
        editor.putString("phoneNumber", phoneNumber.getText().toString());
        editor.putString("city", city.getText().toString());
        editor.putString("state", state.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        emailSP = sharedPreferences.getString("email", "");
        phoneNumberSP = sharedPreferences.getString("phoneNumber", "");
        citySP = sharedPreferences.getString("city", "");
        stateSP = sharedPreferences.getString("state", "");

        email.setText(emailSP);
        phoneNumber.setText(phoneNumberSP);
        city.setText(citySP);
        state.setText(stateSP);
    }
}
