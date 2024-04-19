package com.autonavi.gbl.layer.impl;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ForeshorteningCoefParam;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.ItemMarkerInfo;
import com.autonavi.gbl.map.layer.model.LayerItemPoiAnimation;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.RotateMode;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.ScalePriority;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LayerLaneSvrJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_resetOnVisible(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, boolean z) {
        laneGuideCameraLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_onVisible(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, boolean z) {
        laneGuideCameraLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_getOnVisible(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_applyOnVisible(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        laneGuideCameraLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideCameraLayerItemImpl_getBound(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_getVisible(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideCameraLayerItemImpl_getPriority(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_isAreaCollision(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setAreaCollision(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, boolean z) {
        laneGuideCameraLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideCameraLayerItemImpl_getItemType(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_setID(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, String str) {
        return laneGuideCameraLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideCameraLayerItemImpl_getID(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_setInfo(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, String str) {
        return laneGuideCameraLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideCameraLayerItemImpl_getInfo(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setPriority(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, int i) {
        laneGuideCameraLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setVisible(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, boolean z) {
        laneGuideCameraLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_getFocus(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setAlpha(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, double d) {
        laneGuideCameraLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideCameraLayerItemImpl_getAlpha(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setAngle(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, double d) {
        laneGuideCameraLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideCameraLayerItemImpl_getAngle(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setPitch(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, double d) {
        laneGuideCameraLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideCameraLayerItemImpl_getPitch(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setMaxPitch(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, double d) {
        laneGuideCameraLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideCameraLayerItemImpl_getMaxPitch(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setDisplayScale(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, LayerScale layerScale) {
        laneGuideCameraLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideCameraLayerItemImpl_getDisplayScale(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setAnimation(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideCameraLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setStyle__SWIG_0(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideCameraLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setStyle__SWIG_1(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, String str) {
        laneGuideCameraLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_updateStyle__SWIG_0(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        laneGuideCameraLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_updateStyle__SWIG_1(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideCameraLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_addPoiFilter(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        laneGuideCameraLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_removePoiFilter(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        laneGuideCameraLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_onPaint(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        laneGuideCameraLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setParent(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideCameraLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setBusinessType(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, int i) {
        laneGuideCameraLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideCameraLayerItemImpl_getBusinessType(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_LaneGuideCameraLayerItemImpl_getTypeIdName(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_clearStyle(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        laneGuideCameraLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setVisible3V(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Visible3V visible3V) {
        laneGuideCameraLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_getVisible3V(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Visible3V visible3V) {
        laneGuideCameraLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setBillboard(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, boolean z) {
        laneGuideCameraLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_getBillboard(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setPosition3D(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCameraLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setRotateCenter3D(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCameraLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_getRotateCenter3D(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCameraLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setPosition(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCameraLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_getPosition(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCameraLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setRotateCenter(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCameraLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_getNormalStyle(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideCameraLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_getFocusStyle(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideCameraLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setItemVisibleRegion(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, RectInt rectInt) {
        laneGuideCameraLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setItemIgnoreRegion(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideCameraLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_getItemIgnoreRegion(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideCameraLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setScale(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideCameraLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_getScale(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideCameraLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setPointTypeCode(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, String str) {
        laneGuideCameraLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideCameraLayerItemImpl_getPointTypeCode(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setScaleFactor(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, float[] fArr) {
        laneGuideCameraLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setRotateMode(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideCameraLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_addMarker(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideCameraLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_clearAllMarkers(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        laneGuideCameraLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setForeshorteningCoef(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideCameraLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideCameraLayerItemImpl_getForeshorteningCoef(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_resetOnVisible(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, boolean z) {
        laneGuideTurnLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_onVisible(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, boolean z) {
        laneGuideTurnLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_getOnVisible(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_applyOnVisible(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        laneGuideTurnLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideTurnLayerItemImpl_getBound(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_getVisible(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideTurnLayerItemImpl_getPriority(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_isAreaCollision(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setAreaCollision(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, boolean z) {
        laneGuideTurnLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideTurnLayerItemImpl_getItemType(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_setID(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, String str) {
        return laneGuideTurnLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideTurnLayerItemImpl_getID(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_setInfo(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, String str) {
        return laneGuideTurnLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideTurnLayerItemImpl_getInfo(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setPriority(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, int i) {
        laneGuideTurnLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setVisible(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, boolean z) {
        laneGuideTurnLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_getFocus(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setAlpha(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, double d) {
        laneGuideTurnLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideTurnLayerItemImpl_getAlpha(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setAngle(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, double d) {
        laneGuideTurnLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideTurnLayerItemImpl_getAngle(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setPitch(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, double d) {
        laneGuideTurnLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideTurnLayerItemImpl_getPitch(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setMaxPitch(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, double d) {
        laneGuideTurnLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideTurnLayerItemImpl_getMaxPitch(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setDisplayScale(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, LayerScale layerScale) {
        laneGuideTurnLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideTurnLayerItemImpl_getDisplayScale(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setAnimation(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideTurnLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setStyle__SWIG_0(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideTurnLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setStyle__SWIG_1(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, String str) {
        laneGuideTurnLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_updateStyle__SWIG_0(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        laneGuideTurnLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_updateStyle__SWIG_1(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideTurnLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_addPoiFilter(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        laneGuideTurnLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_removePoiFilter(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        laneGuideTurnLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_onPaint(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        laneGuideTurnLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setParent(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideTurnLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setBusinessType(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, int i) {
        laneGuideTurnLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideTurnLayerItemImpl_getBusinessType(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_LaneGuideTurnLayerItemImpl_getTypeIdName(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_clearStyle(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        laneGuideTurnLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setVisible3V(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Visible3V visible3V) {
        laneGuideTurnLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_getVisible3V(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Visible3V visible3V) {
        laneGuideTurnLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setBillboard(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, boolean z) {
        laneGuideTurnLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_getBillboard(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setPosition3D(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTurnLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setRotateCenter3D(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTurnLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_getRotateCenter3D(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTurnLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setPosition(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTurnLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_getPosition(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTurnLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setRotateCenter(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTurnLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_getNormalStyle(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTurnLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_getFocusStyle(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTurnLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setItemVisibleRegion(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, RectInt rectInt) {
        laneGuideTurnLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setItemIgnoreRegion(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTurnLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_getItemIgnoreRegion(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTurnLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setScale(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideTurnLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_getScale(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideTurnLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setPointTypeCode(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, String str) {
        laneGuideTurnLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideTurnLayerItemImpl_getPointTypeCode(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setScaleFactor(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, float[] fArr) {
        laneGuideTurnLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setRotateMode(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideTurnLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_addMarker(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideTurnLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_clearAllMarkers(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        laneGuideTurnLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setForeshorteningCoef(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideTurnLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideTurnLayerItemImpl_getForeshorteningCoef(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_resetOnVisible(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z) {
        laneGuideCongestionLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_onVisible(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z) {
        laneGuideCongestionLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_getOnVisible(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_applyOnVisible(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideCongestionLayerItemImpl_getBound(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_getVisible(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideCongestionLayerItemImpl_getPriority(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_isAreaCollision(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setAreaCollision(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z) {
        laneGuideCongestionLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideCongestionLayerItemImpl_getItemType(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_setID(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, String str) {
        return laneGuideCongestionLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideCongestionLayerItemImpl_getID(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_setInfo(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, String str) {
        return laneGuideCongestionLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideCongestionLayerItemImpl_getInfo(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setPriority(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, int i) {
        laneGuideCongestionLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setVisible(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z) {
        laneGuideCongestionLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_getFocus(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setAlpha(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, double d) {
        laneGuideCongestionLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideCongestionLayerItemImpl_getAlpha(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setAngle(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, double d) {
        laneGuideCongestionLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideCongestionLayerItemImpl_getAngle(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setPitch(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, double d) {
        laneGuideCongestionLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideCongestionLayerItemImpl_getPitch(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setMaxPitch(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, double d) {
        laneGuideCongestionLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideCongestionLayerItemImpl_getMaxPitch(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setDisplayScale(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, LayerScale layerScale) {
        laneGuideCongestionLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideCongestionLayerItemImpl_getDisplayScale(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setAnimation(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideCongestionLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setStyle__SWIG_0(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideCongestionLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setStyle__SWIG_1(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, String str) {
        laneGuideCongestionLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_updateStyle__SWIG_0(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_updateStyle__SWIG_1(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideCongestionLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_addPoiFilter(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_removePoiFilter(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_onPaint(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setParent(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideCongestionLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setBusinessType(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, int i) {
        laneGuideCongestionLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideCongestionLayerItemImpl_getBusinessType(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_LaneGuideCongestionLayerItemImpl_getTypeIdName(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_clearStyle(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setVisible3V(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Visible3V visible3V) {
        laneGuideCongestionLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_getVisible3V(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Visible3V visible3V) {
        laneGuideCongestionLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setBillboard(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z) {
        laneGuideCongestionLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_getBillboard(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setPosition3D(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCongestionLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setRotateCenter3D(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCongestionLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_getRotateCenter3D(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCongestionLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setPosition(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCongestionLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_getPosition(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCongestionLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setRotateCenter(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideCongestionLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_getNormalStyle(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideCongestionLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_getFocusStyle(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideCongestionLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setItemVisibleRegion(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, RectInt rectInt) {
        laneGuideCongestionLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setItemIgnoreRegion(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideCongestionLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_getItemIgnoreRegion(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideCongestionLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setScale(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideCongestionLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_getScale(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideCongestionLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setPointTypeCode(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, String str) {
        laneGuideCongestionLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideCongestionLayerItemImpl_getPointTypeCode(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setScaleFactor(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, float[] fArr) {
        laneGuideCongestionLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setRotateMode(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideCongestionLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_addMarker(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideCongestionLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_clearAllMarkers(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setForeshorteningCoef(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideCongestionLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideCongestionLayerItemImpl_getForeshorteningCoef(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setIdle(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z) {
        laneGuideCongestionLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_isIdle(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.isIdle();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_addIntersectArea(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, float f) {
        laneGuideCongestionLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_LaneGuideCongestionLayerItemImpl_getIntersectArea(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_resetIntersectArea(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_addIntersectAreaEx(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, float f) {
        laneGuideCongestionLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_LaneGuideCongestionLayerItemImpl_getIntersectAreaEx(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_resetIntersectAreaEx(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        laneGuideCongestionLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_checkShowFlag(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_LaneGuideCongestionLayerItemImpl_getQuadrantGroupId(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_LaneGuideCongestionLayerItemImpl_getQuadrantType(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_resetOnVisible(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z) {
        laneGuideTrafficEventLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_onVisible(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z) {
        laneGuideTrafficEventLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_getOnVisible(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_applyOnVisible(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideTrafficEventLayerItemImpl_getBound(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_getVisible(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideTrafficEventLayerItemImpl_getPriority(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_isAreaCollision(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setAreaCollision(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z) {
        laneGuideTrafficEventLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideTrafficEventLayerItemImpl_getItemType(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_setID(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, String str) {
        return laneGuideTrafficEventLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideTrafficEventLayerItemImpl_getID(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_setInfo(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, String str) {
        return laneGuideTrafficEventLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideTrafficEventLayerItemImpl_getInfo(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setPriority(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i) {
        laneGuideTrafficEventLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setVisible(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z) {
        laneGuideTrafficEventLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_getFocus(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setAlpha(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, double d) {
        laneGuideTrafficEventLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideTrafficEventLayerItemImpl_getAlpha(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setAngle(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, double d) {
        laneGuideTrafficEventLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideTrafficEventLayerItemImpl_getAngle(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setPitch(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, double d) {
        laneGuideTrafficEventLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideTrafficEventLayerItemImpl_getPitch(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setMaxPitch(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, double d) {
        laneGuideTrafficEventLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideTrafficEventLayerItemImpl_getMaxPitch(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setDisplayScale(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, LayerScale layerScale) {
        laneGuideTrafficEventLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideTrafficEventLayerItemImpl_getDisplayScale(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setAnimation(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideTrafficEventLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setStyle__SWIG_0(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideTrafficEventLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setStyle__SWIG_1(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, String str) {
        laneGuideTrafficEventLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_updateStyle__SWIG_0(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_updateStyle__SWIG_1(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_addPoiFilter(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_removePoiFilter(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_onPaint(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setParent(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideTrafficEventLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setBusinessType(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, int i) {
        laneGuideTrafficEventLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideTrafficEventLayerItemImpl_getBusinessType(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_LaneGuideTrafficEventLayerItemImpl_getTypeIdName(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_clearStyle(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setVisible3V(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Visible3V visible3V) {
        laneGuideTrafficEventLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_getVisible3V(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Visible3V visible3V) {
        laneGuideTrafficEventLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setBillboard(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z) {
        laneGuideTrafficEventLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_getBillboard(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setPosition3D(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficEventLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setRotateCenter3D(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficEventLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_getRotateCenter3D(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficEventLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setPosition(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficEventLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_getPosition(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficEventLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setRotateCenter(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficEventLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_getNormalStyle(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTrafficEventLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_getFocusStyle(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTrafficEventLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setItemVisibleRegion(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, RectInt rectInt) {
        laneGuideTrafficEventLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setItemIgnoreRegion(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTrafficEventLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_getItemIgnoreRegion(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTrafficEventLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setScale(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideTrafficEventLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_getScale(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideTrafficEventLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setPointTypeCode(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, String str) {
        laneGuideTrafficEventLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideTrafficEventLayerItemImpl_getPointTypeCode(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setScaleFactor(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, float[] fArr) {
        laneGuideTrafficEventLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setRotateMode(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideTrafficEventLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_addMarker(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideTrafficEventLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_clearAllMarkers(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setForeshorteningCoef(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideTrafficEventLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideTrafficEventLayerItemImpl_getForeshorteningCoef(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setIdle(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z) {
        laneGuideTrafficEventLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_isIdle(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.isIdle();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_addIntersectArea(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, float f) {
        laneGuideTrafficEventLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_LaneGuideTrafficEventLayerItemImpl_getIntersectArea(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_resetIntersectArea(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_addIntersectAreaEx(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, float f) {
        laneGuideTrafficEventLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_LaneGuideTrafficEventLayerItemImpl_getIntersectAreaEx(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_resetIntersectAreaEx(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        laneGuideTrafficEventLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_checkShowFlag(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_LaneGuideTrafficEventLayerItemImpl_getQuadrantGroupId(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_LaneGuideTrafficEventLayerItemImpl_getQuadrantType(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_resetOnVisible(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z) {
        laneRoutePathPointItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_onVisible(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z) {
        laneRoutePathPointItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_getOnVisible(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_applyOnVisible(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        laneRoutePathPointItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneRoutePathPointItemImpl_getBound(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_getVisible(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getVisible();
    }

    public static int SwigDirector_LaneRoutePathPointItemImpl_getPriority(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_isAreaCollision(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setAreaCollision(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z) {
        laneRoutePathPointItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneRoutePathPointItemImpl_getItemType(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_setID(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, String str) {
        return laneRoutePathPointItemImpl.setID(str);
    }

    public static String SwigDirector_LaneRoutePathPointItemImpl_getID(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getID();
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_setInfo(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, String str) {
        return laneRoutePathPointItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneRoutePathPointItemImpl_getInfo(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getInfo();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setPriority(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, int i) {
        laneRoutePathPointItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setVisible(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z) {
        laneRoutePathPointItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_getFocus(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getFocus();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setAlpha(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, double d) {
        laneRoutePathPointItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneRoutePathPointItemImpl_getAlpha(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setAngle(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, double d) {
        laneRoutePathPointItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneRoutePathPointItemImpl_getAngle(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getAngle();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setPitch(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, double d) {
        laneRoutePathPointItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneRoutePathPointItemImpl_getPitch(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getPitch();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setMaxPitch(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, double d) {
        laneRoutePathPointItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneRoutePathPointItemImpl_getMaxPitch(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setDisplayScale(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, LayerScale layerScale) {
        laneRoutePathPointItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneRoutePathPointItemImpl_getDisplayScale(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setAnimation(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneRoutePathPointItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setStyle__SWIG_0(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneRoutePathPointItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setStyle__SWIG_1(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, String str) {
        laneRoutePathPointItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_updateStyle__SWIG_0(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        laneRoutePathPointItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_updateStyle__SWIG_1(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, LayerItemImpl layerItemImpl) {
        laneRoutePathPointItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_addPoiFilter(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        laneRoutePathPointItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_removePoiFilter(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        laneRoutePathPointItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_onPaint(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        laneRoutePathPointItemImpl.onPaint();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setParent(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, BaseLayerImpl baseLayerImpl) {
        laneRoutePathPointItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setBusinessType(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, int i) {
        laneRoutePathPointItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneRoutePathPointItemImpl_getBusinessType(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getBusinessType();
    }

    public static String SwigDirector_LaneRoutePathPointItemImpl_getTypeIdName(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getTypeIdName();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_clearStyle(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        laneRoutePathPointItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setVisible3V(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Visible3V visible3V) {
        laneRoutePathPointItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_getVisible3V(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Visible3V visible3V) {
        laneRoutePathPointItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setBillboard(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z) {
        laneRoutePathPointItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_getBillboard(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setPosition3D(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Coord3DDouble coord3DDouble) {
        laneRoutePathPointItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setRotateCenter3D(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Coord3DDouble coord3DDouble) {
        laneRoutePathPointItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_getRotateCenter3D(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Coord3DDouble coord3DDouble) {
        laneRoutePathPointItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setPosition(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Coord3DDouble coord3DDouble) {
        laneRoutePathPointItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_getPosition(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Coord3DDouble coord3DDouble) {
        laneRoutePathPointItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setRotateCenter(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, Coord3DDouble coord3DDouble) {
        laneRoutePathPointItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_getNormalStyle(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneRoutePathPointItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_getFocusStyle(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneRoutePathPointItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setItemVisibleRegion(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, RectInt rectInt) {
        laneRoutePathPointItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setItemIgnoreRegion(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneRoutePathPointItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_getItemIgnoreRegion(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneRoutePathPointItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setScale(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneRoutePathPointItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_getScale(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, ScaleAttribute scaleAttribute) {
        laneRoutePathPointItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setPointTypeCode(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, String str) {
        laneRoutePathPointItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneRoutePathPointItemImpl_getPointTypeCode(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setScaleFactor(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, float[] fArr) {
        laneRoutePathPointItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setRotateMode(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, @RotateMode.RotateMode1 int i) {
        laneRoutePathPointItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_addMarker(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneRoutePathPointItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_clearAllMarkers(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        laneRoutePathPointItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneRoutePathPointItemImpl_setForeshorteningCoef(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneRoutePathPointItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneRoutePathPointItemImpl_getForeshorteningCoef(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getForeshorteningCoef();
    }
}
