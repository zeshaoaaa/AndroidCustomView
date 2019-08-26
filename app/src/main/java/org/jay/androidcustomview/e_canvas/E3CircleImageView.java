package org.jay.androidcustomview.e_canvas;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import org.jay.androidcustomview.BaseView;
import org.jay.androidcustomview.R;

import static org.jay.androidcustomview.ViewUtils.cropAndScale;

public class E3CircleImageView extends BaseView {

    private Bitmap bitmap;
    private Paint bitmapPaint;
    private Path path;
    private Paint rectPaint;
    private int pathLeftOffset;
    private float pathTopOffset;
    private float bitmapWidth;
    private int width;
    private Canvas mCanvas;

    public E3CircleImageView(Context context) {
        this(context, null);
    }

    public E3CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public E3CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        // 禁用硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        initBitmap();

        initBitmapPaint();

        initRectPaint();

        initPath();

    }

    private void initRectPaint() {
        rectPaint = new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setColor(Color.DKGRAY);
    }

    private void initBitmapPaint() {
        bitmapPaint = new Paint();
        bitmapPaint.setAntiAlias(true);
        // bitmapPaint.setFilterBitmap(true);
    }

    private void initPath() {
        float w = bitmap.getWidth();
        float h = bitmap.getHeight();

        path = new Path();
        pathLeftOffset = (int) dp2px(60);
        pathTopOffset = dp2px(30);

        float x = w / 2 + pathLeftOffset;
        float y = h / 2 + pathTopOffset;
        path.addCircle(x, y, w / 2, Path.Direction.CCW);
    }

    private void initBitmap() {
        // 裁剪并缩放
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
        bitmapWidth = dp2px(110);
        bitmap = cropAndScale(bitmap, bitmapWidth, bitmapWidth);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        saveAndClip(canvas);
        canvas.drawBitmap(bitmap, pathLeftOffset, pathTopOffset, bitmapPaint);
        drawRect(canvas);
    }

    private void saveAndClip(Canvas canvas) {
        canvas.save();
        canvas.clipPath(path);
    }

    private void drawRect(Canvas canvas) {
        canvas.restore();
        int left = (int) dp2px(220);
        int top = (int) dp2px(50);
        int width = (int) dp2px(80);
        Rect rect = new Rect(left, top, left + width, top + width);
        canvas.drawRect(rect, rectPaint);
    }


}
