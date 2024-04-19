package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.text.TextUtils;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bridge.SettingLicencePlateBridge;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.xui.widget.XSwitch;
/* loaded from: classes3.dex */
public class AvoidLimitRouteViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_avoid_limit_route_switch_btn)
    XSwitch mAvoidLimitRouteSwitchBtn;

    public AvoidLimitRouteViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mAvoidLimitRouteSwitchBtn.setChecked(this.mAdapter.getProvider().isAvoidRestrictionRouteEnable());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mAvoidLimitRouteSwitchBtn;
    }

    @OnCheckedChanged({R.id.setting_avoid_limit_route_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (xSwitch.isPressed()) {
            String licensePlate = this.mAdapter.getProvider().getLicensePlate();
            if (this.mAvoidLimitRouteSwitchBtn.isChecked() && TextUtils.isEmpty(licensePlate)) {
                this.mAdapter.startScene(new SettingLicencePlateBridge().setStartMode(1), 4);
                return;
            }
            this.mAdapter.getProvider().setAvoidRestrictionRouteEnable(xSwitch.isChecked());
            this.mAdapter.modifySettingPreference(9, xSwitch.isChecked());
            this.mAdapter.saveSettingPreference();
            SettingStatUtil.sendStatDataAvoidRestrictionRoute(xSwitch.isChecked());
        }
    }
}
