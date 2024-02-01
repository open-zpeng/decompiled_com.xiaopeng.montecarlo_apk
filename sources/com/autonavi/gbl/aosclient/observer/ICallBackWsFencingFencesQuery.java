package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsFencingFencesQueryResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsFencingFencesQueryRouter;
@IntfAuto(target = CallBackWsFencingFencesQueryRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsFencingFencesQuery {
    void onRecvAck(GWsFencingFencesQueryResponseParam gWsFencingFencesQueryResponseParam);
}
