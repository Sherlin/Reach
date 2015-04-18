package com.hackathon.lta.reach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final ImageButton login_facebook = (ImageButton) findViewById(R.id.login_facebook);
        final ImageButton login_google = (ImageButton) findViewById(R.id.login_google);
        final Button login_skip = (Button) findViewById(R.id.login_skip);

        login_facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                login();

            }
        });

        login_google.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                login();

            }
        });


        login_skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                skip();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void login(){

        Intent i = new Intent(this, LoginSplash.class);
        startActivity(i);

    }

    public void skip()
    {
        Intent intent = new Intent(this, Setup1.class);
        startActivity(intent);
    }
}
