package com.xiaopeng.montecarlo.navcore.database;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.LccGeoFenceInfo;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.navcore.greendao.LccGeoFenceInfoDao;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.query.WhereCondition;
/* loaded from: classes3.dex */
public class LccGeoFenceDataHelper {
    private static final L.Tag TAG = new L.Tag("LccGeoFenceDataHelper");
    public static final int TYPE1_ON_BRIDGE = 1;
    public static final int TYPE1_UNDER_BRIDGE = 2;
    public static final int TYPE2_ON_MAINROAD = 1;
    public static final int TYPE2_ON_SIDEROAD = 2;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r1.exists() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean parseData(java.lang.String r7) {
        /*
            com.xiaopeng.montecarlo.root.util.L$Tag r0 = com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper.TAG
            java.lang.String r1 = "parseData begin"
            com.xiaopeng.montecarlo.root.util.L.i(r0, r1)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            r2 = 0
            java.lang.String r3 = com.xiaopeng.montecarlo.root.util.ioutil.FileUtil.inputStream2String(r1)     // Catch: java.lang.Throwable -> L54
            java.lang.Class<com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper$LccGenFenceDataResponse> r4 = com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper.LccGenFenceDataResponse.class
            java.lang.Object r3 = com.xiaopeng.montecarlo.root.util.GsonUtil.fromJson(r3, r4)     // Catch: java.lang.Throwable -> L54
            com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper$LccGenFenceDataResponse r3 = (com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper.LccGenFenceDataResponse) r3     // Catch: java.lang.Throwable -> L54
            com.xiaopeng.montecarlo.navcore.database.bean.greendao.LccGeoFenceInfo[] r3 = r3.getData()     // Catch: java.lang.Throwable -> L54
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch: java.lang.Throwable -> L54
            com.xiaopeng.montecarlo.root.util.L$Tag r4 = com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper.TAG     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r5.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r6 = "parseData end size:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L54
            int r6 = r3.size()     // Catch: java.lang.Throwable -> L54
            r5.append(r6)     // Catch: java.lang.Throwable -> L54
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L54
            com.xiaopeng.montecarlo.root.util.L.i(r4, r5)     // Catch: java.lang.Throwable -> L54
            boolean r0 = replaceAll(r3)     // Catch: java.lang.Throwable -> L54
            r1.close()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r7 = r1.exists()
            if (r7 == 0) goto L77
        L4e:
            r1.delete()
            goto L77
        L52:
            r3 = move-exception
            goto L56
        L54:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L52
        L56:
            if (r2 == 0) goto L61
            r1.close()     // Catch: java.lang.Throwable -> L5c
            goto L64
        L5c:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            goto L64
        L61:
            r1.close()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
        L64:
            throw r3     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
        L65:
            r0 = move-exception
            goto L78
        L67:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L65
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r7 = r1.exists()
            if (r7 == 0) goto L77
            goto L4e
        L77:
            return r0
        L78:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r7 = r1.exists()
            if (r7 == 0) goto L86
            r1.delete()
        L86:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper.parseData(java.lang.String):boolean");
    }

    private static boolean replaceAll(final List<LccGeoFenceInfo> list) {
        L.i(TAG, "begin insert");
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list)) {
            try {
                z = ((Boolean) daoSession.callInTx(new Callable<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.database.LccGeoFenceDataHelper.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        DaoSession.this.deleteAll(LccGeoFenceInfo.class);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (DaoSession.this.insert((LccGeoFenceInfo) it.next()) < 0) {
                                throw new Exception();
                            }
                        }
                        return true;
                    }
                })).booleanValue();
            } catch (Exception e) {
                e.getStackTrace();
            }
            L.Tag tag = TAG;
            L.i(tag, "end insert " + z);
        }
        return z;
    }

    public static List<LccGeoFenceInfo> query(XPCoordinate2DDouble[] xPCoordinate2DDoubleArr) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        List<LccGeoFenceInfo> list = null;
        if (daoSession == null || xPCoordinate2DDoubleArr == null) {
            return null;
        }
        double d = 0.0d;
        int i = 0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        while (i < xPCoordinate2DDoubleArr.length) {
            XPCoordinate2DDouble xPCoordinate2DDouble = xPCoordinate2DDoubleArr[i];
            if (xPCoordinate2DDouble != null) {
                if (d == d2 || d == d3 || d == d4 || d == d5) {
                    d2 = xPCoordinate2DDouble.mLon;
                    d3 = xPCoordinate2DDouble.mLon;
                    d4 = xPCoordinate2DDouble.mLat;
                    d5 = xPCoordinate2DDouble.mLat;
                }
                if (xPCoordinate2DDouble.mLon < d2) {
                    d2 = xPCoordinate2DDouble.mLon;
                }
                if (xPCoordinate2DDouble.mLon > d3) {
                    d3 = xPCoordinate2DDouble.mLon;
                }
                if (xPCoordinate2DDouble.mLat < d4) {
                    d4 = xPCoordinate2DDouble.mLat;
                }
                if (xPCoordinate2DDouble.mLat > d5) {
                    d5 = xPCoordinate2DDouble.mLat;
                }
            }
            i++;
            d = 0.0d;
        }
        if (d2 >= d3 || d4 >= d5) {
            if (L.ENABLE) {
                L.d(TAG, "error date:" + d2 + " " + d3 + " " + d4 + " " + d5);
            }
            return null;
        }
        if (L.ENABLE) {
            L.d(TAG, "begin query");
        }
        try {
            list = daoSession.queryBuilder(LccGeoFenceInfo.class).where(LccGeoFenceInfoDao.Properties.RangeLeftBottomLon.between(Double.valueOf(d2), Double.valueOf(d3)), new WhereCondition[0]).where(LccGeoFenceInfoDao.Properties.RangeLeftBottomLat.between(Double.valueOf(d4), Double.valueOf(d5)), new WhereCondition[0]).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("end query size: ");
            sb.append(CollectionUtils.isEmpty(list) ? 0 : list.size());
            L.d(tag, sb.toString());
        }
        return list;
    }

    public static List<LccGeoFenceInfo> listAll() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return null;
        }
        return daoSession.loadAll(LccGeoFenceInfo.class);
    }

    public static boolean clearData() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.deleteAll(LccGeoFenceInfo.class);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    private static class LccGenFenceDataResponse {
        @SerializedName("data")
        private LccGeoFenceInfo[] data;
        @SerializedName("version")
        private String version;

        protected boolean canEqual(Object obj) {
            return obj instanceof LccGenFenceDataResponse;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LccGenFenceDataResponse) {
                LccGenFenceDataResponse lccGenFenceDataResponse = (LccGenFenceDataResponse) obj;
                if (lccGenFenceDataResponse.canEqual(this)) {
                    String version = getVersion();
                    String version2 = lccGenFenceDataResponse.getVersion();
                    if (version != null ? version.equals(version2) : version2 == null) {
                        return Arrays.deepEquals(getData(), lccGenFenceDataResponse.getData());
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String version = getVersion();
            return (((version == null ? 43 : version.hashCode()) + 59) * 59) + Arrays.deepHashCode(getData());
        }

        public void setData(LccGeoFenceInfo[] lccGeoFenceInfoArr) {
            this.data = lccGeoFenceInfoArr;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String toString() {
            return "LccGeoFenceDataHelper.LccGenFenceDataResponse(version=" + getVersion() + ", data=" + Arrays.deepToString(getData()) + ")";
        }

        public String getVersion() {
            return this.version;
        }

        public LccGeoFenceInfo[] getData() {
            return this.data;
        }
    }
}
