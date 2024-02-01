package com.xiaopeng.montecarlo.account.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.SyncAlarmManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class FavoriteSyncReceiver extends BroadcastReceiver {
    private static final L.Tag TAG = new L.Tag("FavoriteSyncReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        L.Tag tag = TAG;
        L.i(tag, "onReceive() action = " + action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return;
            }
            if (L.ENABLE) {
                L.d(TAG, "onReceive() CONNECTIVITY_ACTION networkInfo.isConnected()");
            }
            if (!SettingWrapper.getFavoriteSyncStatus()) {
                L.i(TAG, "onReceive() CONNECTIVITY_ACTION blStatus false");
                AccountManager.getInstance().getAccountSyncSession().startSync(55);
            }
            if (SettingWrapper.getAccountDataPullStatus()) {
                if (!SettingWrapper.getAccountDataUploadStatus()) {
                    L.i(TAG, "onReceive() CONNECTIVITY_ACTION xpUploadStatus false");
                    AccountManager.getInstance().getAccountSyncSession().startSync(2);
                }
            } else {
                L.i(TAG, "onReceive() CONNECTIVITY_ACTION xpPullStatus false");
                AccountManager.getInstance().getAccountSyncSession().startSync(1);
            }
            if (SettingWrapper.getDeletedAllNormalFavVersion() > 0 || SettingWrapper.getDeletedAllNormalHistoryVersion() > 0) {
                L.i(TAG, "del_user_data onReceive() CONNECTIVITY_ACTION start sync");
                AccountManager.getInstance().getAccountSyncSession().startSync(4);
            }
        } else if (SyncAlarmManager.ACCOUNT_SYNC_TIMER_BROADCAST_ACTION.equals(action)) {
            AccountManager.getInstance().getAccountSyncSession().startSync(55);
            AccountManager.getInstance().getAccountSyncSession().startSync(2);
        }
    }
}
