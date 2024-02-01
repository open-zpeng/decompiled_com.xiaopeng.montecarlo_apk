package com.xiaopeng.montecarlo.service.minimap;

import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.account.AccountEventCallback;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
/* loaded from: classes3.dex */
public class MiniMapAccountEventCallback implements AccountEventCallback {
    private MiniMapServiceHelper mMiniMapServiceHelper;

    @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
    public void accountSyncFinish() {
    }

    @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
    public void amapQuickLogin() {
    }

    @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
    public void xpMapLogin() {
    }

    public MiniMapAccountEventCallback(MiniMapServiceHelper miniMapServiceHelper) {
        this.mMiniMapServiceHelper = miniMapServiceHelper;
    }

    @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
    public void refreshSettingInfos(int i, int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapAccountEventCallback.1
            @Override // java.lang.Runnable
            public void run() {
                if (MiniMapAccountEventCallback.this.mMiniMapServiceHelper != null) {
                    MiniMapAccountEventCallback.this.mMiniMapServiceHelper.updateCarIcon();
                    MiniMapAccountEventCallback.this.mMiniMapServiceHelper.updateRealTimeTrafficState(SettingWrapper.isRealTimeTraffic());
                    MiniMapAccountEventCallback.this.mMiniMapServiceHelper.setMapMode(SettingWrapper.getCurrentMinimapMapMode(), true, false);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.root.account.AccountEventCallback
    public void initAccountFinish() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.service.minimap.MiniMapAccountEventCallback.2
            @Override // java.lang.Runnable
            public void run() {
                if (MiniMapAccountEventCallback.this.mMiniMapServiceHelper != null) {
                    MiniMapAccountEventCallback.this.mMiniMapServiceHelper.updateCarIcon();
                    MiniMapAccountEventCallback.this.mMiniMapServiceHelper.updateRealTimeTrafficState(SettingWrapper.isRealTimeTraffic());
                    MiniMapAccountEventCallback.this.mMiniMapServiceHelper.setMapMode(SettingWrapper.getCurrentMinimapMapMode(), true, false);
                }
            }
        });
    }
}
