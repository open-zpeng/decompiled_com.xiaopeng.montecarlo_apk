package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.router.ChannelProxyAdapterRouter;
@IntfAuto(target = ChannelProxyAdapterRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelProxyAdapter {
    long writeData(byte[] bArr);
}
