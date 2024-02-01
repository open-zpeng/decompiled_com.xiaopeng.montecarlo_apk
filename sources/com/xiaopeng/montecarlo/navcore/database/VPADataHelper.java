package com.xiaopeng.montecarlo.navcore.database;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.VPAInfo;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.navcore.greendao.VPAInfoDao;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.query.WhereCondition;
/* loaded from: classes3.dex */
public class VPADataHelper {
    private static final L.Tag TAG = new L.Tag("VPADataHelper");

    public static boolean replaceAllData(final List<VPAInfo> list) {
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list)) {
            try {
                Callable callable = new Callable() { // from class: com.xiaopeng.montecarlo.navcore.database.-$$Lambda$VPADataHelper$8ok92sdXyz6LuwUXw9HRVYesWco
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return VPADataHelper.lambda$replaceAllData$0(DaoSession.this, list);
                    }
                };
                if (L.ENABLE) {
                    L.d(TAG, "replaceAllData begin insert");
                }
                z = ((Boolean) daoSession.callInTx(callable)).booleanValue();
                if (L.ENABLE) {
                    L.d(TAG, "replaceAllData end insert");
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$replaceAllData$0(DaoSession daoSession, List list) throws Exception {
        daoSession.deleteAll(VPAInfo.class);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (daoSession.insert((VPAInfo) it.next()) < 0) {
                throw new Exception();
            }
        }
        return true;
    }

    public static List<XPPoiInfo> query(Coord2DDouble[] coord2DDoubleArr) {
        List list;
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null || coord2DDoubleArr == null) {
            return null;
        }
        if (L.ENABLE) {
            L.d(TAG, "query coord2DDoubles = " + Arrays.toString(coord2DDoubleArr));
        }
        int length = coord2DDoubleArr.length;
        double d = 0.0d;
        int i = 0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        while (i < length) {
            Coord2DDouble coord2DDouble = coord2DDoubleArr[i];
            if (coord2DDouble != null) {
                if (d == d2 || d == d3 || d == d4 || d == d5) {
                    d2 = coord2DDouble.lon;
                    d3 = coord2DDouble.lon;
                    d4 = coord2DDouble.lat;
                    d5 = coord2DDouble.lat;
                }
                if (coord2DDouble.lon < d2) {
                    d2 = coord2DDouble.lon;
                }
                if (coord2DDouble.lon > d3) {
                    d3 = coord2DDouble.lon;
                }
                if (coord2DDouble.lat < d4) {
                    d4 = coord2DDouble.lat;
                }
                if (coord2DDouble.lat > d5) {
                    d5 = coord2DDouble.lat;
                }
            }
            i++;
            d = 0.0d;
        }
        if (d2 >= d3 || d4 >= d5) {
            if (L.ENABLE) {
                L.d(TAG, "error date:" + d2 + " " + d3 + " " + d4 + " " + d5);
                return null;
            }
            return null;
        }
        if (L.ENABLE) {
            L.d(TAG, "minLon:" + d2 + " , maxLon：" + d3 + " , minLat：" + d4 + " , maxLat：" + d5);
        }
        try {
            list = daoSession.queryBuilder(VPAInfo.class).where(VPAInfoDao.Properties.Lon.between(Double.valueOf(d2), Double.valueOf(d3)), new WhereCondition[0]).where(VPAInfoDao.Properties.Lat.between(Double.valueOf(d4), Double.valueOf(d5)), new WhereCondition[0]).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (L.ENABLE) {
                L.d(TAG, "Exception:" + e.toString());
            }
            list = null;
        }
        ArrayList<XPPoiInfo> xPPoiInfo = VPAInfo.toXPPoiInfo(list);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("end query size: ");
            sb.append(CollectionUtils.isEmpty(xPPoiInfo) ? 0 : xPPoiInfo.size());
            L.d(tag, sb.toString());
        }
        return xPPoiInfo;
    }

    public static boolean clearData() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.deleteAll(VPAInfo.class);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
}
