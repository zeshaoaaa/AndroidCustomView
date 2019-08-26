package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.BaseView;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A5CanvasLineView extends BaseView {

    private int centerX;
    private int width;

    public A5CanvasLineView(Context context) {
        super(context);
    }

    public A5CanvasLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public A5CanvasLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float offset = dp2px(30);

        // 10
        drawLine(canvas, offset, 10);

        // 20
        float length = dp2px(100);
        drawLine(canvas, width - length - offset, 20);

    }

    private void drawLine(Canvas canvas, float startX, int strokeWidth) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#484848"));
        paint.setStrokeWidth(strokeWidth);

        float length = dp2px(100);
        float y = dp2px(35);
        canvas.drawLine(startX, y, length + startX, y, paint);
    }

}
