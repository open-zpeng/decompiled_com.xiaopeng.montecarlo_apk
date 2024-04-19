package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.MapResourceParam;
import com.autonavi.gbl.map.model.ReportCode;
import com.autonavi.gbl.map.model.ReportType;
import com.autonavi.gbl.map.router.BLMapEngineProxyRouter;
@IntfAuto(target = BLMapEngineProxyRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IBLMapEngineProxy {
    void onMapLogReporter(long j, @ReportType.ReportType1 int i, @ReportCode.ReportCode1 int i2, String str);

    void onSendBehaviorLog(long j, String str, String str2, String str3);

    void requireMapRender(long j, int i, int i2);

    byte[] requireMapResource(long j, MapResourceParam mapResourceParam);
}
