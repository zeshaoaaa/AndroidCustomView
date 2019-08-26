package org.jay.androidcustomview.d_region;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class D2RegionUnionView extends BaseView {

    private Paint grayPaint;
    private int centerX;
    private Paint redPaint;

    public D2RegionUnionView(Context context) {
        this(context, null);
    }

    public D2RegionUnionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public D2RegionUnionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        grayPaint = new Paint();
        grayPaint.setColor(Color.parseColor("#484848"));
        grayPaint.setAntiAlias(true);

        redPaint = new Paint();
        redPaint.setAntiAlias(true);
        redPaint.setAlpha(200);
        redPaint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 目标矩阵
        Rect rect = getRect(50);
        canvas.drawRect(rect, grayPaint);

        // 原始区域
        Region region = getRegion(150);
        drawRegion(canvas, region, grayPaint);

        // 合并
        rect = getRect(280);
        region = getRegion(280);
        region.union(rect);

        // 绘制区域
        drawRegion(canvas, region, redPaint);

    }

    private Region getRegion(int left) {
        left = (int) dp2px(left);
        int top = (int) dp2px(20);
        int width = (int) dp2px(40);
        int height = (int) dp2px(20);
        Rect rect = new Rect(left, top, left + width, top + height);
        return new Region(rect);
    }

    private Rect getRect(int left) {
        left = (int) dp2px(left);
        int top = (int) dp2px(20);
        int width = (int) dp2px(20);
        int height = (int) dp2px(80);
        return new Rect(left, top, left + width, top + height);
    }

}
