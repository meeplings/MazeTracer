package com.example.jeffrey.mazetracer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class StartActivity extends AppCompatActivity {

//    ImageView imageView = new ImageView(this);
//
//    imageView.OnLongClickListener(new View.OnLongClickListener(){
//
//        public boolean onLongClick(View v){
//            ClipData.Item item = new ClipData.Item(v.getTag());
//
//            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView);
//
//            ClipData dragData = new ClipData("","");
//
//
//
//            v.startDrag(dragData, myShadow, null, 0);
//
//            );
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
    public void onInstructionClick(View v){
        Intent i = new Intent(StartActivity.this,InstructionActivity.class);
        startActivity(i);
        finish();

    }
    public void onStartClick(View v){
        Intent i = new Intent(StartActivity.this,MainActivity.class);
        startActivity(i);
        finish();

    }
}
