package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.model.RuntimeInfo;
import com.autonavi.gbl.util.router.RuntimeInfoObserverRouter;
@IntfAuto(target = RuntimeInfoObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRuntimeInfoObserver {
    void onRuntimeInfoResponse(RuntimeInfo runtimeInfo);
}
