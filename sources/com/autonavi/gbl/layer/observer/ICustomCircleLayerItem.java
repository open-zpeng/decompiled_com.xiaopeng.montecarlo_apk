package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomCircleLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.ISectorLayerItem;
@IntfAuto(target = CustomCircleLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICustomCircleLayerItem extends ISectorLayerItem {
    int getMType();

    String getMValue();
}
