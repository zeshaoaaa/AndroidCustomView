package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.BaseView;

public class B5AddPathView extends BaseView {

    private int width;
    private int centerX;

    public B5AddPathView(Context context) {
        super(context);
    }

    public B5AddPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public B5AddPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 画笔
        Paint paint = getPaint();

        // 设定起点
        Path path = new Path();
        float x = centerX - dp2px(80);
        float y = dp2px(10);
        path.moveTo(x, y);

        // 直线路径
        x += dp2px(80);
        y = dp2px(60);
        path.lineTo(x, y);

        // 弧线路径
        float width = dp2px(30);
        RectF rect = new RectF(x, y, x + width, y + width);
        path.addArc(rect, 0, 90);

        // 绘制路径
        canvas.drawPath(path, paint);

    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        return paint;
    }

}
