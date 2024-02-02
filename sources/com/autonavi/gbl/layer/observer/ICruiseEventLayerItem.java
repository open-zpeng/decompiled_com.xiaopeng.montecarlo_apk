package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.guide.model.CruiseEventInfo;
import com.autonavi.gbl.layer.router.CruiseEventLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = CruiseEventLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICruiseEventLayerItem extends IPointLayerItem {
    CruiseEventInfo getMCruiseEventInfo();

    boolean getMShowText();
}
