package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.router.ChannelMessageObserverRouter;
@IntfAuto(target = ChannelMessageObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelMessageObserver {
    void onNotifyMsg(ChannelMsgHead channelMsgHead, ChannelParcel channelParcel);
}
