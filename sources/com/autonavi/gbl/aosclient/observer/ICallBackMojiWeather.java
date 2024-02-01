package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GMojiWeatherResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackMojiWeatherRouter;
@IntfAuto(target = CallBackMojiWeatherRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackMojiWeather {
    void onRecvAck(GMojiWeatherResponseParam gMojiWeatherResponseParam);
}
