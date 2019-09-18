package com.example.android.musicplayerapp;

import android.widget.Filter;

import java.io.Serializable;

public class Song implements Serializable {

    private String mSongName;
    private String mArtistName;
    private int mImageResourceId;
    private String mGenre;

    public Song(String songName, String artistName, int imageResourceId, String genre) {
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mGenre = genre;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getGenre() {
        return mGenre;
    }

}
