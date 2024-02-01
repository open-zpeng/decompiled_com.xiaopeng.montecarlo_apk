package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceIotDeviceListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceIotDeviceListRouter;
@IntfAuto(target = CallBackWsTserviceIotDeviceListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceIotDeviceList {
    void onRecvAck(GWsTserviceIotDeviceListResponseParam gWsTserviceIotDeviceListResponseParam);
}
