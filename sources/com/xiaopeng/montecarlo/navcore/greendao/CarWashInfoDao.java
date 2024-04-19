package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CarWashInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes2.dex */
public class CarWashInfoDao extends AbstractDao<CarWashInfo, Long> {
    public static final String TABLENAME = "CAR_WASH_INFO";

    /* loaded from: classes2.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, "_id");
        public static final Property StationId = new Property(1, String.class, CPSearchParam.PARAM_KEY_STATIONID, false, "STATION_ID");
        public static final Property Latitude = new Property(2, Double.TYPE, "latitude", false, "LATITUDE");
        public static final Property Longitude = new Property(3, Double.TYPE, "longitude", false, "LONGITUDE");
        public static final Property NavLatitude = new Property(4, Double.TYPE, "navLatitude", false, "NAV_LATITUDE");
        public static final Property NavLongitude = new Property(5, Double.TYPE, "navLongitude", false, "NAV_LONGITUDE");
        public static final Property CoordType = new Property(6, String.class, "coordType", false, "COORD_TYPE");
        public static final Property Adcode = new Property(7, String.class, "adcode", false, "ADCODE");
        public static final Property StationName = new Property(8, String.class, "stationName", false, "STATION_NAME");
        public static final Property Brand = new Property(9, String.class, "brand", false, "BRAND");
        public static final Property Address = new Property(10, String.class, "address", false, "ADDRESS");
        public static final Property Province = new Property(11, String.class, "province", false, "PROVINCE");
        public static final Property City = new Property(12, String.class, CPSearchParam.PARAM_KEY_CITY, false, "CITY");
        public static final Property SubCity = new Property(13, String.class, "subCity", false, "SUB_CITY");
        public static final Property BizTime = new Property(14, String.class, "bizTime", false, "BIZ_TIME");
        public static final Property DeviceCount = new Property(15, Integer.TYPE, "deviceCount", false, "DEVICE_COUNT");
        public static final Property Phone = new Property(16, String.class, "phone", false, "PHONE");
        public static final Property Price = new Property(17, String.class, "price", false, "PRICE");
        public static final Property Intro = new Property(18, String.class, "intro", false, "INTRO");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public CarWashInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public CarWashInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"CAR_WASH_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"STATION_ID\" TEXT NOT NULL UNIQUE ,\"LATITUDE\" REAL NOT NULL ,\"LONGITUDE\" REAL NOT NULL ,\"NAV_LATITUDE\" REAL NOT NULL ,\"NAV_LONGITUDE\" REAL NOT NULL ,\"COORD_TYPE\" TEXT,\"ADCODE\" TEXT,\"STATION_NAME\" TEXT,\"BRAND\" TEXT,\"ADDRESS\" TEXT,\"PROVINCE\" TEXT,\"CITY\" TEXT,\"SUB_CITY\" TEXT,\"BIZ_TIME\" TEXT,\"DEVICE_COUNT\" INTEGER NOT NULL ,\"PHONE\" TEXT,\"PRICE\" TEXT,\"INTRO\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"CAR_WASH_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, CarWashInfo carWashInfo) {
        databaseStatement.clearBindings();
        Long id = carWashInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindString(2, carWashInfo.getStationId());
        databaseStatement.bindDouble(3, carWashInfo.getLatitude());
        databaseStatement.bindDouble(4, carWashInfo.getLongitude());
        databaseStatement.bindDouble(5, carWashInfo.getNavLatitude());
        databaseStatement.bindDouble(6, carWashInfo.getNavLongitude());
        String coordType = carWashInfo.getCoordType();
        if (coordType != null) {
            databaseStatement.bindString(7, coordType);
        }
        String adcode = carWashInfo.getAdcode();
        if (adcode != null) {
            databaseStatement.bindString(8, adcode);
        }
        String stationName = carWashInfo.getStationName();
        if (stationName != null) {
            databaseStatement.bindString(9, stationName);
        }
        String brand = carWashInfo.getBrand();
        if (brand != null) {
            databaseStatement.bindString(10, brand);
        }
        String address = carWashInfo.getAddress();
        if (address != null) {
            databaseStatement.bindString(11, address);
        }
        String province = carWashInfo.getProvince();
        if (province != null) {
            databaseStatement.bindString(12, province);
        }
        String city = carWashInfo.getCity();
        if (city != null) {
            databaseStatement.bindString(13, city);
        }
        String subCity = carWashInfo.getSubCity();
        if (subCity != null) {
            databaseStatement.bindString(14, subCity);
        }
        String bizTime = carWashInfo.getBizTime();
        if (bizTime != null) {
            databaseStatement.bindString(15, bizTime);
        }
        databaseStatement.bindLong(16, carWashInfo.getDeviceCount());
        String phone = carWashInfo.getPhone();
        if (phone != null) {
            databaseStatement.bindString(17, phone);
        }
        String price = carWashInfo.getPrice();
        if (price != null) {
            databaseStatement.bindString(18, price);
        }
        String intro = carWashInfo.getIntro();
        if (intro != null) {
            databaseStatement.bindString(19, intro);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, CarWashInfo carWashInfo) {
        sQLiteStatement.clearBindings();
        Long id = carWashInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindString(2, carWashInfo.getStationId());
        sQLiteStatement.bindDouble(3, carWashInfo.getLatitude());
        sQLiteStatement.bindDouble(4, carWashInfo.getLongitude());
        sQLiteStatement.bindDouble(5, carWashInfo.getNavLatitude());
        sQLiteStatement.bindDouble(6, carWashInfo.getNavLongitude());
        String coordType = carWashInfo.getCoordType();
        if (coordType != null) {
            sQLiteStatement.bindString(7, coordType);
        }
        String adcode = carWashInfo.getAdcode();
        if (adcode != null) {
            sQLiteStatement.bindString(8, adcode);
        }
        String stationName = carWashInfo.getStationName();
        if (stationName != null) {
            sQLiteStatement.bindString(9, stationName);
        }
        String brand = carWashInfo.getBrand();
        if (brand != null) {
            sQLiteStatement.bindString(10, brand);
        }
        String address = carWashInfo.getAddress();
        if (address != null) {
            sQLiteStatement.bindString(11, address);
        }
        String province = carWashInfo.getProvince();
        if (province != null) {
            sQLiteStatement.bindString(12, province);
        }
        String city = carWashInfo.getCity();
        if (city != null) {
            sQLiteStatement.bindString(13, city);
        }
        String subCity = carWashInfo.getSubCity();
        if (subCity != null) {
            sQLiteStatement.bindString(14, subCity);
        }
        String bizTime = carWashInfo.getBizTime();
        if (bizTime != null) {
            sQLiteStatement.bindString(15, bizTime);
        }
        sQLiteStatement.bindLong(16, carWashInfo.getDeviceCount());
        String phone = carWashInfo.getPhone();
        if (phone != null) {
            sQLiteStatement.bindString(17, phone);
        }
        String price = carWashInfo.getPrice();
        if (price != null) {
            sQLiteStatement.bindString(18, price);
        }
        String intro = carWashInfo.getIntro();
        if (intro != null) {
            sQLiteStatement.bindString(19, intro);
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
    public CarWashInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        double d = cursor.getDouble(i + 2);
        double d2 = cursor.getDouble(i + 3);
        double d3 = cursor.getDouble(i + 4);
        double d4 = cursor.getDouble(i + 5);
        int i3 = i + 6;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 7;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 8;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 9;
        String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 10;
        String string6 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 11;
        String string7 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 12;
        String string8 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 13;
        String string9 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 14;
        String string10 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = cursor.getInt(i + 15);
        int i13 = i + 16;
        String string11 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 17;
        String string12 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 18;
        return new CarWashInfo(valueOf, string, d, d2, d3, d4, string2, string3, string4, string5, string6, string7, string8, string9, string10, i12, string11, string12, cursor.isNull(i15) ? null : cursor.getString(i15));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, CarWashInfo carWashInfo, int i) {
        int i2 = i + 0;
        carWashInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        carWashInfo.setStationId(cursor.getString(i + 1));
        carWashInfo.setLatitude(cursor.getDouble(i + 2));
        carWashInfo.setLongitude(cursor.getDouble(i + 3));
        carWashInfo.setNavLatitude(cursor.getDouble(i + 4));
        carWashInfo.setNavLongitude(cursor.getDouble(i + 5));
        int i3 = i + 6;
        carWashInfo.setCoordType(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 7;
        carWashInfo.setAdcode(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 8;
        carWashInfo.setStationName(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 9;
        carWashInfo.setBrand(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 10;
        carWashInfo.setAddress(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 11;
        carWashInfo.setProvince(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 12;
        carWashInfo.setCity(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 13;
        carWashInfo.setSubCity(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 14;
        carWashInfo.setBizTime(cursor.isNull(i11) ? null : cursor.getString(i11));
        carWashInfo.setDeviceCount(cursor.getInt(i + 15));
        int i12 = i + 16;
        carWashInfo.setPhone(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 17;
        carWashInfo.setPrice(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 18;
        carWashInfo.setIntro(cursor.isNull(i14) ? null : cursor.getString(i14));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(CarWashInfo carWashInfo, long j) {
        carWashInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(CarWashInfo carWashInfo) {
        if (carWashInfo != null) {
            return carWashInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(CarWashInfo carWashInfo) {
        return carWashInfo.getId() != null;
    }
}
