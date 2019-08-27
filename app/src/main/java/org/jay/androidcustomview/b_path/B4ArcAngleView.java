package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.BaseView;

// 弧线角度示例
public class B4ArcAngleView extends BaseView {

    private int width;
    private Paint ovalPaint;
    private Paint arcPaint;
    private int centerX;
    private float circleWidth;

    public B4ArcAngleView(Context context) {
        this(context, null);
    }

    public B4ArcAngleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public B4ArcAngleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ovalPaint = new Paint();
        ovalPaint.setColor(Color.parseColor("#484848"));
        ovalPaint.setAntiAlias(true);
        ovalPaint.setAntiAlias(true);

        arcPaint = new Paint();
        arcPaint.setColor(Color.GREEN);
        arcPaint.setAntiAlias(true);
        arcPaint.setStrokeWidth(10);
        arcPaint.setStyle(Paint.Style.STROKE);

        circleWidth = dp2px(80);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float offset = dp2px(40);
        drawArc(canvas, offset, 0, 90);

        offset = dp2px(40);
        drawArc(canvas, centerX - offset, 0, 180);

        offset = dp2px(120);
        drawArc(canvas, width - offset, 90, 180);


    }

    private void drawArc(Canvas canvas, float left,
                         float startAngle, float sweepAngle) {

        // 椭圆范围
        float top = dp2px(30);
        RectF ovalRect = getRect(left, top);

        // 椭圆背景
        canvas.drawOval(ovalRect, ovalPaint);

        // 设置开始的角度和终点的角度
        Path path = new Path();
        path.arcTo(ovalRect, startAngle, sweepAngle);

        // 绘制路径
        canvas.drawPath(path, arcPaint);

    }

    private RectF getRect(float left, float top) {
        float right = left + circleWidth;
        float bottom = top + circleWidth;
        RectF ovalRect = new RectF(left, top, right, bottom);
        return ovalRect;
    }

}
