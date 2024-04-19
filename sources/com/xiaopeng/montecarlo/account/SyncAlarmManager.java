package com.xiaopeng.montecarlo.account;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class SyncAlarmManager {
    public static final String ACCOUNT_SYNC_TIMER_BROADCAST_ACTION = "com.xiaopeng.montecarlo.FAVORITE_TIME_SYNC_BROADCAST_ACTION";
    private static final int ACCOUNT_SYNC_TIME_INTERVAL = 1800000;
    private static final L.Tag TAG = new L.Tag("Sync_AlarmManager");

    public static void setAccountSyncAlarm() {
        PendingIntent accountSyncPendingIntent = getAccountSyncPendingIntent();
        long currentTimeMillis = System.currentTimeMillis() + 1800000;
        ((AlarmManager) ContextUtils.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, currentTimeMillis, accountSyncPendingIntent);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "setAccountSyncAlarm next sync time = " + currentTimeMillis);
        }
    }

    public static void cancelAccountSyncAlarm() {
        if (SettingWrapper.getFavoriteSyncStatus()) {
            if (SettingWrapper.getAccountDataPullStatus()) {
                if (SettingWrapper.getAccountDataUploadStatus()) {
                    ((AlarmManager) ContextUtils.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(getAccountSyncPendingIntent());
                } else if (L.ENABLE) {
                    L.d(TAG, "cancelAccountSyncAlarm cancel sync time, xpUploadStatus false");
                }
            } else if (L.ENABLE) {
                L.d(TAG, "cancelAccountSyncAlarm cancel sync time, xpPullStatus false");
            }
        } else if (L.ENABLE) {
            L.d(TAG, "cancelAccountSyncAlarm cancel sync time, blStatus false");
        }
    }

    private static PendingIntent getAccountSyncPendingIntent() {
        return PendingIntent.getBroadcast(ContextUtils.getContext(), 0, new Intent(ACCOUNT_SYNC_TIMER_BROADCAST_ACTION), 0);
    }
}
