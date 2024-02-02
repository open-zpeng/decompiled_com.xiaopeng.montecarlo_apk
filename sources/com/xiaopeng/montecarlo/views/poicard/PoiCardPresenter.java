package com.xiaopeng.montecarlo.views.poicard;

import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.stat.PoiPopStatUtil;
import com.xiaopeng.montecarlo.stat.SearchStatUtil;
import com.xiaopeng.montecarlo.stat.StatUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PoiCardPresenter {
    private static final L.Tag TAG = new L.Tag("PoiCardPresenter POI POP");
    private PoiCardView mCardView;
    private IPoiCardDataProvider mDataProvider;
    private PoiCardDataProviderListener mDataProviderListener;
    private PoiCardEventListener mEventListener;
    private final MainContext mMainContext;
    private BaseMapDecorator mMapDecorator;
    private XPPoiInfo mPoiInfo;
    private final IBaseScene mScene;
    private final XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardPresenter.1
        @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
        public void onThemeSwitch(int i) {
            if (PoiCardPresenter.this.isCardCurrentShow() && PoiCardPresenter.this.mCardView != null) {
                PoiCardPresenter.this.mCardView.render(false);
            }
        }
    };
    private int mIndex = -1;

    public PoiCardPresenter(IBaseScene iBaseScene, PoiCardView poiCardView, MainContext mainContext) {
        this.mScene = iBaseScene;
        this.mCardView = poiCardView;
        this.mMainContext = mainContext;
        this.mCardView.setMainContext(this.mMainContext);
        initListeners();
        this.mDataProvider = new PoiCardDataProvider(this.mDataProviderListener);
    }

    public IPoiCardDataProvider getDataProvider() {
        return this.mDataProvider;
    }

    public IBaseScene getScene() {
        return this.mScene;
    }

    public int getSearchDest() {
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView == null) {
            return 1000;
        }
        return poiCardView.getSearchDest();
    }

    private void initDecoratorValues(BaseMapDecorator baseMapDecorator) {
        this.mMapDecorator = baseMapDecorator;
        this.mIndex = baseMapDecorator.getCurrentExpandedIndex();
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.initDecoratorValues(baseMapDecorator);
        }
    }

    private void initListeners() {
        initEventListener();
        initDataProviderListener();
    }

    private void initDataProviderListener() {
        this.mDataProviderListener = new PoiCardDataProviderListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardPresenter.2
            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardDataProviderListener
            public void onRouteSuccess(IVariantPath iVariantPath, IPathResult iPathResult, RouteResult.RouteInfo routeInfo, XPPoiInfo xPPoiInfo) {
                if (L.ENABLE) {
                    L.Tag tag = PoiCardPresenter.TAG;
                    L.d(tag, "onRouteSuccess path:" + iVariantPath + ",routeInfo:" + routeInfo + ",end:" + xPPoiInfo);
                }
                if (PoiCardPresenter.this.isDifferentEndRoute(xPPoiInfo) || PoiCardPresenter.this.mCardView == null) {
                    return;
                }
                PoiCardPresenter.this.mCardView.onRouteSuccess(iVariantPath, iPathResult, routeInfo, xPPoiInfo);
                PoiCardPresenter.this.mCardView.renderBusinessTimeInfo(true, routeInfo.mTravelTime * 1000);
                PoiCardPresenter.this.mCardView.renderBottomButtonsStatus(true);
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardDataProviderListener
            public void onRouteFailure(XPPoiInfo xPPoiInfo) {
                if (L.ENABLE) {
                    L.Tag tag = PoiCardPresenter.TAG;
                    L.d(tag, "onRouteFailure end:" + xPPoiInfo);
                }
                if (PoiCardPresenter.this.isDifferentEndRoute(xPPoiInfo) || PoiCardPresenter.this.mCardView == null) {
                    return;
                }
                PoiCardPresenter.this.mCardView.onRouteFailure(xPPoiInfo);
                PoiCardPresenter.this.mCardView.renderBottomButtonsStatus(true);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDifferentEndRoute(XPPoiInfo xPPoiInfo) {
        XPPoiInfo xPPoiInfo2 = this.mPoiInfo;
        if (xPPoiInfo2 == null || xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo2.getPoiId()) || TextUtils.isEmpty(xPPoiInfo.getPoiId())) {
            return true;
        }
        return !this.mPoiInfo.getPoiId().equals(xPPoiInfo.getPoiId());
    }

    private void initEventListener() {
        this.mEventListener = new PoiCardEventListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardPresenter.3
            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEventListener
            public void onAddFavoriteClick() {
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEventListener
            public void onSearchClick() {
                if (!VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode()) {
                    PoiCardPresenter.this.handleSearchClick();
                } else {
                    VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
                }
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEventListener
            public void onAddWayPointClick() {
                if (VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode()) {
                    VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
                }
                PoiCardPresenter.this.handleAddWayPointClick();
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEventListener
            public void onDeleteWayPointClick() {
                if (VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode()) {
                    VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
                }
                PoiCardPresenter.this.handleDeleteWayPointClick();
                PoiPopStatUtil.sendStatDataWhenDeleteWaypoint(PoiCardPresenter.this.mMainContext);
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEventListener
            public void onStartNaviClick() {
                if (VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode()) {
                    VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
                }
                PoiCardPresenter.this.handleStartNaviClick();
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEventListener
            public void onHomeSettingSuccess(FavoriteAddress favoriteAddress) {
                if (VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode()) {
                    VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
                }
                PoiCardPresenter.this.handleOnHomeSettingSuccess(favoriteAddress);
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEventListener
            public void onOfficeSettingSuccess(FavoriteAddress favoriteAddress) {
                if (VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode()) {
                    VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
                }
                PoiCardPresenter.this.handelOfficeSettingSuccess(favoriteAddress);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handelOfficeSettingSuccess(FavoriteAddress favoriteAddress) {
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.goToSearch(favoriteAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnHomeSettingSuccess(FavoriteAddress favoriteAddress) {
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.goToSearch(favoriteAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartNaviClick() {
        RouteRequest createNewDesRequest;
        PoiPopStatUtil.sendStatDataWhenStartNavi(this.mMainContext);
        if (TBTManager.getInstance().getCurrentStatus() == 1 || TBTManager.getInstance().getCurrentStatus() == 2) {
            createNewDesRequest = RouteRequest.createNewDesRequest(this.mPoiInfo);
        } else {
            createNewDesRequest = RouteRequest.createNormalRequest(TBTManager.getInstance().getStartPOIFromCurrent(), this.mPoiInfo, null);
        }
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.startDestinationUpdate(createNewDesRequest.toBundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeleteWayPointClick() {
        if (isCardCurrentShow()) {
            RouteRequest createRemoveViaRequest = RouteRequest.createRemoveViaRequest(this.mPoiInfo, TBTManager.getInstance().getCurrentRouteRequestId());
            PoiCardView poiCardView = this.mCardView;
            if (poiCardView != null) {
                poiCardView.startRouteUpdate(createRemoveViaRequest.toBundle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAddWayPointClick() {
        PoiCardView poiCardView;
        if (isCardCurrentShow()) {
            PoiPopStatUtil.sendStatDataWhenAddWaypoint(this.mMainContext);
            RouteRequest createAddViaRequest = RouteRequest.createAddViaRequest(this.mPoiInfo, TBTManager.getInstance().getCurrentRouteRequestId());
            if (createAddViaRequest == null || (poiCardView = this.mCardView) == null) {
                return;
            }
            poiCardView.startRouteUpdate(createAddViaRequest.toBundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSearchClick() {
        PoiPopStatUtil.sendStatDataWhenSearchAround(this.mMainContext);
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.handleSearchClick();
        }
    }

    public void showLoading(BaseMapDecorator baseMapDecorator, boolean z) {
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            if (z) {
                initDecoratorValues(baseMapDecorator);
                this.mCardView.showLoading();
                return;
            }
            poiCardView.hideLoading();
        }
    }

    public void showCard(XPPoiInfo xPPoiInfo, BaseMapDecorator baseMapDecorator) {
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
        initDecoratorValues(baseMapDecorator);
        this.mPoiInfo = xPPoiInfo;
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.showCard(xPPoiInfo);
        }
    }

    public void updateCard(XPPoiInfo xPPoiInfo, BaseMapDecorator baseMapDecorator) {
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
        initDecoratorValues(baseMapDecorator);
        this.mPoiInfo = xPPoiInfo;
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.updateCard(xPPoiInfo);
        }
    }

    public void hideCard() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "hideCard poiInfo:" + this.mPoiInfo);
        }
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.hideCard();
        }
    }

    public void resetCard() {
        if (L.ENABLE) {
            L.d(TAG, "resetCard");
        }
        this.mDataProvider.reset();
        this.mDataProvider = null;
        hideCard();
        this.mCardView = null;
        this.mEventListener = null;
        this.mIndex = -1;
    }

    public boolean isCardCurrentShow() {
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            return poiCardView.isVisible();
        }
        return false;
    }

    public void renderAOIInfo(boolean z) {
        if (isCardCurrentShow()) {
            if (this.mCardView != null && getCardType() == 5) {
                if (L.ENABLE) {
                    L.d(TAG, "renderAOIInfo mCardType: PoiCardType.CARD_TYPE_RGC");
                }
                this.mCardView.clearAOIPolygon();
                return;
            }
            PoiCardView poiCardView = this.mCardView;
            if (poiCardView != null) {
                poiCardView.renderAoiAreaInfo(z);
            }
        }
    }

    private boolean isSearchResultFragSinglePoi() {
        IBaseScene iBaseScene = this.mScene;
        if (iBaseScene == null || !Utils.isSearchResultScene(iBaseScene)) {
            return false;
        }
        return this.mScene.isSearchResultFragSinglePoi(this.mPoiInfo);
    }

    public void checkIsShouldOverviewPolygon(ArrayList<Coord3DDouble> arrayList) {
        PoiCardView poiCardView;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "checkIsShouldOverviewPolygon isSearchResultFragSinglePoi() = " + isSearchResultFragSinglePoi());
        }
        if (isCardCurrentShow()) {
            if (getCardType() == 5) {
                if (L.ENABLE) {
                    L.d(TAG, "checkIsShouldOverviewPolygon mCardType: PoiCardType.CARD_TYPE_RGC");
                }
            } else if (isSearchResultFragSinglePoi()) {
                ArrayList<XPCoordinate2DDouble> poiPolygonBounds = this.mPoiInfo.getPoiPolygonBounds();
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("checkIsShouldOverviewPolygon isSearchResultFragSinglePoi items.size = ");
                    sb.append(poiPolygonBounds == null ? "0" : Integer.valueOf(poiPolygonBounds.size()));
                    L.d(tag2, sb.toString());
                }
                if (poiPolygonBounds == null || poiPolygonBounds.size() <= 0 || (poiCardView = this.mCardView) == null) {
                    return;
                }
                poiCardView.checkIsShouldOverviewPolygon(arrayList);
            }
        }
    }

    public void renderSubPoiInfo() {
        PoiCardView poiCardView;
        if (isCardCurrentShow() && (poiCardView = this.mCardView) != null) {
            poiCardView.renderSubPoi();
        }
    }

    public void onSearchClick() {
        PoiCardEventListener poiCardEventListener = this.mEventListener;
        if (poiCardEventListener != null) {
            poiCardEventListener.onSearchClick();
        }
    }

    public void onBtnFavoriteClick() {
        PoiCardEventListener poiCardEventListener = this.mEventListener;
        if (poiCardEventListener != null) {
            poiCardEventListener.onAddFavoriteClick();
        }
    }

    public void onAddWayPointClick() {
        PoiCardEventListener poiCardEventListener = this.mEventListener;
        if (poiCardEventListener != null) {
            poiCardEventListener.onAddWayPointClick();
        }
        BaseMapDecorator baseMapDecorator = this.mMapDecorator;
        if (baseMapDecorator != null) {
            baseMapDecorator.clearFocus();
        }
    }

    public void onDeleteWayPointClick() {
        PoiCardEventListener poiCardEventListener = this.mEventListener;
        if (poiCardEventListener != null) {
            poiCardEventListener.onDeleteWayPointClick();
            XPPoiInfo xPPoiInfo = this.mPoiInfo;
            if (xPPoiInfo != null) {
                SearchStatUtil.sendStatDataWhenHistoryItemDeleteWaypoint(this.mMainContext, StatUtil.formatLocationToStr(xPPoiInfo.getDisplayLon(), this.mPoiInfo.getDisplayLat()), this.mIndex);
            }
        }
        BaseMapDecorator baseMapDecorator = this.mMapDecorator;
        if (baseMapDecorator != null) {
            baseMapDecorator.clearFocus();
        }
    }

    public void onBtnStartNaviClick() {
        BaseMapDecorator baseMapDecorator;
        PoiCardEventListener poiCardEventListener = this.mEventListener;
        if (poiCardEventListener != null) {
            poiCardEventListener.onStartNaviClick();
        }
        if ((TBTManager.getInstance().getCurrentStatus() == 1 || TBTManager.getInstance().getCurrentStatus() == 2) && (baseMapDecorator = this.mMapDecorator) != null) {
            baseMapDecorator.clearFocus();
        }
    }

    public void onBtnPark() {
        L.i(TAG, "try to open charge service view");
        PoiPopStatUtil.sendStatDataWhenSelectChargeSpot(this.mMainContext);
        String poiId = this.mPoiInfo.getPoiId();
        Uri.Builder builder = new Uri.Builder();
        builder.authority("com.xiaopeng.chargeservice.ChargeServiceMainApiRouter").path("showChargeUnlockCard").appendQueryParameter(CPSearchParam.PARAM_KEY_STATIONID, poiId);
        try {
            ApiRouter.route(builder.build());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onSettingHomeContainerClick() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSettingHomeContainerClick poi:" + this.mPoiInfo);
        }
        PoiPopStatUtil.sendStatDataWhenSettingHome(this.mMainContext);
        FavoriteAddress favoriteAddress = new FavoriteAddress(this.mPoiInfo);
        boolean home = FavoriteDataManager.getInstance().setHome(favoriteAddress);
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.showSettingHomeResult(home);
        }
        if (home) {
            PoiCardEventListener poiCardEventListener = this.mEventListener;
            if (poiCardEventListener != null) {
                poiCardEventListener.onHomeSettingSuccess(favoriteAddress);
            }
            BaseMapDecorator baseMapDecorator = this.mMapDecorator;
            if (baseMapDecorator != null) {
                baseMapDecorator.setSearchDest(1000);
                this.mMapDecorator.clearFocus();
            }
        }
    }

    public void onSettingCompanyContainerClick() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onSettingCompanyContainerClick poi:" + this.mPoiInfo);
        }
        PoiPopStatUtil.sendStatDataWhenSettingCompany(this.mMainContext);
        FavoriteAddress favoriteAddress = new FavoriteAddress(this.mPoiInfo);
        boolean company = FavoriteDataManager.getInstance().setCompany(favoriteAddress);
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.showOfficeSettingResult(company);
        }
        if (company) {
            PoiCardEventListener poiCardEventListener = this.mEventListener;
            if (poiCardEventListener != null) {
                poiCardEventListener.onOfficeSettingSuccess(favoriteAddress);
            }
            BaseMapDecorator baseMapDecorator = this.mMapDecorator;
            if (baseMapDecorator != null) {
                baseMapDecorator.setSearchDest(1000);
                this.mMapDecorator.clearFocus();
            }
        }
    }

    public XPPoiInfo getCurrentShowPoiInfo() {
        return this.mPoiInfo;
    }

    public Rect formatCardPosition(Point point, int i, int i2) {
        if (getCardType() == 1) {
            i2 -= 5;
        }
        return new Rect(point.x - (i / 2), 0, 0, (RootUtil.getVisibleBottom() - point.y) + i2);
    }

    private int getCardType() {
        BaseMapDecorator baseMapDecorator = this.mMapDecorator;
        if (baseMapDecorator != null) {
            return baseMapDecorator.getCardType();
        }
        return 0;
    }

    public void updatePosition(int i, int i2) {
        if (this.mPoiInfo != null) {
            Point lonLatToPixel = this.mMainContext.getMapView().lonLatToPixel(new XPCoordinate2DDouble(this.mPoiInfo));
            if (lonLatToPixel == null) {
                L.w(TAG, "updatePosition newPoint is null.");
                return;
            }
            PoiCardView poiCardView = this.mCardView;
            if (poiCardView != null) {
                poiCardView.updateCardPosition(formatCardPosition(lonLatToPixel, i, i2));
            }
        }
    }

    public void move() {
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView != null) {
            poiCardView.move();
        }
    }

    public boolean checkIsSettingHomeOrOffice() {
        boolean z = false;
        if (isCardCurrentShow()) {
            int searchDest = getSearchDest();
            z = (searchDest == 1001 || searchDest == 1002) ? true : true;
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "checkIsSettingHomeOrOffice flag:" + z);
            }
            return z;
        }
        return false;
    }

    public PoiCardDisplayStateConfig getCardContentsDisplayState() {
        PoiCardDisplayStateConfig poiCardDisplayStateConfig = new PoiCardDisplayStateConfig();
        if (isCardCurrentShow()) {
            poiCardDisplayStateConfig.setIsBottomButtonsVisible(checkIsBottomButtonsVisible());
            poiCardDisplayStateConfig.setIsHomeOrOfficeButtonsVisible(checkIsHomeOrOfficeButtonsVisible());
            poiCardDisplayStateConfig.setIsNameVisible(checkIsNameVisible());
            poiCardDisplayStateConfig.setIsPicVisible(checkIsPicVisible());
            poiCardDisplayStateConfig.setIsAddressVisible(checkIsAddressVisible());
            poiCardDisplayStateConfig.setIsEvaluationVisible(checkIsEvaluationVisible());
            poiCardDisplayStateConfig.setIsCarServiceVisible(checkIsCarServiceVisible());
            poiCardDisplayStateConfig.setIsDistanceVisible(checkIsDistanceVisible());
            poiCardDisplayStateConfig.setIsEntryVisible(true);
            poiCardDisplayStateConfig.setIsChargeVisible(checkIsChargeVisible());
            poiCardDisplayStateConfig.setIsParkVisible(checkIsParkVisible());
            poiCardDisplayStateConfig.setIsTimeVisible(checkIsTimeVisible());
            poiCardDisplayStateConfig.setIsPriceVisible(checkIsPriceVisible());
            poiCardDisplayStateConfig.setIsRoadInfoVisible(checkIsRoadInfoVisible());
            poiCardDisplayStateConfig.setIsSubPoiVisible(checkIsSubPoiVisible());
        }
        return poiCardDisplayStateConfig;
    }

    private boolean checkIsBottomButtonsVisible() {
        PoiCardView poiCardView = this.mCardView;
        if (poiCardView == null) {
            L.w(TAG, "checkIsBottomButtonsVisible card view is null");
            return false;
        } else if (this.mPoiInfo != null) {
            DecoratorType decoratorType = poiCardView.getDecoratorType();
            return (checkIsSettingHomeOrOffice() || decoratorType == DecoratorType.END_POINT || decoratorType == DecoratorType.START_POINT) ? false : true;
        } else {
            return false;
        }
    }

    private boolean checkIsHomeOrOfficeButtonsVisible() {
        return this.mPoiInfo != null && checkIsSettingHomeOrOffice();
    }

    private boolean checkIsSubPoiVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return xPPoiInfo != null && CollectionUtils.isNotEmpty(xPPoiInfo.getChild());
    }

    private boolean checkIsRoadInfoVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getRoadInfo())) ? false : true;
    }

    private boolean checkIsPriceVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getPrice())) ? false : true;
    }

    private boolean checkIsTimeVisible() {
        XPPoiInfo xPPoiInfo;
        return (getCardType() == 5 || (xPPoiInfo = this.mPoiInfo) == null || TextUtils.isEmpty(xPPoiInfo.getOpenTime())) ? false : true;
    }

    private boolean checkIsParkVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return xPPoiInfo != null && xPPoiInfo.getParkTotal() >= 0;
    }

    private boolean checkIsChargeVisible() {
        XPDeepInfoPoi xPDeepInfoPoi;
        XPDeepCharging[] chargeData;
        XPDeepCharging xPDeepCharging;
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null || (xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi()) == null || (chargeData = xPDeepInfoPoi.getChargeData()) == null || chargeData.length <= 0 || (xPDeepCharging = chargeData[0]) == null) {
            return false;
        }
        return xPDeepCharging.getNumFast() > 0 || xPDeepCharging.getNumFastFree() > 0 || xPDeepCharging.getNumSlow() > 0 || xPDeepCharging.getNumSlowFree() > 0;
    }

    private boolean checkIsDistanceVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return xPPoiInfo != null && NavCoreUtil.isValidLatLon(xPPoiInfo.getDisplayLat(), this.mPoiInfo.getDisplayLon());
    }

    private boolean checkIsEvaluationVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return xPPoiInfo != null && (xPPoiInfo.getVisitCount() > 0 || this.mPoiInfo.getEvaluationCount() > 0 || this.mPoiInfo.isFreeParking());
    }

    private boolean checkIsCarServiceVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return (xPPoiInfo == null || xPPoiInfo.getXPCarServiceInfo() == null) ? false : true;
    }

    private boolean checkIsAddressVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getAddress())) ? false : true;
    }

    private boolean checkIsPicVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return xPPoiInfo != null && CollectionUtils.isNotEmpty(xPPoiInfo.getImageUrlList());
    }

    private boolean checkIsNameVisible() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        return (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getName())) ? false : true;
    }

    public void formatChildPoi(ChildPoiGridView childPoiGridView, String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("formatChildPoi fatherLabel:" + str + ",childPoiGridView:" + childPoiGridView));
        }
        CommonVuiHelper.getInstance().formatChildPoi(childPoiGridView, this.mPoiInfo.getName(), 0, "-poicard", str);
    }

    public void dialPhoneNumberForVui() {
        CommonVuiHelper.getInstance().dialPhoneNumberForVui(this.mPoiInfo, this.mMainContext);
    }
}
