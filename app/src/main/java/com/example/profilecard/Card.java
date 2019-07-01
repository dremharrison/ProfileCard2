package com.example.profilecard;


import android.content.Intent;
import android.net.InetAddresses;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Card extends AppCompatActivity {

    Button btnEdit;
    ImageButton btnDropdown, btnContract, btnFacebook, btnTwitter, btnInstagram, btnGithub;
    TextView fullNameTextView, usernameTextView, phoneTextView, emailTextView, cityStateTextView;
    String firstName, lastName, username, email, phoneNumber, formattedPhoneNumber, city, state, facebook, twitter, instagram, github;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        btnEdit = findViewById(R.id.editButton);
        btnDropdown = findViewById(R.id.expandButton);
        btnContract = findViewById(R.id.contractButton);
        btnFacebook = findViewById(R.id.facebookImageButton);
        btnTwitter = findViewById(R.id.twitterImageButton);
        btnInstagram = findViewById(R.id.instagramImageButton);
        btnGithub = findViewById(R.id.githubImageButton);
        fullNameTextView = findViewById(R.id.fullNameTextView);
        usernameTextView = findViewById(R.id.usernameTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        emailTextView = findViewById(R.id.emailTextView);
        cityStateTextView = findViewById(R.id.cityStateTextView);

        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        formattedPhoneNumber = PhoneNumberUtils.formatNumber(phoneNumber);
        city = getIntent().getStringExtra("city").toUpperCase();
        state = getIntent().getStringExtra("state").toUpperCase();
        facebook = getIntent().getStringExtra("facebook");
        twitter = getIntent().getStringExtra("twitter");
        instagram = getIntent().getStringExtra("instagram");
        github = getIntent().getStringExtra("github");

        Log.d("facebook", facebook);

        if (firstName.length() > 0 && lastName.length() > 0) {
            fullNameTextView.setText(firstName + " " + lastName);
        }

        if (username.length() > 0) {
            usernameTextView.setText("@" + username);
        }

        btnDropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDropdown.setVisibility(View.GONE);
                btnContract.setVisibility(View.VISIBLE);

                if (facebook.length() > 0) {
                    btnFacebook.setVisibility(View.VISIBLE);
                }

                if (twitter.length() > 0) {
                    btnTwitter.setVisibility(View.VISIBLE);
                }

                if (instagram.length() > 0) {
                    btnInstagram.setVisibility(View.VISIBLE);
                }

                if (github.length() > 0) {
                    btnGithub.setVisibility(View.VISIBLE);
                }

                if (phoneNumber.length() > 0) {
                    phoneTextView.setVisibility(View.VISIBLE);
                    phoneTextView.setText(phoneNumber);
                }

                if (email.length() > 0) {
                    emailTextView.setVisibility(View.VISIBLE);
                    emailTextView.setText(email);
                }

                if (city.length() > 0 && state.length() > 0) {
                    cityStateTextView.setVisibility(View.VISIBLE);
                    cityStateTextView.setText(city + ", " + state);
                }

            }
        });

        btnContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnContract.setVisibility(View.GONE);
                btnFacebook.setVisibility(View.GONE);
                btnTwitter.setVisibility(View.GONE);
                btnInstagram.setVisibility(View.GONE);
                btnGithub.setVisibility(View.GONE);
                phoneTextView.setVisibility(View.GONE);
                emailTextView.setVisibility(View.GONE);
                cityStateTextView.setVisibility(View.GONE);
                btnDropdown.setVisibility(View.VISIBLE);
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + facebook));
                startActivity(intent);
            }
        });

        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/" + twitter));
                startActivity(intent);
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/" + instagram));
                startActivity(intent);
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/" + github));
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Card.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
