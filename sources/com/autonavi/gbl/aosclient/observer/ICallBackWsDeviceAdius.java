package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsDeviceAdiusResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsDeviceAdiusRouter;
@IntfAuto(target = CallBackWsDeviceAdiusRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsDeviceAdius {
    void onRecvAck(GWsDeviceAdiusResponseParam gWsDeviceAdiusResponseParam);
}
