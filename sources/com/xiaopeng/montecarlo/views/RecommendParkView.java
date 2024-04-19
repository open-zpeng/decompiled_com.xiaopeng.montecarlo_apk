package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.config.Configuration;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.xui.widget.XFrameLayout;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XToggleButton;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendParkView extends XFrameLayout implements View.OnClickListener {
    private static final long RECOMMEND_COLLAPSE_DELAY = 20000;
    private static final L.Tag TAG = new L.Tag("RecommendParkView");
    private Unbinder mBind;
    @BindView(R.id.btn_recommend_park1)
    XToggleButton mBtnRecommendPark1;
    @BindView(R.id.btn_recommend_park2)
    XToggleButton mBtnRecommendPark2;
    @BindView(R.id.btn_recommend_park3)
    XToggleButton mBtnRecommendPark3;
    private boolean mCanExpandOnShow;
    private Handler mHandler;
    private RecommendParkViewListener mListener;
    @BindView(R.id.park_space_view)
    ParkChargeStatusView mParkChargeStatusView;
    @BindView(R.id.park_toll_layout)
    XLinearLayout mParkTollLayout;
    @BindView(R.id.park_toll)
    XTextView mParkTollView;
    @BindView(R.id.recommend_park_button_container)
    XLinearLayout mRecommendButtonContainer;
    private Runnable mRecommendCollapseRunnable;
    @BindView(R.id.guide_recommend_collapse_container)
    XRelativeLayout mRecommendParkCollapseContainer;
    @BindView(R.id.guide_recommend_container)
    XLinearLayout mRecommendParkNormalContainer;
    private List<XPPoiInfo> mRecommendParkingList;
    FrameLayout mRootView;
    protected int mSelectedParkIndex;
    private XPPoiInfo mSelectedRecommendPark;
    @BindView(R.id.tv_recommend_park_address)
    XTextView mTvRecommendParkAddress;
    @BindView(R.id.tv_recommend_park_distance)
    XTextView mTvRecommendParkDis;
    @BindView(R.id.tv_recommend_park_name)
    XTextView mTvRecommendParkName;

    /* loaded from: classes3.dex */
    public interface RecommendParkViewListener {
        void onCollapse();

        void onExpand();

        void onRecommendParkHide();

        void onRecommendParkShow();

        void onSelectPopItem(int i);

        void onSwitchRouteToPark(XPPoiInfo xPPoiInfo);
    }

    public XToggleButton getBtnRecommendPark1() {
        return this.mBtnRecommendPark1;
    }

    public RecommendParkView(@NonNull Context context) {
        super(context);
        this.mSelectedParkIndex = 0;
        this.mCanExpandOnShow = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRecommendCollapseRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.views.RecommendParkView.1
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.d(RecommendParkView.TAG, "20000 time up, recommend parking collapse");
                }
                RecommendParkView.this.collapse();
            }
        };
        initView(context);
    }

    public RecommendParkView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedParkIndex = 0;
        this.mCanExpandOnShow = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRecommendCollapseRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.views.RecommendParkView.1
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.d(RecommendParkView.TAG, "20000 time up, recommend parking collapse");
                }
                RecommendParkView.this.collapse();
            }
        };
        initView(context);
    }

    public RecommendParkView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectedParkIndex = 0;
        this.mCanExpandOnShow = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRecommendCollapseRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.views.RecommendParkView.1
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.d(RecommendParkView.TAG, "20000 time up, recommend parking collapse");
                }
                RecommendParkView.this.collapse();
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        this.mRootView = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.layout_guide_recommend_park, (ViewGroup) this, true);
    }

    public void setListener(RecommendParkViewListener recommendParkViewListener) {
        this.mListener = recommendParkViewListener;
    }

    public void setCanExpandOnShow(boolean z) {
        this.mCanExpandOnShow = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mBind = ButterKnife.bind(this, this.mRootView);
        this.mBtnRecommendPark1.setOnClickListener(this);
        this.mBtnRecommendPark2.setOnClickListener(this);
        this.mBtnRecommendPark3.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Unbinder unbinder = this.mBind;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_recommend_park1) {
            onClickRecommendPark1(view);
        } else if (view.getId() == R.id.btn_recommend_park2) {
            onClickRecommendPark2(view);
        } else if (view.getId() == R.id.btn_recommend_park3) {
            onClickRecommendPark3(view);
        }
    }

    @OnClick({R.id.guide_recommend_collapse_container})
    public void onClickRecommendParkCollapse(View view) {
        expand();
        RecommendParkViewListener recommendParkViewListener = this.mListener;
        if (recommendParkViewListener != null) {
            recommendParkViewListener.onExpand();
        }
    }

    @OnClick({R.id.btn_recommend_park_switch})
    public void onClickRecommendPardSwitch(View view) {
        resetCollapseRecommendTiming();
        RecommendParkViewListener recommendParkViewListener = this.mListener;
        if (recommendParkViewListener != null) {
            recommendParkViewListener.onSwitchRouteToPark(this.mSelectedRecommendPark);
        }
        DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_SELECTED, Integer.valueOf(this.mSelectedParkIndex));
    }

    public void onClickRecommendPark1(View view) {
        onSelectRecommendPark(0);
    }

    public void onClickRecommendPark2(View view) {
        onSelectRecommendPark(1);
    }

    public void onClickRecommendPark3(View view) {
        onSelectRecommendPark(2);
    }

    @OnClick({R.id.iv_parking_collapse_arrow})
    public void onClickRecommendCollapseArrow(View view) {
        expand();
        RecommendParkViewListener recommendParkViewListener = this.mListener;
        if (recommendParkViewListener != null) {
            recommendParkViewListener.onExpand();
        }
    }

    private void onSelectRecommendPark(int i) {
        resetCollapseRecommendTiming();
        setRecommendParkingContent(i);
        RecommendParkViewListener recommendParkViewListener = this.mListener;
        if (recommendParkViewListener != null) {
            recommendParkViewListener.onSelectPopItem(i);
        }
        logRecommendParkClickEvent(i);
    }

    private void logRecommendParkClickEvent(int i) {
        if (!CollectionUtils.isNotEmpty(this.mRecommendParkingList) || i <= -1 || i >= this.mRecommendParkingList.size()) {
            return;
        }
        XPPoiInfo xPPoiInfo = this.mRecommendParkingList.get(i);
        if (i == 0) {
            DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_P1, xPPoiInfo.getPoiId(), Integer.valueOf(xPPoiInfo.getCategory()));
        } else if (i == 1) {
            DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_P2, xPPoiInfo.getPoiId(), Integer.valueOf(xPPoiInfo.getCategory()));
        } else if (i != 2) {
        } else {
            DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_P3, xPPoiInfo.getPoiId(), Integer.valueOf(xPPoiInfo.getCategory()));
        }
    }

    public void onShow(List<XPPoiInfo> list, boolean z) {
        DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_SHOW, new Object[0]);
        this.mRecommendParkingList = list;
        if (this.mRootView == null) {
            return;
        }
        for (int i = 0; i < this.mRecommendParkingList.size(); i++) {
            if (i == 0) {
                this.mBtnRecommendPark1.setVisibility(0);
            } else if (i == 1) {
                this.mBtnRecommendPark2.setVisibility(0);
            } else {
                this.mBtnRecommendPark3.setVisibility(0);
            }
        }
        for (int size = this.mRecommendParkingList.size(); size < 3; size++) {
            if (size == 0) {
                this.mBtnRecommendPark1.setVisibility(4);
            } else if (size == 1) {
                this.mBtnRecommendPark2.setVisibility(4);
            } else {
                this.mBtnRecommendPark3.setVisibility(4);
            }
        }
        setRecommendParkingContent(0, false);
        if (!Configuration.Dependency.AIASSISTANT_ENABLE) {
            if (this.mCanExpandOnShow) {
                expand();
            } else {
                collapseView();
            }
        }
        RecommendParkViewListener recommendParkViewListener = this.mListener;
        if (recommendParkViewListener != null) {
            recommendParkViewListener.onRecommendParkShow();
        }
    }

    public void onHide() {
        this.mHandler.removeCallbacks(this.mRecommendCollapseRunnable);
        setVisibility(8);
        RecommendParkViewListener recommendParkViewListener = this.mListener;
        if (recommendParkViewListener != null) {
            recommendParkViewListener.onRecommendParkHide();
        }
    }

    public void collapse() {
        collapseView();
        RecommendParkViewListener recommendParkViewListener = this.mListener;
        if (recommendParkViewListener != null) {
            recommendParkViewListener.onCollapse();
        }
    }

    public void collapseView() {
        XLinearLayout xLinearLayout;
        L.i(TAG, "collapseRecommendParking");
        if (this.mRecommendParkCollapseContainer != null && (xLinearLayout = this.mRecommendParkNormalContainer) != null) {
            if (xLinearLayout.getVisibility() == 0) {
                DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_COLLAPSE, new Object[0]);
            }
            this.mRecommendParkCollapseContainer.setVisibility(0);
            this.mRecommendParkNormalContainer.setVisibility(8);
        }
        this.mHandler.removeCallbacks(this.mRecommendCollapseRunnable);
    }

    public void expand() {
        this.mRecommendParkCollapseContainer.setVisibility(8);
        this.mRecommendParkNormalContainer.setVisibility(0);
        DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_PARK_EXPAND, new Object[0]);
        resetCollapseRecommendTiming();
    }

    public boolean isExpand() {
        return this.mRecommendParkNormalContainer.getVisibility() == 0;
    }

    @MainThread
    public void setRecommendParkingContent(int i) {
        setRecommendParkingContent(i, true);
    }

    @MainThread
    private void setRecommendParkingContent(int i, boolean z) {
        List<XPPoiInfo> list = this.mRecommendParkingList;
        if (list == null || i >= list.size() || i <= -1) {
            return;
        }
        updateRecommendPartButton(i);
        XPPoiInfo xPPoiInfo = this.mRecommendParkingList.get(i);
        this.mSelectedRecommendPark = xPPoiInfo;
        this.mSelectedParkIndex = i;
        if (xPPoiInfo != null) {
            this.mTvRecommendParkName.setText(xPPoiInfo.getName());
            if (xPPoiInfo.hasParkSpaceInfo()) {
                this.mParkChargeStatusView.initParkSpaceData(xPPoiInfo);
                this.mParkChargeStatusView.setVisibility(0);
                this.mTvRecommendParkAddress.setVisibility(8);
            } else {
                this.mParkChargeStatusView.setVisibility(8);
                this.mTvRecommendParkAddress.setText(xPPoiInfo.getAddress());
                this.mTvRecommendParkAddress.setVisibility(0);
            }
            if (!TextUtils.isEmpty(xPPoiInfo.getPrice())) {
                XTextView xTextView = this.mParkTollView;
                xTextView.setText(xTextView.getResources().getString(R.string.park_toll, xPPoiInfo.getPrice()));
                this.mParkTollLayout.setVisibility(0);
            } else {
                this.mParkTollLayout.setVisibility(8);
            }
            XPCoordinate2DDouble routeLastPoint = TBTManager.getInstance().getRouteLastPoint(TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
            if (routeLastPoint != null) {
                this.mTvRecommendParkDis.setText(getContext().getString(R.string.guide_recommend_park_distance, NaviUtil.getDistanceString(LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), routeLastPoint))));
            }
        }
    }

    private void updateRecommendPartButton(int i) {
        for (int i2 = 0; i2 < this.mRecommendButtonContainer.getChildCount(); i2++) {
            XToggleButton xToggleButton = (XToggleButton) this.mRecommendButtonContainer.getChildAt(i2);
            if (i2 == i) {
                xToggleButton.setChecked(true);
            } else {
                xToggleButton.setChecked(false);
            }
        }
    }

    public void resetCollapseRecommendTiming() {
        this.mHandler.removeCallbacks(this.mRecommendCollapseRunnable);
        this.mHandler.postDelayed(this.mRecommendCollapseRunnable, 20000L);
    }

    public void updateTheme() {
        updateRecommendPartButton(this.mSelectedParkIndex);
    }
}
