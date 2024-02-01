package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.model.ObjLifeState;
import com.autonavi.gbl.util.router.ObjLifeStateObserverRouter;
@IntfAuto(target = ObjLifeStateObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IObjLifeStateObserver {
    void inProgress(@ObjLifeState.ObjLifeState1 int i, long j, String str);
}
