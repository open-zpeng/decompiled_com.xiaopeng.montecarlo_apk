package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.router.ChannelMsgTransferRouter;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
@IntfAuto(target = ChannelMsgTransferRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IChannelMsgTransfer {
    boolean onPauseNavi(long j, int i);

    boolean onResumeNavi(long j, int i);

    void onSelectMainPathID(long j, int i);

    boolean onSetNaviPath(NaviPath naviPath, long j, int i);

    boolean onStartNavi(long j, @NaviType.NaviType1 int i, int i2);

    boolean onStopNavi(long j, int i);
}
