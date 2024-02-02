package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaopeng.xui.widget.XViewPager;
/* loaded from: classes3.dex */
public class XPViewPager extends XViewPager {
    public XPViewPager(Context context) {
        super(context);
    }

    public XPViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return canScroll() && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return canScroll() && super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        return super.canScroll(view, z, i, i2, i3);
    }

    private boolean canScroll() {
        return getAdapter() != null && getAdapter().getCount() > 1;
    }
}
