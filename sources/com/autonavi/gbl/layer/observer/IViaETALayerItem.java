package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.ViaETADirection;
import com.autonavi.gbl.layer.router.ViaETALayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = ViaETALayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IViaETALayerItem extends IQuadrantLayerItem {
    @ViaETADirection.ViaETADirection1
    int getMDirection();

    int getMLeftEnergy();

    long getMTravelTime();
}
