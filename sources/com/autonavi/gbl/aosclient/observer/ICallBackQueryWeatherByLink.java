package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GQueryWeatherByLinkResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackQueryWeatherByLinkRouter;
@IntfAuto(target = CallBackQueryWeatherByLinkRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackQueryWeatherByLink {
    void onRecvAck(GQueryWeatherByLinkResponseParam gQueryWeatherByLinkResponseParam);
}
