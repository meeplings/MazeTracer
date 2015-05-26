package com.example.jeffrey.mazetracer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Jeffrey on 5/12/2015.
 */
public class LevelTemplates extends ActionBarActivity {

    public int score;
    ImageButton star;
    float xCo;
    float yCo;
    final float startX =0;
    final float startY = 0;
    public long startTimer = 0;
    public long endTimer =  System.currentTimeMillis()+15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        star = (ImageButton) findViewById(R.id.star);
        star.setOnTouchListener(
                new ImageButton.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent e) {
                        star.setX(xCo);
                        star.setY(yCo);

                        switch (e.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                xCo = e.getX();
                                yCo = e.getY();
                                break;
                            case MotionEvent.ACTION_UP:
                                xCo = startX;
                                yCo = startY;
                                break;
                            case MotionEvent.ACTION_MOVE:
                                xCo = e.getX();
                                yCo = e.getY();
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                xCo = startX;
                                yCo = startY;
                                break;
                            default:
                                xCo = 0;
                                yCo = 0;
                                break;

                        }
                        return false;

                    }
                }
        );

        startTimer = System.currentTimeMillis();
        while(startTimer < endTimer){

        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int s) {
        score = s;
    }

    public void redrawMaze(View view){

    }
//    public void readText() throws FileNotFoundException {
//        try{
//            InputStream input = openFileInput("C:\\Users\\Jeffrey\\AndroidStudioProjects\\MazeTracer\\app\\src\\main\\res\\drawable");
//            if(input != null){
//                InputStreamReader inputReader = new InputStreamReader(input);
//                BufferedReader buffReader = new BufferedReader(inputReader);
//                String line = "";
//                String lineAt ="";
//                try{
//                    while(line = buffReader.readLine() != null)
//                        lineAt+=line;
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
