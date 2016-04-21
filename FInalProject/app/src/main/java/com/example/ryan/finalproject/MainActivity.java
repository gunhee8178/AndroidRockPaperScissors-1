package com.example.ryan.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GifView gifView = (GifView) findViewById(R.id.imageView);
        final Button localPlay = (Button) findViewById(R.id.localPlay);
        final Button leaderboard = (Button) findViewById(R.id.leaderboard);

        localPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent localIntent = new Intent(getApplicationContext(),localPlayerOne.class);
                localIntent.putExtra("p1_wins","0");
                localIntent.putExtra("p2_wins","0");
                localIntent.putExtra("draws","0");
                startActivity(localIntent);
            }
        });

        leaderboard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent leaderIntent = new Intent(getApplicationContext(),leaderboard.class);
                startActivity(leaderIntent);
            }
        });
    }
}
