package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcOrderApiMergeListResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTcOrderApiMergeListRouter;
@IntfAuto(target = CallBackWsTcOrderApiMergeListRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTcOrderApiMergeList {
    void onRecvAck(GWsTcOrderApiMergeListResponseParam gWsTcOrderApiMergeListResponseParam);
}
