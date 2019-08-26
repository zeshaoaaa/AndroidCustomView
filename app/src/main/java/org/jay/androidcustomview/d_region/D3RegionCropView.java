package org.jay.androidcustomview.d_region;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class D3RegionCropView extends BaseView {

    private Paint grayPaint;
    private int centerX;
    private Paint redPaint;
    private Paint greenPaint;
    private final int widthDp = 50;

    public D3RegionCropView(Context context) {
        this(context, null);
    }

    public D3RegionCropView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public D3RegionCropView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        grayPaint = new Paint();
        grayPaint.setColor(Color.parseColor("#484848"));
        grayPaint.setAntiAlias(true);

        greenPaint = new Paint();
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStyle(Paint.Style.STROKE);
        greenPaint.setStrokeWidth(2);
        greenPaint.setAntiAlias(true);

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

        int left = (int) (centerX - dp2px(60 + widthDp));

        // 椭圆路径
        Path path = getPath(left);
        canvas.drawPath(path, grayPaint);

        // 裁剪区域
        Region clip = getClip(left);
        drawRegion(canvas, clip, greenPaint);

        // 绘制裁剪结果
        Region region = new Region();
        left = (int) (centerX + dp2px(60));
        path = getPath(left);
        clip = getClip(left);
        region.setPath(path, clip);
        drawRegion(canvas, region, redPaint);

    }

    private Path getPath(int left) {
        RectF rect = getRect(left);
        Path path = new Path();
        path.addOval(rect, Path.Direction.CW);
        return path;
    }

    private Region getClip(int left) {
        int top = (int) dp2px(20);
        int width = (int) dp2px(widthDp);
        Rect rect = new Rect(left, top, left + width, top + width);
        return new Region(rect);
    }

    private RectF getRect(int left) {
        float top = dp2px(30);
        float width = dp2px(widthDp);
        float height = dp2px(widthDp * 2);
        return new RectF(left, top, left + width, top + height);
    }

}
