package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


// Activities: 1. Main (Player + List of random (?) songs below)
// 2. Library (total list of songs)
// 3. Hearted songs -> You may also like (Genres)