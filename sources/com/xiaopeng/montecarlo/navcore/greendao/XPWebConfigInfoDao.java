package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.lzy.okgo.cache.CacheEntity;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPWebConfigInfo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes3.dex */
public class XPWebConfigInfoDao extends AbstractDao<XPWebConfigInfo, Long> {
    public static final String TABLENAME = "XPWEB_CONFIG_INFO";

    /* loaded from: classes3.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, "_id");
        public static final Property Key = new Property(1, String.class, CacheEntity.KEY, false, "KEY");
        public static final Property Value = new Property(2, String.class, "value", false, "VALUE");
        public static final Property UpdateTime = new Property(3, Date.class, "updateTime", false, "UPDATE_TIME");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public XPWebConfigInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public XPWebConfigInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"XPWEB_CONFIG_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"KEY\" TEXT NOT NULL UNIQUE ,\"VALUE\" TEXT,\"UPDATE_TIME\" INTEGER);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"XPWEB_CONFIG_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, XPWebConfigInfo xPWebConfigInfo) {
        databaseStatement.clearBindings();
        Long id = xPWebConfigInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindString(2, xPWebConfigInfo.getKey());
        String value = xPWebConfigInfo.getValue();
        if (value != null) {
            databaseStatement.bindString(3, value);
        }
        Date updateTime = xPWebConfigInfo.getUpdateTime();
        if (updateTime != null) {
            databaseStatement.bindLong(4, updateTime.getTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, XPWebConfigInfo xPWebConfigInfo) {
        sQLiteStatement.clearBindings();
        Long id = xPWebConfigInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindString(2, xPWebConfigInfo.getKey());
        String value = xPWebConfigInfo.getValue();
        if (value != null) {
            sQLiteStatement.bindString(3, value);
        }
        Date updateTime = xPWebConfigInfo.getUpdateTime();
        if (updateTime != null) {
            sQLiteStatement.bindLong(4, updateTime.getTime());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.AbstractDao
    public XPWebConfigInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        int i3 = i + 2;
        int i4 = i + 3;
        return new XPWebConfigInfo(valueOf, string, cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : new Date(cursor.getLong(i4)));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, XPWebConfigInfo xPWebConfigInfo, int i) {
        int i2 = i + 0;
        xPWebConfigInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        xPWebConfigInfo.setKey(cursor.getString(i + 1));
        int i3 = i + 2;
        xPWebConfigInfo.setValue(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        xPWebConfigInfo.setUpdateTime(cursor.isNull(i4) ? null : new Date(cursor.getLong(i4)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(XPWebConfigInfo xPWebConfigInfo, long j) {
        xPWebConfigInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(XPWebConfigInfo xPWebConfigInfo) {
        if (xPWebConfigInfo != null) {
            return xPWebConfigInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(XPWebConfigInfo xPWebConfigInfo) {
        return xPWebConfigInfo.getId() != null;
    }
}
