package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.router.ChannelProxyObserverRouter;
@IntfAuto(target = ChannelProxyObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelProxyObserver {
    default void onChannelProxyConnect(String str) {
    }

    default void onChannelProxyDisconnect(String str) {
    }
}
