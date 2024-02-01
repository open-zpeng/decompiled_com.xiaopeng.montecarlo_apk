package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.anim.AnimCallback;
import com.xiaopeng.montecarlo.anim.AnimEvent;
import com.xiaopeng.montecarlo.anim.LifecycleAnimMode;
import com.xiaopeng.montecarlo.anim.SceneAnimHelper;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.bridge.ExploreBridge;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.ScanSearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.SearchResultBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.FavoriteSyncEvent;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dialog.ProtocolDialog;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter;
import com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter;
import com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract;
import com.xiaopeng.montecarlo.scenes.searchscene.PresenterData;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter;
import com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchResultData;
import com.xiaopeng.montecarlo.stat.HomeOrOfficeSuggestStatUtil;
import com.xiaopeng.montecarlo.stat.SearchStatUtil;
import com.xiaopeng.montecarlo.stat.StatUtil;
import com.xiaopeng.montecarlo.util.BundleUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.PageRecyclerAdapter;
import com.xiaopeng.montecarlo.views.TrafficBar;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.montecarlo.views.XpLinearLayoutManager;
import com.xiaopeng.montecarlo.views.XpMixedTextView;
import com.xiaopeng.montecarlo.views.dialog.DialogManager;
import com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog;
import com.xiaopeng.montecarlo.views.dialog.XLandLoadingDialog;
import com.xiaopeng.montecarlo.views.dialog.XNoTitleDialog;
import com.xiaopeng.montecarlo.views.dialog.XTextDialog;
import com.xiaopeng.montecarlo.views.font.XpFontTagHandler;
import com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView;
import com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks;
import com.xiaopeng.speech.common.util.ResourceUtils;
import com.xiaopeng.vui.commons.model.VuiEvent;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.utils.XInputUtils;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XEditText;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.dialogview.XDialogView;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class SearchFragment extends BaseMapScene implements ISearchContract.LogicView, View.OnClickListener {
    private static final String CACHED_FAVORITE_RESULT_DATA_KEY = "cached_favorite_result_data_key";
    private static final String CACHED_HISTORY_RESULT_DATA_KEY = "cached_history_result_data_key";
    private static final String CACHED_RESULT_DATA_KEY = "cached_result_data_key";
    private static final int MSG_SEARCH_SUGGEST = 101;
    private static final long SET_HOME_OFFICE_THRESHOLD = 1000;
    private static final L.Tag TAG = new L.Tag("SearchFragment");
    private static final String TAG_BIND_AMAP_DIALOG = "tag_search_bind_amap_dialog";
    private XTextDialog mAddWayPoiDia;
    @BindView(R.id.tv_around_left)
    XpMixedTextView mAroundLeft;
    @BindView(R.id.tv_around_right)
    XpMixedTextView mAroundRight;
    @BindView(R.id.btn_return)
    XImageButton mBtnReturn;
    private Unbinder mButterBinder;
    XRelativeLayout mContainerChangeHome;
    XRelativeLayout mContainerChangeOffice;
    private XNoTitleDialog mDeleteAllFavDia;
    private XNoTitleDialog mDeleteHisDia;
    private XLandLoadingDialog mDialog;
    DialogManager mDialogManager;
    private XTextDialog mEdiHomComDia;
    @BindView(R.id.et_search)
    XEditText mEtSearch;
    private RecyclerView.OnScrollListener mFavRecScrLis;
    @BindView(R.id.container_favorite)
    XRelativeLayout mFavoriteContainer;
    @BindView(R.id.iv_favorite_next)
    XImageButton mFavoriteNext;
    @BindView(R.id.favorite_container_recyclerview)
    XPRecyclerView mFavoriteRecyclerView;
    private ObservableScrollViewCallbacks mFavoriteScrollCallback;
    @BindView(R.id.tv_favorite_update_time)
    XTextView mFavoriteUpdateTime;
    @BindView(R.id.iv_have_more_data)
    XImageView mHaveMoreDataDecorator;
    private RecyclerView.OnScrollListener mHisRecScrLis;
    private XImageView mHistoryNoImg;
    @BindView(R.id.history_record_recyclerview)
    XPRecyclerView mHistoryRecyclerView;
    private ObservableScrollViewCallbacks mHistoryScrollCallback;
    @BindView(R.id.history_sub_container)
    XRelativeLayout mHistorySubContainer;
    @BindView(R.id.container_home)
    XRelativeLayout mHomeContainer;
    @BindView(R.id.iv_change_home)
    XImageView mIvChangeHome;
    @BindView(R.id.iv_change_office)
    XImageView mIvChangeOffice;
    @BindView(R.id.iv_clear)
    XImageButton mIvClear;
    private RelativeLayout.LayoutParams mIvClearLayoutParams;
    private EditOnKeyListener mKeyListener;
    private String mLastUserId;
    XTextView mNoRecordTipSubView;
    XTextView mNoRecordTipView;
    XTextView mNoRecordTitleView;
    @BindView(R.id.container_office)
    XRelativeLayout mOfficeContainer;
    @BindView(R.id.progressbar_history_container_loading)
    ProgressBar mPbHistoryLoad;
    @BindView(R.id.search_recyclerview_header)
    View mRecyclerViewHeader;
    List<FavoriteAddress> mSaveFavoriteAddressList;
    List<HistoryRecordInfo> mSaveHistoryRecordInfos;
    ArrayList<XPPoiInfo> mSaveSearchData;
    private RecyclerView.OnScrollListener mSeaRecScrLis;
    private SearchAdapter mSearchAdapter;
    @BindView(R.id.search_container)
    View mSearchContainer;
    @BindView(R.id.search_container_sub)
    ViewStub mSearchContainerSub;
    @BindView(R.id.search_favorite_parent)
    XLinearLayout mSearchFavoriteParent;
    @BindView(R.id.search_header_layout)
    XRelativeLayout mSearchHeaderLayout;
    @BindView(R.id.search_input_container)
    ViewGroup mSearchInputContainer;
    XImageView mSearchNoNetworkImg;
    XImageView mSearchNoResultImg;
    XImageView mSearchNoSuggestImg;
    XPRecyclerView mSearchRecyclerView;
    private ObservableScrollViewCallbacks mSearchScrollCallback;
    LinearLayout mSearchSubContainer;
    @BindView(R.id.search_tip_stub)
    ViewStub mSearchTipStub;
    private View mSearchTipView;
    private XTextDialog mSetDiaWhenClick;
    private XTextDialog mSetDiaWhenSysSug;
    private EditChangedListener mTextChangeListener;
    @BindView(R.id.trafficbar_home)
    TrafficBar mTrafficBarHome;
    @BindView(R.id.trafficbar_office)
    TrafficBar mTrafficBarOffice;
    @BindView(R.id.tv_favorite)
    XTextView mTvFavorite;
    @BindView(R.id.tv_history_container_loading)
    XTextView mTvHistoryLoad;
    @BindView(R.id.tv_home)
    XTextView mTvHome;
    @BindView(R.id.tv_home_tips_dis)
    XTextView mTvHomeTipsDis;
    @BindView(R.id.tv_home_tips_time)
    XTextView mTvHomeTipsTime;
    XTextView mTvNoResultContent;
    XTextView mTvNoResultTitle;
    XTextView mTvNoSugContent;
    XTextView mTvNoSugTitle;
    XTextView mTvNoWifiContent;
    XTextView mTvNoWifiTitle;
    @BindView(R.id.tv_office)
    XTextView mTvOffice;
    @BindView(R.id.tv_office_tips_dis)
    XTextView mTvOfficeTipsDis;
    @BindView(R.id.tv_office_tips_time)
    XTextView mTvOfficeTipsDisTime;
    @BindView(R.id.tv_scan_search)
    XTextView mTvScanSearch;
    @BindView(R.id.search_vertical_line_scan)
    XView mTvScanSearchLine;
    @BindView(R.id.tv_set_home)
    XTextView mTvSetHome;
    @BindView(R.id.tv_set_office)
    XTextView mTvSetOffice;
    @BindView(R.id.view_head_vertical_line)
    XView mViewHeadVerticalLine;
    protected XpFontTagHandler mXpFontTagHandler;
    boolean mHasSaveInstance = false;
    String mSaveEtSearch = "";
    private int mSubContainerType = 2;
    private int mStartFrom = 0;
    private FavoriteAdapter mFavoriteAdapter = null;
    private HistoryRecordAdapter mHistoryAdapter = null;
    private SearchPresenter mPresenter = null;
    private boolean mIsCreate = false;
    private int mStartAnimType = 0;
    private boolean mIsAnimToClose = false;
    private HomeCompanyConflictDialog mFavoriteSyncDialog = null;
    private XBindAmapDialog mBindAmapDialog = null;
    private int mHistoryRecordFirstVisiblePosition = -1;
    private int mHistoryRecordLastVisiblePosition = -1;
    private int mSearchRecordFirstVisiblePosition = -1;
    private int mSearchRecordLastVisiblePosition = -1;
    private int mFavoriteRecordFirstVisiblePosition = -1;
    private int mFavoriteRecordLastVisiblePosition = -1;
    private XPRecyclerView.CreateViewCallback mHistoryRecCreateCallback = new XPRecyclerView.CreateViewCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.1
        @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.CreateViewCallback
        public View onCreateView() {
            if (SearchFragment.this.isSceneLegal()) {
                View inflate = LayoutInflater.from(ContextUtils.getActivity()).inflate(R.layout.layout_xp_recyclerview_delete_all, (ViewGroup) SearchFragment.this.mHistoryRecyclerView, false);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (SearchFragment.this.preventMultiClick(view)) {
                            SearchFragment.this.performHistoryDeleteClick();
                        }
                    }
                });
                return inflate;
            }
            return null;
        }
    };
    private XPRecyclerView.CreateViewCallback mFavoriteRecCreateCallback = new XPRecyclerView.CreateViewCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.2
        @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.CreateViewCallback
        public View onCreateView() {
            if (SearchFragment.this.isSceneLegal()) {
                View inflate = LayoutInflater.from(ContextUtils.getActivity()).inflate(R.layout.layout_xp_recyclerview_delete_all, (ViewGroup) SearchFragment.this.mFavoriteRecyclerView, false);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (SearchFragment.this.preventMultiClick(view)) {
                            SearchFragment.this.performFavoriteDeleteClick();
                        }
                    }
                });
                return inflate;
            }
            return null;
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 101 || message.obj == null || SearchFragment.this.mPresenter == null) {
                return;
            }
            SearchFragment.this.mPresenter.doTextChanged(message.obj.toString());
        }
    };
    private Bundle mCachedData = new Bundle();
    private HistoryRecordAdapter.AdapterCallback mHistoryAdapterCallback = new HistoryRecordAdapter.AdapterCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.4
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onItemClick(HistoryRecordInfo historyRecordInfo, int i) {
            SearchFragment.this.onHistoryRecordItemClick(historyRecordInfo, i);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onGotoDest(HistoryRecordInfo historyRecordInfo, int i) {
            if (historyRecordInfo.getXPPoiInfo() == null) {
                L.Tag tag = SearchFragment.TAG;
                L.i(tag, "SearchFragment onGotoDest XPPoiInfo = " + historyRecordInfo);
                return;
            }
            SearchStatUtil.sendStatDataWhenHistoryItemNavi(SearchFragment.this.getMainContext(), historyRecordInfo.getXPPoiInfo(), StatUtil.formatLocationToStr(historyRecordInfo.getXPPoiInfo().getDisplayLon(), historyRecordInfo.getXPPoiInfo().getDisplayLat()), i);
            SearchFragment.this.mPresenter.goToPoi(historyRecordInfo.getXPPoiInfo(), historyRecordInfo.getViaPois());
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onSetHome(HistoryRecordInfo historyRecordInfo, int i) {
            if (historyRecordInfo.getXPPoiInfo() != null) {
                SearchStatUtil.sendStatDataWhenHistoryItemSettingHome(SearchFragment.this.getMainContext(), StatUtil.formatLocationToStr(historyRecordInfo.getXPPoiInfo().getDisplayLon(), historyRecordInfo.getXPPoiInfo().getDisplayLat()), i);
                SearchFragment.this.mPresenter.setHomeCompany(new FavoriteAddress(historyRecordInfo.getXPPoiInfo()), 0);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onSetCompany(HistoryRecordInfo historyRecordInfo, int i) {
            if (historyRecordInfo.getXPPoiInfo() != null) {
                SearchStatUtil.sendStatDataWhenHistoryItemSettingOffice(SearchFragment.this.getMainContext(), StatUtil.formatLocationToStr(historyRecordInfo.getXPPoiInfo().getDisplayLon(), historyRecordInfo.getXPPoiInfo().getDisplayLat()), i);
                SearchFragment.this.mPresenter.setHomeCompany(new FavoriteAddress(historyRecordInfo.getXPPoiInfo()), 1);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onDel(HistoryRecordInfo historyRecordInfo, int i) {
            if (historyRecordInfo.getXPPoiInfo() == null || SearchFragment.this.mHistoryRecyclerView == null || SearchFragment.this.mHistoryRecyclerView.getScrollState() != 0) {
                return;
            }
            SearchFragment.this.mHistoryRecyclerView.setLock(true);
            SearchStatUtil.sendStatDataWhenDeleteHistoryItem(SearchFragment.this.getMainContext(), historyRecordInfo.getXPPoiInfo(), i);
            SearchFragment.this.mPresenter.deleteHistoryRecord(historyRecordInfo, i);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onAddWay(HistoryRecordInfo historyRecordInfo, int i) {
            if (historyRecordInfo.getXPPoiInfo() != null) {
                if (L.ENABLE) {
                    L.Tag tag = SearchFragment.TAG;
                    L.d(tag, "onAddWay this:" + this);
                }
                SearchStatUtil.sendStatDataWhenHistoryItemAddWaypoint(SearchFragment.this.getMainContext(), historyRecordInfo.getXPPoiInfo(), StatUtil.formatLocationToStr(historyRecordInfo.getXPPoiInfo().getDisplayLon(), historyRecordInfo.getXPPoiInfo().getDisplayLat()), i);
                SearchFragment.this.mPresenter.addWayPoint(historyRecordInfo.getXPPoiInfo());
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onRemoveWay(HistoryRecordInfo historyRecordInfo, int i) {
            if (historyRecordInfo.getXPPoiInfo() != null) {
                SearchFragment.this.mPresenter.removeWayPoint(historyRecordInfo.getXPPoiInfo());
                SearchStatUtil.sendStatDataWhenHistoryItemDeleteWaypoint(SearchFragment.this.getMainContext(), StatUtil.formatLocationToStr(historyRecordInfo.getXPPoiInfo().getDisplayLon(), historyRecordInfo.getXPPoiInfo().getDisplayLat()), i);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onNewNavi(HistoryRecordInfo historyRecordInfo, int i) {
            SearchStatUtil.sendStatDataWhenHistoryItemNavi(SearchFragment.this.getMainContext(), historyRecordInfo.getXPPoiInfo(), StatUtil.formatLocationToStr(historyRecordInfo.getXPPoiInfo().getDisplayLon(), historyRecordInfo.getXPPoiInfo().getDisplayLat()), i);
            SearchFragment.this.mPresenter.addNewNavi(historyRecordInfo.getXPPoiInfo());
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.HistoryRecordAdapter.AdapterCallback
        public void onChildPoiClick(int i, XPPoiInfo xPPoiInfo) {
            if (xPPoiInfo != null) {
                SearchFragment.this.mPresenter.goToChildPoi(xPPoiInfo);
            }
        }
    };
    private FavoriteAdapter.AdapterCallback mFavoriteAdapterCallback = new FavoriteAdapter.AdapterCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.5
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onDel(int i, FavoriteAddress favoriteAddress) {
            if (SearchFragment.this.mFavoriteRecyclerView == null || SearchFragment.this.mFavoriteRecyclerView.getScrollState() != 0) {
                return;
            }
            if (favoriteAddress != null && favoriteAddress.getXPPoiInfo() != null) {
                SearchStatUtil.sendStatDataWhenDeleteFavoriteItem(SearchFragment.this.getMainContext(), favoriteAddress.getXPPoiInfo(), i);
            }
            SearchFragment.this.mFavoriteRecyclerView.setLock(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(favoriteAddress);
            SearchFragment.this.mPresenter.deleteFavorite(arrayList);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onGotoPoi(int i, FavoriteAddress favoriteAddress) {
            SearchFragment.this.hideIme();
            XPPoiInfo xPPoiInfo = favoriteAddress.getXPPoiInfo();
            if (xPPoiInfo != null) {
                SearchStatUtil.sendStatDataWhenStartNavi(SearchFragment.this.getActivity(), SearchFragment.this.getMainContext(), xPPoiInfo);
                SearchFragment.this.mPresenter.gotoPoiByFavoriteItem(favoriteAddress);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onItemClick(int i, FavoriteAddress favoriteAddress) {
            if (favoriteAddress.getXPPoiInfo() != null) {
                SearchStatUtil.sendStatDataWhenFavListItemSelected(SearchFragment.this.getActivity(), SearchFragment.this.getMainContext(), favoriteAddress.getXPPoiInfo());
            }
            SearchFragment.this.mPresenter.clickByFavoriteItem(favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onSetHome(int i, FavoriteAddress favoriteAddress) {
            SearchFragment.this.mPresenter.setHomeCompany(favoriteAddress, 0);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onSetCompany(int i, FavoriteAddress favoriteAddress) {
            FavoriteDataManager.getInstance().setCompany(favoriteAddress);
            SearchFragment.this.mPresenter.goBackForResult(favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onAddWay(int i, FavoriteAddress favoriteAddress) {
            if (favoriteAddress.getXPPoiInfo() != null) {
                SearchStatUtil.sendStatDataWhenFavListItemAddWayPoint(SearchFragment.this.getActivity(), SearchFragment.this.getMainContext(), favoriteAddress.getXPPoiInfo());
            }
            SearchFragment.this.mPresenter.addWayPointByFavorite(favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onRemoveWay(int i, FavoriteAddress favoriteAddress) {
            if (favoriteAddress.getXPPoiInfo() != null) {
                SearchStatUtil.sendStatDataWhenFavListItemRemoveWayPoint(SearchFragment.this.getActivity(), SearchFragment.this.getMainContext(), favoriteAddress.getXPPoiInfo());
            }
            SearchFragment.this.mPresenter.removeWayPoint(favoriteAddress.getXPPoiInfo());
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onNewNavi(int i, FavoriteAddress favoriteAddress) {
            SearchFragment.this.mPresenter.addNewNaviByFavorite(favoriteAddress);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.FavoriteAdapter.AdapterCallback
        public void onStarIconClick(int i, FavoriteAddress favoriteAddress) {
            SearchFragment.this.mPresenter.updateFavoriteStatus(i, favoriteAddress);
        }
    };
    private SearchAdapterCallback mSearchAdapterCallback = new SearchAdapterCallback(this);

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean canPoiCardShow() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene
    public boolean canShowTrafficEventPop() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean showCover() {
        return true;
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchSetCompany(int i) {
        XPPoiInfo xPPoiInfo;
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter == null) {
            return;
        }
        int actualPosition = searchAdapter.getActualPosition(i);
        List<XPPoiInfo> data = this.mSearchAdapter.getData();
        if (CollectionUtils.isEmpty(data) || data.size() <= actualPosition || (xPPoiInfo = data.get(actualPosition)) == null || this.mPresenter == null) {
            return;
        }
        SearchStatUtil.sendStatDataWhenSugSettingOffice(getActivity(), getMainContext(), xPPoiInfo, actualPosition);
        this.mPresenter.setHomeCompany(new FavoriteAddress(xPPoiInfo), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchSetHome(int i) {
        XPPoiInfo xPPoiInfo;
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter == null) {
            return;
        }
        int actualPosition = searchAdapter.getActualPosition(i);
        List<XPPoiInfo> data = this.mSearchAdapter.getData();
        if (CollectionUtils.isEmpty(data) || data.size() <= actualPosition || (xPPoiInfo = data.get(actualPosition)) == null || this.mPresenter == null) {
            return;
        }
        SearchStatUtil.sendStatDataWhenSugSettingHome(getActivity(), getMainContext(), xPPoiInfo, actualPosition);
        this.mPresenter.setHomeCompany(new FavoriteAddress(xPPoiInfo), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchGotoWayPoint(int i) {
        XPPoiInfo xPPoiInfo;
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter == null) {
            return;
        }
        int actualPosition = searchAdapter.getActualPosition(i);
        List<XPPoiInfo> data = this.mSearchAdapter.getData();
        if (CollectionUtils.isEmpty(data) || data.size() <= actualPosition || (xPPoiInfo = data.get(actualPosition)) == null || this.mPresenter == null) {
            return;
        }
        SearchStatUtil.sendStatDataWhenSugNavi(getPageType(), getActivity(), getMainContext(), xPPoiInfo, actualPosition);
        this.mPresenter.addNewNavi(xPPoiInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchDeleteWayPoint(int i) {
        XPPoiInfo xPPoiInfo;
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter == null) {
            return;
        }
        int actualPosition = searchAdapter.getActualPosition(i);
        List<XPPoiInfo> data = this.mSearchAdapter.getData();
        if (CollectionUtils.isEmpty(data) || data.size() <= actualPosition || (xPPoiInfo = data.get(actualPosition)) == null || this.mPresenter == null) {
            return;
        }
        SearchStatUtil.sendStatDataWhenSugDeleteWaypoint(getActivity(), getMainContext(), xPPoiInfo, actualPosition);
        this.mPresenter.removeWayPoint(xPPoiInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchAddWayPoint(int i) {
        XPPoiInfo xPPoiInfo;
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter == null) {
            return;
        }
        int actualPosition = searchAdapter.getActualPosition(i);
        List<XPPoiInfo> data = this.mSearchAdapter.getData();
        if (CollectionUtils.isEmpty(data) || data.size() <= actualPosition || (xPPoiInfo = data.get(actualPosition)) == null || this.mPresenter == null) {
            return;
        }
        SearchStatUtil.sendStatDataWhenSugAddWaypoint(getActivity(), getMainContext(), xPPoiInfo, actualPosition);
        this.mPresenter.addWayPoint(xPPoiInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchGotoPoi(int i) {
        XPPoiInfo xPPoiInfo;
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter == null) {
            return;
        }
        int actualPosition = searchAdapter.getActualPosition(i);
        List<XPPoiInfo> data = this.mSearchAdapter.getData();
        if (CollectionUtils.isEmpty(data) || data.size() <= actualPosition || (xPPoiInfo = data.get(actualPosition)) == null || this.mPresenter == null) {
            return;
        }
        SearchStatUtil.sendStatDataWhenSugNavi(getPageType(), getActivity(), getMainContext(), xPPoiInfo, actualPosition);
        this.mPresenter.gotoBySearchResult(xPPoiInfo);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneCreate(@Nullable Bundle bundle) {
        super.onSceneCreate(bundle);
        resetPageVuiState();
        initData(bundle);
        initRegister();
    }

    private void resetPageVuiState() {
        if (isSceneVuiEnabled()) {
            SearchVuiHelper.getInstance().resetPageVuiState();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search, viewGroup, true);
        this.mButterBinder = ButterKnife.bind(this, inflate);
        if (Utils.isLandscape()) {
            this.mContainerChangeOffice = (XRelativeLayout) inflate.findViewById(R.id.container_change_office);
            this.mContainerChangeHome = (XRelativeLayout) inflate.findViewById(R.id.container_change_home);
            this.mContainerChangeOffice.setOnClickListener(this);
            this.mContainerChangeHome.setOnClickListener(this);
        }
        this.mPresenter.onCreateView();
        return inflate;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        this.mPresenter.onViewCreate();
    }

    private void initData(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mSaveEtSearch = bundle.getString(SearchSceneConstants.SEARCH_SAVESTATE_ETSEARCH);
            this.mSaveSearchData = bundle.getParcelableArrayList(SearchSceneConstants.SEARCH_SAVESTATE_SEARCHDATA);
            this.mSaveFavoriteAddressList = bundle.getParcelableArrayList(SearchSceneConstants.SEARCH_SAVESTATE_FAVORITE);
            this.mSaveHistoryRecordInfos = bundle.getParcelableArrayList(SearchSceneConstants.SEARCH_SAVESTATE_HISTORY);
            this.mHasSaveInstance = true;
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("initData mSaveHistoryRecordInfos:");
            List<HistoryRecordInfo> list = this.mSaveHistoryRecordInfos;
            sb.append(list == null ? 0 : list.size());
            sb.append(", mSaveFavoriteAddressList:");
            List<FavoriteAddress> list2 = this.mSaveFavoriteAddressList;
            sb.append(list2 != null ? list2.size() : 0);
            L.i(tag, sb.toString());
        }
        this.mIsCreate = true;
        initBundleData();
    }

    private void initBundleData() {
        PresenterData presenterData;
        SearchPresenter searchPresenter;
        Bundle bundle = getBridge().getBundle();
        if (bundle != null) {
            int i = bundle.getInt(SearchBridge.SUB_CONTAINER_TYPE, this.mSubContainerType);
            this.mStartFrom = bundle.getInt(SearchBridge.KEY_START_FROM, 0);
            if (this.mStartFrom == 1 && i == 1 && (searchPresenter = this.mPresenter) != null) {
                searchPresenter.setClickFavoriteBtn(true);
            }
            this.mStartAnimType = bundle.getInt(SearchBridge.ANIM_TYPE, 0);
            int i2 = bundle.getInt(SearchBridge.SEARCH_MODE);
            int i3 = bundle.getInt(SearchBridge.SEARCH_MODE_VIEW);
            int i4 = bundle.getInt(SearchBridge.FROM_SCENE_INDEX, -2);
            presenterData = new PresenterData.Builder().searchMode(i2).searchModeView(i3).fromSceneIndex(i4).aroundPoi((XPPoiInfo) bundle.getParcelable(SearchBridge.SEARCH_AROUND_ITEM)).fromSceneChildIndex(bundle.getInt(SearchBridge.FROM_SCENE_CHILD_INDEX, -1)).saveSearchData(this.mSaveSearchData).saveFavoriteAddressList(this.mSaveFavoriteAddressList).saveHistoryRecordList(this.mSaveHistoryRecordInfos).animType(this.mStartAnimType).searchDest(bundle.getInt(SearchBridge.SEARCH_DEST_KEY, 1000)).hasSaveState(this.mHasSaveInstance).subContainerType(this.mSubContainerType).build();
        } else {
            presenterData = null;
        }
        if (presenterData != null) {
            this.mPresenter.initData(presenterData);
        }
        this.mPresenter.doAlertSettingHomeOrCompany();
    }

    private void initRegister() {
        SearchPresenter searchPresenter = this.mPresenter;
        if (searchPresenter != null) {
            searchPresenter.registerAccountObserver();
            this.mPresenter.registerAccountEventCallback();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void unRegisterEventBus() {
        EventBus.getDefault().unregister(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void initListener() {
        this.mTextChangeListener = new EditChangedListener();
        this.mKeyListener = new EditOnKeyListener();
        if (this.mPresenter.isFavoriteShow()) {
            return;
        }
        addEtSearchListener();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void initView() {
        initSubFavoriteLayout();
        initSubHistoryLayout();
        initScrollCallbacks();
        renderLayoutByDayNightStatus();
        XInputUtils.ignoreHiddenInput(this.mIvClear);
    }

    private void initSubSearchLayout() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.mSearchAdapter = new SearchAdapter(activity, this.mSearchRecyclerView);
        SearchPresenter searchPresenter = this.mPresenter;
        if (searchPresenter != null) {
            this.mSearchAdapter.setSearchDest(searchPresenter.getSearchDest());
            this.mSearchAdapter.setSearchMode(this.mPresenter.getSearchMode());
            this.mSearchAdapter.setSearchModeView(this.mPresenter.getSearchModeView());
        }
        this.mSearchAdapter.setAdapterCallback(this.mSearchAdapterCallback);
        this.mSearchRecyclerView.setLayoutManager(new XpLinearLayoutManager(getActivity(), new XpLinearLayoutManager.XpLinearLayoutManagerListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.6
            @Override // com.xiaopeng.montecarlo.views.XpLinearLayoutManager.XpLinearLayoutManagerListener
            public void onLayoutCompleted() {
                SearchFragment.this.executeOnSearchRecordLayoutCompleted();
            }
        }));
        this.mSearchRecyclerView.setHideLoadMore(true);
        this.mSearchRecyclerView.setAdapter((PageRecyclerAdapter) this.mSearchAdapter);
        this.mXpFontTagHandler = new XpFontTagHandler(getResources().getDisplayMetrics());
        addSearchRecyclerScrollListenerForVui();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnSearchRecordLayoutCompleted() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            XpLinearLayoutManager xpLinearLayoutManager = (XpLinearLayoutManager) this.mSearchRecyclerView.getLayoutManager();
            if (xpLinearLayoutManager.getItemCount() > 0) {
                int findFirstVisibleItemPosition = xpLinearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = xpLinearLayoutManager.findLastVisibleItemPosition();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, L.formatVoiceFullScenesLog("updateSearchListForVui onLayoutCompleted first:" + findFirstVisibleItemPosition + ",last:" + findLastVisibleItemPosition));
                }
                if (findFirstVisibleItemPosition == 0) {
                    this.mSearchRecordFirstVisiblePosition = findFirstVisibleItemPosition;
                    this.mSearchRecordLastVisiblePosition = findLastVisibleItemPosition;
                    updateSearchListForVui();
                }
            }
        }
    }

    private void updateSearchListForVui() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.d(TAG, L.formatVoiceFullScenesLog("updateSearchListForVui"));
            }
            XEditText xEditText = this.mEtSearch;
            SearchVuiHelper.getInstance().updateSceneForVui(this.mSearchRecyclerView, this, xEditText == null ? null : xEditText.getText(), this.mPresenter.getSearchDest());
        }
    }

    private void initSubHistoryLayout() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.mHistoryRecyclerView.setLayoutManager(new XpLinearLayoutManager(activity, new XpLinearLayoutManager.XpLinearLayoutManagerListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.7
            @Override // com.xiaopeng.montecarlo.views.XpLinearLayoutManager.XpLinearLayoutManagerListener
            public void onLayoutCompleted() {
                SearchFragment.this.executeOnHistoryRecordLayoutCompleted();
            }
        }));
        this.mHistoryRecyclerView.setHasFixedSize(true);
        this.mHistoryRecyclerView.setNestedScrollingEnabled(false);
        this.mHistoryRecyclerView.setHideNoMore(true);
        this.mHistoryRecyclerView.setMaxCount(200);
        this.mHistoryRecyclerView.setPageSize(20);
        if (this.mHasSaveInstance) {
            this.mHistoryRecyclerView.setAutoPaging(true);
        } else {
            this.mHistoryRecyclerView.setAutoPaging(false);
            this.mHistoryRecyclerView.setLoadMoreCallback(new XPRecyclerView.LoadMoreCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.8
                @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.LoadMoreCallback
                public void onLoadMore() {
                    if (SearchFragment.this.mPresenter != null) {
                        SearchFragment.this.mPresenter.delayLoadHistoryList();
                    }
                }
            });
        }
        if (this.mPresenter.isSwipeMenuEnable()) {
            this.mHistoryRecyclerView.setShowFooter(true);
            this.mHistoryRecyclerView.setCreateFooterCallback(this.mHistoryRecCreateCallback);
        }
        this.mHistoryAdapter = new HistoryRecordAdapter(activity, this.mHistoryRecyclerView, this.mPresenter.getSearchMode(), this.mPresenter.getSearchDest(), this.mPresenter.getSearchModeView());
        this.mHistoryAdapter.setAdapterCallback(this.mHistoryAdapterCallback);
        this.mHistoryRecyclerView.setAdapter((PageRecyclerAdapter) this.mHistoryAdapter);
        addHistoryRecordScrollListenerForVui();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnHistoryRecordLayoutCompleted() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            XpLinearLayoutManager xpLinearLayoutManager = (XpLinearLayoutManager) this.mHistoryRecyclerView.getLayoutManager();
            if (xpLinearLayoutManager.getItemCount() > 0) {
                int findFirstVisibleItemPosition = xpLinearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = xpLinearLayoutManager.findLastVisibleItemPosition();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, L.formatVoiceFullScenesLog("updateHistoryListForVui onLayoutCompleted first:" + findFirstVisibleItemPosition + ",last:" + findLastVisibleItemPosition));
                }
                if (findFirstVisibleItemPosition == 0) {
                    this.mHistoryRecordFirstVisiblePosition = findFirstVisibleItemPosition;
                    this.mHistoryRecordLastVisiblePosition = findLastVisibleItemPosition;
                    updateHistoryListForVui();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performHistoryDeleteClick() {
        if (this.mPresenter != null) {
            SearchStatUtil.sendStatDataWhenDeleteAllHistories(getMainContext());
            showDeleteHistoryDialog();
        }
    }

    private void initSubFavoriteLayout() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.mFavoriteAdapter = new FavoriteAdapter(activity, this.mFavoriteRecyclerView, this.mPresenter.getSearchMode(), this.mPresenter.getSearchDest(), this.mPresenter.getSearchModeView());
        this.mFavoriteAdapter.setAdapterCallback(this.mFavoriteAdapterCallback);
        this.mFavoriteRecyclerView.setHasFixedSize(true);
        this.mFavoriteRecyclerView.setNestedScrollingEnabled(false);
        this.mFavoriteRecyclerView.setLayoutManager(new XpLinearLayoutManager(getActivity(), new XpLinearLayoutManager.XpLinearLayoutManagerListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.9
            @Override // com.xiaopeng.montecarlo.views.XpLinearLayoutManager.XpLinearLayoutManagerListener
            public void onLayoutCompleted() {
                SearchFragment.this.executeOnFavoriteRecordLayoutCompleted();
            }
        }));
        this.mFavoriteRecyclerView.setHideNoMore(true);
        this.mFavoriteRecyclerView.setPageSize(20);
        this.mFavoriteRecyclerView.setShowFooter(true);
        if (this.mHasSaveInstance) {
            this.mFavoriteRecyclerView.setAutoPaging(true);
        } else {
            this.mFavoriteRecyclerView.setAutoPaging(false);
            this.mFavoriteRecyclerView.setLoadMoreCallback(new XPRecyclerView.LoadMoreCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.10
                @Override // com.xiaopeng.montecarlo.views.XPRecyclerView.LoadMoreCallback
                public void onLoadMore() {
                    if (SearchFragment.this.mPresenter != null) {
                        SearchFragment.this.mPresenter.delayLoadFavoriteList();
                    }
                }
            });
        }
        this.mFavoriteRecyclerView.setCreateFooterCallback(this.mFavoriteRecCreateCallback);
        this.mFavoriteRecyclerView.setAdapter((PageRecyclerAdapter) this.mFavoriteAdapter);
        this.mFavoriteRecyclerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.11
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                L.i(SearchFragment.TAG, ">>>> onViewAttachedToWindow");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                L.i(SearchFragment.TAG, ">>>> onViewDetachedFromWindow");
                SearchFragment.this.mPresenter.deleteCancelFavoriteData();
            }
        });
        addFavoriteRecordScrollListenerForVui();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnFavoriteRecordLayoutCompleted() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            XpLinearLayoutManager xpLinearLayoutManager = (XpLinearLayoutManager) this.mFavoriteRecyclerView.getLayoutManager();
            if (xpLinearLayoutManager.getItemCount() > 0) {
                int findFirstVisibleItemPosition = xpLinearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = xpLinearLayoutManager.findLastVisibleItemPosition();
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, L.formatVoiceFullScenesLog("updateFavoriteListForVui onLayoutCompleted first:" + findFirstVisibleItemPosition + ",last:" + findLastVisibleItemPosition));
                }
                if (findFirstVisibleItemPosition == 0) {
                    this.mFavoriteRecordFirstVisiblePosition = findFirstVisibleItemPosition;
                    this.mFavoriteRecordLastVisiblePosition = findLastVisibleItemPosition;
                    updateFavoriteListForVui();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performFavoriteDeleteClick() {
        if (this.mPresenter != null) {
            SearchStatUtil.sendStatDataWhenDeleteAllFavorites(getMainContext());
            deleteAllFavorites();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHistoryRecordItemClick(HistoryRecordInfo historyRecordInfo, int i) {
        if (historyRecordInfo.getXPPoiInfo() != null) {
            if (3 == historyRecordInfo.getHistoryType()) {
                SearchStatUtil.sendStatDataWhenHistoryPathItemSelected(getMainContext());
                this.mPresenter.goToPoi(historyRecordInfo.getXPPoiInfo(), historyRecordInfo.getViaPois());
                return;
            }
            SearchStatUtil.sendStatDataWhenHistoryItemSelected(getMainContext(), StatUtil.formatLocationToStr(historyRecordInfo.getXPPoiInfo().getDisplayLon(), historyRecordInfo.getXPPoiInfo().getDisplayLat()), i);
            this.mPresenter.historyRecordItemClick(historyRecordInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSearchItemClick(View view, int i) {
        XPPoiInfo xPPoiInfo;
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter == null) {
            return;
        }
        int actualPosition = searchAdapter.getActualPosition(i);
        SearchStatUtil.sendStatDataWhenExecuteGestureOperations(getMainContext(), actualPosition);
        SearchAdapter searchAdapter2 = this.mSearchAdapter;
        if (searchAdapter2 == null) {
            return;
        }
        List<XPPoiInfo> data = searchAdapter2.getData();
        if (CollectionUtils.isEmpty(data) || data.size() <= actualPosition || (xPPoiInfo = data.get(actualPosition)) == null) {
            return;
        }
        SearchStatUtil.sendStatDataWhenSugSelected(getActivity(), getMainContext(), xPPoiInfo, actualPosition);
        hideIme();
        onSearchItemSwitch(view.getId(), actualPosition, xPPoiInfo);
    }

    private void onSearchItemSwitch(int i, int i2, XPPoiInfo xPPoiInfo) {
        if (i != R.id.container_content) {
            return;
        }
        this.mPresenter.startSearch(xPPoiInfo);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startAnimTwo(final Runnable runnable) {
        int i = getBridge().getBundle().getInt(SearchBridge.ANIM_START_Y, -1);
        int i2 = getBridge().getBundle().getInt(SearchBridge.ANIM_START_H, -1);
        View sceneContentView = getSceneContentView();
        int paddingTop = sceneContentView != null ? sceneContentView.getPaddingTop() : 0;
        LifecycleAnimMode scaleYHRightToLeftShowAnim = SceneAnimHelper.getScaleYHRightToLeftShowAnim(this, i, i2, paddingTop);
        LifecycleAnimMode slideYTo0 = SceneAnimHelper.getSlideYTo0(this, 0);
        slideYTo0.addView(this.mSearchInputContainer);
        scaleYHRightToLeftShowAnim.addNextAnimMode(slideYTo0);
        LifecycleAnimMode scaleYShowAnim = SceneAnimHelper.getScaleYShowAnim(this, i, i2, paddingTop);
        scaleYShowAnim.addView(this.mSearchContainer);
        scaleYShowAnim.addAnimCallback(new AnimCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.12
            @Override // com.xiaopeng.montecarlo.anim.AnimCallback
            public void onEvent(AnimEvent animEvent, View view) {
                Runnable runnable2;
                if (animEvent != AnimEvent.END || (runnable2 = runnable) == null) {
                    return;
                }
                runnable2.run();
            }
        });
        scaleYHRightToLeftShowAnim.addNextAnimMode(scaleYShowAnim);
        scaleYHRightToLeftShowAnim.start(this.mSearchInputContainer, null);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startAnimOne(final Runnable runnable) {
        SceneAnimHelper.getSlideLeftToRightShowAnim(this).start(this.mSearchContainer, new AnimCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.13
            @Override // com.xiaopeng.montecarlo.anim.AnimCallback
            public void onEvent(AnimEvent animEvent, View view) {
                Runnable runnable2;
                if (animEvent != AnimEvent.END || (runnable2 = runnable) == null) {
                    return;
                }
                runnable2.run();
            }
        });
    }

    private void animToClose() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "animToClose mIsAnimToClose:" + this.mIsAnimToClose);
        }
        if (this.mIsAnimToClose) {
            return;
        }
        this.mIsAnimToClose = true;
        int i = this.mStartAnimType;
        if (i == 2) {
            animClose2();
        } else if (i == 1) {
            animClose1();
        } else {
            goBack();
            this.mIsAnimToClose = false;
        }
    }

    private void animClose1() {
        SceneAnimHelper.getSlideRightToLeftHideAnim(this).start(this.mSearchContainer, new AnimCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.14
            @Override // com.xiaopeng.montecarlo.anim.AnimCallback
            public void onEvent(AnimEvent animEvent, View view) {
                if (AnimEvent.END == animEvent) {
                    SearchFragment.this.goBack();
                    SearchFragment.this.mIsAnimToClose = false;
                }
            }
        });
    }

    private void animClose2() {
        ViewGroup viewGroup = this.mSearchInputContainer;
        View view = this.mSearchContainer;
        viewGroup.animate().cancel();
        view.animate().cancel();
        int i = getBridge().getBundle().getInt(SearchBridge.ANIM_START_Y, -1);
        int i2 = getBridge().getBundle().getInt(SearchBridge.ANIM_START_H, -1);
        View sceneContentView = getSceneContentView();
        int paddingTop = sceneContentView != null ? sceneContentView.getPaddingTop() : 0;
        LifecycleAnimMode slideYTo0 = SceneAnimHelper.getSlideYTo0(this, (((i2 - viewGroup.getMeasuredHeight()) / 2) + i) - paddingTop);
        SceneAnimHelper.getScaleYHideAnim(this, i, i2, paddingTop).start(this.mSearchContainer, null);
        LifecycleAnimMode scaleLeftToRightHideAnim = SceneAnimHelper.getScaleLeftToRightHideAnim(this);
        scaleLeftToRightHideAnim.addView(this.mSearchInputContainer);
        scaleLeftToRightHideAnim.addAnimCallback(new AnimCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.15
            @Override // com.xiaopeng.montecarlo.anim.AnimCallback
            public void onEvent(AnimEvent animEvent, View view2) {
                if (AnimEvent.END == animEvent) {
                    SearchFragment.this.goBack();
                    SearchFragment.this.mIsAnimToClose = false;
                }
            }
        });
        slideYTo0.addNextAnimMode(scaleLeftToRightHideAnim);
        slideYTo0.start(this.mSearchInputContainer, new AnimCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.16
            @Override // com.xiaopeng.montecarlo.anim.AnimCallback
            public void onEvent(AnimEvent animEvent, View view2) {
                View sceneContentView2;
                if (AnimEvent.END != animEvent || (sceneContentView2 = SearchFragment.this.getSceneContentView()) == null) {
                    return;
                }
                sceneContentView2.animate().alpha(0.0f).start();
            }
        });
    }

    private void deleteAllFavorites() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "deleteAllFavorites");
        }
        if (this.mDeleteAllFavDia == null) {
            this.mDeleteAllFavDia = new XNoTitleDialog(activity);
        }
        this.mDeleteAllFavDia.setOkButtonText(R.string.ok_del_btn);
        if (this.mPresenter.isLoginXPAndBind()) {
            this.mDeleteAllFavDia.setContentText(R.string.favorite_delete_all_dialog_title);
        } else {
            this.mDeleteAllFavDia.setContentText(R.string.setting_del_user_history_data);
        }
        this.mDeleteAllFavDia.showClose(false);
        this.mDeleteAllFavDia.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchFragment.this.mFavoriteRecyclerView != null && SearchFragment.this.mFavoriteRecyclerView.getScrollState() == 0) {
                    SearchFragment.this.mFavoriteRecyclerView.setLock(true);
                    SearchFragment.this.mPresenter.deleteAllFavorites();
                }
                SearchFragment.this.mDeleteAllFavDia.dismiss();
            }
        });
        this.mDeleteAllFavDia.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchStatUtil.sendStatDataWhenDeleteAllFavoritesDialogCanceled(SearchFragment.this.getMainContext());
                SearchFragment.this.mDeleteAllFavDia.dismiss();
            }
        });
        addShowAndDismissListener(this.mDeleteAllFavDia, true, true);
        this.mDeleteAllFavDia.show();
        if (isSceneVuiEnabled() && this.mFavoriteRecyclerView.getVisibility() == 0) {
            CommonVuiHelper.getInstance().addDialogVuiSupport(this.mDeleteAllFavDia, "DeleteAllFavorites");
        }
    }

    private void addShowAndDismissListener(XDialog xDialog, boolean z, boolean z2) {
        if (xDialog == null) {
            return;
        }
        if (z) {
            xDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.19
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (SearchFragment.this.isSceneLegal() && SearchFragment.this.isSceneVuiEnabled()) {
                        SearchFragment.this.exitVuiScene();
                    }
                }
            });
        }
        if (z2) {
            xDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.20
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (SearchFragment.this.isSceneLegal() && SearchFragment.this.isSceneVuiEnabled()) {
                        SearchFragment.this.enterVuiScene();
                    }
                }
            });
        }
    }

    private void initScrollCallbacks() {
        if (this.mHistoryScrollCallback == null) {
            this.mHistoryScrollCallback = new XPObservableScrollViewCallbacks(this.mHistoryRecyclerView, this.mHaveMoreDataDecorator);
        }
        if (this.mFavoriteScrollCallback == null) {
            this.mFavoriteScrollCallback = new XPObservableScrollViewCallbacks(this.mFavoriteRecyclerView, this.mHaveMoreDataDecorator);
        }
        this.mHistoryRecyclerView.setScrollViewCallbacks(this.mHistoryScrollCallback);
        this.mFavoriteRecyclerView.setScrollViewCallbacks(this.mFavoriteScrollCallback);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setHistoryLoadParentVisible(boolean z) {
        if (z) {
            this.mPbHistoryLoad.setVisibility(0);
            this.mTvHistoryLoad.setVisibility(0);
            return;
        }
        this.mPbHistoryLoad.setVisibility(8);
        this.mTvHistoryLoad.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setSubContainerVisibleByFavorityType(boolean z) {
        if (z) {
            this.mFavoriteRecyclerView.setVisibility(4);
        } else {
            this.mFavoriteRecyclerView.setVisibility(0);
        }
        LinearLayout linearLayout = this.mSearchSubContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        this.mHistorySubContainer.setVisibility(4);
        this.mPbHistoryLoad.setVisibility(8);
        this.mTvHistoryLoad.setVisibility(8);
        updateRecyclerViewPosition(this.mFavoriteRecyclerView);
        XImageView xImageView = this.mHaveMoreDataDecorator;
        if (xImageView != null) {
            xImageView.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.shape_bg_indicator_down_with_corner));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setSubContainerVisibleBySearchType(boolean z) {
        this.mFavoriteRecyclerView.setVisibility(4);
        initSearchContainer();
        if (z) {
            this.mSearchSubContainer.setVisibility(4);
        } else {
            this.mSearchSubContainer.setVisibility(0);
        }
        this.mHistorySubContainer.setVisibility(4);
        updateRecyclerViewPosition(this.mSearchRecyclerView);
        XImageView xImageView = this.mHaveMoreDataDecorator;
        if (xImageView != null) {
            xImageView.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.shape_bg_indicator_down_with_corner));
        }
    }

    private void initSearchContainer() {
        if (this.mSearchSubContainer == null) {
            this.mSearchSubContainer = (LinearLayout) this.mSearchContainerSub.inflate();
            this.mSearchRecyclerView = (XPRecyclerView) this.mSearchSubContainer.findViewById(R.id.keyword_suggest_result);
            this.mSearchNoResultImg = (XImageView) this.mSearchSubContainer.findViewById(R.id.iv_search_no_result);
            this.mTvNoResultTitle = (XTextView) this.mSearchSubContainer.findViewById(R.id.tv_none_result);
            this.mTvNoResultContent = (XTextView) this.mSearchSubContainer.findViewById(R.id.tv_change_keyword);
            this.mSearchNoNetworkImg = (XImageView) this.mSearchSubContainer.findViewById(R.id.iv_search_no_network);
            this.mTvNoWifiTitle = (XTextView) this.mSearchSubContainer.findViewById(R.id.tv_none_result_nowifi);
            this.mTvNoWifiContent = (XTextView) this.mSearchSubContainer.findViewById(R.id.tv_online_retry);
            this.mSearchNoSuggestImg = (XImageView) this.mSearchSubContainer.findViewById(R.id.iv_search_no_suggest);
            this.mTvNoSugTitle = (XTextView) this.mSearchSubContainer.findViewById(R.id.tv_none_suggestion);
            this.mTvNoSugContent = (XTextView) this.mSearchSubContainer.findViewById(R.id.tv_right_bottom_tips);
            initSubSearchLayout();
            if (this.mSearchScrollCallback == null) {
                this.mSearchScrollCallback = new XPObservableScrollViewCallbacks(this.mSearchRecyclerView, this.mHaveMoreDataDecorator);
            }
            this.mSearchRecyclerView.setScrollViewCallbacks(this.mSearchScrollCallback);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setSubContainerVisibleByHistoryType(boolean z) {
        this.mFavoriteRecyclerView.setVisibility(4);
        LinearLayout linearLayout = this.mSearchSubContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        if (z) {
            this.mHistorySubContainer.setVisibility(4);
        } else {
            this.mHistorySubContainer.setVisibility(0);
        }
        updateRecyclerViewPosition(this.mHistoryRecyclerView);
    }

    private void updateRecyclerViewPosition(ObservableRecyclerView observableRecyclerView) {
        View view = this.mRecyclerViewHeader;
        if (view == null || observableRecyclerView == null) {
            return;
        }
        view.setTranslationY(0.0f);
        observableRecyclerView.setSelectionFromTop(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        onSearchResume();
    }

    private void onSearchResume() {
        if (Utils.isLandscape()) {
            hideIme();
        } else if (this.mIsCreate) {
            showIme();
        }
        this.mPresenter.onResume();
        resumeCacheData();
        updateFavoriteClickState();
        updateHomeCompanyDistance();
        this.mIsCreate = false;
        if (isSceneVuiEnabled() && VoiceFullScenesUtil.isHavePendingJob(this)) {
            L.i(TAG, L.formatVoiceFullScenesLog("onSearchResume need update scene"));
            VoiceFullScenesUtil.clearPendingJob(this);
            updateScene();
            updateListForVui();
        }
    }

    private void updateListForVui() {
        if (isSceneVuiEnabled()) {
            if (this.mFavoriteRecyclerView.getVisibility() == 0) {
                updateFavoriteListForVui();
                return;
            }
            XPRecyclerView xPRecyclerView = this.mSearchRecyclerView;
            if (xPRecyclerView != null && xPRecyclerView.getVisibility() == 0) {
                updateSearchListForVui();
            } else if (this.mHistoryRecyclerView.getVisibility() == 0) {
                updateHistoryListForVui();
            }
        }
    }

    private void updateHomeCompanyDistance() {
        if (this.mIsCreate) {
            return;
        }
        this.mPresenter.updateHomeCompanyDistance();
    }

    private void updateFavoriteClickState() {
        if (this.mIsCreate) {
            return;
        }
        if (XPAccountServiceWrapper.getInstance().isLoginXp()) {
            String userId = XPAccountServiceWrapper.getInstance().getUserId();
            L.Tag tag = TAG;
            L.i(tag, "onSearchResume currentUserId = " + userId + ", mLastUserId:" + this.mLastUserId);
            if (userId.equals(this.mLastUserId)) {
                return;
            }
            resetFavoriteClickState();
            this.mLastUserId = userId;
            return;
        }
        resetFavoriteClickState();
        if (L.ENABLE) {
            L.d(TAG, "onSearchResume login false");
        }
    }

    private void resetFavoriteClickState() {
        SearchPresenter searchPresenter = this.mPresenter;
        if (searchPresenter != null) {
            searchPresenter.setClickFavoriteBtn(false);
        }
        this.mLastUserId = "-1";
    }

    private void resumeCacheData() {
        Bundle bundle = this.mCachedData;
        if (bundle != null) {
            final SearchResultData searchResultData = (SearchResultData) bundle.getParcelable(CACHED_RESULT_DATA_KEY);
            if (searchResultData != null) {
                this.mCachedData.remove(CACHED_RESULT_DATA_KEY);
                runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.21
                    @Override // java.lang.Runnable
                    public void run() {
                        SearchFragment.this.mPresenter.onDataFetched(searchResultData);
                    }
                });
            }
            final SearchResultData searchResultData2 = (SearchResultData) this.mCachedData.getParcelable(CACHED_FAVORITE_RESULT_DATA_KEY);
            if (searchResultData2 != null) {
                this.mCachedData.remove(CACHED_FAVORITE_RESULT_DATA_KEY);
                runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.22
                    @Override // java.lang.Runnable
                    public void run() {
                        SearchFragment.this.mPresenter.onDataFetched(searchResultData2);
                    }
                });
            }
            final SearchResultData searchResultData3 = (SearchResultData) this.mCachedData.getParcelable(CACHED_HISTORY_RESULT_DATA_KEY);
            if (searchResultData3 != null) {
                this.mCachedData.remove(CACHED_HISTORY_RESULT_DATA_KEY);
                runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.23
                    @Override // java.lang.Runnable
                    public void run() {
                        SearchFragment.this.mPresenter.onDataFetched(searchResultData3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        dismissLoadingDialog();
        dismissFavoriteSyncDialog(false);
        this.mIsAnimToClose = false;
        hideIme();
        this.mPresenter.onPause();
        this.mLastUserId = XPAccountServiceWrapper.getInstance().getUserId();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onScenePause mLastUserId = " + this.mLastUserId);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        onSearchDestroyView();
        removeAllScrollListenerForVui();
        removeAllScrollCallback();
        this.mSearchAdapterCallback = null;
    }

    private void onSearchDestroyView() {
        this.mPresenter.onDestroyView();
        if (this.mHistoryAdapter != null) {
            this.mHistoryAdapter = null;
        }
        if (this.mFavoriteAdapter != null) {
            this.mFavoriteAdapter = null;
        }
        if (this.mSearchAdapter != null) {
            this.mSearchAdapter = null;
        }
        removeEtSearchListener();
        Unbinder unbinder = this.mButterBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        dismissDialog();
        if (this.mHandler.hasMessages(101)) {
            this.mHandler.removeMessages(101);
        }
        resetPageVuiState();
        removeRecyclerViewCallbacks();
        this.mHistoryRecordFirstVisiblePosition = -1;
        this.mHistoryRecordLastVisiblePosition = -1;
        this.mSearchRecordFirstVisiblePosition = -1;
        this.mSearchRecordLastVisiblePosition = -1;
        this.mFavoriteRecordFirstVisiblePosition = -1;
        this.mFavoriteRecordLastVisiblePosition = -1;
        this.mIvClearLayoutParams = null;
    }

    private void dismissDialog() {
        XLandLoadingDialog xLandLoadingDialog = this.mDialog;
        if (xLandLoadingDialog != null && xLandLoadingDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        XBindAmapDialog xBindAmapDialog = this.mBindAmapDialog;
        if (xBindAmapDialog != null) {
            xBindAmapDialog.dismiss();
            this.mBindAmapDialog = null;
        }
        dismissFavoriteSyncDialog(true);
        XTextDialog xTextDialog = this.mSetDiaWhenClick;
        if (xTextDialog != null) {
            xTextDialog.dismiss();
            this.mSetDiaWhenClick = null;
        }
        XTextDialog xTextDialog2 = this.mSetDiaWhenSysSug;
        if (xTextDialog2 != null) {
            xTextDialog2.dismiss();
            this.mSetDiaWhenSysSug = null;
        }
        XTextDialog xTextDialog3 = this.mAddWayPoiDia;
        if (xTextDialog3 != null) {
            xTextDialog3.dismiss();
            this.mAddWayPoiDia = null;
        }
        XTextDialog xTextDialog4 = this.mEdiHomComDia;
        if (xTextDialog4 != null) {
            xTextDialog4.dismiss();
            this.mEdiHomComDia = null;
        }
        XNoTitleDialog xNoTitleDialog = this.mDeleteAllFavDia;
        if (xNoTitleDialog != null) {
            xNoTitleDialog.dismiss();
            this.mDeleteAllFavDia = null;
        }
        XNoTitleDialog xNoTitleDialog2 = this.mDeleteHisDia;
        if (xNoTitleDialog2 != null) {
            xNoTitleDialog2.dismiss();
            this.mDeleteHisDia = null;
        }
    }

    private void dismissFavoriteSyncDialog(boolean z) {
        HomeCompanyConflictDialog homeCompanyConflictDialog = this.mFavoriteSyncDialog;
        if (homeCompanyConflictDialog != null) {
            if (homeCompanyConflictDialog.isShowing()) {
                this.mFavoriteSyncDialog.dismiss();
            }
            if (z) {
                this.mFavoriteSyncDialog = null;
            }
        }
    }

    private void removeRecyclerViewCallbacks() {
        XPRecyclerView xPRecyclerView = this.mHistoryRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.setAdapter((PageRecyclerAdapter) null);
            this.mHistoryRecyclerView.setCreateFooterCallback(null);
            this.mHistoryRecCreateCallback = null;
            this.mHistoryRecyclerView.setCreateHeaderCallback(null);
            this.mHistoryRecyclerView.setLoadMoreCallback(null);
            this.mHistoryRecyclerView.setOnPageCallback(null);
        }
        XPRecyclerView xPRecyclerView2 = this.mFavoriteRecyclerView;
        if (xPRecyclerView2 != null) {
            xPRecyclerView2.setAdapter((PageRecyclerAdapter) null);
            this.mFavoriteRecyclerView.setCreateFooterCallback(null);
            this.mFavoriteRecCreateCallback = null;
            this.mFavoriteRecyclerView.setCreateHeaderCallback(null);
            this.mFavoriteRecyclerView.setLoadMoreCallback(null);
            this.mFavoriteRecyclerView.setOnPageCallback(null);
        }
    }

    private void addEtSearchListener() {
        XEditText xEditText = this.mEtSearch;
        if (xEditText != null) {
            xEditText.addTextChangedListener(this.mTextChangeListener);
            this.mEtSearch.setOnKeyListener(this.mKeyListener);
        }
    }

    private void removeEtSearchListener() {
        XEditText xEditText = this.mEtSearch;
        if (xEditText != null) {
            xEditText.removeTextChangedListener(this.mTextChangeListener);
            this.mEtSearch.setOnKeyListener(null);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setEtSearchText(String str) {
        XEditText xEditText = this.mEtSearch;
        if (xEditText == null) {
            return;
        }
        xEditText.setText(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mEtSearch.setSelection(str.length());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setEtSearchTextWithoutChange(String str) {
        XEditText xEditText = this.mEtSearch;
        if (xEditText != null) {
            xEditText.removeTextChangedListener(this.mTextChangeListener);
            this.mEtSearch.setText(str);
            if (!TextUtils.isEmpty(str)) {
                this.mEtSearch.setSelection(str.length());
            }
            this.mEtSearch.addTextChangedListener(this.mTextChangeListener);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setTvAround(XPPoiInfo xPPoiInfo) {
        int breakText;
        if (xPPoiInfo == null) {
            return;
        }
        String name = xPPoiInfo.getName();
        if (new Paint().breakText(name, true, 70.0f, null) < xPPoiInfo.getName().length()) {
            name = xPPoiInfo.getName().substring(0, breakText) + "...";
        }
        this.mAroundLeft.setVisibility(0);
        this.mAroundRight.setVisibility(0);
        LinearLayout.LayoutParams secondLayoutParams = this.mAroundLeft.getSecondLayoutParams();
        secondLayoutParams.leftMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_around_content_margin);
        this.mAroundLeft.addOrUpdateTextWithLayoutParams(ResourceUtils.getString(R.string.search_hint_around_left), null, name, secondLayoutParams);
        LinearLayout.LayoutParams firstLayoutParams = this.mAroundRight.getFirstLayoutParams();
        firstLayoutParams.leftMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_around_content_margin);
        this.mAroundRight.addOrUpdateTextWithLayoutParams(ResourceUtils.getString(R.string.search_hint_around_right), firstLayoutParams, null, null);
        this.mEtSearch.setHint("");
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setSearchAdapterData(ArrayList<XPPoiInfo> arrayList) {
        if (arrayList != null) {
            this.mSearchAdapter.setData(arrayList);
            this.mSearchAdapter.setLoadMode(3);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setWayPointHint() {
        this.mEtSearch.setHint(R.string.search_hint_waypoint);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setSearchHomeAndCompany(int i) {
        String string;
        this.mOfficeContainer.setVisibility(8);
        this.mHomeContainer.setVisibility(8);
        this.mSearchHeaderLayout.setVisibility(8);
        if (i == 1001) {
            string = ContextUtils.getString(R.string.search_hint_home);
        } else {
            string = ContextUtils.getString(R.string.search_hint_office);
        }
        this.mEtSearch.setHint(string);
        this.mTvScanSearch.setVisibility(0);
        showLeftView(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setTvScanSearch() {
        this.mTvScanSearch.setVisibility(8);
        this.mSearchHeaderLayout.setVisibility(0);
        if (this.mPresenter.getSearchMode() == 101) {
            showFavoriteAndHotWord(true, false);
            return;
        }
        showFavoriteAndHotWord(true, true);
        initFavoriteButton();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setSearchContainerByAnimOne() {
        this.mSearchContainer.setVisibility(4);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setSearchContainerByAnimTwo() {
        this.mSearchInputContainer.setVisibility(4);
        this.mSearchContainer.setVisibility(4);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showFavoriteView() {
        resetFavoriteTitle(true);
        showLeftView(false);
        this.mFavoriteRecyclerView.setVisibility(0);
        XImageView xImageView = this.mHaveMoreDataDecorator;
        if (xImageView != null) {
            xImageView.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.shape_bg_indicator_down_with_corner));
        }
        if (isSceneVuiEnabled()) {
            disableViewsWhenFavoriteShowForVui();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void hideFavoriteView() {
        resetFavoriteTitle(false);
        showLeftView(true);
        this.mFavoriteUpdateTime.setVisibility(8);
        this.mFavoriteRecyclerView.setVisibility(8);
        XPRecyclerView xPRecyclerView = this.mFavoriteRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.resetPage();
        }
        XImageView xImageView = this.mHaveMoreDataDecorator;
        if (xImageView != null) {
            xImageView.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.shape_bg_indicator_down_with_right_corner));
        }
        if (isSceneVuiEnabled() && isSceneLegal()) {
            enableViewsWhenFavoriteHideForVui();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void resetFavoritePageState() {
        XPRecyclerView xPRecyclerView = this.mFavoriteRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.resetPage();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void resetHistoryPageState() {
        XPRecyclerView xPRecyclerView = this.mHistoryRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.resetPage();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateNextIcon(int i) {
        XImageButton xImageButton = this.mFavoriteNext;
        if (xImageButton != null) {
            xImageButton.setVisibility(i > 0 ? 0 : 8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showNoFavoriteDataToast() {
        showPrompt(R.string.favorite_list_empty_title);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showCancelFavoriteToast() {
        showPrompt(R.string.favorite_item_cancel_favorite_text);
    }

    private void resetFavoriteTitle(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "resetFavoriteTitle" + z);
        if (z) {
            removeEtSearchListener();
            this.mEtSearch.setFocusable(false);
            this.mEtSearch.setFocusableInTouchMode(false);
            this.mEtSearch.setText(ContextUtils.getString(R.string.search_category_favorite));
            hideIme();
            return;
        }
        this.mEtSearch.setText("");
        this.mEtSearch.setFocusable(true);
        this.mEtSearch.setFocusableInTouchMode(true);
        addEtSearchListener();
        if (Utils.isPortrait()) {
            showIme();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setLastFavoriteVisile(boolean z, boolean z2) {
        if (z) {
            doClickFavoriteAnim(this.mFavoriteRecyclerView, this.mHistorySubContainer, true);
        } else if (z2) {
            doClickFavoriteAnim(this.mFavoriteRecyclerView, this.mSearchSubContainer, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setNoLastFavoriteVisile(boolean z, boolean z2) {
        if (z) {
            doClickFavoriteAnim(this.mHistorySubContainer, this.mFavoriteRecyclerView, false);
        } else if (z2) {
            doClickFavoriteAnim(this.mSearchSubContainer, this.mFavoriteRecyclerView, false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setIvClearVisible(boolean z) {
        if (this.mIvClearLayoutParams == null) {
            this.mIvClearLayoutParams = (RelativeLayout.LayoutParams) this.mIvClear.getLayoutParams();
        }
        if (z) {
            this.mIvClear.setVisibility(0);
            SearchPresenter searchPresenter = this.mPresenter;
            if (searchPresenter != null && searchPresenter.isSetDest()) {
                this.mTvScanSearchLine.setVisibility(0);
                this.mIvClearLayoutParams.removeRule(21);
                this.mIvClearLayoutParams.addRule(0, R.id.search_vertical_line_scan);
                return;
            }
            this.mIvClearLayoutParams.removeRule(0);
            this.mIvClearLayoutParams.addRule(21);
            return;
        }
        this.mIvClear.setVisibility(4);
        this.mTvScanSearchLine.setVisibility(8);
        this.mIvClearLayoutParams.removeRule(0);
        this.mIvClearLayoutParams.addRule(21);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void cleanSearchAdapterData() {
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter != null) {
            searchAdapter.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroy() {
        super.onSceneDestroy();
    }

    private void removeAllScrollCallback() {
        XPRecyclerView xPRecyclerView = this.mHistoryRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.removeScrollViewCallbacks(this.mHistoryScrollCallback);
        }
        this.mHistoryScrollCallback = null;
        XPRecyclerView xPRecyclerView2 = this.mSearchRecyclerView;
        if (xPRecyclerView2 != null) {
            xPRecyclerView2.removeScrollViewCallbacks(this.mSearchScrollCallback);
        }
        this.mSearchScrollCallback = null;
        XPRecyclerView xPRecyclerView3 = this.mFavoriteRecyclerView;
        if (xPRecyclerView3 != null) {
            xPRecyclerView3.removeScrollViewCallbacks(this.mFavoriteScrollCallback);
        }
        this.mFavoriteScrollCallback = null;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public SearchPresenter mo116getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(SearchPresenter searchPresenter) {
        this.mPresenter = searchPresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setResult(RouteRequest routeRequest) {
        setReturnResult(routeRequest.toBundle());
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void setResultBundleData(int i, XPPoiInfo xPPoiInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_DEST_KEY, i);
        bundle.putParcelable(SearchBridge.SET_RESULT_OBJECT, xPPoiInfo);
        setReturnResult(bundle);
        goBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onBackResult(int i, Bundle bundle) {
        SearchPresenter searchPresenter;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("onBackResult requestCode:" + i));
        }
        if (100 == i) {
            setReturnResult(bundle);
            SearchPresenter searchPresenter2 = this.mPresenter;
            if (searchPresenter2 == null || !searchPresenter2.isSetDest()) {
                return;
            }
            goBack();
        } else if (101 != i) {
            if (102 == i) {
                setReturnResult(bundle);
                goBack();
            }
        } else {
            reInitVui();
            XPPoiInfo xPPoiInfo = (XPPoiInfo) bundle.getParcelable(SearchBridge.SET_RESULT_OBJECT);
            if (xPPoiInfo == null) {
                return;
            }
            int i2 = bundle.getInt(SearchBridge.SEARCH_DEST_KEY, 1000);
            if (i2 == 1001) {
                SearchPresenter searchPresenter3 = this.mPresenter;
                if (searchPresenter3 != null) {
                    searchPresenter3.setHomeText(xPPoiInfo, ContextUtils.getString(R.string.favorite_to_set));
                }
            } else if (i2 != 1002 || (searchPresenter = this.mPresenter) == null) {
            } else {
                searchPresenter.setCompanyText(xPPoiInfo, ContextUtils.getString(R.string.favorite_to_set));
            }
        }
    }

    private void reInitVui() {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.24
            @Override // java.lang.Runnable
            public void run() {
                if (SearchFragment.this.isSceneLegal()) {
                    SearchFragment.this.initSceneVui();
                    SearchFragment.this.onBuildScene();
                    SearchFragment.super.onSceneResume();
                }
            }
        }, 1000L);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    @UiThread
    public void updateAdapter(SearchResponseEvent searchResponseEvent) {
        if (isAdded()) {
            ArrayList<XPPoiInfo> arrayList = null;
            int i = -1;
            if (searchResponseEvent != null) {
                arrayList = searchResponseEvent.getList();
                i = searchResponseEvent.getErrorCode();
            }
            this.mPresenter.doSearchTips(this.mEtSearch.getText(), false, arrayList, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateMatchedTips(ArrayList<XPPoiInfo> arrayList) {
        XPRecyclerView xPRecyclerView = this.mSearchRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.removeAllViews();
            if (this.mSearchAdapter == null || this.mSearchRecyclerView.getScrollState() != 0 || this.mSearchRecyclerView.isComputingLayout()) {
                return;
            }
            this.mSearchAdapter.setSugDatas(arrayList);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    @UiThread
    public void updateSugAdapter(List<HistoryRecordInfo> list) {
        XPRecyclerView xPRecyclerView;
        if (this.mSearchAdapter == null || (xPRecyclerView = this.mSearchRecyclerView) == null || xPRecyclerView.getScrollState() != 0 || this.mSearchRecyclerView.isComputingLayout()) {
            return;
        }
        this.mSearchAdapter.setRecordInfos(list);
        if (L.ENABLE) {
            L.d(TAG, L.formatVoiceFullScenesLog("updateSugAdapter"));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateFavoriteAdapter(List<FavoriteAddress> list, boolean z, boolean z2) {
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("updateFavoriteAdapter isPaging:");
        sb.append(z);
        sb.append(", list:");
        sb.append(list == null ? 0 : list.size());
        L.i(tag, sb.toString());
        if (z) {
            FavoriteAdapter favoriteAdapter = this.mFavoriteAdapter;
            if (favoriteAdapter != null) {
                favoriteAdapter.addData(list, z2);
            }
        } else {
            if (this.mFavoriteRecyclerView != null) {
                if (CollectionUtils.isEmpty(list)) {
                    this.mFavoriteNext.setVisibility(8);
                    if (this.mPresenter.isFavoriteShow()) {
                        this.mPresenter.closeFavorite();
                    } else {
                        showNoFavoriteDataToast();
                    }
                } else {
                    this.mFavoriteAdapter.setData(new ArrayList(list));
                    this.mFavoriteNext.setVisibility(0);
                    L.Tag tag2 = TAG;
                    L.i(tag2, "isClickFavoriteBtn:" + this.mPresenter.isClickFavoriteBtn() + ", isFavoriteShow:" + this.mPresenter.isFavoriteShow());
                    if (this.mPresenter.isClickFavoriteBtn() || this.mPresenter.isFavoriteShow()) {
                        this.mPresenter.showFavoriteView();
                    }
                }
            }
            initFavoriteButton();
            if (this.mPresenter.isClickFavoriteBtn()) {
                this.mPresenter.setClickFavoriteBtn(false);
            }
        }
        XPRecyclerView xPRecyclerView = this.mFavoriteRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.setLock(false);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateForFavoriteItemClick(int i) {
        List<FavoriteAddress> data;
        FavoriteAdapter favoriteAdapter = this.mFavoriteAdapter;
        if (favoriteAdapter == null || (data = favoriteAdapter.getData()) == null || data.size() <= i) {
            return;
        }
        data.add(0, data.remove(i));
        this.mFavoriteAdapter.notifyItemRangeChanged(0, i + 1);
        XPRecyclerView xPRecyclerView = this.mFavoriteRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.scrollToPosition(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void deleteFavorite(boolean z, int i, boolean z2) {
        FavoriteAdapter favoriteAdapter;
        if (!isAdded() || (favoriteAdapter = this.mFavoriteAdapter) == null) {
            return;
        }
        favoriteAdapter.notifyChangeForDelete(z, i);
        this.mPresenter.requestFavouriteList(1);
        if (z || CollectionUtils.isEmpty(this.mFavoriteAdapter.getData())) {
            updateFavoriteAdapter(null, false, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateEmptyHistoryList() {
        this.mPbHistoryLoad.setVisibility(8);
        this.mTvHistoryLoad.setVisibility(8);
        if (this.mSearchTipView == null) {
            this.mSearchTipView = this.mSearchTipStub.inflate();
        }
        if (this.mHistoryNoImg == null) {
            this.mHistoryNoImg = (XImageView) this.mSearchTipView.findViewById(R.id.iv_search_tip);
        }
        if (this.mNoRecordTitleView == null) {
            this.mNoRecordTitleView = (XTextView) this.mSearchTipView.findViewById(R.id.tv_search_tip_title);
        }
        if (this.mNoRecordTipView == null) {
            this.mNoRecordTipView = (XTextView) this.mSearchTipView.findViewById(R.id.tv_search_tip_context1);
        }
        if (this.mNoRecordTipSubView == null) {
            this.mNoRecordTipSubView = (XTextView) this.mSearchTipView.findViewById(R.id.tv_search_tip_context2);
        }
        this.mSearchTipView.setVisibility(0);
        this.mHistoryRecyclerView.setVisibility(8);
        updateRecyclerViewPosition(this.mHistoryRecyclerView);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showHistoryListOrHistoryEmptyView() {
        if (isSceneLegal()) {
            HistoryRecordAdapter historyRecordAdapter = this.mHistoryAdapter;
            if (historyRecordAdapter != null && CollectionUtils.isEmpty(historyRecordAdapter.getData())) {
                updateEmptyHistoryList();
                return;
            }
            this.mPbHistoryLoad.setVisibility(8);
            this.mTvHistoryLoad.setVisibility(8);
            View view = this.mSearchTipView;
            if (view != null) {
                view.setVisibility(8);
            }
            this.mHistoryRecyclerView.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showSwitchCityTip(final XPPoiInfo xPPoiInfo) {
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.25
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(xPPoiInfo.getName())) {
                    SearchFragment.this.showPrompt(ContextUtils.getString(R.string.search_switch_city_toast, xPPoiInfo.getName()));
                }
                SearchFragment.this.goBack();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void setBackMapStatusByRequestCodeDelegate(MapStatus mapStatus, int i) {
        if (this.mPresenter.isSwitchedCity()) {
            mapStatus.setMapStatus(this.mPresenter.getSwitchedCityMapStatus());
        } else {
            super.setBackMapStatusByRequestCodeDelegate(mapStatus, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void hideIme() {
        if (this.mEtSearch == null || getActivity() == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive(this.mEtSearch)) {
            this.mEtSearch.setFocusable(false);
            View sceneContentView = getSceneContentView();
            if (sceneContentView != null) {
                sceneContentView.requestFocus();
            }
            try {
                boolean hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(this.mEtSearch.getWindowToken(), 0);
                L.Tag tag = TAG;
                L.d(tag, "hideIme bool:" + hideSoftInputFromWindow);
                return;
            } catch (IllegalArgumentException unused) {
                L.w(TAG, "hideSoftInputFromWindow error");
                return;
            }
        }
        L.d(TAG, "hideIme : There is no need to hide the keyboard.");
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateSearchTips(int i) {
        this.mPresenter.initSubContainerVisible(0, false);
        if (i == 1) {
            disableViewsWhenSuggestShowForVui();
            this.mSearchRecyclerView.setVisibility(0);
            this.mSearchNoResultImg.setVisibility(8);
            this.mTvNoResultTitle.setVisibility(8);
            this.mTvNoResultContent.setVisibility(8);
            this.mSearchNoNetworkImg.setVisibility(8);
            this.mTvNoWifiTitle.setVisibility(8);
            this.mTvNoWifiContent.setVisibility(8);
            this.mSearchNoSuggestImg.setVisibility(8);
            this.mTvNoSugTitle.setVisibility(8);
            this.mTvNoSugContent.setVisibility(8);
        } else if (i == 2) {
            enableViewsWhenSuggestHideForVui();
            this.mSearchRecyclerView.setVisibility(8);
            this.mSearchNoResultImg.setVisibility(8);
            this.mTvNoResultTitle.setVisibility(8);
            this.mTvNoResultContent.setVisibility(8);
            this.mSearchNoNetworkImg.setVisibility(8);
            this.mTvNoWifiTitle.setVisibility(8);
            this.mTvNoWifiContent.setVisibility(8);
            this.mSearchNoSuggestImg.setVisibility(8);
            this.mTvNoSugTitle.setVisibility(8);
            this.mTvNoSugContent.setVisibility(8);
        } else if (i == 3) {
            enableViewsWhenSuggestHideForVui();
            this.mSearchRecyclerView.setVisibility(8);
            this.mSearchNoResultImg.setVisibility(0);
            this.mTvNoResultTitle.setVisibility(0);
            this.mTvNoResultContent.setVisibility(0);
            this.mSearchNoNetworkImg.setVisibility(8);
            this.mTvNoWifiTitle.setVisibility(8);
            this.mTvNoWifiContent.setVisibility(8);
            this.mSearchNoSuggestImg.setVisibility(8);
            this.mTvNoSugTitle.setVisibility(8);
            this.mTvNoSugContent.setVisibility(8);
        } else if (i == 4) {
            enableViewsWhenSuggestHideForVui();
            this.mSearchRecyclerView.setVisibility(8);
            this.mSearchNoResultImg.setVisibility(8);
            this.mTvNoResultTitle.setVisibility(8);
            this.mTvNoResultContent.setVisibility(8);
            this.mSearchNoNetworkImg.setVisibility(0);
            this.mTvNoWifiTitle.setVisibility(0);
            this.mTvNoWifiContent.setVisibility(0);
            this.mSearchNoSuggestImg.setVisibility(8);
            this.mTvNoSugTitle.setVisibility(8);
            this.mTvNoSugContent.setVisibility(8);
        } else if (i != 5) {
        } else {
            enableViewsWhenSuggestHideForVui();
            this.mSearchRecyclerView.setVisibility(8);
            this.mSearchNoResultImg.setVisibility(8);
            this.mTvNoResultTitle.setVisibility(8);
            this.mTvNoResultContent.setVisibility(8);
            this.mSearchNoNetworkImg.setVisibility(8);
            this.mTvNoWifiTitle.setVisibility(8);
            this.mTvNoWifiContent.setVisibility(8);
            this.mSearchNoSuggestImg.setVisibility(0);
            this.mTvNoSugTitle.setVisibility(0);
            this.mTvNoSugContent.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showLoadingDialog() {
        if (this.mDialog == null) {
            this.mDialog = new XLandLoadingDialog(getActivity());
            this.mDialog.setMessage(ContextUtils.getString(R.string.dialog_loading_message));
            this.mDialog.setOnCancelListener(new XLoadingCancelButtonAction(this));
            this.mDialog.setCancelable(false);
        }
        if (this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        L.i(TAG, "showLoadingDialog");
        this.mDialog.show();
        this.mDialog.correctedLocation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Utils.isLandscape()) {
            L.Tag tag = TAG;
            L.i(tag, "id " + view.getId());
            switch (view.getId()) {
                case R.id.container_change_home /* 2131296505 */:
                    XRelativeLayout xRelativeLayout = this.mContainerChangeHome;
                    if (xRelativeLayout == null || !preventMultiClick(xRelativeLayout)) {
                        return;
                    }
                    SearchStatUtil.sendStatDataWhenHomeEdit(getMainContext());
                    showEditHomeCompanyDialog(1001, this.mPresenter.getHomeXPPoiInfo());
                    return;
                case R.id.container_change_office /* 2131296506 */:
                    XRelativeLayout xRelativeLayout2 = this.mContainerChangeOffice;
                    if (xRelativeLayout2 == null || !preventMultiClick(xRelativeLayout2)) {
                        return;
                    }
                    SearchStatUtil.sendStatDataWhenOfficeEdit(getMainContext());
                    showEditHomeCompanyDialog(1002, this.mPresenter.getCompanyXPPoiInfo());
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void dismissLoadingDialog() {
        XLandLoadingDialog xLandLoadingDialog = this.mDialog;
        if (xLandLoadingDialog == null || !xLandLoadingDialog.isShowing()) {
            return;
        }
        L.i(TAG, "dismissLoadingDialog");
        this.mDialog.dismiss();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void unRegister() {
        SearchPresenter searchPresenter = this.mPresenter;
        if (searchPresenter != null) {
            searchPresenter.unRegisterAccountObserver();
            this.mPresenter.unRegisterAccountEventCallback();
        }
        unRegisterEventBus();
    }

    private void showDeleteHistoryDialog() {
        if (L.ENABLE) {
            L.d(TAG, "showDeleteHistoryDialog");
        }
        if (this.mDeleteHisDia == null) {
            this.mDeleteHisDia = new XNoTitleDialog(getActivity());
        }
        this.mDeleteHisDia.setOkButtonText(R.string.ok_del_btn);
        this.mDeleteHisDia.setContentText(R.string.setting_del_user_history_data);
        this.mDeleteHisDia.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchFragment.this.mHistoryRecyclerView != null && SearchFragment.this.mHistoryRecyclerView.getScrollState() == 0) {
                    SearchFragment.this.mHistoryRecyclerView.setLock(true);
                    SearchStatUtil.sendStatDataWhenDeleteAllHistoriesDialogConfirmed();
                    SearchFragment.this.mPresenter.deleteHistoryRecords();
                }
                SearchFragment.this.mDeleteHisDia.dismiss();
            }
        });
        this.mDeleteHisDia.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchStatUtil.sendStatDataWhenDeleteAllHistoriesDialogCanceled();
                SearchFragment.this.mDeleteHisDia.dismiss();
            }
        });
        addShowAndDismissListener(this.mDeleteHisDia, true, true);
        this.mDeleteHisDia.show();
        if (isSceneVuiEnabled() && this.mHistoryRecyclerView.getVisibility() == 0) {
            CommonVuiHelper.getInstance().addDialogVuiSupport(this.mDeleteHisDia, "DeleteHistoryDialog");
        }
    }

    private void editDialogText(int i, XPPoiInfo xPPoiInfo, @NonNull XTextDialog xTextDialog) {
        boolean z;
        String string;
        String address = Utils.getAddress(xPPoiInfo);
        if (TextUtils.isEmpty(address)) {
            address = xPPoiInfo.getName();
            z = !TextUtils.isEmpty(address);
        } else {
            z = false;
        }
        if (z) {
            string = ContextUtils.getString(i == 1001 ? R.string.home_edit_title_no_name : R.string.company_edit_title_no_name);
        } else {
            String string2 = ContextUtils.getString(R.string.company_edit_unknow);
            if (!TextUtils.isEmpty(xPPoiInfo.getName())) {
                string2 = xPPoiInfo.getName();
            } else if (!TextUtils.isEmpty(xPPoiInfo.getAddress())) {
                string2 = xPPoiInfo.getAddress();
            }
            string = i == 1001 ? ContextUtils.getString(R.string.home_edit_title, string2) : ContextUtils.getString(R.string.company_edit_title, string2);
        }
        if (xTextDialog != null) {
            xTextDialog.setTitle(string);
            xTextDialog.setContentText(ContextUtils.getString(R.string.address_edit_content, address));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showAddWayPointDialog(final int i, final XPPoiInfo xPPoiInfo) {
        if (this.mAddWayPoiDia == null) {
            this.mAddWayPoiDia = new XTextDialog(getActivity());
        }
        this.mAddWayPoiDia.showClose(false);
        this.mAddWayPoiDia.setOkButtonText(R.string.poi_setting_waypoint);
        this.mAddWayPoiDia.setCancelButtonText(R.string.go_to_poi);
        editDialogText(i, xPPoiInfo, this.mAddWayPoiDia);
        this.mAddWayPoiDia.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mPresenter.sendStatWhenSettingDialogAdd(i);
                SearchFragment.this.mPresenter.addWayPoint(xPPoiInfo);
                SearchFragment.this.mAddWayPoiDia.dismiss();
            }
        });
        this.mAddWayPoiDia.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mPresenter.sendStatWhenSettingDialogStartNavi(i);
                SearchFragment.this.mPresenter.addNewNavi(xPPoiInfo);
                SearchFragment.this.mAddWayPoiDia.dismiss();
            }
        });
        addShowAndDismissListener(this.mAddWayPoiDia, true, true);
        this.mAddWayPoiDia.show();
        if (isSceneVuiEnabled()) {
            CommonVuiHelper.getInstance().addDialogVuiSupport(this.mAddWayPoiDia, "AddWayPointDialog");
        }
    }

    public void showEditHomeCompanyDialog(final int i, XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            L.Tag tag = TAG;
            L.w(tag, "editHomeCompany info = " + xPPoiInfo);
            return;
        }
        hideIme();
        if (this.mEdiHomComDia == null) {
            this.mEdiHomComDia = new XTextDialog(getActivity());
        }
        editDialogText(i, xPPoiInfo, this.mEdiHomComDia);
        this.mEdiHomComDia.setOkButtonText(R.string.company_edit_positive_text);
        this.mEdiHomComDia.showCancelButton(false);
        this.mEdiHomComDia.showClose(false);
        this.mEdiHomComDia.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mPresenter.editHomeCompany(i);
                SearchFragment.this.mEdiHomComDia.dismiss();
            }
        });
        addShowAndDismissListener(this.mEdiHomComDia, true, true);
        this.mEdiHomComDia.show();
        if (isSceneVuiEnabled()) {
            CommonVuiHelper.getInstance().addDialogVuiSupport(this.mEdiHomComDia, "EditHomeCompanyDialog");
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public String getSearchCarWash() {
        return getString(R.string.search_category_carwash);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public String[] getSearchCommonKeywords() {
        return getResources().getStringArray(R.array.search_common_keywords);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public String getSearchCategoryCharge() {
        return getString(R.string.search_category_charge);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updatePoiDistance(boolean z, long j, long j2) {
        View sceneContentView;
        if (isSceneLegal() && (sceneContentView = getSceneContentView()) != null) {
            updateSceneAddressForVui(z);
            XTextView xTextView = (XTextView) sceneContentView.findViewById(z ? R.id.tv_home_tips_dis : R.id.tv_office_tips_dis);
            if (xTextView != null) {
                String distanceNoSpaceString = j2 > 0 ? NaviUtil.getDistanceNoSpaceString(j2) : "";
                if (TextUtils.isEmpty(distanceNoSpaceString)) {
                    xTextView.setVisibility(8);
                } else {
                    xTextView.setVisibility(0);
                    xTextView.setText(distanceNoSpaceString);
                }
            }
            XTextView xTextView2 = (XTextView) sceneContentView.findViewById(z ? R.id.tv_home_tips_time : R.id.tv_office_tips_time);
            if (xTextView2 == null) {
                return;
            }
            String timeString = j > 0 ? NaviUtil.getTimeString(j) : "";
            if (j2 < 1000 || TextUtils.isEmpty(timeString)) {
                xTextView2.setVisibility(8);
                return;
            }
            xTextView2.setVisibility(0);
            xTextView2.setText(timeString);
        }
    }

    private void updateSceneAddressForVui(boolean z) {
        if (isSceneVuiEnabled()) {
            if (z) {
                SearchVuiHelper.getInstance().updateHomeForVui(this.mHomeContainer, getVuiSceneId());
            } else {
                SearchVuiHelper.getInstance().updateOfficeForVui(this.mOfficeContainer, getVuiSceneId());
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateTrafficBar(boolean z, ILightBarInfo iLightBarInfo, long j, long j2) {
        if (z) {
            if (iLightBarInfo == null || j < 1000) {
                this.mTrafficBarHome.setVisibility(8);
                return;
            }
            this.mTrafficBarHome.setVisibility(0);
            this.mTrafficBarHome.updateTrafficBarVariantPath(j);
            this.mTrafficBarHome.setLeftDistance(j2);
            this.mTrafficBarHome.setLightBarInfo(iLightBarInfo, 0, true);
        } else if (iLightBarInfo == null || j < 1000) {
            this.mTrafficBarOffice.setVisibility(8);
        } else {
            this.mTrafficBarOffice.setVisibility(0);
            this.mTrafficBarOffice.updateTrafficBarVariantPath(j);
            this.mTrafficBarOffice.setLeftDistance(j2);
            this.mTrafficBarOffice.setLightBarInfo(iLightBarInfo, 0, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void cacheResultData(SearchResultData searchResultData) {
        if (searchResultData == null) {
            return;
        }
        if (searchResultData.getSearchType() == 0) {
            this.mCachedData.putParcelable(CACHED_FAVORITE_RESULT_DATA_KEY, searchResultData);
        } else if (1 == searchResultData.getSearchType()) {
            this.mCachedData.putParcelable(CACHED_HISTORY_RESULT_DATA_KEY, searchResultData);
        } else {
            this.mCachedData.putParcelable(CACHED_RESULT_DATA_KEY, searchResultData);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startNaviScene(RouteRequest routeRequest) {
        Bundle bundle = routeRequest.toBundle();
        bundle.putBoolean(SystemConst.ROUTE_MANUAL, true);
        startScene(new NaviBridge().setBundle(bundle));
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startSearchResultScene(PresenterData presenterData, int i) {
        startScene(new SearchResultBridge().setBundle(new BundleUtil().searchBundleToBundle(presenterData)), i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startSearchScene(PresenterData presenterData, int i) {
        L.i(TAG, "open search with over mode for setting home or office");
        startScene(new SearchBridge(StatusConst.Mode.SET_HOME_OFFICE).enableOverMode().setBundle(new BundleUtil().searchBundleToBundle(presenterData)), i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startScanSearchScene(PresenterData presenterData, int i) {
        startScene(new ScanSearchBridge().setBundle(new BundleUtil().searchBundleToBundle(presenterData)), i);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startRouteScene(RouteRequest routeRequest) {
        startScene(new RouteBridge().setBundle(routeRequest.toBundle()));
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void startExploreScene(RouteRequest routeRequest) {
        startScene(new ExploreBridge().setBundle(routeRequest.toBundle()));
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public boolean isAmapHomeConflict() {
        return SettingWrapper.getAmapHomeConflictStatus();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public boolean isAmapCompanyConflict() {
        return SettingWrapper.getAMapCompanyConflictStatus();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void deleteHistoryRecords() {
        HistoryRecordAdapter historyRecordAdapter = this.mHistoryAdapter;
        if (historyRecordAdapter != null) {
            historyRecordAdapter.removeAllItem();
        }
        XPRecyclerView xPRecyclerView = this.mHistoryRecyclerView;
        if (xPRecyclerView != null) {
            xPRecyclerView.setLock(false);
        }
        updateEmptyHistoryList();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void deleteHistoryRecord(int i) {
        HistoryRecordAdapter historyRecordAdapter;
        if (!isAdded() || (historyRecordAdapter = this.mHistoryAdapter) == null) {
            return;
        }
        historyRecordAdapter.notifyChangeForDelete(i);
        if (CollectionUtils.isEmpty(this.mHistoryAdapter.getData())) {
            updateEmptyHistoryList();
        }
        this.mPresenter.requestHistoryList(1);
        if (isSceneVuiEnabled()) {
            SearchVuiHelper.getInstance().updateSceneForVui(this.mHistoryRecyclerView, this, null, this.mPresenter.getSearchDest());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateHome(FavoriteAddress favoriteAddress) {
        SearchPresenter searchPresenter = this.mPresenter;
        if (searchPresenter != null) {
            searchPresenter.setHomeText(favoriteAddress.getXPPoiInfo(), ContextUtils.getString(R.string.favorite_to_set));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateCompany(FavoriteAddress favoriteAddress) {
        SearchPresenter searchPresenter = this.mPresenter;
        if (searchPresenter != null) {
            searchPresenter.setCompanyText(favoriteAddress.getXPPoiInfo(), ContextUtils.getString(R.string.favorite_to_set));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateEmptyHomeText() {
        XRelativeLayout xRelativeLayout = this.mContainerChangeHome;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(8);
        }
        this.mIvChangeHome.setVisibility(8);
        this.mTvSetHome.setVisibility(0);
        this.mTvHomeTipsDis.setText("");
        this.mTvHomeTipsTime.setText("");
        this.mTrafficBarHome.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateDefaultHomeText() {
        XRelativeLayout xRelativeLayout = this.mContainerChangeHome;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(8);
        }
        this.mIvChangeHome.setVisibility(8);
        this.mTvSetHome.setVisibility(0);
        this.mTvSetHome.setText(ContextUtils.getString(R.string.go_home));
        this.mTvHomeTipsDis.setText("");
        this.mTvHomeTipsTime.setText("");
        this.mTrafficBarHome.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateHomeText() {
        XRelativeLayout xRelativeLayout = this.mContainerChangeHome;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(0);
        }
        this.mIvChangeHome.setVisibility(0);
        this.mTvSetHome.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateEmptyCompanyText() {
        XRelativeLayout xRelativeLayout = this.mContainerChangeOffice;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(8);
        }
        this.mIvChangeOffice.setVisibility(8);
        this.mTvSetOffice.setVisibility(0);
        this.mTvOfficeTipsDis.setText("");
        this.mTvOfficeTipsDisTime.setText("");
        this.mTrafficBarOffice.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateDefaultCompanyText() {
        XRelativeLayout xRelativeLayout = this.mContainerChangeOffice;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(8);
        }
        this.mIvChangeOffice.setVisibility(8);
        this.mTvSetOffice.setVisibility(0);
        this.mTvSetOffice.setText(ContextUtils.getString(R.string.to_company));
        this.mTvOfficeTipsDis.setText("");
        this.mTvOfficeTipsDisTime.setText("");
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateCompanyText() {
        XRelativeLayout xRelativeLayout = this.mContainerChangeOffice;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(0);
        }
        this.mIvChangeOffice.setVisibility(0);
        this.mTvSetOffice.setVisibility(8);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showSettingAlertWhenSystemSuggest(int i) {
        String string;
        String format;
        if (this.mPresenter.getSearchDest() == 1000 && isSceneLegal() && i != 0) {
            if (1 == i) {
                if (SearchSceneDataHelper.home == null) {
                    return;
                }
                string = ContextUtils.getString(R.string.title_not_setting_home);
                format = String.format(ContextUtils.getString(R.string.content_not_setting_home_when_click), SearchSceneDataHelper.home.getName());
                HomeOrOfficeSuggestStatUtil.sendStatDataWhenHomeSugDialogShow();
            } else if (SearchSceneDataHelper.company == null) {
                return;
            } else {
                string = ContextUtils.getString(R.string.title_not_setting_company);
                format = String.format(ContextUtils.getString(R.string.content_not_setting_company_when_click), SearchSceneDataHelper.company.getName());
                HomeOrOfficeSuggestStatUtil.sendStatDataWhenOfficeSugDialogShow();
            }
            showSettingDialogWhenSystemSuggest(i, string, format);
        }
    }

    private void showSettingDialogWhenSystemSuggest(final int i, String str, String str2) {
        if (this.mSetDiaWhenSysSug == null) {
            this.mSetDiaWhenSysSug = new XTextDialog(getActivity());
        }
        this.mSetDiaWhenSysSug.setTitle(str);
        this.mSetDiaWhenSysSug.setContentText(str2);
        this.mSetDiaWhenSysSug.setOkButtonText(R.string.btn_tittle_setting_for_me);
        this.mSetDiaWhenSysSug.setCancelButtonText(R.string.btn_tittle_no_setting_for_me);
        this.mSetDiaWhenSysSug.showClose(false);
        this.mSetDiaWhenSysSug.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mPresenter.handleAddSuggestForMe(i, true);
                SearchFragment.this.mSetDiaWhenSysSug.dismiss();
            }
        });
        this.mSetDiaWhenSysSug.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mSetDiaWhenSysSug.dismiss();
                SearchFragment.this.mPresenter.handleCancelAddSuggestForMe(i, true);
            }
        });
        addShowAndDismissListener(this.mSetDiaWhenSysSug, true, true);
        this.mSetDiaWhenSysSug.show();
        if (isSceneVuiEnabled()) {
            CommonVuiHelper.getInstance().addDialogVuiSupport(this.mSetDiaWhenSysSug, "SettingDialogWhenSystemSuggest");
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showSettingAlertWhenClick(int i) {
        String string;
        String format;
        if (!isSceneLegal() || i == 0) {
            return;
        }
        if (1 == i) {
            if (SearchSceneDataHelper.home == null) {
                return;
            }
            string = ContextUtils.getString(R.string.title_not_setting_home);
            format = String.format(ContextUtils.getString(R.string.content_not_setting_home_when_click), SearchSceneDataHelper.home.getName());
        } else if (SearchSceneDataHelper.company == null) {
            return;
        } else {
            string = ContextUtils.getString(R.string.title_not_setting_company);
            format = String.format(ContextUtils.getString(R.string.content_not_setting_company_when_click), SearchSceneDataHelper.company.getName());
        }
        showSettingDialogWhenClick(i, string, format);
    }

    private void showSettingDialogWhenClick(final int i, String str, String str2) {
        if (this.mSetDiaWhenClick == null) {
            this.mSetDiaWhenClick = new XTextDialog(getActivity());
        }
        this.mSetDiaWhenClick.setTitle(str);
        this.mSetDiaWhenClick.setContentText(str2);
        this.mSetDiaWhenClick.setOkButtonText(R.string.btn_tittle_setting_for_me);
        this.mSetDiaWhenClick.setCancelButtonText(R.string.btn_tittle_no_setting_for_me);
        this.mSetDiaWhenClick.showClose(false);
        this.mSetDiaWhenClick.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mPresenter.handleAddSuggestForMe(i, false);
                SearchFragment.this.mSetDiaWhenClick.dismiss();
            }
        });
        this.mSetDiaWhenClick.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mPresenter.handleCancelAddSuggestForMe(i, false);
                SearchFragment.this.mSetDiaWhenClick.dismiss();
            }
        });
        addShowAndDismissListener(this.mSetDiaWhenClick, true, true);
        this.mSetDiaWhenClick.show();
        if (isSceneVuiEnabled()) {
            CommonVuiHelper.getInstance().addDialogVuiSupport(this.mSetDiaWhenClick, "SettingDialogWhenClick");
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showFavoriteSyncConflictDialog() {
        HomeCompanyConflictDialog homeCompanyConflictDialog = this.mFavoriteSyncDialog;
        if (homeCompanyConflictDialog != null && homeCompanyConflictDialog.isShowing()) {
            this.mFavoriteSyncDialog.cancel();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.mFavoriteSyncDialog = new HomeCompanyConflictDialog(activity);
            this.mFavoriteSyncDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.35
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    SearchFragment.this.mPresenter.resetHomeCompany();
                }
            });
            this.mFavoriteSyncDialog.show();
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateFavSyncTimeView(long j) {
        if (this.mFavoriteUpdateTime != null) {
            this.mFavoriteUpdateTime.setText(ContextUtils.getString(R.string.favorite_update_time_text, new SimpleDateFormat(TimeFormatUtil.DATE_TIME_PATTERN_FORMAT_CN).format(new Date(j))));
            this.mFavoriteUpdateTime.setVisibility(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showSecBindAMapDialog() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        final XLandLoadingDialog xLandLoadingDialog = new XLandLoadingDialog(activity);
        xLandLoadingDialog.setMessage(activity.getString(R.string.search_result_loading_text));
        xLandLoadingDialog.correctedLocation();
        this.mBindAmapDialog = new XBindAmapDialog();
        this.mBindAmapDialog.setLoadingDialog(xLandLoadingDialog);
        SearchStatUtil.sendStatDataWhenbindAmapDialogShow(getMainContext());
        this.mBindAmapDialog.setCancelOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFragment.this.mBindAmapDialog.dismiss();
                xLandLoadingDialog.dismiss();
            }
        });
        this.mBindAmapDialog.openProtocolView(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.-$$Lambda$SearchFragment$0xup_NIzK3JU4EBN1857e48r8Vw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchFragment.this.lambda$showSecBindAMapDialog$0$SearchFragment(view);
            }
        });
        this.mBindAmapDialog.setOkOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchFragment.this.mDialogManager == null) {
                    SearchFragment searchFragment = SearchFragment.this;
                    searchFragment.mDialogManager = new DialogManager(searchFragment.mBindAmapDialog);
                }
                SearchFragment.this.mDialogManager.secBindAMap();
                xLandLoadingDialog.show();
            }
        });
        this.mBindAmapDialog.setXBindAmapDialogListener(new XBindAmapDialog.OnXBindAmapDialogListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.38
            @Override // com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.OnXBindAmapDialogListener
            public void onXBindAmapDialogShow(XDialogView xDialogView) {
                if (SearchFragment.this.isSceneVuiEnabled()) {
                    SearchFragment.this.exitVuiScene();
                    CommonVuiHelper.getInstance().addDialogVuiSupport(xDialogView, "SecBindAMapDialog");
                }
            }

            @Override // com.xiaopeng.montecarlo.views.dialog.XBindAmapDialog.OnXBindAmapDialogListener
            public void onXBindAmapDialogDismiss(XDialogView xDialogView) {
                if (SearchFragment.this.isSceneVuiEnabled()) {
                    SearchFragment.this.enterVuiScene();
                }
            }
        });
        this.mBindAmapDialog.show(getFragmentManager(), TAG_BIND_AMAP_DIALOG);
    }

    public /* synthetic */ void lambda$showSecBindAMapDialog$0$SearchFragment(View view) {
        ProtocolDialog.showProtocol(getContext(), 0);
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public BaseBridge getBaseBridge() {
        return getBridge();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showSettingHomeSuccess(boolean z) {
        if (isSceneLegal()) {
            showPrompt(z ? R.string.action_set_home_success : R.string.action_set_home_failure);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showSettingCompanySuccess(boolean z) {
        if (isSceneLegal()) {
            showPrompt(z ? R.string.action_set_company_success : R.string.action_set_company_failure);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public String getSearchKeyword() {
        if (this.mEtSearch.getText() == null) {
            return null;
        }
        return this.mEtSearch.getText().toString();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    @OnClick({R.id.btn_return})
    public void onClickBack() {
        L.i(TAG, "onClickBack");
        resetOriginVuiState();
        if (this.mPresenter.isSetDest()) {
            setResultBundleData(101, null);
        }
        if (this.mPresenter.isFavoriteShow()) {
            this.mPresenter.closeFavorite();
            return;
        }
        SearchStatUtil.sendStatDataWhenExitButtonClicked(getMainContext());
        animToClose();
    }

    @OnClick({R.id.et_search})
    public void onTitleClick() {
        if (this.mPresenter.isFavoriteShow()) {
            this.mPresenter.closeFavorite();
        }
        showIme();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void showLeftView(boolean z) {
        if (this.mRecyclerViewHeader != null) {
            int i = z ? 0 : 8;
            if (i != this.mRecyclerViewHeader.getVisibility()) {
                this.mRecyclerViewHeader.setVisibility(i);
            }
        }
    }

    @OnClick({R.id.base_scene})
    public void onClickOutside() {
        XEditText xEditText;
        L.i(TAG, "onClickOutside");
        if (this.mPbHistoryLoad.getVisibility() == 0 || this.mTvHistoryLoad.getVisibility() == 0) {
            return;
        }
        if (this.mPresenter.getSearchDest() == 1002 || this.mPresenter.getSearchDest() == 1001) {
            XEditText xEditText2 = this.mEtSearch;
            if (xEditText2 == null || xEditText2.getText() == null) {
                return;
            }
            this.mPresenter.startScanSearchScene(this.mEtSearch.getText().toString());
            return;
        }
        SearchStatUtil.sendStatDataWhenExitByGesture(getMainContext());
        if (this.mPresenter.getSearchMode() == 101) {
            animToClose();
            return;
        }
        Bundle bundle = new Bundle();
        if (!this.mPresenter.isFavoriteShow() && (xEditText = this.mEtSearch) != null && xEditText.getText() != null) {
            bundle.putString(SearchBridge.SEARCH_KEYWORD_TEXT, this.mEtSearch.getText().toString().trim());
        }
        setReturnResult(bundle);
        animToClose();
    }

    @OnClick({R.id.iv_clear})
    public void onClickClear() {
        SearchStatUtil.sendStatDataWhenClearKeywords(getMainContext());
        this.mEtSearch.setText("");
        resetOriginVuiState();
    }

    private void resetOriginVuiState() {
        if (isSceneVuiEnabled()) {
            SearchVuiHelper.getInstance().setPageVuiState(this.mPresenter.getOriginVuiState());
        }
    }

    @OnClick({R.id.tv_charge, R.id.tv_park, R.id.tv_food, R.id.tv_wc, R.id.tv_expcenter, R.id.tv_server_center, R.id.tv_carwash, R.id.tv_fix})
    public void onClickCategory(View view) {
        String str;
        String string;
        if (view != null && preventMultiClick(view)) {
            String str2 = "";
            switch (view.getId()) {
                case R.id.tv_carwash /* 2131297463 */:
                    str2 = ContextUtils.getString(R.string.search_category_carwash);
                    str = "010500";
                    break;
                case R.id.tv_charge /* 2131297466 */:
                    SearchStatUtil.sendStatDataWhenChargeTabClicked(getMainContext());
                    str2 = ContextUtils.getString(R.string.search_category_charge);
                    str = XPPoiCategory.SEARCH_CATEGORY_CHARGE;
                    break;
                case R.id.tv_expcenter /* 2131297493 */:
                    SearchStatUtil.sendStatDataWhenExpCenterTabClicked(getMainContext());
                    string = ContextUtils.getString(R.string.search_category_expcenter);
                    str2 = string;
                    str = "";
                    break;
                case R.id.tv_fix /* 2131297503 */:
                    SearchStatUtil.sendStatDataWhenRepairTabClicked(getMainContext());
                    str2 = ContextUtils.getString(R.string.search_category_fixshop);
                    str = XPPoiCategory.SEARCH_CATEGORY_FIXSHOP;
                    break;
                case R.id.tv_food /* 2131297504 */:
                    SearchStatUtil.sendStatDataWhenFoodTabClicked(getMainContext());
                    str2 = ContextUtils.getString(R.string.search_category_food);
                    str = XPPoiCategory.SEARCH_CATEGORY_FOOD;
                    break;
                case R.id.tv_park /* 2131297549 */:
                    SearchStatUtil.sendStatDataWhenParkingTabClicked(getMainContext());
                    str2 = ContextUtils.getString(R.string.search_category_park);
                    str = XPPoiCategory.SEARCH_CATEGORY_PARK;
                    break;
                case R.id.tv_server_center /* 2131297582 */:
                    SearchStatUtil.sendStatDataWhen4STabClicked(getMainContext());
                    string = ContextUtils.getString(R.string.search_category_server_center);
                    str2 = string;
                    str = "";
                    break;
                case R.id.tv_wc /* 2131297619 */:
                    SearchStatUtil.sendStatDataWhenWCTabClicked(getMainContext());
                    str2 = ContextUtils.getString(R.string.search_category_wc);
                    str = XPPoiCategory.SEARCH_CATEGORY_WC;
                    break;
                default:
                    str = "";
                    break;
            }
            this.mPresenter.startKeywordSearch(str2, str);
        }
    }

    @OnClick({R.id.container_favorite, R.id.iv_favorite_next})
    public void onClickFavorite() {
        if (preventMultiClick(this.mFavoriteContainer)) {
            if (this.mPresenter.isFavoriteShow()) {
                L.w(TAG, "onClickFavorite failure, already opened");
                return;
            }
            SearchStatUtil.sendStatDataWhenFavoriteTabClicked(getMainContext());
            this.mPresenter.doClickFavorite();
        }
    }

    private void doClickFavoriteAnim(@NonNull View view, @NonNull final View view2, boolean z) {
        if (z) {
            SceneAnimHelper.getSlideUpToDownShowAnim(this).start(view, new AnimCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.39
                @Override // com.xiaopeng.montecarlo.anim.AnimCallback
                public void onEvent(AnimEvent animEvent, View view3) {
                    if (AnimEvent.END == animEvent && view2.isAttachedToWindow()) {
                        view2.setVisibility(4);
                        view2.setTranslationY(0.0f);
                    }
                }
            });
            SceneAnimHelper.getSlideUpToDownHideAnim(this).start(view2);
            return;
        }
        SceneAnimHelper.getSlideDownToUpShowAnim(this).start(view, new AnimCallback() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.40
            @Override // com.xiaopeng.montecarlo.anim.AnimCallback
            public void onEvent(AnimEvent animEvent, View view3) {
                if (AnimEvent.END == animEvent && view2.isAttachedToWindow()) {
                    view2.setVisibility(4);
                    view2.setTranslationY(0.0f);
                }
            }
        });
        SceneAnimHelper.getSlideDownToUpHideAnim(this).start(view2);
    }

    @OnClick({R.id.container_home})
    public void onClickHome() {
        if (preventMultiClick(this.mHomeContainer)) {
            SearchStatUtil.sendStatDataWhenHomeTabClicked(getMainContext());
            this.mPresenter.settingHomeOrCompany(1001, 1);
        }
    }

    @OnClick({R.id.container_office})
    public void onClickOffice() {
        if (preventMultiClick(this.mOfficeContainer)) {
            SearchStatUtil.sendStatDataWhenOfficeTabClicked(getMainContext());
            this.mPresenter.settingHomeOrCompany(1002, 2);
        }
    }

    @OnClick({R.id.iv_change_home})
    public void onEditHome() {
        if (preventMultiClick(this.mIvChangeHome)) {
            SearchStatUtil.sendStatDataWhenHomeEdit(getMainContext());
            showEditHomeCompanyDialog(1001, this.mPresenter.getHomeXPPoiInfo());
        }
    }

    @OnClick({R.id.iv_change_office})
    public void onEditCompany() {
        if (preventMultiClick(this.mIvChangeOffice)) {
            SearchStatUtil.sendStatDataWhenOfficeEdit(getMainContext());
            showEditHomeCompanyDialog(1002, this.mPresenter.getCompanyXPPoiInfo());
        }
    }

    @OnClick({R.id.tv_scan_search})
    public void onScanSearch() {
        this.mPresenter.startScanSearchScene("");
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void retrySearch(XPPoiInfo xPPoiInfo) {
        XEditText xEditText;
        String name = xPPoiInfo.getName();
        if (TextUtils.isEmpty(name) && (xEditText = this.mEtSearch) != null && xEditText.getText() != null) {
            name = this.mEtSearch.getText().toString();
        }
        this.mPresenter.startKeywordSearch(name, "");
    }

    private void showIme() {
        if (isSceneLegal()) {
            if (this.mEtSearch == null || this.mPresenter.isFavoriteShow()) {
                L.Tag tag = TAG;
                L.w(tag, "showIme mEtSearch:" + this.mEtSearch);
                return;
            }
            this.mEtSearch.setFocusable(true);
            this.mEtSearch.setFocusableInTouchMode(true);
            this.mEtSearch.requestFocus();
            if (getActivity() != null) {
                boolean showSoftInput = ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.mEtSearch, 0);
                L.Tag tag2 = TAG;
                L.i(tag2, "showIme bool:" + showSoftInput);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public boolean checkTvHome() {
        return Utils.isLandscape() ? this.mContainerChangeHome == null || this.mTvSetHome == null : this.mIvChangeHome == null || this.mTvSetHome == null;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public boolean checkTvCompany() {
        return Utils.isLandscape() ? this.mContainerChangeOffice == null || this.mTvSetOffice == null : this.mIvChangeOffice == null || this.mTvSetOffice == null;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void initFavoriteButton() {
        updateFavoriteButton();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateFavoriteButton() {
        FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
        SearchPresenter searchPresenter = this.mPresenter;
        if (searchPresenter != null) {
            searchPresenter.setHomeText(home == null ? null : home.getXPPoiInfo(), ContextUtils.getString(R.string.favorite_to_set));
        }
        FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
        SearchPresenter searchPresenter2 = this.mPresenter;
        if (searchPresenter2 != null) {
            searchPresenter2.setCompanyText(company != null ? company.getXPPoiInfo() : null, ContextUtils.getString(R.string.favorite_to_set));
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        PresenterData onSceneSaveInstanceState = this.mPresenter.onSceneSaveInstanceState();
        List<HistoryRecordInfo> saveHistoryRecordList = onSceneSaveInstanceState.getSaveHistoryRecordList();
        List<FavoriteAddress> saveFavoriteAddressList = onSceneSaveInstanceState.getSaveFavoriteAddressList();
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onSceneSaveInstanceState historyRecordList:");
        sb.append(saveHistoryRecordList == null ? 0 : saveHistoryRecordList.size());
        sb.append(", favoriteAddressList:");
        sb.append(saveFavoriteAddressList != null ? saveFavoriteAddressList.size() : 0);
        L.i(tag, sb.toString());
        String str = null;
        bundle.putParcelableArrayList(SearchSceneConstants.SEARCH_SAVESTATE_HISTORY, saveHistoryRecordList != null ? new ArrayList<>(saveHistoryRecordList) : null);
        bundle.putParcelableArrayList(SearchSceneConstants.SEARCH_SAVESTATE_FAVORITE, saveFavoriteAddressList != null ? new ArrayList<>(saveFavoriteAddressList) : null);
        bundle.putInt(SearchSceneConstants.SEARCH_SAVESTATE_SUBCONTAINER_TYPE, onSceneSaveInstanceState.getSubContainerType());
        XEditText xEditText = this.mEtSearch;
        if (xEditText != null && xEditText.getText() != null) {
            str = this.mEtSearch.getText().toString();
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        bundle.putString(SearchSceneConstants.SEARCH_SAVESTATE_ETSEARCH, str);
        SearchAdapter searchAdapter = this.mSearchAdapter;
        if (searchAdapter != null) {
            List<XPPoiInfo> data = searchAdapter.getData();
            if (CollectionUtils.isNotEmpty(data)) {
                bundle.putParcelableArrayList(SearchSceneConstants.SEARCH_SAVESTATE_SEARCHDATA, (ArrayList) data);
                return true;
            }
            return true;
        }
        return true;
    }

    private void showFavoriteAndHotWord(boolean z, boolean z2) {
        this.mSearchHeaderLayout.setVisibility(z ? 0 : 8);
        this.mSearchFavoriteParent.setVisibility(z2 ? 0 : 8);
    }

    private void changeScrollBarStyle() {
        if (this.mHistoryRecyclerView != null) {
            Utils.changeScrollBarStyle(getActivity(), this.mHistoryRecyclerView);
        }
        if (this.mFavoriteRecyclerView != null) {
            Utils.changeScrollBarStyle(getActivity(), this.mFavoriteRecyclerView);
        }
        if (this.mSearchRecyclerView != null) {
            Utils.changeScrollBarStyle(getActivity(), this.mSearchRecyclerView);
        }
    }

    private void renderLayoutByDayNightStatus() {
        XRelativeLayout xRelativeLayout;
        XPRecyclerView xPRecyclerView = this.mFavoriteRecyclerView;
        if (xPRecyclerView != null && xPRecyclerView.getVisibility() == 0 && this.mFavoriteAdapter != null) {
            this.mFavoriteRecyclerView.updateAdapterAndRefreshCache();
        }
        XPRecyclerView xPRecyclerView2 = this.mHistoryRecyclerView;
        if (xPRecyclerView2 != null && xPRecyclerView2.getVisibility() == 0 && this.mHistoryAdapter != null) {
            this.mHistoryRecyclerView.updateAdapterAndRefreshCache();
        }
        XPRecyclerView xPRecyclerView3 = this.mSearchRecyclerView;
        if (xPRecyclerView3 != null && xPRecyclerView3.getVisibility() == 0 && this.mSearchAdapter != null) {
            this.mSearchRecyclerView.updateAdapterAndRefreshCache();
        }
        changeScrollBarStyle();
        setTvAround(mo116getPresenter().getAroundPoi());
        XImageView xImageView = this.mHaveMoreDataDecorator;
        if (xImageView == null || (xRelativeLayout = this.mSearchHeaderLayout) == null) {
            return;
        }
        xImageView.setBackground(ThemeWatcherUtil.getDrawable(xRelativeLayout.getVisibility() == 0 ? R.drawable.shape_bg_indicator_down_with_right_corner : R.drawable.shape_bg_indicator_down_with_corner));
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public PageType getPageType() {
        return this.mPresenter.getPageType();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @MainThread
    public void onEvent(FavoriteSyncEvent favoriteSyncEvent) {
        SearchPresenter searchPresenter;
        if (favoriteSyncEvent == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "onEvent event.isShowDialog() = " + favoriteSyncEvent.isShowDialog());
        if (favoriteSyncEvent.isShowDialog()) {
            int userHandle = AccountObservable.getInstance().getUserHandle();
            if (favoriteSyncEvent.getUserType() == userHandle && (searchPresenter = this.mPresenter) != null) {
                searchPresenter.initFavoriteSyncConflictDialog();
                return;
            }
            L.Tag tag2 = TAG;
            L.w(tag2, "onEvent event.getUserType() = " + favoriteSyncEvent.getUserType() + ", userHandle = " + userHandle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.DayNightFragment
    public void onThemeSwitchDelegate(int i) {
        renderLayoutByDayNightStatus();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchDest() {
        return this.mPresenter.getSearchDest();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public int getSearchMode() {
        return this.mPresenter.getSearchMode();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void updateHistoryAdapter(List<HistoryRecordInfo> list, boolean z, boolean z2) {
        XRelativeLayout xRelativeLayout;
        if (z) {
            HistoryRecordAdapter historyRecordAdapter = this.mHistoryAdapter;
            if (historyRecordAdapter != null) {
                historyRecordAdapter.addData(list, z2);
                XPRecyclerView xPRecyclerView = this.mHistoryRecyclerView;
                if (xPRecyclerView != null) {
                    xPRecyclerView.setLock(false);
                    return;
                }
                return;
            }
            return;
        }
        XImageView xImageView = this.mHaveMoreDataDecorator;
        if (xImageView != null && (xRelativeLayout = this.mSearchHeaderLayout) != null) {
            xImageView.setBackground(ThemeWatcherUtil.getDrawable(xRelativeLayout.getVisibility() == 0 ? R.drawable.shape_bg_indicator_down_with_right_corner : R.drawable.shape_bg_indicator_down_with_corner));
        }
        HistoryRecordAdapter historyRecordAdapter2 = this.mHistoryAdapter;
        if (historyRecordAdapter2 != null) {
            historyRecordAdapter2.setData(new ArrayList(list));
        }
        showHistoryListOrHistoryEmptyView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public boolean isHistoryPaging() {
        XPRecyclerView xPRecyclerView = this.mHistoryRecyclerView;
        if (xPRecyclerView != null) {
            return xPRecyclerView.isPaging();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public boolean isFavoritePaging() {
        XPRecyclerView xPRecyclerView = this.mFavoriteRecyclerView;
        if (xPRecyclerView != null) {
            return xPRecyclerView.isPaging();
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public int getHistoryPageNum() {
        XPRecyclerView xPRecyclerView = this.mHistoryRecyclerView;
        if (xPRecyclerView != null) {
            return xPRecyclerView.getPageNum();
        }
        return 1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public int getFavoritePageNum() {
        XPRecyclerView xPRecyclerView = this.mFavoriteRecyclerView;
        if (xPRecyclerView != null) {
            return xPRecyclerView.getPageNum();
        }
        return 1;
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void notifyItemChangedForCancelFav(int i) {
        FavoriteAdapter favoriteAdapter = this.mFavoriteAdapter;
        if (favoriteAdapter != null) {
            favoriteAdapter.notifyItemForChanged(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.searchscene.ISearchContract.LogicView
    public void openSearchNormal() {
        if (isSceneLegal()) {
            if (this.mHistoryRecyclerView.getVisibility() != 0) {
                this.mHistoryRecyclerView.setVisibility(0);
                if (this.mPresenter.isFavoriteShow()) {
                    this.mPresenter.closeFavorite();
                }
                if (!TextUtils.isEmpty(this.mEtSearch.getText())) {
                    onClickClear();
                }
            }
            this.mHistoryRecyclerView.smoothScrollToPosition(0);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes
    protected View formatRootViewForVui() {
        View sceneContentView = getSceneContentView();
        if (sceneContentView == null) {
            sceneContentView = getWindowDecorView();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, L.formatVoiceFullScenesLog("formatRootViewForVui vui:" + sceneContentView));
        }
        return sceneContentView;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean isSceneVuiEnabled() {
        return CommonVuiHelper.getInstance().isSceneVuiSupport();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public String getVuiSceneId() {
        String format = String.format("%s%s", getClass().getSimpleName(), SearchVuiHelper.getInstance().getPageVuiStateDesc());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getVuiSceneId:" + format);
        }
        return format;
    }

    private void addHistoryRecordScrollListenerForVui() {
        if (isSceneVuiEnabled() && this.mHisRecScrLis == null) {
            this.mHisRecScrLis = new RecyclerView.OnScrollListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.41
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    if (i == 0) {
                        SearchFragment.this.executeOnHistoryRecordScrollIdle();
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                }
            };
            this.mHistoryRecyclerView.setOnXpScrollListener(this.mHisRecScrLis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnHistoryRecordScrollIdle() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            XpLinearLayoutManager xpLinearLayoutManager = (XpLinearLayoutManager) this.mHistoryRecyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = xpLinearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = xpLinearLayoutManager.findLastVisibleItemPosition();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateHistoryListForVui SCROLL_STATE_IDLE first:" + findFirstVisibleItemPosition + ",last:" + findLastVisibleItemPosition + ",mHistoryRecordFirstVisiblePosition:" + this.mHistoryRecordFirstVisiblePosition + ",mHistoryRecordLastVisiblePosition:" + this.mHistoryRecordLastVisiblePosition));
            }
            if (findFirstVisibleItemPosition == this.mHistoryRecordFirstVisiblePosition && findLastVisibleItemPosition == this.mHistoryRecordLastVisiblePosition) {
                return;
            }
            this.mHistoryRecordFirstVisiblePosition = findFirstVisibleItemPosition;
            this.mHistoryRecordLastVisiblePosition = findLastVisibleItemPosition;
            updateHistoryListForVui();
        }
    }

    private void updateHistoryListForVui() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.d(TAG, "updateHistoryListForVui");
            }
            if (this.mFavoriteRecyclerView.getVisibility() == 0) {
                disableViewsWhenFavoriteShowForVui();
            }
            XEditText xEditText = this.mEtSearch;
            SearchVuiHelper.getInstance().updateSceneForVui(this.mHistoryRecyclerView, this, xEditText == null ? null : xEditText.getText(), this.mPresenter.getSearchDest());
        }
    }

    private void addSearchRecyclerScrollListenerForVui() {
        if (isSceneVuiEnabled() && this.mSeaRecScrLis == null) {
            this.mSeaRecScrLis = new RecyclerView.OnScrollListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.42
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    if (i == 0) {
                        SearchFragment.this.executeOnSearchRecordScrollIdle();
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                }
            };
            this.mSearchRecyclerView.setOnXpScrollListener(this.mSeaRecScrLis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnSearchRecordScrollIdle() {
        XPRecyclerView xPRecyclerView;
        if (isSceneLegal() && isSceneVuiEnabled() && (xPRecyclerView = this.mSearchRecyclerView) != null) {
            XpLinearLayoutManager xpLinearLayoutManager = (XpLinearLayoutManager) xPRecyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = xpLinearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = xpLinearLayoutManager.findLastVisibleItemPosition();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateSearchListForVui SCROLL_STATE_IDLE first:" + findFirstVisibleItemPosition + ",last:" + findLastVisibleItemPosition + ",mSearchRecordFirstVisiblePosition:" + this.mSearchRecordFirstVisiblePosition + ",mSearchRecordLastVisiblePosition:" + this.mSearchRecordLastVisiblePosition));
            }
            if (findFirstVisibleItemPosition == this.mSearchRecordFirstVisiblePosition && findLastVisibleItemPosition == this.mSearchRecordLastVisiblePosition) {
                return;
            }
            this.mSearchRecordFirstVisiblePosition = findFirstVisibleItemPosition;
            this.mSearchRecordLastVisiblePosition = findLastVisibleItemPosition;
            updateSearchListForVui();
        }
    }

    private void updateFavoriteListForVui() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            if (L.ENABLE) {
                L.d(TAG, L.formatVoiceFullScenesLog("updateFavoriteListForVui"));
            }
            XEditText xEditText = this.mEtSearch;
            SearchVuiHelper.getInstance().updateSceneForVui(this.mFavoriteRecyclerView, this, xEditText == null ? null : xEditText.getText(), this.mPresenter.getSearchDest());
        }
    }

    private void addFavoriteRecordScrollListenerForVui() {
        if (isSceneVuiEnabled() && this.mFavRecScrLis == null) {
            this.mFavRecScrLis = new RecyclerView.OnScrollListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchFragment.43
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    if (i == 0) {
                        SearchFragment.this.executeOnFavoriteRecordScrollIdle();
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                }
            };
            this.mFavoriteRecyclerView.setOnXpScrollListener(this.mFavRecScrLis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnFavoriteRecordScrollIdle() {
        if (isSceneLegal() && isSceneVuiEnabled()) {
            XpLinearLayoutManager xpLinearLayoutManager = (XpLinearLayoutManager) this.mFavoriteRecyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = xpLinearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = xpLinearLayoutManager.findLastVisibleItemPosition();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, L.formatVoiceFullScenesLog("updateFavoriteListForVui SCROLL_STATE_IDLE first:" + findFirstVisibleItemPosition + ",last:" + findLastVisibleItemPosition + ",mFavoriteRecordFirstVisiblePosition:" + this.mFavoriteRecordFirstVisiblePosition + ",mFavoriteRecordLastVisiblePosition:" + this.mFavoriteRecordLastVisiblePosition));
            }
            if (findFirstVisibleItemPosition == this.mFavoriteRecordFirstVisiblePosition && findLastVisibleItemPosition == this.mFavoriteRecordLastVisiblePosition) {
                return;
            }
            this.mFavoriteRecordFirstVisiblePosition = findFirstVisibleItemPosition;
            this.mFavoriteRecordLastVisiblePosition = findLastVisibleItemPosition;
            updateFavoriteListForVui();
        }
    }

    private void removeAllScrollListenerForVui() {
        if (isSceneVuiEnabled()) {
            XPRecyclerView xPRecyclerView = this.mSearchRecyclerView;
            if (xPRecyclerView != null && this.mSeaRecScrLis != null) {
                xPRecyclerView.setOnXpScrollListener(null);
            }
            XPRecyclerView xPRecyclerView2 = this.mHistoryRecyclerView;
            if (xPRecyclerView2 != null && this.mHisRecScrLis != null) {
                xPRecyclerView2.setOnXpScrollListener(null);
            }
            XPRecyclerView xPRecyclerView3 = this.mFavoriteRecyclerView;
            if (xPRecyclerView3 == null || this.mFavRecScrLis == null) {
                return;
            }
            xPRecyclerView3.setOnXpScrollListener(null);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public void onBuildScene() {
        CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
        MainContext mainContext = getMainContext();
        XTextView xTextView = this.mTvScanSearch;
        commonVuiHelper.enableCanSpeechControl(mainContext, xTextView, xTextView, false);
        CommonVuiHelper commonVuiHelper2 = CommonVuiHelper.getInstance();
        String string = ContextUtils.getString(R.string.vui_general_action_system_close_return);
        MainContext mainContext2 = getMainContext();
        XImageButton xImageButton = this.mBtnReturn;
        commonVuiHelper2.markGeneralAction(string, mainContext2, xImageButton, xImageButton, false);
        super.onBuildScene();
    }

    private void disableViewsWhenFavoriteShowForVui() {
        if (isSceneVuiEnabled()) {
            this.mRecyclerViewHeader.setVisibility(8);
            this.mHistoryRecyclerView.setVisibility(8);
            XPRecyclerView xPRecyclerView = this.mSearchRecyclerView;
            if (xPRecyclerView != null) {
                xPRecyclerView.setVisibility(8);
            }
            updateScene();
        }
    }

    private void enableViewsWhenFavoriteHideForVui() {
        if (isSceneVuiEnabled()) {
            this.mRecyclerViewHeader.setVisibility(0);
            this.mHistoryRecyclerView.setVisibility(0);
            XPRecyclerView xPRecyclerView = this.mSearchRecyclerView;
            if (xPRecyclerView != null) {
                xPRecyclerView.setVisibility(8);
            }
            updateScene();
        }
    }

    private void disableViewsWhenSuggestShowForVui() {
        if (isSceneVuiEnabled()) {
            this.mRecyclerViewHeader.setVisibility(8);
            this.mHistoryRecyclerView.setVisibility(8);
            this.mFavoriteRecyclerView.setVisibility(8);
            updateScene();
        }
    }

    private void enableViewsWhenSuggestHideForVui() {
        if (isSceneVuiEnabled()) {
            SearchPresenter searchPresenter = this.mPresenter;
            if (searchPresenter != null && !searchPresenter.isSetDest()) {
                this.mRecyclerViewHeader.setVisibility(0);
            }
            this.mHistoryRecyclerView.setVisibility(0);
            this.mFavoriteRecyclerView.setVisibility(8);
            updateScene();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes
    public void enterVuiScene() {
        super.enterVuiScene();
        if (isFirstEnterScene()) {
            return;
        }
        if (SearchVuiHelper.getInstance().getPageVuiState() == 1 || SearchVuiHelper.getInstance().getPageVuiState() == 2) {
            updateHistoryListForVui();
        }
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.vui.commons.IVuiSceneListener
    public boolean onInterceptVuiEvent(View view, VuiEvent vuiEvent) {
        int id = view.getId();
        if (id != R.id.tv_delete_all_container) {
            if (id == R.id.tv_scan_search) {
                return handleVuiEventScanSearch(view);
            }
            return super.onInterceptVuiEvent(view, vuiEvent);
        }
        return handleVuiEventForDeleteAll(view);
    }

    private boolean handleVuiEventScanSearch(View view) {
        VoiceFullScenesUtil.showVuiAnimation(view);
        onScanSearch();
        return true;
    }

    private boolean handleVuiEventForDeleteAll(View view) {
        VoiceFullScenesUtil.showVuiAnimation(view);
        if (this.mHistoryRecyclerView.getVisibility() == 0) {
            performHistoryDeleteClick();
            return true;
        } else if (this.mFavoriteRecyclerView.getVisibility() == 0) {
            performFavoriteDeleteClick();
            return true;
        } else {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    private static class XLoadingCancelButtonAction implements DialogInterface.OnCancelListener {
        private WeakReference<SearchFragment> mWeakReference;

        public XLoadingCancelButtonAction(SearchFragment searchFragment) {
            this.mWeakReference = new WeakReference<>(searchFragment);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            SearchFragment searchFragment = this.mWeakReference.get();
            if (searchFragment != null) {
                SearchStatUtil.sendStatDataWhenCancelSearch(searchFragment.getMainContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SearchAdapterCallback implements SearchAdapter.AdapterCallback {
        private WeakReference<SearchFragment> mWeakFragment;

        SearchAdapterCallback(SearchFragment searchFragment) {
            this.mWeakFragment = new WeakReference<>(searchFragment);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.AdapterCallback
        public void onItemClick(View view, int i) {
            SearchFragment searchFragment = this.mWeakFragment.get();
            if (searchFragment != null) {
                List<HistoryRecordInfo> matchedHistory = searchFragment.mSearchAdapter.getMatchedHistory();
                if (!CollectionUtils.isNotEmpty(matchedHistory) || i >= matchedHistory.size()) {
                    searchFragment.onSearchItemClick(view, i);
                } else {
                    searchFragment.onHistoryRecordItemClick(matchedHistory.get(i), i);
                }
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.AdapterCallback
        public void onGotoPoi(int i) {
            SearchFragment searchFragment = this.mWeakFragment.get();
            if (searchFragment != null) {
                searchFragment.onSearchGotoPoi(i);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.AdapterCallback
        public void onAddWayPoint(int i) {
            SearchFragment searchFragment = this.mWeakFragment.get();
            if (searchFragment != null) {
                searchFragment.onSearchAddWayPoint(i);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.AdapterCallback
        public void onDeleteWayPoint(int i) {
            SearchFragment searchFragment = this.mWeakFragment.get();
            if (searchFragment != null) {
                searchFragment.onSearchDeleteWayPoint(i);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.AdapterCallback
        public void onGotoWayPoint(int i) {
            SearchFragment searchFragment = this.mWeakFragment.get();
            if (searchFragment != null) {
                searchFragment.onSearchGotoWayPoint(i);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.AdapterCallback
        public void onSetHome(int i) {
            SearchFragment searchFragment = this.mWeakFragment.get();
            if (searchFragment != null) {
                searchFragment.onSearchSetHome(i);
            }
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchAdapter.AdapterCallback
        public void onSetCompany(int i) {
            SearchFragment searchFragment = this.mWeakFragment.get();
            if (searchFragment != null) {
                searchFragment.onSearchSetCompany(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class EditChangedListener implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private EditChangedListener() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SearchFragment.this.mIvClear == null || charSequence == null || SearchFragment.this.mPresenter == null) {
                return;
            }
            String trim = charSequence.toString().trim();
            if (SearchFragment.this.mHandler.hasMessages(101)) {
                SearchFragment.this.mHandler.removeMessages(101);
            }
            SearchFragment.this.mHandler.sendMessageDelayed(SearchFragment.this.mHandler.obtainMessage(101, trim), 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class EditOnKeyListener implements View.OnKeyListener {
        private EditOnKeyListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 66 && keyEvent.getAction() == 1) {
                String trim = SearchFragment.this.mEtSearch.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    SearchFragment.this.mPresenter.startKeywordSearch(trim, "");
                } else {
                    SearchFragment.this.showPrompt(R.string.search_msg_no_content);
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class XPObservableScrollViewCallbacks implements ObservableScrollViewCallbacks {
        private WeakReference<ImageView> mHaveMoreDataDecorator;
        private WeakReference<XPRecyclerView> mWeakRecycleView;

        @Override // com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks
        public void onUpOrCancelMotionEvent(int i) {
        }

        public XPObservableScrollViewCallbacks(XPRecyclerView xPRecyclerView, ImageView imageView) {
            this.mWeakRecycleView = new WeakReference<>(xPRecyclerView);
            this.mHaveMoreDataDecorator = new WeakReference<>(imageView);
        }

        @Override // com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks
        public void onScrollChanged(int i, boolean z, boolean z2) {
            ImageView imageView;
            XPRecyclerView xPRecyclerView = this.mWeakRecycleView.get();
            if (xPRecyclerView == null || (imageView = this.mHaveMoreDataDecorator.get()) == null) {
                return;
            }
            int loadMode = xPRecyclerView.getLoadMode();
            boolean z3 = true;
            if (!(loadMode != 3) && (loadMode != 3 || !xPRecyclerView.canScrollVertically(1))) {
                z3 = false;
            }
            imageView.setVisibility(z3 ? 0 : 8);
        }

        @Override // com.xiaopeng.montecarlo.views.observable.ObservableScrollViewCallbacks
        public void onDownMotionEvent() {
            if (Utils.isLandscape()) {
                SearchFragment.this.hideIme();
            }
        }
    }
}
