package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A2PaintStyleView extends View {

    private int centerX;
    private Paint paint;

    public A2PaintStyleView(Context context) {
        this(context, null);
    }

    public A2PaintStyleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public A2PaintStyleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#484848"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(30);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float offset = dp2px(this, 90);

        // 描边
        drawCircle((int) (centerX - offset), Paint.Style.STROKE, canvas);

        // 填充
        drawCircle(centerX, Paint.Style.FILL, canvas);

        // 描边且填充
        drawCircle((int) (centerX + offset), Paint.Style.FILL_AND_STROKE, canvas);

    }

    private void drawCircle(int centerX, Paint.Style style, Canvas canvas) {

        paint.setStyle(style);

        // 画圆
        float centerY = dp2px(getContext(), 50);
        int radius = (int) dp2px(getContext(), 30);
        canvas.drawCircle(centerX, centerY, radius, paint);

    }

}
