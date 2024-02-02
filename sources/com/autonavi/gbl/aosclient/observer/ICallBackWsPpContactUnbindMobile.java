package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpContactUnbindMobileResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpContactUnbindMobileRouter;
@IntfAuto(target = CallBackWsPpContactUnbindMobileRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpContactUnbindMobile {
    void onRecvAck(GWsPpContactUnbindMobileResponseParam gWsPpContactUnbindMobileResponseParam);
}
