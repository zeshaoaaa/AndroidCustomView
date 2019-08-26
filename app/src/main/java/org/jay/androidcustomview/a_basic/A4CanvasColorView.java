package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A4CanvasColorView extends View {

    private int centerX;
    private Paint paint;

    public A4CanvasColorView(Context context) {
        this(context, null);
    }

    public A4CanvasColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public A4CanvasColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 背景
        canvas.drawColor(Color.DKGRAY);


        // 画圆
        int radius = (int) dp2px(getContext(), 30);
        float centerY = dp2px(getContext(), 70);
        canvas.drawCircle(centerX, centerY, radius, paint);

    }

}
