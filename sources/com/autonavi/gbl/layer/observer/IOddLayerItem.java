package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.model.BizOddInfo;
import com.autonavi.gbl.layer.model.ODDPointType;
import com.autonavi.gbl.layer.router.OddLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = OddLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IOddLayerItem extends IPointLayerItem {
    BizOddInfo getMOddInfo();

    @ODDPointType.ODDPointType1
    int getMPointType();

    RectDouble getMRect();

    long getOddIndex();
}
