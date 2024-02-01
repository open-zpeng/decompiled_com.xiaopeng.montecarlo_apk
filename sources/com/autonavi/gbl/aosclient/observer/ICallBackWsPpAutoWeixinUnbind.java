package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinUnbindResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpAutoWeixinUnbindRouter;
@IntfAuto(target = CallBackWsPpAutoWeixinUnbindRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpAutoWeixinUnbind {
    void onRecvAck(GWsPpAutoWeixinUnbindResponseParam gWsPpAutoWeixinUnbindResponseParam);
}
