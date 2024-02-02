package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.BLResponseBase;
import com.autonavi.gbl.aosclient.router.BLAosCallBackRouter;
@IntfAuto(target = BLAosCallBackRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IBLAosCallBack {
    void onRecvResponse(BLResponseBase bLResponseBase);
}
