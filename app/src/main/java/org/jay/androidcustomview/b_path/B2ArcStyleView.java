package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.BaseView;

// 弧线样式示例
public class B2ArcStyleView extends BaseView {

    private int width;
    private Paint ovalPaint;
    private Paint arcPaint;

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

        arcPaint = new Paint();
        arcPaint.setColor(Color.GREEN);
        arcPaint.setAntiAlias(true);
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
        arcPaint.setStyle(Paint.Style.FILL);
        drawPath(canvas, offset);

        // 描边样式
        offset = dp2px(160);
        arcPaint.setStrokeWidth(10);
        arcPaint.setStyle(Paint.Style.STROKE);
        drawPath(canvas, width - offset);

    }

    private void drawPath(Canvas canvas, float left) {

        // 椭圆矩形范围
        RectF ovalRect = getRect(left);

        // 绘制椭圆背景
        canvas.drawOval(ovalRect, ovalPaint);

        // 绘制弧线路径
        drawArc(ovalRect, canvas);
    }

    private void drawArc(RectF ovalRect, Canvas canvas) {
        Path path = new Path();
        path.arcTo(ovalRect, 0, 90);
        canvas.drawPath(path, arcPaint);
    }

    private RectF getRect(float left) {
        float top = dp2px(30);
        float width = dp2px(80);
        float right = left + width;
        float bottom = top + width;
        RectF ovalRect = new RectF(left, top, right, bottom);
        return ovalRect;
    }


}
