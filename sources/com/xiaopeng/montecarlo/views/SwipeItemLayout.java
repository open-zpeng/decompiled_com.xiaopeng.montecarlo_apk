package com.xiaopeng.montecarlo.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class SwipeItemLayout extends FrameLayout {
    public static final L.Tag TAG = new L.Tag("SwipeItemLayout");
    private View mCurrentMenu;
    private float mDownX;
    private float mDownY;
    private ViewDragHelper mDragHelper;
    private boolean mIsDragged;
    private boolean mIsOpen;
    private LinkedHashMap<Integer, View> mMenus;
    private boolean mSwipeEnable;
    private int mTouchSlop;
    private int mVelocity;

    public SwipeItemLayout(Context context) {
        this(context, null);
    }

    public SwipeItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSwipeEnable = true;
        this.mMenus = new LinkedHashMap<>();
        if (L.ENABLE) {
            L.d(TAG, "init");
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.mDragHelper = ViewDragHelper.create(this, new DragCallBack());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mIsOpen = false;
        updateMenu();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (isCloseAnimating()) {
                return false;
            }
            if (this.mIsOpen && isTouchContent((int) motionEvent.getX(), (int) motionEvent.getY())) {
                close();
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mSwipeEnable) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mIsDragged = false;
                this.mDownX = motionEvent.getX();
                this.mDownY = motionEvent.getY();
            } else {
                if (action != 1) {
                    if (action == 2) {
                        checkCanDragged(motionEvent);
                    } else if (action != 3) {
                        if (this.mIsDragged) {
                            this.mDragHelper.processTouchEvent(motionEvent);
                        }
                    }
                }
                if (this.mIsDragged) {
                    this.mDragHelper.processTouchEvent(motionEvent);
                    this.mIsDragged = false;
                }
            }
            return this.mIsDragged || super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mSwipeEnable) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mIsDragged = false;
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
        } else {
            if (action != 1) {
                if (action == 2) {
                    boolean z = this.mIsDragged;
                    checkCanDragged(motionEvent);
                    if (this.mIsDragged) {
                        this.mDragHelper.processTouchEvent(motionEvent);
                    }
                    if (!z && this.mIsDragged) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        super.onTouchEvent(obtain);
                    }
                } else if (action != 3) {
                    if (this.mIsDragged) {
                        this.mDragHelper.processTouchEvent(motionEvent);
                    }
                }
            }
            if (this.mIsDragged || this.mIsOpen) {
                this.mDragHelper.processTouchEvent(motionEvent);
                motionEvent.setAction(3);
                this.mIsDragged = false;
            }
        }
        return this.mIsDragged || super.onTouchEvent(motionEvent);
    }

    @SuppressLint({"RtlHardcoded"})
    private void checkCanDragged(MotionEvent motionEvent) {
        if (this.mIsDragged) {
            return;
        }
        float x = motionEvent.getX() - this.mDownX;
        float y = motionEvent.getY() - this.mDownY;
        boolean z = x > ((float) this.mTouchSlop) && x > Math.abs(y);
        boolean z2 = x < ((float) (-this.mTouchSlop)) && Math.abs(x) > Math.abs(y);
        if (this.mIsOpen) {
            int i = (int) this.mDownX;
            int i2 = (int) this.mDownY;
            if (isTouchContent(i, i2)) {
                this.mIsDragged = true;
            } else if (isTouchMenu(i, i2)) {
                this.mIsDragged = (isLeftMenu() && z2) || (isRightMenu() && z);
            }
        } else if (z) {
            this.mCurrentMenu = this.mMenus.get(3);
            this.mIsDragged = this.mCurrentMenu != null;
        } else if (z2) {
            this.mCurrentMenu = this.mMenus.get(5);
            this.mIsDragged = this.mCurrentMenu != null;
        }
        if (this.mIsDragged) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            this.mDragHelper.processTouchEvent(obtain);
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"RtlHardcoded"})
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (L.ENABLE) {
            L.d(TAG, "addView");
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((FrameLayout.LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        if (absoluteGravity == 3) {
            this.mMenus.put(3, view);
        } else if (absoluteGravity != 5) {
        } else {
            this.mMenus.put(5, view);
        }
    }

    public void setSwipeEnable(boolean z) {
        this.mSwipeEnable = z;
    }

    public View getContentView() {
        return getChildAt(getChildCount() - 1);
    }

    public boolean isTouchContent(int i, int i2) {
        View contentView = getContentView();
        if (contentView == null) {
            return false;
        }
        Rect rect = new Rect();
        contentView.getHitRect(rect);
        return rect.contains(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"RtlHardcoded"})
    public boolean isLeftMenu() {
        View view = this.mCurrentMenu;
        return view != null && view == this.mMenus.get(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"RtlHardcoded"})
    public boolean isRightMenu() {
        View view = this.mCurrentMenu;
        return view != null && view == this.mMenus.get(5);
    }

    public boolean isTouchMenu(int i, int i2) {
        if (this.mCurrentMenu == null) {
            return false;
        }
        Rect rect = new Rect();
        this.mCurrentMenu.getHitRect(rect);
        return rect.contains(i, i2);
    }

    public void close() {
        if (this.mCurrentMenu == null) {
            this.mIsOpen = false;
            return;
        }
        this.mDragHelper.smoothSlideViewTo(getContentView(), getPaddingLeft(), getPaddingTop());
        invalidate();
    }

    public void open() {
        if (this.mCurrentMenu == null) {
            this.mIsOpen = false;
            return;
        }
        if (isLeftMenu()) {
            this.mDragHelper.smoothSlideViewTo(getContentView(), this.mCurrentMenu.getWidth(), getPaddingTop());
        } else if (isRightMenu()) {
            this.mDragHelper.smoothSlideViewTo(getContentView(), -this.mCurrentMenu.getWidth(), getPaddingTop());
        }
        this.mIsOpen = true;
        invalidate();
    }

    public boolean isOpen() {
        return this.mIsOpen;
    }

    private boolean isOpenAnimating() {
        if (this.mCurrentMenu != null) {
            int left = getContentView().getLeft();
            int width = this.mCurrentMenu.getWidth();
            if (this.mIsOpen) {
                if (!isLeftMenu() || left >= width) {
                    return isRightMenu() && (-left) < width;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isCloseAnimating() {
        if (this.mCurrentMenu != null) {
            int left = getContentView().getLeft();
            if (this.mIsOpen) {
                return false;
            }
            if (!isLeftMenu() || left <= 0) {
                return isRightMenu() && left < 0;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMenu() {
        View contentView = getContentView();
        if (contentView != null) {
            if (contentView.getLeft() == 0) {
                for (View view : this.mMenus.values()) {
                    if (view.getVisibility() != 4) {
                        view.setVisibility(4);
                    }
                }
                return;
            }
            View view2 = this.mCurrentMenu;
            if (view2 == null || view2.getVisibility() == 0) {
                return;
            }
            this.mCurrentMenu.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* loaded from: classes3.dex */
    private class DragCallBack extends ViewDragHelper.Callback {
        private int mRightNum;

        private DragCallBack() {
            this.mRightNum = 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return view == SwipeItemLayout.this.getContentView() || SwipeItemLayout.this.mMenus.containsValue(view);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int i3;
            if (L.ENABLE) {
                L.d(SwipeItemLayout.TAG, "clampViewPositionHorizontal left:" + i + "  dx:" + i2);
            }
            int i4 = 0;
            if (view == SwipeItemLayout.this.getContentView()) {
                if (!SwipeItemLayout.this.isRightMenu()) {
                    if (SwipeItemLayout.this.isLeftMenu()) {
                        if (L.ENABLE) {
                            L.d(SwipeItemLayout.TAG, "getContentView isLeftMenu");
                        }
                        if (i > SwipeItemLayout.this.mCurrentMenu.getWidth()) {
                            return SwipeItemLayout.this.mCurrentMenu.getWidth();
                        }
                        if (i < 0) {
                            return 0;
                        }
                        return i;
                    }
                } else {
                    this.mRightNum += i2;
                    if (L.ENABLE) {
                        L.d(SwipeItemLayout.TAG, "clampViewPositionHorizontal mRightNum:" + this.mRightNum);
                    }
                    if (i > 0) {
                        i3 = 0;
                    } else {
                        i3 = i < (-SwipeItemLayout.this.mCurrentMenu.getWidth()) ? -SwipeItemLayout.this.mCurrentMenu.getWidth() : i;
                    }
                    if (i3 <= (-SwipeItemLayout.this.mCurrentMenu.getWidth())) {
                        i3 = (((SwipeItemLayout.this.mCurrentMenu.getWidth() - 10) * (SwipeItemLayout.this.mCurrentMenu.getWidth() - 10)) / ((-this.mRightNum) - 3)) - ((SwipeItemLayout.this.mCurrentMenu.getWidth() * 2) - 20);
                    }
                    if (L.ENABLE) {
                        L.d(SwipeItemLayout.TAG, "getContentView isRightMenu left:" + i + "update:" + i3);
                    }
                    return i3;
                }
            } else if (!SwipeItemLayout.this.isRightMenu()) {
                if (SwipeItemLayout.this.isLeftMenu()) {
                    if (L.ENABLE) {
                        L.d(SwipeItemLayout.TAG, "isLeftMenu");
                    }
                    View contentView = SwipeItemLayout.this.getContentView();
                    int left = i2 + contentView.getLeft();
                    if (left >= 0) {
                        i4 = left > view.getWidth() ? view.getWidth() : left;
                    }
                    contentView.layout(i4, contentView.getTop(), contentView.getWidth() + i4, contentView.getBottom());
                    return view.getLeft();
                }
            } else {
                if (L.ENABLE) {
                    L.d(SwipeItemLayout.TAG, "isRightMenu");
                }
                View contentView2 = SwipeItemLayout.this.getContentView();
                int left2 = i2 + contentView2.getLeft();
                if (left2 <= 0) {
                    i4 = left2 < (-view.getWidth()) ? -view.getWidth() : left2;
                }
                contentView2.layout(i4, contentView2.getTop(), contentView2.getWidth() + i4, contentView2.getBottom());
                return view.getLeft();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, i, i2, i3, i4);
            if (i == 0) {
                SwipeItemLayout.this.mIsOpen = false;
            }
            SwipeItemLayout.this.updateMenu();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            L.Tag tag = SwipeItemLayout.TAG;
            L.e(tag, "onViewReleased: " + f + " ,releasedChild = " + view);
            this.mRightNum = 0;
            if (SwipeItemLayout.this.isLeftMenu()) {
                if (f <= SwipeItemLayout.this.mVelocity) {
                    if (f >= (-SwipeItemLayout.this.mVelocity)) {
                        if (SwipeItemLayout.this.getContentView().getLeft() > (SwipeItemLayout.this.mCurrentMenu.getWidth() / 3) * 2) {
                            SwipeItemLayout.this.open();
                            return;
                        } else {
                            SwipeItemLayout.this.close();
                            return;
                        }
                    }
                    SwipeItemLayout.this.close();
                    return;
                }
                SwipeItemLayout.this.open();
            } else if (SwipeItemLayout.this.isRightMenu()) {
                if (f >= (-SwipeItemLayout.this.mVelocity)) {
                    if (f <= SwipeItemLayout.this.mVelocity) {
                        if (SwipeItemLayout.this.getContentView().getLeft() < ((-SwipeItemLayout.this.mCurrentMenu.getWidth()) / 3) * 2) {
                            SwipeItemLayout.this.open();
                            return;
                        } else {
                            SwipeItemLayout.this.close();
                            return;
                        }
                    }
                    SwipeItemLayout.this.close();
                    return;
                }
                SwipeItemLayout.this.open();
            }
        }
    }
}
