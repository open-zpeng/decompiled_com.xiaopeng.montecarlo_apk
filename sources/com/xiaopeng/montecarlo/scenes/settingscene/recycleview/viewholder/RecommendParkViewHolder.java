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
public class RecommendParkViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_recommend_park_switch_btn)
    XSwitch mSettingRecommendParkBtn;

    public RecommendParkViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mSettingRecommendParkBtn.setChecked(this.mAdapter.getProvider().isRecommendParkEnable());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mSettingRecommendParkBtn;
    }

    @OnCheckedChanged({R.id.setting_recommend_park_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (this.mAdapter.getProvider().isRecommendParkEnable() == xSwitch.isChecked()) {
            return;
        }
        this.mAdapter.getProvider().setRecommendParkEnable(xSwitch.isChecked());
        this.mAdapter.modifySettingPreference(24, xSwitch.isChecked());
        this.mAdapter.saveSettingPreference();
        this.mAdapter.updateSceneWithView(this.mSettingRecommendParkBtn);
        SettingStatUtil.sendStatRecommendPark(xSwitch.isChecked());
    }
}
