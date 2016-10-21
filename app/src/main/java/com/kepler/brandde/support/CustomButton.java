package com.kepler.brandde.support;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

public class CustomButton extends Button {

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButton(Context context) {
        super(context);
        init();
    }

    public void init() {
//        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/font.ttf");
//        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto_regular.ttf");
//        setTypeface(tf ,1);
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }

}