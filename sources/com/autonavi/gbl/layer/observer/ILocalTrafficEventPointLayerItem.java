package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import com.autonavi.gbl.layer.router.LocalTrafficEventPointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = LocalTrafficEventPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILocalTrafficEventPointLayerItem extends IPointLayerItem {
    String getEventID();

    @LocalTrafficEventType.LocalTrafficEventType1
    int getEventType();
}
