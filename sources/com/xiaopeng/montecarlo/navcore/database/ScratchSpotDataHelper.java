package com.xiaopeng.montecarlo.navcore.database;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPScratchSpotInfo;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.navcore.greendao.XPScratchSpotInfoDao;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.query.WhereCondition;
/* loaded from: classes2.dex */
public class ScratchSpotDataHelper {
    private static final L.Tag TAG = new L.Tag("ScratchSpotDataHelper");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
    public static boolean parseData(String str) {
        BufferedReader bufferedReader;
        ScratchSpotDataResponse scratchSpotDataResponse;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "utf-8"));
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            try {
                if (L.ENABLE) {
                    L.d(TAG, "parseData begin");
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    XPScratchSpotInfo xPScratchSpotInfo = new XPScratchSpotInfo();
                    try {
                        scratchSpotDataResponse = (ScratchSpotDataResponse) GsonUtil.fromJson(readLine, (Class<Object>) ScratchSpotDataResponse.class);
                    } catch (Exception unused) {
                        scratchSpotDataResponse = null;
                    }
                    if (scratchSpotDataResponse != null) {
                        xPScratchSpotInfo.setStationId(scratchSpotDataResponse.mId);
                        xPScratchSpotInfo.setName(scratchSpotDataResponse.mName);
                        xPScratchSpotInfo.setAddress(scratchSpotDataResponse.mName);
                        if (scratchSpotDataResponse.mLocation != null) {
                            xPScratchSpotInfo.setLat(scratchSpotDataResponse.mLocation.getLat());
                            xPScratchSpotInfo.setLon(scratchSpotDataResponse.mLocation.getLon());
                        }
                        xPScratchSpotInfo.setImgs(GsonUtil.toJson(scratchSpotDataResponse.mImgs));
                        xPScratchSpotInfo.setIntro(scratchSpotDataResponse.mIntro);
                        xPScratchSpotInfo.setBusiTime(scratchSpotDataResponse.mBusiTime);
                        arrayList.add(xPScratchSpotInfo);
                    }
                }
                if (L.ENABLE) {
                    L.d(TAG, "parseData end size:" + arrayList.size());
                }
                boolean replaceAll = replaceAll(arrayList);
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                    return replaceAll;
                }
                return replaceAll;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            File file3 = new File(str);
            str = file3.exists();
            if (str != 0) {
                file3.delete();
            }
            return false;
        }
    }

    public static List<XPPoiInfo> query(Coord2DDouble[] coord2DDoubleArr) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        List list = null;
        if (daoSession == null || coord2DDoubleArr == null) {
            return null;
        }
        double d = 0.0d;
        int i = 0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        while (i < coord2DDoubleArr.length) {
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
            }
            return null;
        }
        if (L.ENABLE) {
            L.d(TAG, "begin query");
        }
        try {
            list = daoSession.queryBuilder(XPScratchSpotInfo.class).where(XPScratchSpotInfoDao.Properties.Lon.between(Double.valueOf(d2), Double.valueOf(d3)), new WhereCondition[0]).where(XPScratchSpotInfoDao.Properties.Lat.between(Double.valueOf(d4), Double.valueOf(d5)), new WhereCondition[0]).limit(50).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<XPPoiInfo> xPPoiInfo = XPScratchSpotInfo.toXPPoiInfo(list);
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
            daoSession.deleteAll(XPScratchSpotInfo.class);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    private static boolean replaceAll(final List<XPScratchSpotInfo> list) {
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list)) {
            try {
                Callable<Boolean> callable = new Callable<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.database.ScratchSpotDataHelper.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        DaoSession.this.deleteAll(XPScratchSpotInfo.class);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (DaoSession.this.insert((XPScratchSpotInfo) it.next()) < 0) {
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

    /* loaded from: classes2.dex */
    private class ScratchSpotDataResponse {
        @SerializedName("busi_time")
        private String mBusiTime;
        @SerializedName(VuiConstants.ELEMENT_ID)
        private String mId;
        @SerializedName("imgs")
        private String[] mImgs;
        @SerializedName("intro")
        private String mIntro;
        @SerializedName("location")
        private Location mLocation;
        @SerializedName("name")
        private String mName;

        public ScratchSpotDataResponse() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof ScratchSpotDataResponse;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ScratchSpotDataResponse) {
                ScratchSpotDataResponse scratchSpotDataResponse = (ScratchSpotDataResponse) obj;
                if (scratchSpotDataResponse.canEqual(this)) {
                    String id = getId();
                    String id2 = scratchSpotDataResponse.getId();
                    if (id != null ? id.equals(id2) : id2 == null) {
                        String name = getName();
                        String name2 = scratchSpotDataResponse.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            Location location = getLocation();
                            Location location2 = scratchSpotDataResponse.getLocation();
                            if (location != null ? location.equals(location2) : location2 == null) {
                                if (Arrays.deepEquals(getImgs(), scratchSpotDataResponse.getImgs())) {
                                    String intro = getIntro();
                                    String intro2 = scratchSpotDataResponse.getIntro();
                                    if (intro != null ? intro.equals(intro2) : intro2 == null) {
                                        String busiTime = getBusiTime();
                                        String busiTime2 = scratchSpotDataResponse.getBusiTime();
                                        return busiTime != null ? busiTime.equals(busiTime2) : busiTime2 == null;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String id = getId();
            int hashCode = id == null ? 43 : id.hashCode();
            String name = getName();
            int hashCode2 = ((hashCode + 59) * 59) + (name == null ? 43 : name.hashCode());
            Location location = getLocation();
            int hashCode3 = (((hashCode2 * 59) + (location == null ? 43 : location.hashCode())) * 59) + Arrays.deepHashCode(getImgs());
            String intro = getIntro();
            int hashCode4 = (hashCode3 * 59) + (intro == null ? 43 : intro.hashCode());
            String busiTime = getBusiTime();
            return (hashCode4 * 59) + (busiTime != null ? busiTime.hashCode() : 43);
        }

        public void setBusiTime(String str) {
            this.mBusiTime = str;
        }

        public void setId(String str) {
            this.mId = str;
        }

        public void setImgs(String[] strArr) {
            this.mImgs = strArr;
        }

        public void setIntro(String str) {
            this.mIntro = str;
        }

        public void setLocation(Location location) {
            this.mLocation = location;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public String toString() {
            return "ScratchSpotDataHelper.ScratchSpotDataResponse(mId=" + getId() + ", mName=" + getName() + ", mLocation=" + getLocation() + ", mImgs=" + Arrays.deepToString(getImgs()) + ", mIntro=" + getIntro() + ", mBusiTime=" + getBusiTime() + ")";
        }

        public String getId() {
            return this.mId;
        }

        public String getName() {
            return this.mName;
        }

        public Location getLocation() {
            return this.mLocation;
        }

        public String[] getImgs() {
            return this.mImgs;
        }

        public String getIntro() {
            return this.mIntro;
        }

        public String getBusiTime() {
            return this.mBusiTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Location {
        @SerializedName(CPSearchParam.PARAM_KEY_LAT)
        private double mLat;
        @SerializedName(CPSearchParam.PARAM_KEY_LON)
        private double mLon;

        public Location() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof Location;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Location) {
                Location location = (Location) obj;
                return location.canEqual(this) && Double.compare(getLat(), location.getLat()) == 0 && Double.compare(getLon(), location.getLon()) == 0;
            }
            return false;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(getLat());
            long doubleToLongBits2 = Double.doubleToLongBits(getLon());
            return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
        }

        public void setLat(double d) {
            this.mLat = d;
        }

        public void setLon(double d) {
            this.mLon = d;
        }

        public String toString() {
            return "ScratchSpotDataHelper.Location(mLat=" + getLat() + ", mLon=" + getLon() + ")";
        }

        public double getLat() {
            return this.mLat;
        }

        public double getLon() {
            return this.mLon;
        }
    }
}
