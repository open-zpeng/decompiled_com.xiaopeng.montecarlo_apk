package com.xiaopeng.montecarlo.account.sync;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.account.AccountManager;
import com.xiaopeng.montecarlo.account.IThreadOperation;
import com.xiaopeng.montecarlo.navcore.account.ObjectConvertor;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo;
import com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.SettingSyncUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class IncrementDataHelper {
    private static final L.Tag TAG = new L.Tag("Xp_Sync_IncreHelper");
    private static final Uri XPINCRE_CONTENT_URI = NavFavoriteProvider.XPINCRE_CONTENT_URI;
    private IThreadOperation mIThreadOperation = null;

    public void setIThreadOperation(IThreadOperation iThreadOperation) {
        this.mIThreadOperation = iThreadOperation;
    }

    public IThreadOperation getIThreadOperation() {
        return this.mIThreadOperation;
    }

    public void insertFavorite(FavoriteAddress favoriteAddress, int i) {
        if (favoriteAddress == null) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertFavorite opType = " + i + ", favoriteAddress = " + NaviLogUtil.dumpXPPOIInfo(favoriteAddress.getXPPoiInfo()));
        }
        if (insert(ObjectConvertor.toFavoriteDataOperation(favoriteAddress, i)) != null) {
            startXpUploadSync();
        }
    }

    public void insertHistoryRecord(HistoryRecordInfo historyRecordInfo, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertHistoryRecord opType = " + i + ", historyRecordInfo = " + NaviLogUtil.dumpXPPOIInfo(historyRecordInfo.getXPPoiInfo()));
        }
        if (insert(ObjectConvertor.toHistoryDataOperation(historyRecordInfo, i)) != null) {
            startXpUploadSync();
        }
    }

    public void insertSettings(@NonNull AccountSettingInfo accountSettingInfo, int i) {
        String name = accountSettingInfo.getName();
        if (name.equals(SettingSyncUtil.ACCOUNT_KEY_SETTING_PREFERENCE)) {
            insertSetting(accountSettingInfo, i);
        } else if (name.equals(SettingSyncUtil.SYNC_VOLUME_ON_KEY)) {
            insertVolume(accountSettingInfo, i);
        } else if (name.equals(SettingSyncUtil.SYNC_NAVI_ANGLE_KEY)) {
            insertNavAngle(accountSettingInfo, i);
        } else if (name.equals(SettingSyncUtil.SYNC_CRUISE_ANGLE_KEY)) {
            insertCruiseAngle(accountSettingInfo, i);
        } else {
            insertSetting(accountSettingInfo, i);
        }
    }

    private void insertSetting(AccountSettingInfo accountSettingInfo, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertSetting opType = " + i + ", accountSettingInfo = " + NaviLogUtil.dumpAccountSetInfo(accountSettingInfo));
        }
        if (insert(ObjectConvertor.toSettingDataOperation(accountSettingInfo, false, i)) != null) {
            startXpUploadSync();
        }
    }

    private void insertVolume(AccountSettingInfo accountSettingInfo, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertVolume opType = " + i + ", accountSettingInfo = " + NaviLogUtil.dumpAccountSetInfo(accountSettingInfo));
        }
        if (insert(ObjectConvertor.toVolumeDataOperation(accountSettingInfo, i)) != null) {
            startXpUploadSync();
        }
    }

    private void insertNavAngle(AccountSettingInfo accountSettingInfo, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertNavAngle opType = " + i + ", accountSettingInfo = " + NaviLogUtil.dumpAccountSetInfo(accountSettingInfo));
        }
        IncrementDataRecord navAngleDataOperation = ObjectConvertor.toNavAngleDataOperation(accountSettingInfo, true, i);
        if (navAngleDataOperation == null || insert(navAngleDataOperation) == null) {
            return;
        }
        startXpUploadSync();
    }

    private void insertCruiseAngle(AccountSettingInfo accountSettingInfo, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "insertNavAngle opType = " + i + ", accountSettingInfo = " + NaviLogUtil.dumpAccountSetInfo(accountSettingInfo));
        }
        IncrementDataRecord navAngleDataOperation = ObjectConvertor.toNavAngleDataOperation(accountSettingInfo, false, i);
        if (navAngleDataOperation == null || insert(navAngleDataOperation) == null) {
            return;
        }
        startXpUploadSync();
    }

    private Uri insert(IncrementDataRecord incrementDataRecord) {
        if (isThreadInterrupted() || incrementDataRecord == null) {
            return null;
        }
        try {
            Uri insert = ContextUtils.getContext().getContentResolver().insert(NavFavoriteProvider.XPINCRE_CONTENT_URI, incrementDataRecord.toContentValues());
            if (insert != null) {
                if (ContentUris.parseId(insert) >= 0) {
                    return insert;
                }
            }
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
        }
        return null;
    }

    public void clearNormalFav(List<FavoriteAddress> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "clearNormalFav list.size = " + list.size());
            }
            SettingWrapper.setDeletedAllNormalFavVersion(SettingWrapper.getLocalVersion());
            AccountManager.getInstance().getAccountSyncSession().startSync(4);
        }
    }

    public void clearAllFav(List<FavoriteAddress> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "clearAllFav list.size = " + list.size());
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(ObjectConvertor.toFavoriteDataOperation(list.get(i), 3));
            }
            if (insertList(arrayList)) {
                startXpUploadSync();
            }
        }
    }

    public void addFavList(List<FavoriteAddress> list) {
        insertFavList(list, 1);
    }

    public void updateFavList(List<FavoriteAddress> list) {
        insertFavList(list, 2);
    }

    public void removeFavList(List<FavoriteAddress> list) {
        insertFavList(list, 3);
    }

    private void insertFavList(List<FavoriteAddress> list, int i) {
        if (CollectionUtils.isNotEmpty(list)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "insertFavList opType = " + i + ", list.size = " + list.size());
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(ObjectConvertor.toFavoriteDataOperation(list.get(i2), i));
            }
            if (insertList(arrayList)) {
                startXpUploadSync();
            }
        }
    }

    public void addOrUpdateFavList(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("addOrUpdateFavList addList.size = ");
            sb.append(list == null ? 0 : list.size());
            sb.append(", updateList.size = ");
            sb.append(list2 == null ? 0 : list2.size());
            L.d(tag, sb.toString());
        }
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(ObjectConvertor.toFavoriteDataOperation(list.get(i), 1));
            }
        }
        if (CollectionUtils.isNotEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(ObjectConvertor.toFavoriteDataOperation(list2.get(i2), 2));
            }
        }
        if (CollectionUtils.isNotEmpty(arrayList) && insertList(arrayList)) {
            startXpUploadSync();
        }
    }

    public void replaceFavorite(List<FavoriteAddress> list, List<FavoriteAddress> list2) {
        if (L.ENABLE) {
            if (CollectionUtils.isNotEmpty(list)) {
                L.Tag tag = TAG;
                L.d(tag, "replaceFavorite addList.size(): " + list.size());
            }
            if (CollectionUtils.isNotEmpty(list2)) {
                L.Tag tag2 = TAG;
                L.d(tag2, "replaceFavorite deleteList.size(): " + list2.size());
            }
        }
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list2)) {
            for (FavoriteAddress favoriteAddress : list2) {
                arrayList.add(ObjectConvertor.toFavoriteDataOperation(favoriteAddress, 3));
            }
        }
        if (CollectionUtils.isNotEmpty(list)) {
            for (FavoriteAddress favoriteAddress2 : list) {
                int favoriteType = favoriteAddress2.getFavoriteType();
                int i = 1;
                if (favoriteType == 2 || favoriteType == 3) {
                    i = 4;
                }
                arrayList.add(ObjectConvertor.toFavoriteDataOperation(favoriteAddress2, i));
            }
        }
        if (CollectionUtils.isNotEmpty(arrayList) && insertList(arrayList)) {
            startXpUploadSync();
        }
    }

    public void clearAllHistoryRecordInfo(List<HistoryRecordInfo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "clearAllHistoryRecordInfo list.size = " + list.size());
            }
            SettingWrapper.setDeletedAllNormalHistoryVersion(SettingWrapper.getLocalVersion());
            AccountManager.getInstance().getAccountSyncSession().startSync(4);
        }
    }

    public void addHistoryRecordInfoList(List<HistoryRecordInfo> list) {
        insertHistoryList(list, 1);
    }

    public void updateHistoryRecordInfoList(List<HistoryRecordInfo> list) {
        insertHistoryList(list, 2);
    }

    public void removeHistoryRecordInfoList(List<HistoryRecordInfo> list) {
        insertHistoryList(list, 3);
    }

    private void insertHistoryList(List<HistoryRecordInfo> list, int i) {
        if (CollectionUtils.isNotEmpty(list)) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "insertHistoryList opType = " + i + ", list.size = " + list.size());
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(ObjectConvertor.toHistoryDataOperation(list.get(i2), i));
            }
            if (insertList(arrayList)) {
                startXpUploadSync();
            }
        }
    }

    public void addOrUpdateHistoryRecordInfoList(List<HistoryRecordInfo> list, List<HistoryRecordInfo> list2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("addOrUpdateHistoryRecordInfoList addList.size = ");
            sb.append(list == null ? 0 : list.size());
            sb.append(", updateList.size = ");
            sb.append(list2 == null ? 0 : list2.size());
            L.d(tag, sb.toString());
        }
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(ObjectConvertor.toHistoryDataOperation(list.get(i), 1));
            }
        }
        if (CollectionUtils.isNotEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(ObjectConvertor.toHistoryDataOperation(list2.get(i2), 2));
            }
        }
        if (CollectionUtils.isNotEmpty(arrayList) && insertList(arrayList)) {
            if (L.ENABLE) {
                L.d(TAG, "addOrUpdateHistoryRecordInfoList sync start");
            }
            startXpUploadSync();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0071, code lost:
        if (r4 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
        if (r4 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation> getIncrementDataOpByType(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            long r1 = com.xiaopeng.montecarlo.navcore.setting.SettingWrapper.getDataSyncRecordTime()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r5.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r6 = "create_time > ?"
            r5.append(r6)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r6 = " and "
            r5.append(r6)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r6 = "data_type = ?"
            r5.append(r6)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r6 = "create_time ASC"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r8 = 0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r9.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r9.append(r0)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r9.append(r1)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r1 = r9.toString()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r7[r8] = r1     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r1 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r2.append(r0)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r2.append(r11)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r11 = r2.toString()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r7[r1] = r11     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            android.database.Cursor r4 = r10.queryIncrementDataOp(r5, r7, r6)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r4 == 0) goto L71
            int r11 = r4.getCount()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r11 <= 0) goto L71
            r4.moveToFirst()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
        L5c:
            boolean r11 = r4.isAfterLast()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r11 != 0) goto L71
            com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation r11 = new com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r11.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r11.bindContentValues(r4)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r3.add(r11)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r4.moveToNext()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            goto L5c
        L71:
            if (r4 == 0) goto L7f
            goto L7c
        L74:
            r11 = move-exception
            goto L80
        L76:
            r11 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r11)     // Catch: java.lang.Throwable -> L74
            if (r4 == 0) goto L7f
        L7c:
            r4.close()
        L7f:
            return r3
        L80:
            if (r4 == 0) goto L85
            r4.close()
        L85:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.IncrementDataHelper.getIncrementDataOpByType(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        return java.lang.System.currentTimeMillis();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long getEarliestCreateTime() {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "create_time ASC"
            android.database.Cursor r0 = r6.queryIncrementDataOp(r0, r0, r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r0 == 0) goto L3e
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r1 <= 0) goto L3e
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord r1 = new com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r1.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r1.bindContentValues(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            com.xiaopeng.montecarlo.root.util.L$Tag r2 = com.xiaopeng.montecarlo.account.sync.IncrementDataHelper.TAG     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String r4 = "getEarliestCreateTime createTime:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            long r4 = r1.getCreateTime()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.append(r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            com.xiaopeng.montecarlo.root.util.L.i(r2, r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            long r1 = r1.getCreateTime()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            if (r0 == 0) goto L4c
            goto L49
        L41:
            r1 = move-exception
            goto L51
        L43:
            r1 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r1)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L4c
        L49:
            r0.close()
        L4c:
            long r0 = java.lang.System.currentTimeMillis()
            return r0
        L51:
            if (r0 == 0) goto L56
            r0.close()
        L56:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.IncrementDataHelper.getEarliestCreateTime():long");
    }

    public long getLastSyncDataTime() {
        long dataSyncRecordTime = SettingWrapper.getDataSyncRecordTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (dataSyncRecordTime > currentTimeMillis) {
            L.Tag tag = TAG;
            L.e(tag, "getIncrementDataOp error recordTime:" + dataSyncRecordTime + ",currentTime" + currentTimeMillis);
            long earliestCreateTime = getEarliestCreateTime() - 1;
            SettingWrapper.setDataSyncRecordTime(earliestCreateTime);
            return earliestCreateTime;
        }
        return dataSyncRecordTime;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (r3 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        if (r3 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<java.lang.String, java.util.List<com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord>> getIncrementDataOp() {
        /*
            r10 = this;
            long r0 = r10.getLastSyncDataTime()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            java.lang.String r4 = "create_time > ?"
            java.lang.String r5 = "create_time ASC"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r7 = 0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r8.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            java.lang.String r9 = ""
            r8.append(r9)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r8.append(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            java.lang.String r0 = r8.toString()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r6[r7] = r0     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            android.database.Cursor r3 = r10.queryIncrementDataOp(r4, r6, r5)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r3 == 0) goto L61
            int r0 = r3.getCount()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r0 <= 0) goto L61
            r3.moveToFirst()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L34:
            boolean r0 = r3.isAfterLast()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r0 != 0) goto L61
            com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord r0 = new com.xiaopeng.montecarlo.navcore.bean.sync.IncrementDataRecord     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r0.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r0.bindContentValues(r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            java.lang.String r1 = r0.getDataId()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r1 != 0) goto L5a
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r1.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            java.lang.String r4 = r0.getDataId()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r2.put(r4, r1)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L5a:
            r1.add(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r3.moveToNext()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            goto L34
        L61:
            if (r3 == 0) goto L6f
            goto L6c
        L64:
            r0 = move-exception
            goto L70
        L66:
            r0 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r0)     // Catch: java.lang.Throwable -> L64
            if (r3 == 0) goto L6f
        L6c:
            r3.close()
        L6f:
            return r2
        L70:
            if (r3 == 0) goto L75
            r3.close()
        L75:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.IncrementDataHelper.getIncrementDataOp():java.util.Map");
    }

    private Cursor queryIncrementDataOp(@Nullable String str, @Nullable String[] strArr, @Nullable String str2) {
        return ContextUtils.getContext().getContentResolver().query(XPINCRE_CONTENT_URI, null, str, strArr, str2);
    }

    public boolean insertIncrementRecords(@NonNull List<IncrementDataRecord> list) {
        return insertList(list);
    }

    private boolean insertList(@NonNull List<IncrementDataRecord> list) {
        ContentResolver contentResolver;
        int size;
        ArrayList<ContentProviderOperation> arrayList;
        if (isThreadInterrupted() || CollectionUtils.isEmpty(list)) {
            return false;
        }
        try {
            contentResolver = ContextUtils.getContext().getContentResolver();
            size = list.size();
            arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (isThreadInterrupted()) {
                    return false;
                }
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(XPINCRE_CONTENT_URI);
                newInsert.withValues(list.get(i).toContentValues());
                if (newInsert == null) {
                    return false;
                }
                arrayList.add(newInsert.build());
            }
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
        }
        if (isThreadInterrupted()) {
            return false;
        }
        return contentResolver.applyBatch(NavFavoriteProvider.AUTHORITY, arrayList).length == size;
    }

    public boolean deleteIncrementDataOperation(long j) {
        ContentResolver contentResolver;
        Uri uri;
        StringBuilder sb;
        if (isThreadInterrupted()) {
            return false;
        }
        try {
            contentResolver = ContextUtils.getContext().getContentResolver();
            uri = XPINCRE_CONTENT_URI;
            sb = new StringBuilder();
            sb.append("");
            sb.append(j);
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
        }
        return contentResolver.delete(uri, "create_time <= ?", new String[]{sb.toString()}) > 0;
    }

    public boolean hasIncrementData() {
        return getIncrementCount() > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r7 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r7 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getIncrementCount() {
        /*
            r8 = this;
            java.lang.String r0 = "count(_id)"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r0 = 0
            r7 = 0
            android.content.Context r1 = com.xiaopeng.montecarlo.root.util.ContextUtils.getContext()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.net.Uri r2 = com.xiaopeng.montecarlo.account.sync.IncrementDataHelper.XPINCRE_CONTENT_URI     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            if (r7 == 0) goto L2e
            int r1 = r7.getCount()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            if (r1 <= 0) goto L2e
            r7.moveToFirst()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            int r0 = r7.getInt(r0)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            if (r7 == 0) goto L2d
            r7.close()
        L2d:
            return r0
        L2e:
            if (r7 == 0) goto L3c
            goto L39
        L31:
            r0 = move-exception
            goto L3d
        L33:
            r1 = move-exception
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r1)     // Catch: java.lang.Throwable -> L31
            if (r7 == 0) goto L3c
        L39:
            r7.close()
        L3c:
            return r0
        L3d:
            if (r7 == 0) goto L42
            r7.close()
        L42:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.account.sync.IncrementDataHelper.getIncrementCount():int");
    }

    private void startXpUploadSync() {
        AccountManager.getInstance().getAccountSyncSession().startSync(2);
    }

    private boolean isThreadInterrupted() {
        IThreadOperation iThreadOperation = this.mIThreadOperation;
        return iThreadOperation != null && iThreadOperation.isThreadInterrupted();
    }

    public void deleteUserData(int i, int i2) {
        if (i > 0) {
            SettingWrapper.setDeletedAllNormalFavVersion(SettingWrapper.getLocalVersion());
        }
        if (i2 > 0) {
            SettingWrapper.setDeletedAllNormalHistoryVersion(SettingWrapper.getLocalVersion());
        }
        AccountManager.getInstance().getAccountSyncSession().startSync(4);
    }
}
