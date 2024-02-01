package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicDataResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsNavigationDynamicDataRouter;
@IntfAuto(target = CallBackWsNavigationDynamicDataRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsNavigationDynamicData {
    void onRecvAck(GWsNavigationDynamicDataResponseParam gWsNavigationDynamicDataResponseParam);
}
