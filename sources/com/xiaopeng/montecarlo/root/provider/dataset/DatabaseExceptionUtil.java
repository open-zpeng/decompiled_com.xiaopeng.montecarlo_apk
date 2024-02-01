package com.xiaopeng.montecarlo.root.provider.dataset;

import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDatatypeMismatchException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteMisuseException;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.database.sqlite.SQLiteTableLockedException;
/* loaded from: classes3.dex */
public class DatabaseExceptionUtil {
    public static void handleException(Exception exc) {
        if (exc instanceof SQLiteException) {
            if (!(exc instanceof SQLiteAbortException) && !(exc instanceof SQLiteAccessPermException) && !(exc instanceof SQLiteBindOrColumnIndexOutOfRangeException) && !(exc instanceof SQLiteBlobTooBigException) && !(exc instanceof SQLiteCantOpenDatabaseException) && !(exc instanceof SQLiteConstraintException) && !(exc instanceof SQLiteDatabaseCorruptException) && !(exc instanceof SQLiteDatabaseLockedException) && !(exc instanceof SQLiteDatatypeMismatchException) && !(exc instanceof SQLiteDiskIOException) && !(exc instanceof SQLiteDoneException) && !(exc instanceof SQLiteFullException) && !(exc instanceof SQLiteMisuseException) && !(exc instanceof SQLiteOutOfMemoryException) && !(exc instanceof SQLiteReadOnlyDatabaseException)) {
                boolean z = exc instanceof SQLiteTableLockedException;
            }
        } else {
            boolean z2 = exc instanceof RuntimeException;
        }
        exc.printStackTrace();
    }
}
