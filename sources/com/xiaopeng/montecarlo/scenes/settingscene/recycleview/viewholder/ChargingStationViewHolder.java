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
public class ChargingStationViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_charging_station_show_switch_btn)
    XSwitch mChargingStationShowSwitchBtn;

    public ChargingStationViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mChargingStationShowSwitchBtn.setChecked(this.mAdapter.getProvider().isChargingStationDisplayEnable());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mChargingStationShowSwitchBtn;
    }

    @OnCheckedChanged({R.id.setting_charging_station_show_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (xSwitch.isPressed()) {
            this.mAdapter.getProvider().setChargingStationDisplayEnable(xSwitch.isChecked());
            this.mAdapter.modifySettingPreference(14, xSwitch.isChecked());
            this.mAdapter.saveSettingPreference();
            SettingStatUtil.sendStatDataChargingStationShow(xSwitch.isChecked());
            this.mAdapter.enableCharge(xSwitch.isChecked());
        }
    }
}
