package com.xiaopeng.montecarlo.views.mapmode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DrawingThread extends HandlerThread {
    private static final int FRAME_TIME = 50;
    private static final L.Tag TAG = new L.Tag("DrawingThread");
    private ArrowSprite mArrowSprite;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private float mCarDir;
    private CircleSprite mCircleSprite;
    private float mCircleStrokeWidth;
    private final Object mDrawLock;
    private int mDrawingHeight;
    private int mDrawingWidth;
    private boolean mIsNightMode;
    private boolean mIsPaused;
    private float mMapAngle;
    private MapViewWrapper mMapViewWrapper;
    private DrawModeType mMode;
    private ThreadLocal<Boolean> mNeedDraw;
    private NorthDotSprite mNorthDotSprite;
    private final int mNorthOvalRadius;
    private Bitmap mOutBitmap;
    private Paint mOutPaint;
    private final int mOvalHeight;
    private final int mOvalWidth;
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private DrawingHandler mReceiver;
    private final Rect mSurfaceRect;
    private int mUpdateMapStatusLoopCount;
    private View mView;

    static /* synthetic */ int access$1410(DrawingThread drawingThread) {
        int i = drawingThread.mUpdateMapStatusLoopCount;
        drawingThread.mUpdateMapStatusLoopCount = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawingThread(View view, int i, int i2, float f, MapViewWrapper mapViewWrapper, DrawModeType drawModeType, boolean z, boolean z2) {
        super("DrawingThread");
        this.mDrawLock = new Object();
        this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
        this.mUpdateMapStatusLoopCount = 0;
        this.mNeedDraw = new ThreadLocal<Boolean>() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Boolean initialValue() {
                return true;
            }
        };
        this.mView = view;
        this.mSurfaceRect = new Rect();
        this.mDrawingWidth = i;
        this.mDrawingHeight = i2;
        this.mCircleStrokeWidth = f;
        this.mMapViewWrapper = mapViewWrapper;
        this.mMode = drawModeType;
        this.mIsPaused = z;
        this.mIsNightMode = z2;
        this.mOvalWidth = ContextUtils.getDimensionPixelSize(R.dimen.map_mode_button_oval_width);
        this.mOvalHeight = ContextUtils.getDimensionPixelSize(R.dimen.map_mode_button_oval_height);
        this.mNorthOvalRadius = ContextUtils.getDimensionPixelSize(R.dimen.map_mode_button_north_oval_radius);
        this.mCanvas = new Canvas();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateMapStatusLoopCount(int i) {
        if (this.mUpdateMapStatusLoopCount <= 0) {
            this.mReceiver.sendEmptyMessageDelayed(2, 150L);
        }
        if (this.mUpdateMapStatusLoopCount < i) {
            this.mUpdateMapStatusLoopCount = i;
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.mReceiver = new DrawingHandler(getLooper());
        this.mReceiver.sendEmptyMessageDelayed(0, 50L);
    }

    public boolean draw(Canvas canvas) {
        synchronized (this.mDrawLock) {
            if (this.mDrawingWidth != 0 && this.mDrawingHeight != 0) {
                if (this.mOutBitmap == null || this.mOutBitmap.isRecycled()) {
                    return false;
                }
                canvas.drawBitmap(this.mOutBitmap, 0.0f, 0.0f, this.mOutPaint);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        int i;
        int i2 = this.mDrawingWidth;
        if (i2 == 0 || (i = this.mDrawingHeight) == 0) {
            return;
        }
        this.mSurfaceRect.set(0, 0, i2, i);
        RectF rectF = new RectF();
        rectF.left = (this.mDrawingWidth - this.mOvalWidth) / 2.0f;
        rectF.top = (this.mDrawingHeight - this.mOvalHeight) / 2.0f;
        rectF.right = rectF.left + this.mOvalWidth;
        rectF.bottom = rectF.top + this.mOvalHeight;
        RectF rectF2 = new RectF();
        rectF2.left = (this.mDrawingWidth / 2) - this.mNorthOvalRadius;
        rectF2.right = rectF2.left + (this.mNorthOvalRadius * 2);
        rectF2.top = rectF.top - this.mNorthOvalRadius;
        rectF2.bottom = rectF2.top + (this.mNorthOvalRadius * 2);
        this.mCircleSprite = new CircleSprite(this.mDrawingWidth, this.mDrawingHeight, this.mCircleStrokeWidth, rectF);
        this.mCircleSprite.setNightMode(this.mIsNightMode);
        this.mCircleSprite.setDrawingThread(this);
        this.mArrowSprite = new ArrowSprite(this.mDrawingWidth, this.mDrawingHeight);
        this.mArrowSprite.setNightMode(this.mIsNightMode);
        this.mArrowSprite.setDrawingThread(this);
        View view = this.mView;
        if (view != null) {
            this.mNorthDotSprite = new NorthDotSprite(this.mDrawingWidth, this.mDrawingHeight, rectF2, view.getResources().getString(R.string.north));
        }
        this.mNorthDotSprite.setNightMode(this.mIsNightMode);
        this.mNorthDotSprite.setDrawingThread(this);
        this.mBitmap = Bitmap.createBitmap(this.mDrawingWidth, this.mDrawingHeight, Bitmap.Config.ARGB_8888);
        this.mOutBitmap = Bitmap.createBitmap(this.mDrawingWidth, this.mDrawingHeight, Bitmap.Config.ARGB_8888);
        this.mOutPaint = new Paint();
        this.mOutPaint.setAntiAlias(true);
        this.mCanvas.setBitmap(this.mOutBitmap);
        drawBitmap();
        this.mCanvas.setBitmap(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestDraw() {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler != null) {
            drawingHandler.sendEmptyMessage(1);
        }
    }

    public void resetMapStatus() {
        resetMapStatus(1000L);
    }

    public void resetMapStatus(long j) {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler == null || drawingHandler.hasMessages(2)) {
            return;
        }
        this.mReceiver.sendEmptyMessageDelayed(2, j);
    }

    public void setMode(final DrawModeType drawModeType) {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler != null) {
            drawingHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.2
                @Override // java.lang.Runnable
                public void run() {
                    DrawModeType drawModeType2 = DrawingThread.this.mMode;
                    DrawModeType drawModeType3 = drawModeType;
                    if (drawModeType2 != drawModeType3) {
                        DrawingThread.this.mMode = drawModeType3;
                        DrawingThread.this.getMapStatus();
                        DrawingThread.this.setUpdateMapStatusLoopCount(5);
                        DrawingThread.this.requestDraw();
                    }
                }
            });
        }
    }

    public void setMapViewWrapper(final MapViewWrapper mapViewWrapper) {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler != null) {
            drawingHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.3
                @Override // java.lang.Runnable
                public void run() {
                    DrawingThread.this.mMapViewWrapper = mapViewWrapper;
                }
            });
        }
    }

    public void setNightMode(final boolean z) {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler == null || this.mDrawingWidth == 0 || this.mDrawingHeight == 0) {
            return;
        }
        drawingHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.4
            @Override // java.lang.Runnable
            public void run() {
                DrawingThread.this.mCircleSprite.setNightMode(z);
                DrawingThread.this.mArrowSprite.setNightMode(z);
                DrawingThread.this.requestDraw();
            }
        });
    }

    public void setState(final int[] iArr) {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler == null || this.mDrawingWidth == 0 || this.mDrawingHeight == 0) {
            return;
        }
        drawingHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.5
            @Override // java.lang.Runnable
            public void run() {
                DrawingThread.this.mCircleSprite.setState(iArr);
                DrawingThread.this.mArrowSprite.setState(iArr);
                DrawingThread.this.mNorthDotSprite.setState(iArr);
                DrawingThread.this.requestDraw();
            }
        });
    }

    public void setPaused(final boolean z) {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler != null) {
            drawingHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.6
                @Override // java.lang.Runnable
                public void run() {
                    boolean z2 = DrawingThread.this.mIsPaused;
                    boolean z3 = z;
                    if (z2 != z3) {
                        DrawingThread.this.mIsPaused = z3;
                        DrawingThread.this.requestDraw();
                    }
                }
            });
        }
    }

    public void updateSize(final int i, final int i2) {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler != null) {
            drawingHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.7
                @Override // java.lang.Runnable
                public void run() {
                    if (DrawingThread.this.mDrawingHeight == i2 && DrawingThread.this.mDrawingWidth == i) {
                        return;
                    }
                    DrawingThread.this.mDrawingWidth = i;
                    DrawingThread.this.mDrawingHeight = i2;
                    DrawingThread.this.init();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getMapStatus() {
        if (this.mDrawingWidth == 0 || this.mDrawingHeight == 0) {
            return false;
        }
        float mapAngle = this.mMapViewWrapper.getMapAngle();
        CarLoc carLocation = this.mMode == DrawModeType.NORTHUP ? this.mMapViewWrapper.getBizControlManager().getCarLocation() : null;
        float f = 0.0f;
        if (carLocation != null && carLocation.vecPathMatchInfo != null && carLocation.vecPathMatchInfo.size() > 0) {
            f = carLocation.vecPathMatchInfo.get(0).carDir;
        }
        if (isNeedUpdate(this.mMapAngle, mapAngle) || isNeedUpdate(this.mCarDir, f)) {
            this.mMapAngle = mapAngle;
            this.mCarDir = f;
            this.mArrowSprite.setRotateZ(this.mCarDir);
            this.mNorthDotSprite.setRotateZ(this.mMapAngle);
            requestDraw();
            return true;
        }
        return false;
    }

    private boolean isNeedUpdate(float f, float f2) {
        return Math.abs(f - f2) > 5.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableDrawRun() {
        this.mNeedDraw.set(true);
        if (this.mIsPaused) {
            return;
        }
        if (this.mReceiver.hasMessages(0)) {
            this.mReceiver.sendEmptyMessageDelayed(0, 50L);
        } else {
            this.mReceiver.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runDraw() {
        Bitmap bitmap;
        if (this.mDrawingWidth == 0 || this.mDrawingHeight == 0 || this.mIsPaused) {
            return;
        }
        if (this.mSurfaceRect.width() == 0 || this.mSurfaceRect.height() == 0) {
            this.mReceiver.sendEmptyMessageDelayed(0, 50L);
            return;
        }
        View view = this.mView;
        if (view != null && !view.isAttachedToWindow()) {
            this.mReceiver.sendEmptyMessageDelayed(0, 500L);
            return;
        }
        if (this.mNeedDraw.get().booleanValue()) {
            synchronized (this.mDrawLock) {
                bitmap = this.mBitmap;
            }
            this.mCanvas.setBitmap(bitmap);
            drawBitmap();
            synchronized (this.mDrawLock) {
                Bitmap bitmap2 = this.mOutBitmap;
                this.mOutBitmap = this.mBitmap;
                this.mBitmap = bitmap2;
            }
            this.mNeedDraw.set(false);
        }
        View view2 = this.mView;
        if (view2 != null) {
            view2.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.DrawingThread.8
                @Override // java.lang.Runnable
                public void run() {
                    if (DrawingThread.this.mView != null) {
                        DrawingThread.this.mView.invalidate();
                    }
                }
            });
        }
    }

    private void drawBitmap() {
        if (this.mDrawingWidth == 0 || this.mDrawingHeight == 0) {
            return;
        }
        int save = this.mCanvas.save();
        this.mCanvas.setDrawFilter(this.mPaintFlagsDrawFilter);
        this.mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.mCircleSprite.draw(this.mCanvas, this.mMode);
        this.mCanvas.restoreToCount(save);
        this.mCanvas.setMatrix(null);
        this.mArrowSprite.draw(this.mCanvas, this.mMode);
        this.mCanvas.restoreToCount(save);
        this.mCanvas.setMatrix(null);
        this.mNorthDotSprite.draw(this.mCanvas, this.mMode);
        this.mCanvas.restoreToCount(save);
        this.mCanvas.setMatrix(null);
        this.mCircleSprite.onDrawEnd();
        this.mArrowSprite.onDrawEnd();
        this.mNorthDotSprite.onDrawEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DrawingHandler extends Handler {
        static final int MSG_RUN_DRAW = 0;
        static final int MSG_RUN_ENABLE_DRAW = 1;
        static final int MSG_RUN_GET_MAP_STATUS = 2;

        DrawingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                DrawingThread.this.runDraw();
            } else if (i == 1) {
                DrawingThread.this.enableDrawRun();
            } else if (i != 2) {
            } else {
                boolean mapStatus = DrawingThread.this.getMapStatus();
                if (DrawingThread.this.mUpdateMapStatusLoopCount > 0 || mapStatus) {
                    sendEmptyMessageDelayed(2, 150L);
                    DrawingThread.access$1410(DrawingThread.this);
                }
                if (DrawingThread.this.mUpdateMapStatusLoopCount < 0) {
                    DrawingThread.this.mUpdateMapStatusLoopCount = 0;
                }
            }
        }
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        clearHandlerMessage();
        this.mView = null;
        return super.quit();
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        clearHandlerMessage();
        this.mView = null;
        return super.quitSafely();
    }

    private void clearHandlerMessage() {
        DrawingHandler drawingHandler = this.mReceiver;
        if (drawingHandler != null) {
            drawingHandler.removeMessages(0);
            this.mReceiver.removeMessages(1);
            this.mReceiver.removeMessages(2);
        }
    }
}
