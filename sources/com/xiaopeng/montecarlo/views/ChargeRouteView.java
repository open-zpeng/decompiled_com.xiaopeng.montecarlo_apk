package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryResult;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ChargeRouteView extends XView implements XpThemeSwitchReceiver.ThemeSwitchListener {
    private static final L.Tag TAG = new L.Tag("ROUTE_CHARGE_CRouteView");
    private Bitmap mAddChargeNormal;
    private int mAddChargeNormalResId;
    private Bitmap mAddChargeSelect;
    private int mAddChargeSelectResId;
    private int mBasicColor;
    private int mBasicColorResId;
    private int mBasicOuterColor;
    private int mBasicOuterColorResId;
    private Rect mCanvasRect;
    private Bitmap mCarIcon;
    private int mCarIconResId;
    private int mChargeEnduranceColor;
    private int mChargeEnduranceColorResId;
    private List<ChargePoint> mChargePoints;
    private int mCurrentEnduranceColor;
    private int mCurrentEnduranceColorResId;
    private ChargePoint mCurrentFocus;
    private Bitmap mEndIcon;
    private int mEndIconResId;
    private double mEnduranceDistance;
    private int mHeight;
    private int mIconBottom;
    private double mLeftRouteDistance;
    private int mOuterThicker;
    private Paint mPaint;
    private Bitmap mPassChargeNormal;
    private int mPassChargeNormalResId;
    private Bitmap mPassChargeSelect;
    private int mPassChargeSelectResId;
    private double mPathK;
    private Bitmap mReachableChargeNormal;
    private int mReachableChargeNormalResId;
    private Bitmap mReachableChargeSelect;
    private int mReachableChargeSelectResId;
    private int mRoundPx;
    private int mRoundPy;
    private double mTotalRouteDistance;
    private Bitmap mUnReachableChargeNormal;
    private int mUnReachableChargeNormalResId;
    private Bitmap mUnReachableChargeSelect;
    private int mUnReachableChargeSelectResId;
    private int mWidth;

    public ChargeRouteView(Context context) {
        super(context);
        this.mTotalRouteDistance = 0.0d;
        this.mLeftRouteDistance = 0.0d;
        this.mEnduranceDistance = 0.0d;
        this.mPathK = 1.0d;
        this.mBasicColor = 0;
        this.mBasicOuterColor = 0;
        this.mCurrentEnduranceColor = 0;
        this.mChargeEnduranceColor = 0;
        this.mWidth = 0;
        this.mHeight = 0;
    }

    public ChargeRouteView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalRouteDistance = 0.0d;
        this.mLeftRouteDistance = 0.0d;
        this.mEnduranceDistance = 0.0d;
        this.mPathK = 1.0d;
        this.mBasicColor = 0;
        this.mBasicOuterColor = 0;
        this.mCurrentEnduranceColor = 0;
        this.mChargeEnduranceColor = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ChargeRouteView, 0, 0);
        if (obtainStyledAttributes != null) {
            try {
                try {
                    this.mBasicColorResId = obtainStyledAttributes.getResourceId(3, 0);
                    this.mBasicOuterColorResId = obtainStyledAttributes.getResourceId(4, 0);
                    this.mCurrentEnduranceColorResId = obtainStyledAttributes.getResourceId(10, 0);
                    this.mChargeEnduranceColorResId = obtainStyledAttributes.getResourceId(0, 0);
                    this.mWidth = (int) obtainStyledAttributes.getDimension(9, 947.0f);
                    this.mHeight = (int) obtainStyledAttributes.getDimension(7, 16.0f);
                    this.mCarIconResId = obtainStyledAttributes.getResourceId(5, 0);
                    this.mEndIconResId = obtainStyledAttributes.getResourceId(6, 0);
                    this.mReachableChargeNormalResId = obtainStyledAttributes.getResourceId(13, 0);
                    this.mReachableChargeSelectResId = obtainStyledAttributes.getResourceId(14, 0);
                    this.mUnReachableChargeNormalResId = obtainStyledAttributes.getResourceId(15, 0);
                    this.mUnReachableChargeSelectResId = obtainStyledAttributes.getResourceId(16, 0);
                    this.mAddChargeNormalResId = obtainStyledAttributes.getResourceId(1, 0);
                    this.mAddChargeSelectResId = obtainStyledAttributes.getResourceId(2, 0);
                    this.mPassChargeNormalResId = obtainStyledAttributes.getResourceId(11, 0);
                    this.mPassChargeSelectResId = obtainStyledAttributes.getResourceId(12, 0);
                    this.mIconBottom = (int) obtainStyledAttributes.getDimension(8, 0.0f);
                    updateTheme();
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
        this.mCanvasRect = new Rect();
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setAntiAlias(true);
        int i = this.mHeight;
        this.mRoundPx = i / 2;
        this.mRoundPy = i / 2;
        this.mChargePoints = new LinkedList();
        this.mOuterThicker = getResources().getDimensionPixelSize(R.dimen.route_charge_bar_outer);
    }

    public List<ChargePoint> getChargePoints() {
        return this.mChargePoints;
    }

    public void addCharge(ChargePoint chargePoint) {
        this.mChargePoints.add(chargePoint);
        this.mCurrentFocus = chargePoint;
        invalidate();
    }

    public void addCharge(int i, ChargePoint chargePoint) {
        this.mChargePoints.add(i, chargePoint);
        invalidate();
    }

    public void removeCharges(List<String> list) {
        Iterator<ChargePoint> it = this.mChargePoints.iterator();
        while (it.hasNext()) {
            ChargePoint next = it.next();
            Iterator<String> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (it2.next().equals(next.mPoiId)) {
                    it.remove();
                    break;
                }
            }
        }
        this.mCurrentFocus = null;
        invalidate();
    }

    public void removeCharge(ChargePoint chargePoint) {
        if (this.mChargePoints.contains(chargePoint)) {
            this.mChargePoints.remove(chargePoint);
            invalidate();
        }
    }

    public void removeCharge(int i) {
        if (i >= this.mChargePoints.size() || i < 0) {
            return;
        }
        this.mChargePoints.remove(i);
        invalidate();
    }

    public void removeAllCharge() {
        this.mCurrentFocus = null;
        if (!this.mChargePoints.isEmpty()) {
            this.mChargePoints.clear();
        }
        invalidate();
    }

    public void clearAndUpdateCharges(List<ChargePoint> list) {
        removeAllCharge();
        this.mChargePoints.addAll(list);
        invalidate();
    }

    public void setSelect(ChargePoint chargePoint) {
        this.mCurrentFocus = chargePoint;
        invalidate();
    }

    public void setChargePointStatus(String str, int i) {
        for (ChargePoint chargePoint : this.mChargePoints) {
            if (chargePoint != null && str.equals(chargePoint.mPoiId)) {
                chargePoint.mChargePointState = i;
                invalidate();
                return;
            }
        }
    }

    public void updateRouteDistance(double d, double d2, double d3, double d4) {
        L.Tag tag = TAG;
        L.i(tag, "updateRouteDistance totalRouteDis=" + d + " leftRouteDis=" + d2 + " carRemainDis=" + d3 + " pathK: " + d4);
        this.mTotalRouteDistance = d;
        this.mLeftRouteDistance = d2;
        this.mEnduranceDistance = d3;
        this.mPathK = d4;
        invalidate();
    }

    public void setK(double d) {
        this.mPathK = d;
        L.Tag tag = TAG;
        L.i(tag, "set pathK: " + d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.mWidth;
        int i2 = this.mHeight;
        int measuredWidth = (getMeasuredWidth() - this.mWidth) / 2;
        int i3 = measuredWidth + i;
        int paddingTop = getPaddingTop();
        int i4 = i2 + paddingTop;
        this.mCanvasRect.set(measuredWidth, paddingTop, i3, i4);
        drawBasicRound(canvas, this.mPaint, this.mCanvasRect);
        double d = this.mTotalRouteDistance;
        if (d != 0.0d) {
            double d2 = this.mLeftRouteDistance;
            if (d2 != 0.0d) {
                double d3 = i;
                int i5 = ((int) (((d - d2) / d) * d3)) + measuredWidth;
                int i6 = ((int) (((this.mEnduranceDistance / this.mPathK) / d) * d3)) + i5;
                if (i6 > i3) {
                    i6 = i3;
                }
                this.mPaint.setColor(this.mCurrentEnduranceColor);
                this.mCanvasRect.set(i5, paddingTop, i6, i4);
                if (this.mCanvasRect.left > this.mRoundPx + measuredWidth) {
                    canvas.drawRect(this.mCanvasRect, this.mPaint);
                } else {
                    drawLeftRound(canvas, this.mPaint, this.mCanvasRect);
                }
                drawChargePoints(canvas, this.mCanvasRect.right, i, paddingTop, i4, measuredWidth, i3);
                this.mPaint.setColor(-1);
                drawEndIcon(canvas, this.mPaint, i2, i, i3, paddingTop);
                drawCarIcon(canvas, this.mPaint, i5, i, i2, paddingTop);
                super.onDraw(canvas);
                return;
            }
        }
        if (L.ENABLE) {
            L.d(TAG, "onDraw total:" + this.mTotalRouteDistance + "  left:" + this.mLeftRouteDistance);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this);
    }

    private void drawBasicRound(Canvas canvas, Paint paint, Rect rect) {
        paint.setColor(this.mBasicOuterColor);
        RectF rectF = new RectF(rect);
        rectF.left -= this.mOuterThicker;
        rectF.right += this.mOuterThicker;
        rectF.top -= this.mOuterThicker;
        rectF.bottom += this.mOuterThicker;
        canvas.drawRoundRect(rectF, this.mRoundPx, this.mRoundPy, paint);
        paint.setColor(this.mBasicColor);
        canvas.drawRoundRect(new RectF(rect), this.mRoundPx, this.mRoundPy, paint);
    }

    private void drawLeftRound(Canvas canvas, Paint paint, Rect rect) {
        canvas.drawRoundRect(new RectF(rect), this.mRoundPx, this.mRoundPy, paint);
    }

    private void drawRightRound(Canvas canvas, Paint paint, Rect rect) {
        canvas.drawRoundRect(new RectF(rect), this.mRoundPx, this.mRoundPy, paint);
        canvas.drawRect(new RectF(rect.left, 0.0f, rect.left + this.mRoundPx, this.mRoundPy), paint);
        canvas.drawRect(new RectF(rect.left, rect.height() - this.mRoundPy, rect.left + this.mRoundPx, rect.height()), paint);
    }

    private void drawCarIcon(Canvas canvas, Paint paint, int i, int i2, int i3, int i4) {
        Bitmap bitmap = this.mCarIcon;
        if (bitmap != null) {
            float width = i - (bitmap.getWidth() / 2.0f);
            float width2 = i2 - (this.mCarIcon.getWidth() / 2.0f);
            if (width > width2) {
                width = width2;
            }
            canvas.drawBitmap(this.mCarIcon, width, i4 + ((i3 - this.mCarIcon.getHeight()) / 2.0f), paint);
        }
    }

    private void drawEndIcon(Canvas canvas, Paint paint, int i, int i2, int i3, int i4) {
        Bitmap bitmap = this.mEndIcon;
        if (bitmap != null) {
            canvas.drawBitmap(this.mEndIcon, i3 - (bitmap.getWidth() / 2.0f), i4 + ((i - this.mEndIcon.getHeight()) / 2.0f), paint);
        }
    }

    private void drawChargePoints(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6) {
        this.mCanvasRect.set(i, i3, i, i4);
        int i7 = i - i5;
        boolean z = false;
        for (ChargePoint chargePoint : this.mChargePoints) {
            i7 = calculateChargeBarEnd(chargePoint, i7, i2, i3, i4, i5, i6);
            ChargePoint chargePoint2 = this.mCurrentFocus;
            if (chargePoint2 != null && chargePoint2.getPoiId().equals(chargePoint.getPoiId())) {
                z = true;
            }
        }
        int i8 = i7 + i5;
        if (i8 > this.mCanvasRect.right) {
            this.mCanvasRect.right = Math.min(i6, i8);
            this.mPaint.setColor(this.mChargeEnduranceColor);
            RectF rectF = new RectF(this.mCanvasRect);
            float f = rectF.left;
            int i9 = this.mRoundPx;
            rectF.left = f - (i9 * 2);
            if (i8 < i6) {
                canvas.drawRoundRect(rectF, i9, this.mRoundPy, this.mPaint);
            } else {
                canvas.drawRect(rectF, this.mPaint);
            }
        }
        for (ChargePoint chargePoint3 : this.mChargePoints) {
            drawChargePoint(chargePoint3, canvas, i2, i5, i6, i3);
        }
        ChargePoint chargePoint4 = this.mCurrentFocus;
        if (chargePoint4 == null || z) {
            return;
        }
        drawChargePoint(chargePoint4, canvas, i2, i5, i6, i3);
    }

    private int calculateChargeBarEnd(ChargePoint chargePoint, int i, int i2, int i3, int i4, int i5, int i6) {
        if (chargePoint == null || 2 != chargePoint.mChargePointState) {
            return i;
        }
        double d = i2;
        int maxRemainAfterCharge = i + (((int) (((RouteChargeHelper.getMaxRemainAfterCharge() / this.mPathK) / this.mTotalRouteDistance) * d)) - (i - ((int) ((chargePoint.mChargePointRouteDistance / this.mTotalRouteDistance) * d))));
        if (maxRemainAfterCharge > i2) {
            maxRemainAfterCharge = i2;
        }
        return Math.max(i, maxRemainAfterCharge);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawChargePoint(com.xiaopeng.montecarlo.views.ChargeRouteView.ChargePoint r8, android.graphics.Canvas r9, int r10, int r11, int r12, int r13) {
        /*
            r7 = this;
            com.xiaopeng.montecarlo.views.ChargeRouteView$ChargePoint r0 = r7.mCurrentFocus
            r1 = 1
            if (r0 == 0) goto L13
            java.lang.String r0 = r0.getPoiId()
            java.lang.String r2 = r8.mPoiId
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L13
            r0 = r1
            goto L14
        L13:
            r0 = 0
        L14:
            r2 = 0
            int r3 = r8.mChargePointState
            r4 = 2
            if (r3 == 0) goto L3b
            if (r3 == r1) goto L33
            if (r3 == r4) goto L2b
            r1 = 3
            if (r3 == r1) goto L22
            goto L43
        L22:
            if (r0 == 0) goto L27
            android.graphics.Bitmap r0 = r7.mPassChargeSelect
            goto L29
        L27:
            android.graphics.Bitmap r0 = r7.mPassChargeNormal
        L29:
            r2 = r0
            goto L43
        L2b:
            if (r0 == 0) goto L30
            android.graphics.Bitmap r0 = r7.mAddChargeSelect
            goto L29
        L30:
            android.graphics.Bitmap r0 = r7.mAddChargeNormal
            goto L29
        L33:
            if (r0 == 0) goto L38
            android.graphics.Bitmap r0 = r7.mUnReachableChargeSelect
            goto L29
        L38:
            android.graphics.Bitmap r0 = r7.mUnReachableChargeNormal
            goto L29
        L3b:
            if (r0 == 0) goto L40
            android.graphics.Bitmap r0 = r7.mReachableChargeSelect
            goto L29
        L40:
            android.graphics.Bitmap r0 = r7.mReachableChargeNormal
            goto L29
        L43:
            if (r2 == 0) goto L75
            float r11 = (float) r11
            double r0 = r8.mChargePointRouteDistance
            double r5 = r7.mTotalRouteDistance
            double r0 = r0 / r5
            double r5 = (double) r10
            double r0 = r0 * r5
            int r8 = r2.getWidth()
            int r8 = r8 / r4
            double r3 = (double) r8
            double r0 = r0 - r3
            float r8 = (float) r0
            float r11 = r11 + r8
            float r8 = (float) r12
            int r8 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r8 <= 0) goto L61
            int r8 = r2.getWidth()
            int r12 = r12 - r8
            float r11 = (float) r12
        L61:
            int r8 = r2.getHeight()
            int r13 = r13 - r8
            int r8 = r7.mIconBottom
            int r13 = r13 - r8
            float r8 = (float) r13
            android.graphics.Paint r10 = r7.mPaint
            r12 = -1
            r10.setColor(r12)
            android.graphics.Paint r10 = r7.mPaint
            r9.drawBitmap(r2, r11, r8, r10)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.ChargeRouteView.drawChargePoint(com.xiaopeng.montecarlo.views.ChargeRouteView$ChargePoint, android.graphics.Canvas, int, int, int, int):void");
    }

    private void updateBitmap(final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7, final int i8, final int i9, final int i10) {
        BitmapFactoryXP.decodeResourceAsync(ContextUtils.getContext().getResources(), new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.views.ChargeRouteView.1
            @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
            public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                    L.w(ChargeRouteView.TAG, "result.mBitmap error");
                    return;
                }
                int i11 = bitmapFactoryResult.mResid;
                Bitmap bitmap = bitmapFactoryResult.mBitmap;
                if (i11 == i) {
                    if (ChargeRouteView.this.mCarIcon != null && !ChargeRouteView.this.mCarIcon.isRecycled()) {
                        ChargeRouteView.this.mCarIcon.recycle();
                    }
                    ChargeRouteView.this.mCarIcon = bitmap;
                }
                if (i11 == i2) {
                    if (ChargeRouteView.this.mEndIcon != null && !ChargeRouteView.this.mEndIcon.isRecycled()) {
                        ChargeRouteView.this.mEndIcon.recycle();
                    }
                    ChargeRouteView.this.mEndIcon = bitmap;
                }
                if (i11 == i3) {
                    if (ChargeRouteView.this.mReachableChargeNormal != null && !ChargeRouteView.this.mReachableChargeNormal.isRecycled()) {
                        ChargeRouteView.this.mReachableChargeNormal.recycle();
                    }
                    ChargeRouteView.this.mReachableChargeNormal = bitmap;
                }
                if (i11 == i4) {
                    if (ChargeRouteView.this.mReachableChargeSelect != null && !ChargeRouteView.this.mReachableChargeSelect.isRecycled()) {
                        ChargeRouteView.this.mReachableChargeSelect.recycle();
                    }
                    ChargeRouteView.this.mReachableChargeSelect = bitmap;
                }
                if (i11 == i5) {
                    if (ChargeRouteView.this.mUnReachableChargeNormal != null && !ChargeRouteView.this.mUnReachableChargeNormal.isRecycled()) {
                        ChargeRouteView.this.mUnReachableChargeNormal.recycle();
                    }
                    ChargeRouteView.this.mUnReachableChargeNormal = bitmap;
                }
                if (i11 == i6) {
                    if (ChargeRouteView.this.mUnReachableChargeSelect != null && !ChargeRouteView.this.mUnReachableChargeSelect.isRecycled()) {
                        ChargeRouteView.this.mUnReachableChargeSelect.recycle();
                    }
                    ChargeRouteView.this.mUnReachableChargeSelect = bitmap;
                }
                if (i11 == i7) {
                    if (ChargeRouteView.this.mAddChargeNormal != null && !ChargeRouteView.this.mAddChargeNormal.isRecycled()) {
                        ChargeRouteView.this.mAddChargeNormal.recycle();
                    }
                    ChargeRouteView.this.mAddChargeNormal = bitmap;
                }
                if (i11 == i8) {
                    if (ChargeRouteView.this.mAddChargeSelect != null && !ChargeRouteView.this.mAddChargeSelect.isRecycled()) {
                        ChargeRouteView.this.mAddChargeSelect.recycle();
                    }
                    ChargeRouteView.this.mAddChargeSelect = bitmap;
                }
                if (i11 == i9) {
                    if (ChargeRouteView.this.mPassChargeNormal != null && !ChargeRouteView.this.mPassChargeNormal.isRecycled()) {
                        ChargeRouteView.this.mPassChargeNormal.recycle();
                    }
                    ChargeRouteView.this.mPassChargeNormal = bitmap;
                }
                if (i11 == i10) {
                    if (ChargeRouteView.this.mPassChargeSelect != null && !ChargeRouteView.this.mPassChargeSelect.isRecycled()) {
                        ChargeRouteView.this.mPassChargeSelect.recycle();
                    }
                    ChargeRouteView.this.mPassChargeSelect = bitmap;
                }
            }

            @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
            public void onComplete() {
                ChargeRouteView.this.invalidate();
            }
        }, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSelectChargesNum() {
        return this.mChargePoints.size();
    }

    @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        L.Tag tag = TAG;
        L.i(tag, ">>> onThemeSwitch theme =" + i);
        updateTheme();
    }

    private void updateTheme() {
        this.mBasicColor = ThemeWatcherUtil.getColor(this.mBasicColorResId);
        this.mBasicOuterColor = ThemeWatcherUtil.getColor(this.mBasicOuterColorResId);
        this.mCurrentEnduranceColor = ThemeWatcherUtil.getColor(this.mCurrentEnduranceColorResId);
        this.mChargeEnduranceColor = ThemeWatcherUtil.getColor(this.mChargeEnduranceColorResId);
        updateBitmap(ThemeWatcherUtil.getDrawableResId(this.mCarIconResId), ThemeWatcherUtil.getDrawableResId(this.mEndIconResId), ThemeWatcherUtil.getDrawableResId(this.mReachableChargeNormalResId), ThemeWatcherUtil.getDrawableResId(this.mReachableChargeSelectResId), ThemeWatcherUtil.getDrawableResId(this.mUnReachableChargeNormalResId), ThemeWatcherUtil.getDrawableResId(this.mUnReachableChargeSelectResId), ThemeWatcherUtil.getDrawableResId(this.mAddChargeNormalResId), ThemeWatcherUtil.getDrawableResId(this.mAddChargeSelectResId), ThemeWatcherUtil.getDrawableResId(this.mPassChargeNormalResId), ThemeWatcherUtil.getDrawableResId(this.mPassChargeSelectResId));
    }

    public double getCarRemainDistance() {
        return this.mEnduranceDistance;
    }

    /* loaded from: classes3.dex */
    public static class ChargePoint {
        public static final int CHARGE_POINT_ADD = 2;
        public static final int CHARGE_POINT_PASSED = 3;
        public static final int CHARGE_POINT_REACHABLE = 0;
        public static final int CHARGE_POINT_UNREACHABLE = 1;
        public double mChargePointRouteDistance;
        public int mChargePointState;
        public boolean mIsSelected;
        public String mPoiId;

        protected boolean canEqual(Object obj) {
            return obj instanceof ChargePoint;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChargePoint) {
                ChargePoint chargePoint = (ChargePoint) obj;
                if (chargePoint.canEqual(this) && isSelected() == chargePoint.isSelected() && getChargePointState() == chargePoint.getChargePointState() && Double.compare(getChargePointRouteDistance(), chargePoint.getChargePointRouteDistance()) == 0) {
                    String poiId = getPoiId();
                    String poiId2 = chargePoint.getPoiId();
                    return poiId != null ? poiId.equals(poiId2) : poiId2 == null;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int chargePointState = (((isSelected() ? 79 : 97) + 59) * 59) + getChargePointState();
            long doubleToLongBits = Double.doubleToLongBits(getChargePointRouteDistance());
            int i = (chargePointState * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
            String poiId = getPoiId();
            return (i * 59) + (poiId == null ? 43 : poiId.hashCode());
        }

        public void setChargePointRouteDistance(double d) {
            this.mChargePointRouteDistance = d;
        }

        public void setChargePointState(int i) {
            this.mChargePointState = i;
        }

        public void setPoiId(String str) {
            this.mPoiId = str;
        }

        public void setSelected(boolean z) {
            this.mIsSelected = z;
        }

        public String toString() {
            return "ChargeRouteView.ChargePoint(mPoiId=" + getPoiId() + ", mIsSelected=" + isSelected() + ", mChargePointState=" + getChargePointState() + ", mChargePointRouteDistance=" + getChargePointRouteDistance() + ")";
        }

        public String getPoiId() {
            return this.mPoiId;
        }

        public boolean isSelected() {
            return this.mIsSelected;
        }

        public int getChargePointState() {
            return this.mChargePointState;
        }

        public double getChargePointRouteDistance() {
            return this.mChargePointRouteDistance;
        }
    }
}
