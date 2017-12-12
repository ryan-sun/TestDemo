package com.ryan.testdemo.canvas;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.testdemo.R;

/**
 * author： sr on 2017/11/14.
 * e-mail：
 */

public class DefaultView extends View {
    public Paint mPaint;
    public String defaultColor = "#508cee";
    public int paintColor = Color.RED;
    public int strokeWidth = 10;
    public int widthMeasureSpec = 100;
    public int heightMeasureSpec = 100;

    public DefaultView(Context context) {
        this(context,null);
    }

    public DefaultView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DefaultView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.draw_color_view);
        paintColor = ta.getColor(R.styleable.draw_color_view_bgColor, Color.parseColor(defaultColor));
        boolean isFill = ta.getBoolean(R.styleable.draw_color_view_fill,true);
        strokeWidth = (int) ta.getDimension(R.styleable.draw_color_view_stroke,10);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(paintColor);
        mPaint.setStrokeWidth(strokeWidth);
        if(isFill){
            mPaint.setStyle(Paint.Style.FILL);
        }else{
            mPaint.setStyle(Paint.Style.STROKE);
        }
    }
}
