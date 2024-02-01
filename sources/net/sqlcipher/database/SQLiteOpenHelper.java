package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: classes3.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mDeferSetWriteAheadLoggingEnabled;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        } else if (databaseErrorHandler == null) {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        } else {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i;
            this.mHook = sQLiteDatabaseHook;
            this.mErrorHandler = databaseErrorHandler;
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase(String str) {
        return getWritableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] cArr) {
        return getWritableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
    }

    public synchronized SQLiteDatabase getWritableDatabase(byte[] bArr) {
        SQLiteDatabase openOrCreateDatabase;
        if (this.mDatabase != null && this.mDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
            return this.mDatabase;
        } else if (this.mIsInitializing) {
            throw new IllegalStateException("getWritableDatabase called recursively");
        } else {
            if (this.mDatabase != null) {
                this.mDatabase.lock();
            }
            this.mIsInitializing = true;
            if (this.mName == null) {
                openOrCreateDatabase = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null, "");
            } else {
                String path = this.mContext.getDatabasePath(this.mName).getPath();
                File file = new File(path);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(path, bArr, this.mFactory, this.mHook, this.mErrorHandler);
            }
            SQLiteDatabase sQLiteDatabase = openOrCreateDatabase;
            if (this.mDeferSetWriteAheadLoggingEnabled) {
                this.mEnableWriteAheadLogging = sQLiteDatabase.enableWriteAheadLogging();
            }
            onConfigure(sQLiteDatabase);
            int version = sQLiteDatabase.getVersion();
            if (version != this.mNewVersion) {
                sQLiteDatabase.beginTransaction();
                if (version == 0) {
                    onCreate(sQLiteDatabase);
                } else if (version > this.mNewVersion) {
                    onDowngrade(sQLiteDatabase, version, this.mNewVersion);
                } else {
                    onUpgrade(sQLiteDatabase, version, this.mNewVersion);
                }
                sQLiteDatabase.setVersion(this.mNewVersion);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            }
            onOpen(sQLiteDatabase);
            this.mIsInitializing = false;
            if (this.mDatabase != null) {
                try {
                    this.mDatabase.close();
                } catch (Exception unused) {
                }
                this.mDatabase.unlock();
            }
            this.mDatabase = sQLiteDatabase;
            return sQLiteDatabase;
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase(String str) {
        return getReadableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] cArr) {
        return getReadableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
    }

    public synchronized SQLiteDatabase getReadableDatabase(byte[] bArr) {
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            return this.mDatabase;
        } else if (this.mIsInitializing) {
            throw new IllegalStateException("getReadableDatabase called recursively");
        } else {
            try {
                return getWritableDatabase(bArr);
            } catch (SQLiteException e) {
                if (this.mName == null) {
                    throw e;
                }
                String str = TAG;
                Log.e(str, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
                this.mIsInitializing = true;
                String path = this.mContext.getDatabasePath(this.mName).getPath();
                File file = new File(path);
                File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.exists()) {
                    this.mIsInitializing = false;
                    SQLiteDatabase writableDatabase = getWritableDatabase(bArr);
                    this.mIsInitializing = true;
                    writableDatabase.close();
                }
                SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, bArr, this.mFactory, 1, this.mHook, this.mErrorHandler);
                if (openDatabase.getVersion() != this.mNewVersion) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + openDatabase.getVersion() + " to " + this.mNewVersion + ": " + path);
                }
                onOpen(openDatabase);
                String str2 = TAG;
                Log.w(str2, "Opened " + this.mName + " in read-only mode");
                this.mDatabase = openDatabase;
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                this.mIsInitializing = false;
                if (openDatabase != null && openDatabase != this.mDatabase) {
                    openDatabase.close();
                }
                return sQLiteDatabase;
            }
        }
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        }
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                if (this.mDatabase != null && this.mDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                    this.mEnableWriteAheadLogging = z;
                } else {
                    this.mDeferSetWriteAheadLoggingEnabled = z;
                }
            }
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
    }
}
