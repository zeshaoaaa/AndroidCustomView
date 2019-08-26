package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A6CanvasDotView extends View {

    private int centerX;

    public A6CanvasDotView(Context context) {
        super(context);
    }

    public A6CanvasDotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public A6CanvasDotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float offset = dp2px(this, 50);

        // 10
        float startX = centerX - offset;
        drawPoint(canvas, startX, 10);

        // 20
        startX = centerX + offset;
        drawPoint(canvas, startX, 20);

    }

    private void drawPoint(Canvas canvas, float centerX, int strokeWidth) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#484848"));
        paint.setStrokeWidth(strokeWidth);

        float y = dp2px(this, 35);
        canvas.drawPoint(centerX, y, paint);
    }

}
