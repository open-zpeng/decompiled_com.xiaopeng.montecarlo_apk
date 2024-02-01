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
/* loaded from: classes2.dex */
public interface IMapviewObserver {
    default void onCheckIngDataRenderComplete(long j, long j2) {
    }

    default void onClickBlank(long j, float f, float f2) {
    }

    default void onClickLabel(long j, ArrayList<MapLabelItem> arrayList) {
    }

    default void onGuideRoadBoardNameProcessed(long j, GuideRoadNameBoardParam guideRoadNameBoardParam) {
    }

    default void onIndoorBuildingActivity(long j, IndoorBuilding indoorBuilding) {
    }

    default void onMapAnimationFinished(long j, long j2) {
    }

    default void onMapCenterChanged(long j, double d, double d2) {
    }

    default void onMapHeatActive(long j, boolean z) {
    }

    default void onMapLevelChanged(long j, boolean z) {
    }

    default void onMapModeChanged(long j, @MapviewMode.MapviewMode1 int i) {
    }

    default void onMapPreviewEnter(long j) {
    }

    default void onMapPreviewExit(long j) {
    }

    default void onMapSizeChanged(long j) {
    }

    default void onMapViewDestory(long j) {
    }

    default void onMapVisibleIndoor(long j, ArrayList<IndoorBuilding> arrayList, ArrayList<IndoorBuilding> arrayList2) {
    }

    default void onMotionFinished(long j, int i) {
    }

    default void onPitchAngle(long j, float f) {
    }

    default void onPreDrawFrame(long j) {
    }

    default void onRealCityAnimationFinished(long j) {
    }

    default void onRenderEnter(long j) {
    }

    default void onRenderMap(long j, @RenderMapType.RenderMapType1 int i) {
    }

    default void onRollAngle(long j, float f) {
    }

    default void onRouteBoardData(long j, ArrayList<MapRoadTip> arrayList) {
    }

    default void onScenicActive(long j, ScenicInfo scenicInfo) {
    }

    default void onSelectSubWayActive(long j, long[] jArr) {
    }
}
