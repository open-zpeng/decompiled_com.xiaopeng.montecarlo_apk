package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomLineLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.ILineLayerItem;
@IntfAuto(target = CustomLineLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICustomLineLayerItem extends ILineLayerItem {
    int getMType();

    String getMValue();
}
