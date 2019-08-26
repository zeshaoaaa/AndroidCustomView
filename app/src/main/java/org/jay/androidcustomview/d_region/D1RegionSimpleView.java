package org.jay.androidcustomview.d_region;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class D1RegionSimpleView extends BaseView {

    private Paint paint;
    private int centerX;

    public D1RegionSimpleView(Context context) {
        this(context, null);
    }

    public D1RegionSimpleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public D1RegionSimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#484848"));
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = (int) dp2px(40);
        int top = (int) dp2px(20);

        // 正方形
        Rect rect = new Rect(centerX - width, top, centerX + width, top + width * 2);

        // 区域
        Region region = new Region(rect);

        // 绘制区域
        drawRegion(canvas, region, paint);

    }

}
