package com.autonavi.gbl.ehp.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.ehp.router.GEhpAdasDataCallbackRouter;
@IntfAuto(target = GEhpAdasDataCallbackRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGEhpAdasDataCallback {
    void adasDataResponse(String str);
}
