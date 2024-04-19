package com.autonavi.gbl.layer.observer.impl;

import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
/* loaded from: classes.dex */
public class LayerObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_updateCardContent(IPrepareLayerParamImpl iPrepareLayerParamImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        return iPrepareLayerParamImpl.updateCardContent(baseLayerImpl, layerItemImpl, itemStyleInfo, customTextureParam);
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_getPrepareLayerParam(IPrepareLayerParamImpl iPrepareLayerParamImpl, LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        return iPrepareLayerParamImpl.getPrepareLayerParam(layerItemImpl, prepareLayerMarkerParam);
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_isRouteCacheStyleEnabled(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        return iPrepareLayerParamImpl.isRouteCacheStyleEnabled();
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_isRouteStyleNightMode(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        return iPrepareLayerParamImpl.isRouteStyleNightMode();
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_isStaticMarker(IPrepareLayerParamImpl iPrepareLayerParamImpl, String str) {
        return iPrepareLayerParamImpl.isStaticMarker(str);
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_isDynamicMarker(IPrepareLayerParamImpl iPrepareLayerParamImpl, String str) {
        return iPrepareLayerParamImpl.isDynamicMarker(str);
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_getNewStaticMarkerId(IPrepareLayerParamImpl iPrepareLayerParamImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        return iPrepareLayerParamImpl.getNewStaticMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo, strArr);
    }

    public static int SwigDirector_IPrepareLayerParamImpl_get3DModelId(IPrepareLayerParamImpl iPrepareLayerParamImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        return iPrepareLayerParamImpl.get3DModelId(baseLayerImpl, layerItemImpl, str);
    }

    public static float SwigDirector_IPrepareLayerParamImpl_getPointMarkerScaleFactor(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        return iPrepareLayerParamImpl.getPointMarkerScaleFactor();
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_isNightMode(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        return iPrepareLayerParamImpl.isNightMode();
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_isEnglish(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        return iPrepareLayerParamImpl.isEnglish();
    }

    public static float SwigDirector_IPrepareLayerParamImpl_getRouteWidthScaleFactor(IPrepareLayerParamImpl iPrepareLayerParamImpl, int i) {
        return iPrepareLayerParamImpl.getRouteWidthScaleFactor(i);
    }

    public static boolean SwigDirector_IPrepareLayerParamImpl_isInForeground(IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        return iPrepareLayerParamImpl.isInForeground();
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_updateCardContent(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam) {
        return prepareLayerParamInnerImpl.updateCardContent(baseLayerImpl, layerItemImpl, itemStyleInfo, customTextureParam);
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_getPrepareLayerParam(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, LayerItemImpl layerItemImpl, PrepareLayerMarkerParam prepareLayerMarkerParam) {
        return prepareLayerParamInnerImpl.getPrepareLayerParam(layerItemImpl, prepareLayerMarkerParam);
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_isRouteCacheStyleEnabled(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        return prepareLayerParamInnerImpl.isRouteCacheStyleEnabled();
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_isRouteStyleNightMode(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        return prepareLayerParamInnerImpl.isRouteStyleNightMode();
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_isStaticMarker(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, String str) {
        return prepareLayerParamInnerImpl.isStaticMarker(str);
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_isDynamicMarker(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, String str) {
        return prepareLayerParamInnerImpl.isDynamicMarker(str);
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_getNewStaticMarkerId(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo, String[] strArr) {
        return prepareLayerParamInnerImpl.getNewStaticMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo, strArr);
    }

    public static int SwigDirector_PrepareLayerParamInnerImpl_get3DModelId(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        return prepareLayerParamInnerImpl.get3DModelId(baseLayerImpl, layerItemImpl, str);
    }

    public static float SwigDirector_PrepareLayerParamInnerImpl_getPointMarkerScaleFactor(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        return prepareLayerParamInnerImpl.getPointMarkerScaleFactor();
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_isNightMode(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        return prepareLayerParamInnerImpl.isNightMode();
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_isEnglish(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        return prepareLayerParamInnerImpl.isEnglish();
    }

    public static float SwigDirector_PrepareLayerParamInnerImpl_getRouteWidthScaleFactor(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl, int i) {
        return prepareLayerParamInnerImpl.getRouteWidthScaleFactor(i);
    }

    public static boolean SwigDirector_PrepareLayerParamInnerImpl_isInForeground(PrepareLayerParamInnerImpl prepareLayerParamInnerImpl) {
        return prepareLayerParamInnerImpl.isInForeground();
    }

    public static int SwigDirector_PrepareLayerStyleInnerImpl_getMarkerId(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        return prepareLayerStyleInnerImpl.getMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo);
    }

    public static int SwigDirector_PrepareLayerStyleInnerImpl_get3DModelId(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        return prepareLayerStyleInnerImpl.get3DModelId(baseLayerImpl, layerItemImpl, str);
    }

    public static String SwigDirector_PrepareLayerStyleInnerImpl_getLayerStyle(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        return prepareLayerStyleInnerImpl.getLayerStyle(baseLayerImpl, layerItemImpl, z);
    }

    public static boolean SwigDirector_PrepareLayerStyleInnerImpl_getRouteLayerStyle(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, RouteLayerStyle routeLayerStyle) {
        return prepareLayerStyleInnerImpl.getRouteLayerStyle(baseLayerImpl, layerItemImpl, routeLayerStyle);
    }

    public static boolean SwigDirector_PrepareLayerStyleInnerImpl_isRouteCacheStyleEnabled(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl) {
        return prepareLayerStyleInnerImpl.isRouteCacheStyleEnabled();
    }

    public static boolean SwigDirector_PrepareLayerStyleInnerImpl_isRouteStyleNightMode(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl) {
        return prepareLayerStyleInnerImpl.isRouteStyleNightMode();
    }

    public static void SwigDirector_PrepareLayerStyleInnerImpl_clearLayerItems(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, BaseLayerImpl baseLayerImpl) {
        prepareLayerStyleInnerImpl.clearLayerItems(baseLayerImpl);
    }

    public static void SwigDirector_PrepareLayerStyleInnerImpl_clearLayerItem(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        prepareLayerStyleInnerImpl.clearLayerItem(baseLayerImpl, layerItemImpl);
    }

    public static void SwigDirector_PrepareLayerStyleInnerImpl_clearLayerStyle(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        prepareLayerStyleInnerImpl.clearLayerStyle(baseLayerImpl, layerItemImpl);
    }

    public static String SwigDirector_PrepareLayerStyleInnerImpl_getCommonInfo(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, String str) {
        return prepareLayerStyleInnerImpl.getCommonInfo(str);
    }

    public static void SwigDirector_PrepareLayerStyleInnerImpl_setParam(PrepareLayerStyleInnerImpl prepareLayerStyleInnerImpl, IPrepareLayerParamImpl iPrepareLayerParamImpl) {
        prepareLayerStyleInnerImpl.setParam(iPrepareLayerParamImpl);
    }
}
