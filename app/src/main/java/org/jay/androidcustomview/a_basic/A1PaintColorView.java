package org.jay.androidcustomview.a_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.ViewUtils;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class A1PaintColorView extends View {

    private int centerX;
    private Paint paint;

    public A1PaintColorView(Context context) {
        this(context, null);
    }

    public A1PaintColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public A1PaintColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float offset = dp2px(this, 80);

        // 红色圆
        drawCircle((int) (centerX - offset), Color.RED, canvas);

        // 绿色圆
        drawCircle(centerX, Color.GREEN, canvas);

        // 蓝色圆
        drawCircle((int) (centerX + offset), Color.BLUE, canvas);

    }

    private void drawCircle(int centerX, int color, Canvas canvas) {

        // 设置画笔颜色
        paint.setColor(color);

        // 画圆
        int radius = (int) dp2px(getContext(), 30);
        float centerY = dp2px(getContext(), 50);
        canvas.drawCircle(centerX, centerY, radius, paint);

    }

}
