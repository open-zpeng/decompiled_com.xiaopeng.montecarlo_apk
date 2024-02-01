package com.xiaopeng.montecarlo.navcore.database;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CPInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.Level500CellInfo;
import com.xiaopeng.montecarlo.navcore.greendao.CPInfoDao;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.query.WhereCondition;
/* loaded from: classes3.dex */
public class CPDataHelper {
    private static final L.Tag TAG = new L.Tag("CPDataHelper");
    private static final BigDecimal CELL_LENGTH = BigDecimal.valueOf(0.01d);

    private static byte mergeFlag(byte b, byte b2) {
        return b == 0 ? b2 : b;
    }

    public static <T> boolean replaceData(final List<T> list, final Class<T> cls) {
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list)) {
            try {
                Callable<Boolean> callable = new Callable<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.database.CPDataHelper.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        DaoSession.this.deleteAll(cls);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (DaoSession.this.insert(it.next()) < 0) {
                                throw new Exception();
                            }
                        }
                        return true;
                    }
                };
                if (L.ENABLE) {
                    L.d(TAG, "replaceData begin insert");
                }
                z = ((Boolean) daoSession.callInTx(callable)).booleanValue();
                if (L.ENABLE) {
                    L.d(TAG, "replaceData end insert");
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return z;
    }

    public static boolean replaceAllData(final List<CPInfo> list, final List<Level500CellInfo> list2) {
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list) && !CollectionUtils.isEmpty(list2)) {
            try {
                Callable<Boolean> callable = new Callable<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.database.CPDataHelper.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        DaoSession.this.deleteAll(CPInfo.class);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (DaoSession.this.insert((CPInfo) it.next()) < 0) {
                                throw new Exception();
                            }
                        }
                        DaoSession.this.deleteAll(Level500CellInfo.class);
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            if (DaoSession.this.insert((Level500CellInfo) it2.next()) < 0) {
                                throw new Exception();
                            }
                        }
                        return true;
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

    public static boolean update(CPInfo cPInfo) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.update(cPInfo);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public static boolean delete(CPInfo cPInfo) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.delete(cPInfo);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public static <T> List<T> listAll(Class<T> cls) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return null;
        }
        try {
            return daoSession.loadAll(cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> long listCount(Class<T> cls) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return 0L;
        }
        try {
            return daoSession.queryBuilder(cls).count();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r5 == r7) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo> query(com.autonavi.gbl.common.model.Coord2DDouble[] r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.database.CPDataHelper.query(com.autonavi.gbl.common.model.Coord2DDouble[], int, boolean):java.util.List");
    }

    public static List<XPPoiInfo> queryByIds(String[] strArr) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null || CollectionUtils.isEmpty(strArr)) {
            return null;
        }
        try {
            return CPInfo.toXPPoiInfo(daoSession.queryBuilder(CPInfo.class).where(CPInfoDao.Properties.StationId.in(strArr), new WhereCondition[0]).list());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d9, code lost:
        if (r0.exists() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00db, code lost:
        r0.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fe, code lost:
        if (r0.exists() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0101, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean parseData(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.database.CPDataHelper.parseData(java.lang.String):boolean");
    }

    public static boolean clearData() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.deleteAll(CPInfo.class);
            daoSession.deleteAll(Level500CellInfo.class);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    private static Level500CellInfo createCellInfo(CPInfo cPInfo) {
        Level500CellInfo level500CellInfo = new Level500CellInfo();
        level500CellInfo.setLon(cPInfo.getLon());
        level500CellInfo.setLat(cPInfo.getLat());
        level500CellInfo.setChargeNum(1);
        level500CellInfo.setChargeIdList(cPInfo.getStationId());
        level500CellInfo.setPoiMinLon(cPInfo.getLon());
        level500CellInfo.setPoiMaxLon(cPInfo.getLon());
        level500CellInfo.setPoiMinLat(cPInfo.getLat());
        level500CellInfo.setPoiMaxLat(cPInfo.getLat());
        level500CellInfo.setContainXPFlag(cPInfo.getSelfSupportFlag());
        BigDecimal multiply = BigDecimal.valueOf(cPInfo.getLon()).divideToIntegralValue(CELL_LENGTH).multiply(CELL_LENGTH);
        BigDecimal multiply2 = BigDecimal.valueOf(cPInfo.getLat()).divideToIntegralValue(CELL_LENGTH).multiply(CELL_LENGTH);
        level500CellInfo.setCellMinLon(multiply.doubleValue());
        level500CellInfo.setCellMaxLon(multiply.add(CELL_LENGTH).doubleValue());
        level500CellInfo.setCellMinLat(multiply2.doubleValue());
        level500CellInfo.setCellMaxLat(multiply2.add(CELL_LENGTH).doubleValue());
        return level500CellInfo;
    }

    public static List<Level500CellInfo> generateCellInfoList(List<CPInfo> list) {
        byte b;
        byte b2;
        Level500CellInfo level500CellInfo;
        Iterator it;
        String str;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "generateCellInfoList begin list size:" + list.size());
        }
        HashMap hashMap = new HashMap();
        Iterator<CPInfo> it2 = list.iterator();
        while (true) {
            b = 2;
            b2 = 1;
            if (!it2.hasNext()) {
                break;
            }
            CPInfo next = it2.next();
            BigDecimal valueOf = BigDecimal.valueOf(next.getLon());
            BigDecimal valueOf2 = BigDecimal.valueOf(next.getLat());
            BigDecimal multiply = valueOf.divideToIntegralValue(CELL_LENGTH).multiply(CELL_LENGTH);
            BigDecimal multiply2 = valueOf2.divideToIntegralValue(CELL_LENGTH).multiply(CELL_LENGTH);
            if (next.getSelfSupportFlag() == 1 || next.getSelfSupportFlag() == 2) {
                hashMap.put(generateCellKey(multiply.add(valueOf), multiply2.add(valueOf2)), createCellInfo(next));
            } else {
                String generateCellKey = generateCellKey(multiply, multiply2);
                Level500CellInfo level500CellInfo2 = (Level500CellInfo) hashMap.get(generateCellKey);
                if (level500CellInfo2 != null) {
                    updateCellInfo(level500CellInfo2, next);
                } else {
                    hashMap.put(generateCellKey, createCellInfo(next));
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "generateCellInfoList before merge cell map size:" + hashMap.size());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashMap.keySet());
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            String str2 = (String) it3.next();
            if (hashMap.containsKey(str2)) {
                Level500CellInfo level500CellInfo3 = (Level500CellInfo) hashMap.get(str2);
                if (level500CellInfo3 == null) {
                    hashMap.remove(str2);
                } else if (b2 != level500CellInfo3.getContainXPFlag() && b != level500CellInfo3.getContainXPFlag()) {
                    String str3 = null;
                    BigDecimal bigDecimal = CELL_LENGTH;
                    BigDecimal valueOf3 = BigDecimal.valueOf(level500CellInfo3.getCellMinLon());
                    BigDecimal valueOf4 = BigDecimal.valueOf(level500CellInfo3.getCellMinLat());
                    BigDecimal subtract = valueOf3.subtract(CELL_LENGTH);
                    while (subtract.compareTo(valueOf3.add(CELL_LENGTH)) <= 0) {
                        BigDecimal subtract2 = valueOf4.subtract(CELL_LENGTH);
                        while (subtract2.compareTo(valueOf4.add(CELL_LENGTH)) <= 0) {
                            if (subtract.compareTo(valueOf3) != 0 || subtract2.compareTo(valueOf4) != 0) {
                                String generateCellKey2 = generateCellKey(subtract, subtract2);
                                if (hashMap.containsKey(generateCellKey2) && (level500CellInfo = (Level500CellInfo) hashMap.get(generateCellKey2)) != null) {
                                    double pow = Math.pow(level500CellInfo3.getLat() - level500CellInfo.getLat(), 2.0d);
                                    double lon = level500CellInfo3.getLon();
                                    double lon2 = level500CellInfo.getLon();
                                    it = it3;
                                    str = str3;
                                    double sqrt = Math.sqrt(pow + Math.pow(lon - lon2, 2.0d));
                                    if (BigDecimal.valueOf(sqrt).compareTo(bigDecimal) < 0) {
                                        bigDecimal = BigDecimal.valueOf(sqrt);
                                        str3 = generateCellKey2;
                                        subtract2 = subtract2.add(CELL_LENGTH);
                                        it3 = it;
                                    }
                                    str3 = str;
                                    subtract2 = subtract2.add(CELL_LENGTH);
                                    it3 = it;
                                }
                            }
                            it = it3;
                            str = str3;
                            str3 = str;
                            subtract2 = subtract2.add(CELL_LENGTH);
                            it3 = it;
                        }
                        subtract = subtract.add(CELL_LENGTH);
                        it3 = it3;
                    }
                    Iterator it4 = it3;
                    if (str3 != null) {
                        updateCellInfo(level500CellInfo3, (Level500CellInfo) hashMap.get(str3));
                        hashMap.remove(str3);
                    }
                    it3 = it4;
                    b = 2;
                    b2 = 1;
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag3 = TAG;
            L.d(tag3, "generateCellInfoList after merge cell map size:" + hashMap.size());
        }
        return new ArrayList(hashMap.values());
    }

    private static Level500CellInfo updateCellInfo(Level500CellInfo level500CellInfo, CPInfo cPInfo) {
        level500CellInfo.setContainXPFlag(mergeFlag(level500CellInfo.getContainXPFlag(), cPInfo.getSelfSupportFlag()));
        level500CellInfo.setChargeNum(level500CellInfo.getChargeNum() + 1);
        level500CellInfo.setChargeIdList(level500CellInfo.getChargeIdList() + "," + cPInfo.getStationId());
        if (cPInfo.getLon() < level500CellInfo.getPoiMinLon()) {
            level500CellInfo.setPoiMinLon(cPInfo.getLon());
        }
        if (cPInfo.getLon() > level500CellInfo.getPoiMaxLon()) {
            level500CellInfo.setPoiMaxLon(cPInfo.getLon());
        }
        if (cPInfo.getLat() < level500CellInfo.getPoiMinLat()) {
            level500CellInfo.setPoiMinLat(cPInfo.getLat());
        }
        if (cPInfo.getLat() > level500CellInfo.getPoiMaxLat()) {
            level500CellInfo.setPoiMaxLat(cPInfo.getLat());
        }
        return level500CellInfo;
    }

    private static Level500CellInfo updateCellInfo(Level500CellInfo level500CellInfo, Level500CellInfo level500CellInfo2) {
        level500CellInfo.setContainXPFlag(mergeFlag(level500CellInfo.getContainXPFlag(), level500CellInfo2.getContainXPFlag()));
        level500CellInfo.setChargeNum(level500CellInfo.getChargeNum() + level500CellInfo2.getChargeNum());
        level500CellInfo.setChargeIdList(level500CellInfo.getChargeIdList() + "," + level500CellInfo2.getChargeIdList());
        if (level500CellInfo2.getPoiMinLon() < level500CellInfo.getPoiMinLon()) {
            level500CellInfo.setPoiMinLon(level500CellInfo2.getPoiMinLon());
        }
        if (level500CellInfo2.getPoiMaxLon() > level500CellInfo.getPoiMaxLon()) {
            level500CellInfo.setPoiMaxLon(level500CellInfo2.getPoiMaxLon());
        }
        if (level500CellInfo2.getPoiMinLat() < level500CellInfo.getPoiMinLat()) {
            level500CellInfo.setPoiMinLat(level500CellInfo2.getPoiMinLat());
        }
        if (level500CellInfo2.getPoiMaxLat() > level500CellInfo.getPoiMaxLat()) {
            level500CellInfo.setPoiMaxLat(level500CellInfo2.getPoiMaxLat());
        }
        return level500CellInfo;
    }

    private static String generateCellKey(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.setScale(5, 1).toString() + bigDecimal2.setScale(5, 1).toString();
    }
}
