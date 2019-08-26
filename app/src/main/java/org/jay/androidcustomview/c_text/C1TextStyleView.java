package org.jay.androidcustomview.c_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class C1TextStyleView extends BaseView {

    private int width;
    private int centerX;
    private final String txt = "自定义";
    private Paint mainPaint;
    private Paint namePaint;

    public C1TextStyleView(Context context) {
        this(context, null);
    }

    public C1TextStyleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C1TextStyleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mainPaint = getPaint();

        namePaint = getPaint();
        namePaint.setTextSize(sp2px(12));
        namePaint.setColor(Color.parseColor("#d8d8d8"));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float textWidth = mainPaint.measureText(txt);
        float offset = dp2px(20);

        // 默认填充
        float start = offset + textWidth / 2;
        drawText(canvas, Paint.Style.FILL, start);

        // 描边
        drawText(canvas, Paint.Style.STROKE, centerX);

        // 描边且填充
        start = width - textWidth / 2 - offset;
        drawText(canvas, Paint.Style.FILL_AND_STROKE, start);

    }

    private void drawText(Canvas canvas, Paint.Style style, float start) {

        // 文字样式
        if (style != null) {
            mainPaint.setStyle(style);
        }

        // 绘制文字
        float y = dp2px(60);
        canvas.drawText(txt, start, y, mainPaint);

        drawName(style, canvas, start);

    }

    private void drawName(Paint.Style style, Canvas canvas, float start) {
        Rect rect = new Rect();
        mainPaint.getTextBounds(txt, 0, txt.length(), rect);
        String styleName = "FILL";
        if (style != null) {
            switch (style) {
                case STROKE:
                    styleName = "STROKE";
                    break;
                case FILL_AND_STROKE:
                    styleName = "FILL_AND_STROKE";
                    break;
                default:
                    styleName = "FILL";
                    break;
            }
        }
        float x = start + (rect.right - rect.left) / 20f;
        canvas.drawText(styleName, x, dp2px(90), namePaint);
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(30));
        return paint;
    }

}
