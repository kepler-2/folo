package com.kepler.brandde.support;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;

public class CustomCheckBox extends CheckBox {

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
}

public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        }

public CustomCheckBox(Context context) {
        super(context);
        init();
        }

public void init() {
//        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/font.ttf");
//        setTypeface(tf ,1);
        }


protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        }

        }