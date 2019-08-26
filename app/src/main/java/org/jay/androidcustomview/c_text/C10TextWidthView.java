package org.jay.androidcustomview.c_text;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class C10TextWidthView extends BaseView {

    private Paint paint;
    private int centerX;
    private final String content = "自定义";

    public C10TextWidthView(Context context) {
        this(context, null);
    }

    public C10TextWidthView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C10TextWidthView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(30));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int top = (int) dp2px(40);
        canvas.drawText(content, centerX, top, paint);

        // 文字宽度
        int textWidth = (int) paint.measureText(content);

        // 绘制直线
        top = (int) (top +  dp2px(20));
        Paint linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(5);
        linePaint.setColor(Color.DKGRAY);
        int startX = centerX - textWidth / 2;
        canvas.drawLine(startX, top, startX + textWidth , top, linePaint);

    }

}
