package com.xiaopeng.montecarlo.navcore.account;

import androidx.annotation.NonNull;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DefaultAccountBehaviorServiceObserver implements IBehaviorServiceObserver {
    @NonNull
    private static final L.Tag TAG = new L.Tag("DefaultAccountBehaviorServiceObserver");

    @Override // com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver
    public void notify(int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z) {
    }

    @Override // com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver
    public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "notify syncEventType = [" + i + "], syncRet = [" + i2 + "]");
        }
    }
}
