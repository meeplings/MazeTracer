package com.example.jeffrey.mazetracer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity{

    float x;
    private static double score;
    StopWatch t;
    static String scoreSender;
    float y;
    Scanner input;
    List<ImageButton> ActivatedButtons;

    ImageButton star;
    RelativeLayout screen;
    ImageButton[][] box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 1000;
        t = new StopWatch();

        try {
            input = new Scanner(randFile(fileSetup()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ActivatedButtons = new ArrayList<ImageButton>();
        screen = (RelativeLayout) findViewById(R.id.relativeLayout);
        x = 0;
        y = 0;
<<<<<<< HEAD
        box = boxSetup(input);
        int yOffset = 0;
=======
        box = new ImageButton[5][5];
>>>>>>> cda02de686ed3df50a10e957b314476e3afd3400
        for(int i = 0; i < box.length; i++){
            int xOffset = 0;
            for(int j =0; j < box[i].length; j++){
                box[i][j] = new ImageButton(this);
                buttonSetup(box[i][j], xOffset, yOffset);
                xOffset+=box[i][j].getWidth();
                box[i][j].setOnTouchListener(
                        new ImageButton.OnTouchListener(){
                            public boolean onTouch(View v, MotionEvent e) {
<<<<<<< HEAD
                                if (star.isPressed() &&
                                        ((v.getX()+v.getWidth() > star.getX() + star.getWidth())&& (v.getY()+v.getHeight()> star.getY() + star.getHeight()))){
                                    t.stop();
                                    Intent intent = new Intent(MainActivity.this, StartActivity.class);
                                    scoreSender = Double.toString(score);
                                    intent.putExtra("scoreSender", scoreSender);
=======
                                if (star.isPressed() && v.){
                                    Intent intent = new Intent(MainActivity.this, StartActivity.class);
>>>>>>> cda02de686ed3df50a10e957b314476e3afd3400
                                    startActivity(intent);
                                    finish();
                            }
                                return true;
                            }
                        }
                );
                box[i][j].setVisibility(View.VISIBLE);
                box[i][j].setImageResource(R.drawable.red_x);
                box[i][j].setActivated(true);
            }
            yOffset+=box[i][0].getHeight();
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
                                resetStar(star,screen);
                                break;
                            case MotionEvent.ACTION_MOVE:
                                x = e.getX();
                                y = e.getY();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                resetStar(star,screen);
                                break;
                            default:
                                resetStar(star,screen);
                                break;

                        }
                        return false;

                    }
                }
        );
        try {
            scan();
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
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

    public void resetStar(ImageButton s, RelativeLayout screen){
            s.setX(screen.getWidth()/2);
            s.setY(screen.getHeight() / 2);

    }
    public void buttonSetup(ImageButton x, int xOff, int yOff){
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(screen.getWidth(),screen.getHeight());
        p.leftMargin = xOff;
        p.topMargin = yOff;
        if(x.isActivated())
             x.setBackgroundColor(Color.BLUE);
        screen.addView(x, p);
    }
    public void scan() throws IOException {
        Scanner scan = null;
        try{
            scan = new Scanner(getAssets().open("N.txt"));
        }catch(IOException e) {
            e.printStackTrace();
        }
        if(scan != null)
<<<<<<< HEAD
            readText(box, scan);
=======
            readText(box,scan);
>>>>>>> cda02de686ed3df50a10e957b314476e3afd3400
    }

    public ImageButton[][] readText(ImageButton[][] b, Scanner scan){
        int row = 0;
        int col = 0;
        while(scan.hasNext()){
            String character = scan.next();
            if(character == "s"){

                b[row][col].setBackgroundResource(R.drawable.s_image);
                b[row][col].setBackgroundColor(Color.GREEN);
            }

            else if(character == "e") {
                b[row][col].setBackgroundResource(R.drawable.e_image);
                b[row][col].setBackgroundColor(Color.RED);
            }
<<<<<<< HEAD
            else if(character == "*")
                b[row][col].setBackgroundColor(Color.BLUE);
            row++;
            if(character == "|"){
                scan.nextLine();
                col++;
                row = 0;
            }



        }
        return b;
    }
    public InputStream randFile(InputStream[] f){
        int r = (int) (Math.random()*f.length);
        return f[r];
=======
            else if(character == "*"){
                b[row][col].setBackgroundColor(Color.BLUE);
            }
            col++;
             if(character == "|"){
                 col = 0;
                 row++;
            }

>>>>>>> cda02de686ed3df50a10e957b314476e3afd3400

    }
    public static ImageButton[][] boxSetup(Scanner scan){
        int x = 0;
        int y = 0;
        while(scan.hasNext()){
            x++;
            if(scan.next() == "|") {
                scan.nextLine();
                x = 0;
                y++;
            }
        }
<<<<<<< HEAD
        return new ImageButton[x][y];

    }

    public InputStream[] fileSetup() throws IOException{
        InputStream[] s = {getAssets().open("N.txt"), getAssets().open("Diamond.txt")};
        return s;
    }
    public double incrementScore(){
        while(t.getRunning())
            score--;
        return score;
=======
        return b;
>>>>>>> cda02de686ed3df50a10e957b314476e3afd3400
    }

}
