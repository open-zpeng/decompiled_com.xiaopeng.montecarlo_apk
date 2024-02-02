package com.xiaopeng.montecarlo.navcore.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes2.dex */
public class XPKeywordConfigInfoDao extends AbstractDao<XPKeywordConfigInfo, Long> {
    public static final String TABLENAME = "XPKEYWORD_CONFIG_INFO";

    /* loaded from: classes2.dex */
    public static class Properties {
        public static final Property Id = new Property(0, Long.class, VuiConstants.ELEMENT_ID, true, "_id");
        public static final Property Category = new Property(1, String.class, "category", false, "CATEGORY");
        public static final Property Keyword = new Property(2, String.class, VoiceFusionUtil.KEY_KEYWORD, false, "KEYWORD");
        public static final Property Description = new Property(3, String.class, "description", false, "DESCRIPTION");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    public XPKeywordConfigInfoDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public XPKeywordConfigInfoDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"XPKEYWORD_CONFIG_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"CATEGORY\" TEXT NOT NULL UNIQUE ,\"KEYWORD\" TEXT,\"DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"XPKEYWORD_CONFIG_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(DatabaseStatement databaseStatement, XPKeywordConfigInfo xPKeywordConfigInfo) {
        databaseStatement.clearBindings();
        Long id = xPKeywordConfigInfo.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        databaseStatement.bindString(2, xPKeywordConfigInfo.getCategory());
        String keyword = xPKeywordConfigInfo.getKeyword();
        if (keyword != null) {
            databaseStatement.bindString(3, keyword);
        }
        String description = xPKeywordConfigInfo.getDescription();
        if (description != null) {
            databaseStatement.bindString(4, description);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final void bindValues(SQLiteStatement sQLiteStatement, XPKeywordConfigInfo xPKeywordConfigInfo) {
        sQLiteStatement.clearBindings();
        Long id = xPKeywordConfigInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindString(2, xPKeywordConfigInfo.getCategory());
        String keyword = xPKeywordConfigInfo.getKeyword();
        if (keyword != null) {
            sQLiteStatement.bindString(3, keyword);
        }
        String description = xPKeywordConfigInfo.getDescription();
        if (description != null) {
            sQLiteStatement.bindString(4, description);
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
    public XPKeywordConfigInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        int i3 = i + 2;
        int i4 = i + 3;
        return new XPKeywordConfigInfo(valueOf, string, cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public void readEntity(Cursor cursor, XPKeywordConfigInfo xPKeywordConfigInfo, int i) {
        int i2 = i + 0;
        xPKeywordConfigInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        xPKeywordConfigInfo.setCategory(cursor.getString(i + 1));
        int i3 = i + 2;
        xPKeywordConfigInfo.setKeyword(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        xPKeywordConfigInfo.setDescription(cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final Long updateKeyAfterInsert(XPKeywordConfigInfo xPKeywordConfigInfo, long j) {
        xPKeywordConfigInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public Long getKey(XPKeywordConfigInfo xPKeywordConfigInfo) {
        if (xPKeywordConfigInfo != null) {
            return xPKeywordConfigInfo.getId();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.AbstractDao
    public boolean hasKey(XPKeywordConfigInfo xPKeywordConfigInfo) {
        return xPKeywordConfigInfo.getId() != null;
    }
}
