package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsFencingGroupsQueryResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsFencingGroupsQueryRouter;
@IntfAuto(target = CallBackWsFencingGroupsQueryRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsFencingGroupsQuery {
    void onRecvAck(GWsFencingGroupsQueryResponseParam gWsFencingGroupsQueryResponseParam);
}
