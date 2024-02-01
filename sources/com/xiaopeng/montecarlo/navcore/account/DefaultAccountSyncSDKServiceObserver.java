package com.xiaopeng.montecarlo.navcore.account;

import androidx.annotation.NonNull;
import com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class DefaultAccountSyncSDKServiceObserver implements ISyncSDKServiceObserver {
    @NonNull
    private static final L.Tag TAG = new L.Tag("DefaultAccountSyncSDKServiceObserver");

    @Override // com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver
    public void notify(int i, int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "notify syncEventType = [" + i + "], syncRet = [" + i2 + "]");
        }
    }
}
