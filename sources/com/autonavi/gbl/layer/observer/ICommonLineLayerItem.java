package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CommonLineLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.ILineLayerItem;
@IntfAuto(target = CommonLineLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICommonLineLayerItem extends ILineLayerItem {
    int getMType();
}
