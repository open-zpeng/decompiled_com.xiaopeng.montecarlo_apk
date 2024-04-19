package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.ThreeUrgentType;
import com.autonavi.gbl.layer.router.ThreeUrgentLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = ThreeUrgentLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IThreeUrgentLayerItem extends IPointLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getMBigBubbleStyle();

    int getMElectronicEyeSpeed();

    int getMPassingSpeed();

    @ThreeUrgentType.ThreeUrgentType1
    int getMType();

    boolean getMbIsMaxOverSpeedPoint();
}
