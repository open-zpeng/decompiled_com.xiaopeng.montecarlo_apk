package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsAppConfAppUpdateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsAppConfAppUpdateRouter;
@IntfAuto(target = CallBackWsAppConfAppUpdateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsAppConfAppUpdate {
    void onRecvAck(GWsAppConfAppUpdateResponseParam gWsAppConfAppUpdateResponseParam);
}
