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
    private Paint rectPaint;
    private Paint circlePaint;

    public A8CanvasRoundRectView(Context context) {
        this(context, null);
    }

    public A8CanvasRoundRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public A8CanvasRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // 圆角半径
        radius = dp2px(this, 10);

        rectPaint = new Paint();
        rectPaint.setColor(Color.parseColor("#484848"));
        rectPaint.setAntiAlias(true);

        circlePaint = new Paint();
        circlePaint.setColor(Color.GREEN);
        circlePaint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        RectF rect = getRect();

        // 绘制圆角矩形
        canvas.drawRoundRect(rect, radius, radius, rectPaint);

        // 绘制四个圆
        drawCircles(canvas, rect);

    }

    private RectF getRect() {
        float halfWidth = dp2px(this, 70);
        float y = dp2px(this, 10);
        RectF rect = new RectF(centerX - halfWidth, y,
                centerX + halfWidth, y + halfWidth * 2);
        return rect;
    }

    private void drawCircles(Canvas canvas, RectF rect) {
        canvas.drawCircle(rect.left + radius, rect.top + radius, radius, circlePaint);
        canvas.drawCircle(rect.right - radius, rect.top + radius, radius, circlePaint);
        canvas.drawCircle(rect.left + radius, rect.bottom - radius, radius, circlePaint);
        canvas.drawCircle(rect.right - radius, rect.bottom - radius, radius, circlePaint);
    }

}
