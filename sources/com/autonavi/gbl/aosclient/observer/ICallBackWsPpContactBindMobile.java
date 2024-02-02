package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpContactBindMobileResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpContactBindMobileRouter;
@IntfAuto(target = CallBackWsPpContactBindMobileRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpContactBindMobile {
    void onRecvAck(GWsPpContactBindMobileResponseParam gWsPpContactBindMobileResponseParam);
}
