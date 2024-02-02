package com.autonavi.gbl.map.layer.observer.impl;

import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.model.AnimationEvent;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
/* loaded from: classes.dex */
public class MapLayerObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_ILayerClickObserverImpl_onBeforeNotifyClick(ILayerClickObserverImpl iLayerClickObserverImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        iLayerClickObserverImpl.onBeforeNotifyClick(baseLayerImpl, layerItemImpl, clickViewIdInfo);
    }

    public static void SwigDirector_ILayerClickObserverImpl_onNotifyClick(ILayerClickObserverImpl iLayerClickObserverImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        iLayerClickObserverImpl.onNotifyClick(baseLayerImpl, layerItemImpl, clickViewIdInfo);
    }

    public static void SwigDirector_ILayerClickObserverImpl_onAfterNotifyClick(ILayerClickObserverImpl iLayerClickObserverImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ClickViewIdInfo clickViewIdInfo) {
        iLayerClickObserverImpl.onAfterNotifyClick(baseLayerImpl, layerItemImpl, clickViewIdInfo);
    }

    public static void SwigDirector_ICarObserverImpl_onCarClick(ICarObserverImpl iCarObserverImpl, CarLoc carLoc) {
        iCarObserverImpl.onCarClick(carLoc);
    }

    public static void SwigDirector_ICarObserverImpl_onCarLocChange(ICarObserverImpl iCarObserverImpl, CarLoc carLoc) {
        iCarObserverImpl.onCarLocChange(carLoc);
    }

    public static void SwigDirector_IFlyLineObserverImpl_onFlyLineClick(IFlyLineObserverImpl iFlyLineObserverImpl, Coord3DDouble coord3DDouble) {
        iFlyLineObserverImpl.onFlyLineClick(coord3DDouble);
    }

    public static void SwigDirector_IFlyLineObserverImpl_onStartChange(IFlyLineObserverImpl iFlyLineObserverImpl, Coord3DDouble coord3DDouble) {
        iFlyLineObserverImpl.onStartChange(coord3DDouble);
    }

    public static void SwigDirector_IFlyLineObserverImpl_onEndChange(IFlyLineObserverImpl iFlyLineObserverImpl, Coord3DDouble coord3DDouble) {
        iFlyLineObserverImpl.onEndChange(coord3DDouble);
    }

    public static void SwigDirector_ILayerFocusChangeObserverImpl_onNotifyFocusChange(ILayerFocusChangeObserverImpl iLayerFocusChangeObserverImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        iLayerFocusChangeObserverImpl.onNotifyFocusChange(baseLayerImpl, layerItemImpl, z);
    }

    public static int SwigDirector_IPrepareLayerStyleImpl_getMarkerId(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, ItemStyleInfo itemStyleInfo) {
        return iPrepareLayerStyleImpl.getMarkerId(baseLayerImpl, layerItemImpl, itemStyleInfo);
    }

    public static int SwigDirector_IPrepareLayerStyleImpl_get3DModelId(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, String str) {
        return iPrepareLayerStyleImpl.get3DModelId(baseLayerImpl, layerItemImpl, str);
    }

    public static String SwigDirector_IPrepareLayerStyleImpl_getLayerStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, boolean z) {
        return iPrepareLayerStyleImpl.getLayerStyle(baseLayerImpl, layerItemImpl, z);
    }

    public static boolean SwigDirector_IPrepareLayerStyleImpl_getRouteLayerStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, RouteLayerStyle routeLayerStyle) {
        return iPrepareLayerStyleImpl.getRouteLayerStyle(baseLayerImpl, layerItemImpl, routeLayerStyle);
    }

    public static boolean SwigDirector_IPrepareLayerStyleImpl_isRouteCacheStyleEnabled(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        return iPrepareLayerStyleImpl.isRouteCacheStyleEnabled();
    }

    public static boolean SwigDirector_IPrepareLayerStyleImpl_isRouteStyleNightMode(IPrepareLayerStyleImpl iPrepareLayerStyleImpl) {
        return iPrepareLayerStyleImpl.isRouteStyleNightMode();
    }

    public static void SwigDirector_IPrepareLayerStyleImpl_clearLayerItems(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, BaseLayerImpl baseLayerImpl) {
        iPrepareLayerStyleImpl.clearLayerItems(baseLayerImpl);
    }

    public static void SwigDirector_IPrepareLayerStyleImpl_clearLayerItem(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        iPrepareLayerStyleImpl.clearLayerItem(baseLayerImpl, layerItemImpl);
    }

    public static void SwigDirector_IPrepareLayerStyleImpl_clearLayerStyle(IPrepareLayerStyleImpl iPrepareLayerStyleImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl) {
        iPrepareLayerStyleImpl.clearLayerStyle(baseLayerImpl, layerItemImpl);
    }

    public static void SwigDirector_ILayerItemAnimationObserverImpl_onProcessAnimationEvent(ILayerItemAnimationObserverImpl iLayerItemAnimationObserverImpl, BaseLayerImpl baseLayerImpl, LayerItemImpl layerItemImpl, AnimationEvent animationEvent) {
        iLayerItemAnimationObserverImpl.onProcessAnimationEvent(baseLayerImpl, layerItemImpl, animationEvent);
    }
}
