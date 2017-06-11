package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    //Handles playback of all the sound files
    private MediaPlayer mMediaPlayer;

    //This listener gets triggered when the {@link MediaPlayer} has completed playing the audio file.
    //
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();

                if (i == 0) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_father);
                    mediaPlayer.start();
                }
                if (i == 1) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_mother);
                    mediaPlayer.start();
                }
                if (i == 2) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_son);
                    mediaPlayer.start();
                }
                if (i == 3) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_daughter);
                    mediaPlayer.start();
                }
                if (i == 4) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_older_brother);
                    mediaPlayer.start();
                }
                if (i == 5) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_younger_brother);
                    mediaPlayer.start();
                }
                if (i == 6) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_older_sister);
                    mediaPlayer.start();
                }
                if (i == 7) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_younger_sister);
                    mediaPlayer.start();
                }
                if (i == 8) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_grandmother);
                    mediaPlayer.start();
                }
                if (i == 9) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, R.raw.family_grandfather);
                    mediaPlayer.start();
                }
            }

            /**
             * Clean up the media player by releasing its resources.
             */
            private void releaseMediaPlayer() {
                // If the media player is not null, then it may be currently playing a sound.
                if (mMediaPlayer != null) {
                    // Regardless of the current state of the media player, release its resources
                    // because we no longer need it.
                    mMediaPlayer.release();

                    // Set the media player back to null. For our code, we've decided that
                    // setting the media player to null is an easy way to tell that the media player
                    // is not configured to play an audio file at the moment.
                    mMediaPlayer = null;
                }
            }
        });
    }
}