package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CruiseFacilityType;
import com.autonavi.gbl.layer.model.BizCruiseFacilityInfo;
import com.autonavi.gbl.layer.router.CruiseFacilityLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
import java.util.ArrayList;
@IntfAuto(target = CruiseFacilityLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICruiseFacilityLayerItem extends IPointLayerItem {
    int getIndex();

    int getMDistance();

    ArrayList<BizCruiseFacilityInfo> getMFacilityList();

    int getMSpeed();

    @CruiseFacilityType.CruiseFacilityType1
    int getMType();
}
