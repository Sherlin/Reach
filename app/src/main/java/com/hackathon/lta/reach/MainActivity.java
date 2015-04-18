package com.hackathon.lta.reach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton avatarButton = (ImageButton) findViewById(R.id.main_avatar);
        final ImageButton medalButton = (ImageButton) findViewById(R.id.main_medal);
        final ImageButton rewardButton = (ImageButton) findViewById(R.id.main_reward);
        final ImageButton socialButton = (ImageButton) findViewById(R.id.main_social);

        avatarButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goAvatar();
            }
        });

        medalButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goMedal();
            }
        });

        rewardButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goReward();
            }
        });

        socialButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goSocial();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void goAvatar()
    {
        Intent intent = new Intent(this, Avatar.class);
        startActivity(intent);
    }

    public void goMedal()
    {
        Intent intent = new Intent(this, Medal.class);
        startActivity(intent);
    }

    public void goReward()
    {
        Intent intent = new Intent(this, Reward.class);
        startActivity(intent);

    }

    public void goSocial()
    {
        Intent intent = new Intent(this, Social.class);
        startActivity(intent);
    }
}
