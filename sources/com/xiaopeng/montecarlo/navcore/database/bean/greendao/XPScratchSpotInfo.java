package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.util.ChargeComparatorUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class XPScratchSpotInfo {
    private static final L.Tag TAG = new L.Tag("XPScratchSpotInfo");
    private String address;
    private String busiTime;
    private Long id;
    private String imgs;
    private String intro;
    private double lat;
    private double lon;
    private String name;
    private String stationId;

    public XPScratchSpotInfo(Long l, String str, String str2, String str3, double d, double d2, String str4, String str5, String str6) {
        this.id = l;
        this.stationId = str;
        this.name = str2;
        this.address = str3;
        this.lon = d;
        this.lat = d2;
        this.imgs = str4;
        this.intro = str5;
        this.busiTime = str6;
    }

    public XPScratchSpotInfo() {
    }

    public static XPPoiInfo toXPPoiInfo(XPScratchSpotInfo xPScratchSpotInfo) {
        if (xPScratchSpotInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setDisplayLon(xPScratchSpotInfo.getLon());
        xPPoiInfo.setDisplayLat(xPScratchSpotInfo.getLat());
        xPPoiInfo.setName(xPScratchSpotInfo.getName());
        xPPoiInfo.setAddress(xPScratchSpotInfo.getAddress());
        xPPoiInfo.setPoiId(xPScratchSpotInfo.getStationId());
        TextUtils.isEmpty(xPScratchSpotInfo.getImgs());
        xPPoiInfo.setOpenTime(xPScratchSpotInfo.getBusiTime());
        xPPoiInfo.setRoadInfo(xPScratchSpotInfo.getIntro());
        xPPoiInfo.setPoiSource(11);
        xPPoiInfo.setCategory(119);
        return xPPoiInfo;
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<XPScratchSpotInfo> list) {
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

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
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

    public String getImgs() {
        return this.imgs;
    }

    public void setImgs(String str) {
        this.imgs = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getBusiTime() {
        return this.busiTime;
    }

    public void setBusiTime(String str) {
        this.busiTime = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }
}
