package org.jay.androidcustomview.c_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import org.jay.androidcustomview.BaseView;

public class C9TextFaceStyleView extends BaseView {

    private Paint paint;
    private int centerX;

    public C9TextFaceStyleView(Context context) {
        this(context, null);
    }

    public C9TextFaceStyleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C9TextFaceStyleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(20));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float y = dp2px(50);
        float offset = dp2px(40);

        // 正常字体
        float x = centerX - offset * 3;
        drawText(canvas, -1, x, y);

        // 粗体
        x = centerX - offset;
        drawText(canvas, Typeface.BOLD, x, y);

        // 斜体
        x = centerX + offset;
        drawText(canvas, Typeface.ITALIC, x, y);

        // 粗斜体
        x = centerX + offset * 3;
        drawText(canvas, Typeface.BOLD_ITALIC, x, y);

    }

    private void drawText(Canvas canvas, int style,
                          float x, float y) {

        // 样式
        if (style != -1) {
            paint.setTypeface(Typeface.defaultFromStyle(style));
        }

        // 绘制
        canvas.drawText("自定义", x, y, paint);

    }

}
