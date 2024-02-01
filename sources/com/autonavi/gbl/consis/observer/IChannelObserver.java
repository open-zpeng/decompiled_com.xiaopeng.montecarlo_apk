package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.router.ChannelObserverRouter;
@IntfAuto(target = ChannelObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelObserver {
    default void onChannelCreate(String str, String str2) {
    }

    default void onChannelDestroy(String str, String str2) {
    }
}
