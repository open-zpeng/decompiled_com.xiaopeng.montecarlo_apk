package com.xiaopeng.montecarlo.navcore.account;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.MapModeUtil;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.provider.dataset.AccountContentProvider;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil;
import com.xiaopeng.montecarlo.root.provider.dataset.StringKeyValueSetTab;
import com.xiaopeng.montecarlo.root.provider.favorite.NavFavoriteProvider;
import com.xiaopeng.montecarlo.root.util.AccountUtil;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class GuestAccountDataManager {
    private static final L.Tag TAG = new L.Tag("Sync_guest_manager");

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r10 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress getGuestHome(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase r10) {
        /*
            r0 = 0
            java.lang.String r4 = "favorite_type = ?"
            java.lang.String r2 = "favoriteaddress"
            r3 = 0
            java.lang.String r1 = "2"
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            r1 = 0
            java.util.List r2 = listFavorites(r10, r1, r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            boolean r3 = com.xiaopeng.montecarlo.root.util.CollectionUtils.isNotEmpty(r2)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            if (r3 == 0) goto L2b
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress r1 = (com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress) r1     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            if (r10 == 0) goto L2a
            r10.close()
        L2a:
            return r1
        L2b:
            if (r10 == 0) goto L42
            goto L3f
        L2e:
            r1 = move-exception
            goto L37
        L30:
            r10 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L44
        L35:
            r1 = move-exception
            r10 = r0
        L37:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r1)     // Catch: java.lang.Throwable -> L43
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r10 == 0) goto L42
        L3f:
            r10.close()
        L42:
            return r0
        L43:
            r0 = move-exception
        L44:
            if (r10 == 0) goto L49
            r10.close()
        L49:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.account.GuestAccountDataManager.getGuestHome(android.database.sqlite.SQLiteDatabase):com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r10 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress getGuestCompany(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase r10) {
        /*
            r0 = 0
            java.lang.String r4 = "favorite_type = ?"
            java.lang.String r2 = "favoriteaddress"
            r3 = 0
            java.lang.String r1 = "3"
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            r1 = 0
            java.util.List r2 = listFavorites(r10, r1, r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            boolean r3 = com.xiaopeng.montecarlo.root.util.CollectionUtils.isNotEmpty(r2)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            if (r3 == 0) goto L2b
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress r1 = (com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress) r1     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            if (r10 == 0) goto L2a
            r10.close()
        L2a:
            return r1
        L2b:
            if (r10 == 0) goto L42
            goto L3f
        L2e:
            r1 = move-exception
            goto L37
        L30:
            r10 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L44
        L35:
            r1 = move-exception
            r10 = r0
        L37:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r1)     // Catch: java.lang.Throwable -> L43
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r10 == 0) goto L42
        L3f:
            r10.close()
        L42:
            return r0
        L43:
            r0 = move-exception
        L44:
            if (r10 == 0) goto L49
            r10.close()
        L49:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.account.GuestAccountDataManager.getGuestCompany(android.database.sqlite.SQLiteDatabase):com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress");
    }

    @Nullable
    protected static List<FavoriteAddress> listGuestNormalFavorites(@NonNull SQLiteDatabase sQLiteDatabase, @Nullable String str, @Nullable String[] strArr, @Nullable String str2) {
        return listGuestFavorites(sQLiteDatabase, concatNormalFavorite(str), strArr, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static java.util.List<com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress> listGuestFavorites(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase r9, @androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.lang.String[] r11, @androidx.annotation.Nullable java.lang.String r12) {
        /*
            r0 = 0
            java.lang.String r2 = "favoriteaddress"
            r3 = 0
            r6 = 0
            r7 = 0
            r1 = r9
            r4 = r10
            r5 = r11
            r8 = r12
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1e
            r10 = 0
            java.util.List r10 = listFavorites(r9, r10, r0)     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2c
            if (r9 == 0) goto L18
            r9.close()
        L18:
            return r10
        L19:
            r10 = move-exception
            goto L20
        L1b:
            r10 = move-exception
            r9 = r0
            goto L2d
        L1e:
            r10 = move-exception
            r9 = r0
        L20:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r10)     // Catch: java.lang.Throwable -> L2c
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto L2b
            r9.close()
        L2b:
            return r0
        L2c:
            r10 = move-exception
        L2d:
            if (r9 == 0) goto L32
            r9.close()
        L32:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.account.GuestAccountDataManager.listGuestFavorites(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String[], java.lang.String):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static java.util.List<com.xiaopeng.montecarlo.navcore.bean.favorite.HistoryRecordInfo> listGuestHistoryRecords(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase r9, @androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.lang.String[] r11, @androidx.annotation.Nullable java.lang.String r12) {
        /*
            r0 = 0
            java.lang.String r2 = "historyrecord"
            r3 = 0
            r6 = 0
            r7 = 0
            r1 = r9
            r4 = r10
            r5 = r11
            r8 = r12
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1e
            r10 = 0
            java.util.List r10 = listHistoryRecords(r9, r10, r0)     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2c
            if (r9 == 0) goto L18
            r9.close()
        L18:
            return r10
        L19:
            r10 = move-exception
            goto L20
        L1b:
            r10 = move-exception
            r9 = r0
            goto L2d
        L1e:
            r10 = move-exception
            r9 = r0
        L20:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r10)     // Catch: java.lang.Throwable -> L2c
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto L2b
            r9.close()
        L2b:
            return r0
        L2c:
            r10 = move-exception
        L2d:
            if (r9 == 0) goto L32
            r9.close()
        L32:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.account.GuestAccountDataManager.listGuestHistoryRecords(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String[], java.lang.String):java.util.List");
    }

    public static List<HistoryRecordInfo> listGuestHistoryRecords(@NonNull SQLiteDatabase sQLiteDatabase) {
        return listGuestHistoryRecords(sQLiteDatabase, null, null, "createtime DESC limit 100");
    }

    @Nullable
    private static List<FavoriteAddress> listFavorites(Cursor cursor, boolean z, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        if (z && xPCoordinate2DDouble == null) {
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FavoriteAddress favoriteAddress = new FavoriteAddress();
            favoriteAddress.bindContentValues(cursor);
            if (z) {
                favoriteAddress.getXPPoiInfo().setDistance(NavCoreUtil.calcuCarLocationDistance(favoriteAddress.getXPPoiInfo(), xPCoordinate2DDouble));
            }
            arrayList.add(favoriteAddress);
            cursor.moveToNext();
        }
        return arrayList;
    }

    @Nullable
    private static List<HistoryRecordInfo> listHistoryRecords(Cursor cursor, boolean z, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        if (z && xPCoordinate2DDouble == null) {
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            HistoryRecordInfo historyRecordInfo = new HistoryRecordInfo();
            historyRecordInfo.bindContentValues(cursor);
            if (z) {
                historyRecordInfo.getXPPoiInfo().setDistance(NavCoreUtil.calcuCarLocationDistance(historyRecordInfo.getXPPoiInfo(), xPCoordinate2DDouble));
            }
            arrayList.add(historyRecordInfo);
            cursor.moveToNext();
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r10 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r10 == null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo getGuestSettingList(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase r10) {
        /*
            java.lang.String r0 = "key_setting_preference"
            r1 = 0
            java.lang.String r5 = "name = ?"
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            java.lang.String r3 = "string_keyvalue_set"
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            if (r10 == 0) goto L3c
            int r2 = r10.getCount()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            if (r2 <= 0) goto L3c
            r10.moveToFirst()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            java.lang.String r2 = "value"
            int r2 = r10.getColumnIndexOrThrow(r2)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo r3 = new com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            r3.<init>()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            r3.setName(r0)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            java.lang.String r0 = r10.getString(r2)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            r3.setValue(r0)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4d
            if (r10 == 0) goto L39
            r10.close()
        L39:
            return r3
        L3a:
            r0 = move-exception
            goto L44
        L3c:
            if (r10 == 0) goto L4c
            goto L49
        L3f:
            r0 = move-exception
            r10 = r1
            goto L4e
        L42:
            r0 = move-exception
            r10 = r1
        L44:
            com.xiaopeng.montecarlo.root.provider.dataset.DatabaseExceptionUtil.handleException(r0)     // Catch: java.lang.Throwable -> L4d
            if (r10 == 0) goto L4c
        L49:
            r10.close()
        L4c:
            return r1
        L4d:
            r0 = move-exception
        L4e:
            if (r10 == 0) goto L53
            r10.close()
        L53:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.account.GuestAccountDataManager.getGuestSettingList(android.database.sqlite.SQLiteDatabase):com.xiaopeng.montecarlo.navcore.bean.sync.AccountSettingInfo");
    }

    private static int clearGuestXpIncrements(SQLiteDatabase sQLiteDatabase) {
        try {
            return sQLiteDatabase.delete(NavFavoriteProvider.TABLE_XP_INCRE, null, null);
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            return 0;
        }
    }

    private static int clearGuestHistoryRecords(SQLiteDatabase sQLiteDatabase) {
        try {
            return sQLiteDatabase.delete(NavFavoriteProvider.TABLE_HISTORY_RECORD, null, null);
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            return 0;
        }
    }

    private static int clearGuestFavorites(SQLiteDatabase sQLiteDatabase) {
        try {
            return sQLiteDatabase.delete(NavFavoriteProvider.TABLE_FAVORITES, null, null);
        } catch (Exception e) {
            DatabaseExceptionUtil.handleException(e);
            return 0;
        }
    }

    private static int clearGuestSettings(SQLiteDatabase sQLiteDatabase) {
        int i;
        int i2 = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", DataSetHelper.AccountSet.KEY_SETTING_PREFERENCE);
            contentValues.put("value", Integer.valueOf(SettingWrapper.getDefaultState()));
            long replace = sQLiteDatabase.replace(StringKeyValueSetTab.TAB_NAME, null, contentValues);
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, " invokeRefreshSettingCallback replace KEY_SETTING_PREFERENCE  id:" + replace);
            }
            i = replace >= 0 ? 1 : 0;
        } catch (Exception e) {
            e = e;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("name", MapModeUtil.getStoreKeyName(false));
            contentValues2.put("value", Integer.valueOf(MapModeUtil.getDefaultMapMode()));
            if (sQLiteDatabase.replace(StringKeyValueSetTab.TAB_NAME, null, contentValues2) >= 0) {
                i++;
            }
            i2 = i;
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("name", MapModeUtil.getStoreKeyName(true));
            contentValues3.put("value", Integer.valueOf(MapModeUtil.getDefaultMapMode()));
            if (sQLiteDatabase.replace(StringKeyValueSetTab.TAB_NAME, null, contentValues3) >= 0) {
                i2++;
            }
            L.Tag tag2 = TAG;
            L.i(tag2, " invokeRefreshSettingCallback start count:" + i2);
            if (i2 > 0) {
                DataSetHelper.AccountSet.clearCache();
            }
        } catch (Exception e2) {
            e = e2;
            i2 = i;
            DatabaseExceptionUtil.handleException(e);
            return i2;
        }
        return i2;
    }

    public static int clearGuestAccountData() {
        if (L.ENABLE) {
            L.d(TAG, "clearGuestAccountData start");
        }
        int i = 0;
        SQLiteDatabase guestFavoriteDatabase = getGuestFavoriteDatabase();
        if (guestFavoriteDatabase != null) {
            i = clearGuestHistoryRecords(guestFavoriteDatabase) + clearGuestFavorites(guestFavoriteDatabase) + 0;
            clearGuestXpIncrements(guestFavoriteDatabase);
            guestFavoriteDatabase.close();
        } else {
            L.i(TAG, "clearGuestAccountData favoriteDb is null");
        }
        SQLiteDatabase guestSettingDatabase = getGuestSettingDatabase();
        if (guestSettingDatabase != null) {
            i += clearGuestSettings(guestSettingDatabase);
            guestSettingDatabase.close();
        } else {
            L.i(TAG, "clearGuestAccountData settingDb is null");
        }
        if (L.ENABLE) {
            L.d(TAG, "clearGuestAccountData finish");
        }
        return i;
    }

    private static String concatNormalFavorite(String str) {
        if (TextUtils.isEmpty(str)) {
            return "favorite_type = 1";
        }
        return "favorite_type = 1 and " + str;
    }

    public static SQLiteDatabase getGuestFavoriteDatabase() {
        String guestFavoriteDatabasePath = getGuestFavoriteDatabasePath();
        if (TextUtils.isEmpty(guestFavoriteDatabasePath)) {
            L.i(TAG, "getGuestFavoriteDatabase isEmpty");
            return null;
        }
        return SQLiteDatabase.openDatabase(guestFavoriteDatabasePath, null, 1);
    }

    public static SQLiteDatabase getGuestSettingDatabase() {
        String guestSettingDatabasePath = getGuestSettingDatabasePath();
        if (TextUtils.isEmpty(guestSettingDatabasePath)) {
            L.i(TAG, "getGuestSettingDatabasePath isEmpty");
            return null;
        }
        return SQLiteDatabase.openDatabase(guestSettingDatabasePath, null, 1);
    }

    private static String getGuestFavoriteDatabasePath() {
        File databasePath = ContextUtils.getContext().getDatabasePath(AccountUtil.getFavoriteDatabaseNameForUserId(AccountObservable.getType(UserInfo.UserType.TEMP), "-1", "favorite", NavFavoriteProvider.DATABASE_NAME_SUFFIX));
        if (databasePath.exists()) {
            return databasePath.getAbsolutePath();
        }
        L.i(TAG, "getGuestFavoriteDatabasePath null");
        return null;
    }

    private static String getGuestSettingDatabasePath() {
        File databasePath = ContextUtils.getContext().getDatabasePath(AccountUtil.getLocalDatabaseNameForUser(AccountObservable.getType(UserInfo.UserType.TEMP), "-1", AccountContentProvider.DB_NAME));
        if (databasePath.exists()) {
            return databasePath.getAbsolutePath();
        }
        L.i(TAG, "getGuestSettingDatabasePath null");
        return null;
    }

    @Nullable
    protected static List<FavoriteAddress> listGuestNormalFavorites(@NonNull SQLiteDatabase sQLiteDatabase) {
        return listGuestFavorites(sQLiteDatabase, concatNormalFavorite(null), null, "bl_createtime DESC limit 100");
    }
}
