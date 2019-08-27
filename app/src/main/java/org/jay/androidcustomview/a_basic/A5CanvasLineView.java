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
    private Paint paint;

    public A5CanvasLineView(Context context) {
        this(context, null);
    }

    public A5CanvasLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public A5CanvasLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#484848"));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float length = dp2px(100);
        float y = dp2px(35);
        float offset = dp2px(20);
        float startX = centerX - length - offset;

        // 10
        paint.setStrokeWidth(10);
        canvas.drawLine(startX, y, startX + length, y, paint);


        // 20
        paint.setStrokeWidth(20);
        startX = centerX + offset;
        canvas.drawLine(startX, y, startX + length, y, paint);

    }

}
