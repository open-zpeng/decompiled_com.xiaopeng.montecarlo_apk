package com.autonavi.gbl.lane.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.LaneResourceRequest;
import com.autonavi.gbl.lane.model.LaneResourceRequestFile;
import com.autonavi.gbl.lane.model.LaneResourceResponse;
import com.autonavi.gbl.lane.router.LaneResourceProxyRouter;
@IntfAuto(target = LaneResourceProxyRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILaneResourceProxy {
    LaneResourceResponse onRequestResource(LaneResourceRequest laneResourceRequest);

    LaneResourceResponse onRequestResourceFile(LaneResourceRequestFile laneResourceRequestFile);
}
