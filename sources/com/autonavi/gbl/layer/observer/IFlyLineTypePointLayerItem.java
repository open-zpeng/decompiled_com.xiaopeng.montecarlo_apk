package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.FlyLineTypePointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = FlyLineTypePointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IFlyLineTypePointLayerItem extends IPointLayerItem {
    int getMainkey();

    String getName();

    int getSubkey();

    float getTextFontScale();
}
