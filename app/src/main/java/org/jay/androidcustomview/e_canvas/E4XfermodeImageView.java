package org.jay.androidcustomview.e_canvas;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;
import org.jay.androidcustomview.R;

import static org.jay.androidcustomview.ViewUtils.cropAndScale;

public class E4XfermodeImageView extends BaseView {

    private Bitmap originBitmap;
    private Paint bitmapPaint;
    private float bitmapWidth;
    private Canvas mCanvas;
    private float maxWidth;
    private Paint xferPaint;
    private PorterDuffXfermode mode;

    public E4XfermodeImageView(Context context) {
        this(context, null);
    }

    public E4XfermodeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public E4XfermodeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        // 禁用硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        initBitmap();

        initBitmapPaint();
        initXferPaint();

        maxWidth = dp2px(200);

        mode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    }

    private void initXferPaint() {
        xferPaint = new Paint();
        xferPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasureSize(widthMeasureSpec);
        int height = getMeasureSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int getMeasureSize(int measureSpec) {
        int result;
        int specSize = MeasureSpec.getSize(measureSpec);
        int specMode = MeasureSpec.getMode(measureSpec);
        if (specMode == MeasureSpec.AT_MOST) {
            result = (int) maxWidth;
        } else {
            result = specSize;
        }
        return result;
    }

    private void initBitmapPaint() {
        bitmapPaint = new Paint();
    }

    private void initBitmap() {
        // 裁剪并缩放
        originBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
        bitmapWidth = dp2px(110);
        originBitmap = cropAndScale(originBitmap, bitmapWidth, bitmapWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int bitmapW = (int) bitmapWidth;

        // 1. 源范围
        Rect src = new Rect(0, 0, bitmapW, bitmapW);

        // 2. 目标范围
        Rect dst = new Rect(0, 0, bitmapW, bitmapW);

        // 3. 空白图片
        Bitmap outputBitmap = Bitmap.createBitmap(bitmapW, bitmapW, Bitmap.Config.ARGB_8888);

        // 4. 原图画板
        mCanvas = new Canvas(outputBitmap);

        // 5. 绘制圆形
        int radius = bitmapW / 2;
        mCanvas.drawRoundRect(new RectF(dst), radius, radius, xferPaint);

        // 6. 设置模式
        xferPaint.setXfermode(mode);

        // 7. 进行混合
        mCanvas.drawBitmap(originBitmap, src, dst, xferPaint);

        // 8. 绘制图片
        canvas.drawBitmap(outputBitmap, 0, 0, bitmapPaint);

        // 9. 清除模式
        xferPaint.setXfermode(null);

    }

}
