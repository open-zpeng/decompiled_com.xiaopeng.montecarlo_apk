package com.autonavi.gbl.activation.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.activation.model.AuthenticationGoodsInfo;
import com.autonavi.gbl.activation.model.AuthenticationResult;
import com.autonavi.gbl.activation.router.AuthenticationObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = AuthenticationObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IAuthenticationObserver {
    default void onError(AuthenticationResult authenticationResult) {
    }

    default void onStatusUpdated(int i, ArrayList<AuthenticationGoodsInfo> arrayList) {
    }
}
