package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;

public class B8ResetPathView extends View {

    public B8ResetPathView(Context context) {
        super(context);
    }

    public B8ResetPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public B8ResetPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public B8ResetPathView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        // 填充外部区域
        Path path = new Path();
        path.setFillType(Path.FillType.INVERSE_WINDING);
        path.addCircle(100, 100, 50, Path.Direction.CW);
        canvas.drawPath(path, paint);


        // 清空并重绘
        path.reset();
        path.addCircle(300, 100, 50, Path.Direction.CW);
        path.moveTo(300, 100);
        canvas.drawPath(path, paint);

        // 重置并重绘
        path.rewind();
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        path.addRect(new RectF(400, 50, 450, 100), Path.Direction.CCW);
        // canvas.drawPath(path ,paint);

        path.rewind();
        // path.moveTo(500, 50);
        canvas.drawPath(path, paint);

    }

}
