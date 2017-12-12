package com.ryan.testdemo.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * author： sr on 2017/11/14.
 * e-mail：
 */

public class DrawArcView extends View {
    private Paint mPaint;
    private int widthMeasureSpec = 100;
    private int heightMeasureSpec = 100;


    public DrawArcView(Context context) {
        this(context,null);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        widthMeasureSpec = getMeasuredWidth();
        heightMeasureSpec = getMeasuredHeight();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        canvas.drawArc(100,100,600,600,-170,120,true,mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(140,120,600,600,-48,40,true,mPaint);
    }
}
