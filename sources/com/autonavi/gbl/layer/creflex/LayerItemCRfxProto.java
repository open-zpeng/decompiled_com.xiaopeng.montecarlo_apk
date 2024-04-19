package com.autonavi.gbl.layer.creflex;

import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.ICRfxProto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.gbl.layer.impl.CommonLineLayerItemImpl;
import com.autonavi.gbl.layer.impl.CruiseCongestionEventLayerItemImpl;
import com.autonavi.gbl.layer.impl.CruiseCongestionItemImpl;
import com.autonavi.gbl.layer.impl.CruiseCongestionPromptLayerItemImpl;
import com.autonavi.gbl.layer.impl.CruiseEventLayerItemImpl;
import com.autonavi.gbl.layer.impl.CruiseFacilityLayerItemImpl;
import com.autonavi.gbl.layer.impl.CustomArrowLayerItemImpl;
import com.autonavi.gbl.layer.impl.CustomCircleLayerItemImpl;
import com.autonavi.gbl.layer.impl.CustomLineLayerItemImpl;
import com.autonavi.gbl.layer.impl.CustomPlaneLayerItemImpl;
import com.autonavi.gbl.layer.impl.CustomPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.CustomPolygonLayerItemImpl;
import com.autonavi.gbl.layer.impl.EndAreaParentLayerItemImpl;
import com.autonavi.gbl.layer.impl.EndAreaPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.EnergyKeyPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.FavoritePointLayerItemImpl;
import com.autonavi.gbl.layer.impl.GpsTrackPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideCameraLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideCongestionLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideETAEventLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideFacilityLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideFamiliarRouteLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideIntervalCameraLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideLabelLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideMixForkLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideTrafficEventLayerItemImpl;
import com.autonavi.gbl.layer.impl.GuideTrafficLightLayerItemImpl;
import com.autonavi.gbl.layer.impl.LaneGuideCameraLayerItemImpl;
import com.autonavi.gbl.layer.impl.LaneGuideCongestionLayerItemImpl;
import com.autonavi.gbl.layer.impl.LaneGuideTrafficEventLayerItemImpl;
import com.autonavi.gbl.layer.impl.LaneGuideTurnLayerItemImpl;
import com.autonavi.gbl.layer.impl.LaneRoutePathPointItemImpl;
import com.autonavi.gbl.layer.impl.LocalTrafficEventLineLayerItemImpl;
import com.autonavi.gbl.layer.impl.LocalTrafficEventPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.OddLayerItemImpl;
import com.autonavi.gbl.layer.impl.PathBoardLayerItemImpl;
import com.autonavi.gbl.layer.impl.PathTMCPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.PopPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.RangeOnMapPolygonPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteBlockLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteCompareTipsLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteForbiddenLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteIndoorParkEndLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteIndoorParkLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteJamLineLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteJamPointLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteNumberLayerItemImpl;
import com.autonavi.gbl.layer.impl.RoutePathPointItemImpl;
import com.autonavi.gbl.layer.impl.RouteRestAreaLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteTrafficEventTipsLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteViaRoadLayerItemImpl;
import com.autonavi.gbl.layer.impl.RouteWeatherLayerItemImpl;
import com.autonavi.gbl.layer.impl.SearchAlongWayLayerItemImpl;
import com.autonavi.gbl.layer.impl.SearchAlongWayPopLayerItemImpl;
import com.autonavi.gbl.layer.impl.SearchBeginEndLayerItemImpl;
import com.autonavi.gbl.layer.impl.SearchChargeStationLayerItemImpl;
import com.autonavi.gbl.layer.impl.SearchChildLayerItemImpl;
import com.autonavi.gbl.layer.impl.SearchExitEntranceLayerItemImpl;
import com.autonavi.gbl.layer.impl.SearchParentLayerItemImpl;
import com.autonavi.gbl.layer.impl.SpeedCarLayerItemImpl;
import com.autonavi.gbl.layer.impl.ThreeUrgentLayerItemImpl;
import com.autonavi.gbl.layer.impl.ViaETALayerItemImpl;
import com.autonavi.gbl.map.layer.impl.ArrowLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.ClusterPointLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.LineLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.MapModelLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.PolygonLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.RctRouteLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.RouteLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.SkeletonLayerItemImpl;
import com.autonavi.gbl.map.layer.impl.VectorCrossLayerItemImpl;
/* loaded from: classes.dex */
public class LayerItemCRfxProto implements ICRfxProto {
    @Override // com.autonavi.auto.intfauto.ICRfxProto
    public String getObjectTypeId(Object obj) {
        String str = obj != null ? (String) ReflexTool.invokeDeclMethodSafe(obj, "getTypeIdName", null, null) : null;
        if (str == null) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? "null" : ReflexTool.PN(obj.getClass());
            DebugTool.e("LayerItemCRfxProto.getObjectTypeId: typeId = null, inst = %s", objArr);
        }
        return str;
    }

    @Override // com.autonavi.auto.intfauto.ICRfxProto
    public String getClassTypeId(Class cls) {
        String str = cls != null ? (String) ReflexTool.invokeDeclMethodSafe(cls, "getClassTypeName", null, null) : null;
        if (str == null) {
            Object[] objArr = new Object[1];
            objArr[0] = cls == null ? "null" : ReflexTool.PN(cls);
            DebugTool.e("LayerItemCRfxProto.getClassTypeId: typeId = null, cls = %s", objArr);
        }
        return str;
    }

    @Override // com.autonavi.auto.intfauto.ICRfxProto
    public Class[] getRelatedClassList() {
        return new Class[]{ArrowLayerItemImpl.class, ClusterPointLayerItemImpl.class, CommonLineLayerItemImpl.class, CruiseCongestionEventLayerItemImpl.class, CruiseCongestionItemImpl.class, CruiseCongestionPromptLayerItemImpl.class, CruiseEventLayerItemImpl.class, CruiseFacilityLayerItemImpl.class, CustomArrowLayerItemImpl.class, CustomCircleLayerItemImpl.class, CustomLineLayerItemImpl.class, CustomPlaneLayerItemImpl.class, CustomPointLayerItemImpl.class, CustomPolygonLayerItemImpl.class, EndAreaParentLayerItemImpl.class, EndAreaPointLayerItemImpl.class, EnergyKeyPointLayerItemImpl.class, FavoritePointLayerItemImpl.class, GpsTrackPointLayerItemImpl.class, GuideCameraLayerItemImpl.class, GuideCongestionLayerItemImpl.class, GuideETAEventLayerItemImpl.class, GuideFacilityLayerItemImpl.class, GuideFamiliarRouteLayerItemImpl.class, GuideIntervalCameraLayerItemImpl.class, GuideLabelLayerItemImpl.class, GuideMixForkLayerItemImpl.class, GuideTrafficEventLayerItemImpl.class, GuideTrafficLightLayerItemImpl.class, LaneGuideCameraLayerItemImpl.class, LaneGuideCongestionLayerItemImpl.class, LaneGuideTrafficEventLayerItemImpl.class, LaneGuideTurnLayerItemImpl.class, LaneRoutePathPointItemImpl.class, LayerItemImpl.class, LineLayerItemImpl.class, LocalTrafficEventLineLayerItemImpl.class, LocalTrafficEventPointLayerItemImpl.class, MapModelLayerItemImpl.class, NaviPointLayerItemImpl.class, OddLayerItemImpl.class, PathBoardLayerItemImpl.class, PathTMCPointLayerItemImpl.class, PointLayerItemImpl.class, PolygonLayerItemImpl.class, PopPointLayerItemImpl.class, QuadrantLayerItemImpl.class, RangeOnMapPolygonPointLayerItemImpl.class, RasterImageLayerItemImpl.class, RctRouteLayerItemImpl.class, RouteBlockLayerItemImpl.class, RouteCompareTipsLayerItemImpl.class, RouteForbiddenLayerItemImpl.class, RouteIndoorParkEndLayerItemImpl.class, RouteIndoorParkLayerItemImpl.class, RouteJamLineLayerItemImpl.class, RouteJamPointLayerItemImpl.class, RouteLayerItemImpl.class, RouteNumberLayerItemImpl.class, RoutePathPointItemImpl.class, RouteRestAreaLayerItemImpl.class, RouteTrafficEventTipsLayerItemImpl.class, RouteViaRoadLayerItemImpl.class, RouteWeatherLayerItemImpl.class, SearchAlongWayLayerItemImpl.class, SearchAlongWayPopLayerItemImpl.class, SearchBeginEndLayerItemImpl.class, SearchChargeStationLayerItemImpl.class, SearchChildLayerItemImpl.class, SearchExitEntranceLayerItemImpl.class, SearchParentLayerItemImpl.class, SectorLayerItemImpl.class, SkeletonLayerItemImpl.class, SpeedCarLayerItemImpl.class, ThreeUrgentLayerItemImpl.class, VectorCrossLayerItemImpl.class, ViaETALayerItemImpl.class};
    }
}
