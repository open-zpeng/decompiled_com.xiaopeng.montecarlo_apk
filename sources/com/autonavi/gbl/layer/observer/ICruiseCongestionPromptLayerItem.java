package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.CruiseCongestionPromptLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = CruiseCongestionPromptLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICruiseCongestionPromptLayerItem extends IQuadrantLayerItem {
    String getMCongestionDetail();

    Coord2DDouble getMCongestionEndPos();

    @TrafficStatus.TrafficStatus1
    int getMCongestionStatus();

    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    Coord2DDouble getMEnterCarPos();

    long getMEnterTime();

    int getMEtaTime();

    int getMLength();
}
