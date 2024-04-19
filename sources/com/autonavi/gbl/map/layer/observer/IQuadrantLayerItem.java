package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.router.QuadrantLayerItemRouter;
@IntfAuto(target = QuadrantLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IQuadrantLayerItem extends IPointLayerItem {
    float getIntersectArea();

    float getIntersectAreaEx();

    long getQuadrantGroupId();

    @QuadrantType.QuadrantType1
    int getQuadrantType();
}
