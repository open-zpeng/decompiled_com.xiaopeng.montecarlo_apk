package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpAccountProfileUpdateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpAccountProfileUpdateRouter;
@IntfAuto(target = CallBackWsPpAccountProfileUpdateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpAccountProfileUpdate {
    void onRecvAck(GWsPpAccountProfileUpdateResponseParam gWsPpAccountProfileUpdateResponseParam);
}
