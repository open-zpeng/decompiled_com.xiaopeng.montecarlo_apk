package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.DimenRes;
import androidx.annotation.MainThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.model.BizPolygonBusinessInfo;
import com.autonavi.gbl.map.model.PointD;
import com.autonavi.gbl.map.model.PreviewParam;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.ExploreBridge;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.montecarlo.stat.PoiPopStatUtil;
import com.xiaopeng.montecarlo.util.CommonVuiHelper;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.util.VoiceFullScenesUtil;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import com.xiaopeng.montecarlo.views.ExpandableTextView;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.montecarlo.views.OnViewStateChangedListener;
import com.xiaopeng.montecarlo.views.XpPoiPopScrollView;
import com.xiaopeng.montecarlo.views.XpRelativeLayout;
import com.xiaopeng.montecarlo.views.dialog.XBaseDialog;
import com.xiaopeng.montecarlo.views.poicard.PoiCardBottomButtons;
import com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer;
import com.xiaopeng.montecarlo.views.poicard.PoiCardHelper;
import com.xiaopeng.montecarlo.views.poicard.PoiCardHomeCompanyContainer;
import com.xiaopeng.montecarlo.views.poicard.PoiCardPriceContainer;
import com.xiaopeng.vui.commons.VuiPriority;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class PoiCardView extends XpRelativeLayout implements PoiCardHomeCompanyContainer.OnPoiCardHomeCompanyContainerClickListener, PoiCardBottomButtons.OnPoiCardBottomButtonsClickListener, ExpandableTextView.OnExpandableTextViewChangeListener, OnChildLayoutCompletedListener, OnViewStateChangedListener {
    public static final int BACK_REQUESTCODE_SEARCH = 100;
    public static final int GESTURE_ADDRESS_EXPAND = 1;
    public static final int GESTURE_PRICE_EXPAND = 2;
    public static final int GESTURE_SCROLL = 3;
    private static final L.Tag TAG = new L.Tag("POP=>PoiCardView");
    private AnimationCallback mAnimationCallback;
    private String mAoiRefreshedId;
    private DecoratorType mAoiRefreshedType;
    PoiCardBottomButtons mBottomBtnContainer;
    @BindView(R.id.btn_close_poi_card)
    XTextView mBtnClose;
    @BindView(R.id.btn_left_button)
    NaviImageView mBtnLeftButton;
    private Unbinder mButterBinder;
    PoiCardCarRemainDistance mCarRemainDistanceContainer;
    @BindView(R.id.car_remain_distance_container)
    XLinearLayout mCarRemainDistanceLayoutContainer;
    PoiCardCarServiceContainer mCarServiceContainer;
    @BindView(R.id.container_car_service)
    XLinearLayout mCarServiceLayoutContainer;
    PoiCardChargeStatusContainer mChargeDetail;
    @BindView(R.id.poi_charge_detail_container)
    XLinearLayout mChargeDetailLayoutContainer;
    PoiCardChargeDownLockContainer mChargeDownLock;
    @BindView(R.id.poi_charge_down_lock_container)
    XLinearLayout mChargeDownLockLayoutContainer;
    @BindView(R.id.poi_children_divider_top)
    XView mChildTopDivider;
    @BindView(R.id.search_result_cost)
    XTextView mCost;
    private DecoratorType mDecoratorType;
    private PoiCardDisplayStateConfig mDisplayConfig;
    PoiCardEvaluationContainer mEvaluationContainer;
    @BindView(R.id.container_evaluation)
    XLinearLayout mEvaluationLayoutContainer;
    private int mHeight;
    boolean mIsShowAnimating;
    private volatile boolean mIsVisible;
    @BindView(R.id.loading_poi_card)
    XLoading mLoading;
    @BindView(R.id.main_body)
    XLinearLayout mMainBody;
    private MainContext mMainContext;
    private BaseMapDecorator mMapDecorator;
    private int mMaxHeight;
    private XBaseDialog mNumPopDialog;
    private int mOffsetToMark;
    @BindView(R.id.poi_item_park_container)
    XLinearLayout mParkLayoutContainer;
    PoiCardPicContainer mPicContainer;
    @BindView(R.id.poi_pic_container)
    XLinearLayout mPicLayoutContainer;
    private XBaseDialog mPicPopDialog;
    @BindView(R.id.poi_bottom)
    XLinearLayout mPoiBottom;
    private PoiCardHelper.PoiCardManagerCallback mPoiCallback;
    @BindView(R.id.poi_children_container)
    XLinearLayout mPoiChildContainer;
    @BindView(R.id.poi_children)
    ChildPoiGridView mPoiChildView;
    @BindView(R.id.poi_divider_bottom)
    XView mPoiDividerBottom;
    private PoiCardEntryContainer.OnPoiCardEntryContainerClickListener mPoiEntryClickListener;
    PoiCardEntryContainer mPoiEntryLayout;
    @BindView(R.id.poi_entry_layout)
    XLinearLayout mPoiEntryLayoutContainer;
    private XPPoiInfo mPoiInfo;
    PoiCardParkContainer mPoiParkContainer;
    @BindView(R.id.poi_pop_container)
    XLinearLayout mPoiPopContainer;
    PoiCardPriceContainer mPoiPriceContainer;
    @BindView(R.id.poi_scroll_container)
    XLinearLayout mPoiScrollContainer;
    @BindView(R.id.poi_xp_scroller_and_divider)
    XRelativeLayout mPoiScrollDividerContainer;
    private PoiCardPresenter mPresenter;
    @BindView(R.id.poi_price_container)
    XLinearLayout mPriceLayoutContainer;
    private PoiCardPriceContainer.PoiCardPriceContainerListener mPriceListener;
    @BindView(R.id.search_result_rating_bar)
    RatingBar mRatingBar;
    PoiCardRoadInfoContainer mRoadInfoContainer;
    @BindView(R.id.tv_road_info_container)
    XLinearLayout mRoadInfoLayoutContainer;
    private View mRootView;
    private IBaseScene mScene;
    private int mSearchDest;
    private int mSearchMode;
    PoiCardHomeCompanyContainer mSettingHomeOrCompanyContainer;
    @BindView(R.id.search_result_rating_star_container)
    ViewGroup mStarContainer;
    PoiCardTimeContainer mTimeContainer;
    @BindView(R.id.poi_time_container)
    XLinearLayout mTimeLayoutContainer;
    PoiCardTitleContainer mTitleContainer;
    @BindView(R.id.poi_title_container)
    XLinearLayout mTitleLayoutContainer;
    @BindView(R.id.poi_xp_scroller)
    XpPoiPopScrollView mTopScroller;
    @BindView(R.id.poi_address)
    ExpandableTextView mTvAddress;
    private int mWidth;
    private int mYOffset;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface AnimationCallback {
        void onAnimateEnd();
    }

    public PoiCardView(Context context) {
        this(context, null);
    }

    public PoiCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PoiCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsShowAnimating = false;
        this.mAoiRefreshedId = "";
        this.mAoiRefreshedType = DecoratorType.INVALID;
        this.mSearchDest = 1000;
        this.mSearchMode = 100;
        this.mDecoratorType = DecoratorType.INVALID;
        this.mYOffset = 0;
        this.mOffsetToMark = 0;
        this.mIsVisible = false;
        this.mMaxHeight = 0;
        this.mPoiEntryClickListener = new PoiCardEntryContainer.OnPoiCardEntryContainerClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.1
            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer.OnPoiCardEntryContainerClickListener
            public void onBtnSearchClicked() {
                if (PoiCardView.this.mPresenter != null) {
                    PoiCardView.this.mPresenter.onSearchClick();
                }
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer.OnPoiCardEntryContainerClickListener
            public void onBtnParkClicked() {
                if (PoiCardView.this.mPresenter != null) {
                    PoiCardView.this.mPresenter.onBtnPark();
                }
            }

            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer.OnPoiCardEntryContainerClickListener
            public void onBtnFavoriteClicked() {
                if (PoiCardView.this.mPresenter != null) {
                    PoiCardView.this.mPresenter.onBtnFavoriteClick();
                }
            }
        };
        this.mPriceListener = new PoiCardPriceContainer.PoiCardPriceContainerListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.2
            @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardPriceContainer.PoiCardPriceContainerListener
            public void oneExpandStatusChanged(boolean z) {
                PoiPopStatUtil.sendStatDataWhenGesture(PoiCardView.this.mMainContext, 2);
                PoiCardView.this.renderPriceInfo(true);
                PoiCardView poiCardView = PoiCardView.this;
                if (poiCardView.checkViewIsLegal(poiCardView.mTopScroller, "oneExpandStatusChanged") && z) {
                    PoiCardView.this.mTopScroller.scrollToBottom();
                }
            }
        };
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_poi_pop, this);
        setVuiLayoutLoadable(true);
        this.mButterBinder = ButterKnife.bind(this.mRootView);
        this.mYOffset = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_y_offset);
        this.mOffsetToMark = ContextUtils.getDimensionPixelSize(R.dimen.poi_offset_to_mark);
        this.mIsVisible = getVisibility() == 0;
        this.mMaxHeight = Utils.isPortrait() ? getResources().getDimensionPixelSize(R.dimen.poi_pop_height) : getResources().getDimensionPixelSize(R.dimen.poi_pop_max_height_for_land);
        setStateChangedListener(this);
    }

    public XPPoiInfo getPoiInfo() {
        return this.mPoiInfo;
    }

    public DecoratorType getDecoratorType() {
        return this.mDecoratorType;
    }

    public void setMainContext(MainContext mainContext) {
        this.mMainContext = mainContext;
    }

    @OnClick({R.id.btn_left_button})
    public void onLeftButtonClick(View view) {
        this.mMainContext.getDecoratorManager().clearFocus(this.mScene);
    }

    @OnClick({R.id.btn_close_poi_card})
    public void onCloseButtonClick(View view) {
        this.mMainContext.getDecoratorManager().clearFocus(this.mScene);
    }

    public void init(PoiCardPresenter poiCardPresenter, PoiCardHelper.PoiCardManagerCallback poiCardManagerCallback) {
        this.mPresenter = poiCardPresenter;
        this.mPoiCallback = poiCardManagerCallback;
        this.mScene = this.mPresenter.getScene();
    }

    public void showCard(XPPoiInfo xPPoiInfo) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "showCard poiInfo:" + xPPoiInfo);
        }
        if (isRouteChargePoint(xPPoiInfo)) {
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.mIsVisible = true;
        renderCard(xPPoiInfo, false);
    }

    public void updateCard(final XPPoiInfo xPPoiInfo) {
        L.Tag tag = TAG;
        L.i(tag, "refreshCard poiInfo: " + xPPoiInfo + ", mIsShowAnimating: " + this.mIsShowAnimating);
        if (isRouteChargePoint(xPPoiInfo)) {
            return;
        }
        this.mIsVisible = true;
        if (!this.mIsShowAnimating) {
            renderCard(xPPoiInfo, true);
        } else {
            setAnimationCallback(new AnimationCallback() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.3
                @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardView.AnimationCallback
                public void onAnimateEnd() {
                    PoiCardView.this.renderCard(xPPoiInfo, true);
                }
            });
        }
    }

    private boolean isRouteChargePoint(XPPoiInfo xPPoiInfo) {
        XPViaPoint xPViaPoint;
        if (this.mMapDecorator.getDecoratorType() == DecoratorType.WAY_POINT) {
            int currentExpandedIndex = this.mMapDecorator.getCurrentExpandedIndex();
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
            if (viaInfos == null || currentExpandedIndex <= -1 || currentExpandedIndex >= viaInfos.size() || (xPViaPoint = viaInfos.get(currentExpandedIndex)) == null || xPViaPoint.getViaType() != 4) {
                return false;
            }
            this.mPoiInfo = xPPoiInfo;
            PoiCardHelper.PoiCardManagerCallback poiCardManagerCallback = this.mPoiCallback;
            if (poiCardManagerCallback != null) {
                poiCardManagerCallback.onPoiShow(this);
            }
            hideCard();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderCard(XPPoiInfo xPPoiInfo, final boolean z) {
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("renderCard poiInfo = ");
        sb.append(xPPoiInfo == null ? "null" : xPPoiInfo.dumpXPPoiInfo());
        sb.append(",isRefresh: ");
        sb.append(z);
        L.i(tag, sb.toString());
        this.mPoiInfo = xPPoiInfo;
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.4
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal(null, null)) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    final long currentTimeMillis2 = System.currentTimeMillis();
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PoiCardView.this.mDisplayConfig = PoiCardView.this.mPresenter.getCardContentsDisplayState();
                            if (L.ENABLE) {
                                L.Tag tag2 = PoiCardView.TAG;
                                L.d(tag2, "preloadRender config:" + PoiCardView.this.mDisplayConfig + ",cost time:" + (currentTimeMillis2 - currentTimeMillis));
                            }
                            if (PoiCardView.this.checkViewIsLegal(null, null)) {
                                PoiCardView.this.render(z);
                                if (PoiCardView.this.mPoiCallback != null) {
                                    if (z) {
                                        PoiCardView.this.mPoiCallback.onPoiUpdate(PoiCardView.this);
                                    } else {
                                        PoiCardView.this.mPoiCallback.onPoiShow(PoiCardView.this);
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    private void setAnimationCallback(AnimationCallback animationCallback) {
        this.mAnimationCallback = animationCallback;
    }

    public void render(boolean z) {
        IBaseScene iBaseScene;
        if (this.mPoiInfo == null) {
            L.w(TAG, "render data error");
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "render mIsVisible: " + this.mIsVisible);
        if (!this.mIsVisible || (iBaseScene = this.mScene) == null || !iBaseScene.isSceneLegal()) {
            L.Tag tag2 = TAG;
            L.e(tag2, "render mScene: " + this.mScene);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        showContent();
        scroll2TopForFirstRender(z);
        setVuiForMainBody();
        setMainBodyBackground();
        showPictures(z);
        renderBasicInfo();
        renderRoadInfo(z);
        renderEvaluteTag(z);
        renderCarServiceTag(z);
        renderRatingInfo();
        renderNaviInfo(z);
        renderChargeInfo(z);
        renderParkInfo(z);
        renderPoiEntry(z);
        renderAOIInfo(z);
        renderBusinessTimeInfo(z, 0L);
        renderPriceInfo(false);
        renderSubPoiInfo();
        renderHomeOrCompany(z);
        renderBottomButtonsStatus(z);
        addListener();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (L.ENABLE) {
            L.Tag tag3 = TAG;
            L.d(tag3, "poi card render cost time:" + (currentTimeMillis2 - currentTimeMillis) + "ms, isRefresh:" + z);
        }
    }

    private void setVuiForMainBody() {
        XPPoiInfo xPPoiInfo;
        XLinearLayout xLinearLayout = this.mMainBody;
        if (xLinearLayout == null || (xPPoiInfo = this.mPoiInfo) == null) {
            return;
        }
        xLinearLayout.setVuiLabel(xPPoiInfo.getName());
    }

    private void scroll2TopForFirstRender(boolean z) {
        if (z || !checkViewIsLegal(this.mTopScroller, "scroll2TopForFirstRender")) {
            return;
        }
        this.mTopScroller.scrollToTop();
    }

    private void addListener() {
        addScrollListener();
    }

    private void addScrollListener() {
        if (checkViewIsLegal(this.mTopScroller, "addScrollListener")) {
            this.mTopScroller.setScrollViewListener(new XpPoiPopScrollView.OnScrollListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.5
                @Override // com.xiaopeng.montecarlo.views.XpPoiPopScrollView.OnScrollListener
                public void onScrollChanged(ScrollView scrollView, int i, int i2, int i3, int i4) {
                }

                @Override // com.xiaopeng.montecarlo.views.XpPoiPopScrollView.OnScrollListener
                public void onScrollEnd() {
                }

                @Override // com.xiaopeng.montecarlo.views.XpPoiPopScrollView.OnScrollListener
                public void onScrollStart() {
                    PoiPopStatUtil.sendStatDataWhenGesture(PoiCardView.this.mMainContext, 3);
                }
            });
        }
    }

    public void move() {
        if (checkViewIsLegal("move")) {
            updatePosition();
        }
    }

    private void updatePosition() {
        if (checkViewIsLegal("updatePosition")) {
            this.mPresenter.updatePosition(this.mWidth, this.mYOffset + this.mOffsetToMark);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int i3 = this.mHeight;
        if (i3 > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, mode));
        setMeasuredDimension(getMeasuredWidth(), Math.min(getMeasuredHeight(), this.mMaxHeight));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (checkViewIsLegal("onLayout") && checkViewIsLegal(this.mTopScroller, "onLayout") && checkViewIsLegal(this.mPoiDividerBottom, "onLayout")) {
            if (this.mTopScroller.getChildAt(0) != null && this.mTopScroller.getChildAt(0).getMeasuredHeight() > this.mTopScroller.getHeight()) {
                this.mPoiDividerBottom.setVisibility(0);
            } else {
                this.mPoiDividerBottom.setVisibility(8);
            }
        }
    }

    public void hideCard() {
        L.i(TAG, "hideCard");
        if (checkViewIsLegal("hideCard") && this.mScene != null) {
            XBaseDialog xBaseDialog = this.mNumPopDialog;
            if (xBaseDialog != null) {
                xBaseDialog.dismiss();
                this.mNumPopDialog = null;
            }
            XBaseDialog xBaseDialog2 = this.mPicPopDialog;
            if (xBaseDialog2 != null) {
                xBaseDialog2.dismiss();
                this.mPicPopDialog = null;
            }
            PoiCardBottomButtons poiCardBottomButtons = this.mBottomBtnContainer;
            if (poiCardBottomButtons != null) {
                poiCardBottomButtons.poiHide();
            }
            clearAOIPolygon();
            hideChildScenesForPoiCard();
            setVisibility(8);
            this.mIsVisible = false;
            L.Tag tag = TAG;
            L.i(tag, "hideCard mIsVisible = " + this.mIsVisible);
            PoiCardHelper.PoiCardManagerCallback poiCardManagerCallback = this.mPoiCallback;
            if (poiCardManagerCallback != null) {
                poiCardManagerCallback.onPoiHide(this);
            }
        }
    }

    private void hideChildScenesForPoiCard() {
        if (L.ENABLE) {
            L.d(TAG, "hideChildScenesForPoiCard");
        }
        if (!checkViewIsLegal("hideChildScenesForPoiCard")) {
            L.e(TAG, "hideChildScenesForPoiCard view is illegal");
            return;
        }
        MainContext mainContext = this.mMainContext;
        if (mainContext == null) {
            L.e(TAG, "hideChildScenesForPoiCard mMainContext is null");
            return;
        }
        IBaseScene currentScene = mainContext.getCurrentScene();
        if (currentScene == null) {
            L.e(TAG, "hideChildScenesForPoiCard scene is null");
        } else if (Utils.isPopDialogScene(currentScene)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "hideChildScenesForPoiCard scene:" + currentScene);
            }
            currentScene.goBack();
        }
    }

    private void renderBasicInfo() {
        if (checkViewIsLegal("renderBasicInfo")) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardView$MxR2AIhLwrgXYnGTbdii7DRih2E
                @Override // java.lang.Runnable
                public final void run() {
                    PoiCardView.this.lambda$renderBasicInfo$0$PoiCardView();
                }
            });
        }
    }

    public /* synthetic */ void lambda$renderBasicInfo$0$PoiCardView() {
        renderTitleInfo();
        showPoiAddressInfo();
    }

    private void renderNaviInfo(final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderNaviInfo") && PoiCardView.this.checkPresenterIsLegal("renderNaviInfo")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mCarRemainDistanceLayoutContainer, "renderNaviInfo") || PoiCardView.this.mCarRemainDistanceLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isDistanceVisible = PoiCardView.this.mDisplayConfig.isDistanceVisible();
                    PoiCardView.this.mCarRemainDistanceLayoutContainer.setVisibility(isDistanceVisible ? 0 : 8);
                    if (isDistanceVisible) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        hashMap.put("mainContext", PoiCardView.this.mMainContext);
                        hashMap.put(PoiCardCarRemainDistance.KEY_DATA_PROVIDER, PoiCardView.this.mPresenter.getDataProvider());
                        hashMap.put("isRefresh", Boolean.valueOf(z));
                        if (PoiCardView.this.mCarRemainDistanceContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mCarRemainDistanceContainer = new PoiCardCarRemainDistance(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        } else {
                            PoiCardView.this.mCarRemainDistanceContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mCarRemainDistanceLayoutContainer.getChildCount() == 0) {
                            PoiCardView.this.mCarRemainDistanceLayoutContainer.addView(PoiCardView.this.mCarRemainDistanceContainer, 0);
                        }
                    }
                }
            }
        });
    }

    private void renderChargeInfo(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.7
            @Override // java.lang.Runnable
            public void run() {
                PoiCardView.this.renderChargeDetail();
                PoiCardView.this.renderChargeDownLock();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void renderChargeDetail() {
        if (!checkViewIsLegal(this.mChargeDetailLayoutContainer, "renderChargeInfo")) {
            L.Tag tag = TAG;
            L.e(tag, "checkViewIsLegal " + checkViewIsLegal(this.mChargeDetailLayoutContainer, "renderChargeInfo"));
        } else if (this.mChargeDetailLayoutContainer == null || this.mPoiInfo == null) {
        } else {
            boolean isChargeVisible = this.mDisplayConfig.isChargeVisible();
            this.mChargeDetailLayoutContainer.setVisibility(isChargeVisible ? 0 : 8);
            if (!isChargeVisible) {
                L.Tag tag2 = TAG;
                L.e(tag2, "isChargeVisible=" + isChargeVisible);
                return;
            }
            int width = (checkViewIsLegal(this.mPoiPopContainer, "renderChargeInfo") && checkViewIsLegal(this.mTopScroller, "renderChargeInfo") && checkViewIsLegal(this.mPoiScrollContainer, "renderChargeInfo")) ? ((this.mPoiPopContainer.getWidth() - this.mTopScroller.getPaddingLeft()) - this.mTopScroller.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) this.mPoiScrollContainer.getLayoutParams()).rightMargin : 0;
            HashMap hashMap = new HashMap();
            hashMap.put("poiInfo", this.mPoiInfo);
            hashMap.put(PoiCardChargeStatusContainer.KEY_MAX_DISPLAY_WIDTH, Integer.valueOf(width));
            hashMap.put("isSettingHomeOrOffice", Boolean.valueOf(this.mPresenter.checkIsSettingHomeOrOffice()));
            hashMap.put("clickListener", this.mPoiEntryClickListener);
            PoiCardChargeStatusContainer poiCardChargeStatusContainer = this.mChargeDetail;
            if (poiCardChargeStatusContainer == null) {
                this.mChargeDetail = new PoiCardChargeStatusContainer(getContext(), hashMap, this);
            } else {
                poiCardChargeStatusContainer.refresh(getContext(), hashMap, this);
            }
            if (this.mChargeDetailLayoutContainer.getChildCount() == 0) {
                this.mChargeDetailLayoutContainer.addView(this.mChargeDetail, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void renderChargeDownLock() {
        if (!checkViewIsLegal(this.mChargeDownLockLayoutContainer, "renderChargeDownLock") || this.mChargeDownLockLayoutContainer == null || this.mPoiInfo == null) {
            return;
        }
        boolean isChargeVisible = this.mDisplayConfig.isChargeVisible();
        this.mChargeDownLockLayoutContainer.setVisibility(isChargeVisible ? 0 : 8);
        if (isChargeVisible) {
            HashMap hashMap = new HashMap();
            hashMap.put("poiInfo", this.mPoiInfo);
            hashMap.put("isSettingHomeOrOffice", Boolean.valueOf(this.mPresenter.checkIsSettingHomeOrOffice()));
            PoiCardChargeDownLockContainer poiCardChargeDownLockContainer = this.mChargeDownLock;
            if (poiCardChargeDownLockContainer == null) {
                this.mChargeDownLock = new PoiCardChargeDownLockContainer(getContext(), hashMap, this);
            } else {
                poiCardChargeDownLockContainer.refresh(getContext(), hashMap, this);
            }
            if (this.mChargeDownLockLayoutContainer.getChildCount() == 0) {
                this.mChargeDownLockLayoutContainer.addView(this.mChargeDownLock, 0);
            }
        }
    }

    private void renderParkInfo(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.8
            @Override // java.lang.Runnable
            public void run() {
                PoiCardView poiCardView = PoiCardView.this;
                if (!poiCardView.checkViewIsLegal(poiCardView.mParkLayoutContainer, "renderParkInfo") || PoiCardView.this.mParkLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                    return;
                }
                boolean isParkVisible = PoiCardView.this.mDisplayConfig.isParkVisible();
                PoiCardView.this.mParkLayoutContainer.setVisibility(isParkVisible ? 0 : 8);
                if (isParkVisible) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                    if (PoiCardView.this.mPoiParkContainer == null) {
                        PoiCardView poiCardView2 = PoiCardView.this;
                        poiCardView2.mPoiParkContainer = new PoiCardParkContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                    } else {
                        PoiCardView.this.mPoiParkContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                    }
                    if (PoiCardView.this.mParkLayoutContainer.getChildCount() == 0) {
                        PoiCardView.this.mParkLayoutContainer.addView(PoiCardView.this.mPoiParkContainer, 0);
                    }
                }
            }
        });
    }

    private void renderAOIInfo(final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.9
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.mPresenter == null) {
                    L.w(PoiCardView.TAG, "renderAOIInfo mPresenter is null");
                } else {
                    PoiCardView.this.mPresenter.renderAOIInfo(z);
                }
            }
        });
    }

    public void renderBusinessTimeInfo(boolean z, final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.10
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderBusinessTimeInfo")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mTimeLayoutContainer, "renderBusinessTimeInfo") || !PoiCardView.this.checkPresenterIsLegal("renderBusinessTimeInfo") || PoiCardView.this.mTimeLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isTimeVisible = PoiCardView.this.mDisplayConfig.isTimeVisible();
                    PoiCardView.this.mTimeLayoutContainer.setVisibility(isTimeVisible ? 0 : 8);
                    if (isTimeVisible) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        hashMap.put(PoiCardTimeContainer.KEY_TIME_ON_ROAD, Long.valueOf(j));
                        if (PoiCardView.this.mMapDecorator != null) {
                            hashMap.put("cardType", Integer.valueOf(PoiCardView.this.mMapDecorator.getCardType()));
                        }
                        if (PoiCardView.this.mTimeContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mTimeContainer = new PoiCardTimeContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        } else {
                            PoiCardView.this.mTimeContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mTimeLayoutContainer.getChildCount() == 0) {
                            PoiCardView.this.mTimeLayoutContainer.addView(PoiCardView.this.mTimeContainer, 0);
                        }
                    }
                }
            }
        });
    }

    public void renderPriceInfo(final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderPriceInfo")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mPriceLayoutContainer, "renderPriceInfo") || PoiCardView.this.mPriceLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isPriceVisible = PoiCardView.this.mDisplayConfig.isPriceVisible();
                    PoiCardView.this.mPriceLayoutContainer.setVisibility(isPriceVisible ? 0 : 8);
                    if (isPriceVisible) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        hashMap.put(PoiCardPriceContainer.KEY_PRICE_LISTENER, PoiCardView.this.mPriceListener);
                        hashMap.put("isRefresh", Boolean.valueOf(z));
                        if (PoiCardView.this.mPoiPriceContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mPoiPriceContainer = new PoiCardPriceContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        } else {
                            PoiCardView.this.mPoiPriceContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mPriceLayoutContainer.getChildCount() == 0) {
                            PoiCardView.this.mPriceLayoutContainer.addView(PoiCardView.this.mPoiPriceContainer, 0);
                        }
                    }
                }
            }
        });
    }

    private void renderSubPoiInfo() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.mPresenter == null) {
                    L.w(PoiCardView.TAG, "renderSubPoiInfo mPresenter is null");
                } else {
                    PoiCardView.this.mPresenter.renderSubPoiInfo();
                }
            }
        });
    }

    private void renderRoadInfo(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.13
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderRoadInfo")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mRoadInfoLayoutContainer, "renderRoadInfo") || PoiCardView.this.mRoadInfoLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isRoadInfoVisible = PoiCardView.this.mDisplayConfig.isRoadInfoVisible();
                    PoiCardView.this.mRoadInfoLayoutContainer.setVisibility(isRoadInfoVisible ? 0 : 8);
                    if (isRoadInfoVisible) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        if (PoiCardView.this.mRoadInfoContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mRoadInfoContainer = new PoiCardRoadInfoContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        } else {
                            PoiCardView.this.mRoadInfoContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mRoadInfoLayoutContainer.getChildCount() == 0) {
                            PoiCardView.this.mRoadInfoLayoutContainer.addView(PoiCardView.this.mRoadInfoContainer, 0);
                        }
                    }
                }
            }
        });
    }

    public void renderTitleInfo() {
        if (!checkViewIsLegal("renderTitleInfo") || !checkViewIsLegal(this.mTitleLayoutContainer, "renderTitleInfo") || this.mTitleLayoutContainer == null || this.mPoiInfo == null) {
            return;
        }
        boolean isNameVisible = this.mDisplayConfig.isNameVisible();
        this.mTitleLayoutContainer.setVisibility(isNameVisible ? 0 : 8);
        if (isNameVisible) {
            HashMap hashMap = new HashMap();
            hashMap.put("poiInfo", this.mPoiInfo);
            PoiCardTitleContainer poiCardTitleContainer = this.mTitleContainer;
            if (poiCardTitleContainer == null) {
                this.mTitleContainer = new PoiCardTitleContainer(getContext(), hashMap, this);
            } else {
                poiCardTitleContainer.refresh(getContext(), hashMap, this);
            }
            if (this.mTitleLayoutContainer.getChildCount() == 0) {
                this.mTitleLayoutContainer.addView(this.mTitleContainer, 0);
            }
        }
    }

    public void showPoiAddressInfo() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.14
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("showPoiAddressInfo")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mTvAddress, "showPoiAddressInfo") || PoiCardView.this.mTvAddress == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isAddressVisible = PoiCardView.this.mDisplayConfig.isAddressVisible();
                    PoiCardView.this.mTvAddress.setVisibility(isAddressVisible ? 0 : 8);
                    if (isAddressVisible) {
                        PoiCardView.this.mTvAddress.getToggleView().setVuiLabel(ContextUtils.getString(R.string.vui_label_poi_card_poi_address));
                        VoiceFullScenesUtil.setVuiElementTag(PoiCardView.this.mTvAddress.getToggleView(), PoiCardView.this.mTvAddress.getToggleView().getId() + DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT + PoiCardView.this.mPoiInfo.getPoiId());
                        PoiCardView.this.mTvAddress.setText(null);
                        PoiCardView.this.mTvAddress.setChangeListener(PoiCardView.this);
                        String tag = PoiCardView.this.mPoiInfo.getTag();
                        if (L.ENABLE) {
                            L.Tag tag2 = PoiCardView.TAG;
                            L.d(tag2, "poiaddress_detail" + GsonUtil.toJson(PoiCardView.this.mPoiInfo));
                        }
                        if (TextUtils.isEmpty(tag)) {
                            PoiCardView.this.mTvAddress.setText(PoiCardView.this.mPoiInfo.getAddress());
                        } else {
                            String string = ContextUtils.getString(R.string.poi_address_info);
                            PoiCardView poiCardView2 = PoiCardView.this;
                            String format = String.format(string, tag, poiCardView2.trimedAddress(poiCardView2.mPoiInfo.getAddress()));
                            if (Utils.isPortrait()) {
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
                                int indexOf = format.indexOf(tag);
                                spannableStringBuilder.setSpan(new TextAppearanceSpan(PoiCardView.this.getContext(), R.style.poi_address_with_tag_type), indexOf, tag.length() + indexOf, 18);
                                PoiCardView.this.mTvAddress.setText(spannableStringBuilder.toString());
                            } else {
                                PoiCardView.this.mTvAddress.setText(format);
                            }
                        }
                        PoiCardView.this.mTvAddress.resetStatus(false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence trimedAddress(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setTrimedAddress" + str);
        }
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        return !trim.startsWith("-") ? trim : trim.replaceFirst("-+", "");
    }

    public void renderEvaluteTag(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.15
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderEvaluteTag")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mEvaluationLayoutContainer, "renderEvaluteTag") || PoiCardView.this.mEvaluationLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isEvaluationVisible = PoiCardView.this.mDisplayConfig.isEvaluationVisible();
                    PoiCardView.this.mEvaluationLayoutContainer.setVisibility(isEvaluationVisible ? 0 : 8);
                    if (isEvaluationVisible) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        if (PoiCardView.this.mEvaluationContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mEvaluationContainer = new PoiCardEvaluationContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        } else {
                            PoiCardView.this.mEvaluationContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mEvaluationLayoutContainer.getChildCount() == 0) {
                            PoiCardView.this.mEvaluationLayoutContainer.addView(PoiCardView.this.mEvaluationContainer, 0);
                        }
                    }
                }
            }
        });
    }

    public void renderCarServiceTag(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.16
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderCarServiceTag")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mCarServiceLayoutContainer, "renderCarServiceTag") || PoiCardView.this.mCarServiceLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isCarServiceVisible = PoiCardView.this.mDisplayConfig.isCarServiceVisible();
                    PoiCardView.this.mCarServiceLayoutContainer.setVisibility(isCarServiceVisible ? 0 : 8);
                    if (isCarServiceVisible) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        if (PoiCardView.this.mCarServiceContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mCarServiceContainer = new PoiCardCarServiceContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        } else {
                            PoiCardView.this.mCarServiceContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mCarServiceLayoutContainer.getChildCount() == 0) {
                            PoiCardView.this.mCarServiceLayoutContainer.addView(PoiCardView.this.mCarServiceContainer, 0);
                        }
                    }
                }
            }
        });
    }

    private void renderRatingInfo() {
        XPPoiInfo xPPoiInfo;
        int i;
        this.mStarContainer.setVisibility(8);
        this.mRatingBar.setVisibility(8);
        this.mCost.setVisibility(8);
        if (!Utils.isFoodOpen() || (xPPoiInfo = this.mPoiInfo) == null) {
            return;
        }
        String blCategory = xPPoiInfo.getBlCategory();
        if (TextUtils.isEmpty(blCategory) || !blCategory.startsWith(XPPoiCategory.SEARCH_CATEGORY_FOOD)) {
            return;
        }
        if (this.mPoiInfo.getRating() > 0.0f || !TextUtils.isEmpty(this.mPoiInfo.getPrice())) {
            this.mStarContainer.setVisibility(0);
            this.mRatingBar.setVisibility(0);
            this.mRatingBar.setProgressDrawableTiled(ThemeWatcherUtil.getDrawable(R.drawable.layer_rating_bar));
            this.mRatingBar.setRating(this.mPoiInfo.getRating());
            try {
                i = (int) Float.parseFloat(this.mPoiInfo.getPrice());
            } catch (Exception unused) {
                i = 0;
            }
            if (i > 0) {
                this.mCost.setVisibility(0);
                this.mCost.setText(String.format(ContextUtils.getString(R.string.search_result_cost), String.valueOf(i)));
            }
        }
    }

    private void showPictures(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.17
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("showPictures")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mPicLayoutContainer, "showPictures") || !PoiCardView.this.checkPresenterIsLegal("showPictures") || PoiCardView.this.mPicLayoutContainer == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean isPicVisible = PoiCardView.this.mDisplayConfig.isPicVisible();
                    PoiCardView.this.mPicLayoutContainer.setVisibility(isPicVisible ? 0 : 8);
                    if (isPicVisible) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        hashMap.put("mainContext", PoiCardView.this.mMainContext);
                        if (PoiCardView.this.mPicContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mPicContainer = new PoiCardPicContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                            PoiCardView.this.mPicContainer.setOnPopDialogShowListener(new onPopDialogShow() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.17.1
                                @Override // com.xiaopeng.montecarlo.views.poicard.onPopDialogShow
                                public void onPopDialogDismiss(XBaseDialog xBaseDialog) {
                                }

                                @Override // com.xiaopeng.montecarlo.views.poicard.onPopDialogShow
                                public void onPopDialogShow(XBaseDialog xBaseDialog) {
                                    PoiCardView.this.mPicPopDialog = xBaseDialog;
                                }
                            });
                        } else {
                            PoiCardView.this.mPicContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mPicLayoutContainer.getChildCount() == 0) {
                            PoiCardView.this.mPicLayoutContainer.addView(PoiCardView.this.mPicContainer, 0);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: com.xiaopeng.montecarlo.views.poicard.PoiCardView$18  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass18 implements Runnable {
        AnonymousClass18() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PoiCardView.this.checkViewIsLegal("renderSubPoi")) {
                PoiCardView poiCardView = PoiCardView.this;
                if (!poiCardView.checkViewIsLegal(poiCardView.mPoiChildContainer, "renderSubPoi") || PoiCardView.this.mPoiChildContainer == null || PoiCardView.this.mPoiInfo == null) {
                    return;
                }
                PoiCardView.this.mPoiChildView.removeAllViews();
                boolean isSubPoiVisible = PoiCardView.this.mDisplayConfig.isSubPoiVisible();
                PoiCardView.this.mPoiChildContainer.setVisibility(isSubPoiVisible ? 0 : 8);
                if (isSubPoiVisible) {
                    ArrayList<XPPoiInfo> child = PoiCardView.this.mPoiInfo.getChild();
                    if (CollectionUtils.isNotEmpty(child)) {
                        PoiCardView.this.mPoiChildView.setChildViewClickListener(new ChildPoiGridView.ChildViewClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.18.1
                            @Override // com.xiaopeng.montecarlo.views.ChildPoiGridView.ChildViewClickListener
                            public void onExpandViewClick(boolean z) {
                            }

                            @Override // com.xiaopeng.montecarlo.views.ChildPoiGridView.ChildViewClickListener
                            public void onChildClick(View view, XPPoiInfo xPPoiInfo) {
                                PoiPopStatUtil.sendStatDataWhenSubPoi(PoiCardView.this.mMainContext);
                                PoiCardView.this.mMainContext.getDecoratorManager().focusByPriority(PoiCardView.this.mScene, xPPoiInfo, new DecoratorType[0]);
                            }
                        });
                        PoiCardView.this.mPoiChildView.addChildViews(child.size(), child);
                        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.18.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PoiCardView.this.mTimeContainer == null || PoiCardView.this.mTvAddress == null) {
                                    return;
                                }
                                final String formatElementFatherLabelForSearch = CommonVuiHelper.getInstance().formatElementFatherLabelForSearch(-1, PoiCardView.this.mTitleContainer.getTitle(), PoiCardView.this.mTvAddress.getText());
                                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.18.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        PoiCardView.this.mPresenter.formatChildPoi(PoiCardView.this.mPoiChildView, formatElementFatherLabelForSearch);
                                    }
                                });
                            }
                        });
                    }
                }
            }
        }
    }

    public void renderSubPoi() {
        UiHandlerUtil.getInstance().post(new AnonymousClass18());
    }

    private void renderHomeOrCompany(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.19
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderHomeOrCompany")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (poiCardView.checkViewIsLegal(poiCardView.mPoiBottom, "renderHomeOrCompany") && PoiCardView.this.mPoiBottom != null) {
                        boolean z2 = PoiCardView.this.mDisplayConfig.isHomeOrOfficeButtonsVisible() || PoiCardView.this.mDisplayConfig.isBottomButtonsVisible();
                        boolean isHomeOrOfficeButtonsVisible = PoiCardView.this.mDisplayConfig.isHomeOrOfficeButtonsVisible();
                        PoiCardView.this.mPoiBottom.setVisibility(z2 ? 0 : 8);
                        if (isHomeOrOfficeButtonsVisible) {
                            PoiCardView.this.mPoiBottom.removeAllViews();
                            HashMap hashMap = new HashMap();
                            hashMap.put("searchDest", Integer.valueOf(PoiCardView.this.mPresenter.getSearchDest()));
                            hashMap.put("clickListener", PoiCardView.this);
                            if (PoiCardView.this.mSettingHomeOrCompanyContainer == null) {
                                PoiCardView poiCardView2 = PoiCardView.this;
                                poiCardView2.mSettingHomeOrCompanyContainer = new PoiCardHomeCompanyContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                            } else {
                                PoiCardView.this.mSettingHomeOrCompanyContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                            }
                            if (PoiCardView.this.mPoiBottom.getChildCount() == 0) {
                                PoiCardView.this.mPoiBottom.addView(PoiCardView.this.mSettingHomeOrCompanyContainer, 0);
                            }
                            if (PoiCardView.this.mBottomBtnContainer != null) {
                                PoiCardView.this.mBottomBtnContainer.visibleStateExchange(true);
                            }
                        }
                    }
                }
            }
        });
    }

    public void showSettingHomeResult(boolean z) {
        this.mMainContext.showPrompt(z ? R.string.action_set_home_success : R.string.action_set_home_failure);
    }

    public void showOfficeSettingResult(boolean z) {
        this.mMainContext.showPrompt(z ? R.string.action_set_company_success : R.string.action_set_company_failure);
    }

    public void updateCardPosition(Rect rect) {
        if (checkViewIsLegal("updateCardPosition")) {
            if (rect == null) {
                L.w(TAG, "updateCardPosition rect is null");
                return;
            }
            float translationX = getTranslationX();
            float translationY = getTranslationY();
            if (translationX == rect.left && translationY == rect.top) {
                if (L.ENABLE) {
                    L.d(TAG, "updateCardPosition translation is already same with rect");
                    return;
                }
                return;
            }
            setTranslationX(rect.left);
            setTranslationY(-rect.bottom);
        }
    }

    public void renderAoiAreaInfo(boolean z) {
        XPPoiInfo xPPoiInfo;
        if (!checkViewIsLegal("renderAoiAreaInfo") || (xPPoiInfo = this.mPoiInfo) == null) {
            return;
        }
        if (z && TextUtils.equals(this.mAoiRefreshedId, xPPoiInfo.getPoiId()) && this.mAoiRefreshedType == this.mDecoratorType && this.mMapDecorator.isAoiRefreshed()) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "renderAoiAreaInfo same poi " + this.mPoiInfo.getName());
                return;
            }
            return;
        }
        clearAOIPolygon();
        ArrayList<XPCoordinate2DDouble> poiPolygonBounds = this.mPoiInfo.getPoiPolygonBounds();
        if (CollectionUtils.isNotEmpty(poiPolygonBounds)) {
            L.i(TAG, "renderAoiAreaInfo");
            BizPolygonBusinessInfo bizPolygonBusinessInfo = new BizPolygonBusinessInfo();
            bizPolygonBusinessInfo.mDrawPolygonRim = true;
            for (int i = 0; i < poiPolygonBounds.size(); i++) {
                bizPolygonBusinessInfo.mVecPoints.add(NaviUtil.transformCoord2DDoubleToCoord3DDouble(poiPolygonBounds.get(i)));
            }
            MainContext mainContext = this.mMainContext;
            if (mainContext != null && mainContext.getMapView() != null) {
                this.mMainContext.getMapView().getBizControlManager().renderAoiAreaInfo(bizPolygonBusinessInfo);
                this.mAoiRefreshedId = this.mPoiInfo.getPoiId();
                this.mAoiRefreshedType = this.mDecoratorType;
                this.mMapDecorator.setAoiRefreshed(true);
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "renderAoiAreaInfo success poi:" + this.mPoiInfo.getName());
                }
                if (getVisibility() == 0) {
                    this.mPresenter.checkIsShouldOverviewPolygon(bizPolygonBusinessInfo.mVecPoints);
                    return;
                }
                return;
            }
        }
        if (L.ENABLE) {
            L.Tag tag3 = TAG;
            L.d(tag3, "renderAoiAreaInfo failure:aoi info is empty poi:" + this.mPoiInfo.getName());
        }
    }

    public void startDestinationUpdate(Bundle bundle) {
        IBaseScene iBaseScene = this.mScene;
        if (iBaseScene == null) {
            return;
        }
        if (iBaseScene.getMode() == StatusConst.Mode.NAVI || this.mScene.getMode() == StatusConst.Mode.ROUTE || this.mScene.getMode() == StatusConst.Mode.EXPLORE) {
            if (this.mScene.getPresenter() instanceof BaseMapDecorator.IMapDecoratorRouteUpdateListener) {
                ((BaseMapDecorator.IMapDecoratorRouteUpdateListener) this.mScene.getPresenter()).onDestinationUpdate(this.mDecoratorType, bundle);
            }
        } else if (TBTManager.getInstance().getCurrentStatus() != 0) {
            if (TBTManager.getInstance().getCurrentStatus() == 2) {
                this.mScene.startScene(new ExploreBridge().setBundle(bundle));
                return;
            }
            bundle.putBoolean(SystemConst.ROUTE_MANUAL, true);
            this.mScene.startScene(new NaviBridge().setBundle(bundle));
        } else {
            this.mScene.startScene(new RouteBridge().setBundle(bundle));
            if (VoiceFusionUtil.getInstance().isInVoiceSearchFusionMode() && this.mScene.getMode() == StatusConst.Mode.SEARCH_RESULT) {
                this.mScene.goBack();
            }
        }
    }

    public void goToSearch(FavoriteAddress favoriteAddress) {
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_DEST_KEY, this.mSearchDest);
        bundle.putParcelable(SearchBridge.SET_RESULT_OBJECT, favoriteAddress.getXPPoiInfo());
        this.mScene.setReturnResult(bundle);
        this.mScene.goBack();
    }

    public void startRouteUpdate(Bundle bundle) {
        if (this.mScene == null) {
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, ">>> startRouteUpdate sceneMode:" + this.mScene.getMode());
        if (this.mScene.getMode() == StatusConst.Mode.NAVI || this.mScene.getMode() == StatusConst.Mode.ROUTE || this.mScene.getMode() == StatusConst.Mode.EXPLORE) {
            if (this.mScene.getPresenter() instanceof BaseMapDecorator.IMapDecoratorRouteUpdateListener) {
                ((BaseMapDecorator.IMapDecoratorRouteUpdateListener) this.mScene.getPresenter()).onRouteUpdate(this.mDecoratorType, bundle);
            }
        } else if (TBTManager.getInstance().getCurrentStatus() != 0) {
            if (TBTManager.getInstance().getCurrentStatus() == 2) {
                this.mScene.startScene(new ExploreBridge().setBundle(bundle));
                return;
            }
            bundle.putBoolean(SystemConst.ROUTE_MANUAL, true);
            this.mScene.startScene(new NaviBridge().setBundle(bundle));
        } else {
            this.mScene.startScene(new RouteBridge().setBundle(bundle));
        }
    }

    public void handleSearchClick() {
        int i;
        if (this.mScene == null || this.mPoiInfo == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(SearchBridge.SEARCH_MODE, 101);
        bundle.putParcelable(SearchBridge.SEARCH_AROUND_ITEM, this.mPoiInfo);
        SearchBridge searchBridge = new SearchBridge();
        if (isShowSearchModeWayLayout()) {
            bundle.putInt(SearchBridge.SEARCH_MODE_VIEW, 102);
            int i2 = -1;
            if (Utils.isExploreScene(this.mScene)) {
                i2 = this.mScene.getSceneStackSize();
                i = this.mScene.getChildStackSize();
            } else if (Utils.isNaviScene(this.mScene)) {
                i2 = this.mScene.getSceneStackSize();
                i = this.mScene.getChildStackSize();
            } else if (Utils.isRouteScene(this.mScene)) {
                i2 = this.mScene.getSceneStackSize();
                i = this.mScene.getChildStackSize();
            } else if (Utils.isSearchResultScene(this.mScene)) {
                i2 = this.mScene.getSceneStackSize() - 1;
                i = this.mScene.getChildStackSize();
            } else {
                i = -1;
            }
            bundle.putInt(SearchBridge.FROM_SCENE_INDEX, i2);
            bundle.putInt(SearchBridge.FROM_SCENE_CHILD_INDEX, i);
            L.i(TAG, "open search with over mode for search around in poi card");
            searchBridge.enableOverMode();
            this.mScene.startScene(searchBridge.setBundle(bundle), 100);
            return;
        }
        this.mScene.startScene(searchBridge.setBundle(bundle));
    }

    public void clearAOIPolygon() {
        L.i(TAG, "'clearAOIPolygon");
        MainContext mainContext = this.mMainContext;
        if (mainContext == null || mainContext.getMapView() == null) {
            return;
        }
        this.mMainContext.getMapView().getBizControlManager().clearAOIPolygon();
        this.mAoiRefreshedId = "";
        this.mAoiRefreshedType = DecoratorType.INVALID;
        BaseMapDecorator baseMapDecorator = this.mMapDecorator;
        if (baseMapDecorator != null) {
            baseMapDecorator.setAoiRefreshed(false);
        }
    }

    public void checkIsShouldOverviewPolygon(ArrayList<Coord3DDouble> arrayList) {
        if (L.ENABLE) {
            L.d(TAG, "checkIsShouldOverviewPolygon");
        }
        if (checkViewIsLegal("checkIsShouldOverviewPolygon") && CollectionUtils.isNotEmpty(arrayList)) {
            PreviewParam previewParam = new PreviewParam();
            Iterator<Coord3DDouble> it = arrayList.iterator();
            while (it.hasNext()) {
                Coord3DDouble next = it.next();
                if (next != null) {
                    previewParam.points.add(new PointD(next.lon, next.lat));
                }
            }
            previewParam.bUseRect = false;
            Rect poiCardOffsetRect = NaviUtil.getPoiCardOffsetRect();
            previewParam.screenLeft = poiCardOffsetRect.left;
            previewParam.screenTop = poiCardOffsetRect.top;
            previewParam.screenRight = poiCardOffsetRect.right;
            previewParam.screenBottom = poiCardOffsetRect.bottom;
            previewParam.leftOfMap = previewParam.screenLeft;
            previewParam.topOfMap = previewParam.screenTop;
            previewParam.bAdjustHeaderAngle = false;
            MainContext mainContext = this.mMainContext;
            if (mainContext == null || mainContext.getMapView() == null) {
                return;
            }
            if (L.ENABLE) {
                L.d(TAG, "checkIsShouldOverviewPolygon showPreview");
            }
            this.mMainContext.getMapView().showPreview(previewParam);
        }
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public void initDecoratorValues(BaseMapDecorator baseMapDecorator) {
        if (baseMapDecorator != null) {
            this.mMapDecorator = baseMapDecorator;
            this.mSearchDest = baseMapDecorator.getSearchDest();
            this.mDecoratorType = baseMapDecorator.getDecoratorType();
            this.mSearchMode = baseMapDecorator.getSearchMode();
        }
    }

    private boolean isShowSearchModeWayLayout() {
        boolean z = this.mDecoratorType == DecoratorType.WAY_POINT;
        boolean z2 = (this.mDecoratorType == DecoratorType.INVALID || TBTManager.getInstance().isRouting()) ? false : true;
        boolean z3 = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId()) != null;
        if (z) {
            return true;
        }
        return z2 && z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInNavi() {
        return TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId()) != null;
    }

    public void renderBottomButtonsStatus(boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.20
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderBottomButtonsStatus")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mPoiBottom, "renderBottomButtonsStatus") || PoiCardView.this.mPoiBottom == null || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    boolean z2 = PoiCardView.this.mDisplayConfig.isHomeOrOfficeButtonsVisible() || PoiCardView.this.mDisplayConfig.isBottomButtonsVisible();
                    boolean isBottomButtonsVisible = PoiCardView.this.mDisplayConfig.isBottomButtonsVisible();
                    PoiCardView.this.mPoiBottom.setVisibility(z2 ? 0 : 8);
                    if (isBottomButtonsVisible) {
                        PoiCardView.this.mPoiBottom.removeAllViews();
                        HashMap hashMap = new HashMap();
                        hashMap.put(PoiCardBottomButtons.KEY_IS_IN_NAVI, Boolean.valueOf(PoiCardView.this.isInNavi()));
                        hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                        hashMap.put("searchDest", Integer.valueOf(PoiCardView.this.mSearchDest));
                        hashMap.put(PoiCardBottomButtons.KEY_DECORATOR_TYPE, PoiCardView.this.mDecoratorType);
                        hashMap.put("isSettingHomeOrOffice", Boolean.valueOf(PoiCardView.this.mPresenter.checkIsSettingHomeOrOffice()));
                        hashMap.put("clickListener", PoiCardView.this);
                        if (PoiCardView.this.mBottomBtnContainer == null) {
                            PoiCardView poiCardView2 = PoiCardView.this;
                            poiCardView2.mBottomBtnContainer = new PoiCardBottomButtons(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        } else {
                            PoiCardView.this.mBottomBtnContainer.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                        }
                        if (PoiCardView.this.mPoiBottom.getChildCount() == 0) {
                            PoiCardView.this.mPoiBottom.addView(PoiCardView.this.mBottomBtnContainer);
                        }
                    }
                }
            }
        });
    }

    public BaseMapDecorator getMapDecorator() {
        return this.mMapDecorator;
    }

    public int getSearchDest() {
        return this.mSearchDest;
    }

    private int getDimensionPixelSize(@DimenRes int i) {
        return getResources().getDimensionPixelSize(i);
    }

    private void setMainBodyBackground() {
        if (checkViewIsLegal("setMainBodyBackground") && checkViewIsLegal(this.mMainBody, "setMainBodyBackground") && checkViewIsLegal(this.mBtnLeftButton, "setMainBodyBackground")) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mMainBody.getLayoutParams();
            if (this.mBtnLeftButton.getVisibility() == 0) {
                this.mMainBody.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.png_card_poi_bg));
                int dimensionPixelSize = getDimensionPixelSize(R.dimen.poi_pop_bg_margin);
                layoutParams.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                this.mMainBody.setPadding(0, 0, 0, 0);
            } else {
                this.mMainBody.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_big_panel));
                layoutParams.setMargins(0, 0, 0, 0);
                int dimensionPixelSize2 = getDimensionPixelSize(R.dimen.poi_pop_bg_margin);
                this.mMainBody.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
            }
            this.mMainBody.setLayoutParams(layoutParams);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardHomeCompanyContainer.OnPoiCardHomeCompanyContainerClickListener
    public void onSettingHomeContainerClick() {
        PoiCardPresenter poiCardPresenter = this.mPresenter;
        if (poiCardPresenter != null) {
            poiCardPresenter.onSettingHomeContainerClick();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardHomeCompanyContainer.OnPoiCardHomeCompanyContainerClickListener
    public void onSettingCompanyContainerClick() {
        PoiCardPresenter poiCardPresenter = this.mPresenter;
        if (poiCardPresenter != null) {
            poiCardPresenter.onSettingCompanyContainerClick();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardBottomButtons.OnPoiCardBottomButtonsClickListener
    public void onAddWayPointClicked() {
        PoiCardPresenter poiCardPresenter = this.mPresenter;
        if (poiCardPresenter != null) {
            poiCardPresenter.onAddWayPointClick();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardBottomButtons.OnPoiCardBottomButtonsClickListener
    public void onDeleteWayPointClicked() {
        PoiCardPresenter poiCardPresenter = this.mPresenter;
        if (poiCardPresenter != null) {
            poiCardPresenter.onDeleteWayPointClick();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.PoiCardBottomButtons.OnPoiCardBottomButtonsClickListener
    public void onNaviClicked() {
        PoiCardPresenter poiCardPresenter = this.mPresenter;
        if (poiCardPresenter != null) {
            poiCardPresenter.onBtnStartNaviClick();
        }
    }

    public void onRouteSuccess(IVariantPath iVariantPath, IPathResult iPathResult, RouteResult.RouteInfo routeInfo, XPPoiInfo xPPoiInfo) {
        PoiCardCarRemainDistance poiCardCarRemainDistance;
        if (!checkViewIsLegal(this.mCarRemainDistanceLayoutContainer, "onRouteSuccess") || (poiCardCarRemainDistance = this.mCarRemainDistanceContainer) == null) {
            return;
        }
        poiCardCarRemainDistance.onRouteSuccess(iVariantPath, iPathResult, routeInfo, xPPoiInfo);
    }

    public void onRouteFailure(XPPoiInfo xPPoiInfo) {
        PoiCardCarRemainDistance poiCardCarRemainDistance;
        if (!checkViewIsLegal(this.mCarRemainDistanceLayoutContainer, "onRouteFailure") || (poiCardCarRemainDistance = this.mCarRemainDistanceContainer) == null) {
            return;
        }
        poiCardCarRemainDistance.onRouteFailure(xPPoiInfo);
    }

    private void renderPoiEntry(final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.21
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardView.this.checkViewIsLegal("renderPoiEntry")) {
                    PoiCardView poiCardView = PoiCardView.this;
                    if (!poiCardView.checkViewIsLegal(poiCardView.mPoiEntryLayoutContainer, "renderPoiEntry") || PoiCardView.this.mPoiInfo == null) {
                        return;
                    }
                    if (!z && PoiCardView.this.mPoiEntryLayout != null) {
                        PoiCardView.this.mPoiEntryLayoutContainer.removeView(PoiCardView.this.mPoiEntryLayout);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("poiInfo", PoiCardView.this.mPoiInfo);
                    hashMap.put(PoiCardEntryContainer.KEY_SEARCH_MODE, Integer.valueOf(PoiCardView.this.mSearchMode));
                    hashMap.put("isSettingHomeOrOffice", Boolean.valueOf(PoiCardView.this.mPresenter.checkIsSettingHomeOrOffice()));
                    hashMap.put("cardType", Integer.valueOf(PoiCardView.this.mMapDecorator.getCardType()));
                    hashMap.put("mainContext", PoiCardView.this.mMainContext);
                    hashMap.put("clickListener", PoiCardView.this.mPoiEntryClickListener);
                    if (PoiCardView.this.mPoiEntryLayout == null) {
                        PoiCardView poiCardView2 = PoiCardView.this;
                        poiCardView2.mPoiEntryLayout = new PoiCardEntryContainer(poiCardView2.getContext(), hashMap, PoiCardView.this);
                        PoiCardView.this.mPoiEntryLayout.setonNumPopDialogShow(new onPopDialogShow() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardView.21.1
                            @Override // com.xiaopeng.montecarlo.views.poicard.onPopDialogShow
                            public void onPopDialogDismiss(XBaseDialog xBaseDialog) {
                            }

                            @Override // com.xiaopeng.montecarlo.views.poicard.onPopDialogShow
                            public void onPopDialogShow(XBaseDialog xBaseDialog) {
                                PoiCardView.this.mNumPopDialog = xBaseDialog;
                            }
                        });
                    } else {
                        PoiCardView.this.mPoiEntryLayout.refresh(PoiCardView.this.getContext(), hashMap, PoiCardView.this);
                    }
                    if (z) {
                        return;
                    }
                    PoiCardView.this.mPoiEntryLayoutContainer.addView(PoiCardView.this.mPoiEntryLayout, 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkViewIsLegal(String str) {
        if (checkViewIsLegal(null, str)) {
            return true;
        }
        L.Tag tag = TAG;
        L.w(tag, "checkViewIsLegal func:" + str + " is illegal");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkViewIsLegal(View view, String str) {
        if (view != null ? view != null : getVisibility() == 0) {
            return true;
        }
        L.Tag tag = TAG;
        L.w(tag, "checkViewIsLegal func:" + str + "view:" + view + " is illegal");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkPresenterIsLegal(String str) {
        if (this.mPresenter == null) {
            L.Tag tag = TAG;
            L.w(tag, "checkPresenterIsLegal func:" + str + " is illegal");
            return false;
        }
        return true;
    }

    @Override // com.xiaopeng.montecarlo.views.ExpandableTextView.OnExpandableTextViewChangeListener
    public void onToggleViewVisibleChangeListener(int i) {
        PoiPopStatUtil.sendStatDataWhenGesture(this.mMainContext, 1);
        if (checkViewIsLegal(this.mTvAddress, "onToggleViewVisibleChangeListener")) {
            int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_address_top_margin);
            if (i == 0) {
                dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_address_top_margin_expanded);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTvAddress.getLayoutParams();
            if (layoutParams.topMargin != dimensionPixelSize) {
                layoutParams.topMargin = dimensionPixelSize;
                this.mTvAddress.setLayoutParams(layoutParams);
            }
        }
    }

    private void refreshPoiCardScene() {
        IBaseScene currentScene;
        if (getVisibility() == 0 && (currentScene = this.mMainContext.getCurrentScene()) != null && currentScene.isSceneVuiEnabled()) {
            setVuiLayoutLoadable(true);
            this.mBtnClose.setVuiPriority(VuiPriority.LEVEL1);
            CommonVuiHelper commonVuiHelper = CommonVuiHelper.getInstance();
            String string = ContextUtils.getString(R.string.vui_general_action_system_close_return);
            MainContext mainContext = this.mMainContext;
            XTextView xTextView = this.mBtnClose;
            commonVuiHelper.markGeneralAction(string, mainContext, xTextView, xTextView, false);
            VoiceFullScenesUtil.updateScene(currentScene, this);
        }
    }

    public void dialPhoneNumberForVui() {
        this.mPresenter.dialPhoneNumberForVui();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.OnChildLayoutCompletedListener
    public void onChildLayoutCompleted(View view) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onChildLayoutCompleted view:" + view);
        }
    }

    public void showLoading() {
        this.mPoiInfo = null;
        if (L.ENABLE) {
            L.d(TAG, "showLoading");
        }
        if (this.mMainBody.getVisibility() != 8) {
            this.mMainBody.setVisibility(8);
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (this.mLoading.getVisibility() != 0) {
            this.mLoading.setVisibility(0);
        }
        PoiCardHelper.PoiCardManagerCallback poiCardManagerCallback = this.mPoiCallback;
        if (poiCardManagerCallback != null) {
            poiCardManagerCallback.onPoiShow(this);
        }
    }

    public void hideLoading() {
        if (L.ENABLE) {
            L.d(TAG, "hideLoading");
        }
        if (this.mLoading.getVisibility() != 8) {
            this.mLoading.setVisibility(8);
        }
    }

    private void showContent() {
        if (L.ENABLE) {
            L.d(TAG, "hideLoading");
        }
        hideLoading();
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (this.mMainBody.getVisibility() != 0) {
            this.mMainBody.setVisibility(0);
        }
    }

    public int getBodyVisibility() {
        return this.mMainBody.getVisibility();
    }

    @Override // com.xiaopeng.montecarlo.views.OnViewStateChangedListener
    public void onVisibleStateChanged(View view, VuiView vuiView, int i) {
        PoiCardCarRemainDistance poiCardCarRemainDistance;
        if (i == 0 || (poiCardCarRemainDistance = this.mCarRemainDistanceContainer) == null) {
            return;
        }
        poiCardCarRemainDistance.noticeCardHide();
    }
}
