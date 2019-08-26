package org.jay.androidcustomview.d_region;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import org.jay.androidcustomview.BaseView;

public class D4RegionSetView extends BaseView {

    private int centerX;
    private Paint yellowPaint;
    private Paint greenPaint;
    private Paint redPaint;
    private int rectWidth;
    private int width;

    public D4RegionSetView(Context context) {
        this(context, null);
    }

    public D4RegionSetView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public D4RegionSetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        yellowPaint = new Paint();
        yellowPaint.setStyle(Paint.Style.STROKE);
        yellowPaint.setStrokeWidth(2);
        yellowPaint.setAntiAlias(true);
        yellowPaint.setColor(Color.YELLOW);

        greenPaint = new Paint();
        greenPaint.setStyle(Paint.Style.STROKE);
        greenPaint.setStrokeWidth(2);
        greenPaint.setAntiAlias(true);
        greenPaint.setColor(Color.GREEN);

        redPaint = new Paint();
        redPaint.setAntiAlias(true);
        redPaint.setColor(Color.RED);

        rectWidth = (int) dp2px(25);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float offset = dp2px(100);
        int top = (int) dp2px(20);

        // 补集
        int left = (int) dp2px(80);
        drawRegion(Region.Op.DIFFERENCE, canvas,left, top);

        // 反转补集
        left = (int) (centerX - dp2px(10));
        drawRegion(Region.Op.REVERSE_DIFFERENCE, canvas,left, top);

        // 交集
        left = (int) (width - offset);
        drawRegion(Region.Op.INTERSECT, canvas,left, top);

        // 并集
        top = (int) dp2px(130);
        left = (int) (int) dp2px(80);
        drawRegion(Region.Op.UNION, canvas,left, top);

        // 异或集
        left = (int) (centerX - dp2px(10));
        drawRegion(Region.Op.XOR, canvas,left, top);

        // 替换原有区域
        left = (int) (width - offset);
        drawRegion(Region.Op.REPLACE, canvas,left, top);

    }

    public void  drawRegion(Region.Op op, Canvas canvas,
                            int left, int top) {

        int height = (int) dp2px(50);

        // 绘制黄色矩形
        Rect yellowRect = new Rect(left, top, left + rectWidth, top + height + rectWidth);
        canvas.drawRect(yellowRect, yellowPaint);

        // 绘制绿色矩形
        Rect greenRect = new Rect(left - rectWidth, top + rectWidth,
                left + height, top + height);
        canvas.drawRect(greenRect, greenPaint);

        // 进行集合运算
        Region yellowRegion = new Region(yellowRect);
        Region greenRegion = new Region(greenRect);
        yellowRegion.op(greenRegion, op);

        // 绘制运算结果
        drawRegion(canvas,yellowRegion, redPaint);

    }




}
