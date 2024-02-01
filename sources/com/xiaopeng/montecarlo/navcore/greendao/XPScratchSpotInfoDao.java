package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPScratchSpotInfo;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes3.dex */
public class XPScratchSpotInfoDao extends AbstractDao<XPScratchSpotInfo, Long> {
    public static final String TABLENAME = "XPSCRATCH_SPOT_INFO";

    /* loaded from: classes3.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, "_id");
        public static final Property StationId = new Property(1, String.class, CPSearchParam.PARAM_KEY_STATIONID, false, "STATION_ID");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Address = new Property(3, String.class, "address", false, "ADDRESS");
        public static final Property Lon = new Property(4, Double.TYPE, CPSearchParam.PARAM_KEY_LON, false, "LON");
        public static final Property Lat = new Property(5, Double.TYPE, CPSearchParam.PARAM_KEY_LAT, false, "LAT");
        public static final Property Imgs = new Property(6, String.class, "imgs", false, "IMGS");
        public static final Property Intro = new Property(7, String.class, "intro", false, "INTRO");
        public static final Property BusiTime = new Property(8, String.class, "busiTime", false, "BUSI_TIME");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public XPScratchSpotInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public XPScratchSpotInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"XPSCRATCH_SPOT_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"STATION_ID\" TEXT NOT NULL UNIQUE ,\"NAME\" TEXT,\"ADDRESS\" TEXT,\"LON\" REAL NOT NULL ,\"LAT\" REAL NOT NULL ,\"IMGS\" TEXT,\"INTRO\" TEXT,\"BUSI_TIME\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"XPSCRATCH_SPOT_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, XPScratchSpotInfo xPScratchSpotInfo) {
        databaseStatement.clearBindings();
        Long id = xPScratchSpotInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindString(2, xPScratchSpotInfo.getStationId());
        String name = xPScratchSpotInfo.getName();
        if (name != null) {
            databaseStatement.bindString(3, name);
        }
        String address = xPScratchSpotInfo.getAddress();
        if (address != null) {
            databaseStatement.bindString(4, address);
        }
        databaseStatement.bindDouble(5, xPScratchSpotInfo.getLon());
        databaseStatement.bindDouble(6, xPScratchSpotInfo.getLat());
        String imgs = xPScratchSpotInfo.getImgs();
        if (imgs != null) {
            databaseStatement.bindString(7, imgs);
        }
        String intro = xPScratchSpotInfo.getIntro();
        if (intro != null) {
            databaseStatement.bindString(8, intro);
        }
        String busiTime = xPScratchSpotInfo.getBusiTime();
        if (busiTime != null) {
            databaseStatement.bindString(9, busiTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, XPScratchSpotInfo xPScratchSpotInfo) {
        sQLiteStatement.clearBindings();
        Long id = xPScratchSpotInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindString(2, xPScratchSpotInfo.getStationId());
        String name = xPScratchSpotInfo.getName();
        if (name != null) {
            sQLiteStatement.bindString(3, name);
        }
        String address = xPScratchSpotInfo.getAddress();
        if (address != null) {
            sQLiteStatement.bindString(4, address);
        }
        sQLiteStatement.bindDouble(5, xPScratchSpotInfo.getLon());
        sQLiteStatement.bindDouble(6, xPScratchSpotInfo.getLat());
        String imgs = xPScratchSpotInfo.getImgs();
        if (imgs != null) {
            sQLiteStatement.bindString(7, imgs);
        }
        String intro = xPScratchSpotInfo.getIntro();
        if (intro != null) {
            sQLiteStatement.bindString(8, intro);
        }
        String busiTime = xPScratchSpotInfo.getBusiTime();
        if (busiTime != null) {
            sQLiteStatement.bindString(9, busiTime);
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
    public XPScratchSpotInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        int i3 = i + 2;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        double d = cursor.getDouble(i + 4);
        double d2 = cursor.getDouble(i + 5);
        int i5 = i + 6;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 7;
        int i7 = i + 8;
        return new XPScratchSpotInfo(valueOf, string, string2, string3, d, d2, string4, cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, XPScratchSpotInfo xPScratchSpotInfo, int i) {
        int i2 = i + 0;
        xPScratchSpotInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        xPScratchSpotInfo.setStationId(cursor.getString(i + 1));
        int i3 = i + 2;
        xPScratchSpotInfo.setName(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        xPScratchSpotInfo.setAddress(cursor.isNull(i4) ? null : cursor.getString(i4));
        xPScratchSpotInfo.setLon(cursor.getDouble(i + 4));
        xPScratchSpotInfo.setLat(cursor.getDouble(i + 5));
        int i5 = i + 6;
        xPScratchSpotInfo.setImgs(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 7;
        xPScratchSpotInfo.setIntro(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 8;
        xPScratchSpotInfo.setBusiTime(cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(XPScratchSpotInfo xPScratchSpotInfo, long j) {
        xPScratchSpotInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(XPScratchSpotInfo xPScratchSpotInfo) {
        if (xPScratchSpotInfo != null) {
            return xPScratchSpotInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(XPScratchSpotInfo xPScratchSpotInfo) {
        return xPScratchSpotInfo.getId() != null;
    }
}
