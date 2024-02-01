package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bridge.SetCarLogoBridge;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class CarLogoViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_current_car_logo_sub_title)
    XTextView mCarCurrentTitle;
    @BindView(R.id.setting_car_logo_more)
    XImageView mCarLogoIconMore;
    @BindView(R.id.setting_carlogo_hint_tv)
    XTextView mCarLogoMore;
    @BindView(R.id.setting_car_logo_title)
    XTextView mCarTitle;
    @BindView(R.id.setting_current_car_logo_img)
    XImageView mCurrentCarLogo;
    @BindView(R.id.setting_current_car_logo_sub_title_hint)
    XTextView mSetCarLogoHintTitle;

    public CarLogoViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mSetCarLogoHintTitle.setText(this.mAdapter.getProvider().getCarLogoHintTitle());
        int currentCarLogoSrc = this.mAdapter.getProvider().getCurrentCarLogoSrc();
        if (currentCarLogoSrc == -1 || currentCarLogoSrc == 0) {
            currentCarLogoSrc = R.drawable.png_ic_xlarge_carlocation_normal;
        }
        this.mCurrentCarLogo.setImageDrawable(ThemeWatcherUtil.getDrawable(currentCarLogoSrc));
    }

    @OnClick({R.id.setting_car_logo_layout, R.id.setting_car_logo_next})
    public void onClickSetCarLogo(View view) {
        if (preventMultiClick(view)) {
            SettingStatUtil.sendStatDataCarLogo();
            this.mAdapter.startScene(new SetCarLogoBridge(), 6);
        }
    }
}
