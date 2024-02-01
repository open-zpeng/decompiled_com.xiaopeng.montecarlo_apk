package com.xiaopeng.montecarlo.scenes.searchscene;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.autonavi.gbl.map.model.PointD;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecoratorData;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.ParallelRoadEvent;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.navcore.search.DetailInfoRequest;
import com.xiaopeng.montecarlo.navcore.search.SearchClient;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.search.charge.ChargeDataProvider;
import com.xiaopeng.montecarlo.navcore.search.param.GeneralChargeRequestParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchAlongWayParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPSearchKeywordParam;
import com.xiaopeng.montecarlo.navcore.search.request.AlongWayRequest;
import com.xiaopeng.montecarlo.navcore.search.request.KeywordQueryRequest;
import com.xiaopeng.montecarlo.navcore.speech.bean.SpeechDataCenterPoi;
import com.xiaopeng.montecarlo.navcore.speech.utils.NaviSpeechUtils;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.CPSearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.NaviSearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultDataProvider;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultRequestParam;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultReturnData;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
import com.xiaopeng.montecarlo.stat.MapStateChangeStatUtil;
import com.xiaopeng.montecarlo.stat.SearchResultStatUtil;
import com.xiaopeng.montecarlo.util.MapUtil;
import com.xiaopeng.montecarlo.util.SRUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.RouteChargePanelView;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class SearchResultPresenter extends BasePresenter implements ISearchResultContract.Presenter, IStateListener, BaseCallBack<SearchRequestParam, SearchResultReturnData>, RouteChargePanelView.IRouteChargeDetailListener {
    private static final int INFOFLOW_DISPALY_SIZE = 3;
    private static final L.Tag TAG = new L.Tag("SearchResultPresenter");
    private List<XPPoiInfo> mAllMarkList;
    private AlongWayRequest mAlongWayRequest;
    private XPPoiInfo mAroundPoi;
    private XPPoiInfo mFavoritePoi;
    private GeneralChargeRequestParam mGeneralChargeRequestParam;
    private String mKeyword;
    private KeywordQueryRequest mKeywordQueryRequest;
    @VisibleForTesting
    protected ArrayList<XPPoiInfo> mList;
    public ISearchResultContract.LogicView mLogicView;
    private PageType mOldPageType;
    private PresenterData mPresenterData;
    private SearchNaviListener mSearchNaviListener;
    @VisibleForTesting
    private SearchResultDataProvider mSearchResultProvider;
    private XPNaviSearchParam mXPNaviSearchParam;
    @VisibleForTesting
    protected boolean mListExpandState = true;
    private int mSearchMode = 100;
    private int mSearchModeView = 100;
    private int mSearchDest = 1000;
    private int mSearchType = -1;
    private int mSearchRadius = 0;
    private String mSearchFrom = null;
    private int mStartFrom = 0;
    private boolean mIsOnWayOfVF = false;
    ChargeDataProvider mChargeDataProvider = new ChargeDataProvider();

    @Override // com.xiaopeng.montecarlo.views.RouteChargePanelView.IRouteChargeDetailListener
    public void onChargeAdd(String str) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataCache(@NonNull SearchResultReturnData searchResultReturnData) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onError(int i, @NonNull String str) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchComplete(SearchRequestParam searchRequestParam) {
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onFetchStart(SearchRequestParam searchRequestParam) {
    }

    public SearchResultPresenter(ISearchResultContract.LogicView logicView) {
        this.mSearchResultProvider = null;
        if (logicView == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
        this.mSearchNaviListener = new SearchNaviListener(this, this.mLogicView);
        this.mSearchResultProvider = new SearchResultDataProvider();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public int getSearchModeView() {
        return this.mSearchModeView;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.d(TAG, "onResume()");
        }
        TBTManager.getInstance().addNaviListener(this.mSearchNaviListener);
        if (this.mSearchResultProvider.switchOnTimer()) {
            StateManager.getInstance().addListener(this);
            StateManager.getInstance().switchActiveState();
            StateManager.getInstance().start(0, 10000);
        }
        if (this.mLogicView.isCreate()) {
            processExpandState();
        }
        SearchResultStatUtil.sendStatDataWhenGotoForeground(getPageType());
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        if (L.ENABLE) {
            L.d(TAG, "onPause()");
        }
        TBTManager.getInstance().removeNaviListener(this.mSearchNaviListener);
        StateManager.getInstance().removeListener(this);
        if (this.mLogicView.isChildScene()) {
            NaviSpeechUtils.setPageType(this.mOldPageType);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
        if (this.mAllMarkList != null) {
            this.mAllMarkList = null;
        }
        this.mChargeDataProvider.cancelAllRequest();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void init(PresenterData presenterData) {
        this.mPresenterData = presenterData;
        initView();
        initData();
        initTitle();
        checkRecyclerViewAutoPaging();
        initAdapter();
    }

    private void initView() {
        this.mLogicView.initView();
    }

    private void initData() {
        PresenterData presenterData = this.mPresenterData;
        if (presenterData != null) {
            this.mSearchMode = presenterData.getSearchMode();
            this.mSearchModeView = this.mPresenterData.getSearchModeView();
            this.mAroundPoi = this.mPresenterData.getAroundPoi();
            this.mSearchDest = this.mPresenterData.getSearchDest();
            this.mSearchFrom = this.mPresenterData.getSearchFromKey();
            this.mSearchType = this.mPresenterData.getSearchType();
            this.mStartFrom = this.mPresenterData.getStartFrom();
            this.mIsOnWayOfVF = this.mPresenterData.isOnWayOfVoiceFusion();
            this.mList = this.mPresenterData.getSearchResult();
            if (isStartFromVoiceFusion()) {
                this.mLogicView.updatePageSizeForVoiceFusion(getPageSizeForVoiceFusion());
            }
            this.mFavoritePoi = (XPPoiInfo) this.mPresenterData.getSearchResultFavoritePoi();
            this.mSearchRadius = this.mPresenterData.getSearchRadius();
            this.mKeyword = this.mPresenterData.getSearchKeywordText();
            if (this.mLogicView.isChildScene()) {
                this.mOldPageType = NaviSpeechUtils.getPageType();
            }
            initRequestData();
        }
    }

    public boolean isStartFromVoiceFusion() {
        return this.mStartFrom == 2 && VoiceFusionUtil.getInstance().isVoiceFusionSupported();
    }

    private void initTitle() {
        if (!CollectionUtils.isNotEmpty(this.mList) || this.mList.get(0) == null) {
            return;
        }
        this.mList.get(0);
        int i = this.mSearchMode;
        if (101 == i) {
            this.mLogicView.setAroundTitle(this.mKeyword);
        } else if (103 == i) {
            this.mLogicView.setScreenChargeTitle();
        } else if (isSearchFromFavorite()) {
            this.mLogicView.setFavoriteTitle();
        } else if (Utils.isPortrait() && isStartFromVoiceFusion()) {
            this.mLogicView.setTitle(ContextUtils.getString(R.string.search_voice_back_to_result));
        } else {
            this.mLogicView.setTitle(this.mKeyword);
        }
    }

    private void initRequestData() {
        int i = this.mSearchType;
        String str = "";
        int i2 = -1;
        if (4 == i || 13 == i) {
            XPSearchKeywordParam xPSearchKeywordParam = (XPSearchKeywordParam) this.mPresenterData.getSearchResultSearchParams();
            if (xPSearchKeywordParam != null) {
                this.mKeywordQueryRequest = new KeywordQueryRequest((int) System.currentTimeMillis(), xPSearchKeywordParam);
                str = xPSearchKeywordParam.getKeywords();
            }
        } else if (2 == i) {
            XPSearchAlongWayParam xPSearchAlongWayParam = (XPSearchAlongWayParam) this.mPresenterData.getSearchResultSearchParams();
            if (xPSearchAlongWayParam != null) {
                this.mAlongWayRequest = new AlongWayRequest((int) System.currentTimeMillis(), xPSearchAlongWayParam);
                str = xPSearchAlongWayParam.getKeyword();
            }
        } else if (5 == i || 6 == i) {
            this.mGeneralChargeRequestParam = (GeneralChargeRequestParam) this.mPresenterData.getSearchResultSearchParams();
            GeneralChargeRequestParam generalChargeRequestParam = this.mGeneralChargeRequestParam;
            if (generalChargeRequestParam != null) {
                str = generalChargeRequestParam.getQuery();
                i2 = CarServiceManager.getInstance().getCarRemainDistance();
                if (shouldShowChargeFilter(str)) {
                    this.mLogicView.showChargeFilter();
                }
            }
        } else if (14 == i) {
            this.mXPNaviSearchParam = (XPNaviSearchParam) this.mPresenterData.getSearchResultSearchParams();
            str = this.mXPNaviSearchParam.getQuery();
        }
        NaviSpeechUtils.setPageType(getPageType());
        SearchResultStatUtil.sendStatDataWhenExposure(getPageType(), str, i2);
    }

    private void initAdapter() {
        this.mLogicView.initAdapter();
        initSearchResult();
    }

    public boolean shouldShowChargeFilter(String str) {
        if (CarFeatureManager.INSTANCE.isChargeFilterEnable()) {
            return TextUtils.isEmpty(str) || !(str.contains(ContextUtils.getString(R.string.filter_self_sale)) || str.contains(ContextUtils.getString(R.string.filter_free)));
        }
        return false;
    }

    private void checkRecyclerViewAutoPaging() {
        if (isAutoPage()) {
            this.mLogicView.setRecyclerViewAutoPaging(true);
            if (getSearchMode() != 103 || getSearchPois() == null) {
                return;
            }
            this.mLogicView.setRecyclerViewMaxCount(getSearchPois().size());
            return;
        }
        this.mLogicView.setRecyclerViewLoadMore();
    }

    public void initSearchResult() {
        if (isSingleResult()) {
            this.mLogicView.updateSinglePoi(getSingleResult());
        } else {
            setMultiPoi(this.mList);
        }
    }

    private void setMultiPoi(List<XPPoiInfo> list) {
        this.mLogicView.updateMultiPoi(list);
    }

    public boolean isShowSingleLayout() {
        int i = this.mSearchDest;
        return 1001 == i || 1002 == i || isSearchFromFavorite() || isSingleResult();
    }

    public void queryChargeStation(boolean z, boolean z2) {
        if (this.mGeneralChargeRequestParam == null) {
            L.e(TAG, "queryChargeStation no param!");
            return;
        }
        String str = z ? "1" : null;
        String str2 = z2 ? "3" : null;
        this.mGeneralChargeRequestParam.setFilterOperationMode(str);
        this.mGeneralChargeRequestParam.setFilterDiscountType(str2);
        this.mGeneralChargeRequestParam.setPage(1);
        this.mLogicView.showLoadingDialog();
        this.mChargeDataProvider.queryChargeStation(this.mGeneralChargeRequestParam, getSearchTypeBySearchMode(), new DisposableObserver<XPSearchResult>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultPresenter.1
            @Override // io.reactivex.Observer
            public void onNext(@io.reactivex.annotations.NonNull XPSearchResult xPSearchResult) {
                if (SearchResultPresenter.this.isLegal()) {
                    SearchResultPresenter.this.mLogicView.resetListItemVisiblePosition();
                    List<XPPoiInfo> xPPoiInfos = xPSearchResult.getXPPoiInfos();
                    SearchResultPresenter.this.mList = new ArrayList<>();
                    if (xPPoiInfos != null) {
                        SearchResultPresenter.this.mList.addAll(xPPoiInfos);
                    }
                    SearchResultPresenter.this.initSearchResult();
                    if (SearchResultPresenter.this.mList.isEmpty()) {
                        SearchResultPresenter.this.mLogicView.showChargeNoResult();
                    } else {
                        SearchResultPresenter.this.mLogicView.showChargeSearchResult();
                    }
                    if (SearchResultPresenter.this.mGeneralChargeRequestParam != null) {
                        SearchResultPresenter.this.mGeneralChargeRequestParam.nextPage();
                    }
                    if (SearchResultPresenter.this.mLogicView != null) {
                        SearchResultPresenter.this.mLogicView.updateFirstVisible(0);
                    }
                }
            }

            @Override // io.reactivex.Observer
            public void onError(@io.reactivex.annotations.NonNull Throwable th) {
                SearchResultPresenter.this.mLogicView.resetListItemVisiblePosition();
                SearchResultPresenter.this.mList = new ArrayList<>();
                SearchResultPresenter.this.initSearchResult();
                SearchResultPresenter.this.mLogicView.dismissLoadingDialog();
                SearchResultPresenter.this.mLogicView.showChargeLoadingError();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                SearchResultPresenter.this.mLogicView.dismissLoadingDialog();
            }
        });
    }

    public String getSearchTypeBySearchMode() {
        return this.mSearchMode == 102 ? XPNaviSearchParam.PARAM_TYPE_VALUE_ALONGWAY : "100";
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    @MainThread
    public void startUpdateMarkTask() {
        ArrayList<XPPoiInfo> arrayList;
        WorkThreadUtil.getInstance().executeBusinessTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                SearchResultPresenter.this.showAllMarkPreview();
            }
        });
        boolean isSingleResult = isSingleResult();
        SearchDecoratorData.Builder builder = new SearchDecoratorData.Builder();
        builder.searchType(getSearchMode());
        ArrayList<XPPoiInfo> arrayList2 = this.mList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            builder.firstVisibleItemPosition(-1);
            arrayList = new ArrayList<>();
        } else if (isSingleResult) {
            builder.firstVisibleItemPosition(0);
            arrayList = new ArrayList<>(getSearchPois());
        } else {
            builder.firstVisibleItemPosition(this.mLogicView.getActualFirstItemPosition());
            List<XPPoiInfo> adapterData = this.mLogicView.getAdapterData();
            arrayList = adapterData != null ? new ArrayList<>(adapterData) : null;
        }
        if (arrayList != null) {
            builder.poiList(arrayList);
            if (getSearchMode() == 101 && getAroundPoi() != null) {
                L.d(TAG, "updateSearchMarkOverlay search mode around");
                arrayList.add(getAroundPoi());
            }
            L.Tag tag = TAG;
            L.i(tag, "startUpdateMarkTask list size:" + arrayList.size());
        }
        if (getFavoritePoi() != null) {
            builder.favoritepPoi(getFavoritePoi());
        }
        this.mLogicView.updateMapDecorator(DecoratorType.SEARCH, builder.builder());
    }

    @VisibleForTesting
    protected boolean needShowOfflineContainer() {
        return needShowOfflineContainer(this.mListExpandState);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void loadMore() {
        XPNaviSearchParam xPNaviSearchParam;
        int i = this.mSearchType;
        if (4 == i || 13 == i) {
            SearchResultRequestParam searchResultRequestParam = new SearchResultRequestParam();
            searchResultRequestParam.setKeywordRequest(this.mKeywordQueryRequest);
            this.mSearchResultProvider.keywordSearch(searchResultRequestParam, this);
        } else if (5 != i && 6 != i) {
            if (14 != i || (xPNaviSearchParam = this.mXPNaviSearchParam) == null) {
                return;
            }
            NaviSearchRequestParam naviSearchRequestParam = new NaviSearchRequestParam(xPNaviSearchParam);
            naviSearchRequestParam.setSearchType(this.mSearchType);
            this.mSearchResultProvider.searchNaviServer(naviSearchRequestParam, this);
        } else {
            GeneralChargeRequestParam generalChargeRequestParam = this.mGeneralChargeRequestParam;
            if (generalChargeRequestParam != null) {
                CPSearchRequestParam cPSearchRequestParam = new CPSearchRequestParam(generalChargeRequestParam);
                cPSearchRequestParam.setSearchType(this.mSearchType);
                int i2 = this.mSearchType;
                if (5 == i2) {
                    this.mSearchResultProvider.searchChargeAround(cPSearchRequestParam, this);
                } else if (6 == i2) {
                    this.mSearchResultProvider.searchChargeAlongWay(cPSearchRequestParam, this);
                }
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void setListExpandState() {
        this.mListExpandState = !this.mListExpandState;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public boolean getListExpandState() {
        return this.mListExpandState;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public int processCurrentFreeBound() {
        if (this.mListExpandState) {
            return this.mLogicView.updatePoiLeftOffset();
        }
        return this.mLogicView.updateEmptyPoiLeftOffset();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void processExpandState() {
        if (isStartFromVoiceFusion()) {
            this.mLogicView.setListCollapseForVoiceFusion();
        } else if (isSingleResult()) {
        } else {
            this.mLogicView.setOfflineContainerVisible(needShowOfflineContainer());
            if (this.mListExpandState) {
                this.mLogicView.setListExpand();
            } else {
                this.mLogicView.setListCollapse();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public int getSearchMode() {
        return this.mSearchMode;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public int getSearchDest() {
        return this.mSearchDest;
    }

    public int getSearchRadius() {
        return this.mSearchRadius;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void goToPoi(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "goToPoi item:" + xPPoiInfo);
            return;
        }
        L.Tag tag2 = TAG;
        L.w(tag2, "goToPoi item:" + xPPoiInfo.toString());
        gotoPoi(RouteRequest.createNormalRequest(this.mSearchResultProvider.getStartInfoFromCurrent(), xPPoiInfo, null));
    }

    public void gotoPoi(RouteRequest routeRequest) {
        if (routeRequest == null) {
            L.w(TAG, "goToPoi routeRequest is null");
        } else {
            Utils.startSceneForRoute(this.mLogicView.getMainContext().getCurrentScene(), routeRequest);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
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
        exitCurrentSearch();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void removeWayPoint(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "removeWayPoint item:" + xPPoiInfo);
            return;
        }
        this.mLogicView.setResult(RouteRequest.createRemoveViaRequest(xPPoiInfo, TBTManager.getInstance().getCurrentRouteRequestId()));
        exitCurrentSearch();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void setHomeOrCompany(XPPoiInfo xPPoiInfo, int i) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "setCompany item:" + xPPoiInfo);
            return;
        }
        FavoriteAddress favoriteAddress = new FavoriteAddress(xPPoiInfo);
        if (i == 1001) {
            if (this.mSearchResultProvider.setHome(favoriteAddress)) {
                this.mSearchResultProvider.insertOrReplaceHome(favoriteAddress);
            }
        } else if (this.mSearchResultProvider.setCompany(favoriteAddress)) {
            this.mSearchResultProvider.insertOrReplaceCompany(favoriteAddress);
        }
        this.mLogicView.setResultBundleData(i, xPPoiInfo);
        this.mLogicView.goBack();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void addNewNavi(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "addNewNavi item:" + xPPoiInfo);
            return;
        }
        this.mLogicView.setResult(RouteRequest.createNewDesRequest(xPPoiInfo));
        exitCurrentSearch();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void queryDetailInfo(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "queryDetailInfo item:" + xPPoiInfo);
            return;
        }
        this.mLogicView.setPoiToCenter(new XPCoordinate2DDouble(xPPoiInfo));
        DetailInfoRequest.Builder builder = new DetailInfoRequest.Builder();
        builder.mPoiId(xPPoiInfo.getPoiId()).mPoiName(xPPoiInfo.getName()).mPoiLon(xPPoiInfo.getDisplayLon()).mPoiLat(xPPoiInfo.getDisplayLat()).mUserLon(xPPoiInfo.getDisplayLon()).mUserLat(xPPoiInfo.getDisplayLat()).mSearchId(SearchClient.getInstance().getRequestId());
        SearchResultRequestParam searchResultRequestParam = new SearchResultRequestParam();
        searchResultRequestParam.setDetailInfoRequest(builder.build());
        this.mSearchResultProvider.detailInfoSearch(searchResultRequestParam, this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void exitCurrentSearch() {
        if (L.ENABLE) {
            L.d(TAG, "exitCurrentSearch");
        }
        int i = this.mSearchMode;
        if (103 == i || 104 == i || isStartFromVoiceFusion()) {
            this.mLogicView.goBack();
        } else {
            this.mLogicView.backToMode(StatusConst.Mode.SEARCH, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.RouteChargePanelView.IRouteChargeDetailListener
    public void onChargeRemove(String str) {
        if (this.mLogicView.isSceneLegal() && !TextUtils.isEmpty(str)) {
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
            if (CollectionUtils.isEmpty(viaInfos)) {
                return;
            }
            for (XPViaPoint xPViaPoint : viaInfos) {
                XPPoiInfo poiPoint = xPViaPoint.getPoiPoint();
                if (poiPoint != null && str.equals(poiPoint.getPoiId())) {
                    removeWayPoint(poiPoint);
                    return;
                }
            }
        }
    }

    private void enterImmersion() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "enterImmersion startFrom:" + this.mStartFrom);
        }
        if (isStartFromVoiceFusion()) {
            if (L.ENABLE) {
                L.d(TAG, "enterImmersion start from voice fusion do not need enter immersion");
                return;
            }
            return;
        }
        int i = this.mSearchMode;
        if (103 == i) {
            this.mLogicView.goBack();
        } else if (104 == i) {
            this.mLogicView.goBack();
        } else if (this.mLogicView.isPreScene(StatusConst.Mode.NAVI)) {
            this.mLogicView.backToMode(StatusConst.Mode.NAVI, false);
        } else if (this.mLogicView.isPreScene(StatusConst.Mode.EXPLORE)) {
            this.mLogicView.backToMode(StatusConst.Mode.EXPLORE, false);
        } else if (this.mLogicView.isPreScene(StatusConst.Mode.ROUTE)) {
            this.mLogicView.backToMode(StatusConst.Mode.ROUTE, false);
        } else {
            this.mLogicView.backToLastMode(StatusConst.Mode.SEARCH, true);
        }
    }

    private String getSearchFrom() {
        return this.mSearchFrom;
    }

    private boolean isSearchFromFavorite() {
        return "favorite".equals(getSearchFrom());
    }

    @VisibleForTesting
    protected boolean isSearchFromFavoriteOrHistory() {
        return "favorite".equals(getSearchFrom()) || SearchBridge.POI_FROM_HISTORY.equals(getSearchFrom());
    }

    private boolean isAutoPage() {
        int i = this.mSearchType;
        return i == 2 || i == 6 || getSearchMode() == 103;
    }

    private XPPoiInfo getAroundPoi() {
        return this.mAroundPoi;
    }

    private void exitSetHomeOffice() {
        this.mLogicView.backToMode(StatusConst.Mode.SET_HOME_OFFICE, true);
    }

    private void showMarkPreview(List<XPPoiInfo> list) {
        if (isStartFromVoiceFusion() && Utils.isPortrait()) {
            showMarkPreview(list, VoiceFusionUtil.getInstance().getDefaultInfoflowCardHeight(0));
        } else {
            showMarkPreview(list, 0);
        }
    }

    private void showMarkPreview(List<XPPoiInfo> list, int i) {
        int i2;
        int i3;
        int multiLayoutWidth;
        if (list == null || this.mLogicView.isPoiPopup() || list.size() <= 1) {
            return;
        }
        this.mAllMarkList = list;
        ArrayList<PointD> arrayList = new ArrayList<>();
        for (int i4 = 0; i4 < list.size(); i4++) {
            XPPoiInfo xPPoiInfo = list.get(i4);
            PointD pointD = new PointD();
            pointD.x = xPPoiInfo.getDisplayLon();
            pointD.y = xPPoiInfo.getDisplayLat();
            arrayList.add(pointD);
        }
        int markWidth = this.mLogicView.getMarkWidth();
        if (Utils.isLandscape()) {
            if (isStartFromVoiceFusion()) {
                multiLayoutWidth = ContextUtils.getDimensionPixelSize(R.dimen.search_result_mark_preview_left_offset_for_voice_fusion) + markWidth;
            } else {
                multiLayoutWidth = this.mLogicView.getMultiLayoutWidth() + markWidth + ContextUtils.getDimensionPixelSize(R.dimen.base_scene_margin_start);
            }
            i2 = multiLayoutWidth;
        } else {
            i2 = markWidth;
        }
        int dimensionPixelSize = Utils.isLandscape() ? ContextUtils.getDimensionPixelSize(R.dimen.base_scene_margin_top) + markWidth : this.mLogicView.getSearchPageTop() + markWidth;
        int dimensionPixelSize2 = markWidth + ContextUtils.getDimensionPixelSize(R.dimen.base_scene_margin_bottom);
        if (isStartFromVoiceFusion() && i != 0 && Utils.isPortrait()) {
            if (L.ENABLE) {
                L.d(TAG, "showMarkPreview exchange top offset by portrait voice fusion");
            }
            i3 = i + markWidth;
        } else {
            i3 = dimensionPixelSize;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showMarkPreview lScreenOffset:" + i2 + ",tScreenOffset:" + i3 + ",rScreenOffset:" + markWidth + ",bScreenOffset:" + dimensionPixelSize2);
        }
        this.mLogicView.showPreview(arrayList, i2, i3, markWidth, dimensionPixelSize2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onParallelRoadEvent(ParallelRoadEvent parallelRoadEvent) {
        if (parallelRoadEvent != null && parallelRoadEvent.getType() == 1) {
            exitCurrentSearch();
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        L.Tag tag = TAG;
        L.i(tag, ">>>onStateChange state = " + i);
        ISearchResultContract.LogicView logicView = this.mLogicView;
        if (logicView != null) {
            MapStateChangeStatUtil.sendStatData(logicView.getMainContext(), i);
        }
        if (1 == i) {
            enterImmersion();
        }
    }

    private ArrayList<XPPoiInfo> getSearchPois() {
        return this.mList;
    }

    public XPPoiInfo getSingleResult() {
        if (isSingleResult()) {
            return this.mList.get(0);
        }
        return null;
    }

    private XPPoiInfo getFavoritePoi() {
        return this.mFavoritePoi;
    }

    public boolean isSingleResult() {
        ArrayList<XPPoiInfo> arrayList = this.mList;
        return arrayList != null && arrayList.size() == 1;
    }

    @VisibleForTesting
    protected boolean needShowOfflineContainer(boolean z) {
        if (isSingleResult()) {
            if (!isShowSingleLayout() && isOffline()) {
                return true;
            }
        } else if (z && isOffline()) {
            return true;
        }
        return false;
    }

    public String getCategory() {
        KeywordQueryRequest keywordQueryRequest = this.mKeywordQueryRequest;
        if (keywordQueryRequest != null && keywordQueryRequest.getKeywordParam() != null) {
            return this.mKeywordQueryRequest.getKeywordParam().getCategory();
        }
        AlongWayRequest alongWayRequest = this.mAlongWayRequest;
        if (alongWayRequest == null || alongWayRequest.getSearchAlongWayParam() == null) {
            return null;
        }
        return this.mAlongWayRequest.getSearchAlongWayParam().getCategory();
    }

    public PageType getPageType() {
        PageType pageType = PageType.Navi_Search_Main_Result;
        int i = this.mSearchMode;
        if (i == 103) {
            return PageType.SEARCH_CHARGINGSTATION_RESULT;
        }
        switch (this.mSearchDest) {
            case 1000:
                if (i == 101) {
                    return PageType.SEARCH_NEARBY_RESULT;
                }
                return i == 102 ? PageType.SEARCH_WAYPOINT_RESULT : pageType;
            case 1001:
                return PageType.SEARCH_HOME_RESULT;
            case 1002:
                return PageType.SEARCH_OFFICE_RESULT;
            default:
                return pageType;
        }
    }

    public boolean isOffline() {
        ArrayList<XPPoiInfo> arrayList = this.mList;
        if (arrayList == null || arrayList.size() <= 0 || this.mList.get(0) == null) {
            return false;
        }
        return this.mList.get(0).isOffline();
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public void onDataFetched(@NonNull SearchResultReturnData searchResultReturnData) {
        if (L.ENABLE) {
            L.d(TAG, "onDataFetched");
        }
        int searchType = searchResultReturnData.getSearchType();
        if (searchType != 2) {
            if (searchType != 4) {
                if (searchType == 5 || searchType == 6) {
                    GeneralChargeRequestParam generalChargeRequestParam = this.mGeneralChargeRequestParam;
                    if (generalChargeRequestParam != null) {
                        generalChargeRequestParam.nextPage();
                    }
                    if (searchResultReturnData.getSearchResponseEvent() != null) {
                        this.mLogicView.updatePagePoi(searchResultReturnData.getSearchResponseEvent().getList());
                        return;
                    }
                    return;
                }
                switch (searchType) {
                    case 12:
                    default:
                        return;
                    case 13:
                        break;
                    case 14:
                        XPNaviSearchParam xPNaviSearchParam = this.mXPNaviSearchParam;
                        if (xPNaviSearchParam != null) {
                            xPNaviSearchParam.nextPage();
                        }
                        if (searchResultReturnData.getSearchResponseEvent() != null) {
                            this.mLogicView.updatePagePoi(searchResultReturnData.getSearchResponseEvent().getList());
                            return;
                        }
                        return;
                }
            }
            KeywordQueryRequest keywordQueryRequest = this.mKeywordQueryRequest;
            if (keywordQueryRequest != null) {
                keywordQueryRequest.nextPage();
            }
            if (searchResultReturnData.getSearchResponseEvent() != null) {
                this.mLogicView.updatePagePoi(searchResultReturnData.getSearchResponseEvent().getList());
            }
        } else if (searchResultReturnData.getSearchResponseEvent() != null) {
            this.mLogicView.updatePagePoi(searchResultReturnData.getSearchResponseEvent().getList());
        }
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack
    public boolean isLegal() {
        return this.mLogicView.isSceneLegal();
    }

    public void showAllMarkPreview() {
        ArrayList<XPPoiInfo> visibleSubList;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "poicardview is popup " + this.mLogicView.isPoiPopup());
        }
        if (this.mLogicView.isPoiPopup()) {
            return;
        }
        if (isSingleResult()) {
            visibleSubList = new ArrayList<>(getSearchPois());
        } else {
            visibleSubList = this.mLogicView.getVisibleSubList();
        }
        if (visibleSubList != null) {
            if (getSearchMode() == 101 && getAroundPoi() != null) {
                if (L.ENABLE) {
                    L.d(TAG, "updateSearchMarkOverlay search mode around");
                }
                visibleSubList.add(getAroundPoi());
            }
            if (CollectionUtils.isNotEmpty(this.mAllMarkList)) {
                this.mAllMarkList.clear();
            }
            if (!visibleSubList.isEmpty() && this.mLogicView.getMapView().isLaneMode()) {
                this.mLogicView.getMapView().switchToSD(ThemeWatcherUtil.getMapModeByCurrentTheme());
            }
            if (visibleSubList.size() > 1) {
                showMarkPreview(visibleSubList);
            } else if (visibleSubList.size() == 1) {
                XPPoiInfo xPPoiInfo = visibleSubList.get(0);
                this.mLogicView.getMapView().getBizControlManager().setFollowMode(false);
                this.mLogicView.setPoiToCenter(new XPCoordinate2DDouble(xPPoiInfo));
                ArrayList<XPCoordinate2DDouble> poiPolygonBounds = xPPoiInfo.getPoiPolygonBounds();
                if (poiPolygonBounds == null || poiPolygonBounds.size() == 0) {
                    if (L.ENABLE) {
                        L.d(TAG, "itemPoiBounds.size() == 0");
                    }
                    MapUtil.updateMapLevel(this.mLogicView.getMainContext(), true);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        int i = speechNaviEvent.what;
        if (i == 100) {
            L.i(TAG, "SPEECH_OPEN_FAVORITE");
            this.mLogicView.getSpeechEventBizHelper().openFavoriteInSearchResult(this);
        } else if (i == 312) {
            L.Tag tag = TAG;
            L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneVisible:" + this.mLogicView.isSceneVisible());
            return this.mLogicView.getSpeechEventBizHelper().routeNewDestWithViaInSearchResult(this, speechNaviEvent);
        } else if (i == 313) {
            L.Tag tag2 = TAG;
            L.i(tag2, "SPEECH_ADD_VIA, isSceneVisible:" + this.mLogicView.isSceneVisible());
            return this.mLogicView.getSpeechEventBizHelper().addViaInSearchResult(this, speechNaviEvent);
        } else if (i != 2006) {
            if (i != 2007) {
                switch (i) {
                    case 407:
                        L.Tag tag3 = TAG;
                        L.i(tag3, "SPEECH_MAP_MODE_NORTH_UP, isSceneVisible:" + this.mLogicView.isSceneVisible());
                        if (this.mLogicView.isSceneLegal()) {
                            this.mLogicView.getSpeechEventBizHelper().setMapModeNorthUpNotSupported(iCommandCallback);
                            return true;
                        }
                        break;
                    case SpeechNaviEvent.SPEECH_MAP_MODE_HEAD_UP_2D /* 408 */:
                        L.Tag tag4 = TAG;
                        L.i(tag4, "SPEECH_MAP_MODE_HEAD_UP_2D, isSceneVisible:" + this.mLogicView.isSceneVisible());
                        if (this.mLogicView.isSceneLegal()) {
                            this.mLogicView.getSpeechEventBizHelper().setMapModeHeadUp2DNotSupported(iCommandCallback);
                            return true;
                        }
                        break;
                    case 409:
                        L.Tag tag5 = TAG;
                        L.i(tag5, "SPEECH_MAP_MODE_HEAD_UP_3D, isSceneVisible:" + this.mLogicView.isSceneVisible());
                        if (this.mLogicView.isSceneVisible()) {
                            this.mLogicView.getSpeechEventBizHelper().setMapModeHeadUp3DNotSupported(iCommandCallback);
                            return true;
                        }
                        break;
                    default:
                        switch (i) {
                            case 2001:
                                L.i(TAG, "SPEECH_VOICE_INTERACTIVE_END");
                                this.mLogicView.getSpeechEventBizHelper().executeWhenVoiceInteractiveEnd(this);
                                break;
                            case 2002:
                                L.i(TAG, "SPEECH_VOICE_SEARCH_DATA_FETCHED");
                                return this.mLogicView.getSpeechEventBizHelper().executeWhenVoiceSearchDataFetchedInSearchResult(this, speechNaviEvent);
                            case 2003:
                                return this.mLogicView.getSpeechEventBizHelper().executeWhenVoiceSearchDataItemFocusedInSearchResult(this, speechNaviEvent);
                            case 2004:
                                return this.mLogicView.getSpeechEventBizHelper().executeWhenInfoflowScrollEnd(this, speechNaviEvent);
                        }
                }
            } else {
                return this.mLogicView.getSpeechEventBizHelper().executeWhenInfoflowCardHeightChangedInSearch(this, speechNaviEvent);
            }
        } else {
            return this.mLogicView.getSpeechEventBizHelper().executeWhenInfoflowListStateChanged(this, speechNaviEvent);
        }
        return false;
    }

    public boolean executeSpeechCmdRouteNewDestWithVias(SpeechNaviEvent speechNaviEvent) {
        if (this.mLogicView.isSceneLegal()) {
            boolean isLaneMode = SRUtil.isLaneMode();
            XPPoiInfo dest = speechNaviEvent.getDest();
            if (!isLaneMode && (1 == TBTManager.getInstance().getCurrentStatus() || 2 == TBTManager.getInstance().getCurrentStatus())) {
                exitCurrentSearch();
                return false;
            }
            IBaseScene currentScene = this.mLogicView.getMainContext().getCurrentScene();
            boolean z = this.mLogicView.getMainContext().getScenesManager().findInTask(StatusConst.Mode.ROUTE, false) >= 0;
            RouteRequest requestFrom = RouteRequest.createNewDesRequestWithVias(speechNaviEvent.getOrig(), dest, speechNaviEvent.getViaList(), speechNaviEvent.getSettingParam(), speechNaviEvent.getStartType(), speechNaviEvent.getRouteSelectRef()).setRequestFrom(1);
            if (requestFrom != null) {
                if (z) {
                    this.mLogicView.setResult(requestFrom);
                    exitCurrentSearch();
                } else {
                    gotoPoi(requestFrom);
                    currentScene.goBack();
                }
            }
            return true;
        }
        return false;
    }

    public boolean addViaInSearchResult(SpeechNaviEvent speechNaviEvent) {
        if (this.mLogicView.isSceneLegal()) {
            boolean isLaneMode = SRUtil.isLaneMode();
            XPPoiInfo dest = speechNaviEvent.getDest();
            if (!isLaneMode && (1 == TBTManager.getInstance().getCurrentStatus() || 2 == TBTManager.getInstance().getCurrentStatus())) {
                exitCurrentSearch();
                return false;
            }
            boolean z = this.mLogicView.getMainContext().getScenesManager().findInTask(StatusConst.Mode.ROUTE, false) >= 0;
            RouteRequest createAddViaRequest = RouteRequest.createAddViaRequest(dest, TBTManager.getInstance().getCurrentRouteRequestId());
            if (createAddViaRequest != null) {
                createAddViaRequest.setRequestFrom(1);
                if (z) {
                    this.mLogicView.setResult(createAddViaRequest);
                    exitCurrentSearch();
                } else {
                    IBaseScene currentScene = this.mLogicView.getMainContext().getCurrentScene();
                    gotoPoi(createAddViaRequest);
                    currentScene.goBack();
                }
            }
            return true;
        }
        return false;
    }

    public boolean executeSpeechCmdDataItemFocused(SpeechNaviEvent speechNaviEvent) {
        if (canExecuteVoiceSearchFusionCommand()) {
            L.i(TAG, "SPEECH_VOICE_SEARCH_DATA_ITEM_FOCUSED");
            handleVoiceSearchDataItemFocused(speechNaviEvent.getFocusIndex());
            return true;
        }
        return false;
    }

    public boolean executeSpeechCmdVoiceSearchDataFetched(SpeechNaviEvent speechNaviEvent) {
        this.mStartFrom = 2;
        if (canExecuteVoiceSearchFusionCommand()) {
            L.i(TAG, "SPEECH_VOICE_SEARCH_DATA_FETCHED");
            handleVoiceSearchDataFetchedEvent(speechNaviEvent.getVoiceSearchData());
            return true;
        }
        return false;
    }

    public boolean executeSpeechCmdVoiceInteractiveEnd() {
        L.Tag tag = TAG;
        L.i(tag, "executeSpeechCmdVoiceInteractiveEnd isStartFromVoiceFusion : " + isStartFromVoiceFusion());
        if (!isStartFromVoiceFusion() || this.mLogicView == null) {
            return false;
        }
        L.i(TAG, "handleVoiceInteractiveEnd");
        this.mLogicView.setReturnResult(new Bundle());
        this.mLogicView.stopSelf();
        return true;
    }

    public void executeSpeechCmdOpenFavorite() {
        this.mLogicView.goBack();
    }

    private void handleVoiceSearchDataItemFocused(int i) {
        if (canExecuteVoiceSearchFusionCommand()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "handleVoiceSearchDataItemFocused focusIndex:" + i);
            }
            if (i > 0) {
                this.mLogicView.focusPosition(i - 1);
            }
        }
    }

    private void handleInfoflowScrollEnd(int i) {
        if (canExecuteVoiceSearchFusionCommand()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "handleInfoflowScrollEnd firstVisibleIndex:" + i);
            }
            this.mLogicView.executeAfterInfoflowScrollEnd(i);
        }
    }

    private boolean canExecuteVoiceSearchFusionCommand() {
        boolean isSceneLegal = this.mLogicView.isSceneLegal();
        if (!Utils.isSearchResultScene(this.mLogicView.getMainContext().getCurrentScene())) {
            isSceneLegal = false;
        }
        boolean isStartFromVoiceFusion = isSceneLegal & isStartFromVoiceFusion();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "canExecuteVoiceSearchFusionCommand flag:" + isStartFromVoiceFusion);
        }
        return isStartFromVoiceFusion;
    }

    private void handleVoiceSearchDataFetchedEvent(final String str) {
        if (canExecuteVoiceSearchFusionCommand()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "handleVoiceSearchDataFetchedEvent voiceSearchData:" + str);
            }
            WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    VoiceFusionUtil.getInstance().analysisVoiceFusionData(str, new VoiceFusionUtil.OnVoiceFusionDataAnalysisListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultPresenter.3.1
                        @Override // com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.OnVoiceFusionDataAnalysisListener
                        public void onSuccess(Map<String, Object> map) {
                            if (L.ENABLE) {
                                L.d(SearchResultPresenter.TAG, "handleVoiceSearchDataFetchedEvent onSuccess");
                            }
                            if (!SearchResultPresenter.this.isLegal()) {
                                L.w(SearchResultPresenter.TAG, "handleVoiceSearchDataFetchedEvent not legal");
                            } else if (!VoiceFusionUtil.getInstance().isCarSpeechDialogShowing()) {
                                L.w(SearchResultPresenter.TAG, "executeWhenVoiceSearchFusionDataFetched speech is not showing");
                                SearchResultPresenter.this.executeSpeechCmdVoiceInteractiveEnd();
                            } else {
                                SearchResultPresenter.this.refreshPage(map);
                            }
                        }

                        @Override // com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil.OnVoiceFusionDataAnalysisListener
                        public void onError(Exception exc) {
                            L.Tag tag2 = SearchResultPresenter.TAG;
                            L.e(tag2, "handleVoiceSearchDataFetchedEvent onError:" + exc.getMessage());
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPage(Map<String, Object> map) {
        this.mLogicView.updateFirstVisible(0);
        this.mLogicView.hidePoiPop();
        this.mKeyword = (String) map.get(VoiceFusionUtil.KEY_KEYWORD);
        this.mList = (ArrayList) map.get("data");
        this.mIsOnWayOfVF = ((Boolean) map.get(VoiceFusionUtil.KEY_IS_ONWAY)).booleanValue();
        boolean z = map.get(VoiceFusionUtil.KEY_CENTER_POI) != null;
        SpeechDataCenterPoi speechDataCenterPoi = z ? (SpeechDataCenterPoi) map.get(VoiceFusionUtil.KEY_CENTER_POI) : null;
        this.mAroundPoi = speechDataCenterPoi != null ? speechDataCenterPoi.toXPPoiInfo() : null;
        this.mSearchMode = z ? 101 : 100;
        if (!TextUtils.isEmpty(this.mKeyword)) {
            initTitle();
        }
        if (isStartFromVoiceFusion()) {
            this.mLogicView.updatePageSizeForVoiceFusion(getPageSizeForVoiceFusion());
        }
        initSearchResult();
        processExpandState();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.Presenter
    public void fetchDataForFusion(List<XPPoiInfo> list, int i) {
        SearchResultRequestParam searchResultRequestParam = new SearchResultRequestParam();
        searchResultRequestParam.setSearchType(i);
        this.mSearchResultProvider.alongRouteSearch(searchResultRequestParam, list, this);
    }

    public void stopSpeechDialog() {
        if (isStartFromVoiceFusion()) {
            VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
        }
    }

    public boolean executeSpeechCmdInfoScrollEnd(SpeechNaviEvent speechNaviEvent) {
        if (canExecuteVoiceSearchFusionCommand()) {
            L.i(TAG, "SPEECH_INFOFLOW_SCROLL_END");
            handleInfoflowScrollEnd(speechNaviEvent.getFirstVisibleIndex());
            return true;
        }
        return false;
    }

    public int getPageSizeForVoiceFusion() {
        if (CollectionUtils.isNotEmpty(this.mList)) {
            return this.mList.size();
        }
        return 50;
    }

    public int findIndex(XPPoiInfo xPPoiInfo) {
        if (!CollectionUtils.isNotEmpty(this.mLogicView.getAdapterData()) || xPPoiInfo == null) {
            return -1;
        }
        for (int i = 0; i < this.mLogicView.getAdapterData().size(); i++) {
            if (TextUtils.equals(this.mLogicView.getAdapterData().get(i).getPoiId(), xPPoiInfo.getPoiId())) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkIsVoiceData(XPPoiInfo xPPoiInfo) {
        if (!CollectionUtils.isNotEmpty(this.mList) || xPPoiInfo == null) {
            return false;
        }
        Iterator<XPPoiInfo> it = this.mList.iterator();
        while (it.hasNext()) {
            XPPoiInfo next = it.next();
            if (!TextUtils.isEmpty(next.getPoiId()) && !TextUtils.isEmpty(xPPoiInfo.getPoiId()) && next.getPoiId().equals(xPPoiInfo.getPoiId())) {
                return true;
            }
        }
        return false;
    }

    public boolean executeSpeechCmdInfoflowListStateChanged(SpeechNaviEvent speechNaviEvent) {
        if (canExecuteVoiceSearchFusionCommand()) {
            L.i(TAG, "SPEECH_INFOFLOW_LIST_STATE_CHANGED");
            if (speechNaviEvent.isExpand()) {
                this.mLogicView.hidePoiPop();
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean executeWhenInfoflowCardHeightChanged(SpeechNaviEvent speechNaviEvent) {
        if (canExecuteVoiceSearchFusionCommand()) {
            L.i(TAG, "SPEECH_INFOFLOW_CARD_HEIGHT_CHANGED");
            showMarkPreview(this.mAllMarkList, speechNaviEvent.getInfoflowCardHeight());
            return true;
        }
        return false;
    }

    public int getResultCount() {
        if (CollectionUtils.isNotEmpty(this.mList)) {
            return this.mList.size();
        }
        return 0;
    }

    public void onMainPathChanged() {
        if (L.ENABLE) {
            L.d(TAG, "onMainPathChanged");
        }
        if (isStartFromVoiceFusion()) {
            if (!this.mIsOnWayOfVF) {
                if (L.ENABLE) {
                    L.d(TAG, "exitCurrentSearch: current is not onway of voice fusion no need to exit");
                    return;
                }
                return;
            }
            VoiceFusionUtil.getInstance().noticeStopSpeechDialog();
        }
        exitCurrentSearch();
    }
}
