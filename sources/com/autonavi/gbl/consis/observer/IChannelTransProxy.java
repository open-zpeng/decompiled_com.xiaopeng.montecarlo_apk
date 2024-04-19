package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.router.ChannelTransProxyRouter;
@IntfAuto(target = ChannelTransProxyRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelTransProxy {
    long writeData(long j, long j2);
}
