package com.xiaopeng.montecarlo.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class ImageUtil {
    public static Bitmap roundBitmapByShader(@NonNull Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap can't be null");
        }
        float f = i;
        Matrix matrix = new Matrix();
        matrix.setScale((f * 1.0f) / bitmap.getWidth(), (i2 * 1.0f) / bitmap.getHeight());
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        float f2 = i3;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f), f2, f2, paint);
        return createBitmap;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }
}
