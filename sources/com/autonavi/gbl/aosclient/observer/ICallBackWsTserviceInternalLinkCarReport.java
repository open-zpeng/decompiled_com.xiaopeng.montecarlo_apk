package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarReportResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsTserviceInternalLinkCarReportRouter;
@IntfAuto(target = CallBackWsTserviceInternalLinkCarReportRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsTserviceInternalLinkCarReport {
    void onRecvAck(GWsTserviceInternalLinkCarReportResponseParam gWsTserviceInternalLinkCarReportResponseParam);
}
