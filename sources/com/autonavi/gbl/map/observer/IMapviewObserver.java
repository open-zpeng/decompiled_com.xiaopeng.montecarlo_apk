package com.autonavi.gbl.map.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.GuideRoadNameBoardParam;
import com.autonavi.gbl.map.model.IndoorBuilding;
import com.autonavi.gbl.map.model.MapLabelItem;
import com.autonavi.gbl.map.model.MapRoadTip;
import com.autonavi.gbl.map.model.MapviewMode;
import com.autonavi.gbl.map.model.RenderMapType;
import com.autonavi.gbl.map.model.ScenicInfo;
import com.autonavi.gbl.map.router.MapviewObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = MapviewObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IMapviewObserver {
    void onCheckIngDataRenderComplete(long j, long j2);

    void onClickBlank(long j, float f, float f2);

    void onClickLabel(long j, ArrayList<MapLabelItem> arrayList);

    void onGuideRoadBoardNameProcessed(long j, GuideRoadNameBoardParam guideRoadNameBoardParam);

    void onIndoorBuildingActivity(long j, IndoorBuilding indoorBuilding);

    void onMapAnimationFinished(long j, long j2);

    void onMapCenterChanged(long j, double d, double d2);

    void onMapHeatActive(long j, boolean z);

    void onMapLevelChanged(long j, boolean z);

    void onMapModeChanged(long j, @MapviewMode.MapviewMode1 int i);

    void onMapPreviewEnter(long j);

    void onMapPreviewExit(long j);

    void onMapSizeChanged(long j);

    void onMapViewDestory(long j);

    void onMapVisibleIndoor(long j, ArrayList<IndoorBuilding> arrayList, ArrayList<IndoorBuilding> arrayList2);

    void onMotionFinished(long j, int i);

    void onPitchAngle(long j, float f);

    void onPreDrawFrame(long j);

    void onRealCityAnimationFinished(long j);

    void onRenderEnter(long j);

    void onRenderMap(long j, @RenderMapType.RenderMapType1 int i);

    void onRollAngle(long j, float f);

    void onRouteBoardData(long j, ArrayList<MapRoadTip> arrayList);

    void onScenicActive(long j, ScenicInfo scenicInfo);

    void onSelectSubWayActive(long j, long[] jArr);
}
