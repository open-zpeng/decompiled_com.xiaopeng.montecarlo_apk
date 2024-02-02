package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GHolidayListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackHolidayListRouter;
@IntfAuto(target = CallBackHolidayListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackHolidayList {
    void onRecvAck(GHolidayListResponseParam gHolidayListResponseParam);
}
