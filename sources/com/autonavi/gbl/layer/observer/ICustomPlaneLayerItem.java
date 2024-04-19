package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomPlaneLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IRasterImageLayerItem;
@IntfAuto(target = CustomPlaneLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICustomPlaneLayerItem extends IRasterImageLayerItem {
    int getMType();

    String getMValue();
}
