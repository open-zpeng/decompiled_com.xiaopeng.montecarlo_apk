package com.xiaopeng.montecarlo.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.navcore.bean.route.RouteDetailInfo;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class RouteDetailItemView extends XRelativeLayout implements View.OnClickListener, View.OnLongClickListener, OnUpdateRemainDisListener {
    public static final int LEFT_BG = 0;
    public static final int LEFT_BG_ROUND = 1;
    public static final int MID_BG = 2;
    public static final int RIGHT_BG = 3;
    public static final int RIGHT_BG_IMMERSION = 7;
    public static final int RIGHT_BG_ROUND = 4;
    public static final int SCENE_TYPE_EXPLORE = 1;
    public static final int SCENE_TYPE_ROUTE = 0;
    public static final int SINGLE_BG = 5;
    public static final int SINGLE_BG_ROUND = 6;
    private static final long SWITCH_ANIMATOR_DURATION = 6000;
    protected static final int SWITCH_ANIMATOR_START = -1838984925;
    private static final L.Tag TAG = new L.Tag("RouteDetailItemView");
    protected AnimatorSet mAnimatorSet;
    protected int mBatteryStatus;
    protected BatteryView mBatteryView;
    private ViewStub mBatteryViewStub;
    protected Context mContext;
    private OnRouteDetailViewDataRefreshListener mDataRefreshListener;
    private View mDetailItemFoldView;
    private ViewStub mDetailItemFoldViewStub;
    protected Handler mHandler;
    protected int mIndex;
    protected boolean mIsTimeSingleLine;
    protected MixedTextView mLeftDistanceView;
    protected int mLevel;
    protected long mLightCount;
    protected OnItemClickListener mListener;
    private ViewStub mMoreTotalViewStub;
    private View mMoreView;
    protected XTextView mPassedDistanceHint;
    protected XTextView mPassedDistanceMiles;
    protected long mPathId;
    protected long mPreLeftDistance;
    protected int mRemainDistance;
    protected View mRootView;
    protected long mRouteLeftDistance;
    protected MixedTextView mRouteLeftDistanceFold;
    protected XLinearLayout mRouteTypeContainer;
    protected XTextView mRouteTypeNoView;
    protected GradientTextView mRouteTypeView;
    protected boolean mRunTextSwitcher;
    protected int mSceneType;
    private MixedTextView mSingleTotalTimeView1;
    private MixedTextView mSingleTotalTimeView2;
    private ViewStub mSingleTotalViewStub;
    private View mSingleView;
    protected XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;
    protected long mTollCost;
    protected MixedTextView mTotalTimeLine1;
    protected MixedTextView mTotalTimeLine1Fold;
    protected ViewFlipperExt mTotalTimeView;
    protected XTextView mTrafficCostView;
    protected XTextView mTrafficSigView;
    protected long mTravelTime;

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onItemClick(int i, View view);
    }

    /* loaded from: classes3.dex */
    public interface OnRouteDetailViewDataRefreshListener {
        void onRouteDetailViewRemainDistanceDataRefresh(RouteDetailItemView routeDetailItemView);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public RouteDetailItemView(Context context, int i, int i2, boolean z, int i3, long j, OnItemClickListener onItemClickListener) {
        super(context);
        this.mRunTextSwitcher = false;
        this.mLevel = 5;
        this.mBatteryStatus = -1;
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.xiaopeng.montecarlo.views.RouteDetailItemView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == RouteDetailItemView.SWITCH_ANIMATOR_START) {
                    RouteDetailItemView.this.doStartSwitchAnimator();
                    RouteDetailItemView.this.clearPendingSwitchMessages();
                    RouteDetailItemView.this.mHandler.sendEmptyMessageDelayed(RouteDetailItemView.SWITCH_ANIMATOR_START, RouteDetailItemView.SWITCH_ANIMATOR_DURATION);
                    return false;
                }
                return false;
            }
        });
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.RouteDetailItemView.2
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i4) {
                RouteDetailItemView.this.updateTheme(true);
            }
        };
        this.mContext = context;
        this.mIsTimeSingleLine = z;
        this.mListener = onItemClickListener;
        this.mSceneType = i3;
        this.mPreLeftDistance = j;
        this.mIndex = i;
        this.mLevel = i2;
        initView();
        if (Utils.isLandscape()) {
            int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.route_detail_panel_padding);
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            return;
        }
        setPadding(0, 0, ContextUtils.getDimensionPixelSize(R.dimen.route_detail_panel_padding_right), 0);
    }

    public void setOnRouteDetailViewDataRefreshListener(OnRouteDetailViewDataRefreshListener onRouteDetailViewDataRefreshListener) {
        this.mDataRefreshListener = onRouteDetailViewDataRefreshListener;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public void setLevel(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setLevel level:" + i);
        }
        this.mLevel = i;
        setBackground(ThemeWatcherUtil.getDrawable(i != 0 ? i != 1 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? i != 7 ? R.drawable.selector_routecard_item_bg_middle : R.drawable.selector_routecard_item_bg_right_round_immersion_corner : R.drawable.selector_routecard_item_bg_single_round_corner : R.drawable.selector_routecard_item_bg_single : R.drawable.selector_routecard_item_bg_right_round_corner : R.drawable.selector_routecard_item_bg_right : R.drawable.selector_routecard_item_bg_left_round_corner : R.drawable.selector_routecard_item_bg_left));
    }

    public String getRouteType() {
        GradientTextView gradientTextView = this.mRouteTypeView;
        if (gradientTextView != null) {
            String charSequence = gradientTextView.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                return charSequence;
            }
        }
        return "null";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
        stopViewFlipper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPendingSwitchMessages() {
        if (this.mHandler.hasMessages(SWITCH_ANIMATOR_START)) {
            this.mHandler.removeMessages(SWITCH_ANIMATOR_START);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void updateRouteTypeContent(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 0) {
                this.mRouteTypeNoView.setText(getContext().getString(R.string.route_1_no));
            } else if (1 == i) {
                this.mRouteTypeNoView.setText(getContext().getString(R.string.route_2_no));
            } else {
                this.mRouteTypeNoView.setText(getContext().getString(R.string.route_3_no));
            }
            this.mRouteTypeView.setText(getLabelContent(i, str));
        } else if (i == 0) {
            this.mRouteTypeNoView.setText(getContext().getString(R.string.route_1_no));
            this.mRouteTypeView.setText(getContext().getString(R.string.explore_alternative_route_label_one));
        } else if (1 == i) {
            this.mRouteTypeNoView.setText(getContext().getString(R.string.route_2_no));
            this.mRouteTypeView.setText(getContext().getString(R.string.explore_alternative_route_label_two));
        } else {
            this.mRouteTypeNoView.setText(getContext().getString(R.string.route_3_no));
            this.mRouteTypeView.setText(getContext().getString(R.string.explore_alternative_route_label));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemClickListener onItemClickListener;
        if (!(view instanceof RouteDetailItemView) || (onItemClickListener = this.mListener) == null) {
            return;
        }
        onItemClickListener.onItemClick(this.mIndex, view);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        OnItemClickListener onItemClickListener;
        if (!z || (onItemClickListener = this.mListener) == null) {
            return;
        }
        onItemClickListener.onItemClick(this.mIndex, this);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void setSelected(boolean z) {
        XLinearLayout xLinearLayout;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setSelected selected:" + z + ",index:" + this.mIndex);
        }
        if (Utils.isLandscape() && (xLinearLayout = this.mRouteTypeContainer) != null) {
            xLinearLayout.setSelected(z);
        }
        this.mRouteTypeView.setSelected(z);
        setRouteTypeViewColor();
        this.mLeftDistanceView.setSelected(z);
        this.mTrafficCostView.setSelected(z);
        this.mTrafficSigView.setSelected(z);
        this.mTrafficCostView.setEnabled(true);
        this.mTrafficSigView.setEnabled(true);
        if (this.mIsTimeSingleLine) {
            this.mSingleTotalTimeView1.setSelected(z);
            this.mSingleTotalTimeView2.setSelected(z);
        } else {
            MixedTextView mixedTextView = (MixedTextView) this.mTotalTimeView.getCurrentView();
            if (mixedTextView != null) {
                mixedTextView.setSelected(z);
            }
            MixedTextView mixedTextView2 = (MixedTextView) this.mTotalTimeView.getNextView();
            if (mixedTextView2 != null) {
                mixedTextView2.setSelected(z);
            }
            if (z) {
                startViewFlipper();
            } else {
                stopViewFlipper();
            }
        }
        this.mRouteTypeNoView.setSelected(z);
        this.mPassedDistanceHint.setSelected(z);
        this.mPassedDistanceMiles.setSelected(z);
        BatteryView batteryView = this.mBatteryView;
        if (batteryView != null) {
            batteryView.setSelected(z);
        }
        if (Utils.isLandscape() && 1 == this.mSceneType) {
            if (z) {
                showLandscapeExploreRouteDetail();
            } else {
                showLandscapeExploreRouteSimpleInfo();
            }
        }
        super.setSelected(z);
    }

    private void showLandscapeExploreRouteDetail() {
        int i = this.mBatteryStatus;
        if (i == 0) {
            this.mPassedDistanceMiles.setVisibility(8);
            this.mPassedDistanceHint.setVisibility(0);
        } else if (i == 1) {
            this.mPassedDistanceMiles.setVisibility(0);
            this.mPassedDistanceHint.setVisibility(0);
        } else if (i == 2) {
            this.mPassedDistanceMiles.setVisibility(0);
            this.mPassedDistanceHint.setVisibility(8);
        } else {
            this.mPassedDistanceMiles.setVisibility(8);
            this.mPassedDistanceHint.setVisibility(8);
        }
        if (this.mLightCount == 0) {
            this.mTrafficSigView.setVisibility(8);
        } else {
            this.mTrafficSigView.setVisibility(0);
        }
        this.mTrafficCostView.setVisibility(this.mTollCost == 0 ? 8 : 0);
        this.mRouteTypeView.setVisibility(0);
        BatteryView batteryView = this.mBatteryView;
        if (batteryView != null && this.mBatteryStatus != -1) {
            batteryView.setVisibility(0);
        }
        this.mTotalTimeView.setVisibility(0);
        this.mLeftDistanceView.setVisibility(0);
        MixedTextView mixedTextView = this.mTotalTimeLine1Fold;
        if (mixedTextView != null) {
            mixedTextView.setVisibility(8);
        }
        MixedTextView mixedTextView2 = this.mRouteLeftDistanceFold;
        if (mixedTextView2 != null) {
            mixedTextView2.setVisibility(8);
        }
    }

    private void showLandscapeExploreRouteSimpleInfo() {
        this.mTrafficCostView.setVisibility(8);
        this.mTrafficSigView.setVisibility(8);
        this.mPassedDistanceHint.setVisibility(8);
        this.mPassedDistanceMiles.setVisibility(8);
        this.mRouteTypeView.setVisibility(8);
        BatteryView batteryView = this.mBatteryView;
        if (batteryView != null) {
            batteryView.setVisibility(8);
        }
        this.mTotalTimeView.setVisibility(8);
        this.mLeftDistanceView.setVisibility(8);
        MixedTextView mixedTextView = this.mTotalTimeLine1Fold;
        if (mixedTextView != null) {
            mixedTextView.setVisibility(0);
        }
        MixedTextView mixedTextView2 = this.mRouteLeftDistanceFold;
        if (mixedTextView2 != null) {
            mixedTextView2.setVisibility(0);
        }
    }

    public void updateViewState(boolean z) {
        if (this.mIsTimeSingleLine != z) {
            this.mIsTimeSingleLine = z;
            updateSingleState();
        }
    }

    public void updatePanelInfo(long j, double d, long j2, double d2, long j3) {
        if (this.mPathId != j) {
            clearDistanceView();
        }
        this.mPathId = j;
        this.mRouteLeftDistance = (long) d;
        if (this.mDetailItemFoldView == null) {
            this.mDetailItemFoldView = this.mDetailItemFoldViewStub.inflate();
        }
        if (this.mRouteLeftDistanceFold == null) {
            this.mRouteLeftDistanceFold = (MixedTextView) this.mDetailItemFoldView.findViewById(R.id.route_left_distance_fold);
        }
        if (this.mTotalTimeLine1Fold == null) {
            this.mTotalTimeLine1Fold = (MixedTextView) this.mDetailItemFoldView.findViewById(R.id.total_time_line1_fold);
        }
        updateLeftDistanceView(this.mRouteLeftDistance, true);
        this.mLightCount = j2;
        this.mTravelTime = (long) d2;
        this.mTollCost = j3;
        if (!Utils.isLandscape() || this.mSceneType == 0) {
            long j4 = this.mLightCount;
            if (j4 == 0) {
                this.mTrafficSigView.setVisibility(8);
            } else {
                String string = ContextUtils.getString(R.string.route_detail_traffic_signal, Long.valueOf(j4));
                if (TextUtils.isEmpty(string)) {
                    this.mTrafficSigView.setVisibility(8);
                } else {
                    this.mTrafficSigView.setVisibility(0);
                    this.mTrafficSigView.setText(string);
                }
            }
            long j5 = this.mTollCost;
            if (0 == j5) {
                this.mTrafficCostView.setVisibility(8);
            } else {
                String string2 = ContextUtils.getString(R.string.route_detail_total_tll_cost, Long.valueOf(j5));
                if (TextUtils.isEmpty(string2)) {
                    this.mTrafficCostView.setVisibility(8);
                } else {
                    this.mTrafficCostView.setVisibility(0);
                    this.mTrafficCostView.setText(string2);
                }
            }
        } else {
            long j6 = this.mLightCount;
            if (j6 > 0) {
                String string3 = ContextUtils.getString(R.string.route_detail_traffic_signal, Long.valueOf(j6));
                if (!TextUtils.isEmpty(string3)) {
                    this.mTrafficSigView.setText(string3);
                }
            }
            long j7 = this.mTollCost;
            if (j7 > 0) {
                String string4 = ContextUtils.getString(R.string.route_detail_total_tll_cost, Long.valueOf(j7));
                if (!TextUtils.isEmpty(string4)) {
                    this.mTrafficCostView.setText(string4);
                }
            }
        }
        updateTimeView(this.mTravelTime, true);
    }

    public long getRouteLeftDistance() {
        return this.mRouteLeftDistance;
    }

    public long getLightCount() {
        return this.mLightCount;
    }

    public long getTravelTime() {
        return this.mTravelTime;
    }

    public long getTollCost() {
        return this.mTollCost;
    }

    public long getPathId() {
        return this.mPathId;
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
    public void onUpdateRemainDis(final long j, int i, final int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.RouteDetailItemView.3
            @Override // java.lang.Runnable
            public void run() {
                RouteDetailItemView routeDetailItemView = RouteDetailItemView.this;
                routeDetailItemView.mRemainDistance = i2;
                routeDetailItemView.fillDistanceView(CarServiceManager.getInstance().getCarRemainDistance(), i2);
                if (L.ENABLE) {
                    L.Tag tag = RouteDetailItemView.TAG;
                    L.d(tag, "onUpdateRemainDis mDataRefreshListener:" + RouteDetailItemView.this.mDataRefreshListener + ",pathId:" + j + ",mRemainDistance:" + RouteDetailItemView.this.mRemainDistance);
                    L.Tag tag2 = RouteDetailItemView.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("async route info end pathId:");
                    sb.append(j);
                    sb.append(",time:");
                    sb.append(System.currentTimeMillis());
                    L.d(tag2, sb.toString());
                }
                if (RouteDetailItemView.this.mDataRefreshListener == null || RouteDetailItemView.this.getVisibility() != 0) {
                    return;
                }
                RouteDetailItemView.this.mDataRefreshListener.onRouteDetailViewRemainDistanceDataRefresh(RouteDetailItemView.this);
            }
        });
    }

    public RouteDetailInfo getRouteDetailInfo() {
        RouteDetailInfo routeDetailInfo = new RouteDetailInfo();
        if (this.mRouteTypeNoView.getVisibility() == 0 && !TextUtils.isEmpty(this.mRouteTypeNoView.getText())) {
            routeDetailInfo.setRouteTypeNo(this.mRouteTypeNoView.getText().toString());
        }
        if (this.mRouteTypeView.getVisibility() == 0 && !TextUtils.isEmpty(this.mRouteTypeView.getText())) {
            routeDetailInfo.setRouteTypeName(this.mRouteTypeView.getText().toString());
        }
        if (this.mTrafficSigView.getVisibility() == 0 && !TextUtils.isEmpty(this.mTrafficSigView.getText())) {
            routeDetailInfo.setTrafficSignal(this.mTrafficSigView.getText().toString());
        }
        if (this.mTrafficCostView.getVisibility() == 0 && !TextUtils.isEmpty(this.mTrafficCostView.getText())) {
            routeDetailInfo.setTrafficCost(this.mTrafficCostView.getText().toString());
        }
        if (this.mLeftDistanceView.getVisibility() == 0 && !TextUtils.isEmpty(this.mLeftDistanceView.getDisplayString())) {
            routeDetailInfo.setRouteLeftDistance(this.mLeftDistanceView.getDisplayString());
        }
        routeDetailInfo.setRouteLeftDistanceValue(this.mRouteLeftDistance);
        if (this.mIsTimeSingleLine) {
            if (this.mSingleTotalTimeView1.getVisibility() == 0 && !TextUtils.isEmpty(this.mSingleTotalTimeView1.getDisplayString())) {
                routeDetailInfo.setTotalTimeLine1(this.mSingleTotalTimeView1.getDisplayString());
            }
        } else {
            MixedTextView mixedTextView = (MixedTextView) this.mTotalTimeView.getChildAt(0);
            MixedTextView mixedTextView2 = (MixedTextView) this.mTotalTimeView.getChildAt(1);
            if (mixedTextView.getVisibility() == 0 && !TextUtils.isEmpty(mixedTextView.getDisplayString())) {
                routeDetailInfo.setTotalTimeLine1(mixedTextView.getDisplayString());
            }
            if (mixedTextView2.getVisibility() == 0 && !TextUtils.isEmpty(mixedTextView2.getDisplayString())) {
                routeDetailInfo.setTotalTimeLine2(mixedTextView2.getDisplayString());
            }
        }
        routeDetailInfo.setTotalTimeLine1Value(this.mTravelTime);
        if (this.mPassedDistanceHint.getVisibility() == 8) {
            if (!TextUtils.isEmpty(this.mPassedDistanceMiles.getText()) && this.mPassedDistanceMiles.getVisibility() == 0) {
                routeDetailInfo.setBatteryStatusTips(this.mPassedDistanceMiles.getText().toString());
            }
        } else {
            if (!TextUtils.isEmpty(this.mPassedDistanceHint.getText())) {
                routeDetailInfo.setBatteryStatusTips(this.mPassedDistanceHint.getText().toString());
            }
            if (!TextUtils.isEmpty(this.mPassedDistanceMiles.getText()) && this.mPassedDistanceMiles.getVisibility() == 0) {
                routeDetailInfo.setRemainDistance(this.mPassedDistanceMiles.getText().toString());
            }
        }
        routeDetailInfo.setBatteryStatus(this.mBatteryStatus);
        routeDetailInfo.setRemainDistanceValue(this.mRemainDistance);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getRouteDetailInfo info:" + routeDetailInfo.toString());
        }
        return routeDetailInfo;
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.layout_route_detail_item, (ViewGroup) this, true);
        this.mRouteTypeContainer = (XLinearLayout) this.mRootView.findViewById(R.id.route_type_container);
        this.mRouteTypeView = (GradientTextView) this.mRootView.findViewById(R.id.route_type_name);
        this.mRouteTypeNoView = (XTextView) this.mRootView.findViewById(R.id.route_type_no);
        this.mLeftDistanceView = (MixedTextView) this.mRootView.findViewById(R.id.route_left_distance);
        this.mPassedDistanceHint = (XTextView) this.mRootView.findViewById(R.id.route_detail_battery_hint);
        this.mPassedDistanceMiles = (XTextView) this.mRootView.findViewById(R.id.route_detail_remain_distance);
        this.mBatteryViewStub = (ViewStub) this.mRootView.findViewById(R.id.route_detail_item_battery);
        this.mTrafficSigView = (XTextView) this.mRootView.findViewById(R.id.traffic_signal);
        this.mTrafficCostView = (XTextView) this.mRootView.findViewById(R.id.traffic_cost);
        this.mSingleTotalViewStub = (ViewStub) this.mRootView.findViewById(R.id.single_total_time_stub);
        this.mMoreTotalViewStub = (ViewStub) this.mRootView.findViewById(R.id.more_total_time_stub);
        this.mDetailItemFoldViewStub = (ViewStub) this.mRootView.findViewById(R.id.route_detail_item_fold_stub);
        updateSingleState();
        updateTheme(false);
        setOnClickListener(this);
    }

    private void updateTotalTimeLine1FoldLp() {
        LinearLayout.LayoutParams childViewLayoutParams = this.mLeftDistanceView.getChildViewLayoutParams(1);
        childViewLayoutParams.bottomMargin = ContextUtils.getDimensionPixelSize(R.dimen.route_detail_item_time_bottom_offset);
        childViewLayoutParams.gravity = 80;
        this.mRouteLeftDistanceFold.updateChildViewLayoutParams(1, childViewLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRouteLeftDistanceFoldLp() {
        LinearLayout.LayoutParams childViewLayoutParams = this.mLeftDistanceView.getChildViewLayoutParams(0);
        childViewLayoutParams.gravity = 16;
        this.mRouteLeftDistanceFold.updateChildViewLayoutParams(0, childViewLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLeftDistanceViewLp() {
        LinearLayout.LayoutParams childViewLayoutParams = this.mRouteLeftDistanceFold.getChildViewLayoutParams(0);
        childViewLayoutParams.gravity = 16;
        this.mRouteLeftDistanceFold.updateChildViewLayoutParams(0, childViewLayoutParams);
    }

    private void updateSingleState() {
        if (this.mIsTimeSingleLine) {
            if (this.mSingleView == null) {
                this.mSingleView = this.mSingleTotalViewStub.inflate();
            }
            if (this.mSingleTotalTimeView1 == null) {
                this.mSingleTotalTimeView1 = (MixedTextView) this.mSingleView.findViewById(R.id.single_total_time_text1);
            }
            if (this.mSingleTotalTimeView2 == null) {
                this.mSingleTotalTimeView2 = (MixedTextView) this.mSingleView.findViewById(R.id.single_total_time_text2);
            }
            ViewFlipperExt viewFlipperExt = this.mTotalTimeView;
            if (viewFlipperExt != null) {
                viewFlipperExt.setVisibility(8);
            }
            this.mSingleTotalTimeView1.setVisibility(0);
            this.mSingleTotalTimeView2.setVisibility(0);
            return;
        }
        if (this.mMoreView == null) {
            this.mMoreView = this.mMoreTotalViewStub.inflate();
        }
        if (this.mTotalTimeView == null) {
            this.mTotalTimeView = (ViewFlipperExt) this.mMoreView.findViewById(R.id.total_time);
        }
        if (this.mTotalTimeLine1 == null) {
            this.mTotalTimeLine1 = (MixedTextView) this.mMoreView.findViewById(R.id.total_time_line1);
        }
        MixedTextView mixedTextView = this.mSingleTotalTimeView1;
        if (mixedTextView != null) {
            mixedTextView.setVisibility(8);
        }
        MixedTextView mixedTextView2 = this.mSingleTotalTimeView2;
        if (mixedTextView2 != null) {
            mixedTextView2.setVisibility(8);
        }
        this.mTotalTimeView.setVisibility(0);
    }

    public void updateTheme(boolean z) {
        setLevel(this.mLevel);
        if (z) {
            fillDistanceView(CarServiceManager.getInstance().getCarRemainDistance(), this.mRemainDistance);
        }
        MixedTextView mixedTextView = this.mTotalTimeLine1;
        if (mixedTextView != null) {
            mixedTextView.updateTheme();
        }
        MixedTextView mixedTextView2 = this.mLeftDistanceView;
        if (mixedTextView2 != null) {
            mixedTextView2.updateTheme();
        }
        MixedTextView mixedTextView3 = this.mTotalTimeLine1Fold;
        if (mixedTextView3 != null) {
            mixedTextView3.updateTheme();
        }
        MixedTextView mixedTextView4 = this.mRouteLeftDistanceFold;
        if (mixedTextView4 != null) {
            mixedTextView4.updateTheme();
        }
        setRouteTypeViewColor();
    }

    private void setRouteTypeViewColor() {
        this.mRouteTypeView.setLimit(4);
        GradientTextView gradientTextView = this.mRouteTypeView;
        if (gradientTextView != null) {
            if (gradientTextView.isSelected()) {
                this.mRouteTypeView.setTextColor(getResources().getColor(R.color.route_detail_type_color));
            } else {
                this.mRouteTypeView.setTextColor(ThemeWatcherUtil.getColor(R.color.common_gray_56));
            }
        }
    }

    protected String getLabelContent(int i, String str) {
        if (str.contains(getContext().getString(R.string.explore_alternative_route_label_default))) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? str : getContext().getString(R.string.explore_alternative_route_label_three);
                }
                return getContext().getString(R.string.explore_alternative_route_label_two);
            }
            return getContext().getString(R.string.explore_alternative_route_label_one);
        }
        return str;
    }

    protected void fillDistanceView(long j, int i) {
        updateBatterStatusColor(j, i);
        String string = ContextUtils.getString(R.string.route_detail_endurance_distance_remain_unit, Integer.valueOf(i / 1000));
        this.mBatteryStatus = -1;
        try {
            this.mBatteryStatus = NaviUtil.checkDistanceReachableStatus(j, i);
        } catch (NaviUtil.DistanceStatusIllegalArgumentException unused) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "INVALID remain dis and leftDistance remain dis: " + j + " leftDis: " + i);
            }
        }
        int i2 = this.mBatteryStatus;
        if (i2 == 0) {
            this.mPassedDistanceMiles.setVisibility(8);
            this.mPassedDistanceMiles.setText("");
            this.mPassedDistanceHint.setVisibility(0);
            this.mPassedDistanceHint.setText(R.string.route_detail_endurance_insufficient_noreache);
        } else if (i2 == 1) {
            this.mPassedDistanceMiles.setVisibility(0);
            this.mPassedDistanceMiles.setText(string);
            this.mPassedDistanceHint.setVisibility(0);
            this.mPassedDistanceHint.setText(R.string.route_detail_endurance_distance_remain);
        } else if (i2 == 2) {
            if (Utils.isLandscape()) {
                this.mPassedDistanceHint.setVisibility(8);
                this.mPassedDistanceHint.setText("");
                this.mPassedDistanceMiles.setVisibility(0);
                this.mPassedDistanceMiles.setText(R.string.route_detail_endurance_lower_power);
            } else {
                this.mPassedDistanceHint.setVisibility(0);
                this.mPassedDistanceHint.setText(R.string.route_detail_endurance_lower_power);
                this.mPassedDistanceMiles.setVisibility(8);
                this.mPassedDistanceMiles.setText("");
            }
        } else {
            this.mPassedDistanceHint.setText("");
            this.mPassedDistanceMiles.setVisibility(8);
            this.mPassedDistanceMiles.setText("");
            this.mPassedDistanceHint.setVisibility(8);
        }
        updateBatteryStatus(j, i);
        setSelected(isSelected());
    }

    protected void clearDistanceView() {
        this.mPassedDistanceMiles.setVisibility(8);
        this.mPassedDistanceMiles.setText("");
        this.mPassedDistanceHint.setVisibility(8);
        this.mPassedDistanceHint.setText("");
        this.mBatteryStatus = -1;
        BatteryView batteryView = this.mBatteryView;
        if (batteryView != null) {
            batteryView.setVisibility(8);
        }
    }

    private void updateBatteryStatus(long j, int i) {
        ViewStub viewStub = this.mBatteryViewStub;
        if (viewStub != null) {
            if (this.mBatteryView == null) {
                this.mBatteryView = (BatteryView) viewStub.inflate();
            }
            this.mBatteryView.setSelected(isSelected());
            this.mBatteryView.updateBatteryStatus((int) j, i, (int) this.mRouteLeftDistance);
        }
    }

    protected void updateBatterStatusColor(long j, int i) {
        int remainDisColorStatusResId = NaviUtil.getRemainDisColorStatusResId(j, i);
        this.mPassedDistanceHint.setTextColor(getResources().getColorStateList(remainDisColorStatusResId, null));
        this.mPassedDistanceMiles.setTextColor(getResources().getColorStateList(remainDisColorStatusResId, null));
    }

    private void startViewFlipper() {
        if (this.mRunTextSwitcher || this.mTotalTimeView == null) {
            return;
        }
        resetTimeSwitchState();
        this.mRunTextSwitcher = true;
        clearPendingSwitchMessages();
        this.mHandler.sendEmptyMessageDelayed(SWITCH_ANIMATOR_START, SWITCH_ANIMATOR_DURATION);
    }

    private void resetTimeSwitchState() {
        ViewFlipperExt viewFlipperExt = this.mTotalTimeView;
        if (viewFlipperExt != null) {
            viewFlipperExt.resetIndex();
            this.mTotalTimeView.setDisplayedChild(0);
            this.mTotalTimeView.getChildAt(0).setVisibility(0);
            this.mTotalTimeView.getChildAt(1).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartSwitchAnimator() {
        if (this.mRunTextSwitcher) {
            updateTravelTimeView(true);
            if (this.mAnimatorSet != null) {
                this.mTotalTimeView.showNext();
            }
            final View currentView = this.mTotalTimeView.getCurrentView();
            final View nextView = this.mTotalTimeView.getNextView();
            this.mTotalTimeView.updateIndex();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(currentView, "translationY", 0.0f, -this.mTotalTimeView.getHeight());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(nextView, "translationY", this.mTotalTimeView.getHeight(), 0.0f);
            this.mAnimatorSet = new AnimatorSet();
            this.mAnimatorSet.setDuration(1000L);
            this.mAnimatorSet.playTogether(ofFloat, ofFloat2);
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.views.RouteDetailItemView.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    currentView.setTranslationY(0.0f);
                    currentView.setVisibility(8);
                    nextView.setTranslationY(0.0f);
                    currentView.setDrawingCacheEnabled(false);
                    nextView.setDrawingCacheEnabled(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    currentView.setTranslationY(0.0f);
                    currentView.setVisibility(8);
                    currentView.setDrawingCacheEnabled(false);
                    nextView.setDrawingCacheEnabled(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    currentView.setVisibility(0);
                    nextView.setVisibility(0);
                    currentView.setDrawingCacheEnabled(true);
                    nextView.setDrawingCacheEnabled(true);
                    nextView.setTranslationY(RouteDetailItemView.this.mTotalTimeView.getHeight());
                }
            });
            this.mAnimatorSet.start();
        }
    }

    private void stopViewFlipper() {
        this.mRunTextSwitcher = false;
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mAnimatorSet.cancel();
        }
        this.mAnimatorSet = null;
        clearPendingSwitchMessages();
        resetTimeSwitchState();
    }

    private void updateTravelTimeView(boolean z) {
        AsyncTask<Long, Integer, List<String>> asyncTask = new AsyncTask<Long, Integer, List<String>>() { // from class: com.xiaopeng.montecarlo.views.RouteDetailItemView.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            @SuppressLint({"WrongThread"})
            public List<String> doInBackground(Long... lArr) {
                return NaviUtil.getTravelTime(RouteDetailItemView.this.mTravelTime);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(List<String> list) {
                RouteDetailItemView.this.setTravelTimeView(list);
            }
        };
        if (z) {
            asyncTask.execute(0L);
        } else {
            setTravelTimeView(NaviUtil.getTravelTime(this.mTravelTime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTravelTimeView(List<String> list) {
        if (this.mIsTimeSingleLine) {
            this.mSingleTotalTimeView2.updateMixedText(list);
            return;
        }
        ViewFlipperExt viewFlipperExt = this.mTotalTimeView;
        if (viewFlipperExt != null) {
            MixedTextView mixedTextView = (MixedTextView) viewFlipperExt.getChildAt(1);
            if (mixedTextView != null) {
                mixedTextView.updateMixedText(list);
            } else {
                L.e(TAG, "setTravelTimeView is null");
            }
        }
    }

    protected void updateLeftDistanceView(long j, boolean z) {
        AsyncTask<Long, Integer, List<String>> asyncTask = new AsyncTask<Long, Integer, List<String>>() { // from class: com.xiaopeng.montecarlo.views.RouteDetailItemView.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            @SuppressLint({"WrongThread"})
            public List<String> doInBackground(Long... lArr) {
                return RouteDetailItemView.this.formatLeftDistance(lArr[0].longValue());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(List<String> list) {
                RouteDetailItemView.this.mLeftDistanceView.updateMixedText(list);
                if (Utils.isLandscape()) {
                    RouteDetailItemView.this.updateRouteLeftDistanceFoldLp();
                }
                RouteDetailItemView.this.mRouteLeftDistanceFold.updateMixedText(list);
                if (Utils.isLandscape()) {
                    RouteDetailItemView.this.updateLeftDistanceViewLp();
                }
            }
        };
        if (z) {
            asyncTask.execute(Long.valueOf(j));
            return;
        }
        List<String> formatLeftDistance = formatLeftDistance(j);
        this.mLeftDistanceView.updateMixedText(formatLeftDistance);
        if (Utils.isLandscape()) {
            updateRouteLeftDistanceFoldLp();
        }
        this.mRouteLeftDistanceFold.updateMixedText(formatLeftDistance);
        if (Utils.isLandscape()) {
            updateLeftDistanceViewLp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> formatLeftDistance(long j) {
        return Arrays.asList(NaviUtil.getDistanceArray(j));
    }

    protected void updateTimeView(long j, boolean z) {
        AsyncTask<Long, Integer, List<String>> asyncTask = new AsyncTask<Long, Integer, List<String>>() { // from class: com.xiaopeng.montecarlo.views.RouteDetailItemView.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            @SuppressLint({"WrongThread"})
            public List<String> doInBackground(Long... lArr) {
                return NaviUtil.getNaviTimeString(lArr[0].longValue());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(List<String> list) {
                RouteDetailItemView.this.setTimeView(list);
                RouteDetailItemView.this.setFoldTimeView(list);
            }
        };
        if (z) {
            asyncTask.execute(Long.valueOf(j));
        } else {
            List<String> naviTimeString = NaviUtil.getNaviTimeString(j);
            if (!CollectionUtils.isEmpty(naviTimeString)) {
                setTimeView(naviTimeString);
                setFoldTimeView(naviTimeString);
            }
        }
        updateTravelTimeView(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeView(List<String> list) {
        if (this.mIsTimeSingleLine) {
            this.mSingleTotalTimeView1.updateMixedText(list);
            return;
        }
        ViewFlipperExt viewFlipperExt = this.mTotalTimeView;
        if (viewFlipperExt != null) {
            MixedTextView mixedTextView = (MixedTextView) viewFlipperExt.getChildAt(0);
            if (mixedTextView != null) {
                mixedTextView.updateMixedText(list);
            } else {
                L.e(TAG, "setTimeView is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFoldTimeView(List<String> list) {
        this.mTotalTimeLine1Fold.updateMixedText(list);
        if (Utils.isLandscape()) {
            updateTotalTimeLine1FoldLp();
        }
    }

    public void release() {
        this.mListener = null;
        this.mDataRefreshListener = null;
    }
}
