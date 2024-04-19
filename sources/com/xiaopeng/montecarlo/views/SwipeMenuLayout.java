package com.xiaopeng.montecarlo.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XViewGroup;
/* loaded from: classes3.dex */
public class SwipeMenuLayout extends XViewGroup {
    private static final L.Tag TAG = new L.Tag("SwipeMenuLayout");
    private static boolean sIsTouching;
    private static SwipeMenuLayout sViewCache;
    private ValueAnimator mCloseAnim;
    private View mContentView;
    private ValueAnimator mExpandAnim;
    private PointF mFirstP;
    private int mHeight;
    private boolean mIosInterceptFlag;
    private boolean mIsExpand;
    private boolean mIsIos;
    private boolean mIsLeftSwipe;
    private boolean mIsSwipeEnable;
    private boolean mIsUnMoved;
    private boolean mIsUserSwiped;
    private PointF mLastP;
    private int mLimit;
    private MotionEventListener mListener;
    private int mMaxVelocity;
    private int mPointerId;
    private int mRightMenuWidths;
    private int mScaleTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes3.dex */
    public interface MotionEventListener {
        void onHeightChange(int i);

        void onPositionChange(int i, int i2);
    }

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastP = new PointF();
        this.mIsUnMoved = true;
        this.mFirstP = new PointF();
        init(context, attributeSet, i);
    }

    public static SwipeMenuLayout getViewCache() {
        return sViewCache;
    }

    public boolean isSwipeEnable() {
        return this.mIsSwipeEnable;
    }

    public void setSwipeEnable(boolean z) {
        this.mIsSwipeEnable = z;
    }

    public boolean isIos() {
        return this.mIsIos;
    }

    public SwipeMenuLayout setIos(boolean z) {
        this.mIsIos = z;
        return this;
    }

    public boolean isLeftSwipe() {
        return this.mIsLeftSwipe;
    }

    public SwipeMenuLayout setLeftSwipe(boolean z) {
        this.mIsLeftSwipe = z;
        return this;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mScaleTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMaxVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mIsSwipeEnable = true;
        this.mIsIos = true;
        this.mIsLeftSwipe = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 2) {
                this.mIsSwipeEnable = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 0) {
                this.mIsIos = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 1) {
                this.mIsLeftSwipe = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setClickable(true);
        this.mRightMenuWidths = 0;
        this.mHeight = 0;
        int childCount = getChildCount();
        boolean z = View.MeasureSpec.getMode(i2) != 1073741824;
        int i3 = 0;
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.mHeight = Math.max(this.mHeight, childAt.getMeasuredHeight());
                if (z && marginLayoutParams.height == -1) {
                    z2 = true;
                }
                if (i4 > 0) {
                    this.mRightMenuWidths += childAt.getMeasuredWidth();
                } else {
                    this.mContentView = childAt;
                    i3 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i3, this.mHeight + getPaddingTop() + getPaddingBottom());
        this.mLimit = (this.mRightMenuWidths * 4) / 10;
        if (z2) {
            forceUniformHeight(childCount, i);
        }
        MotionEventListener motionEventListener = this.mListener;
        if (motionEventListener != null) {
            motionEventListener.onHeightChange(this.mHeight);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams.height == -1) {
                    int i4 = marginLayoutParams.width;
                    marginLayoutParams.width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i2, 0, makeMeasureSpec, 0);
                    marginLayoutParams.width = i4;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        int paddingLeft2 = getPaddingLeft() + 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                if (i5 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.mIsLeftSwipe) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, getPaddingTop() + childAt.getMeasuredHeight());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft += measuredWidth;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L69;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.SwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mIsSwipeEnable) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && Math.abs(motionEvent.getRawX() - this.mFirstP.x) > this.mScaleTouchSlop) {
                    return true;
                }
            } else {
                if (this.mIsLeftSwipe) {
                    if (getScrollX() > this.mScaleTouchSlop && motionEvent.getX() < getWidth() - getScrollX()) {
                        if (this.mIsUnMoved) {
                            smoothClose();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.mScaleTouchSlop && motionEvent.getX() > (-getScrollX())) {
                    if (this.mIsUnMoved) {
                        smoothClose();
                    }
                    return true;
                }
                if (this.mIsUserSwiped) {
                    return true;
                }
            }
            if (this.mIosInterceptFlag) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void smoothExpand() {
        sViewCache = this;
        View view = this.mContentView;
        if (view != null) {
            view.setLongClickable(false);
        }
        cancelAnim();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.mIsLeftSwipe ? this.mRightMenuWidths : -this.mRightMenuWidths;
        this.mExpandAnim = ValueAnimator.ofInt(iArr);
        this.mExpandAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.montecarlo.views.SwipeMenuLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                if (SwipeMenuLayout.this.mListener != null) {
                    SwipeMenuLayout.this.mListener.onPositionChange(SwipeMenuLayout.this.getScrollX(), SwipeMenuLayout.this.mRightMenuWidths);
                }
            }
        });
        this.mExpandAnim.setInterpolator(new OvershootInterpolator());
        this.mExpandAnim.addListener(new AnimatorListenerAdapter() { // from class: com.xiaopeng.montecarlo.views.SwipeMenuLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwipeMenuLayout.this.mIsExpand = true;
            }
        });
        this.mExpandAnim.setDuration(300L).start();
    }

    private void cancelAnim() {
        ValueAnimator valueAnimator = this.mCloseAnim;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mCloseAnim.cancel();
        }
        ValueAnimator valueAnimator2 = this.mExpandAnim;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.mExpandAnim.cancel();
    }

    public void smoothClose() {
        sViewCache = null;
        View view = this.mContentView;
        if (view != null) {
            view.setLongClickable(true);
        }
        cancelAnim();
        this.mCloseAnim = ValueAnimator.ofInt(getScrollX(), 0);
        this.mCloseAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.montecarlo.views.SwipeMenuLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                if (SwipeMenuLayout.this.mListener != null) {
                    SwipeMenuLayout.this.mListener.onPositionChange(SwipeMenuLayout.this.getScrollX(), SwipeMenuLayout.this.mRightMenuWidths);
                }
            }
        });
        this.mCloseAnim.setInterpolator(new AccelerateInterpolator());
        this.mCloseAnim.addListener(new AnimatorListenerAdapter() { // from class: com.xiaopeng.montecarlo.views.SwipeMenuLayout.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwipeMenuLayout.this.mIsExpand = false;
            }
        });
        this.mCloseAnim.setDuration(300L).start();
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = sViewCache;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.smoothClose();
            sViewCache = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.mScaleTouchSlop) {
            return false;
        }
        return super.performLongClick();
    }

    public void quickClose() {
        if (this == sViewCache) {
            cancelAnim();
            sViewCache.scrollTo(0, 0);
            sViewCache = null;
        }
    }

    public void setListener(MotionEventListener motionEventListener) {
        this.mListener = motionEventListener;
    }
}
