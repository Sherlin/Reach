package com.hackathon.lta.reach;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Medal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medal);

        getSupportActionBar().hide();

        final ImageButton homeButton = (ImageButton) findViewById(R.id.medal_home);
        final ImageButton rewardButton = (ImageButton) findViewById(R.id.medal_reward);
        final ImageButton mapButton = (ImageButton) findViewById(R.id.medal_map);
        final ImageButton socialButton = (ImageButton) findViewById(R.id.medal_social);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goHome();
            }
        });

        rewardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goReward();
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goMap();
            }
        });

        socialButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goSocial();
            }
        });
/**
        final ImageButton backButton = (ImageButton) findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                back();
            }
        });
 **/
    }

    public void back()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_medal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goReward()
    {
        Intent intent = new Intent(this, Reward.class);
        startActivity(intent);

    }

    public void goMap()
    {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    public void goSocial()
    {
        Intent intent = new Intent(this, Social.class);
        startActivity(intent);
    }
}
