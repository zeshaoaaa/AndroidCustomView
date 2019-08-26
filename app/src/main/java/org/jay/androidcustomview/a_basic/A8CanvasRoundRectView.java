package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A8CanvasRoundRectView extends View {

    private int centerX;
    private float radius;

    public A8CanvasRoundRectView(Context context) {
        super(context);
    }

    public A8CanvasRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public A8CanvasRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 圆角半径
        radius = dp2px(this, 5);

        RectF rect = getRect();
        drawRect(canvas, rect);
        drawCircles(canvas, rect);

    }

    private RectF getRect() {
        float halfWidth = dp2px(this, 40);
        float y = dp2px(this, 10);
        RectF rect = new RectF(centerX - halfWidth, y,
                centerX + halfWidth, y + halfWidth * 2);
        return rect;
    }

    private void drawCircles(Canvas canvas, RectF rect) {
        // 画笔
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);

        canvas.drawCircle(rect.left + radius, rect.top + radius, radius, paint);
        canvas.drawCircle(rect.right - radius, rect.top + radius, radius, paint);
        canvas.drawCircle(rect.left + radius, rect.bottom - radius, radius, paint);
        canvas.drawCircle(rect.right - radius, rect.bottom - radius, radius, paint);
    }

    private void drawRect(Canvas canvas, RectF rect) {
        // 画笔
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#484848"));
        paint.setAntiAlias(true);


        canvas.drawRoundRect(rect, radius, radius, paint);

    }

}
