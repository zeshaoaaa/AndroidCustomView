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

public class C5TextPosView extends BaseView {

    private int centerX;

    public C5TextPosView(Context context) {
        super(context);
    }

    public C5TextPosView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C5TextPosView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 画笔
        Paint paint = getGrayPaint();

        float x = centerX;

        // 每个文字的位置
        float position[] = {
                centerX, dp2px(20),
                centerX, dp2px(50),
                centerX, dp2px(80)
        };

        // 绘制文字
        canvas.drawPosText("自定义", position, paint);

    }

    private Paint getGrayPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(20));
        return paint;
    }

}
