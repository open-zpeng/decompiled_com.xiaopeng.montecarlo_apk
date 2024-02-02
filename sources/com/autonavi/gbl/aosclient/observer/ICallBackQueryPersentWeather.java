package com.autonavi.gbl.aosclient.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.autonavi.gbl.aosclient.router.CallBackQueryPersentWeatherRouter;
@IntfAuto(target = CallBackQueryPersentWeatherRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICallBackQueryPersentWeather {
    void onRecvAck(GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam);
}
