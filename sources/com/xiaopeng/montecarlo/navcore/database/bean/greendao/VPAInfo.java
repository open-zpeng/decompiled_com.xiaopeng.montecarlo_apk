package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VPAInfo {
    private static final L.Tag TAG = new L.Tag("VPAInfo");
    private String cityCode;
    private String cityName;
    private String garageId;
    private Long id;
    private double lat;
    private double lon;
    private String path;

    public VPAInfo(Long l, String str, String str2, String str3, String str4, double d, double d2) {
        this.id = l;
        this.cityCode = str;
        this.cityName = str2;
        this.garageId = str3;
        this.path = str4;
        this.lon = d;
        this.lat = d2;
    }

    public VPAInfo() {
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<VPAInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(toXPPoiInfo(list.get(i)));
        }
        return arrayList;
    }

    public static XPPoiInfo toXPPoiInfo(VPAInfo vPAInfo) {
        if (vPAInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setDisplayLon(vPAInfo.getLon());
        xPPoiInfo.setDisplayLat(vPAInfo.getLat());
        xPPoiInfo.setOffline(true);
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(vPAInfo.getLon(), vPAInfo.getLat()), currentLocation));
        }
        xPPoiInfo.setPoiSource(1);
        return xPPoiInfo;
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

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public String getGarageId() {
        return this.garageId;
    }

    public void setGarageId(String str) {
        this.garageId = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
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
}
