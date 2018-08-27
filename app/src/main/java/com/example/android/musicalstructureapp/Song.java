package com.example.android.musicalstructureapp;

public class Song {

    // Name of the Song
    private String mSongName;

    // Name of the Artist
    private String mSongArtistName;

    // Year the song was released
    private String mSongYear;

    // Drawable resource ID for the album art or icon
    private int mImageResourceId;

    /**
     * Create a new Song object.
     *
     * @param songName        is the name of the song (e.g. Baby)
     * @param songArtistName  is the name of the artist (e.g. Justin Bieber)
     * @param songYear        is the year the song was released (e.g.2002)
     * @param imageResourceId is the image for the album art/icon
     */
    public Song(String songName, String songArtistName, String songYear, int imageResourceId)

    {
        mSongName = songName;
        mSongArtistName = songArtistName;
        mSongYear = songYear;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the song
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the name of the artist
     */
    public String getSongArtistName() {
        return mSongArtistName;
    }

    /**
     * Get the year of the song release
     */
    public String getSongYear() {
        return mSongYear;
    }

    /**
     * Get the image resource ID for the album art or icon
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
