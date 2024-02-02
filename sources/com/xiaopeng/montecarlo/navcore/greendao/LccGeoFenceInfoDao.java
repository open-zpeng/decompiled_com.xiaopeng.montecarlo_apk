package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.LccGeoFenceInfo;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes2.dex */
public class LccGeoFenceInfoDao extends AbstractDao<LccGeoFenceInfo, Long> {
    public static final String TABLENAME = "LCC_GEO_FENCE_INFO";

    /* loaded from: classes2.dex */
    public static class Properties {
        public static final Property DbId = new Property(0, Long.class, "dbId", true, "_id");
        public static final Property FenceId = new Property(1, String.class, "fenceId", false, "FENCE_ID");
        public static final Property RoadName = new Property(2, String.class, "roadName", false, "ROAD_NAME");
        public static final Property RoadDir = new Property(3, Float.TYPE, "roadDir", false, "ROAD_DIR");
        public static final Property CityCode = new Property(4, String.class, "cityCode", false, "CITY_CODE");
        public static final Property Type1 = new Property(5, Integer.TYPE, "type1", false, "TYPE1");
        public static final Property Type2 = new Property(6, Integer.TYPE, "type2", false, "TYPE2");
        public static final Property Action = new Property(7, Integer.TYPE, IntentActions.ActionsKey.KEY_ACTION, false, "ACTION");
        public static final Property DangerLaneNumber = new Property(8, Integer.TYPE, "dangerLaneNumber", false, "DANGER_LANE_NUMBER");
        public static final Property DangerLane = new Property(9, Integer.TYPE, "dangerLane", false, "DANGER_LANE");
        public static final Property DangerType = new Property(10, Integer.TYPE, "dangerType", false, "DANGER_TYPE");
        public static final Property DangerLevel = new Property(11, Integer.TYPE, "dangerLevel", false, "DANGER_LEVEL");
        public static final Property RangeLeftBottomLon = new Property(12, Double.TYPE, "rangeLeftBottomLon", false, "RANGE_LEFT_BOTTOM_LON");
        public static final Property RangeLeftBottomLat = new Property(13, Double.TYPE, "rangeLeftBottomLat", false, "RANGE_LEFT_BOTTOM_LAT");
        public static final Property RangeRightTopLon = new Property(14, Double.TYPE, "rangeRightTopLon", false, "RANGE_RIGHT_TOP_LON");
        public static final Property RangeRightTopLat = new Property(15, Double.TYPE, "rangeRightTopLat", false, "RANGE_RIGHT_TOP_LAT");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public LccGeoFenceInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public LccGeoFenceInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"LCC_GEO_FENCE_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"FENCE_ID\" TEXT,\"ROAD_NAME\" TEXT,\"ROAD_DIR\" REAL NOT NULL ,\"CITY_CODE\" TEXT,\"TYPE1\" INTEGER NOT NULL ,\"TYPE2\" INTEGER NOT NULL ,\"ACTION\" INTEGER NOT NULL ,\"DANGER_LANE_NUMBER\" INTEGER NOT NULL ,\"DANGER_LANE\" INTEGER NOT NULL ,\"DANGER_TYPE\" INTEGER NOT NULL ,\"DANGER_LEVEL\" INTEGER NOT NULL ,\"RANGE_LEFT_BOTTOM_LON\" REAL NOT NULL ,\"RANGE_LEFT_BOTTOM_LAT\" REAL NOT NULL ,\"RANGE_RIGHT_TOP_LON\" REAL NOT NULL ,\"RANGE_RIGHT_TOP_LAT\" REAL NOT NULL );");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"LCC_GEO_FENCE_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, LccGeoFenceInfo lccGeoFenceInfo) {
        databaseStatement.clearBindings();
        Long dbId = lccGeoFenceInfo.getDbId();
        if (dbId != null) {
            databaseStatement.bindLong(1, dbId.longValue());
        }
        String fenceId = lccGeoFenceInfo.getFenceId();
        if (fenceId != null) {
            databaseStatement.bindString(2, fenceId);
        }
        String roadName = lccGeoFenceInfo.getRoadName();
        if (roadName != null) {
            databaseStatement.bindString(3, roadName);
        }
        databaseStatement.bindDouble(4, lccGeoFenceInfo.getRoadDir());
        String cityCode = lccGeoFenceInfo.getCityCode();
        if (cityCode != null) {
            databaseStatement.bindString(5, cityCode);
        }
        databaseStatement.bindLong(6, lccGeoFenceInfo.getType1());
        databaseStatement.bindLong(7, lccGeoFenceInfo.getType2());
        databaseStatement.bindLong(8, lccGeoFenceInfo.getAction());
        databaseStatement.bindLong(9, lccGeoFenceInfo.getDangerLaneNumber());
        databaseStatement.bindLong(10, lccGeoFenceInfo.getDangerLane());
        databaseStatement.bindLong(11, lccGeoFenceInfo.getDangerType());
        databaseStatement.bindLong(12, lccGeoFenceInfo.getDangerLevel());
        databaseStatement.bindDouble(13, lccGeoFenceInfo.getRangeLeftBottomLon());
        databaseStatement.bindDouble(14, lccGeoFenceInfo.getRangeLeftBottomLat());
        databaseStatement.bindDouble(15, lccGeoFenceInfo.getRangeRightTopLon());
        databaseStatement.bindDouble(16, lccGeoFenceInfo.getRangeRightTopLat());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, LccGeoFenceInfo lccGeoFenceInfo) {
        sQLiteStatement.clearBindings();
        Long dbId = lccGeoFenceInfo.getDbId();
        if (dbId != null) {
            sQLiteStatement.bindLong(1, dbId.longValue());
        }
        String fenceId = lccGeoFenceInfo.getFenceId();
        if (fenceId != null) {
            sQLiteStatement.bindString(2, fenceId);
        }
        String roadName = lccGeoFenceInfo.getRoadName();
        if (roadName != null) {
            sQLiteStatement.bindString(3, roadName);
        }
        sQLiteStatement.bindDouble(4, lccGeoFenceInfo.getRoadDir());
        String cityCode = lccGeoFenceInfo.getCityCode();
        if (cityCode != null) {
            sQLiteStatement.bindString(5, cityCode);
        }
        sQLiteStatement.bindLong(6, lccGeoFenceInfo.getType1());
        sQLiteStatement.bindLong(7, lccGeoFenceInfo.getType2());
        sQLiteStatement.bindLong(8, lccGeoFenceInfo.getAction());
        sQLiteStatement.bindLong(9, lccGeoFenceInfo.getDangerLaneNumber());
        sQLiteStatement.bindLong(10, lccGeoFenceInfo.getDangerLane());
        sQLiteStatement.bindLong(11, lccGeoFenceInfo.getDangerType());
        sQLiteStatement.bindLong(12, lccGeoFenceInfo.getDangerLevel());
        sQLiteStatement.bindDouble(13, lccGeoFenceInfo.getRangeLeftBottomLon());
        sQLiteStatement.bindDouble(14, lccGeoFenceInfo.getRangeLeftBottomLat());
        sQLiteStatement.bindDouble(15, lccGeoFenceInfo.getRangeRightTopLon());
        sQLiteStatement.bindDouble(16, lccGeoFenceInfo.getRangeRightTopLat());
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
    public LccGeoFenceInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        return new LccGeoFenceInfo(valueOf, string, string2, cursor.getFloat(i + 3), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.getInt(i + 5), cursor.getInt(i + 6), cursor.getInt(i + 7), cursor.getInt(i + 8), cursor.getInt(i + 9), cursor.getInt(i + 10), cursor.getInt(i + 11), cursor.getDouble(i + 12), cursor.getDouble(i + 13), cursor.getDouble(i + 14), cursor.getDouble(i + 15));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, LccGeoFenceInfo lccGeoFenceInfo, int i) {
        int i2 = i + 0;
        lccGeoFenceInfo.setDbId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        lccGeoFenceInfo.setFenceId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        lccGeoFenceInfo.setRoadName(cursor.isNull(i4) ? null : cursor.getString(i4));
        lccGeoFenceInfo.setRoadDir(cursor.getFloat(i + 3));
        int i5 = i + 4;
        lccGeoFenceInfo.setCityCode(cursor.isNull(i5) ? null : cursor.getString(i5));
        lccGeoFenceInfo.setType1(cursor.getInt(i + 5));
        lccGeoFenceInfo.setType2(cursor.getInt(i + 6));
        lccGeoFenceInfo.setAction(cursor.getInt(i + 7));
        lccGeoFenceInfo.setDangerLaneNumber(cursor.getInt(i + 8));
        lccGeoFenceInfo.setDangerLane(cursor.getInt(i + 9));
        lccGeoFenceInfo.setDangerType(cursor.getInt(i + 10));
        lccGeoFenceInfo.setDangerLevel(cursor.getInt(i + 11));
        lccGeoFenceInfo.setRangeLeftBottomLon(cursor.getDouble(i + 12));
        lccGeoFenceInfo.setRangeLeftBottomLat(cursor.getDouble(i + 13));
        lccGeoFenceInfo.setRangeRightTopLon(cursor.getDouble(i + 14));
        lccGeoFenceInfo.setRangeRightTopLat(cursor.getDouble(i + 15));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(LccGeoFenceInfo lccGeoFenceInfo, long j) {
        lccGeoFenceInfo.setDbId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(LccGeoFenceInfo lccGeoFenceInfo) {
        if (lccGeoFenceInfo != null) {
            return lccGeoFenceInfo.getDbId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(LccGeoFenceInfo lccGeoFenceInfo) {
        return lccGeoFenceInfo.getDbId() != null;
    }
}
