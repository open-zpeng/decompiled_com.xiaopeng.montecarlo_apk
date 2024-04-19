package com.xiaopeng.montecarlo.navcore.download;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.download.autodownload.profile.DownloadUserProfile;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataContent;
/* loaded from: classes2.dex */
public interface IMapDataOperator {
    DownloadUserProfile getUserProfile();

    default void handlePushMessage(@NonNull MapDataContent mapDataContent) {
    }

    void initAutoDownload();

    void onAdCodeChanged(int i);

    void onAutoDownloadSwitchChanged(boolean z);

    default void onOOBE() {
    }

    void retriggerAutoDownload();
}
