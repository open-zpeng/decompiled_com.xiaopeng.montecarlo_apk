package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.BizRouteBoardStyle;
import com.autonavi.gbl.layer.router.PathBoardLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = PathBoardLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IPathBoardLayerItem extends IPointLayerItem {
    String getMBoardName();

    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    @BizRouteBoardStyle.BizRouteBoardStyle1
    int getMType();
}
