package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GDriveReportSmsResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackDriveReportSmsRouter;
@IntfAuto(target = CallBackDriveReportSmsRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackDriveReportSms {
    void onRecvAck(GDriveReportSmsResponseParam gDriveReportSmsResponseParam);
}
