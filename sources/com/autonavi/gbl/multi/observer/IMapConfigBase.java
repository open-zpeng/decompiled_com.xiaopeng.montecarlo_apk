package com.autonavi.gbl.multi.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.model.DayNightModeConfig;
import com.autonavi.gbl.multi.model.MapScaleConfig;
import com.autonavi.gbl.multi.model.MapViewModeConfig;
import com.autonavi.gbl.multi.model.TmcConfig;
import com.autonavi.gbl.multi.router.MapConfigBaseRouter;
@IntfAuto(target = MapConfigBaseRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapConfigBase extends IKldConfigItemBase {
    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int applyConfig(KldDisplay kldDisplay);

    boolean getAllowedTransAnimation();

    int getAnimationId();

    int getAnimationTime();

    float getCarPosition();

    float getCarPositionHoriz();

    float getCarPositionN();

    Coord2DDouble getDefaultMapCenter();

    boolean getIs2DCarMode();

    boolean getIs3DBuildingVisiable();

    boolean getIsBuildingTextureVisiable();

    boolean getIsNeedJudgeAutoScale();

    boolean getIsSimple3DEnabled();

    int getLogoLeft();

    int getLogoTop();

    @DayNightModeConfig.DayNightModeConfig1
    int getMapDayNightMode();

    boolean getMapFadeOut();

    @MapScaleConfig.MapScaleConfig1
    int getMapScaleConfig();

    String getMapStyleFileNameDay();

    String getMapStyleFileNameNight();

    @MapViewModeConfig.MapViewModeConfig1
    int getMapViewMode();

    int getPreviewScreenBottom();

    int getPreviewScreenLeft();

    int getPreviewScreenRight();

    int getPreviewScreenTop();

    @DayNightModeConfig.DayNightModeConfig1
    int getSkyDayNightMode();

    @TmcConfig.TmcConfig1
    int getTmcConfig();

    boolean getZoomEnable();

    @Override // com.autonavi.gbl.multi.observer.IKldConfigItemBase, com.autonavi.gbl.multi.observer.IDisplayConfigBase
    int parseConfigString(String str);
}
