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

public class C7TextFaceView extends BaseView {

    private int centerX;
    private Paint paint;
    private final String enTxt = "Custom";
    private final String zhTxt = "自定义";
    private int width;

    public C7TextFaceView(Context context) {
        this(context, null);
    }

    public C7TextFaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C7TextFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = getGrayPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float txtWidth = paint.measureText(enTxt);
        float padding = dp2px(40);
        float y = dp2px(30);
        float zhY = dp2px(60);

        // sans serif
        float x = padding + txtWidth / 2;
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("sans serif", x, y, paint);
        canvas.drawText(zhTxt, x, zhY, paint);

        // serif
        paint.setTypeface(Typeface.SERIF);
        canvas.drawText("serif", centerX, y, paint);
        canvas.drawText(zhTxt, centerX, zhY, paint);

        // monospace
        x = width - padding - txtWidth / 2;
        paint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("monospace", x, y, paint);
        canvas.drawText(zhTxt, x, zhY, paint);

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
