package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcPoiInfoResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcPoiInfoRouter;
@IntfAuto(target = CallBackWsTcPoiInfoRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcPoiInfo {
    void onRecvAck(GWsTcPoiInfoResponseParam gWsTcPoiInfoResponseParam);
}
