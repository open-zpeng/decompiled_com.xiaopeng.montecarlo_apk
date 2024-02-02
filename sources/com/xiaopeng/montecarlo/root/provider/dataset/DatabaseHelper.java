package com.xiaopeng.montecarlo.root.provider.dataset;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 2;
    private static final L.Tag TAG = new L.Tag("DatabaseHelper");
    private int mUserHandle;
    private String mUserId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatabaseHelper(Context context, String str, int i, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
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
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS string_keyvalue_set (name TEXT PRIMARY KEY, value TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 > 1) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS localset");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS string_keyvalue_set");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } finally {
            }
        } else if (i < 2) {
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS string_keyvalue_set");
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            sQLiteDatabase.endTransaction();
            onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        L.Tag tag = TAG;
        L.w(tag, "onDowngrade oldVersion:" + i + ", newVersion:" + i2);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS localset");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS string_keyvalue_set");
        onCreate(sQLiteDatabase);
    }
}
