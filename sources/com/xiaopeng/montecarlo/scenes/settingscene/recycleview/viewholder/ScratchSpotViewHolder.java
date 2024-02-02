package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.xui.widget.XSwitch;
/* loaded from: classes3.dex */
public class ScratchSpotViewHolder extends BaseSettingViewHolder {
    private static final L.Tag TAG = new L.Tag("ScratchSpotViewHolder");
    @BindView(R.id.setting_scratch_spot_switch_btn)
    XSwitch mScratchSpotSwitchBtn;

    public ScratchSpotViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        boolean isScratchSpotEnable = this.mAdapter.getProvider().isScratchSpotEnable();
        this.mScratchSpotSwitchBtn.setChecked(isScratchSpotEnable);
        boolean isScratchSpotEnable2 = SettingWrapper.isScratchSpotEnable();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "refreshViewFromData providerState:" + isScratchSpotEnable + ",preferenceState:" + isScratchSpotEnable2);
        }
        if (isScratchSpotEnable != isScratchSpotEnable2) {
            L.Tag tag2 = TAG;
            L.w(tag2, "refreshViewFromData exception,providerState:" + isScratchSpotEnable + ",preferenceState:" + isScratchSpotEnable2);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mScratchSpotSwitchBtn;
    }

    @OnCheckedChanged({R.id.setting_scratch_spot_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (xSwitch.isPressed()) {
            boolean isChecked = xSwitch.isChecked();
            this.mAdapter.getProvider().setScratchSpotEnable(isChecked);
            this.mAdapter.modifySettingPreference(23, isChecked);
            this.mAdapter.saveSettingPreference();
            SettingStatUtil.sendStatDataScratchSpot(isChecked);
            this.mAdapter.enableScratchSpot(isChecked);
            this.mAdapter.updateSceneWithView(this.mScratchSpotSwitchBtn);
        }
    }
}
