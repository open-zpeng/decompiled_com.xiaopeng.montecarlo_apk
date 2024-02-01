package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinStatusResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpAutoWeixinStatusRouter;
@IntfAuto(target = CallBackWsPpAutoWeixinStatusRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpAutoWeixinStatus {
    void onRecvAck(GWsPpAutoWeixinStatusResponseParam gWsPpAutoWeixinStatusResponseParam);
}
