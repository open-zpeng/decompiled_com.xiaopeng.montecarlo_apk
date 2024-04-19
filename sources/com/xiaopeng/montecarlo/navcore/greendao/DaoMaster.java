package com.xiaopeng.montecarlo.navcore.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
/* loaded from: classes2.dex */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 9;

    public static void createAllTables(Database database, boolean z) {
        XPScratchSpotInfoDao.createTable(database, z);
        CPDeepInfoDao.createTable(database, z);
        CPInfoDao.createTable(database, z);
        CarWashInfoDao.createTable(database, z);
        LccGeoFenceInfoDao.createTable(database, z);
        VPAInfoDao.createTable(database, z);
        XPServiceCenterInfoDao.createTable(database, z);
        XPKeywordConfigInfoDao.createTable(database, z);
        Level500CellInfoDao.createTable(database, z);
        XPWebConfigInfoDao.createTable(database, z);
    }

    public static void dropAllTables(Database database, boolean z) {
        XPScratchSpotInfoDao.dropTable(database, z);
        CPDeepInfoDao.dropTable(database, z);
        CPInfoDao.dropTable(database, z);
        CarWashInfoDao.dropTable(database, z);
        LccGeoFenceInfoDao.dropTable(database, z);
        VPAInfoDao.dropTable(database, z);
        XPServiceCenterInfoDao.dropTable(database, z);
        XPKeywordConfigInfoDao.dropTable(database, z);
        Level500CellInfoDao.dropTable(database, z);
        XPWebConfigInfoDao.dropTable(database, z);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this(new StandardDatabase(sQLiteDatabase));
    }

    public DaoMaster(Database database) {
        super(database, 9);
        registerDaoClass(XPScratchSpotInfoDao.class);
        registerDaoClass(CPDeepInfoDao.class);
        registerDaoClass(CPInfoDao.class);
        registerDaoClass(CarWashInfoDao.class);
        registerDaoClass(LccGeoFenceInfoDao.class);
        registerDaoClass(VPAInfoDao.class);
        registerDaoClass(XPServiceCenterInfoDao.class);
        registerDaoClass(XPKeywordConfigInfoDao.class);
        registerDaoClass(Level500CellInfoDao.class);
        registerDaoClass(XPWebConfigInfoDao.class);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    public DaoSession newSession() {
        return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // org.greenrobot.greendao.AbstractDaoMaster
    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.db, identityScopeType, this.daoConfigMap);
    }

    /* loaded from: classes2.dex */
    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String str) {
            super(context, str, 9);
        }

        public OpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 9);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onCreate(Database database) {
            Log.i("greenDAO", "Creating tables for schema version 9");
            DaoMaster.createAllTables(database, false);
        }
    }

    /* loaded from: classes2.dex */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        public DevOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onUpgrade(Database database, int i, int i2) {
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            DaoMaster.dropAllTables(database, true);
            onCreate(database);
        }
    }
}
