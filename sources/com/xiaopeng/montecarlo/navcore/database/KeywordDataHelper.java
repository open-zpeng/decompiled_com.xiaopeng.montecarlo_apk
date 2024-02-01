package com.xiaopeng.montecarlo.navcore.database;

import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes3.dex */
public class KeywordDataHelper {
    private static final L.Tag TAG = new L.Tag("KeywordDataHelper");

    public static boolean replaceAll(final List<XPKeywordConfigInfo> list) {
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list)) {
            try {
                Callable<Boolean> callable = new Callable<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.database.KeywordDataHelper.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        DaoSession.this.deleteAll(XPKeywordConfigInfo.class);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (DaoSession.this.insert((XPKeywordConfigInfo) it.next()) < 0) {
                                throw new Exception();
                            }
                        }
                        return true;
                    }
                };
                if (L.ENABLE) {
                    L.d(TAG, "begin insert");
                }
                z = ((Boolean) daoSession.callInTx(callable)).booleanValue();
                if (L.ENABLE) {
                    L.d(TAG, "end insert");
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return z;
    }

    public static List<XPKeywordConfigInfo> listAll() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return null;
        }
        return daoSession.loadAll(XPKeywordConfigInfo.class);
    }

    public static boolean clearData() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.deleteAll(XPKeywordConfigInfo.class);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
}
