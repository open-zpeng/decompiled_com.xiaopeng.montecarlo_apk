package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideTrafficEventLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = GuideTrafficEventLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGuideTrafficEventLayerItem extends IPointLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    int getMId();

    int getMIndex();

    boolean getMIsPreview();

    String getMLane();

    int getMLayer();

    int getMLayerTag();

    long getPathId();
}
