package org.jay.androidcustomview;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public abstract class BaseView extends View {

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float dp2px(float dp) {
        return ViewUtils.dp2px(this, dp);
    }

    public float sp2px(float sp) {
        return ViewUtils.sp2px(this, sp);
    }

    public void drawRegion(Canvas canvas, Region region, Paint paint) {

        RegionIterator iterator = new RegionIterator(region);

        Rect r = new Rect();

        // 遍历矩形中的子矩形区域
        while (iterator.next(r)) {
            canvas.drawRect(r, paint);
        }

    }

}
