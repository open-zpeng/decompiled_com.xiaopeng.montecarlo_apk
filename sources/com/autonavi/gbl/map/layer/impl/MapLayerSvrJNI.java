package com.autonavi.gbl.map.layer.impl;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.common.model.Vector3i;
import com.autonavi.gbl.map.impl.CollisionItemImpl;
import com.autonavi.gbl.map.impl.ICollisonRemoveObseverImpl;
import com.autonavi.gbl.map.layer.model.ActionLastDesc;
import com.autonavi.gbl.map.layer.model.ActionPlayDesc;
import com.autonavi.gbl.map.layer.model.AnimationStyleParam;
import com.autonavi.gbl.map.layer.model.ArrowAnimationPlayState;
import com.autonavi.gbl.map.layer.model.ArrowLayerItemStyle;
import com.autonavi.gbl.map.layer.model.BGDClusterStrategy;
import com.autonavi.gbl.map.layer.model.ForeshorteningCoefParam;
import com.autonavi.gbl.map.layer.model.IntersectThresholdType;
import com.autonavi.gbl.map.layer.model.IntersectValueType;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.ItemMarkerInfo;
import com.autonavi.gbl.map.layer.model.Layer3DModel;
import com.autonavi.gbl.map.layer.model.LayerItemPoiAnimation;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.layer.model.MapRouteHighLightType;
import com.autonavi.gbl.map.layer.model.MapRoutePolylineDrawType;
import com.autonavi.gbl.map.layer.model.MassDataCircleInfo;
import com.autonavi.gbl.map.layer.model.MassDataPointInfo;
import com.autonavi.gbl.map.layer.model.MassDataPolygonInfo;
import com.autonavi.gbl.map.layer.model.MassDataPolylineInfo;
import com.autonavi.gbl.map.layer.model.ModelDescInfo;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.PolygonGradientPointInfo;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.RealCityNaviInfo;
import com.autonavi.gbl.map.layer.model.RealCityTmcParam;
import com.autonavi.gbl.map.layer.model.RotateMode;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.layer.model.RouteLayerParam;
import com.autonavi.gbl.map.layer.model.RouteLayerPassedColor;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.ScalePriority;
import com.autonavi.gbl.map.layer.model.SectorAngles;
import com.autonavi.gbl.map.layer.model.UIRectRecord;
import com.autonavi.gbl.map.layer.model.VectorCrossViewPostureEvent;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.impl.ILayerClickObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerFocusChangeObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class MapLayerSvrJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_LayerItemImpl_resetOnVisible(LayerItemImpl layerItemImpl, boolean z) {
        layerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LayerItemImpl_onVisible(LayerItemImpl layerItemImpl, boolean z) {
        layerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LayerItemImpl_getOnVisible(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LayerItemImpl_applyOnVisible(LayerItemImpl layerItemImpl) {
        layerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LayerItemImpl_getBound(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getBound();
    }

    public static boolean SwigDirector_LayerItemImpl_getVisible(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getVisible();
    }

    public static int SwigDirector_LayerItemImpl_getPriority(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LayerItemImpl_isAreaCollision(LayerItemImpl layerItemImpl) {
        return layerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LayerItemImpl_setAreaCollision(LayerItemImpl layerItemImpl, boolean z) {
        layerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LayerItemImpl_canCollision(LayerItemImpl layerItemImpl) {
        return layerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LayerItemImpl_canAreaCollision(LayerItemImpl layerItemImpl) {
        return layerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LayerItemImpl_getTypeIdName(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LayerItemImpl_getItemType(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LayerItemImpl_setID(LayerItemImpl layerItemImpl, String str) {
        return layerItemImpl.setID(str);
    }

    public static String SwigDirector_LayerItemImpl_getID(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getID();
    }

    public static boolean SwigDirector_LayerItemImpl_setInfo(LayerItemImpl layerItemImpl, String str) {
        return layerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LayerItemImpl_getInfo(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getInfo();
    }

    public static void SwigDirector_LayerItemImpl_setPriority(LayerItemImpl layerItemImpl, int i) {
        layerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LayerItemImpl_setVisible(LayerItemImpl layerItemImpl, boolean z) {
        layerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LayerItemImpl_getFocus(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getFocus();
    }

    public static void SwigDirector_LayerItemImpl_setAlpha(LayerItemImpl layerItemImpl, double d) {
        layerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LayerItemImpl_getAlpha(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getAlpha();
    }

    public static void SwigDirector_LayerItemImpl_setAngle(LayerItemImpl layerItemImpl, double d) {
        layerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LayerItemImpl_getAngle(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getAngle();
    }

    public static void SwigDirector_LayerItemImpl_setPitch(LayerItemImpl layerItemImpl, double d) {
        layerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LayerItemImpl_getPitch(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getPitch();
    }

    public static void SwigDirector_LayerItemImpl_setMaxPitch(LayerItemImpl layerItemImpl, double d) {
        layerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LayerItemImpl_getMaxPitch(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LayerItemImpl_setClickable(LayerItemImpl layerItemImpl, boolean z) {
        layerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LayerItemImpl_getClickable(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getClickable();
    }

    public static void SwigDirector_LayerItemImpl_setDisplayScale(LayerItemImpl layerItemImpl, LayerScale layerScale) {
        layerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LayerItemImpl_getDisplayScale(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LayerItemImpl_setAnimation(LayerItemImpl layerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        layerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LayerItemImpl_setStyle__SWIG_0(LayerItemImpl layerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        layerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LayerItemImpl_setStyle__SWIG_1(LayerItemImpl layerItemImpl, String str) {
        layerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LayerItemImpl_updateStyle__SWIG_0(LayerItemImpl layerItemImpl) {
        layerItemImpl.updateStyle();
    }

    public static void SwigDirector_LayerItemImpl_updateStyle__SWIG_1(LayerItemImpl layerItemImpl, LayerItemImpl layerItemImpl2) {
        layerItemImpl.updateStyle(layerItemImpl2);
    }

    public static void SwigDirector_LayerItemImpl_addPoiFilter(LayerItemImpl layerItemImpl) {
        layerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LayerItemImpl_removePoiFilter(LayerItemImpl layerItemImpl) {
        layerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LayerItemImpl_onPaint(LayerItemImpl layerItemImpl) {
        layerItemImpl.onPaint();
    }

    public static void SwigDirector_LayerItemImpl_setParent(LayerItemImpl layerItemImpl, BaseLayerImpl baseLayerImpl) {
        layerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LayerItemImpl_setBusinessType(LayerItemImpl layerItemImpl, int i) {
        layerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LayerItemImpl_getBusinessType(LayerItemImpl layerItemImpl) {
        return layerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LayerItemImpl_clearStyle(LayerItemImpl layerItemImpl) {
        layerItemImpl.clearStyle();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_resetOnVisible(LightBeamLayerItemImpl lightBeamLayerItemImpl, boolean z) {
        lightBeamLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LightBeamLayerItemImpl_onVisible(LightBeamLayerItemImpl lightBeamLayerItemImpl, boolean z) {
        lightBeamLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_getOnVisible(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_applyOnVisible(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        lightBeamLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LightBeamLayerItemImpl_getBound(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_getVisible(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LightBeamLayerItemImpl_getPriority(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_isAreaCollision(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setAreaCollision(LightBeamLayerItemImpl lightBeamLayerItemImpl, boolean z) {
        lightBeamLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_canCollision(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_canAreaCollision(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LightBeamLayerItemImpl_getTypeIdName(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LightBeamLayerItemImpl_getItemType(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_setID(LightBeamLayerItemImpl lightBeamLayerItemImpl, String str) {
        return lightBeamLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LightBeamLayerItemImpl_getID(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_setInfo(LightBeamLayerItemImpl lightBeamLayerItemImpl, String str) {
        return lightBeamLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LightBeamLayerItemImpl_getInfo(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setPriority(LightBeamLayerItemImpl lightBeamLayerItemImpl, int i) {
        lightBeamLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setVisible(LightBeamLayerItemImpl lightBeamLayerItemImpl, boolean z) {
        lightBeamLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_getFocus(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setAlpha(LightBeamLayerItemImpl lightBeamLayerItemImpl, double d) {
        lightBeamLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LightBeamLayerItemImpl_getAlpha(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setAngle(LightBeamLayerItemImpl lightBeamLayerItemImpl, double d) {
        lightBeamLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LightBeamLayerItemImpl_getAngle(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setPitch(LightBeamLayerItemImpl lightBeamLayerItemImpl, double d) {
        lightBeamLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LightBeamLayerItemImpl_getPitch(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setMaxPitch(LightBeamLayerItemImpl lightBeamLayerItemImpl, double d) {
        lightBeamLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LightBeamLayerItemImpl_getMaxPitch(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setClickable(LightBeamLayerItemImpl lightBeamLayerItemImpl, boolean z) {
        lightBeamLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LightBeamLayerItemImpl_getClickable(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setDisplayScale(LightBeamLayerItemImpl lightBeamLayerItemImpl, LayerScale layerScale) {
        lightBeamLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LightBeamLayerItemImpl_getDisplayScale(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setAnimation(LightBeamLayerItemImpl lightBeamLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        lightBeamLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setStyle__SWIG_0(LightBeamLayerItemImpl lightBeamLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        lightBeamLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setStyle__SWIG_1(LightBeamLayerItemImpl lightBeamLayerItemImpl, String str) {
        lightBeamLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LightBeamLayerItemImpl_updateStyle(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        lightBeamLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_updateStyle__SWIG_1(LightBeamLayerItemImpl lightBeamLayerItemImpl, LayerItemImpl layerItemImpl) {
        lightBeamLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LightBeamLayerItemImpl_addPoiFilter(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        lightBeamLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_removePoiFilter(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        lightBeamLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_onPaint(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        lightBeamLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setParent(LightBeamLayerItemImpl lightBeamLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        lightBeamLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LightBeamLayerItemImpl_setBusinessType(LightBeamLayerItemImpl lightBeamLayerItemImpl, int i) {
        lightBeamLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LightBeamLayerItemImpl_getBusinessType(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        return lightBeamLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LightBeamLayerItemImpl_clearStyle(LightBeamLayerItemImpl lightBeamLayerItemImpl) {
        lightBeamLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LineLayerItemImpl_resetOnVisible(LineLayerItemImpl lineLayerItemImpl, boolean z) {
        lineLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LineLayerItemImpl_onVisible(LineLayerItemImpl lineLayerItemImpl, boolean z) {
        lineLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LineLayerItemImpl_getOnVisible(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LineLayerItemImpl_applyOnVisible(LineLayerItemImpl lineLayerItemImpl) {
        lineLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LineLayerItemImpl_getBound(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LineLayerItemImpl_getVisible(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LineLayerItemImpl_getPriority(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LineLayerItemImpl_isAreaCollision(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LineLayerItemImpl_setAreaCollision(LineLayerItemImpl lineLayerItemImpl, boolean z) {
        lineLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LineLayerItemImpl_canCollision(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LineLayerItemImpl_canAreaCollision(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LineLayerItemImpl_getTypeIdName(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LineLayerItemImpl_getItemType(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LineLayerItemImpl_setID(LineLayerItemImpl lineLayerItemImpl, String str) {
        return lineLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LineLayerItemImpl_getID(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LineLayerItemImpl_setInfo(LineLayerItemImpl lineLayerItemImpl, String str) {
        return lineLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LineLayerItemImpl_getInfo(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LineLayerItemImpl_setPriority(LineLayerItemImpl lineLayerItemImpl, int i) {
        lineLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LineLayerItemImpl_setVisible(LineLayerItemImpl lineLayerItemImpl, boolean z) {
        lineLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LineLayerItemImpl_getFocus(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LineLayerItemImpl_setAlpha(LineLayerItemImpl lineLayerItemImpl, double d) {
        lineLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LineLayerItemImpl_getAlpha(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LineLayerItemImpl_setAngle(LineLayerItemImpl lineLayerItemImpl, double d) {
        lineLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LineLayerItemImpl_getAngle(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LineLayerItemImpl_setPitch(LineLayerItemImpl lineLayerItemImpl, double d) {
        lineLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LineLayerItemImpl_getPitch(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LineLayerItemImpl_setMaxPitch(LineLayerItemImpl lineLayerItemImpl, double d) {
        lineLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LineLayerItemImpl_getMaxPitch(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LineLayerItemImpl_setClickable(LineLayerItemImpl lineLayerItemImpl, boolean z) {
        lineLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LineLayerItemImpl_getClickable(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LineLayerItemImpl_setDisplayScale(LineLayerItemImpl lineLayerItemImpl, LayerScale layerScale) {
        lineLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LineLayerItemImpl_getDisplayScale(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LineLayerItemImpl_setAnimation(LineLayerItemImpl lineLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        lineLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LineLayerItemImpl_setStyle__SWIG_0(LineLayerItemImpl lineLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        lineLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LineLayerItemImpl_setStyle__SWIG_1(LineLayerItemImpl lineLayerItemImpl, String str) {
        lineLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LineLayerItemImpl_updateStyle__SWIG_0(LineLayerItemImpl lineLayerItemImpl) {
        lineLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LineLayerItemImpl_updateStyle__SWIG_1(LineLayerItemImpl lineLayerItemImpl, LayerItemImpl layerItemImpl) {
        lineLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LineLayerItemImpl_addPoiFilter(LineLayerItemImpl lineLayerItemImpl) {
        lineLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LineLayerItemImpl_removePoiFilter(LineLayerItemImpl lineLayerItemImpl) {
        lineLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LineLayerItemImpl_onPaint(LineLayerItemImpl lineLayerItemImpl) {
        lineLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LineLayerItemImpl_setParent(LineLayerItemImpl lineLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        lineLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LineLayerItemImpl_setBusinessType(LineLayerItemImpl lineLayerItemImpl, int i) {
        lineLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LineLayerItemImpl_getBusinessType(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LineLayerItemImpl_clearStyle(LineLayerItemImpl lineLayerItemImpl) {
        lineLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LineLayerItemImpl_setPoints(LineLayerItemImpl lineLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        lineLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_LineLayerItemImpl_setColor(LineLayerItemImpl lineLayerItemImpl, long j, long j2) {
        lineLayerItemImpl.setColor(j, j2);
    }

    public static void SwigDirector_LineLayerItemImpl_setPassedColor(LineLayerItemImpl lineLayerItemImpl, long j, long j2) {
        lineLayerItemImpl.setPassedColor(j, j2);
    }

    public static void SwigDirector_LineLayerItemImpl_setWidth(LineLayerItemImpl lineLayerItemImpl, int i, int i2) {
        lineLayerItemImpl.setWidth(i, i2);
    }

    public static void SwigDirector_LineLayerItemImpl_getStyle(LineLayerItemImpl lineLayerItemImpl, LineLayerItemStyle lineLayerItemStyle) {
        lineLayerItemImpl.getStyle(lineLayerItemStyle);
    }

    public static long SwigDirector_LineLayerItemImpl_getPointsCount(LineLayerItemImpl lineLayerItemImpl) {
        return lineLayerItemImpl.getPointsCount();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_resetOnVisible(SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z) {
        skeletonLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_onVisible(SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z) {
        skeletonLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_getOnVisible(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_applyOnVisible(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        skeletonLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SkeletonLayerItemImpl_getBound(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_getVisible(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SkeletonLayerItemImpl_getPriority(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_isAreaCollision(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setAreaCollision(SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z) {
        skeletonLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_canCollision(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_canAreaCollision(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_SkeletonLayerItemImpl_getTypeIdName(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SkeletonLayerItemImpl_getItemType(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_setID(SkeletonLayerItemImpl skeletonLayerItemImpl, String str) {
        return skeletonLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SkeletonLayerItemImpl_getID(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_setInfo(SkeletonLayerItemImpl skeletonLayerItemImpl, String str) {
        return skeletonLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SkeletonLayerItemImpl_getInfo(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setPriority(SkeletonLayerItemImpl skeletonLayerItemImpl, int i) {
        skeletonLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setVisible(SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z) {
        skeletonLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_getFocus(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setAlpha(SkeletonLayerItemImpl skeletonLayerItemImpl, double d) {
        skeletonLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SkeletonLayerItemImpl_getAlpha(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setAngle(SkeletonLayerItemImpl skeletonLayerItemImpl, double d) {
        skeletonLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SkeletonLayerItemImpl_getAngle(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setPitch(SkeletonLayerItemImpl skeletonLayerItemImpl, double d) {
        skeletonLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SkeletonLayerItemImpl_getPitch(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setMaxPitch(SkeletonLayerItemImpl skeletonLayerItemImpl, double d) {
        skeletonLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SkeletonLayerItemImpl_getMaxPitch(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setClickable(SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z) {
        skeletonLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_getClickable(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getClickable();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setDisplayScale(SkeletonLayerItemImpl skeletonLayerItemImpl, LayerScale layerScale) {
        skeletonLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SkeletonLayerItemImpl_getDisplayScale(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setAnimation(SkeletonLayerItemImpl skeletonLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        skeletonLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setStyle__SWIG_0(SkeletonLayerItemImpl skeletonLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        skeletonLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setStyle__SWIG_1(SkeletonLayerItemImpl skeletonLayerItemImpl, String str) {
        skeletonLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_updateStyle__SWIG_0(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        skeletonLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_updateStyle__SWIG_1(SkeletonLayerItemImpl skeletonLayerItemImpl, LayerItemImpl layerItemImpl) {
        skeletonLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_addPoiFilter(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        skeletonLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_removePoiFilter(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        skeletonLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_onPaint(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        skeletonLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setParent(SkeletonLayerItemImpl skeletonLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        skeletonLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setBusinessType(SkeletonLayerItemImpl skeletonLayerItemImpl, int i) {
        skeletonLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SkeletonLayerItemImpl_getBusinessType(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_clearStyle(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        skeletonLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setPosition(SkeletonLayerItemImpl skeletonLayerItemImpl, Coord3DDouble coord3DDouble) {
        skeletonLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setPosition3D(SkeletonLayerItemImpl skeletonLayerItemImpl, Coord3DDouble coord3DDouble) {
        skeletonLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_getPosition(SkeletonLayerItemImpl skeletonLayerItemImpl, Coord3DDouble coord3DDouble) {
        skeletonLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_getPosition3D(SkeletonLayerItemImpl skeletonLayerItemImpl, Coord3DDouble coord3DDouble) {
        skeletonLayerItemImpl.getPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setBinaryData(SkeletonLayerItemImpl skeletonLayerItemImpl, byte[] bArr) {
        skeletonLayerItemImpl.setBinaryData(bArr);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_getActionList(SkeletonLayerItemImpl skeletonLayerItemImpl, ArrayList<ActionLastDesc> arrayList) {
        skeletonLayerItemImpl.getActionList(arrayList);
    }

    public static boolean SwigDirector_SkeletonLayerItemImpl_setActionPlayList(SkeletonLayerItemImpl skeletonLayerItemImpl, ArrayList<ActionPlayDesc> arrayList) {
        return skeletonLayerItemImpl.setActionPlayList(arrayList);
    }

    public static String SwigDirector_SkeletonLayerItemImpl_getCurrentAction(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getCurrentAction();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setRotateAngles(SkeletonLayerItemImpl skeletonLayerItemImpl, float f, float f2, float f3) {
        skeletonLayerItemImpl.setRotateAngles(f, f2, f3);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setScaleRation(SkeletonLayerItemImpl skeletonLayerItemImpl, float f) {
        skeletonLayerItemImpl.setScaleRation(f);
    }

    public static float SwigDirector_SkeletonLayerItemImpl_getScaleRation(SkeletonLayerItemImpl skeletonLayerItemImpl) {
        return skeletonLayerItemImpl.getScaleRation();
    }

    public static void SwigDirector_SkeletonLayerItemImpl_getScreenBound(SkeletonLayerItemImpl skeletonLayerItemImpl, RectDouble rectDouble) {
        skeletonLayerItemImpl.getScreenBound(rectDouble);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setRotateWithMap(SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z) {
        skeletonLayerItemImpl.setRotateWithMap(z);
    }

    public static void SwigDirector_SkeletonLayerItemImpl_setScaleWithMap(SkeletonLayerItemImpl skeletonLayerItemImpl, boolean z) {
        skeletonLayerItemImpl.setScaleWithMap(z);
    }

    public static void SwigDirector_PointLayerItemImpl_resetOnVisible(PointLayerItemImpl pointLayerItemImpl, boolean z) {
        pointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_PointLayerItemImpl_onVisible(PointLayerItemImpl pointLayerItemImpl, boolean z) {
        pointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_PointLayerItemImpl_getOnVisible(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_PointLayerItemImpl_applyOnVisible(PointLayerItemImpl pointLayerItemImpl) {
        pointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_PointLayerItemImpl_getBound(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_PointLayerItemImpl_getVisible(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_PointLayerItemImpl_getPriority(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_PointLayerItemImpl_isAreaCollision(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_PointLayerItemImpl_setAreaCollision(PointLayerItemImpl pointLayerItemImpl, boolean z) {
        pointLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_PointLayerItemImpl_canCollision(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_PointLayerItemImpl_canAreaCollision(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_PointLayerItemImpl_getTypeIdName(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_PointLayerItemImpl_getItemType(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_PointLayerItemImpl_setID(PointLayerItemImpl pointLayerItemImpl, String str) {
        return pointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_PointLayerItemImpl_getID(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_PointLayerItemImpl_setInfo(PointLayerItemImpl pointLayerItemImpl, String str) {
        return pointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_PointLayerItemImpl_getInfo(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_PointLayerItemImpl_setPriority(PointLayerItemImpl pointLayerItemImpl, int i) {
        pointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_PointLayerItemImpl_setVisible(PointLayerItemImpl pointLayerItemImpl, boolean z) {
        pointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_PointLayerItemImpl_getFocus(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_PointLayerItemImpl_setAlpha(PointLayerItemImpl pointLayerItemImpl, double d) {
        pointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_PointLayerItemImpl_getAlpha(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_PointLayerItemImpl_setAngle(PointLayerItemImpl pointLayerItemImpl, double d) {
        pointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_PointLayerItemImpl_getAngle(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_PointLayerItemImpl_setPitch(PointLayerItemImpl pointLayerItemImpl, double d) {
        pointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_PointLayerItemImpl_getPitch(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_PointLayerItemImpl_setMaxPitch(PointLayerItemImpl pointLayerItemImpl, double d) {
        pointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_PointLayerItemImpl_getMaxPitch(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_PointLayerItemImpl_setClickable(PointLayerItemImpl pointLayerItemImpl, boolean z) {
        pointLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_PointLayerItemImpl_getClickable(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getClickable();
    }

    public static void SwigDirector_PointLayerItemImpl_setDisplayScale(PointLayerItemImpl pointLayerItemImpl, LayerScale layerScale) {
        pointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_PointLayerItemImpl_getDisplayScale(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_PointLayerItemImpl_setAnimation(PointLayerItemImpl pointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        pointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_PointLayerItemImpl_setStyle__SWIG_0(PointLayerItemImpl pointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        pointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_PointLayerItemImpl_setStyle__SWIG_1(PointLayerItemImpl pointLayerItemImpl, String str) {
        pointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_PointLayerItemImpl_updateStyle__SWIG_0(PointLayerItemImpl pointLayerItemImpl) {
        pointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_PointLayerItemImpl_updateStyle__SWIG_1(PointLayerItemImpl pointLayerItemImpl, LayerItemImpl layerItemImpl) {
        pointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_PointLayerItemImpl_addPoiFilter(PointLayerItemImpl pointLayerItemImpl) {
        pointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_PointLayerItemImpl_removePoiFilter(PointLayerItemImpl pointLayerItemImpl) {
        pointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_PointLayerItemImpl_onPaint(PointLayerItemImpl pointLayerItemImpl) {
        pointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_PointLayerItemImpl_setParent(PointLayerItemImpl pointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        pointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_PointLayerItemImpl_setBusinessType(PointLayerItemImpl pointLayerItemImpl, int i) {
        pointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_PointLayerItemImpl_getBusinessType(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_PointLayerItemImpl_clearStyle(PointLayerItemImpl pointLayerItemImpl) {
        pointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_PointLayerItemImpl_setVisible3V(PointLayerItemImpl pointLayerItemImpl, Visible3V visible3V) {
        pointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_PointLayerItemImpl_getVisible3V(PointLayerItemImpl pointLayerItemImpl, Visible3V visible3V) {
        pointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_PointLayerItemImpl_setBillboard(PointLayerItemImpl pointLayerItemImpl, boolean z) {
        pointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_PointLayerItemImpl_getBillboard(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_PointLayerItemImpl_setPosition3D(PointLayerItemImpl pointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_PointLayerItemImpl_setRotateCenter3D(PointLayerItemImpl pointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PointLayerItemImpl_getRotateCenter3D(PointLayerItemImpl pointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PointLayerItemImpl_setPosition(PointLayerItemImpl pointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_PointLayerItemImpl_getPosition(PointLayerItemImpl pointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_PointLayerItemImpl_setRotateCenter(PointLayerItemImpl pointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_PointLayerItemImpl_getNormalStyle(PointLayerItemImpl pointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        pointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PointLayerItemImpl_getFocusStyle(PointLayerItemImpl pointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        pointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PointLayerItemImpl_setItemVisibleRegion(PointLayerItemImpl pointLayerItemImpl, RectInt rectInt) {
        pointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_PointLayerItemImpl_setItemIgnoreRegion(PointLayerItemImpl pointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        pointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PointLayerItemImpl_getItemIgnoreRegion(PointLayerItemImpl pointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        pointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PointLayerItemImpl_setScale(PointLayerItemImpl pointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        pointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_PointLayerItemImpl_getScale(PointLayerItemImpl pointLayerItemImpl, ScaleAttribute scaleAttribute) {
        pointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_PointLayerItemImpl_setPointTypeCode(PointLayerItemImpl pointLayerItemImpl, String str) {
        pointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_PointLayerItemImpl_getPointTypeCode(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_PointLayerItemImpl_setScaleFactor(PointLayerItemImpl pointLayerItemImpl, float[] fArr) {
        pointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_PointLayerItemImpl_setRotateMode(PointLayerItemImpl pointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        pointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_PointLayerItemImpl_addMarker(PointLayerItemImpl pointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return pointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_PointLayerItemImpl_clearAllMarkers(PointLayerItemImpl pointLayerItemImpl) {
        pointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_PointLayerItemImpl_setForeshorteningCoef(PointLayerItemImpl pointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        pointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_PointLayerItemImpl_getForeshorteningCoef(PointLayerItemImpl pointLayerItemImpl) {
        return pointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_resetOnVisible(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z) {
        quadrantLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_onVisible(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z) {
        quadrantLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_getOnVisible(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_applyOnVisible(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_QuadrantLayerItemImpl_getBound(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_getVisible(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getVisible();
    }

    public static int SwigDirector_QuadrantLayerItemImpl_getPriority(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_isAreaCollision(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setAreaCollision(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z) {
        quadrantLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_canCollision(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_canAreaCollision(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_QuadrantLayerItemImpl_getTypeIdName(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_QuadrantLayerItemImpl_getItemType(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_setID(QuadrantLayerItemImpl quadrantLayerItemImpl, String str) {
        return quadrantLayerItemImpl.setID(str);
    }

    public static String SwigDirector_QuadrantLayerItemImpl_getID(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getID();
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_setInfo(QuadrantLayerItemImpl quadrantLayerItemImpl, String str) {
        return quadrantLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_QuadrantLayerItemImpl_getInfo(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getInfo();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setPriority(QuadrantLayerItemImpl quadrantLayerItemImpl, int i) {
        quadrantLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setVisible(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z) {
        quadrantLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_getFocus(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getFocus();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setAlpha(QuadrantLayerItemImpl quadrantLayerItemImpl, double d) {
        quadrantLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_QuadrantLayerItemImpl_getAlpha(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setAngle(QuadrantLayerItemImpl quadrantLayerItemImpl, double d) {
        quadrantLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_QuadrantLayerItemImpl_getAngle(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getAngle();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setPitch(QuadrantLayerItemImpl quadrantLayerItemImpl, double d) {
        quadrantLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_QuadrantLayerItemImpl_getPitch(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getPitch();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setMaxPitch(QuadrantLayerItemImpl quadrantLayerItemImpl, double d) {
        quadrantLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_QuadrantLayerItemImpl_getMaxPitch(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setClickable(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z) {
        quadrantLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_getClickable(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getClickable();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setDisplayScale(QuadrantLayerItemImpl quadrantLayerItemImpl, LayerScale layerScale) {
        quadrantLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_QuadrantLayerItemImpl_getDisplayScale(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setAnimation(QuadrantLayerItemImpl quadrantLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        quadrantLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setStyle__SWIG_0(QuadrantLayerItemImpl quadrantLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        quadrantLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setStyle__SWIG_1(QuadrantLayerItemImpl quadrantLayerItemImpl, String str) {
        quadrantLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_updateStyle__SWIG_0(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_updateStyle__SWIG_1(QuadrantLayerItemImpl quadrantLayerItemImpl, LayerItemImpl layerItemImpl) {
        quadrantLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_addPoiFilter(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_removePoiFilter(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_onPaint(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.onPaint();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setParent(QuadrantLayerItemImpl quadrantLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        quadrantLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setBusinessType(QuadrantLayerItemImpl quadrantLayerItemImpl, int i) {
        quadrantLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_QuadrantLayerItemImpl_getBusinessType(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_clearStyle(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setVisible3V(QuadrantLayerItemImpl quadrantLayerItemImpl, Visible3V visible3V) {
        quadrantLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_getVisible3V(QuadrantLayerItemImpl quadrantLayerItemImpl, Visible3V visible3V) {
        quadrantLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setBillboard(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z) {
        quadrantLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_getBillboard(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setPosition3D(QuadrantLayerItemImpl quadrantLayerItemImpl, Coord3DDouble coord3DDouble) {
        quadrantLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setRotateCenter3D(QuadrantLayerItemImpl quadrantLayerItemImpl, Coord3DDouble coord3DDouble) {
        quadrantLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_getRotateCenter3D(QuadrantLayerItemImpl quadrantLayerItemImpl, Coord3DDouble coord3DDouble) {
        quadrantLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setPosition(QuadrantLayerItemImpl quadrantLayerItemImpl, Coord3DDouble coord3DDouble) {
        quadrantLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_getPosition(QuadrantLayerItemImpl quadrantLayerItemImpl, Coord3DDouble coord3DDouble) {
        quadrantLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setRotateCenter(QuadrantLayerItemImpl quadrantLayerItemImpl, Coord3DDouble coord3DDouble) {
        quadrantLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_getNormalStyle(QuadrantLayerItemImpl quadrantLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        quadrantLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_getFocusStyle(QuadrantLayerItemImpl quadrantLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        quadrantLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setItemVisibleRegion(QuadrantLayerItemImpl quadrantLayerItemImpl, RectInt rectInt) {
        quadrantLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setItemIgnoreRegion(QuadrantLayerItemImpl quadrantLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        quadrantLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_getItemIgnoreRegion(QuadrantLayerItemImpl quadrantLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        quadrantLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setScale(QuadrantLayerItemImpl quadrantLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        quadrantLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_getScale(QuadrantLayerItemImpl quadrantLayerItemImpl, ScaleAttribute scaleAttribute) {
        quadrantLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setPointTypeCode(QuadrantLayerItemImpl quadrantLayerItemImpl, String str) {
        quadrantLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_QuadrantLayerItemImpl_getPointTypeCode(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setScaleFactor(QuadrantLayerItemImpl quadrantLayerItemImpl, float[] fArr) {
        quadrantLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setRotateMode(QuadrantLayerItemImpl quadrantLayerItemImpl, @RotateMode.RotateMode1 int i) {
        quadrantLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_addMarker(QuadrantLayerItemImpl quadrantLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return quadrantLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_clearAllMarkers(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setForeshorteningCoef(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        quadrantLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_QuadrantLayerItemImpl_getForeshorteningCoef(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_setIdle(QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z) {
        quadrantLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_isIdle(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.isIdle();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_addIntersectArea(QuadrantLayerItemImpl quadrantLayerItemImpl, float f) {
        quadrantLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_QuadrantLayerItemImpl_getIntersectArea(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_resetIntersectArea(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_addIntersectAreaEx(QuadrantLayerItemImpl quadrantLayerItemImpl, float f) {
        quadrantLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_QuadrantLayerItemImpl_getIntersectAreaEx(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_resetIntersectAreaEx(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        quadrantLayerItemImpl.resetIntersectAreaEx();
    }

    public static void SwigDirector_QuadrantLayerItemImpl_addIntersectValue(QuadrantLayerItemImpl quadrantLayerItemImpl, @IntersectValueType.IntersectValueType1 int i, float f) {
        quadrantLayerItemImpl.addIntersectValue(i, f);
    }

    public static float SwigDirector_QuadrantLayerItemImpl_getIntersectValue(QuadrantLayerItemImpl quadrantLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        return quadrantLayerItemImpl.getIntersectValue(i);
    }

    public static void SwigDirector_QuadrantLayerItemImpl_resetIntersectValue(QuadrantLayerItemImpl quadrantLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        quadrantLayerItemImpl.resetIntersectValue(i);
    }

    public static boolean SwigDirector_QuadrantLayerItemImpl_checkShowFlag(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_QuadrantLayerItemImpl_getQuadrantGroupId(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_QuadrantLayerItemImpl_getQuadrantType(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        return quadrantLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_resetOnVisible(ClusterPointLayerItemImpl clusterPointLayerItemImpl, boolean z) {
        clusterPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_onVisible(ClusterPointLayerItemImpl clusterPointLayerItemImpl, boolean z) {
        clusterPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_getOnVisible(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_applyOnVisible(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        clusterPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_ClusterPointLayerItemImpl_getBound(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_getVisible(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_ClusterPointLayerItemImpl_getPriority(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_isAreaCollision(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setAreaCollision(ClusterPointLayerItemImpl clusterPointLayerItemImpl, boolean z) {
        clusterPointLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_canCollision(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_canAreaCollision(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_ClusterPointLayerItemImpl_getTypeIdName(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_ClusterPointLayerItemImpl_getItemType(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_setID(ClusterPointLayerItemImpl clusterPointLayerItemImpl, String str) {
        return clusterPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_ClusterPointLayerItemImpl_getID(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_setInfo(ClusterPointLayerItemImpl clusterPointLayerItemImpl, String str) {
        return clusterPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_ClusterPointLayerItemImpl_getInfo(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setPriority(ClusterPointLayerItemImpl clusterPointLayerItemImpl, int i) {
        clusterPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setVisible(ClusterPointLayerItemImpl clusterPointLayerItemImpl, boolean z) {
        clusterPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_getFocus(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setAlpha(ClusterPointLayerItemImpl clusterPointLayerItemImpl, double d) {
        clusterPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_ClusterPointLayerItemImpl_getAlpha(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setAngle(ClusterPointLayerItemImpl clusterPointLayerItemImpl, double d) {
        clusterPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_ClusterPointLayerItemImpl_getAngle(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setPitch(ClusterPointLayerItemImpl clusterPointLayerItemImpl, double d) {
        clusterPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_ClusterPointLayerItemImpl_getPitch(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setMaxPitch(ClusterPointLayerItemImpl clusterPointLayerItemImpl, double d) {
        clusterPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_ClusterPointLayerItemImpl_getMaxPitch(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setClickable(ClusterPointLayerItemImpl clusterPointLayerItemImpl, boolean z) {
        clusterPointLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_getClickable(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getClickable();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setDisplayScale(ClusterPointLayerItemImpl clusterPointLayerItemImpl, LayerScale layerScale) {
        clusterPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_ClusterPointLayerItemImpl_getDisplayScale(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setAnimation(ClusterPointLayerItemImpl clusterPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        clusterPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setStyle__SWIG_0(ClusterPointLayerItemImpl clusterPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        clusterPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setStyle__SWIG_1(ClusterPointLayerItemImpl clusterPointLayerItemImpl, String str) {
        clusterPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_updateStyle__SWIG_0(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        clusterPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_updateStyle__SWIG_1(ClusterPointLayerItemImpl clusterPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        clusterPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_addPoiFilter(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        clusterPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_removePoiFilter(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        clusterPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_onPaint(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        clusterPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setParent(ClusterPointLayerItemImpl clusterPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        clusterPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setBusinessType(ClusterPointLayerItemImpl clusterPointLayerItemImpl, int i) {
        clusterPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_ClusterPointLayerItemImpl_getBusinessType(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_clearStyle(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        clusterPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setVisible3V(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Visible3V visible3V) {
        clusterPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_getVisible3V(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Visible3V visible3V) {
        clusterPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setBillboard(ClusterPointLayerItemImpl clusterPointLayerItemImpl, boolean z) {
        clusterPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_getBillboard(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setPosition3D(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        clusterPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setRotateCenter3D(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        clusterPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_getRotateCenter3D(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        clusterPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setPosition(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        clusterPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_getPosition(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        clusterPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setRotateCenter(ClusterPointLayerItemImpl clusterPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        clusterPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_getNormalStyle(ClusterPointLayerItemImpl clusterPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        clusterPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_getFocusStyle(ClusterPointLayerItemImpl clusterPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        clusterPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setItemVisibleRegion(ClusterPointLayerItemImpl clusterPointLayerItemImpl, RectInt rectInt) {
        clusterPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setItemIgnoreRegion(ClusterPointLayerItemImpl clusterPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        clusterPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_getItemIgnoreRegion(ClusterPointLayerItemImpl clusterPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        clusterPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setScale(ClusterPointLayerItemImpl clusterPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        clusterPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_getScale(ClusterPointLayerItemImpl clusterPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        clusterPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setPointTypeCode(ClusterPointLayerItemImpl clusterPointLayerItemImpl, String str) {
        clusterPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_ClusterPointLayerItemImpl_getPointTypeCode(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setScaleFactor(ClusterPointLayerItemImpl clusterPointLayerItemImpl, float[] fArr) {
        clusterPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setRotateMode(ClusterPointLayerItemImpl clusterPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        clusterPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_ClusterPointLayerItemImpl_addMarker(ClusterPointLayerItemImpl clusterPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return clusterPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_clearAllMarkers(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        clusterPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_ClusterPointLayerItemImpl_setForeshorteningCoef(ClusterPointLayerItemImpl clusterPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        clusterPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_ClusterPointLayerItemImpl_getForeshorteningCoef(ClusterPointLayerItemImpl clusterPointLayerItemImpl) {
        return clusterPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_PolygonGradientItemImpl_resetOnVisible(PolygonGradientItemImpl polygonGradientItemImpl, boolean z) {
        polygonGradientItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_PolygonGradientItemImpl_onVisible(PolygonGradientItemImpl polygonGradientItemImpl, boolean z) {
        polygonGradientItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_getOnVisible(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getOnVisible();
    }

    public static void SwigDirector_PolygonGradientItemImpl_applyOnVisible(PolygonGradientItemImpl polygonGradientItemImpl) {
        polygonGradientItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_PolygonGradientItemImpl_getBound(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getBound();
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_getVisible(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getVisible();
    }

    public static int SwigDirector_PolygonGradientItemImpl_getPriority(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getPriority();
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_isAreaCollision(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.isAreaCollision();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setAreaCollision(PolygonGradientItemImpl polygonGradientItemImpl, boolean z) {
        polygonGradientItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_canCollision(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.canCollision();
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_canAreaCollision(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.canAreaCollision();
    }

    public static String SwigDirector_PolygonGradientItemImpl_getTypeIdName(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_PolygonGradientItemImpl_getItemType(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getItemType();
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_setID(PolygonGradientItemImpl polygonGradientItemImpl, String str) {
        return polygonGradientItemImpl.setID(str);
    }

    public static String SwigDirector_PolygonGradientItemImpl_getID(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getID();
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_setInfo(PolygonGradientItemImpl polygonGradientItemImpl, String str) {
        return polygonGradientItemImpl.setInfo(str);
    }

    public static String SwigDirector_PolygonGradientItemImpl_getInfo(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getInfo();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setPriority(PolygonGradientItemImpl polygonGradientItemImpl, int i) {
        polygonGradientItemImpl.setPriority(i);
    }

    public static void SwigDirector_PolygonGradientItemImpl_setVisible(PolygonGradientItemImpl polygonGradientItemImpl, boolean z) {
        polygonGradientItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_getFocus(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getFocus();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setAlpha(PolygonGradientItemImpl polygonGradientItemImpl, double d) {
        polygonGradientItemImpl.setAlpha(d);
    }

    public static double SwigDirector_PolygonGradientItemImpl_getAlpha(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getAlpha();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setAngle(PolygonGradientItemImpl polygonGradientItemImpl, double d) {
        polygonGradientItemImpl.setAngle(d);
    }

    public static double SwigDirector_PolygonGradientItemImpl_getAngle(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getAngle();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setPitch(PolygonGradientItemImpl polygonGradientItemImpl, double d) {
        polygonGradientItemImpl.setPitch(d);
    }

    public static double SwigDirector_PolygonGradientItemImpl_getPitch(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getPitch();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setMaxPitch(PolygonGradientItemImpl polygonGradientItemImpl, double d) {
        polygonGradientItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_PolygonGradientItemImpl_getMaxPitch(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getMaxPitch();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setClickable(PolygonGradientItemImpl polygonGradientItemImpl, boolean z) {
        polygonGradientItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_PolygonGradientItemImpl_getClickable(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getClickable();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setDisplayScale(PolygonGradientItemImpl polygonGradientItemImpl, LayerScale layerScale) {
        polygonGradientItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_PolygonGradientItemImpl_getDisplayScale(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getDisplayScale();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setAnimation(PolygonGradientItemImpl polygonGradientItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        polygonGradientItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_PolygonGradientItemImpl_setStyle__SWIG_0(PolygonGradientItemImpl polygonGradientItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        polygonGradientItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_PolygonGradientItemImpl_setStyle__SWIG_1(PolygonGradientItemImpl polygonGradientItemImpl, String str) {
        polygonGradientItemImpl.setStyle(str);
    }

    public static void SwigDirector_PolygonGradientItemImpl_updateStyle(PolygonGradientItemImpl polygonGradientItemImpl) {
        polygonGradientItemImpl.updateStyle();
    }

    public static void SwigDirector_PolygonGradientItemImpl_updateStyle__SWIG_1(PolygonGradientItemImpl polygonGradientItemImpl, LayerItemImpl layerItemImpl) {
        polygonGradientItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_PolygonGradientItemImpl_addPoiFilter(PolygonGradientItemImpl polygonGradientItemImpl) {
        polygonGradientItemImpl.addPoiFilter();
    }

    public static void SwigDirector_PolygonGradientItemImpl_removePoiFilter(PolygonGradientItemImpl polygonGradientItemImpl) {
        polygonGradientItemImpl.removePoiFilter();
    }

    public static void SwigDirector_PolygonGradientItemImpl_onPaint(PolygonGradientItemImpl polygonGradientItemImpl) {
        polygonGradientItemImpl.onPaint();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setParent(PolygonGradientItemImpl polygonGradientItemImpl, BaseLayerImpl baseLayerImpl) {
        polygonGradientItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_PolygonGradientItemImpl_setBusinessType(PolygonGradientItemImpl polygonGradientItemImpl, int i) {
        polygonGradientItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_PolygonGradientItemImpl_getBusinessType(PolygonGradientItemImpl polygonGradientItemImpl) {
        return polygonGradientItemImpl.getBusinessType();
    }

    public static void SwigDirector_PolygonGradientItemImpl_clearStyle(PolygonGradientItemImpl polygonGradientItemImpl) {
        polygonGradientItemImpl.clearStyle();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setPoints(PolygonGradientItemImpl polygonGradientItemImpl, ArrayList<PolygonGradientPointInfo> arrayList) {
        polygonGradientItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_PolygonGradientItemImpl_clearAll(PolygonGradientItemImpl polygonGradientItemImpl) {
        polygonGradientItemImpl.clearAll();
    }

    public static void SwigDirector_PolygonGradientItemImpl_setPriority(PolygonGradientItemImpl polygonGradientItemImpl, LayerPriority layerPriority) {
        polygonGradientItemImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_PolygonLayerItemImpl_resetOnVisible(PolygonLayerItemImpl polygonLayerItemImpl, boolean z) {
        polygonLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_PolygonLayerItemImpl_onVisible(PolygonLayerItemImpl polygonLayerItemImpl, boolean z) {
        polygonLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_getOnVisible(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_PolygonLayerItemImpl_applyOnVisible(PolygonLayerItemImpl polygonLayerItemImpl) {
        polygonLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_PolygonLayerItemImpl_getBound(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_getVisible(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getVisible();
    }

    public static int SwigDirector_PolygonLayerItemImpl_getPriority(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_isAreaCollision(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setAreaCollision(PolygonLayerItemImpl polygonLayerItemImpl, boolean z) {
        polygonLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_canCollision(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_canAreaCollision(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_PolygonLayerItemImpl_getTypeIdName(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_PolygonLayerItemImpl_getItemType(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_setID(PolygonLayerItemImpl polygonLayerItemImpl, String str) {
        return polygonLayerItemImpl.setID(str);
    }

    public static String SwigDirector_PolygonLayerItemImpl_getID(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getID();
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_setInfo(PolygonLayerItemImpl polygonLayerItemImpl, String str) {
        return polygonLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_PolygonLayerItemImpl_getInfo(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getInfo();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setPriority(PolygonLayerItemImpl polygonLayerItemImpl, int i) {
        polygonLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_PolygonLayerItemImpl_setVisible(PolygonLayerItemImpl polygonLayerItemImpl, boolean z) {
        polygonLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_getFocus(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getFocus();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setAlpha(PolygonLayerItemImpl polygonLayerItemImpl, double d) {
        polygonLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_PolygonLayerItemImpl_getAlpha(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setAngle(PolygonLayerItemImpl polygonLayerItemImpl, double d) {
        polygonLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_PolygonLayerItemImpl_getAngle(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getAngle();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setPitch(PolygonLayerItemImpl polygonLayerItemImpl, double d) {
        polygonLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_PolygonLayerItemImpl_getPitch(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getPitch();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setMaxPitch(PolygonLayerItemImpl polygonLayerItemImpl, double d) {
        polygonLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_PolygonLayerItemImpl_getMaxPitch(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setClickable(PolygonLayerItemImpl polygonLayerItemImpl, boolean z) {
        polygonLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_PolygonLayerItemImpl_getClickable(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getClickable();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setDisplayScale(PolygonLayerItemImpl polygonLayerItemImpl, LayerScale layerScale) {
        polygonLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_PolygonLayerItemImpl_getDisplayScale(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setAnimation(PolygonLayerItemImpl polygonLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        polygonLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_PolygonLayerItemImpl_setStyle__SWIG_0(PolygonLayerItemImpl polygonLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        polygonLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_PolygonLayerItemImpl_setStyle__SWIG_1(PolygonLayerItemImpl polygonLayerItemImpl, String str) {
        polygonLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_PolygonLayerItemImpl_updateStyle(PolygonLayerItemImpl polygonLayerItemImpl) {
        polygonLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_PolygonLayerItemImpl_updateStyle__SWIG_1(PolygonLayerItemImpl polygonLayerItemImpl, LayerItemImpl layerItemImpl) {
        polygonLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_PolygonLayerItemImpl_addPoiFilter(PolygonLayerItemImpl polygonLayerItemImpl) {
        polygonLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_PolygonLayerItemImpl_removePoiFilter(PolygonLayerItemImpl polygonLayerItemImpl) {
        polygonLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_PolygonLayerItemImpl_onPaint(PolygonLayerItemImpl polygonLayerItemImpl) {
        polygonLayerItemImpl.onPaint();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setParent(PolygonLayerItemImpl polygonLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        polygonLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_PolygonLayerItemImpl_setBusinessType(PolygonLayerItemImpl polygonLayerItemImpl, int i) {
        polygonLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_PolygonLayerItemImpl_getBusinessType(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_PolygonLayerItemImpl_clearStyle(PolygonLayerItemImpl polygonLayerItemImpl) {
        polygonLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_PolygonLayerItemImpl_setPoints(PolygonLayerItemImpl polygonLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        polygonLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_PolygonLayerItemImpl_setColor(PolygonLayerItemImpl polygonLayerItemImpl, long j) {
        polygonLayerItemImpl.setColor(j);
    }

    public static long SwigDirector_PolygonLayerItemImpl_getColor(PolygonLayerItemImpl polygonLayerItemImpl) {
        return polygonLayerItemImpl.getColor();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_resetOnVisible(RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z) {
        rasterImageLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_onVisible(RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z) {
        rasterImageLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_getOnVisible(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_applyOnVisible(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        rasterImageLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RasterImageLayerItemImpl_getBound(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_getVisible(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RasterImageLayerItemImpl_getPriority(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_isAreaCollision(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setAreaCollision(RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z) {
        rasterImageLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_canCollision(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_canAreaCollision(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_RasterImageLayerItemImpl_getTypeIdName(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RasterImageLayerItemImpl_getItemType(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_setID(RasterImageLayerItemImpl rasterImageLayerItemImpl, String str) {
        return rasterImageLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RasterImageLayerItemImpl_getID(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_setInfo(RasterImageLayerItemImpl rasterImageLayerItemImpl, String str) {
        return rasterImageLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RasterImageLayerItemImpl_getInfo(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setPriority(RasterImageLayerItemImpl rasterImageLayerItemImpl, int i) {
        rasterImageLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setVisible(RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z) {
        rasterImageLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_getFocus(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setAlpha(RasterImageLayerItemImpl rasterImageLayerItemImpl, double d) {
        rasterImageLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RasterImageLayerItemImpl_getAlpha(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setAngle(RasterImageLayerItemImpl rasterImageLayerItemImpl, double d) {
        rasterImageLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RasterImageLayerItemImpl_getAngle(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setPitch(RasterImageLayerItemImpl rasterImageLayerItemImpl, double d) {
        rasterImageLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RasterImageLayerItemImpl_getPitch(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setMaxPitch(RasterImageLayerItemImpl rasterImageLayerItemImpl, double d) {
        rasterImageLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RasterImageLayerItemImpl_getMaxPitch(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setClickable(RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z) {
        rasterImageLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_RasterImageLayerItemImpl_getClickable(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getClickable();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setDisplayScale(RasterImageLayerItemImpl rasterImageLayerItemImpl, LayerScale layerScale) {
        rasterImageLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RasterImageLayerItemImpl_getDisplayScale(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setAnimation(RasterImageLayerItemImpl rasterImageLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        rasterImageLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setStyle__SWIG_0(RasterImageLayerItemImpl rasterImageLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        rasterImageLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setStyle__SWIG_1(RasterImageLayerItemImpl rasterImageLayerItemImpl, String str) {
        rasterImageLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_updateStyle(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        rasterImageLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_updateStyle__SWIG_1(RasterImageLayerItemImpl rasterImageLayerItemImpl, LayerItemImpl layerItemImpl) {
        rasterImageLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_addPoiFilter(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        rasterImageLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_removePoiFilter(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        rasterImageLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_onPaint(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        rasterImageLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setParent(RasterImageLayerItemImpl rasterImageLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        rasterImageLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setBusinessType(RasterImageLayerItemImpl rasterImageLayerItemImpl, int i) {
        rasterImageLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RasterImageLayerItemImpl_getBusinessType(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        return rasterImageLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_clearStyle(RasterImageLayerItemImpl rasterImageLayerItemImpl) {
        rasterImageLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setArrowColor(RasterImageLayerItemImpl rasterImageLayerItemImpl, boolean z, int i) {
        rasterImageLayerItemImpl.setArrowColor(z, i);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setRasterImageData(RasterImageLayerItemImpl rasterImageLayerItemImpl, LayerTexture layerTexture, LayerTexture layerTexture2) {
        rasterImageLayerItemImpl.setRasterImageData(layerTexture, layerTexture2);
    }

    public static void SwigDirector_RasterImageLayerItemImpl_setPlaneViewRect(RasterImageLayerItemImpl rasterImageLayerItemImpl, RectInt rectInt) {
        rasterImageLayerItemImpl.setPlaneViewRect(rectInt);
    }

    public static void SwigDirector_SectorLayerItemImpl_resetOnVisible(SectorLayerItemImpl sectorLayerItemImpl, boolean z) {
        sectorLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SectorLayerItemImpl_onVisible(SectorLayerItemImpl sectorLayerItemImpl, boolean z) {
        sectorLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SectorLayerItemImpl_getOnVisible(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SectorLayerItemImpl_applyOnVisible(SectorLayerItemImpl sectorLayerItemImpl) {
        sectorLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SectorLayerItemImpl_getBound(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SectorLayerItemImpl_getVisible(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SectorLayerItemImpl_getPriority(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SectorLayerItemImpl_isAreaCollision(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SectorLayerItemImpl_setAreaCollision(SectorLayerItemImpl sectorLayerItemImpl, boolean z) {
        sectorLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_SectorLayerItemImpl_canCollision(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_SectorLayerItemImpl_canAreaCollision(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_SectorLayerItemImpl_getTypeIdName(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SectorLayerItemImpl_getItemType(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SectorLayerItemImpl_setID(SectorLayerItemImpl sectorLayerItemImpl, String str) {
        return sectorLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SectorLayerItemImpl_getID(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SectorLayerItemImpl_setInfo(SectorLayerItemImpl sectorLayerItemImpl, String str) {
        return sectorLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SectorLayerItemImpl_getInfo(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SectorLayerItemImpl_setPriority(SectorLayerItemImpl sectorLayerItemImpl, int i) {
        sectorLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SectorLayerItemImpl_setVisible(SectorLayerItemImpl sectorLayerItemImpl, boolean z) {
        sectorLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SectorLayerItemImpl_getFocus(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SectorLayerItemImpl_setAlpha(SectorLayerItemImpl sectorLayerItemImpl, double d) {
        sectorLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SectorLayerItemImpl_getAlpha(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SectorLayerItemImpl_setAngle(SectorLayerItemImpl sectorLayerItemImpl, double d) {
        sectorLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SectorLayerItemImpl_getAngle(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SectorLayerItemImpl_setPitch(SectorLayerItemImpl sectorLayerItemImpl, double d) {
        sectorLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SectorLayerItemImpl_getPitch(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SectorLayerItemImpl_setMaxPitch(SectorLayerItemImpl sectorLayerItemImpl, double d) {
        sectorLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SectorLayerItemImpl_getMaxPitch(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SectorLayerItemImpl_setClickable(SectorLayerItemImpl sectorLayerItemImpl, boolean z) {
        sectorLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_SectorLayerItemImpl_getClickable(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getClickable();
    }

    public static void SwigDirector_SectorLayerItemImpl_setDisplayScale(SectorLayerItemImpl sectorLayerItemImpl, LayerScale layerScale) {
        sectorLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SectorLayerItemImpl_getDisplayScale(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SectorLayerItemImpl_setAnimation(SectorLayerItemImpl sectorLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        sectorLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SectorLayerItemImpl_setStyle__SWIG_0(SectorLayerItemImpl sectorLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        sectorLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SectorLayerItemImpl_setStyle__SWIG_1(SectorLayerItemImpl sectorLayerItemImpl, String str) {
        sectorLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SectorLayerItemImpl_updateStyle(SectorLayerItemImpl sectorLayerItemImpl) {
        sectorLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SectorLayerItemImpl_updateStyle__SWIG_1(SectorLayerItemImpl sectorLayerItemImpl, LayerItemImpl layerItemImpl) {
        sectorLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SectorLayerItemImpl_addPoiFilter(SectorLayerItemImpl sectorLayerItemImpl) {
        sectorLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SectorLayerItemImpl_removePoiFilter(SectorLayerItemImpl sectorLayerItemImpl) {
        sectorLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SectorLayerItemImpl_onPaint(SectorLayerItemImpl sectorLayerItemImpl) {
        sectorLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SectorLayerItemImpl_setParent(SectorLayerItemImpl sectorLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        sectorLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SectorLayerItemImpl_setBusinessType(SectorLayerItemImpl sectorLayerItemImpl, int i) {
        sectorLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SectorLayerItemImpl_getBusinessType(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_SectorLayerItemImpl_clearStyle(SectorLayerItemImpl sectorLayerItemImpl) {
        sectorLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SectorLayerItemImpl_setPosition(SectorLayerItemImpl sectorLayerItemImpl, Coord3DDouble coord3DDouble) {
        sectorLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SectorLayerItemImpl_setRadius(SectorLayerItemImpl sectorLayerItemImpl, double d) {
        sectorLayerItemImpl.setRadius(d);
    }

    public static void SwigDirector_SectorLayerItemImpl_setSectorAngles(SectorLayerItemImpl sectorLayerItemImpl, SectorAngles sectorAngles) {
        sectorLayerItemImpl.setSectorAngles(sectorAngles);
    }

    public static void SwigDirector_SectorLayerItemImpl_setColor(SectorLayerItemImpl sectorLayerItemImpl, long j) {
        sectorLayerItemImpl.setColor(j);
    }

    public static double SwigDirector_SectorLayerItemImpl_getRadius(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getRadius();
    }

    public static void SwigDirector_SectorLayerItemImpl_getSectorAngles(SectorLayerItemImpl sectorLayerItemImpl, SectorAngles sectorAngles) {
        sectorLayerItemImpl.getSectorAngles(sectorAngles);
    }

    public static long SwigDirector_SectorLayerItemImpl_getColor(SectorLayerItemImpl sectorLayerItemImpl) {
        return sectorLayerItemImpl.getColor();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_resetOnVisible(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, boolean z) {
        vectorCrossLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_onVisible(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, boolean z) {
        vectorCrossLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_getOnVisible(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_applyOnVisible(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        vectorCrossLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_VectorCrossLayerItemImpl_getBound(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_getVisible(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getVisible();
    }

    public static int SwigDirector_VectorCrossLayerItemImpl_getPriority(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_isAreaCollision(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setAreaCollision(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, boolean z) {
        vectorCrossLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_canCollision(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_canAreaCollision(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_VectorCrossLayerItemImpl_getTypeIdName(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_VectorCrossLayerItemImpl_getItemType(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_setID(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, String str) {
        return vectorCrossLayerItemImpl.setID(str);
    }

    public static String SwigDirector_VectorCrossLayerItemImpl_getID(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getID();
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_setInfo(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, String str) {
        return vectorCrossLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_VectorCrossLayerItemImpl_getInfo(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getInfo();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setPriority(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, int i) {
        vectorCrossLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setVisible(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, boolean z) {
        vectorCrossLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_getFocus(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getFocus();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setAlpha(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, double d) {
        vectorCrossLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_VectorCrossLayerItemImpl_getAlpha(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setAngle(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, double d) {
        vectorCrossLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_VectorCrossLayerItemImpl_getAngle(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getAngle();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setPitch(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, double d) {
        vectorCrossLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_VectorCrossLayerItemImpl_getPitch(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getPitch();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setMaxPitch(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, double d) {
        vectorCrossLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_VectorCrossLayerItemImpl_getMaxPitch(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setClickable(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, boolean z) {
        vectorCrossLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_VectorCrossLayerItemImpl_getClickable(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getClickable();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setDisplayScale(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, LayerScale layerScale) {
        vectorCrossLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_VectorCrossLayerItemImpl_getDisplayScale(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setAnimation(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        vectorCrossLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setStyle__SWIG_0(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        vectorCrossLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setStyle__SWIG_1(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, String str) {
        vectorCrossLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_updateStyle(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        vectorCrossLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_updateStyle__SWIG_1(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, LayerItemImpl layerItemImpl) {
        vectorCrossLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_addPoiFilter(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        vectorCrossLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_removePoiFilter(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        vectorCrossLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_onPaint(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        vectorCrossLayerItemImpl.onPaint();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setParent(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        vectorCrossLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setBusinessType(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, int i) {
        vectorCrossLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_VectorCrossLayerItemImpl_getBusinessType(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        return vectorCrossLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_clearStyle(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        vectorCrossLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setVectorCar(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, Coord3DDouble coord3DDouble, int i) {
        vectorCrossLayerItemImpl.setVectorCar(coord3DDouble, i);
    }

    public static int SwigDirector_VectorCrossLayerItemImpl_showVectorCross(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, byte[] bArr) {
        return vectorCrossLayerItemImpl.showVectorCross(bArr);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setPriority(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, LayerPriority layerPriority) {
        vectorCrossLayerItemImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_clearAll(VectorCrossLayerItemImpl vectorCrossLayerItemImpl) {
        vectorCrossLayerItemImpl.clearAll();
    }

    public static void SwigDirector_VectorCrossLayerItemImpl_setViewPostureEvent(VectorCrossLayerItemImpl vectorCrossLayerItemImpl, @VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        vectorCrossLayerItemImpl.setViewPostureEvent(i);
    }

    public static void SwigDirector_MapModelLayerItemImpl_resetOnVisible(MapModelLayerItemImpl mapModelLayerItemImpl, boolean z) {
        mapModelLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_MapModelLayerItemImpl_onVisible(MapModelLayerItemImpl mapModelLayerItemImpl, boolean z) {
        mapModelLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_getOnVisible(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_MapModelLayerItemImpl_applyOnVisible(MapModelLayerItemImpl mapModelLayerItemImpl) {
        mapModelLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_MapModelLayerItemImpl_getBound(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_getVisible(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getVisible();
    }

    public static int SwigDirector_MapModelLayerItemImpl_getPriority(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_isAreaCollision(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setAreaCollision(MapModelLayerItemImpl mapModelLayerItemImpl, boolean z) {
        mapModelLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_canCollision(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_canAreaCollision(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_MapModelLayerItemImpl_getTypeIdName(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_MapModelLayerItemImpl_getItemType(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_setID(MapModelLayerItemImpl mapModelLayerItemImpl, String str) {
        return mapModelLayerItemImpl.setID(str);
    }

    public static String SwigDirector_MapModelLayerItemImpl_getID(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getID();
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_setInfo(MapModelLayerItemImpl mapModelLayerItemImpl, String str) {
        return mapModelLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_MapModelLayerItemImpl_getInfo(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getInfo();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setPriority(MapModelLayerItemImpl mapModelLayerItemImpl, int i) {
        mapModelLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setVisible(MapModelLayerItemImpl mapModelLayerItemImpl, boolean z) {
        mapModelLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_getFocus(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getFocus();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setAlpha(MapModelLayerItemImpl mapModelLayerItemImpl, double d) {
        mapModelLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_MapModelLayerItemImpl_getAlpha(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setAngle(MapModelLayerItemImpl mapModelLayerItemImpl, double d) {
        mapModelLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_MapModelLayerItemImpl_getAngle(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getAngle();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setPitch(MapModelLayerItemImpl mapModelLayerItemImpl, double d) {
        mapModelLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_MapModelLayerItemImpl_getPitch(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getPitch();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setMaxPitch(MapModelLayerItemImpl mapModelLayerItemImpl, double d) {
        mapModelLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_MapModelLayerItemImpl_getMaxPitch(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setClickable(MapModelLayerItemImpl mapModelLayerItemImpl, boolean z) {
        mapModelLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_getClickable(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getClickable();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setDisplayScale(MapModelLayerItemImpl mapModelLayerItemImpl, LayerScale layerScale) {
        mapModelLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_MapModelLayerItemImpl_getDisplayScale(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setAnimation(MapModelLayerItemImpl mapModelLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        mapModelLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setStyle__SWIG_0(MapModelLayerItemImpl mapModelLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        mapModelLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setStyle__SWIG_1(MapModelLayerItemImpl mapModelLayerItemImpl, String str) {
        mapModelLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_MapModelLayerItemImpl_updateStyle(MapModelLayerItemImpl mapModelLayerItemImpl) {
        mapModelLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_MapModelLayerItemImpl_updateStyle__SWIG_1(MapModelLayerItemImpl mapModelLayerItemImpl, LayerItemImpl layerItemImpl) {
        mapModelLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_MapModelLayerItemImpl_addPoiFilter(MapModelLayerItemImpl mapModelLayerItemImpl) {
        mapModelLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_MapModelLayerItemImpl_removePoiFilter(MapModelLayerItemImpl mapModelLayerItemImpl) {
        mapModelLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_MapModelLayerItemImpl_onPaint(MapModelLayerItemImpl mapModelLayerItemImpl) {
        mapModelLayerItemImpl.onPaint();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setParent(MapModelLayerItemImpl mapModelLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        mapModelLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setBusinessType(MapModelLayerItemImpl mapModelLayerItemImpl, int i) {
        mapModelLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_MapModelLayerItemImpl_getBusinessType(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_MapModelLayerItemImpl_clearStyle(MapModelLayerItemImpl mapModelLayerItemImpl) {
        mapModelLayerItemImpl.clearStyle();
    }

    public static int SwigDirector_MapModelLayerItemImpl_getModelID(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getModelID();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setModelDescInfo(MapModelLayerItemImpl mapModelLayerItemImpl, ModelDescInfo modelDescInfo) {
        mapModelLayerItemImpl.setModelDescInfo(modelDescInfo);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setPos(MapModelLayerItemImpl mapModelLayerItemImpl, Coord3DDouble coord3DDouble) {
        mapModelLayerItemImpl.setPos(coord3DDouble);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setPos3D(MapModelLayerItemImpl mapModelLayerItemImpl, Coord3DDouble coord3DDouble) {
        mapModelLayerItemImpl.setPos3D(coord3DDouble);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setScale(MapModelLayerItemImpl mapModelLayerItemImpl, float f) {
        mapModelLayerItemImpl.setScale(f);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setDepthMask(MapModelLayerItemImpl mapModelLayerItemImpl, boolean z) {
        mapModelLayerItemImpl.setDepthMask(z);
    }

    public static boolean SwigDirector_MapModelLayerItemImpl_getDepthMask(MapModelLayerItemImpl mapModelLayerItemImpl) {
        return mapModelLayerItemImpl.getDepthMask();
    }

    public static void SwigDirector_MapModelLayerItemImpl_setResolveConflict(MapModelLayerItemImpl mapModelLayerItemImpl, boolean z) {
        mapModelLayerItemImpl.setResolveConflict(z);
    }

    public static void SwigDirector_MapModelLayerItemImpl_setMaxPitchAxisOffset(MapModelLayerItemImpl mapModelLayerItemImpl, float f) {
        mapModelLayerItemImpl.setMaxPitchAxisOffset(f);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_resetOnVisible(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, boolean z) {
        mapPrefabLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_onVisible(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, boolean z) {
        mapPrefabLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_getOnVisible(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_applyOnVisible(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        mapPrefabLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_MapPrefabLayerItemImpl_getBound(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_getVisible(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getVisible();
    }

    public static int SwigDirector_MapPrefabLayerItemImpl_getPriority(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_isAreaCollision(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setAreaCollision(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, boolean z) {
        mapPrefabLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_canCollision(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_canAreaCollision(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_MapPrefabLayerItemImpl_getTypeIdName(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_MapPrefabLayerItemImpl_getItemType(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_setID(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, String str) {
        return mapPrefabLayerItemImpl.setID(str);
    }

    public static String SwigDirector_MapPrefabLayerItemImpl_getID(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getID();
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_setInfo(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, String str) {
        return mapPrefabLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_MapPrefabLayerItemImpl_getInfo(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getInfo();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setPriority(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, int i) {
        mapPrefabLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setVisible(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, boolean z) {
        mapPrefabLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_getFocus(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getFocus();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setAlpha(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, double d) {
        mapPrefabLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_MapPrefabLayerItemImpl_getAlpha(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setAngle(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, double d) {
        mapPrefabLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_MapPrefabLayerItemImpl_getAngle(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getAngle();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setPitch(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, double d) {
        mapPrefabLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_MapPrefabLayerItemImpl_getPitch(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getPitch();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setMaxPitch(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, double d) {
        mapPrefabLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_MapPrefabLayerItemImpl_getMaxPitch(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setClickable(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, boolean z) {
        mapPrefabLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_MapPrefabLayerItemImpl_getClickable(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getClickable();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setDisplayScale(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, LayerScale layerScale) {
        mapPrefabLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_MapPrefabLayerItemImpl_getDisplayScale(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setAnimation(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        mapPrefabLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setStyle__SWIG_0(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        mapPrefabLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setStyle__SWIG_1(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, String str) {
        mapPrefabLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_updateStyle__SWIG_0(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        mapPrefabLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_updateStyle__SWIG_1(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, LayerItemImpl layerItemImpl) {
        mapPrefabLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_addPoiFilter(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        mapPrefabLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_removePoiFilter(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        mapPrefabLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_onPaint(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        mapPrefabLayerItemImpl.onPaint();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setParent(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        mapPrefabLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_setBusinessType(MapPrefabLayerItemImpl mapPrefabLayerItemImpl, int i) {
        mapPrefabLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_MapPrefabLayerItemImpl_getBusinessType(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        return mapPrefabLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_MapPrefabLayerItemImpl_clearStyle(MapPrefabLayerItemImpl mapPrefabLayerItemImpl) {
        mapPrefabLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_resetOnVisible(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_onVisible(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_getOnVisible(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_applyOnVisible(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        naviPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_NaviPointLayerItemImpl_getBound(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_getVisible(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_NaviPointLayerItemImpl_getPriority(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_isAreaCollision(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setAreaCollision(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_canCollision(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_canAreaCollision(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_NaviPointLayerItemImpl_getTypeIdName(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_NaviPointLayerItemImpl_getItemType(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_setID(NaviPointLayerItemImpl naviPointLayerItemImpl, String str) {
        return naviPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_NaviPointLayerItemImpl_getID(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_setInfo(NaviPointLayerItemImpl naviPointLayerItemImpl, String str) {
        return naviPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_NaviPointLayerItemImpl_getInfo(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setPriority(NaviPointLayerItemImpl naviPointLayerItemImpl, int i) {
        naviPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setVisible(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_getFocus(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setAlpha(NaviPointLayerItemImpl naviPointLayerItemImpl, double d) {
        naviPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_NaviPointLayerItemImpl_getAlpha(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setAngle(NaviPointLayerItemImpl naviPointLayerItemImpl, double d) {
        naviPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_NaviPointLayerItemImpl_getAngle(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setPitch(NaviPointLayerItemImpl naviPointLayerItemImpl, double d) {
        naviPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_NaviPointLayerItemImpl_getPitch(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setMaxPitch(NaviPointLayerItemImpl naviPointLayerItemImpl, double d) {
        naviPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_NaviPointLayerItemImpl_getMaxPitch(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setClickable(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_getClickable(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getClickable();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setDisplayScale(NaviPointLayerItemImpl naviPointLayerItemImpl, LayerScale layerScale) {
        naviPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_NaviPointLayerItemImpl_getDisplayScale(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setAnimation(NaviPointLayerItemImpl naviPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        naviPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setStyle__SWIG_0(NaviPointLayerItemImpl naviPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        naviPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setStyle__SWIG_1(NaviPointLayerItemImpl naviPointLayerItemImpl, String str) {
        naviPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_updateStyle(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        naviPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_updateStyle__SWIG_1(NaviPointLayerItemImpl naviPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        naviPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_addPoiFilter(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        naviPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_removePoiFilter(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        naviPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_onPaint(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        naviPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setParent(NaviPointLayerItemImpl naviPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        naviPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setBusinessType(NaviPointLayerItemImpl naviPointLayerItemImpl, int i) {
        naviPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_NaviPointLayerItemImpl_getBusinessType(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_clearStyle(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        naviPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setDepthMask(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.setDepthMask(z);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setResolveConflict(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.setResolveConflict(z);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setVisible3V(NaviPointLayerItemImpl naviPointLayerItemImpl, Visible3V visible3V) {
        naviPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getVisible3V(NaviPointLayerItemImpl naviPointLayerItemImpl, Visible3V visible3V) {
        naviPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setBillboard(NaviPointLayerItemImpl naviPointLayerItemImpl, boolean z) {
        naviPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_getBillboard(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        return naviPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setPosition3D(NaviPointLayerItemImpl naviPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        naviPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getPosition3D(NaviPointLayerItemImpl naviPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        naviPointLayerItemImpl.getPosition3D(coord3DDouble);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setRotateCenter3D(NaviPointLayerItemImpl naviPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        naviPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getRotateCenter3D(NaviPointLayerItemImpl naviPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        naviPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setPosition(NaviPointLayerItemImpl naviPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        naviPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getPosition(NaviPointLayerItemImpl naviPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        naviPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setRotateCenter(NaviPointLayerItemImpl naviPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        naviPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getNormalStyle(NaviPointLayerItemImpl naviPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        naviPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getFocusStyle(NaviPointLayerItemImpl naviPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        naviPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setItemVisibleRegion(NaviPointLayerItemImpl naviPointLayerItemImpl, RectInt rectInt) {
        naviPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getItemVisibleRegion(NaviPointLayerItemImpl naviPointLayerItemImpl, RectInt rectInt) {
        naviPointLayerItemImpl.getItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setItemIgnoreRegion(NaviPointLayerItemImpl naviPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        naviPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getItemIgnoreRegion(NaviPointLayerItemImpl naviPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        naviPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setScaleFactor(NaviPointLayerItemImpl naviPointLayerItemImpl, float[] fArr) {
        naviPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setScale(NaviPointLayerItemImpl naviPointLayerItemImpl, ScaleInfo scaleInfo) {
        naviPointLayerItemImpl.setScale(scaleInfo);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_getScale(NaviPointLayerItemImpl naviPointLayerItemImpl, ScaleInfo scaleInfo) {
        naviPointLayerItemImpl.getScale(scaleInfo);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_setRotateMode(NaviPointLayerItemImpl naviPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        naviPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_NaviPointLayerItemImpl_addMarker(NaviPointLayerItemImpl naviPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return naviPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_NaviPointLayerItemImpl_clearAllMarkers(NaviPointLayerItemImpl naviPointLayerItemImpl) {
        naviPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_ArrowLayerItemImpl_resetOnVisible(ArrowLayerItemImpl arrowLayerItemImpl, boolean z) {
        arrowLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_ArrowLayerItemImpl_onVisible(ArrowLayerItemImpl arrowLayerItemImpl, boolean z) {
        arrowLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_getOnVisible(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_ArrowLayerItemImpl_applyOnVisible(ArrowLayerItemImpl arrowLayerItemImpl) {
        arrowLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_ArrowLayerItemImpl_getBound(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_getVisible(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getVisible();
    }

    public static int SwigDirector_ArrowLayerItemImpl_getPriority(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_isAreaCollision(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setAreaCollision(ArrowLayerItemImpl arrowLayerItemImpl, boolean z) {
        arrowLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_canCollision(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_canAreaCollision(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_ArrowLayerItemImpl_getTypeIdName(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_ArrowLayerItemImpl_getItemType(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_setID(ArrowLayerItemImpl arrowLayerItemImpl, String str) {
        return arrowLayerItemImpl.setID(str);
    }

    public static String SwigDirector_ArrowLayerItemImpl_getID(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getID();
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_setInfo(ArrowLayerItemImpl arrowLayerItemImpl, String str) {
        return arrowLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_ArrowLayerItemImpl_getInfo(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getInfo();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setPriority(ArrowLayerItemImpl arrowLayerItemImpl, int i) {
        arrowLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_ArrowLayerItemImpl_setVisible(ArrowLayerItemImpl arrowLayerItemImpl, boolean z) {
        arrowLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_getFocus(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getFocus();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setAlpha(ArrowLayerItemImpl arrowLayerItemImpl, double d) {
        arrowLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_ArrowLayerItemImpl_getAlpha(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setAngle(ArrowLayerItemImpl arrowLayerItemImpl, double d) {
        arrowLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_ArrowLayerItemImpl_getAngle(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getAngle();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setPitch(ArrowLayerItemImpl arrowLayerItemImpl, double d) {
        arrowLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_ArrowLayerItemImpl_getPitch(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getPitch();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setMaxPitch(ArrowLayerItemImpl arrowLayerItemImpl, double d) {
        arrowLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_ArrowLayerItemImpl_getMaxPitch(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setClickable(ArrowLayerItemImpl arrowLayerItemImpl, boolean z) {
        arrowLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_getClickable(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getClickable();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setDisplayScale(ArrowLayerItemImpl arrowLayerItemImpl, LayerScale layerScale) {
        arrowLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_ArrowLayerItemImpl_getDisplayScale(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setAnimation(ArrowLayerItemImpl arrowLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        arrowLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_ArrowLayerItemImpl_setStyle__SWIG_0(ArrowLayerItemImpl arrowLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        arrowLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_ArrowLayerItemImpl_setStyle__SWIG_1(ArrowLayerItemImpl arrowLayerItemImpl, String str) {
        arrowLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_ArrowLayerItemImpl_updateStyle(ArrowLayerItemImpl arrowLayerItemImpl) {
        arrowLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_ArrowLayerItemImpl_updateStyle__SWIG_1(ArrowLayerItemImpl arrowLayerItemImpl, LayerItemImpl layerItemImpl) {
        arrowLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_ArrowLayerItemImpl_addPoiFilter(ArrowLayerItemImpl arrowLayerItemImpl) {
        arrowLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_ArrowLayerItemImpl_removePoiFilter(ArrowLayerItemImpl arrowLayerItemImpl) {
        arrowLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_ArrowLayerItemImpl_onPaint(ArrowLayerItemImpl arrowLayerItemImpl) {
        arrowLayerItemImpl.onPaint();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setParent(ArrowLayerItemImpl arrowLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        arrowLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_ArrowLayerItemImpl_setBusinessType(ArrowLayerItemImpl arrowLayerItemImpl, int i) {
        arrowLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_ArrowLayerItemImpl_getBusinessType(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_ArrowLayerItemImpl_clearStyle(ArrowLayerItemImpl arrowLayerItemImpl) {
        arrowLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setPoints(ArrowLayerItemImpl arrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        arrowLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_ArrowLayerItemImpl_setPoints3D(ArrowLayerItemImpl arrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        arrowLayerItemImpl.setPoints3D(arrayList);
    }

    public static void SwigDirector_ArrowLayerItemImpl_getStyle(ArrowLayerItemImpl arrowLayerItemImpl, ArrowLayerItemStyle arrowLayerItemStyle) {
        arrowLayerItemImpl.getStyle(arrowLayerItemStyle);
    }

    public static void SwigDirector_ArrowLayerItemImpl_setAnimationPlayState(ArrowLayerItemImpl arrowLayerItemImpl, @ArrowAnimationPlayState.ArrowAnimationPlayState1 int i) {
        arrowLayerItemImpl.setAnimationPlayState(i);
    }

    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    public static int SwigDirector_ArrowLayerItemImpl_getAnimationPlayState(ArrowLayerItemImpl arrowLayerItemImpl) {
        return arrowLayerItemImpl.getAnimationPlayState();
    }

    public static void SwigDirector_ArrowLayerItemImpl_setGrownAnimation__SWIG_0(ArrowLayerItemImpl arrowLayerItemImpl, int i, int i2, long j) {
        arrowLayerItemImpl.setGrownAnimation(i, i2, j);
    }

    public static void SwigDirector_ArrowLayerItemImpl_setGrownAnimation__SWIG_1(ArrowLayerItemImpl arrowLayerItemImpl, int i, int i2) {
        arrowLayerItemImpl.setGrownAnimation(i, i2);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_addGrownAnimationObserver(ArrowLayerItemImpl arrowLayerItemImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return arrowLayerItemImpl.addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_removeGrownAnimationObserver(ArrowLayerItemImpl arrowLayerItemImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return arrowLayerItemImpl.removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_isIntersectCircle(ArrowLayerItemImpl arrowLayerItemImpl, double d, double d2, int i) {
        return arrowLayerItemImpl.isIntersectCircle(d, d2, i);
    }

    public static boolean SwigDirector_ArrowLayerItemImpl_isIntersectRect(ArrowLayerItemImpl arrowLayerItemImpl, RectDouble rectDouble) {
        return arrowLayerItemImpl.isIntersectRect(rectDouble);
    }

    public static void SwigDirector_RouteLayerItemImpl_resetOnVisible(RouteLayerItemImpl routeLayerItemImpl, boolean z) {
        routeLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteLayerItemImpl_onVisible(RouteLayerItemImpl routeLayerItemImpl, boolean z) {
        routeLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_getOnVisible(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteLayerItemImpl_applyOnVisible(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteLayerItemImpl_getBound(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteLayerItemImpl_getVisible(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteLayerItemImpl_getPriority(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteLayerItemImpl_isAreaCollision(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteLayerItemImpl_setAreaCollision(RouteLayerItemImpl routeLayerItemImpl, boolean z) {
        routeLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_canCollision(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_RouteLayerItemImpl_canAreaCollision(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_RouteLayerItemImpl_getTypeIdName(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteLayerItemImpl_getItemType(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteLayerItemImpl_setID(RouteLayerItemImpl routeLayerItemImpl, String str) {
        return routeLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteLayerItemImpl_getID(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteLayerItemImpl_setInfo(RouteLayerItemImpl routeLayerItemImpl, String str) {
        return routeLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteLayerItemImpl_getInfo(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteLayerItemImpl_setPriority(RouteLayerItemImpl routeLayerItemImpl, int i) {
        routeLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteLayerItemImpl_setVisible(RouteLayerItemImpl routeLayerItemImpl, boolean z) {
        routeLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_getFocus(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteLayerItemImpl_setAlpha(RouteLayerItemImpl routeLayerItemImpl, double d) {
        routeLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteLayerItemImpl_getAlpha(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteLayerItemImpl_setAngle(RouteLayerItemImpl routeLayerItemImpl, double d) {
        routeLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteLayerItemImpl_getAngle(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteLayerItemImpl_setPitch(RouteLayerItemImpl routeLayerItemImpl, double d) {
        routeLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteLayerItemImpl_getPitch(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteLayerItemImpl_setMaxPitch(RouteLayerItemImpl routeLayerItemImpl, double d) {
        routeLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteLayerItemImpl_getMaxPitch(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteLayerItemImpl_setClickable(RouteLayerItemImpl routeLayerItemImpl, boolean z) {
        routeLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_getClickable(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getClickable();
    }

    public static void SwigDirector_RouteLayerItemImpl_setDisplayScale(RouteLayerItemImpl routeLayerItemImpl, LayerScale layerScale) {
        routeLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteLayerItemImpl_getDisplayScale(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteLayerItemImpl_setAnimation(RouteLayerItemImpl routeLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteLayerItemImpl_setStyle__SWIG_0(RouteLayerItemImpl routeLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteLayerItemImpl_setStyle__SWIG_1(RouteLayerItemImpl routeLayerItemImpl, String str) {
        routeLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteLayerItemImpl_updateStyle(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteLayerItemImpl_updateStyle__SWIG_1(RouteLayerItemImpl routeLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteLayerItemImpl_addPoiFilter(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteLayerItemImpl_removePoiFilter(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteLayerItemImpl_onPaint(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteLayerItemImpl_setParent(RouteLayerItemImpl routeLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteLayerItemImpl_setBusinessType(RouteLayerItemImpl routeLayerItemImpl, int i) {
        routeLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteLayerItemImpl_getBusinessType(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_RouteLayerItemImpl_clearStyle(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteLayerItemImpl_getDisplayScale(RouteLayerItemImpl routeLayerItemImpl, LayerScale layerScale) {
        routeLayerItemImpl.getDisplayScale(layerScale);
    }

    public static void SwigDirector_RouteLayerItemImpl_setCar2DPosition(RouteLayerItemImpl routeLayerItemImpl, long j, float f) {
        routeLayerItemImpl.setCar2DPosition(j, f);
    }

    public static void SwigDirector_RouteLayerItemImpl_setCar3DPosition(RouteLayerItemImpl routeLayerItemImpl, long j, float f) {
        routeLayerItemImpl.setCar3DPosition(j, f);
    }

    public static void SwigDirector_RouteLayerItemImpl_addRouteName(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.addRouteName();
    }

    public static void SwigDirector_RouteLayerItemImpl_removeRouteName(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.removeRouteName();
    }

    public static void SwigDirector_RouteLayerItemImpl_setLineWidthScale(RouteLayerItemImpl routeLayerItemImpl, float f) {
        routeLayerItemImpl.setLineWidthScale(f);
    }

    public static void SwigDirector_RouteLayerItemImpl_setRouteItemParam(RouteLayerItemImpl routeLayerItemImpl, RouteLayerParam routeLayerParam) {
        routeLayerItemImpl.setRouteItemParam(routeLayerParam);
    }

    public static void SwigDirector_RouteLayerItemImpl_setRouteItemParams(RouteLayerItemImpl routeLayerItemImpl, ArrayList<RouteLayerParam> arrayList) {
        routeLayerItemImpl.setRouteItemParams(arrayList);
    }

    public static void SwigDirector_RouteLayerItemImpl_setPassedColor(RouteLayerItemImpl routeLayerItemImpl, RouteLayerPassedColor routeLayerPassedColor) {
        routeLayerItemImpl.setPassedColor(routeLayerPassedColor);
    }

    public static void SwigDirector_RouteLayerItemImpl_setRouteDrawParam(RouteLayerItemImpl routeLayerItemImpl, RouteLayerDrawParam routeLayerDrawParam) {
        routeLayerItemImpl.setRouteDrawParam(routeLayerDrawParam);
    }

    public static void SwigDirector_RouteLayerItemImpl_getRouteDrawParam(RouteLayerItemImpl routeLayerItemImpl, RouteLayerDrawParam routeLayerDrawParam) {
        routeLayerItemImpl.getRouteDrawParam(routeLayerDrawParam);
    }

    public static void SwigDirector_RouteLayerItemImpl_addRouteItem(RouteLayerItemImpl routeLayerItemImpl, @RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        routeLayerItemImpl.addRouteItem(i, i2, bArr, s);
    }

    public static void SwigDirector_RouteLayerItemImpl_removeRouteItem(RouteLayerItemImpl routeLayerItemImpl) {
        routeLayerItemImpl.removeRouteItem();
    }

    public static boolean SwigDirector_RouteLayerItemImpl_isPathIntersectRect(RouteLayerItemImpl routeLayerItemImpl, RectDouble rectDouble) {
        return routeLayerItemImpl.isPathIntersectRect(rectDouble);
    }

    public static void SwigDirector_RouteLayerItemImpl_setHighlightType(RouteLayerItemImpl routeLayerItemImpl, @MapRouteHighLightType.MapRouteHighLightType1 int i) {
        routeLayerItemImpl.setHighlightType(i);
    }

    public static void SwigDirector_RouteLayerItemImpl_setSelectStatus(RouteLayerItemImpl routeLayerItemImpl, boolean z) {
        routeLayerItemImpl.setSelectStatus(z);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_getSelectStatus(RouteLayerItemImpl routeLayerItemImpl) {
        return routeLayerItemImpl.getSelectStatus();
    }

    public static void SwigDirector_RouteLayerItemImpl_setShowNaviRouteNameCountMap(RouteLayerItemImpl routeLayerItemImpl, HashMap<Integer, Integer> hashMap) {
        routeLayerItemImpl.setShowNaviRouteNameCountMap(hashMap);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_setDrawType(RouteLayerItemImpl routeLayerItemImpl, @MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        return routeLayerItemImpl.setDrawType(i);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_setGrownAnimation__SWIG_0(RouteLayerItemImpl routeLayerItemImpl, int i, long j) {
        return routeLayerItemImpl.setGrownAnimation(i, j);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_setGrownAnimation__SWIG_1(RouteLayerItemImpl routeLayerItemImpl, int i) {
        return routeLayerItemImpl.setGrownAnimation(i);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_setGrownAnimation__SWIG_2(RouteLayerItemImpl routeLayerItemImpl, boolean z, int i, long j) {
        return routeLayerItemImpl.setGrownAnimation(z, i, j);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_setGrownAnimation__SWIG_3(RouteLayerItemImpl routeLayerItemImpl, boolean z, int i) {
        return routeLayerItemImpl.setGrownAnimation(z, i);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_addGrownAnimationObserver(RouteLayerItemImpl routeLayerItemImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return routeLayerItemImpl.addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static boolean SwigDirector_RouteLayerItemImpl_removeGrownAnimationObserver(RouteLayerItemImpl routeLayerItemImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return routeLayerItemImpl.removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static void SwigDirector_RouteLayerItemImpl_setFilterZoomLevel(RouteLayerItemImpl routeLayerItemImpl, float f, float f2) {
        routeLayerItemImpl.setFilterZoomLevel(f, f2);
    }

    public static void SwigDirector_RouteLayerItemImpl_addOddItem(RouteLayerItemImpl routeLayerItemImpl, ArrayList<LineLayerItemImpl> arrayList) {
        routeLayerItemImpl.addOddItem(arrayList);
    }

    public static void SwigDirector_RouteLayerItemImpl_setOddAnimation(RouteLayerItemImpl routeLayerItemImpl, boolean z, AnimationStyleParam animationStyleParam) {
        routeLayerItemImpl.setOddAnimation(z, animationStyleParam);
    }

    public static void SwigDirector_RouteLayerItemImpl_setParkFloor(RouteLayerItemImpl routeLayerItemImpl, int i) {
        routeLayerItemImpl.setParkFloor(i);
    }

    public static void SwigDirector_BaseLayerImpl_resetNextPair(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.resetNextPair();
    }

    public static boolean SwigDirector_BaseLayerImpl_testIntersect(BaseLayerImpl baseLayerImpl, CollisionItemImpl collisionItemImpl) {
        return baseLayerImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_BaseLayerImpl_getType(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getType();
    }

    public static void SwigDirector_BaseLayerImpl_enableAreaCollision(BaseLayerImpl baseLayerImpl, boolean z) {
        baseLayerImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_BaseLayerImpl_isAreaCollision(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.isAreaCollision();
    }

    public static void SwigDirector_BaseLayerImpl_enableCollision(BaseLayerImpl baseLayerImpl, boolean z) {
        baseLayerImpl.enableCollision(z);
    }

    public static boolean SwigDirector_BaseLayerImpl_isCollision(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.isCollision();
    }

    public static void SwigDirector_BaseLayerImpl_lockItems(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.lockItems();
    }

    public static void SwigDirector_BaseLayerImpl_unLockItems(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.unLockItems();
    }

    public static void SwigDirector_BaseLayerImpl_caculateCollision(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.caculateCollision();
    }

    public static void SwigDirector_BaseLayerImpl_intersectUI(BaseLayerImpl baseLayerImpl, ArrayList<UIRectRecord> arrayList) {
        baseLayerImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_BaseLayerImpl_addCollisionItem(BaseLayerImpl baseLayerImpl, CollisionItemImpl collisionItemImpl) {
        return baseLayerImpl.addCollisionItem(collisionItemImpl);
    }

    public static boolean SwigDirector_BaseLayerImpl_removeCollisionItem(BaseLayerImpl baseLayerImpl, CollisionItemImpl collisionItemImpl) {
        return baseLayerImpl.removeCollisionItem(collisionItemImpl);
    }

    public static void SwigDirector_BaseLayerImpl_clearAllCollisionItems(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_BaseLayerImpl_getCollisionItems(BaseLayerImpl baseLayerImpl) {
        ArrayList<CollisionItemImpl> collisionItems = baseLayerImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionItemImpl.getCPtr(collisionItems.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_BaseLayerImpl_setIntersectAreaThreshold(BaseLayerImpl baseLayerImpl, float f) {
        baseLayerImpl.setIntersectAreaThreshold(f);
    }

    public static float SwigDirector_BaseLayerImpl_getIntersectAreaThreshold(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getIntersectAreaThreshold();
    }

    public static void SwigDirector_BaseLayerImpl_setIntersectThreshold(BaseLayerImpl baseLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        baseLayerImpl.setIntersectThreshold(i, f);
    }

    public static float SwigDirector_BaseLayerImpl_getIntersectThreshold(BaseLayerImpl baseLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i) {
        return baseLayerImpl.getIntersectThreshold(i);
    }

    public static void SwigDirector_BaseLayerImpl_updateQuadrantItems(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.updateQuadrantItems();
    }

    public static void SwigDirector_BaseLayerImpl_getPriority(BaseLayerImpl baseLayerImpl, LayerPriority layerPriority) {
        baseLayerImpl.getPriority(layerPriority);
    }

    public static void SwigDirector_BaseLayerImpl_applyItemsOnVisible(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.applyItemsOnVisible();
    }

    public static void SwigDirector_BaseLayerImpl_setApplyItemsOnVisible(BaseLayerImpl baseLayerImpl, boolean z) {
        baseLayerImpl.setApplyItemsOnVisible(z);
    }

    public static boolean SwigDirector_BaseLayerImpl_hasAppliedItemsOnVisible(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.hasAppliedItemsOnVisible();
    }

    public static String SwigDirector_BaseLayerImpl_getTypeIdName(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getTypeIdName();
    }

    public static void SwigDirector_BaseLayerImpl_setName(BaseLayerImpl baseLayerImpl, String str) {
        baseLayerImpl.setName(str);
    }

    public static String SwigDirector_BaseLayerImpl_getName(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getName();
    }

    public static long SwigDirector_BaseLayerImpl_getLayerID(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getLayerID();
    }

    public static boolean SwigDirector_BaseLayerImpl_addLayer3DModel(BaseLayerImpl baseLayerImpl, Layer3DModel layer3DModel) {
        return baseLayerImpl.addLayer3DModel(layer3DModel);
    }

    public static boolean SwigDirector_BaseLayerImpl_destroyLayer3DModel(BaseLayerImpl baseLayerImpl, int i) {
        return baseLayerImpl.destroyLayer3DModel(i);
    }

    public static void SwigDirector_BaseLayerImpl_addLayerTexture(BaseLayerImpl baseLayerImpl, LayerTexture layerTexture) {
        baseLayerImpl.addLayerTexture(layerTexture);
    }

    public static void SwigDirector_BaseLayerImpl_removeLayerTexture(BaseLayerImpl baseLayerImpl, int i) {
        baseLayerImpl.removeLayerTexture(i);
    }

    public static boolean SwigDirector_BaseLayerImpl_addItem(BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        return baseLayerImpl.addItem(layerItemImpl);
    }

    public static void SwigDirector_BaseLayerImpl_addItems__SWIG_0(BaseLayerImpl baseLayerImpl, ArrayList<LayerItemImpl> arrayList, boolean z) {
        baseLayerImpl.addItems(arrayList, z);
    }

    public static void SwigDirector_BaseLayerImpl_addItems__SWIG_1(BaseLayerImpl baseLayerImpl, ArrayList<LayerItemImpl> arrayList) {
        baseLayerImpl.addItems(arrayList);
    }

    public static void SwigDirector_BaseLayerImpl_removeItem(BaseLayerImpl baseLayerImpl, String str) {
        baseLayerImpl.removeItem(str);
    }

    public static void SwigDirector_BaseLayerImpl_removeItems(BaseLayerImpl baseLayerImpl, String[] strArr) {
        baseLayerImpl.removeItems(strArr);
    }

    public static long SwigDirector_BaseLayerImpl_getItem(BaseLayerImpl baseLayerImpl, String str) {
        return LayerItemImpl.getCPtr(baseLayerImpl.getItem(str));
    }

    public static ArrayList<LayerItemImpl> SwigDirector_BaseLayerImpl_getAllItems(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getAllItems();
    }

    public static int SwigDirector_BaseLayerImpl_getCount(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getCount();
    }

    public static void SwigDirector_BaseLayerImpl_clearAllItems(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.clearAllItems();
    }

    public static void SwigDirector_BaseLayerImpl_setVisible(BaseLayerImpl baseLayerImpl, boolean z) {
        baseLayerImpl.setVisible(z);
    }

    public static boolean SwigDirector_BaseLayerImpl_getVisible(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getVisible();
    }

    public static void SwigDirector_BaseLayerImpl_saveVisible(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.saveVisible();
    }

    public static void SwigDirector_BaseLayerImpl_restoreVisible(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.restoreVisible();
    }

    public static void SwigDirector_BaseLayerImpl_setClickable(BaseLayerImpl baseLayerImpl, boolean z) {
        baseLayerImpl.setClickable(z);
    }

    public static boolean SwigDirector_BaseLayerImpl_getClickable(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getClickable();
    }

    public static void SwigDirector_BaseLayerImpl_addClickObserver(BaseLayerImpl baseLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        baseLayerImpl.addClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_BaseLayerImpl_removeClickObserver(BaseLayerImpl baseLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        baseLayerImpl.removeClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_BaseLayerImpl_setDisplayScale(BaseLayerImpl baseLayerImpl, LayerScale layerScale) {
        baseLayerImpl.setDisplayScale(layerScale);
    }

    public static void SwigDirector_BaseLayerImpl_getDisplayScale(BaseLayerImpl baseLayerImpl, LayerScale layerScale) {
        baseLayerImpl.getDisplayScale(layerScale);
    }

    public static void SwigDirector_BaseLayerImpl_setStyle(BaseLayerImpl baseLayerImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        baseLayerImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_BaseLayerImpl_updateStyle(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.updateStyle();
    }

    public static void SwigDirector_BaseLayerImpl_setFocus(BaseLayerImpl baseLayerImpl, String str, boolean z) {
        baseLayerImpl.setFocus(str, z);
    }

    public static boolean SwigDirector_BaseLayerImpl_getFocus(BaseLayerImpl baseLayerImpl, String str) {
        return baseLayerImpl.getFocus(str);
    }

    public static void SwigDirector_BaseLayerImpl_clearFocus(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.clearFocus();
    }

    public static void SwigDirector_BaseLayerImpl_addFocusChangeObserver(BaseLayerImpl baseLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        baseLayerImpl.addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_BaseLayerImpl_removeFocusChangeObserver(BaseLayerImpl baseLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        baseLayerImpl.removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_BaseLayerImpl_addCollisonRemoveObsever(BaseLayerImpl baseLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        baseLayerImpl.addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static void SwigDirector_BaseLayerImpl_removeCollisonRemoveObsever(BaseLayerImpl baseLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        baseLayerImpl.removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static RectDouble SwigDirector_BaseLayerImpl_getBound(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getBound();
    }

    public static void SwigDirector_BaseLayerImpl_setPriority(BaseLayerImpl baseLayerImpl, LayerPriority layerPriority) {
        baseLayerImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_BaseLayerImpl_sort(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.sort();
    }

    public static void SwigDirector_BaseLayerImpl_onPaint(BaseLayerImpl baseLayerImpl) {
        baseLayerImpl.onPaint();
    }

    public static boolean SwigDirector_BaseLayerImpl_enableCluster(BaseLayerImpl baseLayerImpl, boolean z) {
        return baseLayerImpl.enableCluster(z);
    }

    public static void SwigDirector_BaseLayerImpl_setBGDClusterStrategy(BaseLayerImpl baseLayerImpl, BGDClusterStrategy bGDClusterStrategy) {
        baseLayerImpl.setBGDClusterStrategy(bGDClusterStrategy);
    }

    public static void SwigDirector_BaseLayerImpl_enableItemsCollision(BaseLayerImpl baseLayerImpl, boolean z) {
        baseLayerImpl.enableItemsCollision(z);
    }

    public static boolean SwigDirector_BaseLayerImpl_isItemsCollision(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.isItemsCollision();
    }

    public static void SwigDirector_BaseLayerImpl_enablePoiFilter(BaseLayerImpl baseLayerImpl, boolean z) {
        baseLayerImpl.enablePoiFilter(z);
    }

    public static boolean SwigDirector_BaseLayerImpl_isEnablePoiFilter(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.isEnablePoiFilter();
    }

    public static void SwigDirector_BaseLayerImpl_setFilterPoiType(BaseLayerImpl baseLayerImpl, int i) {
        baseLayerImpl.setFilterPoiType(i);
    }

    public static int SwigDirector_BaseLayerImpl_getFilterPoiType(BaseLayerImpl baseLayerImpl) {
        return baseLayerImpl.getFilterPoiType();
    }

    public static void SwigDirector_MassPointLayerImpl_resetNextPair(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.resetNextPair();
    }

    public static boolean SwigDirector_MassPointLayerImpl_testIntersect(MassPointLayerImpl massPointLayerImpl, CollisionItemImpl collisionItemImpl) {
        return massPointLayerImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_MassPointLayerImpl_getType(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getType();
    }

    public static void SwigDirector_MassPointLayerImpl_enableAreaCollision(MassPointLayerImpl massPointLayerImpl, boolean z) {
        massPointLayerImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_isAreaCollision(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.isAreaCollision();
    }

    public static void SwigDirector_MassPointLayerImpl_enableCollision(MassPointLayerImpl massPointLayerImpl, boolean z) {
        massPointLayerImpl.enableCollision(z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_isCollision(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.isCollision();
    }

    public static void SwigDirector_MassPointLayerImpl_lockItems(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.lockItems();
    }

    public static void SwigDirector_MassPointLayerImpl_unLockItems(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.unLockItems();
    }

    public static void SwigDirector_MassPointLayerImpl_caculateCollision(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.caculateCollision();
    }

    public static void SwigDirector_MassPointLayerImpl_intersectUI(MassPointLayerImpl massPointLayerImpl, ArrayList<UIRectRecord> arrayList) {
        massPointLayerImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_MassPointLayerImpl_addCollisionItem(MassPointLayerImpl massPointLayerImpl, CollisionItemImpl collisionItemImpl) {
        return massPointLayerImpl.addCollisionItem(collisionItemImpl);
    }

    public static boolean SwigDirector_MassPointLayerImpl_removeCollisionItem(MassPointLayerImpl massPointLayerImpl, CollisionItemImpl collisionItemImpl) {
        return massPointLayerImpl.removeCollisionItem(collisionItemImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_clearAllCollisionItems(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_MassPointLayerImpl_getCollisionItems(MassPointLayerImpl massPointLayerImpl) {
        ArrayList<CollisionItemImpl> collisionItems = massPointLayerImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionItemImpl.getCPtr(collisionItems.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_MassPointLayerImpl_setIntersectAreaThreshold(MassPointLayerImpl massPointLayerImpl, float f) {
        massPointLayerImpl.setIntersectAreaThreshold(f);
    }

    public static float SwigDirector_MassPointLayerImpl_getIntersectAreaThreshold(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getIntersectAreaThreshold();
    }

    public static void SwigDirector_MassPointLayerImpl_setIntersectThreshold(MassPointLayerImpl massPointLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        massPointLayerImpl.setIntersectThreshold(i, f);
    }

    public static float SwigDirector_MassPointLayerImpl_getIntersectThreshold(MassPointLayerImpl massPointLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i) {
        return massPointLayerImpl.getIntersectThreshold(i);
    }

    public static void SwigDirector_MassPointLayerImpl_updateQuadrantItems(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.updateQuadrantItems();
    }

    public static void SwigDirector_MassPointLayerImpl_getPriority(MassPointLayerImpl massPointLayerImpl, LayerPriority layerPriority) {
        massPointLayerImpl.getPriority(layerPriority);
    }

    public static void SwigDirector_MassPointLayerImpl_applyItemsOnVisible(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.applyItemsOnVisible();
    }

    public static void SwigDirector_MassPointLayerImpl_setApplyItemsOnVisible(MassPointLayerImpl massPointLayerImpl, boolean z) {
        massPointLayerImpl.setApplyItemsOnVisible(z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_hasAppliedItemsOnVisible(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.hasAppliedItemsOnVisible();
    }

    public static String SwigDirector_MassPointLayerImpl_getTypeIdName(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getTypeIdName();
    }

    public static void SwigDirector_MassPointLayerImpl_setName(MassPointLayerImpl massPointLayerImpl, String str) {
        massPointLayerImpl.setName(str);
    }

    public static String SwigDirector_MassPointLayerImpl_getName(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getName();
    }

    public static long SwigDirector_MassPointLayerImpl_getLayerID(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getLayerID();
    }

    public static boolean SwigDirector_MassPointLayerImpl_addLayer3DModel(MassPointLayerImpl massPointLayerImpl, Layer3DModel layer3DModel) {
        return massPointLayerImpl.addLayer3DModel(layer3DModel);
    }

    public static boolean SwigDirector_MassPointLayerImpl_destroyLayer3DModel(MassPointLayerImpl massPointLayerImpl, int i) {
        return massPointLayerImpl.destroyLayer3DModel(i);
    }

    public static void SwigDirector_MassPointLayerImpl_addLayerTexture(MassPointLayerImpl massPointLayerImpl, LayerTexture layerTexture) {
        massPointLayerImpl.addLayerTexture(layerTexture);
    }

    public static void SwigDirector_MassPointLayerImpl_removeLayerTexture(MassPointLayerImpl massPointLayerImpl, int i) {
        massPointLayerImpl.removeLayerTexture(i);
    }

    public static boolean SwigDirector_MassPointLayerImpl_addItem(MassPointLayerImpl massPointLayerImpl, LayerItemImpl layerItemImpl) {
        return massPointLayerImpl.addItem(layerItemImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_addItems__SWIG_0(MassPointLayerImpl massPointLayerImpl, ArrayList<LayerItemImpl> arrayList, boolean z) {
        massPointLayerImpl.addItems(arrayList, z);
    }

    public static void SwigDirector_MassPointLayerImpl_addItems__SWIG_1(MassPointLayerImpl massPointLayerImpl, ArrayList<LayerItemImpl> arrayList) {
        massPointLayerImpl.addItems(arrayList);
    }

    public static void SwigDirector_MassPointLayerImpl_removeItem(MassPointLayerImpl massPointLayerImpl, String str) {
        massPointLayerImpl.removeItem(str);
    }

    public static void SwigDirector_MassPointLayerImpl_removeItems(MassPointLayerImpl massPointLayerImpl, String[] strArr) {
        massPointLayerImpl.removeItems(strArr);
    }

    public static long SwigDirector_MassPointLayerImpl_getItem(MassPointLayerImpl massPointLayerImpl, String str) {
        return LayerItemImpl.getCPtr(massPointLayerImpl.getItem(str));
    }

    public static ArrayList<LayerItemImpl> SwigDirector_MassPointLayerImpl_getAllItems(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getAllItems();
    }

    public static int SwigDirector_MassPointLayerImpl_getCount(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getCount();
    }

    public static void SwigDirector_MassPointLayerImpl_clearAllItems(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.clearAllItems();
    }

    public static void SwigDirector_MassPointLayerImpl_setVisible(MassPointLayerImpl massPointLayerImpl, boolean z) {
        massPointLayerImpl.setVisible(z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_getVisible(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getVisible();
    }

    public static void SwigDirector_MassPointLayerImpl_saveVisible(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.saveVisible();
    }

    public static void SwigDirector_MassPointLayerImpl_restoreVisible(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.restoreVisible();
    }

    public static void SwigDirector_MassPointLayerImpl_setClickable(MassPointLayerImpl massPointLayerImpl, boolean z) {
        massPointLayerImpl.setClickable(z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_getClickable(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getClickable();
    }

    public static void SwigDirector_MassPointLayerImpl_addClickObserver(MassPointLayerImpl massPointLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        massPointLayerImpl.addClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_removeClickObserver(MassPointLayerImpl massPointLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        massPointLayerImpl.removeClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_setDisplayScale(MassPointLayerImpl massPointLayerImpl, LayerScale layerScale) {
        massPointLayerImpl.setDisplayScale(layerScale);
    }

    public static void SwigDirector_MassPointLayerImpl_getDisplayScale(MassPointLayerImpl massPointLayerImpl, LayerScale layerScale) {
        massPointLayerImpl.getDisplayScale(layerScale);
    }

    public static void SwigDirector_MassPointLayerImpl_setStyle(MassPointLayerImpl massPointLayerImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        massPointLayerImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_updateStyle(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.updateStyle();
    }

    public static void SwigDirector_MassPointLayerImpl_setFocus(MassPointLayerImpl massPointLayerImpl, String str, boolean z) {
        massPointLayerImpl.setFocus(str, z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_getFocus(MassPointLayerImpl massPointLayerImpl, String str) {
        return massPointLayerImpl.getFocus(str);
    }

    public static void SwigDirector_MassPointLayerImpl_clearFocus(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.clearFocus();
    }

    public static void SwigDirector_MassPointLayerImpl_addFocusChangeObserver(MassPointLayerImpl massPointLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        massPointLayerImpl.addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_removeFocusChangeObserver(MassPointLayerImpl massPointLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        massPointLayerImpl.removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_addCollisonRemoveObsever(MassPointLayerImpl massPointLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        massPointLayerImpl.addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static void SwigDirector_MassPointLayerImpl_removeCollisonRemoveObsever(MassPointLayerImpl massPointLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        massPointLayerImpl.removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static RectDouble SwigDirector_MassPointLayerImpl_getBound(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getBound();
    }

    public static void SwigDirector_MassPointLayerImpl_setPriority(MassPointLayerImpl massPointLayerImpl, LayerPriority layerPriority) {
        massPointLayerImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_MassPointLayerImpl_sort(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.sort();
    }

    public static void SwigDirector_MassPointLayerImpl_onPaint(MassPointLayerImpl massPointLayerImpl) {
        massPointLayerImpl.onPaint();
    }

    public static boolean SwigDirector_MassPointLayerImpl_enableCluster(MassPointLayerImpl massPointLayerImpl, boolean z) {
        return massPointLayerImpl.enableCluster(z);
    }

    public static void SwigDirector_MassPointLayerImpl_setBGDClusterStrategy(MassPointLayerImpl massPointLayerImpl, BGDClusterStrategy bGDClusterStrategy) {
        massPointLayerImpl.setBGDClusterStrategy(bGDClusterStrategy);
    }

    public static void SwigDirector_MassPointLayerImpl_enableItemsCollision(MassPointLayerImpl massPointLayerImpl, boolean z) {
        massPointLayerImpl.enableItemsCollision(z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_isItemsCollision(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.isItemsCollision();
    }

    public static void SwigDirector_MassPointLayerImpl_enablePoiFilter(MassPointLayerImpl massPointLayerImpl, boolean z) {
        massPointLayerImpl.enablePoiFilter(z);
    }

    public static boolean SwigDirector_MassPointLayerImpl_isEnablePoiFilter(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.isEnablePoiFilter();
    }

    public static void SwigDirector_MassPointLayerImpl_setFilterPoiType(MassPointLayerImpl massPointLayerImpl, int i) {
        massPointLayerImpl.setFilterPoiType(i);
    }

    public static int SwigDirector_MassPointLayerImpl_getFilterPoiType(MassPointLayerImpl massPointLayerImpl) {
        return massPointLayerImpl.getFilterPoiType();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_resetOnVisible(RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z) {
        rctRouteLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_onVisible(RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z) {
        rctRouteLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_getOnVisible(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_applyOnVisible(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RctRouteLayerItemImpl_getBound(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_getVisible(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RctRouteLayerItemImpl_getPriority(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_isAreaCollision(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setAreaCollision(RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z) {
        rctRouteLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_canCollision(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_canAreaCollision(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_RctRouteLayerItemImpl_getTypeIdName(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RctRouteLayerItemImpl_getItemType(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_setID(RctRouteLayerItemImpl rctRouteLayerItemImpl, String str) {
        return rctRouteLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RctRouteLayerItemImpl_getID(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_setInfo(RctRouteLayerItemImpl rctRouteLayerItemImpl, String str) {
        return rctRouteLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RctRouteLayerItemImpl_getInfo(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setPriority(RctRouteLayerItemImpl rctRouteLayerItemImpl, int i) {
        rctRouteLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setVisible(RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z) {
        rctRouteLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_getFocus(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setAlpha(RctRouteLayerItemImpl rctRouteLayerItemImpl, double d) {
        rctRouteLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RctRouteLayerItemImpl_getAlpha(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setAngle(RctRouteLayerItemImpl rctRouteLayerItemImpl, double d) {
        rctRouteLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RctRouteLayerItemImpl_getAngle(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setPitch(RctRouteLayerItemImpl rctRouteLayerItemImpl, double d) {
        rctRouteLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RctRouteLayerItemImpl_getPitch(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setMaxPitch(RctRouteLayerItemImpl rctRouteLayerItemImpl, double d) {
        rctRouteLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RctRouteLayerItemImpl_getMaxPitch(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setClickable(RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z) {
        rctRouteLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_getClickable(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getClickable();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setDisplayScale(RctRouteLayerItemImpl rctRouteLayerItemImpl, LayerScale layerScale) {
        rctRouteLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RctRouteLayerItemImpl_getDisplayScale(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setAnimation(RctRouteLayerItemImpl rctRouteLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        rctRouteLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setStyle__SWIG_0(RctRouteLayerItemImpl rctRouteLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        rctRouteLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setStyle__SWIG_1(RctRouteLayerItemImpl rctRouteLayerItemImpl, String str) {
        rctRouteLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_updateStyle(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_updateStyle__SWIG_1(RctRouteLayerItemImpl rctRouteLayerItemImpl, LayerItemImpl layerItemImpl) {
        rctRouteLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_addPoiFilter(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_removePoiFilter(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_onPaint(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setParent(RctRouteLayerItemImpl rctRouteLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        rctRouteLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_setBusinessType(RctRouteLayerItemImpl rctRouteLayerItemImpl, int i) {
        rctRouteLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RctRouteLayerItemImpl_getBusinessType(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        return rctRouteLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_clearStyle(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.clearStyle();
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_setFlyRoute(RctRouteLayerItemImpl rctRouteLayerItemImpl, byte[] bArr) {
        return rctRouteLayerItemImpl.setFlyRoute(bArr);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_setFlyTmc(RctRouteLayerItemImpl rctRouteLayerItemImpl, byte[] bArr, ArrayList<RealCityTmcParam> arrayList) {
        return rctRouteLayerItemImpl.setFlyTmc(bArr, arrayList);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_updataNaviInfo(RctRouteLayerItemImpl rctRouteLayerItemImpl, RealCityNaviInfo realCityNaviInfo) {
        rctRouteLayerItemImpl.updataNaviInfo(realCityNaviInfo);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_setRctNaviMode(RctRouteLayerItemImpl rctRouteLayerItemImpl, int i) {
        return rctRouteLayerItemImpl.setRctNaviMode(i);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_setRctHeadAngleSync(RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z) {
        return rctRouteLayerItemImpl.setRctHeadAngleSync(z);
    }

    public static boolean SwigDirector_RctRouteLayerItemImpl_setGpsPos(RctRouteLayerItemImpl rctRouteLayerItemImpl, Vector3i vector3i, float f) {
        return rctRouteLayerItemImpl.setGpsPos(vector3i, f);
    }

    public static void SwigDirector_RctRouteLayerItemImpl_startNavi(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.startNavi();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_pauseNavi(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.pauseNavi();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_resumeNavi(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.resumeNavi();
    }

    public static void SwigDirector_RctRouteLayerItemImpl_stopNavi(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        rctRouteLayerItemImpl.stopNavi();
    }

    public static void SwigDirector_VectorCrossLayerImpl_resetNextPair(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.resetNextPair();
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_testIntersect(VectorCrossLayerImpl vectorCrossLayerImpl, CollisionItemImpl collisionItemImpl) {
        return vectorCrossLayerImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_VectorCrossLayerImpl_getType(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getType();
    }

    public static void SwigDirector_VectorCrossLayerImpl_enableAreaCollision(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        vectorCrossLayerImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_isAreaCollision(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.isAreaCollision();
    }

    public static void SwigDirector_VectorCrossLayerImpl_enableCollision(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        vectorCrossLayerImpl.enableCollision(z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_isCollision(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.isCollision();
    }

    public static void SwigDirector_VectorCrossLayerImpl_lockItems(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.lockItems();
    }

    public static void SwigDirector_VectorCrossLayerImpl_unLockItems(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.unLockItems();
    }

    public static void SwigDirector_VectorCrossLayerImpl_caculateCollision(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.caculateCollision();
    }

    public static void SwigDirector_VectorCrossLayerImpl_intersectUI(VectorCrossLayerImpl vectorCrossLayerImpl, ArrayList<UIRectRecord> arrayList) {
        vectorCrossLayerImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_addCollisionItem(VectorCrossLayerImpl vectorCrossLayerImpl, CollisionItemImpl collisionItemImpl) {
        return vectorCrossLayerImpl.addCollisionItem(collisionItemImpl);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_removeCollisionItem(VectorCrossLayerImpl vectorCrossLayerImpl, CollisionItemImpl collisionItemImpl) {
        return vectorCrossLayerImpl.removeCollisionItem(collisionItemImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_clearAllCollisionItems(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_VectorCrossLayerImpl_getCollisionItems(VectorCrossLayerImpl vectorCrossLayerImpl) {
        ArrayList<CollisionItemImpl> collisionItems = vectorCrossLayerImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionItemImpl.getCPtr(collisionItems.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_VectorCrossLayerImpl_setIntersectAreaThreshold(VectorCrossLayerImpl vectorCrossLayerImpl, float f) {
        vectorCrossLayerImpl.setIntersectAreaThreshold(f);
    }

    public static float SwigDirector_VectorCrossLayerImpl_getIntersectAreaThreshold(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getIntersectAreaThreshold();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setIntersectThreshold(VectorCrossLayerImpl vectorCrossLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        vectorCrossLayerImpl.setIntersectThreshold(i, f);
    }

    public static float SwigDirector_VectorCrossLayerImpl_getIntersectThreshold(VectorCrossLayerImpl vectorCrossLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i) {
        return vectorCrossLayerImpl.getIntersectThreshold(i);
    }

    public static void SwigDirector_VectorCrossLayerImpl_updateQuadrantItems(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.updateQuadrantItems();
    }

    public static void SwigDirector_VectorCrossLayerImpl_getPriority(VectorCrossLayerImpl vectorCrossLayerImpl, LayerPriority layerPriority) {
        vectorCrossLayerImpl.getPriority(layerPriority);
    }

    public static void SwigDirector_VectorCrossLayerImpl_applyItemsOnVisible(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.applyItemsOnVisible();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setApplyItemsOnVisible(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        vectorCrossLayerImpl.setApplyItemsOnVisible(z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_hasAppliedItemsOnVisible(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.hasAppliedItemsOnVisible();
    }

    public static String SwigDirector_VectorCrossLayerImpl_getTypeIdName(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getTypeIdName();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setName(VectorCrossLayerImpl vectorCrossLayerImpl, String str) {
        vectorCrossLayerImpl.setName(str);
    }

    public static String SwigDirector_VectorCrossLayerImpl_getName(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getName();
    }

    public static long SwigDirector_VectorCrossLayerImpl_getLayerID(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getLayerID();
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_addLayer3DModel(VectorCrossLayerImpl vectorCrossLayerImpl, Layer3DModel layer3DModel) {
        return vectorCrossLayerImpl.addLayer3DModel(layer3DModel);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_destroyLayer3DModel(VectorCrossLayerImpl vectorCrossLayerImpl, int i) {
        return vectorCrossLayerImpl.destroyLayer3DModel(i);
    }

    public static void SwigDirector_VectorCrossLayerImpl_addLayerTexture(VectorCrossLayerImpl vectorCrossLayerImpl, LayerTexture layerTexture) {
        vectorCrossLayerImpl.addLayerTexture(layerTexture);
    }

    public static void SwigDirector_VectorCrossLayerImpl_removeLayerTexture(VectorCrossLayerImpl vectorCrossLayerImpl, int i) {
        vectorCrossLayerImpl.removeLayerTexture(i);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_addItem(VectorCrossLayerImpl vectorCrossLayerImpl, LayerItemImpl layerItemImpl) {
        return vectorCrossLayerImpl.addItem(layerItemImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_addItems__SWIG_0(VectorCrossLayerImpl vectorCrossLayerImpl, ArrayList<LayerItemImpl> arrayList, boolean z) {
        vectorCrossLayerImpl.addItems(arrayList, z);
    }

    public static void SwigDirector_VectorCrossLayerImpl_addItems__SWIG_1(VectorCrossLayerImpl vectorCrossLayerImpl, ArrayList<LayerItemImpl> arrayList) {
        vectorCrossLayerImpl.addItems(arrayList);
    }

    public static void SwigDirector_VectorCrossLayerImpl_removeItem(VectorCrossLayerImpl vectorCrossLayerImpl, String str) {
        vectorCrossLayerImpl.removeItem(str);
    }

    public static void SwigDirector_VectorCrossLayerImpl_removeItems(VectorCrossLayerImpl vectorCrossLayerImpl, String[] strArr) {
        vectorCrossLayerImpl.removeItems(strArr);
    }

    public static long SwigDirector_VectorCrossLayerImpl_getItem(VectorCrossLayerImpl vectorCrossLayerImpl, String str) {
        return LayerItemImpl.getCPtr(vectorCrossLayerImpl.getItem(str));
    }

    public static ArrayList<LayerItemImpl> SwigDirector_VectorCrossLayerImpl_getAllItems(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getAllItems();
    }

    public static int SwigDirector_VectorCrossLayerImpl_getCount(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getCount();
    }

    public static void SwigDirector_VectorCrossLayerImpl_clearAllItems(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.clearAllItems();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setVisible(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        vectorCrossLayerImpl.setVisible(z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_getVisible(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getVisible();
    }

    public static void SwigDirector_VectorCrossLayerImpl_saveVisible(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.saveVisible();
    }

    public static void SwigDirector_VectorCrossLayerImpl_restoreVisible(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.restoreVisible();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setClickable(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        vectorCrossLayerImpl.setClickable(z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_getClickable(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getClickable();
    }

    public static void SwigDirector_VectorCrossLayerImpl_addClickObserver(VectorCrossLayerImpl vectorCrossLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        vectorCrossLayerImpl.addClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_removeClickObserver(VectorCrossLayerImpl vectorCrossLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        vectorCrossLayerImpl.removeClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_setDisplayScale(VectorCrossLayerImpl vectorCrossLayerImpl, LayerScale layerScale) {
        vectorCrossLayerImpl.setDisplayScale(layerScale);
    }

    public static void SwigDirector_VectorCrossLayerImpl_getDisplayScale(VectorCrossLayerImpl vectorCrossLayerImpl, LayerScale layerScale) {
        vectorCrossLayerImpl.getDisplayScale(layerScale);
    }

    public static void SwigDirector_VectorCrossLayerImpl_setStyle(VectorCrossLayerImpl vectorCrossLayerImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        vectorCrossLayerImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_updateStyle(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.updateStyle();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setFocus(VectorCrossLayerImpl vectorCrossLayerImpl, String str, boolean z) {
        vectorCrossLayerImpl.setFocus(str, z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_getFocus(VectorCrossLayerImpl vectorCrossLayerImpl, String str) {
        return vectorCrossLayerImpl.getFocus(str);
    }

    public static void SwigDirector_VectorCrossLayerImpl_clearFocus(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.clearFocus();
    }

    public static void SwigDirector_VectorCrossLayerImpl_addFocusChangeObserver(VectorCrossLayerImpl vectorCrossLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        vectorCrossLayerImpl.addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_removeFocusChangeObserver(VectorCrossLayerImpl vectorCrossLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        vectorCrossLayerImpl.removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_addCollisonRemoveObsever(VectorCrossLayerImpl vectorCrossLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        vectorCrossLayerImpl.addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static void SwigDirector_VectorCrossLayerImpl_removeCollisonRemoveObsever(VectorCrossLayerImpl vectorCrossLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        vectorCrossLayerImpl.removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static RectDouble SwigDirector_VectorCrossLayerImpl_getBound(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getBound();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setPriority(VectorCrossLayerImpl vectorCrossLayerImpl, LayerPriority layerPriority) {
        vectorCrossLayerImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_VectorCrossLayerImpl_sort(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.sort();
    }

    public static void SwigDirector_VectorCrossLayerImpl_onPaint(VectorCrossLayerImpl vectorCrossLayerImpl) {
        vectorCrossLayerImpl.onPaint();
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_enableCluster(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        return vectorCrossLayerImpl.enableCluster(z);
    }

    public static void SwigDirector_VectorCrossLayerImpl_setBGDClusterStrategy(VectorCrossLayerImpl vectorCrossLayerImpl, BGDClusterStrategy bGDClusterStrategy) {
        vectorCrossLayerImpl.setBGDClusterStrategy(bGDClusterStrategy);
    }

    public static void SwigDirector_VectorCrossLayerImpl_enableItemsCollision(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        vectorCrossLayerImpl.enableItemsCollision(z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_isItemsCollision(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.isItemsCollision();
    }

    public static void SwigDirector_VectorCrossLayerImpl_enablePoiFilter(VectorCrossLayerImpl vectorCrossLayerImpl, boolean z) {
        vectorCrossLayerImpl.enablePoiFilter(z);
    }

    public static boolean SwigDirector_VectorCrossLayerImpl_isEnablePoiFilter(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.isEnablePoiFilter();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setFilterPoiType(VectorCrossLayerImpl vectorCrossLayerImpl, int i) {
        vectorCrossLayerImpl.setFilterPoiType(i);
    }

    public static int SwigDirector_VectorCrossLayerImpl_getFilterPoiType(VectorCrossLayerImpl vectorCrossLayerImpl) {
        return vectorCrossLayerImpl.getFilterPoiType();
    }

    public static void SwigDirector_VectorCrossLayerImpl_setBusinessType(VectorCrossLayerImpl vectorCrossLayerImpl, int i) {
        vectorCrossLayerImpl.setBusinessType(i);
    }

    public static void SwigDirector_VectorCrossLayerImpl_setVectorCar(VectorCrossLayerImpl vectorCrossLayerImpl, Coord3DDouble coord3DDouble, int i) {
        vectorCrossLayerImpl.setVectorCar(coord3DDouble, i);
    }

    public static int SwigDirector_VectorCrossLayerImpl_showVectorCross(VectorCrossLayerImpl vectorCrossLayerImpl, byte[] bArr) {
        return vectorCrossLayerImpl.showVectorCross(bArr);
    }

    public static void SwigDirector_VectorCrossLayerImpl_setViewPostureEvent(VectorCrossLayerImpl vectorCrossLayerImpl, @VectorCrossViewPostureEvent.VectorCrossViewPostureEvent1 int i) {
        vectorCrossLayerImpl.setViewPostureEvent(i);
    }

    public static void SwigDirector_VectorCrossLayerImpl_setVectorViewRect(VectorCrossLayerImpl vectorCrossLayerImpl, RectInt rectInt) {
        vectorCrossLayerImpl.setVectorViewRect(rectInt);
    }

    public static void SwigDirector_MassDataLayerImpl_resetNextPair(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.resetNextPair();
    }

    public static boolean SwigDirector_MassDataLayerImpl_testIntersect(MassDataLayerImpl massDataLayerImpl, CollisionItemImpl collisionItemImpl) {
        return massDataLayerImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_MassDataLayerImpl_getType(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getType();
    }

    public static void SwigDirector_MassDataLayerImpl_enableAreaCollision(MassDataLayerImpl massDataLayerImpl, boolean z) {
        massDataLayerImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_isAreaCollision(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.isAreaCollision();
    }

    public static void SwigDirector_MassDataLayerImpl_enableCollision(MassDataLayerImpl massDataLayerImpl, boolean z) {
        massDataLayerImpl.enableCollision(z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_isCollision(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.isCollision();
    }

    public static void SwigDirector_MassDataLayerImpl_lockItems(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.lockItems();
    }

    public static void SwigDirector_MassDataLayerImpl_unLockItems(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.unLockItems();
    }

    public static void SwigDirector_MassDataLayerImpl_caculateCollision(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.caculateCollision();
    }

    public static void SwigDirector_MassDataLayerImpl_intersectUI(MassDataLayerImpl massDataLayerImpl, ArrayList<UIRectRecord> arrayList) {
        massDataLayerImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_MassDataLayerImpl_addCollisionItem(MassDataLayerImpl massDataLayerImpl, CollisionItemImpl collisionItemImpl) {
        return massDataLayerImpl.addCollisionItem(collisionItemImpl);
    }

    public static boolean SwigDirector_MassDataLayerImpl_removeCollisionItem(MassDataLayerImpl massDataLayerImpl, CollisionItemImpl collisionItemImpl) {
        return massDataLayerImpl.removeCollisionItem(collisionItemImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_clearAllCollisionItems(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_MassDataLayerImpl_getCollisionItems(MassDataLayerImpl massDataLayerImpl) {
        ArrayList<CollisionItemImpl> collisionItems = massDataLayerImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionItemImpl.getCPtr(collisionItems.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_MassDataLayerImpl_setIntersectAreaThreshold(MassDataLayerImpl massDataLayerImpl, float f) {
        massDataLayerImpl.setIntersectAreaThreshold(f);
    }

    public static float SwigDirector_MassDataLayerImpl_getIntersectAreaThreshold(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getIntersectAreaThreshold();
    }

    public static void SwigDirector_MassDataLayerImpl_setIntersectThreshold(MassDataLayerImpl massDataLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        massDataLayerImpl.setIntersectThreshold(i, f);
    }

    public static float SwigDirector_MassDataLayerImpl_getIntersectThreshold(MassDataLayerImpl massDataLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i) {
        return massDataLayerImpl.getIntersectThreshold(i);
    }

    public static void SwigDirector_MassDataLayerImpl_updateQuadrantItems(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.updateQuadrantItems();
    }

    public static void SwigDirector_MassDataLayerImpl_getPriority(MassDataLayerImpl massDataLayerImpl, LayerPriority layerPriority) {
        massDataLayerImpl.getPriority(layerPriority);
    }

    public static void SwigDirector_MassDataLayerImpl_applyItemsOnVisible(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.applyItemsOnVisible();
    }

    public static void SwigDirector_MassDataLayerImpl_setApplyItemsOnVisible(MassDataLayerImpl massDataLayerImpl, boolean z) {
        massDataLayerImpl.setApplyItemsOnVisible(z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_hasAppliedItemsOnVisible(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.hasAppliedItemsOnVisible();
    }

    public static String SwigDirector_MassDataLayerImpl_getTypeIdName(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getTypeIdName();
    }

    public static void SwigDirector_MassDataLayerImpl_setName(MassDataLayerImpl massDataLayerImpl, String str) {
        massDataLayerImpl.setName(str);
    }

    public static String SwigDirector_MassDataLayerImpl_getName(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getName();
    }

    public static long SwigDirector_MassDataLayerImpl_getLayerID(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getLayerID();
    }

    public static boolean SwigDirector_MassDataLayerImpl_addLayer3DModel(MassDataLayerImpl massDataLayerImpl, Layer3DModel layer3DModel) {
        return massDataLayerImpl.addLayer3DModel(layer3DModel);
    }

    public static boolean SwigDirector_MassDataLayerImpl_destroyLayer3DModel(MassDataLayerImpl massDataLayerImpl, int i) {
        return massDataLayerImpl.destroyLayer3DModel(i);
    }

    public static void SwigDirector_MassDataLayerImpl_addLayerTexture(MassDataLayerImpl massDataLayerImpl, LayerTexture layerTexture) {
        massDataLayerImpl.addLayerTexture(layerTexture);
    }

    public static void SwigDirector_MassDataLayerImpl_removeLayerTexture(MassDataLayerImpl massDataLayerImpl, int i) {
        massDataLayerImpl.removeLayerTexture(i);
    }

    public static boolean SwigDirector_MassDataLayerImpl_addItem(MassDataLayerImpl massDataLayerImpl, LayerItemImpl layerItemImpl) {
        return massDataLayerImpl.addItem(layerItemImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_addItems__SWIG_0(MassDataLayerImpl massDataLayerImpl, ArrayList<LayerItemImpl> arrayList, boolean z) {
        massDataLayerImpl.addItems(arrayList, z);
    }

    public static void SwigDirector_MassDataLayerImpl_addItems__SWIG_1(MassDataLayerImpl massDataLayerImpl, ArrayList<LayerItemImpl> arrayList) {
        massDataLayerImpl.addItems(arrayList);
    }

    public static void SwigDirector_MassDataLayerImpl_removeItem(MassDataLayerImpl massDataLayerImpl, String str) {
        massDataLayerImpl.removeItem(str);
    }

    public static void SwigDirector_MassDataLayerImpl_removeItems(MassDataLayerImpl massDataLayerImpl, String[] strArr) {
        massDataLayerImpl.removeItems(strArr);
    }

    public static long SwigDirector_MassDataLayerImpl_getItem(MassDataLayerImpl massDataLayerImpl, String str) {
        return LayerItemImpl.getCPtr(massDataLayerImpl.getItem(str));
    }

    public static ArrayList<LayerItemImpl> SwigDirector_MassDataLayerImpl_getAllItems(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getAllItems();
    }

    public static int SwigDirector_MassDataLayerImpl_getCount(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getCount();
    }

    public static void SwigDirector_MassDataLayerImpl_clearAllItems(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.clearAllItems();
    }

    public static void SwigDirector_MassDataLayerImpl_setVisible(MassDataLayerImpl massDataLayerImpl, boolean z) {
        massDataLayerImpl.setVisible(z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_getVisible(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getVisible();
    }

    public static void SwigDirector_MassDataLayerImpl_saveVisible(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.saveVisible();
    }

    public static void SwigDirector_MassDataLayerImpl_restoreVisible(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.restoreVisible();
    }

    public static void SwigDirector_MassDataLayerImpl_setClickable(MassDataLayerImpl massDataLayerImpl, boolean z) {
        massDataLayerImpl.setClickable(z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_getClickable(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getClickable();
    }

    public static void SwigDirector_MassDataLayerImpl_addClickObserver(MassDataLayerImpl massDataLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        massDataLayerImpl.addClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_removeClickObserver(MassDataLayerImpl massDataLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        massDataLayerImpl.removeClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_setDisplayScale(MassDataLayerImpl massDataLayerImpl, LayerScale layerScale) {
        massDataLayerImpl.setDisplayScale(layerScale);
    }

    public static void SwigDirector_MassDataLayerImpl_getDisplayScale(MassDataLayerImpl massDataLayerImpl, LayerScale layerScale) {
        massDataLayerImpl.getDisplayScale(layerScale);
    }

    public static void SwigDirector_MassDataLayerImpl_setStyle(MassDataLayerImpl massDataLayerImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        massDataLayerImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_updateStyle(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.updateStyle();
    }

    public static void SwigDirector_MassDataLayerImpl_setFocus(MassDataLayerImpl massDataLayerImpl, String str, boolean z) {
        massDataLayerImpl.setFocus(str, z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_getFocus(MassDataLayerImpl massDataLayerImpl, String str) {
        return massDataLayerImpl.getFocus(str);
    }

    public static void SwigDirector_MassDataLayerImpl_clearFocus(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.clearFocus();
    }

    public static void SwigDirector_MassDataLayerImpl_addFocusChangeObserver(MassDataLayerImpl massDataLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        massDataLayerImpl.addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_removeFocusChangeObserver(MassDataLayerImpl massDataLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        massDataLayerImpl.removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_addCollisonRemoveObsever(MassDataLayerImpl massDataLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        massDataLayerImpl.addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static void SwigDirector_MassDataLayerImpl_removeCollisonRemoveObsever(MassDataLayerImpl massDataLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        massDataLayerImpl.removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static RectDouble SwigDirector_MassDataLayerImpl_getBound(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getBound();
    }

    public static void SwigDirector_MassDataLayerImpl_setPriority(MassDataLayerImpl massDataLayerImpl, LayerPriority layerPriority) {
        massDataLayerImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_MassDataLayerImpl_sort(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.sort();
    }

    public static void SwigDirector_MassDataLayerImpl_onPaint(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.onPaint();
    }

    public static boolean SwigDirector_MassDataLayerImpl_enableCluster(MassDataLayerImpl massDataLayerImpl, boolean z) {
        return massDataLayerImpl.enableCluster(z);
    }

    public static void SwigDirector_MassDataLayerImpl_setBGDClusterStrategy(MassDataLayerImpl massDataLayerImpl, BGDClusterStrategy bGDClusterStrategy) {
        massDataLayerImpl.setBGDClusterStrategy(bGDClusterStrategy);
    }

    public static void SwigDirector_MassDataLayerImpl_enableItemsCollision(MassDataLayerImpl massDataLayerImpl, boolean z) {
        massDataLayerImpl.enableItemsCollision(z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_isItemsCollision(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.isItemsCollision();
    }

    public static void SwigDirector_MassDataLayerImpl_enablePoiFilter(MassDataLayerImpl massDataLayerImpl, boolean z) {
        massDataLayerImpl.enablePoiFilter(z);
    }

    public static boolean SwigDirector_MassDataLayerImpl_isEnablePoiFilter(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.isEnablePoiFilter();
    }

    public static void SwigDirector_MassDataLayerImpl_setFilterPoiType(MassDataLayerImpl massDataLayerImpl, int i) {
        massDataLayerImpl.setFilterPoiType(i);
    }

    public static int SwigDirector_MassDataLayerImpl_getFilterPoiType(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getFilterPoiType();
    }

    public static void SwigDirector_MassDataLayerImpl_setDisplayScaleCount__SWIG_0(MassDataLayerImpl massDataLayerImpl, HashMap<Integer, Integer> hashMap) {
        massDataLayerImpl.setDisplayScaleCount(hashMap);
    }

    public static void SwigDirector_MassDataLayerImpl_setDisplayScaleCount__SWIG_1(MassDataLayerImpl massDataLayerImpl, int i, int i2) {
        massDataLayerImpl.setDisplayScaleCount(i, i2);
    }

    public static void SwigDirector_MassDataLayerImpl_setLengthOfCenterChanged(MassDataLayerImpl massDataLayerImpl, long j) {
        massDataLayerImpl.setLengthOfCenterChanged(j);
    }

    public static void SwigDirector_MassDataLayerImpl_setRollAngleOfCenterChanged(MassDataLayerImpl massDataLayerImpl, long j) {
        massDataLayerImpl.setRollAngleOfCenterChanged(j);
    }

    public static void SwigDirector_MassDataLayerImpl_addPointData(MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPointInfo> arrayList) {
        massDataLayerImpl.addPointData(arrayList);
    }

    public static void SwigDirector_MassDataLayerImpl_addPolylineData(MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPolylineInfo> arrayList) {
        massDataLayerImpl.addPolylineData(arrayList);
    }

    public static void SwigDirector_MassDataLayerImpl_addPolygonData(MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataPolygonInfo> arrayList) {
        massDataLayerImpl.addPolygonData(arrayList);
    }

    public static void SwigDirector_MassDataLayerImpl_addCircleData(MassDataLayerImpl massDataLayerImpl, ArrayList<MassDataCircleInfo> arrayList) {
        massDataLayerImpl.addCircleData(arrayList);
    }

    public static void SwigDirector_MassDataLayerImpl_removePointData(MassDataLayerImpl massDataLayerImpl, String[] strArr) {
        massDataLayerImpl.removePointData(strArr);
    }

    public static void SwigDirector_MassDataLayerImpl_removePolylineData(MassDataLayerImpl massDataLayerImpl, String[] strArr) {
        massDataLayerImpl.removePolylineData(strArr);
    }

    public static void SwigDirector_MassDataLayerImpl_removePolygonData(MassDataLayerImpl massDataLayerImpl, String[] strArr) {
        massDataLayerImpl.removePolygonData(strArr);
    }

    public static void SwigDirector_MassDataLayerImpl_removeCircleData(MassDataLayerImpl massDataLayerImpl, String[] strArr) {
        massDataLayerImpl.removeCircleData(strArr);
    }

    public static void SwigDirector_MassDataLayerImpl_removeAllPointData(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.removeAllPointData();
    }

    public static void SwigDirector_MassDataLayerImpl_removeAllPolylineData(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.removeAllPolylineData();
    }

    public static void SwigDirector_MassDataLayerImpl_removeAllPolygonData(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.removeAllPolygonData();
    }

    public static void SwigDirector_MassDataLayerImpl_removeAllCircleData(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.removeAllCircleData();
    }

    public static void SwigDirector_MassDataLayerImpl_removeAllData(MassDataLayerImpl massDataLayerImpl) {
        massDataLayerImpl.removeAllData();
    }

    public static long SwigDirector_MassDataLayerImpl_getPointDataCount(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getPointDataCount();
    }

    public static long SwigDirector_MassDataLayerImpl_getPolylineDataCount(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getPolylineDataCount();
    }

    public static long SwigDirector_MassDataLayerImpl_getPolygonDataCount(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getPolygonDataCount();
    }

    public static long SwigDirector_MassDataLayerImpl_getCircleDataCount(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getCircleDataCount();
    }

    public static long SwigDirector_MassDataLayerImpl_getAllDataCount(MassDataLayerImpl massDataLayerImpl) {
        return massDataLayerImpl.getAllDataCount();
    }

    public static void SwigDirector_QuadrantLayerImpl_resetNextPair(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.resetNextPair();
    }

    public static boolean SwigDirector_QuadrantLayerImpl_testIntersect(QuadrantLayerImpl quadrantLayerImpl, CollisionItemImpl collisionItemImpl) {
        return quadrantLayerImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_QuadrantLayerImpl_getType(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getType();
    }

    public static void SwigDirector_QuadrantLayerImpl_enableAreaCollision(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        quadrantLayerImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_isAreaCollision(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.isAreaCollision();
    }

    public static void SwigDirector_QuadrantLayerImpl_enableCollision(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        quadrantLayerImpl.enableCollision(z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_isCollision(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.isCollision();
    }

    public static void SwigDirector_QuadrantLayerImpl_lockItems(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.lockItems();
    }

    public static void SwigDirector_QuadrantLayerImpl_unLockItems(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.unLockItems();
    }

    public static void SwigDirector_QuadrantLayerImpl_caculateCollision(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.caculateCollision();
    }

    public static void SwigDirector_QuadrantLayerImpl_intersectUI(QuadrantLayerImpl quadrantLayerImpl, ArrayList<UIRectRecord> arrayList) {
        quadrantLayerImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_addCollisionItem(QuadrantLayerImpl quadrantLayerImpl, CollisionItemImpl collisionItemImpl) {
        return quadrantLayerImpl.addCollisionItem(collisionItemImpl);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_removeCollisionItem(QuadrantLayerImpl quadrantLayerImpl, CollisionItemImpl collisionItemImpl) {
        return quadrantLayerImpl.removeCollisionItem(collisionItemImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_clearAllCollisionItems(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_QuadrantLayerImpl_getCollisionItems(QuadrantLayerImpl quadrantLayerImpl) {
        ArrayList<CollisionItemImpl> collisionItems = quadrantLayerImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionItemImpl.getCPtr(collisionItems.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_QuadrantLayerImpl_setIntersectAreaThreshold(QuadrantLayerImpl quadrantLayerImpl, float f) {
        quadrantLayerImpl.setIntersectAreaThreshold(f);
    }

    public static float SwigDirector_QuadrantLayerImpl_getIntersectAreaThreshold(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getIntersectAreaThreshold();
    }

    public static void SwigDirector_QuadrantLayerImpl_setIntersectThreshold(QuadrantLayerImpl quadrantLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        quadrantLayerImpl.setIntersectThreshold(i, f);
    }

    public static float SwigDirector_QuadrantLayerImpl_getIntersectThreshold(QuadrantLayerImpl quadrantLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i) {
        return quadrantLayerImpl.getIntersectThreshold(i);
    }

    public static void SwigDirector_QuadrantLayerImpl_updateQuadrantItems(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.updateQuadrantItems();
    }

    public static void SwigDirector_QuadrantLayerImpl_getPriority(QuadrantLayerImpl quadrantLayerImpl, LayerPriority layerPriority) {
        quadrantLayerImpl.getPriority(layerPriority);
    }

    public static void SwigDirector_QuadrantLayerImpl_applyItemsOnVisible(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.applyItemsOnVisible();
    }

    public static void SwigDirector_QuadrantLayerImpl_setApplyItemsOnVisible(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        quadrantLayerImpl.setApplyItemsOnVisible(z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_hasAppliedItemsOnVisible(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.hasAppliedItemsOnVisible();
    }

    public static String SwigDirector_QuadrantLayerImpl_getTypeIdName(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getTypeIdName();
    }

    public static void SwigDirector_QuadrantLayerImpl_setName(QuadrantLayerImpl quadrantLayerImpl, String str) {
        quadrantLayerImpl.setName(str);
    }

    public static String SwigDirector_QuadrantLayerImpl_getName(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getName();
    }

    public static long SwigDirector_QuadrantLayerImpl_getLayerID(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getLayerID();
    }

    public static boolean SwigDirector_QuadrantLayerImpl_addLayer3DModel(QuadrantLayerImpl quadrantLayerImpl, Layer3DModel layer3DModel) {
        return quadrantLayerImpl.addLayer3DModel(layer3DModel);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_destroyLayer3DModel(QuadrantLayerImpl quadrantLayerImpl, int i) {
        return quadrantLayerImpl.destroyLayer3DModel(i);
    }

    public static void SwigDirector_QuadrantLayerImpl_addLayerTexture(QuadrantLayerImpl quadrantLayerImpl, LayerTexture layerTexture) {
        quadrantLayerImpl.addLayerTexture(layerTexture);
    }

    public static void SwigDirector_QuadrantLayerImpl_removeLayerTexture(QuadrantLayerImpl quadrantLayerImpl, int i) {
        quadrantLayerImpl.removeLayerTexture(i);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_addItem(QuadrantLayerImpl quadrantLayerImpl, LayerItemImpl layerItemImpl) {
        return quadrantLayerImpl.addItem(layerItemImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_addItems__SWIG_0(QuadrantLayerImpl quadrantLayerImpl, ArrayList<LayerItemImpl> arrayList, boolean z) {
        quadrantLayerImpl.addItems(arrayList, z);
    }

    public static void SwigDirector_QuadrantLayerImpl_addItems__SWIG_1(QuadrantLayerImpl quadrantLayerImpl, ArrayList<LayerItemImpl> arrayList) {
        quadrantLayerImpl.addItems(arrayList);
    }

    public static void SwigDirector_QuadrantLayerImpl_removeItem(QuadrantLayerImpl quadrantLayerImpl, String str) {
        quadrantLayerImpl.removeItem(str);
    }

    public static void SwigDirector_QuadrantLayerImpl_removeItems(QuadrantLayerImpl quadrantLayerImpl, String[] strArr) {
        quadrantLayerImpl.removeItems(strArr);
    }

    public static long SwigDirector_QuadrantLayerImpl_getItem(QuadrantLayerImpl quadrantLayerImpl, String str) {
        return LayerItemImpl.getCPtr(quadrantLayerImpl.getItem(str));
    }

    public static ArrayList<LayerItemImpl> SwigDirector_QuadrantLayerImpl_getAllItems(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getAllItems();
    }

    public static int SwigDirector_QuadrantLayerImpl_getCount(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getCount();
    }

    public static void SwigDirector_QuadrantLayerImpl_clearAllItems(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.clearAllItems();
    }

    public static void SwigDirector_QuadrantLayerImpl_setVisible(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        quadrantLayerImpl.setVisible(z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_getVisible(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getVisible();
    }

    public static void SwigDirector_QuadrantLayerImpl_saveVisible(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.saveVisible();
    }

    public static void SwigDirector_QuadrantLayerImpl_restoreVisible(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.restoreVisible();
    }

    public static void SwigDirector_QuadrantLayerImpl_setClickable(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        quadrantLayerImpl.setClickable(z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_getClickable(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getClickable();
    }

    public static void SwigDirector_QuadrantLayerImpl_addClickObserver(QuadrantLayerImpl quadrantLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        quadrantLayerImpl.addClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_removeClickObserver(QuadrantLayerImpl quadrantLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        quadrantLayerImpl.removeClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_setDisplayScale(QuadrantLayerImpl quadrantLayerImpl, LayerScale layerScale) {
        quadrantLayerImpl.setDisplayScale(layerScale);
    }

    public static void SwigDirector_QuadrantLayerImpl_getDisplayScale(QuadrantLayerImpl quadrantLayerImpl, LayerScale layerScale) {
        quadrantLayerImpl.getDisplayScale(layerScale);
    }

    public static void SwigDirector_QuadrantLayerImpl_setStyle(QuadrantLayerImpl quadrantLayerImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        quadrantLayerImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_updateStyle(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.updateStyle();
    }

    public static void SwigDirector_QuadrantLayerImpl_setFocus(QuadrantLayerImpl quadrantLayerImpl, String str, boolean z) {
        quadrantLayerImpl.setFocus(str, z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_getFocus(QuadrantLayerImpl quadrantLayerImpl, String str) {
        return quadrantLayerImpl.getFocus(str);
    }

    public static void SwigDirector_QuadrantLayerImpl_clearFocus(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.clearFocus();
    }

    public static void SwigDirector_QuadrantLayerImpl_addFocusChangeObserver(QuadrantLayerImpl quadrantLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        quadrantLayerImpl.addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_removeFocusChangeObserver(QuadrantLayerImpl quadrantLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        quadrantLayerImpl.removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_addCollisonRemoveObsever(QuadrantLayerImpl quadrantLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        quadrantLayerImpl.addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static void SwigDirector_QuadrantLayerImpl_removeCollisonRemoveObsever(QuadrantLayerImpl quadrantLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        quadrantLayerImpl.removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static RectDouble SwigDirector_QuadrantLayerImpl_getBound(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getBound();
    }

    public static void SwigDirector_QuadrantLayerImpl_setPriority(QuadrantLayerImpl quadrantLayerImpl, LayerPriority layerPriority) {
        quadrantLayerImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_QuadrantLayerImpl_sort(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.sort();
    }

    public static void SwigDirector_QuadrantLayerImpl_onPaint(QuadrantLayerImpl quadrantLayerImpl) {
        quadrantLayerImpl.onPaint();
    }

    public static boolean SwigDirector_QuadrantLayerImpl_enableCluster(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        return quadrantLayerImpl.enableCluster(z);
    }

    public static void SwigDirector_QuadrantLayerImpl_setBGDClusterStrategy(QuadrantLayerImpl quadrantLayerImpl, BGDClusterStrategy bGDClusterStrategy) {
        quadrantLayerImpl.setBGDClusterStrategy(bGDClusterStrategy);
    }

    public static void SwigDirector_QuadrantLayerImpl_enableItemsCollision(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        quadrantLayerImpl.enableItemsCollision(z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_isItemsCollision(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.isItemsCollision();
    }

    public static void SwigDirector_QuadrantLayerImpl_enablePoiFilter(QuadrantLayerImpl quadrantLayerImpl, boolean z) {
        quadrantLayerImpl.enablePoiFilter(z);
    }

    public static boolean SwigDirector_QuadrantLayerImpl_isEnablePoiFilter(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.isEnablePoiFilter();
    }

    public static void SwigDirector_QuadrantLayerImpl_setFilterPoiType(QuadrantLayerImpl quadrantLayerImpl, int i) {
        quadrantLayerImpl.setFilterPoiType(i);
    }

    public static int SwigDirector_QuadrantLayerImpl_getFilterPoiType(QuadrantLayerImpl quadrantLayerImpl) {
        return quadrantLayerImpl.getFilterPoiType();
    }

    public static void SwigDirector_RoutePathLayerImpl_resetNextPair(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.resetNextPair();
    }

    public static boolean SwigDirector_RoutePathLayerImpl_testIntersect(RoutePathLayerImpl routePathLayerImpl, CollisionItemImpl collisionItemImpl) {
        return routePathLayerImpl.testIntersect(collisionItemImpl);
    }

    @CollisionType.CollisionType1
    public static int SwigDirector_RoutePathLayerImpl_getType(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getType();
    }

    public static void SwigDirector_RoutePathLayerImpl_enableAreaCollision(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.enableAreaCollision(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_isAreaCollision(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.isAreaCollision();
    }

    public static void SwigDirector_RoutePathLayerImpl_enableCollision(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.enableCollision(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_isCollision(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.isCollision();
    }

    public static void SwigDirector_RoutePathLayerImpl_lockItems(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.lockItems();
    }

    public static void SwigDirector_RoutePathLayerImpl_unLockItems(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.unLockItems();
    }

    public static void SwigDirector_RoutePathLayerImpl_caculateCollision(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.caculateCollision();
    }

    public static void SwigDirector_RoutePathLayerImpl_intersectUI(RoutePathLayerImpl routePathLayerImpl, ArrayList<UIRectRecord> arrayList) {
        routePathLayerImpl.intersectUI(arrayList);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_addCollisionItem(RoutePathLayerImpl routePathLayerImpl, CollisionItemImpl collisionItemImpl) {
        return routePathLayerImpl.addCollisionItem(collisionItemImpl);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_removeCollisionItem(RoutePathLayerImpl routePathLayerImpl, CollisionItemImpl collisionItemImpl) {
        return routePathLayerImpl.removeCollisionItem(collisionItemImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_clearAllCollisionItems(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.clearAllCollisionItems();
    }

    public static long[] SwigDirector_RoutePathLayerImpl_getCollisionItems(RoutePathLayerImpl routePathLayerImpl) {
        ArrayList<CollisionItemImpl> collisionItems = routePathLayerImpl.getCollisionItems();
        if (collisionItems != null) {
            int size = collisionItems.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = CollisionItemImpl.getCPtr(collisionItems.get(i));
            }
            return jArr;
        }
        return null;
    }

    public static void SwigDirector_RoutePathLayerImpl_setIntersectAreaThreshold(RoutePathLayerImpl routePathLayerImpl, float f) {
        routePathLayerImpl.setIntersectAreaThreshold(f);
    }

    public static float SwigDirector_RoutePathLayerImpl_getIntersectAreaThreshold(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getIntersectAreaThreshold();
    }

    public static void SwigDirector_RoutePathLayerImpl_setIntersectThreshold(RoutePathLayerImpl routePathLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i, float f) {
        routePathLayerImpl.setIntersectThreshold(i, f);
    }

    public static float SwigDirector_RoutePathLayerImpl_getIntersectThreshold(RoutePathLayerImpl routePathLayerImpl, @IntersectThresholdType.IntersectThresholdType1 int i) {
        return routePathLayerImpl.getIntersectThreshold(i);
    }

    public static void SwigDirector_RoutePathLayerImpl_updateQuadrantItems(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.updateQuadrantItems();
    }

    public static void SwigDirector_RoutePathLayerImpl_getPriority(RoutePathLayerImpl routePathLayerImpl, LayerPriority layerPriority) {
        routePathLayerImpl.getPriority(layerPriority);
    }

    public static void SwigDirector_RoutePathLayerImpl_applyItemsOnVisible(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.applyItemsOnVisible();
    }

    public static void SwigDirector_RoutePathLayerImpl_setApplyItemsOnVisible(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.setApplyItemsOnVisible(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_hasAppliedItemsOnVisible(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.hasAppliedItemsOnVisible();
    }

    public static String SwigDirector_RoutePathLayerImpl_getTypeIdName(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getTypeIdName();
    }

    public static void SwigDirector_RoutePathLayerImpl_setName(RoutePathLayerImpl routePathLayerImpl, String str) {
        routePathLayerImpl.setName(str);
    }

    public static String SwigDirector_RoutePathLayerImpl_getName(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getName();
    }

    public static long SwigDirector_RoutePathLayerImpl_getLayerID(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getLayerID();
    }

    public static boolean SwigDirector_RoutePathLayerImpl_addLayer3DModel(RoutePathLayerImpl routePathLayerImpl, Layer3DModel layer3DModel) {
        return routePathLayerImpl.addLayer3DModel(layer3DModel);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_destroyLayer3DModel(RoutePathLayerImpl routePathLayerImpl, int i) {
        return routePathLayerImpl.destroyLayer3DModel(i);
    }

    public static void SwigDirector_RoutePathLayerImpl_addLayerTexture(RoutePathLayerImpl routePathLayerImpl, LayerTexture layerTexture) {
        routePathLayerImpl.addLayerTexture(layerTexture);
    }

    public static void SwigDirector_RoutePathLayerImpl_removeLayerTexture(RoutePathLayerImpl routePathLayerImpl, int i) {
        routePathLayerImpl.removeLayerTexture(i);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_addItem(RoutePathLayerImpl routePathLayerImpl, LayerItemImpl layerItemImpl) {
        return routePathLayerImpl.addItem(layerItemImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_addItems__SWIG_0(RoutePathLayerImpl routePathLayerImpl, ArrayList<LayerItemImpl> arrayList, boolean z) {
        routePathLayerImpl.addItems(arrayList, z);
    }

    public static void SwigDirector_RoutePathLayerImpl_addItems__SWIG_1(RoutePathLayerImpl routePathLayerImpl, ArrayList<LayerItemImpl> arrayList) {
        routePathLayerImpl.addItems(arrayList);
    }

    public static void SwigDirector_RoutePathLayerImpl_removeItem(RoutePathLayerImpl routePathLayerImpl, String str) {
        routePathLayerImpl.removeItem(str);
    }

    public static void SwigDirector_RoutePathLayerImpl_removeItems(RoutePathLayerImpl routePathLayerImpl, String[] strArr) {
        routePathLayerImpl.removeItems(strArr);
    }

    public static long SwigDirector_RoutePathLayerImpl_getItem(RoutePathLayerImpl routePathLayerImpl, String str) {
        return LayerItemImpl.getCPtr(routePathLayerImpl.getItem(str));
    }

    public static ArrayList<LayerItemImpl> SwigDirector_RoutePathLayerImpl_getAllItems(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getAllItems();
    }

    public static int SwigDirector_RoutePathLayerImpl_getCount(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getCount();
    }

    public static void SwigDirector_RoutePathLayerImpl_clearAllItems(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.clearAllItems();
    }

    public static void SwigDirector_RoutePathLayerImpl_setVisible(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.setVisible(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_getVisible(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getVisible();
    }

    public static void SwigDirector_RoutePathLayerImpl_saveVisible(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.saveVisible();
    }

    public static void SwigDirector_RoutePathLayerImpl_restoreVisible(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.restoreVisible();
    }

    public static void SwigDirector_RoutePathLayerImpl_setClickable(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.setClickable(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_getClickable(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getClickable();
    }

    public static void SwigDirector_RoutePathLayerImpl_addClickObserver(RoutePathLayerImpl routePathLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        routePathLayerImpl.addClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_removeClickObserver(RoutePathLayerImpl routePathLayerImpl, ILayerClickObserverImpl iLayerClickObserverImpl) {
        routePathLayerImpl.removeClickObserver(iLayerClickObserverImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_setDisplayScale(RoutePathLayerImpl routePathLayerImpl, LayerScale layerScale) {
        routePathLayerImpl.setDisplayScale(layerScale);
    }

    public static void SwigDirector_RoutePathLayerImpl_getDisplayScale(RoutePathLayerImpl routePathLayerImpl, LayerScale layerScale) {
        routePathLayerImpl.getDisplayScale(layerScale);
    }

    public static void SwigDirector_RoutePathLayerImpl_setStyle(RoutePathLayerImpl routePathLayerImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routePathLayerImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_updateStyle(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.updateStyle();
    }

    public static void SwigDirector_RoutePathLayerImpl_setFocus(RoutePathLayerImpl routePathLayerImpl, String str, boolean z) {
        routePathLayerImpl.setFocus(str, z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_getFocus(RoutePathLayerImpl routePathLayerImpl, String str) {
        return routePathLayerImpl.getFocus(str);
    }

    public static void SwigDirector_RoutePathLayerImpl_clearFocus(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.clearFocus();
    }

    public static void SwigDirector_RoutePathLayerImpl_addFocusChangeObserver(RoutePathLayerImpl routePathLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        routePathLayerImpl.addFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_removeFocusChangeObserver(RoutePathLayerImpl routePathLayerImpl, ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl) {
        routePathLayerImpl.removeFocusChangeObserver(iLayerFocusChangeObserverImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_addCollisonRemoveObsever(RoutePathLayerImpl routePathLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        routePathLayerImpl.addCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_removeCollisonRemoveObsever(RoutePathLayerImpl routePathLayerImpl, ICollisonRemoveObseverImpl iCollisonRemoveObseverImpl) {
        routePathLayerImpl.removeCollisonRemoveObsever(iCollisonRemoveObseverImpl);
    }

    public static RectDouble SwigDirector_RoutePathLayerImpl_getBound(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getBound();
    }

    public static void SwigDirector_RoutePathLayerImpl_setPriority(RoutePathLayerImpl routePathLayerImpl, LayerPriority layerPriority) {
        routePathLayerImpl.setPriority(layerPriority);
    }

    public static void SwigDirector_RoutePathLayerImpl_sort(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.sort();
    }

    public static void SwigDirector_RoutePathLayerImpl_onPaint(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.onPaint();
    }

    public static boolean SwigDirector_RoutePathLayerImpl_enableCluster(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        return routePathLayerImpl.enableCluster(z);
    }

    public static void SwigDirector_RoutePathLayerImpl_setBGDClusterStrategy(RoutePathLayerImpl routePathLayerImpl, BGDClusterStrategy bGDClusterStrategy) {
        routePathLayerImpl.setBGDClusterStrategy(bGDClusterStrategy);
    }

    public static void SwigDirector_RoutePathLayerImpl_enableItemsCollision(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.enableItemsCollision(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_isItemsCollision(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.isItemsCollision();
    }

    public static void SwigDirector_RoutePathLayerImpl_enablePoiFilter(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.enablePoiFilter(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_isEnablePoiFilter(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.isEnablePoiFilter();
    }

    public static void SwigDirector_RoutePathLayerImpl_setFilterPoiType(RoutePathLayerImpl routePathLayerImpl, int i) {
        routePathLayerImpl.setFilterPoiType(i);
    }

    public static int SwigDirector_RoutePathLayerImpl_getFilterPoiType(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getFilterPoiType();
    }

    public static void SwigDirector_RoutePathLayerImpl_setBusinessType(RoutePathLayerImpl routePathLayerImpl, int i) {
        routePathLayerImpl.setBusinessType(i);
    }

    public static void SwigDirector_RoutePathLayerImpl_setCar2DPosition(RoutePathLayerImpl routePathLayerImpl, long j, float f) {
        routePathLayerImpl.setCar2DPosition(j, f);
    }

    public static void SwigDirector_RoutePathLayerImpl_setCar3DPosition(RoutePathLayerImpl routePathLayerImpl, long j, float f) {
        routePathLayerImpl.setCar3DPosition(j, f);
    }

    public static void SwigDirector_RoutePathLayerImpl_addRouteName(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.addRouteName();
    }

    public static void SwigDirector_RoutePathLayerImpl_removeRouteName(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.removeRouteName();
    }

    public static void SwigDirector_RoutePathLayerImpl_setLineWidthScale(RoutePathLayerImpl routePathLayerImpl, float f) {
        routePathLayerImpl.setLineWidthScale(f);
    }

    public static void SwigDirector_RoutePathLayerImpl_setRouteItemParam(RoutePathLayerImpl routePathLayerImpl, RouteLayerParam routeLayerParam) {
        routePathLayerImpl.setRouteItemParam(routeLayerParam);
    }

    public static void SwigDirector_RoutePathLayerImpl_setRouteItemParams(RoutePathLayerImpl routePathLayerImpl, ArrayList<RouteLayerParam> arrayList) {
        routePathLayerImpl.setRouteItemParams(arrayList);
    }

    public static void SwigDirector_RoutePathLayerImpl_setPassedColor(RoutePathLayerImpl routePathLayerImpl, RouteLayerPassedColor routeLayerPassedColor) {
        routePathLayerImpl.setPassedColor(routeLayerPassedColor);
    }

    public static void SwigDirector_RoutePathLayerImpl_setRouteDrawParam(RoutePathLayerImpl routePathLayerImpl, RouteLayerDrawParam routeLayerDrawParam) {
        routePathLayerImpl.setRouteDrawParam(routeLayerDrawParam);
    }

    public static void SwigDirector_RoutePathLayerImpl_getRouteDrawParam(RoutePathLayerImpl routePathLayerImpl, RouteLayerDrawParam routeLayerDrawParam) {
        routePathLayerImpl.getRouteDrawParam(routeLayerDrawParam);
    }

    public static void SwigDirector_RoutePathLayerImpl_addRouteItem(RoutePathLayerImpl routePathLayerImpl, @RouteLayerScene.RouteLayerScene1 int i, int i2, byte[] bArr, short s) {
        routePathLayerImpl.addRouteItem(i, i2, bArr, s);
    }

    public static void SwigDirector_RoutePathLayerImpl_removeRouteItem(RoutePathLayerImpl routePathLayerImpl) {
        routePathLayerImpl.removeRouteItem();
    }

    public static boolean SwigDirector_RoutePathLayerImpl_isPathIntersectRect(RoutePathLayerImpl routePathLayerImpl, RectDouble rectDouble) {
        return routePathLayerImpl.isPathIntersectRect(rectDouble);
    }

    public static void SwigDirector_RoutePathLayerImpl_setHighlightType(RoutePathLayerImpl routePathLayerImpl, @MapRouteHighLightType.MapRouteHighLightType1 int i) {
        routePathLayerImpl.setHighlightType(i);
    }

    public static void SwigDirector_RoutePathLayerImpl_setSelectStatus(RoutePathLayerImpl routePathLayerImpl, boolean z) {
        routePathLayerImpl.setSelectStatus(z);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_getSelectStatus(RoutePathLayerImpl routePathLayerImpl) {
        return routePathLayerImpl.getSelectStatus();
    }

    public static void SwigDirector_RoutePathLayerImpl_setShowNaviRouteNameCountMap(RoutePathLayerImpl routePathLayerImpl, HashMap<Integer, Integer> hashMap) {
        routePathLayerImpl.setShowNaviRouteNameCountMap(hashMap);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_setDrawType(RoutePathLayerImpl routePathLayerImpl, @MapRoutePolylineDrawType.MapRoutePolylineDrawType1 int i) {
        return routePathLayerImpl.setDrawType(i);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_setGrownAnimation__SWIG_0(RoutePathLayerImpl routePathLayerImpl, int i, long j) {
        return routePathLayerImpl.setGrownAnimation(i, j);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_setGrownAnimation__SWIG_1(RoutePathLayerImpl routePathLayerImpl, int i) {
        return routePathLayerImpl.setGrownAnimation(i);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_setGrownAnimation__SWIG_2(RoutePathLayerImpl routePathLayerImpl, boolean z, int i, long j) {
        return routePathLayerImpl.setGrownAnimation(z, i, j);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_setGrownAnimation__SWIG_3(RoutePathLayerImpl routePathLayerImpl, boolean z, int i) {
        return routePathLayerImpl.setGrownAnimation(z, i);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_addGrownAnimationObserver(RoutePathLayerImpl routePathLayerImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return routePathLayerImpl.addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static boolean SwigDirector_RoutePathLayerImpl_removeGrownAnimationObserver(RoutePathLayerImpl routePathLayerImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return routePathLayerImpl.removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static void SwigDirector_RoutePathLayerImpl_setFilterZoomLevel(RoutePathLayerImpl routePathLayerImpl, float f, float f2) {
        routePathLayerImpl.setFilterZoomLevel(f, f2);
    }

    public static void SwigDirector_RoutePathLayerImpl_setParkFloor(RoutePathLayerImpl routePathLayerImpl, int i) {
        routePathLayerImpl.setParkFloor(i);
    }
}
