package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ** Send explicit intent to library activity
         */
        Button libraryBtn = findViewById(R.id.library_btn);
        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent =
                        new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });
/*
**This receives a Song object when it is started by an explicit intent and sets it to
* the current Song
 */
        Intent intent = getIntent();
        Song clickedSong = (Song) intent.getSerializableExtra("clickedSong");
        if (clickedSong != null) {
            setCurrentSong(clickedSong);
        }
    }

    public void setCurrentSong(Song clickedSong){
        TextView currentSongTitle = findViewById(R.id.current_song_title);
        currentSongTitle.setText(clickedSong.getSongName());

        TextView currentArtistName = findViewById(R.id.current_artist_name);
        currentArtistName.setText(clickedSong.getArtistName());

        int ImageId = clickedSong.getImageResourceId();
        RelativeLayout currentSongLayout = findViewById(R.id.current_song_layout);
        currentSongLayout.setBackgroundResource(ImageId);
    }


}