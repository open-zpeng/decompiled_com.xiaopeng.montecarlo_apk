package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPServiceCenterInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes3.dex */
public class XPServiceCenterInfoDao extends AbstractDao<XPServiceCenterInfo, Long> {
    public static final String TABLENAME = "XPSERVICE_CENTER_INFO";

    /* loaded from: classes3.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, "_id");
        public static final Property StationId = new Property(1, String.class, CPSearchParam.PARAM_KEY_STATIONID, false, "STATION_ID");
        public static final Property AutoId = new Property(2, String.class, "autoId", false, "AUTO_ID");
        public static final Property Name = new Property(3, String.class, "name", false, "NAME");
        public static final Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public static final Property Category = new Property(5, String.class, "category", false, "CATEGORY");
        public static final Property Source = new Property(6, Integer.TYPE, "source", false, "SOURCE");
        public static final Property Province = new Property(7, String.class, "province", false, "PROVINCE");
        public static final Property City = new Property(8, String.class, CPSearchParam.PARAM_KEY_CITY, false, "CITY");
        public static final Property SubCity = new Property(9, String.class, "subCity", false, "SUB_CITY");
        public static final Property Lon = new Property(10, Double.TYPE, CPSearchParam.PARAM_KEY_LON, false, "LON");
        public static final Property Lat = new Property(11, Double.TYPE, CPSearchParam.PARAM_KEY_LAT, false, "LAT");
        public static final Property Phone = new Property(12, String.class, "phone", false, "PHONE");
        public static final Property Imgs = new Property(13, String.class, "imgs", false, "IMGS");
        public static final Property BusiTime = new Property(14, String.class, "busiTime", false, "BUSI_TIME");
        public static final Property Chargeable = new Property(15, Boolean.TYPE, "chargeable", false, "CHARGEABLE");
        public static final Property Visible = new Property(16, Boolean.TYPE, "visible", false, "VISIBLE");
        public static final Property Status = new Property(17, Integer.TYPE, "status", false, "STATUS");
        public static final Property Type = new Property(18, Integer.TYPE, "type", false, "TYPE");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public XPServiceCenterInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public XPServiceCenterInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"XPSERVICE_CENTER_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"STATION_ID\" TEXT NOT NULL UNIQUE ,\"AUTO_ID\" TEXT,\"NAME\" TEXT,\"ADDRESS\" TEXT,\"CATEGORY\" TEXT,\"SOURCE\" INTEGER NOT NULL ,\"PROVINCE\" TEXT,\"CITY\" TEXT,\"SUB_CITY\" TEXT,\"LON\" REAL NOT NULL ,\"LAT\" REAL NOT NULL ,\"PHONE\" TEXT,\"IMGS\" TEXT,\"BUSI_TIME\" TEXT,\"CHARGEABLE\" INTEGER NOT NULL ,\"VISIBLE\" INTEGER NOT NULL ,\"STATUS\" INTEGER NOT NULL ,\"TYPE\" INTEGER NOT NULL );");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"XPSERVICE_CENTER_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, XPServiceCenterInfo xPServiceCenterInfo) {
        databaseStatement.clearBindings();
        Long id = xPServiceCenterInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindString(2, xPServiceCenterInfo.getStationId());
        String autoId = xPServiceCenterInfo.getAutoId();
        if (autoId != null) {
            databaseStatement.bindString(3, autoId);
        }
        String name = xPServiceCenterInfo.getName();
        if (name != null) {
            databaseStatement.bindString(4, name);
        }
        String address = xPServiceCenterInfo.getAddress();
        if (address != null) {
            databaseStatement.bindString(5, address);
        }
        String category = xPServiceCenterInfo.getCategory();
        if (category != null) {
            databaseStatement.bindString(6, category);
        }
        databaseStatement.bindLong(7, xPServiceCenterInfo.getSource());
        String province = xPServiceCenterInfo.getProvince();
        if (province != null) {
            databaseStatement.bindString(8, province);
        }
        String city = xPServiceCenterInfo.getCity();
        if (city != null) {
            databaseStatement.bindString(9, city);
        }
        String subCity = xPServiceCenterInfo.getSubCity();
        if (subCity != null) {
            databaseStatement.bindString(10, subCity);
        }
        databaseStatement.bindDouble(11, xPServiceCenterInfo.getLon());
        databaseStatement.bindDouble(12, xPServiceCenterInfo.getLat());
        String phone = xPServiceCenterInfo.getPhone();
        if (phone != null) {
            databaseStatement.bindString(13, phone);
        }
        String imgs = xPServiceCenterInfo.getImgs();
        if (imgs != null) {
            databaseStatement.bindString(14, imgs);
        }
        String busiTime = xPServiceCenterInfo.getBusiTime();
        if (busiTime != null) {
            databaseStatement.bindString(15, busiTime);
        }
        databaseStatement.bindLong(16, xPServiceCenterInfo.getChargeable() ? 1L : 0L);
        databaseStatement.bindLong(17, xPServiceCenterInfo.getVisible() ? 1L : 0L);
        databaseStatement.bindLong(18, xPServiceCenterInfo.getStatus());
        databaseStatement.bindLong(19, xPServiceCenterInfo.getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, XPServiceCenterInfo xPServiceCenterInfo) {
        sQLiteStatement.clearBindings();
        Long id = xPServiceCenterInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindString(2, xPServiceCenterInfo.getStationId());
        String autoId = xPServiceCenterInfo.getAutoId();
        if (autoId != null) {
            sQLiteStatement.bindString(3, autoId);
        }
        String name = xPServiceCenterInfo.getName();
        if (name != null) {
            sQLiteStatement.bindString(4, name);
        }
        String address = xPServiceCenterInfo.getAddress();
        if (address != null) {
            sQLiteStatement.bindString(5, address);
        }
        String category = xPServiceCenterInfo.getCategory();
        if (category != null) {
            sQLiteStatement.bindString(6, category);
        }
        sQLiteStatement.bindLong(7, xPServiceCenterInfo.getSource());
        String province = xPServiceCenterInfo.getProvince();
        if (province != null) {
            sQLiteStatement.bindString(8, province);
        }
        String city = xPServiceCenterInfo.getCity();
        if (city != null) {
            sQLiteStatement.bindString(9, city);
        }
        String subCity = xPServiceCenterInfo.getSubCity();
        if (subCity != null) {
            sQLiteStatement.bindString(10, subCity);
        }
        sQLiteStatement.bindDouble(11, xPServiceCenterInfo.getLon());
        sQLiteStatement.bindDouble(12, xPServiceCenterInfo.getLat());
        String phone = xPServiceCenterInfo.getPhone();
        if (phone != null) {
            sQLiteStatement.bindString(13, phone);
        }
        String imgs = xPServiceCenterInfo.getImgs();
        if (imgs != null) {
            sQLiteStatement.bindString(14, imgs);
        }
        String busiTime = xPServiceCenterInfo.getBusiTime();
        if (busiTime != null) {
            sQLiteStatement.bindString(15, busiTime);
        }
        sQLiteStatement.bindLong(16, xPServiceCenterInfo.getChargeable() ? 1L : 0L);
        sQLiteStatement.bindLong(17, xPServiceCenterInfo.getVisible() ? 1L : 0L);
        sQLiteStatement.bindLong(18, xPServiceCenterInfo.getStatus());
        sQLiteStatement.bindLong(19, xPServiceCenterInfo.getType());
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
    public XPServiceCenterInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        int i3 = i + 2;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = cursor.getInt(i + 6);
        int i8 = i + 7;
        String string6 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 8;
        String string7 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 9;
        String string8 = cursor.isNull(i10) ? null : cursor.getString(i10);
        double d = cursor.getDouble(i + 10);
        double d2 = cursor.getDouble(i + 11);
        int i11 = i + 12;
        String string9 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = i + 13;
        String string10 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i + 14;
        return new XPServiceCenterInfo(valueOf, string, string2, string3, string4, string5, i7, string6, string7, string8, d, d2, string9, string10, cursor.isNull(i13) ? null : cursor.getString(i13), cursor.getShort(i + 15) != 0, cursor.getShort(i + 16) != 0, cursor.getInt(i + 17), cursor.getInt(i + 18));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, XPServiceCenterInfo xPServiceCenterInfo, int i) {
        int i2 = i + 0;
        xPServiceCenterInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        xPServiceCenterInfo.setStationId(cursor.getString(i + 1));
        int i3 = i + 2;
        xPServiceCenterInfo.setAutoId(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        xPServiceCenterInfo.setName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        xPServiceCenterInfo.setAddress(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        xPServiceCenterInfo.setCategory(cursor.isNull(i6) ? null : cursor.getString(i6));
        xPServiceCenterInfo.setSource(cursor.getInt(i + 6));
        int i7 = i + 7;
        xPServiceCenterInfo.setProvince(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 8;
        xPServiceCenterInfo.setCity(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 9;
        xPServiceCenterInfo.setSubCity(cursor.isNull(i9) ? null : cursor.getString(i9));
        xPServiceCenterInfo.setLon(cursor.getDouble(i + 10));
        xPServiceCenterInfo.setLat(cursor.getDouble(i + 11));
        int i10 = i + 12;
        xPServiceCenterInfo.setPhone(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 13;
        xPServiceCenterInfo.setImgs(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 14;
        xPServiceCenterInfo.setBusiTime(cursor.isNull(i12) ? null : cursor.getString(i12));
        xPServiceCenterInfo.setChargeable(cursor.getShort(i + 15) != 0);
        xPServiceCenterInfo.setVisible(cursor.getShort(i + 16) != 0);
        xPServiceCenterInfo.setStatus(cursor.getInt(i + 17));
        xPServiceCenterInfo.setType(cursor.getInt(i + 18));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(XPServiceCenterInfo xPServiceCenterInfo, long j) {
        xPServiceCenterInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(XPServiceCenterInfo xPServiceCenterInfo) {
        if (xPServiceCenterInfo != null) {
            return xPServiceCenterInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(XPServiceCenterInfo xPServiceCenterInfo) {
        return xPServiceCenterInfo.getId() != null;
    }
}
