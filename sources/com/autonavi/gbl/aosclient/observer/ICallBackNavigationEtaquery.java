package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackNavigationEtaqueryRouter;
@IntfAuto(target = CallBackNavigationEtaqueryRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackNavigationEtaquery {
    void onRecvAck(GNavigationEtaqueryResponseParam gNavigationEtaqueryResponseParam);
}
