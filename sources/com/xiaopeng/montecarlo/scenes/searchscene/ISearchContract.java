package com.xiaopeng.montecarlo.scenes.searchscene;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public interface ISearchContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IMapLogicView<SearchPresenter> {
        void cacheResultData(SearchResultData searchResultData);

        boolean checkTvCompany();

        boolean checkTvHome();

        void cleanSearchAdapterData();

        void deleteFavorite(boolean z, int i, boolean z2);

        void deleteHistoryRecord(int i);

        void deleteHistoryRecords();

        void dismissLoadingDialog();

        BaseBridge getBaseBridge();

        int getFavoritePageNum();

        int getHistoryPageNum();

        String getSearchCarWash();

        String getSearchCategoryCharge();

        String[] getSearchCommonKeywords();

        String getSearchKeyword();

        void hideFavoriteView();

        void hideIme();

        void initFavoriteButton();

        void initListener();

        void initView();

        boolean isAmapCompanyConflict();

        boolean isAmapHomeConflict();

        boolean isChildScene();

        boolean isFavoritePaging();

        boolean isHistoryPaging();

        @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
        boolean isSceneVuiEnabled();

        void notifyItemChangedForCancelFav(int i);

        void onClickBack();

        void openSearchNormal();

        void registerEventBus();

        void resetFavoritePageState();

        void resetHistoryPageState();

        void retrySearch(XPPoiInfo xPPoiInfo);

        void setEtSearchText(String str);

        void setEtSearchTextWithoutChange(String str);

        void setHistoryLoadParentVisible(boolean z);

        void setIvClearVisible(boolean z);

        void setLastFavoriteVisile(boolean z, boolean z2);

        void setNoLastFavoriteVisile(boolean z, boolean z2);

        void setResult(RouteRequest routeRequest);

        void setResultBundleData(int i, XPPoiInfo xPPoiInfo);

        void setSearchAdapterData(ArrayList<XPPoiInfo> arrayList);

        void setSearchContainerByAnimOne();

        void setSearchContainerByAnimTwo();

        void setSearchHomeAndCompany(int i);

        void setSubContainerVisibleByFavorityType(boolean z);

        void setSubContainerVisibleByHistoryType(boolean z);

        void setSubContainerVisibleBySearchType(boolean z);

        void setTvAround(XPPoiInfo xPPoiInfo);

        void setTvScanSearch();

        void setWayPointHint();

        void showAddWayPointDialog(int i, XPPoiInfo xPPoiInfo);

        void showCancelFavoriteToast();

        void showFavoriteSyncConflictDialog();

        void showFavoriteView();

        void showHistoryListOrHistoryEmptyView();

        void showLeftView(boolean z);

        void showLoadingDialog();

        void showNoFavoriteDataToast();

        void showSecBindAMapDialog();

        void showSettingAlertWhenClick(int i);

        void showSettingAlertWhenSystemSuggest(int i);

        void showSettingCompanySuccess(boolean z);

        void showSettingHomeSuccess(boolean z);

        void showSwitchCityTip(XPPoiInfo xPPoiInfo);

        void startAnimOne(Runnable runnable);

        void startAnimTwo(Runnable runnable);

        void startExploreScene(RouteRequest routeRequest);

        void startNaviScene(RouteRequest routeRequest);

        void startRouteScene(RouteRequest routeRequest);

        void startScanSearchScene(PresenterData presenterData, int i);

        void startSearchResultScene(PresenterData presenterData, int i);

        void startSearchScene(PresenterData presenterData, int i);

        void unRegister();

        void unRegisterEventBus();

        void updateAdapter(SearchResponseEvent searchResponseEvent);

        void updateCompany(FavoriteAddress favoriteAddress);

        void updateCompanyText();

        void updateDefaultCompanyText();

        void updateDefaultHomeText();

        void updateEmptyCompanyText();

        void updateEmptyHistoryList();

        void updateEmptyHomeText();

        void updateFavSyncTimeView(long j);

        void updateFavoriteAdapter(List<FavoriteAddress> list, boolean z, boolean z2);

        void updateFavoriteButton();

        void updateForFavoriteItemClick(int i);

        void updateHistoryAdapter(List<HistoryRecordInfo> list, boolean z, boolean z2);

        void updateHome(FavoriteAddress favoriteAddress);

        void updateHomeText();

        void updateMatchedTips(ArrayList<XPPoiInfo> arrayList);

        void updateNextIcon(int i);

        void updatePoiDistance(boolean z, long j, long j2);

        void updateSearchTips(int i);

        void updateSugAdapter(List<HistoryRecordInfo> list);

        void updateTrafficBar(boolean z, ILightBarInfo iLightBarInfo, long j, long j2);
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
        void addNewNavi(XPPoiInfo xPPoiInfo);

        void addNewNaviByFavorite(FavoriteAddress favoriteAddress);

        void addWayPoint(XPPoiInfo xPPoiInfo);

        void addWayPointByFavorite(FavoriteAddress favoriteAddress);

        void clickByFavoriteItem(FavoriteAddress favoriteAddress);

        void deleteAllFavorites();

        void deleteFavorite(List<FavoriteAddress> list);

        void deleteHistoryRecord(HistoryRecordInfo historyRecordInfo, int i);

        void doAlertSettingHomeOrCompany();

        XPPoiInfo getAroundPoi();

        int getSearchMode();

        int getSearchModeView();

        void goBackForResult(FavoriteAddress favoriteAddress);

        void goToChildPoi(XPPoiInfo xPPoiInfo);

        void goToPoi(XPPoiInfo xPPoiInfo, List<XPPoiInfo> list);

        void gotoBySearchResult(XPPoiInfo xPPoiInfo);

        void gotoPoiByFavoriteItem(FavoriteAddress favoriteAddress);

        void historyRecordItemClick(HistoryRecordInfo historyRecordInfo);

        void initData(PresenterData presenterData);

        void onCreateView();

        void onViewCreate();

        void removeWayPoint(XPPoiInfo xPPoiInfo);

        void requestFavouriteList(int i);

        void requestHistoryList(int i);

        void requestNormalFavoriteCount();

        void resetHisRecordRequest();

        void setHomeCompany(FavoriteAddress favoriteAddress, int i);
    }
}
