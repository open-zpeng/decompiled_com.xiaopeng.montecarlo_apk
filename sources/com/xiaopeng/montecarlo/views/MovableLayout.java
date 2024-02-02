package com.xiaopeng.montecarlo.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.widget.XLinearLayout;
/* loaded from: classes3.dex */
public class MovableLayout extends XLinearLayout {
    private AnimatorSet mAnimatorSet;
    private final Context mContext;
    private boolean mIsAttach;
    private boolean mIsDrag;
    private boolean mIsDrug;
    private boolean mIsScaled;
    private float mLastX;
    private float mLastY;
    private int mParentHeight;
    private int mParentWidth;

    public MovableLayout(@NonNull Context context) {
        this(context, null);
    }

    public MovableLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MovableLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mParentWidth = BLParams.NOTIFY;
        this.mParentHeight = 1564;
        this.mIsDrug = false;
        this.mContext = context;
        initAttrs(context, attributeSet);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MovableLayout);
        this.mIsAttach = obtainStyledAttributes.getBoolean(0, true);
        this.mIsDrag = obtainStyledAttributes.getBoolean(1, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        final ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.xiaopeng.montecarlo.views.MovableLayout.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    MovableLayout.this.mParentHeight = viewGroup.getMeasuredHeight();
                    MovableLayout.this.mParentWidth = viewGroup.getMeasuredWidth();
                }
            });
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        inRangeOfView(this, motionEvent);
        return false;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsDrag) {
            getParent().requestDisallowInterceptTouchEvent(true);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.mIsAttach) {
                        if (motionEvent.getRawX() <= this.mParentWidth / 2.0f) {
                            animate().setInterpolator(new OvershootInterpolator()).setDuration(400L).x(Utils.dp2px(this.mContext, 0.0f)).start();
                        } else {
                            animate().setInterpolator(new OvershootInterpolator()).setDuration(400L).x((this.mParentWidth - getWidth()) - Utils.dp2px(this.mContext, 0.0f)).start();
                        }
                    }
                    if (this.mIsScaled) {
                        this.mIsScaled = false;
                    }
                } else if (action == 2) {
                    float f = x - this.mLastX;
                    float f2 = y - this.mLastY;
                    if (!this.mIsDrug) {
                        this.mIsDrug = Math.sqrt((double) ((f * f) + (f2 * f2))) >= 2.0d;
                    }
                    float x2 = getX() + f;
                    float y2 = getY() + f2;
                    float width = this.mParentWidth - getWidth();
                    float height = this.mParentHeight - getHeight();
                    float min = x2 < 0.0f ? 0.0f : Math.min(x2, width);
                    float min2 = y2 >= 0.0f ? Math.min(y2, height) : 0.0f;
                    setX(min);
                    setY(min2);
                    if (this.mIsDrug && !this.mIsScaled) {
                        this.mIsScaled = true;
                    }
                }
            } else {
                this.mIsDrug = false;
                this.mLastX = x;
                this.mLastY = y;
            }
        }
        return this.mIsDrag || super.onTouchEvent(motionEvent);
    }

    private void startScaleAnimator(float f, float f2, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", f, f2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", f, f2);
        if (this.mAnimatorSet == null) {
            this.mAnimatorSet = new AnimatorSet();
        }
        this.mAnimatorSet.play(ofFloat).with(ofFloat2);
        this.mAnimatorSet.setDuration(i);
        this.mAnimatorSet.start();
    }

    private boolean inRangeOfView(View view, MotionEvent motionEvent) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }
}
