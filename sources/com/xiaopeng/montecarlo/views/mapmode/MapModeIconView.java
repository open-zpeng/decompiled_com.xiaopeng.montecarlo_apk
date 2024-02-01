package com.xiaopeng.montecarlo.views.mapmode;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
import java.lang.Thread;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class MapModeIconView extends XView {
    private static final L.Tag TAG = new L.Tag("MapModeIconView");
    private float mCircleStrokeWidth;
    private boolean mIsNightMode;
    private boolean mIsPaused;
    private OnMapModeStateChangeListener mListener;
    private MapViewWrapper mMapViewWrapper;
    private DrawModeType mMode;
    private Runnable mStartThreadRun;
    private DrawingThread mThread;
    private WeakReference<MapModeIconView> mView;

    /* loaded from: classes3.dex */
    public interface OnMapModeStateChangeListener {
        void onMapModeChange(DrawModeType drawModeType);
    }

    public void setImageResource(int i) {
    }

    public void setListener(OnMapModeStateChangeListener onMapModeStateChangeListener) {
        this.mListener = onMapModeStateChangeListener;
    }

    public DrawModeType getMode() {
        return this.mMode;
    }

    public MapModeIconView(Context context) {
        this(context, null);
    }

    public MapModeIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapModeIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsNightMode = false;
        this.mMode = DrawModeType.NORTHUP;
        this.mIsPaused = false;
        this.mView = null;
        this.mStartThreadRun = new Runnable() { // from class: com.xiaopeng.montecarlo.views.mapmode.MapModeIconView.1
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = MapModeIconView.this.getMeasuredWidth();
                int measuredHeight = MapModeIconView.this.getMeasuredHeight();
                if (MapModeIconView.this.mThread != null || measuredWidth <= 0 || measuredHeight <= 0) {
                    return;
                }
                if (MapModeIconView.this.mView == null || MapModeIconView.this.mView.get() == null) {
                    MapModeIconView mapModeIconView = MapModeIconView.this;
                    mapModeIconView.mView = new WeakReference(mapModeIconView);
                }
                MapModeIconView mapModeIconView2 = MapModeIconView.this;
                mapModeIconView2.mThread = new DrawingThread((View) mapModeIconView2.mView.get(), MapModeIconView.this.getMeasuredWidth(), MapModeIconView.this.getMeasuredHeight(), MapModeIconView.this.mCircleStrokeWidth, MapModeIconView.this.mMapViewWrapper, MapModeIconView.this.mMode, MapModeIconView.this.mIsPaused, MapModeIconView.this.mIsNightMode);
                MapModeIconView.this.mThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.xiaopeng.montecarlo.views.mapmode.MapModeIconView.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread, Throwable th) {
                        L.Tag tag = MapModeIconView.TAG;
                        L.e(tag, "DrawingThread Exception：" + th.toString());
                        if (MapModeIconView.this.mThread != null) {
                            MapModeIconView.this.mThread.quit();
                            MapModeIconView.this.mThread = null;
                        }
                        if (MapModeIconView.this.isAttachedToWindow()) {
                            MapModeIconView.this.postDelayed(MapModeIconView.this.mStartThreadRun, 1000L);
                        }
                    }
                });
                MapModeIconView.this.mThread.start();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MapModeIconView, i, 0);
        if (obtainStyledAttributes != null) {
            try {
                try {
                    this.mCircleStrokeWidth = obtainStyledAttributes.getDimension(0, 3.0f);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
        setNightMode(!ThemeWatcherUtil.isDayMode());
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.setState(drawableState);
        }
    }

    public void setNightMode(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setNightMode is：" + z);
        }
        this.mIsNightMode = z;
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.setNightMode(z);
        }
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void setVisibility(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setVisibility visibility：" + i);
        }
        super.setVisibility(i);
        setPaused(i != 0);
    }

    public void setPaused(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setPaused is：" + z);
        }
        this.mIsPaused = z;
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.setPaused(z);
        }
    }

    public void setMapViewWrapper(MapViewWrapper mapViewWrapper) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setMapViewWrapper wrapper：" + mapViewWrapper);
        }
        this.mMapViewWrapper = mapViewWrapper;
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.setMapViewWrapper(mapViewWrapper);
        }
    }

    public void setMode(DrawModeType drawModeType) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setMode mode：" + drawModeType);
        }
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.setMode(drawModeType);
        }
        this.mMode = drawModeType;
        OnMapModeStateChangeListener onMapModeStateChangeListener = this.mListener;
        if (onMapModeStateChangeListener != null) {
            onMapModeStateChangeListener.onMapModeChange(this.mMode);
        }
    }

    public void resetMapStatus() {
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.resetMapStatus();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (L.ENABLE) {
            L.d(TAG, "onMeasure");
        }
        super.onMeasure(i, i2);
        this.mStartThreadRun.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onAttachedToWindow() {
        if (L.ENABLE) {
            L.d(TAG, "onAttachedToWindow");
        }
        super.onAttachedToWindow();
        post(this.mStartThreadRun);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onDetachedFromWindow() {
        if (L.ENABLE) {
            L.d(TAG, "onDetachedFromWindow");
        }
        super.onDetachedFromWindow();
        this.mView.clear();
        this.mView = null;
        removeCallbacks(this.mStartThreadRun);
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.quit();
            this.mThread = null;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (L.ENABLE) {
            L.d(TAG, "onSizeChanged");
        }
        super.onSizeChanged(i, i2, i3, i4);
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.updateSize(i, i2);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null && drawingThread.draw(canvas)) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "onDraw Error!");
        }
        invalidate();
    }
}
