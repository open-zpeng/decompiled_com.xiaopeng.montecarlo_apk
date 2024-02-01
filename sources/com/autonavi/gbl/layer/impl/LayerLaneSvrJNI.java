package com.autonavi.gbl.layer.impl;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ForeshorteningCoefParam;
import com.autonavi.gbl.map.layer.model.IntersectValueType;
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
/* loaded from: classes2.dex */
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

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_canCollision(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_canAreaCollision(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideCameraLayerItemImpl_getTypeIdName(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getTypeIdName();
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

    public static void SwigDirector_LaneGuideCameraLayerItemImpl_setClickable(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, boolean z) {
        laneGuideCameraLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideCameraLayerItemImpl_getClickable(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        return laneGuideCameraLayerItemImpl.getClickable();
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

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_canCollision(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_canAreaCollision(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideTurnLayerItemImpl_getTypeIdName(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getTypeIdName();
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

    public static void SwigDirector_LaneGuideTurnLayerItemImpl_setClickable(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl, boolean z) {
        laneGuideTurnLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideTurnLayerItemImpl_getClickable(LaneGuideTurnLayerItemImpl laneGuideTurnLayerItemImpl) {
        return laneGuideTurnLayerItemImpl.getClickable();
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

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_canCollision(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_canAreaCollision(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideCongestionLayerItemImpl_getTypeIdName(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getTypeIdName();
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

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_setClickable(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, boolean z) {
        laneGuideCongestionLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideCongestionLayerItemImpl_getClickable(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl) {
        return laneGuideCongestionLayerItemImpl.getClickable();
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

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_addIntersectValue(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, @IntersectValueType.IntersectValueType1 int i, float f) {
        laneGuideCongestionLayerItemImpl.addIntersectValue(i, f);
    }

    public static float SwigDirector_LaneGuideCongestionLayerItemImpl_getIntersectValue(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        return laneGuideCongestionLayerItemImpl.getIntersectValue(i);
    }

    public static void SwigDirector_LaneGuideCongestionLayerItemImpl_resetIntersectValue(LaneGuideCongestionLayerItemImpl laneGuideCongestionLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        laneGuideCongestionLayerItemImpl.resetIntersectValue(i);
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

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_canCollision(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_canAreaCollision(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideTrafficEventLayerItemImpl_getTypeIdName(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getTypeIdName();
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

    public static void SwigDirector_LaneGuideTrafficEventLayerItemImpl_setClickable(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl, boolean z) {
        laneGuideTrafficEventLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficEventLayerItemImpl_getClickable(LaneGuideTrafficEventLayerItemImpl laneGuideTrafficEventLayerItemImpl) {
        return laneGuideTrafficEventLayerItemImpl.getClickable();
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

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_canCollision(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_canAreaCollision(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneRoutePathPointItemImpl_getTypeIdName(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getTypeIdName();
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

    public static void SwigDirector_LaneRoutePathPointItemImpl_setClickable(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z) {
        laneRoutePathPointItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneRoutePathPointItemImpl_getClickable(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        return laneRoutePathPointItemImpl.getClickable();
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

    public static void SwigDirector_LaneGuideOddInfoItemImpl_resetOnVisible(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, boolean z) {
        laneGuideOddInfoItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_onVisible(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, boolean z) {
        laneGuideOddInfoItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_getOnVisible(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_applyOnVisible(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        laneGuideOddInfoItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideOddInfoItemImpl_getBound(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_getVisible(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideOddInfoItemImpl_getPriority(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_isAreaCollision(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setAreaCollision(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, boolean z) {
        laneGuideOddInfoItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_canCollision(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_canAreaCollision(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideOddInfoItemImpl_getTypeIdName(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideOddInfoItemImpl_getItemType(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_setID(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, String str) {
        return laneGuideOddInfoItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideOddInfoItemImpl_getID(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_setInfo(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, String str) {
        return laneGuideOddInfoItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideOddInfoItemImpl_getInfo(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setPriority(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, int i) {
        laneGuideOddInfoItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setVisible(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, boolean z) {
        laneGuideOddInfoItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_getFocus(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setAlpha(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, double d) {
        laneGuideOddInfoItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideOddInfoItemImpl_getAlpha(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setAngle(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, double d) {
        laneGuideOddInfoItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideOddInfoItemImpl_getAngle(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setPitch(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, double d) {
        laneGuideOddInfoItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideOddInfoItemImpl_getPitch(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setMaxPitch(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, double d) {
        laneGuideOddInfoItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideOddInfoItemImpl_getMaxPitch(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setClickable(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, boolean z) {
        laneGuideOddInfoItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_getClickable(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setDisplayScale(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, LayerScale layerScale) {
        laneGuideOddInfoItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideOddInfoItemImpl_getDisplayScale(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setAnimation(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideOddInfoItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setStyle__SWIG_0(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideOddInfoItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setStyle__SWIG_1(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, String str) {
        laneGuideOddInfoItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_updateStyle__SWIG_0(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        laneGuideOddInfoItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_updateStyle__SWIG_1(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideOddInfoItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_addPoiFilter(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        laneGuideOddInfoItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_removePoiFilter(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        laneGuideOddInfoItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_onPaint(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        laneGuideOddInfoItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setParent(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideOddInfoItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setBusinessType(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, int i) {
        laneGuideOddInfoItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideOddInfoItemImpl_getBusinessType(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_clearStyle(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        laneGuideOddInfoItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setVisible3V(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Visible3V visible3V) {
        laneGuideOddInfoItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_getVisible3V(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Visible3V visible3V) {
        laneGuideOddInfoItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setBillboard(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, boolean z) {
        laneGuideOddInfoItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_getBillboard(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setPosition3D(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideOddInfoItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setRotateCenter3D(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideOddInfoItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_getRotateCenter3D(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideOddInfoItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setPosition(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideOddInfoItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_getPosition(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideOddInfoItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setRotateCenter(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideOddInfoItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_getNormalStyle(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideOddInfoItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_getFocusStyle(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideOddInfoItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setItemVisibleRegion(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, RectInt rectInt) {
        laneGuideOddInfoItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setItemIgnoreRegion(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideOddInfoItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_getItemIgnoreRegion(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideOddInfoItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setScale(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideOddInfoItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_getScale(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideOddInfoItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setPointTypeCode(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, String str) {
        laneGuideOddInfoItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideOddInfoItemImpl_getPointTypeCode(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setScaleFactor(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, float[] fArr) {
        laneGuideOddInfoItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setRotateMode(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideOddInfoItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideOddInfoItemImpl_addMarker(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideOddInfoItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_clearAllMarkers(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        laneGuideOddInfoItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideOddInfoItemImpl_setForeshorteningCoef(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideOddInfoItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideOddInfoItemImpl_getForeshorteningCoef(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        return laneGuideOddInfoItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_resetOnVisible(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, boolean z) {
        laneGuideBusLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_onVisible(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, boolean z) {
        laneGuideBusLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_getOnVisible(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_applyOnVisible(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        laneGuideBusLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideBusLayerItemImpl_getBound(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_getVisible(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideBusLayerItemImpl_getPriority(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_isAreaCollision(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setAreaCollision(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, boolean z) {
        laneGuideBusLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_canCollision(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_canAreaCollision(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideBusLayerItemImpl_getTypeIdName(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideBusLayerItemImpl_getItemType(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_setID(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, String str) {
        return laneGuideBusLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideBusLayerItemImpl_getID(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_setInfo(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, String str) {
        return laneGuideBusLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideBusLayerItemImpl_getInfo(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setPriority(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, int i) {
        laneGuideBusLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setVisible(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, boolean z) {
        laneGuideBusLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_getFocus(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setAlpha(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, double d) {
        laneGuideBusLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideBusLayerItemImpl_getAlpha(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setAngle(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, double d) {
        laneGuideBusLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideBusLayerItemImpl_getAngle(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setPitch(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, double d) {
        laneGuideBusLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideBusLayerItemImpl_getPitch(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setMaxPitch(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, double d) {
        laneGuideBusLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideBusLayerItemImpl_getMaxPitch(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setClickable(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, boolean z) {
        laneGuideBusLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_getClickable(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setDisplayScale(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, LayerScale layerScale) {
        laneGuideBusLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideBusLayerItemImpl_getDisplayScale(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setAnimation(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideBusLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setStyle__SWIG_0(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideBusLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setStyle__SWIG_1(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, String str) {
        laneGuideBusLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_updateStyle__SWIG_0(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        laneGuideBusLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_updateStyle__SWIG_1(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideBusLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_addPoiFilter(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        laneGuideBusLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_removePoiFilter(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        laneGuideBusLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_onPaint(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        laneGuideBusLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setParent(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideBusLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setBusinessType(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, int i) {
        laneGuideBusLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideBusLayerItemImpl_getBusinessType(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_clearStyle(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        laneGuideBusLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setVisible3V(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Visible3V visible3V) {
        laneGuideBusLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_getVisible3V(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Visible3V visible3V) {
        laneGuideBusLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setBillboard(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, boolean z) {
        laneGuideBusLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_getBillboard(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setPosition3D(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideBusLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setRotateCenter3D(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideBusLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_getRotateCenter3D(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideBusLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setPosition(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideBusLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_getPosition(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideBusLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setRotateCenter(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideBusLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_getNormalStyle(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideBusLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_getFocusStyle(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideBusLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setItemVisibleRegion(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, RectInt rectInt) {
        laneGuideBusLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setItemIgnoreRegion(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideBusLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_getItemIgnoreRegion(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideBusLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setScale(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideBusLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_getScale(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideBusLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setPointTypeCode(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, String str) {
        laneGuideBusLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideBusLayerItemImpl_getPointTypeCode(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setScaleFactor(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, float[] fArr) {
        laneGuideBusLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setRotateMode(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideBusLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideBusLayerItemImpl_addMarker(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideBusLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_clearAllMarkers(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        laneGuideBusLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideBusLayerItemImpl_setForeshorteningCoef(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideBusLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideBusLayerItemImpl_getForeshorteningCoef(LaneGuideBusLayerItemImpl laneGuideBusLayerItemImpl) {
        return laneGuideBusLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_resetOnVisible(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, boolean z) {
        laneGuideHovLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_onVisible(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, boolean z) {
        laneGuideHovLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_getOnVisible(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_applyOnVisible(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        laneGuideHovLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideHovLayerItemImpl_getBound(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_getVisible(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideHovLayerItemImpl_getPriority(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_isAreaCollision(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setAreaCollision(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, boolean z) {
        laneGuideHovLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_canCollision(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_canAreaCollision(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideHovLayerItemImpl_getTypeIdName(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideHovLayerItemImpl_getItemType(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_setID(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, String str) {
        return laneGuideHovLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideHovLayerItemImpl_getID(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_setInfo(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, String str) {
        return laneGuideHovLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideHovLayerItemImpl_getInfo(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setPriority(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, int i) {
        laneGuideHovLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setVisible(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, boolean z) {
        laneGuideHovLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_getFocus(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setAlpha(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, double d) {
        laneGuideHovLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideHovLayerItemImpl_getAlpha(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setAngle(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, double d) {
        laneGuideHovLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideHovLayerItemImpl_getAngle(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setPitch(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, double d) {
        laneGuideHovLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideHovLayerItemImpl_getPitch(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setMaxPitch(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, double d) {
        laneGuideHovLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideHovLayerItemImpl_getMaxPitch(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setClickable(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, boolean z) {
        laneGuideHovLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_getClickable(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setDisplayScale(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, LayerScale layerScale) {
        laneGuideHovLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideHovLayerItemImpl_getDisplayScale(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setAnimation(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideHovLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setStyle__SWIG_0(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideHovLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setStyle__SWIG_1(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, String str) {
        laneGuideHovLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_updateStyle__SWIG_0(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        laneGuideHovLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_updateStyle__SWIG_1(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideHovLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_addPoiFilter(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        laneGuideHovLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_removePoiFilter(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        laneGuideHovLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_onPaint(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        laneGuideHovLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setParent(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideHovLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setBusinessType(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, int i) {
        laneGuideHovLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideHovLayerItemImpl_getBusinessType(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_clearStyle(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        laneGuideHovLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setVisible3V(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Visible3V visible3V) {
        laneGuideHovLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_getVisible3V(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Visible3V visible3V) {
        laneGuideHovLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setBillboard(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, boolean z) {
        laneGuideHovLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_getBillboard(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setPosition3D(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideHovLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setRotateCenter3D(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideHovLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_getRotateCenter3D(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideHovLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setPosition(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideHovLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_getPosition(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideHovLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setRotateCenter(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideHovLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_getNormalStyle(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideHovLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_getFocusStyle(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideHovLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setItemVisibleRegion(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, RectInt rectInt) {
        laneGuideHovLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setItemIgnoreRegion(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideHovLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_getItemIgnoreRegion(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideHovLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setScale(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideHovLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_getScale(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideHovLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setPointTypeCode(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, String str) {
        laneGuideHovLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideHovLayerItemImpl_getPointTypeCode(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setScaleFactor(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, float[] fArr) {
        laneGuideHovLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setRotateMode(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideHovLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideHovLayerItemImpl_addMarker(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideHovLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_clearAllMarkers(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        laneGuideHovLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideHovLayerItemImpl_setForeshorteningCoef(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideHovLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideHovLayerItemImpl_getForeshorteningCoef(LaneGuideHovLayerItemImpl laneGuideHovLayerItemImpl) {
        return laneGuideHovLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_resetOnVisible(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z) {
        laneGuideRestrictedLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_onVisible(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z) {
        laneGuideRestrictedLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_getOnVisible(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_applyOnVisible(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideRestrictedLayerItemImpl_getBound(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_getVisible(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideRestrictedLayerItemImpl_getPriority(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_isAreaCollision(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setAreaCollision(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z) {
        laneGuideRestrictedLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_canCollision(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_canAreaCollision(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideRestrictedLayerItemImpl_getTypeIdName(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideRestrictedLayerItemImpl_getItemType(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_setID(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, String str) {
        return laneGuideRestrictedLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideRestrictedLayerItemImpl_getID(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_setInfo(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, String str) {
        return laneGuideRestrictedLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideRestrictedLayerItemImpl_getInfo(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setPriority(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, int i) {
        laneGuideRestrictedLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setVisible(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z) {
        laneGuideRestrictedLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_getFocus(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setAlpha(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, double d) {
        laneGuideRestrictedLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideRestrictedLayerItemImpl_getAlpha(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setAngle(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, double d) {
        laneGuideRestrictedLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideRestrictedLayerItemImpl_getAngle(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setPitch(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, double d) {
        laneGuideRestrictedLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideRestrictedLayerItemImpl_getPitch(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setMaxPitch(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, double d) {
        laneGuideRestrictedLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideRestrictedLayerItemImpl_getMaxPitch(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setClickable(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z) {
        laneGuideRestrictedLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_getClickable(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setDisplayScale(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, LayerScale layerScale) {
        laneGuideRestrictedLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideRestrictedLayerItemImpl_getDisplayScale(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setAnimation(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideRestrictedLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setStyle__SWIG_0(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideRestrictedLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setStyle__SWIG_1(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, String str) {
        laneGuideRestrictedLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_updateStyle__SWIG_0(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_updateStyle__SWIG_1(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideRestrictedLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_addPoiFilter(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_removePoiFilter(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_onPaint(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setParent(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideRestrictedLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setBusinessType(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, int i) {
        laneGuideRestrictedLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideRestrictedLayerItemImpl_getBusinessType(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_clearStyle(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setVisible3V(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Visible3V visible3V) {
        laneGuideRestrictedLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_getVisible3V(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Visible3V visible3V) {
        laneGuideRestrictedLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setBillboard(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z) {
        laneGuideRestrictedLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_getBillboard(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setPosition3D(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideRestrictedLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setRotateCenter3D(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideRestrictedLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_getRotateCenter3D(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideRestrictedLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setPosition(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideRestrictedLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_getPosition(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideRestrictedLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setRotateCenter(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideRestrictedLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_getNormalStyle(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideRestrictedLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_getFocusStyle(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideRestrictedLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setItemVisibleRegion(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, RectInt rectInt) {
        laneGuideRestrictedLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setItemIgnoreRegion(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideRestrictedLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_getItemIgnoreRegion(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideRestrictedLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setScale(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideRestrictedLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_getScale(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideRestrictedLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setPointTypeCode(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, String str) {
        laneGuideRestrictedLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideRestrictedLayerItemImpl_getPointTypeCode(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setScaleFactor(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, float[] fArr) {
        laneGuideRestrictedLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setRotateMode(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideRestrictedLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_addMarker(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideRestrictedLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_clearAllMarkers(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setForeshorteningCoef(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideRestrictedLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideRestrictedLayerItemImpl_getForeshorteningCoef(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_setIdle(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, boolean z) {
        laneGuideRestrictedLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_isIdle(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.isIdle();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_addIntersectArea(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, float f) {
        laneGuideRestrictedLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_LaneGuideRestrictedLayerItemImpl_getIntersectArea(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_resetIntersectArea(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_addIntersectAreaEx(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, float f) {
        laneGuideRestrictedLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_LaneGuideRestrictedLayerItemImpl_getIntersectAreaEx(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_resetIntersectAreaEx(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        laneGuideRestrictedLayerItemImpl.resetIntersectAreaEx();
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_addIntersectValue(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, @IntersectValueType.IntersectValueType1 int i, float f) {
        laneGuideRestrictedLayerItemImpl.addIntersectValue(i, f);
    }

    public static float SwigDirector_LaneGuideRestrictedLayerItemImpl_getIntersectValue(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        return laneGuideRestrictedLayerItemImpl.getIntersectValue(i);
    }

    public static void SwigDirector_LaneGuideRestrictedLayerItemImpl_resetIntersectValue(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        laneGuideRestrictedLayerItemImpl.resetIntersectValue(i);
    }

    public static boolean SwigDirector_LaneGuideRestrictedLayerItemImpl_checkShowFlag(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_LaneGuideRestrictedLayerItemImpl_getQuadrantGroupId(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_LaneGuideRestrictedLayerItemImpl_getQuadrantType(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        return laneGuideRestrictedLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_resetOnVisible(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, boolean z) {
        laneGuideChangeLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_onVisible(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, boolean z) {
        laneGuideChangeLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_getOnVisible(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_applyOnVisible(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        laneGuideChangeLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideChangeLayerItemImpl_getBound(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_getVisible(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideChangeLayerItemImpl_getPriority(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_isAreaCollision(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setAreaCollision(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, boolean z) {
        laneGuideChangeLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_canCollision(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_canAreaCollision(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideChangeLayerItemImpl_getTypeIdName(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideChangeLayerItemImpl_getItemType(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_setID(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, String str) {
        return laneGuideChangeLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideChangeLayerItemImpl_getID(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_setInfo(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, String str) {
        return laneGuideChangeLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideChangeLayerItemImpl_getInfo(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setPriority(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, int i) {
        laneGuideChangeLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setVisible(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, boolean z) {
        laneGuideChangeLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_getFocus(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setAlpha(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, double d) {
        laneGuideChangeLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideChangeLayerItemImpl_getAlpha(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setAngle(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, double d) {
        laneGuideChangeLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideChangeLayerItemImpl_getAngle(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setPitch(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, double d) {
        laneGuideChangeLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideChangeLayerItemImpl_getPitch(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setMaxPitch(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, double d) {
        laneGuideChangeLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideChangeLayerItemImpl_getMaxPitch(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setClickable(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, boolean z) {
        laneGuideChangeLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_getClickable(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setDisplayScale(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, LayerScale layerScale) {
        laneGuideChangeLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideChangeLayerItemImpl_getDisplayScale(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setAnimation(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideChangeLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setStyle__SWIG_0(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideChangeLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setStyle__SWIG_1(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, String str) {
        laneGuideChangeLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_updateStyle__SWIG_0(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        laneGuideChangeLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_updateStyle__SWIG_1(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideChangeLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_addPoiFilter(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        laneGuideChangeLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_removePoiFilter(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        laneGuideChangeLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_onPaint(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        laneGuideChangeLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setParent(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideChangeLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setBusinessType(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, int i) {
        laneGuideChangeLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideChangeLayerItemImpl_getBusinessType(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_clearStyle(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        laneGuideChangeLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setVisible3V(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Visible3V visible3V) {
        laneGuideChangeLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_getVisible3V(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Visible3V visible3V) {
        laneGuideChangeLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setBillboard(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, boolean z) {
        laneGuideChangeLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_getBillboard(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setPosition3D(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideChangeLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setRotateCenter3D(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideChangeLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_getRotateCenter3D(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideChangeLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setPosition(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideChangeLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_getPosition(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideChangeLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setRotateCenter(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideChangeLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_getNormalStyle(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideChangeLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_getFocusStyle(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideChangeLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setItemVisibleRegion(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, RectInt rectInt) {
        laneGuideChangeLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setItemIgnoreRegion(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideChangeLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_getItemIgnoreRegion(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideChangeLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setScale(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideChangeLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_getScale(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideChangeLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setPointTypeCode(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, String str) {
        laneGuideChangeLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideChangeLayerItemImpl_getPointTypeCode(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setScaleFactor(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, float[] fArr) {
        laneGuideChangeLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setRotateMode(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideChangeLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideChangeLayerItemImpl_addMarker(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideChangeLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_clearAllMarkers(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        laneGuideChangeLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideChangeLayerItemImpl_setForeshorteningCoef(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideChangeLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideChangeLayerItemImpl_getForeshorteningCoef(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        return laneGuideChangeLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_resetOnVisible(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, boolean z) {
        laneGuideNotRecommendedLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_onVisible(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, boolean z) {
        laneGuideNotRecommendedLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getOnVisible(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_applyOnVisible(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getBound(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getVisible(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getPriority(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_isAreaCollision(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setAreaCollision(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, boolean z) {
        laneGuideNotRecommendedLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_canCollision(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_canAreaCollision(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getTypeIdName(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getItemType(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setID(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, String str) {
        return laneGuideNotRecommendedLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getID(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setInfo(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, String str) {
        return laneGuideNotRecommendedLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getInfo(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setPriority(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, int i) {
        laneGuideNotRecommendedLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setVisible(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, boolean z) {
        laneGuideNotRecommendedLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getFocus(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setAlpha(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, double d) {
        laneGuideNotRecommendedLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getAlpha(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setAngle(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, double d) {
        laneGuideNotRecommendedLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getAngle(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setPitch(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, double d) {
        laneGuideNotRecommendedLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getPitch(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setMaxPitch(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, double d) {
        laneGuideNotRecommendedLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getMaxPitch(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setClickable(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, boolean z) {
        laneGuideNotRecommendedLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getClickable(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setDisplayScale(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, LayerScale layerScale) {
        laneGuideNotRecommendedLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getDisplayScale(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setAnimation(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideNotRecommendedLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setStyle__SWIG_0(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideNotRecommendedLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setStyle__SWIG_1(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, String str) {
        laneGuideNotRecommendedLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_updateStyle__SWIG_0(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_updateStyle__SWIG_1(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_addPoiFilter(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_removePoiFilter(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_onPaint(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setParent(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideNotRecommendedLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setBusinessType(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, int i) {
        laneGuideNotRecommendedLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getBusinessType(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_clearStyle(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setVisible3V(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Visible3V visible3V) {
        laneGuideNotRecommendedLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getVisible3V(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Visible3V visible3V) {
        laneGuideNotRecommendedLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setBillboard(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, boolean z) {
        laneGuideNotRecommendedLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getBillboard(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setPosition3D(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideNotRecommendedLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setRotateCenter3D(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideNotRecommendedLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getRotateCenter3D(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideNotRecommendedLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setPosition(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideNotRecommendedLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getPosition(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideNotRecommendedLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setRotateCenter(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideNotRecommendedLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getNormalStyle(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideNotRecommendedLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getFocusStyle(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideNotRecommendedLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setItemVisibleRegion(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, RectInt rectInt) {
        laneGuideNotRecommendedLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setItemIgnoreRegion(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideNotRecommendedLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getItemIgnoreRegion(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideNotRecommendedLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setScale(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideNotRecommendedLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getScale(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideNotRecommendedLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setPointTypeCode(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, String str) {
        laneGuideNotRecommendedLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getPointTypeCode(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setScaleFactor(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, float[] fArr) {
        laneGuideNotRecommendedLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setRotateMode(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideNotRecommendedLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideNotRecommendedLayerItemImpl_addMarker(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideNotRecommendedLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_clearAllMarkers(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        laneGuideNotRecommendedLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideNotRecommendedLayerItemImpl_setForeshorteningCoef(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideNotRecommendedLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideNotRecommendedLayerItemImpl_getForeshorteningCoef(LaneGuideNotRecommendedLayerItemImpl laneGuideNotRecommendedLayerItemImpl) {
        return laneGuideNotRecommendedLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_resetOnVisible(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, boolean z) {
        laneGuideSolidLineLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_onVisible(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, boolean z) {
        laneGuideSolidLineLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_getOnVisible(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_applyOnVisible(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        laneGuideSolidLineLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideSolidLineLayerItemImpl_getBound(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_getVisible(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideSolidLineLayerItemImpl_getPriority(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_isAreaCollision(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setAreaCollision(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, boolean z) {
        laneGuideSolidLineLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_canCollision(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_canAreaCollision(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideSolidLineLayerItemImpl_getTypeIdName(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideSolidLineLayerItemImpl_getItemType(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_setID(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, String str) {
        return laneGuideSolidLineLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideSolidLineLayerItemImpl_getID(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_setInfo(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, String str) {
        return laneGuideSolidLineLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideSolidLineLayerItemImpl_getInfo(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setPriority(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, int i) {
        laneGuideSolidLineLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setVisible(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, boolean z) {
        laneGuideSolidLineLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_getFocus(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setAlpha(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, double d) {
        laneGuideSolidLineLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideSolidLineLayerItemImpl_getAlpha(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setAngle(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, double d) {
        laneGuideSolidLineLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideSolidLineLayerItemImpl_getAngle(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setPitch(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, double d) {
        laneGuideSolidLineLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideSolidLineLayerItemImpl_getPitch(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setMaxPitch(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, double d) {
        laneGuideSolidLineLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideSolidLineLayerItemImpl_getMaxPitch(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setClickable(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, boolean z) {
        laneGuideSolidLineLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_getClickable(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setDisplayScale(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, LayerScale layerScale) {
        laneGuideSolidLineLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideSolidLineLayerItemImpl_getDisplayScale(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setAnimation(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideSolidLineLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setStyle__SWIG_0(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideSolidLineLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setStyle__SWIG_1(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, String str) {
        laneGuideSolidLineLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_updateStyle__SWIG_0(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        laneGuideSolidLineLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_updateStyle__SWIG_1(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideSolidLineLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_addPoiFilter(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        laneGuideSolidLineLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_removePoiFilter(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        laneGuideSolidLineLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_onPaint(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        laneGuideSolidLineLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setParent(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideSolidLineLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setBusinessType(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, int i) {
        laneGuideSolidLineLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideSolidLineLayerItemImpl_getBusinessType(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_clearStyle(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        laneGuideSolidLineLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setVisible3V(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Visible3V visible3V) {
        laneGuideSolidLineLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_getVisible3V(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Visible3V visible3V) {
        laneGuideSolidLineLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setBillboard(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, boolean z) {
        laneGuideSolidLineLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_getBillboard(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setPosition3D(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideSolidLineLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setRotateCenter3D(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideSolidLineLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_getRotateCenter3D(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideSolidLineLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setPosition(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideSolidLineLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_getPosition(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideSolidLineLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setRotateCenter(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideSolidLineLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_getNormalStyle(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideSolidLineLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_getFocusStyle(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideSolidLineLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setItemVisibleRegion(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, RectInt rectInt) {
        laneGuideSolidLineLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setItemIgnoreRegion(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideSolidLineLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_getItemIgnoreRegion(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideSolidLineLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setScale(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideSolidLineLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_getScale(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideSolidLineLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setPointTypeCode(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, String str) {
        laneGuideSolidLineLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideSolidLineLayerItemImpl_getPointTypeCode(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setScaleFactor(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, float[] fArr) {
        laneGuideSolidLineLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setRotateMode(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideSolidLineLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideSolidLineLayerItemImpl_addMarker(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideSolidLineLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_clearAllMarkers(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        laneGuideSolidLineLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideSolidLineLayerItemImpl_setForeshorteningCoef(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideSolidLineLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideSolidLineLayerItemImpl_getForeshorteningCoef(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        return laneGuideSolidLineLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_resetOnVisible(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z) {
        laneGuideTrafficLightCountdownLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_onVisible(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z) {
        laneGuideTrafficLightCountdownLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getOnVisible(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_applyOnVisible(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getBound(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getVisible(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getPriority(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_isAreaCollision(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setAreaCollision(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z) {
        laneGuideTrafficLightCountdownLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_canCollision(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_canAreaCollision(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getTypeIdName(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getItemType(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setID(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, String str) {
        return laneGuideTrafficLightCountdownLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getID(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setInfo(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, String str) {
        return laneGuideTrafficLightCountdownLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getInfo(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setPriority(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, int i) {
        laneGuideTrafficLightCountdownLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setVisible(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z) {
        laneGuideTrafficLightCountdownLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getFocus(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setAlpha(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, double d) {
        laneGuideTrafficLightCountdownLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getAlpha(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setAngle(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, double d) {
        laneGuideTrafficLightCountdownLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getAngle(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setPitch(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, double d) {
        laneGuideTrafficLightCountdownLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getPitch(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setMaxPitch(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, double d) {
        laneGuideTrafficLightCountdownLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getMaxPitch(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setClickable(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z) {
        laneGuideTrafficLightCountdownLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getClickable(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setDisplayScale(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, LayerScale layerScale) {
        laneGuideTrafficLightCountdownLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getDisplayScale(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setAnimation(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideTrafficLightCountdownLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setStyle__SWIG_0(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setStyle__SWIG_1(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, String str) {
        laneGuideTrafficLightCountdownLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_updateStyle__SWIG_0(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_updateStyle__SWIG_1(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_addPoiFilter(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_removePoiFilter(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_onPaint(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setParent(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setBusinessType(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, int i) {
        laneGuideTrafficLightCountdownLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getBusinessType(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_clearStyle(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setVisible3V(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Visible3V visible3V) {
        laneGuideTrafficLightCountdownLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getVisible3V(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Visible3V visible3V) {
        laneGuideTrafficLightCountdownLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setBillboard(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z) {
        laneGuideTrafficLightCountdownLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getBillboard(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setPosition3D(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightCountdownLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setRotateCenter3D(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightCountdownLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getRotateCenter3D(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightCountdownLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setPosition(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightCountdownLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getPosition(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightCountdownLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setRotateCenter(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightCountdownLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getNormalStyle(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTrafficLightCountdownLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getFocusStyle(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTrafficLightCountdownLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setItemVisibleRegion(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, RectInt rectInt) {
        laneGuideTrafficLightCountdownLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setItemIgnoreRegion(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTrafficLightCountdownLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getItemIgnoreRegion(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTrafficLightCountdownLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setScale(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideTrafficLightCountdownLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getScale(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideTrafficLightCountdownLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setPointTypeCode(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, String str) {
        laneGuideTrafficLightCountdownLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getPointTypeCode(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setScaleFactor(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, float[] fArr) {
        laneGuideTrafficLightCountdownLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setRotateMode(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideTrafficLightCountdownLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_addMarker(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideTrafficLightCountdownLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_clearAllMarkers(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setForeshorteningCoef(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideTrafficLightCountdownLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getForeshorteningCoef(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_setIdle(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, boolean z) {
        laneGuideTrafficLightCountdownLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_isIdle(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.isIdle();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_addIntersectArea(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, float f) {
        laneGuideTrafficLightCountdownLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getIntersectArea(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_resetIntersectArea(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_addIntersectAreaEx(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, float f) {
        laneGuideTrafficLightCountdownLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getIntersectAreaEx(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_resetIntersectAreaEx(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        laneGuideTrafficLightCountdownLayerItemImpl.resetIntersectAreaEx();
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_addIntersectValue(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, @IntersectValueType.IntersectValueType1 int i, float f) {
        laneGuideTrafficLightCountdownLayerItemImpl.addIntersectValue(i, f);
    }

    public static float SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getIntersectValue(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getIntersectValue(i);
    }

    public static void SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_resetIntersectValue(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, @IntersectValueType.IntersectValueType1 int i) {
        laneGuideTrafficLightCountdownLayerItemImpl.resetIntersectValue(i);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_checkShowFlag(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getQuadrantGroupId(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_LaneGuideTrafficLightCountdownLayerItemImpl_getQuadrantType(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        return laneGuideTrafficLightCountdownLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_resetOnVisible(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, boolean z) {
        laneGuideTrafficLightIconLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_onVisible(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, boolean z) {
        laneGuideTrafficLightIconLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getOnVisible(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_applyOnVisible(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getBound(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getVisible(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getPriority(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_isAreaCollision(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setAreaCollision(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, boolean z) {
        laneGuideTrafficLightIconLayerItemImpl.setAreaCollision(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_canCollision(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.canCollision();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_canAreaCollision(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.canAreaCollision();
    }

    public static String SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getTypeIdName(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getTypeIdName();
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getItemType(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setID(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, String str) {
        return laneGuideTrafficLightIconLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getID(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setInfo(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, String str) {
        return laneGuideTrafficLightIconLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getInfo(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setPriority(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, int i) {
        laneGuideTrafficLightIconLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setVisible(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, boolean z) {
        laneGuideTrafficLightIconLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getFocus(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setAlpha(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, double d) {
        laneGuideTrafficLightIconLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getAlpha(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setAngle(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, double d) {
        laneGuideTrafficLightIconLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getAngle(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setPitch(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, double d) {
        laneGuideTrafficLightIconLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getPitch(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setMaxPitch(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, double d) {
        laneGuideTrafficLightIconLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getMaxPitch(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setClickable(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, boolean z) {
        laneGuideTrafficLightIconLayerItemImpl.setClickable(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getClickable(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getClickable();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setDisplayScale(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, LayerScale layerScale) {
        laneGuideTrafficLightIconLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getDisplayScale(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setAnimation(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        laneGuideTrafficLightIconLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setStyle__SWIG_0(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        laneGuideTrafficLightIconLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setStyle__SWIG_1(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, String str) {
        laneGuideTrafficLightIconLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_updateStyle__SWIG_0(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_updateStyle__SWIG_1(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, LayerItemImpl layerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_addPoiFilter(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_removePoiFilter(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_onPaint(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setParent(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        laneGuideTrafficLightIconLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setBusinessType(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, int i) {
        laneGuideTrafficLightIconLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getBusinessType(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getBusinessType();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_clearStyle(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setVisible3V(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Visible3V visible3V) {
        laneGuideTrafficLightIconLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getVisible3V(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Visible3V visible3V) {
        laneGuideTrafficLightIconLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setBillboard(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, boolean z) {
        laneGuideTrafficLightIconLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getBillboard(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setPosition3D(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightIconLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setRotateCenter3D(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightIconLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getRotateCenter3D(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightIconLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setPosition(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightIconLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getPosition(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightIconLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setRotateCenter(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, Coord3DDouble coord3DDouble) {
        laneGuideTrafficLightIconLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getNormalStyle(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTrafficLightIconLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getFocusStyle(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        laneGuideTrafficLightIconLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setItemVisibleRegion(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, RectInt rectInt) {
        laneGuideTrafficLightIconLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setItemIgnoreRegion(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTrafficLightIconLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getItemIgnoreRegion(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        laneGuideTrafficLightIconLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setScale(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        laneGuideTrafficLightIconLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getScale(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, ScaleAttribute scaleAttribute) {
        laneGuideTrafficLightIconLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setPointTypeCode(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, String str) {
        laneGuideTrafficLightIconLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getPointTypeCode(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setScaleFactor(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, float[] fArr) {
        laneGuideTrafficLightIconLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setRotateMode(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, @RotateMode.RotateMode1 int i) {
        laneGuideTrafficLightIconLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_addMarker(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return laneGuideTrafficLightIconLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_clearAllMarkers(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        laneGuideTrafficLightIconLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_setForeshorteningCoef(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        laneGuideTrafficLightIconLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LaneGuideTrafficLightIconLayerItemImpl_getForeshorteningCoef(LaneGuideTrafficLightIconLayerItemImpl laneGuideTrafficLightIconLayerItemImpl) {
        return laneGuideTrafficLightIconLayerItemImpl.getForeshorteningCoef();
    }
}
