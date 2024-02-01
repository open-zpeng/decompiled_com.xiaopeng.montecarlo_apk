package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GLbpEventSyncCommonResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackLbpEventSyncCommonRouter;
@IntfAuto(target = CallBackLbpEventSyncCommonRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackLbpEventSyncCommon {
    void onRecvAck(GLbpEventSyncCommonResponseParam gLbpEventSyncCommonResponseParam);
}
