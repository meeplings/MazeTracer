package com.example.jeffrey.mazetracer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    float x;
    float y;
    List<ImageButton> ActivatedButtons;

    ImageButton star;
    RelativeLayout screen;
    ImageButton[][] box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivatedButtons = new ArrayList<ImageButton>();
        screen = (RelativeLayout) findViewById(R.id.relativeLayout);
        x = 0;
        y = 0;
        box = new ImageButton[20][20];
        for(int i = 0; i < box.length; i++){
            for(int j =0; j < box[i].length; j++){
                box[i][j] = new ImageButton(this);
                box[i][j].setOnTouchListener(
                        new ImageButton.OnTouchListener(){
                            public boolean onTouch(View v, MotionEvent e) {
                                if (e.getAction() == MotionEvent.ACTION_MOVE){
                                    x = screen.getWidth() / 2;
                                    y = screen.getHeight() / 2;
                            }
                                return true;
                            }
                        }
                );
                box[i][j].setVisibility(View.VISIBLE);
                box[i][j].setActivated(true);
            }
        }
        for(int i = 1; i < box.length; i++){
            for(int j = 1; j < box[i].length; j++){
                box[i][j].setActivated(false);
            }
        }

        int yOffset = 0;
        for(int i = 0; i < box.length; i++){
            int xOffset = 0;
            for(int j = 0; j < box[i].length; j++){
                boxSetup(box[i][j], xOffset, yOffset);
                xOffset+= (int) (1/100* getResources().getDisplayMetrics().density) ;
            }
            yOffset+= (int) (1/100* getResources().getDisplayMetrics().density) ;
        }
        invisButtons();
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
                                for(int i = 0; i < box.length; i++){
                                    for(int j = 1; j < box[i].length; j++){
                                        if((star.getX()  - box[i][j].getX() > 0) && (star.getY() - box[i][j].getY() > 0)){
                                            Intent intent = new Intent(MainActivity.this, StartActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }

                                    }
                                }
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
            s.setY(screen.getHeight()/2);

    }
    public void boxSetup(ImageButton x, int xOff, int yOff){
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams((int) (screen.getWidth()/100*getResources().getDisplayMetrics().density)
                , (int) (screen.getHeight()/100* getResources().getDisplayMetrics().density));
        p.leftMargin = xOff;
        p.topMargin = yOff;
        if(x.isActivated())
             x.setBackgroundColor(Color.BLUE);
        screen.addView(x, p);
    }
    public void invisButtons(){
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].isActivated())
                    box[i][j].setVisibility(View.INVISIBLE);
                else
                    ActivatedButtons.add(box[i][j]);
            }
        }
    }
//    public void scan (String s) throws IOException {
//        Scanner scan = null;
//        try{
//            scan = new Scanner(getAssets().open("box.txt"));
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//        if(scan != null)
//            readText(scan);
//    }
//
//    public static String[][] readText(Scanner scan){
//        String[][] result = new String[9][7];
//        int row = 0;
//        while(scan.hasNext()){
//            int col = 0;
//            String character = scan.next();
//            if(character == "s")
//                result[row][col] = "s";
//            else if(character == "e")
//                result[row][col] = "e";
//            else if(character == )
//
//        }
//    }

}
