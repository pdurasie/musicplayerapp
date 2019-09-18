package com.example.android.musicplayerapp;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> implements Filterable {

    private List<Song> originalSongList;

   public SongAdapter(Activity context, ArrayList<Song> songs){
        super(context, 0, songs);
        originalSongList = songs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        Song currentSong = getItem(position);

        ImageView songIcon = listItemView.findViewById(R.id.song_item_icon);
        songIcon.setImageResource(currentSong.getImageResourceId());

        TextView songName = listItemView.findViewById(R.id.song_name_text_view);
        songName.setText(currentSong.getSongName());

        TextView artistName = listItemView.findViewById(R.id.artist_name_text_view);
        artistName.setText(currentSong.getArtistName());

        return listItemView;
    }

 /*   // This filtering section is adapted by a stack overflow question:
    // "Custom getFilter in custom ArrayAdapter in android"
    @Override
    public Filter getFilter() {
        return new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filteredSongs = new FilterResults();
                ArrayList<Song> tempList = new ArrayList<Song>();

                if(charSequence != null && originalSongList != null){
                    int length = originalSongList.size();
                    int i = 0;
                    // If the genre is equal to the filtering parameter, add to list
                        while (i < length){
                            Song song = originalSongList.get(i);
                            if (song.getGenre() == charSequence || charSequence == "All") {
                                tempList.add(song);
                            }
                            i++;
                        }
                        //prepare a FilterResults object for "publishResult" method
                        filteredSongs.values = tempList;
                        filteredSongs.count = tempList.size();
                }
                return filteredSongs;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
               originalSongList = (ArrayList<Song>) filterResults.values;
               if (filterResults.count > 0){
                   notifyDataSetChanged();
               } else{
                   notifyDataSetInvalidated();
               }
            }
        };
    }*/
}
