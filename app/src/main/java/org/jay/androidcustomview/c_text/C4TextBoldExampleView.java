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

public class C4TextBoldExampleView extends BaseView {

    private int width;
    private int centerX;
    private final String txt = "自定义";

    public C4TextBoldExampleView(Context context) {
        super(context);
    }

    public C4TextBoldExampleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public C4TextBoldExampleView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        // 红色画笔
        Paint paint = getRedPaint();
        float txtWidth = paint.measureText(txt);

        float y = dp2px(60);
        float x = dp2px(30);

        // 正常字体
        canvas.drawText(txt, x, y, paint);

        // 粗体
        paint.setFakeBoldText(true);
        x = (float) (centerX - txtWidth * 1.2);
        canvas.drawText(txt, x, y, paint);

        // 下划线
        paint = getRedPaint();
        paint.setUnderlineText(true);
        x = centerX + txtWidth / 6f;
        canvas.drawText(txt, x, y, paint);

        // 删除线
        paint = getRedPaint();
        paint.setStrikeThruText(true);
        x = width - dp2px(30) - txtWidth;
        canvas.drawText(txt, x, y, paint);

    }

    private Paint getRedPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(20));
        return paint;
    }

}
