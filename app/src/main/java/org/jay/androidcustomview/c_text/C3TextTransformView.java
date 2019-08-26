package org.jay.androidcustomview.c_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import org.jay.androidcustomview.BaseView;

public class C3TextTransformView extends BaseView {

    private final String txt = "自定义";
    private int width;
    private int centerX;

    public C3TextTransformView(Context context) {
        super(context);
    }

    public C3TextTransformView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C3TextTransformView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = getGrayPaint();
        float txtWidth = paint.measureText(txt);

        // 正常字体
        float x = dp2px(30);
        float y = dp2px(60);
        canvas.drawText(txt, x, y, paint);

        // 倾斜
        paint.setTextSkewX(-0.25f);
        x = (float) (centerX - txtWidth / 1.4);
        canvas.drawText(txt, x, y, paint);

        // 拉伸
        paint = getGrayPaint();
        paint.setTextScaleX(1.5f);
        txtWidth = paint.measureText(txt);
        x = width - txtWidth - dp2px(30);
        canvas.drawText(txt, x, y, paint);

    }

    private Paint getGrayPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(25));
        return paint;
    }

}
