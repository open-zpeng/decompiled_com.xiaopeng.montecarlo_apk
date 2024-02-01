package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinQrcodeResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpAutoWeixinQrcodeRouter;
@IntfAuto(target = CallBackWsPpAutoWeixinQrcodeRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpAutoWeixinQrcode {
    void onRecvAck(GWsPpAutoWeixinQrcodeResponseParam gWsPpAutoWeixinQrcodeResponseParam);
}
