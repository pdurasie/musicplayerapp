package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        final ArrayList<Song> SONGS = new ArrayList<>();

        SONGS.add(new Song("Set this world free", "Death to the Spartans", R.drawable.boats_pic, "Rock"));
        SONGS.add(new Song("I'm the master of man", "Death to the Spartans",  R.drawable.boats_pic, "Metal"));
        SONGS.add(new Song("Lollipops", "Death to the Martians",  R.drawable.skyline_pic, "Pop"));

        SongAdapter adapter = new SongAdapter(this, SONGS);

        ListView listView = findViewById(R.id.library_list);

        listView.setAdapter(adapter);

        // Setting the current song
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song clickedSong = SONGS.get(i);
                Intent playIntent = new Intent(LibraryActivity.this, MainActivity.class);
                playIntent.putExtra("clickedSong", clickedSong);
                startActivity(playIntent);
            }
        });

    }
}
