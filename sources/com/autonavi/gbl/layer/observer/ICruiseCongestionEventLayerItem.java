package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizSocolEventInfo;
import com.autonavi.gbl.layer.router.CruiseCongestionEventLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = CruiseCongestionEventLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICruiseCongestionEventLayerItem extends IPointLayerItem {
    BizSocolEventInfo getMSocolEventInfo();
}
