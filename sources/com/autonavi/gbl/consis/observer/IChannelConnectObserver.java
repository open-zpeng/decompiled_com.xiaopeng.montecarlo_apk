package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.model.ConnectMsgHead;
import com.autonavi.gbl.consis.router.ChannelConnectObserverRouter;
@IntfAuto(target = ChannelConnectObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelConnectObserver {
    void onChannelConnect(ConnectMsgHead connectMsgHead, ChannelTransProxy channelTransProxy);

    void onChannelDestroy(ConnectMsgHead connectMsgHead, ChannelTransProxy channelTransProxy);

    void onCustomDataIncome(ChannelParcel channelParcel, ChannelTransProxy channelTransProxy);
}
