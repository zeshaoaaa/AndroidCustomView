package org.jay.androidcustomview;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 创建画笔
        Paint ovalPaint = new Paint();
        Paint arcPaint = new Paint();
        arcPaint.setColor(Color.GREEN);
        arcPaint.setAntiAlias(true);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(5);

        // 1. 0~90
        // 椭圆背景
        RectF ovalRect = new RectF(100, 100, 200, 200);
        canvas.drawOval(ovalRect, ovalPaint);
        // 设置开始的角度和终点的角度
        Path path = new Path();
        path.arcTo(ovalRect, 0, 90);
        canvas.drawPath(path, arcPaint);

        // 2. 0~180
        // 椭圆背景
        ovalRect = new RectF(300, 100, 400, 200);
        canvas.drawOval(ovalRect, ovalPaint);
        path = new Path();
        // 设置开始的角度和终点的角度
        path.arcTo(ovalRect, 0, 180);
        canvas.drawPath(path, arcPaint);

        // 3. 90~180
        // 椭圆背景
        ovalRect = new RectF(500, 100, 600, 200);
        canvas.drawOval(ovalRect, ovalPaint);
        path = new Path();
        // 设置开始的角度和终点的角度
        path.arcTo(ovalRect, 90, 180);
        canvas.drawPath(path, arcPaint);


    }

}