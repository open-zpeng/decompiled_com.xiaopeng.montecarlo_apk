package com.autonavi.gbl.consis.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.router.ConsisMessageAdapterRouter;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
@IntfAuto(target = ConsisMessageAdapterRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IConsisMessageAdapter {
    boolean onPauseNavi(long j, int i);

    boolean onResumeNavi(long j, int i);

    default void onSelectMainPathID(long j, int i) {
    }

    boolean onSetNaviPath(NaviPath naviPath, int i);

    boolean onStartNavi(long j, @NaviType.NaviType1 int i, int i2);

    boolean onStopNavi(long j, int i);
}
