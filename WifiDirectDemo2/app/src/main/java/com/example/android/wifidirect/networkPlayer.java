package com.example.android.wifidirect;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class networkPlayer extends Activity{

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_player);

        Intent last_intent = getIntent();

        intent = new Intent();

        intent.putExtra("p1_wins",last_intent.getStringExtra("p1_wins"));
        intent.putExtra("p2_wins",last_intent.getStringExtra("p2_wins"));
        intent.putExtra("draws",last_intent.getStringExtra("draws"));

        final Button rock = (Button) findViewById(R.id.rock);
        final Button paper = (Button) findViewById(R.id.paper);
        final Button scissors = (Button) findViewById(R.id.scissors);

        rock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("p1Move", "rock");
								setResult(DeviceDetailFragment.CHOOSE_FILE_RESULT_CODE, intent);
                finish();
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("p1Move", "paper");
								setResult(DeviceDetailFragment.CHOOSE_FILE_RESULT_CODE, intent);
                finish();
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("p1Move", "scissors");
								setResult(DeviceDetailFragment.CHOOSE_FILE_RESULT_CODE, intent);
                finish();
            }
        });

    }
}
