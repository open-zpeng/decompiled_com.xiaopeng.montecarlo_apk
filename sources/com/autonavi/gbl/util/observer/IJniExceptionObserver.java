package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.router.JniExceptionObserverRouter;
@IntfAuto(target = JniExceptionObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IJniExceptionObserver {
    void onException(String str);
}
