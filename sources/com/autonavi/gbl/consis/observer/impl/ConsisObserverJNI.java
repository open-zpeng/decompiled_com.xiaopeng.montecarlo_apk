package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.model.ConnectMsgHead;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
/* loaded from: classes.dex */
public class ConsisObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static int SwigDirector_IChannelMsgObserverImpl_onNotifyMsg(IChannelMsgObserverImpl iChannelMsgObserverImpl, ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        return iChannelMsgObserverImpl.onNotifyMsg(channelMsgHead, channelParcelImpl);
    }

    public static boolean SwigDirector_IChannelMsgTransferImpl_onStartNavi(IChannelMsgTransferImpl iChannelMsgTransferImpl, long j, @NaviType.NaviType1 int i, int i2) {
        return iChannelMsgTransferImpl.onStartNavi(j, i, i2);
    }

    public static boolean SwigDirector_IChannelMsgTransferImpl_onStopNavi(IChannelMsgTransferImpl iChannelMsgTransferImpl, long j, int i) {
        return iChannelMsgTransferImpl.onStopNavi(j, i);
    }

    public static boolean SwigDirector_IChannelMsgTransferImpl_onPauseNavi(IChannelMsgTransferImpl iChannelMsgTransferImpl, long j, int i) {
        return iChannelMsgTransferImpl.onPauseNavi(j, i);
    }

    public static boolean SwigDirector_IChannelMsgTransferImpl_onResumeNavi(IChannelMsgTransferImpl iChannelMsgTransferImpl, long j, int i) {
        return iChannelMsgTransferImpl.onResumeNavi(j, i);
    }

    public static boolean SwigDirector_IChannelMsgTransferImpl_onSetNaviPath(IChannelMsgTransferImpl iChannelMsgTransferImpl, NaviPathImpl naviPathImpl, long j, int i) {
        return iChannelMsgTransferImpl.onSetNaviPath(naviPathImpl, j, i);
    }

    public static void SwigDirector_IChannelMsgTransferImpl_onSelectMainPathID(IChannelMsgTransferImpl iChannelMsgTransferImpl, long j, int i) {
        iChannelMsgTransferImpl.onSelectMainPathID(j, i);
    }

    public static void SwigDirector_IChannelConnectObserverImpl_onCustomDataIncome(IChannelConnectObserverImpl iChannelConnectObserverImpl, ChannelParcelImpl channelParcelImpl, IChannelTransProxyImpl iChannelTransProxyImpl) {
        iChannelConnectObserverImpl.onCustomDataIncome(channelParcelImpl, iChannelTransProxyImpl);
    }

    public static void SwigDirector_IChannelConnectObserverImpl_onChannelConnect(IChannelConnectObserverImpl iChannelConnectObserverImpl, ConnectMsgHead connectMsgHead, IChannelTransProxyImpl iChannelTransProxyImpl) {
        iChannelConnectObserverImpl.onChannelConnect(connectMsgHead, iChannelTransProxyImpl);
    }

    public static void SwigDirector_IChannelConnectObserverImpl_onChannelDestroy(IChannelConnectObserverImpl iChannelConnectObserverImpl, ConnectMsgHead connectMsgHead, IChannelTransProxyImpl iChannelTransProxyImpl) {
        iChannelConnectObserverImpl.onChannelDestroy(connectMsgHead, iChannelTransProxyImpl);
    }

    public static long SwigDirector_IChannelTransProxyImpl_writeData(IChannelTransProxyImpl iChannelTransProxyImpl, long j, long j2) {
        return iChannelTransProxyImpl.writeData(j, j2);
    }
}
