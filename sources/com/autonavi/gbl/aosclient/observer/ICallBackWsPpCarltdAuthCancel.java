package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdAuthCancelResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpCarltdAuthCancelRouter;
@IntfAuto(target = CallBackWsPpCarltdAuthCancelRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpCarltdAuthCancel {
    void onRecvAck(GWsPpCarltdAuthCancelResponseParam gWsPpCarltdAuthCancelResponseParam);
}
