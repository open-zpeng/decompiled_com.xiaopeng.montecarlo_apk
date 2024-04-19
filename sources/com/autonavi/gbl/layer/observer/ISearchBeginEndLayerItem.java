package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.SearchBeginEndLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = SearchBeginEndLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISearchBeginEndLayerItem extends IPointLayerItem {
    int getMPointCount();

    int getMPointType();
}
