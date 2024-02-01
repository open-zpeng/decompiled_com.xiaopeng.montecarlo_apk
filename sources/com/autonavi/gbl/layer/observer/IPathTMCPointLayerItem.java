package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.PathTMCPointLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = PathTMCPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPathTMCPointLayerItem extends IQuadrantLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getMBoardStyle();
}
