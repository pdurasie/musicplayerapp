package com.example.android.musicplayerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Song currentSong;
    Handler handler = new Handler();
    Runnable updateSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = findViewById(R.id.seekbar);
        updateSeekbar = new Runnable() {
            @Override
            public void run() {
                int currentMediaPosition = mediaPlayer.getCurrentPosition();
                int maxMediaDuration = mediaPlayer.getDuration();
                seekBar.setMax(maxMediaDuration);
                seekBar.setProgress(currentMediaPosition);
                handler.postDelayed(this, 100);
            }
        };

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    int currentPosition = seekBar.getProgress();
                    mediaPlayer.seekTo(currentPosition);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
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

        Button playButton = findViewById(R.id.play_btn);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSong(currentSong);
            }
        });
        /*
         **This receives a Song object when it is started by an explicit intent and sets it to
         * the current Song
         */
        Intent intent = getIntent();
        Song clickedSong = (Song) intent.getSerializableExtra("clickedSong");
        if (clickedSong != null) {
            currentSong = clickedSong;
            setCurrentSong(currentSong);
            startSong(currentSong);
        } else {
            currentSong = new Song("Covered in Flames",
                    "Imagine Letters",
                    R.drawable.concert_pic,
                    R.drawable.concert_pic_tn,
                    "Rock",
                    R.raw.a_kiss_to_build_a_dream_on);
            setCurrentSong(currentSong);
        }
    }


    public void setCurrentSong(Song clickedSong) {
        TextView currentSongTitle = findViewById(R.id.current_song_title);
        currentSongTitle.setText(clickedSong.getSongName());

        TextView currentArtistName = findViewById(R.id.current_artist_name);
        currentArtistName.setText(clickedSong.getArtistName());

        int ImageId = clickedSong.getImageResourceId();
        RelativeLayout currentSongLayout = findViewById(R.id.current_song_layout);
        currentSongLayout.setBackgroundResource(ImageId);
    }



    /*
     **The startSong method is a placeholder for real music playing capabilities
     */
    public void startSong(Song currentSong) {
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), currentSong.getSongFileId());
        mediaPlayer.start();
        handler.post(updateSeekbar);
    }

}