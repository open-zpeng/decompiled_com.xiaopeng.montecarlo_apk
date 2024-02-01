package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdLogin4bindResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpCarltdLogin4bindRouter;
@IntfAuto(target = CallBackWsPpCarltdLogin4bindRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpCarltdLogin4bind {
    void onRecvAck(GWsPpCarltdLogin4bindResponseParam gWsPpCarltdLogin4bindResponseParam);
}
