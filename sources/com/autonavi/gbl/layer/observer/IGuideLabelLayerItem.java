package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.router.GuideLabelLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = GuideLabelLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGuideLabelLayerItem extends IQuadrantLayerItem {
    int getMAlterPathIndx();

    @BizDirectionStyle.BizDirectionStyle1
    int getMBoardStyle();

    int getMCostDiff();

    int getMDistanceDiff();

    boolean getMIsFaster();

    int getMLabelIndex();

    long getMPathCost();

    long getMPathId();

    boolean getMPreviewMode();

    @Formway.Formway1
    int getMRoadFormway();

    String getMRoadName();

    int getMTrafficLightDiff();

    int getMTravelTimeDiff();

    @Override // 
    void onVisible(boolean z);
}
