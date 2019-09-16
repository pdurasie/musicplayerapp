package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView intentSponge = findViewById(R.id.intent_sponge);

        intentSponge.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, libraryActivity.class);
                startActivity(numbersIntent);
            }
        });


    }


}


// Activities: 1. Main (Player + List of random (?) songs below)
// 2. Library (total list of songs)
// 3. Hearted songs -> You may also like (Genres)