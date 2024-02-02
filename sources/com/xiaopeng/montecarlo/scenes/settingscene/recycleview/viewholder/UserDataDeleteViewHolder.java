package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
/* loaded from: classes3.dex */
public class UserDataDeleteViewHolder extends BaseSettingViewHolder {
    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
    }

    public UserDataDeleteViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @OnClick({R.id.setting_map_user_data_delete_layout, R.id.setting_map_user_data_delete_btn})
    public void onClickButtonDelUserData() {
        this.mAdapter.delUserData();
    }
}
