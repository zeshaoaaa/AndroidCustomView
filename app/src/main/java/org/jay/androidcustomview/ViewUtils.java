package org.jay.androidcustomview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;

public class ViewUtils {

    public static float dp2px(View view, float dp) {
        return dp2px(view.getContext(), dp);
    }

    public static float dp2px(Context context, float dp) {
        final float scaledDensity = context.getResources().getDisplayMetrics().density;
        return dp * scaledDensity + 0.5f;
    }

    public static float sp2px(View view, float sp) {
        return sp2px(view.getContext(), sp);
    }

    public static float sp2px(Context context, float sp) {
        final float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return sp * scaledDensity + 0.5f;
    }

    public static Bitmap cropAndScale(Bitmap origin, float newWidth, float newHeight) {
        if (origin == null) return null;

        origin = crop(origin);

        int height = origin.getHeight();
        int width = origin.getWidth();

        float scaleWidth = newWidth / width;
        float scaleHeight = newHeight / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap result = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return result;
    }

    private static Bitmap crop(Bitmap bitmap) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int cropWidth = Math.min(w, h);
        Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, cropWidth, cropWidth, null, false);
        return result;
    }


}



