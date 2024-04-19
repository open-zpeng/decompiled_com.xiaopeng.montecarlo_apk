package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.EndAreaPointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = EndAreaPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IEndAreaPointLayerItem extends IPointLayerItem {
    String getMPoiName();

    int getMPoiType();
}
