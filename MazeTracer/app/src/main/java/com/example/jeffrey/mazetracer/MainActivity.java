package com.example.jeffrey.mazetracer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    float x;
    float y;

    ImageButton star;
    GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridLayout) findViewById(R.id.gridLayout);
        x = 0;
        y = 0;
        star = (ImageButton) findViewById(R.id.star);
        star.setOnTouchListener(
                new ImageButton.OnTouchListener(){
                    public boolean onTouch(View v, MotionEvent e) {
                        star.setX(x);
                        star.setY(y);

                        switch (e.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                x = e.getX();
                                y = e.getY();
                                break;
                            case MotionEvent.ACTION_UP:
                                x = e.getX();
                                y = e.getY();
                                break;
                            case MotionEvent.ACTION_MOVE:
                                x = e.getX();
                                y = e.getY();
                                break;
                            default:
                                x = 0;
                                y = 0;
                                break;

                        }
                        return false;

                    }
                }
        );


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



}
