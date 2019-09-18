package com.example.android.musicplayerapp;

import java.io.Serializable;

public class Song implements Serializable {

    private String mSongName;
    private String mArtistName;
    private int mImageResourceId;
    private boolean mIsHearted;

    public Song(String songName, String artistName, int imageResourceId, boolean isHearted) {
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mIsHearted = isHearted;
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

    public boolean getIsHearted() {
        return mIsHearted;
    }



}
