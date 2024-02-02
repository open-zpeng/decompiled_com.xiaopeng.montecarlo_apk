package com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder;

import android.content.Intent;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.setting.constant.MinimapTypeEnum;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.settingscene.CommonTabChangeListener;
import com.xiaopeng.montecarlo.scenes.settingscene.ISettingCallback;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.SettingPreferenceAdapterView;
import com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.MinimapViewHolder;
import com.xiaopeng.montecarlo.stat.SettingStatUtil;
import com.xiaopeng.montecarlo.views.XpGroup;
import com.xiaopeng.xui.widget.XTabLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class MinimapViewHolder extends BaseSettingViewHolder {
    private static final L.Tag TAG = new L.Tag("MinimapViewHolder");
    @BindView(R.id.setting_minimap_layout)
    XpGroup mMinimapLayout;
    @BindView(R.id.setting_minimap_mapmode_xindicator)
    XTabLayout mMinimapMapmodeXIndicator;
    @BindView(R.id.setting_minimap_title)
    XTextView mSettingMinimapTitle;

    public MinimapViewHolder(View view, SettingPreferenceAdapterView settingPreferenceAdapterView) {
        super(view, settingPreferenceAdapterView);
        ButterKnife.bind(this, view);
        this.mMinimapMapmodeXIndicator.setOnTabChangeListener(new OnTabChangeListenerForMinimap());
    }

    @Override // com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.BaseSettingViewHolder
    public void refreshViewFromData() {
        this.mMinimapMapmodeXIndicator.selectTab(this.mAdapter.getProvider().getMinimapTypeEnum().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMinimapMapMode(int i) {
        if (TBTManager.getInstance().isMiniMapEnable()) {
            Intent intent = new Intent();
            intent.setClassName(ContextUtils.getContext().getPackageName(), "com.xiaopeng.montecarlo.service.minimap.MiniMapService");
            intent.setAction("com.xiaopeng.montecarlo.minimap.ACTION_SET_MAP_MODE");
            intent.putExtra("map_mode", i);
            ContextUtils.getContext().startService(intent);
            L.i(TAG, "MiniMapService startService ACTION_SET_MAP_MODE in sendMinimapMapMode");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class OnTabChangeListenerForMinimap extends CommonTabChangeListener {
        private OnTabChangeListenerForMinimap() {
        }

        @Override // com.xiaopeng.montecarlo.scenes.settingscene.CommonTabChangeListener
        public void onTabSelected(int i) {
            if (i == 0) {
                MinimapViewHolder.this.mAdapter.getProvider().setMinimapTypeEnum(MinimapTypeEnum.MINIMAP_MAPMODE_3D_CAR);
                MinimapViewHolder.this.mAdapter.modifySettingPreference(21, true);
                MinimapViewHolder.this.mAdapter.modifySettingPreference(22, false);
            } else if (i == 1) {
                MinimapViewHolder.this.mAdapter.getProvider().setMinimapTypeEnum(MinimapTypeEnum.MINIMAP_MAPMODE_2D_CAR);
                MinimapViewHolder.this.mAdapter.modifySettingPreference(21, false);
                MinimapViewHolder.this.mAdapter.modifySettingPreference(22, true);
            }
            MinimapViewHolder.this.mAdapter.saveSettingPreference(new ISettingCallback() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.recycleview.viewholder.-$$Lambda$MinimapViewHolder$OnTabChangeListenerForMinimap$APn2Ffcb8uXY7Bxe6PnfleFSuLU
                @Override // com.xiaopeng.montecarlo.scenes.settingscene.ISettingCallback
                public final void onFinish(int i2) {
                    MinimapViewHolder.OnTabChangeListenerForMinimap.this.lambda$onTabSelected$0$MinimapViewHolder$OnTabChangeListenerForMinimap(i2);
                }
            });
            MinimapViewHolder.this.mAdapter.updateSceneWithView(MinimapViewHolder.this.mMinimapMapmodeXIndicator);
        }

        public /* synthetic */ void lambda$onTabSelected$0$MinimapViewHolder$OnTabChangeListenerForMinimap(int i) {
            SettingStatUtil.sendMinimapMapMode(1 == SettingWrapper.getCurrentMinimapMapMode(i));
            MinimapViewHolder.this.sendMinimapMapMode(SettingWrapper.getCurrentMinimapMapMode(i));
        }
    }
}
