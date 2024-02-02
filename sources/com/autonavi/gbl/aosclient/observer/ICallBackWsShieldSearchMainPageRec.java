package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldSearchMainPageRecResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsShieldSearchMainPageRecRouter;
@IntfAuto(target = CallBackWsShieldSearchMainPageRecRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsShieldSearchMainPageRec {
    void onRecvAck(GWsShieldSearchMainPageRecResponseParam gWsShieldSearchMainPageRecResponseParam);
}
