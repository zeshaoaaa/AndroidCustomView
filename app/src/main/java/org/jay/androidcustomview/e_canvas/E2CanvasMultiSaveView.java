package org.jay.androidcustomview.e_canvas;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class E2CanvasMultiSaveView extends BaseView {

    private int centerX;

    public E2CanvasMultiSaveView(Context context) {
        super(context);
    }

    public E2CanvasMultiSaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public E2CanvasMultiSaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 灰色全屏
        canvas.drawColor(Color.DKGRAY);
        int storeCount = canvas.save();

        // 左边
        drawRects(canvas, (int) dp2px(90));
        canvas.restoreToCount(storeCount);

        // 右边
        drawRects(canvas, (int) -dp2px(90));

        // 两次出栈
        canvas.restore();
        canvas.restore();
        canvas.drawColor(Color.YELLOW);

    }

    private void drawRects(Canvas canvas, int offset) {
        int left;
        int width;

        // 绿色 150
        int top = (int) dp2px(30);
        width  = (int) dp2px(150);
        left = centerX - width / 2 - offset;
        canvas.clipRect(new Rect(left, top, left + width, top + width));
        canvas.drawColor(Color.GREEN);
        canvas.save();

        // 蓝色 120
        width  = (int) dp2px(120);
        top = (int) dp2px(45);
        left = centerX - width / 2 - offset;
        canvas.clipRect(new Rect(left, top, left + width, top + width));
        canvas.drawColor(Color.BLUE);
        canvas.save();

        // 黑色 90
        width  = (int) dp2px(90);
        top = (int) dp2px(60);
        left = centerX - width / 2 - offset;
        canvas.clipRect(new Rect(left, top, left + width, top + width));
        canvas.drawColor(Color.BLACK);
        canvas.save();

        // 白色 60
        width  = (int) dp2px(60);
        top = (int) dp2px(75);
        left = centerX - width / 2 - offset;
        canvas.clipRect(new Rect(left, top, left + width, top + width));
        canvas.drawColor(Color.WHITE);
        canvas.save();

    }

}
