package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizGpsPointType;
import com.autonavi.gbl.layer.router.GpsTrackPointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = GpsTrackPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGpsTrackPointLayerItem extends IPointLayerItem {
    @BizGpsPointType.BizGpsPointType1
    int getMGpsPointType();
}
