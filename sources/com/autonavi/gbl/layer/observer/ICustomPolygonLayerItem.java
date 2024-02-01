package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomPolygonLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPolygonLayerItem;
@IntfAuto(target = CustomPolygonLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICustomPolygonLayerItem extends IPolygonLayerItem {
    int getMType();

    String getMValue();
}
