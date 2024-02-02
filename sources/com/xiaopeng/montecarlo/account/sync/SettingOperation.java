package com.xiaopeng.montecarlo.account.sync;

import com.xiaopeng.montecarlo.navcore.account.AccountContext;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.util.AudioUtil;
/* loaded from: classes2.dex */
public class SettingOperation {
    public static void initAccountSettingState() {
        syncMapMode();
        refreshVolumeMute();
    }

    private static void refreshVolumeMute() {
        setVolumeMute(SettingWrapper.getVolumeMuteState());
    }

    public static void setMapMode(int i) {
        AccountContext.getInstance().setMapMode(i);
    }

    public static void syncMapMode() {
        AccountContext.getInstance().syncMapMode();
    }

    public static void setVolumeMute(boolean z) {
        AudioUtil.getInstance().setMute(z);
    }
}
