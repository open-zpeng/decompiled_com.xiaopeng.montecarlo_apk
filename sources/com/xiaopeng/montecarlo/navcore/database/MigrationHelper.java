package com.xiaopeng.montecarlo.navcore.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes2.dex */
public class MigrationHelper {
    private static final String SQLITE_MASTER = "sqlite_master";
    private static final String SQLITE_TEMP_MASTER = "sqlite_temp_master";
    private static final L.Tag TAG = new L.Tag("MigrationHelper");
    private static WeakReference<ReCreateAllTableListener> sWeakListener;

    /* loaded from: classes2.dex */
    public interface ReCreateAllTableListener {
        void onCreateAllTables(Database database, boolean z);

        void onDropAllTables(Database database, boolean z);
    }

    public static void migrate(SQLiteDatabase sQLiteDatabase, Class<? extends AbstractDao<?, ?>>... clsArr) {
        L.Tag tag = TAG;
        L.i(tag, "The Old Database Version:" + sQLiteDatabase.getVersion());
        migrate(new StandardDatabase(sQLiteDatabase), clsArr);
    }

    public static void migrate(SQLiteDatabase sQLiteDatabase, ReCreateAllTableListener reCreateAllTableListener, Class<? extends AbstractDao<?, ?>>... clsArr) {
        sWeakListener = new WeakReference<>(reCreateAllTableListener);
        migrate(sQLiteDatabase, clsArr);
    }

    public static void migrate(Database database, ReCreateAllTableListener reCreateAllTableListener, Class<? extends AbstractDao<?, ?>>... clsArr) {
        sWeakListener = new WeakReference<>(reCreateAllTableListener);
        migrate(database, clsArr);
    }

    public static void migrate(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        L.i(TAG, "Generate temp table start");
        generateTempTables(database, clsArr);
        L.i(TAG, "Generate temp table complete");
        WeakReference<ReCreateAllTableListener> weakReference = sWeakListener;
        ReCreateAllTableListener reCreateAllTableListener = weakReference != null ? weakReference.get() : null;
        if (reCreateAllTableListener != null) {
            reCreateAllTableListener.onDropAllTables(database, true);
            L.i(TAG, "Drop all table by listener");
            reCreateAllTableListener.onCreateAllTables(database, false);
            L.i(TAG, "Create all table by listener");
        } else {
            dropAllTables(database, true, clsArr);
            createAllTables(database, false, clsArr);
        }
        L.i(TAG, "Restore data start");
        restoreData(database, clsArr);
        L.i(TAG, "Restore data complete");
    }

    private static void generateTempTables(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            String str = null;
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str2 = daoConfig.tablename;
            if (!isTableExists(database, false, str2)) {
                L.i(TAG, "New Table:" + str2);
            } else {
                try {
                    str = daoConfig.tablename.concat("_TEMP");
                    database.execSQL("DROP TABLE IF EXISTS " + str + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
                    database.execSQL("CREATE TEMPORARY TABLE " + str + " AS SELECT * FROM " + str2 + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
                    L.i(TAG, "Table:" + str2 + "\n ---Columns-->" + getColumnsStr(daoConfig));
                    L.Tag tag = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Generate temp table:");
                    sb.append(str);
                    L.i(tag, sb.toString());
                } catch (SQLException unused) {
                    L.e(TAG, "Failed to generate temp table" + str);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean isTableExists(org.greenrobot.greendao.database.Database r5, boolean r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r5 == 0) goto L68
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto La
            goto L68
        La:
            if (r6 == 0) goto L10
            java.lang.String r6 = "sqlite_temp_master"
            goto L13
        L10:
            java.lang.String r6 = "sqlite_master"
        L13:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT COUNT(*) FROM "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = " WHERE mType = ? AND mName = ?"
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r1 = 0
            r2 = 2
            r3 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r4 = "table"
            r2[r0] = r4     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r2[r3] = r7     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            android.database.Cursor r1 = r5.rawQuery(r6, r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r1 == 0) goto L4c
            boolean r5 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r5 != 0) goto L42
            goto L4c
        L42:
            int r5 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r1 == 0) goto L5e
            r1.close()
            goto L5e
        L4c:
            if (r1 == 0) goto L51
            r1.close()
        L51:
            return r0
        L52:
            r5 = move-exception
            goto L62
        L54:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L5d
            r1.close()
        L5d:
            r5 = r0
        L5e:
            if (r5 <= 0) goto L61
            r0 = r3
        L61:
            return r0
        L62:
            if (r1 == 0) goto L67
            r1.close()
        L67:
            throw r5
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.database.MigrationHelper.isTableExists(org.greenrobot.greendao.database.Database, boolean, java.lang.String):boolean");
    }

    private static String getColumnsStr(DaoConfig daoConfig) {
        if (daoConfig == null) {
            return "no columns";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < daoConfig.allColumns.length; i++) {
            sb.append(daoConfig.allColumns[i]);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static void dropAllTables(Database database, boolean z, @NonNull Class<? extends AbstractDao<?, ?>>... clsArr) {
        reflectMethod(database, "dropTable", z, clsArr);
        L.i(TAG, "Drop all table by reflect");
    }

    private static void createAllTables(Database database, boolean z, @NonNull Class<? extends AbstractDao<?, ?>>... clsArr) {
        reflectMethod(database, "createTable", z, clsArr);
        L.e(TAG, "Create all table by reflect");
    }

    private static void reflectMethod(Database database, String str, boolean z, @NonNull Class<? extends AbstractDao<?, ?>>... clsArr) {
        if (clsArr.length < 1) {
            return;
        }
        try {
            for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
                cls.getDeclaredMethod(str, Database.class, Boolean.TYPE).invoke(null, database, Boolean.valueOf(z));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    private static void restoreData(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            String concat = daoConfig.tablename.concat("_TEMP");
            if (!isTableExists(database, true, concat)) {
                L.w(TAG, "restoreData table not exists tableName:" + str + ", tempTableName:" + concat);
            } else {
                try {
                    List<TableInfo> tableInfo = TableInfo.getTableInfo(database, str);
                    List<TableInfo> tableInfo2 = TableInfo.getTableInfo(database, concat);
                    ArrayList arrayList = new ArrayList(tableInfo.size());
                    ArrayList arrayList2 = new ArrayList(tableInfo.size());
                    for (TableInfo tableInfo3 : tableInfo2) {
                        if (tableInfo.contains(tableInfo3)) {
                            String str2 = '`' + tableInfo3.mName + '`';
                            arrayList2.add(str2);
                            arrayList.add(str2);
                        }
                    }
                    for (TableInfo tableInfo4 : tableInfo) {
                        if (tableInfo4.mNotnull && !tableInfo2.contains(tableInfo4)) {
                            String str3 = '`' + tableInfo4.mName + '`';
                            arrayList2.add(str3);
                            arrayList.add((tableInfo4.mDfltValue != null ? "'" + tableInfo4.mDfltValue + "' AS " : "'' AS ") + str3);
                        }
                    }
                    if (arrayList2.size() != 0) {
                        database.execSQL("REPLACE INTO " + str + " (" + TextUtils.join(",", arrayList2) + ") SELECT " + TextUtils.join(",", arrayList) + " FROM " + concat + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
                        L.Tag tag = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Restore data to ");
                        sb.append(str);
                        L.i(tag, sb.toString());
                    }
                    database.execSQL("DROP TABLE " + concat);
                    L.i(TAG, "Drop temp table:" + concat);
                } catch (SQLException unused) {
                    L.e(TAG, "Failed to restore data from temp table:" + concat);
                }
            }
        }
    }

    private static List<String> getColumns(Database database, String str) {
        Cursor cursor = null;
        r0 = null;
        List<String> asList = null;
        cursor = null;
        try {
            try {
                Cursor rawQuery = database.rawQuery("SELECT * FROM " + str + " limit 0", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getColumnCount() > 0) {
                            asList = Arrays.asList(rawQuery.getColumnNames());
                        }
                    } catch (Exception e) {
                        e = e;
                        cursor = rawQuery;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return new ArrayList();
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        new ArrayList();
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return asList == null ? new ArrayList() : asList;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class TableInfo {
        int mCid;
        String mDfltValue;
        String mName;
        boolean mNotnull;
        boolean mPk;
        String mType;

        private TableInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x007a, code lost:
            if (r1 != null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
            if (r1 == null) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
            return r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.util.List<com.xiaopeng.montecarlo.navcore.database.MigrationHelper.TableInfo> getTableInfo(org.greenrobot.greendao.database.Database r4, java.lang.String r5) {
            /*
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "PRAGMA table_info("
                r0.append(r1)
                r0.append(r5)
                java.lang.String r5 = ")"
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                com.xiaopeng.montecarlo.root.util.L$Tag r0 = com.xiaopeng.montecarlo.navcore.database.MigrationHelper.access$100()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "sql:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                com.xiaopeng.montecarlo.root.util.L.i(r0, r1)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r1 = 0
                android.database.Cursor r1 = r4.rawQuery(r5, r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            L39:
                boolean r4 = r1.moveToNext()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r4 == 0) goto L7a
                com.xiaopeng.montecarlo.navcore.database.MigrationHelper$TableInfo r4 = new com.xiaopeng.montecarlo.navcore.database.MigrationHelper$TableInfo     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r4.<init>()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r5 = 0
                int r2 = r1.getInt(r5)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r4.mCid = r2     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r2 = 1
                java.lang.String r3 = r1.getString(r2)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r4.mName = r3     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r3 = 2
                java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r4.mType = r3     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r3 = 3
                int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r3 != r2) goto L62
                r3 = r2
                goto L63
            L62:
                r3 = r5
            L63:
                r4.mNotnull = r3     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r3 = 4
                java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r4.mDfltValue = r3     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r3 = 5
                int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                if (r3 != r2) goto L74
                r5 = r2
            L74:
                r4.mPk = r5     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                r0.add(r4)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
                goto L39
            L7a:
                if (r1 == 0) goto L88
                goto L85
            L7d:
                r4 = move-exception
                goto L89
            L7f:
                r4 = move-exception
                r4.printStackTrace()     // Catch: java.lang.Throwable -> L7d
                if (r1 == 0) goto L88
            L85:
                r1.close()
            L88:
                return r0
            L89:
                if (r1 == 0) goto L8e
                r1.close()
            L8e:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.database.MigrationHelper.TableInfo.getTableInfo(org.greenrobot.greendao.database.Database, java.lang.String):java.util.List");
        }

        public boolean equals(Object obj) {
            return this == obj || (obj != null && getClass() == obj.getClass() && this.mName.equals(((TableInfo) obj).mName));
        }

        public String toString() {
            return "TableInfo{mCid=" + this.mCid + ", mName='" + this.mName + "', mType='" + this.mType + "', mNotnull=" + this.mNotnull + ", mDfltValue='" + this.mDfltValue + "', mPk=" + this.mPk + '}';
        }
    }
}
