package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.xui.widget.XScrollView;
/* loaded from: classes3.dex */
public class XpPoiPopScrollView extends XScrollView {
    private long mDelayMillis;
    private boolean mIsAlive;
    private long mLastScrollUpdate;
    private OnScrollListener mOnScrollListener;
    private Runnable mScrollerTask;

    /* loaded from: classes3.dex */
    public interface OnScrollListener {
        void onScrollChanged(ScrollView scrollView, int i, int i2, int i3, int i4);

        void onScrollEnd();

        void onScrollStart();
    }

    public XpPoiPopScrollView(Context context) {
        super(context);
        this.mLastScrollUpdate = -1L;
        this.mDelayMillis = 150L;
        this.mIsAlive = false;
        this.mScrollerTask = new Runnable() { // from class: com.xiaopeng.montecarlo.views.XpPoiPopScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                if (XpPoiPopScrollView.this.mIsAlive) {
                    if (System.currentTimeMillis() - XpPoiPopScrollView.this.mLastScrollUpdate > 100) {
                        XpPoiPopScrollView.this.mLastScrollUpdate = -1L;
                        if (XpPoiPopScrollView.this.mOnScrollListener != null) {
                            XpPoiPopScrollView.this.mOnScrollListener.onScrollEnd();
                            return;
                        }
                        return;
                    }
                    XpPoiPopScrollView xpPoiPopScrollView = XpPoiPopScrollView.this;
                    xpPoiPopScrollView.postDelayed(this, xpPoiPopScrollView.mDelayMillis);
                }
            }
        };
    }

    public XpPoiPopScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastScrollUpdate = -1L;
        this.mDelayMillis = 150L;
        this.mIsAlive = false;
        this.mScrollerTask = new Runnable() { // from class: com.xiaopeng.montecarlo.views.XpPoiPopScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                if (XpPoiPopScrollView.this.mIsAlive) {
                    if (System.currentTimeMillis() - XpPoiPopScrollView.this.mLastScrollUpdate > 100) {
                        XpPoiPopScrollView.this.mLastScrollUpdate = -1L;
                        if (XpPoiPopScrollView.this.mOnScrollListener != null) {
                            XpPoiPopScrollView.this.mOnScrollListener.onScrollEnd();
                            return;
                        }
                        return;
                    }
                    XpPoiPopScrollView xpPoiPopScrollView = XpPoiPopScrollView.this;
                    xpPoiPopScrollView.postDelayed(this, xpPoiPopScrollView.mDelayMillis);
                }
            }
        };
    }

    public XpPoiPopScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastScrollUpdate = -1L;
        this.mDelayMillis = 150L;
        this.mIsAlive = false;
        this.mScrollerTask = new Runnable() { // from class: com.xiaopeng.montecarlo.views.XpPoiPopScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                if (XpPoiPopScrollView.this.mIsAlive) {
                    if (System.currentTimeMillis() - XpPoiPopScrollView.this.mLastScrollUpdate > 100) {
                        XpPoiPopScrollView.this.mLastScrollUpdate = -1L;
                        if (XpPoiPopScrollView.this.mOnScrollListener != null) {
                            XpPoiPopScrollView.this.mOnScrollListener.onScrollEnd();
                            return;
                        }
                        return;
                    }
                    XpPoiPopScrollView xpPoiPopScrollView = XpPoiPopScrollView.this;
                    xpPoiPopScrollView.postDelayed(this, xpPoiPopScrollView.mDelayMillis);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAlive = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XScrollView, android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAlive = false;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        OnScrollListener onScrollListener;
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener2 = this.mOnScrollListener;
        if (onScrollListener2 != null) {
            onScrollListener2.onScrollChanged(this, i, i2, i3, i4);
        }
        if (this.mLastScrollUpdate == -1 && (onScrollListener = this.mOnScrollListener) != null) {
            onScrollListener.onScrollStart();
            postDelayed(this.mScrollerTask, this.mDelayMillis);
        }
        this.mLastScrollUpdate = System.currentTimeMillis();
    }

    public void setScrollViewListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("XpPoiPopScrollView draw error");
        }
    }

    public void scrollToBottom() {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.views.XpPoiPopScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                if (XpPoiPopScrollView.this.mIsAlive) {
                    XpPoiPopScrollView.this.fullScroll(130);
                }
            }
        }, this.mDelayMillis);
    }

    public void scrollToTop() {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.views.XpPoiPopScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                if (XpPoiPopScrollView.this.mIsAlive) {
                    XpPoiPopScrollView.this.scrollTo(0, 0);
                }
            }
        }, this.mDelayMillis);
    }
}
