package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.SpeedCarLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.INaviPointLayerItem;
@IntfAuto(target = SpeedCarLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISpeedCarLayerItem extends INaviPointLayerItem {
    boolean getBBackGround();
}
