package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.BaseView;

public class B2ArcStyleView extends BaseView {

    private int width;
    private Paint ovalPaint;

    public B2ArcStyleView(Context context) {
        this(context, null);
    }

    public B2ArcStyleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public B2ArcStyleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ovalPaint = new Paint();
        ovalPaint.setColor(Color.parseColor("#484848"));
        ovalPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 默认填充
        float offset = dp2px(100);
        drawPath(canvas, offset, null);

        // 描边样式
        offset = dp2px(160);
        drawPath(canvas, width - offset, Paint.Style.STROKE);

    }

    private void drawPath(Canvas canvas, float left,
                         Paint.Style style) {

        // 画笔
        Paint paint = getPaint(style);

        // 椭圆矩形范围
        RectF ovalRect = getRect(left);

        // 绘制椭圆背景
        canvas.drawOval(ovalRect, ovalPaint);

        // 绘制弧线路径
        drawArc(paint, ovalRect, canvas);
    }

    private void drawArc(Paint paint, RectF ovalRect,
                         Canvas canvas) {
        Path path = new Path();
        path.arcTo(ovalRect, 0, 90);
        canvas.drawPath(path, paint);
    }

    private Paint getPaint(Paint.Style style) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        if (style != null) {
            paint.setStrokeWidth(10);
            paint.setStyle(style);
        }
        return paint;
    }

    private RectF getRect(float left) {
        float top = dp2px(30);
        float width = dp2px(60);
        float right = left + width;
        float bottom = top + width;
        RectF ovalRect = new RectF(left, top, right, bottom);
        return ovalRect;
    }


}
