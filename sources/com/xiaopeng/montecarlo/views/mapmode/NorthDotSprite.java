package com.xiaopeng.montecarlo.views.mapmode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes3.dex */
public class NorthDotSprite extends Sprite {
    private static L.Tag sTAG = new L.Tag("DrawingThread_NDS");
    private int mColor;
    private boolean mIsNightMode;
    private String mNorthStr;
    private RectF mOvalNorthUp;
    private float[] mRS;
    private float[] mRXZ;
    private float mRotateDZ;
    private float mRotateX;
    private float mRotateZ;
    private float mScale;
    private RectF mScaleRectF;
    private int mTextColor;
    private Paint mTextPaint;
    private float mUsedRotateX;
    private float mUsedRotateZ;
    private float mUsedScale;
    private int mX;
    private int mY;

    public NorthDotSprite(int i, int i2, RectF rectF, String str) {
        super(i, i2);
        this.mRotateZ = 0.0f;
        this.mRotateDZ = 3.0f;
        this.mUsedRotateZ = 0.0f;
        this.mRotateX = 0.0f;
        this.mUsedRotateX = 0.0f;
        this.mScale = 1.0f;
        this.mUsedScale = 1.0f;
        this.mRS = new float[4];
        this.mRXZ = new float[9];
        this.mScaleRectF = new RectF();
        this.mNorthStr = "N";
        this.mOvalNorthUp = rectF;
        this.mNorthStr = str;
        this.mColor = ThemeWatcherUtil.getColor(R.color.icon_map_north);
        this.mTextColor = ThemeWatcherUtil.getColor(R.color.icon_map_north_text);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(3.0f);
        this.mTextPaint = new Paint();
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTextSize(ContextUtils.getDimensionPixelSize(R.dimen.map_mode_button_north_text_size));
        this.mTextPaint.setAntiAlias(true);
        float measureText = this.mTextPaint.measureText(this.mNorthStr);
        float f = this.mTextPaint.getFontMetrics().descent;
        float f2 = this.mTextPaint.getFontMetrics().ascent;
        float abs = Math.abs(f2) + f;
        this.mX = (int) ((((rectF.right - rectF.left) - measureText) / 2.0f) + rectF.left + 0.5d);
        this.mY = (int) ((((rectF.bottom - rectF.top) - abs) / 2.0f) + rectF.top + Math.abs(f2) + 0.5d);
        float[] fArr = this.mRS;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 1.0f;
        float[] fArr2 = this.mRXZ;
        fArr2[0] = 1.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 1.0f;
        fArr2[5] = 0.0f;
        fArr2[6] = 0.0f;
        fArr2[7] = 0.0f;
        fArr2[8] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNightMode(boolean z) {
        if (this.mIsNightMode != z) {
            this.mIsNightMode = z;
            this.mColor = ThemeWatcherUtil.getColor(R.color.icon_map_north);
            this.mPaint.setColor(this.mColor);
            this.mTextColor = ThemeWatcherUtil.getColor(R.color.icon_map_north_text);
            this.mTextPaint.setColor(this.mTextColor);
            addFlag(1);
        }
    }

    public void setState(int[] iArr) {
        if (iArr == null) {
            return;
        }
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (16842919 == iArr[i]) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        this.mColor = ThemeWatcherUtil.getColor(z ? R.color.icon_map_north_pressed : R.color.icon_map_north);
        this.mPaint.setColor(this.mColor);
        this.mTextColor = ThemeWatcherUtil.getColor(z ? R.color.icon_map_north_text_pressed : R.color.icon_map_north_text);
        this.mTextPaint.setColor(this.mTextColor);
        addFlag(1);
    }

    public void setRotateZ(float f) {
        this.mRotateDZ = Math.abs(f - this.mUsedRotateZ) % 360.0f;
        this.mRotateZ = f;
        addFlag(1);
    }

    private void setScale(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.mScale != f) {
            this.mScale = f;
        }
    }

    private RectF getScaleRectF(RectF rectF) {
        float f = rectF.left + ((rectF.right - rectF.left) / 2.0f);
        float f2 = rectF.top + ((rectF.bottom - rectF.top) / 2.0f);
        float f3 = rectF.left - f;
        float f4 = rectF.top - f2;
        RectF rectF2 = this.mScaleRectF;
        float[] fArr = this.mRS;
        rectF2.left = (fArr[0] * f3) + (fArr[1] * f4) + f;
        rectF2.top = (f3 * fArr[2]) + (f4 * fArr[3]) + f2;
        float f5 = rectF.right - f;
        float f6 = rectF.bottom - f2;
        RectF rectF3 = this.mScaleRectF;
        float[] fArr2 = this.mRS;
        rectF3.right = (fArr2[0] * f5) + (fArr2[1] * f6) + f;
        rectF3.bottom = (f5 * fArr2[2]) + (f6 * fArr2[3]) + f2;
        return rectF3;
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void preDraw() {
        if (getDrawModeType() == DrawModeType.HEADUP_3D) {
            this.mRotateX = 45.0f;
        } else {
            this.mRotateX = 0.0f;
        }
        setScale(1.0f);
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void onDraw(Canvas canvas) {
        float f;
        float cos = (float) Math.cos((this.mUsedRotateX * 3.141592653589793d) / 180.0d);
        float sin = (float) Math.sin((this.mUsedRotateX * 3.141592653589793d) / 180.0d);
        float cos2 = (float) Math.cos((this.mUsedRotateZ * 3.141592653589793d) / 180.0d);
        float sin2 = (float) Math.sin((this.mUsedRotateZ * 3.141592653589793d) / 180.0d);
        float[] fArr = this.mRXZ;
        fArr[0] = -cos2;
        fArr[1] = sin2;
        fArr[2] = 0.0f;
        fArr[3] = sin2 * cos;
        fArr[4] = cos * cos2;
        fArr[5] = -sin;
        fArr[6] = sin2 * sin;
        fArr[7] = sin * cos2;
        fArr[8] = cos;
        RectF scaleRectF = getScaleRectF(this.mOvalNorthUp);
        float f2 = this.mDrawingWidth / 2;
        float width = (scaleRectF.left + (scaleRectF.width() / 2.0f)) - f2;
        float f3 = this.mDrawingHeight / 2;
        float height = (scaleRectF.top + (scaleRectF.height() / 2.0f)) - f3;
        float[] fArr2 = this.mRXZ;
        float f4 = (fArr2[0] * width) + (fArr2[1] * height) + f2;
        float f5 = (width * fArr2[3]) + (height * fArr2[4]) + f3;
        float height2 = f5 - (scaleRectF.height() / 2.0f);
        float width2 = f4 - (scaleRectF.width() / 2.0f);
        float width3 = f4 + (scaleRectF.width() / 2.0f);
        scaleRectF.top = height2;
        scaleRectF.left = width2;
        scaleRectF.right = width3;
        scaleRectF.bottom = f5 + (scaleRectF.height() / 2.0f);
        canvas.drawArc(scaleRectF, 0.0f, 360.0f, true, this.mPaint);
        float measureText = this.mTextPaint.measureText(this.mNorthStr);
        float abs = Math.abs(this.mTextPaint.getFontMetrics().ascent) + this.mTextPaint.getFontMetrics().descent;
        this.mX = (int) (((scaleRectF.width() - measureText) / 2.0f) + scaleRectF.left + 0.5d);
        this.mY = (int) (((scaleRectF.height() - abs) / 2.0f) + scaleRectF.top + Math.abs(f) + 0.5d);
        if (this.mUsedScale > 0.9d) {
            canvas.drawText(this.mNorthStr, this.mX, this.mY, this.mTextPaint);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void postDraw() {
        float f = this.mRotateZ;
        if (f != this.mUsedRotateZ) {
            this.mUsedRotateZ = f;
            addFlag(1);
        }
        float f2 = this.mScale;
        float f3 = this.mUsedScale;
        if (f2 != f3) {
            float f4 = f2 - f3;
            float abs = Math.abs(f4);
            if (abs < 0.05d) {
                this.mUsedScale = this.mScale;
            } else {
                this.mUsedScale = (float) (this.mUsedScale + ((abs / f4) * 0.05d));
            }
            float[] fArr = this.mRS;
            float f5 = this.mUsedScale;
            fArr[0] = f5;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = f5;
            addFlag(1);
        }
        float f6 = this.mRotateX;
        if (f6 != this.mUsedRotateX) {
            this.mUsedRotateX = f6;
            addFlag(1);
        }
    }
}
