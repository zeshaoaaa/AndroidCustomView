package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A7CanvasRectView extends View {

    private int width;

    private float size;

    public A7CanvasRectView(Context context) {
        super(context);
    }

    public A7CanvasRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public A7CanvasRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        size = dp2px(this, 60);

        float offset = dp2px(this, 60);

        // 填充
        float left = offset;
        drawRect(canvas, left, null);

        // 描边
        left = width - offset - size;
        drawRect(canvas, left, Paint.Style.STROKE);

    }

    private void drawRect(Canvas canvas, float left, Paint.Style style) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#484848"));
        paint.setAntiAlias(true);
        if (style != null) {
            paint.setStyle(style);
            paint.setStrokeWidth(20);
        }

        float top = dp2px(this, 20);

        canvas.drawRect(left, top, left + size, top + size, paint);
    }

}
