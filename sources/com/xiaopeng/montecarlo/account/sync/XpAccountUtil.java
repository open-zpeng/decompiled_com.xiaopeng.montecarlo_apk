package com.xiaopeng.montecarlo.account.sync;

import com.xiaopeng.montecarlo.navcore.bean.sync.AccountDataPullResponse;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class XpAccountUtil {
    private static final int MAX_UPLOAD_COUNT = 1000;
    private static final L.Tag TAG = new L.Tag("Xp_Sync_AccountUtil");

    public static void updateUploadCount() {
        SettingWrapper.setAccountDataUploadCount(SettingWrapper.getAccountDataUploadCount() + 1);
    }

    public static void updateUploadTime() {
        SettingWrapper.setAccountDataUploadTime(System.currentTimeMillis());
    }

    public static void updatePullTime() {
        SettingWrapper.setAccountDataUploadTime(System.currentTimeMillis());
    }

    public static boolean isPullSuccess() {
        return SettingWrapper.getAccountDataPullStatus();
    }

    public static boolean isUploadSuccess() {
        return SettingWrapper.getAccountDataUploadStatus();
    }

    public static boolean checkPullStatus(AccountDataPullResponse accountDataPullResponse) {
        return accountDataPullResponse != null && 200 == accountDataPullResponse.getCode();
    }

    public static void setPullStatus(boolean z) {
        SettingWrapper.setAccountDataPullStatus(z);
    }

    public static void setUploadStatus(boolean z) {
        SettingWrapper.setAccountDataUploadStatus(z);
    }

    public static boolean isLessThanUploadTimes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.setTimeInMillis(SettingWrapper.getAccountDataUploadTime());
        int i4 = calendar.get(1);
        int i5 = calendar.get(2);
        int i6 = calendar.get(5);
        if (i == i4 && i5 == i2 && i3 == i6) {
            int accountDataUploadCount = SettingWrapper.getAccountDataUploadCount();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "AccountSyncSession isLessThanRetryTimes count = " + accountDataUploadCount);
            }
            return accountDataUploadCount < 1000;
        }
        if (L.ENABLE) {
            L.d(TAG, "AccountSyncSession isLessThanRetryTimes new day reset");
        }
        SettingWrapper.setAccountDataUploadCount(0);
        return true;
    }

    public static void updateLocalVersion(int i) {
        SettingWrapper.setLocalVersion(i);
    }

    public static void updateRecordTime(long j) {
        SettingWrapper.setDataSyncRecordTime(j);
    }

    public static boolean hasAccountLocalData() {
        long dataSyncRecordTime = SettingWrapper.getDataSyncRecordTime();
        boolean hasIncrementData = IncrementDataManager.getInstance().hasIncrementData();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "hasAccountLocalData hasData = " + hasIncrementData + ", recordTime = " + dataSyncRecordTime);
        }
        return hasIncrementData || dataSyncRecordTime > 0;
    }
}
