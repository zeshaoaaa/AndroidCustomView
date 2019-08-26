package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class B8RadarView extends View {

    //网格最大半径
    private float radius;

    //中心X
    private int centerX;

    //中心Y
    private int centerY;

    //雷达区画笔
    private Paint radarPaint;

    //数据个数
    private int count = 6;

    //数据区画笔
    private Paint valuePaint;

    // 1度 = 1 * PI / 180   360度=2*PI
    // 那么我们每旋转一次的角度为 2 * PI / 内角个数
    // 中心与相邻两个内角相连的夹角角度
    float angle = (float) (2 * Math.PI / count);

    public B8RadarView(Context context) {
        this(context, null);
    }

    public B8RadarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public B8RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        radarPaint = new Paint();
        radarPaint.setColor(Color.BLACK);
        radarPaint.setAntiAlias(true);
        radarPaint.setStrokeWidth(1);
        radarPaint.setStyle(Paint.Style.STROKE);

        valuePaint = new Paint();
        valuePaint.setColor(Color.RED);
        valuePaint.setAntiAlias(true);
        valuePaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(w, h) / 2 * 0.9f;
        centerX = w / 2;
        centerY = h / 2;

        //一旦size发生改变，重新绘制
        postInvalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {

        // 画多边形
        drawPolygon(canvas);

        drawLines(canvas);

        // 画结果
        drawData(canvas);
    }

    private void drawLines(Canvas canvas) {
        Path path = new Path();

        for (int i = 0; i < count; i++) {
            path.reset();

            path.moveTo(centerX, centerY);

            float x = (float) (centerX + radius * Math.cos(angle * i));

            float y = (float) (centerY + radius * Math.sin(angle * i));

            path.lineTo(x, y);

            canvas.drawPath(path, radarPaint);
        }
    }

    // 数据
    private double[] data = {2, 5, 1, 6, 4, 5};

    // 最大值
    private float maxValue = 6;

    public void drawData(Canvas canvas) {
        Path path = new Path();

        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, centerY);
            } else {
                path.lineTo(x, y);
            }
            // 绘制小圆点
            valuePaint.setAlpha(255);
            canvas.drawCircle(x, y, 10, valuePaint);
        }

        // 绘制填充区域
        valuePaint.setAlpha(127);
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);

    }

    /**
     * 绘制多边形
     *
     * @param canvas
     */
    private void drawPolygon(Canvas canvas) {
        Path path = new Path();

        //每个蛛丝之间的间距
        float gap = radius / (count - 1);

        for (int i = 0; i < count; i++) {
            //当前半径
            float curR = gap * i;
            path.reset();
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    path.moveTo(centerX + curR, centerY);
                } else {
                    float x = (float) (centerX + curR * Math.cos(angle * j));
                    float y = (float) (centerY + curR * Math.sin(angle * j));
                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, radarPaint);
        }
    }

}