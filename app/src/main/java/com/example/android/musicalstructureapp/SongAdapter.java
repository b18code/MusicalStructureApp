package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * This is a custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of Song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Song object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID song_name
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name);

        // Get the song name from the current Song object and
        // set this text on the song_name TextView
        songNameTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID song_artist
        TextView songArtistTextView = (TextView) listItemView.findViewById(R.id.song_artist);

        // Get the song artist from the current Song object and
        // set this text on the song_artist TextView
        songArtistTextView.setText(currentSong.getSongArtistName());

        // Find the TextView in the list_item.xml layout with the ID song_year
        TextView songYearTextView = (TextView) listItemView.findViewById(R.id.song_year);

        // Get the song year from the current Song object and
        // set this text on the song_year TextView
        songYearTextView.setText(currentSong.getSongYear());

        // Find the ImageView in the list_item.xml layout with the ID song_list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.song_list_item_icon);

        // Get the image resource ID from the current Song object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getImageResourceId());

        // Return the song list item layout (containing 3 TextViews and an ImageView)
        return listItemView;
    }
}
