package pl.droidsonroids.gif.transforms;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class CornerRadiusTransform implements Transform {
    private float mCornerRadius;
    private final RectF mDstRectF = new RectF();
    private Shader mShader;

    public CornerRadiusTransform(@FloatRange(from = 0.0d) float f) {
        setCornerRadiusSafely(f);
    }

    public void setCornerRadius(@FloatRange(from = 0.0d) float f) {
        setCornerRadiusSafely(f);
    }

    private void setCornerRadiusSafely(@FloatRange(from = 0.0d) float f) {
        float max = Math.max(0.0f, f);
        if (max != this.mCornerRadius) {
            this.mCornerRadius = max;
            this.mShader = null;
        }
    }

    @FloatRange(from = 0.0d)
    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    @NonNull
    public RectF getBounds() {
        return this.mDstRectF;
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void onBoundsChange(Rect rect) {
        this.mDstRectF.set(rect);
        this.mShader = null;
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void onDraw(Canvas canvas, Paint paint, Bitmap bitmap) {
        if (this.mCornerRadius == 0.0f) {
            canvas.drawBitmap(bitmap, (Rect) null, this.mDstRectF, paint);
            return;
        }
        if (this.mShader == null) {
            this.mShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setTranslate(this.mDstRectF.left, this.mDstRectF.top);
            matrix.preScale(this.mDstRectF.width() / bitmap.getWidth(), this.mDstRectF.height() / bitmap.getHeight());
            this.mShader.setLocalMatrix(matrix);
        }
        paint.setShader(this.mShader);
        RectF rectF = this.mDstRectF;
        float f = this.mCornerRadius;
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
