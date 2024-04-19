package com.xiaopeng.montecarlo.views.mapmode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes3.dex */
public class CircleSprite extends Sprite {
    private static L.Tag sTAG = new L.Tag("DrawingThread_CS");
    private final Bitmap mBitmap;
    private final Canvas mCanvas;
    private final Paint mCleanPaint;
    private int mColor;
    private boolean mIsNightMode;
    private Paint mOutPaint;
    private final RectF mOval;
    private float mRotateX;
    private float mStrokeWidth;
    private final RectF mTmpRectF;
    private float mUsedRotateX;

    public CircleSprite(int i, int i2, float f, RectF rectF) {
        super(i, i2);
        this.mTmpRectF = new RectF();
        this.mRotateX = 0.0f;
        this.mUsedRotateX = 0.0f;
        this.mColor = ThemeWatcherUtil.getColor(R.color.icon_map_circle);
        this.mOutPaint = new Paint();
        this.mOutPaint.setAntiAlias(true);
        this.mOutPaint.setFilterBitmap(true);
        this.mOval = rectF;
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mStrokeWidth = f;
        this.mCleanPaint = new Paint();
        this.mCleanPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mCleanPaint.setStyle(Paint.Style.FILL);
        this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas();
        this.mCanvas.setBitmap(this.mBitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNightMode(boolean z) {
        if (this.mIsNightMode != z) {
            this.mIsNightMode = z;
            this.mColor = ThemeWatcherUtil.getColor(R.color.icon_map_circle);
            this.mPaint.setColor(this.mColor);
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
        this.mColor = ThemeWatcherUtil.getColor(z ? R.color.icon_map_circle_pressed : R.color.icon_map_circle);
        this.mPaint.setColor(this.mColor);
        addFlag(1);
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void preDraw() {
        if (getDrawModeType() == DrawModeType.HEADUP_3D) {
            this.mRotateX = 45.0f;
        } else {
            this.mRotateX = 0.0f;
        }
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void onDraw(Canvas canvas) {
        this.mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.mUsedRotateX == 0.0f) {
            this.mPaint.setStrokeWidth(this.mStrokeWidth);
            doMatrix(this.mCanvas, 0.0f, 0.0f, 0.0f);
            this.mCanvas.drawArc(this.mOval, 0.0f, 360.0f, false, this.mPaint);
        } else {
            this.mPaint.setStrokeWidth(this.mStrokeWidth);
            doMatrix(this.mCanvas, this.mUsedRotateX, 0.0f, 0.0f);
            float f = (this.mUsedRotateX / 45.0f) * 8.0f;
            for (float f2 = 0.0f; f2 <= f; f2 += 1.0f) {
                this.mTmpRectF.set(this.mOval);
                this.mTmpRectF.top += f2;
                this.mTmpRectF.bottom += f2;
                this.mCanvas.drawArc(this.mTmpRectF, 0.0f, 360.0f, false, this.mPaint);
            }
            this.mCleanPaint.setStrokeWidth(this.mStrokeWidth);
            this.mCanvas.drawArc(this.mOval, 0.0f, 360.0f, true, this.mCleanPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mStrokeWidth);
            this.mCanvas.drawArc(this.mOval, 0.0f, 360.0f, false, this.mPaint);
        }
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mOutPaint);
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void postDraw() {
        float f = this.mRotateX;
        if (f != this.mUsedRotateX) {
            this.mUsedRotateX = f;
            addFlag(1);
        }
    }
}
