package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Spinner spinner = findViewById(R.id.genre_spinner);
        ArrayAdapter<CharSequence> genreAdapter = ArrayAdapter.createFromResource(this,
                R.array.genres_array,
                android.R.layout.simple_spinner_item);
        genreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(genreAdapter);

        final ArrayList<Song> SONGS = new ArrayList<>();

        SONGS.add(new Song("Flames", "Imagine Letters", R.drawable.concert_pic,  R.drawable.concert_pic_tn, "Rock"));
        SONGS.add(new Song("Set this world free", "Death to the Spartans", R.drawable.stairs_pic, R.drawable.stairs_pic_tn, "Metal"));
        SONGS.add(new Song("Sunset Rider", "Four Guys",  R.drawable.boats_pic, R.drawable.boats_pic_tn, "Rock"));
        SONGS.add(new Song("Lollipops", "Death to the Martians",  R.drawable.head_pic, R.drawable.head_pic_tn, "Pop"));
        SONGS.add(new Song("Nature fixes you", "The Hipsters", R.drawable.creek_pic, R.drawable.creek_pic_tn, "Alternative"));

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
