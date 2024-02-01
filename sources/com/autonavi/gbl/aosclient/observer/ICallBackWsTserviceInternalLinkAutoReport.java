package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkAutoReportResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkAutoReportRouter;
@IntfAuto(target = CallBackWsTserviceInternalLinkAutoReportRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceInternalLinkAutoReport {
    void onRecvAck(GWsTserviceInternalLinkAutoReportResponseParam gWsTserviceInternalLinkAutoReportResponseParam);
}
