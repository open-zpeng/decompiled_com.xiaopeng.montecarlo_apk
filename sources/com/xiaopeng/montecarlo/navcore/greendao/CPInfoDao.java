package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.lzy.okgo.cache.CacheEntity;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CPInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes3.dex */
public class CPInfoDao extends AbstractDao<CPInfo, Long> {
    public static final String TABLENAME = "CPINFO";

    /* loaded from: classes3.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, "_id");
        public static final Property CityCode = new Property(1, String.class, "cityCode", false, "CITY_CODE");
        public static final Property StationId = new Property(2, String.class, CPSearchParam.PARAM_KEY_STATIONID, false, "STATION_ID");
        public static final Property StationName = new Property(3, String.class, "stationName", false, "STATION_NAME");
        public static final Property StationAddr = new Property(4, String.class, "stationAddr", false, "STATION_ADDR");
        public static final Property OperId = new Property(5, String.class, "operId", false, "OPER_ID");
        public static final Property OperName = new Property(6, String.class, "operName", false, "OPER_NAME");
        public static final Property SelfSupportFlag = new Property(7, Byte.TYPE, "selfSupportFlag", false, "SELF_SUPPORT_FLAG");
        public static final Property Lon = new Property(8, Double.TYPE, CPSearchParam.PARAM_KEY_LON, false, "LON");
        public static final Property Lat = new Property(9, Double.TYPE, CPSearchParam.PARAM_KEY_LAT, false, "LAT");
        public static final Property FastNums = new Property(10, Integer.TYPE, "fastNums", false, "DC_NUMS");
        public static final Property SlowNums = new Property(11, Integer.TYPE, "slowNums", false, "AC_NUMS");
        public static final Property Key = new Property(12, String.class, CacheEntity.KEY, false, "KEY");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public CPInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public CPInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"CPINFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"CITY_CODE\" TEXT,\"STATION_ID\" TEXT NOT NULL UNIQUE ,\"STATION_NAME\" TEXT,\"STATION_ADDR\" TEXT,\"OPER_ID\" TEXT,\"OPER_NAME\" TEXT,\"SELF_SUPPORT_FLAG\" INTEGER NOT NULL ,\"LON\" REAL NOT NULL ,\"LAT\" REAL NOT NULL ,\"DC_NUMS\" INTEGER NOT NULL ,\"AC_NUMS\" INTEGER NOT NULL ,\"KEY\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"CPINFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, CPInfo cPInfo) {
        databaseStatement.clearBindings();
        Long id = cPInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String cityCode = cPInfo.getCityCode();
        if (cityCode != null) {
            databaseStatement.bindString(2, cityCode);
        }
        databaseStatement.bindString(3, cPInfo.getStationId());
        String stationName = cPInfo.getStationName();
        if (stationName != null) {
            databaseStatement.bindString(4, stationName);
        }
        String stationAddr = cPInfo.getStationAddr();
        if (stationAddr != null) {
            databaseStatement.bindString(5, stationAddr);
        }
        String operId = cPInfo.getOperId();
        if (operId != null) {
            databaseStatement.bindString(6, operId);
        }
        String operName = cPInfo.getOperName();
        if (operName != null) {
            databaseStatement.bindString(7, operName);
        }
        databaseStatement.bindLong(8, cPInfo.getSelfSupportFlag());
        databaseStatement.bindDouble(9, cPInfo.getLon());
        databaseStatement.bindDouble(10, cPInfo.getLat());
        databaseStatement.bindLong(11, cPInfo.getFastNums());
        databaseStatement.bindLong(12, cPInfo.getSlowNums());
        String key = cPInfo.getKey();
        if (key != null) {
            databaseStatement.bindString(13, key);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, CPInfo cPInfo) {
        sQLiteStatement.clearBindings();
        Long id = cPInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String cityCode = cPInfo.getCityCode();
        if (cityCode != null) {
            sQLiteStatement.bindString(2, cityCode);
        }
        sQLiteStatement.bindString(3, cPInfo.getStationId());
        String stationName = cPInfo.getStationName();
        if (stationName != null) {
            sQLiteStatement.bindString(4, stationName);
        }
        String stationAddr = cPInfo.getStationAddr();
        if (stationAddr != null) {
            sQLiteStatement.bindString(5, stationAddr);
        }
        String operId = cPInfo.getOperId();
        if (operId != null) {
            sQLiteStatement.bindString(6, operId);
        }
        String operName = cPInfo.getOperName();
        if (operName != null) {
            sQLiteStatement.bindString(7, operName);
        }
        sQLiteStatement.bindLong(8, cPInfo.getSelfSupportFlag());
        sQLiteStatement.bindDouble(9, cPInfo.getLon());
        sQLiteStatement.bindDouble(10, cPInfo.getLat());
        sQLiteStatement.bindLong(11, cPInfo.getFastNums());
        sQLiteStatement.bindLong(12, cPInfo.getSlowNums());
        String key = cPInfo.getKey();
        if (key != null) {
            sQLiteStatement.bindString(13, key);
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
    public CPInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 3;
        int i5 = i + 4;
        int i6 = i + 5;
        int i7 = i + 6;
        int i8 = i + 12;
        return new CPInfo(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.getString(i + 2), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : cursor.getString(i7), (byte) cursor.getShort(i + 7), cursor.getDouble(i + 8), cursor.getDouble(i + 9), cursor.getInt(i + 10), cursor.getInt(i + 11), cursor.isNull(i8) ? null : cursor.getString(i8));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, CPInfo cPInfo, int i) {
        int i2 = i + 0;
        cPInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        cPInfo.setCityCode(cursor.isNull(i3) ? null : cursor.getString(i3));
        cPInfo.setStationId(cursor.getString(i + 2));
        int i4 = i + 3;
        cPInfo.setStationName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        cPInfo.setStationAddr(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        cPInfo.setOperId(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 6;
        cPInfo.setOperName(cursor.isNull(i7) ? null : cursor.getString(i7));
        cPInfo.setSelfSupportFlag((byte) cursor.getShort(i + 7));
        cPInfo.setLon(cursor.getDouble(i + 8));
        cPInfo.setLat(cursor.getDouble(i + 9));
        cPInfo.setFastNums(cursor.getInt(i + 10));
        cPInfo.setSlowNums(cursor.getInt(i + 11));
        int i8 = i + 12;
        cPInfo.setKey(cursor.isNull(i8) ? null : cursor.getString(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(CPInfo cPInfo, long j) {
        cPInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(CPInfo cPInfo) {
        if (cPInfo != null) {
            return cPInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(CPInfo cPInfo) {
        return cPInfo.getId() != null;
    }
}
