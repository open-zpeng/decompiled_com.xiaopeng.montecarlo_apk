package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.Level500CellInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes2.dex */
public class Level500CellInfoDao extends AbstractDao<Level500CellInfo, Long> {
    public static final String TABLENAME = "LEVEL500_CELL_INFO";

    /* loaded from: classes2.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, "_id");
        public static final Property Lon = new Property(1, Double.TYPE, CPSearchParam.PARAM_KEY_LON, false, "LON");
        public static final Property Lat = new Property(2, Double.TYPE, CPSearchParam.PARAM_KEY_LAT, false, "LAT");
        public static final Property ChargeNum = new Property(3, Integer.TYPE, "chargeNum", false, "CHARGE_NUM");
        public static final Property ChargeIdList = new Property(4, String.class, "chargeIdList", false, "CHARGE_ID_LIST");
        public static final Property PoiMinLon = new Property(5, Double.TYPE, "poiMinLon", false, "POI_MIN_LON");
        public static final Property PoiMaxLon = new Property(6, Double.TYPE, "poiMaxLon", false, "POI_MAX_LON");
        public static final Property PoiMinLat = new Property(7, Double.TYPE, "poiMinLat", false, "POI_MIN_LAT");
        public static final Property PoiMaxLat = new Property(8, Double.TYPE, "poiMaxLat", false, "POI_MAX_LAT");
        public static final Property ContainXPFlag = new Property(9, Byte.TYPE, "containXPFlag", false, "CONTAIN_XPFLAG");
        public static final Property CellMinLon = new Property(10, Double.TYPE, "cellMinLon", false, "CELL_MIN_LON");
        public static final Property CellMaxLon = new Property(11, Double.TYPE, "cellMaxLon", false, "CELL_MAX_LON");
        public static final Property CellMinLat = new Property(12, Double.TYPE, "cellMinLat", false, "CELL_MIN_LAT");
        public static final Property CellMaxLat = new Property(13, Double.TYPE, "cellMaxLat", false, "CELL_MAX_LAT");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public Level500CellInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public Level500CellInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"LEVEL500_CELL_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"LON\" REAL NOT NULL ,\"LAT\" REAL NOT NULL ,\"CHARGE_NUM\" INTEGER NOT NULL ,\"CHARGE_ID_LIST\" TEXT,\"POI_MIN_LON\" REAL NOT NULL ,\"POI_MAX_LON\" REAL NOT NULL ,\"POI_MIN_LAT\" REAL NOT NULL ,\"POI_MAX_LAT\" REAL NOT NULL ,\"CONTAIN_XPFLAG\" INTEGER NOT NULL ,\"CELL_MIN_LON\" REAL NOT NULL ,\"CELL_MAX_LON\" REAL NOT NULL ,\"CELL_MIN_LAT\" REAL NOT NULL ,\"CELL_MAX_LAT\" REAL NOT NULL );");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"LEVEL500_CELL_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, Level500CellInfo level500CellInfo) {
        databaseStatement.clearBindings();
        Long id = level500CellInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindDouble(2, level500CellInfo.getLon());
        databaseStatement.bindDouble(3, level500CellInfo.getLat());
        databaseStatement.bindLong(4, level500CellInfo.getChargeNum());
        String chargeIdList = level500CellInfo.getChargeIdList();
        if (chargeIdList != null) {
            databaseStatement.bindString(5, chargeIdList);
        }
        databaseStatement.bindDouble(6, level500CellInfo.getPoiMinLon());
        databaseStatement.bindDouble(7, level500CellInfo.getPoiMaxLon());
        databaseStatement.bindDouble(8, level500CellInfo.getPoiMinLat());
        databaseStatement.bindDouble(9, level500CellInfo.getPoiMaxLat());
        databaseStatement.bindLong(10, level500CellInfo.getContainXPFlag());
        databaseStatement.bindDouble(11, level500CellInfo.getCellMinLon());
        databaseStatement.bindDouble(12, level500CellInfo.getCellMaxLon());
        databaseStatement.bindDouble(13, level500CellInfo.getCellMinLat());
        databaseStatement.bindDouble(14, level500CellInfo.getCellMaxLat());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, Level500CellInfo level500CellInfo) {
        sQLiteStatement.clearBindings();
        Long id = level500CellInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindDouble(2, level500CellInfo.getLon());
        sQLiteStatement.bindDouble(3, level500CellInfo.getLat());
        sQLiteStatement.bindLong(4, level500CellInfo.getChargeNum());
        String chargeIdList = level500CellInfo.getChargeIdList();
        if (chargeIdList != null) {
            sQLiteStatement.bindString(5, chargeIdList);
        }
        sQLiteStatement.bindDouble(6, level500CellInfo.getPoiMinLon());
        sQLiteStatement.bindDouble(7, level500CellInfo.getPoiMaxLon());
        sQLiteStatement.bindDouble(8, level500CellInfo.getPoiMinLat());
        sQLiteStatement.bindDouble(9, level500CellInfo.getPoiMaxLat());
        sQLiteStatement.bindLong(10, level500CellInfo.getContainXPFlag());
        sQLiteStatement.bindDouble(11, level500CellInfo.getCellMinLon());
        sQLiteStatement.bindDouble(12, level500CellInfo.getCellMaxLon());
        sQLiteStatement.bindDouble(13, level500CellInfo.getCellMinLat());
        sQLiteStatement.bindDouble(14, level500CellInfo.getCellMaxLat());
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
    public Level500CellInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 4;
        return new Level500CellInfo(valueOf, cursor.getDouble(i + 1), cursor.getDouble(i + 2), cursor.getInt(i + 3), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.getDouble(i + 5), cursor.getDouble(i + 6), cursor.getDouble(i + 7), cursor.getDouble(i + 8), (byte) cursor.getShort(i + 9), cursor.getDouble(i + 10), cursor.getDouble(i + 11), cursor.getDouble(i + 12), cursor.getDouble(i + 13));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, Level500CellInfo level500CellInfo, int i) {
        int i2 = i + 0;
        level500CellInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        level500CellInfo.setLon(cursor.getDouble(i + 1));
        level500CellInfo.setLat(cursor.getDouble(i + 2));
        level500CellInfo.setChargeNum(cursor.getInt(i + 3));
        int i3 = i + 4;
        level500CellInfo.setChargeIdList(cursor.isNull(i3) ? null : cursor.getString(i3));
        level500CellInfo.setPoiMinLon(cursor.getDouble(i + 5));
        level500CellInfo.setPoiMaxLon(cursor.getDouble(i + 6));
        level500CellInfo.setPoiMinLat(cursor.getDouble(i + 7));
        level500CellInfo.setPoiMaxLat(cursor.getDouble(i + 8));
        level500CellInfo.setContainXPFlag((byte) cursor.getShort(i + 9));
        level500CellInfo.setCellMinLon(cursor.getDouble(i + 10));
        level500CellInfo.setCellMaxLon(cursor.getDouble(i + 11));
        level500CellInfo.setCellMinLat(cursor.getDouble(i + 12));
        level500CellInfo.setCellMaxLat(cursor.getDouble(i + 13));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(Level500CellInfo level500CellInfo, long j) {
        level500CellInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(Level500CellInfo level500CellInfo) {
        if (level500CellInfo != null) {
            return level500CellInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(Level500CellInfo level500CellInfo) {
        return level500CellInfo.getId() != null;
    }
}
