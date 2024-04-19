package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CongestExtend;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideCongestionLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = GuideCongestionLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGuideCongestionLayerItem extends IQuadrantLayerItem {
    CongestExtend getMCongestExtend();

    @TrafficStatus.TrafficStatus1
    int getMCongestionStatus();

    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    int getMLayerTag();

    long getMRemainDist();

    String getMTimeInfo();

    long getMTotalRemainDist();

    long getMTotalTimeOfSeconds();
}
