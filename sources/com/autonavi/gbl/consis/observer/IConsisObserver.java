package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.router.ConsisObserverRouter;
@IntfAuto(target = ConsisObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IConsisObserver {
    default void onReceiveMessage(ChannelMsgHead channelMsgHead, ChannelParcel channelParcel) {
    }

    default void onSendMessage(ChannelMsgHead channelMsgHead, ChannelParcel channelParcel) {
    }
}
