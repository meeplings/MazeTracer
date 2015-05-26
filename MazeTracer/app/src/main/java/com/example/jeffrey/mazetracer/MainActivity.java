package com.example.jeffrey.mazetracer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;


public class MainActivity extends ActionBarActivity {

    float x;
    float y;

    ImageButton star;
    TableLayout grid;
    ImageButton[][] box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (TableLayout) findViewById(R.id.tableLayout);
        x = 0;
        y = 0;
        box = new ImageButton[4][4];
        int id = R.id.redX00;
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                box[i][j] = (ImageButton) findViewById(id);
                id++;
            }
        }
        box[1][1].setActivated(false);
        box[1][2].setActivated(false);
        box[2][1].setActivated(false);
        box[2][2].setActivated(false);
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].isActivated())
                    box[i][j].setVisibility(View.INVISIBLE);
            }
        }
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
                                resetStar(star,grid);
                                break;
                            case MotionEvent.ACTION_MOVE:
                                x = e.getX();
                                y = e.getY();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                resetStar(star,grid);
                                break;
                            default:
                                resetStar(star,grid);
                                break;

                        }
                        return false;

                    }
                }
        );
        boxSetup(box[1][2]);
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

    public void resetStar(ImageButton s, TableLayout screen){
            s.setX(screen.getWidth()/2);
            s.setY(screen.getHeight()/2);

    }
    public void boxSetup(View v){
        v.setX(grid.getWidth()/2);
        v.setY(grid.getHeight()/2);
    }

}
