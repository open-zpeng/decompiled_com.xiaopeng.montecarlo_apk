package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeDetailProvider;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.ChargeRouteView;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
/* loaded from: classes3.dex */
public class RouteChargePanelView extends XRelativeLayout implements XpThemeSwitchReceiver.ThemeSwitchListener, IRouteChargeDetailContract.IChargeDetailCallBack {
    protected static final float DISABLE_ALPHA = 0.56f;
    protected static final float ENABLE_ALPHA = 1.0f;
    public static final long INVALID_NEXT_DIS_GAP = -1000;
    protected static final int ORANGE_REMAIN_DISTANCE = 30000;
    protected static final L.Tag TAG = new L.Tag("ROUTE_CHARGE_panel");
    @BindView(R.id.route_charge_arrival_estimation)
    XTextView mArrivalEstiView;
    @BindView(R.id.route_charge_battery)
    BatteryView mBatteryView;
    protected Unbinder mButterBinder;
    @BindView(R.id.route_charge_add_remove)
    ImageTextButton mChargeAddView;
    @BindView(R.id.route_charge_detail_container)
    ViewGroup mDetailContainer;
    protected IRouteChargeDetailContract.IRouteChargeDetailProvider mDetailProvider;
    @BindView(R.id.route_charge_divider)
    XImageView mDivider;
    protected boolean mIsBarVisible;
    private boolean mIsFirstCharging;
    protected boolean mIsLast;
    protected boolean mIsNavi;
    protected boolean mIsNeedCharging;
    protected boolean mIsPlanSuccess;
    protected boolean mIsReachable;
    protected boolean mIsVia;
    protected IRouteChargeDetailListener mListener;
    @BindView(R.id.route_charge_name)
    XTextView mNameTextView;
    @BindView(R.id.route_charge_nav_distance)
    XTextView mNavDistanceView;
    @BindView(R.id.route_charge_next_distance)
    XTextView mNextChargeDistanceView;
    protected long mNextDisGap;
    protected boolean mReachNext;
    protected int mRemainDistance;
    @BindView(R.id.route_charge_root)
    XLinearLayout mRoot;
    protected View mRootView;
    @BindView(R.id.route_charge_bar)
    ChargeRouteView mRouteChargeBar;
    @BindView(R.id.route_charge_bar_container)
    XRelativeLayout mRouteChargeBarContainer;
    @BindView(R.id.route_charge_msg_view)
    XTextView mRouteChargeMsgView;
    protected String mStationID;
    @BindView(R.id.route_charge_title_tips)
    XTextView mTitleTipsView;

    /* loaded from: classes3.dex */
    public interface IRouteChargeDetailListener {
        void onChargeAdd(String str);

        void onChargeRemove(String str);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IChargeDetailCallBack
    public void onDistanceFetched(String str, long j, long j2) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IChargeDetailCallBack
    public void onExternalDataFetchError() {
    }

    public RouteChargePanelView(Context context) {
        this(context, null);
    }

    public RouteChargePanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RouteChargePanelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNextDisGap = 0L;
        this.mIsBarVisible = false;
        this.mIsLast = false;
        this.mIsNavi = false;
        initView(context);
    }

    protected void initView(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_route_charge_panel, this);
        this.mDetailProvider = new RouteChargeDetailProvider(this);
    }

    public void setK(double d) {
        this.mRouteChargeBar.setK(d);
    }

    public void addCharge(ChargeRouteView.ChargePoint chargePoint) {
        this.mRouteChargeBar.addCharge(chargePoint);
    }

    public void removeCharges(List<String> list) {
        this.mRouteChargeBar.removeCharges(list);
    }

    public void removeAllCharge() {
        this.mRouteChargeBar.removeAllCharge();
    }

    public void updateRouteDistance(double d, double d2, double d3, double d4) {
        this.mRouteChargeBar.updateRouteDistance(d, d2, d3, d4);
    }

    public void clearAndUpdateCharges(List<ChargeRouteView.ChargePoint> list) {
        this.mRouteChargeBar.clearAndUpdateCharges(list);
    }

    public void setSelect(ChargeRouteView.ChargePoint chargePoint) {
        this.mRouteChargeBar.setSelect(chargePoint);
    }

    public void setChargeBarVisible(boolean z) {
        this.mIsBarVisible = z;
    }

    public void showDetail(String str, String str2, double d, double d2, int i, boolean z) {
        this.mIsNavi = true;
        L.Tag tag = TAG;
        L.i(tag, "show detail, stationID: " + str + ", name: " + str2 + ", index: " + i + ", mIsNavi: " + this.mIsNavi);
        this.mRouteChargeBarContainer.setVisibility(this.mIsBarVisible ? 0 : 8);
        this.mDivider.setVisibility(this.mIsBarVisible ? 0 : 8);
        renderBasicInfo(true, str, str2, !z);
        this.mDetailProvider.renderExternalStatusOnNavi(str, d2, d, i);
        updateTheme();
    }

    public void showDetail(boolean z, boolean z2, boolean z3, String str, String str2, long j, long j2, boolean z4, long j3, boolean z5, boolean z6) {
        L.Tag tag = TAG;
        L.i(tag, "show detail, stationID: " + str + ", name: " + str2 + ", isVia: " + z4);
        this.mRouteChargeBarContainer.setVisibility(this.mIsBarVisible ? 0 : 8);
        this.mDivider.setVisibility(this.mIsBarVisible ? 0 : 8);
        renderBasicInfo(z, str, str2, z4);
        renderExternalInfo(z, z2, z3, j, j2, j3, z5, z6);
        updateTheme();
        this.mDetailProvider.startRequestDetail(str);
    }

    protected void renderBasicInfo(boolean z, String str, String str2, boolean z2) {
        this.mIsVia = z2;
        this.mStationID = str;
        this.mDetailContainer.setVisibility(0);
        this.mNameTextView.setText(str2);
        updateChargeAddView(z, z2);
    }

    public void updateChargeAddView(boolean z, boolean z2) {
        this.mIsVia = z2;
        if (this.mIsNavi && !z2) {
            this.mChargeAddView.setVisibility(8);
            return;
        }
        this.mChargeAddView.setVisibility(0);
        this.mChargeAddView.setText(ContextUtils.getString(z2 ? R.string.route_charge_remove_text : R.string.route_charge_add_text));
        this.mChargeAddView.setEnabled(z);
        if (!z) {
            this.mChargeAddView.setAlpha(DISABLE_ALPHA);
        } else {
            this.mChargeAddView.setAlpha(1.0f);
        }
        updateChargeAddBtnTheme();
    }

    private void updateChargeAddBtnTheme() {
        Drawable drawable = ThemeWatcherUtil.getDrawable(this.mIsVia ? R.drawable.route_charge_remove_btn : R.drawable.route_charge_add_btn);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getMinimumHeight());
        this.mChargeAddView.setCompoundDrawables(drawable, null, null, null);
        this.mChargeAddView.setTextColor(ThemeWatcherUtil.getColor(this.mIsVia ? R.color.route_charge_remove_btn_text_color : R.color.route_charge_add_btn_text_color));
        this.mChargeAddView.setBackground(ThemeWatcherUtil.getDrawable(this.mIsVia ? R.drawable.selector_bg_route_charge_remove : R.drawable.selector_bg_route_charge_add));
    }

    public void updateRouteChargeBarInfo(boolean z) {
        this.mIsPlanSuccess = z;
        int selectChargesNum = this.mRouteChargeBar.getSelectChargesNum();
        if (selectChargesNum == 0) {
            this.mRouteChargeMsgView.setText(getResources().getString(R.string.route_charge_msg_head, NaviUtil.getDistanceString(this.mRouteChargeBar.getCarRemainDistance())));
        } else if (z) {
            this.mRouteChargeMsgView.setText(getResources().getString(R.string.route_charge_add_charge_ok_text, Integer.valueOf(selectChargesNum)));
        } else {
            this.mRouteChargeMsgView.setText(getResources().getString(R.string.route_charge_add_charge_normal_text, Integer.valueOf(selectChargesNum)));
        }
        if (z) {
            this.mTitleTipsView.setText(getResources().getString(R.string.route_charge_plan_success_tips_text));
            this.mTitleTipsView.setTextColor(ThemeWatcherUtil.getColor(R.color.pallete_deep_green));
            return;
        }
        this.mTitleTipsView.setText(getResources().getString(R.string.route_charge_plan_pop_right_text));
        this.mTitleTipsView.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text03));
    }

    public void updateRouteChargeCarRemain() {
        if (this.mRouteChargeBar.getSelectChargesNum() == 0) {
            this.mRouteChargeMsgView.setText(getResources().getString(R.string.route_charge_msg_head, NaviUtil.getDistanceString(CarServiceManager.getInstance().getCarRemainDistance())));
        }
    }

    protected void renderExternalInfo(boolean z, boolean z2, boolean z3, long j, long j2, long j3, boolean z4, boolean z5) {
        this.mRemainDistance = (int) j2;
        this.mNextDisGap = j3;
        this.mReachNext = z4;
        this.mIsLast = z5;
        this.mIsReachable = z;
        this.mIsNeedCharging = z2;
        this.mIsFirstCharging = z3;
        this.mNavDistanceView.setText(NaviUtil.getDistanceString(j));
        updateRightEnduranceInfo();
        if (this.mIsNavi && !this.mIsVia) {
            this.mBatteryView.setVisibility(8);
            this.mArrivalEstiView.setVisibility(8);
            return;
        }
        this.mArrivalEstiView.setVisibility(0);
        updateArrivalInfo();
    }

    protected void renderExternalInfo(long j) {
        this.mNavDistanceView.setText(NaviUtil.getDistanceString(j));
        this.mBatteryView.setVisibility(8);
        if (!this.mIsNavi || this.mIsVia) {
            return;
        }
        this.mArrivalEstiView.setVisibility(8);
        this.mNextChargeDistanceView.setVisibility(8);
    }

    private void updateRightEnduranceInfo() {
        if (this.mNextDisGap == -1000) {
            this.mNextChargeDistanceView.setVisibility(8);
            return;
        }
        this.mNextChargeDistanceView.setVisibility(0);
        if (this.mReachNext) {
            this.mNextChargeDistanceView.setText(ContextUtils.getString(this.mIsLast ? R.string.route_charge_right_endurance_destination_text : R.string.route_charge_right_endurance_text, NaviUtil.getDistanceString(this.mNextDisGap)));
        } else {
            this.mNextChargeDistanceView.setText(ContextUtils.getString(R.string.route_charge_right_endurance_warning_text));
        }
    }

    private void updateArrivalInfo() {
        if (this.mIsReachable) {
            int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
            int color = ThemeWatcherUtil.getColor(R.color.primary_text03);
            if (!this.mIsNeedCharging && this.mIsFirstCharging) {
                this.mBatteryView.setVisibility(0);
                this.mBatteryView.updateBatteryStatus(carRemainDistance, this.mRemainDistance, 0);
                XTextView xTextView = this.mArrivalEstiView;
                Resources resources = getResources();
                Object[] objArr = new Object[1];
                int i = this.mRemainDistance;
                if (i > 1000) {
                    i = (i / 1000) * 1000;
                }
                objArr[0] = NaviUtil.getDistanceString(i);
                xTextView.setText(resources.getString(R.string.route_charge_arrival_estimation_left, objArr));
                color = NaviUtil.checkColorStatus(carRemainDistance, this.mRemainDistance);
            } else {
                this.mBatteryView.setVisibility(8);
                this.mArrivalEstiView.setText(getResources().getString(R.string.route_charge_arrival_estimation));
            }
            this.mArrivalEstiView.setTextColor(color);
            return;
        }
        this.mBatteryView.setVisibility(8);
        this.mArrivalEstiView.setText(getResources().getString(R.string.charge_unable_reach_des));
        this.mArrivalEstiView.setTextColor(ThemeWatcherUtil.getColor(R.color.route_charge_unrechable_text_color));
    }

    public void updatePathK(double d) {
        this.mRouteChargeBar.setK(d);
        this.mRouteChargeBar.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.route_charge_add_remove})
    public void onAddRouteCharge(View view) {
        IRouteChargeDetailListener iRouteChargeDetailListener = this.mListener;
        if (iRouteChargeDetailListener == null) {
            return;
        }
        if (this.mIsVia) {
            iRouteChargeDetailListener.onChargeRemove(this.mStationID);
        } else {
            iRouteChargeDetailListener.onChargeAdd(this.mStationID);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this);
        this.mButterBinder = ButterKnife.bind(this, this.mRootView);
        this.mDetailProvider.setCallBack(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this);
        this.mDetailProvider.unInit();
        Unbinder unbinder = this.mButterBinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void setListener(IRouteChargeDetailListener iRouteChargeDetailListener) {
        this.mListener = iRouteChargeDetailListener;
    }

    protected void updateTheme() {
        setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_big_panel));
        updateChargeAddBtnTheme();
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        if (this.mBatteryView.getVisibility() == 0) {
            this.mBatteryView.updateBatteryStatus(carRemainDistance, this.mRemainDistance, 0);
        }
        updateArrivalInfo();
        if (this.mIsPlanSuccess) {
            this.mTitleTipsView.setTextColor(ThemeWatcherUtil.getColor(R.color.pallete_deep_green));
        } else {
            this.mTitleTipsView.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text03));
        }
        if (this.mReachNext) {
            this.mNextChargeDistanceView.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text03));
        } else {
            this.mNextChargeDistanceView.setTextColor(ThemeWatcherUtil.getColor(R.color.route_charge_unrechable_text_color));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IChargeDetailCallBack
    public void onChargeDetailFetched(String str, XPPoiInfo xPPoiInfo) {
        if (str.equals(this.mStationID)) {
            this.mNameTextView.setText(xPPoiInfo.getName());
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeDetailContract.IChargeDetailCallBack
    public void onExternalDataFetched(String str, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, long j3, boolean z5, boolean z6) {
        if (str.equals(this.mStationID)) {
            if (!z) {
                renderExternalInfo(j);
                return;
            }
            renderExternalInfo(z2, z3, z4, j, j2, j3, z5, z6);
            updateTheme();
        }
    }

    @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        updateTheme();
    }
}
