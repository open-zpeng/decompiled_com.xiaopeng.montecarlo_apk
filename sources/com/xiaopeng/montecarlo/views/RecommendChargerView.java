package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.view.View;
import android.widget.Space;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.stat.RecommendChargeStatUtil;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class RecommendChargerView extends XConstraintLayout implements VuiView {
    private static final L.Tag TAG = new L.Tag("RecommendChargerView");
    private BatteryView mBatteryIcon;
    private Space mBatterySpace;
    private XTextView mBatteryStatus;
    private RecommendChargerBean mBean;
    private XImageView mChargeIcon;
    private XImageView mChargeSign;
    private RecommendChargeClickListener mListener;
    private XTextView mNaviDistance;
    private XTextView mNaviDistanceUnit;
    private View.OnClickListener mRecommendClickListener;
    private XImageButton mRightArrow;

    /* loaded from: classes3.dex */
    public interface RecommendChargeClickListener {
        void onClickRecommendCharge(RecommendChargerBean recommendChargerBean);
    }

    public RecommendChargerView(Context context) {
        super(context);
        this.mBean = null;
        this.mRecommendClickListener = new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.RecommendChargerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                L.Tag tag = RecommendChargerView.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("click recommend charge: ");
                sb.append(RecommendChargerView.this.mBean != null ? RecommendChargerView.this.mBean.getName() : "");
                L.i(tag, sb.toString());
                if (RecommendChargerView.this.mListener != null && RecommendChargerView.this.mBean != null) {
                    RecommendChargerView.this.mListener.onClickRecommendCharge(RecommendChargerView.this.mBean);
                }
                RecommendChargerView.this.setSelectedState(true);
            }
        };
        View.inflate(context, R.layout.layout_cruise_recommend_chargers, this);
        setOnClickListener(this.mRecommendClickListener);
        this.mChargeIcon = (XImageView) findViewById(R.id.charge_icon);
        this.mChargeSign = (XImageView) findViewById(R.id.charge_sign);
        this.mNaviDistance = (XTextView) findViewById(R.id.navi_distance_value);
        this.mNaviDistanceUnit = (XTextView) findViewById(R.id.navi_distance_unit);
        this.mBatteryIcon = (BatteryView) findViewById(R.id.charge_battery_icon);
        this.mBatteryStatus = (XTextView) findViewById(R.id.battery_status);
        this.mRightArrow = (XImageButton) findViewById(R.id.right_arrow);
        this.mBatterySpace = (Space) findViewById(R.id.battery_space);
        this.mRightArrow.setOnClickListener(this.mRecommendClickListener);
        initVui(this, null);
        setVuiLayoutLoadable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XConstraintLayout
    public void finalize() throws Throwable {
        super.finalize();
        releaseVui();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) getResources().getDimension(R.dimen.charge_content_width), 1073741824), View.MeasureSpec.makeMeasureSpec((int) getResources().getDimension(R.dimen.charge_content_height), 1073741824));
    }

    public void setSelectedState(boolean z) {
        this.mRightArrow.setSelected(z);
    }

    public void updateRecommendViewData(@NonNull RecommendChargerBean recommendChargerBean, int i) {
        L.Tag tag = TAG;
        L.i(tag, "mNavDistance: " + recommendChargerBean.getNavDistance() + ", mLeftDistance: " + recommendChargerBean.getLeftDistance());
        if (this.mBean == null || !recommendChargerBean.getId().equals(this.mBean.getId())) {
            onRecommendShow(recommendChargerBean);
            setSelectedState(false);
        } else if (this.mBean.getType() != recommendChargerBean.getType()) {
            setSelectedState(false);
        }
        this.mBean = recommendChargerBean;
        setIconAndSign(recommendChargerBean.getType());
        setRecommendInfo(recommendChargerBean.getNavDistance(), recommendChargerBean.getLeftDistance(), i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchVisibilityChanged(View view, int i) {
        RecommendChargerBean recommendChargerBean;
        super.dispatchVisibilityChanged(view, i);
        if (i != 0 || (recommendChargerBean = this.mBean) == null) {
            return;
        }
        onRecommendShow(recommendChargerBean);
    }

    private void onRecommendShow(RecommendChargerBean recommendChargerBean) {
        RecommendChargeStatUtil.sendShowData(recommendChargerBean);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void setIconAndSign(int i) {
        int i2 = R.drawable.png_charge_poi_recommend_other;
        int i3 = 0;
        int i4 = R.drawable.png_poi_large_charge_pc_chargingpile_slow;
        switch (i) {
            case 1001:
                FavoriteAddress company = FavoriteDataManager.getInstance().getCompany();
                if (company != null && company.getXPPoiInfo() != null) {
                    i3 = R.drawable.tag_small_company;
                    break;
                }
                i3 = R.drawable.png_tag_small_commonly;
                break;
            case 1002:
                FavoriteAddress home = FavoriteDataManager.getInstance().getHome();
                if (home != null && home.getXPPoiInfo() != null) {
                    i3 = R.drawable.tag_small_home;
                    break;
                }
                i3 = R.drawable.png_tag_small_commonly;
                break;
            case 1003:
                i3 = R.drawable.png_tag_small_commonly;
                break;
            default:
                switch (i) {
                    case 2001:
                        i2 = R.drawable.png_charge_poi_recommend_xp;
                    case 2002:
                    case 2003:
                        i4 = i2;
                        i3 = R.drawable.png_tag_small_recommend;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
        }
        this.mChargeIcon.setImageResource(ThemeWatcherUtil.getDrawableResId(i4));
        this.mChargeSign.setImageResource(ThemeWatcherUtil.getDrawableResId(i3));
    }

    private void setRecommendInfo(double d, double d2, int i) {
        int i2;
        String[] distanceArray = NaviUtil.getDistanceArray(d);
        this.mNaviDistance.setText(distanceArray[0]);
        this.mNaviDistanceUnit.setText(distanceArray[1]);
        long j = i;
        int i3 = (int) d2;
        this.mBatteryStatus.setTextColor(NaviUtil.checkColorStatus(j, i3));
        this.mBatteryIcon.updateBatteryStatus(i, i3, (int) d);
        this.mBatterySpace.setVisibility(this.mBatteryIcon.getVisibility());
        try {
            i2 = NaviUtil.checkDistanceReachableStatus(j, i3);
        } catch (NaviUtil.DistanceStatusIllegalArgumentException unused) {
            if (L.ENABLE) {
                L.d(TAG, "INVALID remain dis and leftDistance remain dis: " + i + " leftDis: " + d2);
            }
            i2 = 2;
        }
        if (i2 == 0) {
            this.mBatteryStatus.setText(R.string.navi_unable_reach_des);
        } else if (i2 == 1) {
            String[] remainDistanceArray = NaviUtil.getRemainDistanceArray(d2);
            this.mBatteryStatus.setText(ContextUtils.getString(R.string.recommend_charger_arrived_left_distance, remainDistanceArray[0], remainDistanceArray[1]));
        } else if (i2 != 2) {
        } else {
            this.mBatteryStatus.setText(R.string.navi_lower_power_des);
        }
    }

    public void setListener(RecommendChargeClickListener recommendChargeClickListener) {
        this.mListener = recommendChargeClickListener;
    }

    public void updateTheme(int i) {
        RecommendChargerBean recommendChargerBean = this.mBean;
        if (recommendChargerBean != null) {
            updateRecommendViewData(recommendChargerBean, i);
        }
    }

    public void setIconAndSign() {
        RecommendChargerBean recommendChargerBean;
        if (getVisibility() != 0 || (recommendChargerBean = this.mBean) == null) {
            return;
        }
        setIconAndSign(recommendChargerBean.getType());
    }

    public XPPoiInfo getPoiInfo() {
        RecommendChargerBean recommendChargerBean = this.mBean;
        if (recommendChargerBean != null) {
            return recommendChargerBean.getXPPoiInfo();
        }
        return null;
    }
}
