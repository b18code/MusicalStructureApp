package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        // Create an ArrayList of Song objects
        final ArrayList<Song> songs = new ArrayList<Song>();

        //Each Song object has the song name, artist name, year song was released and the album art/icon
        //Then each Song object is added to the ArrayList songs
        songs.add(new Song("Baby", "Justin Bieber", "2002", R.drawable.music_note_icon_psd));
        songs.add(new Song("Thriller", "Michael Jackson", "1982", R.drawable.nicubunu_musical_note));
        songs.add(new Song("In Da Club", "50 Cent", "2003", R.drawable.music_note_icon_psd));
        songs.add(new Song("Unfaithful", "Rihanna", "2006", R.drawable.music_note_icon_psd));
        songs.add(new Song("I want it that way", "Backstreet Boys", "1999", R.drawable.music_note_icon_psd));
        songs.add(new Song("See you again", "Wiz Khalifa", "2015", R.drawable.music_note_icon_psd));
        songs.add(new Song("A Thousand Miles", "Vanessa Carlton", "2001", R.drawable.nicubunu_musical_note));
        songs.add(new Song("Nice For What", "Drake", "2018", R.drawable.music_note_icon_psd));
        songs.add(new Song("Shape of You", "Ed Sheeran", "2017", R.drawable.music_note_icon_psd));
        songs.add(new Song("Halo", "Beyoncé", "2008", R.drawable.nicubunu_musical_note));

        // Create a {@link SongAdapter}, whose data source is a list of
        // {@link Song}s. The adapter knows how to create list item views for each item
        // in the list.
        SongAdapter musicAdapter = new SongAdapter(this, songs);

        //Use ID:list_view_song for the ListView, and attach the adapter to the listView.
        ListView songListView = (ListView) findViewById(R.id.list_view_song);

        // Make the {@link songListView} use the {@link ArrayAdapter} created above, so that the
        // {@link songListView} will display list items for each song in the list of songs.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name musicAdapter.
        songListView.setAdapter(musicAdapter);

        //The setOnItemClickListener allows each item on the ListView (i.e. songListView) to be clicked individually
        // by using the onItemClick method
        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the selected song's current position within the ListView
                Song currentSelection = songs.get(position);

                //The selected song's info is stored in their respective variables
                String name = currentSelection.getSongName();
                String artist = currentSelection.getSongArtistName();
                String year = currentSelection.getSongYear();
                int image = currentSelection.getImageResourceId();

                //Create a new bundle, then each variable from above is placed into the relavent bundle below
                Bundle bundle = new Bundle();

                bundle.putString("Name", name);
                bundle.putString("Artist", artist);
                bundle.putString("Year", year);
                bundle.putInt("Image", image);

                // Create a new intent to open the {@link NowPlayingActivity}
                Intent nowPlayingIntent = new Intent(PlayListActivity.this, NowPlayingActivity.class);

                // The bundle with all the song info is passed to the NowPlayingActivity
                nowPlayingIntent.putExtras(bundle);

                // Start the new activity
                startActivity(nowPlayingIntent);
            }
        });
    }
}

