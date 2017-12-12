package com.ryan.testdemo.canvas;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ryan.testdemo.R;

/**
 * 画颜色
 * author： sr on 2017/11/14.
 * e-mail：
 */

public class DrawColorView extends View {
    private Paint mPaint;
    private int defaultColor = 0x0101014f;
    private int paintColor = 0x0101014f;

    public DrawColorView(Context context) {
        this(context,null);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.draw_color_view);
        paintColor = ta.getColor(R.styleable.draw_color_view_bgColor,defaultColor);
        mPaint = new Paint();
        mPaint.setColor(paintColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(paintColor);
    }
}
