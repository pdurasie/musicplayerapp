package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class libraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        int SongImageId = R.drawable.skyline_pic;

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Set this world free", "Death to the Spartans", SongImageId, false));
        songs.add(new Song("I'm the master of man", "Death to the Spartans", SongImageId, false));
        songs.add(new Song("Lollipops", "Death to the Martians", SongImageId, false));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.library_list);

        listView.setAdapter(adapter);

    }
}
