package com.example.jeffrey.mazetracer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Jeffrey on 5/14/2015.
 */
public class MyDragShadowBuilder extends View.DragShadowBuilder{

    private static Drawable shadow;

    public MyDragShadowBuilder(View v){
        super(v);

        shadow = new ColorDrawable((Color.BLUE));
    }

    public void onProvideShadowMetrics(Point s, Point t){
         int width = 0;
         int height = 0;
        width = getView().getWidth()/2;
        height = getView().getHeight()/2;

        shadow.setBounds(0,0,width,height);


        s.set(width, height);
        t.set(width/2,height/2);
    }

    public void onDrawShadow(Canvas c){
        shadow.draw(c);
    }
}
