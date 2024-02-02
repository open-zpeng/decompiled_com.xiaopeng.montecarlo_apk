package com.autonavi.gbl.user.forcast.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.forcast.model.ForcastArrivedData;
import com.autonavi.gbl.user.router.ForcastServiceObserverRouter;
import com.autonavi.gbl.util.model.ErrorCode;
@IntfAuto(target = ForcastServiceObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IForcastServiceObserver {
    void onForcastArrivedData(ForcastArrivedData forcastArrivedData);

    void onInit(@ErrorCode.ErrorCode1 int i);

    void onSetLoginInfo(@ErrorCode.ErrorCode1 int i);
}
