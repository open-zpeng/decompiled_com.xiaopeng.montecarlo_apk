package com.xiaopeng.montecarlo.util;

import android.os.Bundle;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.LinkSeamlessNaviBridge;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseScenePresenter;
import com.xiaopeng.montecarlo.scenes.mapscene.IMapContract;
import com.xiaopeng.montecarlo.scenes.mapscene.MapScenePresenter;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.NaviScenePresenter;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.routescene.RouteScenePresenter;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultPresenter;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingPreferencePresenter;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
/* loaded from: classes3.dex */
public class SpeechEventBizHelper {
    private static final L.Tag TAG = new L.Tag("SpeechEventBizHelper");

    public boolean closeScene(SpeechNaviEvent speechNaviEvent, IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "closeScene event:" + speechNaviEvent + ",scene:" + iBaseScene);
        }
        if (iBaseScene.getBridge().getMode().ordinal() == speechNaviEvent.getSceneMode()) {
            iBaseScene.backToMode(iBaseScene.getBridge().getMode(), true);
            return true;
        }
        return false;
    }

    public void openLinkSeamlessNavi(IBaseScene iBaseScene) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openLinkSeamlessNavi scene:" + iBaseScene);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(LinkSeamlessNaviBridge.KEY_FROM_WHERE, 1);
        iBaseScene.startScene(new LinkSeamlessNaviBridge().setBundle(bundle).setStartMode(1), 300);
    }

    public void openSettings(IMapContract.LogicView logicView, MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openSettings scene:" + logicView + ",mainContext:" + mainContext);
        }
        logicView.startSettingScene();
        SpeechStatProxy.getInstance().sendStatDataForSpeech(10, 2);
    }

    public void openSearchHistories(IMapContract.LogicView logicView, MainContext mainContext) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openSearchHistories scene:" + logicView + ",mainContext:" + mainContext);
        }
        logicView.startSearchHistories();
    }

    public void setMute(MapScenePresenter mapScenePresenter, boolean z) {
        mapScenePresenter.setTtsEnabledStatus(z);
    }

    public void zoomIn(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.executeSpeechCmdZoomIn();
    }

    public void zoomInMax(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.executeSpeechCmdZoomInMax();
    }

    public void zoomOut(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.executeSpeechCmdZoomOut();
    }

    public void zoomOutMin(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.executeSpeechCmdZoomOutMin();
    }

    public void zoom(MapScenePresenter mapScenePresenter, int i) {
        mapScenePresenter.executeSpeechCmdZoom(i);
    }

    public void enterActiveState() {
        StateManager.getInstance().switchActiveState();
    }

    public void setMapModeNorthUp(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.executeSpeechCmdMapModeNorthUp();
    }

    public void setMapModeHeadUp2D(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.executeSpeechCmdMapModeHeadUp2D();
    }

    public void setMapModeHeadUp3D(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.executeSpeechCmdMapModeHeadUp3D();
    }

    public void switchChargingStation(MapScenePresenter mapScenePresenter, SpeechNaviEvent speechNaviEvent) {
        mapScenePresenter.executeSpeechCmdSwitchChargingStation(speechNaviEvent);
    }

    public void setPoiToCenter(MapScenePresenter mapScenePresenter, SpeechNaviEvent speechNaviEvent) {
        mapScenePresenter.executeSpeechCmdSetPoiToCenter(speechNaviEvent);
    }

    public boolean executeWhenVoiceSearchFusionDataFetched(MapScenePresenter mapScenePresenter, SpeechNaviEvent speechNaviEvent) {
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return mapScenePresenter.executeSpeechCmdVoiceSearchDataFetched(speechNaviEvent);
        }
        return false;
    }

    public void switchToMainRoad(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.switchRoad(true);
    }

    public void switchToSlidRoad(MapScenePresenter mapScenePresenter) {
        mapScenePresenter.switchRoad(false);
    }

    public void routeNewDestWithVias(IBaseScene iBaseScene, SpeechNaviEvent speechNaviEvent) {
        Utils.startSceneForRoute(iBaseScene, RouteRequest.createNewDesRequestWithVias(speechNaviEvent.getOrig(), speechNaviEvent.getDest(), speechNaviEvent.getViaList(), speechNaviEvent.getSettingParam(), speechNaviEvent.getStartType(), speechNaviEvent.getRouteSelectRef()).setRequestFrom(1));
    }

    public void stopNavi(BaseNaviPresenter baseNaviPresenter) {
        baseNaviPresenter.executeSpeechCmdStopNavi();
    }

    public void reroute(BaseNaviPresenter baseNaviPresenter) {
        baseNaviPresenter.executeSpeechCmdReroute();
    }

    public void routeNewDestWithViasInNav(BaseNaviPresenter baseNaviPresenter, SpeechNaviEvent speechNaviEvent) {
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            NaviModel.getInstance().startSpeechDialog();
        }
        baseNaviPresenter.executeSpeechCmdRouteNewDestWithVias(speechNaviEvent);
    }

    public void addViaInNavi(BaseNaviPresenter baseNaviPresenter, SpeechNaviEvent speechNaviEvent) {
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            NaviModel.getInstance().startSpeechDialog();
        }
        baseNaviPresenter.executeSpeechCmdAddVia(speechNaviEvent);
    }

    public void selectRecommendPard(BaseNaviPresenter baseNaviPresenter, SpeechNaviEvent speechNaviEvent) {
        baseNaviPresenter.executeSpeechCmdSelectRecommendPark(speechNaviEvent);
    }

    public void startNavi(BaseNaviPresenter baseNaviPresenter) {
        baseNaviPresenter.executeSpeechCmdStartNavi();
    }

    public void zoomInInNavi(BaseNaviPresenter baseNaviPresenter) {
        baseNaviPresenter.executeSpeechCmdZoomIn();
    }

    public void zoomOutInNavi(BaseNaviPresenter baseNaviPresenter) {
        baseNaviPresenter.executeSpeechCmdZoomOut();
    }

    public void openFavorite(BaseNaviPresenter baseNaviPresenter) {
        baseNaviPresenter.executeSpeechCmdOpenFavorite();
    }

    public void setMapModeNorthUpNotSupported(ICommandCallback iCommandCallback) {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(42, 0);
        iCommandCallback.notSupport();
    }

    public void setMapModeHeadUp2DNotSupported(ICommandCallback iCommandCallback) {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(41, 0);
        iCommandCallback.notSupport();
    }

    public void setMapModeHeadUp3DNotSupported(ICommandCallback iCommandCallback) {
        SpeechStatProxy.getInstance().sendStatDataForSpeech(40, 0);
        iCommandCallback.notSupport();
    }

    public void openOverview(NaviScenePresenter naviScenePresenter) {
        naviScenePresenter.executeSpeechCmdOpenOverview();
    }

    public void closeOverview(NaviScenePresenter naviScenePresenter) {
        naviScenePresenter.executeSpeechCmdCloseOverview();
    }

    public void exitCross3D(NaviScenePresenter naviScenePresenter) {
        naviScenePresenter.executeSpeechCmdExitCross3D();
    }

    public void startNaviInRoute(RouteScenePresenter routeScenePresenter, SpeechNaviEvent speechNaviEvent) {
        routeScenePresenter.executeSpeechCmdStartNavi(speechNaviEvent);
    }

    public void rerouteInRoute(RouteScenePresenter routeScenePresenter) {
        routeScenePresenter.executeSpeechCmdReroute();
    }

    public void routeNewDestWithViasInRoute(RouteScenePresenter routeScenePresenter, SpeechNaviEvent speechNaviEvent) {
        routeScenePresenter.executeSpeechCmdRouteNewDestWithVias(speechNaviEvent);
    }

    public void addViaInRoute(RouteScenePresenter routeScenePresenter, SpeechNaviEvent speechNaviEvent) {
        routeScenePresenter.executeSpeechCmdAddVia(speechNaviEvent);
    }

    public void openFavoriteInRoute(RouteScenePresenter routeScenePresenter) {
        routeScenePresenter.executeSpeechCmdOpenFavorite();
    }

    public boolean executeWhenVoiceSearchDataItemFocusedInRoute(RouteScenePresenter routeScenePresenter, SpeechNaviEvent speechNaviEvent) {
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return routeScenePresenter.executeSpeechCmdVoiceSearchDataItemFocused(speechNaviEvent);
        }
        return false;
    }

    public void openFavoriteInSearch(SearchPresenter searchPresenter) {
        searchPresenter.executeSpeechCmdOpenFavorite();
    }

    public void openNormalInSearch(SearchPresenter searchPresenter) {
        searchPresenter.executeSpeechCmdOpenNormal();
    }

    public void openSettingsInSearch(SearchPresenter searchPresenter) {
        searchPresenter.executeSpeechCmdOpenSettings();
    }

    public void updateFavoriteButton(SearchPresenter searchPresenter) {
        searchPresenter.executeSpeechCmdUpdateFavoriteButton();
    }

    public boolean routeNewDestWithViaInSearchResult(SearchResultPresenter searchResultPresenter, SpeechNaviEvent speechNaviEvent) {
        return searchResultPresenter.executeSpeechCmdRouteNewDestWithVias(speechNaviEvent);
    }

    public boolean addViaInSearchResult(SearchResultPresenter searchResultPresenter, SpeechNaviEvent speechNaviEvent) {
        return searchResultPresenter.addViaInSearchResult(speechNaviEvent);
    }

    public void openFavoriteInSearchResult(SearchResultPresenter searchResultPresenter) {
        searchResultPresenter.executeSpeechCmdOpenFavorite();
    }

    public boolean executeWhenVoiceInteractiveEnd(SearchResultPresenter searchResultPresenter) {
        return searchResultPresenter.executeSpeechCmdVoiceInteractiveEnd();
    }

    public boolean executeWhenVoiceSearchDataFetchedInSearchResult(SearchResultPresenter searchResultPresenter, SpeechNaviEvent speechNaviEvent) {
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return searchResultPresenter.executeSpeechCmdVoiceSearchDataFetched(speechNaviEvent);
        }
        return false;
    }

    public boolean executeWhenVoiceSearchDataItemFocusedInSearchResult(SearchResultPresenter searchResultPresenter, SpeechNaviEvent speechNaviEvent) {
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return searchResultPresenter.executeSpeechCmdDataItemFocused(speechNaviEvent);
        }
        return false;
    }

    public void refreshAllSettings(SettingPreferencePresenter settingPreferencePresenter) {
        settingPreferencePresenter.executeSpeechCmdRefreshAll();
    }

    public void openFavoriteInSetting(SettingPreferencePresenter settingPreferencePresenter) {
        settingPreferencePresenter.executeSpeechCmdOpenFavorite();
    }

    public void openSettings(SettingPreferencePresenter settingPreferencePresenter) {
        settingPreferencePresenter.executeSpeechCmdOpenSettings();
    }

    public void openLinkSeamlessNavi(SettingPreferencePresenter settingPreferencePresenter) {
        settingPreferencePresenter.executeSpeechCmdOpenLinkSeamlessNavi();
    }

    public void openSettingLicencePlate(SettingPreferencePresenter settingPreferencePresenter) {
        settingPreferencePresenter.executeSpeechCmdOpenSettingLicencePlate();
    }

    public boolean executeWhenVoiceInteractiveEndInRoute(RouteScenePresenter routeScenePresenter) {
        return routeScenePresenter.executeWhenVoiceInteractiveEnd();
    }

    public boolean executeWhenInfoflowScrollEnd(SearchResultPresenter searchResultPresenter, SpeechNaviEvent speechNaviEvent) {
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return searchResultPresenter.executeSpeechCmdInfoScrollEnd(speechNaviEvent);
        }
        return false;
    }

    public boolean executeWhenOnDialogStartInRoute(RouteScenePresenter routeScenePresenter) {
        return routeScenePresenter.executeWhenOnDialogStart();
    }

    public boolean executeOpenSearchNormalInRoute(RouteScenePresenter routeScenePresenter) {
        return routeScenePresenter.executeOpenSearchNormal();
    }

    public void openSearchNormalInNavi(BaseNaviPresenter baseNaviPresenter) {
        baseNaviPresenter.openSearchNormal();
    }

    public boolean executeStartExploreInRoute(RouteScenePresenter routeScenePresenter) {
        return routeScenePresenter.executeStartExplore();
    }

    public void executeVoiceSearchDataFetched(RouteScenePresenter routeScenePresenter) {
        if (routeScenePresenter.isRouteFromSpeech()) {
            routeScenePresenter.cancelRoute();
        }
    }

    public void switchSmartScale(SpeechNaviEvent speechNaviEvent, NaviScenePresenter naviScenePresenter) {
        naviScenePresenter.switchSmartScale(speechNaviEvent);
    }

    public void onSmartScaleSwitch(SpeechNaviEvent speechNaviEvent, CruiseScenePresenter cruiseScenePresenter) {
        cruiseScenePresenter.onSmartScaleSwitch(speechNaviEvent);
    }

    public void checkTopChildScene(SpeechNaviEvent speechNaviEvent, MapScenePresenter mapScenePresenter) {
        mapScenePresenter.checkTopChildScene(speechNaviEvent);
    }

    public boolean executeWhenInfoflowListStateChanged(SearchResultPresenter searchResultPresenter, SpeechNaviEvent speechNaviEvent) {
        if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return searchResultPresenter.executeSpeechCmdInfoflowListStateChanged(speechNaviEvent);
        }
        return false;
    }

    public boolean executeWhenInfoflowCardHeightChangedInSearch(SearchResultPresenter searchResultPresenter, SpeechNaviEvent speechNaviEvent) {
        if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return searchResultPresenter.executeWhenInfoflowCardHeightChanged(speechNaviEvent);
        }
        return false;
    }

    public boolean executeWhenInfoflowCardHeightChangedInRoute(RouteScenePresenter routeScenePresenter, SpeechNaviEvent speechNaviEvent) {
        if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return routeScenePresenter.executeWhenInfoflowCardHeightChanged(speechNaviEvent);
        }
        return false;
    }

    public boolean executeWhenWidgetCancel(RouteScenePresenter routeScenePresenter, SpeechNaviEvent speechNaviEvent) {
        if (Utils.isPortrait() && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            return routeScenePresenter.executeWhenWidgetCancel(speechNaviEvent);
        }
        return false;
    }

    public void exitSROrLaneMode(NaviScenePresenter naviScenePresenter) {
        naviScenePresenter.exitSROrLaneMode();
    }
}
