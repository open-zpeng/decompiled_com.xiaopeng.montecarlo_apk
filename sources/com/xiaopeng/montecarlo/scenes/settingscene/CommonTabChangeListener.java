package com.xiaopeng.montecarlo.scenes.settingscene;

import com.xiaopeng.xui.widget.XTabLayout;
/* loaded from: classes3.dex */
public abstract class CommonTabChangeListener implements XTabLayout.OnTabChangeListener {
    boolean mIsPlayAnim = false;

    public abstract void onTabSelected(int i);

    @Override // com.xiaopeng.xui.widget.XTabLayout.OnTabChangeListener
    public boolean onInterceptTabChange(XTabLayout xTabLayout, int i, boolean z, boolean z2) {
        return this.mIsPlayAnim;
    }

    @Override // com.xiaopeng.xui.widget.XTabLayout.OnTabChangeListener
    public void onTabChangeStart(XTabLayout xTabLayout, int i, boolean z, boolean z2) {
        this.mIsPlayAnim = true;
    }

    @Override // com.xiaopeng.xui.widget.XTabLayout.OnTabChangeListener
    public void onTabChangeEnd(XTabLayout xTabLayout, int i, boolean z, boolean z2) {
        this.mIsPlayAnim = false;
        onTabSelected(i);
    }
}
