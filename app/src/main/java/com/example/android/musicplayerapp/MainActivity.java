package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ListView intentSponge = findViewById(R.id.main_list);

        intentSponge.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, libraryActivity.class);
                startActivity(numbersIntent);
            }
        });*/

        int SongImageId = R.drawable.skyline_pic;

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Set this world free", "Death to the Spartans", R.drawable.boats_pic, false));
        songs.add(new Song("I'm the master of man", "Death to the Spartans", SongImageId, false));
        songs.add(new Song("Lollipops", "Death to the Martians", SongImageId, false));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.main_list);

        listView.setAdapter(adapter);

    }


}


// Activities: 1. Main (Player + List of random (?) songs below)
// 2. Library (total list of songs)
// 3. Hearted songs -> You may also like (Genres)