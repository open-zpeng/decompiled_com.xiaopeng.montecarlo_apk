package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicFatigueResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsNavigationDynamicFatigueRouter;
@IntfAuto(target = CallBackWsNavigationDynamicFatigueRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsNavigationDynamicFatigue {
    void onRecvAck(GWsNavigationDynamicFatigueResponseParam gWsNavigationDynamicFatigueResponseParam);
}
