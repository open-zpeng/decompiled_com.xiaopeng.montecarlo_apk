package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.VPAInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes3.dex */
public class VPAInfoDao extends AbstractDao<VPAInfo, Long> {
    public static final String TABLENAME = "VPAINFO";

    /* loaded from: classes3.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, VuiConstants.ELEMENT_ID);
        public static final Property CityCode = new Property(1, String.class, "cityCode", false, "city_code");
        public static final Property CityName = new Property(2, String.class, "cityName", false, "city_name");
        public static final Property GarageId = new Property(3, String.class, "garageId", false, "garage_id");
        public static final Property Path = new Property(4, String.class, "path", false, "path");
        public static final Property Lon = new Property(5, Double.TYPE, CPSearchParam.PARAM_KEY_LON, false, CPSearchParam.PARAM_KEY_LON);
        public static final Property Lat = new Property(6, Double.TYPE, CPSearchParam.PARAM_KEY_LAT, false, CPSearchParam.PARAM_KEY_LAT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public VPAInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public VPAInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"VPAINFO\" (\"id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"city_code\" TEXT,\"city_name\" TEXT,\"garage_id\" TEXT,\"path\" TEXT,\"lon\" REAL NOT NULL ,\"lat\" REAL NOT NULL );");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"VPAINFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, VPAInfo vPAInfo) {
        databaseStatement.clearBindings();
        Long id = vPAInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String cityCode = vPAInfo.getCityCode();
        if (cityCode != null) {
            databaseStatement.bindString(2, cityCode);
        }
        String cityName = vPAInfo.getCityName();
        if (cityName != null) {
            databaseStatement.bindString(3, cityName);
        }
        String garageId = vPAInfo.getGarageId();
        if (garageId != null) {
            databaseStatement.bindString(4, garageId);
        }
        String path = vPAInfo.getPath();
        if (path != null) {
            databaseStatement.bindString(5, path);
        }
        databaseStatement.bindDouble(6, vPAInfo.getLon());
        databaseStatement.bindDouble(7, vPAInfo.getLat());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, VPAInfo vPAInfo) {
        sQLiteStatement.clearBindings();
        Long id = vPAInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String cityCode = vPAInfo.getCityCode();
        if (cityCode != null) {
            sQLiteStatement.bindString(2, cityCode);
        }
        String cityName = vPAInfo.getCityName();
        if (cityName != null) {
            sQLiteStatement.bindString(3, cityName);
        }
        String garageId = vPAInfo.getGarageId();
        if (garageId != null) {
            sQLiteStatement.bindString(4, garageId);
        }
        String path = vPAInfo.getPath();
        if (path != null) {
            sQLiteStatement.bindString(5, path);
        }
        sQLiteStatement.bindDouble(6, vPAInfo.getLon());
        sQLiteStatement.bindDouble(7, vPAInfo.getLat());
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
    public VPAInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string3 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        return new VPAInfo(valueOf, string, string2, string3, cursor.isNull(i6) ? null : cursor.getString(i6), cursor.getDouble(i + 5), cursor.getDouble(i + 6));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, VPAInfo vPAInfo, int i) {
        int i2 = i + 0;
        vPAInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        vPAInfo.setCityCode(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        vPAInfo.setCityName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        vPAInfo.setGarageId(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        vPAInfo.setPath(cursor.isNull(i6) ? null : cursor.getString(i6));
        vPAInfo.setLon(cursor.getDouble(i + 5));
        vPAInfo.setLat(cursor.getDouble(i + 6));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(VPAInfo vPAInfo, long j) {
        vPAInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(VPAInfo vPAInfo) {
        if (vPAInfo != null) {
            return vPAInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(VPAInfo vPAInfo) {
        return vPAInfo.getId() != null;
    }
}
