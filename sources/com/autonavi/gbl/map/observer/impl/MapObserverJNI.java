package com.autonavi.gbl.map.observer.impl;

import com.autonavi.gbl.map.impl.MapDeviceImpl;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.model.AnmCallbackParam;
import com.autonavi.gbl.map.model.EGLColorBits;
import com.autonavi.gbl.map.model.EGLDeviceID;
import com.autonavi.gbl.map.model.EGLDeviceRenderStatus;
import com.autonavi.gbl.map.model.FontMetrics;
import com.autonavi.gbl.map.model.FontMetricsRequestParam;
import com.autonavi.gbl.map.model.GestureAction;
import com.autonavi.gbl.map.model.GlyphMetrics;
import com.autonavi.gbl.map.model.GlyphRaster;
import com.autonavi.gbl.map.model.GlyphRequestParam;
import com.autonavi.gbl.map.model.GuideRoadNameBoardParam;
import com.autonavi.gbl.map.model.IndoorBuilding;
import com.autonavi.gbl.map.model.MapFuncActiveParam;
import com.autonavi.gbl.map.model.MapLabelItem;
import com.autonavi.gbl.map.model.MapResourceParam;
import com.autonavi.gbl.map.model.MapRoadTip;
import com.autonavi.gbl.map.model.MapviewMode;
import com.autonavi.gbl.map.model.RenderMapType;
import com.autonavi.gbl.map.model.ReportCode;
import com.autonavi.gbl.map.model.ReportType;
import com.autonavi.gbl.map.model.ScenicInfo;
import com.autonavi.gbl.map.model.ScreenShotCallbackMethod;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.autonavi.gbl.map.model.SelectOutInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MapObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IMapRunnableImpl_run(IMapRunnableImpl iMapRunnableImpl) {
        iMapRunnableImpl.run();
    }

    public static void SwigDirector_IDeviceObserverImpl_onDeviceCreated(IDeviceObserverImpl iDeviceObserverImpl, int i) {
        iDeviceObserverImpl.onDeviceCreated(i);
    }

    public static void SwigDirector_IDeviceObserverImpl_onDeviceDestroyed(IDeviceObserverImpl iDeviceObserverImpl, int i) {
        iDeviceObserverImpl.onDeviceDestroyed(i);
    }

    public static void SwigDirector_IDeviceObserverImpl_onSurfaceCreated(IDeviceObserverImpl iDeviceObserverImpl, int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        iDeviceObserverImpl.onSurfaceCreated(i, i2, i3, i4);
    }

    public static void SwigDirector_IDeviceObserverImpl_onSurfaceDestroyed(IDeviceObserverImpl iDeviceObserverImpl, int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        iDeviceObserverImpl.onSurfaceDestroyed(i, i2, i3, i4);
    }

    public static void SwigDirector_IDeviceObserverImpl_onSurfaceChanged(IDeviceObserverImpl iDeviceObserverImpl, int i, int i2, int i3, @EGLColorBits.EGLColorBits1 int i4) {
        iDeviceObserverImpl.onSurfaceChanged(i, i2, i3, i4);
    }

    public static void SwigDirector_IDeviceObserverImpl_onDeviceRender(IDeviceObserverImpl iDeviceObserverImpl, int i, @EGLDeviceRenderStatus.EGLDeviceRenderStatus1 int i2) {
        iDeviceObserverImpl.onDeviceRender(i, i2);
    }

    public static void SwigDirector_IDeviceObserverImpl_onEGLDoRender(IDeviceObserverImpl iDeviceObserverImpl, @EGLDeviceID.EGLDeviceID1 int i) {
        iDeviceObserverImpl.onEGLDoRender(i);
    }

    public static void SwigDirector_IMapLifecycleObserver_beforeEGLDeviceCreate(IMapLifecycleObserver iMapLifecycleObserver, MapDeviceImpl mapDeviceImpl) {
        iMapLifecycleObserver.beforeEGLDeviceCreate(mapDeviceImpl);
    }

    public static void SwigDirector_IMapLifecycleObserver_beforeEGLMapViewCreate(IMapLifecycleObserver iMapLifecycleObserver, MapViewImpl mapViewImpl) {
        iMapLifecycleObserver.beforeEGLMapViewCreate(mapViewImpl);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapCenterChanged(IMapviewObserverImpl iMapviewObserverImpl, long j, double d, double d2) {
        iMapviewObserverImpl.onMapCenterChanged(j, d, d2);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapSizeChanged(IMapviewObserverImpl iMapviewObserverImpl, long j) {
        iMapviewObserverImpl.onMapSizeChanged(j);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapLevelChanged(IMapviewObserverImpl iMapviewObserverImpl, long j, boolean z) {
        iMapviewObserverImpl.onMapLevelChanged(j, z);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapModeChanged(IMapviewObserverImpl iMapviewObserverImpl, long j, @MapviewMode.MapviewMode1 int i) {
        iMapviewObserverImpl.onMapModeChanged(j, i);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapPreviewEnter(IMapviewObserverImpl iMapviewObserverImpl, long j) {
        iMapviewObserverImpl.onMapPreviewEnter(j);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapPreviewExit(IMapviewObserverImpl iMapviewObserverImpl, long j) {
        iMapviewObserverImpl.onMapPreviewExit(j);
    }

    public static void SwigDirector_IMapviewObserverImpl_onClickLabel(IMapviewObserverImpl iMapviewObserverImpl, long j, ArrayList<MapLabelItem> arrayList) {
        iMapviewObserverImpl.onClickLabel(j, arrayList);
    }

    public static void SwigDirector_IMapviewObserverImpl_onClickBlank(IMapviewObserverImpl iMapviewObserverImpl, long j, float f, float f2) {
        iMapviewObserverImpl.onClickBlank(j, f, f2);
    }

    public static void SwigDirector_IMapviewObserverImpl_onRenderMap(IMapviewObserverImpl iMapviewObserverImpl, long j, @RenderMapType.RenderMapType1 int i) {
        iMapviewObserverImpl.onRenderMap(j, i);
    }

    public static void SwigDirector_IMapviewObserverImpl_onRealCityAnimationFinished(IMapviewObserverImpl iMapviewObserverImpl, long j) {
        iMapviewObserverImpl.onRealCityAnimationFinished(j);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapAnimationFinished(IMapviewObserverImpl iMapviewObserverImpl, long j, long j2) {
        iMapviewObserverImpl.onMapAnimationFinished(j, j2);
    }

    public static void SwigDirector_IMapviewObserverImpl_onRouteBoardData(IMapviewObserverImpl iMapviewObserverImpl, long j, ArrayList<MapRoadTip> arrayList) {
        iMapviewObserverImpl.onRouteBoardData(j, arrayList);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapHeatActive(IMapviewObserverImpl iMapviewObserverImpl, long j, boolean z) {
        iMapviewObserverImpl.onMapHeatActive(j, z);
    }

    public static void SwigDirector_IMapviewObserverImpl_onScenicActive(IMapviewObserverImpl iMapviewObserverImpl, long j, ScenicInfo scenicInfo) {
        iMapviewObserverImpl.onScenicActive(j, scenicInfo);
    }

    public static void SwigDirector_IMapviewObserverImpl_onIndoorBuildingActivity(IMapviewObserverImpl iMapviewObserverImpl, long j, IndoorBuilding indoorBuilding) {
        iMapviewObserverImpl.onIndoorBuildingActivity(j, indoorBuilding);
    }

    public static void SwigDirector_IMapviewObserverImpl_onSelectSubWayActive(IMapviewObserverImpl iMapviewObserverImpl, long j, long[] jArr) {
        iMapviewObserverImpl.onSelectSubWayActive(j, jArr);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMotionFinished(IMapviewObserverImpl iMapviewObserverImpl, long j, int i) {
        iMapviewObserverImpl.onMotionFinished(j, i);
    }

    public static void SwigDirector_IMapviewObserverImpl_onPreDrawFrame(IMapviewObserverImpl iMapviewObserverImpl, long j) {
        iMapviewObserverImpl.onPreDrawFrame(j);
    }

    public static void SwigDirector_IMapviewObserverImpl_onRenderEnter(IMapviewObserverImpl iMapviewObserverImpl, long j) {
        iMapviewObserverImpl.onRenderEnter(j);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapViewDestory(IMapviewObserverImpl iMapviewObserverImpl, long j) {
        iMapviewObserverImpl.onMapViewDestory(j);
    }

    public static void SwigDirector_IMapviewObserverImpl_onRollAngle(IMapviewObserverImpl iMapviewObserverImpl, long j, float f) {
        iMapviewObserverImpl.onRollAngle(j, f);
    }

    public static void SwigDirector_IMapviewObserverImpl_onPitchAngle(IMapviewObserverImpl iMapviewObserverImpl, long j, float f) {
        iMapviewObserverImpl.onPitchAngle(j, f);
    }

    public static void SwigDirector_IMapviewObserverImpl_onCheckIngDataRenderComplete(IMapviewObserverImpl iMapviewObserverImpl, long j, long j2) {
        iMapviewObserverImpl.onCheckIngDataRenderComplete(j, j2);
    }

    public static void SwigDirector_IMapviewObserverImpl_onGuideRoadBoardNameProcessed(IMapviewObserverImpl iMapviewObserverImpl, long j, GuideRoadNameBoardParam guideRoadNameBoardParam) {
        iMapviewObserverImpl.onGuideRoadBoardNameProcessed(j, guideRoadNameBoardParam);
    }

    public static void SwigDirector_IMapviewObserverImpl_onMapVisibleIndoor(IMapviewObserverImpl iMapviewObserverImpl, long j, ArrayList<IndoorBuilding> arrayList, ArrayList<IndoorBuilding> arrayList2) {
        iMapviewObserverImpl.onMapVisibleIndoor(j, arrayList, arrayList2);
    }

    public static boolean SwigDirector_IMapEventObserverImpl_onMapMoveStart(IMapEventObserverImpl iMapEventObserverImpl) {
        return iMapEventObserverImpl.onMapMoveStart();
    }

    public static boolean SwigDirector_IMapEventObserverImpl_onMapMoveEnd(IMapEventObserverImpl iMapEventObserverImpl) {
        return iMapEventObserverImpl.onMapMoveEnd();
    }

    public static void SwigDirector_IMapFpsObserverImpl_onMapRenderTimeOut(IMapFpsObserverImpl iMapFpsObserverImpl, int i, int i2, int i3) {
        iMapFpsObserverImpl.onMapRenderTimeOut(i, i2, i3);
    }

    public static void SwigDirector_IMapFpsObserverImpl_onMapRenderRealFps(IMapFpsObserverImpl iMapFpsObserverImpl, int i, int i2, int i3) {
        iMapFpsObserverImpl.onMapRenderRealFps(i, i2, i3);
    }

    public static void SwigDirector_IMapFpsObserverImpl_onMapRenderConfigFps(IMapFpsObserverImpl iMapFpsObserverImpl, int i, int i2) {
        iMapFpsObserverImpl.onMapRenderConfigFps(i, i2);
    }

    public static void SwigDirector_ISelectPoiObserverImpl_onSelectPoiOut(ISelectPoiObserverImpl iSelectPoiObserverImpl, long j, SelectOutInfo selectOutInfo) {
        iSelectPoiObserverImpl.onSelectPoiOut(j, selectOutInfo);
    }

    public static void SwigDirector_IMapStyleSwitchObserverImpl_onMapStyleSwitchComplete(IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl, int i) {
        iMapStyleSwitchObserverImpl.onMapStyleSwitchComplete(i);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onMotionEvent(IMapGestureObserverImpl iMapGestureObserverImpl, long j, @GestureAction.GestureAction1 int i, long j2, long j3) {
        iMapGestureObserverImpl.onMotionEvent(j, i, j2, j3);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onMoveBegin(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        iMapGestureObserverImpl.onMoveBegin(j, j2, j3);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onMoveEnd(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        iMapGestureObserverImpl.onMoveEnd(j, j2, j3);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onMove(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        iMapGestureObserverImpl.onMove(j, j2, j3);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onMoveLocked(IMapGestureObserverImpl iMapGestureObserverImpl, long j) {
        iMapGestureObserverImpl.onMoveLocked(j);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onScaleRotateBegin(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        iMapGestureObserverImpl.onScaleRotateBegin(j, j2, j3);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onScaleRotateEnd(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        iMapGestureObserverImpl.onScaleRotateEnd(j, j2, j3);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onScaleRotate(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        iMapGestureObserverImpl.onScaleRotate(j, j2, j3);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onPinchLocked(IMapGestureObserverImpl iMapGestureObserverImpl, long j) {
        iMapGestureObserverImpl.onPinchLocked(j);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onLongPress(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        iMapGestureObserverImpl.onLongPress(j, j2, j3);
    }

    public static boolean SwigDirector_IMapGestureObserverImpl_onDoublePress(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3) {
        return iMapGestureObserverImpl.onDoublePress(j, j2, j3);
    }

    public static boolean SwigDirector_IMapGestureObserverImpl_onSinglePress(IMapGestureObserverImpl iMapGestureObserverImpl, long j, long j2, long j3, boolean z) {
        return iMapGestureObserverImpl.onSinglePress(j, j2, j3, z);
    }

    public static void SwigDirector_IMapGestureObserverImpl_onSliding(IMapGestureObserverImpl iMapGestureObserverImpl, long j, float f, float f2) {
        iMapGestureObserverImpl.onSliding(j, f, f2);
    }

    public static boolean SwigDirector_IMapFontObserverImpl_getGlyphMetrics(IMapFontObserverImpl iMapFontObserverImpl, GlyphRequestParam glyphRequestParam, GlyphMetrics glyphMetrics) {
        return iMapFontObserverImpl.getGlyphMetrics(glyphRequestParam, glyphMetrics);
    }

    public static boolean SwigDirector_IMapFontObserverImpl_getGlyphRaster(IMapFontObserverImpl iMapFontObserverImpl, GlyphRequestParam glyphRequestParam, GlyphRaster glyphRaster) {
        return iMapFontObserverImpl.getGlyphRaster(glyphRequestParam, glyphRaster);
    }

    public static boolean SwigDirector_IMapFontObserverImpl_getFontMetrics(IMapFontObserverImpl iMapFontObserverImpl, FontMetricsRequestParam fontMetricsRequestParam, FontMetrics fontMetrics) {
        return iMapFontObserverImpl.getFontMetrics(fontMetricsRequestParam, fontMetrics);
    }

    public static byte[] SwigDirector_ITextTextureObserverImpl_getCharBitmap(ITextTextureObserverImpl iTextTextureObserverImpl, long j, int i, int i2) {
        return iTextTextureObserverImpl.getCharBitmap(j, i, i2);
    }

    public static byte[] SwigDirector_ITextTextureObserverImpl_getCharsWidths(ITextTextureObserverImpl iTextTextureObserverImpl, long j, short[] sArr, int i) {
        return iTextTextureObserverImpl.getCharsWidths(j, sArr, i);
    }

    public static void SwigDirector_IEGLScreenshotObserverImpl_onEGLScreenshot(IEGLScreenshotObserverImpl iEGLScreenshotObserverImpl, int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, @ScreenShotCallbackMethod.ScreenShotCallbackMethod1 int i2, long j) {
        iEGLScreenshotObserverImpl.onEGLScreenshot(i, bArr, screenShotDataInfo, i2, j);
    }

    public static void SwigDirector_IBLThreadObserverImpl_threadCallback(IBLThreadObserverImpl iBLThreadObserverImpl, long j, byte b) {
        iBLThreadObserverImpl.threadCallback(j, b);
    }

    public static byte[] SwigDirector_IBLMapEngineProxyImpl_requireMapResource(IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j, MapResourceParam mapResourceParam) {
        return iBLMapEngineProxyImpl.requireMapResource(j, mapResourceParam);
    }

    public static void SwigDirector_IBLMapEngineProxyImpl_onMapLogReporter(IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j, @ReportType.ReportType1 int i, @ReportCode.ReportCode1 int i2, String str) {
        iBLMapEngineProxyImpl.onMapLogReporter(j, i, i2, str);
    }

    public static void SwigDirector_IBLMapEngineProxyImpl_onSendBehaviorLog(IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j, String str, String str2, String str3) {
        iBLMapEngineProxyImpl.onSendBehaviorLog(j, str, str2, str3);
    }

    public static void SwigDirector_IBLMapEngineProxyImpl_requireMapRender(IBLMapEngineProxyImpl iBLMapEngineProxyImpl, long j, int i, int i2) {
        iBLMapEngineProxyImpl.requireMapRender(j, i, i2);
    }

    public static byte[] SwigDirector_IBLMapViewProxyImpl_requireMapResource(IBLMapViewProxyImpl iBLMapViewProxyImpl, long j, MapResourceParam mapResourceParam) {
        return iBLMapViewProxyImpl.requireMapResource(j, mapResourceParam);
    }

    public static void SwigDirector_IBLMapViewProxyImpl_onMapLogReporter(IBLMapViewProxyImpl iBLMapViewProxyImpl, long j, @ReportType.ReportType1 int i, @ReportCode.ReportCode1 int i2, String str) {
        iBLMapViewProxyImpl.onMapLogReporter(j, i, i2, str);
    }

    public static void SwigDirector_IBLMapViewProxyImpl_onSendBehaviorLog(IBLMapViewProxyImpl iBLMapViewProxyImpl, long j, String str, String str2, String str3) {
        iBLMapViewProxyImpl.onSendBehaviorLog(j, str, str2, str3);
    }

    public static void SwigDirector_IBLMapViewProxyImpl_requireMapRender(IBLMapViewProxyImpl iBLMapViewProxyImpl, long j, int i, int i2) {
        iBLMapViewProxyImpl.requireMapRender(j, i, i2);
    }

    public static void SwigDirector_IBLMapViewProxyImpl_reloadMapResource(IBLMapViewProxyImpl iBLMapViewProxyImpl, long j, byte[] bArr, int i) {
        iBLMapViewProxyImpl.reloadMapResource(j, bArr, i);
    }

    public static void SwigDirector_IBLGLRenderStateObserverImpl_onMapGLRender(IBLGLRenderStateObserverImpl iBLGLRenderStateObserverImpl, long j, int i) {
        iBLGLRenderStateObserverImpl.onMapGLRender(j, i);
    }

    public static void SwigDirector_IBLMapEngineObserverImpl_onMapRender(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j, int i) {
        iBLMapEngineObserverImpl.onMapRender(j, i);
    }

    public static void SwigDirector_IBLMapEngineObserverImpl_onMapOrthoRender(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j) {
        iBLMapEngineObserverImpl.onMapOrthoRender(j);
    }

    public static void SwigDirector_IBLMapEngineObserverImpl_onMapTransferParam(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j, int[] iArr) {
        iBLMapEngineObserverImpl.onMapTransferParam(j, iArr);
    }

    public static void SwigDirector_IBLMapEngineObserverImpl_onMapOfflineError(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j, String str, int i) {
        iBLMapEngineObserverImpl.onMapOfflineError(j, str, i);
    }

    public static void SwigDirector_IBLMapEngineObserverImpl_onMapAnimationFinished(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j) {
        iBLMapEngineObserverImpl.onMapAnimationFinished(j);
    }

    public static void SwigDirector_IBLMapEngineObserverImpl_onMapFunctionActivity(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j, MapFuncActiveParam mapFuncActiveParam) {
        iBLMapEngineObserverImpl.onMapFunctionActivity(j, mapFuncActiveParam);
    }

    public static void SwigDirector_IBLMapEngineObserverImpl_onMapViewDestroyed(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j) {
        iBLMapEngineObserverImpl.onMapViewDestroyed(j);
    }

    public static boolean SwigDirector_IBLMapBusinessDataObserverImpl_onBusinessDataObserver(IBLMapBusinessDataObserverImpl iBLMapBusinessDataObserverImpl, int i, long j, long j2) {
        return iBLMapBusinessDataObserverImpl.onBusinessDataObserver(i, j, j2);
    }

    public static void SwigDirector_IAnimationObserverImpl_processMapAnimationFinished(IAnimationObserverImpl iAnimationObserverImpl, long j, AnmCallbackParam anmCallbackParam) {
        iAnimationObserverImpl.processMapAnimationFinished(j, anmCallbackParam);
    }

    public static void SwigDirector_IReculateOverlayImpl_recalculateOverlay(IReculateOverlayImpl iReculateOverlayImpl) {
        iReculateOverlayImpl.recalculateOverlay();
    }
}
