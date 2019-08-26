package org.jay.androidcustomview.c_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class C11TextBoundsView extends BaseView {

    private Paint txtPaint;
    private int centerX;
    private final String content = "自定义";

    public C11TextBoundsView(Context context) {
        this(context, null);
    }

    public C11TextBoundsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C11TextBoundsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        txtPaint = new Paint();
        txtPaint.setColor(Color.DKGRAY);
        txtPaint.setAntiAlias(true);
        txtPaint.setTextSize(sp2px(35));
        txtPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 绘制文字
        int top = (int) dp2px(60);
        canvas.drawText(content, centerX, top, txtPaint);

        // 文字宽高
        Rect bounds = new Rect();
        txtPaint.getTextBounds(content, 0, content.length(), bounds);

        // 绘制矩形
        int leftOffset = (int) (centerX - bounds.width() / 2 - dp2px(4));
        bounds.left += leftOffset;
        bounds.right += leftOffset;
        bounds.top += top;
        bounds.bottom += top;
        Paint rectPaint = new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setStrokeWidth(5);
        rectPaint.setColor(Color.DKGRAY);
        canvas.drawRect(bounds, rectPaint);

    }

}
