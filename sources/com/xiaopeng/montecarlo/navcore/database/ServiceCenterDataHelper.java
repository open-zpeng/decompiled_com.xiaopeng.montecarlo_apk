package com.xiaopeng.montecarlo.navcore.database;

import android.text.TextUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPServiceCenterInfo;
import com.xiaopeng.montecarlo.navcore.greendao.DaoSession;
import com.xiaopeng.montecarlo.navcore.greendao.XPServiceCenterInfoDao;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
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
public class ServiceCenterDataHelper {
    private static final L.Tag TAG = new L.Tag("ServiceCenterDataHelper");

    public static boolean parseData(String str) {
        BufferedReader bufferedReader;
        ServiceCenterDataResponse serviceCenterDataResponse;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "utf-8"));
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
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
                        XPServiceCenterInfo xPServiceCenterInfo = new XPServiceCenterInfo();
                        try {
                            serviceCenterDataResponse = (ServiceCenterDataResponse) GsonUtil.fromJson(readLine, (Class<Object>) ServiceCenterDataResponse.class);
                        } catch (Exception unused) {
                            serviceCenterDataResponse = null;
                        }
                        if (serviceCenterDataResponse != null) {
                            xPServiceCenterInfo.setAddress(serviceCenterDataResponse.mAddress);
                            xPServiceCenterInfo.setName(serviceCenterDataResponse.mName);
                            xPServiceCenterInfo.setAutoId(serviceCenterDataResponse.mAutoId);
                            xPServiceCenterInfo.setBusiTime(serviceCenterDataResponse.mBusiTime);
                            xPServiceCenterInfo.setCategory(serviceCenterDataResponse.mCategory);
                            xPServiceCenterInfo.setCity(serviceCenterDataResponse.mCity);
                            xPServiceCenterInfo.setStationId(serviceCenterDataResponse.mId);
                            xPServiceCenterInfo.setImgs(GsonUtil.toJson(serviceCenterDataResponse.mImgs));
                            xPServiceCenterInfo.setPhone(serviceCenterDataResponse.mPhone);
                            xPServiceCenterInfo.setProvince(serviceCenterDataResponse.mProvince);
                            xPServiceCenterInfo.setSource(serviceCenterDataResponse.mSource);
                            xPServiceCenterInfo.setSubCity(serviceCenterDataResponse.mSubCity);
                            if (serviceCenterDataResponse.mLocation != null) {
                                xPServiceCenterInfo.setLat(serviceCenterDataResponse.mLocation.getLat());
                                xPServiceCenterInfo.setLon(serviceCenterDataResponse.mLocation.getLon());
                            }
                            if (serviceCenterDataResponse.mCarService != null) {
                                xPServiceCenterInfo.setStatus(serviceCenterDataResponse.mCarService.getStatus());
                                xPServiceCenterInfo.setChargeable(serviceCenterDataResponse.mCarService.isChargeable());
                                xPServiceCenterInfo.setVisible(serviceCenterDataResponse.mCarService.isVisible());
                                xPServiceCenterInfo.setType(serviceCenterDataResponse.mCarService.getType());
                            }
                            arrayList.add(xPServiceCenterInfo);
                        }
                    }
                    if (L.ENABLE) {
                        L.d(TAG, "parseData end size:" + arrayList.size());
                    }
                    boolean replaceAll = replaceAll(arrayList);
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                        return replaceAll;
                    }
                    return replaceAll;
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader2 = bufferedReader;
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    File file2 = new File(str);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                File file3 = new File(str);
                if (file3.exists()) {
                    file3.delete();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static List<XPPoiInfo> query(Coord2DDouble[] coord2DDoubleArr, int i, boolean z) {
        ArrayList<XPPoiInfo> arrayList;
        List list;
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null || coord2DDoubleArr == null) {
            return null;
        }
        double d = 0.0d;
        int i2 = 0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        while (i2 < coord2DDoubleArr.length) {
            Coord2DDouble coord2DDouble = coord2DDoubleArr[i2];
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
            i2++;
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
            L.d(TAG, "begin query scaleLevel:" + i);
        }
        if (!z || i < 10) {
            arrayList = null;
        } else {
            try {
                list = daoSession.queryBuilder(XPServiceCenterInfo.class).where(XPServiceCenterInfoDao.Properties.Lon.between(Double.valueOf(d2), Double.valueOf(d3)), new WhereCondition[0]).where(XPServiceCenterInfoDao.Properties.Lat.between(Double.valueOf(d4), Double.valueOf(d5)), new WhereCondition[0]).where(XPServiceCenterInfoDao.Properties.Visible.eq(true), new WhereCondition[0]).where(XPServiceCenterInfoDao.Properties.Status.in("1", "2"), new WhereCondition[0]).whereOr(XPServiceCenterInfoDao.Properties.Category.like("%1000101%"), XPServiceCenterInfoDao.Properties.Category.like("%1000103%"), new WhereCondition[0]).limit(50).list();
            } catch (Exception e) {
                e.printStackTrace();
                list = null;
            }
            arrayList = XPServiceCenterInfo.toXPPoiInfo(list);
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("end query size: ");
            sb.append(CollectionUtils.isEmpty(arrayList) ? 0 : arrayList.size());
            L.d(tag, sb.toString());
        }
        return arrayList;
    }

    public static List<XPPoiInfo> query(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "begin query id:" + str);
        }
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        List list = null;
        if (daoSession == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            List asList = Arrays.asList(str.split(","));
            list = daoSession.queryBuilder(XPServiceCenterInfo.class).whereOr(XPServiceCenterInfoDao.Properties.AutoId.in(asList), XPServiceCenterInfoDao.Properties.StationId.in(asList), new WhereCondition[0]).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<XPPoiInfo> xPPoiInfo = XPServiceCenterInfo.toXPPoiInfo(list);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("end query size: ");
            sb.append(CollectionUtils.isEmpty(xPPoiInfo) ? 0 : xPPoiInfo.size());
            L.d(tag2, sb.toString());
        }
        return xPPoiInfo;
    }

    public static List<XPPoiInfo> query(Coord2DDouble coord2DDouble, int i, String str) {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        ArrayList<XPPoiInfo> arrayList = null;
        if (daoSession != null && coord2DDouble != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "begin query lon:" + coord2DDouble.lon + ", lat:" + coord2DDouble.lat + ",radius:" + i + ", category:" + str);
            }
            if (XPNaviSearchParam.CATEGORY_INTEGRATED_SERVER_CENTER.equalsIgnoreCase(str)) {
                str = "";
            }
            String str2 = XPServiceCenterInfoDao.Properties.Lon.columnName;
            String str3 = XPServiceCenterInfoDao.Properties.Lat.columnName;
            String str4 = XPServiceCenterInfoDao.Properties.Status.columnName;
            String str5 = XPServiceCenterInfoDao.Properties.Category.columnName;
            StringBuilder sb = new StringBuilder();
            sb.append("where abs(");
            sb.append(str2);
            sb.append("-");
            sb.append(coord2DDouble.lon);
            sb.append(") * abs(");
            sb.append(str2);
            sb.append("-");
            sb.append(coord2DDouble.lon);
            sb.append(") + abs(");
            sb.append(str3);
            sb.append("-");
            sb.append(coord2DDouble.lat);
            sb.append(") * abs(");
            sb.append(str3);
            sb.append("-");
            sb.append(coord2DDouble.lat);
            sb.append(") < ");
            double d = (i / 1000) * 0.01d;
            sb.append(d * d);
            sb.append(" and ");
            sb.append(str4);
            sb.append("=1 and ");
            sb.append(str5);
            sb.append(" like '%");
            sb.append(str);
            sb.append("%' limit 50");
            try {
                arrayList = XPServiceCenterInfo.toXPPoiInfo(daoSession.queryRaw(XPServiceCenterInfo.class, sb.toString(), new String[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("end query size: ");
                sb2.append(CollectionUtils.isEmpty(arrayList) ? 0 : arrayList.size());
                L.d(tag2, sb2.toString());
            }
        }
        return arrayList;
    }

    public static boolean clearData() {
        DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        if (daoSession == null) {
            return false;
        }
        try {
            daoSession.deleteAll(XPServiceCenterInfo.class);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    private static boolean replaceAll(final List<XPServiceCenterInfo> list) {
        final DaoSession daoSession = DatabaseManager.getInstance().getDaoSession();
        boolean z = false;
        if (daoSession != null && !CollectionUtils.isEmpty(list)) {
            try {
                Callable<Boolean> callable = new Callable<Boolean>() { // from class: com.xiaopeng.montecarlo.navcore.database.ServiceCenterDataHelper.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        DaoSession.this.deleteAll(XPServiceCenterInfo.class);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (DaoSession.this.insert((XPServiceCenterInfo) it.next()) < 0) {
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
    private class ServiceCenterDataResponse {
        @SerializedName("address")
        private String mAddress;
        @SerializedName("auto_id")
        private String mAutoId;
        @SerializedName("busi_time")
        private String mBusiTime;
        @SerializedName("car_service")
        private CarService mCarService;
        @SerializedName("category")
        private String mCategory;
        @SerializedName(CPSearchParam.PARAM_KEY_CITY)
        private String mCity;
        @SerializedName(VuiConstants.ELEMENT_ID)
        private String mId;
        @SerializedName("imgs")
        private String[] mImgs;
        @SerializedName("location")
        private Location mLocation;
        @SerializedName("name")
        private String mName;
        @SerializedName("phone")
        private String mPhone;
        @SerializedName("province")
        private String mProvince;
        @SerializedName("source")
        private int mSource;
        @SerializedName("sub_city")
        private String mSubCity;

        public ServiceCenterDataResponse() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof ServiceCenterDataResponse;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ServiceCenterDataResponse) {
                ServiceCenterDataResponse serviceCenterDataResponse = (ServiceCenterDataResponse) obj;
                if (serviceCenterDataResponse.canEqual(this) && getSource() == serviceCenterDataResponse.getSource()) {
                    String id = getId();
                    String id2 = serviceCenterDataResponse.getId();
                    if (id != null ? id.equals(id2) : id2 == null) {
                        String name = getName();
                        String name2 = serviceCenterDataResponse.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            String address = getAddress();
                            String address2 = serviceCenterDataResponse.getAddress();
                            if (address != null ? address.equals(address2) : address2 == null) {
                                String province = getProvince();
                                String province2 = serviceCenterDataResponse.getProvince();
                                if (province != null ? province.equals(province2) : province2 == null) {
                                    String city = getCity();
                                    String city2 = serviceCenterDataResponse.getCity();
                                    if (city != null ? city.equals(city2) : city2 == null) {
                                        String category = getCategory();
                                        String category2 = serviceCenterDataResponse.getCategory();
                                        if (category != null ? category.equals(category2) : category2 == null) {
                                            String phone = getPhone();
                                            String phone2 = serviceCenterDataResponse.getPhone();
                                            if (phone != null ? phone.equals(phone2) : phone2 == null) {
                                                if (Arrays.deepEquals(getImgs(), serviceCenterDataResponse.getImgs())) {
                                                    String autoId = getAutoId();
                                                    String autoId2 = serviceCenterDataResponse.getAutoId();
                                                    if (autoId != null ? autoId.equals(autoId2) : autoId2 == null) {
                                                        String subCity = getSubCity();
                                                        String subCity2 = serviceCenterDataResponse.getSubCity();
                                                        if (subCity != null ? subCity.equals(subCity2) : subCity2 == null) {
                                                            String busiTime = getBusiTime();
                                                            String busiTime2 = serviceCenterDataResponse.getBusiTime();
                                                            if (busiTime != null ? busiTime.equals(busiTime2) : busiTime2 == null) {
                                                                Location location = getLocation();
                                                                Location location2 = serviceCenterDataResponse.getLocation();
                                                                if (location != null ? location.equals(location2) : location2 == null) {
                                                                    CarService carService = getCarService();
                                                                    CarService carService2 = serviceCenterDataResponse.getCarService();
                                                                    return carService != null ? carService.equals(carService2) : carService2 == null;
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
            int source = ((getSource() + 59) * 59) + (id == null ? 43 : id.hashCode());
            String name = getName();
            int hashCode = (source * 59) + (name == null ? 43 : name.hashCode());
            String address = getAddress();
            int hashCode2 = (hashCode * 59) + (address == null ? 43 : address.hashCode());
            String province = getProvince();
            int hashCode3 = (hashCode2 * 59) + (province == null ? 43 : province.hashCode());
            String city = getCity();
            int hashCode4 = (hashCode3 * 59) + (city == null ? 43 : city.hashCode());
            String category = getCategory();
            int hashCode5 = (hashCode4 * 59) + (category == null ? 43 : category.hashCode());
            String phone = getPhone();
            int hashCode6 = (((hashCode5 * 59) + (phone == null ? 43 : phone.hashCode())) * 59) + Arrays.deepHashCode(getImgs());
            String autoId = getAutoId();
            int hashCode7 = (hashCode6 * 59) + (autoId == null ? 43 : autoId.hashCode());
            String subCity = getSubCity();
            int hashCode8 = (hashCode7 * 59) + (subCity == null ? 43 : subCity.hashCode());
            String busiTime = getBusiTime();
            int hashCode9 = (hashCode8 * 59) + (busiTime == null ? 43 : busiTime.hashCode());
            Location location = getLocation();
            int hashCode10 = (hashCode9 * 59) + (location == null ? 43 : location.hashCode());
            CarService carService = getCarService();
            return (hashCode10 * 59) + (carService != null ? carService.hashCode() : 43);
        }

        public void setAddress(String str) {
            this.mAddress = str;
        }

        public void setAutoId(String str) {
            this.mAutoId = str;
        }

        public void setBusiTime(String str) {
            this.mBusiTime = str;
        }

        public void setCarService(CarService carService) {
            this.mCarService = carService;
        }

        public void setCategory(String str) {
            this.mCategory = str;
        }

        public void setCity(String str) {
            this.mCity = str;
        }

        public void setId(String str) {
            this.mId = str;
        }

        public void setImgs(String[] strArr) {
            this.mImgs = strArr;
        }

        public void setLocation(Location location) {
            this.mLocation = location;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public void setPhone(String str) {
            this.mPhone = str;
        }

        public void setProvince(String str) {
            this.mProvince = str;
        }

        public void setSource(int i) {
            this.mSource = i;
        }

        public void setSubCity(String str) {
            this.mSubCity = str;
        }

        public String toString() {
            return "ServiceCenterDataHelper.ServiceCenterDataResponse(mId=" + getId() + ", mName=" + getName() + ", mSource=" + getSource() + ", mAddress=" + getAddress() + ", mProvince=" + getProvince() + ", mCity=" + getCity() + ", mCategory=" + getCategory() + ", mPhone=" + getPhone() + ", mImgs=" + Arrays.deepToString(getImgs()) + ", mAutoId=" + getAutoId() + ", mSubCity=" + getSubCity() + ", mBusiTime=" + getBusiTime() + ", mLocation=" + getLocation() + ", mCarService=" + getCarService() + ")";
        }

        public String getId() {
            return this.mId;
        }

        public String getName() {
            return this.mName;
        }

        public int getSource() {
            return this.mSource;
        }

        public String getAddress() {
            return this.mAddress;
        }

        public String getProvince() {
            return this.mProvince;
        }

        public String getCity() {
            return this.mCity;
        }

        public String getCategory() {
            return this.mCategory;
        }

        public String getPhone() {
            return this.mPhone;
        }

        public String[] getImgs() {
            return this.mImgs;
        }

        public String getAutoId() {
            return this.mAutoId;
        }

        public String getSubCity() {
            return this.mSubCity;
        }

        public String getBusiTime() {
            return this.mBusiTime;
        }

        public Location getLocation() {
            return this.mLocation;
        }

        public CarService getCarService() {
            return this.mCarService;
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
            return "ServiceCenterDataHelper.Location(mLat=" + getLat() + ", mLon=" + getLon() + ")";
        }

        public double getLat() {
            return this.mLat;
        }

        public double getLon() {
            return this.mLon;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CarService {
        @SerializedName("chargeable")
        private boolean mChargeable;
        @SerializedName("status")
        private int mStatus;
        @SerializedName("type")
        private int mType;
        @SerializedName("visible")
        private boolean mVisible;

        public CarService() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof CarService;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CarService) {
                CarService carService = (CarService) obj;
                return carService.canEqual(this) && isChargeable() == carService.isChargeable() && isVisible() == carService.isVisible() && getStatus() == carService.getStatus() && getType() == carService.getType();
            }
            return false;
        }

        public int hashCode() {
            return (((((((isChargeable() ? 79 : 97) + 59) * 59) + (isVisible() ? 79 : 97)) * 59) + getStatus()) * 59) + getType();
        }

        public void setChargeable(boolean z) {
            this.mChargeable = z;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public void setType(int i) {
            this.mType = i;
        }

        public void setVisible(boolean z) {
            this.mVisible = z;
        }

        public String toString() {
            return "ServiceCenterDataHelper.CarService(mChargeable=" + isChargeable() + ", mVisible=" + isVisible() + ", mStatus=" + getStatus() + ", mType=" + getType() + ")";
        }

        public boolean isChargeable() {
            return this.mChargeable;
        }

        public boolean isVisible() {
            return this.mVisible;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public int getType() {
            return this.mType;
        }
    }
}
