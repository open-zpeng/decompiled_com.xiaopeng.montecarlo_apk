package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCarServiceInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.util.ChargeComparatorUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class XPServiceCenterInfo {
    private static final L.Tag TAG = new L.Tag("XPServiceCenterInfo");
    private String address;
    private String autoId;
    private String busiTime;
    private String category;
    private boolean chargeable;
    private String city;
    private Long id;
    private String imgs;
    private double lat;
    private double lon;
    private String name;
    private String phone;
    private String province;
    private int source;
    private String stationId;
    private int status;
    private String subCity;
    private int type;
    private boolean visible;

    public XPServiceCenterInfo(Long l, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, double d, double d2, String str9, String str10, String str11, boolean z, boolean z2, int i2, int i3) {
        this.id = l;
        this.stationId = str;
        this.autoId = str2;
        this.name = str3;
        this.address = str4;
        this.category = str5;
        this.source = i;
        this.province = str6;
        this.city = str7;
        this.subCity = str8;
        this.lon = d;
        this.lat = d2;
        this.phone = str9;
        this.imgs = str10;
        this.busiTime = str11;
        this.chargeable = z;
        this.visible = z2;
        this.status = i2;
        this.type = i3;
    }

    public XPServiceCenterInfo() {
    }

    public static XPPoiInfo toXPPoiInfo(XPServiceCenterInfo xPServiceCenterInfo) {
        if (xPServiceCenterInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setDisplayLon(xPServiceCenterInfo.getLon());
        xPPoiInfo.setDisplayLat(xPServiceCenterInfo.getLat());
        xPPoiInfo.setName(xPServiceCenterInfo.getName());
        xPPoiInfo.setAddress(xPServiceCenterInfo.getAddress());
        xPPoiInfo.setPoiId(xPServiceCenterInfo.getStationId());
        if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
            xPPoiInfo.setOffline(false);
        } else {
            xPPoiInfo.setOffline(true);
        }
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(xPServiceCenterInfo.getLon(), xPServiceCenterInfo.getLat()), currentLocation));
        }
        if (!TextUtils.isEmpty(xPServiceCenterInfo.getImgs())) {
            try {
                xPPoiInfo.setImageUrlList(Arrays.asList((Object[]) GsonUtil.fromJson(xPServiceCenterInfo.getImgs(), (Class<Object>) String[].class)));
            } catch (Exception unused) {
            }
        }
        xPPoiInfo.setOpenTime(xPServiceCenterInfo.getBusiTime());
        xPPoiInfo.setTel(xPServiceCenterInfo.getPhone());
        xPPoiInfo.setProvinceName(xPServiceCenterInfo.getProvince());
        xPPoiInfo.setCityName(xPServiceCenterInfo.getCity());
        xPPoiInfo.setDistrictName(xPServiceCenterInfo.getSubCity());
        xPPoiInfo.setPoiSource(10);
        xPPoiInfo.setCategory(118);
        XPCarServiceInfo xPCarServiceInfo = new XPCarServiceInfo();
        xPCarServiceInfo.setAutoId(xPServiceCenterInfo.getAutoId());
        xPCarServiceInfo.setChargeable(xPServiceCenterInfo.getChargeable());
        xPCarServiceInfo.setStatus(xPServiceCenterInfo.getStatus());
        xPCarServiceInfo.setVisible(xPServiceCenterInfo.getVisible());
        xPCarServiceInfo.setType(xPServiceCenterInfo.getType());
        if (!TextUtils.isEmpty(xPServiceCenterInfo.getCategory())) {
            if (xPServiceCenterInfo.getCategory().contains(XPNaviSearchParam.CATEGORY_EXPERIENCE_CENTER)) {
                xPCarServiceInfo.setExpCenter(true);
            }
            if (xPServiceCenterInfo.getCategory().contains(XPNaviSearchParam.CATEGORY_DELIVERY_CENTER)) {
                xPCarServiceInfo.setDelCenter(true);
            }
            if (xPServiceCenterInfo.getCategory().contains(XPNaviSearchParam.CATEGORY_SERVER_CENTER)) {
                xPCarServiceInfo.setSerCenter(true);
            }
        }
        xPPoiInfo.setXPCarServiceInfo(xPCarServiceInfo);
        return xPPoiInfo;
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<XPServiceCenterInfo> list) {
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getStationId() {
        return this.stationId;
    }

    public void setStationId(String str) {
        this.stationId = str;
    }

    public String getAutoId() {
        return this.autoId;
    }

    public void setAutoId(String str) {
        this.autoId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getSubCity() {
        return this.subCity;
    }

    public void setSubCity(String str) {
        this.subCity = str;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getImgs() {
        return this.imgs;
    }

    public void setImgs(String str) {
        this.imgs = str;
    }

    public String getBusiTime() {
        return this.busiTime;
    }

    public void setBusiTime(String str) {
        this.busiTime = str;
    }

    public boolean getChargeable() {
        return this.chargeable;
    }

    public void setChargeable(boolean z) {
        this.chargeable = z;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean z) {
        this.visible = z;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
