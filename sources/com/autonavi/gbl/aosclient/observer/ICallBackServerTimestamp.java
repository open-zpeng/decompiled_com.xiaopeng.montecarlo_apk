package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GServerTimestampResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackServerTimestampRouter;
@IntfAuto(target = CallBackServerTimestampRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackServerTimestamp {
    void onRecvAck(GServerTimestampResponseParam gServerTimestampResponseParam);
}
