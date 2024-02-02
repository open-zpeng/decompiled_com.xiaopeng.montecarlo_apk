package com.xiaopeng.montecarlo.scenes.searchscene;

import com.autonavi.gbl.map.model.PointD;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecoratorData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public interface ISearchResultContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IMapLogicView<SearchResultPresenter> {
        void dismissLoadingDialog();

        void executeAfterInfoflowScrollEnd(int i);

        void focusPosition(int i);

        int getActualFirstItemPosition();

        List<XPPoiInfo> getAdapterData();

        BaseBridge getBaseBridge();

        int getDisplayMetricsWidth();

        int getMarkWidth();

        int getMultiLayoutWidth();

        int getOfflineContainerHeight();

        String getParkKeyword();

        int getSearchPageTop();

        ArrayList<XPPoiInfo> getVisibleSubList();

        void hidePoiPop();

        void initAdapter();

        void initView();

        boolean isChildScene();

        boolean isCreate();

        boolean isPoiPopup();

        boolean isSceneVisible();

        boolean isScrolling();

        boolean isUpdateMark();

        void resetListItemVisiblePosition();

        void setAroundTitle(String str);

        void setCarWashTitle();

        void setFavoriteTitle();

        void setListCollapse();

        void setListCollapseForVoiceFusion();

        void setListExpand();

        void setMapLevel(int i);

        void setOfflineContainerVisible(boolean z);

        void setPoiToCenter(XPCoordinate2DDouble xPCoordinate2DDouble);

        void setRecyclerViewAutoPaging(boolean z);

        void setRecyclerViewLoadMore();

        void setRecyclerViewMaxCount(int i);

        void setResult(RouteRequest routeRequest);

        void setResultBundleData(int i, XPPoiInfo xPPoiInfo);

        void setScreenChargeTitle();

        void setTitle(String str);

        void showChargeFilter();

        void showChargeLoadingError();

        void showChargeNoResult();

        void showChargeSearchResult();

        void showLoadingDialog();

        void showPreview(ArrayList<PointD> arrayList, int i, int i2, int i3, int i4);

        int updateEmptyPoiLeftOffset();

        void updateFirstVisible(int i);

        void updateMapDecorator(DecoratorType decoratorType, SearchDecoratorData searchDecoratorData);

        void updateMultiPoi(List<XPPoiInfo> list);

        void updatePagePoi(List<XPPoiInfo> list);

        void updatePageSizeForVoiceFusion(int i);

        int updatePoiLeftOffset();

        void updateSelectItem(int i);

        void updateSinglePoi(XPPoiInfo xPPoiInfo);
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
        void addNewNavi(XPPoiInfo xPPoiInfo);

        void addWayPoint(XPPoiInfo xPPoiInfo);

        void exitCurrentSearch();

        void fetchDataForFusion(List<XPPoiInfo> list, int i);

        boolean getListExpandState();

        int getSearchDest();

        int getSearchMode();

        int getSearchModeView();

        void goToPoi(XPPoiInfo xPPoiInfo);

        void init(PresenterData presenterData);

        void loadMore();

        int processCurrentFreeBound();

        void processExpandState();

        void queryDetailInfo(XPPoiInfo xPPoiInfo);

        void removeWayPoint(XPPoiInfo xPPoiInfo);

        void setHomeOrCompany(XPPoiInfo xPPoiInfo, int i);

        void setListExpandState();

        void startUpdateMarkTask();
    }
}
