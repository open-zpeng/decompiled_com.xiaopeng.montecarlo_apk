package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GUserDeviceResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackUserDeviceRouter;
@IntfAuto(target = CallBackUserDeviceRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackUserDevice {
    void onRecvAck(GUserDeviceResponseParam gUserDeviceResponseParam);
}
