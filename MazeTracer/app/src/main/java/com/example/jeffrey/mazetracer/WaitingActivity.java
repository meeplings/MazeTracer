package com.example.jeffrey.mazetracer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class WaitingActivity extends AppCompatActivity {

    ImageButton cont;
    TextView score;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        cont = (ImageButton) findViewById(R.id.ContinueButton);
        score = (TextView) findViewById(R.id.Score);
        i = getIntent();
        String holder = i.getStringExtra(MainActivity.scoreSender);
        score.setText(holder);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_waiting, menu);
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

    public void cont (View v){
        i = new Intent(WaitingActivity.this, MainActivity.class);
        startActivity(i);
        finish();

    }

}
