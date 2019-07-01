package com.example.profilecard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    MaterialButton btnEnter;
    TextInputEditText firstName, lastName, username;
    SharedPreferences sharedPreferences;
    String firstNameSP, lastNameSP, usernameSP;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstNameInput);
        lastName = findViewById(R.id.lastNameInput);
        username = findViewById(R.id.usernameInput);
        btnEnter = findViewById(R.id.enterButton);
        sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                intent.putExtra("firstName", firstName.getText().toString());
                intent.putExtra("lastName", lastName.getText().toString());
                intent.putExtra("username",username.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstName", firstName.getText().toString());
        editor.putString("lastName", lastName.getText().toString());
        editor.putString("username",username.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        firstNameSP = sharedPreferences.getString("firstName", "");
        lastNameSP = sharedPreferences.getString("lastName", "");
        usernameSP = sharedPreferences.getString("username", "");

        firstName.setText(firstNameSP);
        lastName.setText(lastNameSP);
        username.setText(usernameSP);
    }
}
