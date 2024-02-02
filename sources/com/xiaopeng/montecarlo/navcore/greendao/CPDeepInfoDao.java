package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CPDeepInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes2.dex */
public class CPDeepInfoDao extends AbstractDao<CPDeepInfo, Long> {
    public static final String TABLENAME = "CPDEEP_INFO";

    /* loaded from: classes2.dex */
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
        public static final Property FastNums = new Property(10, Integer.TYPE, "fastNums", false, "FAST_NUMS");
        public static final Property FastFreeNums = new Property(11, Integer.TYPE, "fastFreeNums", false, "FAST_FREE_NUMS");
        public static final Property SlowNums = new Property(12, Integer.TYPE, "slowNums", false, "SLOW_NUMS");
        public static final Property SlowFreeNums = new Property(13, Integer.TYPE, "slowFreeNums", false, "SLOW_FREE_NUMS");
        public static final Property FreeNums = new Property(14, Integer.TYPE, "freeNums", false, "FREE_NUMS");
        public static final Property Distance = new Property(15, String.class, "distance", false, "DISTANCE");
        public static final Property ServiceTel = new Property(16, String.class, "serviceTel", false, "SERVICE_TEL");
        public static final Property BusiTime = new Property(17, String.class, "busiTime", false, "BUSI_TIME");
        public static final Property Payment = new Property(18, String.class, "payment", false, "PAYMENT");
        public static final Property LineOrder = new Property(19, String.class, "lineOrder", false, "LINE_ORDER");
        public static final Property EvaScore = new Property(20, Float.TYPE, "evaScore", false, "EVA_SCORE");
        public static final Property EvaNum = new Property(21, Integer.TYPE, "evaNum", false, "EVA_NUM");
        public static final Property ChcRemark = new Property(22, String.class, "chcRemark", false, "CHC_REMARK");
        public static final Property StoreFlag = new Property(23, Byte.TYPE, "storeFlag", false, "STORE_FLAG");
        public static final Property ServiceAmt = new Property(24, Float.TYPE, "serviceAmt", false, "SERVICE_AMT");
        public static final Property ChargeAmt = new Property(25, Float.TYPE, "chargeAmt", false, "CHARGE_AMT");
        public static final Property ChrgCnt = new Property(26, Integer.TYPE, "chrgCnt", false, "CHRG_CNT");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public CPDeepInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public CPDeepInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"CPDEEP_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"CITY_CODE\" TEXT,\"STATION_ID\" TEXT NOT NULL UNIQUE ,\"STATION_NAME\" TEXT,\"STATION_ADDR\" TEXT,\"OPER_ID\" TEXT,\"OPER_NAME\" TEXT,\"SELF_SUPPORT_FLAG\" INTEGER NOT NULL ,\"LON\" REAL NOT NULL ,\"LAT\" REAL NOT NULL ,\"FAST_NUMS\" INTEGER NOT NULL ,\"FAST_FREE_NUMS\" INTEGER NOT NULL ,\"SLOW_NUMS\" INTEGER NOT NULL ,\"SLOW_FREE_NUMS\" INTEGER NOT NULL ,\"FREE_NUMS\" INTEGER NOT NULL ,\"DISTANCE\" TEXT,\"SERVICE_TEL\" TEXT,\"BUSI_TIME\" TEXT,\"PAYMENT\" TEXT,\"LINE_ORDER\" TEXT,\"EVA_SCORE\" REAL NOT NULL ,\"EVA_NUM\" INTEGER NOT NULL ,\"CHC_REMARK\" TEXT,\"STORE_FLAG\" INTEGER NOT NULL ,\"SERVICE_AMT\" REAL NOT NULL ,\"CHARGE_AMT\" REAL NOT NULL ,\"CHRG_CNT\" INTEGER NOT NULL );");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"CPDEEP_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, CPDeepInfo cPDeepInfo) {
        databaseStatement.clearBindings();
        Long id = cPDeepInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String cityCode = cPDeepInfo.getCityCode();
        if (cityCode != null) {
            databaseStatement.bindString(2, cityCode);
        }
        databaseStatement.bindString(3, cPDeepInfo.getStationId());
        String stationName = cPDeepInfo.getStationName();
        if (stationName != null) {
            databaseStatement.bindString(4, stationName);
        }
        String stationAddr = cPDeepInfo.getStationAddr();
        if (stationAddr != null) {
            databaseStatement.bindString(5, stationAddr);
        }
        String operId = cPDeepInfo.getOperId();
        if (operId != null) {
            databaseStatement.bindString(6, operId);
        }
        String operName = cPDeepInfo.getOperName();
        if (operName != null) {
            databaseStatement.bindString(7, operName);
        }
        databaseStatement.bindLong(8, cPDeepInfo.getSelfSupportFlag());
        databaseStatement.bindDouble(9, cPDeepInfo.getLon());
        databaseStatement.bindDouble(10, cPDeepInfo.getLat());
        databaseStatement.bindLong(11, cPDeepInfo.getFastNums());
        databaseStatement.bindLong(12, cPDeepInfo.getFastFreeNums());
        databaseStatement.bindLong(13, cPDeepInfo.getSlowNums());
        databaseStatement.bindLong(14, cPDeepInfo.getSlowFreeNums());
        databaseStatement.bindLong(15, cPDeepInfo.getFreeNums());
        String distance = cPDeepInfo.getDistance();
        if (distance != null) {
            databaseStatement.bindString(16, distance);
        }
        String serviceTel = cPDeepInfo.getServiceTel();
        if (serviceTel != null) {
            databaseStatement.bindString(17, serviceTel);
        }
        String busiTime = cPDeepInfo.getBusiTime();
        if (busiTime != null) {
            databaseStatement.bindString(18, busiTime);
        }
        String payment = cPDeepInfo.getPayment();
        if (payment != null) {
            databaseStatement.bindString(19, payment);
        }
        String lineOrder = cPDeepInfo.getLineOrder();
        if (lineOrder != null) {
            databaseStatement.bindString(20, lineOrder);
        }
        databaseStatement.bindDouble(21, cPDeepInfo.getEvaScore());
        databaseStatement.bindLong(22, cPDeepInfo.getEvaNum());
        String chcRemark = cPDeepInfo.getChcRemark();
        if (chcRemark != null) {
            databaseStatement.bindString(23, chcRemark);
        }
        databaseStatement.bindLong(24, cPDeepInfo.getStoreFlag());
        databaseStatement.bindDouble(25, cPDeepInfo.getServiceAmt());
        databaseStatement.bindDouble(26, cPDeepInfo.getChargeAmt());
        databaseStatement.bindLong(27, cPDeepInfo.getChrgCnt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, CPDeepInfo cPDeepInfo) {
        sQLiteStatement.clearBindings();
        Long id = cPDeepInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String cityCode = cPDeepInfo.getCityCode();
        if (cityCode != null) {
            sQLiteStatement.bindString(2, cityCode);
        }
        sQLiteStatement.bindString(3, cPDeepInfo.getStationId());
        String stationName = cPDeepInfo.getStationName();
        if (stationName != null) {
            sQLiteStatement.bindString(4, stationName);
        }
        String stationAddr = cPDeepInfo.getStationAddr();
        if (stationAddr != null) {
            sQLiteStatement.bindString(5, stationAddr);
        }
        String operId = cPDeepInfo.getOperId();
        if (operId != null) {
            sQLiteStatement.bindString(6, operId);
        }
        String operName = cPDeepInfo.getOperName();
        if (operName != null) {
            sQLiteStatement.bindString(7, operName);
        }
        sQLiteStatement.bindLong(8, cPDeepInfo.getSelfSupportFlag());
        sQLiteStatement.bindDouble(9, cPDeepInfo.getLon());
        sQLiteStatement.bindDouble(10, cPDeepInfo.getLat());
        sQLiteStatement.bindLong(11, cPDeepInfo.getFastNums());
        sQLiteStatement.bindLong(12, cPDeepInfo.getFastFreeNums());
        sQLiteStatement.bindLong(13, cPDeepInfo.getSlowNums());
        sQLiteStatement.bindLong(14, cPDeepInfo.getSlowFreeNums());
        sQLiteStatement.bindLong(15, cPDeepInfo.getFreeNums());
        String distance = cPDeepInfo.getDistance();
        if (distance != null) {
            sQLiteStatement.bindString(16, distance);
        }
        String serviceTel = cPDeepInfo.getServiceTel();
        if (serviceTel != null) {
            sQLiteStatement.bindString(17, serviceTel);
        }
        String busiTime = cPDeepInfo.getBusiTime();
        if (busiTime != null) {
            sQLiteStatement.bindString(18, busiTime);
        }
        String payment = cPDeepInfo.getPayment();
        if (payment != null) {
            sQLiteStatement.bindString(19, payment);
        }
        String lineOrder = cPDeepInfo.getLineOrder();
        if (lineOrder != null) {
            sQLiteStatement.bindString(20, lineOrder);
        }
        sQLiteStatement.bindDouble(21, cPDeepInfo.getEvaScore());
        sQLiteStatement.bindLong(22, cPDeepInfo.getEvaNum());
        String chcRemark = cPDeepInfo.getChcRemark();
        if (chcRemark != null) {
            sQLiteStatement.bindString(23, chcRemark);
        }
        sQLiteStatement.bindLong(24, cPDeepInfo.getStoreFlag());
        sQLiteStatement.bindDouble(25, cPDeepInfo.getServiceAmt());
        sQLiteStatement.bindDouble(26, cPDeepInfo.getChargeAmt());
        sQLiteStatement.bindLong(27, cPDeepInfo.getChrgCnt());
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
    public CPDeepInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        String string2 = cursor.getString(i + 2);
        int i4 = i + 3;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 6;
        String string6 = cursor.isNull(i7) ? null : cursor.getString(i7);
        byte b = (byte) cursor.getShort(i + 7);
        double d = cursor.getDouble(i + 8);
        double d2 = cursor.getDouble(i + 9);
        int i8 = cursor.getInt(i + 10);
        int i9 = cursor.getInt(i + 11);
        int i10 = cursor.getInt(i + 12);
        int i11 = cursor.getInt(i + 13);
        int i12 = cursor.getInt(i + 14);
        int i13 = i + 15;
        String string7 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 16;
        String string8 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 17;
        String string9 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 18;
        String string10 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 19;
        String string11 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 22;
        return new CPDeepInfo(valueOf, string, string2, string3, string4, string5, string6, b, d, d2, i8, i9, i10, i11, i12, string7, string8, string9, string10, string11, cursor.getFloat(i + 20), cursor.getInt(i + 21), cursor.isNull(i18) ? null : cursor.getString(i18), (byte) cursor.getShort(i + 23), cursor.getFloat(i + 24), cursor.getFloat(i + 25), cursor.getInt(i + 26));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, CPDeepInfo cPDeepInfo, int i) {
        int i2 = i + 0;
        cPDeepInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        cPDeepInfo.setCityCode(cursor.isNull(i3) ? null : cursor.getString(i3));
        cPDeepInfo.setStationId(cursor.getString(i + 2));
        int i4 = i + 3;
        cPDeepInfo.setStationName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        cPDeepInfo.setStationAddr(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        cPDeepInfo.setOperId(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 6;
        cPDeepInfo.setOperName(cursor.isNull(i7) ? null : cursor.getString(i7));
        cPDeepInfo.setSelfSupportFlag((byte) cursor.getShort(i + 7));
        cPDeepInfo.setLon(cursor.getDouble(i + 8));
        cPDeepInfo.setLat(cursor.getDouble(i + 9));
        cPDeepInfo.setFastNums(cursor.getInt(i + 10));
        cPDeepInfo.setFastFreeNums(cursor.getInt(i + 11));
        cPDeepInfo.setSlowNums(cursor.getInt(i + 12));
        cPDeepInfo.setSlowFreeNums(cursor.getInt(i + 13));
        cPDeepInfo.setFreeNums(cursor.getInt(i + 14));
        int i8 = i + 15;
        cPDeepInfo.setDistance(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 16;
        cPDeepInfo.setServiceTel(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 17;
        cPDeepInfo.setBusiTime(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 18;
        cPDeepInfo.setPayment(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 19;
        cPDeepInfo.setLineOrder(cursor.isNull(i12) ? null : cursor.getString(i12));
        cPDeepInfo.setEvaScore(cursor.getFloat(i + 20));
        cPDeepInfo.setEvaNum(cursor.getInt(i + 21));
        int i13 = i + 22;
        cPDeepInfo.setChcRemark(cursor.isNull(i13) ? null : cursor.getString(i13));
        cPDeepInfo.setStoreFlag((byte) cursor.getShort(i + 23));
        cPDeepInfo.setServiceAmt(cursor.getFloat(i + 24));
        cPDeepInfo.setChargeAmt(cursor.getFloat(i + 25));
        cPDeepInfo.setChrgCnt(cursor.getInt(i + 26));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(CPDeepInfo cPDeepInfo, long j) {
        cPDeepInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(CPDeepInfo cPDeepInfo) {
        if (cPDeepInfo != null) {
            return cPDeepInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(CPDeepInfo cPDeepInfo) {
        return cPDeepInfo.getId() != null;
    }
}
