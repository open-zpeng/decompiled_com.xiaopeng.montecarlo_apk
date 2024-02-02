package com.xiaopeng.montecarlo.navcore.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaopeng.montecarlo.navcore.greendao.CPDeepInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.CarWashInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.DaoMaster;
import com.xiaopeng.montecarlo.navcore.greendao.LccGeoFenceInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.Level500CellInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.VPAInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.XPKeywordConfigInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.XPScratchSpotInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.XPServiceCenterInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.XPWebConfigInfoDao;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.root.util.L;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;
/* loaded from: classes2.dex */
public class XPSQLiteOpenHelper extends DaoMaster.OpenHelper {
    private static final L.Tag TAG = new L.Tag("XPSQLiteOpenHelper");

    public XPSQLiteOpenHelper(Context context, String str) {
        super(context, str);
    }

    public XPSQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory);
    }

    @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
    public void onUpgrade(Database database, int i, int i2) {
        L.i(TAG, "onUpgrade database oldVersion:" + i + ", newVersion:" + i2);
        if (i <= 1) {
            CarWashInfoDao.createTable(database, true);
            Level500CellInfoDao.createTable(database, true);
            MigrationHelper.migrate(database, CPDeepInfoDao.class);
            i = 2;
        }
        if (2 == i) {
            XPKeywordConfigInfoDao.createTable(database, true);
            L.i(TAG, "XPKeywordConfigInfoDao createTable, new version is 3");
            i = 3;
        }
        if (3 == i) {
            XPServiceCenterInfoDao.createTable(database, true);
            L.i(TAG, "XPServiceCenterInfoDao createTable, new version is 4");
            i = 4;
        }
        if (4 == i) {
            XPScratchSpotInfoDao.createTable(database, true);
            L.i(TAG, "XPScratchSpotInfoDao createTable, new version is 5");
            i = 5;
        }
        if (5 == i) {
            XPWebConfigInfoDao.createTable(database, true);
            L.i(TAG, "XPWebConfigInfoDao createTable, new version is 6");
            i = 6;
        }
        if (6 == i) {
            VPAInfoDao.createTable(database, true);
            L.i(TAG, "VPAInfoDao createTable, new version is 7");
            i = 7;
        }
        if (7 == i) {
            LccGeoFenceInfoDao.createTable(database, true);
            L.i(TAG, "LccGeoFenceInfoDao createTable, new version is 8");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        L.Tag tag = TAG;
        L.w(tag, "onDowngrade oldVersion:" + i + ", newVersion:" + i2);
        StandardDatabase standardDatabase = new StandardDatabase(sQLiteDatabase);
        DaoMaster.dropAllTables(standardDatabase, true);
        DaoMaster.createAllTables(standardDatabase, true);
        XPOfflineDataManager.getInstance().clearChargeData();
        XPOfflineDataManager.getInstance().clearKeywordConfigData();
        XPOfflineDataManager.getInstance().clearServiceCenterData();
        XPOfflineDataManager.getInstance().clearScratchSpotData();
        XPOfflineDataManager.getInstance().clearLccGeoFenceData();
    }
}
