package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.download.IMapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingCallback;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.xui.widget.XSwitch;
import java.util.Objects;
/* loaded from: classes3.dex */
public class OfflineMapAutoUpdateViewHolder extends BaseSettingViewHolder {
    @BindView(R.id.setting_map_data_update_switch_btn)
    XSwitch mMapDataUpdateSwitchBtn;

    public OfflineMapAutoUpdateViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mMapDataUpdateSwitchBtn.setChecked(this.mAdapter.getProvider().isMapDataAutoUpdateEnable());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public XSwitch getXSwitch() {
        return this.mMapDataUpdateSwitchBtn;
    }

    @OnCheckedChanged({R.id.setting_map_data_update_switch_btn})
    public void onCheckedChanged(XSwitch xSwitch) {
        if (xSwitch.isPressed()) {
            this.mAdapter.getProvider().setMapDataAutoUpdateEnable(xSwitch.isChecked());
            this.mAdapter.modifySettingPreference(16, xSwitch.isChecked());
            this.mAdapter.saveSettingPreference(new ISettingCallback() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.-$$Lambda$OfflineMapAutoUpdateViewHolder$8SDzejhpxzKddY3XVQhT8nCy9Eo
                @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingCallback
                public final void onFinish(int i) {
                    OfflineMapAutoUpdateViewHolder.lambda$onCheckedChanged$0(i);
                }
            });
            DataLogUtil.sendStatData(PageType.SETTING, BtnType.DOWNLOAD_AUTO_SWITCH, Integer.valueOf(xSwitch.isChecked() ? 1 : 0));
            this.mAdapter.updateSceneWithView(this.mMapDataUpdateSwitchBtn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onCheckedChanged$0(int i) {
        IMapDataOperator mapDataOperator = MapDataManager.getInstance().getMapDataOperator();
        if (Objects.nonNull(mapDataOperator)) {
            mapDataOperator.onAutoDownloadSwitchChanged(SettingWrapper.isAutoDataDownloadEnabled(i));
        }
    }
}
