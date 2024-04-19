package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomArrowLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IArrowLayerItem;
@IntfAuto(target = CustomArrowLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICustomArrowLayerItem extends IArrowLayerItem {
    int getMType();

    String getMValue();
}
