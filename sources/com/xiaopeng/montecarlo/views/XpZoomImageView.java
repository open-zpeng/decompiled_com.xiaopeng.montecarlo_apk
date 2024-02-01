package com.xiaopeng.montecarlo.views;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class XpZoomImageView extends NaviImageView {
    public static final float FLING_DAMPING_FACTOR = 0.9f;
    private static final float MAX_SCALE = 4.0f;
    public static final int PINCH_MODE_FREE = 0;
    public static final int PINCH_MODE_SCALE = 2;
    public static final int PINCH_MODE_SCROLL = 1;
    public static final int SCALE_ANIMATOR_DURATION = 200;
    private static final float UPPER_BOUND_SCALE = 100.0f;
    private int mDispatchOuterMatrixChangedLock;
    private FlingAnimator mFlingAnimator;
    private GestureDetector mGestureDetector;
    private PointF mLastMovePoint;
    private RectF mMask;
    private MaskAnimator mMaskAnimator;
    private View.OnClickListener mOnClickListener;
    private View.OnLongClickListener mOnLongClickListener;
    private Matrix mOuterMatrix;
    private List<OuterMatrixChangedListener> mOuterMatrixChangedListeners;
    private List<OuterMatrixChangedListener> mOuterMatrixChangedListenersCopy;
    private int mPinchMode;
    private ScaleAnimator mScaleAnimator;
    private float mScaleBase;
    private PointF mScaleCenter;

    /* loaded from: classes3.dex */
    public interface OuterMatrixChangedListener {
        void onOuterMatrixChanged(XpZoomImageView xpZoomImageView);
    }

    protected float calculateNextScale(float f, float f2) {
        if (f2 * f < 4.0f) {
            return 4.0f;
        }
        return f;
    }

    protected float getMaxScale() {
        return 4.0f;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public Matrix getOuterMatrix(Matrix matrix) {
        if (matrix == null) {
            return new Matrix(this.mOuterMatrix);
        }
        matrix.set(this.mOuterMatrix);
        return matrix;
    }

    public Matrix getInnerMatrix(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (isReady()) {
            RectF rectFTake = MathUtils.rectFTake(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            RectF rectFTake2 = MathUtils.rectFTake(0.0f, 0.0f, getWidth(), getHeight());
            matrix.setRectToRect(rectFTake, rectFTake2, Matrix.ScaleToFit.CENTER);
            MathUtils.rectFGiven(rectFTake2);
            MathUtils.rectFGiven(rectFTake);
        }
        return matrix;
    }

    public Matrix getCurrentImageMatrix(Matrix matrix) {
        Matrix innerMatrix = getInnerMatrix(matrix);
        innerMatrix.postConcat(this.mOuterMatrix);
        return innerMatrix;
    }

    public RectF getImageBound(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (isReady()) {
            Matrix matrixTake = MathUtils.matrixTake();
            getCurrentImageMatrix(matrixTake);
            rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            matrixTake.mapRect(rectF);
            MathUtils.matrixGiven(matrixTake);
            return rectF;
        }
        return rectF;
    }

    public RectF getMask() {
        RectF rectF = this.mMask;
        if (rectF != null) {
            return new RectF(rectF);
        }
        return null;
    }

    public int getPinchMode() {
        return this.mPinchMode;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.mPinchMode == 2) {
            return true;
        }
        RectF imageBound = getImageBound(null);
        if (imageBound == null || imageBound.isEmpty()) {
            return false;
        }
        return i > 0 ? imageBound.right > ((float) getWidth()) : imageBound.left < 0.0f;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (this.mPinchMode == 2) {
            return true;
        }
        RectF imageBound = getImageBound(null);
        if (imageBound == null || imageBound.isEmpty()) {
            return false;
        }
        return i > 0 ? imageBound.bottom > ((float) getHeight()) : imageBound.top < 0.0f;
    }

    public void outerMatrixTo(Matrix matrix, long j) {
        if (matrix == null) {
            return;
        }
        this.mPinchMode = 0;
        cancelAllAnimator();
        if (j <= 0) {
            this.mOuterMatrix.set(matrix);
            dispatchOuterMatrixChanged();
            invalidate();
            return;
        }
        this.mScaleAnimator = new ScaleAnimator(this.mOuterMatrix, matrix, j);
        this.mScaleAnimator.start();
    }

    public void zoomMaskTo(RectF rectF, long j) {
        RectF rectF2;
        if (rectF == null) {
            return;
        }
        MaskAnimator maskAnimator = this.mMaskAnimator;
        if (maskAnimator != null) {
            maskAnimator.cancel();
            this.mMaskAnimator = null;
        }
        if (j <= 0 || (rectF2 = this.mMask) == null) {
            if (this.mMask == null) {
                this.mMask = new RectF();
            }
            this.mMask.set(rectF);
            invalidate();
            return;
        }
        this.mMaskAnimator = new MaskAnimator(rectF2, rectF, j);
        this.mMaskAnimator.start();
    }

    public void reset() {
        this.mOuterMatrix.reset();
        dispatchOuterMatrixChanged();
        this.mMask = null;
        this.mPinchMode = 0;
        this.mLastMovePoint.set(0.0f, 0.0f);
        this.mScaleCenter.set(0.0f, 0.0f);
        this.mScaleBase = 0.0f;
        MaskAnimator maskAnimator = this.mMaskAnimator;
        if (maskAnimator != null) {
            maskAnimator.cancel();
            this.mMaskAnimator = null;
        }
        cancelAllAnimator();
        invalidate();
    }

    public void addOuterMatrixChangedListener(OuterMatrixChangedListener outerMatrixChangedListener) {
        if (outerMatrixChangedListener == null) {
            return;
        }
        if (this.mDispatchOuterMatrixChangedLock == 0) {
            if (this.mOuterMatrixChangedListeners == null) {
                this.mOuterMatrixChangedListeners = new ArrayList();
            }
            this.mOuterMatrixChangedListeners.add(outerMatrixChangedListener);
            return;
        }
        if (this.mOuterMatrixChangedListenersCopy == null) {
            List<OuterMatrixChangedListener> list = this.mOuterMatrixChangedListeners;
            if (list != null) {
                this.mOuterMatrixChangedListenersCopy = new ArrayList(list);
            } else {
                this.mOuterMatrixChangedListenersCopy = new ArrayList();
            }
        }
        this.mOuterMatrixChangedListenersCopy.add(outerMatrixChangedListener);
    }

    public void removeOuterMatrixChangedListener(OuterMatrixChangedListener outerMatrixChangedListener) {
        List<OuterMatrixChangedListener> list;
        if (outerMatrixChangedListener == null) {
            return;
        }
        if (this.mDispatchOuterMatrixChangedLock == 0) {
            List<OuterMatrixChangedListener> list2 = this.mOuterMatrixChangedListeners;
            if (list2 != null) {
                list2.remove(outerMatrixChangedListener);
                return;
            }
            return;
        }
        if (this.mOuterMatrixChangedListenersCopy == null && (list = this.mOuterMatrixChangedListeners) != null) {
            this.mOuterMatrixChangedListenersCopy = new ArrayList(list);
        }
        List<OuterMatrixChangedListener> list3 = this.mOuterMatrixChangedListenersCopy;
        if (list3 != null) {
            list3.remove(outerMatrixChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOuterMatrixChanged() {
        List<OuterMatrixChangedListener> list;
        List<OuterMatrixChangedListener> list2 = this.mOuterMatrixChangedListeners;
        if (list2 == null) {
            return;
        }
        this.mDispatchOuterMatrixChangedLock++;
        for (OuterMatrixChangedListener outerMatrixChangedListener : list2) {
            outerMatrixChangedListener.onOuterMatrixChanged(this);
        }
        this.mDispatchOuterMatrixChangedLock--;
        if (this.mDispatchOuterMatrixChangedLock != 0 || (list = this.mOuterMatrixChangedListenersCopy) == null) {
            return;
        }
        this.mOuterMatrixChangedListeners = list;
        this.mOuterMatrixChangedListenersCopy = null;
    }

    public XpZoomImageView(Context context) {
        super(context);
        this.mOuterMatrix = new Matrix();
        this.mPinchMode = 0;
        this.mLastMovePoint = new PointF();
        this.mScaleCenter = new PointF();
        this.mScaleBase = 0.0f;
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.xiaopeng.montecarlo.views.XpZoomImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (XpZoomImageView.this.mPinchMode == 0) {
                    if (XpZoomImageView.this.mScaleAnimator == null || !XpZoomImageView.this.mScaleAnimator.isRunning()) {
                        XpZoomImageView.this.fling(f, f2);
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mOnLongClickListener != null) {
                    XpZoomImageView.this.mOnLongClickListener.onLongClick(XpZoomImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mPinchMode == 1 && (XpZoomImageView.this.mScaleAnimator == null || !XpZoomImageView.this.mScaleAnimator.isRunning())) {
                    XpZoomImageView.this.doubleTap(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mOnClickListener != null) {
                    XpZoomImageView.this.mOnClickListener.onClick(XpZoomImageView.this);
                    return true;
                }
                return true;
            }
        });
        initView();
    }

    public XpZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOuterMatrix = new Matrix();
        this.mPinchMode = 0;
        this.mLastMovePoint = new PointF();
        this.mScaleCenter = new PointF();
        this.mScaleBase = 0.0f;
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.xiaopeng.montecarlo.views.XpZoomImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (XpZoomImageView.this.mPinchMode == 0) {
                    if (XpZoomImageView.this.mScaleAnimator == null || !XpZoomImageView.this.mScaleAnimator.isRunning()) {
                        XpZoomImageView.this.fling(f, f2);
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mOnLongClickListener != null) {
                    XpZoomImageView.this.mOnLongClickListener.onLongClick(XpZoomImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mPinchMode == 1 && (XpZoomImageView.this.mScaleAnimator == null || !XpZoomImageView.this.mScaleAnimator.isRunning())) {
                    XpZoomImageView.this.doubleTap(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mOnClickListener != null) {
                    XpZoomImageView.this.mOnClickListener.onClick(XpZoomImageView.this);
                    return true;
                }
                return true;
            }
        });
        initView();
    }

    public XpZoomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOuterMatrix = new Matrix();
        this.mPinchMode = 0;
        this.mLastMovePoint = new PointF();
        this.mScaleCenter = new PointF();
        this.mScaleBase = 0.0f;
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.xiaopeng.montecarlo.views.XpZoomImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (XpZoomImageView.this.mPinchMode == 0) {
                    if (XpZoomImageView.this.mScaleAnimator == null || !XpZoomImageView.this.mScaleAnimator.isRunning()) {
                        XpZoomImageView.this.fling(f, f2);
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mOnLongClickListener != null) {
                    XpZoomImageView.this.mOnLongClickListener.onLongClick(XpZoomImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mPinchMode == 1 && (XpZoomImageView.this.mScaleAnimator == null || !XpZoomImageView.this.mScaleAnimator.isRunning())) {
                    XpZoomImageView.this.doubleTap(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (XpZoomImageView.this.mOnClickListener != null) {
                    XpZoomImageView.this.mOnClickListener.onClick(XpZoomImageView.this);
                    return true;
                }
                return true;
            }
        });
        initView();
    }

    private void initView() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.views.NaviImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (isReady()) {
            Matrix matrixTake = MathUtils.matrixTake();
            setImageMatrix(getCurrentImageMatrix(matrixTake));
            MathUtils.matrixGiven(matrixTake);
        }
        if (this.mMask != null) {
            canvas.save();
            canvas.clipRect(this.mMask);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    private boolean isReady() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && getWidth() > 0 && getHeight() > 0;
    }

    /* loaded from: classes3.dex */
    private class MaskAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private float[] mStart = new float[4];
        private float[] mEnd = new float[4];
        private float[] mResult = new float[4];

        public MaskAnimator(RectF rectF, RectF rectF2, long j) {
            setFloatValues(0.0f, 1.0f);
            setDuration(j);
            addUpdateListener(this);
            this.mStart[0] = rectF.left;
            this.mStart[1] = rectF.top;
            this.mStart[2] = rectF.right;
            this.mStart[3] = rectF.bottom;
            this.mEnd[0] = rectF2.left;
            this.mEnd[1] = rectF2.top;
            this.mEnd[2] = rectF2.right;
            this.mEnd[3] = rectF2.bottom;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 4; i++) {
                float[] fArr = this.mResult;
                float[] fArr2 = this.mStart;
                fArr[i] = fArr2[i] + ((this.mEnd[i] - fArr2[i]) * floatValue);
            }
            if (XpZoomImageView.this.mMask == null) {
                XpZoomImageView.this.mMask = new RectF();
            }
            RectF rectF = XpZoomImageView.this.mMask;
            float[] fArr3 = this.mResult;
            rectF.set(fArr3[0], fArr3[1], fArr3[2], fArr3[3]);
            XpZoomImageView.this.invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ScaleAnimator scaleAnimator;
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.mPinchMode == 2) {
                scaleEnd();
            }
            this.mPinchMode = 0;
        } else if (action == 6) {
            if (this.mPinchMode == 2 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    saveScaleContext(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    saveScaleContext(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 0) {
            ScaleAnimator scaleAnimator2 = this.mScaleAnimator;
            if (scaleAnimator2 == null || !scaleAnimator2.isRunning()) {
                cancelAllAnimator();
                this.mPinchMode = 1;
                this.mLastMovePoint.set(motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 5) {
            cancelAllAnimator();
            this.mPinchMode = 2;
            saveScaleContext(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2 && ((scaleAnimator = this.mScaleAnimator) == null || !scaleAnimator.isRunning())) {
            int i = this.mPinchMode;
            if (i == 1) {
                scrollBy(motionEvent.getX() - this.mLastMovePoint.x, motionEvent.getY() - this.mLastMovePoint.y);
                this.mLastMovePoint.set(motionEvent.getX(), motionEvent.getY());
            } else if (i == 2 && motionEvent.getPointerCount() > 1) {
                float distance = MathUtils.getDistance(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                float[] centerPoint = MathUtils.getCenterPoint(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                this.mLastMovePoint.set(centerPoint[0], centerPoint[1]);
                scale(this.mScaleCenter, this.mScaleBase, distance, this.mLastMovePoint);
            }
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scrollBy(float r7, float r8) {
        /*
            r6 = this;
            boolean r0 = r6.isReady()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.graphics.RectF r0 = com.xiaopeng.montecarlo.views.XpZoomImageView.MathUtils.rectFTake()
            r6.getImageBound(r0)
            int r2 = r6.getWidth()
            float r2 = (float) r2
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r4 = r0.right
            float r5 = r0.left
            float r4 = r4 - r5
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r5 = 0
            if (r4 >= 0) goto L25
        L23:
            r7 = r5
            goto L47
        L25:
            float r4 = r0.left
            float r4 = r4 + r7
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L36
            float r7 = r0.left
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 >= 0) goto L23
            float r7 = r0.left
            float r7 = -r7
            goto L47
        L36:
            float r4 = r0.right
            float r4 = r4 + r7
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L47
            float r7 = r0.right
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 <= 0) goto L23
            float r7 = r0.right
            float r7 = r2 - r7
        L47:
            float r2 = r0.bottom
            float r4 = r0.top
            float r2 = r2 - r4
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L52
        L50:
            r8 = r5
            goto L74
        L52:
            float r2 = r0.top
            float r2 = r2 + r8
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L63
            float r8 = r0.top
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 >= 0) goto L50
            float r8 = r0.top
            float r8 = -r8
            goto L74
        L63:
            float r2 = r0.bottom
            float r2 = r2 + r8
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L74
            float r8 = r0.bottom
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 <= 0) goto L50
            float r8 = r0.bottom
            float r8 = r3 - r8
        L74:
            com.xiaopeng.montecarlo.views.XpZoomImageView.MathUtils.rectFGiven(r0)
            android.graphics.Matrix r0 = r6.mOuterMatrix
            r0.postTranslate(r7, r8)
            r6.dispatchOuterMatrixChanged()
            r6.invalidate()
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 != 0) goto L8a
            int r7 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r7 == 0) goto L8b
        L8a:
            r1 = 1
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.XpZoomImageView.scrollBy(float, float):boolean");
    }

    private void saveScaleContext(float f, float f2, float f3, float f4) {
        this.mScaleBase = MathUtils.getMatrixScale(this.mOuterMatrix)[0] / MathUtils.getDistance(f, f2, f3, f4);
        float[] inverseMatrixPoint = MathUtils.inverseMatrixPoint(MathUtils.getCenterPoint(f, f2, f3, f4), this.mOuterMatrix);
        this.mScaleCenter.set(inverseMatrixPoint[0], inverseMatrixPoint[1]);
    }

    private void scale(PointF pointF, float f, float f2, PointF pointF2) {
        if (isReady()) {
            float f3 = f * f2;
            Matrix matrixTake = MathUtils.matrixTake();
            Matrix matrixTake2 = MathUtils.matrixTake(matrixTake);
            getCurrentImageMatrix(matrixTake2);
            if (MathUtils.getMatrixScale(matrixTake2)[0] > UPPER_BOUND_SCALE) {
                return;
            }
            matrixTake.postScale(f3, f3, pointF.x, pointF.y);
            matrixTake.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
            this.mOuterMatrix.set(matrixTake);
            MathUtils.matrixGiven(matrixTake);
            dispatchOuterMatrixChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTap(float f, float f2) {
        float f3;
        if (isReady()) {
            Matrix matrixTake = MathUtils.matrixTake();
            getInnerMatrix(matrixTake);
            float f4 = MathUtils.getMatrixScale(matrixTake)[0];
            float f5 = MathUtils.getMatrixScale(this.mOuterMatrix)[0];
            float f6 = f4 * f5;
            float width = getWidth();
            float height = getHeight();
            float maxScale = getMaxScale();
            float calculateNextScale = calculateNextScale(f4, f5);
            if (calculateNextScale > maxScale) {
                calculateNextScale = maxScale;
            }
            if (calculateNextScale >= f4) {
                f4 = calculateNextScale;
            }
            Matrix matrixTake2 = MathUtils.matrixTake(this.mOuterMatrix);
            float f7 = f4 / f6;
            matrixTake2.postScale(f7, f7, f, f2);
            float f8 = width / 2.0f;
            float f9 = height / 2.0f;
            matrixTake2.postTranslate(f8 - f, f9 - f2);
            Matrix matrixTake3 = MathUtils.matrixTake(matrixTake);
            matrixTake3.postConcat(matrixTake2);
            float f10 = 0.0f;
            RectF rectFTake = MathUtils.rectFTake(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            matrixTake3.mapRect(rectFTake);
            if (rectFTake.right - rectFTake.left < width) {
                f3 = f8 - ((rectFTake.right + rectFTake.left) / 2.0f);
            } else if (rectFTake.left > 0.0f) {
                f3 = -rectFTake.left;
            } else {
                f3 = rectFTake.right < width ? width - rectFTake.right : 0.0f;
            }
            if (rectFTake.bottom - rectFTake.top < height) {
                f10 = f9 - ((rectFTake.bottom + rectFTake.top) / 2.0f);
            } else if (rectFTake.top > 0.0f) {
                f10 = -rectFTake.top;
            } else if (rectFTake.bottom < height) {
                f10 = height - rectFTake.bottom;
            }
            matrixTake2.postTranslate(f3, f10);
            cancelAllAnimator();
            this.mScaleAnimator = new ScaleAnimator(this, this.mOuterMatrix, matrixTake2);
            this.mScaleAnimator.start();
            MathUtils.rectFGiven(rectFTake);
            MathUtils.matrixGiven(matrixTake3);
            MathUtils.matrixGiven(matrixTake2);
            MathUtils.matrixGiven(matrixTake);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void scaleEnd() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.XpZoomImageView.scaleEnd():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fling(float f, float f2) {
        if (isReady()) {
            cancelAllAnimator();
            this.mFlingAnimator = new FlingAnimator(f / 60.0f, f2 / 60.0f);
            this.mFlingAnimator.start();
        }
    }

    private void cancelAllAnimator() {
        ScaleAnimator scaleAnimator = this.mScaleAnimator;
        if (scaleAnimator != null) {
            scaleAnimator.cancel();
            this.mScaleAnimator = null;
        }
        FlingAnimator flingAnimator = this.mFlingAnimator;
        if (flingAnimator != null) {
            flingAnimator.cancel();
            this.mFlingAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class FlingAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private float[] mVector;

        public FlingAnimator(float f, float f2) {
            setFloatValues(0.0f, 1.0f);
            setDuration(1000000L);
            addUpdateListener(this);
            this.mVector = new float[]{f, f2};
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            XpZoomImageView xpZoomImageView = XpZoomImageView.this;
            float[] fArr = this.mVector;
            boolean scrollBy = xpZoomImageView.scrollBy(fArr[0], fArr[1]);
            float[] fArr2 = this.mVector;
            fArr2[0] = fArr2[0] * 0.9f;
            fArr2[1] = fArr2[1] * 0.9f;
            if (!scrollBy || MathUtils.getDistance(0.0f, 0.0f, fArr2[0], fArr2[1]) < 1.0f) {
                valueAnimator.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ScaleAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private float[] mEnd;
        private float[] mResult;
        private float[] mStart;

        public ScaleAnimator(XpZoomImageView xpZoomImageView, Matrix matrix, Matrix matrix2) {
            this(matrix, matrix2, 200L);
        }

        public ScaleAnimator(Matrix matrix, Matrix matrix2, long j) {
            this.mStart = new float[9];
            this.mEnd = new float[9];
            this.mResult = new float[9];
            setFloatValues(0.0f, 1.0f);
            setDuration(j);
            addUpdateListener(this);
            matrix.getValues(this.mStart);
            matrix2.getValues(this.mEnd);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mResult;
                float[] fArr2 = this.mStart;
                fArr[i] = fArr2[i] + ((this.mEnd[i] - fArr2[i]) * floatValue);
            }
            XpZoomImageView.this.mOuterMatrix.setValues(this.mResult);
            XpZoomImageView.this.dispatchOuterMatrixChanged();
            XpZoomImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class ObjectsPool<T> {
        private Queue<T> mQueue = new LinkedList();
        private int mSize;

        protected abstract T newInstance();

        protected abstract T resetInstance(T t);

        public ObjectsPool(int i) {
            this.mSize = i;
        }

        public T take() {
            if (this.mQueue.size() == 0) {
                return newInstance();
            }
            return resetInstance(this.mQueue.poll());
        }

        public void given(T t) {
            if (t == null || this.mQueue.size() >= this.mSize) {
                return;
            }
            this.mQueue.offer(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MatrixPool extends ObjectsPool<Matrix> {
        public MatrixPool(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.views.XpZoomImageView.ObjectsPool
        public Matrix newInstance() {
            return new Matrix();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.montecarlo.views.XpZoomImageView.ObjectsPool
        public Matrix resetInstance(Matrix matrix) {
            matrix.reset();
            return matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RectFPool extends ObjectsPool<RectF> {
        public RectFPool(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.montecarlo.views.XpZoomImageView.ObjectsPool
        public RectF newInstance() {
            return new RectF();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.montecarlo.views.XpZoomImageView.ObjectsPool
        public RectF resetInstance(RectF rectF) {
            rectF.setEmpty();
            return rectF;
        }
    }

    /* loaded from: classes3.dex */
    public static class MathUtils {
        private static MatrixPool sMatrixPool = new MatrixPool(16);
        private static RectFPool sRectFPool = new RectFPool(16);

        public static Matrix matrixTake() {
            return sMatrixPool.take();
        }

        public static Matrix matrixTake(Matrix matrix) {
            Matrix take = sMatrixPool.take();
            if (matrix != null) {
                take.set(matrix);
            }
            return take;
        }

        public static void matrixGiven(Matrix matrix) {
            sMatrixPool.given(matrix);
        }

        public static RectF rectFTake() {
            return sRectFPool.take();
        }

        public static RectF rectFTake(float f, float f2, float f3, float f4) {
            RectF take = sRectFPool.take();
            take.set(f, f2, f3, f4);
            return take;
        }

        public static RectF rectFTake(RectF rectF) {
            RectF take = sRectFPool.take();
            if (rectF != null) {
                take.set(rectF);
            }
            return take;
        }

        public static void rectFGiven(RectF rectF) {
            sRectFPool.given(rectF);
        }

        public static float getDistance(float f, float f2, float f3, float f4) {
            float f5 = f - f3;
            float f6 = f2 - f4;
            return (float) Math.sqrt((f5 * f5) + (f6 * f6));
        }

        public static float[] getCenterPoint(float f, float f2, float f3, float f4) {
            return new float[]{(f + f3) / 2.0f, (f2 + f4) / 2.0f};
        }

        public static float[] getMatrixScale(Matrix matrix) {
            if (matrix != null) {
                float[] fArr = new float[9];
                matrix.getValues(fArr);
                return new float[]{fArr[0], fArr[4]};
            }
            return new float[2];
        }

        public static float[] inverseMatrixPoint(float[] fArr, Matrix matrix) {
            if (fArr != null && matrix != null) {
                float[] fArr2 = new float[2];
                Matrix matrixTake = matrixTake();
                matrix.invert(matrixTake);
                matrixTake.mapPoints(fArr2, fArr);
                matrixGiven(matrixTake);
                return fArr2;
            }
            return new float[2];
        }

        public static void calculateRectTranslateMatrix(RectF rectF, RectF rectF2, Matrix matrix) {
            if (rectF == null || rectF2 == null || matrix == null || rectF.width() == 0.0f || rectF.height() == 0.0f) {
                return;
            }
            matrix.reset();
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(rectF2.width() / rectF.width(), rectF2.height() / rectF.height());
            matrix.postTranslate(rectF2.left, rectF2.top);
        }

        public static void calculateScaledRectInContainer(RectF rectF, float f, float f2, ImageView.ScaleType scaleType, RectF rectF2) {
            float width;
            float f3;
            if (rectF == null || rectF2 == null) {
                return;
            }
            float f4 = 0.0f;
            if (f == 0.0f || f2 == 0.0f) {
                return;
            }
            if (scaleType == null) {
                scaleType = ImageView.ScaleType.FIT_CENTER;
            }
            rectF2.setEmpty();
            if (ImageView.ScaleType.FIT_XY.equals(scaleType)) {
                rectF2.set(rectF);
            } else if (ImageView.ScaleType.CENTER.equals(scaleType)) {
                Matrix matrixTake = matrixTake();
                RectF rectFTake = rectFTake(0.0f, 0.0f, f, f2);
                matrixTake.setTranslate((rectF.width() - f) * 0.5f, (rectF.height() - f2) * 0.5f);
                matrixTake.mapRect(rectF2, rectFTake);
                rectFGiven(rectFTake);
                matrixGiven(matrixTake);
                rectF2.left += rectF.left;
                rectF2.right += rectF.left;
                rectF2.top += rectF.top;
                rectF2.bottom += rectF.top;
            } else if (ImageView.ScaleType.CENTER_CROP.equals(scaleType)) {
                Matrix matrixTake2 = matrixTake();
                RectF rectFTake2 = rectFTake(0.0f, 0.0f, f, f2);
                if (rectF.height() * f > rectF.width() * f2) {
                    width = rectF.height() / f2;
                    f3 = (rectF.width() - (f * width)) * 0.5f;
                } else {
                    width = rectF.width() / f;
                    f4 = (rectF.height() - (f2 * width)) * 0.5f;
                    f3 = 0.0f;
                }
                matrixTake2.setScale(width, width);
                matrixTake2.postTranslate(f3, f4);
                matrixTake2.mapRect(rectF2, rectFTake2);
                rectFGiven(rectFTake2);
                matrixGiven(matrixTake2);
                rectF2.left += rectF.left;
                rectF2.right += rectF.left;
                rectF2.top += rectF.top;
                rectF2.bottom += rectF.top;
            } else if (ImageView.ScaleType.CENTER_INSIDE.equals(scaleType)) {
                Matrix matrixTake3 = matrixTake();
                RectF rectFTake3 = rectFTake(0.0f, 0.0f, f, f2);
                float min = (f > rectF.width() || f2 > rectF.height()) ? Math.min(rectF.width() / f, rectF.height() / f2) : 1.0f;
                matrixTake3.setScale(min, min);
                matrixTake3.postTranslate((rectF.width() - (f * min)) * 0.5f, (rectF.height() - (f2 * min)) * 0.5f);
                matrixTake3.mapRect(rectF2, rectFTake3);
                rectFGiven(rectFTake3);
                matrixGiven(matrixTake3);
                rectF2.left += rectF.left;
                rectF2.right += rectF.left;
                rectF2.top += rectF.top;
                rectF2.bottom += rectF.top;
            } else if (ImageView.ScaleType.FIT_CENTER.equals(scaleType)) {
                Matrix matrixTake4 = matrixTake();
                RectF rectFTake4 = rectFTake(0.0f, 0.0f, f, f2);
                RectF rectFTake5 = rectFTake(0.0f, 0.0f, f, f2);
                RectF rectFTake6 = rectFTake(0.0f, 0.0f, rectF.width(), rectF.height());
                matrixTake4.setRectToRect(rectFTake5, rectFTake6, Matrix.ScaleToFit.CENTER);
                matrixTake4.mapRect(rectF2, rectFTake4);
                rectFGiven(rectFTake6);
                rectFGiven(rectFTake5);
                rectFGiven(rectFTake4);
                matrixGiven(matrixTake4);
                rectF2.left += rectF.left;
                rectF2.right += rectF.left;
                rectF2.top += rectF.top;
                rectF2.bottom += rectF.top;
            } else if (ImageView.ScaleType.FIT_START.equals(scaleType)) {
                Matrix matrixTake5 = matrixTake();
                RectF rectFTake7 = rectFTake(0.0f, 0.0f, f, f2);
                RectF rectFTake8 = rectFTake(0.0f, 0.0f, f, f2);
                RectF rectFTake9 = rectFTake(0.0f, 0.0f, rectF.width(), rectF.height());
                matrixTake5.setRectToRect(rectFTake8, rectFTake9, Matrix.ScaleToFit.START);
                matrixTake5.mapRect(rectF2, rectFTake7);
                rectFGiven(rectFTake9);
                rectFGiven(rectFTake8);
                rectFGiven(rectFTake7);
                matrixGiven(matrixTake5);
                rectF2.left += rectF.left;
                rectF2.right += rectF.left;
                rectF2.top += rectF.top;
                rectF2.bottom += rectF.top;
            } else if (ImageView.ScaleType.FIT_END.equals(scaleType)) {
                Matrix matrixTake6 = matrixTake();
                RectF rectFTake10 = rectFTake(0.0f, 0.0f, f, f2);
                RectF rectFTake11 = rectFTake(0.0f, 0.0f, f, f2);
                RectF rectFTake12 = rectFTake(0.0f, 0.0f, rectF.width(), rectF.height());
                matrixTake6.setRectToRect(rectFTake11, rectFTake12, Matrix.ScaleToFit.END);
                matrixTake6.mapRect(rectF2, rectFTake10);
                rectFGiven(rectFTake12);
                rectFGiven(rectFTake11);
                rectFGiven(rectFTake10);
                matrixGiven(matrixTake6);
                rectF2.left += rectF.left;
                rectF2.right += rectF.left;
                rectF2.top += rectF.top;
                rectF2.bottom += rectF.top;
            } else {
                rectF2.set(rectF);
            }
        }
    }
}
