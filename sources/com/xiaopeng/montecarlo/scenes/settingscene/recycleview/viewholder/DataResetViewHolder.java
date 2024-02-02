package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
/* loaded from: classes3.dex */
public class DataResetViewHolder extends BaseSettingViewHolder {
    private static final L.Tag TAG = new L.Tag("DataResetViewHolder");

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
    }

    public DataResetViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @OnClick({R.id.setting_map_data_reset_layout, R.id.setting_map_data_reset_btn})
    public void onClickButtonRestoreDefaultData(View view) {
        this.mAdapter.restoreDefaultData(view.isSelected());
    }

    @OnLongClick({R.id.setting_map_data_reset_btn})
    public boolean onLongClickButtonRestoreDefaultData(View view) {
        L.i(TAG, "onLongClickButtonRestoreDefaultData");
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_LAST_SYS_VERSION, "");
        RootUtil.delayExitApp(RootUtil.KILL_NAVI_USER_LONG_CLICK);
        return true;
    }
}
