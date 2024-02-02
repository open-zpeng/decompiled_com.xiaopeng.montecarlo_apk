package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.os.Bundle;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bridge.LinkSeamlessNaviBridge;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.stat.NaviGuiderStatUtil;
import com.xiaopeng.montecarlo.views.AccountTypeView;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class MapSeamlessNaviViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_map_bind_guide_icon)
    AccountTypeView mMapBindGuideIcon;
    @BindView(R.id.setting_map_seamless_navi_layout)
    XpGroup mSeamlessLayout;
    @BindView(R.id.setting_account_subtitle_content)
    XTextView mSettingAccountSubtitleContent;
    @BindView(R.id.setting_map_user_seamless_navi_name)
    XTextView mSettingMapUserSeamlessNaviName;
    @BindView(R.id.setting_map_xpeng_guide_icon)
    AccountTypeView mXpengGuideIcon;

    public MapSeamlessNaviViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mMapBindGuideIcon.updateLogonStatus(this.mAdapter.getProvider().isAMapBinded());
        this.mXpengGuideIcon.updateLogonStatus(this.mAdapter.getProvider().isXPAccountLoginIn());
    }

    @OnClick({R.id.setting_map_seamless_icon, R.id.setting_map_seamless_navi_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_map_seamless_icon /* 2131297276 */:
            case R.id.setting_map_seamless_navi_layout /* 2131297277 */:
                NaviGuiderStatUtil.bISettingNaviGuiderEnterBtn();
                Bundle bundle = new Bundle();
                bundle.putInt(LinkSeamlessNaviBridge.KEY_FROM_WHERE, 0);
                this.mAdapter.startScene(new LinkSeamlessNaviBridge().setBundle(bundle), 3);
                return;
            default:
                return;
        }
    }
}
