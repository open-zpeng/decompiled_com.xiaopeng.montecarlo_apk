package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.autonavi.gbl.common.model.RectInt;
import com.autonavi.gbl.map.model.PointD;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchResultBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecorator;
import com.xiaopeng.montecarlo.mapoverlay.search.SearchDecoratorData;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.VoiceFusionExitEvent;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract;
import com.xiaopeng.montecarlo.scenes.searchscene.PresenterData;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter;
import com.xiaopeng.montecarlo.stat.MapOpStatUtil;
import com.xiaopeng.montecarlo.stat.SearchResultStatUtil;
import com.xiaopeng.montecarlo.util.ActivityLifecycleHelper;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.PageRecyclerAdapter;
import com.xiaopeng.montecarlo.views.RouteChargePanelView;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.montecarlo.views.XpLinearLayoutManager;
import com.xiaopeng.montecarlo.views.dialog.XLandLoadingDialog;
import com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks;
import com.xiaopeng.montecarlo.views.poicard.PoiCardView;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes3.dex */
public class SearchResultFragment extends BaseMapScene implements ISearchResultContract.LogicView, SearchResultAdapter.SearchResultAdapterListener, ISceneMapFragmentListener {
    private static final int DEFAULT_NUM = 5;
    private static final L.Tag TAG = new L.Tag("SearchResultFragment");
    private SearchResultAdapter mAdapter;
    private Unbinder mButterBinder;
    @BindView(R.id.container_title)
    XView mContainerTitle;
    private XLandLoadingDialog mDialog;
    @BindView(R.id.search_charge_filter_container)
    View mFilterContainer;
    private boolean mIsPoiSelected;
    @BindView(R.id.iv_search_back)
    XImageButton mIvBack;
    @BindView(R.id.iv_clear)
    XImageButton mIvClear;
    @BindView(R.id.search_result_expand)
    XImageView mIvExpand;
    @BindView(R.id.search_result_inner_shadow)
    XImageView mIvInnerShadow;
    @BindView(R.id.iv_single_back)
    XImageButton mIvSingleBack;
    @BindView(R.id.iv_single_close)
    XImageButton mIvSingleClose;
    @BindView(R.id.multiple_layout)
    XConstraintLayout mMultipleLayout;
    @BindView(R.id.search_result_offline_container)
    ViewStub mOfflineContainer;
    private int mPoiLeftOffset;
    @BindView(R.id.keyword_search_result)
    XPRecyclerView mRecyclerView;
    private RouteChargePanelView mRouteChargePanelView;
    @BindView(R.id.route_charge_panel_stub)
    ViewStub mRouteChargeStub;
    private int mSearchMode;
    LinearLayout mSearchNoResultContainer;
    @BindView(R.id.search_no_result_container_sub)
    ViewStub mSearchNoResultContainerSub;
    XTextView mSearchNoResultContentTx;
    XImageView mSearchNoResultIcon;
    XTextView mSearchNoResultTitleTx;
    private int mSearchType;
    @BindView(R.id.container_search_result_panel)
    XLinearLayout mSingleLayout;
    @BindView(R.id.filter_free)
    XTextView mTvFilterFree;
    @BindView(R.id.filter_self_sale)
    XTextView mTvFilterSelfSale;
    @BindView(R.id.tv_search_radius)
    XTextView mTvRadius;
    @BindView(R.id.tv_search_result_radius)
    XTextView mTvRadiusSingle;
    @BindView(R.id.tv_search_content)
    XTextView mTvTitle;
    @BindView(R.id.tv_search_result_content)
    XTextView mTvTitleSingle;
    private SearchResultPresenter mPresenter = null;
    private View mRootView = null;
    private int mFirstItemPosition = -1;
    private int mLastItemPosition = -1;
    private int mItemSize = 0;
    private int mItemSizeBak = 0;
    private int mFirstItemPositionBak = -1;
    private int mLastItemPositionBak = -1;
    private boolean mIsCreate = false;
    private int mSelectIndex = -1;
    private int mStartFrom = 0;
    private boolean mIsOnWayOfVF = false;
    private int mExpandedIndex = -1;
    private boolean mIsScrolling = false;
    private boolean mIsShowPreView = false;
    private final RecyclerView.OnScrollListener mResultScrollListener = new RecyclerView.OnScrollListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                SearchResultFragment.this.mIsScrolling = false;
                SearchResultFragment.this.lambda$initView$0$SearchResultFragment();
                return;
            }
            SearchResultFragment.this.mIsScrolling = true;
        }
    };

    private void hideBottomAnchor() {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes
    public boolean isNeedMergeBaseMapViewForVui() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickOverView() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickRouteChargeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickZoomView(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onSceneMapFragmentResult(int i, Bundle bundle) {
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int updateEmptyPoiLeftOffset() {
        return 0;
    }

    public static SearchResultFragment newInstance() {
        return new SearchResultFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateDecorators */
    public void lambda$initView$0$SearchResultFragment() {
        int resultCount = this.mPresenter.getResultCount();
        L.Tag tag = TAG;
        L.d(tag, "updateDecorators start +++++ searchResultSize：" + resultCount);
        calculatePosition(this.mSelectIndex);
        if (resultCount == 0 || isSingleResult() || isUpdateMark()) {
            StateManager.getInstance().resetTimer();
            this.mPresenter.startUpdateMarkTask();
            SearchResultStatUtil.sendStatDataWhenBrowse(getPageType());
        }
        updateSearchResultForVui();
        L.d(TAG, "updateDecorators end +++++ ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(@Nullable Bundle bundle) {
        super.onSceneCreate(bundle);
        this.mIsCreate = true;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.fragment_search_result, (ViewGroup) null);
        this.mButterBinder = ButterKnife.bind(this, this.mRootView);
        return this.mRootView;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        initData(getBridge().getBundle());
        getMainContext().updateSRNaviSwitchStatus(8, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        SearchResultPresenter searchResultPresenter = this.mPresenter;
        if (searchResultPresenter != null) {
            searchResultPresenter.onResume();
        }
        getMainContext().updateRecenterShowTag(true);
        getMainContext().setSceneMapFragmentListener(this);
        if (this.mIsCreate) {
            this.mIsCreate = false;
            return;
        }
        XPRecyclerView xPRecyclerView = this.mRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.requestLayout();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public boolean isCreate() {
        return this.mIsCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        getMainContext().removeSceneMapFragmentListener(this);
        SearchResultPresenter searchResultPresenter = this.mPresenter;
        if (searchResultPresenter != null) {
            searchResultPresenter.onPause();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mSearchType = bundle.getInt(SearchBridge.SEARCH_TYPE_KEY);
        this.mSearchMode = bundle.getInt(SearchBridge.SEARCH_MODE);
        this.mStartFrom = bundle.getInt(SearchBridge.KEY_START_FROM);
        this.mIsOnWayOfVF = bundle.getBoolean(SearchBridge.KEY_IS_ONWAY_OF_VOICE_FUSION);
        int i = bundle.getInt(SearchBridge.SEARCH_MODE_VIEW);
        int i2 = bundle.getInt(SearchBridge.SEARCH_DEST_KEY, 1000);
        String string = bundle.getString(SearchBridge.SEARCH_FROM_KEY);
        ArrayList<XPPoiInfo> parcelableArrayList = bundle.getParcelableArrayList("search_result");
        Parcelable parcelable = bundle.getParcelable(SearchResultBridge.SEARCH_RESULT_SEARCH_PARAMS);
        int i3 = bundle.getInt(SearchBridge.SEARCH_RADIUS);
        PresenterData build = new PresenterData.Builder().searchMode(this.mSearchMode).searchDest(i2).searchType(this.mSearchType).searchFromKey(string).searchResult(parcelableArrayList).aroundPoi((XPPoiInfo) bundle.getParcelable(SearchBridge.SEARCH_AROUND_ITEM)).searchModeView(i).searchRadius(i3).searchResultFavoritePoi((XPPoiInfo) bundle.getParcelable(SearchResultBridge.SEARCH_RESULT_FAVORITE_POI)).searchResultSearchParams(parcelable).searchKeywordText(bundle.getString(SearchBridge.SEARCH_KEYWORD_TEXT)).startFrom(this.mStartFrom).isOnWayOfVoiceFusion(this.mIsOnWayOfVF).previousSceneMode(bundle.getInt(SearchBridge.PREVIOUS_SCENE_MODE)).build();
        SearchResultPresenter searchResultPresenter = this.mPresenter;
        if (searchResultPresenter != null) {
            searchResultPresenter.init(build);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void initView() {
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new XpLinearLayoutManager((Context) getActivity(), 1, false, new XpLinearLayoutManager.XpLinearLayoutManagerListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.-$$Lambda$SearchResultFragment$Q8a6puMNE6hamz8hNnpm6PTbW8Q
            @Override // com.xiaopeng.montecarlo.views.XpLinearLayoutManager.XpLinearLayoutManagerListener
            public final void onLayoutCompleted() {
                SearchResultFragment.this.lambda$initView$0$SearchResultFragment();
            }
        }));
        ((DefaultItemAnimator) this.mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.mRecyclerView.setOnXpScrollListener(this.mResultScrollListener);
        this.mRecyclerView.setMaxCount(50);
        this.mRecyclerView.setPageSize(20);
        XPRecyclerView xPRecyclerView = this.mRecyclerView;
        xPRecyclerView.setScrollViewCallbacks(new XPObservableScrollViewCallbacks(xPRecyclerView));
        initPoiLeftOffset();
        renderLayoutByDayNightStatus();
    }

    private void updateSearchResultForVui() {
        if (isSceneVuiEnabled() && isSceneLegal()) {
            if (L.ENABLE) {
                L.d(TAG, L.formatVoiceFullScenesLog("updateSearchResultForVui"));
            }
            SearchResultVuiHelper.getInstance().updateSearchResultVui(this.mRecyclerView, this, this.mPresenter.getSearchDest());
        }
    }

    private void initPoiLeftOffset() {
        this.mPoiLeftOffset = ContextUtils.getDimensionPixelSize(R.dimen.search_result_title_width) + ContextUtils.getDimensionPixelSize(R.dimen.search_box_margin_left);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void initAdapter() {
        this.mRecyclerView.setVisibility(!isStartFromVoiceFusion() ? 0 : 4);
        this.mAdapter = new SearchResultAdapter(getActivity(), this.mRecyclerView, this.mPresenter.getSearchDest(), this.mPresenter.getSearchMode(), this.mPresenter.getSearchModeView());
        this.mAdapter.setSearchResultAdapterListener(this);
        this.mRecyclerView.setAdapter((PageRecyclerAdapter) this.mAdapter);
        if (this.mSearchType == 2) {
            this.mAdapter.setDataFusionCallback(new XPRecyclerView.DataFusionCallback<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment.2
                @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.DataFusionCallback
                public void fetch(List<XPPoiInfo> list) {
                    SearchResultFragment.this.mPresenter.fetchDataForFusion(list, SearchResultFragment.this.mSearchType);
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setListExpand() {
        this.mMultipleLayout.setVisibility(0);
        this.mRecyclerView.setVisibility(0);
        this.mSingleLayout.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setListCollapse() {
        this.mMultipleLayout.setVisibility(8);
        this.mRecyclerView.setVisibility(8);
        this.mSingleLayout.setVisibility(0);
        if (isSingleResult()) {
            this.mIvSingleBack.setVisibility(0);
            this.mIvExpand.setVisibility(8);
            return;
        }
        this.mIvSingleBack.setVisibility(8);
        this.mIvExpand.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setListCollapseForVoiceFusion() {
        this.mMultipleLayout.setVisibility(4);
        if (Utils.isLandscape()) {
            this.mSingleLayout.setVisibility(8);
        } else if (isPoiPopup()) {
            this.mIvExpand.setVisibility(8);
            this.mIvSingleBack.setVisibility(0);
            this.mIvSingleClose.setVisibility(8);
            this.mSingleLayout.setVisibility(0);
        } else {
            this.mSingleLayout.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public ArrayList<XPPoiInfo> getVisibleSubList() {
        if (getAdapterData() == null) {
            return null;
        }
        int actualPosition = this.mAdapter.getActualPosition(this.mFirstItemPosition);
        int actualPosition2 = this.mAdapter.getActualPosition(this.mLastItemPosition);
        int size = getAdapterData().size();
        if (actualPosition < 0 || actualPosition > actualPosition2 || actualPosition2 >= size) {
            return null;
        }
        return new ArrayList<>(getAdapterData().subList(actualPosition, actualPosition2 + 1));
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        if (this.mPresenter.isStartFromVoiceFusion() && Utils.isPortrait()) {
            VoiceFusionUtil.getInstance().sendPoiListFoldUIEvent(Utils.getPackageName(ContextUtils.getContext()));
        }
        this.mRecyclerView.setOnXpScrollListener(null);
        Unbinder unbinder = this.mButterBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (getMainContext().getCurrentScene().getMode() != StatusConst.Mode.EXPLORE) {
            getMapView().exitPreview(false, false);
        } else {
            getMapView().exitPreviewImplicit();
        }
        this.mIsShowPreView = false;
        getMapView().restoreCarPosition();
        if (this.mAdapter != null) {
            this.mAdapter = null;
        }
        RouteChargePanelView routeChargePanelView = this.mRouteChargePanelView;
        if (routeChargePanelView != null) {
            routeChargePanelView.setListener(null);
        }
        if (VoiceFusionUtil.getInstance().isVoiceFusionSupported() && isStartFromVoiceFusion()) {
            L.i(TAG, "onSceneDestroyView notice voice fusion exit");
            EventBus.getDefault().post(new VoiceFusionExitEvent());
        }
        SearchResultVuiHelper.getInstance().release();
        SearchResultStatUtil.sendStatDataWhenExit(getPageType());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setResult(RouteRequest routeRequest) {
        setReturnResult(routeRequest.toBundle());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setResultBundleData(int i, XPPoiInfo xPPoiInfo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SearchBridge.SET_RESULT_OBJECT, xPPoiInfo);
        bundle.putInt(SearchBridge.SEARCH_DEST_KEY, i);
        setReturnResult(bundle);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setAroundTitle(String str) {
        this.mTvTitle.setText(str);
        this.mTvTitleSingle.setText(str);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setScreenChargeTitle() {
        if (isSceneLegal()) {
            this.mTvTitle.setText(R.string.charge_panel_result_title);
            this.mTvTitleSingle.setText(R.string.charge_panel_result_title);
            int searchRadius = this.mPresenter.getSearchRadius();
            if (searchRadius > 0) {
                String replaceAll = NaviUtil.getDistanceString(searchRadius).replaceAll(" ", "");
                this.mTvRadius.setVisibility(0);
                this.mTvRadius.setText(replaceAll);
                this.mTvRadiusSingle.setVisibility(0);
                this.mTvRadiusSingle.setText(replaceAll);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setTitle(String str) {
        if (isSceneLegal()) {
            this.mTvTitle.setText(str);
            this.mTvTitleSingle.setText(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setFavoriteTitle() {
        if (isSceneLegal()) {
            this.mTvTitle.setText(R.string.search_category_favorite);
            this.mTvTitleSingle.setText(R.string.search_category_favorite);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setCarWashTitle() {
        if (isSceneLegal()) {
            this.mTvTitle.setText(R.string.search_category_carwash);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setRecyclerViewAutoPaging(boolean z) {
        this.mRecyclerView.setAutoPaging(z);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setRecyclerViewMaxCount(int i) {
        this.mRecyclerView.setMaxCount(i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setRecyclerViewLoadMore() {
        this.mRecyclerView.setLoadMoreCallback(new XPRecyclerView.LoadMoreCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment.3
            @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.LoadMoreCallback
            public void onLoadMore() {
                SearchResultFragment.this.mPresenter.loadMore();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void updatePagePoi(List<XPPoiInfo> list) {
        SearchResultAdapter searchResultAdapter = this.mAdapter;
        if (searchResultAdapter == null) {
            return;
        }
        searchResultAdapter.addData(list, true);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int updatePoiLeftOffset() {
        SearchResultAdapter searchResultAdapter = this.mAdapter;
        if (searchResultAdapter == null || searchResultAdapter.getItemCount() <= 1) {
            return 0;
        }
        this.mPoiLeftOffset = Utils.getViewRightInWindow(this.mRecyclerView);
        return this.mPoiLeftOffset;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void updateSelectItem(int i) {
        SearchResultAdapter searchResultAdapter = this.mAdapter;
        if (searchResultAdapter != null) {
            searchResultAdapter.updateSelectItem(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void updateMapDecorator(DecoratorType decoratorType, SearchDecoratorData searchDecoratorData) {
        Bundle bundle = new Bundle();
        bundle.putInt(SearchDecorator.KEY_SEARCH_TYPE, this.mPresenter.getSearchMode());
        if (searchDecoratorData.getFirstVisibleItemPposition() != -1) {
            bundle.putInt(SearchDecorator.KEY_FIRST_VISIBLE_ITEM_POSITION, searchDecoratorData.getFirstVisibleItemPposition());
        }
        if (searchDecoratorData.getFavoritePoi() != null) {
            bundle.putParcelable(BaseMapDecorator.KEY_FAVORITE_POI, searchDecoratorData.getFavoritePoi());
        }
        if (searchDecoratorData.getPoiList() != null) {
            bundle.putParcelableArrayList(BaseMapDecorator.KEY_POI_LIST, searchDecoratorData.getPoiList());
        }
        int i = this.mLastItemPosition;
        if (i != -1) {
            bundle.putInt(SearchDecorator.KEY_LAST_VISIBLE_ITEM_POSITION, i);
        }
        bundle.putBoolean(SearchDecorator.KEY_IS_PORTRAIT_VOICE_FUSION, this.mPresenter.isStartFromVoiceFusion() && Utils.isPortrait());
        getMainContext().getDecoratorManager().showMapDecorator(this, decoratorType, bundle);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public String getParkKeyword() {
        return getString(R.string.search_category_park);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int getDisplayMetricsWidth() {
        return RootUtil.getScreenWidth();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int getSearchPageTop() {
        return getResources().getDimensionPixelSize(R.dimen.poi_pop_height);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int getMarkWidth() {
        return ContextUtils.getDimensionPixelSize(R.dimen.search_result_realbutton_poi_width);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setPoiToCenter(XPCoordinate2DDouble xPCoordinate2DDouble) {
        getMapView().setPoiToCenter(xPCoordinate2DDouble);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void showPreview(ArrayList<PointD> arrayList, int i, int i2, int i3, int i4) {
        if (this.mIsShowPreView) {
            getMapView().exitPreviewImplicit();
        } else {
            this.mIsShowPreView = true;
        }
        getMapView().showPreview(arrayList, i, i2, i3, i4);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setMapLevel(int i) {
        getMapView().setMapLevel(i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public boolean isSceneVisible() {
        return isVisible();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int getMultiLayoutWidth() {
        XConstraintLayout xConstraintLayout = this.mMultipleLayout;
        if (xConstraintLayout == null) {
            return 0;
        }
        return xConstraintLayout.getWidth();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void updateSinglePoi(XPPoiInfo xPPoiInfo) {
        this.mIvSingleBack.setVisibility(0);
        this.mIvExpand.setVisibility(8);
        this.mMultipleLayout.setVisibility(8);
        this.mSingleLayout.setVisibility(0);
        lambda$initView$0$SearchResultFragment();
        if (!Utils.isPortrait() || !this.mPresenter.isStartFromVoiceFusion()) {
            getMainContext().getDecoratorManager().focus(this, DecoratorType.SEARCH, xPPoiInfo);
        }
        MapUIStatus uIStatus = getUIStatus();
        uIStatus.mMapRenderModeVisibility = 8;
        uIStatus.mOverViewVisibility = 8;
        getMapView().setMapMode(0);
        updateUIStatus(uIStatus);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void updateMultiPoi(List<XPPoiInfo> list) {
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("updateMultiPoi list.size = ");
        sb.append(list == null ? 0 : list.size());
        L.d(tag, sb.toString());
        if (isSceneLegal()) {
            this.mMultipleLayout.setVisibility(0);
            this.mSingleLayout.setVisibility(8);
            if (CollectionUtils.isNotEmpty(list)) {
                this.mAdapter.setData(list);
            } else {
                this.mAdapter.setData(new ArrayList());
            }
            MapUIStatus uIStatus = getUIStatus();
            uIStatus.mMapRenderModeVisibility = 8;
            uIStatus.mOverViewVisibility = 8;
            getMapView().setMapMode(0);
            updateUIStatus(uIStatus);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public BaseBridge getBaseBridge() {
        return getBridge();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public SearchResultPresenter mo116getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(SearchResultPresenter searchResultPresenter) {
        this.mPresenter = searchResultPresenter;
    }

    @OnClick({R.id.filter_self_sale, R.id.filter_free})
    public void onClickChargeFilter(View view) {
        boolean isSelected = this.mTvFilterFree.isSelected();
        boolean isSelected2 = this.mTvFilterSelfSale.isSelected();
        if (view.getId() == R.id.filter_free) {
            isSelected = !isSelected;
            this.mTvFilterFree.setSelected(isSelected);
            if (isSelected) {
                SearchResultStatUtil.sendStatDataWhenSelectFilterFree(getPageType());
            }
        } else if (view.getId() == R.id.filter_self_sale) {
            isSelected2 = !isSelected2;
            this.mTvFilterSelfSale.setSelected(isSelected2);
            if (isSelected2) {
                SearchResultStatUtil.sendStatDataWhenSelectFilterSelfSale(getPageType());
            }
        }
        this.mRecyclerView.stopScroll();
        this.mPresenter.queryChargeStation(isSelected2, isSelected);
    }

    @OnClick({R.id.iv_search_back})
    public void onClickBack() {
        SearchResultStatUtil.sendStatDataWhenBackClick(getPageType());
        exitScene();
    }

    @OnClick({R.id.iv_single_back})
    public void onClickBackBySingle() {
        SearchResultStatUtil.sendStatDataWhenBackClick(getPageType());
        if (canExitScene()) {
            exitScene();
        }
    }

    @OnClick({R.id.tv_search_result_content, R.id.tv_search_result_radius})
    public void onTitleClickBySingle() {
        XImageView xImageView = this.mIvExpand;
        if (xImageView != null && xImageView.getVisibility() == 0) {
            hideSceneTrafficEventPop();
            performClickExpand();
        } else if (canExitScene()) {
            exitScene();
        }
    }

    @OnClick({R.id.container_title})
    public void onTitleContainerClick() {
        exitScene();
    }

    @OnClick({R.id.iv_clear})
    public void onClickClose() {
        SearchResultStatUtil.sendStatDataWhenExitClick(getPageType());
        this.mPresenter.exitCurrentSearch();
    }

    @OnClick({R.id.iv_single_close})
    public void onClickCloseBySingle() {
        SearchResultStatUtil.sendStatDataWhenExitClick(getPageType());
        if (canExitScene()) {
            this.mPresenter.exitCurrentSearch();
        }
    }

    @OnClick({R.id.search_result_expand})
    public void onClickExpand() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onClickExpand mPresenter.getListExpandState() = " + this.mPresenter.getListExpandState());
        }
        hideSceneTrafficEventPop();
        performClickExpand();
    }

    @OnClick({R.id.search_result_fold})
    public void onClickFold() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onClickFold mPresenter.getListExpandState() = " + this.mPresenter.getListExpandState());
        }
        performClickExpand();
    }

    private boolean canExitScene() {
        if (Utils.isPortrait() && isStartFromVoiceFusion()) {
            if (L.ENABLE) {
                L.d(TAG, "canExitScene no, notice poi list expand");
            }
            hidePoiPop();
            return false;
        }
        return true;
    }

    private void performClickExpand() {
        if (isPoiPopup()) {
            hidePoiPop();
        } else {
            exchangeExpandState();
        }
    }

    private void exchangeExpandState() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "exchangeExpandState mPresenter.getListExpandState() = " + this.mPresenter.getListExpandState());
        }
        this.mPresenter.setListExpandState();
        this.mPresenter.processExpandState();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onItemClick(int i) {
        focusPosition(i);
        SearchResultStatUtil.sendStatDataWhenItemClick(getPageType());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void focusPosition(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "focusPosition position:" + i + ",mFirstItemPosition:" + this.mFirstItemPosition);
        }
        XPPoiInfo xPPoiInfo = null;
        if (Utils.isPortrait() && isSingleResult() && this.mPresenter.isStartFromVoiceFusion()) {
            if (CollectionUtils.isNotEmpty(this.mPresenter.mList)) {
                xPPoiInfo = this.mPresenter.mList.get(i);
            }
        } else {
            xPPoiInfo = getAdapterItem(i);
        }
        if (xPPoiInfo == null) {
            L.w(TAG, "focusPosition error poi info is null");
            return;
        }
        this.mExpandedIndex = i + 1;
        showSearchPoint(xPPoiInfo);
        if (this.mIsPoiSelected) {
            MapOpStatUtil.sendStatDataWhenMapClick(getMainContext(), 20001, 1, xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void hidePoiPop() {
        getMainContext().getDecoratorManager().clearFocus(this);
    }

    private XPPoiInfo getAdapterItem(int i) {
        if (getAdapterData() == null || i >= getAdapterData().size()) {
            return null;
        }
        return getAdapterData().get(i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onGoToPoiClick(int i) {
        XPPoiInfo adapterItem = getAdapterItem(i);
        if (adapterItem != null) {
            SearchResultStatUtil.sendStatDataWhenNaviClick(getPageType(), adapterItem);
            this.mPresenter.goToPoi(adapterItem);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onAddWayClick(int i) {
        XPPoiInfo adapterItem = getAdapterItem(i);
        if (adapterItem != null) {
            this.mPresenter.addWayPoint(adapterItem);
            SearchResultStatUtil.sendStatDataWhenAddWayClick(getPageType(), adapterItem);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onRemoveWayClick(int i) {
        XPPoiInfo adapterItem = getAdapterItem(i);
        this.mPresenter.removeWayPoint(adapterItem);
        SearchResultStatUtil.sendStatDataWhenRemoveWayClick(getPageType(), adapterItem);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onAddNewNaviClick(int i) {
        XPPoiInfo adapterItem = getAdapterItem(i);
        if (adapterItem != null) {
            this.mPresenter.addNewNavi(adapterItem);
            SearchResultStatUtil.sendStatDataWhenNaviClick(getPageType(), adapterItem);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onSetCompanyClick(int i) {
        XPPoiInfo adapterItem = getAdapterItem(i);
        if (adapterItem != null) {
            this.mPresenter.setHomeOrCompany(adapterItem, 1002);
            SearchResultStatUtil.sendStatDataWhenSetCompanyClick(getPageType(), adapterItem);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onSetHomeClick(int i) {
        XPPoiInfo adapterItem = getAdapterItem(i);
        if (adapterItem != null) {
            this.mPresenter.setHomeOrCompany(adapterItem, 1001);
            SearchResultStatUtil.sendStatDataWhenSetHomeClick(getPageType(), adapterItem);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.SearchResultAdapterListener
    public void onChildPoiClick(int i, int i2) {
        XPPoiInfo adapterItem = getAdapterItem(i);
        if (adapterItem == null || adapterItem.getChild() == null || i2 >= adapterItem.getChild().size()) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "onChildPoiClick parentPosition:" + i + ",childPosition = " + i2);
        this.mMainContext.getDecoratorManager().focusByPriority(this, adapterItem.getChild().get(i2), new DecoratorType[0]);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiShow(PoiCardView poiCardView) {
        XPViaPoint xPViaPoint;
        int i;
        L.i(TAG, "onPoiShow type:");
        if (isSceneLegal()) {
            if (isMultipleSearchResult() && this.mPresenter.getListExpandState()) {
                exchangeExpandState();
            }
            if (isStartFromVoiceFusion()) {
                setListCollapseForVoiceFusion();
            }
            if (DecoratorType.SEARCH == poiCardView.getDecoratorType()) {
                this.mSelectIndex = this.mPresenter.findIndex(poiCardView.getPoiInfo());
                updateSelectItem(this.mSelectIndex);
                this.mIsPoiSelected = true;
                if (isMultipleSearchResult() && (isUnVisibleItem(this.mSelectIndex) || (i = this.mSelectIndex) == this.mFirstItemPosition || i == this.mLastItemPosition)) {
                    lambda$initView$0$SearchResultFragment();
                }
            } else if (DecoratorType.WAY_POINT == poiCardView.getDecoratorType()) {
                int currentExpandedIndex = poiCardView.getMapDecorator().getCurrentExpandedIndex();
                List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
                if (currentExpandedIndex > -1 && currentExpandedIndex < viaInfos.size() && (xPViaPoint = viaInfos.get(currentExpandedIndex)) != null && xPViaPoint.getViaType() == 4) {
                    showRouteChargeCard(xPViaPoint, currentExpandedIndex);
                    return;
                }
            }
            hideRouteChargeCard();
            if (this.mPresenter.isStartFromVoiceFusion()) {
                if (this.mPresenter.checkIsVoiceData(poiCardView.getPoiInfo())) {
                    this.mExpandedIndex = this.mSelectIndex + 1;
                    VoiceFusionUtil.getInstance().sendGUIEventWhenItemFocused(this.mExpandedIndex, Utils.getPackageName(ContextUtils.getContext()));
                }
                if (Utils.isPortrait()) {
                    VoiceFusionUtil.getInstance().sendPoiListFoldUIEvent(Utils.getPackageName(ContextUtils.getContext()));
                }
            }
            super.onPoiShow(poiCardView);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.views.poicard.PoiCardHelper.PoiCardManagerCallback
    public void onPoiHide(PoiCardView poiCardView) {
        RouteChargePanelView routeChargePanelView;
        L.Tag tag = TAG;
        L.i(tag, "onPoiHide poiPop:" + poiCardView + ",mExpandedIndex:" + this.mExpandedIndex);
        if (isSceneLegal()) {
            super.onPoiHide(poiCardView);
            if (getActivity() == null) {
                return;
            }
            if (isMultipleSearchResult() && !this.mPresenter.getListExpandState() && !poiCardView.getMapDecorator().isHideByChange() && ((routeChargePanelView = this.mRouteChargePanelView) == null || routeChargePanelView.getVisibility() != 0)) {
                exchangeExpandState();
            }
            if (isStartFromVoiceFusion()) {
                VoiceFusionUtil.getInstance().sendGUIEventWhenItemunFocused(this.mExpandedIndex, Utils.getPackageName(ContextUtils.getContext()));
                if (Utils.isPortrait()) {
                    VoiceFusionUtil.getInstance().sendPoiListExpandUIEvent(Utils.getPackageName(ContextUtils.getContext()));
                }
            }
            this.mIsPoiSelected = false;
            this.mSelectIndex = -1;
            this.mExpandedIndex = -1;
            updateSelectItem(this.mSelectIndex);
        }
    }

    private void showSearchPoint(XPPoiInfo xPPoiInfo) {
        getMainContext().getDecoratorManager().focus(this, DecoratorType.SEARCH, xPPoiInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public RectInt getCurrentFreeBound() {
        if (Utils.isPortrait()) {
            if (isStartFromVoiceFusion()) {
                this.mFreeBound.top = 0;
            }
        } else if (Utils.isLandscape()) {
            if (isSingleResult()) {
                this.mFreeBound.top = this.mSingleLayout.getBottom() - ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_bg_margin);
            } else {
                this.mFreeBound.top = this.mContainerTitle.getBottom();
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getCurrentFreeBound bound:" + this.mFreeBound);
        }
        return this.mFreeBound;
    }

    private void calculatePosition(int i) {
        L.Tag tag = TAG;
        L.d(tag, "calculatePosition index = " + i);
        if (this.mRecyclerView != null && CollectionUtils.isNotEmpty(getAdapterData())) {
            this.mItemSize = this.mAdapter.getXpItemCount();
            L.Tag tag2 = TAG;
            L.d(tag2, "mItemSize = " + this.mItemSize);
            if (i == -1 || this.mPresenter.getListExpandState()) {
                XpLinearLayoutManager xpLinearLayoutManager = (XpLinearLayoutManager) this.mRecyclerView.getLayoutManager();
                if (xpLinearLayoutManager != null) {
                    this.mFirstItemPosition = xpLinearLayoutManager.findFirstVisibleItemPosition();
                    this.mLastItemPosition = xpLinearLayoutManager.findLastVisibleItemPosition();
                    L.Tag tag3 = TAG;
                    L.d(tag3, "calculatePosition mFirstItemPosition = " + this.mFirstItemPosition + ", mLastItemPosition = " + this.mLastItemPosition);
                }
            } else {
                this.mFirstItemPosition = i;
                if (this.mFirstItemPosition == this.mAdapter.getXpItemCount() - 1) {
                    this.mFirstItemPosition = (this.mAdapter.getXpItemCount() - 1) - 2;
                }
                this.mLastItemPosition = this.mFirstItemPosition + 5;
                if (this.mLastItemPosition >= this.mAdapter.getXpItemCount()) {
                    this.mLastItemPosition = this.mAdapter.getXpItemCount() - 1;
                }
                updateFirstVisible(this.mFirstItemPosition);
            }
        }
        L.Tag tag4 = TAG;
        L.d(tag4, "mFirstItemPosition = " + this.mFirstItemPosition + ", mLastItemPosition = " + this.mLastItemPosition);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void resetListItemVisiblePosition() {
        this.mFirstItemPosition = -1;
        this.mLastItemPosition = -1;
        this.mFirstItemPositionBak = -1;
        this.mLastItemPositionBak = -1;
    }

    private void exitScene() {
        if (L.ENABLE) {
            L.d(TAG, "exitScene");
        }
        goBack();
        this.mPresenter.stopSpeechDialog();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchMode() {
        return this.mPresenter.getSearchMode();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchDest() {
        return this.mPresenter.getSearchDest();
    }

    private void changeScrollBarStyle() {
        Utils.changeScrollBarStyle(getActivity(), this.mRecyclerView);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return this.mPresenter.getPageType();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isShowFavorite() {
        return (isPreScene(StatusConst.Mode.ROUTE, true) || isPreScene(StatusConst.Mode.NAVI, true) || isPreScene(StatusConst.Mode.EXPLORE, true)) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void setOfflineContainerVisible(boolean z) {
        this.mOfflineContainer.setVisibility(z ? 0 : 8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int getOfflineContainerHeight() {
        return this.mOfflineContainer.getMeasuredHeight();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public int getActualFirstItemPosition() {
        SearchResultAdapter searchResultAdapter = this.mAdapter;
        if (searchResultAdapter == null) {
            return 0;
        }
        return searchResultAdapter.getActualPosition(this.mFirstItemPosition);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public boolean isUpdateMark() {
        if (this.mRecyclerView == null || this.mAdapter == null || this.mFirstItemPosition == -1 || this.mLastItemPosition == -1) {
            return false;
        }
        if (hasItemMove() || this.mPresenter.isStartFromVoiceFusion()) {
            L.d(TAG, "hasItemMove = true");
            this.mFirstItemPositionBak = this.mFirstItemPosition;
            this.mLastItemPositionBak = this.mLastItemPosition;
            this.mItemSizeBak = this.mItemSize;
            return true;
        }
        L.d(TAG, "hasItemMove = false");
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        if (100 != i) {
            if (1000 == i) {
                exitSearchWhenVoiceRouteExit();
            }
        } else if (bundle != null) {
            this.mPresenter.gotoPoi((RouteRequest) bundle.getParcelable(RouteBridge.ROUTE_REQUEST));
        }
    }

    private void exitSearchWhenVoiceRouteExit() {
        L.i(TAG, "onBackResult REQUEST_CODE_ROUTE_BY_SPEECH");
        goBack();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public List<XPPoiInfo> getAdapterData() {
        SearchResultAdapter searchResultAdapter = this.mAdapter;
        if (searchResultAdapter == null) {
            return null;
        }
        return searchResultAdapter.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        renderLayoutByDayNightStatus();
    }

    private void renderLayoutByDayNightStatus() {
        XPRecyclerView xPRecyclerView = this.mRecyclerView;
        if (xPRecyclerView != null && this.mAdapter != null) {
            xPRecyclerView.updateAdapterAndRefreshCache();
            changeScrollBarStyle();
            this.mPresenter.processExpandState();
        }
        if (!ActivityLifecycleHelper.getInstance().isInterestingActivityVisible() || !this.mIsPoiSelected || getPoiCard() == null || getPoiCard().getPoiInfo() == null) {
            return;
        }
        MapOpStatUtil.sendStatDataWhenMapClick(getMainContext(), 20001, 1, getPoiCard().getPoiInfo().getDisplayLon(), getPoiCard().getPoiInfo().getDisplayLat());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneStop() {
        super.onSceneStop();
        SearchResultStatUtil.sendStatDataWhenGotoBackground(getPageType());
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopShow(View view, double d, double d2) {
        if (isSceneLegal()) {
            super.onTrafficEventPopShow(view, d, d2);
            if (this.mPresenter.getListExpandState()) {
                performClickExpand();
            }
            if (this.mPresenter.isStartFromVoiceFusion() && Utils.isPortrait()) {
                VoiceFusionUtil.getInstance().sendPoiListFoldUIEvent(Utils.getPackageName(ContextUtils.getContext()));
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.trafficevent.TrafficEventHelper.ITrafficEventCallback
    public void onTrafficEventPopHide(View view) {
        super.onTrafficEventPopHide(view);
        if (isStartFromVoiceFusion() && Utils.isPortrait()) {
            VoiceFusionUtil.getInstance().sendPoiListExpandUIEvent(Utils.getPackageName(ContextUtils.getContext()));
        }
    }

    private boolean hasItemMove() {
        return (this.mFirstItemPositionBak == this.mFirstItemPosition && this.mLastItemPositionBak == this.mLastItemPosition && this.mItemSize == this.mItemSizeBak) ? false : true;
    }

    public XPPoiInfo getSingleResult() {
        return this.mPresenter.getSingleResult();
    }

    public boolean isSingleResult() {
        return this.mPresenter.isSingleResult();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSearchResultFragSinglePoi(XPPoiInfo xPPoiInfo) {
        XPPoiInfo singleResult = getSingleResult();
        return (xPPoiInfo == null || singleResult == null || !singleResult.getPoiId().equals(xPPoiInfo.getPoiId())) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isMultipleSearchResult() {
        return !isSingleResult();
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public boolean onClickRecenter() {
        if (isSceneLegal()) {
            if (getMapView().isPreview()) {
                getMapView().exitPreview(false, true);
                this.mIsShowPreView = false;
            }
            getMapView().goBackCenterAndRestoreCarPosition(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHaveMoreDataDecorator(boolean z) {
        XImageView xImageView = this.mIvInnerShadow;
        if (xImageView != null) {
            xImageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public boolean isScrolling() {
        return this.mIsScrolling;
    }

    public boolean isStartFromVoiceFusion() {
        return this.mPresenter.isStartFromVoiceFusion() && VoiceFusionUtil.getInstance().isVoiceFusionSupported();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void updatePageSizeForVoiceFusion(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updatePageSizeForVoiceFusion pageSize:" + i);
        }
        if (isSceneLegal()) {
            this.mRecyclerView.setPageSize(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void updateFirstVisible(int i) {
        LinearLayoutManager linearLayoutManager;
        L.d(TAG, "updateFirstVisible");
        if (i == -1 || !isSceneLegal() || (linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager()) == null) {
            return;
        }
        TopSmoothScroller topSmoothScroller = new TopSmoothScroller(getActivity());
        topSmoothScroller.setTargetPosition(i);
        linearLayoutManager.startSmoothScroll(topSmoothScroller);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void executeAfterInfoflowScrollEnd(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "executeAfterInfoflowScrollEnd firstVisibleIndex:" + i + ",mExpandedIndex:" + this.mExpandedIndex);
        }
        if (checkIsScrollIllegal(i)) {
            return;
        }
        hidePoiPop();
        updateFirstVisible(i - 1);
    }

    private boolean checkIsScrollIllegal(int i) {
        if (i <= 0) {
            L.Tag tag = TAG;
            L.w(tag, "executeAfterInfoflowScrollEnd failure index <= 0,index:" + i);
            return true;
        } else if (i == this.mExpandedIndex) {
            L.Tag tag2 = TAG;
            L.w(tag2, "executeAfterInfoflowScrollEnd failure index == mExpandedIndex,index:" + i + ",mExpandedIndex:" + this.mExpandedIndex);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public boolean isPoiPopup() {
        return isPoiCardShowing();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiEnabled() {
        return CommonVuiHelper.getInstance().isSceneVuiSupport();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onBuildScene() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        String string = ContextUtils.getString(R.string.vui_general_action_system_close_return);
        MainContext mainContext = getMainContext();
        XImageButton xImageButton = this.mIvBack;
        commonVuiHelper.markGeneralAction(string, mainContext, xImageButton, xImageButton, false);
        super.onBuildScene();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onInterceptVuiEvent view:" + view + ",vuiEvent:" + vuiEvent + ",element:" + vuiEvent.getHitVuiElement()));
        }
        if (view.getId() == R.id.iv_search_back) {
            VoiceFullScenesUtil.showVuiAnimation(view);
            if (this.mPresenter.isSingleResult()) {
                onClickBack();
                return true;
            } else if (this.mPresenter.getListExpandState()) {
                onClickBack();
                return true;
            } else {
                onClickExpand();
                return true;
            }
        }
        return super.onInterceptVuiEvent(view, vuiEvent);
    }

    public boolean isUnVisibleItem(int i) {
        int i2;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isUnVisibleItem index:" + i + ",mFirstItemPosition:" + this.mFirstItemPosition + ",mLastItemPosition:" + this.mLastItemPosition);
        }
        if (isSingleResult() && Utils.isPortrait() && this.mPresenter.isStartFromVoiceFusion()) {
            return false;
        }
        return i == -1 || (i2 = this.mFirstItemPosition) == -1 || i < i2 || i > this.mLastItemPosition;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public void onClickBlank(long j, float f, float f2) {
        super.onClickBlank(j, f, f2);
        hideRouteChargeCard();
        clearOverlayElemAllFocus();
    }

    private RouteChargePanelView getRouteChargeCard() {
        if (this.mRouteChargePanelView == null && this.mRouteChargeStub.getParent() != null) {
            try {
                this.mRouteChargeStub.inflate();
                this.mRouteChargePanelView = (RouteChargePanelView) this.mRootView.findViewById(R.id.route_charge_panel);
                this.mRouteChargePanelView.setChargeBarVisible(false);
                this.mRouteChargePanelView.setListener(this.mPresenter);
            } catch (IllegalArgumentException | IllegalStateException unused) {
                L.e(TAG, "inflate route charge panel view err");
            }
        }
        return this.mRouteChargePanelView;
    }

    private void showRouteChargeCard(XPViaPoint xPViaPoint, int i) {
        if (!isSceneLegal() || xPViaPoint == null || xPViaPoint.getPoiPoint() == null || getRouteChargeCard() == null) {
            return;
        }
        XPPoiInfo poiPoint = xPViaPoint.getPoiPoint();
        this.mRouteChargePanelView.setVisibility(0);
        this.mRouteChargePanelView.bringToFront();
        this.mRouteChargePanelView.showDetail(poiPoint.getPoiId(), poiPoint.getName(), poiPoint.getDisplayLat(), poiPoint.getDisplayLon(), i, xPViaPoint.getIsPassedVia());
    }

    private void hideRouteChargeCard() {
        RouteChargePanelView routeChargePanelView;
        if (!isSceneResumed() || (routeChargePanelView = this.mRouteChargePanelView) == null || routeChargePanelView.getVisibility() == 8) {
            return;
        }
        this.mRouteChargePanelView.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void showChargeFilter() {
        this.mFilterContainer.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void showLoadingDialog() {
        if (this.mDialog == null) {
            this.mDialog = new XLandLoadingDialog(getActivity());
            this.mDialog.setMessage(ContextUtils.getString(R.string.dialog_loading_message));
            this.mDialog.setCancelable(false);
        }
        if (this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        L.i(TAG, "showLoadingDialog");
        this.mDialog.show();
        this.mDialog.correctedLocation();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void dismissLoadingDialog() {
        XLandLoadingDialog xLandLoadingDialog = this.mDialog;
        if (xLandLoadingDialog == null || !xLandLoadingDialog.isShowing()) {
            return;
        }
        L.i(TAG, "dismissLoadingDialog");
        this.mDialog.dismiss();
    }

    private void initChargeNoResultView() {
        if (this.mSearchNoResultContainer == null) {
            this.mSearchNoResultContainer = (LinearLayout) this.mSearchNoResultContainerSub.inflate();
            this.mSearchNoResultIcon = (XImageView) this.mSearchNoResultContainer.findViewById(R.id.iv_search_no_result);
            this.mSearchNoResultTitleTx = (XTextView) this.mSearchNoResultContainer.findViewById(R.id.tv_no_result_title);
            this.mSearchNoResultContentTx = (XTextView) this.mSearchNoResultContainer.findViewById(R.id.tv_no_result_content);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void showChargeNoResult() {
        initChargeNoResultView();
        this.mSearchNoResultContainer.setVisibility(0);
        this.mSearchNoResultIcon.setImageResource(R.drawable.vector_ic_xxlarge_noinfo);
        this.mSearchNoResultTitleTx.setText(R.string.search_no_result_title);
        this.mSearchNoResultContentTx.setText(R.string.search_no_result_filter);
        this.mRecyclerView.setVisibility(4);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void showChargeLoadingError() {
        initChargeNoResultView();
        this.mSearchNoResultContainer.setVisibility(0);
        this.mSearchNoResultIcon.setImageResource(R.drawable.vector_ic_xxlarge_nowifi);
        this.mSearchNoResultTitleTx.setText(R.string.search_loading_error);
        SpannableString spannableString = new SpannableString(getString(R.string.search_refresh));
        spannableString.setSpan(new ClickableSpan() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultFragment.4
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                SearchResultFragment.this.mPresenter.queryChargeStation(SearchResultFragment.this.mTvFilterSelfSale.isSelected(), SearchResultFragment.this.mTvFilterFree.isSelected());
            }
        }, 3, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.search_result_no_result_retry_tx_color)), 3, 5, 17);
        this.mSearchNoResultContentTx.setText(spannableString);
        this.mSearchNoResultContentTx.setMovementMethod(LinkMovementMethod.getInstance());
        this.mRecyclerView.setVisibility(4);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchResultContract.LogicView
    public void showChargeSearchResult() {
        LinearLayout linearLayout = this.mSearchNoResultContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        XPRecyclerView xPRecyclerView = this.mRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    private class XPObservableScrollViewCallbacks implements ObservableScrollViewCallbacks {
        private final XPRecyclerView mRecycleView;

        @Override // com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks
        public void onDownMotionEvent() {
        }

        @Override // com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks
        public void onUpOrCancelMotionEvent(int i) {
        }

        public XPObservableScrollViewCallbacks(XPRecyclerView xPRecyclerView) {
            this.mRecycleView = xPRecyclerView;
        }

        @Override // com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks
        public void onScrollChanged(int i, boolean z, boolean z2) {
            int loadMode = this.mRecycleView.getLoadMode();
            boolean z3 = false;
            if ((loadMode != 3) || (loadMode == 3 && this.mRecycleView.canScrollVertically(1))) {
                z3 = true;
            }
            SearchResultFragment.this.showHaveMoreDataDecorator(z3);
        }
    }
}
