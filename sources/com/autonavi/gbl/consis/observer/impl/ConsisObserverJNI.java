package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
/* loaded from: classes.dex */
public class ConsisObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static long SwigDirector_IChannelProxyAdapterImpl_writeData(IChannelProxyAdapterImpl iChannelProxyAdapterImpl, byte[] bArr) {
        return iChannelProxyAdapterImpl.writeData(bArr);
    }

    public static void SwigDirector_IChannelMessageObserverImpl_onNotifyMsg(IChannelMessageObserverImpl iChannelMessageObserverImpl, ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        iChannelMessageObserverImpl.onNotifyMsg(channelMsgHead, channelParcelImpl);
    }

    public static boolean SwigDirector_IConsisMessageAdapterImpl_onStartNavi(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j, @NaviType.NaviType1 int i, int i2) {
        return iConsisMessageAdapterImpl.onStartNavi(j, i, i2);
    }

    public static boolean SwigDirector_IConsisMessageAdapterImpl_onStopNavi(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j, int i) {
        return iConsisMessageAdapterImpl.onStopNavi(j, i);
    }

    public static boolean SwigDirector_IConsisMessageAdapterImpl_onPauseNavi(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j, int i) {
        return iConsisMessageAdapterImpl.onPauseNavi(j, i);
    }

    public static boolean SwigDirector_IConsisMessageAdapterImpl_onResumeNavi(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j, int i) {
        return iConsisMessageAdapterImpl.onResumeNavi(j, i);
    }

    public static boolean SwigDirector_IConsisMessageAdapterImpl_onSetNaviPath(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, NaviPathImpl naviPathImpl, int i) {
        return iConsisMessageAdapterImpl.onSetNaviPath(naviPathImpl, i);
    }

    public static void SwigDirector_IConsisMessageAdapterImpl_onSelectMainPathID(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j, int i) {
        iConsisMessageAdapterImpl.onSelectMainPathID(j, i);
    }

    public static void SwigDirector_IChannelProxyObserverImpl_onChannelProxyConnect(IChannelProxyObserverImpl iChannelProxyObserverImpl, String str) {
        iChannelProxyObserverImpl.onChannelProxyConnect(str);
    }

    public static void SwigDirector_IChannelProxyObserverImpl_onChannelProxyDisconnect(IChannelProxyObserverImpl iChannelProxyObserverImpl, String str) {
        iChannelProxyObserverImpl.onChannelProxyDisconnect(str);
    }

    public static void SwigDirector_IChannelObserverImpl_onChannelCreate(IChannelObserverImpl iChannelObserverImpl, String str, String str2) {
        iChannelObserverImpl.onChannelCreate(str, str2);
    }

    public static void SwigDirector_IChannelObserverImpl_onChannelDestroy(IChannelObserverImpl iChannelObserverImpl, String str, String str2) {
        iChannelObserverImpl.onChannelDestroy(str, str2);
    }

    public static void SwigDirector_IConsisObserverImpl_onSendMessage(IConsisObserverImpl iConsisObserverImpl, ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        iConsisObserverImpl.onSendMessage(channelMsgHead, channelParcelImpl);
    }

    public static void SwigDirector_IConsisObserverImpl_onReceiveMessage(IConsisObserverImpl iConsisObserverImpl, ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        iConsisObserverImpl.onReceiveMessage(channelMsgHead, channelParcelImpl);
    }
}
