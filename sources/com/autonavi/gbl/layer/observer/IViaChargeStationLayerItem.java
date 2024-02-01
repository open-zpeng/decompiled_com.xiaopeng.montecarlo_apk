package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.ViaChargeStationLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = ViaChargeStationLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IViaChargeStationLayerItem extends IPointLayerItem {
    boolean getIsEagleEye();
}
