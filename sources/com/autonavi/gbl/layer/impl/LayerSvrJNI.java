package com.autonavi.gbl.layer.impl;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.layer.model.DynamicLevelCalcResult;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ArrowAnimationPlayState;
import com.autonavi.gbl.map.layer.model.ArrowLayerItemStyle;
import com.autonavi.gbl.map.layer.model.ForeshorteningCoefParam;
import com.autonavi.gbl.map.layer.model.ItemIgnoreRegion;
import com.autonavi.gbl.map.layer.model.ItemMarkerInfo;
import com.autonavi.gbl.map.layer.model.LayerItemPoiAnimation;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.layer.model.PointLayerItemStyle;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.RotateMode;
import com.autonavi.gbl.map.layer.model.ScaleAttribute;
import com.autonavi.gbl.map.layer.model.ScaleInfo;
import com.autonavi.gbl.map.layer.model.ScalePriority;
import com.autonavi.gbl.map.layer.model.SectorAngles;
import com.autonavi.gbl.map.layer.model.Visible3V;
import com.autonavi.gbl.map.layer.observer.impl.ILayerItemAnimationObserverImpl;
import com.autonavi.gbl.map.layer.observer.impl.IPrepareLayerStyleImpl;
import com.autonavi.gbl.map.model.PixelPoint;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LayerSvrJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_CommonLineLayerItemImpl_resetOnVisible(CommonLineLayerItemImpl commonLineLayerItemImpl, boolean z) {
        commonLineLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_onVisible(CommonLineLayerItemImpl commonLineLayerItemImpl, boolean z) {
        commonLineLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CommonLineLayerItemImpl_getOnVisible(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_applyOnVisible(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        commonLineLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CommonLineLayerItemImpl_getBound(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CommonLineLayerItemImpl_getVisible(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CommonLineLayerItemImpl_getPriority(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CommonLineLayerItemImpl_isAreaCollision(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setAreaCollision(CommonLineLayerItemImpl commonLineLayerItemImpl, boolean z) {
        commonLineLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CommonLineLayerItemImpl_getItemType(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CommonLineLayerItemImpl_setID(CommonLineLayerItemImpl commonLineLayerItemImpl, String str) {
        return commonLineLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CommonLineLayerItemImpl_getID(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CommonLineLayerItemImpl_setInfo(CommonLineLayerItemImpl commonLineLayerItemImpl, String str) {
        return commonLineLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CommonLineLayerItemImpl_getInfo(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setPriority(CommonLineLayerItemImpl commonLineLayerItemImpl, int i) {
        commonLineLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setVisible(CommonLineLayerItemImpl commonLineLayerItemImpl, boolean z) {
        commonLineLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CommonLineLayerItemImpl_getFocus(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setAlpha(CommonLineLayerItemImpl commonLineLayerItemImpl, double d) {
        commonLineLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CommonLineLayerItemImpl_getAlpha(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setAngle(CommonLineLayerItemImpl commonLineLayerItemImpl, double d) {
        commonLineLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CommonLineLayerItemImpl_getAngle(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setPitch(CommonLineLayerItemImpl commonLineLayerItemImpl, double d) {
        commonLineLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CommonLineLayerItemImpl_getPitch(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setMaxPitch(CommonLineLayerItemImpl commonLineLayerItemImpl, double d) {
        commonLineLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CommonLineLayerItemImpl_getMaxPitch(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setDisplayScale(CommonLineLayerItemImpl commonLineLayerItemImpl, LayerScale layerScale) {
        commonLineLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CommonLineLayerItemImpl_getDisplayScale(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setAnimation(CommonLineLayerItemImpl commonLineLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        commonLineLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setStyle__SWIG_0(CommonLineLayerItemImpl commonLineLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        commonLineLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setStyle__SWIG_1(CommonLineLayerItemImpl commonLineLayerItemImpl, String str) {
        commonLineLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_updateStyle__SWIG_0(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        commonLineLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_updateStyle__SWIG_1(CommonLineLayerItemImpl commonLineLayerItemImpl, LayerItemImpl layerItemImpl) {
        commonLineLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_addPoiFilter(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        commonLineLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_removePoiFilter(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        commonLineLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_onPaint(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        commonLineLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setParent(CommonLineLayerItemImpl commonLineLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        commonLineLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setBusinessType(CommonLineLayerItemImpl commonLineLayerItemImpl, int i) {
        commonLineLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CommonLineLayerItemImpl_getBusinessType(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CommonLineLayerItemImpl_getTypeIdName(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        return commonLineLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_clearStyle(CommonLineLayerItemImpl commonLineLayerItemImpl) {
        commonLineLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setPoints(CommonLineLayerItemImpl commonLineLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        commonLineLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setColor(CommonLineLayerItemImpl commonLineLayerItemImpl, long j, long j2) {
        commonLineLayerItemImpl.setColor(j, j2);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_setWidth(CommonLineLayerItemImpl commonLineLayerItemImpl, int i, int i2) {
        commonLineLayerItemImpl.setWidth(i, i2);
    }

    public static void SwigDirector_CommonLineLayerItemImpl_getStyle(CommonLineLayerItemImpl commonLineLayerItemImpl, LineLayerItemStyle lineLayerItemStyle) {
        commonLineLayerItemImpl.getStyle(lineLayerItemStyle);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_resetOnVisible(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, boolean z) {
        endAreaPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_onVisible(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, boolean z) {
        endAreaPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_getOnVisible(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_applyOnVisible(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        endAreaPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_EndAreaPointLayerItemImpl_getBound(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_getVisible(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_EndAreaPointLayerItemImpl_getPriority(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_isAreaCollision(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setAreaCollision(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, boolean z) {
        endAreaPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_EndAreaPointLayerItemImpl_getItemType(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_setID(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, String str) {
        return endAreaPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_EndAreaPointLayerItemImpl_getID(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_setInfo(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, String str) {
        return endAreaPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_EndAreaPointLayerItemImpl_getInfo(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setPriority(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, int i) {
        endAreaPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setVisible(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, boolean z) {
        endAreaPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_getFocus(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setAlpha(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, double d) {
        endAreaPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_EndAreaPointLayerItemImpl_getAlpha(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setAngle(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, double d) {
        endAreaPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_EndAreaPointLayerItemImpl_getAngle(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setPitch(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, double d) {
        endAreaPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_EndAreaPointLayerItemImpl_getPitch(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setMaxPitch(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, double d) {
        endAreaPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_EndAreaPointLayerItemImpl_getMaxPitch(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setDisplayScale(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, LayerScale layerScale) {
        endAreaPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_EndAreaPointLayerItemImpl_getDisplayScale(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setAnimation(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        endAreaPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setStyle__SWIG_0(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        endAreaPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setStyle__SWIG_1(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, String str) {
        endAreaPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_updateStyle__SWIG_0(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        endAreaPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_updateStyle__SWIG_1(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        endAreaPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_addPoiFilter(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        endAreaPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_removePoiFilter(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        endAreaPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_onPaint(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        endAreaPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setParent(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        endAreaPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setBusinessType(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, int i) {
        endAreaPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_EndAreaPointLayerItemImpl_getBusinessType(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_EndAreaPointLayerItemImpl_getTypeIdName(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_clearStyle(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        endAreaPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setVisible3V(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Visible3V visible3V) {
        endAreaPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_getVisible3V(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Visible3V visible3V) {
        endAreaPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setBillboard(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, boolean z) {
        endAreaPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_getBillboard(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setPosition3D(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setRotateCenter3D(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_getRotateCenter3D(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setPosition(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_getPosition(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setRotateCenter(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_getNormalStyle(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        endAreaPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_getFocusStyle(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        endAreaPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setItemVisibleRegion(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, RectInt rectInt) {
        endAreaPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setItemIgnoreRegion(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        endAreaPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_getItemIgnoreRegion(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        endAreaPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setScale(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        endAreaPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_getScale(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        endAreaPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setPointTypeCode(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, String str) {
        endAreaPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_EndAreaPointLayerItemImpl_getPointTypeCode(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setScaleFactor(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, float[] fArr) {
        endAreaPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setRotateMode(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        endAreaPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_EndAreaPointLayerItemImpl_addMarker(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return endAreaPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_clearAllMarkers(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        endAreaPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_EndAreaPointLayerItemImpl_setForeshorteningCoef(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        endAreaPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_EndAreaPointLayerItemImpl_getForeshorteningCoef(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        return endAreaPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_resetOnVisible(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, boolean z) {
        endAreaParentLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_onVisible(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, boolean z) {
        endAreaParentLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_getOnVisible(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_applyOnVisible(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_EndAreaParentLayerItemImpl_getBound(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_getVisible(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getVisible();
    }

    public static int SwigDirector_EndAreaParentLayerItemImpl_getPriority(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_isAreaCollision(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setAreaCollision(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, boolean z) {
        endAreaParentLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_EndAreaParentLayerItemImpl_getItemType(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_setID(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, String str) {
        return endAreaParentLayerItemImpl.setID(str);
    }

    public static String SwigDirector_EndAreaParentLayerItemImpl_getID(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getID();
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_setInfo(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, String str) {
        return endAreaParentLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_EndAreaParentLayerItemImpl_getInfo(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getInfo();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setPriority(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, int i) {
        endAreaParentLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setVisible(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, boolean z) {
        endAreaParentLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_getFocus(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getFocus();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setAlpha(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, double d) {
        endAreaParentLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_EndAreaParentLayerItemImpl_getAlpha(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setAngle(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, double d) {
        endAreaParentLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_EndAreaParentLayerItemImpl_getAngle(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getAngle();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setPitch(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, double d) {
        endAreaParentLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_EndAreaParentLayerItemImpl_getPitch(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getPitch();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setMaxPitch(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, double d) {
        endAreaParentLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_EndAreaParentLayerItemImpl_getMaxPitch(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setDisplayScale(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, LayerScale layerScale) {
        endAreaParentLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_EndAreaParentLayerItemImpl_getDisplayScale(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setAnimation(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        endAreaParentLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setStyle__SWIG_0(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        endAreaParentLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setStyle__SWIG_1(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, String str) {
        endAreaParentLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_updateStyle__SWIG_0(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_updateStyle__SWIG_1(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, LayerItemImpl layerItemImpl) {
        endAreaParentLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_addPoiFilter(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_removePoiFilter(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_onPaint(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.onPaint();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setParent(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        endAreaParentLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setBusinessType(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, int i) {
        endAreaParentLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_EndAreaParentLayerItemImpl_getBusinessType(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_EndAreaParentLayerItemImpl_getTypeIdName(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_clearStyle(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setVisible3V(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Visible3V visible3V) {
        endAreaParentLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_getVisible3V(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Visible3V visible3V) {
        endAreaParentLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setBillboard(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, boolean z) {
        endAreaParentLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_getBillboard(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setPosition3D(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaParentLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setRotateCenter3D(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaParentLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_getRotateCenter3D(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaParentLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setPosition(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaParentLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_getPosition(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaParentLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setRotateCenter(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        endAreaParentLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_getNormalStyle(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        endAreaParentLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_getFocusStyle(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        endAreaParentLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setItemVisibleRegion(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, RectInt rectInt) {
        endAreaParentLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setItemIgnoreRegion(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        endAreaParentLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_getItemIgnoreRegion(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        endAreaParentLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setScale(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        endAreaParentLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_getScale(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, ScaleAttribute scaleAttribute) {
        endAreaParentLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setPointTypeCode(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, String str) {
        endAreaParentLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_EndAreaParentLayerItemImpl_getPointTypeCode(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setScaleFactor(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, float[] fArr) {
        endAreaParentLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setRotateMode(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, @RotateMode.RotateMode1 int i) {
        endAreaParentLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_addMarker(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return endAreaParentLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_clearAllMarkers(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setForeshorteningCoef(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        endAreaParentLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_EndAreaParentLayerItemImpl_getForeshorteningCoef(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_setIdle(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, boolean z) {
        endAreaParentLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_isIdle(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.isIdle();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_addIntersectArea(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, float f) {
        endAreaParentLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_EndAreaParentLayerItemImpl_getIntersectArea(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_resetIntersectArea(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_addIntersectAreaEx(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, float f) {
        endAreaParentLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_EndAreaParentLayerItemImpl_getIntersectAreaEx(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_EndAreaParentLayerItemImpl_resetIntersectAreaEx(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        endAreaParentLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_EndAreaParentLayerItemImpl_checkShowFlag(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_EndAreaParentLayerItemImpl_getQuadrantGroupId(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_EndAreaParentLayerItemImpl_getQuadrantType(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        return endAreaParentLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_resetOnVisible(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, boolean z) {
        rangeOnMapPolygonPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_onVisible(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, boolean z) {
        rangeOnMapPolygonPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getOnVisible(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_applyOnVisible(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getBound(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getVisible(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getPriority(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_isAreaCollision(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setAreaCollision(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, boolean z) {
        rangeOnMapPolygonPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getItemType(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setID(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, String str) {
        return rangeOnMapPolygonPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getID(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setInfo(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, String str) {
        return rangeOnMapPolygonPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getInfo(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setPriority(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, int i) {
        rangeOnMapPolygonPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setVisible(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, boolean z) {
        rangeOnMapPolygonPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getFocus(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setAlpha(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, double d) {
        rangeOnMapPolygonPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getAlpha(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setAngle(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, double d) {
        rangeOnMapPolygonPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getAngle(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setPitch(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, double d) {
        rangeOnMapPolygonPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getPitch(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setMaxPitch(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, double d) {
        rangeOnMapPolygonPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getMaxPitch(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setDisplayScale(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, LayerScale layerScale) {
        rangeOnMapPolygonPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getDisplayScale(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setAnimation(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        rangeOnMapPolygonPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setStyle__SWIG_0(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        rangeOnMapPolygonPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setStyle__SWIG_1(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, String str) {
        rangeOnMapPolygonPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_updateStyle__SWIG_0(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_updateStyle__SWIG_1(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_addPoiFilter(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_removePoiFilter(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_onPaint(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setParent(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        rangeOnMapPolygonPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setBusinessType(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, int i) {
        rangeOnMapPolygonPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getBusinessType(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getTypeIdName(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_clearStyle(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setVisible3V(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Visible3V visible3V) {
        rangeOnMapPolygonPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getVisible3V(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Visible3V visible3V) {
        rangeOnMapPolygonPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setBillboard(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, boolean z) {
        rangeOnMapPolygonPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getBillboard(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setPosition3D(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        rangeOnMapPolygonPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setRotateCenter3D(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        rangeOnMapPolygonPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getRotateCenter3D(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        rangeOnMapPolygonPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setPosition(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        rangeOnMapPolygonPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getPosition(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        rangeOnMapPolygonPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setRotateCenter(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        rangeOnMapPolygonPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getNormalStyle(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        rangeOnMapPolygonPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getFocusStyle(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        rangeOnMapPolygonPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setItemVisibleRegion(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, RectInt rectInt) {
        rangeOnMapPolygonPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setItemIgnoreRegion(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        rangeOnMapPolygonPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getItemIgnoreRegion(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        rangeOnMapPolygonPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setScale(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        rangeOnMapPolygonPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getScale(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        rangeOnMapPolygonPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setPointTypeCode(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, String str) {
        rangeOnMapPolygonPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getPointTypeCode(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setScaleFactor(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, float[] fArr) {
        rangeOnMapPolygonPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setRotateMode(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        rangeOnMapPolygonPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RangeOnMapPolygonPointLayerItemImpl_addMarker(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return rangeOnMapPolygonPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_clearAllMarkers(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        rangeOnMapPolygonPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RangeOnMapPolygonPointLayerItemImpl_setForeshorteningCoef(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        rangeOnMapPolygonPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RangeOnMapPolygonPointLayerItemImpl_getForeshorteningCoef(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        return rangeOnMapPolygonPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_resetOnVisible(CustomPointLayerItemImpl customPointLayerItemImpl, boolean z) {
        customPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_onVisible(CustomPointLayerItemImpl customPointLayerItemImpl, boolean z) {
        customPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_getOnVisible(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_applyOnVisible(CustomPointLayerItemImpl customPointLayerItemImpl) {
        customPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CustomPointLayerItemImpl_getBound(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_getVisible(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CustomPointLayerItemImpl_getPriority(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_isAreaCollision(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setAreaCollision(CustomPointLayerItemImpl customPointLayerItemImpl, boolean z) {
        customPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CustomPointLayerItemImpl_getItemType(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_setID(CustomPointLayerItemImpl customPointLayerItemImpl, String str) {
        return customPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CustomPointLayerItemImpl_getID(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_setInfo(CustomPointLayerItemImpl customPointLayerItemImpl, String str) {
        return customPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CustomPointLayerItemImpl_getInfo(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setPriority(CustomPointLayerItemImpl customPointLayerItemImpl, int i) {
        customPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setVisible(CustomPointLayerItemImpl customPointLayerItemImpl, boolean z) {
        customPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_getFocus(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setAlpha(CustomPointLayerItemImpl customPointLayerItemImpl, double d) {
        customPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CustomPointLayerItemImpl_getAlpha(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setAngle(CustomPointLayerItemImpl customPointLayerItemImpl, double d) {
        customPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CustomPointLayerItemImpl_getAngle(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setPitch(CustomPointLayerItemImpl customPointLayerItemImpl, double d) {
        customPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CustomPointLayerItemImpl_getPitch(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setMaxPitch(CustomPointLayerItemImpl customPointLayerItemImpl, double d) {
        customPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CustomPointLayerItemImpl_getMaxPitch(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setDisplayScale(CustomPointLayerItemImpl customPointLayerItemImpl, LayerScale layerScale) {
        customPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CustomPointLayerItemImpl_getDisplayScale(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setAnimation(CustomPointLayerItemImpl customPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        customPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setStyle__SWIG_0(CustomPointLayerItemImpl customPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        customPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setStyle__SWIG_1(CustomPointLayerItemImpl customPointLayerItemImpl, String str) {
        customPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_updateStyle__SWIG_0(CustomPointLayerItemImpl customPointLayerItemImpl) {
        customPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_updateStyle__SWIG_1(CustomPointLayerItemImpl customPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        customPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_addPoiFilter(CustomPointLayerItemImpl customPointLayerItemImpl) {
        customPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_removePoiFilter(CustomPointLayerItemImpl customPointLayerItemImpl) {
        customPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_onPaint(CustomPointLayerItemImpl customPointLayerItemImpl) {
        customPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setParent(CustomPointLayerItemImpl customPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        customPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setBusinessType(CustomPointLayerItemImpl customPointLayerItemImpl, int i) {
        customPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CustomPointLayerItemImpl_getBusinessType(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CustomPointLayerItemImpl_getTypeIdName(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_clearStyle(CustomPointLayerItemImpl customPointLayerItemImpl) {
        customPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setVisible3V(CustomPointLayerItemImpl customPointLayerItemImpl, Visible3V visible3V) {
        customPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_getVisible3V(CustomPointLayerItemImpl customPointLayerItemImpl, Visible3V visible3V) {
        customPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setBillboard(CustomPointLayerItemImpl customPointLayerItemImpl, boolean z) {
        customPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_getBillboard(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setPosition3D(CustomPointLayerItemImpl customPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        customPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setRotateCenter3D(CustomPointLayerItemImpl customPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        customPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_getRotateCenter3D(CustomPointLayerItemImpl customPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        customPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setPosition(CustomPointLayerItemImpl customPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        customPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_getPosition(CustomPointLayerItemImpl customPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        customPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setRotateCenter(CustomPointLayerItemImpl customPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        customPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_getNormalStyle(CustomPointLayerItemImpl customPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        customPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_getFocusStyle(CustomPointLayerItemImpl customPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        customPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setItemVisibleRegion(CustomPointLayerItemImpl customPointLayerItemImpl, RectInt rectInt) {
        customPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setItemIgnoreRegion(CustomPointLayerItemImpl customPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        customPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_getItemIgnoreRegion(CustomPointLayerItemImpl customPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        customPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setScale(CustomPointLayerItemImpl customPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        customPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_getScale(CustomPointLayerItemImpl customPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        customPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setPointTypeCode(CustomPointLayerItemImpl customPointLayerItemImpl, String str) {
        customPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_CustomPointLayerItemImpl_getPointTypeCode(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setScaleFactor(CustomPointLayerItemImpl customPointLayerItemImpl, float[] fArr) {
        customPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setRotateMode(CustomPointLayerItemImpl customPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        customPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_CustomPointLayerItemImpl_addMarker(CustomPointLayerItemImpl customPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return customPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_CustomPointLayerItemImpl_clearAllMarkers(CustomPointLayerItemImpl customPointLayerItemImpl) {
        customPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_CustomPointLayerItemImpl_setForeshorteningCoef(CustomPointLayerItemImpl customPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        customPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_CustomPointLayerItemImpl_getForeshorteningCoef(CustomPointLayerItemImpl customPointLayerItemImpl) {
        return customPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_resetOnVisible(CustomLineLayerItemImpl customLineLayerItemImpl, boolean z) {
        customLineLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_onVisible(CustomLineLayerItemImpl customLineLayerItemImpl, boolean z) {
        customLineLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CustomLineLayerItemImpl_getOnVisible(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_applyOnVisible(CustomLineLayerItemImpl customLineLayerItemImpl) {
        customLineLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CustomLineLayerItemImpl_getBound(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CustomLineLayerItemImpl_getVisible(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CustomLineLayerItemImpl_getPriority(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CustomLineLayerItemImpl_isAreaCollision(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setAreaCollision(CustomLineLayerItemImpl customLineLayerItemImpl, boolean z) {
        customLineLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CustomLineLayerItemImpl_getItemType(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CustomLineLayerItemImpl_setID(CustomLineLayerItemImpl customLineLayerItemImpl, String str) {
        return customLineLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CustomLineLayerItemImpl_getID(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CustomLineLayerItemImpl_setInfo(CustomLineLayerItemImpl customLineLayerItemImpl, String str) {
        return customLineLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CustomLineLayerItemImpl_getInfo(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setPriority(CustomLineLayerItemImpl customLineLayerItemImpl, int i) {
        customLineLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setVisible(CustomLineLayerItemImpl customLineLayerItemImpl, boolean z) {
        customLineLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CustomLineLayerItemImpl_getFocus(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setAlpha(CustomLineLayerItemImpl customLineLayerItemImpl, double d) {
        customLineLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CustomLineLayerItemImpl_getAlpha(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setAngle(CustomLineLayerItemImpl customLineLayerItemImpl, double d) {
        customLineLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CustomLineLayerItemImpl_getAngle(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setPitch(CustomLineLayerItemImpl customLineLayerItemImpl, double d) {
        customLineLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CustomLineLayerItemImpl_getPitch(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setMaxPitch(CustomLineLayerItemImpl customLineLayerItemImpl, double d) {
        customLineLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CustomLineLayerItemImpl_getMaxPitch(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setDisplayScale(CustomLineLayerItemImpl customLineLayerItemImpl, LayerScale layerScale) {
        customLineLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CustomLineLayerItemImpl_getDisplayScale(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setAnimation(CustomLineLayerItemImpl customLineLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        customLineLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setStyle__SWIG_0(CustomLineLayerItemImpl customLineLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        customLineLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setStyle__SWIG_1(CustomLineLayerItemImpl customLineLayerItemImpl, String str) {
        customLineLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_updateStyle__SWIG_0(CustomLineLayerItemImpl customLineLayerItemImpl) {
        customLineLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_updateStyle__SWIG_1(CustomLineLayerItemImpl customLineLayerItemImpl, LayerItemImpl layerItemImpl) {
        customLineLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_addPoiFilter(CustomLineLayerItemImpl customLineLayerItemImpl) {
        customLineLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_removePoiFilter(CustomLineLayerItemImpl customLineLayerItemImpl) {
        customLineLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_onPaint(CustomLineLayerItemImpl customLineLayerItemImpl) {
        customLineLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setParent(CustomLineLayerItemImpl customLineLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        customLineLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setBusinessType(CustomLineLayerItemImpl customLineLayerItemImpl, int i) {
        customLineLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CustomLineLayerItemImpl_getBusinessType(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CustomLineLayerItemImpl_getTypeIdName(CustomLineLayerItemImpl customLineLayerItemImpl) {
        return customLineLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_clearStyle(CustomLineLayerItemImpl customLineLayerItemImpl) {
        customLineLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setPoints(CustomLineLayerItemImpl customLineLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        customLineLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setColor(CustomLineLayerItemImpl customLineLayerItemImpl, long j, long j2) {
        customLineLayerItemImpl.setColor(j, j2);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_setWidth(CustomLineLayerItemImpl customLineLayerItemImpl, int i, int i2) {
        customLineLayerItemImpl.setWidth(i, i2);
    }

    public static void SwigDirector_CustomLineLayerItemImpl_getStyle(CustomLineLayerItemImpl customLineLayerItemImpl, LineLayerItemStyle lineLayerItemStyle) {
        customLineLayerItemImpl.getStyle(lineLayerItemStyle);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_resetOnVisible(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, boolean z) {
        customPolygonLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_onVisible(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, boolean z) {
        customPolygonLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CustomPolygonLayerItemImpl_getOnVisible(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_applyOnVisible(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        customPolygonLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CustomPolygonLayerItemImpl_getBound(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CustomPolygonLayerItemImpl_getVisible(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CustomPolygonLayerItemImpl_getPriority(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CustomPolygonLayerItemImpl_isAreaCollision(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setAreaCollision(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, boolean z) {
        customPolygonLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CustomPolygonLayerItemImpl_getItemType(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CustomPolygonLayerItemImpl_setID(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, String str) {
        return customPolygonLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CustomPolygonLayerItemImpl_getID(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CustomPolygonLayerItemImpl_setInfo(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, String str) {
        return customPolygonLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CustomPolygonLayerItemImpl_getInfo(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setPriority(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, int i) {
        customPolygonLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setVisible(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, boolean z) {
        customPolygonLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CustomPolygonLayerItemImpl_getFocus(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setAlpha(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, double d) {
        customPolygonLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CustomPolygonLayerItemImpl_getAlpha(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setAngle(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, double d) {
        customPolygonLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CustomPolygonLayerItemImpl_getAngle(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setPitch(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, double d) {
        customPolygonLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CustomPolygonLayerItemImpl_getPitch(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setMaxPitch(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, double d) {
        customPolygonLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CustomPolygonLayerItemImpl_getMaxPitch(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setDisplayScale(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, LayerScale layerScale) {
        customPolygonLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CustomPolygonLayerItemImpl_getDisplayScale(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setAnimation(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        customPolygonLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setStyle__SWIG_0(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        customPolygonLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setStyle__SWIG_1(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, String str) {
        customPolygonLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_updateStyle(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        customPolygonLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_updateStyle__SWIG_1(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, LayerItemImpl layerItemImpl) {
        customPolygonLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_addPoiFilter(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        customPolygonLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_removePoiFilter(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        customPolygonLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_onPaint(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        customPolygonLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setParent(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        customPolygonLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setBusinessType(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, int i) {
        customPolygonLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CustomPolygonLayerItemImpl_getBusinessType(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CustomPolygonLayerItemImpl_getTypeIdName(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_clearStyle(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        customPolygonLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setPoints(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        customPolygonLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_CustomPolygonLayerItemImpl_setColor(CustomPolygonLayerItemImpl customPolygonLayerItemImpl, long j) {
        customPolygonLayerItemImpl.setColor(j);
    }

    public static long SwigDirector_CustomPolygonLayerItemImpl_getColor(CustomPolygonLayerItemImpl customPolygonLayerItemImpl) {
        return customPolygonLayerItemImpl.getColor();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_resetOnVisible(CustomCircleLayerItemImpl customCircleLayerItemImpl, boolean z) {
        customCircleLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_onVisible(CustomCircleLayerItemImpl customCircleLayerItemImpl, boolean z) {
        customCircleLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CustomCircleLayerItemImpl_getOnVisible(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_applyOnVisible(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        customCircleLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CustomCircleLayerItemImpl_getBound(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CustomCircleLayerItemImpl_getVisible(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CustomCircleLayerItemImpl_getPriority(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CustomCircleLayerItemImpl_isAreaCollision(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setAreaCollision(CustomCircleLayerItemImpl customCircleLayerItemImpl, boolean z) {
        customCircleLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CustomCircleLayerItemImpl_getItemType(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CustomCircleLayerItemImpl_setID(CustomCircleLayerItemImpl customCircleLayerItemImpl, String str) {
        return customCircleLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CustomCircleLayerItemImpl_getID(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CustomCircleLayerItemImpl_setInfo(CustomCircleLayerItemImpl customCircleLayerItemImpl, String str) {
        return customCircleLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CustomCircleLayerItemImpl_getInfo(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setPriority(CustomCircleLayerItemImpl customCircleLayerItemImpl, int i) {
        customCircleLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setVisible(CustomCircleLayerItemImpl customCircleLayerItemImpl, boolean z) {
        customCircleLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CustomCircleLayerItemImpl_getFocus(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setAlpha(CustomCircleLayerItemImpl customCircleLayerItemImpl, double d) {
        customCircleLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CustomCircleLayerItemImpl_getAlpha(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setAngle(CustomCircleLayerItemImpl customCircleLayerItemImpl, double d) {
        customCircleLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CustomCircleLayerItemImpl_getAngle(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setPitch(CustomCircleLayerItemImpl customCircleLayerItemImpl, double d) {
        customCircleLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CustomCircleLayerItemImpl_getPitch(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setMaxPitch(CustomCircleLayerItemImpl customCircleLayerItemImpl, double d) {
        customCircleLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CustomCircleLayerItemImpl_getMaxPitch(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setDisplayScale(CustomCircleLayerItemImpl customCircleLayerItemImpl, LayerScale layerScale) {
        customCircleLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CustomCircleLayerItemImpl_getDisplayScale(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setAnimation(CustomCircleLayerItemImpl customCircleLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        customCircleLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setStyle__SWIG_0(CustomCircleLayerItemImpl customCircleLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        customCircleLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setStyle__SWIG_1(CustomCircleLayerItemImpl customCircleLayerItemImpl, String str) {
        customCircleLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_updateStyle(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        customCircleLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_updateStyle__SWIG_1(CustomCircleLayerItemImpl customCircleLayerItemImpl, LayerItemImpl layerItemImpl) {
        customCircleLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_addPoiFilter(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        customCircleLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_removePoiFilter(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        customCircleLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_onPaint(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        customCircleLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setParent(CustomCircleLayerItemImpl customCircleLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        customCircleLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setBusinessType(CustomCircleLayerItemImpl customCircleLayerItemImpl, int i) {
        customCircleLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CustomCircleLayerItemImpl_getBusinessType(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CustomCircleLayerItemImpl_getTypeIdName(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_clearStyle(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        customCircleLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setPosition(CustomCircleLayerItemImpl customCircleLayerItemImpl, Coord3DDouble coord3DDouble) {
        customCircleLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setRadius(CustomCircleLayerItemImpl customCircleLayerItemImpl, double d) {
        customCircleLayerItemImpl.setRadius(d);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setSectorAngles(CustomCircleLayerItemImpl customCircleLayerItemImpl, SectorAngles sectorAngles) {
        customCircleLayerItemImpl.setSectorAngles(sectorAngles);
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_setColor(CustomCircleLayerItemImpl customCircleLayerItemImpl, long j) {
        customCircleLayerItemImpl.setColor(j);
    }

    public static double SwigDirector_CustomCircleLayerItemImpl_getRadius(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getRadius();
    }

    public static void SwigDirector_CustomCircleLayerItemImpl_getSectorAngles(CustomCircleLayerItemImpl customCircleLayerItemImpl, SectorAngles sectorAngles) {
        customCircleLayerItemImpl.getSectorAngles(sectorAngles);
    }

    public static long SwigDirector_CustomCircleLayerItemImpl_getColor(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        return customCircleLayerItemImpl.getColor();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_resetOnVisible(CustomArrowLayerItemImpl customArrowLayerItemImpl, boolean z) {
        customArrowLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_onVisible(CustomArrowLayerItemImpl customArrowLayerItemImpl, boolean z) {
        customArrowLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_getOnVisible(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_applyOnVisible(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        customArrowLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CustomArrowLayerItemImpl_getBound(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_getVisible(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CustomArrowLayerItemImpl_getPriority(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_isAreaCollision(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setAreaCollision(CustomArrowLayerItemImpl customArrowLayerItemImpl, boolean z) {
        customArrowLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CustomArrowLayerItemImpl_getItemType(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_setID(CustomArrowLayerItemImpl customArrowLayerItemImpl, String str) {
        return customArrowLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CustomArrowLayerItemImpl_getID(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_setInfo(CustomArrowLayerItemImpl customArrowLayerItemImpl, String str) {
        return customArrowLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CustomArrowLayerItemImpl_getInfo(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setPriority(CustomArrowLayerItemImpl customArrowLayerItemImpl, int i) {
        customArrowLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setVisible(CustomArrowLayerItemImpl customArrowLayerItemImpl, boolean z) {
        customArrowLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_getFocus(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setAlpha(CustomArrowLayerItemImpl customArrowLayerItemImpl, double d) {
        customArrowLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CustomArrowLayerItemImpl_getAlpha(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setAngle(CustomArrowLayerItemImpl customArrowLayerItemImpl, double d) {
        customArrowLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CustomArrowLayerItemImpl_getAngle(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setPitch(CustomArrowLayerItemImpl customArrowLayerItemImpl, double d) {
        customArrowLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CustomArrowLayerItemImpl_getPitch(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setMaxPitch(CustomArrowLayerItemImpl customArrowLayerItemImpl, double d) {
        customArrowLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CustomArrowLayerItemImpl_getMaxPitch(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setDisplayScale(CustomArrowLayerItemImpl customArrowLayerItemImpl, LayerScale layerScale) {
        customArrowLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CustomArrowLayerItemImpl_getDisplayScale(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setAnimation(CustomArrowLayerItemImpl customArrowLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        customArrowLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setStyle__SWIG_0(CustomArrowLayerItemImpl customArrowLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        customArrowLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setStyle__SWIG_1(CustomArrowLayerItemImpl customArrowLayerItemImpl, String str) {
        customArrowLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_updateStyle(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        customArrowLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_updateStyle__SWIG_1(CustomArrowLayerItemImpl customArrowLayerItemImpl, LayerItemImpl layerItemImpl) {
        customArrowLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_addPoiFilter(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        customArrowLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_removePoiFilter(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        customArrowLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_onPaint(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        customArrowLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setParent(CustomArrowLayerItemImpl customArrowLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        customArrowLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setBusinessType(CustomArrowLayerItemImpl customArrowLayerItemImpl, int i) {
        customArrowLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CustomArrowLayerItemImpl_getBusinessType(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CustomArrowLayerItemImpl_getTypeIdName(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_clearStyle(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        customArrowLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setPoints(CustomArrowLayerItemImpl customArrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        customArrowLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setPoints3D(CustomArrowLayerItemImpl customArrowLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        customArrowLayerItemImpl.setPoints3D(arrayList);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_getStyle(CustomArrowLayerItemImpl customArrowLayerItemImpl, ArrowLayerItemStyle arrowLayerItemStyle) {
        customArrowLayerItemImpl.getStyle(arrowLayerItemStyle);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setAnimationPlayState(CustomArrowLayerItemImpl customArrowLayerItemImpl, @ArrowAnimationPlayState.ArrowAnimationPlayState1 int i) {
        customArrowLayerItemImpl.setAnimationPlayState(i);
    }

    @ArrowAnimationPlayState.ArrowAnimationPlayState1
    public static int SwigDirector_CustomArrowLayerItemImpl_getAnimationPlayState(CustomArrowLayerItemImpl customArrowLayerItemImpl) {
        return customArrowLayerItemImpl.getAnimationPlayState();
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setGrownAnimation__SWIG_0(CustomArrowLayerItemImpl customArrowLayerItemImpl, int i, int i2, long j) {
        customArrowLayerItemImpl.setGrownAnimation(i, i2, j);
    }

    public static void SwigDirector_CustomArrowLayerItemImpl_setGrownAnimation__SWIG_1(CustomArrowLayerItemImpl customArrowLayerItemImpl, int i, int i2) {
        customArrowLayerItemImpl.setGrownAnimation(i, i2);
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_addGrownAnimationObserver(CustomArrowLayerItemImpl customArrowLayerItemImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return customArrowLayerItemImpl.addGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_removeGrownAnimationObserver(CustomArrowLayerItemImpl customArrowLayerItemImpl, ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl) {
        return customArrowLayerItemImpl.removeGrownAnimationObserver(iLayerItemAnimationObserverImpl);
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_isIntersectCircle(CustomArrowLayerItemImpl customArrowLayerItemImpl, double d, double d2, int i) {
        return customArrowLayerItemImpl.isIntersectCircle(d, d2, i);
    }

    public static boolean SwigDirector_CustomArrowLayerItemImpl_isIntersectRect(CustomArrowLayerItemImpl customArrowLayerItemImpl, RectDouble rectDouble) {
        return customArrowLayerItemImpl.isIntersectRect(rectDouble);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_resetOnVisible(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, boolean z) {
        customPlaneLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_onVisible(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, boolean z) {
        customPlaneLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CustomPlaneLayerItemImpl_getOnVisible(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_applyOnVisible(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        customPlaneLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CustomPlaneLayerItemImpl_getBound(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CustomPlaneLayerItemImpl_getVisible(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CustomPlaneLayerItemImpl_getPriority(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CustomPlaneLayerItemImpl_isAreaCollision(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setAreaCollision(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, boolean z) {
        customPlaneLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CustomPlaneLayerItemImpl_getItemType(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CustomPlaneLayerItemImpl_setID(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, String str) {
        return customPlaneLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CustomPlaneLayerItemImpl_getID(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CustomPlaneLayerItemImpl_setInfo(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, String str) {
        return customPlaneLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CustomPlaneLayerItemImpl_getInfo(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setPriority(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, int i) {
        customPlaneLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setVisible(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, boolean z) {
        customPlaneLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CustomPlaneLayerItemImpl_getFocus(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setAlpha(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, double d) {
        customPlaneLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CustomPlaneLayerItemImpl_getAlpha(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setAngle(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, double d) {
        customPlaneLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CustomPlaneLayerItemImpl_getAngle(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setPitch(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, double d) {
        customPlaneLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CustomPlaneLayerItemImpl_getPitch(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setMaxPitch(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, double d) {
        customPlaneLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CustomPlaneLayerItemImpl_getMaxPitch(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setDisplayScale(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, LayerScale layerScale) {
        customPlaneLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CustomPlaneLayerItemImpl_getDisplayScale(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setAnimation(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        customPlaneLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setStyle__SWIG_0(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        customPlaneLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setStyle__SWIG_1(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, String str) {
        customPlaneLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_updateStyle(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        customPlaneLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_updateStyle__SWIG_1(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, LayerItemImpl layerItemImpl) {
        customPlaneLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_addPoiFilter(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        customPlaneLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_removePoiFilter(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        customPlaneLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_onPaint(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        customPlaneLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setParent(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        customPlaneLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setBusinessType(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, int i) {
        customPlaneLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CustomPlaneLayerItemImpl_getBusinessType(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CustomPlaneLayerItemImpl_getTypeIdName(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        return customPlaneLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_clearStyle(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        customPlaneLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setArrowColor(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, boolean z, int i) {
        customPlaneLayerItemImpl.setArrowColor(z, i);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setRasterImageData(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, LayerTexture layerTexture, LayerTexture layerTexture2) {
        customPlaneLayerItemImpl.setRasterImageData(layerTexture, layerTexture2);
    }

    public static void SwigDirector_CustomPlaneLayerItemImpl_setPlaneViewRect(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, RectInt rectInt) {
        customPlaneLayerItemImpl.setPlaneViewRect(rectInt);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_resetOnVisible(SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z) {
        speedCarLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_onVisible(SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z) {
        speedCarLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_getOnVisible(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_applyOnVisible(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        speedCarLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SpeedCarLayerItemImpl_getBound(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_getVisible(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SpeedCarLayerItemImpl_getPriority(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_isAreaCollision(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setAreaCollision(SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z) {
        speedCarLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SpeedCarLayerItemImpl_getItemType(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_setID(SpeedCarLayerItemImpl speedCarLayerItemImpl, String str) {
        return speedCarLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SpeedCarLayerItemImpl_getID(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_setInfo(SpeedCarLayerItemImpl speedCarLayerItemImpl, String str) {
        return speedCarLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SpeedCarLayerItemImpl_getInfo(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setPriority(SpeedCarLayerItemImpl speedCarLayerItemImpl, int i) {
        speedCarLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setVisible(SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z) {
        speedCarLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_getFocus(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setAlpha(SpeedCarLayerItemImpl speedCarLayerItemImpl, double d) {
        speedCarLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SpeedCarLayerItemImpl_getAlpha(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setAngle(SpeedCarLayerItemImpl speedCarLayerItemImpl, double d) {
        speedCarLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SpeedCarLayerItemImpl_getAngle(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setPitch(SpeedCarLayerItemImpl speedCarLayerItemImpl, double d) {
        speedCarLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SpeedCarLayerItemImpl_getPitch(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setMaxPitch(SpeedCarLayerItemImpl speedCarLayerItemImpl, double d) {
        speedCarLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SpeedCarLayerItemImpl_getMaxPitch(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setDisplayScale(SpeedCarLayerItemImpl speedCarLayerItemImpl, LayerScale layerScale) {
        speedCarLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SpeedCarLayerItemImpl_getDisplayScale(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setAnimation(SpeedCarLayerItemImpl speedCarLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        speedCarLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setStyle__SWIG_0(SpeedCarLayerItemImpl speedCarLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        speedCarLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setStyle__SWIG_1(SpeedCarLayerItemImpl speedCarLayerItemImpl, String str) {
        speedCarLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_updateStyle(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        speedCarLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_updateStyle__SWIG_1(SpeedCarLayerItemImpl speedCarLayerItemImpl, LayerItemImpl layerItemImpl) {
        speedCarLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_addPoiFilter(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        speedCarLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_removePoiFilter(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        speedCarLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_onPaint(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        speedCarLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setParent(SpeedCarLayerItemImpl speedCarLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        speedCarLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setBusinessType(SpeedCarLayerItemImpl speedCarLayerItemImpl, int i) {
        speedCarLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SpeedCarLayerItemImpl_getBusinessType(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SpeedCarLayerItemImpl_getTypeIdName(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_clearStyle(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        speedCarLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setDepthMask(SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z) {
        speedCarLayerItemImpl.setDepthMask(z);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setResolveConflict(SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z) {
        speedCarLayerItemImpl.setResolveConflict(z);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setVisible3V(SpeedCarLayerItemImpl speedCarLayerItemImpl, Visible3V visible3V) {
        speedCarLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getVisible3V(SpeedCarLayerItemImpl speedCarLayerItemImpl, Visible3V visible3V) {
        speedCarLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setBillboard(SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z) {
        speedCarLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_getBillboard(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        return speedCarLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setPosition3D(SpeedCarLayerItemImpl speedCarLayerItemImpl, Coord3DDouble coord3DDouble) {
        speedCarLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getPosition3D(SpeedCarLayerItemImpl speedCarLayerItemImpl, Coord3DDouble coord3DDouble) {
        speedCarLayerItemImpl.getPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setRotateCenter3D(SpeedCarLayerItemImpl speedCarLayerItemImpl, Coord3DDouble coord3DDouble) {
        speedCarLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getRotateCenter3D(SpeedCarLayerItemImpl speedCarLayerItemImpl, Coord3DDouble coord3DDouble) {
        speedCarLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setPosition(SpeedCarLayerItemImpl speedCarLayerItemImpl, Coord3DDouble coord3DDouble) {
        speedCarLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getPosition(SpeedCarLayerItemImpl speedCarLayerItemImpl, Coord3DDouble coord3DDouble) {
        speedCarLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setRotateCenter(SpeedCarLayerItemImpl speedCarLayerItemImpl, Coord3DDouble coord3DDouble) {
        speedCarLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getNormalStyle(SpeedCarLayerItemImpl speedCarLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        speedCarLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getFocusStyle(SpeedCarLayerItemImpl speedCarLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        speedCarLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setItemVisibleRegion(SpeedCarLayerItemImpl speedCarLayerItemImpl, RectInt rectInt) {
        speedCarLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getItemVisibleRegion(SpeedCarLayerItemImpl speedCarLayerItemImpl, RectInt rectInt) {
        speedCarLayerItemImpl.getItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setItemIgnoreRegion(SpeedCarLayerItemImpl speedCarLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        speedCarLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getItemIgnoreRegion(SpeedCarLayerItemImpl speedCarLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        speedCarLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setScaleFactor(SpeedCarLayerItemImpl speedCarLayerItemImpl, float[] fArr) {
        speedCarLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setScale(SpeedCarLayerItemImpl speedCarLayerItemImpl, ScaleInfo scaleInfo) {
        speedCarLayerItemImpl.setScale(scaleInfo);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_getScale(SpeedCarLayerItemImpl speedCarLayerItemImpl, ScaleInfo scaleInfo) {
        speedCarLayerItemImpl.getScale(scaleInfo);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_setRotateMode(SpeedCarLayerItemImpl speedCarLayerItemImpl, @RotateMode.RotateMode1 int i) {
        speedCarLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SpeedCarLayerItemImpl_addMarker(SpeedCarLayerItemImpl speedCarLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return speedCarLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SpeedCarLayerItemImpl_clearAllMarkers(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        speedCarLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_resetOnVisible(CruiseCongestionItemImpl cruiseCongestionItemImpl, boolean z) {
        cruiseCongestionItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_onVisible(CruiseCongestionItemImpl cruiseCongestionItemImpl, boolean z) {
        cruiseCongestionItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CruiseCongestionItemImpl_getOnVisible(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getOnVisible();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_applyOnVisible(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        cruiseCongestionItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CruiseCongestionItemImpl_getBound(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getBound();
    }

    public static boolean SwigDirector_CruiseCongestionItemImpl_getVisible(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getVisible();
    }

    public static int SwigDirector_CruiseCongestionItemImpl_getPriority(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getPriority();
    }

    public static boolean SwigDirector_CruiseCongestionItemImpl_isAreaCollision(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setAreaCollision(CruiseCongestionItemImpl cruiseCongestionItemImpl, boolean z) {
        cruiseCongestionItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CruiseCongestionItemImpl_getItemType(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getItemType();
    }

    public static boolean SwigDirector_CruiseCongestionItemImpl_setID(CruiseCongestionItemImpl cruiseCongestionItemImpl, String str) {
        return cruiseCongestionItemImpl.setID(str);
    }

    public static String SwigDirector_CruiseCongestionItemImpl_getID(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getID();
    }

    public static boolean SwigDirector_CruiseCongestionItemImpl_setInfo(CruiseCongestionItemImpl cruiseCongestionItemImpl, String str) {
        return cruiseCongestionItemImpl.setInfo(str);
    }

    public static String SwigDirector_CruiseCongestionItemImpl_getInfo(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getInfo();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setPriority(CruiseCongestionItemImpl cruiseCongestionItemImpl, int i) {
        cruiseCongestionItemImpl.setPriority(i);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setVisible(CruiseCongestionItemImpl cruiseCongestionItemImpl, boolean z) {
        cruiseCongestionItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CruiseCongestionItemImpl_getFocus(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getFocus();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setAlpha(CruiseCongestionItemImpl cruiseCongestionItemImpl, double d) {
        cruiseCongestionItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CruiseCongestionItemImpl_getAlpha(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getAlpha();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setAngle(CruiseCongestionItemImpl cruiseCongestionItemImpl, double d) {
        cruiseCongestionItemImpl.setAngle(d);
    }

    public static double SwigDirector_CruiseCongestionItemImpl_getAngle(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getAngle();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setPitch(CruiseCongestionItemImpl cruiseCongestionItemImpl, double d) {
        cruiseCongestionItemImpl.setPitch(d);
    }

    public static double SwigDirector_CruiseCongestionItemImpl_getPitch(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getPitch();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setMaxPitch(CruiseCongestionItemImpl cruiseCongestionItemImpl, double d) {
        cruiseCongestionItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CruiseCongestionItemImpl_getMaxPitch(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setDisplayScale(CruiseCongestionItemImpl cruiseCongestionItemImpl, LayerScale layerScale) {
        cruiseCongestionItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CruiseCongestionItemImpl_getDisplayScale(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setAnimation(CruiseCongestionItemImpl cruiseCongestionItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        cruiseCongestionItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setStyle__SWIG_0(CruiseCongestionItemImpl cruiseCongestionItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        cruiseCongestionItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setStyle__SWIG_1(CruiseCongestionItemImpl cruiseCongestionItemImpl, String str) {
        cruiseCongestionItemImpl.setStyle(str);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_updateStyle__SWIG_0(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        cruiseCongestionItemImpl.updateStyle();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_updateStyle__SWIG_1(CruiseCongestionItemImpl cruiseCongestionItemImpl, LayerItemImpl layerItemImpl) {
        cruiseCongestionItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_addPoiFilter(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        cruiseCongestionItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_removePoiFilter(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        cruiseCongestionItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_onPaint(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        cruiseCongestionItemImpl.onPaint();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setParent(CruiseCongestionItemImpl cruiseCongestionItemImpl, BaseLayerImpl baseLayerImpl) {
        cruiseCongestionItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setBusinessType(CruiseCongestionItemImpl cruiseCongestionItemImpl, int i) {
        cruiseCongestionItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CruiseCongestionItemImpl_getBusinessType(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getBusinessType();
    }

    public static String SwigDirector_CruiseCongestionItemImpl_getTypeIdName(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        return cruiseCongestionItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_clearStyle(CruiseCongestionItemImpl cruiseCongestionItemImpl) {
        cruiseCongestionItemImpl.clearStyle();
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setPoints(CruiseCongestionItemImpl cruiseCongestionItemImpl, ArrayList<Coord3DDouble> arrayList) {
        cruiseCongestionItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setColor(CruiseCongestionItemImpl cruiseCongestionItemImpl, long j, long j2) {
        cruiseCongestionItemImpl.setColor(j, j2);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_setWidth(CruiseCongestionItemImpl cruiseCongestionItemImpl, int i, int i2) {
        cruiseCongestionItemImpl.setWidth(i, i2);
    }

    public static void SwigDirector_CruiseCongestionItemImpl_getStyle(CruiseCongestionItemImpl cruiseCongestionItemImpl, LineLayerItemStyle lineLayerItemStyle) {
        cruiseCongestionItemImpl.getStyle(lineLayerItemStyle);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_resetOnVisible(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, boolean z) {
        guideMixForkLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_onVisible(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, boolean z) {
        guideMixForkLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_getOnVisible(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_applyOnVisible(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        guideMixForkLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideMixForkLayerItemImpl_getBound(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_getVisible(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideMixForkLayerItemImpl_getPriority(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_isAreaCollision(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setAreaCollision(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, boolean z) {
        guideMixForkLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideMixForkLayerItemImpl_getItemType(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_setID(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, String str) {
        return guideMixForkLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideMixForkLayerItemImpl_getID(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_setInfo(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, String str) {
        return guideMixForkLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideMixForkLayerItemImpl_getInfo(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setPriority(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, int i) {
        guideMixForkLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setVisible(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, boolean z) {
        guideMixForkLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_getFocus(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setAlpha(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, double d) {
        guideMixForkLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideMixForkLayerItemImpl_getAlpha(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setAngle(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, double d) {
        guideMixForkLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideMixForkLayerItemImpl_getAngle(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setPitch(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, double d) {
        guideMixForkLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideMixForkLayerItemImpl_getPitch(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setMaxPitch(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, double d) {
        guideMixForkLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideMixForkLayerItemImpl_getMaxPitch(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setDisplayScale(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, LayerScale layerScale) {
        guideMixForkLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideMixForkLayerItemImpl_getDisplayScale(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setAnimation(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideMixForkLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setStyle__SWIG_0(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideMixForkLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setStyle__SWIG_1(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, String str) {
        guideMixForkLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_updateStyle__SWIG_0(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        guideMixForkLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_updateStyle__SWIG_1(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideMixForkLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_addPoiFilter(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        guideMixForkLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_removePoiFilter(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        guideMixForkLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_onPaint(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        guideMixForkLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setParent(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideMixForkLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setBusinessType(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, int i) {
        guideMixForkLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideMixForkLayerItemImpl_getBusinessType(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideMixForkLayerItemImpl_getTypeIdName(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_clearStyle(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        guideMixForkLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setVisible3V(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Visible3V visible3V) {
        guideMixForkLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_getVisible3V(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Visible3V visible3V) {
        guideMixForkLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setBillboard(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, boolean z) {
        guideMixForkLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_getBillboard(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setPosition3D(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideMixForkLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setRotateCenter3D(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideMixForkLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_getRotateCenter3D(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideMixForkLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setPosition(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideMixForkLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_getPosition(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideMixForkLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setRotateCenter(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideMixForkLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_getNormalStyle(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideMixForkLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_getFocusStyle(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideMixForkLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setItemVisibleRegion(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, RectInt rectInt) {
        guideMixForkLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setItemIgnoreRegion(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideMixForkLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_getItemIgnoreRegion(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideMixForkLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setScale(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideMixForkLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_getScale(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideMixForkLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setPointTypeCode(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, String str) {
        guideMixForkLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideMixForkLayerItemImpl_getPointTypeCode(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setScaleFactor(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, float[] fArr) {
        guideMixForkLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setRotateMode(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideMixForkLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideMixForkLayerItemImpl_addMarker(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideMixForkLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_clearAllMarkers(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        guideMixForkLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideMixForkLayerItemImpl_setForeshorteningCoef(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideMixForkLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideMixForkLayerItemImpl_getForeshorteningCoef(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        return guideMixForkLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_PopPointLayerItemImpl_resetOnVisible(PopPointLayerItemImpl popPointLayerItemImpl, boolean z) {
        popPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_PopPointLayerItemImpl_onVisible(PopPointLayerItemImpl popPointLayerItemImpl, boolean z) {
        popPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_getOnVisible(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_PopPointLayerItemImpl_applyOnVisible(PopPointLayerItemImpl popPointLayerItemImpl) {
        popPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_PopPointLayerItemImpl_getBound(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_getVisible(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_PopPointLayerItemImpl_getPriority(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_isAreaCollision(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setAreaCollision(PopPointLayerItemImpl popPointLayerItemImpl, boolean z) {
        popPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_PopPointLayerItemImpl_getItemType(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_setID(PopPointLayerItemImpl popPointLayerItemImpl, String str) {
        return popPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_PopPointLayerItemImpl_getID(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_setInfo(PopPointLayerItemImpl popPointLayerItemImpl, String str) {
        return popPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_PopPointLayerItemImpl_getInfo(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setPriority(PopPointLayerItemImpl popPointLayerItemImpl, int i) {
        popPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setVisible(PopPointLayerItemImpl popPointLayerItemImpl, boolean z) {
        popPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_getFocus(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setAlpha(PopPointLayerItemImpl popPointLayerItemImpl, double d) {
        popPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_PopPointLayerItemImpl_getAlpha(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setAngle(PopPointLayerItemImpl popPointLayerItemImpl, double d) {
        popPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_PopPointLayerItemImpl_getAngle(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setPitch(PopPointLayerItemImpl popPointLayerItemImpl, double d) {
        popPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_PopPointLayerItemImpl_getPitch(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setMaxPitch(PopPointLayerItemImpl popPointLayerItemImpl, double d) {
        popPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_PopPointLayerItemImpl_getMaxPitch(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setDisplayScale(PopPointLayerItemImpl popPointLayerItemImpl, LayerScale layerScale) {
        popPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_PopPointLayerItemImpl_getDisplayScale(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setAnimation(PopPointLayerItemImpl popPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        popPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setStyle__SWIG_0(PopPointLayerItemImpl popPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        popPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setStyle__SWIG_1(PopPointLayerItemImpl popPointLayerItemImpl, String str) {
        popPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_PopPointLayerItemImpl_updateStyle__SWIG_0(PopPointLayerItemImpl popPointLayerItemImpl) {
        popPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_PopPointLayerItemImpl_updateStyle__SWIG_1(PopPointLayerItemImpl popPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        popPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_PopPointLayerItemImpl_addPoiFilter(PopPointLayerItemImpl popPointLayerItemImpl) {
        popPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_PopPointLayerItemImpl_removePoiFilter(PopPointLayerItemImpl popPointLayerItemImpl) {
        popPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_PopPointLayerItemImpl_onPaint(PopPointLayerItemImpl popPointLayerItemImpl) {
        popPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setParent(PopPointLayerItemImpl popPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        popPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setBusinessType(PopPointLayerItemImpl popPointLayerItemImpl, int i) {
        popPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_PopPointLayerItemImpl_getBusinessType(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_PopPointLayerItemImpl_getTypeIdName(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_PopPointLayerItemImpl_clearStyle(PopPointLayerItemImpl popPointLayerItemImpl) {
        popPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setVisible3V(PopPointLayerItemImpl popPointLayerItemImpl, Visible3V visible3V) {
        popPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_PopPointLayerItemImpl_getVisible3V(PopPointLayerItemImpl popPointLayerItemImpl, Visible3V visible3V) {
        popPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setBillboard(PopPointLayerItemImpl popPointLayerItemImpl, boolean z) {
        popPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_getBillboard(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setPosition3D(PopPointLayerItemImpl popPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        popPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setRotateCenter3D(PopPointLayerItemImpl popPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        popPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PopPointLayerItemImpl_getRotateCenter3D(PopPointLayerItemImpl popPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        popPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setPosition(PopPointLayerItemImpl popPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        popPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_PopPointLayerItemImpl_getPosition(PopPointLayerItemImpl popPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        popPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setRotateCenter(PopPointLayerItemImpl popPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        popPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_PopPointLayerItemImpl_getNormalStyle(PopPointLayerItemImpl popPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        popPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PopPointLayerItemImpl_getFocusStyle(PopPointLayerItemImpl popPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        popPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setItemVisibleRegion(PopPointLayerItemImpl popPointLayerItemImpl, RectInt rectInt) {
        popPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setItemIgnoreRegion(PopPointLayerItemImpl popPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        popPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PopPointLayerItemImpl_getItemIgnoreRegion(PopPointLayerItemImpl popPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        popPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setScale(PopPointLayerItemImpl popPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        popPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_PopPointLayerItemImpl_getScale(PopPointLayerItemImpl popPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        popPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setPointTypeCode(PopPointLayerItemImpl popPointLayerItemImpl, String str) {
        popPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_PopPointLayerItemImpl_getPointTypeCode(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setScaleFactor(PopPointLayerItemImpl popPointLayerItemImpl, float[] fArr) {
        popPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_PopPointLayerItemImpl_setRotateMode(PopPointLayerItemImpl popPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        popPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_PopPointLayerItemImpl_addMarker(PopPointLayerItemImpl popPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return popPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_PopPointLayerItemImpl_clearAllMarkers(PopPointLayerItemImpl popPointLayerItemImpl) {
        popPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_PopPointLayerItemImpl_setForeshorteningCoef(PopPointLayerItemImpl popPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        popPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_PopPointLayerItemImpl_getForeshorteningCoef(PopPointLayerItemImpl popPointLayerItemImpl) {
        return popPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_resetOnVisible(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, boolean z) {
        cruiseCongestionEventLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_onVisible(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, boolean z) {
        cruiseCongestionEventLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_getOnVisible(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_applyOnVisible(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        cruiseCongestionEventLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CruiseCongestionEventLayerItemImpl_getBound(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_getVisible(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CruiseCongestionEventLayerItemImpl_getPriority(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_isAreaCollision(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setAreaCollision(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, boolean z) {
        cruiseCongestionEventLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CruiseCongestionEventLayerItemImpl_getItemType(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_setID(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, String str) {
        return cruiseCongestionEventLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CruiseCongestionEventLayerItemImpl_getID(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_setInfo(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, String str) {
        return cruiseCongestionEventLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CruiseCongestionEventLayerItemImpl_getInfo(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setPriority(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, int i) {
        cruiseCongestionEventLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setVisible(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, boolean z) {
        cruiseCongestionEventLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_getFocus(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setAlpha(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, double d) {
        cruiseCongestionEventLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CruiseCongestionEventLayerItemImpl_getAlpha(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setAngle(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, double d) {
        cruiseCongestionEventLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CruiseCongestionEventLayerItemImpl_getAngle(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setPitch(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, double d) {
        cruiseCongestionEventLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CruiseCongestionEventLayerItemImpl_getPitch(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setMaxPitch(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, double d) {
        cruiseCongestionEventLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CruiseCongestionEventLayerItemImpl_getMaxPitch(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setDisplayScale(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, LayerScale layerScale) {
        cruiseCongestionEventLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CruiseCongestionEventLayerItemImpl_getDisplayScale(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setAnimation(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        cruiseCongestionEventLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setStyle__SWIG_0(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        cruiseCongestionEventLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setStyle__SWIG_1(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, String str) {
        cruiseCongestionEventLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_updateStyle__SWIG_0(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        cruiseCongestionEventLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_updateStyle__SWIG_1(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, LayerItemImpl layerItemImpl) {
        cruiseCongestionEventLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_addPoiFilter(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        cruiseCongestionEventLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_removePoiFilter(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        cruiseCongestionEventLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_onPaint(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        cruiseCongestionEventLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setParent(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        cruiseCongestionEventLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setBusinessType(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, int i) {
        cruiseCongestionEventLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CruiseCongestionEventLayerItemImpl_getBusinessType(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CruiseCongestionEventLayerItemImpl_getTypeIdName(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_clearStyle(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        cruiseCongestionEventLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setVisible3V(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Visible3V visible3V) {
        cruiseCongestionEventLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_getVisible3V(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Visible3V visible3V) {
        cruiseCongestionEventLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setBillboard(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, boolean z) {
        cruiseCongestionEventLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_getBillboard(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setPosition3D(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionEventLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setRotateCenter3D(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionEventLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_getRotateCenter3D(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionEventLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setPosition(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionEventLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_getPosition(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionEventLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setRotateCenter(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionEventLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_getNormalStyle(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseCongestionEventLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_getFocusStyle(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseCongestionEventLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setItemVisibleRegion(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, RectInt rectInt) {
        cruiseCongestionEventLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setItemIgnoreRegion(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseCongestionEventLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_getItemIgnoreRegion(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseCongestionEventLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setScale(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        cruiseCongestionEventLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_getScale(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, ScaleAttribute scaleAttribute) {
        cruiseCongestionEventLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setPointTypeCode(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, String str) {
        cruiseCongestionEventLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_CruiseCongestionEventLayerItemImpl_getPointTypeCode(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setScaleFactor(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, float[] fArr) {
        cruiseCongestionEventLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setRotateMode(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, @RotateMode.RotateMode1 int i) {
        cruiseCongestionEventLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_CruiseCongestionEventLayerItemImpl_addMarker(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return cruiseCongestionEventLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_clearAllMarkers(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        cruiseCongestionEventLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_CruiseCongestionEventLayerItemImpl_setForeshorteningCoef(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        cruiseCongestionEventLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_CruiseCongestionEventLayerItemImpl_getForeshorteningCoef(CruiseCongestionEventLayerItemImpl cruiseCongestionEventLayerItemImpl) {
        return cruiseCongestionEventLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_resetOnVisible(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, boolean z) {
        guideFacilityLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_onVisible(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, boolean z) {
        guideFacilityLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_getOnVisible(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_applyOnVisible(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        guideFacilityLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideFacilityLayerItemImpl_getBound(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_getVisible(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideFacilityLayerItemImpl_getPriority(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_isAreaCollision(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setAreaCollision(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, boolean z) {
        guideFacilityLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideFacilityLayerItemImpl_getItemType(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_setID(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, String str) {
        return guideFacilityLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideFacilityLayerItemImpl_getID(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_setInfo(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, String str) {
        return guideFacilityLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideFacilityLayerItemImpl_getInfo(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setPriority(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, int i) {
        guideFacilityLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setVisible(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, boolean z) {
        guideFacilityLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_getFocus(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setAlpha(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, double d) {
        guideFacilityLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideFacilityLayerItemImpl_getAlpha(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setAngle(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, double d) {
        guideFacilityLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideFacilityLayerItemImpl_getAngle(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setPitch(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, double d) {
        guideFacilityLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideFacilityLayerItemImpl_getPitch(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setMaxPitch(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, double d) {
        guideFacilityLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideFacilityLayerItemImpl_getMaxPitch(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setDisplayScale(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, LayerScale layerScale) {
        guideFacilityLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideFacilityLayerItemImpl_getDisplayScale(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setAnimation(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideFacilityLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setStyle__SWIG_0(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideFacilityLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setStyle__SWIG_1(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, String str) {
        guideFacilityLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_updateStyle__SWIG_0(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        guideFacilityLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_updateStyle__SWIG_1(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideFacilityLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_addPoiFilter(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        guideFacilityLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_removePoiFilter(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        guideFacilityLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_onPaint(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        guideFacilityLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setParent(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideFacilityLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setBusinessType(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, int i) {
        guideFacilityLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideFacilityLayerItemImpl_getBusinessType(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideFacilityLayerItemImpl_getTypeIdName(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_clearStyle(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        guideFacilityLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setVisible3V(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Visible3V visible3V) {
        guideFacilityLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_getVisible3V(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Visible3V visible3V) {
        guideFacilityLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setBillboard(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, boolean z) {
        guideFacilityLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_getBillboard(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setPosition3D(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFacilityLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setRotateCenter3D(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFacilityLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_getRotateCenter3D(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFacilityLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setPosition(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFacilityLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_getPosition(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFacilityLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setRotateCenter(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFacilityLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_getNormalStyle(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideFacilityLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_getFocusStyle(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideFacilityLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setItemVisibleRegion(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, RectInt rectInt) {
        guideFacilityLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setItemIgnoreRegion(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideFacilityLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_getItemIgnoreRegion(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideFacilityLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setScale(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideFacilityLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_getScale(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideFacilityLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setPointTypeCode(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, String str) {
        guideFacilityLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideFacilityLayerItemImpl_getPointTypeCode(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setScaleFactor(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, float[] fArr) {
        guideFacilityLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setRotateMode(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideFacilityLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideFacilityLayerItemImpl_addMarker(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideFacilityLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_clearAllMarkers(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        guideFacilityLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideFacilityLayerItemImpl_setForeshorteningCoef(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideFacilityLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideFacilityLayerItemImpl_getForeshorteningCoef(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        return guideFacilityLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_resetOnVisible(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, boolean z) {
        guideTrafficEventLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_onVisible(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, boolean z) {
        guideTrafficEventLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_getOnVisible(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_applyOnVisible(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        guideTrafficEventLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideTrafficEventLayerItemImpl_getBound(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_getVisible(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideTrafficEventLayerItemImpl_getPriority(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_isAreaCollision(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setAreaCollision(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, boolean z) {
        guideTrafficEventLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideTrafficEventLayerItemImpl_getItemType(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_setID(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, String str) {
        return guideTrafficEventLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideTrafficEventLayerItemImpl_getID(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_setInfo(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, String str) {
        return guideTrafficEventLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideTrafficEventLayerItemImpl_getInfo(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setPriority(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, int i) {
        guideTrafficEventLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setVisible(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, boolean z) {
        guideTrafficEventLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_getFocus(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setAlpha(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, double d) {
        guideTrafficEventLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideTrafficEventLayerItemImpl_getAlpha(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setAngle(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, double d) {
        guideTrafficEventLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideTrafficEventLayerItemImpl_getAngle(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setPitch(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, double d) {
        guideTrafficEventLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideTrafficEventLayerItemImpl_getPitch(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setMaxPitch(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, double d) {
        guideTrafficEventLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideTrafficEventLayerItemImpl_getMaxPitch(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setDisplayScale(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, LayerScale layerScale) {
        guideTrafficEventLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideTrafficEventLayerItemImpl_getDisplayScale(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setAnimation(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideTrafficEventLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setStyle__SWIG_0(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideTrafficEventLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setStyle__SWIG_1(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, String str) {
        guideTrafficEventLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_updateStyle__SWIG_0(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        guideTrafficEventLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_updateStyle__SWIG_1(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideTrafficEventLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_addPoiFilter(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        guideTrafficEventLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_removePoiFilter(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        guideTrafficEventLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_onPaint(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        guideTrafficEventLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setParent(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideTrafficEventLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setBusinessType(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, int i) {
        guideTrafficEventLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideTrafficEventLayerItemImpl_getBusinessType(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideTrafficEventLayerItemImpl_getTypeIdName(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_clearStyle(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        guideTrafficEventLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setVisible3V(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Visible3V visible3V) {
        guideTrafficEventLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_getVisible3V(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Visible3V visible3V) {
        guideTrafficEventLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setBillboard(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, boolean z) {
        guideTrafficEventLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_getBillboard(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setPosition3D(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficEventLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setRotateCenter3D(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficEventLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_getRotateCenter3D(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficEventLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setPosition(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficEventLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_getPosition(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficEventLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setRotateCenter(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficEventLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_getNormalStyle(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideTrafficEventLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_getFocusStyle(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideTrafficEventLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setItemVisibleRegion(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, RectInt rectInt) {
        guideTrafficEventLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setItemIgnoreRegion(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideTrafficEventLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_getItemIgnoreRegion(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideTrafficEventLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setScale(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideTrafficEventLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_getScale(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideTrafficEventLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setPointTypeCode(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, String str) {
        guideTrafficEventLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideTrafficEventLayerItemImpl_getPointTypeCode(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setScaleFactor(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, float[] fArr) {
        guideTrafficEventLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setRotateMode(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideTrafficEventLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideTrafficEventLayerItemImpl_addMarker(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideTrafficEventLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_clearAllMarkers(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        guideTrafficEventLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideTrafficEventLayerItemImpl_setForeshorteningCoef(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideTrafficEventLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideTrafficEventLayerItemImpl_getForeshorteningCoef(GuideTrafficEventLayerItemImpl guideTrafficEventLayerItemImpl) {
        return guideTrafficEventLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_resetOnVisible(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, boolean z) {
        cruiseFacilityLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_onVisible(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, boolean z) {
        cruiseFacilityLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_getOnVisible(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_applyOnVisible(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        cruiseFacilityLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CruiseFacilityLayerItemImpl_getBound(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_getVisible(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CruiseFacilityLayerItemImpl_getPriority(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_isAreaCollision(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setAreaCollision(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, boolean z) {
        cruiseFacilityLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CruiseFacilityLayerItemImpl_getItemType(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_setID(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, String str) {
        return cruiseFacilityLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CruiseFacilityLayerItemImpl_getID(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_setInfo(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, String str) {
        return cruiseFacilityLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CruiseFacilityLayerItemImpl_getInfo(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setPriority(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, int i) {
        cruiseFacilityLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setVisible(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, boolean z) {
        cruiseFacilityLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_getFocus(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setAlpha(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, double d) {
        cruiseFacilityLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CruiseFacilityLayerItemImpl_getAlpha(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setAngle(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, double d) {
        cruiseFacilityLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CruiseFacilityLayerItemImpl_getAngle(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setPitch(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, double d) {
        cruiseFacilityLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CruiseFacilityLayerItemImpl_getPitch(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setMaxPitch(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, double d) {
        cruiseFacilityLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CruiseFacilityLayerItemImpl_getMaxPitch(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setDisplayScale(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, LayerScale layerScale) {
        cruiseFacilityLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CruiseFacilityLayerItemImpl_getDisplayScale(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setAnimation(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        cruiseFacilityLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setStyle__SWIG_0(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        cruiseFacilityLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setStyle__SWIG_1(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, String str) {
        cruiseFacilityLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_updateStyle__SWIG_0(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        cruiseFacilityLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_updateStyle__SWIG_1(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, LayerItemImpl layerItemImpl) {
        cruiseFacilityLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_addPoiFilter(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        cruiseFacilityLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_removePoiFilter(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        cruiseFacilityLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_onPaint(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        cruiseFacilityLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setParent(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        cruiseFacilityLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setBusinessType(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, int i) {
        cruiseFacilityLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CruiseFacilityLayerItemImpl_getBusinessType(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CruiseFacilityLayerItemImpl_getTypeIdName(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_clearStyle(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        cruiseFacilityLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setVisible3V(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Visible3V visible3V) {
        cruiseFacilityLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_getVisible3V(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Visible3V visible3V) {
        cruiseFacilityLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setBillboard(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, boolean z) {
        cruiseFacilityLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_getBillboard(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setPosition3D(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseFacilityLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setRotateCenter3D(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseFacilityLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_getRotateCenter3D(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseFacilityLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setPosition(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseFacilityLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_getPosition(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseFacilityLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setRotateCenter(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseFacilityLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_getNormalStyle(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseFacilityLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_getFocusStyle(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseFacilityLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setItemVisibleRegion(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, RectInt rectInt) {
        cruiseFacilityLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setItemIgnoreRegion(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseFacilityLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_getItemIgnoreRegion(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseFacilityLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setScale(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        cruiseFacilityLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_getScale(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, ScaleAttribute scaleAttribute) {
        cruiseFacilityLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setPointTypeCode(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, String str) {
        cruiseFacilityLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_CruiseFacilityLayerItemImpl_getPointTypeCode(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setScaleFactor(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, float[] fArr) {
        cruiseFacilityLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setRotateMode(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, @RotateMode.RotateMode1 int i) {
        cruiseFacilityLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_CruiseFacilityLayerItemImpl_addMarker(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return cruiseFacilityLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_clearAllMarkers(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        cruiseFacilityLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_CruiseFacilityLayerItemImpl_setForeshorteningCoef(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        cruiseFacilityLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_CruiseFacilityLayerItemImpl_getForeshorteningCoef(CruiseFacilityLayerItemImpl cruiseFacilityLayerItemImpl) {
        return cruiseFacilityLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_resetOnVisible(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, boolean z) {
        cruiseEventLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_onVisible(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, boolean z) {
        cruiseEventLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_getOnVisible(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_applyOnVisible(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        cruiseEventLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CruiseEventLayerItemImpl_getBound(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_getVisible(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CruiseEventLayerItemImpl_getPriority(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_isAreaCollision(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setAreaCollision(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, boolean z) {
        cruiseEventLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CruiseEventLayerItemImpl_getItemType(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_setID(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, String str) {
        return cruiseEventLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CruiseEventLayerItemImpl_getID(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_setInfo(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, String str) {
        return cruiseEventLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CruiseEventLayerItemImpl_getInfo(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setPriority(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, int i) {
        cruiseEventLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setVisible(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, boolean z) {
        cruiseEventLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_getFocus(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setAlpha(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, double d) {
        cruiseEventLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CruiseEventLayerItemImpl_getAlpha(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setAngle(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, double d) {
        cruiseEventLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CruiseEventLayerItemImpl_getAngle(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setPitch(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, double d) {
        cruiseEventLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CruiseEventLayerItemImpl_getPitch(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setMaxPitch(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, double d) {
        cruiseEventLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CruiseEventLayerItemImpl_getMaxPitch(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setDisplayScale(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, LayerScale layerScale) {
        cruiseEventLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CruiseEventLayerItemImpl_getDisplayScale(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setAnimation(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        cruiseEventLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setStyle__SWIG_0(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        cruiseEventLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setStyle__SWIG_1(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, String str) {
        cruiseEventLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_updateStyle__SWIG_0(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        cruiseEventLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_updateStyle__SWIG_1(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, LayerItemImpl layerItemImpl) {
        cruiseEventLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_addPoiFilter(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        cruiseEventLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_removePoiFilter(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        cruiseEventLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_onPaint(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        cruiseEventLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setParent(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        cruiseEventLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setBusinessType(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, int i) {
        cruiseEventLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CruiseEventLayerItemImpl_getBusinessType(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CruiseEventLayerItemImpl_getTypeIdName(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_clearStyle(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        cruiseEventLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setVisible3V(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Visible3V visible3V) {
        cruiseEventLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_getVisible3V(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Visible3V visible3V) {
        cruiseEventLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setBillboard(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, boolean z) {
        cruiseEventLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_getBillboard(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setPosition3D(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseEventLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setRotateCenter3D(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseEventLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_getRotateCenter3D(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseEventLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setPosition(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseEventLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_getPosition(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseEventLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setRotateCenter(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseEventLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_getNormalStyle(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseEventLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_getFocusStyle(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseEventLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setItemVisibleRegion(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, RectInt rectInt) {
        cruiseEventLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setItemIgnoreRegion(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseEventLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_getItemIgnoreRegion(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseEventLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setScale(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        cruiseEventLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_getScale(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, ScaleAttribute scaleAttribute) {
        cruiseEventLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setPointTypeCode(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, String str) {
        cruiseEventLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_CruiseEventLayerItemImpl_getPointTypeCode(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setScaleFactor(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, float[] fArr) {
        cruiseEventLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setRotateMode(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, @RotateMode.RotateMode1 int i) {
        cruiseEventLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_CruiseEventLayerItemImpl_addMarker(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return cruiseEventLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_clearAllMarkers(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        cruiseEventLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_CruiseEventLayerItemImpl_setForeshorteningCoef(CruiseEventLayerItemImpl cruiseEventLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        cruiseEventLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_CruiseEventLayerItemImpl_getForeshorteningCoef(CruiseEventLayerItemImpl cruiseEventLayerItemImpl) {
        return cruiseEventLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_resetOnVisible(GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z) {
        guideCameraLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_onVisible(GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z) {
        guideCameraLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_getOnVisible(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_applyOnVisible(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideCameraLayerItemImpl_getBound(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_getVisible(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideCameraLayerItemImpl_getPriority(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_isAreaCollision(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setAreaCollision(GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z) {
        guideCameraLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideCameraLayerItemImpl_getItemType(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_setID(GuideCameraLayerItemImpl guideCameraLayerItemImpl, String str) {
        return guideCameraLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideCameraLayerItemImpl_getID(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_setInfo(GuideCameraLayerItemImpl guideCameraLayerItemImpl, String str) {
        return guideCameraLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideCameraLayerItemImpl_getInfo(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setPriority(GuideCameraLayerItemImpl guideCameraLayerItemImpl, int i) {
        guideCameraLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setVisible(GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z) {
        guideCameraLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_getFocus(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setAlpha(GuideCameraLayerItemImpl guideCameraLayerItemImpl, double d) {
        guideCameraLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideCameraLayerItemImpl_getAlpha(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setAngle(GuideCameraLayerItemImpl guideCameraLayerItemImpl, double d) {
        guideCameraLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideCameraLayerItemImpl_getAngle(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setPitch(GuideCameraLayerItemImpl guideCameraLayerItemImpl, double d) {
        guideCameraLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideCameraLayerItemImpl_getPitch(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setMaxPitch(GuideCameraLayerItemImpl guideCameraLayerItemImpl, double d) {
        guideCameraLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideCameraLayerItemImpl_getMaxPitch(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setDisplayScale(GuideCameraLayerItemImpl guideCameraLayerItemImpl, LayerScale layerScale) {
        guideCameraLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideCameraLayerItemImpl_getDisplayScale(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setAnimation(GuideCameraLayerItemImpl guideCameraLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideCameraLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setStyle__SWIG_0(GuideCameraLayerItemImpl guideCameraLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideCameraLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setStyle__SWIG_1(GuideCameraLayerItemImpl guideCameraLayerItemImpl, String str) {
        guideCameraLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_updateStyle__SWIG_0(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_updateStyle__SWIG_1(GuideCameraLayerItemImpl guideCameraLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideCameraLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_addPoiFilter(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_removePoiFilter(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_onPaint(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setParent(GuideCameraLayerItemImpl guideCameraLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideCameraLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setBusinessType(GuideCameraLayerItemImpl guideCameraLayerItemImpl, int i) {
        guideCameraLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideCameraLayerItemImpl_getBusinessType(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideCameraLayerItemImpl_getTypeIdName(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_clearStyle(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setVisible3V(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Visible3V visible3V) {
        guideCameraLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_getVisible3V(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Visible3V visible3V) {
        guideCameraLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setBillboard(GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z) {
        guideCameraLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_getBillboard(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setPosition3D(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCameraLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setRotateCenter3D(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCameraLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_getRotateCenter3D(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCameraLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setPosition(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCameraLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_getPosition(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCameraLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setRotateCenter(GuideCameraLayerItemImpl guideCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCameraLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_getNormalStyle(GuideCameraLayerItemImpl guideCameraLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideCameraLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_getFocusStyle(GuideCameraLayerItemImpl guideCameraLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideCameraLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setItemVisibleRegion(GuideCameraLayerItemImpl guideCameraLayerItemImpl, RectInt rectInt) {
        guideCameraLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setItemIgnoreRegion(GuideCameraLayerItemImpl guideCameraLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideCameraLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_getItemIgnoreRegion(GuideCameraLayerItemImpl guideCameraLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideCameraLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setScale(GuideCameraLayerItemImpl guideCameraLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideCameraLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_getScale(GuideCameraLayerItemImpl guideCameraLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideCameraLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setPointTypeCode(GuideCameraLayerItemImpl guideCameraLayerItemImpl, String str) {
        guideCameraLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideCameraLayerItemImpl_getPointTypeCode(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setScaleFactor(GuideCameraLayerItemImpl guideCameraLayerItemImpl, float[] fArr) {
        guideCameraLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setRotateMode(GuideCameraLayerItemImpl guideCameraLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideCameraLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_addMarker(GuideCameraLayerItemImpl guideCameraLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideCameraLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_clearAllMarkers(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setForeshorteningCoef(GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideCameraLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideCameraLayerItemImpl_getForeshorteningCoef(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_setIdle(GuideCameraLayerItemImpl guideCameraLayerItemImpl, boolean z) {
        guideCameraLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_isIdle(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.isIdle();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_addIntersectArea(GuideCameraLayerItemImpl guideCameraLayerItemImpl, float f) {
        guideCameraLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_GuideCameraLayerItemImpl_getIntersectArea(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_resetIntersectArea(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_addIntersectAreaEx(GuideCameraLayerItemImpl guideCameraLayerItemImpl, float f) {
        guideCameraLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_GuideCameraLayerItemImpl_getIntersectAreaEx(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_GuideCameraLayerItemImpl_resetIntersectAreaEx(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        guideCameraLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_GuideCameraLayerItemImpl_checkShowFlag(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_GuideCameraLayerItemImpl_getQuadrantGroupId(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_GuideCameraLayerItemImpl_getQuadrantType(GuideCameraLayerItemImpl guideCameraLayerItemImpl) {
        return guideCameraLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_resetOnVisible(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, boolean z) {
        guideIntervalCameraLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_onVisible(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, boolean z) {
        guideIntervalCameraLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_getOnVisible(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_applyOnVisible(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideIntervalCameraLayerItemImpl_getBound(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_getVisible(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideIntervalCameraLayerItemImpl_getPriority(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_isAreaCollision(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setAreaCollision(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, boolean z) {
        guideIntervalCameraLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideIntervalCameraLayerItemImpl_getItemType(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_setID(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, String str) {
        return guideIntervalCameraLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideIntervalCameraLayerItemImpl_getID(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_setInfo(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, String str) {
        return guideIntervalCameraLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideIntervalCameraLayerItemImpl_getInfo(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setPriority(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, int i) {
        guideIntervalCameraLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setVisible(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, boolean z) {
        guideIntervalCameraLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_getFocus(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setAlpha(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, double d) {
        guideIntervalCameraLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideIntervalCameraLayerItemImpl_getAlpha(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setAngle(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, double d) {
        guideIntervalCameraLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideIntervalCameraLayerItemImpl_getAngle(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setPitch(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, double d) {
        guideIntervalCameraLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideIntervalCameraLayerItemImpl_getPitch(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setMaxPitch(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, double d) {
        guideIntervalCameraLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideIntervalCameraLayerItemImpl_getMaxPitch(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setDisplayScale(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, LayerScale layerScale) {
        guideIntervalCameraLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideIntervalCameraLayerItemImpl_getDisplayScale(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setAnimation(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideIntervalCameraLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setStyle__SWIG_0(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideIntervalCameraLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setStyle__SWIG_1(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, String str) {
        guideIntervalCameraLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_updateStyle__SWIG_0(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_updateStyle__SWIG_1(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideIntervalCameraLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_addPoiFilter(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_removePoiFilter(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_onPaint(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setParent(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideIntervalCameraLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setBusinessType(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, int i) {
        guideIntervalCameraLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideIntervalCameraLayerItemImpl_getBusinessType(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideIntervalCameraLayerItemImpl_getTypeIdName(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_clearStyle(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setVisible3V(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Visible3V visible3V) {
        guideIntervalCameraLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_getVisible3V(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Visible3V visible3V) {
        guideIntervalCameraLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setBillboard(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, boolean z) {
        guideIntervalCameraLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_getBillboard(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setPosition3D(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideIntervalCameraLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setRotateCenter3D(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideIntervalCameraLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_getRotateCenter3D(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideIntervalCameraLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setPosition(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideIntervalCameraLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_getPosition(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideIntervalCameraLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setRotateCenter(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideIntervalCameraLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_getNormalStyle(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideIntervalCameraLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_getFocusStyle(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideIntervalCameraLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setItemVisibleRegion(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, RectInt rectInt) {
        guideIntervalCameraLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setItemIgnoreRegion(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideIntervalCameraLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_getItemIgnoreRegion(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideIntervalCameraLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setScale(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideIntervalCameraLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_getScale(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideIntervalCameraLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setPointTypeCode(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, String str) {
        guideIntervalCameraLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideIntervalCameraLayerItemImpl_getPointTypeCode(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setScaleFactor(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, float[] fArr) {
        guideIntervalCameraLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setRotateMode(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideIntervalCameraLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_addMarker(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideIntervalCameraLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_clearAllMarkers(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setForeshorteningCoef(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideIntervalCameraLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideIntervalCameraLayerItemImpl_getForeshorteningCoef(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_setIdle(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, boolean z) {
        guideIntervalCameraLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_isIdle(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.isIdle();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_addIntersectArea(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, float f) {
        guideIntervalCameraLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_GuideIntervalCameraLayerItemImpl_getIntersectArea(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_resetIntersectArea(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_addIntersectAreaEx(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, float f) {
        guideIntervalCameraLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_GuideIntervalCameraLayerItemImpl_getIntersectAreaEx(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_GuideIntervalCameraLayerItemImpl_resetIntersectAreaEx(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        guideIntervalCameraLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_GuideIntervalCameraLayerItemImpl_checkShowFlag(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_GuideIntervalCameraLayerItemImpl_getQuadrantGroupId(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_GuideIntervalCameraLayerItemImpl_getQuadrantType(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        return guideIntervalCameraLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_resetOnVisible(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, boolean z) {
        guideTrafficLightLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_onVisible(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, boolean z) {
        guideTrafficLightLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_getOnVisible(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_applyOnVisible(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideTrafficLightLayerItemImpl_getBound(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_getVisible(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideTrafficLightLayerItemImpl_getPriority(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_isAreaCollision(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setAreaCollision(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, boolean z) {
        guideTrafficLightLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideTrafficLightLayerItemImpl_getItemType(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_setID(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, String str) {
        return guideTrafficLightLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideTrafficLightLayerItemImpl_getID(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_setInfo(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, String str) {
        return guideTrafficLightLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideTrafficLightLayerItemImpl_getInfo(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setPriority(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, int i) {
        guideTrafficLightLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setVisible(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, boolean z) {
        guideTrafficLightLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_getFocus(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setAlpha(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, double d) {
        guideTrafficLightLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideTrafficLightLayerItemImpl_getAlpha(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setAngle(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, double d) {
        guideTrafficLightLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideTrafficLightLayerItemImpl_getAngle(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setPitch(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, double d) {
        guideTrafficLightLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideTrafficLightLayerItemImpl_getPitch(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setMaxPitch(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, double d) {
        guideTrafficLightLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideTrafficLightLayerItemImpl_getMaxPitch(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setDisplayScale(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, LayerScale layerScale) {
        guideTrafficLightLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideTrafficLightLayerItemImpl_getDisplayScale(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setAnimation(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideTrafficLightLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setStyle__SWIG_0(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideTrafficLightLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setStyle__SWIG_1(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, String str) {
        guideTrafficLightLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_updateStyle__SWIG_0(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_updateStyle__SWIG_1(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideTrafficLightLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_addPoiFilter(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_removePoiFilter(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_onPaint(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setParent(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideTrafficLightLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setBusinessType(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, int i) {
        guideTrafficLightLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideTrafficLightLayerItemImpl_getBusinessType(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideTrafficLightLayerItemImpl_getTypeIdName(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_clearStyle(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setVisible3V(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Visible3V visible3V) {
        guideTrafficLightLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_getVisible3V(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Visible3V visible3V) {
        guideTrafficLightLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setBillboard(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, boolean z) {
        guideTrafficLightLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_getBillboard(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setPosition3D(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficLightLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setRotateCenter3D(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficLightLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_getRotateCenter3D(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficLightLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setPosition(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficLightLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_getPosition(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficLightLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setRotateCenter(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideTrafficLightLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_getNormalStyle(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideTrafficLightLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_getFocusStyle(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideTrafficLightLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setItemVisibleRegion(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, RectInt rectInt) {
        guideTrafficLightLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setItemIgnoreRegion(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideTrafficLightLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_getItemIgnoreRegion(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideTrafficLightLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setScale(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideTrafficLightLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_getScale(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideTrafficLightLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setPointTypeCode(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, String str) {
        guideTrafficLightLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideTrafficLightLayerItemImpl_getPointTypeCode(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setScaleFactor(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, float[] fArr) {
        guideTrafficLightLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setRotateMode(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideTrafficLightLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_addMarker(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideTrafficLightLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_clearAllMarkers(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setForeshorteningCoef(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideTrafficLightLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideTrafficLightLayerItemImpl_getForeshorteningCoef(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_setIdle(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, boolean z) {
        guideTrafficLightLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_isIdle(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.isIdle();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_addIntersectArea(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, float f) {
        guideTrafficLightLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_GuideTrafficLightLayerItemImpl_getIntersectArea(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_resetIntersectArea(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_addIntersectAreaEx(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, float f) {
        guideTrafficLightLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_GuideTrafficLightLayerItemImpl_getIntersectAreaEx(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_GuideTrafficLightLayerItemImpl_resetIntersectAreaEx(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        guideTrafficLightLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_GuideTrafficLightLayerItemImpl_checkShowFlag(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_GuideTrafficLightLayerItemImpl_getQuadrantGroupId(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_GuideTrafficLightLayerItemImpl_getQuadrantType(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        return guideTrafficLightLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_resetOnVisible(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, boolean z) {
        cruiseCongestionPromptLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_onVisible(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, boolean z) {
        cruiseCongestionPromptLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_getOnVisible(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_applyOnVisible(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_CruiseCongestionPromptLayerItemImpl_getBound(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_getVisible(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getVisible();
    }

    public static int SwigDirector_CruiseCongestionPromptLayerItemImpl_getPriority(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_isAreaCollision(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setAreaCollision(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, boolean z) {
        cruiseCongestionPromptLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_CruiseCongestionPromptLayerItemImpl_getItemType(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_setID(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, String str) {
        return cruiseCongestionPromptLayerItemImpl.setID(str);
    }

    public static String SwigDirector_CruiseCongestionPromptLayerItemImpl_getID(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getID();
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_setInfo(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, String str) {
        return cruiseCongestionPromptLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_CruiseCongestionPromptLayerItemImpl_getInfo(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getInfo();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setPriority(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, int i) {
        cruiseCongestionPromptLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setVisible(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, boolean z) {
        cruiseCongestionPromptLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_getFocus(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getFocus();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setAlpha(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, double d) {
        cruiseCongestionPromptLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_CruiseCongestionPromptLayerItemImpl_getAlpha(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setAngle(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, double d) {
        cruiseCongestionPromptLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_CruiseCongestionPromptLayerItemImpl_getAngle(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getAngle();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setPitch(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, double d) {
        cruiseCongestionPromptLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_CruiseCongestionPromptLayerItemImpl_getPitch(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getPitch();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setMaxPitch(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, double d) {
        cruiseCongestionPromptLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_CruiseCongestionPromptLayerItemImpl_getMaxPitch(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setDisplayScale(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, LayerScale layerScale) {
        cruiseCongestionPromptLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_CruiseCongestionPromptLayerItemImpl_getDisplayScale(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setAnimation(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        cruiseCongestionPromptLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setStyle__SWIG_0(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        cruiseCongestionPromptLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setStyle__SWIG_1(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, String str) {
        cruiseCongestionPromptLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_updateStyle__SWIG_0(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_updateStyle__SWIG_1(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, LayerItemImpl layerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_addPoiFilter(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_removePoiFilter(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_onPaint(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.onPaint();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setParent(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        cruiseCongestionPromptLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setBusinessType(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, int i) {
        cruiseCongestionPromptLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_CruiseCongestionPromptLayerItemImpl_getBusinessType(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_CruiseCongestionPromptLayerItemImpl_getTypeIdName(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_clearStyle(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setVisible3V(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Visible3V visible3V) {
        cruiseCongestionPromptLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_getVisible3V(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Visible3V visible3V) {
        cruiseCongestionPromptLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setBillboard(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, boolean z) {
        cruiseCongestionPromptLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_getBillboard(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setPosition3D(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionPromptLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setRotateCenter3D(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionPromptLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_getRotateCenter3D(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionPromptLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setPosition(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionPromptLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_getPosition(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionPromptLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setRotateCenter(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, Coord3DDouble coord3DDouble) {
        cruiseCongestionPromptLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_getNormalStyle(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseCongestionPromptLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_getFocusStyle(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        cruiseCongestionPromptLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setItemVisibleRegion(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, RectInt rectInt) {
        cruiseCongestionPromptLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setItemIgnoreRegion(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseCongestionPromptLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_getItemIgnoreRegion(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        cruiseCongestionPromptLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setScale(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        cruiseCongestionPromptLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_getScale(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, ScaleAttribute scaleAttribute) {
        cruiseCongestionPromptLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setPointTypeCode(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, String str) {
        cruiseCongestionPromptLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_CruiseCongestionPromptLayerItemImpl_getPointTypeCode(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setScaleFactor(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, float[] fArr) {
        cruiseCongestionPromptLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setRotateMode(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, @RotateMode.RotateMode1 int i) {
        cruiseCongestionPromptLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_addMarker(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return cruiseCongestionPromptLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_clearAllMarkers(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setForeshorteningCoef(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        cruiseCongestionPromptLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_CruiseCongestionPromptLayerItemImpl_getForeshorteningCoef(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_setIdle(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, boolean z) {
        cruiseCongestionPromptLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_isIdle(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.isIdle();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_addIntersectArea(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, float f) {
        cruiseCongestionPromptLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_CruiseCongestionPromptLayerItemImpl_getIntersectArea(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_resetIntersectArea(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_addIntersectAreaEx(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl, float f) {
        cruiseCongestionPromptLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_CruiseCongestionPromptLayerItemImpl_getIntersectAreaEx(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_CruiseCongestionPromptLayerItemImpl_resetIntersectAreaEx(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        cruiseCongestionPromptLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_CruiseCongestionPromptLayerItemImpl_checkShowFlag(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_CruiseCongestionPromptLayerItemImpl_getQuadrantGroupId(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_CruiseCongestionPromptLayerItemImpl_getQuadrantType(CruiseCongestionPromptLayerItemImpl cruiseCongestionPromptLayerItemImpl) {
        return cruiseCongestionPromptLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_resetOnVisible(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, boolean z) {
        localTrafficEventPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_onVisible(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, boolean z) {
        localTrafficEventPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_getOnVisible(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_applyOnVisible(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        localTrafficEventPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LocalTrafficEventPointLayerItemImpl_getBound(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_getVisible(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LocalTrafficEventPointLayerItemImpl_getPriority(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_isAreaCollision(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setAreaCollision(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, boolean z) {
        localTrafficEventPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LocalTrafficEventPointLayerItemImpl_getItemType(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_setID(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, String str) {
        return localTrafficEventPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LocalTrafficEventPointLayerItemImpl_getID(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_setInfo(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, String str) {
        return localTrafficEventPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LocalTrafficEventPointLayerItemImpl_getInfo(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setPriority(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, int i) {
        localTrafficEventPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setVisible(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, boolean z) {
        localTrafficEventPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_getFocus(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setAlpha(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, double d) {
        localTrafficEventPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LocalTrafficEventPointLayerItemImpl_getAlpha(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setAngle(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, double d) {
        localTrafficEventPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LocalTrafficEventPointLayerItemImpl_getAngle(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setPitch(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, double d) {
        localTrafficEventPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LocalTrafficEventPointLayerItemImpl_getPitch(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setMaxPitch(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, double d) {
        localTrafficEventPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LocalTrafficEventPointLayerItemImpl_getMaxPitch(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setDisplayScale(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, LayerScale layerScale) {
        localTrafficEventPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LocalTrafficEventPointLayerItemImpl_getDisplayScale(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setAnimation(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        localTrafficEventPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setStyle__SWIG_0(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        localTrafficEventPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setStyle__SWIG_1(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, String str) {
        localTrafficEventPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_updateStyle__SWIG_0(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        localTrafficEventPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_updateStyle__SWIG_1(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        localTrafficEventPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_addPoiFilter(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        localTrafficEventPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_removePoiFilter(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        localTrafficEventPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_onPaint(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        localTrafficEventPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setParent(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        localTrafficEventPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setBusinessType(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, int i) {
        localTrafficEventPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LocalTrafficEventPointLayerItemImpl_getBusinessType(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_LocalTrafficEventPointLayerItemImpl_getTypeIdName(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_clearStyle(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        localTrafficEventPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setVisible3V(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Visible3V visible3V) {
        localTrafficEventPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_getVisible3V(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Visible3V visible3V) {
        localTrafficEventPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setBillboard(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, boolean z) {
        localTrafficEventPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_getBillboard(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setPosition3D(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        localTrafficEventPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setRotateCenter3D(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        localTrafficEventPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_getRotateCenter3D(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        localTrafficEventPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setPosition(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        localTrafficEventPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_getPosition(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        localTrafficEventPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setRotateCenter(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        localTrafficEventPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_getNormalStyle(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        localTrafficEventPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_getFocusStyle(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        localTrafficEventPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setItemVisibleRegion(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, RectInt rectInt) {
        localTrafficEventPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setItemIgnoreRegion(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        localTrafficEventPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_getItemIgnoreRegion(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        localTrafficEventPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setScale(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        localTrafficEventPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_getScale(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        localTrafficEventPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setPointTypeCode(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, String str) {
        localTrafficEventPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_LocalTrafficEventPointLayerItemImpl_getPointTypeCode(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setScaleFactor(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, float[] fArr) {
        localTrafficEventPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setRotateMode(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        localTrafficEventPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_LocalTrafficEventPointLayerItemImpl_addMarker(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return localTrafficEventPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_clearAllMarkers(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        localTrafficEventPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_LocalTrafficEventPointLayerItemImpl_setForeshorteningCoef(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        localTrafficEventPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_LocalTrafficEventPointLayerItemImpl_getForeshorteningCoef(LocalTrafficEventPointLayerItemImpl localTrafficEventPointLayerItemImpl) {
        return localTrafficEventPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_resetOnVisible(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, boolean z) {
        localTrafficEventLineLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_onVisible(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, boolean z) {
        localTrafficEventLineLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_LocalTrafficEventLineLayerItemImpl_getOnVisible(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_applyOnVisible(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        localTrafficEventLineLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_LocalTrafficEventLineLayerItemImpl_getBound(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_LocalTrafficEventLineLayerItemImpl_getVisible(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getVisible();
    }

    public static int SwigDirector_LocalTrafficEventLineLayerItemImpl_getPriority(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_LocalTrafficEventLineLayerItemImpl_isAreaCollision(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setAreaCollision(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, boolean z) {
        localTrafficEventLineLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_LocalTrafficEventLineLayerItemImpl_getItemType(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_LocalTrafficEventLineLayerItemImpl_setID(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, String str) {
        return localTrafficEventLineLayerItemImpl.setID(str);
    }

    public static String SwigDirector_LocalTrafficEventLineLayerItemImpl_getID(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getID();
    }

    public static boolean SwigDirector_LocalTrafficEventLineLayerItemImpl_setInfo(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, String str) {
        return localTrafficEventLineLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_LocalTrafficEventLineLayerItemImpl_getInfo(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getInfo();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setPriority(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, int i) {
        localTrafficEventLineLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setVisible(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, boolean z) {
        localTrafficEventLineLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_LocalTrafficEventLineLayerItemImpl_getFocus(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getFocus();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setAlpha(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, double d) {
        localTrafficEventLineLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_LocalTrafficEventLineLayerItemImpl_getAlpha(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setAngle(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, double d) {
        localTrafficEventLineLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_LocalTrafficEventLineLayerItemImpl_getAngle(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getAngle();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setPitch(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, double d) {
        localTrafficEventLineLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_LocalTrafficEventLineLayerItemImpl_getPitch(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getPitch();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setMaxPitch(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, double d) {
        localTrafficEventLineLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_LocalTrafficEventLineLayerItemImpl_getMaxPitch(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setDisplayScale(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, LayerScale layerScale) {
        localTrafficEventLineLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_LocalTrafficEventLineLayerItemImpl_getDisplayScale(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setAnimation(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        localTrafficEventLineLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setStyle__SWIG_0(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        localTrafficEventLineLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setStyle__SWIG_1(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, String str) {
        localTrafficEventLineLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_updateStyle__SWIG_0(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        localTrafficEventLineLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_updateStyle__SWIG_1(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, LayerItemImpl layerItemImpl) {
        localTrafficEventLineLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_addPoiFilter(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        localTrafficEventLineLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_removePoiFilter(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        localTrafficEventLineLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_onPaint(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        localTrafficEventLineLayerItemImpl.onPaint();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setParent(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        localTrafficEventLineLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setBusinessType(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, int i) {
        localTrafficEventLineLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_LocalTrafficEventLineLayerItemImpl_getBusinessType(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_LocalTrafficEventLineLayerItemImpl_getTypeIdName(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        return localTrafficEventLineLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_clearStyle(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl) {
        localTrafficEventLineLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setPoints(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        localTrafficEventLineLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setColor(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, long j, long j2) {
        localTrafficEventLineLayerItemImpl.setColor(j, j2);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_setWidth(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, int i, int i2) {
        localTrafficEventLineLayerItemImpl.setWidth(i, i2);
    }

    public static void SwigDirector_LocalTrafficEventLineLayerItemImpl_getStyle(LocalTrafficEventLineLayerItemImpl localTrafficEventLineLayerItemImpl, LineLayerItemStyle lineLayerItemStyle) {
        localTrafficEventLineLayerItemImpl.getStyle(lineLayerItemStyle);
    }

    public static boolean SwigDirector_DynamicLevelCustomCalculatorImpl_calculateCruiseDynamicLevel(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        return dynamicLevelCustomCalculatorImpl.calculateCruiseDynamicLevel(i, dynamicLevelCalcResult);
    }

    public static boolean SwigDirector_DynamicLevelCustomCalculatorImpl_calculateGuide2DNorthUpDynamicLevel(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        return dynamicLevelCustomCalculatorImpl.calculateGuide2DNorthUpDynamicLevel(i, dynamicLevelCalcResult);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_resetOnVisible(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, boolean z) {
        guideCongestionLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_onVisible(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, boolean z) {
        guideCongestionLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_getOnVisible(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_applyOnVisible(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideCongestionLayerItemImpl_getBound(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_getVisible(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideCongestionLayerItemImpl_getPriority(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_isAreaCollision(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setAreaCollision(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, boolean z) {
        guideCongestionLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideCongestionLayerItemImpl_getItemType(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_setID(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, String str) {
        return guideCongestionLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideCongestionLayerItemImpl_getID(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_setInfo(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, String str) {
        return guideCongestionLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideCongestionLayerItemImpl_getInfo(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setPriority(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, int i) {
        guideCongestionLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setVisible(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, boolean z) {
        guideCongestionLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_getFocus(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setAlpha(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, double d) {
        guideCongestionLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideCongestionLayerItemImpl_getAlpha(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setAngle(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, double d) {
        guideCongestionLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideCongestionLayerItemImpl_getAngle(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setPitch(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, double d) {
        guideCongestionLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideCongestionLayerItemImpl_getPitch(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setMaxPitch(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, double d) {
        guideCongestionLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideCongestionLayerItemImpl_getMaxPitch(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setDisplayScale(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, LayerScale layerScale) {
        guideCongestionLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideCongestionLayerItemImpl_getDisplayScale(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setAnimation(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideCongestionLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setStyle__SWIG_0(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideCongestionLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setStyle__SWIG_1(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, String str) {
        guideCongestionLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_updateStyle__SWIG_0(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_updateStyle__SWIG_1(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideCongestionLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_addPoiFilter(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_removePoiFilter(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_onPaint(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setParent(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideCongestionLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setBusinessType(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, int i) {
        guideCongestionLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideCongestionLayerItemImpl_getBusinessType(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideCongestionLayerItemImpl_getTypeIdName(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_clearStyle(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setVisible3V(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Visible3V visible3V) {
        guideCongestionLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_getVisible3V(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Visible3V visible3V) {
        guideCongestionLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setBillboard(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, boolean z) {
        guideCongestionLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_getBillboard(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setPosition3D(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCongestionLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setRotateCenter3D(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCongestionLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_getRotateCenter3D(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCongestionLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setPosition(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCongestionLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_getPosition(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCongestionLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setRotateCenter(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideCongestionLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_getNormalStyle(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideCongestionLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_getFocusStyle(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideCongestionLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setItemVisibleRegion(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, RectInt rectInt) {
        guideCongestionLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setItemIgnoreRegion(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideCongestionLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_getItemIgnoreRegion(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideCongestionLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setScale(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideCongestionLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_getScale(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideCongestionLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setPointTypeCode(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, String str) {
        guideCongestionLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideCongestionLayerItemImpl_getPointTypeCode(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setScaleFactor(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, float[] fArr) {
        guideCongestionLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setRotateMode(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideCongestionLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_addMarker(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideCongestionLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_clearAllMarkers(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setForeshorteningCoef(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideCongestionLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideCongestionLayerItemImpl_getForeshorteningCoef(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_setIdle(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, boolean z) {
        guideCongestionLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_isIdle(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.isIdle();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_addIntersectArea(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, float f) {
        guideCongestionLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_GuideCongestionLayerItemImpl_getIntersectArea(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_resetIntersectArea(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_addIntersectAreaEx(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl, float f) {
        guideCongestionLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_GuideCongestionLayerItemImpl_getIntersectAreaEx(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_GuideCongestionLayerItemImpl_resetIntersectAreaEx(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        guideCongestionLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_GuideCongestionLayerItemImpl_checkShowFlag(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_GuideCongestionLayerItemImpl_getQuadrantGroupId(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_GuideCongestionLayerItemImpl_getQuadrantType(GuideCongestionLayerItemImpl guideCongestionLayerItemImpl) {
        return guideCongestionLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_resetOnVisible(RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z) {
        routeBlockLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_onVisible(RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z) {
        routeBlockLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_getOnVisible(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_applyOnVisible(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        routeBlockLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteBlockLayerItemImpl_getBound(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_getVisible(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteBlockLayerItemImpl_getPriority(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_isAreaCollision(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setAreaCollision(RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z) {
        routeBlockLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteBlockLayerItemImpl_getItemType(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_setID(RouteBlockLayerItemImpl routeBlockLayerItemImpl, String str) {
        return routeBlockLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteBlockLayerItemImpl_getID(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_setInfo(RouteBlockLayerItemImpl routeBlockLayerItemImpl, String str) {
        return routeBlockLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteBlockLayerItemImpl_getInfo(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setPriority(RouteBlockLayerItemImpl routeBlockLayerItemImpl, int i) {
        routeBlockLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setVisible(RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z) {
        routeBlockLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_getFocus(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setAlpha(RouteBlockLayerItemImpl routeBlockLayerItemImpl, double d) {
        routeBlockLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteBlockLayerItemImpl_getAlpha(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setAngle(RouteBlockLayerItemImpl routeBlockLayerItemImpl, double d) {
        routeBlockLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteBlockLayerItemImpl_getAngle(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setPitch(RouteBlockLayerItemImpl routeBlockLayerItemImpl, double d) {
        routeBlockLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteBlockLayerItemImpl_getPitch(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setMaxPitch(RouteBlockLayerItemImpl routeBlockLayerItemImpl, double d) {
        routeBlockLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteBlockLayerItemImpl_getMaxPitch(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setDisplayScale(RouteBlockLayerItemImpl routeBlockLayerItemImpl, LayerScale layerScale) {
        routeBlockLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteBlockLayerItemImpl_getDisplayScale(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setAnimation(RouteBlockLayerItemImpl routeBlockLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeBlockLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setStyle__SWIG_0(RouteBlockLayerItemImpl routeBlockLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeBlockLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setStyle__SWIG_1(RouteBlockLayerItemImpl routeBlockLayerItemImpl, String str) {
        routeBlockLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_updateStyle__SWIG_0(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        routeBlockLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_updateStyle__SWIG_1(RouteBlockLayerItemImpl routeBlockLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeBlockLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_addPoiFilter(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        routeBlockLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_removePoiFilter(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        routeBlockLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_onPaint(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        routeBlockLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setParent(RouteBlockLayerItemImpl routeBlockLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeBlockLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setBusinessType(RouteBlockLayerItemImpl routeBlockLayerItemImpl, int i) {
        routeBlockLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteBlockLayerItemImpl_getBusinessType(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteBlockLayerItemImpl_getTypeIdName(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_clearStyle(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        routeBlockLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setVisible3V(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Visible3V visible3V) {
        routeBlockLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_getVisible3V(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Visible3V visible3V) {
        routeBlockLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setBillboard(RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z) {
        routeBlockLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_getBillboard(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setPosition3D(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeBlockLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setRotateCenter3D(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeBlockLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_getRotateCenter3D(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeBlockLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setPosition(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeBlockLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_getPosition(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeBlockLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setRotateCenter(RouteBlockLayerItemImpl routeBlockLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeBlockLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_getNormalStyle(RouteBlockLayerItemImpl routeBlockLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeBlockLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_getFocusStyle(RouteBlockLayerItemImpl routeBlockLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeBlockLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setItemVisibleRegion(RouteBlockLayerItemImpl routeBlockLayerItemImpl, RectInt rectInt) {
        routeBlockLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setItemIgnoreRegion(RouteBlockLayerItemImpl routeBlockLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeBlockLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_getItemIgnoreRegion(RouteBlockLayerItemImpl routeBlockLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeBlockLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setScale(RouteBlockLayerItemImpl routeBlockLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeBlockLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_getScale(RouteBlockLayerItemImpl routeBlockLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeBlockLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setPointTypeCode(RouteBlockLayerItemImpl routeBlockLayerItemImpl, String str) {
        routeBlockLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteBlockLayerItemImpl_getPointTypeCode(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setScaleFactor(RouteBlockLayerItemImpl routeBlockLayerItemImpl, float[] fArr) {
        routeBlockLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setRotateMode(RouteBlockLayerItemImpl routeBlockLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeBlockLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteBlockLayerItemImpl_addMarker(RouteBlockLayerItemImpl routeBlockLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeBlockLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_clearAllMarkers(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        routeBlockLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteBlockLayerItemImpl_setForeshorteningCoef(RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeBlockLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteBlockLayerItemImpl_getForeshorteningCoef(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        return routeBlockLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_resetOnVisible(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z) {
        routeJamPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_onVisible(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z) {
        routeJamPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_getOnVisible(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_applyOnVisible(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        routeJamPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteJamPointLayerItemImpl_getBound(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_getVisible(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteJamPointLayerItemImpl_getPriority(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_isAreaCollision(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setAreaCollision(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z) {
        routeJamPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteJamPointLayerItemImpl_getItemType(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_setID(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, String str) {
        return routeJamPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteJamPointLayerItemImpl_getID(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_setInfo(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, String str) {
        return routeJamPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteJamPointLayerItemImpl_getInfo(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setPriority(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, int i) {
        routeJamPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setVisible(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z) {
        routeJamPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_getFocus(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setAlpha(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, double d) {
        routeJamPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteJamPointLayerItemImpl_getAlpha(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setAngle(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, double d) {
        routeJamPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteJamPointLayerItemImpl_getAngle(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setPitch(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, double d) {
        routeJamPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteJamPointLayerItemImpl_getPitch(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setMaxPitch(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, double d) {
        routeJamPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteJamPointLayerItemImpl_getMaxPitch(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setDisplayScale(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, LayerScale layerScale) {
        routeJamPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteJamPointLayerItemImpl_getDisplayScale(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setAnimation(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeJamPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setStyle__SWIG_0(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeJamPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setStyle__SWIG_1(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, String str) {
        routeJamPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_updateStyle__SWIG_0(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        routeJamPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_updateStyle__SWIG_1(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeJamPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_addPoiFilter(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        routeJamPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_removePoiFilter(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        routeJamPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_onPaint(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        routeJamPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setParent(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeJamPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setBusinessType(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, int i) {
        routeJamPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteJamPointLayerItemImpl_getBusinessType(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteJamPointLayerItemImpl_getTypeIdName(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_clearStyle(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        routeJamPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setVisible3V(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Visible3V visible3V) {
        routeJamPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_getVisible3V(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Visible3V visible3V) {
        routeJamPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setBillboard(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z) {
        routeJamPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_getBillboard(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setPosition3D(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeJamPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setRotateCenter3D(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeJamPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_getRotateCenter3D(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeJamPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setPosition(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeJamPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_getPosition(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeJamPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setRotateCenter(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeJamPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_getNormalStyle(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeJamPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_getFocusStyle(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeJamPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setItemVisibleRegion(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, RectInt rectInt) {
        routeJamPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setItemIgnoreRegion(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeJamPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_getItemIgnoreRegion(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeJamPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setScale(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeJamPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_getScale(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeJamPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setPointTypeCode(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, String str) {
        routeJamPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteJamPointLayerItemImpl_getPointTypeCode(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setScaleFactor(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, float[] fArr) {
        routeJamPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setRotateMode(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeJamPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteJamPointLayerItemImpl_addMarker(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeJamPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_clearAllMarkers(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        routeJamPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteJamPointLayerItemImpl_setForeshorteningCoef(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeJamPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteJamPointLayerItemImpl_getForeshorteningCoef(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        return routeJamPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_resetOnVisible(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, boolean z) {
        routeJamLineLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_onVisible(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, boolean z) {
        routeJamLineLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteJamLineLayerItemImpl_getOnVisible(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_applyOnVisible(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        routeJamLineLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteJamLineLayerItemImpl_getBound(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteJamLineLayerItemImpl_getVisible(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteJamLineLayerItemImpl_getPriority(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteJamLineLayerItemImpl_isAreaCollision(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setAreaCollision(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, boolean z) {
        routeJamLineLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteJamLineLayerItemImpl_getItemType(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteJamLineLayerItemImpl_setID(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, String str) {
        return routeJamLineLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteJamLineLayerItemImpl_getID(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteJamLineLayerItemImpl_setInfo(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, String str) {
        return routeJamLineLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteJamLineLayerItemImpl_getInfo(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setPriority(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, int i) {
        routeJamLineLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setVisible(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, boolean z) {
        routeJamLineLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteJamLineLayerItemImpl_getFocus(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setAlpha(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, double d) {
        routeJamLineLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteJamLineLayerItemImpl_getAlpha(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setAngle(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, double d) {
        routeJamLineLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteJamLineLayerItemImpl_getAngle(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setPitch(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, double d) {
        routeJamLineLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteJamLineLayerItemImpl_getPitch(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setMaxPitch(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, double d) {
        routeJamLineLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteJamLineLayerItemImpl_getMaxPitch(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setDisplayScale(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, LayerScale layerScale) {
        routeJamLineLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteJamLineLayerItemImpl_getDisplayScale(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setAnimation(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeJamLineLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setStyle__SWIG_0(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeJamLineLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setStyle__SWIG_1(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, String str) {
        routeJamLineLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_updateStyle__SWIG_0(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        routeJamLineLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_updateStyle__SWIG_1(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeJamLineLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_addPoiFilter(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        routeJamLineLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_removePoiFilter(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        routeJamLineLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_onPaint(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        routeJamLineLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setParent(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeJamLineLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setBusinessType(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, int i) {
        routeJamLineLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteJamLineLayerItemImpl_getBusinessType(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteJamLineLayerItemImpl_getTypeIdName(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        return routeJamLineLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_clearStyle(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        routeJamLineLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setPoints(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, ArrayList<Coord3DDouble> arrayList) {
        routeJamLineLayerItemImpl.setPoints(arrayList);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setColor(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, long j, long j2) {
        routeJamLineLayerItemImpl.setColor(j, j2);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_setWidth(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, int i, int i2) {
        routeJamLineLayerItemImpl.setWidth(i, i2);
    }

    public static void SwigDirector_RouteJamLineLayerItemImpl_getStyle(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, LineLayerItemStyle lineLayerItemStyle) {
        routeJamLineLayerItemImpl.getStyle(lineLayerItemStyle);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_resetOnVisible(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, boolean z) {
        routeForbiddenLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_onVisible(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, boolean z) {
        routeForbiddenLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_getOnVisible(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_applyOnVisible(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        routeForbiddenLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteForbiddenLayerItemImpl_getBound(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_getVisible(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteForbiddenLayerItemImpl_getPriority(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_isAreaCollision(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setAreaCollision(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, boolean z) {
        routeForbiddenLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteForbiddenLayerItemImpl_getItemType(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_setID(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, String str) {
        return routeForbiddenLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteForbiddenLayerItemImpl_getID(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_setInfo(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, String str) {
        return routeForbiddenLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteForbiddenLayerItemImpl_getInfo(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setPriority(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, int i) {
        routeForbiddenLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setVisible(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, boolean z) {
        routeForbiddenLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_getFocus(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setAlpha(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, double d) {
        routeForbiddenLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteForbiddenLayerItemImpl_getAlpha(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setAngle(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, double d) {
        routeForbiddenLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteForbiddenLayerItemImpl_getAngle(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setPitch(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, double d) {
        routeForbiddenLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteForbiddenLayerItemImpl_getPitch(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setMaxPitch(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, double d) {
        routeForbiddenLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteForbiddenLayerItemImpl_getMaxPitch(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setDisplayScale(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, LayerScale layerScale) {
        routeForbiddenLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteForbiddenLayerItemImpl_getDisplayScale(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setAnimation(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeForbiddenLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setStyle__SWIG_0(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeForbiddenLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setStyle__SWIG_1(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, String str) {
        routeForbiddenLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_updateStyle__SWIG_0(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        routeForbiddenLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_updateStyle__SWIG_1(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeForbiddenLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_addPoiFilter(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        routeForbiddenLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_removePoiFilter(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        routeForbiddenLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_onPaint(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        routeForbiddenLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setParent(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeForbiddenLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setBusinessType(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, int i) {
        routeForbiddenLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteForbiddenLayerItemImpl_getBusinessType(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteForbiddenLayerItemImpl_getTypeIdName(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_clearStyle(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        routeForbiddenLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setVisible3V(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Visible3V visible3V) {
        routeForbiddenLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_getVisible3V(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Visible3V visible3V) {
        routeForbiddenLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setBillboard(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, boolean z) {
        routeForbiddenLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_getBillboard(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setPosition3D(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeForbiddenLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setRotateCenter3D(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeForbiddenLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_getRotateCenter3D(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeForbiddenLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setPosition(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeForbiddenLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_getPosition(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeForbiddenLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setRotateCenter(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeForbiddenLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_getNormalStyle(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeForbiddenLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_getFocusStyle(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeForbiddenLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setItemVisibleRegion(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, RectInt rectInt) {
        routeForbiddenLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setItemIgnoreRegion(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeForbiddenLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_getItemIgnoreRegion(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeForbiddenLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setScale(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeForbiddenLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_getScale(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeForbiddenLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setPointTypeCode(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, String str) {
        routeForbiddenLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteForbiddenLayerItemImpl_getPointTypeCode(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setScaleFactor(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, float[] fArr) {
        routeForbiddenLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setRotateMode(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeForbiddenLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteForbiddenLayerItemImpl_addMarker(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeForbiddenLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_clearAllMarkers(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        routeForbiddenLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteForbiddenLayerItemImpl_setForeshorteningCoef(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeForbiddenLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteForbiddenLayerItemImpl_getForeshorteningCoef(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        return routeForbiddenLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_resetOnVisible(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, boolean z) {
        guideETAEventLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_onVisible(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, boolean z) {
        guideETAEventLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_getOnVisible(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_applyOnVisible(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        guideETAEventLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideETAEventLayerItemImpl_getBound(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_getVisible(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideETAEventLayerItemImpl_getPriority(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_isAreaCollision(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setAreaCollision(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, boolean z) {
        guideETAEventLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideETAEventLayerItemImpl_getItemType(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_setID(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, String str) {
        return guideETAEventLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideETAEventLayerItemImpl_getID(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_setInfo(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, String str) {
        return guideETAEventLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideETAEventLayerItemImpl_getInfo(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setPriority(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, int i) {
        guideETAEventLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setVisible(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, boolean z) {
        guideETAEventLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_getFocus(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setAlpha(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, double d) {
        guideETAEventLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideETAEventLayerItemImpl_getAlpha(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setAngle(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, double d) {
        guideETAEventLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideETAEventLayerItemImpl_getAngle(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setPitch(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, double d) {
        guideETAEventLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideETAEventLayerItemImpl_getPitch(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setMaxPitch(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, double d) {
        guideETAEventLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideETAEventLayerItemImpl_getMaxPitch(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setDisplayScale(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, LayerScale layerScale) {
        guideETAEventLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideETAEventLayerItemImpl_getDisplayScale(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setAnimation(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideETAEventLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setStyle__SWIG_0(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideETAEventLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setStyle__SWIG_1(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, String str) {
        guideETAEventLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_updateStyle__SWIG_0(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        guideETAEventLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_updateStyle__SWIG_1(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideETAEventLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_addPoiFilter(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        guideETAEventLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_removePoiFilter(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        guideETAEventLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_onPaint(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        guideETAEventLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setParent(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideETAEventLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setBusinessType(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, int i) {
        guideETAEventLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideETAEventLayerItemImpl_getBusinessType(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideETAEventLayerItemImpl_getTypeIdName(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_clearStyle(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        guideETAEventLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setVisible3V(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Visible3V visible3V) {
        guideETAEventLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_getVisible3V(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Visible3V visible3V) {
        guideETAEventLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setBillboard(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, boolean z) {
        guideETAEventLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_getBillboard(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setPosition3D(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideETAEventLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setRotateCenter3D(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideETAEventLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_getRotateCenter3D(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideETAEventLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setPosition(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideETAEventLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_getPosition(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideETAEventLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setRotateCenter(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideETAEventLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_getNormalStyle(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideETAEventLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_getFocusStyle(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideETAEventLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setItemVisibleRegion(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, RectInt rectInt) {
        guideETAEventLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setItemIgnoreRegion(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideETAEventLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_getItemIgnoreRegion(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideETAEventLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setScale(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideETAEventLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_getScale(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideETAEventLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setPointTypeCode(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, String str) {
        guideETAEventLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideETAEventLayerItemImpl_getPointTypeCode(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setScaleFactor(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, float[] fArr) {
        guideETAEventLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setRotateMode(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideETAEventLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideETAEventLayerItemImpl_addMarker(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideETAEventLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_clearAllMarkers(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        guideETAEventLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideETAEventLayerItemImpl_setForeshorteningCoef(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideETAEventLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideETAEventLayerItemImpl_getForeshorteningCoef(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        return guideETAEventLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RoutePathPointItemImpl_resetOnVisible(RoutePathPointItemImpl routePathPointItemImpl, boolean z) {
        routePathPointItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RoutePathPointItemImpl_onVisible(RoutePathPointItemImpl routePathPointItemImpl, boolean z) {
        routePathPointItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_getOnVisible(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getOnVisible();
    }

    public static void SwigDirector_RoutePathPointItemImpl_applyOnVisible(RoutePathPointItemImpl routePathPointItemImpl) {
        routePathPointItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RoutePathPointItemImpl_getBound(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getBound();
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_getVisible(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getVisible();
    }

    public static int SwigDirector_RoutePathPointItemImpl_getPriority(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getPriority();
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_isAreaCollision(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setAreaCollision(RoutePathPointItemImpl routePathPointItemImpl, boolean z) {
        routePathPointItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RoutePathPointItemImpl_getItemType(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getItemType();
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_setID(RoutePathPointItemImpl routePathPointItemImpl, String str) {
        return routePathPointItemImpl.setID(str);
    }

    public static String SwigDirector_RoutePathPointItemImpl_getID(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getID();
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_setInfo(RoutePathPointItemImpl routePathPointItemImpl, String str) {
        return routePathPointItemImpl.setInfo(str);
    }

    public static String SwigDirector_RoutePathPointItemImpl_getInfo(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getInfo();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setPriority(RoutePathPointItemImpl routePathPointItemImpl, int i) {
        routePathPointItemImpl.setPriority(i);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setVisible(RoutePathPointItemImpl routePathPointItemImpl, boolean z) {
        routePathPointItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_getFocus(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getFocus();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setAlpha(RoutePathPointItemImpl routePathPointItemImpl, double d) {
        routePathPointItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RoutePathPointItemImpl_getAlpha(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getAlpha();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setAngle(RoutePathPointItemImpl routePathPointItemImpl, double d) {
        routePathPointItemImpl.setAngle(d);
    }

    public static double SwigDirector_RoutePathPointItemImpl_getAngle(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getAngle();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setPitch(RoutePathPointItemImpl routePathPointItemImpl, double d) {
        routePathPointItemImpl.setPitch(d);
    }

    public static double SwigDirector_RoutePathPointItemImpl_getPitch(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getPitch();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setMaxPitch(RoutePathPointItemImpl routePathPointItemImpl, double d) {
        routePathPointItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RoutePathPointItemImpl_getMaxPitch(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setDisplayScale(RoutePathPointItemImpl routePathPointItemImpl, LayerScale layerScale) {
        routePathPointItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RoutePathPointItemImpl_getDisplayScale(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setAnimation(RoutePathPointItemImpl routePathPointItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routePathPointItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setStyle__SWIG_0(RoutePathPointItemImpl routePathPointItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routePathPointItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setStyle__SWIG_1(RoutePathPointItemImpl routePathPointItemImpl, String str) {
        routePathPointItemImpl.setStyle(str);
    }

    public static void SwigDirector_RoutePathPointItemImpl_updateStyle__SWIG_0(RoutePathPointItemImpl routePathPointItemImpl) {
        routePathPointItemImpl.updateStyle();
    }

    public static void SwigDirector_RoutePathPointItemImpl_updateStyle__SWIG_1(RoutePathPointItemImpl routePathPointItemImpl, LayerItemImpl layerItemImpl) {
        routePathPointItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RoutePathPointItemImpl_addPoiFilter(RoutePathPointItemImpl routePathPointItemImpl) {
        routePathPointItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RoutePathPointItemImpl_removePoiFilter(RoutePathPointItemImpl routePathPointItemImpl) {
        routePathPointItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RoutePathPointItemImpl_onPaint(RoutePathPointItemImpl routePathPointItemImpl) {
        routePathPointItemImpl.onPaint();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setParent(RoutePathPointItemImpl routePathPointItemImpl, BaseLayerImpl baseLayerImpl) {
        routePathPointItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setBusinessType(RoutePathPointItemImpl routePathPointItemImpl, int i) {
        routePathPointItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RoutePathPointItemImpl_getBusinessType(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getBusinessType();
    }

    public static String SwigDirector_RoutePathPointItemImpl_getTypeIdName(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RoutePathPointItemImpl_clearStyle(RoutePathPointItemImpl routePathPointItemImpl) {
        routePathPointItemImpl.clearStyle();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setVisible3V(RoutePathPointItemImpl routePathPointItemImpl, Visible3V visible3V) {
        routePathPointItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RoutePathPointItemImpl_getVisible3V(RoutePathPointItemImpl routePathPointItemImpl, Visible3V visible3V) {
        routePathPointItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setBillboard(RoutePathPointItemImpl routePathPointItemImpl, boolean z) {
        routePathPointItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_getBillboard(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getBillboard();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setPosition3D(RoutePathPointItemImpl routePathPointItemImpl, Coord3DDouble coord3DDouble) {
        routePathPointItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setRotateCenter3D(RoutePathPointItemImpl routePathPointItemImpl, Coord3DDouble coord3DDouble) {
        routePathPointItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RoutePathPointItemImpl_getRotateCenter3D(RoutePathPointItemImpl routePathPointItemImpl, Coord3DDouble coord3DDouble) {
        routePathPointItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setPosition(RoutePathPointItemImpl routePathPointItemImpl, Coord3DDouble coord3DDouble) {
        routePathPointItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RoutePathPointItemImpl_getPosition(RoutePathPointItemImpl routePathPointItemImpl, Coord3DDouble coord3DDouble) {
        routePathPointItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setRotateCenter(RoutePathPointItemImpl routePathPointItemImpl, Coord3DDouble coord3DDouble) {
        routePathPointItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RoutePathPointItemImpl_getNormalStyle(RoutePathPointItemImpl routePathPointItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routePathPointItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RoutePathPointItemImpl_getFocusStyle(RoutePathPointItemImpl routePathPointItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routePathPointItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setItemVisibleRegion(RoutePathPointItemImpl routePathPointItemImpl, RectInt rectInt) {
        routePathPointItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setItemIgnoreRegion(RoutePathPointItemImpl routePathPointItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routePathPointItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RoutePathPointItemImpl_getItemIgnoreRegion(RoutePathPointItemImpl routePathPointItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routePathPointItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setScale(RoutePathPointItemImpl routePathPointItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routePathPointItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RoutePathPointItemImpl_getScale(RoutePathPointItemImpl routePathPointItemImpl, ScaleAttribute scaleAttribute) {
        routePathPointItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setPointTypeCode(RoutePathPointItemImpl routePathPointItemImpl, String str) {
        routePathPointItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RoutePathPointItemImpl_getPointTypeCode(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setScaleFactor(RoutePathPointItemImpl routePathPointItemImpl, float[] fArr) {
        routePathPointItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RoutePathPointItemImpl_setRotateMode(RoutePathPointItemImpl routePathPointItemImpl, @RotateMode.RotateMode1 int i) {
        routePathPointItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RoutePathPointItemImpl_addMarker(RoutePathPointItemImpl routePathPointItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routePathPointItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RoutePathPointItemImpl_clearAllMarkers(RoutePathPointItemImpl routePathPointItemImpl) {
        routePathPointItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RoutePathPointItemImpl_setForeshorteningCoef(RoutePathPointItemImpl routePathPointItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routePathPointItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RoutePathPointItemImpl_getForeshorteningCoef(RoutePathPointItemImpl routePathPointItemImpl) {
        return routePathPointItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_resetOnVisible(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, boolean z) {
        routeWeatherLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_onVisible(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, boolean z) {
        routeWeatherLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_getOnVisible(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_applyOnVisible(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        routeWeatherLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteWeatherLayerItemImpl_getBound(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_getVisible(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteWeatherLayerItemImpl_getPriority(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_isAreaCollision(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setAreaCollision(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, boolean z) {
        routeWeatherLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteWeatherLayerItemImpl_getItemType(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_setID(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, String str) {
        return routeWeatherLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteWeatherLayerItemImpl_getID(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_setInfo(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, String str) {
        return routeWeatherLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteWeatherLayerItemImpl_getInfo(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setPriority(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, int i) {
        routeWeatherLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setVisible(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, boolean z) {
        routeWeatherLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_getFocus(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setAlpha(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, double d) {
        routeWeatherLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteWeatherLayerItemImpl_getAlpha(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setAngle(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, double d) {
        routeWeatherLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteWeatherLayerItemImpl_getAngle(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setPitch(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, double d) {
        routeWeatherLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteWeatherLayerItemImpl_getPitch(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setMaxPitch(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, double d) {
        routeWeatherLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteWeatherLayerItemImpl_getMaxPitch(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setDisplayScale(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, LayerScale layerScale) {
        routeWeatherLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteWeatherLayerItemImpl_getDisplayScale(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setAnimation(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeWeatherLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setStyle__SWIG_0(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeWeatherLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setStyle__SWIG_1(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, String str) {
        routeWeatherLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_updateStyle__SWIG_0(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        routeWeatherLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_updateStyle__SWIG_1(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeWeatherLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_addPoiFilter(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        routeWeatherLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_removePoiFilter(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        routeWeatherLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_onPaint(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        routeWeatherLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setParent(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeWeatherLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setBusinessType(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, int i) {
        routeWeatherLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteWeatherLayerItemImpl_getBusinessType(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteWeatherLayerItemImpl_getTypeIdName(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_clearStyle(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        routeWeatherLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setVisible3V(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Visible3V visible3V) {
        routeWeatherLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_getVisible3V(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Visible3V visible3V) {
        routeWeatherLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setBillboard(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, boolean z) {
        routeWeatherLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_getBillboard(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setPosition3D(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeWeatherLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setRotateCenter3D(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeWeatherLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_getRotateCenter3D(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeWeatherLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setPosition(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeWeatherLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_getPosition(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeWeatherLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setRotateCenter(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeWeatherLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_getNormalStyle(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeWeatherLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_getFocusStyle(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeWeatherLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setItemVisibleRegion(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, RectInt rectInt) {
        routeWeatherLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setItemIgnoreRegion(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeWeatherLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_getItemIgnoreRegion(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeWeatherLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setScale(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeWeatherLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_getScale(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeWeatherLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setPointTypeCode(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, String str) {
        routeWeatherLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteWeatherLayerItemImpl_getPointTypeCode(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setScaleFactor(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, float[] fArr) {
        routeWeatherLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setRotateMode(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeWeatherLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteWeatherLayerItemImpl_addMarker(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeWeatherLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_clearAllMarkers(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        routeWeatherLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteWeatherLayerItemImpl_setForeshorteningCoef(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeWeatherLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteWeatherLayerItemImpl_getForeshorteningCoef(RouteWeatherLayerItemImpl routeWeatherLayerItemImpl) {
        return routeWeatherLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_resetOnVisible(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, boolean z) {
        routeRestAreaLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_onVisible(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, boolean z) {
        routeRestAreaLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_getOnVisible(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_applyOnVisible(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        routeRestAreaLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteRestAreaLayerItemImpl_getBound(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_getVisible(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteRestAreaLayerItemImpl_getPriority(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_isAreaCollision(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setAreaCollision(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, boolean z) {
        routeRestAreaLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteRestAreaLayerItemImpl_getItemType(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_setID(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, String str) {
        return routeRestAreaLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteRestAreaLayerItemImpl_getID(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_setInfo(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, String str) {
        return routeRestAreaLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteRestAreaLayerItemImpl_getInfo(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setPriority(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, int i) {
        routeRestAreaLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setVisible(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, boolean z) {
        routeRestAreaLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_getFocus(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setAlpha(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, double d) {
        routeRestAreaLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteRestAreaLayerItemImpl_getAlpha(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setAngle(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, double d) {
        routeRestAreaLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteRestAreaLayerItemImpl_getAngle(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setPitch(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, double d) {
        routeRestAreaLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteRestAreaLayerItemImpl_getPitch(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setMaxPitch(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, double d) {
        routeRestAreaLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteRestAreaLayerItemImpl_getMaxPitch(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setDisplayScale(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, LayerScale layerScale) {
        routeRestAreaLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteRestAreaLayerItemImpl_getDisplayScale(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setAnimation(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeRestAreaLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setStyle__SWIG_0(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeRestAreaLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setStyle__SWIG_1(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, String str) {
        routeRestAreaLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_updateStyle__SWIG_0(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        routeRestAreaLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_updateStyle__SWIG_1(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeRestAreaLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_addPoiFilter(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        routeRestAreaLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_removePoiFilter(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        routeRestAreaLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_onPaint(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        routeRestAreaLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setParent(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeRestAreaLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setBusinessType(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, int i) {
        routeRestAreaLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteRestAreaLayerItemImpl_getBusinessType(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteRestAreaLayerItemImpl_getTypeIdName(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_clearStyle(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        routeRestAreaLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setVisible3V(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Visible3V visible3V) {
        routeRestAreaLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_getVisible3V(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Visible3V visible3V) {
        routeRestAreaLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setBillboard(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, boolean z) {
        routeRestAreaLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_getBillboard(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setPosition3D(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeRestAreaLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setRotateCenter3D(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeRestAreaLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_getRotateCenter3D(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeRestAreaLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setPosition(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeRestAreaLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_getPosition(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeRestAreaLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setRotateCenter(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeRestAreaLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_getNormalStyle(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeRestAreaLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_getFocusStyle(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeRestAreaLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setItemVisibleRegion(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, RectInt rectInt) {
        routeRestAreaLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setItemIgnoreRegion(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeRestAreaLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_getItemIgnoreRegion(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeRestAreaLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setScale(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeRestAreaLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_getScale(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeRestAreaLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setPointTypeCode(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, String str) {
        routeRestAreaLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteRestAreaLayerItemImpl_getPointTypeCode(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setScaleFactor(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, float[] fArr) {
        routeRestAreaLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setRotateMode(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeRestAreaLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteRestAreaLayerItemImpl_addMarker(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeRestAreaLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_clearAllMarkers(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        routeRestAreaLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteRestAreaLayerItemImpl_setForeshorteningCoef(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeRestAreaLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteRestAreaLayerItemImpl_getForeshorteningCoef(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        return routeRestAreaLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_resetOnVisible(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, boolean z) {
        routeViaRoadLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_onVisible(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, boolean z) {
        routeViaRoadLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_getOnVisible(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_applyOnVisible(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        routeViaRoadLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteViaRoadLayerItemImpl_getBound(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_getVisible(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteViaRoadLayerItemImpl_getPriority(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_isAreaCollision(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setAreaCollision(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, boolean z) {
        routeViaRoadLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteViaRoadLayerItemImpl_getItemType(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_setID(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, String str) {
        return routeViaRoadLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteViaRoadLayerItemImpl_getID(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_setInfo(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, String str) {
        return routeViaRoadLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteViaRoadLayerItemImpl_getInfo(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setPriority(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, int i) {
        routeViaRoadLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setVisible(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, boolean z) {
        routeViaRoadLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_getFocus(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setAlpha(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, double d) {
        routeViaRoadLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteViaRoadLayerItemImpl_getAlpha(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setAngle(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, double d) {
        routeViaRoadLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteViaRoadLayerItemImpl_getAngle(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setPitch(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, double d) {
        routeViaRoadLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteViaRoadLayerItemImpl_getPitch(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setMaxPitch(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, double d) {
        routeViaRoadLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteViaRoadLayerItemImpl_getMaxPitch(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setDisplayScale(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, LayerScale layerScale) {
        routeViaRoadLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteViaRoadLayerItemImpl_getDisplayScale(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setAnimation(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeViaRoadLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setStyle__SWIG_0(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeViaRoadLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setStyle__SWIG_1(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, String str) {
        routeViaRoadLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_updateStyle__SWIG_0(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        routeViaRoadLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_updateStyle__SWIG_1(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeViaRoadLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_addPoiFilter(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        routeViaRoadLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_removePoiFilter(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        routeViaRoadLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_onPaint(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        routeViaRoadLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setParent(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeViaRoadLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setBusinessType(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, int i) {
        routeViaRoadLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteViaRoadLayerItemImpl_getBusinessType(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteViaRoadLayerItemImpl_getTypeIdName(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_clearStyle(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        routeViaRoadLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setVisible3V(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Visible3V visible3V) {
        routeViaRoadLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_getVisible3V(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Visible3V visible3V) {
        routeViaRoadLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setBillboard(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, boolean z) {
        routeViaRoadLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_getBillboard(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setPosition3D(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeViaRoadLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setRotateCenter3D(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeViaRoadLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_getRotateCenter3D(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeViaRoadLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setPosition(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeViaRoadLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_getPosition(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeViaRoadLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setRotateCenter(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeViaRoadLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_getNormalStyle(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeViaRoadLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_getFocusStyle(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeViaRoadLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setItemVisibleRegion(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, RectInt rectInt) {
        routeViaRoadLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setItemIgnoreRegion(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeViaRoadLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_getItemIgnoreRegion(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeViaRoadLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setScale(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeViaRoadLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_getScale(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeViaRoadLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setPointTypeCode(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, String str) {
        routeViaRoadLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteViaRoadLayerItemImpl_getPointTypeCode(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setScaleFactor(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, float[] fArr) {
        routeViaRoadLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setRotateMode(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeViaRoadLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteViaRoadLayerItemImpl_addMarker(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeViaRoadLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_clearAllMarkers(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        routeViaRoadLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteViaRoadLayerItemImpl_setForeshorteningCoef(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeViaRoadLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteViaRoadLayerItemImpl_getForeshorteningCoef(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        return routeViaRoadLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_resetOnVisible(PathBoardLayerItemImpl pathBoardLayerItemImpl, boolean z) {
        pathBoardLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_onVisible(PathBoardLayerItemImpl pathBoardLayerItemImpl, boolean z) {
        pathBoardLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_getOnVisible(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_applyOnVisible(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        pathBoardLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_PathBoardLayerItemImpl_getBound(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_getVisible(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getVisible();
    }

    public static int SwigDirector_PathBoardLayerItemImpl_getPriority(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_isAreaCollision(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setAreaCollision(PathBoardLayerItemImpl pathBoardLayerItemImpl, boolean z) {
        pathBoardLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_PathBoardLayerItemImpl_getItemType(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_setID(PathBoardLayerItemImpl pathBoardLayerItemImpl, String str) {
        return pathBoardLayerItemImpl.setID(str);
    }

    public static String SwigDirector_PathBoardLayerItemImpl_getID(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getID();
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_setInfo(PathBoardLayerItemImpl pathBoardLayerItemImpl, String str) {
        return pathBoardLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_PathBoardLayerItemImpl_getInfo(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getInfo();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setPriority(PathBoardLayerItemImpl pathBoardLayerItemImpl, int i) {
        pathBoardLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setVisible(PathBoardLayerItemImpl pathBoardLayerItemImpl, boolean z) {
        pathBoardLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_getFocus(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getFocus();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setAlpha(PathBoardLayerItemImpl pathBoardLayerItemImpl, double d) {
        pathBoardLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_PathBoardLayerItemImpl_getAlpha(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setAngle(PathBoardLayerItemImpl pathBoardLayerItemImpl, double d) {
        pathBoardLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_PathBoardLayerItemImpl_getAngle(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getAngle();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setPitch(PathBoardLayerItemImpl pathBoardLayerItemImpl, double d) {
        pathBoardLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_PathBoardLayerItemImpl_getPitch(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getPitch();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setMaxPitch(PathBoardLayerItemImpl pathBoardLayerItemImpl, double d) {
        pathBoardLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_PathBoardLayerItemImpl_getMaxPitch(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setDisplayScale(PathBoardLayerItemImpl pathBoardLayerItemImpl, LayerScale layerScale) {
        pathBoardLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_PathBoardLayerItemImpl_getDisplayScale(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setAnimation(PathBoardLayerItemImpl pathBoardLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        pathBoardLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setStyle__SWIG_0(PathBoardLayerItemImpl pathBoardLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        pathBoardLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setStyle__SWIG_1(PathBoardLayerItemImpl pathBoardLayerItemImpl, String str) {
        pathBoardLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_updateStyle__SWIG_0(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        pathBoardLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_updateStyle__SWIG_1(PathBoardLayerItemImpl pathBoardLayerItemImpl, LayerItemImpl layerItemImpl) {
        pathBoardLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_addPoiFilter(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        pathBoardLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_removePoiFilter(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        pathBoardLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_onPaint(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        pathBoardLayerItemImpl.onPaint();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setParent(PathBoardLayerItemImpl pathBoardLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        pathBoardLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setBusinessType(PathBoardLayerItemImpl pathBoardLayerItemImpl, int i) {
        pathBoardLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_PathBoardLayerItemImpl_getBusinessType(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_PathBoardLayerItemImpl_getTypeIdName(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_clearStyle(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        pathBoardLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setVisible3V(PathBoardLayerItemImpl pathBoardLayerItemImpl, Visible3V visible3V) {
        pathBoardLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_getVisible3V(PathBoardLayerItemImpl pathBoardLayerItemImpl, Visible3V visible3V) {
        pathBoardLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setBillboard(PathBoardLayerItemImpl pathBoardLayerItemImpl, boolean z) {
        pathBoardLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_getBillboard(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setPosition3D(PathBoardLayerItemImpl pathBoardLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathBoardLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setRotateCenter3D(PathBoardLayerItemImpl pathBoardLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathBoardLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_getRotateCenter3D(PathBoardLayerItemImpl pathBoardLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathBoardLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setPosition(PathBoardLayerItemImpl pathBoardLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathBoardLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_getPosition(PathBoardLayerItemImpl pathBoardLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathBoardLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setRotateCenter(PathBoardLayerItemImpl pathBoardLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathBoardLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_getNormalStyle(PathBoardLayerItemImpl pathBoardLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        pathBoardLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_getFocusStyle(PathBoardLayerItemImpl pathBoardLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        pathBoardLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setItemVisibleRegion(PathBoardLayerItemImpl pathBoardLayerItemImpl, RectInt rectInt) {
        pathBoardLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setItemIgnoreRegion(PathBoardLayerItemImpl pathBoardLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        pathBoardLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_getItemIgnoreRegion(PathBoardLayerItemImpl pathBoardLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        pathBoardLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setScale(PathBoardLayerItemImpl pathBoardLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        pathBoardLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_getScale(PathBoardLayerItemImpl pathBoardLayerItemImpl, ScaleAttribute scaleAttribute) {
        pathBoardLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setPointTypeCode(PathBoardLayerItemImpl pathBoardLayerItemImpl, String str) {
        pathBoardLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_PathBoardLayerItemImpl_getPointTypeCode(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setScaleFactor(PathBoardLayerItemImpl pathBoardLayerItemImpl, float[] fArr) {
        pathBoardLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setRotateMode(PathBoardLayerItemImpl pathBoardLayerItemImpl, @RotateMode.RotateMode1 int i) {
        pathBoardLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_PathBoardLayerItemImpl_addMarker(PathBoardLayerItemImpl pathBoardLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return pathBoardLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_PathBoardLayerItemImpl_clearAllMarkers(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        pathBoardLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_PathBoardLayerItemImpl_setForeshorteningCoef(PathBoardLayerItemImpl pathBoardLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        pathBoardLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_PathBoardLayerItemImpl_getForeshorteningCoef(PathBoardLayerItemImpl pathBoardLayerItemImpl) {
        return pathBoardLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_resetOnVisible(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z) {
        routeCompareTipsLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_onVisible(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z) {
        routeCompareTipsLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_getOnVisible(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_applyOnVisible(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        routeCompareTipsLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteCompareTipsLayerItemImpl_getBound(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_getVisible(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteCompareTipsLayerItemImpl_getPriority(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_isAreaCollision(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setAreaCollision(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z) {
        routeCompareTipsLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteCompareTipsLayerItemImpl_getItemType(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_setID(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, String str) {
        return routeCompareTipsLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteCompareTipsLayerItemImpl_getID(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_setInfo(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, String str) {
        return routeCompareTipsLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteCompareTipsLayerItemImpl_getInfo(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setPriority(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, int i) {
        routeCompareTipsLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setVisible(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z) {
        routeCompareTipsLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_getFocus(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setAlpha(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, double d) {
        routeCompareTipsLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteCompareTipsLayerItemImpl_getAlpha(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setAngle(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, double d) {
        routeCompareTipsLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteCompareTipsLayerItemImpl_getAngle(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setPitch(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, double d) {
        routeCompareTipsLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteCompareTipsLayerItemImpl_getPitch(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setMaxPitch(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, double d) {
        routeCompareTipsLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteCompareTipsLayerItemImpl_getMaxPitch(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setDisplayScale(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, LayerScale layerScale) {
        routeCompareTipsLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteCompareTipsLayerItemImpl_getDisplayScale(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setAnimation(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeCompareTipsLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setStyle__SWIG_0(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeCompareTipsLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setStyle__SWIG_1(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, String str) {
        routeCompareTipsLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_updateStyle__SWIG_0(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        routeCompareTipsLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_updateStyle__SWIG_1(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeCompareTipsLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_addPoiFilter(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        routeCompareTipsLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_removePoiFilter(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        routeCompareTipsLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_onPaint(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        routeCompareTipsLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setParent(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeCompareTipsLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setBusinessType(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, int i) {
        routeCompareTipsLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteCompareTipsLayerItemImpl_getBusinessType(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteCompareTipsLayerItemImpl_getTypeIdName(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_clearStyle(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        routeCompareTipsLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setVisible3V(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Visible3V visible3V) {
        routeCompareTipsLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_getVisible3V(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Visible3V visible3V) {
        routeCompareTipsLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setBillboard(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z) {
        routeCompareTipsLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_getBillboard(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setPosition3D(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeCompareTipsLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setRotateCenter3D(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeCompareTipsLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_getRotateCenter3D(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeCompareTipsLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setPosition(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeCompareTipsLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_getPosition(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeCompareTipsLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setRotateCenter(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeCompareTipsLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_getNormalStyle(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeCompareTipsLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_getFocusStyle(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeCompareTipsLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setItemVisibleRegion(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, RectInt rectInt) {
        routeCompareTipsLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setItemIgnoreRegion(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeCompareTipsLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_getItemIgnoreRegion(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeCompareTipsLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setScale(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeCompareTipsLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_getScale(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeCompareTipsLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setPointTypeCode(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, String str) {
        routeCompareTipsLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteCompareTipsLayerItemImpl_getPointTypeCode(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setScaleFactor(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, float[] fArr) {
        routeCompareTipsLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setRotateMode(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeCompareTipsLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteCompareTipsLayerItemImpl_addMarker(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeCompareTipsLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_clearAllMarkers(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        routeCompareTipsLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteCompareTipsLayerItemImpl_setForeshorteningCoef(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeCompareTipsLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteCompareTipsLayerItemImpl_getForeshorteningCoef(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        return routeCompareTipsLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_resetOnVisible(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, boolean z) {
        routeTrafficEventTipsLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_onVisible(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, boolean z) {
        routeTrafficEventTipsLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_getOnVisible(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_applyOnVisible(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteTrafficEventTipsLayerItemImpl_getBound(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_getVisible(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteTrafficEventTipsLayerItemImpl_getPriority(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_isAreaCollision(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setAreaCollision(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, boolean z) {
        routeTrafficEventTipsLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteTrafficEventTipsLayerItemImpl_getItemType(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_setID(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, String str) {
        return routeTrafficEventTipsLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteTrafficEventTipsLayerItemImpl_getID(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_setInfo(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, String str) {
        return routeTrafficEventTipsLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteTrafficEventTipsLayerItemImpl_getInfo(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setPriority(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, int i) {
        routeTrafficEventTipsLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setVisible(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, boolean z) {
        routeTrafficEventTipsLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_getFocus(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setAlpha(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, double d) {
        routeTrafficEventTipsLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteTrafficEventTipsLayerItemImpl_getAlpha(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setAngle(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, double d) {
        routeTrafficEventTipsLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteTrafficEventTipsLayerItemImpl_getAngle(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setPitch(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, double d) {
        routeTrafficEventTipsLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteTrafficEventTipsLayerItemImpl_getPitch(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setMaxPitch(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, double d) {
        routeTrafficEventTipsLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteTrafficEventTipsLayerItemImpl_getMaxPitch(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setDisplayScale(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, LayerScale layerScale) {
        routeTrafficEventTipsLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteTrafficEventTipsLayerItemImpl_getDisplayScale(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setAnimation(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeTrafficEventTipsLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setStyle__SWIG_0(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeTrafficEventTipsLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setStyle__SWIG_1(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, String str) {
        routeTrafficEventTipsLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_updateStyle__SWIG_0(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_updateStyle__SWIG_1(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_addPoiFilter(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_removePoiFilter(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_onPaint(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setParent(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeTrafficEventTipsLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setBusinessType(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, int i) {
        routeTrafficEventTipsLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteTrafficEventTipsLayerItemImpl_getBusinessType(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteTrafficEventTipsLayerItemImpl_getTypeIdName(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_clearStyle(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setVisible3V(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Visible3V visible3V) {
        routeTrafficEventTipsLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_getVisible3V(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Visible3V visible3V) {
        routeTrafficEventTipsLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setBillboard(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, boolean z) {
        routeTrafficEventTipsLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_getBillboard(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setPosition3D(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeTrafficEventTipsLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setRotateCenter3D(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeTrafficEventTipsLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_getRotateCenter3D(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeTrafficEventTipsLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setPosition(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeTrafficEventTipsLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_getPosition(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeTrafficEventTipsLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setRotateCenter(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeTrafficEventTipsLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_getNormalStyle(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeTrafficEventTipsLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_getFocusStyle(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeTrafficEventTipsLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setItemVisibleRegion(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, RectInt rectInt) {
        routeTrafficEventTipsLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setItemIgnoreRegion(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeTrafficEventTipsLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_getItemIgnoreRegion(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeTrafficEventTipsLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setScale(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeTrafficEventTipsLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_getScale(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeTrafficEventTipsLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setPointTypeCode(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, String str) {
        routeTrafficEventTipsLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteTrafficEventTipsLayerItemImpl_getPointTypeCode(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setScaleFactor(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, float[] fArr) {
        routeTrafficEventTipsLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setRotateMode(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeTrafficEventTipsLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteTrafficEventTipsLayerItemImpl_addMarker(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeTrafficEventTipsLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_clearAllMarkers(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        routeTrafficEventTipsLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteTrafficEventTipsLayerItemImpl_setForeshorteningCoef(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeTrafficEventTipsLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteTrafficEventTipsLayerItemImpl_getForeshorteningCoef(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        return routeTrafficEventTipsLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_resetOnVisible(GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z) {
        guideLabelLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_onVisible(GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z) {
        guideLabelLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_getOnVisible(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_applyOnVisible(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideLabelLayerItemImpl_getBound(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_getVisible(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideLabelLayerItemImpl_getPriority(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_isAreaCollision(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setAreaCollision(GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z) {
        guideLabelLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideLabelLayerItemImpl_getItemType(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_setID(GuideLabelLayerItemImpl guideLabelLayerItemImpl, String str) {
        return guideLabelLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideLabelLayerItemImpl_getID(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_setInfo(GuideLabelLayerItemImpl guideLabelLayerItemImpl, String str) {
        return guideLabelLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideLabelLayerItemImpl_getInfo(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setPriority(GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i) {
        guideLabelLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setVisible(GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z) {
        guideLabelLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_getFocus(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setAlpha(GuideLabelLayerItemImpl guideLabelLayerItemImpl, double d) {
        guideLabelLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideLabelLayerItemImpl_getAlpha(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setAngle(GuideLabelLayerItemImpl guideLabelLayerItemImpl, double d) {
        guideLabelLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideLabelLayerItemImpl_getAngle(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setPitch(GuideLabelLayerItemImpl guideLabelLayerItemImpl, double d) {
        guideLabelLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideLabelLayerItemImpl_getPitch(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setMaxPitch(GuideLabelLayerItemImpl guideLabelLayerItemImpl, double d) {
        guideLabelLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideLabelLayerItemImpl_getMaxPitch(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setDisplayScale(GuideLabelLayerItemImpl guideLabelLayerItemImpl, LayerScale layerScale) {
        guideLabelLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideLabelLayerItemImpl_getDisplayScale(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setAnimation(GuideLabelLayerItemImpl guideLabelLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideLabelLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setStyle__SWIG_0(GuideLabelLayerItemImpl guideLabelLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideLabelLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setStyle__SWIG_1(GuideLabelLayerItemImpl guideLabelLayerItemImpl, String str) {
        guideLabelLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_updateStyle__SWIG_0(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_updateStyle__SWIG_1(GuideLabelLayerItemImpl guideLabelLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideLabelLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_addPoiFilter(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_removePoiFilter(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_onPaint(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setParent(GuideLabelLayerItemImpl guideLabelLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideLabelLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setBusinessType(GuideLabelLayerItemImpl guideLabelLayerItemImpl, int i) {
        guideLabelLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideLabelLayerItemImpl_getBusinessType(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideLabelLayerItemImpl_getTypeIdName(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_clearStyle(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setVisible3V(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Visible3V visible3V) {
        guideLabelLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_getVisible3V(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Visible3V visible3V) {
        guideLabelLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setBillboard(GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z) {
        guideLabelLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_getBillboard(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setPosition3D(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideLabelLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setRotateCenter3D(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideLabelLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_getRotateCenter3D(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideLabelLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setPosition(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideLabelLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_getPosition(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideLabelLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setRotateCenter(GuideLabelLayerItemImpl guideLabelLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideLabelLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_getNormalStyle(GuideLabelLayerItemImpl guideLabelLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideLabelLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_getFocusStyle(GuideLabelLayerItemImpl guideLabelLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideLabelLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setItemVisibleRegion(GuideLabelLayerItemImpl guideLabelLayerItemImpl, RectInt rectInt) {
        guideLabelLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setItemIgnoreRegion(GuideLabelLayerItemImpl guideLabelLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideLabelLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_getItemIgnoreRegion(GuideLabelLayerItemImpl guideLabelLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideLabelLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setScale(GuideLabelLayerItemImpl guideLabelLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideLabelLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_getScale(GuideLabelLayerItemImpl guideLabelLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideLabelLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setPointTypeCode(GuideLabelLayerItemImpl guideLabelLayerItemImpl, String str) {
        guideLabelLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideLabelLayerItemImpl_getPointTypeCode(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setScaleFactor(GuideLabelLayerItemImpl guideLabelLayerItemImpl, float[] fArr) {
        guideLabelLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setRotateMode(GuideLabelLayerItemImpl guideLabelLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideLabelLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_addMarker(GuideLabelLayerItemImpl guideLabelLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideLabelLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_clearAllMarkers(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setForeshorteningCoef(GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideLabelLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideLabelLayerItemImpl_getForeshorteningCoef(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_setIdle(GuideLabelLayerItemImpl guideLabelLayerItemImpl, boolean z) {
        guideLabelLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_isIdle(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.isIdle();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_addIntersectArea(GuideLabelLayerItemImpl guideLabelLayerItemImpl, float f) {
        guideLabelLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_GuideLabelLayerItemImpl_getIntersectArea(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_resetIntersectArea(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_addIntersectAreaEx(GuideLabelLayerItemImpl guideLabelLayerItemImpl, float f) {
        guideLabelLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_GuideLabelLayerItemImpl_getIntersectAreaEx(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_GuideLabelLayerItemImpl_resetIntersectAreaEx(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        guideLabelLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_GuideLabelLayerItemImpl_checkShowFlag(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_GuideLabelLayerItemImpl_getQuadrantGroupId(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_GuideLabelLayerItemImpl_getQuadrantType(GuideLabelLayerItemImpl guideLabelLayerItemImpl) {
        return guideLabelLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_resetOnVisible(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, boolean z) {
        guideFamiliarRouteLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_onVisible(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, boolean z) {
        guideFamiliarRouteLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_getOnVisible(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_applyOnVisible(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GuideFamiliarRouteLayerItemImpl_getBound(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_getVisible(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GuideFamiliarRouteLayerItemImpl_getPriority(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_isAreaCollision(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setAreaCollision(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, boolean z) {
        guideFamiliarRouteLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GuideFamiliarRouteLayerItemImpl_getItemType(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_setID(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, String str) {
        return guideFamiliarRouteLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GuideFamiliarRouteLayerItemImpl_getID(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_setInfo(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, String str) {
        return guideFamiliarRouteLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GuideFamiliarRouteLayerItemImpl_getInfo(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setPriority(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, int i) {
        guideFamiliarRouteLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setVisible(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, boolean z) {
        guideFamiliarRouteLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_getFocus(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setAlpha(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, double d) {
        guideFamiliarRouteLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GuideFamiliarRouteLayerItemImpl_getAlpha(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setAngle(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, double d) {
        guideFamiliarRouteLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GuideFamiliarRouteLayerItemImpl_getAngle(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setPitch(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, double d) {
        guideFamiliarRouteLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GuideFamiliarRouteLayerItemImpl_getPitch(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setMaxPitch(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, double d) {
        guideFamiliarRouteLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GuideFamiliarRouteLayerItemImpl_getMaxPitch(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setDisplayScale(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, LayerScale layerScale) {
        guideFamiliarRouteLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GuideFamiliarRouteLayerItemImpl_getDisplayScale(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setAnimation(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        guideFamiliarRouteLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setStyle__SWIG_0(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        guideFamiliarRouteLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setStyle__SWIG_1(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, String str) {
        guideFamiliarRouteLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_updateStyle__SWIG_0(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_updateStyle__SWIG_1(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, LayerItemImpl layerItemImpl) {
        guideFamiliarRouteLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_addPoiFilter(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_removePoiFilter(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_onPaint(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setParent(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        guideFamiliarRouteLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setBusinessType(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, int i) {
        guideFamiliarRouteLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GuideFamiliarRouteLayerItemImpl_getBusinessType(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GuideFamiliarRouteLayerItemImpl_getTypeIdName(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_clearStyle(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setVisible3V(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Visible3V visible3V) {
        guideFamiliarRouteLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_getVisible3V(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Visible3V visible3V) {
        guideFamiliarRouteLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setBillboard(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, boolean z) {
        guideFamiliarRouteLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_getBillboard(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setPosition3D(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFamiliarRouteLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setRotateCenter3D(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFamiliarRouteLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_getRotateCenter3D(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFamiliarRouteLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setPosition(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFamiliarRouteLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_getPosition(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFamiliarRouteLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setRotateCenter(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, Coord3DDouble coord3DDouble) {
        guideFamiliarRouteLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_getNormalStyle(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideFamiliarRouteLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_getFocusStyle(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        guideFamiliarRouteLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setItemVisibleRegion(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, RectInt rectInt) {
        guideFamiliarRouteLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setItemIgnoreRegion(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideFamiliarRouteLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_getItemIgnoreRegion(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        guideFamiliarRouteLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setScale(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        guideFamiliarRouteLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_getScale(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, ScaleAttribute scaleAttribute) {
        guideFamiliarRouteLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setPointTypeCode(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, String str) {
        guideFamiliarRouteLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GuideFamiliarRouteLayerItemImpl_getPointTypeCode(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setScaleFactor(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, float[] fArr) {
        guideFamiliarRouteLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setRotateMode(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, @RotateMode.RotateMode1 int i) {
        guideFamiliarRouteLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_addMarker(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return guideFamiliarRouteLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_clearAllMarkers(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setForeshorteningCoef(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        guideFamiliarRouteLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GuideFamiliarRouteLayerItemImpl_getForeshorteningCoef(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_setIdle(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, boolean z) {
        guideFamiliarRouteLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_isIdle(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.isIdle();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_addIntersectArea(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, float f) {
        guideFamiliarRouteLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_GuideFamiliarRouteLayerItemImpl_getIntersectArea(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_resetIntersectArea(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_addIntersectAreaEx(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, float f) {
        guideFamiliarRouteLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_GuideFamiliarRouteLayerItemImpl_getIntersectAreaEx(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_GuideFamiliarRouteLayerItemImpl_resetIntersectAreaEx(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        guideFamiliarRouteLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_GuideFamiliarRouteLayerItemImpl_checkShowFlag(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_GuideFamiliarRouteLayerItemImpl_getQuadrantGroupId(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_GuideFamiliarRouteLayerItemImpl_getQuadrantType(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        return guideFamiliarRouteLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_resetOnVisible(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z) {
        routeIndoorParkLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_onVisible(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z) {
        routeIndoorParkLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_getOnVisible(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_applyOnVisible(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteIndoorParkLayerItemImpl_getBound(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_getVisible(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteIndoorParkLayerItemImpl_getPriority(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_isAreaCollision(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setAreaCollision(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z) {
        routeIndoorParkLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteIndoorParkLayerItemImpl_getItemType(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_setID(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, String str) {
        return routeIndoorParkLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteIndoorParkLayerItemImpl_getID(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_setInfo(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, String str) {
        return routeIndoorParkLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteIndoorParkLayerItemImpl_getInfo(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setPriority(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, int i) {
        routeIndoorParkLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setVisible(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z) {
        routeIndoorParkLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_getFocus(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setAlpha(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, double d) {
        routeIndoorParkLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteIndoorParkLayerItemImpl_getAlpha(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setAngle(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, double d) {
        routeIndoorParkLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteIndoorParkLayerItemImpl_getAngle(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setPitch(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, double d) {
        routeIndoorParkLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteIndoorParkLayerItemImpl_getPitch(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setMaxPitch(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, double d) {
        routeIndoorParkLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteIndoorParkLayerItemImpl_getMaxPitch(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setDisplayScale(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, LayerScale layerScale) {
        routeIndoorParkLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteIndoorParkLayerItemImpl_getDisplayScale(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setAnimation(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeIndoorParkLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setStyle__SWIG_0(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeIndoorParkLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setStyle__SWIG_1(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, String str) {
        routeIndoorParkLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_updateStyle__SWIG_0(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_updateStyle__SWIG_1(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeIndoorParkLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_addPoiFilter(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_removePoiFilter(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_onPaint(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setParent(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeIndoorParkLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setBusinessType(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, int i) {
        routeIndoorParkLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteIndoorParkLayerItemImpl_getBusinessType(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteIndoorParkLayerItemImpl_getTypeIdName(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_clearStyle(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setVisible3V(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Visible3V visible3V) {
        routeIndoorParkLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_getVisible3V(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Visible3V visible3V) {
        routeIndoorParkLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setBillboard(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z) {
        routeIndoorParkLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_getBillboard(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setPosition3D(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setRotateCenter3D(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_getRotateCenter3D(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setPosition(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_getPosition(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setRotateCenter(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_getNormalStyle(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeIndoorParkLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_getFocusStyle(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeIndoorParkLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setItemVisibleRegion(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, RectInt rectInt) {
        routeIndoorParkLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setItemIgnoreRegion(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeIndoorParkLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_getItemIgnoreRegion(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeIndoorParkLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setScale(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeIndoorParkLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_getScale(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeIndoorParkLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setPointTypeCode(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, String str) {
        routeIndoorParkLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteIndoorParkLayerItemImpl_getPointTypeCode(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setScaleFactor(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, float[] fArr) {
        routeIndoorParkLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setRotateMode(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeIndoorParkLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_addMarker(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeIndoorParkLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_clearAllMarkers(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setForeshorteningCoef(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeIndoorParkLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteIndoorParkLayerItemImpl_getForeshorteningCoef(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_setIdle(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z) {
        routeIndoorParkLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_isIdle(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.isIdle();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_addIntersectArea(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, float f) {
        routeIndoorParkLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_RouteIndoorParkLayerItemImpl_getIntersectArea(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_resetIntersectArea(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_addIntersectAreaEx(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, float f) {
        routeIndoorParkLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_RouteIndoorParkLayerItemImpl_getIntersectAreaEx(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_RouteIndoorParkLayerItemImpl_resetIntersectAreaEx(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        routeIndoorParkLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_RouteIndoorParkLayerItemImpl_checkShowFlag(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_RouteIndoorParkLayerItemImpl_getQuadrantGroupId(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_RouteIndoorParkLayerItemImpl_getQuadrantType(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        return routeIndoorParkLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_resetOnVisible(RouteNumberLayerItemImpl routeNumberLayerItemImpl, boolean z) {
        routeNumberLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_onVisible(RouteNumberLayerItemImpl routeNumberLayerItemImpl, boolean z) {
        routeNumberLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_getOnVisible(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_applyOnVisible(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        routeNumberLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteNumberLayerItemImpl_getBound(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_getVisible(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteNumberLayerItemImpl_getPriority(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_isAreaCollision(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setAreaCollision(RouteNumberLayerItemImpl routeNumberLayerItemImpl, boolean z) {
        routeNumberLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteNumberLayerItemImpl_getItemType(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_setID(RouteNumberLayerItemImpl routeNumberLayerItemImpl, String str) {
        return routeNumberLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteNumberLayerItemImpl_getID(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_setInfo(RouteNumberLayerItemImpl routeNumberLayerItemImpl, String str) {
        return routeNumberLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteNumberLayerItemImpl_getInfo(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setPriority(RouteNumberLayerItemImpl routeNumberLayerItemImpl, int i) {
        routeNumberLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setVisible(RouteNumberLayerItemImpl routeNumberLayerItemImpl, boolean z) {
        routeNumberLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_getFocus(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setAlpha(RouteNumberLayerItemImpl routeNumberLayerItemImpl, double d) {
        routeNumberLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteNumberLayerItemImpl_getAlpha(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setAngle(RouteNumberLayerItemImpl routeNumberLayerItemImpl, double d) {
        routeNumberLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteNumberLayerItemImpl_getAngle(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setPitch(RouteNumberLayerItemImpl routeNumberLayerItemImpl, double d) {
        routeNumberLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteNumberLayerItemImpl_getPitch(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setMaxPitch(RouteNumberLayerItemImpl routeNumberLayerItemImpl, double d) {
        routeNumberLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteNumberLayerItemImpl_getMaxPitch(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setDisplayScale(RouteNumberLayerItemImpl routeNumberLayerItemImpl, LayerScale layerScale) {
        routeNumberLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteNumberLayerItemImpl_getDisplayScale(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setAnimation(RouteNumberLayerItemImpl routeNumberLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeNumberLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setStyle__SWIG_0(RouteNumberLayerItemImpl routeNumberLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeNumberLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setStyle__SWIG_1(RouteNumberLayerItemImpl routeNumberLayerItemImpl, String str) {
        routeNumberLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_updateStyle__SWIG_0(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        routeNumberLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_updateStyle__SWIG_1(RouteNumberLayerItemImpl routeNumberLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeNumberLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_addPoiFilter(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        routeNumberLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_removePoiFilter(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        routeNumberLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_onPaint(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        routeNumberLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setParent(RouteNumberLayerItemImpl routeNumberLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeNumberLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setBusinessType(RouteNumberLayerItemImpl routeNumberLayerItemImpl, int i) {
        routeNumberLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteNumberLayerItemImpl_getBusinessType(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteNumberLayerItemImpl_getTypeIdName(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_clearStyle(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        routeNumberLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setVisible3V(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Visible3V visible3V) {
        routeNumberLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_getVisible3V(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Visible3V visible3V) {
        routeNumberLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setBillboard(RouteNumberLayerItemImpl routeNumberLayerItemImpl, boolean z) {
        routeNumberLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_getBillboard(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setPosition3D(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeNumberLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setRotateCenter3D(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeNumberLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_getRotateCenter3D(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeNumberLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setPosition(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeNumberLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_getPosition(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeNumberLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setRotateCenter(RouteNumberLayerItemImpl routeNumberLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeNumberLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_getNormalStyle(RouteNumberLayerItemImpl routeNumberLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeNumberLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_getFocusStyle(RouteNumberLayerItemImpl routeNumberLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeNumberLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setItemVisibleRegion(RouteNumberLayerItemImpl routeNumberLayerItemImpl, RectInt rectInt) {
        routeNumberLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setItemIgnoreRegion(RouteNumberLayerItemImpl routeNumberLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeNumberLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_getItemIgnoreRegion(RouteNumberLayerItemImpl routeNumberLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeNumberLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setScale(RouteNumberLayerItemImpl routeNumberLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeNumberLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_getScale(RouteNumberLayerItemImpl routeNumberLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeNumberLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setPointTypeCode(RouteNumberLayerItemImpl routeNumberLayerItemImpl, String str) {
        routeNumberLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteNumberLayerItemImpl_getPointTypeCode(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setScaleFactor(RouteNumberLayerItemImpl routeNumberLayerItemImpl, float[] fArr) {
        routeNumberLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setRotateMode(RouteNumberLayerItemImpl routeNumberLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeNumberLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteNumberLayerItemImpl_addMarker(RouteNumberLayerItemImpl routeNumberLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeNumberLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_clearAllMarkers(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        routeNumberLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteNumberLayerItemImpl_setForeshorteningCoef(RouteNumberLayerItemImpl routeNumberLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeNumberLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteNumberLayerItemImpl_getForeshorteningCoef(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        return routeNumberLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_resetOnVisible(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, boolean z) {
        routeIndoorParkEndLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_onVisible(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, boolean z) {
        routeIndoorParkEndLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_getOnVisible(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_applyOnVisible(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        routeIndoorParkEndLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_RouteIndoorParkEndLayerItemImpl_getBound(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_getVisible(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getVisible();
    }

    public static int SwigDirector_RouteIndoorParkEndLayerItemImpl_getPriority(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_isAreaCollision(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setAreaCollision(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, boolean z) {
        routeIndoorParkEndLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_RouteIndoorParkEndLayerItemImpl_getItemType(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_setID(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, String str) {
        return routeIndoorParkEndLayerItemImpl.setID(str);
    }

    public static String SwigDirector_RouteIndoorParkEndLayerItemImpl_getID(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getID();
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_setInfo(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, String str) {
        return routeIndoorParkEndLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_RouteIndoorParkEndLayerItemImpl_getInfo(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getInfo();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setPriority(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, int i) {
        routeIndoorParkEndLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setVisible(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, boolean z) {
        routeIndoorParkEndLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_getFocus(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getFocus();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setAlpha(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, double d) {
        routeIndoorParkEndLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_RouteIndoorParkEndLayerItemImpl_getAlpha(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setAngle(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, double d) {
        routeIndoorParkEndLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_RouteIndoorParkEndLayerItemImpl_getAngle(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getAngle();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setPitch(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, double d) {
        routeIndoorParkEndLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_RouteIndoorParkEndLayerItemImpl_getPitch(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getPitch();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setMaxPitch(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, double d) {
        routeIndoorParkEndLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_RouteIndoorParkEndLayerItemImpl_getMaxPitch(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setDisplayScale(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, LayerScale layerScale) {
        routeIndoorParkEndLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_RouteIndoorParkEndLayerItemImpl_getDisplayScale(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setAnimation(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        routeIndoorParkEndLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setStyle__SWIG_0(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        routeIndoorParkEndLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setStyle__SWIG_1(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, String str) {
        routeIndoorParkEndLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_updateStyle__SWIG_0(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        routeIndoorParkEndLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_updateStyle__SWIG_1(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, LayerItemImpl layerItemImpl) {
        routeIndoorParkEndLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_addPoiFilter(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        routeIndoorParkEndLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_removePoiFilter(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        routeIndoorParkEndLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_onPaint(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        routeIndoorParkEndLayerItemImpl.onPaint();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setParent(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        routeIndoorParkEndLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setBusinessType(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, int i) {
        routeIndoorParkEndLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_RouteIndoorParkEndLayerItemImpl_getBusinessType(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_RouteIndoorParkEndLayerItemImpl_getTypeIdName(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_clearStyle(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        routeIndoorParkEndLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setVisible3V(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Visible3V visible3V) {
        routeIndoorParkEndLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_getVisible3V(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Visible3V visible3V) {
        routeIndoorParkEndLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setBillboard(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, boolean z) {
        routeIndoorParkEndLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_getBillboard(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setPosition3D(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkEndLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setRotateCenter3D(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkEndLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_getRotateCenter3D(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkEndLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setPosition(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkEndLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_getPosition(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkEndLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setRotateCenter(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        routeIndoorParkEndLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_getNormalStyle(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeIndoorParkEndLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_getFocusStyle(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        routeIndoorParkEndLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setItemVisibleRegion(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, RectInt rectInt) {
        routeIndoorParkEndLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setItemIgnoreRegion(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeIndoorParkEndLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_getItemIgnoreRegion(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        routeIndoorParkEndLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setScale(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        routeIndoorParkEndLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_getScale(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, ScaleAttribute scaleAttribute) {
        routeIndoorParkEndLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setPointTypeCode(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, String str) {
        routeIndoorParkEndLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_RouteIndoorParkEndLayerItemImpl_getPointTypeCode(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setScaleFactor(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, float[] fArr) {
        routeIndoorParkEndLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setRotateMode(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, @RotateMode.RotateMode1 int i) {
        routeIndoorParkEndLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_RouteIndoorParkEndLayerItemImpl_addMarker(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return routeIndoorParkEndLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_clearAllMarkers(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        routeIndoorParkEndLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_RouteIndoorParkEndLayerItemImpl_setForeshorteningCoef(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        routeIndoorParkEndLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_RouteIndoorParkEndLayerItemImpl_getForeshorteningCoef(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        return routeIndoorParkEndLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_resetOnVisible(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, boolean z) {
        energyKeyPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_onVisible(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, boolean z) {
        energyKeyPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_getOnVisible(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_applyOnVisible(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        energyKeyPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_EnergyKeyPointLayerItemImpl_getBound(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_getVisible(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_EnergyKeyPointLayerItemImpl_getPriority(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_isAreaCollision(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setAreaCollision(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, boolean z) {
        energyKeyPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_EnergyKeyPointLayerItemImpl_getItemType(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_setID(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, String str) {
        return energyKeyPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_EnergyKeyPointLayerItemImpl_getID(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_setInfo(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, String str) {
        return energyKeyPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_EnergyKeyPointLayerItemImpl_getInfo(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setPriority(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, int i) {
        energyKeyPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setVisible(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, boolean z) {
        energyKeyPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_getFocus(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setAlpha(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, double d) {
        energyKeyPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_EnergyKeyPointLayerItemImpl_getAlpha(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setAngle(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, double d) {
        energyKeyPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_EnergyKeyPointLayerItemImpl_getAngle(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setPitch(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, double d) {
        energyKeyPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_EnergyKeyPointLayerItemImpl_getPitch(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setMaxPitch(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, double d) {
        energyKeyPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_EnergyKeyPointLayerItemImpl_getMaxPitch(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setDisplayScale(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, LayerScale layerScale) {
        energyKeyPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_EnergyKeyPointLayerItemImpl_getDisplayScale(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setAnimation(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        energyKeyPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setStyle__SWIG_0(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        energyKeyPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setStyle__SWIG_1(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, String str) {
        energyKeyPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_updateStyle__SWIG_0(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        energyKeyPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_updateStyle__SWIG_1(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        energyKeyPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_addPoiFilter(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        energyKeyPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_removePoiFilter(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        energyKeyPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_onPaint(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        energyKeyPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setParent(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        energyKeyPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setBusinessType(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, int i) {
        energyKeyPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_EnergyKeyPointLayerItemImpl_getBusinessType(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_EnergyKeyPointLayerItemImpl_getTypeIdName(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_clearStyle(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        energyKeyPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setVisible3V(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Visible3V visible3V) {
        energyKeyPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_getVisible3V(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Visible3V visible3V) {
        energyKeyPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setBillboard(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, boolean z) {
        energyKeyPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_getBillboard(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setPosition3D(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        energyKeyPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setRotateCenter3D(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        energyKeyPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_getRotateCenter3D(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        energyKeyPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setPosition(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        energyKeyPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_getPosition(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        energyKeyPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setRotateCenter(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        energyKeyPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_getNormalStyle(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        energyKeyPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_getFocusStyle(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        energyKeyPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setItemVisibleRegion(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, RectInt rectInt) {
        energyKeyPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setItemIgnoreRegion(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        energyKeyPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_getItemIgnoreRegion(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        energyKeyPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setScale(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        energyKeyPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_getScale(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        energyKeyPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setPointTypeCode(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, String str) {
        energyKeyPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_EnergyKeyPointLayerItemImpl_getPointTypeCode(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setScaleFactor(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, float[] fArr) {
        energyKeyPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setRotateMode(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        energyKeyPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_EnergyKeyPointLayerItemImpl_addMarker(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return energyKeyPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_clearAllMarkers(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        energyKeyPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_EnergyKeyPointLayerItemImpl_setForeshorteningCoef(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        energyKeyPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_EnergyKeyPointLayerItemImpl_getForeshorteningCoef(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        return energyKeyPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_resetOnVisible(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, boolean z) {
        threeUrgentLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_onVisible(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, boolean z) {
        threeUrgentLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_getOnVisible(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_applyOnVisible(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        threeUrgentLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_ThreeUrgentLayerItemImpl_getBound(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_getVisible(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getVisible();
    }

    public static int SwigDirector_ThreeUrgentLayerItemImpl_getPriority(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_isAreaCollision(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setAreaCollision(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, boolean z) {
        threeUrgentLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_ThreeUrgentLayerItemImpl_getItemType(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_setID(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, String str) {
        return threeUrgentLayerItemImpl.setID(str);
    }

    public static String SwigDirector_ThreeUrgentLayerItemImpl_getID(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getID();
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_setInfo(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, String str) {
        return threeUrgentLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_ThreeUrgentLayerItemImpl_getInfo(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getInfo();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setPriority(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, int i) {
        threeUrgentLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setVisible(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, boolean z) {
        threeUrgentLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_getFocus(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getFocus();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setAlpha(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, double d) {
        threeUrgentLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_ThreeUrgentLayerItemImpl_getAlpha(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setAngle(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, double d) {
        threeUrgentLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_ThreeUrgentLayerItemImpl_getAngle(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getAngle();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setPitch(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, double d) {
        threeUrgentLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_ThreeUrgentLayerItemImpl_getPitch(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getPitch();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setMaxPitch(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, double d) {
        threeUrgentLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_ThreeUrgentLayerItemImpl_getMaxPitch(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setDisplayScale(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, LayerScale layerScale) {
        threeUrgentLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_ThreeUrgentLayerItemImpl_getDisplayScale(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setAnimation(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        threeUrgentLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setStyle__SWIG_0(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        threeUrgentLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setStyle__SWIG_1(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, String str) {
        threeUrgentLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_updateStyle__SWIG_0(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        threeUrgentLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_updateStyle__SWIG_1(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, LayerItemImpl layerItemImpl) {
        threeUrgentLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_addPoiFilter(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        threeUrgentLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_removePoiFilter(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        threeUrgentLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_onPaint(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        threeUrgentLayerItemImpl.onPaint();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setParent(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        threeUrgentLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setBusinessType(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, int i) {
        threeUrgentLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_ThreeUrgentLayerItemImpl_getBusinessType(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_ThreeUrgentLayerItemImpl_getTypeIdName(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_clearStyle(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        threeUrgentLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setVisible3V(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Visible3V visible3V) {
        threeUrgentLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_getVisible3V(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Visible3V visible3V) {
        threeUrgentLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setBillboard(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, boolean z) {
        threeUrgentLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_getBillboard(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setPosition3D(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Coord3DDouble coord3DDouble) {
        threeUrgentLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setRotateCenter3D(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Coord3DDouble coord3DDouble) {
        threeUrgentLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_getRotateCenter3D(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Coord3DDouble coord3DDouble) {
        threeUrgentLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setPosition(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Coord3DDouble coord3DDouble) {
        threeUrgentLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_getPosition(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Coord3DDouble coord3DDouble) {
        threeUrgentLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setRotateCenter(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, Coord3DDouble coord3DDouble) {
        threeUrgentLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_getNormalStyle(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        threeUrgentLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_getFocusStyle(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        threeUrgentLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setItemVisibleRegion(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, RectInt rectInt) {
        threeUrgentLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setItemIgnoreRegion(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        threeUrgentLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_getItemIgnoreRegion(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        threeUrgentLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setScale(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        threeUrgentLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_getScale(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, ScaleAttribute scaleAttribute) {
        threeUrgentLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setPointTypeCode(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, String str) {
        threeUrgentLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_ThreeUrgentLayerItemImpl_getPointTypeCode(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setScaleFactor(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, float[] fArr) {
        threeUrgentLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setRotateMode(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, @RotateMode.RotateMode1 int i) {
        threeUrgentLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_ThreeUrgentLayerItemImpl_addMarker(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return threeUrgentLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_clearAllMarkers(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        threeUrgentLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_ThreeUrgentLayerItemImpl_setForeshorteningCoef(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        threeUrgentLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_ThreeUrgentLayerItemImpl_getForeshorteningCoef(ThreeUrgentLayerItemImpl threeUrgentLayerItemImpl) {
        return threeUrgentLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_OddLayerItemImpl_resetOnVisible(OddLayerItemImpl oddLayerItemImpl, boolean z) {
        oddLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_OddLayerItemImpl_onVisible(OddLayerItemImpl oddLayerItemImpl, boolean z) {
        oddLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_OddLayerItemImpl_getOnVisible(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_OddLayerItemImpl_applyOnVisible(OddLayerItemImpl oddLayerItemImpl) {
        oddLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_OddLayerItemImpl_getBound(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_OddLayerItemImpl_getVisible(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getVisible();
    }

    public static int SwigDirector_OddLayerItemImpl_getPriority(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_OddLayerItemImpl_isAreaCollision(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_OddLayerItemImpl_setAreaCollision(OddLayerItemImpl oddLayerItemImpl, boolean z) {
        oddLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_OddLayerItemImpl_getItemType(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_OddLayerItemImpl_setID(OddLayerItemImpl oddLayerItemImpl, String str) {
        return oddLayerItemImpl.setID(str);
    }

    public static String SwigDirector_OddLayerItemImpl_getID(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getID();
    }

    public static boolean SwigDirector_OddLayerItemImpl_setInfo(OddLayerItemImpl oddLayerItemImpl, String str) {
        return oddLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_OddLayerItemImpl_getInfo(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getInfo();
    }

    public static void SwigDirector_OddLayerItemImpl_setPriority(OddLayerItemImpl oddLayerItemImpl, int i) {
        oddLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_OddLayerItemImpl_setVisible(OddLayerItemImpl oddLayerItemImpl, boolean z) {
        oddLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_OddLayerItemImpl_getFocus(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getFocus();
    }

    public static void SwigDirector_OddLayerItemImpl_setAlpha(OddLayerItemImpl oddLayerItemImpl, double d) {
        oddLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_OddLayerItemImpl_getAlpha(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_OddLayerItemImpl_setAngle(OddLayerItemImpl oddLayerItemImpl, double d) {
        oddLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_OddLayerItemImpl_getAngle(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getAngle();
    }

    public static void SwigDirector_OddLayerItemImpl_setPitch(OddLayerItemImpl oddLayerItemImpl, double d) {
        oddLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_OddLayerItemImpl_getPitch(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getPitch();
    }

    public static void SwigDirector_OddLayerItemImpl_setMaxPitch(OddLayerItemImpl oddLayerItemImpl, double d) {
        oddLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_OddLayerItemImpl_getMaxPitch(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_OddLayerItemImpl_setDisplayScale(OddLayerItemImpl oddLayerItemImpl, LayerScale layerScale) {
        oddLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_OddLayerItemImpl_getDisplayScale(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_OddLayerItemImpl_setAnimation(OddLayerItemImpl oddLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        oddLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_OddLayerItemImpl_setStyle__SWIG_0(OddLayerItemImpl oddLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        oddLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_OddLayerItemImpl_setStyle__SWIG_1(OddLayerItemImpl oddLayerItemImpl, String str) {
        oddLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_OddLayerItemImpl_updateStyle__SWIG_0(OddLayerItemImpl oddLayerItemImpl) {
        oddLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_OddLayerItemImpl_updateStyle__SWIG_1(OddLayerItemImpl oddLayerItemImpl, LayerItemImpl layerItemImpl) {
        oddLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_OddLayerItemImpl_addPoiFilter(OddLayerItemImpl oddLayerItemImpl) {
        oddLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_OddLayerItemImpl_removePoiFilter(OddLayerItemImpl oddLayerItemImpl) {
        oddLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_OddLayerItemImpl_onPaint(OddLayerItemImpl oddLayerItemImpl) {
        oddLayerItemImpl.onPaint();
    }

    public static void SwigDirector_OddLayerItemImpl_setParent(OddLayerItemImpl oddLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        oddLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_OddLayerItemImpl_setBusinessType(OddLayerItemImpl oddLayerItemImpl, int i) {
        oddLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_OddLayerItemImpl_getBusinessType(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_OddLayerItemImpl_getTypeIdName(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_OddLayerItemImpl_clearStyle(OddLayerItemImpl oddLayerItemImpl) {
        oddLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_OddLayerItemImpl_setVisible3V(OddLayerItemImpl oddLayerItemImpl, Visible3V visible3V) {
        oddLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_OddLayerItemImpl_getVisible3V(OddLayerItemImpl oddLayerItemImpl, Visible3V visible3V) {
        oddLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_OddLayerItemImpl_setBillboard(OddLayerItemImpl oddLayerItemImpl, boolean z) {
        oddLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_OddLayerItemImpl_getBillboard(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_OddLayerItemImpl_setPosition3D(OddLayerItemImpl oddLayerItemImpl, Coord3DDouble coord3DDouble) {
        oddLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_OddLayerItemImpl_setRotateCenter3D(OddLayerItemImpl oddLayerItemImpl, Coord3DDouble coord3DDouble) {
        oddLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_OddLayerItemImpl_getRotateCenter3D(OddLayerItemImpl oddLayerItemImpl, Coord3DDouble coord3DDouble) {
        oddLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_OddLayerItemImpl_setPosition(OddLayerItemImpl oddLayerItemImpl, Coord3DDouble coord3DDouble) {
        oddLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_OddLayerItemImpl_getPosition(OddLayerItemImpl oddLayerItemImpl, Coord3DDouble coord3DDouble) {
        oddLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_OddLayerItemImpl_setRotateCenter(OddLayerItemImpl oddLayerItemImpl, Coord3DDouble coord3DDouble) {
        oddLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_OddLayerItemImpl_getNormalStyle(OddLayerItemImpl oddLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        oddLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_OddLayerItemImpl_getFocusStyle(OddLayerItemImpl oddLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        oddLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_OddLayerItemImpl_setItemVisibleRegion(OddLayerItemImpl oddLayerItemImpl, RectInt rectInt) {
        oddLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_OddLayerItemImpl_setItemIgnoreRegion(OddLayerItemImpl oddLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        oddLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_OddLayerItemImpl_getItemIgnoreRegion(OddLayerItemImpl oddLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        oddLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_OddLayerItemImpl_setScale(OddLayerItemImpl oddLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        oddLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_OddLayerItemImpl_getScale(OddLayerItemImpl oddLayerItemImpl, ScaleAttribute scaleAttribute) {
        oddLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_OddLayerItemImpl_setPointTypeCode(OddLayerItemImpl oddLayerItemImpl, String str) {
        oddLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_OddLayerItemImpl_getPointTypeCode(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_OddLayerItemImpl_setScaleFactor(OddLayerItemImpl oddLayerItemImpl, float[] fArr) {
        oddLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_OddLayerItemImpl_setRotateMode(OddLayerItemImpl oddLayerItemImpl, @RotateMode.RotateMode1 int i) {
        oddLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_OddLayerItemImpl_addMarker(OddLayerItemImpl oddLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return oddLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_OddLayerItemImpl_clearAllMarkers(OddLayerItemImpl oddLayerItemImpl) {
        oddLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_OddLayerItemImpl_setForeshorteningCoef(OddLayerItemImpl oddLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        oddLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_OddLayerItemImpl_getForeshorteningCoef(OddLayerItemImpl oddLayerItemImpl) {
        return oddLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_ViaETALayerItemImpl_resetOnVisible(ViaETALayerItemImpl viaETALayerItemImpl, boolean z) {
        viaETALayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_ViaETALayerItemImpl_onVisible(ViaETALayerItemImpl viaETALayerItemImpl, boolean z) {
        viaETALayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_getOnVisible(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_ViaETALayerItemImpl_applyOnVisible(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_ViaETALayerItemImpl_getBound(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getBound();
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_getVisible(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getVisible();
    }

    public static int SwigDirector_ViaETALayerItemImpl_getPriority(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_isAreaCollision(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setAreaCollision(ViaETALayerItemImpl viaETALayerItemImpl, boolean z) {
        viaETALayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_ViaETALayerItemImpl_getItemType(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_setID(ViaETALayerItemImpl viaETALayerItemImpl, String str) {
        return viaETALayerItemImpl.setID(str);
    }

    public static String SwigDirector_ViaETALayerItemImpl_getID(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getID();
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_setInfo(ViaETALayerItemImpl viaETALayerItemImpl, String str) {
        return viaETALayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_ViaETALayerItemImpl_getInfo(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getInfo();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setPriority(ViaETALayerItemImpl viaETALayerItemImpl, int i) {
        viaETALayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setVisible(ViaETALayerItemImpl viaETALayerItemImpl, boolean z) {
        viaETALayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_getFocus(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getFocus();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setAlpha(ViaETALayerItemImpl viaETALayerItemImpl, double d) {
        viaETALayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_ViaETALayerItemImpl_getAlpha(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getAlpha();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setAngle(ViaETALayerItemImpl viaETALayerItemImpl, double d) {
        viaETALayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_ViaETALayerItemImpl_getAngle(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getAngle();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setPitch(ViaETALayerItemImpl viaETALayerItemImpl, double d) {
        viaETALayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_ViaETALayerItemImpl_getPitch(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getPitch();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setMaxPitch(ViaETALayerItemImpl viaETALayerItemImpl, double d) {
        viaETALayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_ViaETALayerItemImpl_getMaxPitch(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setDisplayScale(ViaETALayerItemImpl viaETALayerItemImpl, LayerScale layerScale) {
        viaETALayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_ViaETALayerItemImpl_getDisplayScale(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setAnimation(ViaETALayerItemImpl viaETALayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        viaETALayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setStyle__SWIG_0(ViaETALayerItemImpl viaETALayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        viaETALayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setStyle__SWIG_1(ViaETALayerItemImpl viaETALayerItemImpl, String str) {
        viaETALayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_ViaETALayerItemImpl_updateStyle__SWIG_0(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.updateStyle();
    }

    public static void SwigDirector_ViaETALayerItemImpl_updateStyle__SWIG_1(ViaETALayerItemImpl viaETALayerItemImpl, LayerItemImpl layerItemImpl) {
        viaETALayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_ViaETALayerItemImpl_addPoiFilter(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_ViaETALayerItemImpl_removePoiFilter(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_ViaETALayerItemImpl_onPaint(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.onPaint();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setParent(ViaETALayerItemImpl viaETALayerItemImpl, BaseLayerImpl baseLayerImpl) {
        viaETALayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setBusinessType(ViaETALayerItemImpl viaETALayerItemImpl, int i) {
        viaETALayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_ViaETALayerItemImpl_getBusinessType(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_ViaETALayerItemImpl_getTypeIdName(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_ViaETALayerItemImpl_clearStyle(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.clearStyle();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setVisible3V(ViaETALayerItemImpl viaETALayerItemImpl, Visible3V visible3V) {
        viaETALayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_ViaETALayerItemImpl_getVisible3V(ViaETALayerItemImpl viaETALayerItemImpl, Visible3V visible3V) {
        viaETALayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setBillboard(ViaETALayerItemImpl viaETALayerItemImpl, boolean z) {
        viaETALayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_getBillboard(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getBillboard();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setPosition3D(ViaETALayerItemImpl viaETALayerItemImpl, Coord3DDouble coord3DDouble) {
        viaETALayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setRotateCenter3D(ViaETALayerItemImpl viaETALayerItemImpl, Coord3DDouble coord3DDouble) {
        viaETALayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_ViaETALayerItemImpl_getRotateCenter3D(ViaETALayerItemImpl viaETALayerItemImpl, Coord3DDouble coord3DDouble) {
        viaETALayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setPosition(ViaETALayerItemImpl viaETALayerItemImpl, Coord3DDouble coord3DDouble) {
        viaETALayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_ViaETALayerItemImpl_getPosition(ViaETALayerItemImpl viaETALayerItemImpl, Coord3DDouble coord3DDouble) {
        viaETALayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setRotateCenter(ViaETALayerItemImpl viaETALayerItemImpl, Coord3DDouble coord3DDouble) {
        viaETALayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_ViaETALayerItemImpl_getNormalStyle(ViaETALayerItemImpl viaETALayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        viaETALayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_ViaETALayerItemImpl_getFocusStyle(ViaETALayerItemImpl viaETALayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        viaETALayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setItemVisibleRegion(ViaETALayerItemImpl viaETALayerItemImpl, RectInt rectInt) {
        viaETALayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setItemIgnoreRegion(ViaETALayerItemImpl viaETALayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        viaETALayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_ViaETALayerItemImpl_getItemIgnoreRegion(ViaETALayerItemImpl viaETALayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        viaETALayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setScale(ViaETALayerItemImpl viaETALayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        viaETALayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_ViaETALayerItemImpl_getScale(ViaETALayerItemImpl viaETALayerItemImpl, ScaleAttribute scaleAttribute) {
        viaETALayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setPointTypeCode(ViaETALayerItemImpl viaETALayerItemImpl, String str) {
        viaETALayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_ViaETALayerItemImpl_getPointTypeCode(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setScaleFactor(ViaETALayerItemImpl viaETALayerItemImpl, float[] fArr) {
        viaETALayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_ViaETALayerItemImpl_setRotateMode(ViaETALayerItemImpl viaETALayerItemImpl, @RotateMode.RotateMode1 int i) {
        viaETALayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_addMarker(ViaETALayerItemImpl viaETALayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return viaETALayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_ViaETALayerItemImpl_clearAllMarkers(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setForeshorteningCoef(ViaETALayerItemImpl viaETALayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        viaETALayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_ViaETALayerItemImpl_getForeshorteningCoef(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_ViaETALayerItemImpl_setIdle(ViaETALayerItemImpl viaETALayerItemImpl, boolean z) {
        viaETALayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_isIdle(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.isIdle();
    }

    public static void SwigDirector_ViaETALayerItemImpl_addIntersectArea(ViaETALayerItemImpl viaETALayerItemImpl, float f) {
        viaETALayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_ViaETALayerItemImpl_getIntersectArea(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_ViaETALayerItemImpl_resetIntersectArea(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_ViaETALayerItemImpl_addIntersectAreaEx(ViaETALayerItemImpl viaETALayerItemImpl, float f) {
        viaETALayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_ViaETALayerItemImpl_getIntersectAreaEx(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_ViaETALayerItemImpl_resetIntersectAreaEx(ViaETALayerItemImpl viaETALayerItemImpl) {
        viaETALayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_ViaETALayerItemImpl_checkShowFlag(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_ViaETALayerItemImpl_getQuadrantGroupId(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_ViaETALayerItemImpl_getQuadrantType(ViaETALayerItemImpl viaETALayerItemImpl) {
        return viaETALayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_resetOnVisible(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, boolean z) {
        pathTMCPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_onVisible(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, boolean z) {
        pathTMCPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_getOnVisible(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_applyOnVisible(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_PathTMCPointLayerItemImpl_getBound(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_getVisible(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_PathTMCPointLayerItemImpl_getPriority(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_isAreaCollision(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setAreaCollision(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, boolean z) {
        pathTMCPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_PathTMCPointLayerItemImpl_getItemType(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_setID(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, String str) {
        return pathTMCPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_PathTMCPointLayerItemImpl_getID(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_setInfo(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, String str) {
        return pathTMCPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_PathTMCPointLayerItemImpl_getInfo(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setPriority(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, int i) {
        pathTMCPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setVisible(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, boolean z) {
        pathTMCPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_getFocus(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setAlpha(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, double d) {
        pathTMCPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_PathTMCPointLayerItemImpl_getAlpha(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setAngle(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, double d) {
        pathTMCPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_PathTMCPointLayerItemImpl_getAngle(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setPitch(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, double d) {
        pathTMCPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_PathTMCPointLayerItemImpl_getPitch(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setMaxPitch(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, double d) {
        pathTMCPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_PathTMCPointLayerItemImpl_getMaxPitch(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setDisplayScale(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, LayerScale layerScale) {
        pathTMCPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_PathTMCPointLayerItemImpl_getDisplayScale(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setAnimation(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        pathTMCPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setStyle__SWIG_0(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        pathTMCPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setStyle__SWIG_1(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, String str) {
        pathTMCPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_updateStyle__SWIG_0(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_updateStyle__SWIG_1(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        pathTMCPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_addPoiFilter(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_removePoiFilter(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_onPaint(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setParent(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        pathTMCPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setBusinessType(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, int i) {
        pathTMCPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_PathTMCPointLayerItemImpl_getBusinessType(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_PathTMCPointLayerItemImpl_getTypeIdName(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_clearStyle(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setVisible3V(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Visible3V visible3V) {
        pathTMCPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_getVisible3V(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Visible3V visible3V) {
        pathTMCPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setBillboard(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, boolean z) {
        pathTMCPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_getBillboard(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setPosition3D(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathTMCPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setRotateCenter3D(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathTMCPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_getRotateCenter3D(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathTMCPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setPosition(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathTMCPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_getPosition(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathTMCPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setRotateCenter(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        pathTMCPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_getNormalStyle(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        pathTMCPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_getFocusStyle(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        pathTMCPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setItemVisibleRegion(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, RectInt rectInt) {
        pathTMCPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setItemIgnoreRegion(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        pathTMCPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_getItemIgnoreRegion(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        pathTMCPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setScale(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        pathTMCPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_getScale(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        pathTMCPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setPointTypeCode(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, String str) {
        pathTMCPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_PathTMCPointLayerItemImpl_getPointTypeCode(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setScaleFactor(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, float[] fArr) {
        pathTMCPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setRotateMode(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        pathTMCPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_addMarker(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return pathTMCPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_clearAllMarkers(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setForeshorteningCoef(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        pathTMCPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_PathTMCPointLayerItemImpl_getForeshorteningCoef(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_setIdle(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, boolean z) {
        pathTMCPointLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_isIdle(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.isIdle();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_addIntersectArea(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, float f) {
        pathTMCPointLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_PathTMCPointLayerItemImpl_getIntersectArea(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_resetIntersectArea(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_addIntersectAreaEx(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, float f) {
        pathTMCPointLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_PathTMCPointLayerItemImpl_getIntersectAreaEx(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_PathTMCPointLayerItemImpl_resetIntersectAreaEx(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        pathTMCPointLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_PathTMCPointLayerItemImpl_checkShowFlag(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_PathTMCPointLayerItemImpl_getQuadrantGroupId(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_PathTMCPointLayerItemImpl_getQuadrantType(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        return pathTMCPointLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_resetOnVisible(SearchParentLayerItemImpl searchParentLayerItemImpl, boolean z) {
        searchParentLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_onVisible(SearchParentLayerItemImpl searchParentLayerItemImpl, boolean z) {
        searchParentLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_getOnVisible(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_applyOnVisible(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        searchParentLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SearchParentLayerItemImpl_getBound(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_getVisible(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SearchParentLayerItemImpl_getPriority(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_isAreaCollision(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setAreaCollision(SearchParentLayerItemImpl searchParentLayerItemImpl, boolean z) {
        searchParentLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SearchParentLayerItemImpl_getItemType(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_setID(SearchParentLayerItemImpl searchParentLayerItemImpl, String str) {
        return searchParentLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SearchParentLayerItemImpl_getID(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_setInfo(SearchParentLayerItemImpl searchParentLayerItemImpl, String str) {
        return searchParentLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SearchParentLayerItemImpl_getInfo(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setPriority(SearchParentLayerItemImpl searchParentLayerItemImpl, int i) {
        searchParentLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setVisible(SearchParentLayerItemImpl searchParentLayerItemImpl, boolean z) {
        searchParentLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_getFocus(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setAlpha(SearchParentLayerItemImpl searchParentLayerItemImpl, double d) {
        searchParentLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SearchParentLayerItemImpl_getAlpha(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setAngle(SearchParentLayerItemImpl searchParentLayerItemImpl, double d) {
        searchParentLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SearchParentLayerItemImpl_getAngle(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setPitch(SearchParentLayerItemImpl searchParentLayerItemImpl, double d) {
        searchParentLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SearchParentLayerItemImpl_getPitch(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setMaxPitch(SearchParentLayerItemImpl searchParentLayerItemImpl, double d) {
        searchParentLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SearchParentLayerItemImpl_getMaxPitch(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setDisplayScale(SearchParentLayerItemImpl searchParentLayerItemImpl, LayerScale layerScale) {
        searchParentLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SearchParentLayerItemImpl_getDisplayScale(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setAnimation(SearchParentLayerItemImpl searchParentLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        searchParentLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setStyle__SWIG_0(SearchParentLayerItemImpl searchParentLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        searchParentLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setStyle__SWIG_1(SearchParentLayerItemImpl searchParentLayerItemImpl, String str) {
        searchParentLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_updateStyle__SWIG_0(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        searchParentLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_updateStyle__SWIG_1(SearchParentLayerItemImpl searchParentLayerItemImpl, LayerItemImpl layerItemImpl) {
        searchParentLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_addPoiFilter(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        searchParentLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_removePoiFilter(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        searchParentLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_onPaint(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        searchParentLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setParent(SearchParentLayerItemImpl searchParentLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        searchParentLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setBusinessType(SearchParentLayerItemImpl searchParentLayerItemImpl, int i) {
        searchParentLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SearchParentLayerItemImpl_getBusinessType(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SearchParentLayerItemImpl_getTypeIdName(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_clearStyle(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        searchParentLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setVisible3V(SearchParentLayerItemImpl searchParentLayerItemImpl, Visible3V visible3V) {
        searchParentLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_getVisible3V(SearchParentLayerItemImpl searchParentLayerItemImpl, Visible3V visible3V) {
        searchParentLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setBillboard(SearchParentLayerItemImpl searchParentLayerItemImpl, boolean z) {
        searchParentLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_getBillboard(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setPosition3D(SearchParentLayerItemImpl searchParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchParentLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setRotateCenter3D(SearchParentLayerItemImpl searchParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchParentLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_getRotateCenter3D(SearchParentLayerItemImpl searchParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchParentLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setPosition(SearchParentLayerItemImpl searchParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchParentLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_getPosition(SearchParentLayerItemImpl searchParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchParentLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setRotateCenter(SearchParentLayerItemImpl searchParentLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchParentLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_getNormalStyle(SearchParentLayerItemImpl searchParentLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchParentLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_getFocusStyle(SearchParentLayerItemImpl searchParentLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchParentLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setItemVisibleRegion(SearchParentLayerItemImpl searchParentLayerItemImpl, RectInt rectInt) {
        searchParentLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setItemIgnoreRegion(SearchParentLayerItemImpl searchParentLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchParentLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_getItemIgnoreRegion(SearchParentLayerItemImpl searchParentLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchParentLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setScale(SearchParentLayerItemImpl searchParentLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        searchParentLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_getScale(SearchParentLayerItemImpl searchParentLayerItemImpl, ScaleAttribute scaleAttribute) {
        searchParentLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setPointTypeCode(SearchParentLayerItemImpl searchParentLayerItemImpl, String str) {
        searchParentLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_SearchParentLayerItemImpl_getPointTypeCode(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setScaleFactor(SearchParentLayerItemImpl searchParentLayerItemImpl, float[] fArr) {
        searchParentLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setRotateMode(SearchParentLayerItemImpl searchParentLayerItemImpl, @RotateMode.RotateMode1 int i) {
        searchParentLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SearchParentLayerItemImpl_addMarker(SearchParentLayerItemImpl searchParentLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return searchParentLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SearchParentLayerItemImpl_clearAllMarkers(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        searchParentLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_SearchParentLayerItemImpl_setForeshorteningCoef(SearchParentLayerItemImpl searchParentLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        searchParentLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_SearchParentLayerItemImpl_getForeshorteningCoef(SearchParentLayerItemImpl searchParentLayerItemImpl) {
        return searchParentLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_resetOnVisible(SearchChildLayerItemImpl searchChildLayerItemImpl, boolean z) {
        searchChildLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_onVisible(SearchChildLayerItemImpl searchChildLayerItemImpl, boolean z) {
        searchChildLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_getOnVisible(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_applyOnVisible(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        searchChildLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SearchChildLayerItemImpl_getBound(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_getVisible(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SearchChildLayerItemImpl_getPriority(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_isAreaCollision(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setAreaCollision(SearchChildLayerItemImpl searchChildLayerItemImpl, boolean z) {
        searchChildLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SearchChildLayerItemImpl_getItemType(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_setID(SearchChildLayerItemImpl searchChildLayerItemImpl, String str) {
        return searchChildLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SearchChildLayerItemImpl_getID(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_setInfo(SearchChildLayerItemImpl searchChildLayerItemImpl, String str) {
        return searchChildLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SearchChildLayerItemImpl_getInfo(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setPriority(SearchChildLayerItemImpl searchChildLayerItemImpl, int i) {
        searchChildLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setVisible(SearchChildLayerItemImpl searchChildLayerItemImpl, boolean z) {
        searchChildLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_getFocus(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setAlpha(SearchChildLayerItemImpl searchChildLayerItemImpl, double d) {
        searchChildLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SearchChildLayerItemImpl_getAlpha(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setAngle(SearchChildLayerItemImpl searchChildLayerItemImpl, double d) {
        searchChildLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SearchChildLayerItemImpl_getAngle(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setPitch(SearchChildLayerItemImpl searchChildLayerItemImpl, double d) {
        searchChildLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SearchChildLayerItemImpl_getPitch(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setMaxPitch(SearchChildLayerItemImpl searchChildLayerItemImpl, double d) {
        searchChildLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SearchChildLayerItemImpl_getMaxPitch(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setDisplayScale(SearchChildLayerItemImpl searchChildLayerItemImpl, LayerScale layerScale) {
        searchChildLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SearchChildLayerItemImpl_getDisplayScale(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setAnimation(SearchChildLayerItemImpl searchChildLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        searchChildLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setStyle__SWIG_0(SearchChildLayerItemImpl searchChildLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        searchChildLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setStyle__SWIG_1(SearchChildLayerItemImpl searchChildLayerItemImpl, String str) {
        searchChildLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_updateStyle__SWIG_0(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        searchChildLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_updateStyle__SWIG_1(SearchChildLayerItemImpl searchChildLayerItemImpl, LayerItemImpl layerItemImpl) {
        searchChildLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_addPoiFilter(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        searchChildLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_removePoiFilter(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        searchChildLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_onPaint(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        searchChildLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setParent(SearchChildLayerItemImpl searchChildLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        searchChildLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setBusinessType(SearchChildLayerItemImpl searchChildLayerItemImpl, int i) {
        searchChildLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SearchChildLayerItemImpl_getBusinessType(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SearchChildLayerItemImpl_getTypeIdName(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_clearStyle(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        searchChildLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setVisible3V(SearchChildLayerItemImpl searchChildLayerItemImpl, Visible3V visible3V) {
        searchChildLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_getVisible3V(SearchChildLayerItemImpl searchChildLayerItemImpl, Visible3V visible3V) {
        searchChildLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setBillboard(SearchChildLayerItemImpl searchChildLayerItemImpl, boolean z) {
        searchChildLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_getBillboard(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setPosition3D(SearchChildLayerItemImpl searchChildLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChildLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setRotateCenter3D(SearchChildLayerItemImpl searchChildLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChildLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_getRotateCenter3D(SearchChildLayerItemImpl searchChildLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChildLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setPosition(SearchChildLayerItemImpl searchChildLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChildLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_getPosition(SearchChildLayerItemImpl searchChildLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChildLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setRotateCenter(SearchChildLayerItemImpl searchChildLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChildLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_getNormalStyle(SearchChildLayerItemImpl searchChildLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchChildLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_getFocusStyle(SearchChildLayerItemImpl searchChildLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchChildLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setItemVisibleRegion(SearchChildLayerItemImpl searchChildLayerItemImpl, RectInt rectInt) {
        searchChildLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setItemIgnoreRegion(SearchChildLayerItemImpl searchChildLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchChildLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_getItemIgnoreRegion(SearchChildLayerItemImpl searchChildLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchChildLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setScale(SearchChildLayerItemImpl searchChildLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        searchChildLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_getScale(SearchChildLayerItemImpl searchChildLayerItemImpl, ScaleAttribute scaleAttribute) {
        searchChildLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setPointTypeCode(SearchChildLayerItemImpl searchChildLayerItemImpl, String str) {
        searchChildLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_SearchChildLayerItemImpl_getPointTypeCode(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setScaleFactor(SearchChildLayerItemImpl searchChildLayerItemImpl, float[] fArr) {
        searchChildLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setRotateMode(SearchChildLayerItemImpl searchChildLayerItemImpl, @RotateMode.RotateMode1 int i) {
        searchChildLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SearchChildLayerItemImpl_addMarker(SearchChildLayerItemImpl searchChildLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return searchChildLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SearchChildLayerItemImpl_clearAllMarkers(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        searchChildLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_SearchChildLayerItemImpl_setForeshorteningCoef(SearchChildLayerItemImpl searchChildLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        searchChildLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_SearchChildLayerItemImpl_getForeshorteningCoef(SearchChildLayerItemImpl searchChildLayerItemImpl) {
        return searchChildLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_resetOnVisible(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, boolean z) {
        searchExitEntranceLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_onVisible(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, boolean z) {
        searchExitEntranceLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_getOnVisible(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_applyOnVisible(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        searchExitEntranceLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SearchExitEntranceLayerItemImpl_getBound(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_getVisible(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SearchExitEntranceLayerItemImpl_getPriority(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_isAreaCollision(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setAreaCollision(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, boolean z) {
        searchExitEntranceLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SearchExitEntranceLayerItemImpl_getItemType(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_setID(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, String str) {
        return searchExitEntranceLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SearchExitEntranceLayerItemImpl_getID(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_setInfo(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, String str) {
        return searchExitEntranceLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SearchExitEntranceLayerItemImpl_getInfo(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setPriority(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, int i) {
        searchExitEntranceLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setVisible(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, boolean z) {
        searchExitEntranceLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_getFocus(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setAlpha(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, double d) {
        searchExitEntranceLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SearchExitEntranceLayerItemImpl_getAlpha(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setAngle(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, double d) {
        searchExitEntranceLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SearchExitEntranceLayerItemImpl_getAngle(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setPitch(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, double d) {
        searchExitEntranceLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SearchExitEntranceLayerItemImpl_getPitch(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setMaxPitch(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, double d) {
        searchExitEntranceLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SearchExitEntranceLayerItemImpl_getMaxPitch(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setDisplayScale(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, LayerScale layerScale) {
        searchExitEntranceLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SearchExitEntranceLayerItemImpl_getDisplayScale(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setAnimation(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        searchExitEntranceLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setStyle__SWIG_0(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        searchExitEntranceLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setStyle__SWIG_1(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, String str) {
        searchExitEntranceLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_updateStyle__SWIG_0(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        searchExitEntranceLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_updateStyle__SWIG_1(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, LayerItemImpl layerItemImpl) {
        searchExitEntranceLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_addPoiFilter(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        searchExitEntranceLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_removePoiFilter(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        searchExitEntranceLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_onPaint(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        searchExitEntranceLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setParent(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        searchExitEntranceLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setBusinessType(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, int i) {
        searchExitEntranceLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SearchExitEntranceLayerItemImpl_getBusinessType(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SearchExitEntranceLayerItemImpl_getTypeIdName(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_clearStyle(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        searchExitEntranceLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setVisible3V(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Visible3V visible3V) {
        searchExitEntranceLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_getVisible3V(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Visible3V visible3V) {
        searchExitEntranceLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setBillboard(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, boolean z) {
        searchExitEntranceLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_getBillboard(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setPosition3D(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchExitEntranceLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setRotateCenter3D(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchExitEntranceLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_getRotateCenter3D(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchExitEntranceLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setPosition(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchExitEntranceLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_getPosition(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchExitEntranceLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setRotateCenter(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchExitEntranceLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_getNormalStyle(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchExitEntranceLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_getFocusStyle(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchExitEntranceLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setItemVisibleRegion(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, RectInt rectInt) {
        searchExitEntranceLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setItemIgnoreRegion(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchExitEntranceLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_getItemIgnoreRegion(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchExitEntranceLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setScale(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        searchExitEntranceLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_getScale(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, ScaleAttribute scaleAttribute) {
        searchExitEntranceLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setPointTypeCode(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, String str) {
        searchExitEntranceLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_SearchExitEntranceLayerItemImpl_getPointTypeCode(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setScaleFactor(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, float[] fArr) {
        searchExitEntranceLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setRotateMode(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, @RotateMode.RotateMode1 int i) {
        searchExitEntranceLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SearchExitEntranceLayerItemImpl_addMarker(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return searchExitEntranceLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_clearAllMarkers(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        searchExitEntranceLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_SearchExitEntranceLayerItemImpl_setForeshorteningCoef(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        searchExitEntranceLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_SearchExitEntranceLayerItemImpl_getForeshorteningCoef(SearchExitEntranceLayerItemImpl searchExitEntranceLayerItemImpl) {
        return searchExitEntranceLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_resetOnVisible(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, boolean z) {
        searchBeginEndLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_onVisible(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, boolean z) {
        searchBeginEndLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_getOnVisible(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_applyOnVisible(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        searchBeginEndLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SearchBeginEndLayerItemImpl_getBound(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_getVisible(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SearchBeginEndLayerItemImpl_getPriority(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_isAreaCollision(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setAreaCollision(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, boolean z) {
        searchBeginEndLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SearchBeginEndLayerItemImpl_getItemType(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_setID(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, String str) {
        return searchBeginEndLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SearchBeginEndLayerItemImpl_getID(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_setInfo(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, String str) {
        return searchBeginEndLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SearchBeginEndLayerItemImpl_getInfo(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setPriority(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, int i) {
        searchBeginEndLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setVisible(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, boolean z) {
        searchBeginEndLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_getFocus(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setAlpha(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, double d) {
        searchBeginEndLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SearchBeginEndLayerItemImpl_getAlpha(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setAngle(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, double d) {
        searchBeginEndLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SearchBeginEndLayerItemImpl_getAngle(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setPitch(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, double d) {
        searchBeginEndLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SearchBeginEndLayerItemImpl_getPitch(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setMaxPitch(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, double d) {
        searchBeginEndLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SearchBeginEndLayerItemImpl_getMaxPitch(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setDisplayScale(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, LayerScale layerScale) {
        searchBeginEndLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SearchBeginEndLayerItemImpl_getDisplayScale(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setAnimation(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        searchBeginEndLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setStyle__SWIG_0(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        searchBeginEndLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setStyle__SWIG_1(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, String str) {
        searchBeginEndLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_updateStyle__SWIG_0(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        searchBeginEndLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_updateStyle__SWIG_1(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, LayerItemImpl layerItemImpl) {
        searchBeginEndLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_addPoiFilter(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        searchBeginEndLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_removePoiFilter(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        searchBeginEndLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_onPaint(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        searchBeginEndLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setParent(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        searchBeginEndLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setBusinessType(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, int i) {
        searchBeginEndLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SearchBeginEndLayerItemImpl_getBusinessType(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SearchBeginEndLayerItemImpl_getTypeIdName(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_clearStyle(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        searchBeginEndLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setVisible3V(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Visible3V visible3V) {
        searchBeginEndLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_getVisible3V(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Visible3V visible3V) {
        searchBeginEndLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setBillboard(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, boolean z) {
        searchBeginEndLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_getBillboard(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setPosition3D(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchBeginEndLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setRotateCenter3D(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchBeginEndLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_getRotateCenter3D(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchBeginEndLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setPosition(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchBeginEndLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_getPosition(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchBeginEndLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setRotateCenter(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchBeginEndLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_getNormalStyle(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchBeginEndLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_getFocusStyle(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchBeginEndLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setItemVisibleRegion(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, RectInt rectInt) {
        searchBeginEndLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setItemIgnoreRegion(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchBeginEndLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_getItemIgnoreRegion(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchBeginEndLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setScale(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        searchBeginEndLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_getScale(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, ScaleAttribute scaleAttribute) {
        searchBeginEndLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setPointTypeCode(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, String str) {
        searchBeginEndLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_SearchBeginEndLayerItemImpl_getPointTypeCode(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setScaleFactor(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, float[] fArr) {
        searchBeginEndLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setRotateMode(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, @RotateMode.RotateMode1 int i) {
        searchBeginEndLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SearchBeginEndLayerItemImpl_addMarker(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return searchBeginEndLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_clearAllMarkers(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        searchBeginEndLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_SearchBeginEndLayerItemImpl_setForeshorteningCoef(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        searchBeginEndLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_SearchBeginEndLayerItemImpl_getForeshorteningCoef(SearchBeginEndLayerItemImpl searchBeginEndLayerItemImpl) {
        return searchBeginEndLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_resetOnVisible(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, boolean z) {
        searchAlongWayLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_onVisible(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, boolean z) {
        searchAlongWayLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_getOnVisible(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_applyOnVisible(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        searchAlongWayLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SearchAlongWayLayerItemImpl_getBound(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_getVisible(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SearchAlongWayLayerItemImpl_getPriority(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_isAreaCollision(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setAreaCollision(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, boolean z) {
        searchAlongWayLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SearchAlongWayLayerItemImpl_getItemType(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_setID(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, String str) {
        return searchAlongWayLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SearchAlongWayLayerItemImpl_getID(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_setInfo(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, String str) {
        return searchAlongWayLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SearchAlongWayLayerItemImpl_getInfo(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setPriority(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, int i) {
        searchAlongWayLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setVisible(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, boolean z) {
        searchAlongWayLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_getFocus(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setAlpha(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, double d) {
        searchAlongWayLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SearchAlongWayLayerItemImpl_getAlpha(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setAngle(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, double d) {
        searchAlongWayLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SearchAlongWayLayerItemImpl_getAngle(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setPitch(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, double d) {
        searchAlongWayLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SearchAlongWayLayerItemImpl_getPitch(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setMaxPitch(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, double d) {
        searchAlongWayLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SearchAlongWayLayerItemImpl_getMaxPitch(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setDisplayScale(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, LayerScale layerScale) {
        searchAlongWayLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SearchAlongWayLayerItemImpl_getDisplayScale(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setAnimation(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        searchAlongWayLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setStyle__SWIG_0(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        searchAlongWayLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setStyle__SWIG_1(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, String str) {
        searchAlongWayLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_updateStyle__SWIG_0(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        searchAlongWayLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_updateStyle__SWIG_1(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, LayerItemImpl layerItemImpl) {
        searchAlongWayLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_addPoiFilter(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        searchAlongWayLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_removePoiFilter(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        searchAlongWayLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_onPaint(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        searchAlongWayLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setParent(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        searchAlongWayLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setBusinessType(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, int i) {
        searchAlongWayLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SearchAlongWayLayerItemImpl_getBusinessType(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SearchAlongWayLayerItemImpl_getTypeIdName(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_clearStyle(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        searchAlongWayLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setVisible3V(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Visible3V visible3V) {
        searchAlongWayLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_getVisible3V(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Visible3V visible3V) {
        searchAlongWayLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setBillboard(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, boolean z) {
        searchAlongWayLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_getBillboard(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setPosition3D(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setRotateCenter3D(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_getRotateCenter3D(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setPosition(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_getPosition(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setRotateCenter(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_getNormalStyle(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchAlongWayLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_getFocusStyle(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchAlongWayLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setItemVisibleRegion(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, RectInt rectInt) {
        searchAlongWayLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setItemIgnoreRegion(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchAlongWayLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_getItemIgnoreRegion(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchAlongWayLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setScale(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        searchAlongWayLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_getScale(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, ScaleAttribute scaleAttribute) {
        searchAlongWayLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setPointTypeCode(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, String str) {
        searchAlongWayLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_SearchAlongWayLayerItemImpl_getPointTypeCode(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setScaleFactor(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, float[] fArr) {
        searchAlongWayLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setRotateMode(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, @RotateMode.RotateMode1 int i) {
        searchAlongWayLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SearchAlongWayLayerItemImpl_addMarker(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return searchAlongWayLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_clearAllMarkers(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        searchAlongWayLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_SearchAlongWayLayerItemImpl_setForeshorteningCoef(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        searchAlongWayLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_SearchAlongWayLayerItemImpl_getForeshorteningCoef(SearchAlongWayLayerItemImpl searchAlongWayLayerItemImpl) {
        return searchAlongWayLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_resetOnVisible(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, boolean z) {
        searchAlongWayPopLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_onVisible(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, boolean z) {
        searchAlongWayPopLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_getOnVisible(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_applyOnVisible(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SearchAlongWayPopLayerItemImpl_getBound(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_getVisible(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SearchAlongWayPopLayerItemImpl_getPriority(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_isAreaCollision(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setAreaCollision(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, boolean z) {
        searchAlongWayPopLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SearchAlongWayPopLayerItemImpl_getItemType(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_setID(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, String str) {
        return searchAlongWayPopLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SearchAlongWayPopLayerItemImpl_getID(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_setInfo(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, String str) {
        return searchAlongWayPopLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SearchAlongWayPopLayerItemImpl_getInfo(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setPriority(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, int i) {
        searchAlongWayPopLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setVisible(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, boolean z) {
        searchAlongWayPopLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_getFocus(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setAlpha(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, double d) {
        searchAlongWayPopLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SearchAlongWayPopLayerItemImpl_getAlpha(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setAngle(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, double d) {
        searchAlongWayPopLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SearchAlongWayPopLayerItemImpl_getAngle(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setPitch(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, double d) {
        searchAlongWayPopLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SearchAlongWayPopLayerItemImpl_getPitch(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setMaxPitch(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, double d) {
        searchAlongWayPopLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SearchAlongWayPopLayerItemImpl_getMaxPitch(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setDisplayScale(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, LayerScale layerScale) {
        searchAlongWayPopLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SearchAlongWayPopLayerItemImpl_getDisplayScale(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setAnimation(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        searchAlongWayPopLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setStyle__SWIG_0(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        searchAlongWayPopLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setStyle__SWIG_1(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, String str) {
        searchAlongWayPopLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_updateStyle__SWIG_0(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_updateStyle__SWIG_1(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, LayerItemImpl layerItemImpl) {
        searchAlongWayPopLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_addPoiFilter(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_removePoiFilter(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_onPaint(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setParent(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        searchAlongWayPopLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setBusinessType(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, int i) {
        searchAlongWayPopLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SearchAlongWayPopLayerItemImpl_getBusinessType(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SearchAlongWayPopLayerItemImpl_getTypeIdName(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_clearStyle(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setVisible3V(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Visible3V visible3V) {
        searchAlongWayPopLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_getVisible3V(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Visible3V visible3V) {
        searchAlongWayPopLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setBillboard(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, boolean z) {
        searchAlongWayPopLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_getBillboard(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setPosition3D(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayPopLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setRotateCenter3D(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayPopLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_getRotateCenter3D(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayPopLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setPosition(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayPopLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_getPosition(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayPopLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setRotateCenter(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchAlongWayPopLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_getNormalStyle(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchAlongWayPopLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_getFocusStyle(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchAlongWayPopLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setItemVisibleRegion(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, RectInt rectInt) {
        searchAlongWayPopLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setItemIgnoreRegion(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchAlongWayPopLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_getItemIgnoreRegion(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchAlongWayPopLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setScale(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        searchAlongWayPopLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_getScale(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, ScaleAttribute scaleAttribute) {
        searchAlongWayPopLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setPointTypeCode(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, String str) {
        searchAlongWayPopLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_SearchAlongWayPopLayerItemImpl_getPointTypeCode(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setScaleFactor(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, float[] fArr) {
        searchAlongWayPopLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setRotateMode(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, @RotateMode.RotateMode1 int i) {
        searchAlongWayPopLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_addMarker(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return searchAlongWayPopLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_clearAllMarkers(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setForeshorteningCoef(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        searchAlongWayPopLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_SearchAlongWayPopLayerItemImpl_getForeshorteningCoef(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_setIdle(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, boolean z) {
        searchAlongWayPopLayerItemImpl.setIdle(z);
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_isIdle(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.isIdle();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_addIntersectArea(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, float f) {
        searchAlongWayPopLayerItemImpl.addIntersectArea(f);
    }

    public static float SwigDirector_SearchAlongWayPopLayerItemImpl_getIntersectArea(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getIntersectArea();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_resetIntersectArea(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.resetIntersectArea();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_addIntersectAreaEx(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl, float f) {
        searchAlongWayPopLayerItemImpl.addIntersectAreaEx(f);
    }

    public static float SwigDirector_SearchAlongWayPopLayerItemImpl_getIntersectAreaEx(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getIntersectAreaEx();
    }

    public static void SwigDirector_SearchAlongWayPopLayerItemImpl_resetIntersectAreaEx(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        searchAlongWayPopLayerItemImpl.resetIntersectAreaEx();
    }

    public static boolean SwigDirector_SearchAlongWayPopLayerItemImpl_checkShowFlag(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.checkShowFlag();
    }

    public static long SwigDirector_SearchAlongWayPopLayerItemImpl_getQuadrantGroupId(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getQuadrantGroupId();
    }

    @QuadrantType.QuadrantType1
    public static int SwigDirector_SearchAlongWayPopLayerItemImpl_getQuadrantType(SearchAlongWayPopLayerItemImpl searchAlongWayPopLayerItemImpl) {
        return searchAlongWayPopLayerItemImpl.getQuadrantType();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_resetOnVisible(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, boolean z) {
        searchChargeStationLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_onVisible(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, boolean z) {
        searchChargeStationLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_getOnVisible(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_applyOnVisible(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        searchChargeStationLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_SearchChargeStationLayerItemImpl_getBound(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_getVisible(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getVisible();
    }

    public static int SwigDirector_SearchChargeStationLayerItemImpl_getPriority(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_isAreaCollision(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setAreaCollision(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, boolean z) {
        searchChargeStationLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_SearchChargeStationLayerItemImpl_getItemType(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_setID(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, String str) {
        return searchChargeStationLayerItemImpl.setID(str);
    }

    public static String SwigDirector_SearchChargeStationLayerItemImpl_getID(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getID();
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_setInfo(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, String str) {
        return searchChargeStationLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_SearchChargeStationLayerItemImpl_getInfo(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getInfo();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setPriority(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, int i) {
        searchChargeStationLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setVisible(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, boolean z) {
        searchChargeStationLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_getFocus(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getFocus();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setAlpha(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, double d) {
        searchChargeStationLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_SearchChargeStationLayerItemImpl_getAlpha(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setAngle(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, double d) {
        searchChargeStationLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_SearchChargeStationLayerItemImpl_getAngle(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getAngle();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setPitch(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, double d) {
        searchChargeStationLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_SearchChargeStationLayerItemImpl_getPitch(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getPitch();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setMaxPitch(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, double d) {
        searchChargeStationLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_SearchChargeStationLayerItemImpl_getMaxPitch(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setDisplayScale(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, LayerScale layerScale) {
        searchChargeStationLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_SearchChargeStationLayerItemImpl_getDisplayScale(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setAnimation(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        searchChargeStationLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setStyle__SWIG_0(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        searchChargeStationLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setStyle__SWIG_1(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, String str) {
        searchChargeStationLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_updateStyle__SWIG_0(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        searchChargeStationLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_updateStyle__SWIG_1(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, LayerItemImpl layerItemImpl) {
        searchChargeStationLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_addPoiFilter(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        searchChargeStationLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_removePoiFilter(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        searchChargeStationLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_onPaint(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        searchChargeStationLayerItemImpl.onPaint();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setParent(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        searchChargeStationLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setBusinessType(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, int i) {
        searchChargeStationLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_SearchChargeStationLayerItemImpl_getBusinessType(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_SearchChargeStationLayerItemImpl_getTypeIdName(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_clearStyle(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        searchChargeStationLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setVisible3V(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Visible3V visible3V) {
        searchChargeStationLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_getVisible3V(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Visible3V visible3V) {
        searchChargeStationLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setBillboard(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, boolean z) {
        searchChargeStationLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_getBillboard(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setPosition3D(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChargeStationLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setRotateCenter3D(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChargeStationLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_getRotateCenter3D(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChargeStationLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setPosition(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChargeStationLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_getPosition(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChargeStationLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setRotateCenter(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Coord3DDouble coord3DDouble) {
        searchChargeStationLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_getNormalStyle(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchChargeStationLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_getFocusStyle(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        searchChargeStationLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setItemVisibleRegion(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, RectInt rectInt) {
        searchChargeStationLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setItemIgnoreRegion(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchChargeStationLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_getItemIgnoreRegion(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        searchChargeStationLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setScale(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        searchChargeStationLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_getScale(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, ScaleAttribute scaleAttribute) {
        searchChargeStationLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setPointTypeCode(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, String str) {
        searchChargeStationLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_SearchChargeStationLayerItemImpl_getPointTypeCode(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setScaleFactor(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, float[] fArr) {
        searchChargeStationLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setRotateMode(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, @RotateMode.RotateMode1 int i) {
        searchChargeStationLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_SearchChargeStationLayerItemImpl_addMarker(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return searchChargeStationLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_clearAllMarkers(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        searchChargeStationLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_setForeshorteningCoef(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        searchChargeStationLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_SearchChargeStationLayerItemImpl_getForeshorteningCoef(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_SearchChargeStationLayerItemImpl_onVisible3V(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl, Visible3V visible3V) {
        searchChargeStationLayerItemImpl.onVisible3V(visible3V);
    }

    public static Visible3V SwigDirector_SearchChargeStationLayerItemImpl_getOnVisible3V(SearchChargeStationLayerItemImpl searchChargeStationLayerItemImpl) {
        return searchChargeStationLayerItemImpl.getOnVisible3V();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_resetOnVisible(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, boolean z) {
        gpsTrackPointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_onVisible(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, boolean z) {
        gpsTrackPointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_getOnVisible(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_applyOnVisible(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        gpsTrackPointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_GpsTrackPointLayerItemImpl_getBound(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_getVisible(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_GpsTrackPointLayerItemImpl_getPriority(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_isAreaCollision(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setAreaCollision(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, boolean z) {
        gpsTrackPointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_GpsTrackPointLayerItemImpl_getItemType(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_setID(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, String str) {
        return gpsTrackPointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_GpsTrackPointLayerItemImpl_getID(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_setInfo(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, String str) {
        return gpsTrackPointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_GpsTrackPointLayerItemImpl_getInfo(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setPriority(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, int i) {
        gpsTrackPointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setVisible(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, boolean z) {
        gpsTrackPointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_getFocus(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setAlpha(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, double d) {
        gpsTrackPointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_GpsTrackPointLayerItemImpl_getAlpha(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setAngle(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, double d) {
        gpsTrackPointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_GpsTrackPointLayerItemImpl_getAngle(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setPitch(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, double d) {
        gpsTrackPointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_GpsTrackPointLayerItemImpl_getPitch(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setMaxPitch(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, double d) {
        gpsTrackPointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_GpsTrackPointLayerItemImpl_getMaxPitch(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setDisplayScale(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, LayerScale layerScale) {
        gpsTrackPointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_GpsTrackPointLayerItemImpl_getDisplayScale(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setAnimation(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        gpsTrackPointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setStyle__SWIG_0(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        gpsTrackPointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setStyle__SWIG_1(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, String str) {
        gpsTrackPointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_updateStyle__SWIG_0(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        gpsTrackPointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_updateStyle__SWIG_1(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, LayerItemImpl layerItemImpl) {
        gpsTrackPointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_addPoiFilter(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        gpsTrackPointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_removePoiFilter(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        gpsTrackPointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_onPaint(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        gpsTrackPointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setParent(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        gpsTrackPointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setBusinessType(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, int i) {
        gpsTrackPointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_GpsTrackPointLayerItemImpl_getBusinessType(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_GpsTrackPointLayerItemImpl_getTypeIdName(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_clearStyle(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        gpsTrackPointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setVisible3V(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Visible3V visible3V) {
        gpsTrackPointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_getVisible3V(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Visible3V visible3V) {
        gpsTrackPointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setBillboard(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, boolean z) {
        gpsTrackPointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_getBillboard(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setPosition3D(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        gpsTrackPointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setRotateCenter3D(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        gpsTrackPointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_getRotateCenter3D(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        gpsTrackPointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setPosition(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        gpsTrackPointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_getPosition(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        gpsTrackPointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setRotateCenter(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, Coord3DDouble coord3DDouble) {
        gpsTrackPointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_getNormalStyle(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        gpsTrackPointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_getFocusStyle(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        gpsTrackPointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setItemVisibleRegion(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, RectInt rectInt) {
        gpsTrackPointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setItemIgnoreRegion(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        gpsTrackPointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_getItemIgnoreRegion(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        gpsTrackPointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setScale(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        gpsTrackPointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_getScale(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, ScaleAttribute scaleAttribute) {
        gpsTrackPointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setPointTypeCode(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, String str) {
        gpsTrackPointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_GpsTrackPointLayerItemImpl_getPointTypeCode(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setScaleFactor(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, float[] fArr) {
        gpsTrackPointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setRotateMode(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        gpsTrackPointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_GpsTrackPointLayerItemImpl_addMarker(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return gpsTrackPointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_clearAllMarkers(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        gpsTrackPointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_GpsTrackPointLayerItemImpl_setForeshorteningCoef(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        gpsTrackPointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_GpsTrackPointLayerItemImpl_getForeshorteningCoef(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        return gpsTrackPointLayerItemImpl.getForeshorteningCoef();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_resetOnVisible(FavoritePointLayerItemImpl favoritePointLayerItemImpl, boolean z) {
        favoritePointLayerItemImpl.resetOnVisible(z);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_onVisible(FavoritePointLayerItemImpl favoritePointLayerItemImpl, boolean z) {
        favoritePointLayerItemImpl.onVisible(z);
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_getOnVisible(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getOnVisible();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_applyOnVisible(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        favoritePointLayerItemImpl.applyOnVisible();
    }

    public static ArrayList<PixelPoint> SwigDirector_FavoritePointLayerItemImpl_getBound(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getBound();
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_getVisible(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getVisible();
    }

    public static int SwigDirector_FavoritePointLayerItemImpl_getPriority(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getPriority();
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_isAreaCollision(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.isAreaCollision();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setAreaCollision(FavoritePointLayerItemImpl favoritePointLayerItemImpl, boolean z) {
        favoritePointLayerItemImpl.setAreaCollision(z);
    }

    @LayerItemType.LayerItemType1
    public static int SwigDirector_FavoritePointLayerItemImpl_getItemType(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getItemType();
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_setID(FavoritePointLayerItemImpl favoritePointLayerItemImpl, String str) {
        return favoritePointLayerItemImpl.setID(str);
    }

    public static String SwigDirector_FavoritePointLayerItemImpl_getID(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getID();
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_setInfo(FavoritePointLayerItemImpl favoritePointLayerItemImpl, String str) {
        return favoritePointLayerItemImpl.setInfo(str);
    }

    public static String SwigDirector_FavoritePointLayerItemImpl_getInfo(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getInfo();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setPriority(FavoritePointLayerItemImpl favoritePointLayerItemImpl, int i) {
        favoritePointLayerItemImpl.setPriority(i);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setVisible(FavoritePointLayerItemImpl favoritePointLayerItemImpl, boolean z) {
        favoritePointLayerItemImpl.setVisible(z);
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_getFocus(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getFocus();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setAlpha(FavoritePointLayerItemImpl favoritePointLayerItemImpl, double d) {
        favoritePointLayerItemImpl.setAlpha(d);
    }

    public static double SwigDirector_FavoritePointLayerItemImpl_getAlpha(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getAlpha();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setAngle(FavoritePointLayerItemImpl favoritePointLayerItemImpl, double d) {
        favoritePointLayerItemImpl.setAngle(d);
    }

    public static double SwigDirector_FavoritePointLayerItemImpl_getAngle(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getAngle();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setPitch(FavoritePointLayerItemImpl favoritePointLayerItemImpl, double d) {
        favoritePointLayerItemImpl.setPitch(d);
    }

    public static double SwigDirector_FavoritePointLayerItemImpl_getPitch(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getPitch();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setMaxPitch(FavoritePointLayerItemImpl favoritePointLayerItemImpl, double d) {
        favoritePointLayerItemImpl.setMaxPitch(d);
    }

    public static double SwigDirector_FavoritePointLayerItemImpl_getMaxPitch(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getMaxPitch();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setDisplayScale(FavoritePointLayerItemImpl favoritePointLayerItemImpl, LayerScale layerScale) {
        favoritePointLayerItemImpl.setDisplayScale(layerScale);
    }

    public static LayerScale SwigDirector_FavoritePointLayerItemImpl_getDisplayScale(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getDisplayScale();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setAnimation(FavoritePointLayerItemImpl favoritePointLayerItemImpl, @LayerItemPoiAnimation.LayerItemPoiAnimation1 int i, int i2) {
        favoritePointLayerItemImpl.setAnimation(i, i2);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setStyle__SWIG_0(FavoritePointLayerItemImpl favoritePointLayerItemImpl, IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        favoritePointLayerItemImpl.setStyle(iPrepareLayerStyleImpl);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setStyle__SWIG_1(FavoritePointLayerItemImpl favoritePointLayerItemImpl, String str) {
        favoritePointLayerItemImpl.setStyle(str);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_updateStyle__SWIG_0(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        favoritePointLayerItemImpl.updateStyle();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_updateStyle__SWIG_1(FavoritePointLayerItemImpl favoritePointLayerItemImpl, LayerItemImpl layerItemImpl) {
        favoritePointLayerItemImpl.updateStyle(layerItemImpl);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_addPoiFilter(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        favoritePointLayerItemImpl.addPoiFilter();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_removePoiFilter(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        favoritePointLayerItemImpl.removePoiFilter();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_onPaint(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        favoritePointLayerItemImpl.onPaint();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setParent(FavoritePointLayerItemImpl favoritePointLayerItemImpl, BaseLayerImpl baseLayerImpl) {
        favoritePointLayerItemImpl.setParent(baseLayerImpl);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setBusinessType(FavoritePointLayerItemImpl favoritePointLayerItemImpl, int i) {
        favoritePointLayerItemImpl.setBusinessType(i);
    }

    public static int SwigDirector_FavoritePointLayerItemImpl_getBusinessType(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getBusinessType();
    }

    public static String SwigDirector_FavoritePointLayerItemImpl_getTypeIdName(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getTypeIdName();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_clearStyle(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        favoritePointLayerItemImpl.clearStyle();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setVisible3V(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Visible3V visible3V) {
        favoritePointLayerItemImpl.setVisible3V(visible3V);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_getVisible3V(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Visible3V visible3V) {
        favoritePointLayerItemImpl.getVisible3V(visible3V);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setBillboard(FavoritePointLayerItemImpl favoritePointLayerItemImpl, boolean z) {
        favoritePointLayerItemImpl.setBillboard(z);
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_getBillboard(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getBillboard();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setPosition3D(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Coord3DDouble coord3DDouble) {
        favoritePointLayerItemImpl.setPosition3D(coord3DDouble);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setRotateCenter3D(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Coord3DDouble coord3DDouble) {
        favoritePointLayerItemImpl.setRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_getRotateCenter3D(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Coord3DDouble coord3DDouble) {
        favoritePointLayerItemImpl.getRotateCenter3D(coord3DDouble);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setPosition(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Coord3DDouble coord3DDouble) {
        favoritePointLayerItemImpl.setPosition(coord3DDouble);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_getPosition(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Coord3DDouble coord3DDouble) {
        favoritePointLayerItemImpl.getPosition(coord3DDouble);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setRotateCenter(FavoritePointLayerItemImpl favoritePointLayerItemImpl, Coord3DDouble coord3DDouble) {
        favoritePointLayerItemImpl.setRotateCenter(coord3DDouble);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_getNormalStyle(FavoritePointLayerItemImpl favoritePointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        favoritePointLayerItemImpl.getNormalStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_getFocusStyle(FavoritePointLayerItemImpl favoritePointLayerItemImpl, PointLayerItemStyle pointLayerItemStyle) {
        favoritePointLayerItemImpl.getFocusStyle(pointLayerItemStyle);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setItemVisibleRegion(FavoritePointLayerItemImpl favoritePointLayerItemImpl, RectInt rectInt) {
        favoritePointLayerItemImpl.setItemVisibleRegion(rectInt);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setItemIgnoreRegion(FavoritePointLayerItemImpl favoritePointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        favoritePointLayerItemImpl.setItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_getItemIgnoreRegion(FavoritePointLayerItemImpl favoritePointLayerItemImpl, ItemIgnoreRegion itemIgnoreRegion) {
        favoritePointLayerItemImpl.getItemIgnoreRegion(itemIgnoreRegion);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setScale(FavoritePointLayerItemImpl favoritePointLayerItemImpl, @ScalePriority.ScalePriority1 int i, ScaleInfo scaleInfo) {
        favoritePointLayerItemImpl.setScale(i, scaleInfo);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_getScale(FavoritePointLayerItemImpl favoritePointLayerItemImpl, ScaleAttribute scaleAttribute) {
        favoritePointLayerItemImpl.getScale(scaleAttribute);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setPointTypeCode(FavoritePointLayerItemImpl favoritePointLayerItemImpl, String str) {
        favoritePointLayerItemImpl.setPointTypeCode(str);
    }

    public static String SwigDirector_FavoritePointLayerItemImpl_getPointTypeCode(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getPointTypeCode();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setScaleFactor(FavoritePointLayerItemImpl favoritePointLayerItemImpl, float[] fArr) {
        favoritePointLayerItemImpl.setScaleFactor(fArr);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setRotateMode(FavoritePointLayerItemImpl favoritePointLayerItemImpl, @RotateMode.RotateMode1 int i) {
        favoritePointLayerItemImpl.setRotateMode(i);
    }

    public static boolean SwigDirector_FavoritePointLayerItemImpl_addMarker(FavoritePointLayerItemImpl favoritePointLayerItemImpl, ItemMarkerInfo itemMarkerInfo) {
        return favoritePointLayerItemImpl.addMarker(itemMarkerInfo);
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_clearAllMarkers(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        favoritePointLayerItemImpl.clearAllMarkers();
    }

    public static void SwigDirector_FavoritePointLayerItemImpl_setForeshorteningCoef(FavoritePointLayerItemImpl favoritePointLayerItemImpl, boolean z, ForeshorteningCoefParam foreshorteningCoefParam) {
        favoritePointLayerItemImpl.setForeshorteningCoef(z, foreshorteningCoefParam);
    }

    public static float SwigDirector_FavoritePointLayerItemImpl_getForeshorteningCoef(FavoritePointLayerItemImpl favoritePointLayerItemImpl) {
        return favoritePointLayerItemImpl.getForeshorteningCoef();
    }
}
