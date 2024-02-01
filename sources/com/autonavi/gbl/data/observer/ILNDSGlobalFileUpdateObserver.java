package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.router.LNDSGlobalFileUpdateObserverRouter;
import java.math.BigInteger;
@IntfAuto(target = LNDSGlobalFileUpdateObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILNDSGlobalFileUpdateObserver {
    default void onGlobalFileUpdate(BigInteger bigInteger, int i) {
    }

    default void onGlobalFileVersion(BigInteger bigInteger, String str) {
    }

    default void onTileGlobalFileUpdate(BigInteger bigInteger, int i) {
    }
}
