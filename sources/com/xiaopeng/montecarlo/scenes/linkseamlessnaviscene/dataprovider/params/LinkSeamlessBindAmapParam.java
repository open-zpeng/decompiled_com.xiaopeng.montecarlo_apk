package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.params;

import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.LinkSeamlessRequestParam;
/* loaded from: classes3.dex */
public class LinkSeamlessBindAmapParam extends LinkSeamlessRequestParam {
    private boolean mIsQuickLogin;

    public LinkSeamlessBindAmapParam(boolean z) {
        this.mIsQuickLogin = z;
    }

    public boolean isQuickLogin() {
        return this.mIsQuickLogin;
    }

    public void setQuickLogin(boolean z) {
        this.mIsQuickLogin = z;
    }
}
