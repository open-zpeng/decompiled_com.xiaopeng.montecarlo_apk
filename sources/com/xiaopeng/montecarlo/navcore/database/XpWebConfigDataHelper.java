package com.xiaopeng.montecarlo.navcore.database;

import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPWebConfigInfo;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.navcore.greendao.XPWebConfigInfoDao;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;
import org.greenrobot.greendao.query.WhereCondition;
/* loaded from: classes3.dex */
public class XpWebConfigDataHelper {
    private static final L.Tag TAG = new L.Tag("XpWebConfigDataHelper");

    public boolean insertOrUpdate(String str, String str2) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            L.w(TAG, "session is null");
            return false;
        }
        try {
            XPWebConfigInfo xPWebConfigInfo = new XPWebConfigInfo();
            xPWebConfigInfo.setKey(str);
            xPWebConfigInfo.setValue(str2);
            xPWebConfigInfo.setUpdateTime(new Date());
            return daoSession.insertOrReplace(xPWebConfigInfo) > 0;
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
            L.w(TAG, "insert failed");
            return false;
        }
    }

    private String getValue(String str, String str2) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return str2;
        }
        try {
            return (String) Optional.ofNullable((XPWebConfigInfo) daoSession.queryBuilder(XPWebConfigInfo.class).where(XPWebConfigInfoDao.Properties.Key.eq(str), new WhereCondition[0]).build().unique()).map(new Function() { // from class: com.xiaopeng.montecarlo.navcore.database.-$$Lambda$cxWFdFsXDXe4UYHqxXLtNS_ROm8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((XPWebConfigInfo) obj).getValue();
                }
            }).orElse(str2);
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
            return str2;
        }
    }

    public String getValue(WebConfigurationEnum webConfigurationEnum) {
        return getValue(webConfigurationEnum.getKey(), webConfigurationEnum.getDefaultValue());
    }
}
