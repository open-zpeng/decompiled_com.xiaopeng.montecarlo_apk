package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeUrlTranslateResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackWsPpQrcodeUrlTranslateRouter;
@IntfAuto(target = CallBackWsPpQrcodeUrlTranslateRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackWsPpQrcodeUrlTranslate {
    void onRecvAck(GWsPpQrcodeUrlTranslateResponseParam gWsPpQrcodeUrlTranslateResponseParam);
}
