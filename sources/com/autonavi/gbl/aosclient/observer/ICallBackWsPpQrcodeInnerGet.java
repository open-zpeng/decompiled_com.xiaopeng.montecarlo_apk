package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeInnerGetResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpQrcodeInnerGetRouter;
@IntfAuto(target = CallBackWsPpQrcodeInnerGetRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpQrcodeInnerGet {
    void onRecvAck(GWsPpQrcodeInnerGetResponseParam gWsPpQrcodeInnerGetResponseParam);
}
