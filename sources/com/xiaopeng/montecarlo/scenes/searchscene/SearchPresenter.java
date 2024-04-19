package com.xiaopeng.montecarlo.scenes.searchscene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.RectFloat;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.xiaopeng.montecarlo.account.sync.FavoriteSyncUtil;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.bean.LocationRecognitionInfo;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.FavoriteType;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteUtil;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IAssistantLocationService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantLocationFeedbackRequest;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.search.request.AlongWayRequest;
import com.xiaopeng.montecarlo.navcore.search.request.KeywordQueryRequest;
import com.xiaopeng.montecarlo.navcore.search.request.Request;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract;
import com.xiaopeng.montecarlo.scenes.searchscene.PresenterData;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.AlongWaySearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.CPSearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.NaviSearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDataProvider;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDeleteFavouriteParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDeleteHistoryParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchDeleteResult;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchFavouriteParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchHistoryDataProvider;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchKeywordParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchLoadDistanceParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultData;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SuggestSearchRequestParam;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.HomeOrOfficeSuggestStatUtil;
import com.xiaopeng.montecarlo.stat.SearchStatUtil;
import com.xiaopeng.montecarlo.util.Utils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class SearchPresenter extends BasePresenter implements ISearchContract.Presenter, BaseCallBack<SearchRequestParam, SearchResultData> {
    private static final L.Tag TAG = new L.Tag("SearchPresenter");
    private XPPoiInfo mAroundPoi;
    protected ChargeDataProvider mChargeDataProvider;
    private XPPoiInfo mCompanyXPPoiInfo;
    private List<String> mFavPoiIdList;
    private long mFavRecordUpdateTime;
    private long mFavoriteShowTime;
    private GeneralChargeRequestParam mGeneralChargeRequestParam;
    private XPPoiInfo mHomeXPPoiInfo;
    private boolean mIsClickFavoriteBtn;
    public final ISearchContract.LogicView mLogicView;
    private XPNaviSearchParam mNaviSearchParam;
    private PageType mOldPageType;
    private PresenterData mPresenterData;
    private String mSaveEtSearch;
    private ArrayList<XPPoiInfo> mSaveSearchData;
    @VisibleForTesting
    protected SearchDataProvider mSearchDataProvider;
    private SearchHistoryDataProvider mSearchHistoryDataProvider;
    private String mSearchKeywordText;
    @VisibleForTesting
    protected String mEditTextBak = "";
    private int mSearchMode = 100;
    private int mSearchModeView = 100;
    private int mSearchDest = 1000;
    private int mSearchType = -1;
    private int mStartAnimType = 0;
    private boolean mHasSaveState = false;
    private boolean mIsSwitchedCity = false;
    private MapStatus mSwitchCityMapStatus = new MapStatus();
    private int mSubContainerType = 2;
    private int mFromSceneIndex = -1;
    private int mFromSceneChildIndex = -1;
    private volatile IAssistantLocationService mAssistantLocationService = (IAssistantLocationService) HttpClientManager.getInstance().getService(IAssistantLocationService.class);
    private List<FavoriteAddress> mFavoriteAddressList = new ArrayList();
    private List<HistoryRecordInfo> mHistoryRecordList = new ArrayList();
    private Map<String, Boolean> mSettingAlertMap = new HashMap();
    private long mClickRecordTime = 0;
    private long mClickFavoriteTime = 0;
    private long mIntervalTime = 500;
    private boolean mHasFavoriteCacheDataInit = false;
    private int mOriginVuiState = 0;
    private boolean mHomeDistanceLoaded = false;
    private boolean mCompanyDistanceLoaded = false;
    private Runnable mLoadFavoriteListRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            SearchPresenter.this.requestFavouriteList(20);
        }
    };
    private Observer mAccountObserver = new Observer() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter.2
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            UserInfo userInfo;
            if (!(obj instanceof UserInfo) || (userInfo = (UserInfo) obj) == null) {
                return;
            }
            UserInfo.InfoType infoType = userInfo.getInfoType();
            UserInfo.UserType userType = userInfo.getUserType();
            L.Tag tag = SearchPresenter.TAG;
            L.i(tag, "account update infoType = " + infoType + ", userType = " + userType);
            if (infoType == UserInfo.InfoType.CHANGED) {
                SearchPresenter.this.resetFavoriteList();
                SearchPresenter.this.resetHistoryList();
            }
        }
    };
    private AccountEventCallback mAccountEventCallback = new AccountEventCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter.3
        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void amapQuickLogin() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void initAccountFinish() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void refreshSettingInfos(int i, int i2) {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void xpMapLogin() {
        }

        @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
        public void accountSyncFinish() {
            SearchPresenter.this.refreshForSyncFinish();
        }
    };

    public void setClickFavoriteBtn(boolean z) {
        this.mIsClickFavoriteBtn = z;
    }

    public boolean isClickFavoriteBtn() {
        return this.mIsClickFavoriteBtn;
    }

    public SearchPresenter(@NonNull ISearchContract.LogicView logicView) {
        if (logicView == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
        this.mSearchDataProvider = new SearchDataProvider();
        this.mChargeDataProvider = new ChargeDataProvider();
        this.mSearchHistoryDataProvider = new SearchHistoryDataProvider(this);
        resetFavRecordTime();
        resetHisRecordRequest();
    }

    public int getOriginVuiState() {
        return this.mOriginVuiState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshForSyncFinish() {
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("refreshForSyncFinish mFavoriteAddressList.size = ");
        List<FavoriteAddress> list = this.mFavoriteAddressList;
        sb.append(list == null ? 0 : list.size());
        sb.append(", isFavoriteShow() = ");
        sb.append(isFavoriteShow());
        sb.append(", mHistoryRecordList.size = ");
        List<HistoryRecordInfo> list2 = this.mHistoryRecordList;
        sb.append(list2 != null ? list2.size() : 0);
        L.i(tag, sb.toString());
        if (CollectionUtils.isEmpty(this.mFavoriteAddressList) && isFavoriteShow()) {
            requestFavouriteList(20);
        }
        if (!CollectionUtils.isEmpty(this.mHistoryRecordList) || this.mSearchHistoryDataProvider.hasPendingRequest()) {
            return;
        }
        resetHistoryList();
    }

    private void resetFavRecordTime() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mFavoriteShowTime = currentTimeMillis;
        this.mFavRecordUpdateTime = currentTimeMillis;
        List<String> list = this.mFavPoiIdList;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void resetHisRecordRequest() {
        this.mLogicView.resetHistoryPageState();
        this.mSearchHistoryDataProvider.resetHisRecordRequest();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public int getSearchModeView() {
        return this.mSearchModeView;
    }

    public boolean isSwitchedCity() {
        return this.mIsSwitchedCity;
    }

    public MapStatus getSwitchedCityMapStatus() {
        return this.mSwitchCityMapStatus;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void requestHistoryList(int i) {
        this.mSearchHistoryDataProvider.requestHistoryList(i, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void requestFavouriteList(int i) {
        SearchFavouriteParam searchFavouriteParam = new SearchFavouriteParam();
        searchFavouriteParam.setSearchType(0);
        searchFavouriteParam.setShowTime(this.mFavoriteShowTime);
        searchFavouriteParam.setUpdateTime(this.mFavRecordUpdateTime);
        searchFavouriteParam.setPoiIdList(this.mFavPoiIdList);
        searchFavouriteParam.setPaging(this.mLogicView.getFavoritePageNum() > 1);
        searchFavouriteParam.setPageSize(i);
        searchFavouriteParam.setLocation(TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
        if (i == 1) {
            searchFavouriteParam.setLoad(false);
        } else {
            searchFavouriteParam.setLoad(true);
        }
        this.mSearchDataProvider.getFavouriteList(searchFavouriteParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void requestNormalFavoriteCount() {
        if (!XPAccountServiceWrapper.getInstance().isLoginXp()) {
            this.mLogicView.updateNextIcon(0);
            return;
        }
        SearchFavouriteParam searchFavouriteParam = new SearchFavouriteParam();
        searchFavouriteParam.setSearchType(15);
        this.mSearchDataProvider.getNormalFavoriteCount(searchFavouriteParam, this);
    }

    public void delayLoadHistoryList() {
        this.mSearchHistoryDataProvider.delayRequestHistoryList(20, 300, this);
    }

    public void delayLoadFavoriteList() {
        UiHandlerUtil.getInstance().postDelayed(this.mLoadFavoriteListRunnable, 300L);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void setHomeCompany(FavoriteAddress favoriteAddress, int i) {
        if (i == 0) {
            this.mLogicView.showSettingHomeSuccess(setHomeForSync(favoriteAddress));
        } else if (i == 1) {
            this.mLogicView.showSettingCompanySuccess(setCompanyForSync(favoriteAddress));
        }
        goBackForResult(favoriteAddress);
    }

    private boolean setHomeForSync(FavoriteAddress favoriteAddress) {
        return FavoriteDataManager.getInstance().setHome(favoriteAddress);
    }

    private boolean setCompanyForSync(FavoriteAddress favoriteAddress) {
        return FavoriteDataManager.getInstance().setCompany(favoriteAddress);
    }

    public void resetHomeCompany() {
        FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
        FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
        XPPoiInfo startPOIFromCurrent = (home == null && company == null) ? null : TBTManager.getInstance().getStartPOIFromCurrent();
        if (home != null) {
            XPPoiInfo xPPoiInfo = home.getXPPoiInfo();
            checkPoiInfoForUpdateDistance(true, xPPoiInfo, this.mHomeXPPoiInfo, startPOIFromCurrent);
            this.mHomeXPPoiInfo = xPPoiInfo;
        }
        if (company != null) {
            XPPoiInfo xPPoiInfo2 = company.getXPPoiInfo();
            checkPoiInfoForUpdateDistance(false, xPPoiInfo2, this.mCompanyXPPoiInfo, startPOIFromCurrent);
            this.mCompanyXPPoiInfo = xPPoiInfo2;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void goToChildPoi(XPPoiInfo xPPoiInfo) {
        if (isRecordTime() || TextUtils.isEmpty(xPPoiInfo.getPoiId())) {
            return;
        }
        startPoiSearchResult(xPPoiInfo);
    }

    private boolean isRecordTime() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mClickRecordTime < this.mIntervalTime) {
            return true;
        }
        this.mClickRecordTime = currentTimeMillis;
        return false;
    }

    public void updateFavoriteStatus(int i, FavoriteAddress favoriteAddress) {
        FavoriteAddress findFavoriteAddress = findFavoriteAddress(this.mFavoriteAddressList, favoriteAddress);
        if (findFavoriteAddress != null) {
            if (!findFavoriteAddress.isCancelFavorite()) {
                this.mLogicView.showCancelFavoriteToast();
            }
            findFavoriteAddress.setCancelFavorite(!findFavoriteAddress.isCancelFavorite());
        }
        this.mLogicView.notifyItemChangedForCancelFav(i);
    }

    public FavoriteAddress findFavoriteAddress(List<FavoriteAddress> list, FavoriteAddress favoriteAddress) {
        if (list != null && favoriteAddress != null) {
            for (FavoriteAddress favoriteAddress2 : list) {
                if (favoriteAddress2 != null && favoriteAddress2.getId() == favoriteAddress.getId()) {
                    return favoriteAddress2;
                }
            }
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void historyRecordItemClick(HistoryRecordInfo historyRecordInfo) {
        if (isRecordTime()) {
            return;
        }
        if (historyRecordInfo.getHistoryType() == 1) {
            String name = historyRecordInfo.getXPPoiInfo().getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            startKeywordSearch(name, "");
            this.mSearchKeywordText = name;
            return;
        }
        startPoiSearchResult(historyRecordInfo.getXPPoiInfo(), SearchBridge.POI_FROM_HISTORY);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void gotoPoiByFavoriteItem(FavoriteAddress favoriteAddress) {
        updateFavoriteCreateTime(favoriteAddress);
        goToPoi(favoriteAddress.getXPPoiInfo(), null);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void clickByFavoriteItem(FavoriteAddress favoriteAddress) {
        updateFavoriteCreateTime(favoriteAddress);
        startPoiSearchResult(favoriteAddress.getXPPoiInfo(), "favorite");
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void addWayPointByFavorite(FavoriteAddress favoriteAddress) {
        updateFavoriteCreateTime(favoriteAddress);
        addWayPoint(favoriteAddress.getXPPoiInfo());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void addNewNaviByFavorite(FavoriteAddress favoriteAddress) {
        updateFavoriteCreateTime(favoriteAddress);
        addNewNavi(favoriteAddress.getXPPoiInfo());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void gotoBySearchResult(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo.hasDisplayLatLonInfo()) {
            goToPoi(xPPoiInfo, null);
        } else {
            this.mLogicView.retrySearch(xPPoiInfo);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void onCreateView() {
        this.mLogicView.initListener();
        if (this.mHasSaveState) {
            return;
        }
        int i = this.mStartAnimType;
        if (i == 1) {
            this.mLogicView.setSearchContainerByAnimOne();
        } else if (i == 2) {
            this.mLogicView.setSearchContainerByAnimTwo();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void onViewCreate() {
        if (!this.mHasSaveState) {
            doCreateAnim(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter.4
                @Override // java.lang.Runnable
                public void run() {
                    SearchPresenter.this.init();
                }
            });
        } else {
            init();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.d(TAG, "onResume()");
        }
        this.mLogicView.registerEventBus();
        fillBackTitle();
        SearchStatUtil.sendStatDataWhenSearchPageShow(this.mLogicView.getMainContext(), 0);
        SearchStatUtil.sendStatDataWhenSwitchToForeground(this.mLogicView.getMainContext());
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        if (L.ENABLE) {
            L.d(TAG, "onPause()");
        }
        SearchStatUtil.sendStatDataWhenSwitchToBackground(getPageType(), this.mLogicView.getMainContext());
        this.mLogicView.unRegisterEventBus();
        if (this.mLogicView.isChildScene()) {
            NaviSpeechUtils.setPageType(this.mOldPageType);
        }
    }

    public void onDestroyView() {
        this.mIsClickFavoriteBtn = false;
        this.mLogicView.unRegister();
        SearchStatUtil.sendStatDataWhenPageExit(getPageType(), this.mLogicView.getMainContext());
        UiHandlerUtil.getInstance().removeCallbacks(this.mLoadFavoriteListRunnable);
        resetHisRecordRequest();
        this.mAssistantLocationService = null;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void initData(PresenterData presenterData) {
        initBundleData(presenterData);
        NaviSpeechUtils.setPageType(getPageType());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void doAlertSettingHomeOrCompany() {
        if (this.mSearchMode == 100) {
            delayAlertSettingHomeOrCompany();
        }
    }

    private void initBundleData(PresenterData presenterData) {
        if (presenterData == null) {
            return;
        }
        this.mPresenterData = presenterData;
        this.mSearchMode = presenterData.getSearchMode();
        this.mSearchModeView = presenterData.getSearchModeView();
        this.mFromSceneIndex = presenterData.getFromSceneIndex();
        this.mFromSceneChildIndex = presenterData.getFromSceneChildIndex();
        this.mAroundPoi = presenterData.getAroundPoi();
        this.mSearchDest = presenterData.getSearchDest();
        this.mHasSaveState = presenterData.hasSaveState();
        this.mStartAnimType = presenterData.getAnimType();
        this.mSaveEtSearch = presenterData.getSaveEtSearch();
        this.mSearchKeywordText = presenterData.getSearchKeywordText();
        this.mSaveSearchData = presenterData.getSaveSearchData();
        this.mSubContainerType = presenterData.getSubContainerType();
        if (this.mLogicView.isChildScene()) {
            this.mOldPageType = getPageType();
        }
        setPageVuiState();
    }

    private void setPageVuiState() {
        if (this.mLogicView.isSceneVuiEnabled()) {
            int i = this.mSearchMode;
            if (i == 101) {
                this.mOriginVuiState = 4;
            } else if (i == 102) {
                this.mOriginVuiState = 3;
            } else {
                int i2 = this.mSearchDest;
                if (i2 == 1001) {
                    this.mOriginVuiState = 1;
                } else if (i2 == 1002) {
                    this.mOriginVuiState = 2;
                }
            }
            SearchVuiHelper.getInstance().setPageVuiState(this.mOriginVuiState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        initView();
        initSearchData();
        initSubContainerState();
        this.mHasFavoriteCacheDataInit = true;
        initFavoriteSyncConflictDialog();
        initSecBindAMapDialog();
        if (this.mIsClickFavoriteBtn) {
            openFavorite();
        } else {
            requestNormalFavoriteCount();
        }
    }

    private void initSecBindAMapDialog() {
        if (SettingWrapper.checkShowSecBindDialog()) {
            this.mLogicView.showSecBindAMapDialog();
        }
    }

    private void initView() {
        this.mLogicView.initView();
    }

    private void showFavUpdateTimeView() {
        long max = Math.max(SettingWrapper.getBlFavSyncTime(), Math.max(SettingWrapper.getAccountDataUploadTime(), SettingWrapper.getAccountDataPullTime()));
        if (max > 0) {
            this.mLogicView.updateFavSyncTimeView(max);
        }
    }

    public void initSubContainerVisible(int i, boolean z) {
        if (i == 1) {
            this.mLogicView.setSubContainerVisibleByFavorityType(z);
        } else if (i == 0) {
            this.mLogicView.setSubContainerVisibleBySearchType(z);
        } else if (i == 2) {
            this.mLogicView.setSubContainerVisibleByHistoryType(z);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        int i = speechNaviEvent.what;
        if (i == 100) {
            L.i(TAG, "SPEECH_OPEN_FAVORITE");
            this.mLogicView.getSpeechEventBizHelper().openFavoriteInSearch(this);
            return true;
        }
        if (i == 103) {
            L.i(TAG, "SPEECH_OPEN_SETTINGS");
            this.mLogicView.getSpeechEventBizHelper().openSettingsInSearch(this);
        } else if (i == 312) {
            L.Tag tag = TAG;
            L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneLegal:" + this.mLogicView.isSceneLegal());
            if (this.mLogicView.isSceneLegal()) {
                this.mLogicView.getSpeechEventBizHelper().routeNewDestWithVias(this.mLogicView.getMainContext().getCurrentScene(), speechNaviEvent);
                return true;
            }
        } else if (i != 108) {
            if (i == 109 && this.mLogicView.isSceneLegal()) {
                L.i(TAG, "SPEECH_OPEN_SEARCH_NORMAL");
                this.mLogicView.getSpeechEventBizHelper().openNormalInSearch(this);
                return true;
            }
        } else {
            L.i(TAG, "SPEECH_UPDATE_FAVORITE_BUTTON");
            this.mLogicView.getSpeechEventBizHelper().updateFavoriteButton(this);
        }
        return false;
    }

    public void executeSpeechCmdUpdateFavoriteButton() {
        ISearchContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            logicView.updateFavoriteButton();
        }
    }

    public void executeSpeechCmdOpenSettings() {
        ISearchContract.LogicView logicView = this.mLogicView;
        if (logicView == null || !logicView.isSceneResumed()) {
            return;
        }
        this.mLogicView.onClickBack();
    }

    public void executeSpeechCmdOpenFavorite() {
        if (this.mSubContainerType != 1) {
            this.mLogicView.resetFavoritePageState();
            doClickFavorite();
            SpeechStatProxy.getInstance().sendStatDataForSpeech(9, 2);
            return;
        }
        SpeechStatProxy.getInstance().sendStatDataForSpeech(9, 0);
    }

    public void executeSpeechCmdOpenNormal() {
        this.mLogicView.openSearchNormal();
    }

    public void doClickFavorite() {
        if (this.mHasFavoriteCacheDataInit) {
            this.mIsClickFavoriteBtn = true;
            openFavorite();
        }
    }

    public boolean openFavorite() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mClickFavoriteTime >= this.mIntervalTime && XPAccountServiceWrapper.getInstance().checkLoginState()) {
            this.mClickFavoriteTime = currentTimeMillis;
            resetFavRecordTime();
            requestFavouriteList(20);
            return true;
        }
        return false;
    }

    public void closeFavorite() {
        this.mSubContainerType = 2;
        initSubContainerVisible(this.mSubContainerType, false);
        this.mLogicView.hideFavoriteView();
        deleteCancelFavoriteData();
        this.mFavoriteAddressList.clear();
    }

    public boolean isFavoriteShow() {
        return this.mSubContainerType == 1;
    }

    public void deleteCancelFavoriteData() {
        if (this.mFavoriteAddressList != null) {
            ArrayList arrayList = new ArrayList();
            for (FavoriteAddress favoriteAddress : this.mFavoriteAddressList) {
                if (favoriteAddress != null && favoriteAddress.isCancelFavorite()) {
                    arrayList.add(favoriteAddress);
                }
            }
            if (arrayList.size() > 0) {
                deleteFavorite(arrayList);
            }
        }
    }

    private boolean haveLeftView() {
        return this.mSearchDest == 1000;
    }

    public void doTextChanged(String str) {
        if (str.equals(this.mEditTextBak) && TextUtils.isEmpty(str)) {
            if (this.mSubContainerType != 1) {
                this.mLogicView.showLeftView(haveLeftView());
                return;
            }
            return;
        }
        this.mEditTextBak = str;
        if (TextUtils.isEmpty(str)) {
            this.mLogicView.setIvClearVisible(false);
            this.mLogicView.cleanSearchAdapterData();
            this.mSubContainerType = 2;
            updateSubContainerState();
            if (this.mSubContainerType != 1) {
                this.mLogicView.showLeftView(haveLeftView());
                return;
            }
            return;
        }
        this.mLogicView.setIvClearVisible(true);
        if (this.mSubContainerType != 0) {
            this.mSubContainerType = 0;
            initSubContainerVisible(this.mSubContainerType, false);
        }
        this.mLogicView.showLeftView(false);
        startSuggestSearch(str);
    }

    private void updateSubContainerState() {
        initSubContainerVisible(this.mSubContainerType, false);
        int i = this.mSubContainerType;
        if (i == 1) {
            updateFavoriteAdapter();
        } else if (i == 2) {
            this.mLogicView.showHistoryListOrHistoryEmptyView();
        }
    }

    public void initFavoriteSyncConflictDialog() {
        if (!this.mLogicView.isSceneLegal()) {
            L.w(TAG, "showFavoriteSyncConflictDialog isSceneLegal false");
        } else if (needShowHomeCompanyConflictDialog() && isHomeCompanyDialogConflict()) {
            this.mLogicView.showFavoriteSyncConflictDialog();
        }
    }

    private boolean isHomeCompanyDialogConflict() {
        boolean isAmapHomeConflict = this.mLogicView.isAmapHomeConflict();
        boolean isAmapCompanyConflict = this.mLogicView.isAmapCompanyConflict();
        if (SettingWrapper.getBindAMapStatus()) {
            return isAmapHomeConflict || isAmapCompanyConflict;
        }
        if (isAmapHomeConflict) {
            FavoriteSyncUtil.resetHomeConflictStatus();
        }
        if (isAmapCompanyConflict) {
            FavoriteSyncUtil.resetCompanyConflictStatus();
        }
        return false;
    }

    private void initSubContainerState() {
        initSubContainerVisible(this.mSubContainerType, false);
        if (this.mHasSaveState) {
            this.mLogicView.setHistoryLoadParentVisible(false);
        } else if (this.mSubContainerType == 2) {
            this.mLogicView.setHistoryLoadParentVisible(true);
        }
        initHistoryList(this.mPresenterData);
    }

    private void initSearchData() {
        boolean checkUiRestore = checkUiRestore();
        XPPoiInfo aroundPoi = getAroundPoi();
        if (aroundPoi != null && !TextUtils.isEmpty(aroundPoi.getName())) {
            this.mLogicView.setTvAround(aroundPoi);
        }
        if (getSearchMode() == 102) {
            this.mLogicView.setWayPointHint();
        }
        if (isSetDest()) {
            this.mLogicView.setSearchHomeAndCompany(getSearchDest());
        } else {
            this.mLogicView.setTvScanSearch();
        }
        String str = this.mSearchKeywordText;
        if (str != null && !checkUiRestore) {
            this.mLogicView.setEtSearchText(str);
        }
        if (checkUiRestore) {
            this.mLogicView.setSearchAdapterData(this.mSaveSearchData);
        }
    }

    private boolean checkUiRestore() {
        String str;
        if (!this.mHasSaveState || (str = this.mSaveEtSearch) == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mSubContainerType == 1) {
            this.mLogicView.showFavoriteView();
            return true;
        }
        this.mLogicView.setEtSearchText(this.mSaveEtSearch);
        return true;
    }

    private void doCreateAnim(Runnable runnable) {
        int i = this.mStartAnimType;
        if (i == 1) {
            this.mLogicView.startAnimOne(runnable);
        } else if (i == 2) {
            this.mLogicView.startAnimTwo(runnable);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public void startSearch(XPPoiInfo xPPoiInfo) {
        if (XPPoiCategory.isCityName(xPPoiInfo.getCategory())) {
            switchCityName(xPPoiInfo);
        } else if (xPPoiInfo.isKeywordPoiInfo()) {
            this.mLogicView.retrySearch(xPPoiInfo);
        } else {
            startPoiSearchResult(xPPoiInfo);
        }
    }

    private void switchCityName(XPPoiInfo xPPoiInfo) {
        if (getSearchMode() == 102) {
            startPoiSearchResult(xPPoiInfo);
        } else {
            startKeywordSearch(xPPoiInfo.getName(), "");
        }
    }

    private void startPoiSearchResult(XPPoiInfo xPPoiInfo) {
        startPoiSearchResult(xPPoiInfo, null);
    }

    private void startPoiSearchResult(XPPoiInfo xPPoiInfo, String str) {
        this.mLogicView.hideIme();
        XPPoiInfo deepClone = xPPoiInfo.deepClone();
        deepClone.setKey(deepClone.getName());
        PresenterData.Builder searchModeView = new PresenterData.Builder().searchMode(this.mSearchMode).searchModeView(this.mSearchModeView);
        searchModeView.fromSceneIndex(this.mFromSceneIndex).fromSceneChildIndex(this.mFromSceneChildIndex).searchDest(this.mSearchDest).searchFromKey(str).searchKeywordText(deepClone.getName());
        if (!TextUtils.isEmpty(str) && "favorite".equals(str)) {
            searchModeView.searchResultFavoritePoi(deepClone);
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
        arrayList.add(deepClone);
        searchModeView.searchResult(arrayList);
        this.mLogicView.startSearchResultScene(searchModeView.build(), 100);
    }

    public void startKeywordSearch(String str, String str2) {
        startKeywordSearch(str, str2, false);
    }

    private void startKeywordSearch(String str, String str2, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startKeywordSearch key:" + str + ", category:" + str2 + ", bAutoNavi:" + z);
        }
        if (TextUtils.isEmpty(str)) {
            L.Tag tag2 = TAG;
            L.w(tag2, "startKeywordSearch key:" + str);
        } else if (z) {
            amapSearch(str, str2);
        } else {
            String keyword2Category = XPOfflineDataManager.getInstance().keyword2Category(str);
            if (!TextUtils.isEmpty(keyword2Category)) {
                if (keyword2Category.equalsIgnoreCase(XPKeywordConfigInfo.KEYWORD_CONFIG_CATEGORY_CHARGE)) {
                    xpChargeSearch(str);
                    return;
                } else if (keyword2Category.equalsIgnoreCase(XPKeywordConfigInfo.KEYWORD_CONFIG_CATEGORY_CAR_WASH)) {
                    xpNaviSearch(str, "010500");
                    return;
                } else if (keyword2Category.equalsIgnoreCase(XPKeywordConfigInfo.KEYWORD_CONFIG_CATEGORY_EXP_CENTER)) {
                    xpNaviSearch(str, XPNaviSearchParam.CATEGORY_EXPERIENCE_CENTER);
                    return;
                } else if (keyword2Category.equalsIgnoreCase(XPKeywordConfigInfo.KEYWORD_CONFIG_CATEGORY_SERVER_CENTER)) {
                    xpNaviSearch(str, XPNaviSearchParam.CATEGORY_SERVER_CENTER);
                    return;
                } else if (keyword2Category.equalsIgnoreCase(XPKeywordConfigInfo.KEYWORD_CONFIG_CATEGORY_DELIVERY_CENTER)) {
                    xpNaviSearch(str, XPNaviSearchParam.CATEGORY_DELIVERY_CENTER);
                    return;
                } else if (keyword2Category.equalsIgnoreCase(XPKeywordConfigInfo.KEYWORD_CONFIG_CATEGORY_INTEGRATED_SERVER_CENTER)) {
                    xpNaviSearch(str, XPNaviSearchParam.CATEGORY_INTEGRATED_SERVER_CENTER);
                    return;
                } else {
                    amapSearch(str, str2);
                    return;
                }
            }
            amapSearch(str, str2);
        }
    }

    private void xpChargeSearch(String str) {
        switch (this.mSearchMode) {
            case 100:
            case 101:
                searchCharge(str);
                return;
            case 102:
                searchChargeAlongWay(str);
                return;
            default:
                return;
        }
    }

    private void xpNaviSearch(String str, String str2) {
        switch (this.mSearchMode) {
            case 100:
            case 101:
                xpNaviSearch(str, str2, "100");
                return;
            case 102:
                xpNaviSearch(str, str2, XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY);
                return;
            default:
                return;
        }
    }

    private void amapSearch(String str, String str2) {
        switch (this.mSearchMode) {
            case 100:
                keywordSearch(str, str2);
                return;
            case 101:
                aroundSearch(str, str2, this.mAroundPoi);
                return;
            case 102:
                String categoryByKeyword = this.mSearchDataProvider.getCategoryByKeyword(str);
                if (!TextUtils.isEmpty(categoryByKeyword)) {
                    alongWaySearch(str, categoryByKeyword);
                    return;
                }
                XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
                aroundSearch(str, str2, currentLocation != null ? TBTManager.getInstance().generateStartPoint(currentLocation) : null);
                return;
            default:
                return;
        }
    }

    private void alongWaySearch(String str, String str2) {
        AlongWaySearchRequestParam alongWaySearchRequestParam = new AlongWaySearchRequestParam();
        alongWaySearchRequestParam.setText(str);
        alongWaySearchRequestParam.setCategory(str2);
        alongWaySearchRequestParam.setCarLocation(TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
        alongWaySearchRequestParam.setOrder("DISTANCE");
        alongWaySearchRequestParam.setSearchType(2);
        this.mSearchDataProvider.alongWaySearch(alongWaySearchRequestParam, this);
    }

    private void delayAlertSettingHomeOrCompany() {
        this.mLogicView.runOnUiThreadDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                SearchPresenter.this.alertSettingHomeOrCompany();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertSettingHomeOrCompany() {
        boolean isSettingHome = SearchSceneDataHelper.isSettingHome();
        boolean isSettingCompany = SearchSceneDataHelper.isSettingCompany();
        this.mSettingAlertMap.put("isSettingHome", Boolean.valueOf(isSettingHome));
        this.mSettingAlertMap.put("isSettingCompany", Boolean.valueOf(isSettingCompany));
        if (SearchSceneDataHelper.isShouldShowSystemAlert(1)) {
            alertSetting(1, true);
        } else if (SearchSceneDataHelper.isShouldShowSystemAlert(2)) {
            alertSetting(2, true);
        }
    }

    private void alertSetting(int i, boolean z) {
        if (SearchSceneDataHelper.isOffDay()) {
            L.Tag tag = TAG;
            L.i(tag, "alert setting in off day type:" + i);
            showSettingAlert(i, z);
        } else if (SearchSceneDataHelper.isWorkingDay()) {
            L.Tag tag2 = TAG;
            L.i(tag2, "alert setting in working day type:" + i);
            int i2 = Calendar.getInstance().get(11);
            if (i2 < 10 || i2 > 22) {
                return;
            }
            showSettingAlert(i, z);
        }
    }

    private void showSettingAlert(int i, boolean z) {
        if (z) {
            this.mLogicView.showSettingAlertWhenSystemSuggest(i);
        } else {
            this.mLogicView.showSettingAlertWhenClick(i);
        }
    }

    public void handleCancelAddSuggestForMe(int i, boolean z) {
        LocationRecognitionInfo locationRecognitionInfo;
        if (i == 1) {
            locationRecognitionInfo = SearchSceneDataHelper.home;
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenHomeSugCancelAdded();
            if (this.mSettingAlertMap.get("isSettingCompany") != null && !this.mSettingAlertMap.get("isSettingCompany").booleanValue()) {
                showSettingAlert(2, z);
            }
        } else {
            locationRecognitionInfo = SearchSceneDataHelper.company;
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenOfficeSugCancelAdded();
        }
        feedbackToCloud(locationRecognitionInfo, i);
    }

    private void feedbackToCloud(final LocationRecognitionInfo locationRecognitionInfo, final int i) {
        if (locationRecognitionInfo == null || locationRecognitionInfo.getPoiId() == null) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.-$$Lambda$SearchPresenter$un71US62J9jnROeceEuBZOZfn4Q
            @Override // java.lang.Runnable
            public final void run() {
                SearchPresenter.this.lambda$feedbackToCloud$0$SearchPresenter(locationRecognitionInfo, i);
            }
        });
        if (i == 1) {
            SearchSceneDataHelper.home = null;
        } else {
            SearchSceneDataHelper.company = null;
        }
    }

    public /* synthetic */ void lambda$feedbackToCloud$0$SearchPresenter(LocationRecognitionInfo locationRecognitionInfo, int i) {
        AssistantLocationFeedbackRequest ts = new AssistantLocationFeedbackRequest().setPoiId(locationRecognitionInfo.getPoiId()).setUserId(0L).setKind(i == 1 ? "home" : FavoriteType.COMPANY_STRING).setVin(RootUtil.getVin()).setTs(Long.valueOf(System.currentTimeMillis()));
        if (this.mAssistantLocationService != null) {
            ResponseWrapper feedback = this.mAssistantLocationService.feedback(ts);
            if (feedback.getCode() != 200) {
                L.Tag tag = TAG;
                L.i(tag, "feedback onFailure, code=" + feedback.getCode());
                return;
            }
            L.i(TAG, "feedback onSuccess");
        }
    }

    public void handleAddSuggestForMe(int i, boolean z) {
        FavoriteAddress favoriteAddress = new FavoriteAddress();
        LocationRecognitionInfo locationRecognitionInfo = 1 == i ? SearchSceneDataHelper.home : SearchSceneDataHelper.company;
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setPoiId(locationRecognitionInfo.getPoiId());
        xPPoiInfo.setName(locationRecognitionInfo.getName());
        xPPoiInfo.setAddress(locationRecognitionInfo.getAddress());
        try {
            xPPoiInfo.setNaviLat(Double.valueOf(locationRecognitionInfo.getLat()).doubleValue());
            xPPoiInfo.setNaviLon(Double.valueOf(locationRecognitionInfo.getLon()).doubleValue());
            xPPoiInfo.setDisplayLat(Double.valueOf(locationRecognitionInfo.getLat()).doubleValue());
            xPPoiInfo.setDisplayLon(Double.valueOf(locationRecognitionInfo.getLon()).doubleValue());
        } catch (Exception unused) {
            MainContext mainContext = this.mLogicView.getMainContext();
            mainContext.showPrompt("info: lon = " + locationRecognitionInfo.getLon() + " lat = " + locationRecognitionInfo.getLat());
        }
        favoriteAddress.setXPPoiInfo(xPPoiInfo);
        if (1 == i) {
            handleHomeSuggest(z, favoriteAddress);
        } else {
            handleOfficeSuggest(favoriteAddress);
        }
    }

    private void handleOfficeSuggest(FavoriteAddress favoriteAddress) {
        HomeOrOfficeSuggestStatUtil.sendStatDataWhenOfficeSugConfirmAdded();
        boolean company = FavoriteDataManager.getInstance().setCompany(favoriteAddress);
        this.mLogicView.showSettingCompanySuccess(company);
        if (company) {
            this.mLogicView.updateCompany(favoriteAddress);
        }
    }

    private void handleHomeSuggest(boolean z, FavoriteAddress favoriteAddress) {
        HomeOrOfficeSuggestStatUtil.sendStatDataWhenHomeSugConfirmAdded();
        boolean home = FavoriteDataManager.getInstance().setHome(favoriteAddress);
        this.mLogicView.showSettingHomeSuccess(home);
        if (home) {
            this.mLogicView.updateHome(favoriteAddress);
            if (this.mSettingAlertMap.get("isSettingCompany") == null || this.mSettingAlertMap.get("isSettingCompany").booleanValue()) {
                return;
            }
            showSettingAlert(2, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public int getSearchMode() {
        return this.mSearchMode;
    }

    public int getSearchDest() {
        return this.mSearchDest;
    }

    public boolean isSetDest() {
        int i = this.mSearchDest;
        return i == 1001 || i == 1002;
    }

    public boolean isSwipeMenuEnable() {
        return Utils.isSwipeMenuEnable(this.mSearchMode, this.mSearchDest);
    }

    private boolean needShowHomeCompanyConflictDialog() {
        return this.mSearchMode == 100 && this.mSearchDest == 1000;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public XPPoiInfo getAroundPoi() {
        return this.mAroundPoi;
    }

    @UiThread
    private void showFavorites() {
        if (!this.mIsClickFavoriteBtn && !isFavoriteShow()) {
            requestNormalFavoriteCount();
        } else if (!this.mHasSaveState) {
            requestFavouriteList(20);
        } else {
            this.mFavoriteAddressList.clear();
            updateFavoriteAdapter();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void deleteFavorite(List<FavoriteAddress> list) {
        SearchDeleteFavouriteParam searchDeleteFavouriteParam = new SearchDeleteFavouriteParam();
        searchDeleteFavouriteParam.setFavoriteAddress(list);
        searchDeleteFavouriteParam.setSearchType(7);
        this.mSearchDataProvider.deleteFavouriteRecord(searchDeleteFavouriteParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void deleteAllFavorites() {
        SearchStatUtil.sendStatDataWhenDeleteAllFavoritesDialogConfirmed(this.mLogicView.getMainContext());
        SearchRequestParam searchRequestParam = new SearchRequestParam();
        searchRequestParam.setSearchType(9);
        this.mSearchDataProvider.deleteAllLocalItems(searchRequestParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void deleteHistoryRecord(HistoryRecordInfo historyRecordInfo, int i) {
        SearchDeleteHistoryParam searchDeleteHistoryParam = new SearchDeleteHistoryParam();
        searchDeleteHistoryParam.setHistoryRecordInfo(historyRecordInfo);
        searchDeleteHistoryParam.setPosition(i);
        searchDeleteHistoryParam.setSearchType(8);
        this.mSearchDataProvider.deleteHistoryRecord(searchDeleteHistoryParam, this);
    }

    public void doSearchTips(CharSequence charSequence, boolean z, ArrayList<XPPoiInfo> arrayList, int i) {
        if (TextUtils.isEmpty(charSequence)) {
            arrayList = null;
        } else {
            doSearchMatchedTips(z, arrayList, i);
        }
        this.mLogicView.updateMatchedTips(arrayList);
    }

    private void doSearchMatchedTips(boolean z, ArrayList<XPPoiInfo> arrayList, int i) {
        if (!CollectionUtils.isEmpty(arrayList) || z) {
            this.mLogicView.updateSearchTips(1);
        } else if (i == 0 || 515 == i) {
            this.mLogicView.updateSearchTips(5);
        } else {
            this.mLogicView.updateSearchTips(5);
        }
    }

    @UiThread
    private void updateFavoriteAdapter() {
        this.mLogicView.updateFavoriteAdapter(this.mFavoriteAddressList, false, true);
    }

    @UiThread
    private void updateFavoriteAdapter(List<FavoriteAddress> list, boolean z) {
        FavoriteAddress findFavoriteAddress;
        boolean isEmpty = CollectionUtils.isEmpty(list);
        if (this.mLogicView.isFavoritePaging()) {
            if (!isEmpty) {
                this.mFavoriteAddressList.addAll(list);
            }
            this.mLogicView.updateFavoriteAdapter(list, true, z);
        } else {
            List<FavoriteAddress> list2 = this.mFavoriteAddressList;
            if (list2 != null) {
                for (FavoriteAddress favoriteAddress : list2) {
                    if (favoriteAddress != null && favoriteAddress.isCancelFavorite() && (findFavoriteAddress = findFavoriteAddress(list, favoriteAddress)) != null) {
                        findFavoriteAddress.setCancelFavorite(favoriteAddress.isCancelFavorite());
                    }
                }
                this.mFavoriteAddressList.clear();
            }
            if (!isEmpty) {
                this.mFavoriteAddressList.addAll(list);
            }
            this.mLogicView.updateFavoriteAdapter(this.mFavoriteAddressList, false, z);
        }
        if (isEmpty) {
            return;
        }
        FavoriteAddress favoriteAddress2 = list.get(list.size() - 1);
        this.mFavRecordUpdateTime = favoriteAddress2.getBLCreateTime();
        this.mFavPoiIdList = getFavPoiIdList(this.mFavoriteAddressList, favoriteAddress2);
    }

    @UiThread
    private void updateNextIcon(int i) {
        this.mLogicView.updateNextIcon(i);
    }

    private List<String> getFavPoiIdList(List<FavoriteAddress> list, FavoriteAddress favoriteAddress) {
        if (!CollectionUtils.isNotEmpty(list) || favoriteAddress == null) {
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            FavoriteAddress favoriteAddress2 = list.get(i);
            if (favoriteAddress2 != null && favoriteAddress2.getBLCreateTime() == favoriteAddress.getBLCreateTime()) {
                arrayList.add(favoriteAddress2.getXPPoiInfo().getPoiId());
            }
        }
        return arrayList;
    }

    public void showFavoriteView() {
        if (this.mSubContainerType != 1) {
            this.mSubContainerType = 1;
            initSubContainerVisible(this.mSubContainerType, true);
            showFavUpdateTimeView();
            this.mLogicView.showFavoriteView();
        }
    }

    @UiThread
    private void updateHistoryAdapter(List<HistoryRecordInfo> list, boolean z) {
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("updateHistoryAdapter historyRecordList:");
        sb.append(list == null ? 0 : list.size());
        L.i(tag, sb.toString());
        boolean isEmpty = CollectionUtils.isEmpty(list);
        if (this.mLogicView.isHistoryPaging()) {
            if (!isEmpty) {
                this.mHistoryRecordList.addAll(list);
            }
            this.mLogicView.updateHistoryAdapter(list, true, z);
            return;
        }
        List<HistoryRecordInfo> list2 = this.mHistoryRecordList;
        if (list2 != null) {
            list2.clear();
        }
        if (!isEmpty) {
            this.mHistoryRecordList.addAll(list);
        }
        this.mLogicView.updateHistoryAdapter(this.mHistoryRecordList, false, z);
    }

    @UiThread
    private void initHistoryList(PresenterData presenterData) {
        if (this.mHasSaveState && presenterData != null) {
            List<HistoryRecordInfo> saveHistoryRecordList = presenterData.getSaveHistoryRecordList();
            resetHisRecordRequest();
            this.mSearchHistoryDataProvider.updateParamByList(saveHistoryRecordList);
            updateHistoryAdapter(saveHistoryRecordList, true);
            return;
        }
        resetHistoryList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetFavoriteList() {
        this.mLogicView.resetFavoritePageState();
        resetFavRecordTime();
        this.mLogicView.initFavoriteButton();
        requestNormalFavoriteCount();
        showFavorites();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void resetHistoryList() {
        resetHisRecordRequest();
        requestHistoryList(20);
    }

    @UiThread
    @VisibleForTesting
    protected void startSuggestSearch(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mLogicView.updateAdapter(null);
            L.Tag tag = TAG;
            L.w(tag, "startSuggestSearch key:" + str);
            return;
        }
        SuggestSearchRequestParam suggestSearchRequestParam = new SuggestSearchRequestParam(str, this.mSearchMode, this.mAroundPoi, TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
        suggestSearchRequestParam.setSearchMode(this.mSearchMode);
        suggestSearchRequestParam.setSearchDest(this.mSearchDest);
        this.mSearchDataProvider.suggestSearch(suggestSearchRequestParam, this);
    }

    private void updateFavoriteCreateTime(@NonNull FavoriteAddress favoriteAddress) {
        FavoriteAddress deepClone = favoriteAddress.deepClone();
        long currentTimeMillis = System.currentTimeMillis();
        deepClone.setBLCreateTime(currentTimeMillis);
        if (FavoriteDataManager.getInstance().update(deepClone) > 0) {
            saveFavoriteClickStateAndTop(deepClone, currentTimeMillis);
        }
    }

    private void saveFavoriteClickStateAndTop(@NonNull FavoriteAddress favoriteAddress, long j) {
        int i;
        FavoriteAddress findFavoriteAddress = findFavoriteAddress(this.mFavoriteAddressList, favoriteAddress);
        if (findFavoriteAddress != null) {
            findFavoriteAddress.setBLCreateTime(j);
            findFavoriteAddress.setHasClicked(true);
            i = this.mFavoriteAddressList.indexOf(findFavoriteAddress);
        } else {
            i = -1;
        }
        if (i > 0) {
            this.mFavoriteAddressList.add(0, this.mFavoriteAddressList.remove(i));
            this.mLogicView.updateForFavoriteItemClick(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void goToPoi(XPPoiInfo xPPoiInfo, List<XPPoiInfo> list) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "goToPoi item:" + xPPoiInfo);
            return;
        }
        L.Tag tag2 = TAG;
        L.w(tag2, "goToPoi item:" + xPPoiInfo.toString());
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        ArrayList arrayList = null;
        if (CollectionUtils.isNotEmpty(list)) {
            arrayList = new ArrayList();
            for (XPPoiInfo xPPoiInfo2 : list) {
                arrayList.add(new XPViaPoint(xPPoiInfo2));
            }
        }
        RouteRequest createNormalRequest = RouteRequest.createNormalRequest(startPOIFromCurrent, xPPoiInfo, arrayList);
        if (TBTManager.getInstance().getCurrentStatus() == 0) {
            this.mLogicView.startRouteScene(createNormalRequest);
        } else if (TBTManager.getInstance().getCurrentStatus() == 2) {
            this.mLogicView.startExploreScene(createNormalRequest);
        } else {
            this.mLogicView.startNaviScene(createNormalRequest);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void addWayPoint(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "addWayPoint item:" + xPPoiInfo);
            return;
        }
        RouteRequest createAddViaRequest = RouteRequest.createAddViaRequest(xPPoiInfo, TBTManager.getInstance().getCurrentRouteRequestId());
        if (createAddViaRequest != null) {
            this.mLogicView.setResult(createAddViaRequest);
        }
        this.mLogicView.removeSceneAfterIndex(this.mFromSceneIndex, this.mFromSceneChildIndex);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void removeWayPoint(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "removeWayPoint item:" + xPPoiInfo);
            return;
        }
        this.mLogicView.setResult(RouteRequest.createRemoveViaRequest(xPPoiInfo, TBTManager.getInstance().getCurrentRouteRequestId()));
        this.mLogicView.removeSceneAfterIndex(this.mFromSceneIndex, this.mFromSceneChildIndex);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void addNewNavi(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "addNewNavi item:" + xPPoiInfo);
            return;
        }
        this.mLogicView.setResult(RouteRequest.createNewDesRequest(xPPoiInfo));
        this.mLogicView.removeSceneAfterIndex(this.mFromSceneIndex, this.mFromSceneChildIndex);
    }

    private void switchCity(XPPoiInfo xPPoiInfo, RectFloat rectFloat) {
        if (1 == StateManager.getInstance().getState()) {
            StateManager.getInstance().switchActiveState();
        }
        this.mLogicView.getMapView().getBizControlManager().setFollowMode(false);
        this.mLogicView.getMapView().setPoiToCenter(new XPCoordinate2DDouble(xPPoiInfo));
        this.mIsSwitchedCity = true;
        MapStatus mapStatus = this.mSwitchCityMapStatus;
        mapStatus.mFollowMode = 0;
        mapStatus.mMapCenterLon = xPPoiInfo.getDisplayLon();
        this.mSwitchCityMapStatus.mMapCenterLat = xPPoiInfo.getDisplayLat();
        if (rectFloat == null || rectFloat.bottom <= 0.0f) {
            this.mLogicView.getMapView().setMapLevel(11.0f);
            this.mSwitchCityMapStatus.mMapLevel = 11.0f;
            return;
        }
        Coord2DDouble lonLatToGeoPoint = this.mLogicView.getMapView().lonLatToGeoPoint(new XPCoordinate2DDouble(rectFloat.left, rectFloat.top));
        Coord2DDouble lonLatToGeoPoint2 = this.mLogicView.getMapView().lonLatToGeoPoint(new XPCoordinate2DDouble(rectFloat.right, rectFloat.bottom));
        if (lonLatToGeoPoint == null || lonLatToGeoPoint2 == null) {
            return;
        }
        float mapZoom = this.mLogicView.getMapView().getMapZoom((int) lonLatToGeoPoint.lon, (int) lonLatToGeoPoint.lat, (int) lonLatToGeoPoint2.lon, (int) lonLatToGeoPoint2.lat);
        this.mLogicView.getMapView().setMapLevel(mapZoom);
        this.mSwitchCityMapStatus.mMapLevel = mapZoom;
    }

    private void keywordSearch(String str, String str2) {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        Coord2DDouble lonLatFromCenter = this.mLogicView.getMapView().getLonLatFromCenter();
        SearchKeywordParam searchKeywordParam = new SearchKeywordParam();
        searchKeywordParam.setSearchType(4);
        searchKeywordParam.setText(str);
        searchKeywordParam.setCategory(str2);
        if (lonLatFromCenter != null) {
            searchKeywordParam.setUserLoc(new XPCoordinate2DDouble(lonLatFromCenter.lon, lonLatFromCenter.lat));
        }
        if (currentLocation != null) {
            searchKeywordParam.setPoiLoc(currentLocation);
        }
        this.mSearchDataProvider.keywordSearch(searchKeywordParam, this);
    }

    private CarLoc getCarLocation() {
        return this.mLogicView.getMapView().getBizControlManager().getCarLocation();
    }

    private void aroundSearch(String str, String str2, XPPoiInfo xPPoiInfo) {
        double displayLon;
        double displayLat;
        boolean z = true;
        if (xPPoiInfo == null) {
            Coord2DDouble lonLatFromCenter = this.mLogicView.getMapView().getLonLatFromCenter();
            displayLon = 0.0d;
            if (lonLatFromCenter != null) {
                displayLon = lonLatFromCenter.lon;
                displayLat = lonLatFromCenter.lat;
            } else {
                z = false;
                displayLat = 0.0d;
            }
        } else {
            displayLon = xPPoiInfo.getDisplayLon();
            displayLat = xPPoiInfo.getDisplayLat();
        }
        if (z) {
            int adCodeByLonLat = MapDataManager.getInstance().getAdCodeByLonLat(new XPCoordinate2DDouble(displayLon, displayLat));
            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            SearchKeywordParam searchKeywordParam = new SearchKeywordParam();
            searchKeywordParam.setSearchType(13);
            searchKeywordParam.setText(str);
            searchKeywordParam.setCategory(str2);
            searchKeywordParam.setPoiLoc(new XPCoordinate2DDouble(displayLon, displayLat));
            if (currentLocation != null) {
                searchKeywordParam.setUserLoc(currentLocation);
            }
            searchKeywordParam.setRange("10000");
            searchKeywordParam.setAdCode(adCodeByLonLat);
            this.mSearchDataProvider.keywordSearch(searchKeywordParam, this);
        }
    }

    private void searchCharge(String str) {
        XPCoordinate2DDouble center = getCenter();
        if (center == null) {
            return;
        }
        this.mGeneralChargeRequestParam = new GeneralChargeRequestParam();
        this.mGeneralChargeRequestParam.setQuery(str).setLng(center.mLon).setLat(center.mLat).setRadius(10000).setOrder("DISTANCE").setDetail(true).setSize(20).setIndex(0);
        CPSearchRequestParam cPSearchRequestParam = new CPSearchRequestParam(this.mGeneralChargeRequestParam);
        cPSearchRequestParam.setSearchType(5);
        this.mSearchDataProvider.searchChargeAround(cPSearchRequestParam, this);
    }

    private void searchChargeAlongWay(String str) {
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation == null) {
            L.w(TAG, "searchChargeAlongWay carLocation is null.");
            return;
        }
        this.mGeneralChargeRequestParam = new GeneralChargeRequestParam();
        this.mGeneralChargeRequestParam.setQuery(str).setLng(currentLocation.mLon).setLat(currentLocation.mLat).setDetail(true).setOrder("DISTANCE").setSize(20).setIndex(0).setRadius(500);
        CPSearchRequestParam cPSearchRequestParam = new CPSearchRequestParam(this.mGeneralChargeRequestParam);
        cPSearchRequestParam.setSearchType(6);
        this.mSearchDataProvider.searchChargeAlongWay(cPSearchRequestParam, this);
    }

    private void xpNaviSearch(String str, String str2, String str3) {
        XPCoordinate2DDouble center = getCenter();
        if (center == null) {
            return;
        }
        this.mNaviSearchParam = new XPNaviSearchParam();
        this.mNaviSearchParam.setCategory(str2);
        this.mNaviSearchParam.setType(str3);
        this.mNaviSearchParam.setPoiLocation(center);
        this.mNaviSearchParam.setRemainDistance(CarServiceManager.getInstance().getCarRemainDistance());
        this.mNaviSearchParam.setQuery(str);
        this.mNaviSearchParam.setRadius(50000);
        this.mNaviSearchParam.setSize(20);
        this.mNaviSearchParam.setPage(1);
        NaviSearchRequestParam naviSearchRequestParam = new NaviSearchRequestParam(this.mNaviSearchParam);
        naviSearchRequestParam.setSearchType(14);
        this.mSearchDataProvider.searchNaviServer(naviSearchRequestParam, this);
    }

    private XPCoordinate2DDouble getCenter() {
        Coord2DDouble lonLatFromCenter;
        XPPoiInfo xPPoiInfo = this.mAroundPoi;
        if (xPPoiInfo != null) {
            lonLatFromCenter = new Coord2DDouble(xPPoiInfo.getDisplayLon(), this.mAroundPoi.getDisplayLat());
        } else {
            lonLatFromCenter = this.mLogicView.getMapView().getLonLatFromCenter();
        }
        if (lonLatFromCenter == null) {
            return null;
        }
        return new XPCoordinate2DDouble(lonLatFromCenter);
    }

    private void startSearchResult(SearchResponseEvent searchResponseEvent) {
        int i;
        ArrayList<XPPoiInfo> arrayList;
        if (this.mSearchDataProvider.isCityLocation(searchResponseEvent)) {
            locateCities(searchResponseEvent.getList(), searchResponseEvent.getRectFloat());
            return;
        }
        if (searchResponseEvent != null) {
            arrayList = searchResponseEvent.getList();
            i = searchResponseEvent.getErrorCode();
        } else {
            i = -1;
            arrayList = null;
        }
        if (!CollectionUtils.isEmpty(arrayList)) {
            this.mLogicView.hideIme();
            doJumpScene(arrayList);
            this.mSubContainerType = 2;
            updateSubContainerState();
            return;
        }
        SearchStatUtil.sendStatDataWhenSearchNoneResult(this.mLogicView.getMainContext(), this.mLogicView.getSearchKeyword());
        if (i == 0) {
            this.mLogicView.updateSearchTips(3);
        } else if (515 == i) {
            this.mLogicView.updateSearchTips(4);
        } else {
            this.mLogicView.updateSearchTips(3);
        }
        this.mSearchKeywordText = null;
    }

    private void doJumpScene(ArrayList<XPPoiInfo> arrayList) {
        XPNaviSearchParam xPNaviSearchParam;
        ISearchContract.LogicView logicView = this.mLogicView;
        if (logicView == null || !logicView.isSceneLegal()) {
            L.w(TAG, "doJumpScene failure search scene is illegal");
            return;
        }
        PresenterData.Builder searchModeView = new PresenterData.Builder().searchMode(this.mSearchMode).searchModeView(this.mSearchModeView);
        searchModeView.fromSceneIndex(this.mFromSceneIndex).fromSceneChildIndex(this.mFromSceneChildIndex).searchDest(this.mSearchDest).searchType(this.mSearchType).searchResult(arrayList);
        if (this.mSearchMode == 101) {
            searchModeView.aroundPoi(this.mAroundPoi);
        }
        int i = this.mSearchType;
        if (4 == i || 13 == i || 2 == i) {
            Request request = this.mSearchDataProvider.getRequest();
            if (request != null) {
                if (request instanceof KeywordQueryRequest) {
                    KeywordQueryRequest keywordQueryRequest = (KeywordQueryRequest) request;
                    keywordQueryRequest.nextPage();
                    searchModeView.searchResultSearchParams(keywordQueryRequest.getKeywordParam());
                    if (keywordQueryRequest.getKeywordParam() != null) {
                        searchModeView.searchKeywordText(keywordQueryRequest.getKeywordParam().getKeywords());
                    }
                } else if (request instanceof AlongWayRequest) {
                    AlongWayRequest alongWayRequest = (AlongWayRequest) request;
                    if (alongWayRequest.getSearchAlongWayParam() != null) {
                        searchModeView.searchKeywordText(alongWayRequest.getSearchAlongWayParam().getKeyword());
                    }
                }
            }
        } else if (6 == i || 5 == i) {
            GeneralChargeRequestParam generalChargeRequestParam = this.mGeneralChargeRequestParam;
            if (generalChargeRequestParam != null) {
                generalChargeRequestParam.nextPage();
                searchModeView.searchResultSearchParams(this.mGeneralChargeRequestParam);
                searchModeView.searchKeywordText(this.mGeneralChargeRequestParam.getQuery());
            }
        } else if (14 == i && (xPNaviSearchParam = this.mNaviSearchParam) != null) {
            xPNaviSearchParam.nextPage();
            searchModeView.searchResultSearchParams(this.mNaviSearchParam);
            searchModeView.searchKeywordText(this.mNaviSearchParam.getQuery());
        }
        this.mLogicView.startSearchResultScene(searchModeView.build(), 100);
    }

    public void setHomeText(XPPoiInfo xPPoiInfo, String str) {
        if (isSetDest() || this.mLogicView.checkTvHome()) {
            return;
        }
        if (xPPoiInfo == null) {
            this.mLogicView.updateEmptyHomeText();
            this.mHomeXPPoiInfo = null;
            return;
        }
        if (this.mHomeXPPoiInfo == null || !xPPoiInfo.getPoiId().equals(this.mHomeXPPoiInfo.getPoiId())) {
            this.mLogicView.updateDefaultHomeText();
            checkPoiInfoForUpdateDistance(true, xPPoiInfo, this.mHomeXPPoiInfo, TBTManager.getInstance().getStartPOIFromCurrent());
        }
        this.mHomeXPPoiInfo = xPPoiInfo;
    }

    public void setCompanyText(XPPoiInfo xPPoiInfo, String str) {
        if (isSetDest() || this.mLogicView.checkTvCompany()) {
            return;
        }
        if (xPPoiInfo != null) {
            if (this.mCompanyXPPoiInfo == null || !xPPoiInfo.getPoiId().equals(this.mCompanyXPPoiInfo.getPoiId())) {
                this.mLogicView.updateDefaultCompanyText();
                checkPoiInfoForUpdateDistance(false, xPPoiInfo, this.mCompanyXPPoiInfo, TBTManager.getInstance().getStartPOIFromCurrent());
            }
            this.mCompanyXPPoiInfo = xPPoiInfo;
            return;
        }
        this.mLogicView.updateEmptyCompanyText();
        this.mCompanyXPPoiInfo = null;
    }

    public XPPoiInfo getHomeXPPoiInfo() {
        return this.mHomeXPPoiInfo;
    }

    public XPPoiInfo getCompanyXPPoiInfo() {
        return this.mCompanyXPPoiInfo;
    }

    public void updateHomeCompanyDistance() {
        L.Tag tag = TAG;
        L.i(tag, "updateHomeCompanyDistance: home: " + this.mHomeDistanceLoaded + "; company:" + this.mCompanyDistanceLoaded);
        if (!this.mHomeDistanceLoaded && this.mHomeXPPoiInfo != null) {
            loadPoiDistance(TBTManager.getInstance().getStartPOIFromCurrent(), this.mHomeXPPoiInfo, true);
        }
        if (this.mCompanyDistanceLoaded || this.mCompanyXPPoiInfo == null) {
            return;
        }
        loadPoiDistance(TBTManager.getInstance().getStartPOIFromCurrent(), this.mCompanyXPPoiInfo, false);
    }

    public void settingHomeOrCompany(int i, int i2) {
        boolean isSettingCompany;
        LocationRecognitionInfo locationRecognitionInfo;
        XPPoiInfo xPPoiInfo;
        if (i2 == 1) {
            isSettingCompany = SearchSceneDataHelper.isSettingHome();
            locationRecognitionInfo = SearchSceneDataHelper.home;
            xPPoiInfo = this.mHomeXPPoiInfo;
        } else {
            isSettingCompany = SearchSceneDataHelper.isSettingCompany();
            locationRecognitionInfo = SearchSceneDataHelper.company;
            xPPoiInfo = this.mCompanyXPPoiInfo;
        }
        if (isSettingCompany) {
            gotoSetHomeCompany(i, xPPoiInfo);
            return;
        }
        if (i2 == 1) {
            SearchStatUtil.sendStatDataWhenHomeEmpty(this.mLogicView.getMainContext());
        } else {
            SearchStatUtil.sendStatDataWhenOfficeEmpty(this.mLogicView.getMainContext());
        }
        if (locationRecognitionInfo != null) {
            this.mLogicView.showSettingAlertWhenClick(i2);
        } else {
            gotoSetHomeCompany(i, xPPoiInfo);
        }
    }

    private void gotoSetHomeCompany(int i, XPPoiInfo xPPoiInfo) {
        this.mLogicView.hideIme();
        if (xPPoiInfo == null) {
            int i2 = this.mSearchMode;
            if (i2 == 102) {
                startDestScene(100, i, 1);
            } else {
                startDestScene(i2, i, 1);
            }
        } else if (this.mSearchMode == 102) {
            sendStatWhenSettingDialogShow(i);
            this.mLogicView.showAddWayPointDialog(i, xPPoiInfo);
        } else {
            goToPoi(xPPoiInfo, null);
        }
    }

    private void checkPoiInfoForUpdateDistance(boolean z, @NonNull XPPoiInfo xPPoiInfo, @Nullable XPPoiInfo xPPoiInfo2, @NonNull XPPoiInfo xPPoiInfo3) {
        if (xPPoiInfo2 == null || !xPPoiInfo.getPoiId().equals(xPPoiInfo2.getPoiId())) {
            loadPoiDistance(xPPoiInfo3, xPPoiInfo, z);
        }
    }

    public void editHomeCompany(int i) {
        int i2 = this.mSearchMode;
        if (i2 == 102) {
            startDestScene(100, i, 1);
        } else {
            startDestScene(i2, i, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendStatWhenSettingDialogStartNavi(int i) {
        if (i == 1001) {
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenAddWayPointHomeSettingDialogStartNavi();
        } else if (i == 1002) {
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenAddWayPointOfficeSettingDialogStartNavi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendStatWhenSettingDialogAdd(int i) {
        if (i == 1001) {
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenAddWayPointHomeSettingDialogAdd();
        } else if (i == 1002) {
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenAddWayPointOfficeSettingDialogAdd();
        }
    }

    private void sendStatWhenSettingDialogShow(int i) {
        if (i == 1001) {
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenAddWayPointHomeSettingDialogShow();
        } else if (i == 1002) {
            HomeOrOfficeSuggestStatUtil.sendStatDataWhenAddWayPointOfficeSettingDialogShow();
        }
    }

    private void startDestScene(int i, int i2, int i3) {
        PresenterData.Builder searchMode = new PresenterData.Builder().searchMode(i);
        searchMode.fromSceneIndex(this.mFromSceneIndex).fromSceneChildIndex(this.mFromSceneChildIndex).searchDest(i2).animType(i3);
        if (this.mSearchMode == 101) {
            searchMode.aroundPoi(this.mAroundPoi);
        }
        this.mLogicView.startSearchScene(searchMode.build(), 101);
    }

    public void startScanSearchScene(String str) {
        this.mLogicView.startScanSearchScene(new PresenterData.Builder().searchMode(this.mSearchMode).searchDest(this.mSearchDest).fromSceneIndex(this.mFromSceneIndex).fromSceneChildIndex(this.mFromSceneChildIndex).searchKeywordText(str).build(), 102);
    }

    public boolean isLoginXPAndBind() {
        return FavoriteUtil.isLoginXp() && FavoriteSyncUtil.bindAmapSuccess();
    }

    public void deleteHistoryRecords() {
        SearchRequestParam searchRequestParam = new SearchRequestParam();
        searchRequestParam.setSearchType(10);
        this.mSearchDataProvider.deleteAllLocalItems(searchRequestParam, this);
    }

    private void locateCities(ArrayList<XPPoiInfo> arrayList, RectFloat rectFloat) {
        if (!CollectionUtils.isNotEmpty(arrayList) || arrayList.get(0) == null) {
            return;
        }
        this.mLogicView.hideIme();
        switchCity(arrayList.get(0), rectFloat);
        this.mLogicView.showSwitchCityTip(arrayList.get(0));
    }

    private void showLoadingDialog() {
        this.mLogicView.showLoadingDialog();
    }

    private void dismissLoadingDialog() {
        this.mLogicView.dismissLoadingDialog();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.Presenter
    public void goBackForResult(FavoriteAddress favoriteAddress) {
        this.mLogicView.setResultBundleData(this.mSearchDest, favoriteAddress.getXPPoiInfo());
    }

    public PresenterData onSceneSaveInstanceState() {
        return new PresenterData.Builder().saveFavoriteAddressList(this.mFavoriteAddressList).saveHistoryRecordList(this.mHistoryRecordList).subContainerType(this.mSubContainerType).build();
    }

    private boolean inSearchCommonKeywords(String str) {
        String[] searchCommonKeywords;
        for (String str2 : this.mLogicView.getSearchCommonKeywords()) {
            if (str2.indexOf(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR) > 0) {
                for (Object obj : str2.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR)) {
                    if (str != null && str.equals(obj)) {
                        return true;
                    }
                }
                continue;
            } else if (str != null && str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public PageType getPageType() {
        PageType pageType = PageType.SEARCH_MAIN_PAGE;
        switch (this.mSearchDest) {
            case 1000:
                int i = this.mSearchMode;
                if (i == 101) {
                    return PageType.SEARCH_NEARBY_PAGE;
                }
                return i == 102 ? PageType.SEARCH_WAYPOINT_PAGE : pageType;
            case 1001:
                return PageType.SEARCH_HOME_PAGE;
            case 1002:
                return PageType.SEARCH_OFFICE_PAGE;
            default:
                return pageType;
        }
    }

    private void loadPoiDistance(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2, boolean z) {
        if (z) {
            this.mHomeDistanceLoaded = false;
        } else {
            this.mCompanyDistanceLoaded = false;
        }
        SearchLoadDistanceParam searchLoadDistanceParam = new SearchLoadDistanceParam();
        searchLoadDistanceParam.setStartPoi(TBTManager.getInstance().getStartPOIFromCurrent());
        searchLoadDistanceParam.setEndPoi(xPPoiInfo2);
        searchLoadDistanceParam.setHome(z);
        this.mSearchDataProvider.loadPoiDistance(searchLoadDistanceParam, this);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull SearchResultData searchResultData) {
        int indexOf;
        this.mSearchType = searchResultData.getSearchType();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onDataFetched, mSearchType=" + this.mSearchType);
        }
        switch (this.mSearchType) {
            case 0:
                this.mFavoriteShowTime = searchResultData.getMaxRecordTime();
                List<FavoriteAddress> favouriteList = searchResultData.getFavouriteList();
                if (L.ENABLE) {
                    int size = favouriteList != null ? favouriteList.size() : -1;
                    L.Tag tag2 = TAG;
                    L.d(tag2, "onDataFetched  SEARCH_TYPE_FAVOURITE size:" + size);
                }
                updateFavoriteAdapter(favouriteList, searchResultData.mIsLoad);
                break;
            case 1:
                updateHistoryAdapter(searchResultData.getHistoryList(), searchResultData.mIsLoad);
                break;
            case 2:
            case 4:
            case 13:
                startSearchResult(searchResultData.getSearchResponseEvent());
                break;
            case 3:
                if (searchResultData.isFromCached()) {
                    if (searchResultData.getSuggestSearchXpPoiInfosFromCached() != null) {
                        this.mLogicView.updateSugAdapter(searchResultData.getSuggestSearchXpPoiInfosFromCached());
                        break;
                    } else {
                        return;
                    }
                } else {
                    this.mLogicView.updateAdapter(searchResultData.getSearchResponseEvent());
                    break;
                }
            case 5:
            case 6:
                if (searchResultData.getSearchResponseEvent() == null || CollectionUtils.isEmpty(searchResultData.getSearchResponseEvent().getList())) {
                    GeneralChargeRequestParam generalChargeRequestParam = this.mGeneralChargeRequestParam;
                    if (generalChargeRequestParam != null && !TextUtils.isEmpty(generalChargeRequestParam.getQuery())) {
                        startKeywordSearch(this.mGeneralChargeRequestParam.getQuery(), XPPoiCategory.SEARCH_CATEGORY_CHARGE, true);
                        break;
                    } else {
                        startKeywordSearch(this.mLogicView.getSearchCategoryCharge(), XPPoiCategory.SEARCH_CATEGORY_CHARGE, true);
                        break;
                    }
                } else {
                    startSearchResult(searchResultData.getSearchResponseEvent());
                    break;
                }
                break;
            case 7:
                SearchDeleteResult searchDeleteResult = searchResultData.getSearchDeleteResult();
                int deletedCount = searchDeleteResult.getDeletedCount();
                List<FavoriteAddress> deleteFavoritesList = searchDeleteResult.getDeleteFavoritesList();
                if (deletedCount > 0) {
                    for (FavoriteAddress favoriteAddress : deleteFavoritesList) {
                        FavoriteAddress findFavoriteAddress = findFavoriteAddress(this.mFavoriteAddressList, favoriteAddress);
                        if (findFavoriteAddress != null && (indexOf = this.mFavoriteAddressList.indexOf(findFavoriteAddress)) >= 0) {
                            this.mFavoriteAddressList.remove(findFavoriteAddress);
                            this.mLogicView.deleteFavorite(false, indexOf, true);
                        }
                    }
                    break;
                }
                break;
            case 8:
                searchDeleteHistory(searchResultData);
                break;
            case 9:
            case 10:
                searchDeleteAllHistory(searchResultData);
                break;
            case 11:
                boolean isHome = searchResultData.getSearchLoadDistanceResult().isHome();
                long distance = searchResultData.getSearchLoadDistanceResult().getDistance();
                this.mLogicView.updatePoiDistance(isHome, searchResultData.getSearchLoadDistanceResult().getTravelTime(), distance);
                this.mLogicView.updateTrafficBar(isHome, searchResultData.getSearchLoadDistanceResult().getLightBarInfo(), distance, distance);
                if (isHome) {
                    this.mLogicView.updateHomeText();
                    this.mHomeDistanceLoaded = true;
                    break;
                } else {
                    this.mLogicView.updateCompanyText();
                    this.mCompanyDistanceLoaded = true;
                    break;
                }
            case 14:
                if (searchResultData.getSearchResponseEvent() == null || CollectionUtils.isEmpty(searchResultData.getSearchResponseEvent().getList())) {
                    if ("010500".equalsIgnoreCase(this.mNaviSearchParam.getCategory())) {
                        XPNaviSearchParam xPNaviSearchParam = this.mNaviSearchParam;
                        if (xPNaviSearchParam != null && !TextUtils.isEmpty(xPNaviSearchParam.getQuery())) {
                            startKeywordSearch(this.mNaviSearchParam.getQuery(), this.mNaviSearchParam.getCategory(), true);
                            break;
                        } else {
                            startKeywordSearch(this.mLogicView.getSearchCarWash(), "", true);
                            break;
                        }
                    } else if (XPNaviSearchParam.CATEGORY_EXPERIENCE_CENTER.equalsIgnoreCase(this.mNaviSearchParam.getCategory()) || XPNaviSearchParam.CATEGORY_DELIVERY_CENTER.equalsIgnoreCase(this.mNaviSearchParam.getCategory()) || XPNaviSearchParam.CATEGORY_SERVER_CENTER.equalsIgnoreCase(this.mNaviSearchParam.getCategory()) || XPNaviSearchParam.CATEGORY_INTEGRATED_SERVER_CENTER.equalsIgnoreCase(this.mNaviSearchParam.getCategory())) {
                        startSearchResult(searchResultData.getSearchResponseEvent());
                        break;
                    }
                } else {
                    startSearchResult(searchResultData.getSearchResponseEvent());
                    break;
                }
                break;
            case 15:
                int normalFavCount = searchResultData.getNormalFavCount();
                if (L.ENABLE) {
                    L.Tag tag3 = TAG;
                    L.d(tag3, "onDataFetched  SEARCH_TYPE_NORMAL_FAV_COUNT count:" + normalFavCount);
                }
                updateNextIcon(normalFavCount);
                break;
        }
        if (searchResultData.getSearchResponseEvent() == null || !CollectionUtils.isNotEmpty(searchResultData.getSearchResponseEvent().getList()) || searchResultData.getSearchResponseEvent().getList().get(0) == null) {
            return;
        }
        int i = this.mSearchType;
        if (4 == i || 13 == i || 2 == i) {
            updateHistory(searchResultData.getSearchResponseEvent().getList().get(0).getKey());
        }
    }

    private void updateHistory(String str) {
        if (TextUtils.isEmpty(str) || inSearchCommonKeywords(str)) {
            return;
        }
        FavoriteDataManager.getInstance().insertOrReplaceHistoryKeyword(str);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull SearchResultData searchResultData) {
        this.mLogicView.cacheResultData(searchResultData);
    }

    private void searchDeleteAllHistory(@NonNull SearchResultData searchResultData) {
        int deletedCount = searchResultData.getSearchDeleteResult().getDeletedCount();
        int searchType = searchResultData.getSearchType();
        L.Tag tag = TAG;
        L.i(tag, "searchDeleteAllHistory count:" + deletedCount + ", type:" + searchType);
        if (deletedCount > 0) {
            if (searchType == 9) {
                this.mFavoriteAddressList.clear();
                this.mLogicView.deleteFavorite(true, -1, true);
                return;
            }
            this.mHistoryRecordList.clear();
            this.mLogicView.deleteHistoryRecords();
        }
    }

    private void searchDeleteHistory(@NonNull SearchResultData searchResultData) {
        SearchDeleteResult searchDeleteResult = searchResultData.getSearchDeleteResult();
        int deletedCount = searchDeleteResult.getDeletedCount();
        int deletedPosition = searchDeleteResult.getDeletedPosition();
        HistoryRecordInfo deletedHistoryRecord = searchDeleteResult.getDeletedHistoryRecord();
        if (deletedCount > 0) {
            if (deletedHistoryRecord != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mHistoryRecordList.size()) {
                        break;
                    }
                    HistoryRecordInfo historyRecordInfo = this.mHistoryRecordList.get(i);
                    if (historyRecordInfo.getHistoryType() == deletedHistoryRecord.getHistoryType() && historyRecordInfo.getId() == deletedHistoryRecord.getId()) {
                        this.mHistoryRecordList.remove(i);
                        break;
                    }
                    i++;
                }
            }
            this.mLogicView.deleteHistoryRecord(deletedPosition);
        }
    }

    private void fillBackTitle() {
        if (TextUtils.isEmpty(this.mSearchKeywordText)) {
            return;
        }
        this.mLogicView.setEtSearchText(this.mSearchKeywordText);
        this.mSearchKeywordText = "";
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
        L.Tag tag = TAG;
        L.e(tag, "onError: " + str);
        dismissLoadingDialog();
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(SearchRequestParam searchRequestParam) {
        int searchType = searchRequestParam.getSearchType();
        if (searchType == 2 || searchType == 4 || searchType == 5 || searchType == 6 || searchType == 13 || searchType == 14) {
            showLoadingDialog();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(SearchRequestParam searchRequestParam) {
        int searchType = searchRequestParam.getSearchType();
        if (searchType == 2 || searchType == 4 || searchType == 5 || searchType == 6 || searchType == 13 || searchType == 14) {
            dismissLoadingDialog();
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return this.mLogicView.isSceneLegal();
    }

    public void registerAccountObserver() {
        AccountObservable.getInstance().addObserver(this.mAccountObserver);
    }

    public void unRegisterAccountObserver() {
        AccountObservable.getInstance().deleteObserver(this.mAccountObserver);
    }

    public void registerAccountEventCallback() {
        XPAccountServiceWrapper.getInstance().registerAccountEventCallback(this.mAccountEventCallback);
    }

    public void unRegisterAccountEventCallback() {
        XPAccountServiceWrapper.getInstance().unRegisterAccountEventCallback(this.mAccountEventCallback);
    }
}
