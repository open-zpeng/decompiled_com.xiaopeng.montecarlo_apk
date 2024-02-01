package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsEventSearchResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsEventSearchRouter;
@IntfAuto(target = CallBackWsEventSearchRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsEventSearch {
    void onRecvAck(GWsEventSearchResponseParam gWsEventSearchResponseParam);
}
