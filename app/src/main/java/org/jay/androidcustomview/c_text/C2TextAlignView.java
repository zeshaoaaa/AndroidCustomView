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

public class C2TextAlignView extends BaseView {

    private int centerX;

    public C2TextAlignView(Context context) {
        super(context);
    }

    public C2TextAlignView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C2TextAlignView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 参考线
        drawLine(canvas);

        // 默认左对齐
        drawText(canvas, null, dp2px(30));

        // 居中
        drawText(canvas, Paint.Align.CENTER, dp2px(70));

        // 右对齐
        drawText(canvas, Paint.Align.RIGHT , dp2px(110));

    }

    private void drawText(Canvas canvas, Paint.Align align, float top) {

        // 创建画笔
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);

        // 文字大小
        paint.setTextSize(sp2px(30));

        // 文字样式
        if (align != null) paint.setTextAlign(align);

        // 绘制文字
        canvas.drawText("自定义", centerX, top, paint);

    }

    private void drawLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        canvas.drawLine(centerX, 0, centerX, dp2px(120), paint);
    }

}
