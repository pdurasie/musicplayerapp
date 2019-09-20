package com.example.android.musicplayerapp;

import android.widget.Filter;

import java.io.Serializable;

public class Song implements Serializable {

    private String mSongName;
    private String mArtistName;
    private int mImageResourceId;
    private int mThumbnailResourceId;
    private String mGenre;

    public Song(String songName, String artistName, int imageResourceId, int thumbnailResourceId, String genre) {
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mThumbnailResourceId = thumbnailResourceId;
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

    public int getThumbnailResourceId() { return mThumbnailResourceId; }

    public String getGenre() {
        return mGenre;
    }

}
