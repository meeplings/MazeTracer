package com.example.jeffrey.mazetracer;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    float x;
    float y;

    ImageButton star;
    ImageButton redX;
    GridLayout grid;
    TextView test;
    ImageButton[][] box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (TextView) findViewById(R.id.idTest);

        x = 0;
        y = 0;
        box = new ImageButton[4][4];
        box[0][0] = (ImageButton) findViewById(R.id.redX00);
        box[3][3] = (ImageButton) findViewById(R.id.redX33);
//        for(int i = 0; i < box.length; i++){
//            for(int j = 0; j < box[i].length; j++){
//                int id = R.id.redX00;
//                box[i][j] = (ImageButton) findViewById(id);
//            }
//        }
        test.setText(Integer.toString(box[0][0].getId()) + "\t" + Integer.toString(box[3][3].getId()));

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
                                x = startX;
                                y = startY;
                                break;
                            case MotionEvent.ACTION_MOVE:
                                x = e.getX();
                                y = e.getY();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                x = startX;
                                y = startY;
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
        resetStar();


    }
    final float startX = star.getX();
    final float startY = star.getY();



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

    public void resetStar(){
        if((redX.getX() - star.getX() < 0 ) && (redX.getY() - star.getY() <0)){
            star.setX(startX);
            star.setY(startY);
        }
    }

}
