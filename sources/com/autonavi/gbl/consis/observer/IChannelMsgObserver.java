package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.router.ChannelMsgObserverRouter;
@IntfAuto(target = ChannelMsgObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelMsgObserver {
    int onNotifyMsg(ChannelMsgHead channelMsgHead, ChannelParcel channelParcel);
}
