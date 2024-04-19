package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.PopPointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = PopPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IPopPointLayerItem extends IPointLayerItem {
    String getMText();
}
