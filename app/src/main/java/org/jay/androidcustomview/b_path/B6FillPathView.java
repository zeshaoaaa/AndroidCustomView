package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import org.jay.androidcustomview.BaseView;

// 填充路径
public class B6FillPathView extends BaseView {

    public B6FillPathView(Context context) {
        super(context);
    }

    public B6FillPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public B6FillPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 填充路径内部
        drawPath(canvas, Path.FillType.WINDING, 80, 30);

        // 填充路径外部
        drawPath(canvas, Path.FillType.INVERSE_WINDING, 200, 30);

        // 填充路径相交区域
        drawPath(canvas, Path.FillType.EVEN_ODD, 80, 150);

        // 填充路径外部与相交区域
        drawPath(canvas, Path.FillType.INVERSE_EVEN_ODD, 200, 150);

    }

    private void drawPath(Canvas canvas, Path.FillType fillType,
                          float left, float top) {

        left = dp2px(left);
        top = dp2px(top);

        clipPath(left, top, canvas);

        // 画笔
        Paint paint = getPaint();

        // 路径
        Path path = new Path();

        // 添加矩形
        path.addRect(getRect(left, top), Path.Direction.CW);

        // 添加圆
        addCircle(path, left, top);

        // 设置填充类型
        path.setFillType(fillType);

        // 绘制路径
        canvas.drawPath(path, paint);

        canvas.restore();

    }

    private void clipPath(float left, float top, Canvas canvas) {
        canvas.save();
        Path rectPath = new Path();
        left -= dp2px(1);
        top -= dp2px(1);
        float right = left + dp2px(70);
        float bottom = top + dp2px(70);
        rectPath.addRect(left, top, right, bottom, Path.Direction.CCW);
        canvas.clipPath(rectPath);
    }

    private RectF getRect(float left, float top) {
        float right = left + dp2px(40);
        float bottom = top + dp2px(40);
        return new RectF(left, top, right, bottom);
    }

    private void addCircle(Path path, float left, float top) {
        float x = left + dp2px(40);
        float y = top + dp2px(40);
        float radius = dp2px(25);
        path.addCircle(x, y, radius, Path.Direction.CW);
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        return paint;
    }


}
