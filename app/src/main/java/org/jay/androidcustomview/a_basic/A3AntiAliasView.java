package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A3AntiAliasView extends View {

    private int centerX;
    private Paint normalPaint;
    private Paint antiPaint;

    public A3AntiAliasView(Context context) {
        this(context, null);
    }

    public A3AntiAliasView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public A3AntiAliasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        normalPaint = new Paint();
        normalPaint.setStyle(Paint.Style.STROKE);
        normalPaint.setStrokeWidth(5);
        normalPaint.setColor(Color.parseColor("#484848"));

        antiPaint = new Paint();
        antiPaint.setAntiAlias(true);
        antiPaint.setStyle(Paint.Style.STROKE);
        antiPaint.setStrokeWidth(5);
        antiPaint.setColor(Color.parseColor("#484848"));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        float centerY = dp2px(getContext(), 50);
        float radius = dp2px(getContext(), 40);
        float offset = dp2px(this, 80);

        // 无抗锯齿的圆
        canvas.drawCircle(centerX - offset, centerY, radius, normalPaint);

        // 抗锯齿的圆
        canvas.drawCircle(centerX + offset, centerY, radius, antiPaint);

    }

}
