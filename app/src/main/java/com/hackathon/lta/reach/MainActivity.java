package com.hackathon.lta.reach;

import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    private static final int WALKING_ACTIVITY = 0;
    private static final int CYCLING_ACTIVITY = 1;
    private static final int FRAGMENT_COUNT = 2;

    private ViewPager mImagePager;
    private FragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton avatarButton = (ImageButton) findViewById(R.id.main_avatar);

        avatarButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goAvatar();
            }
        });

        // Initialize the ViewPager
        mPagerAdapter = new ActivityPagerAdapter(getSupportFragmentManager());
        mImagePager = (ViewPager) findViewById(R.id.main_pager);
        mImagePager.setAdapter(mPagerAdapter);

        final ImageButton medalButton = (ImageButton) findViewById(R.id.main_medal);
        final ImageButton rewardButton = (ImageButton) findViewById(R.id.main_reward);
        final ImageButton socialButton = (ImageButton) findViewById(R.id.main_social);

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

    private class ActivityPagerAdapter extends FragmentPagerAdapter
    {
        public ActivityPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            Fragment fragment = null;

            switch(position)
            {
                case WALKING_ACTIVITY:
                    fragment = WalkingFragment.newInstance(MainActivity.this);
                    break;
                case CYCLING_ACTIVITY:
                    fragment = CyclingFragment.newInstance(MainActivity.this);
                    break;
                default:
                    Log.w("ActivityPagerAdapter", "Invalid fragment position requested: " + position);
            }

            return fragment;
        }

        @Override
        public int getCount()
        {
            return FRAGMENT_COUNT;
        }
    }

    public static class WalkingFragment extends Fragment
    {
        private Context mContext;

        public static WalkingFragment newInstance(Context context)
        {
            WalkingFragment fragment = new WalkingFragment();
            fragment.mContext = context;

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_walking, container, false);
            return rootView;
        }
    }

    public static class CyclingFragment extends Fragment
    {
        private Context mContext;

        public static CyclingFragment newInstance(Context context)
        {
            CyclingFragment fragment = new CyclingFragment();
            fragment.mContext = context;

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_cycling, container, false);
            return rootView;
        }
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
