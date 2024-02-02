package com.xiaopeng.montecarlo.navcore.database;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CarWashInfo;
import com.xiaopeng.montecarlo.navcore.greendao.CarWashInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public class CarWashDataHelper {
    private static final L.Tag TAG = new L.Tag("CarWashDataHelper");

    public static boolean insert(CarWashInfo carWashInfo) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            return daoSession.insert(carWashInfo) >= 0;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public static boolean replaceAll(final List<CarWashInfo> list) {
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list)) {
            try {
                Callable<Boolean> callable = new Callable<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.database.CarWashDataHelper.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        DaoSession.this.deleteAll(CarWashInfo.class);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (DaoSession.this.insert((CarWashInfo) it.next()) < 0) {
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

    public static boolean update(CarWashInfo carWashInfo) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.update(carWashInfo);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public static boolean delete(CarWashInfo carWashInfo) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.delete(carWashInfo);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public static List<CarWashInfo> listAll() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return null;
        }
        return daoSession.loadAll(CarWashInfo.class);
    }

    public static CarWashInfo listAll(long j) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return null;
        }
        return (CarWashInfo) daoSession.load(CarWashInfo.class, Long.valueOf(j));
    }

    public static List<CarWashInfo> query(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, int i, int i2) {
        List<CarWashInfo> list;
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null || coord2DDouble == null) {
            return null;
        }
        if (L.ENABLE) {
            L.d(TAG, "begin query");
        }
        if (L.ENABLE) {
            L.d(TAG, "query:lon = " + coord2DDouble.lon + ",lat = " + coord2DDouble.lat + ",radius = " + i);
        }
        String str = CarWashInfoDao.Properties.Longitude.columnName;
        String str2 = CarWashInfoDao.Properties.Latitude.columnName;
        StringBuilder sb = new StringBuilder();
        sb.append("where abs(");
        sb.append(str);
        sb.append("-");
        sb.append(coord2DDouble.lon);
        sb.append(") * abs(");
        sb.append(str);
        sb.append("-");
        sb.append(coord2DDouble.lon);
        sb.append(") + abs(");
        sb.append(str2);
        sb.append("-");
        sb.append(coord2DDouble.lat);
        sb.append(") * abs(");
        sb.append(str2);
        sb.append("-");
        sb.append(coord2DDouble.lat);
        sb.append(") < ");
        double d = (i / 1000) * 0.01d;
        sb.append(d * d);
        sb.append(" limit ");
        sb.append(i2);
        try {
            list = daoSession.queryRaw(CarWashInfo.class, sb.toString(), new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (coord2DDouble2 != null) {
            for (CarWashInfo carWashInfo : list) {
                double distance = LocationUtils.getDistance(new XPCoordinate2DDouble(carWashInfo.getLongitude(), carWashInfo.getLatitude()), new XPCoordinate2DDouble(coord2DDouble2));
                if (distance <= i) {
                    carWashInfo.setDistance(distance);
                    arrayList.add(carWashInfo);
                }
            }
        }
        list.clear();
        list.addAll(arrayList);
        arrayList.clear();
        Collections.sort(list, new Comparator<CarWashInfo>() { // from class: com.xiaopeng.montecarlo.navcore.database.CarWashDataHelper.2
            @Override // java.util.Comparator
            public int compare(CarWashInfo carWashInfo2, CarWashInfo carWashInfo3) {
                if (carWashInfo2.getDistance() > carWashInfo3.getDistance()) {
                    return 1;
                }
                return carWashInfo2.getDistance() < carWashInfo3.getDistance() ? -1 : 0;
            }
        });
        if (L.ENABLE) {
            L.d(TAG, "end query size: " + list.size());
        }
        return list;
    }

    public static boolean clearData() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.deleteAll(CarWashInfo.class);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
}
