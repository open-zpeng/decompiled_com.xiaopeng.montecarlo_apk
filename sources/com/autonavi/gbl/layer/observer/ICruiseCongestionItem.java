package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.TrafficStatus;
import com.autonavi.gbl.guide.model.CruiseCongestionInfo;
import com.autonavi.gbl.layer.router.CruiseCongestionItemRouter;
import com.autonavi.gbl.map.layer.observer.ILineLayerItem;
@IntfAuto(target = CruiseCongestionItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICruiseCongestionItem extends ILineLayerItem {
    CruiseCongestionInfo getMInfo();

    @TrafficStatus.TrafficStatus1
    int getMStatus();
}
