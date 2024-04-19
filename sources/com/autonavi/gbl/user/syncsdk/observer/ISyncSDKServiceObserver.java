package com.autonavi.gbl.user.syncsdk.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.router.SyncSDKServiceObserverRouter;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
@IntfAuto(target = SyncSDKServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ISyncSDKServiceObserver {
    void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2);
}
