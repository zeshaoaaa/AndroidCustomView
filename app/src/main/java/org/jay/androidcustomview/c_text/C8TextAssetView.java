package org.jay.androidcustomview.c_text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;

public class C8TextAssetView extends BaseView {

    private int centerX;
    private Paint normalPaint;
    private final String txt = "Custom";
    private final String assetPath = "fonts/KOMIKAX_.ttf";
    private AssetManager manager;
    private Paint customPaint;
    private int width;

    public C8TextAssetView(Context context) {
        this(context, null);
    }

    public C8TextAssetView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C8TextAssetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        manager = getResources().getAssets();
        normalPaint = getGrayPaint(false);
        customPaint = getGrayPaint(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        float y = dp2px(50);

        // 正常字体
        float txtWidth = normalPaint.measureText(txt);
        float x = dp2px(40) + txtWidth / 2;
        canvas.drawText(txt, x, y, normalPaint);

        // 自定义字体
        txtWidth = customPaint.measureText(txt);
        x = width - dp2px(40) - txtWidth / 2;
        canvas.drawText(txt, x, y, customPaint);

    }

    private Paint getGrayPaint(boolean custom) {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(60);
        if (custom) {
            paint.setTypeface(Typeface.createFromAsset(manager, assetPath));
        }
        return paint;
    }

}
