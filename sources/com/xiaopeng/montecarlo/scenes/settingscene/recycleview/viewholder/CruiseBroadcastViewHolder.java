package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XToggleButton;
/* loaded from: classes3.dex */
public class CruiseBroadcastViewHolder extends BaseSettingViewHolder implements View.OnClickListener {
    @BindView(R.id.setting_cruise_ahead_traffic_btn)
    XToggleButton mSettingCruiseAheadTrafficBtn;
    @BindView(R.id.setting_cruise_electronic_eye_broadcast_btn)
    XToggleButton mSettingCruiseElecronicEyeBroadcastBtn;
    @BindView(R.id.setting_cruise_safety_broadcast_btn)
    XToggleButton mSettingCruiseSafetyBroadcastBtn;
    @BindView(R.id.setting_cruise_title)
    XTextView mSettingCruiseTitle;

    public CruiseBroadcastViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
        this.mSettingCruiseAheadTrafficBtn.setOnClickListener(this);
        this.mSettingCruiseSafetyBroadcastBtn.setOnClickListener(this);
        this.mSettingCruiseElecronicEyeBroadcastBtn.setOnClickListener(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mSettingCruiseAheadTrafficBtn.setChecked(this.mAdapter.getProvider().isCruiseAheadTrafficEnable());
        this.mSettingCruiseSafetyBroadcastBtn.setChecked(this.mAdapter.getProvider().isCruiseSafetyBroadcastEnable());
        this.mSettingCruiseElecronicEyeBroadcastBtn.setChecked(this.mAdapter.getProvider().isCruiseElectronicEyeBroadcastEnable());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof XToggleButton) {
            boolean isChecked = ((XToggleButton) view).isChecked();
            switch (view.getId()) {
                case R.id.setting_cruise_ahead_traffic_btn /* 2131297249 */:
                    this.mAdapter.getProvider().setCruiseAheadTrafficEnable(isChecked);
                    this.mAdapter.modifySettingPreference(6, isChecked);
                    SettingStatUtil.sendStatDataCruiseAheadTraffic(isChecked);
                    break;
                case R.id.setting_cruise_electronic_eye_broadcast_btn /* 2131297250 */:
                    this.mAdapter.getProvider().setCruiseElectronicEyeBroadcastEnable(isChecked);
                    this.mAdapter.modifySettingPreference(7, isChecked);
                    SettingStatUtil.sendStatDataCruiseElectronicEyeBroadcast(isChecked);
                    break;
                case R.id.setting_cruise_safety_broadcast_btn /* 2131297251 */:
                    this.mAdapter.getProvider().setCruiseSafetyBroadcastEnable(isChecked);
                    this.mAdapter.modifySettingPreference(8, isChecked);
                    SettingStatUtil.sendStatDataCruiseSafetyBroadcast(isChecked);
                    break;
            }
            this.mAdapter.saveSettingPreference();
        }
    }
}
