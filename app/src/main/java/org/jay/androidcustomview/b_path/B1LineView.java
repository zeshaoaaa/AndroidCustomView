package org.jay.androidcustomview.b_path;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import org.jay.androidcustomview.BaseView;

import static org.jay.androidcustomview.ViewUtils.dp2px;

public class B1LineView extends BaseView {

    public B1LineView(Context context) {
        super(context);
    }

    public B1LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public B1LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = getPaint();

        // 创建路径
        Path path = new Path();

        // 改变起点
        float x1 = dp2px(80);
        float y1 = dp2px(30);
        path.moveTo(x1, y1);

        // 第一条线
        float x2 = dp2px(250);
        float y2 = dp2px(80);
        path.lineTo(x2, y2);

        // 第二条线
        path.lineTo(x1, y2);

        // 第三条线
        path.close();

        canvas.drawPath(path, paint);

    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#484848"));
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

}
