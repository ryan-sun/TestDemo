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
 * 画圆
 * author： sr on 2017/11/14.
 * e-mail：
 */

public class DrawCircleView extends View {
    private Paint mPaint;
    private String defaultColor = "#508cee";
    private int paintColor = Color.RED;
    private int strokeWidth = 10;
    private int widthMeasureSpec = 100;
    private int heightMeasureSpec = 100;

    public DrawCircleView(Context context) {
        this(context,null);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
        widthMeasureSpec = getMeasuredWidth()/2;
        heightMeasureSpec = getMeasuredHeight()/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(widthMeasureSpec,heightMeasureSpec,100,mPaint);
    }
}
