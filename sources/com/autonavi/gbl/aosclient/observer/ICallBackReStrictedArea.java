package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackReStrictedAreaRouter;
@IntfAuto(target = CallBackReStrictedAreaRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackReStrictedArea {
    void onRecvAck(GReStrictedAreaResponseParam gReStrictedAreaResponseParam);
}
