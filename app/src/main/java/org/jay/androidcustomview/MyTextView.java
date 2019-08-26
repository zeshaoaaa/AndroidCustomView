package org.jay.androidcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;

import static org.jay.androidcustomview.ViewUtils.dp2px;
import static org.jay.androidcustomview.ViewUtils.sp2px;

public class MyTextView extends View {

    private Paint textPaint, linePaint;
    private String text = "";
    private int x, y;
    private int width;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initTextPaint(context);
        initLinePaint();
        initContent(context,attrs);


    }

    private void initContent(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        if (typedArray != null) {
            String text = typedArray.getString(R.styleable.MyTextView_text);
            if (text != null) {
                this.text = text;
            }
        }
    }

    private void initLinePaint() {
        linePaint = new Paint();
        linePaint.setStrokeWidth(2);
        linePaint.setAntiAlias(true);
        linePaint.setColor(getResources().getColor(android.R.color.darker_gray));
    }

    private void initTextPaint(Context context) {
        textPaint = new Paint();
        textPaint.setColor(Color.parseColor("#d8d8d8"));
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        float fontSize = sp2px(context, 15);
        textPaint.setTextSize(fontSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getMeasureSize(widthMeasureSpec);
        int height = getMeasureSize(heightMeasureSpec);

        this.width = width;
        x = width / 2;

        height = (int) dp2px(this, 50);

        y = height / 2;
        setMeasuredDimension(width, height);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawText(text, x, y, textPaint);

        float y = dp2px(getContext(), 40);
        canvas.drawLine(0, y,width, y, linePaint);

    }

    private int getMeasureSize(int spec) {
        // 测量模式
        int specMode = MeasureSpec.getMode(spec);

        // 尺寸
        int specSize = MeasureSpec.getSize(spec);

        // 实际尺寸
        int size;

        // 显示指定控件大小
        if (specMode == MeasureSpec.EXACTLY) {
            size = specSize;
        } else {
            size = (int) dp2px(getContext(), 40);
            if (specMode == MeasureSpec.UNSPECIFIED) {
                size = Math.min(size, specSize);
            }
        }
        return size;
    }

}
