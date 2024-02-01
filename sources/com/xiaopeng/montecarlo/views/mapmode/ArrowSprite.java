package com.xiaopeng.montecarlo.views.mapmode;

import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes3.dex */
public class ArrowSprite extends Sprite {
    private static L.Tag sTAG = new L.Tag("DrawingThread_AS");
    private final float mArrowScale;
    private final int mHeight;
    private boolean mIsNightMode;
    private boolean mIsPressed;
    private float mRotateDZ;
    private float mRotateX;
    private float mRotateZ;
    private Simple3DModel mSimple3DModel;
    private float mUsedRotateX;
    private float mUsedRotateZ;
    private final int mWidth;

    public ArrowSprite(int i, int i2) {
        super(i, i2);
        this.mRotateZ = 0.0f;
        this.mRotateDZ = 3.0f;
        this.mUsedRotateZ = 0.0f;
        this.mRotateX = 0.0f;
        this.mUsedRotateX = 0.0f;
        this.mWidth = i;
        this.mHeight = i2;
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mArrowScale = ContextUtils.getDimensionPixelSize(R.dimen.map_mode_button_arrow_size) / 28.0f;
        this.mPaint.setMaskFilter(new EmbossMaskFilter(new float[]{45.0f, 45.0f, 45.0f}, 0.6f, 16.0f, 0.1f));
        this.mSimple3DModel = new Simple3DModel();
        createModel();
    }

    private void createModel() {
        int i = this.mWidth / 2;
        int i2 = this.mHeight / 2;
        XYZPoint xYZPoint = new XYZPoint(i, i2 - 14, 0);
        int i3 = i2 + 10;
        XYZPoint xYZPoint2 = new XYZPoint(i - 14, i3, 0);
        XYZPoint xYZPoint3 = new XYZPoint(i, i2 + 5, 5);
        XYZPoint xYZPoint4 = new XYZPoint(i, i2 + 8, 0);
        XYZPoint xYZPoint5 = new XYZPoint(i + 14, i3, 0);
        this.mSimple3DModel.clear();
        this.mSimple3DModel.add(new Triangle(xYZPoint, xYZPoint2, xYZPoint3, ThemeWatcherUtil.getColor(this.mIsPressed ? R.color.icon_map_arrow_left_pressed : R.color.icon_map_arrow_left)));
        int color = ThemeWatcherUtil.getColor(this.mIsPressed ? R.color.icon_map_arrow_bottom_pressed : R.color.icon_map_arrow_bottom);
        this.mSimple3DModel.add(new Triangle(xYZPoint2, xYZPoint3, xYZPoint4, color));
        this.mSimple3DModel.add(new Triangle(xYZPoint3, xYZPoint4, xYZPoint5, color));
        this.mSimple3DModel.add(new Triangle(xYZPoint, xYZPoint3, xYZPoint5, ThemeWatcherUtil.getColor(this.mIsPressed ? R.color.icon_map_arrow_right_pressed : R.color.icon_map_arrow_right)));
    }

    public void setRotateZ(float f) {
        this.mRotateDZ = Math.abs(f - this.mUsedRotateZ) % 360.0f;
        this.mRotateZ = f;
        addFlag(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNightMode(boolean z) {
        if (this.mIsNightMode != z) {
            this.mIsNightMode = z;
            createModel();
            addFlag(1);
        }
    }

    public void setState(int[] iArr) {
        if (iArr == null) {
            return;
        }
        int i = 0;
        this.mIsPressed = false;
        int length = iArr.length;
        while (true) {
            if (i >= length) {
                break;
            } else if (16842919 == iArr[i]) {
                this.mIsPressed = true;
                break;
            } else {
                i++;
            }
        }
        createModel();
        addFlag(1);
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void preDraw() {
        if (getDrawModeType() == DrawModeType.HEADUP_3D) {
            this.mRotateZ = 0.0f;
            this.mRotateX = -20.0f;
        } else if (DrawModeType.HEADUP_2D == getDrawModeType()) {
            this.mRotateZ = 0.0f;
            this.mRotateX = 0.0f;
        } else {
            this.mRotateX = 0.0f;
        }
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void onDraw(Canvas canvas) {
        doMatrix(canvas, 0.0f, 0.0f, -this.mUsedRotateZ);
        this.mSimple3DModel.setRotateX(this.mUsedRotateX);
        canvas.save();
        float f = this.mArrowScale;
        canvas.scale(f, f, this.mWidth / 2.0f, this.mHeight / 2.0f);
        this.mSimple3DModel.draw(canvas, this.mPaint);
        canvas.restore();
    }

    @Override // com.xiaopeng.montecarlo.views.mapmode.Sprite
    void postDraw() {
        float f = this.mRotateZ;
        float f2 = this.mUsedRotateZ;
        if (f != f2) {
            float f3 = f - f2;
            float abs = Math.abs(f3) % 360.0f;
            if (abs <= 180.0f) {
                float f4 = this.mRotateDZ;
                if (abs < f4) {
                    this.mUsedRotateZ = this.mRotateZ;
                } else {
                    this.mUsedRotateZ += (abs / f3) * f4;
                }
            } else {
                float f5 = this.mRotateDZ;
                if (360.0f - abs < f5) {
                    this.mUsedRotateZ = this.mRotateZ;
                } else {
                    this.mUsedRotateZ -= (abs / f3) * f5;
                }
            }
            addFlag(1);
        }
        float f6 = this.mRotateX;
        if (f6 != this.mUsedRotateX) {
            this.mUsedRotateX = f6;
            addFlag(1);
        }
    }
}
