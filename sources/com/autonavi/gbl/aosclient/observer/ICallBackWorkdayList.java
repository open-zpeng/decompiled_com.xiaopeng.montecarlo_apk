package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWorkdayListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWorkdayListRouter;
@IntfAuto(target = CallBackWorkdayListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWorkdayList {
    void onRecvAck(GWorkdayListResponseParam gWorkdayListResponseParam);
}
