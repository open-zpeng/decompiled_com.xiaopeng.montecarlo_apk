package com.xiaopeng.montecarlo.navcore.database;

import android.content.Context;
import com.xiaopeng.montecarlo.navcore.greendao.DaoMaster;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.root.util.L;
import org.greenrobot.greendao.query.QueryBuilder;
/* loaded from: classes3.dex */
public class DatabaseManager {
    private static final String DB_NAME = "charge.db";
    private static final L.Tag TAG = new L.Tag("DatabaseManager");
    private static volatile DatabaseManager sInstance = new DatabaseManager();
    private XPSQLiteOpenHelper mDBHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private boolean mEnable = true;

    public static DatabaseManager getInstance() {
        return sInstance;
    }

    public void init(Context context) {
        if (this.mDBHelper == null || this.mDaoMaster == null || this.mDaoSession == null) {
            this.mDBHelper = new XPSQLiteOpenHelper(context, DB_NAME, null);
            this.mDaoMaster = new DaoMaster(this.mDBHelper.getWritableDb());
            this.mDaoSession = this.mDaoMaster.newSession();
        }
    }

    public DaoSession getDaoSession() {
        if (this.mDaoSession == null) {
            L.w(TAG, "not init");
        }
        return this.mDaoSession;
    }

    public void setDebug(Boolean bool) {
        if (bool.booleanValue()) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
            return;
        }
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    public void closeHelper() {
        XPSQLiteOpenHelper xPSQLiteOpenHelper = this.mDBHelper;
        if (xPSQLiteOpenHelper != null) {
            xPSQLiteOpenHelper.close();
            this.mDBHelper = null;
        }
    }

    public void closeSession() {
        DaoSession daoSession = this.mDaoSession;
        if (daoSession != null) {
            daoSession.clear();
            this.mDaoSession = null;
        }
    }

    public void close() {
        closeHelper();
        closeSession();
    }
}
