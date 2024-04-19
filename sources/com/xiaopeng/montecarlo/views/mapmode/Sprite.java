package com.xiaopeng.montecarlo.views.mapmode;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class Sprite {
    public static final int MASK_NEED_DRAW = 1;
    protected final Camera mCamera;
    protected final int mDrawingHeight;
    private DrawingThread mDrawingThread;
    protected final int mDrawingWidth;
    protected final Matrix mMatrix;
    private ThreadLocal<DrawModeType> mDrawModeType = new ThreadLocal<DrawModeType>() { // from class: com.xiaopeng.montecarlo.views.mapmode.Sprite.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public DrawModeType initialValue() {
            return DrawModeType.NORTHUP;
        }
    };
    private ThreadLocal<Integer> mFlag = new ThreadLocal<Integer>() { // from class: com.xiaopeng.montecarlo.views.mapmode.Sprite.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return 1;
        }
    };
    protected final Paint mPaint = new Paint();

    abstract void onDraw(Canvas canvas);

    abstract void postDraw();

    abstract void preDraw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sprite(int i, int i2) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        this.mMatrix = new Matrix();
        this.mCamera = new Camera();
        this.mDrawingWidth = i;
        this.mDrawingHeight = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void draw(Canvas canvas, DrawModeType drawModeType) {
        this.mDrawModeType.set(drawModeType);
        draw(canvas);
    }

    final void draw(Canvas canvas) {
        preDraw();
        postDraw();
        onDraw(canvas);
        clearFlag(1);
    }

    int getFlag() {
        return this.mFlag.get().intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawModeType getDrawModeType() {
        return this.mDrawModeType.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addFlag(int i) {
        this.mFlag.set(Integer.valueOf(i | this.mFlag.get().intValue()));
    }

    protected void clearFlag(int i) {
        this.mFlag.set(Integer.valueOf((~i) & this.mFlag.get().intValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDrawingThread(DrawingThread drawingThread) {
        this.mDrawingThread = drawingThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void doMatrix(Canvas canvas, float f, float f2, float f3) {
        if (0.0f == f && 0.0f == f2 && 0.0f == f3) {
            canvas.setMatrix(null);
        }
        this.mCamera.save();
        this.mCamera.rotateX(f);
        this.mCamera.rotateY(f2);
        this.mCamera.rotateZ(f3);
        this.mCamera.getMatrix(this.mMatrix);
        this.mCamera.restore();
        this.mMatrix.preTranslate((-this.mDrawingWidth) / 2, (-this.mDrawingHeight) / 2);
        this.mMatrix.postTranslate(this.mDrawingWidth / 2, this.mDrawingHeight / 2);
        canvas.setMatrix(this.mMatrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDrawEnd() {
        if ((this.mFlag.get().intValue() & 1) == 1) {
            this.mDrawingThread.requestDraw();
        }
    }
}
