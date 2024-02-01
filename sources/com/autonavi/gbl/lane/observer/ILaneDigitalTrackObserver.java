package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.router.LaneDigitalTrackObserverRouter;
import com.autonavi.gbl.util.model.BinaryStream;
@IntfAuto(target = LaneDigitalTrackObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneDigitalTrackObserver {
    void onUpdateDigitalTrack(BinaryStream binaryStream);
}
