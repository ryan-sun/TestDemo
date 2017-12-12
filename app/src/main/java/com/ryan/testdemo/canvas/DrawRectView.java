package com.ryan.testdemo.canvas;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.testdemo.R;

/**
 * 画矩形
 * author： sr on 2017/11/14.
 * e-mail：
 */

public class DrawRectView extends View {

    public Paint mPaint;
    public String defaultColor = "#508cee";
    public int paintColor = Color.RED;
    public int strokeWidth = 10;
    public int widthMeasureSpec = 50;
    public int heightMeasureSpec = 0;
    private int width = 600;

    public DrawRectView(Context context) {
        this(context,null);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getMeasuredWidth();
        heightMeasureSpec = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        canvas.drawRect(widthMeasureSpec,0,heightMeasureSpec,heightMeasureSpec,mPaint);
    }
}
