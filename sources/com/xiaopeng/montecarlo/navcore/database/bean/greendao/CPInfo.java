package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.util.ChargeComparatorUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class CPInfo {
    public static final int SUPPORT_FLAG_OTHER = 0;
    public static final int SUPPORT_FLAG_XP_COOPERATE = 3;
    public static final int SUPPORT_FLAG_XP_JOIN = 2;
    public static final int SUPPORT_FLAG_XP_SELF = 1;
    private String cityCode;
    private int fastNums;
    private Long id;
    private String key;
    private double lat;
    private double lon;
    private String operId;
    private String operName;
    private byte selfSupportFlag;
    private int slowNums;
    private String stationAddr;
    private String stationId;
    private String stationName;
    private static final L.Tag TAG = new L.Tag("CPInfo");
    public static int COLUMNS = 10;

    public CPInfo(Long l, String str, String str2, String str3, String str4, String str5, String str6, byte b, double d, double d2, int i, int i2, String str7) {
        this.id = l;
        this.cityCode = str;
        this.stationId = str2;
        this.stationName = str3;
        this.stationAddr = str4;
        this.operId = str5;
        this.operName = str6;
        this.selfSupportFlag = b;
        this.lon = d;
        this.lat = d2;
        this.fastNums = i;
        this.slowNums = i2;
        this.key = str7;
    }

    public CPInfo() {
    }

    public static XPPoiInfo toXPPoiInfo(CPInfo cPInfo) {
        if (cPInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setDisplayLon(cPInfo.getLon());
        xPPoiInfo.setDisplayLat(cPInfo.getLat());
        xPPoiInfo.setName(cPInfo.getStationName());
        xPPoiInfo.setAddress(cPInfo.getStationAddr());
        xPPoiInfo.setPoiId(cPInfo.getStationId());
        xPPoiInfo.setOffline(true);
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(cPInfo.getLon(), cPInfo.getLat()), currentLocation));
        }
        if (cPInfo.getSelfSupportFlag() == 1) {
            xPPoiInfo.setCategory(107);
        } else if (cPInfo.getSelfSupportFlag() == 2) {
            xPPoiInfo.setCategory(116);
        } else if (cPInfo.getSelfSupportFlag() == 3) {
            xPPoiInfo.setCategory(117);
        } else if (cPInfo.getSelfSupportFlag() == 0) {
            xPPoiInfo.setCategory(108);
        }
        xPPoiInfo.setTag(cPInfo.getOperName());
        XPDeepCharging[] xPDeepChargingArr = {new XPDeepCharging()};
        xPDeepChargingArr[0].setChargeSrcName(cPInfo.getOperName());
        xPDeepChargingArr[0].setNumFast(cPInfo.getFastNums());
        xPDeepChargingArr[0].setNumSlow(cPInfo.getSlowNums());
        xPDeepChargingArr[0].setNumFastFree(-1);
        xPDeepChargingArr[0].setNumSlowFree(-1);
        XPDeepInfoPoi xPDeepInfoPoi = new XPDeepInfoPoi();
        xPDeepInfoPoi.setChargeData(xPDeepChargingArr);
        xPPoiInfo.setXPDeepInfoPoi(xPDeepInfoPoi);
        xPPoiInfo.setPoiSource(3);
        return xPPoiInfo;
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<CPInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(toXPPoiInfo(list.get(i)));
        }
        Collections.sort(arrayList, new ChargeComparatorUtil());
        return arrayList;
    }

    public void setSelfSupportFlag(String str) {
        try {
            this.selfSupportFlag = Byte.parseByte(str);
        } catch (Exception unused) {
            L.Tag tag = TAG;
            L.w(tag, "bad data:" + str);
            this.selfSupportFlag = (byte) 0;
        }
    }

    public void setLon(String str) {
        try {
            this.lon = Double.parseDouble(str);
        } catch (Exception unused) {
            L.Tag tag = TAG;
            L.w(tag, "bad data:" + str);
            this.lon = 0.0d;
        }
    }

    public void setLat(String str) {
        try {
            this.lat = Double.parseDouble(str);
        } catch (Exception unused) {
            L.Tag tag = TAG;
            L.w(tag, "bad data:" + str);
            this.lat = 0.0d;
        }
    }

    public void setFastNums(String str) {
        try {
            this.fastNums = Integer.parseInt(str);
        } catch (Exception unused) {
            L.Tag tag = TAG;
            L.w(tag, "bad data:" + str);
            this.fastNums = 0;
        }
    }

    public void setSlowNums(String str) {
        try {
            this.slowNums = Integer.parseInt(str);
        } catch (Exception unused) {
            L.Tag tag = TAG;
            L.w(tag, "bad data:" + str);
            this.slowNums = 0;
        }
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public String getStationId() {
        return this.stationId;
    }

    public void setStationId(String str) {
        this.stationId = str;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String str) {
        this.stationName = str;
    }

    public String getStationAddr() {
        return this.stationAddr;
    }

    public void setStationAddr(String str) {
        this.stationAddr = str;
    }

    public String getOperId() {
        return this.operId;
    }

    public void setOperId(String str) {
        this.operId = str;
    }

    public String getOperName() {
        return this.operName;
    }

    public void setOperName(String str) {
        this.operName = str;
    }

    public byte getSelfSupportFlag() {
        return this.selfSupportFlag;
    }

    public void setSelfSupportFlag(byte b) {
        this.selfSupportFlag = b;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public int getFastNums() {
        return this.fastNums;
    }

    public void setFastNums(int i) {
        this.fastNums = i;
    }

    public int getSlowNums() {
        return this.slowNums;
    }

    public void setSlowNums(int i) {
        this.slowNums = i;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
