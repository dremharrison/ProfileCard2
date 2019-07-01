package com.example.profilecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SocialMediaActivity extends AppCompatActivity {

    TextInputEditText facebook, twitter, instagram, github;
    MaterialButton btnEnter;
    String firstName, lastName, username, phoneNumber, email, city, state, facebookSP, twitterSP, instagramSP, githubSP;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        facebook = findViewById(R.id.facebookInput);
        twitter = findViewById(R.id.twitterInput);
        instagram = findViewById(R.id.instagramInput);
        github = findViewById(R.id.githubInput);
        btnEnter = findViewById(R.id.enterButton);
        sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);

        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        city = getIntent().getStringExtra("city");
        state = getIntent().getStringExtra("state");

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SocialMediaActivity.this, Card.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("username",username);
                intent.putExtra("email", email);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("city", city);
                intent.putExtra("state", state);
                intent.putExtra("facebook", facebook.getText().toString());
                intent.putExtra("twitter", twitter.getText().toString());
                intent.putExtra("instagram", instagram.getText().toString());
                intent.putExtra("github", github.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("facebook", facebook.getText().toString());
        editor.putString("twitter", twitter.getText().toString());
        editor.putString("instagram", instagram.getText().toString());
        editor.putString("github", github.getText().toString());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        facebookSP = sharedPreferences.getString("facebook", "");
        twitterSP = sharedPreferences.getString("twitter", "");
        instagramSP = sharedPreferences.getString("instagram", "");
        githubSP = sharedPreferences.getString("github", "");

        facebook.setText(facebookSP);
        twitter.setText(twitterSP);
        instagram.setText(instagramSP);
        github.setText(githubSP);
    }
}
