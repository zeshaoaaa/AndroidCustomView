package org.jay.androidcustomview.c_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import org.jay.androidcustomview.BaseView;

public class C6TextPathView extends BaseView {

    private int centerX;
    private float radius;
    private Paint paint;
    private Path path;

    public C6TextPathView(Context context) {
        this(context, null);
    }

    public C6TextPathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C6TextPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        radius = dp2px(35);
        paint = getGrayPaint();
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float left = centerX - dp2px(90);
        float top = dp2px(40);

        // 无偏移
        drawText(canvas, left, top, 0, 0);

        // 正向水平偏移
        drawText(canvas, centerX, top, 20, 0);

        // 反向水平偏移
        left = centerX + dp2px(90);
        drawText(canvas, left, top, -20, 0);

        // 正向垂直偏移
        top = dp2px(130);
        left = centerX - dp2px(50);
        drawText(canvas, left, top, 0, 20);

        // 反向垂直偏移
        left = centerX + dp2px(50);
        drawText(canvas, left, top, 0, -20);

    }

    private void drawText(Canvas canvas, float left, float top,
                          int horizontalOffset, int verticalOffset) {

        // 画参考线
        drawLines(canvas, left, top);

        // 绘制圆形路径
        Path path = getCirclePath(left, top);
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        // 沿路径绘制文本
        paint.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath("自定义", path, horizontalOffset, verticalOffset, paint);

    }

    private void drawLines(Canvas canvas, float left, float top) {

        path.rewind();
        path.moveTo(left - radius, top);
        path.lineTo(left + radius, top);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        path.rewind();
        path.moveTo(left, top - radius);
        path.lineTo(left, top + radius);
        canvas.drawPath(path, paint);

    }

    private Path getCirclePath(float left, float top) {
        path.rewind();
        path.addCircle(left, top, radius, Path.Direction.CW);
        return path;
    }

    private Paint getGrayPaint() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(13));
        return paint;
    }

}
