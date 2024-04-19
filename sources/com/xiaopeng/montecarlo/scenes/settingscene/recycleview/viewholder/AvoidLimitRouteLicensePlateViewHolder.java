package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.text.TextUtils;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bridge.SettingLicencePlateBridge;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class AvoidLimitRouteLicensePlateViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_avoid_limit_route_license_plate_layout)
    XpGroup mLicencePlateEditBtn;
    @BindView(R.id.setting_avoid_limit_route_license_plate_tv)
    XTextView mLicencePlateTv;

    public AvoidLimitRouteLicensePlateViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        String licensePlate = this.mAdapter.getProvider().getLicensePlate();
        if (!TextUtils.isEmpty(licensePlate)) {
            this.mLicencePlateTv.setText(licensePlate);
        } else {
            this.mLicencePlateTv.setText(R.string.setting_avoid_limit_route_license_plate_edit_btn_name);
        }
    }

    @OnClick({R.id.setting_avoid_limit_route_license_plate_btn, R.id.setting_avoid_limit_route_license_plate_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_avoid_limit_route_license_plate_btn /* 2131297262 */:
            case R.id.setting_avoid_limit_route_license_plate_layout /* 2131297263 */:
                SettingStatUtil.sendStatDataEditPlate(TextUtils.isEmpty(this.mAdapter.getProvider().getLicensePlate()));
                this.mAdapter.startScene(new SettingLicencePlateBridge().setStartMode(1), 2);
                return;
            default:
                return;
        }
    }
}
