package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
/* loaded from: classes2.dex */
public class NaviRestrictEventCallback implements RestrictHelper.IRestrictEventCallback {
    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictEventCallback
    public void onResponseError(long j, int i) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper.IRestrictEventCallback
    public boolean onShowRestrictGuide(short s) {
        return true;
    }
}
