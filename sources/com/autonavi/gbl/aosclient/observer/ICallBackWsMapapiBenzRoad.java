package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsMapapiBenzRoadResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsMapapiBenzRoadRouter;
@IntfAuto(target = CallBackWsMapapiBenzRoadRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsMapapiBenzRoad {
    void onRecvAck(GWsMapapiBenzRoadResponseParam gWsMapapiBenzRoadResponseParam);
}
