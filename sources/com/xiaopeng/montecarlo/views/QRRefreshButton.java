package com.xiaopeng.montecarlo.views;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.util.MarkUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryResult;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
/* loaded from: classes3.dex */
public class QRRefreshButton extends XView {
    private static final L.Tag TAG = new L.Tag("QRRefreshButton");
    private ObjectAnimator mAnimator;
    private Bitmap mDayBgBitmap;
    private Bitmap mDayBitmap;
    @SerializedName("degress")
    private float mDegress;
    private boolean mIsDayMode;
    private Bitmap mNightBgBitmap;
    private Bitmap mNightBitmap;
    private Paint mPaint;

    public QRRefreshButton(Context context) {
        this(context, null);
    }

    public QRRefreshButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QRRefreshButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDayBitmap = null;
        this.mDayBgBitmap = null;
        this.mNightBitmap = null;
        this.mNightBgBitmap = null;
        this.mDegress = 0.0f;
        this.mPaint = new Paint(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRRefreshButton);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    initBitmap(obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(3, 0), obtainStyledAttributes.getResourceId(2, 0));
                } catch (Resources.NotFoundException | UnsupportedOperationException e) {
                    e.printStackTrace();
                }
            }
            this.mIsDayMode = ThemeWatcherUtil.isDayMode();
            this.mAnimator = ObjectAnimator.ofObject(this, "degress", new FloatEvaluator(), 0, Integer.valueOf((int) MarkUtils.MARKER_ID_BUBBLE_VIA_CHARGE));
            this.mAnimator.setDuration(2000L);
            this.mAnimator.setRepeatMode(1);
            this.mAnimator.setInterpolator(new LinearInterpolator());
            this.mAnimator.setRepeatCount(-1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void initBitmap(final int i, final int i2, final int i3, final int i4) {
        BitmapFactoryXP.decodeResourceAsync(getResources(), new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.views.QRRefreshButton.1
            @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
            public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                    L.w(QRRefreshButton.TAG, "result.mBitmap error");
                    return;
                }
                int i5 = bitmapFactoryResult.mResid;
                Bitmap bitmap = bitmapFactoryResult.mBitmap;
                if (i5 == i) {
                    QRRefreshButton.this.mDayBitmap = bitmap;
                    if (i == i3) {
                        if (QRRefreshButton.this.mNightBitmap != null && !QRRefreshButton.this.mNightBitmap.isRecycled()) {
                            QRRefreshButton.this.mNightBitmap.recycle();
                        }
                        QRRefreshButton.this.mNightBitmap = bitmap;
                    }
                } else if (i5 == i2) {
                    QRRefreshButton.this.mDayBgBitmap = bitmap;
                    if (i2 == i4) {
                        if (QRRefreshButton.this.mNightBgBitmap != null && !QRRefreshButton.this.mNightBgBitmap.isRecycled()) {
                            QRRefreshButton.this.mNightBgBitmap.recycle();
                        }
                        QRRefreshButton.this.mNightBgBitmap = bitmap;
                    }
                } else if (i5 == i3) {
                    QRRefreshButton.this.mNightBitmap = bitmap;
                } else if (i5 == i4) {
                    QRRefreshButton.this.mNightBgBitmap = bitmap;
                }
            }

            @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
            public void onComplete() {
                QRRefreshButton.this.invalidate();
            }
        }, i, i2, i3, i4);
    }

    public void updateDayMode(boolean z) {
        this.mIsDayMode = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Rect rect = new Rect();
        rect.top = 0;
        rect.bottom = getHeight();
        rect.left = 0;
        rect.right = getWidth();
        if (this.mIsDayMode) {
            Bitmap bitmap = this.mDayBgBitmap;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, this.mPaint);
            }
        } else {
            Bitmap bitmap2 = this.mNightBgBitmap;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (Rect) null, rect, this.mPaint);
            }
        }
        canvas.rotate(this.mDegress, getWidth() / 2, getHeight() / 2);
        if (this.mIsDayMode) {
            Bitmap bitmap3 = this.mDayBitmap;
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, (getWidth() - this.mDayBitmap.getWidth()) / 2, (getHeight() - this.mDayBitmap.getHeight()) / 2, this.mPaint);
            }
        } else {
            Bitmap bitmap4 = this.mNightBitmap;
            if (bitmap4 != null) {
                canvas.drawBitmap(bitmap4, (getWidth() - this.mNightBitmap.getWidth()) / 2, (getHeight() - this.mNightBitmap.getHeight()) / 2, this.mPaint);
            }
        }
        canvas.restore();
    }

    public void start() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public void stop() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setDegress(0.0f);
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public float getDegress() {
        return this.mDegress;
    }

    public void setDegress(float f) {
        this.mDegress = f;
        invalidate();
    }

    public void destroy() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.mAnimator.removeAllListeners();
            this.mAnimator = null;
        }
        Bitmap bitmap = this.mDayBgBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mDayBgBitmap.recycle();
            this.mDayBgBitmap = null;
        }
        Bitmap bitmap2 = this.mDayBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mDayBitmap.recycle();
            this.mDayBitmap = null;
        }
        Bitmap bitmap3 = this.mNightBgBitmap;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.mNightBgBitmap.recycle();
            this.mNightBgBitmap = null;
        }
        Bitmap bitmap4 = this.mNightBitmap;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            return;
        }
        this.mNightBitmap.recycle();
        this.mNightBitmap = null;
    }
}
