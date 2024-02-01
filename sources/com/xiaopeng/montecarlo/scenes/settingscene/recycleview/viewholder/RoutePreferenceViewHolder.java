package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XToggleButton;
/* loaded from: classes3.dex */
public class RoutePreferenceViewHolder extends BaseSettingViewHolder implements View.OnClickListener {
    @BindView(R.id.setting_route_avoid_charge_btn)
    XToggleButton mSettingRouteAvoidChargeBtn;
    @BindView(R.id.setting_route_avoid_congestion_btn)
    XToggleButton mSettingRouteAvoidCongestionBtn;
    @BindView(R.id.setting_route_highway_priority_btn)
    XToggleButton mSettingRouteHighwayPriorityBtn;
    @BindView(R.id.setting_route_no_freeways_btn)
    XToggleButton mSettingRouteNoFreewaysBtn;
    @BindView(R.id.setting_route_title)
    XTextView mSettingRouteTitle;

    public RoutePreferenceViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
        this.mSettingRouteAvoidCongestionBtn.setOnClickListener(this);
        this.mSettingRouteAvoidChargeBtn.setOnClickListener(this);
        this.mSettingRouteNoFreewaysBtn.setOnClickListener(this);
        this.mSettingRouteHighwayPriorityBtn.setOnClickListener(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mSettingRouteAvoidCongestionBtn.setChecked(this.mAdapter.getProvider().isAvoidCongestionEnable());
        this.mSettingRouteAvoidChargeBtn.setChecked(this.mAdapter.getProvider().isAvoidChargeEnable());
        this.mSettingRouteNoFreewaysBtn.setChecked(this.mAdapter.getProvider().isNoFreewaysEnable());
        this.mSettingRouteHighwayPriorityBtn.setChecked(this.mAdapter.getProvider().isHighwayPriorityEnable());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof XToggleButton) {
            boolean isChecked = ((XToggleButton) view).isChecked();
            switch (view.getId()) {
                case R.id.setting_route_avoid_charge_btn /* 2131297310 */:
                    this.mAdapter.getProvider().setAvoidChargeEnable(isChecked);
                    this.mAdapter.modifySettingPreference(1, isChecked);
                    if (this.mSettingRouteHighwayPriorityBtn.isChecked()) {
                        this.mSettingRouteHighwayPriorityBtn.setChecked(false);
                        this.mAdapter.getProvider().setHighwayPriorityEnable(false);
                        this.mAdapter.modifySettingPreference(3, false);
                        SettingStatUtil.sendStatDataHighWayPriority(false, false);
                    }
                    SettingStatUtil.sendStatDataAvoidFee(true, isChecked);
                    break;
                case R.id.setting_route_avoid_congestion_btn /* 2131297311 */:
                    this.mAdapter.getProvider().setAvoidCongestionEnable(isChecked);
                    this.mAdapter.modifySettingPreference(0, isChecked);
                    if (isChecked) {
                        this.mAdapter.showSettingToast(ContextUtils.getString(R.string.setting_route_avoid_congestion_tip));
                    }
                    SettingStatUtil.sendStatDataAvoidCongestion(true, isChecked);
                    break;
                case R.id.setting_route_highway_priority_btn /* 2131297312 */:
                    this.mAdapter.getProvider().setHighwayPriorityEnable(isChecked);
                    this.mAdapter.modifySettingPreference(3, isChecked);
                    if (this.mSettingRouteAvoidChargeBtn.isChecked()) {
                        this.mSettingRouteAvoidChargeBtn.setChecked(false);
                        this.mAdapter.getProvider().setAvoidChargeEnable(false);
                        this.mAdapter.modifySettingPreference(1, false);
                        SettingStatUtil.sendStatDataAvoidFee(false, false);
                    }
                    if (this.mSettingRouteNoFreewaysBtn.isChecked()) {
                        this.mSettingRouteNoFreewaysBtn.setChecked(false);
                        this.mAdapter.getProvider().setNoFreewaysEnable(false);
                        this.mAdapter.modifySettingPreference(2, false);
                        SettingStatUtil.sendStatDataAvoidHighWay(false, false);
                    }
                    SettingStatUtil.sendStatDataHighWayPriority(true, isChecked);
                    break;
                case R.id.setting_route_no_freeways_btn /* 2131297313 */:
                    this.mAdapter.getProvider().setNoFreewaysEnable(isChecked);
                    this.mAdapter.modifySettingPreference(2, isChecked);
                    if (this.mSettingRouteHighwayPriorityBtn.isChecked()) {
                        this.mSettingRouteHighwayPriorityBtn.setChecked(false);
                        this.mAdapter.getProvider().setHighwayPriorityEnable(false);
                        this.mAdapter.modifySettingPreference(3, false);
                        SettingStatUtil.sendStatDataHighWayPriority(false, false);
                    }
                    SettingStatUtil.sendStatDataAvoidHighWay(true, isChecked);
                    break;
            }
            this.mAdapter.saveSettingPreference();
        }
    }
}
