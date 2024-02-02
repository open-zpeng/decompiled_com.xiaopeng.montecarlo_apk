package com.xiaopeng.montecarlo.root.provider.dataset;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public final class GlobalContentProvider extends ContentProvider {
    private static final String DB_NAME = "global";
    private static final int URI_MATCH_CODE_ALL = 2;
    private static final int URI_MATCH_CODE_SET = 0;
    private static final int URI_MATCH_CODE_SET_VALUE = 1;
    @NonNull
    protected DatabaseHelper mDatabaseHelper;
    private static final L.Tag TAG = new L.Tag("GlobalContentProvider");
    @NonNull
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);

    static {
        sUriMatcher.addURI(DataSetHelper.GlobalSet.AUTHORITY, "set", 0);
        sUriMatcher.addURI(DataSetHelper.GlobalSet.AUTHORITY, "set/*", 1);
        sUriMatcher.addURI(DataSetHelper.GlobalSet.AUTHORITY, "all", 2);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            this.mDatabaseHelper = new DatabaseHelper(ContextUtils.getContext(), "global", 0, "-1");
            DataSetHelper.GlobalSet.loadApplicationData(doQuery(StringKeyValueSetTab.TAB_NAME, null, null, null, null, null, null));
            return true;
        } catch (Exception unused) {
            L.w(TAG, "updateDatabaseHelperLocked run time exception !");
            return false;
        }
    }

    private int doDelete(String str, String str2, String[] strArr) {
        DatabaseHelper databaseHelper = this.mDatabaseHelper;
        if (databaseHelper == null) {
            return 0;
        }
        return databaseHelper.getWritableDatabase().delete(str, str2, strArr);
    }

    private long doReplace(String str, String str2, ContentValues contentValues) {
        DatabaseHelper databaseHelper = this.mDatabaseHelper;
        if (databaseHelper == null) {
            return 0L;
        }
        return databaseHelper.getWritableDatabase().replace(str, str2, contentValues);
    }

    private Cursor doQuery(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        DatabaseHelper databaseHelper = this.mDatabaseHelper;
        if (databaseHelper == null) {
            return null;
        }
        return databaseHelper.getWritableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    private int doUpdate(String str, ContentValues contentValues, String str2, String[] strArr) {
        DatabaseHelper databaseHelper = this.mDatabaseHelper;
        if (databaseHelper == null) {
            return 0;
        }
        return databaseHelper.getWritableDatabase().update(str, contentValues, str2, strArr);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        if (sUriMatcher.match(uri) != 1) {
            return 0;
        }
        String lastPathSegment = uri.getLastPathSegment();
        return doDelete(StringKeyValueSetTab.TAB_NAME, "name = '" + lastPathSegment + "'", null);
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        int match = sUriMatcher.match(uri);
        if (match == 0 || match == 1) {
            return "vnd.android.cursor.dir/single";
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        Context context = getContext();
        if (context != null && sUriMatcher.match(uri) == 0) {
            long doReplace = doReplace(StringKeyValueSetTab.TAB_NAME, null, contentValues);
            if (-1 != doReplace) {
                context.getContentResolver().notifyChange(DataSetHelper.GlobalSet.getUriFor(uri, contentValues.getAsString("name")), (ContentObserver) null, false);
                return ContentUris.withAppendedId(uri, doReplace);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (L.ENABLE) {
            L.d(TAG, "query uri:" + uri.toString());
        }
        int match = sUriMatcher.match(uri);
        if (match != 1) {
            if (match != 2) {
                return null;
            }
            return doQuery(StringKeyValueSetTab.TAB_NAME, null, null, null, null, null, null);
        }
        String str3 = "name = '" + uri.getLastPathSegment() + "'";
        if (L.ENABLE) {
            L.d(TAG, "query where:" + str3);
        }
        return doQuery(StringKeyValueSetTab.TAB_NAME, null, str3, null, null, null, null);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @NonNull ContentValues contentValues, String str, String[] strArr) {
        Context context = getContext();
        if (context != null && sUriMatcher.match(uri) == 0) {
            String asString = contentValues.getAsString("name");
            int doUpdate = doUpdate(StringKeyValueSetTab.TAB_NAME, contentValues, "name = '" + asString + "'", null);
            if (-1 != doUpdate) {
                context.getContentResolver().notifyChange(DataSetHelper.GlobalSet.getUriFor(uri, asString), (ContentObserver) null, false);
                return doUpdate;
            }
            return doUpdate;
        }
        return 0;
    }
}
