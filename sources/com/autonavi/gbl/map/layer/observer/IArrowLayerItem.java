package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.ArrowAnimationPlayState;
import com.autonavi.gbl.map.layer.model.ArrowLayerItemStyle;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.router.ArrowLayerItemRouter;
@IntfAuto(target = ArrowLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IArrowLayerItem extends ILayerItem {
    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    int getAnimationPlayState();

    @Override // 
    @LayerItemType.LayerItemType1
    int getItemType();

    ArrowLayerItemStyle getStyle();
}
