package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.LocalTrafficEventType;
import com.autonavi.gbl.layer.router.LocalTrafficEventLineLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.ILineLayerItem;
@IntfAuto(target = LocalTrafficEventLineLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ILocalTrafficEventLineLayerItem extends ILineLayerItem {
    String getEventID();

    @LocalTrafficEventType.LocalTrafficEventType1
    int getEventType();
}
