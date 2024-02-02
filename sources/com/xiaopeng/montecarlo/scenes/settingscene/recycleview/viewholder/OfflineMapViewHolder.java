package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bridge.MapDownloadBridge;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class OfflineMapViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_offline_map_tv)
    XTextView mMapDownloadTv;
    @BindView(R.id.setting_offline_map_title)
    XTextView mSettingOfflineMapTitle;

    public OfflineMapViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        long mapDownloadSize = this.mAdapter.getProvider().getMapDownloadSize();
        int i = (mapDownloadSize > 0L ? 1 : (mapDownloadSize == 0L ? 0 : -1));
        if (i < 0 || !MapDataManager.getInstance().isCompletedInitialized()) {
            this.mMapDownloadTv.setText("");
        } else if (i == 0) {
            this.mMapDownloadTv.setText(R.string.setting_offline_map_tv_descr_all_done);
        } else {
            this.mMapDownloadTv.setText(String.format(ContextUtils.getString(R.string.setting_offline_map_tv_descr), RootUtil.getFormatSize(mapDownloadSize)));
        }
    }

    @OnClick({R.id.setting_offline_map_btn, R.id.setting_offline_map_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_offline_map_btn /* 2131297300 */:
            case R.id.setting_offline_map_layout /* 2131297301 */:
                this.mAdapter.startScene(new MapDownloadBridge(), 5);
                return;
            default:
                return;
        }
    }
}
