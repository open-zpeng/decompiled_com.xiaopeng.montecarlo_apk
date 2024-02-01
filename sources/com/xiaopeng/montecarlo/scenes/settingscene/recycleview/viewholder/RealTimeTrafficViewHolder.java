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
public class RealTimeTrafficViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_real_time_traffic_switch_btn)
    XSwitch mRealTimeTrafficSwitchBtn;

    public RealTimeTrafficViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mRealTimeTrafficSwitchBtn.setChecked(this.mAdapter.getProvider().isRealTimeTrafficEnable());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mRealTimeTrafficSwitchBtn;
    }

    @OnCheckedChanged({R.id.setting_real_time_traffic_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (xSwitch.isPressed()) {
            this.mAdapter.getProvider().setRealTimeTrafficEnable(xSwitch.isChecked());
            this.mAdapter.modifySettingPreference(15, xSwitch.isChecked());
            this.mAdapter.saveSettingPreference();
            SettingStatUtil.sendStatDataRealTimeTraffic(xSwitch.isChecked());
        }
    }
}
