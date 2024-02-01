package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviRecordResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsUserviewFootprintNaviRecordRouter;
@IntfAuto(target = CallBackWsUserviewFootprintNaviRecordRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsUserviewFootprintNaviRecord {
    void onRecvAck(GWsUserviewFootprintNaviRecordResponseParam gWsUserviewFootprintNaviRecordResponseParam);
}
