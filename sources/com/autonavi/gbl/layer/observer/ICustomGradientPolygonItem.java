package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.CustomGradientPolygonItemRouter;
@IntfAuto(target = CustomGradientPolygonItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ICustomGradientPolygonItem {
    int getMType();

    String getMValue();

    void setMType(int i);

    void setMValue(String str);
}
