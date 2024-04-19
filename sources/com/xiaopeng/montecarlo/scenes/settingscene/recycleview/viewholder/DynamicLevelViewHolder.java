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
public class DynamicLevelViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_dynamic_level_switch_btn)
    XSwitch mSettingDynamicLevelSwitchBtn;

    public DynamicLevelViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mSettingDynamicLevelSwitchBtn.setChecked(this.mAdapter.getProvider().isMapDynamicLevelEnable());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mSettingDynamicLevelSwitchBtn;
    }

    @OnCheckedChanged({R.id.setting_dynamic_level_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (xSwitch.isPressed()) {
            this.mAdapter.getProvider().setMapDynamicLevelEnable(xSwitch.isChecked());
            this.mAdapter.modifySettingPreference(17, xSwitch.isChecked());
            this.mAdapter.saveSettingPreference();
            SettingStatUtil.sendStatDynamicLevel(xSwitch.isChecked());
        }
    }
}
