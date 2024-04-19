package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.xui.widget.XSwitch;
/* loaded from: classes3.dex */
public class RouteRadarViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_route_radar_switch_btn)
    XSwitch mRouteRaderSwitchBtn;

    public RouteRadarViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mRouteRaderSwitchBtn.setChecked(this.mAdapter.getProvider().isRouteRadarEnable());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mRouteRaderSwitchBtn;
    }

    @OnCheckedChanged({R.id.setting_route_radar_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (xSwitch.isPressed()) {
            this.mAdapter.getProvider().setRouteRadarEnable(xSwitch.isChecked());
            this.mAdapter.modifySettingPreference(10, xSwitch.isChecked());
            this.mAdapter.saveSettingPreference();
            SettingStatUtil.sendStatDataRouteRadar(xSwitch.isChecked());
        }
    }
}
