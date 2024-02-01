package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.JamBubblesSegmentDeepInfo;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.RouteJamBubblesLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = RouteJamBubblesLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteJamBubblesLayerItem extends IQuadrantLayerItem {
    long getBubbleIndexId();

    JamBubblesSegmentDeepInfo getCost();

    JamBubblesSegmentDeepInfo getDeepInfo();

    JamBubblesSegmentDeepInfo getDegree();

    @BizDirectionStyle.BizDirectionStyle1
    int getDirectionStyle();

    boolean getIsJamWord();

    long getPathId();

    String getPicPath();

    JamBubblesSegmentDeepInfo getTrend();
}
