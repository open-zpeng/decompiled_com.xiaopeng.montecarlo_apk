package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomPointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = CustomPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICustomPointLayerItem extends IPointLayerItem {
    int getMType();

    String getMValue();
}
