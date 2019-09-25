package com.example.android.musicplayerapp;

import java.io.Serializable;

public class Song implements Serializable {

    private String mSongName;
    private String mArtistName;
    private int mImageResourceId;
    private int mThumbnailResourceId;
    private String mGenre;
    private int mSongFileId;

    public Song(String songName,
                String artistName,
                int imageResourceId,
                int thumbnailResourceId,
                String genre,
                int songFileId) {
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
        mThumbnailResourceId = thumbnailResourceId;
        mGenre = genre;
        mSongFileId = songFileId;
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

    public int getSongFileId() {return mSongFileId; }

}
