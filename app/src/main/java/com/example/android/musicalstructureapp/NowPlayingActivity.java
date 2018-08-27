package com.example.android.musicalstructureapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class NowPlayingActivity extends AppCompatActivity {

    // Global variable for storing the name of the song
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //getIntent().getExtras() is stored in the variable bundle
        Bundle bundle = getIntent().getExtras();

        // NowPlayingActivity will display the song info (song name, artist, year of song release and album art)
        // This 'If' statement displays the song info if the bundle passed from the PlayListActivity is not null
        if (bundle != null) {

            //Song info from the PlayListActivity are stored in their respective variables
            name = bundle.getString("Name");
            String artist = bundle.getString("Artist");
            String year = bundle.getString("Year");
            int image = bundle.getInt("Image");

            //This textview will display the song name
            TextView nameTextView = (TextView) findViewById(R.id.song_name_text_view);
            nameTextView.setText(name);

            //This textview will display the artist name
            TextView artistTextView = (TextView) findViewById(R.id.song_artist_text_view);
            artistTextView.setText(artist);

            //This textview will display the year the song was released
            TextView yearTextView = (TextView) findViewById(R.id.song_year_text_view);
            yearTextView.setText(year);

            //This imageview will display the album art
            ImageView iconImageView = (ImageView) findViewById(R.id.song_icon_image_view);
            iconImageView.setImageResource(image);

        }


        // An Image button is used to represent the play button
        final ImageButton imgPlayPauseButton = (ImageButton) findViewById(R.id.play_image_button);

        //setOnClickListener allows the play button (ID:play_image_button) to be clickable
        imgPlayPauseButton.setOnClickListener(new View.OnClickListener() {

            /**
             *
             * @param button changes the ImageView to the play or pause image depending on the user click
             *               then a toast message appears
             */
            @Override
            public void onClick(View button) {

                //Set the button's appearance
                button.setSelected(!button.isSelected());

                // This 'if' statement determines which image to place when the play button (ID:play_image_button)
                // is clicked (the pause or play image), then a toast message appears telling the user
                // if the song or radio station is playing or not
                if (button.isSelected()) {

                    //This imageview displays the pause image button
                    ImageView pauseSong = (ImageView) findViewById(R.id.play_image_button);
                    Drawable drawablePause = getResources().getDrawable(R.drawable.ic_pause_black_96dp);
                    pauseSong.setImageDrawable(drawablePause);

                    //Toast message tells the user the music player is playing the song
                    Toast.makeText(NowPlayingActivity.this, "'" + name + "'" + " is playing", Toast.LENGTH_SHORT).show();

                } else {

                    //This imageview displays the play image button
                    ImageView pauseSong = (ImageView) findViewById(R.id.play_image_button);
                    Drawable drawablePause = getResources().getDrawable(R.drawable.ic_play_arrow_black_96dp);
                    pauseSong.setImageDrawable(drawablePause);

                    //Toast message tells the user the music player has stopped playing the song
                    Toast.makeText(NowPlayingActivity.this, "'" + name + "'" + " has stopped", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //Find the ID:skip_previous_button and cast it as an ImageView, then store it
        //in the variable imgSkipPrevious
        ImageView imgSkipPrevious = (ImageView) findViewById(R.id.skip_previous_button);

        imgSkipPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {

                //Toast message tells the user, the music player is skipping to the previous song
                Toast.makeText(NowPlayingActivity.this, "Skip to previous song", Toast.LENGTH_SHORT).show();

            }
        });

        //Find the ID:skip_next_button and cast it as an ImageView, then store it
        //in the variable imgSkipNext
        ImageView imgSkipNext = (ImageView) findViewById(R.id.skip_next_button);

        imgSkipNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {

                //Toast message tells the user, the music player is skipping to the next song
                Toast.makeText(NowPlayingActivity.this, "Skip to next song", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

