package com.xiaopeng.montecarlo.root.provider.favorite;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.AccountUtil;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NavFavoriteProvider extends ContentProvider {
    public static final String AUTHORITY = "com.xiaopeng.montecarlo.favorites";
    private static final int CONTENT_FAVORITE_DIR = 101;
    private static final int CONTENT_FAVORITE_ITEM = 102;
    private static final int CONTENT_FAVORITE_TEXT_ITEM = 105;
    private static final int CONTENT_HISTORICAL_DIR = 103;
    private static final int CONTENT_HISTORICAL_ITEM = 104;
    private static final int CONTENT_HISTORICAL_TEXT_ITEM = 106;
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/com.xiaopeng.montecarlo.favorites";
    public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/com.xiaopeng.montecarlo.navcore.favorite";
    private static final int CONTENT_XP_INCRE_DIR = 109;
    private static final int CONTENT_XP_INCRE_ITEM = 110;
    public static final String DATABASE_NAME_PREFIX = "favorite";
    public static final String DATABASE_NAME_SUFFIX = ".db";
    public static final String LIMIT_ARG = "limit";
    public static final String LIMIT_OFFSET_SEPARATE = ",";
    public static final String RAW_SQL_ARG = "raw?";
    public static final String TABLE_FAVORITES = "favoriteaddress";
    public static final String TABLE_HISTORY = "historicaldest";
    public static final String TABLE_HISTORY_RECORD = "historyrecord";
    public static final String TABLE_KEYWORD = "historicalkeyword";
    public static final String TABLE_XP_INCRE = "xpincrement";
    @Nullable
    private DatabaseHelper mOpenHelper;
    public static final Uri FAVORITE_CONTENT_URI = Uri.parse("content://com.xiaopeng.montecarlo.favorites/favorite");
    public static final Uri FAVORITE_DELETE_URI = Uri.parse("content://com.xiaopeng.montecarlo.favorites/favorite/delete");
    public static final Uri HISTORY_CONTENT_URI = Uri.parse("content://com.xiaopeng.montecarlo.favorites/history");
    public static final Uri HISTORY_DELETE_URI = Uri.parse("content://com.xiaopeng.montecarlo.favorites/history/delete");
    public static final Uri XPINCRE_CONTENT_URI = Uri.parse("content://com.xiaopeng.montecarlo.favorites/xpincre");
    private static final L.Tag TAG = new L.Tag("NavFavoriteProvider");
    @NonNull
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);

    static {
        sUriMatcher.addURI(AUTHORITY, "favorite", 101);
        sUriMatcher.addURI(AUTHORITY, "favorite/#", 102);
        sUriMatcher.addURI(AUTHORITY, "favorite/*", 105);
        sUriMatcher.addURI(AUTHORITY, SearchBridge.POI_FROM_HISTORY, 103);
        sUriMatcher.addURI(AUTHORITY, "history/#", 104);
        sUriMatcher.addURI(AUTHORITY, "history/*", 106);
        sUriMatcher.addURI(AUTHORITY, "xpincre", 109);
        sUriMatcher.addURI(AUTHORITY, "xpincre/#", 110);
    }

    @Override // android.content.ContentProvider
    public synchronized boolean onCreate() {
        try {
            Context context = ContextUtils.getContext();
            int userHandle = AccountObservable.getInstance().getUserHandle();
            String userId = AccountObservable.getInstance().getUserId();
            renameDatabase(context, userHandle, userId);
            String favoriteDatabaseNameForUserId = AccountUtil.getFavoriteDatabaseNameForUserId(userHandle, userId, "favorite", DATABASE_NAME_SUFFIX);
            if (this.mOpenHelper == null) {
                this.mOpenHelper = new DatabaseHelper(context, favoriteDatabaseNameForUserId, userHandle, userId);
            }
            if (this.mOpenHelper.getUserHandle() != userHandle || !userId.equals(this.mOpenHelper.getUserId())) {
                try {
                    this.mOpenHelper.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mOpenHelper = new DatabaseHelper(context, favoriteDatabaseNameForUserId, userHandle, userId);
            }
            this.mOpenHelper.close();
        } catch (Exception unused) {
            L.w(TAG, "updateDatabaseHelper run time exception !");
            return false;
        }
        return true;
    }

    private void renameDatabase(Context context, int i, String str) {
        L.Tag tag = TAG;
        L.i(tag, "renameDatabase userHandle = " + i + ", userId = " + str);
        if (i == AccountObservable.getType(UserInfo.UserType.TEMP)) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "renameDatabase start time = " + System.currentTimeMillis());
        }
        File databasePath = context.getDatabasePath(AccountUtil.getFavoriteDatabaseNameForUserId(i, str, "favorite", DATABASE_NAME_SUFFIX));
        if (!databasePath.exists()) {
            L.i(TAG, "renameDatabase userid is not exist");
            String favoriteDatabaseNameForUser = AccountUtil.getFavoriteDatabaseNameForUser(i, str, "favorite", DATABASE_NAME_SUFFIX);
            File databasePath2 = context.getDatabasePath(favoriteDatabaseNameForUser);
            if (databasePath2.exists()) {
                L.i(TAG, "renameDatabase userhandle is exist");
                databasePath2.renameTo(databasePath);
            }
            String databaseJournalSuffixName = AccountUtil.getDatabaseJournalSuffixName(favoriteDatabaseNameForUser);
            if (databaseJournalSuffixName != null) {
                File databasePath3 = context.getDatabasePath(databaseJournalSuffixName);
                if (databasePath3.exists() && databasePath3.isFile()) {
                    databasePath3.delete();
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag3 = TAG;
            L.d(tag3, "renameDatabase end time = " + System.currentTimeMillis());
        }
    }

    @Override // android.content.ContentProvider
    public synchronized String getType(Uri uri) {
        int match = sUriMatcher.match(uri);
        if (match != 109) {
            if (match != 110) {
                switch (match) {
                    case 101:
                    case 103:
                        break;
                    case 102:
                    case 104:
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown URI " + uri);
                }
            }
            return CONTENT_TYPE_ITEM;
        }
        return CONTENT_TYPE;
    }

    @Override // android.content.ContentProvider
    public synchronized Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        String str4;
        String str5;
        if (checkDataBaseHelperValid()) {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            switch (sUriMatcher.match(uri)) {
                case 101:
                    return writableDatabase.query(TABLE_FAVORITES, strArr, str, strArr2, null, null, str2);
                case 102:
                    long parseId = ContentUris.parseId(uri);
                    if (TextUtils.isEmpty(str)) {
                        str3 = "";
                    } else {
                        str3 = "_id = " + parseId + " and (" + str + ")";
                    }
                    return writableDatabase.query(TABLE_FAVORITES, strArr, str3, strArr2, null, null, str2);
                case 103:
                    return writableDatabase.query(TABLE_HISTORY_RECORD, strArr, str, strArr2, null, null, str2);
                case 104:
                    long parseId2 = ContentUris.parseId(uri);
                    if (TextUtils.isEmpty(str)) {
                        str4 = "";
                    } else {
                        str4 = "_id = " + parseId2 + " and (" + str + ")";
                    }
                    return writableDatabase.query(TABLE_HISTORY_RECORD, strArr, str4, strArr2, null, null, str2);
                case 105:
                    int[] parseLimitArgs = parseLimitArgs(uri);
                    if (parseLimitArgs[0] > 0) {
                        return writableDatabase.query(TABLE_FAVORITES, strArr, str, strArr2, null, null, str2, "" + (parseLimitArgs[1] >= 0 ? parseLimitArgs[1] : 0) + "," + parseLimitArgs[0]);
                    }
                    break;
                case 106:
                    if (parseRawQuery(uri)) {
                        return writableDatabase.rawQuery(str, null);
                    }
                    int[] parseLimitArgs2 = parseLimitArgs(uri);
                    if (parseLimitArgs2[0] > 0) {
                        return writableDatabase.query(TABLE_HISTORY_RECORD, strArr, str, strArr2, null, null, str2, "" + (parseLimitArgs2[1] >= 0 ? parseLimitArgs2[1] : 0) + "," + parseLimitArgs2[0]);
                    }
                    break;
                case 107:
                case 108:
                default:
                    new IllegalArgumentException("Unknown URI " + uri).printStackTrace();
                    break;
                case 109:
                    return writableDatabase.query(TABLE_XP_INCRE, strArr, str, strArr2, null, null, str2);
                case 110:
                    long parseId3 = ContentUris.parseId(uri);
                    if (TextUtils.isEmpty(str)) {
                        str5 = "";
                    } else {
                        str5 = "_id = " + parseId3 + " and (" + str + ")";
                    }
                    return writableDatabase.query(TABLE_XP_INCRE, strArr, str5, strArr2, null, null, str2);
            }
            return null;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public synchronized Uri insert(Uri uri, ContentValues contentValues) {
        if (checkDataBaseHelperValid()) {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            int match = sUriMatcher.match(uri);
            if (match == 109) {
                long insert = writableDatabase.insert(TABLE_XP_INCRE, null, contentValues);
                if (insert <= 0) {
                    return null;
                }
                return ContentUris.withAppendedId(uri, insert);
            } else if (match != 110) {
                switch (match) {
                    case 101:
                        long insert2 = writableDatabase.insert(TABLE_FAVORITES, null, contentValues);
                        if (insert2 <= 0) {
                            return null;
                        }
                        return ContentUris.withAppendedId(uri, insert2);
                    case 102:
                        return null;
                    case 103:
                        long insert3 = writableDatabase.insert(TABLE_HISTORY_RECORD, null, contentValues);
                        if (insert3 <= 0) {
                            return null;
                        }
                        return ContentUris.withAppendedId(uri, insert3);
                    case 104:
                        return null;
                    default:
                        new IllegalArgumentException("Unknown URI " + uri).printStackTrace();
                        return null;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public synchronized int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        if (checkDataBaseHelperValid()) {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            int match = sUriMatcher.match(uri);
            if (match != 109) {
                if (match != 110) {
                    switch (match) {
                        case 101:
                            for (ContentValues contentValues : contentValuesArr) {
                                if (writableDatabase.insert(TABLE_FAVORITES, null, contentValues) < 0) {
                                    writableDatabase.endTransaction();
                                    return 0;
                                }
                            }
                            break;
                        case 102:
                            writableDatabase.endTransaction();
                            return 0;
                        case 103:
                            for (ContentValues contentValues2 : contentValuesArr) {
                                if (writableDatabase.insert(TABLE_HISTORY_RECORD, null, contentValues2) < 0) {
                                    writableDatabase.endTransaction();
                                    return 0;
                                }
                            }
                            break;
                        case 104:
                            writableDatabase.endTransaction();
                            return 0;
                        default:
                            new IllegalArgumentException("Unknown URI " + uri).printStackTrace();
                            break;
                    }
                } else {
                    writableDatabase.endTransaction();
                    return 0;
                }
            } else {
                for (ContentValues contentValues3 : contentValuesArr) {
                    if (writableDatabase.insert(TABLE_XP_INCRE, null, contentValues3) < 0) {
                        writableDatabase.endTransaction();
                        return 0;
                    }
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return contentValuesArr.length;
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    @NonNull
    public synchronized ContentProviderResult[] applyBatch(@NonNull ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        if (!checkDataBaseHelperValid()) {
            return new ContentProviderResult[0];
        }
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        return applyBatch;
    }

    @Override // android.content.ContentProvider
    public synchronized int delete(Uri uri, String str, @Nullable String[] strArr) {
        if (checkDataBaseHelperValid()) {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            int match = sUriMatcher.match(uri);
            if (match == 109) {
                return writableDatabase.delete(TABLE_XP_INCRE, str, strArr);
            } else if (match != 110) {
                switch (match) {
                    case 101:
                        return writableDatabase.delete(TABLE_FAVORITES, str, strArr);
                    case 102:
                        String str2 = "_id = " + ContentUris.parseId(uri);
                        if (!TextUtils.isEmpty(str)) {
                            str2 = str2 + " and (" + str + ")";
                        }
                        return writableDatabase.delete(TABLE_FAVORITES, str2, strArr);
                    case 103:
                        return writableDatabase.delete(TABLE_HISTORY_RECORD, str, strArr);
                    case 104:
                        String str3 = "_id = " + ContentUris.parseId(uri);
                        if (!TextUtils.isEmpty(str)) {
                            str3 = str3 + " and (" + str + ")";
                        }
                        return writableDatabase.delete(TABLE_HISTORY_RECORD, str3, strArr);
                    default:
                        new IllegalArgumentException("Unknown URI " + uri).printStackTrace();
                        return 0;
                }
            } else {
                String str4 = "_id = " + ContentUris.parseId(uri);
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + " and (" + str + ")";
                }
                return writableDatabase.delete(TABLE_XP_INCRE, str4, strArr);
            }
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    public synchronized int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (checkDataBaseHelperValid()) {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            int match = sUriMatcher.match(uri);
            if (match == 109) {
                return writableDatabase.update(TABLE_XP_INCRE, contentValues, str, strArr);
            } else if (match != 110) {
                switch (match) {
                    case 101:
                        return writableDatabase.update(TABLE_FAVORITES, contentValues, str, strArr);
                    case 102:
                        long parseId = ContentUris.parseId(uri);
                        sb.append("_id = " + parseId);
                        if (!TextUtils.isEmpty(str)) {
                            sb.append(" and (" + str + ")");
                        }
                        return writableDatabase.update(TABLE_FAVORITES, contentValues, sb.toString(), strArr);
                    case 103:
                        return writableDatabase.update(TABLE_HISTORY_RECORD, contentValues, str, strArr);
                    case 104:
                        long parseId2 = ContentUris.parseId(uri);
                        sb.append("_id = " + parseId2);
                        if (!TextUtils.isEmpty(str)) {
                            sb.append(" and (" + str + ")");
                        }
                        return writableDatabase.update(TABLE_HISTORY_RECORD, contentValues, sb.toString(), strArr);
                    default:
                        new IllegalArgumentException("Unknown URI " + uri).printStackTrace();
                        return 0;
                }
            } else {
                long parseId3 = ContentUris.parseId(uri);
                sb.append("_id = " + parseId3);
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" and (" + str + ")");
                }
                return writableDatabase.update(TABLE_XP_INCRE, contentValues, sb.toString(), strArr);
            }
        }
        return -1;
    }

    private boolean checkDataBaseHelperValid() {
        if (this.mOpenHelper == null) {
            L.e(TAG, "NavFavoriteProvider mOpenHelper is null, please make sure database has been created !");
            return false;
        }
        return true;
    }

    private int[] parseLimitArgs(Uri uri) {
        int[] iArr = new int[2];
        String lastPathSegment = uri.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.startsWith(LIMIT_ARG)) {
            String[] split = lastPathSegment.substring(5).split(",");
            if (split.length == 2) {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                return iArr;
            }
        }
        iArr[0] = 0;
        iArr[1] = 0;
        return iArr;
    }

    private boolean parseRawQuery(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return !TextUtils.isEmpty(lastPathSegment) && lastPathSegment.startsWith(RAW_SQL_ARG);
    }

    /* loaded from: classes3.dex */
    public static final class FavoriteColumns implements BaseColumns {
        public static final String ADCODE = "adcode";
        public static final String ADDRESS = "address";
        public static final String BL_CLASSIFICATION = "bl_classification";
        public static final String BL_CREATETIME = "bl_createtime";
        public static final String BL_CUSTOMNAME = "bl_customname";
        public static final String BL_ITEM_ID = "bl_item_id";
        public static final String BL_NEWTYPE = "bl_newtype";
        public static final String BL_POITYPE = "bl_poitype";
        public static final String BL_TOPTIME = "bl_toptime";
        public static final String BL_TYPE = "bl_type";
        public static final String BL_VERSION = "bl_version";
        public static final String CATEGORY = "category";
        public static final String CHILD_POIS_JSON = "child_pois_json";
        public static final String CITYCODE = "citycode";
        public static final String CITYNAME = "cityname";
        public static final String DATA_VERSION = "data_version";
        public static final String DISTRICTNAME = "districtname";
        public static final String FAVORITE_TYPE = "favorite_type";
        public static final String HAS_CHILD_POIS = "has_child_pois";
        public static final String HAS_PARK_POIS = "has_park_pois";
        public static final String ICONTYPE = "icontype";
        public static final String ICONURL = "iconurl";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String NAME = "name";
        public static final String NAVILAT = "naviLat";
        public static final String NAVILON = "naviLon";
        public static final String OFFLINE = "offline";
        public static final String OPENTIME = "opentime";
        public static final String OVERHEAD = "overhead";
        public static final String PARENTID = "parentid";
        public static final String PARENTNAME = "parentname";
        public static final String PARENT_SIMPLE_NAME = "parent_simple_name";
        public static final String PHONENUMBERS = "phonenumbers";
        public static final String POIID = "poiid";
        public static final String POI_SOURCE = "poi_source";
        public static final String PRICE = "price";
        public static final String PROVINCENAME = "provincename";
        public static final String RESERVE_A = "reserve_a";
        public static final String RESERVE_B = "reserve_b";
        public static final String RESERVE_C = "reserve_c";
        public static final String TAG = "tag";
        public static final String TYPE = "type";
        public static final String TYPECODE = "typecode";

        static void upgradeToVersion6(@NonNull SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from favoriteaddress limit 1", null);
            if (rawQuery != null) {
                int columnIndex = rawQuery.getColumnIndex("data_version");
                rawQuery.close();
                if (columnIndex >= 0) {
                    L.i(NavFavoriteProvider.TAG, "FavoriteColumns upgradeToVersion6 DATA_VERSION column is exist");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE favoriteaddress ADD COLUMN data_version LONG DEFAULT 0");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class HistoryColumns implements BaseColumns {
        public static final String ADCODE = "adcode";
        public static final String ADDRESS = "address";
        public static final String CATEGORY = "category";
        public static final String CHILD_POIS_JSON = "child_pois_json";
        public static final String CITYCODE = "citycode";
        public static final String CITYNAME = "cityname";
        public static final String CREATETIME = "createtime";
        public static final String DATA_VERSION = "data_version";
        public static final String DISTRICTNAME = "districtname";
        public static final String HAS_CHILD_POIS = "has_child_pois";
        public static final String HAS_PARK_POIS = "has_park_pois";
        public static final String HISTORY_TYPE = "history_type";
        public static final String ICONTYPE = "icontype";
        public static final String ICONURL = "iconurl";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String NAME = "name";
        public static final String NAVILAT = "naviLat";
        public static final String NAVILON = "naviLon";
        public static final String OFFLINE = "offline";
        public static final String OPENTIME = "opentime";
        public static final String OVERHEAD = "overhead";
        public static final String PARENTID = "parentid";
        public static final String PARENTNAME = "parentname";
        public static final String PARENT_SIMPLE_NAME = "parent_simple_name";
        public static final String PATH_VIAS = "path_vias";
        public static final String PHONENUMBERS = "phonenumbers";
        public static final String POIID = "poiid";
        public static final String POI_SOURCE = "poi_source";
        public static final String PRICE = "price";
        public static final String PROVINCENAME = "provincename";
        public static final String RESERVE_A = "reserve_a";
        public static final String RESERVE_B = "reserve_b";
        public static final String RESERVE_C = "reserve_c";
        public static final String TAG = "tag";
        public static final String TYPE = "type";
        public static final String TYPECODE = "typecode";
        public static final String UPDATE_COUNT = "update_count";

        static void executeHistoryPathSql(@NonNull SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from historyrecord limit 1", null);
            if (rawQuery != null) {
                int columnIndex = rawQuery.getColumnIndex(PATH_VIAS);
                rawQuery.close();
                if (columnIndex >= 0) {
                    L.i(NavFavoriteProvider.TAG, "HistoryColumns executeHistoryPathSql PATH_VIAS column is exist");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE historyrecord ADD COLUMN path_vias TEXT DEFAULT NULL");
                }
            }
        }

        static void upgradeToVersion6(@NonNull SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from historyrecord limit 1", null);
            if (rawQuery != null) {
                int columnIndex = rawQuery.getColumnIndex("data_version");
                rawQuery.close();
                if (columnIndex >= 0) {
                    L.i(NavFavoriteProvider.TAG, "HistoryColumns upgradeToVersion6 DATA_VERSION column is exist");
                    return;
                }
                sQLiteDatabase.execSQL("ALTER TABLE historyrecord ADD COLUMN data_version LONG DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE historyrecord ADD COLUMN update_count INTEGER DEFAULT 0");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class IncrementColumns implements BaseColumns {
        public static final String CREATE_TIME = "create_time";
        public static final String DATA_CONTENT = "data_content";
        public static final String DATA_ID = "data_id";
        public static final String DATA_TYPE = "data_type";
        public static final String FAVORITE_TYPE = "favorite_type";
        public static final String HISTORY_TYPE = "history_type";
        public static final String OP_TYPE = "op_type";
        public static final String PRE_VERSION = "pre_version";
        public static final String RESERVE_A = "reserve_a";
        public static final String RESERVE_B = "reserve_b";
        public static final String RESERVE_C = "reserve_c";
        public static final String UPDATE_TIME = "update_time";
        public static final String VERSION = "version";

        static String createXPSqlString() {
            return createSqlString(NavFavoriteProvider.TABLE_XP_INCRE);
        }

        private static String createSqlString(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE IF NOT EXISTS " + str + " (");
            sb.append("_id INTEGER PRIMARY KEY AUTOINCREMENT,");
            sb.append("data_id TEXT NOT NULL,");
            sb.append("data_type INTEGER,");
            sb.append("data_content TEXT,");
            sb.append("op_type INTEGER,");
            sb.append("version INTEGER,");
            sb.append("pre_version INTEGER,");
            sb.append("create_time TEXT,");
            sb.append("update_time TEXT,");
            sb.append("history_type INTEGER,");
            sb.append("favorite_type INTEGER,");
            sb.append("reserve_a TEXT,");
            sb.append("reserve_b TEXT,");
            sb.append("reserve_c TEXT");
            sb.append(");");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DatabaseHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 6;
        private final int mUserHandle;
        private final String mUserId;

        DatabaseHelper(Context context, String str, int i, String str2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 6);
            this.mUserHandle = i;
            this.mUserId = str2;
        }

        public int getUserHandle() {
            return this.mUserHandle;
        }

        public String getUserId() {
            return this.mUserId;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(@NonNull SQLiteDatabase sQLiteDatabase) {
            L.i(NavFavoriteProvider.TAG, "DatabaseHelper onCreate() create all tables");
            sQLiteDatabase.execSQL("CREATE TABLE favoriteaddress (_id INTEGER PRIMARY KEY AUTOINCREMENT,longitude TEXT NOT NULL,latitude TEXT NOT NULL,naviLon TEXT,naviLat TEXT,poiid TEXT,cityname TEXT,citycode TEXT,phonenumbers TEXT,tag TEXT,opentime TEXT,price TEXT,name TEXT,type TEXT,category TEXT,address TEXT,favorite_type INTEGER,has_child_pois INTEGER,child_pois_json TEXT,offline INTEGER,adcode TEXT,provincename TEXT,districtname TEXT,icontype TEXT,iconurl TEXT,parentid TEXT,parentname TEXT,parent_simple_name TEXT,typecode TEXT,overhead TEXT,has_park_pois INTEGER,poi_source INTEGER,reserve_a TEXT,reserve_b TEXT,reserve_c TEXT,bl_item_id TEXT,bl_type TEXT,bl_newtype TEXT,bl_customname TEXT,bl_classification TEXT,bl_poitype TEXT,bl_createtime TEXT,bl_toptime TEXT,bl_version TEXT,data_version LONG);");
            sQLiteDatabase.execSQL("CREATE TABLE historyrecord (_id INTEGER PRIMARY KEY AUTOINCREMENT,longitude TEXT NOT NULL,latitude TEXT NOT NULL,naviLon TEXT,naviLat TEXT,poiid TEXT,cityname TEXT,citycode TEXT,phonenumbers TEXT,tag TEXT,opentime TEXT,price TEXT,name TEXT,type TEXT,category TEXT,address TEXT,has_child_pois INTEGER,child_pois_json TEXT,offline INTEGER,adcode TEXT,provincename TEXT,districtname TEXT,icontype TEXT,iconurl TEXT,parentid TEXT,parentname TEXT,parent_simple_name TEXT,typecode TEXT,overhead TEXT,has_park_pois INTEGER,createtime TEXT,history_type INTEGER,poi_source INTEGER,reserve_a TEXT,reserve_b TEXT,reserve_c TEXT,path_vias TEXT DEFAULT NULL,data_version LONG,update_count INTEGER);");
            sQLiteDatabase.execSQL(IncrementColumns.createXPSqlString());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (L.ENABLE) {
                L.Tag tag = NavFavoriteProvider.TAG;
                L.d(tag, "onUpgrade triggered oldVersion:" + i + " newVersion:" + i2);
            }
            if (i != 6) {
                if (i < 4 && i2 >= 4) {
                    L.w(NavFavoriteProvider.TAG, "create bl and xp increment tables");
                    sQLiteDatabase.execSQL(IncrementColumns.createXPSqlString());
                }
                if (i < 5 && i2 >= 5) {
                    L.w(NavFavoriteProvider.TAG, "alter add column for history path");
                    HistoryColumns.executeHistoryPathSql(sQLiteDatabase);
                }
                if (i >= 6 || i2 < 6) {
                    return;
                }
                HistoryColumns.upgradeToVersion6(sQLiteDatabase);
                FavoriteColumns.upgradeToVersion6(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            L.Tag tag = NavFavoriteProvider.TAG;
            L.w(tag, "onDowngrade oldVersion:" + i + ", newVersion:" + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS favoriteaddress");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS historicaldest");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS historicalkeyword");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS historyrecord");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS xpincrement");
            onCreate(sQLiteDatabase);
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_DATA_SYNC_LOCAL_VERSION, 0);
        }
    }
}
