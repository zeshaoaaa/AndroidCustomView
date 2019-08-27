package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.BaseView;

public class B6PathDirectionView extends BaseView {

    private int width;
    private Paint textPaint;

    public B6PathDirectionView(Context context) {
        this(context, null);
    }

    public B6PathDirectionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public B6PathDirectionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        textPaint = getPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(sp2px(15));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float left = dp2px(100);
        drawPath(canvas, Path.Direction.CW, left);

        left = width - dp2px(150);
        drawPath(canvas, Path.Direction.CCW, left);

    }

    private void drawPath(Canvas canvas, Path.Direction direction, float left) {

        // 椭圆路径
        Path path = getOvalPath(direction, left);

        // 绘制椭圆路径
        Paint paint = getPaint();
        paint.setColor(Color.DKGRAY);
        canvas.drawPath(path, paint);

        // 沿着路径方向绘制文字
        canvas.drawTextOnPath("一二三", path, 0, 0, textPaint);

    }

    private Path getOvalPath(Path.Direction direction, float left) {
        Path path = new Path();
        float top = dp2px(10);
        float right = left + dp2px(50);
        float bottom = top + dp2px(100);
        RectF rect = new RectF(left, top, right, bottom);
        path.addOval(rect, direction);
        return path;
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        return paint;
    }


}
