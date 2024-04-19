package com.autonavi.gbl.multi.observer.impl;

import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.CHANNEL_MSG_TYPE;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.model.DeviceAttribute;
import com.autonavi.gbl.map.model.EGLSurfaceAttr;
import com.autonavi.gbl.map.model.MapSkyboxParam;
import com.autonavi.gbl.multi.impl.CKldIntent;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.impl.IKldDisplayCrop;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.model.SceneErrorCode;
import com.autonavi.gbl.multi.model.SceneViewState;
/* loaded from: classes2.dex */
public class MultiObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static int SwigDirector_IKldConfigItemBaseImpl_parseConfigString(IKldConfigItemBaseImpl iKldConfigItemBaseImpl, String str) {
        return iKldConfigItemBaseImpl.parseConfigString(str);
    }

    public static int SwigDirector_IKldConfigItemBaseImpl_applyConfig(IKldConfigItemBaseImpl iKldConfigItemBaseImpl, IKldDisplayImpl iKldDisplayImpl) {
        return iKldConfigItemBaseImpl.applyConfig(iKldDisplayImpl);
    }

    public static int SwigDirector_SurfaceConfigBaseImpl_parseConfigString(SurfaceConfigBaseImpl surfaceConfigBaseImpl, String str) {
        return surfaceConfigBaseImpl.parseConfigString(str);
    }

    public static int SwigDirector_SurfaceConfigBaseImpl_applyConfig(SurfaceConfigBaseImpl surfaceConfigBaseImpl, IKldDisplayImpl iKldDisplayImpl) {
        return surfaceConfigBaseImpl.applyConfig(iKldDisplayImpl);
    }

    public static int SwigDirector_DisplaySceneConfigBaseImpl_parseConfigString(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, String str) {
        return displaySceneConfigBaseImpl.parseConfigString(str);
    }

    public static int SwigDirector_DisplaySceneConfigBaseImpl_applyConfig(DisplaySceneConfigBaseImpl displaySceneConfigBaseImpl, IKldDisplayImpl iKldDisplayImpl) {
        return displaySceneConfigBaseImpl.applyConfig(iKldDisplayImpl);
    }

    public static int SwigDirector_DisplayConfigBaseImpl_parseConfigString(DisplayConfigBaseImpl displayConfigBaseImpl, String str) {
        return displayConfigBaseImpl.parseConfigString(str);
    }

    public static int SwigDirector_DisplayConfigBaseImpl_applyConfig(DisplayConfigBaseImpl displayConfigBaseImpl, IKldDisplayImpl iKldDisplayImpl) {
        return displayConfigBaseImpl.applyConfig(iKldDisplayImpl);
    }

    public static int SwigDirector_RenderConfigBaseImpl_parseConfigString(RenderConfigBaseImpl renderConfigBaseImpl, String str) {
        return renderConfigBaseImpl.parseConfigString(str);
    }

    public static int SwigDirector_RenderConfigBaseImpl_applyConfig(RenderConfigBaseImpl renderConfigBaseImpl, IKldDisplayImpl iKldDisplayImpl) {
        return renderConfigBaseImpl.applyConfig(iKldDisplayImpl);
    }

    public static int SwigDirector_MapConfigBaseImpl_parseConfigString(MapConfigBaseImpl mapConfigBaseImpl, String str) {
        return mapConfigBaseImpl.parseConfigString(str);
    }

    public static int SwigDirector_MapConfigBaseImpl_applyConfig(MapConfigBaseImpl mapConfigBaseImpl, IKldDisplayImpl iKldDisplayImpl) {
        return mapConfigBaseImpl.applyConfig(iKldDisplayImpl);
    }

    public static int SwigDirector_IKldSceneObserverImpl_onSceneError(IKldSceneObserverImpl iKldSceneObserverImpl, CKldSceneContextImpl cKldSceneContextImpl, String str, CKldIntent cKldIntent, @SceneErrorCode.SceneErrorCode1 int i) {
        return iKldSceneObserverImpl.onSceneError(cKldSceneContextImpl, str, cKldIntent, i);
    }

    public static int SwigDirector_IKldSceneObserverImpl_beforeInit(IKldSceneObserverImpl iKldSceneObserverImpl, CKldSceneContextImpl cKldSceneContextImpl, String str) {
        return iKldSceneObserverImpl.beforeInit(cKldSceneContextImpl, str);
    }

    public static int SwigDirector_IKldSceneObserverImpl_onInitDone(IKldSceneObserverImpl iKldSceneObserverImpl, CKldSceneContextImpl cKldSceneContextImpl, String str) {
        return iKldSceneObserverImpl.onInitDone(cKldSceneContextImpl, str);
    }

    public static int SwigDirector_IKldSceneObserverImpl_onSceneEntered(IKldSceneObserverImpl iKldSceneObserverImpl, CKldSceneContextImpl cKldSceneContextImpl, String str) {
        return iKldSceneObserverImpl.onSceneEntered(cKldSceneContextImpl, str);
    }

    public static int SwigDirector_IKldSceneObserverImpl_beforeExit(IKldSceneObserverImpl iKldSceneObserverImpl, CKldSceneContextImpl cKldSceneContextImpl, String str) {
        return iKldSceneObserverImpl.beforeExit(cKldSceneContextImpl, str);
    }

    public static int SwigDirector_IKldSceneObserverImpl_onSceneExited(IKldSceneObserverImpl iKldSceneObserverImpl, CKldSceneContextImpl cKldSceneContextImpl, String str) {
        return iKldSceneObserverImpl.onSceneExited(cKldSceneContextImpl, str);
    }

    public static int SwigDirector_IKldSceneBaseImpl_onSceneInit(IKldSceneBaseImpl iKldSceneBaseImpl, CKldIntent cKldIntent) {
        return iKldSceneBaseImpl.onSceneInit(cKldIntent);
    }

    public static int SwigDirector_IKldSceneBaseImpl_onSceneEntered(IKldSceneBaseImpl iKldSceneBaseImpl, String str, CKldIntent cKldIntent) {
        return iKldSceneBaseImpl.onSceneEntered(str, cKldIntent);
    }

    public static int SwigDirector_IKldSceneBaseImpl_onSceneExit(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.onSceneExit();
    }

    public static int SwigDirector_IKldSceneBaseImpl_onSceneResume(IKldSceneBaseImpl iKldSceneBaseImpl, boolean z) {
        return iKldSceneBaseImpl.onSceneResume(z);
    }

    public static int SwigDirector_IKldSceneBaseImpl_onScenePause(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.onScenePause();
    }

    public static void SwigDirector_IKldSceneBaseImpl_onNewIntent(IKldSceneBaseImpl iKldSceneBaseImpl, CKldIntent cKldIntent) {
        iKldSceneBaseImpl.onNewIntent(cKldIntent);
    }

    public static int SwigDirector_IKldSceneBaseImpl_onUpateSceneState(IKldSceneBaseImpl iKldSceneBaseImpl, String str, SceneViewState sceneViewState) {
        return iKldSceneBaseImpl.onUpateSceneState(str, sceneViewState);
    }

    public static void SwigDirector_IKldSceneBaseImpl_restoreSceneState(IKldSceneBaseImpl iKldSceneBaseImpl) {
        iKldSceneBaseImpl.restoreSceneState();
    }

    public static boolean SwigDirector_IKldSceneBaseImpl_setMapCenterWhenRestore(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.setMapCenterWhenRestore();
    }

    public static boolean SwigDirector_IKldSceneBaseImpl_setZoomerWhenRestore(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.setZoomerWhenRestore();
    }

    public static boolean SwigDirector_IKldSceneBaseImpl_setMapModeWhenRestore(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.setMapModeWhenRestore();
    }

    public static boolean SwigDirector_IKldSceneBaseImpl_setMapProjectionCenterWhenRestore(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.setMapProjectionCenterWhenRestore();
    }

    public static int SwigDirector_IKldSceneBaseImpl_activateMapConfig(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.activateMapConfig();
    }

    public static int SwigDirector_IKldSceneBaseImpl_activateRenderConfig(IKldSceneBaseImpl iKldSceneBaseImpl) {
        return iKldSceneBaseImpl.activateRenderConfig();
    }

    public static int SwigDirector_CBLSceneMapImpl_onSceneInit(CBLSceneMapImpl cBLSceneMapImpl, CKldIntent cKldIntent) {
        return cBLSceneMapImpl.onSceneInit(cKldIntent);
    }

    public static int SwigDirector_CBLSceneMapImpl_onSceneEntered(CBLSceneMapImpl cBLSceneMapImpl, String str, CKldIntent cKldIntent) {
        return cBLSceneMapImpl.onSceneEntered(str, cKldIntent);
    }

    public static int SwigDirector_CBLSceneMapImpl_onSceneExit(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.onSceneExit();
    }

    public static int SwigDirector_CBLSceneMapImpl_onSceneResume(CBLSceneMapImpl cBLSceneMapImpl, boolean z) {
        return cBLSceneMapImpl.onSceneResume(z);
    }

    public static int SwigDirector_CBLSceneMapImpl_onScenePause(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.onScenePause();
    }

    public static void SwigDirector_CBLSceneMapImpl_onNewIntent(CBLSceneMapImpl cBLSceneMapImpl, CKldIntent cKldIntent) {
        cBLSceneMapImpl.onNewIntent(cKldIntent);
    }

    public static int SwigDirector_CBLSceneMapImpl_onUpateSceneState(CBLSceneMapImpl cBLSceneMapImpl, String str, SceneViewState sceneViewState) {
        return cBLSceneMapImpl.onUpateSceneState(str, sceneViewState);
    }

    public static void SwigDirector_CBLSceneMapImpl_restoreSceneState(CBLSceneMapImpl cBLSceneMapImpl) {
        cBLSceneMapImpl.restoreSceneState();
    }

    public static boolean SwigDirector_CBLSceneMapImpl_setMapCenterWhenRestore(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.setMapCenterWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneMapImpl_setZoomerWhenRestore(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.setZoomerWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneMapImpl_setMapModeWhenRestore(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.setMapModeWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneMapImpl_setMapProjectionCenterWhenRestore(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.setMapProjectionCenterWhenRestore();
    }

    public static int SwigDirector_CBLSceneMapImpl_activateMapConfig(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.activateMapConfig();
    }

    public static int SwigDirector_CBLSceneMapImpl_activateRenderConfig(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.activateRenderConfig();
    }

    public static int SwigDirector_CBLSceneMapImpl_open(CBLSceneMapImpl cBLSceneMapImpl) {
        return cBLSceneMapImpl.open();
    }

    public static int SwigDirector_CBLSceneNaviImpl_onSceneInit(CBLSceneNaviImpl cBLSceneNaviImpl, CKldIntent cKldIntent) {
        return cBLSceneNaviImpl.onSceneInit(cKldIntent);
    }

    public static int SwigDirector_CBLSceneNaviImpl_onSceneEntered(CBLSceneNaviImpl cBLSceneNaviImpl, String str, CKldIntent cKldIntent) {
        return cBLSceneNaviImpl.onSceneEntered(str, cKldIntent);
    }

    public static int SwigDirector_CBLSceneNaviImpl_onSceneExit(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.onSceneExit();
    }

    public static int SwigDirector_CBLSceneNaviImpl_onSceneResume(CBLSceneNaviImpl cBLSceneNaviImpl, boolean z) {
        return cBLSceneNaviImpl.onSceneResume(z);
    }

    public static int SwigDirector_CBLSceneNaviImpl_onScenePause(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.onScenePause();
    }

    public static void SwigDirector_CBLSceneNaviImpl_onNewIntent(CBLSceneNaviImpl cBLSceneNaviImpl, CKldIntent cKldIntent) {
        cBLSceneNaviImpl.onNewIntent(cKldIntent);
    }

    public static int SwigDirector_CBLSceneNaviImpl_onUpateSceneState(CBLSceneNaviImpl cBLSceneNaviImpl, String str, SceneViewState sceneViewState) {
        return cBLSceneNaviImpl.onUpateSceneState(str, sceneViewState);
    }

    public static void SwigDirector_CBLSceneNaviImpl_restoreSceneState(CBLSceneNaviImpl cBLSceneNaviImpl) {
        cBLSceneNaviImpl.restoreSceneState();
    }

    public static boolean SwigDirector_CBLSceneNaviImpl_setMapCenterWhenRestore(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.setMapCenterWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneNaviImpl_setZoomerWhenRestore(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.setZoomerWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneNaviImpl_setMapModeWhenRestore(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.setMapModeWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneNaviImpl_setMapProjectionCenterWhenRestore(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.setMapProjectionCenterWhenRestore();
    }

    public static int SwigDirector_CBLSceneNaviImpl_activateMapConfig(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.activateMapConfig();
    }

    public static int SwigDirector_CBLSceneNaviImpl_activateRenderConfig(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.activateRenderConfig();
    }

    public static int SwigDirector_CBLSceneNaviImpl_open(CBLSceneNaviImpl cBLSceneNaviImpl) {
        return cBLSceneNaviImpl.open();
    }

    public static int SwigDirector_CBLSceneOpeningImpl_onSceneInit(CBLSceneOpeningImpl cBLSceneOpeningImpl, CKldIntent cKldIntent) {
        return cBLSceneOpeningImpl.onSceneInit(cKldIntent);
    }

    public static int SwigDirector_CBLSceneOpeningImpl_onSceneEntered(CBLSceneOpeningImpl cBLSceneOpeningImpl, String str, CKldIntent cKldIntent) {
        return cBLSceneOpeningImpl.onSceneEntered(str, cKldIntent);
    }

    public static int SwigDirector_CBLSceneOpeningImpl_onSceneExit(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.onSceneExit();
    }

    public static int SwigDirector_CBLSceneOpeningImpl_onSceneResume(CBLSceneOpeningImpl cBLSceneOpeningImpl, boolean z) {
        return cBLSceneOpeningImpl.onSceneResume(z);
    }

    public static int SwigDirector_CBLSceneOpeningImpl_onScenePause(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.onScenePause();
    }

    public static void SwigDirector_CBLSceneOpeningImpl_onNewIntent(CBLSceneOpeningImpl cBLSceneOpeningImpl, CKldIntent cKldIntent) {
        cBLSceneOpeningImpl.onNewIntent(cKldIntent);
    }

    public static int SwigDirector_CBLSceneOpeningImpl_onUpateSceneState(CBLSceneOpeningImpl cBLSceneOpeningImpl, String str, SceneViewState sceneViewState) {
        return cBLSceneOpeningImpl.onUpateSceneState(str, sceneViewState);
    }

    public static void SwigDirector_CBLSceneOpeningImpl_restoreSceneState(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        cBLSceneOpeningImpl.restoreSceneState();
    }

    public static boolean SwigDirector_CBLSceneOpeningImpl_setMapCenterWhenRestore(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.setMapCenterWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneOpeningImpl_setZoomerWhenRestore(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.setZoomerWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneOpeningImpl_setMapModeWhenRestore(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.setMapModeWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneOpeningImpl_setMapProjectionCenterWhenRestore(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.setMapProjectionCenterWhenRestore();
    }

    public static int SwigDirector_CBLSceneOpeningImpl_activateMapConfig(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.activateMapConfig();
    }

    public static int SwigDirector_CBLSceneOpeningImpl_activateRenderConfig(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.activateRenderConfig();
    }

    public static int SwigDirector_CBLSceneOpeningImpl_open(CBLSceneOpeningImpl cBLSceneOpeningImpl) {
        return cBLSceneOpeningImpl.open();
    }

    public static int SwigDirector_CBLScenePreviewImpl_onSceneInit(CBLScenePreviewImpl cBLScenePreviewImpl, CKldIntent cKldIntent) {
        return cBLScenePreviewImpl.onSceneInit(cKldIntent);
    }

    public static int SwigDirector_CBLScenePreviewImpl_onSceneEntered(CBLScenePreviewImpl cBLScenePreviewImpl, String str, CKldIntent cKldIntent) {
        return cBLScenePreviewImpl.onSceneEntered(str, cKldIntent);
    }

    public static int SwigDirector_CBLScenePreviewImpl_onSceneExit(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.onSceneExit();
    }

    public static int SwigDirector_CBLScenePreviewImpl_onSceneResume(CBLScenePreviewImpl cBLScenePreviewImpl, boolean z) {
        return cBLScenePreviewImpl.onSceneResume(z);
    }

    public static int SwigDirector_CBLScenePreviewImpl_onScenePause(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.onScenePause();
    }

    public static void SwigDirector_CBLScenePreviewImpl_onNewIntent(CBLScenePreviewImpl cBLScenePreviewImpl, CKldIntent cKldIntent) {
        cBLScenePreviewImpl.onNewIntent(cKldIntent);
    }

    public static int SwigDirector_CBLScenePreviewImpl_onUpateSceneState(CBLScenePreviewImpl cBLScenePreviewImpl, String str, SceneViewState sceneViewState) {
        return cBLScenePreviewImpl.onUpateSceneState(str, sceneViewState);
    }

    public static void SwigDirector_CBLScenePreviewImpl_restoreSceneState(CBLScenePreviewImpl cBLScenePreviewImpl) {
        cBLScenePreviewImpl.restoreSceneState();
    }

    public static boolean SwigDirector_CBLScenePreviewImpl_setMapCenterWhenRestore(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.setMapCenterWhenRestore();
    }

    public static boolean SwigDirector_CBLScenePreviewImpl_setZoomerWhenRestore(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.setZoomerWhenRestore();
    }

    public static boolean SwigDirector_CBLScenePreviewImpl_setMapModeWhenRestore(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.setMapModeWhenRestore();
    }

    public static boolean SwigDirector_CBLScenePreviewImpl_setMapProjectionCenterWhenRestore(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.setMapProjectionCenterWhenRestore();
    }

    public static int SwigDirector_CBLScenePreviewImpl_activateMapConfig(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.activateMapConfig();
    }

    public static int SwigDirector_CBLScenePreviewImpl_activateRenderConfig(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.activateRenderConfig();
    }

    public static int SwigDirector_CBLScenePreviewImpl_open(CBLScenePreviewImpl cBLScenePreviewImpl) {
        return cBLScenePreviewImpl.open();
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_onSceneInit(CBLSceneRouteResultImpl cBLSceneRouteResultImpl, CKldIntent cKldIntent) {
        return cBLSceneRouteResultImpl.onSceneInit(cKldIntent);
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_onSceneEntered(CBLSceneRouteResultImpl cBLSceneRouteResultImpl, String str, CKldIntent cKldIntent) {
        return cBLSceneRouteResultImpl.onSceneEntered(str, cKldIntent);
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_onSceneExit(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.onSceneExit();
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_onSceneResume(CBLSceneRouteResultImpl cBLSceneRouteResultImpl, boolean z) {
        return cBLSceneRouteResultImpl.onSceneResume(z);
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_onScenePause(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.onScenePause();
    }

    public static void SwigDirector_CBLSceneRouteResultImpl_onNewIntent(CBLSceneRouteResultImpl cBLSceneRouteResultImpl, CKldIntent cKldIntent) {
        cBLSceneRouteResultImpl.onNewIntent(cKldIntent);
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_onUpateSceneState(CBLSceneRouteResultImpl cBLSceneRouteResultImpl, String str, SceneViewState sceneViewState) {
        return cBLSceneRouteResultImpl.onUpateSceneState(str, sceneViewState);
    }

    public static void SwigDirector_CBLSceneRouteResultImpl_restoreSceneState(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        cBLSceneRouteResultImpl.restoreSceneState();
    }

    public static boolean SwigDirector_CBLSceneRouteResultImpl_setMapCenterWhenRestore(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.setMapCenterWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneRouteResultImpl_setZoomerWhenRestore(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.setZoomerWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneRouteResultImpl_setMapModeWhenRestore(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.setMapModeWhenRestore();
    }

    public static boolean SwigDirector_CBLSceneRouteResultImpl_setMapProjectionCenterWhenRestore(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.setMapProjectionCenterWhenRestore();
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_activateMapConfig(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.activateMapConfig();
    }

    public static int SwigDirector_CBLSceneRouteResultImpl_activateRenderConfig(CBLSceneRouteResultImpl cBLSceneRouteResultImpl) {
        return cBLSceneRouteResultImpl.activateRenderConfig();
    }

    public static int SwigDirector_IKldDisplayDataProviderImpl_onFetchDeviceAttr(IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl, @DisplayType.DisplayType1 int i, DeviceAttribute deviceAttribute) {
        return iKldDisplayDataProviderImpl.onFetchDeviceAttr(i, deviceAttribute);
    }

    public static int SwigDirector_IKldDisplayDataProviderImpl_onFetchSurfaceAttr(IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl, @DisplayType.DisplayType1 int i, EGLSurfaceAttr eGLSurfaceAttr) {
        return iKldDisplayDataProviderImpl.onFetchSurfaceAttr(i, eGLSurfaceAttr);
    }

    public static int SwigDirector_IKldDisplayDataProviderImpl_onFetchSkyBox(IKldDisplayDataProviderImpl iKldDisplayDataProviderImpl, @DisplayType.DisplayType1 int i, @DAY_STATUS.DAY_STATUS1 int i2, MapSkyboxParam mapSkyboxParam) {
        return iKldDisplayDataProviderImpl.onFetchSkyBox(i, i2, mapSkyboxParam);
    }

    public static void SwigDirector_IKldRemoteDispObserverImpl_onRemoteDisplayCreated(IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iKldRemoteDispObserverImpl.onRemoteDisplayCreated(i, i2);
    }

    public static void SwigDirector_IKldRemoteDispObserverImpl_onRemoteDisplayDestroyed(IKldRemoteDispObserverImpl iKldRemoteDispObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iKldRemoteDispObserverImpl.onRemoteDisplayDestroyed(i, i2);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_onDisplayCreated(IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iKldDisplayObserverImpl.onDisplayCreated(i, i2);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_onDisplayCropCustom(IKldDisplayObserverImpl iKldDisplayObserverImpl, IKldDisplayImpl iKldDisplayImpl, IKldDisplayCrop iKldDisplayCrop) {
        iKldDisplayObserverImpl.onDisplayCropCustom(iKldDisplayImpl, iKldDisplayCrop);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_onMapFirstPaint(IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iKldDisplayObserverImpl.onMapFirstPaint(i, i2);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_onMainDisplayCreated(IKldDisplayObserverImpl iKldDisplayObserverImpl, int i) {
        iKldDisplayObserverImpl.onMainDisplayCreated(i);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_beforeSceneContextInit(IKldDisplayObserverImpl iKldDisplayObserverImpl, CKldSceneContextImpl cKldSceneContextImpl) {
        iKldDisplayObserverImpl.beforeSceneContextInit(cKldSceneContextImpl);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_beforeEGLDevCreated(IKldDisplayObserverImpl iKldDisplayObserverImpl, IKldDisplayImpl iKldDisplayImpl) {
        iKldDisplayObserverImpl.beforeEGLDevCreated(iKldDisplayImpl);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_beforeEGLMapCreated(IKldDisplayObserverImpl iKldDisplayObserverImpl, IKldDisplayImpl iKldDisplayImpl) {
        iKldDisplayObserverImpl.beforeEGLMapCreated(iKldDisplayImpl);
    }

    public static void SwigDirector_IKldDisplayObserverImpl_onMapDoRender(IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, @DisplayType.DisplayType1 int i2) {
        iKldDisplayObserverImpl.onMapDoRender(i, i2);
    }

    public static boolean SwigDirector_IKldDisplayObserverImpl_onCheckSyncAllowed(IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, int i2, int i3) {
        return iKldDisplayObserverImpl.onCheckSyncAllowed(i, i2, i3);
    }

    public static boolean SwigDirector_IKldDisplayObserverImpl_onProcessCustomInComeMsg(IKldDisplayObserverImpl iKldDisplayObserverImpl, int i, @CHANNEL_MSG_TYPE.CHANNEL_MSG_TYPE1 int i2, int i3, ChannelParcelImpl channelParcelImpl) {
        return iKldDisplayObserverImpl.onProcessCustomInComeMsg(i, i2, i3, channelParcelImpl);
    }
}
