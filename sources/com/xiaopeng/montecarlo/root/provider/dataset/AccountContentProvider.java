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
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.account.AccountObservable;
import com.xiaopeng.montecarlo.root.account.UserInfo;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.AccountUtil;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
/* loaded from: classes3.dex */
public class AccountContentProvider extends ContentProvider {
    public static final String DB_NAME = "local";
    private static final int URI_MATCH_CODE_ALL = 2;
    private static final int URI_MATCH_CODE_SET = 0;
    private static final int URI_MATCH_CODE_SET_VALUE = 1;
    @Nullable
    protected DatabaseHelper mDatabaseHelperLocked;
    private static final L.Tag TAG = new L.Tag("AccountContentProvider");
    @NonNull
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);

    static {
        sUriMatcher.addURI(DataSetHelper.AccountSet.AUTHORITY, "set", 0);
        sUriMatcher.addURI(DataSetHelper.AccountSet.AUTHORITY, "set/*", 1);
        sUriMatcher.addURI(DataSetHelper.AccountSet.AUTHORITY, "all", 2);
    }

    @Override // android.content.ContentProvider
    public synchronized boolean onCreate() {
        try {
            Context context = ContextUtils.getContext();
            int userHandle = AccountObservable.getInstance().getUserHandle();
            String userId = AccountObservable.getInstance().getUserId();
            renameDatabase(context, userHandle, userId);
            String localDatabaseNameForUserId = AccountUtil.getLocalDatabaseNameForUserId(userHandle, userId, DB_NAME);
            if (this.mDatabaseHelperLocked == null) {
                this.mDatabaseHelperLocked = new DatabaseHelper(context, localDatabaseNameForUserId, userHandle, userId);
            }
            if (this.mDatabaseHelperLocked.getUserHandle() != userHandle || this.mDatabaseHelperLocked.getUserId() != userId) {
                try {
                    this.mDatabaseHelperLocked.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mDatabaseHelperLocked = new DatabaseHelper(context, localDatabaseNameForUserId, userHandle, userId);
            }
            L.Tag tag = TAG;
            L.i(tag, "onCreate switch to userHandle:" + userHandle + " userId:" + userId + "  db:" + localDatabaseNameForUserId);
            DataSetHelper.AccountSet.loadUserData(doQueryLocked(StringKeyValueSetTab.TAB_NAME, null, null, null, null, null, null));
        } catch (Exception unused) {
            L.w(TAG, "updateDatabaseHelperLocked run time exception !");
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
        File databasePath = context.getDatabasePath(AccountUtil.getLocalDatabaseNameForUserId(i, str, DB_NAME));
        if (!databasePath.exists()) {
            L.i(TAG, "renameDatabase userid is not exist");
            String localDatabaseNameForUser = AccountUtil.getLocalDatabaseNameForUser(i, str, DB_NAME);
            File databasePath2 = context.getDatabasePath(localDatabaseNameForUser);
            if (databasePath2.exists()) {
                L.i(TAG, "renameDatabase userhandle is exist");
                databasePath2.renameTo(databasePath);
            }
            String databaseJournalSuffixName = AccountUtil.getDatabaseJournalSuffixName(localDatabaseNameForUser);
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

    private int doDeleteLocked(String str, String str2, String[] strArr) {
        if (checkDataBaseHelperValid()) {
            return this.mDatabaseHelperLocked.getWritableDatabase().delete(str, str2, strArr);
        }
        return -1;
    }

    private long doReplaceLocked(String str, String str2, ContentValues contentValues) {
        if (checkDataBaseHelperValid()) {
            return this.mDatabaseHelperLocked.getWritableDatabase().replace(str, str2, contentValues);
        }
        return -1L;
    }

    private Cursor doQueryLocked(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (checkDataBaseHelperValid()) {
            return this.mDatabaseHelperLocked.getWritableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
        }
        return null;
    }

    private int doUpdateLocked(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (checkDataBaseHelperValid()) {
            return this.mDatabaseHelperLocked.getWritableDatabase().update(str, contentValues, str2, strArr);
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    public synchronized int delete(@NonNull Uri uri, String str, String[] strArr) {
        int i;
        i = 0;
        if (sUriMatcher.match(uri) == 1) {
            String lastPathSegment = uri.getLastPathSegment();
            i = doDeleteLocked(StringKeyValueSetTab.TAB_NAME, "name = '" + lastPathSegment + "'", null);
        }
        return i;
    }

    @Override // android.content.ContentProvider
    public synchronized String getType(@NonNull Uri uri) {
        int match = sUriMatcher.match(uri);
        if (match == 0 || match == 1) {
            return "vnd.android.cursor.dir/single";
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public synchronized Uri insert(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        if (sUriMatcher.match(uri) == 0) {
            long doReplaceLocked = doReplaceLocked(StringKeyValueSetTab.TAB_NAME, null, contentValues);
            if (-1 != doReplaceLocked) {
                context.getContentResolver().notifyChange(DataSetHelper.AccountSet.getUriFor(uri, contentValues.getAsString("name")), (ContentObserver) null, false);
                return ContentUris.withAppendedId(uri, doReplaceLocked);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public synchronized Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        cursor = null;
        if (L.ENABLE) {
            L.d(TAG, "query uri:" + uri.toString());
        }
        int match = sUriMatcher.match(uri);
        if (match == 1) {
            String str3 = "name = '" + uri.getLastPathSegment() + "'";
            if (L.ENABLE) {
                L.d(TAG, "query where:" + str3);
            }
            cursor = doQueryLocked(StringKeyValueSetTab.TAB_NAME, null, str3, null, null, null, null);
        } else if (match == 2) {
            cursor = doQueryLocked(StringKeyValueSetTab.TAB_NAME, null, null, null, null, null, null);
        }
        return cursor;
    }

    @Override // android.content.ContentProvider
    public synchronized int update(@NonNull Uri uri, @NonNull ContentValues contentValues, String str, String[] strArr) {
        int doUpdateLocked;
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        if (sUriMatcher.match(uri) != 0) {
            doUpdateLocked = 0;
        } else {
            String asString = contentValues.getAsString("name");
            doUpdateLocked = doUpdateLocked(StringKeyValueSetTab.TAB_NAME, contentValues, "name = '" + asString + "'", null);
            if (-1 != doUpdateLocked) {
                context.getContentResolver().notifyChange(DataSetHelper.AccountSet.getUriFor(uri, asString), (ContentObserver) null, false);
            }
        }
        return doUpdateLocked;
    }

    private boolean checkDataBaseHelperValid() {
        if (this.mDatabaseHelperLocked == null) {
            L.e(TAG, "AccountContentProvider mOpenHelper is null, please make sure database has been created !");
            return false;
        }
        return true;
    }
}
