package com.example.profilecard;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Card extends AppCompatActivity {

ImageButton btnDropdown, btnContract;
TextView moreInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        btnDropdown = findViewById(R.id.expand_button);
        btnContract = findViewById(R.id.contract_button);
        moreInfo = findViewById(R.id.supporting_text);

        btnDropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDropdown.setVisibility(View.GONE);
                btnContract.setVisibility(View.VISIBLE);
                moreInfo.setVisibility(View.VISIBLE);
            }
        });

        btnContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnContract.setVisibility(View.GONE);
                moreInfo.setVisibility(View.GONE);
                btnDropdown.setVisibility(View.VISIBLE);
            }
        });
    }
}
