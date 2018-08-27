package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * {@link MainActivity} has one button only: My Play List
 * when the button is clicked, the PlayListActivity is opened
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The ID: play_list_button is cast as a button and stored in the variable playListButton
        Button playListButton = (Button) findViewById(R.id.play_list_button);

        //The OnClickListener allows the play list button to change the
        //MainActivity to the PlayListActivity
        playListButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View button) {

                // Create a new intent to open the {@link PlayListActivity}
                Intent playListIntent = new Intent(MainActivity.this, PlayListActivity.class);

                // Start the new activity
                startActivity(playListIntent);

            }
        });
    }
}

