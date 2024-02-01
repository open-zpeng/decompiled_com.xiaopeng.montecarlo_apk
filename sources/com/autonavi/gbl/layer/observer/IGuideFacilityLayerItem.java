package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.FacilityType;
import com.autonavi.gbl.layer.router.GuideFacilityLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = GuideFacilityLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IGuideFacilityLayerItem extends IPointLayerItem {
    int getMDistance();

    @FacilityType.FacilityType1
    int getMType();
}
