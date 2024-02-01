package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomGradientPolygonItemRouter;
import com.autonavi.gbl.map.layer.observer.IPolygonGradientItem;
@IntfAuto(target = CustomGradientPolygonItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ICustomGradientPolygonItem extends IPolygonGradientItem {
    int getMType();

    String getMValue();
}
