package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.util.ChargeComparatorUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class Level500CellInfo {
    private static final L.Tag TAG = new L.Tag("Level500CellInfo");
    private double cellMaxLat;
    private double cellMaxLon;
    private double cellMinLat;
    private double cellMinLon;
    private String chargeIdList;
    private int chargeNum;
    private byte containXPFlag;
    private Long id;
    private double lat;
    private double lon;
    private double poiMaxLat;
    private double poiMaxLon;
    private double poiMinLat;
    private double poiMinLon;

    public Level500CellInfo(Long l, double d, double d2, int i, String str, double d3, double d4, double d5, double d6, byte b, double d7, double d8, double d9, double d10) {
        this.id = l;
        this.lon = d;
        this.lat = d2;
        this.chargeNum = i;
        this.chargeIdList = str;
        this.poiMinLon = d3;
        this.poiMaxLon = d4;
        this.poiMinLat = d5;
        this.poiMaxLat = d6;
        this.containXPFlag = b;
        this.cellMinLon = d7;
        this.cellMaxLon = d8;
        this.cellMinLat = d9;
        this.cellMaxLat = d10;
    }

    public Level500CellInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
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

    public int getChargeNum() {
        return this.chargeNum;
    }

    public void setChargeNum(int i) {
        this.chargeNum = i;
    }

    public String getChargeIdList() {
        return this.chargeIdList;
    }

    public void setChargeIdList(String str) {
        this.chargeIdList = str;
    }

    public double getPoiMinLon() {
        return this.poiMinLon;
    }

    public void setPoiMinLon(double d) {
        this.poiMinLon = d;
    }

    public double getPoiMaxLon() {
        return this.poiMaxLon;
    }

    public void setPoiMaxLon(double d) {
        this.poiMaxLon = d;
    }

    public double getPoiMinLat() {
        return this.poiMinLat;
    }

    public void setPoiMinLat(double d) {
        this.poiMinLat = d;
    }

    public double getPoiMaxLat() {
        return this.poiMaxLat;
    }

    public void setPoiMaxLat(double d) {
        this.poiMaxLat = d;
    }

    public byte getContainXPFlag() {
        return this.containXPFlag;
    }

    public void setContainXPFlag(byte b) {
        this.containXPFlag = b;
    }

    public double getCellMinLon() {
        return this.cellMinLon;
    }

    public void setCellMinLon(double d) {
        this.cellMinLon = d;
    }

    public double getCellMaxLon() {
        return this.cellMaxLon;
    }

    public void setCellMaxLon(double d) {
        this.cellMaxLon = d;
    }

    public double getCellMinLat() {
        return this.cellMinLat;
    }

    public void setCellMinLat(double d) {
        this.cellMinLat = d;
    }

    public double getCellMaxLat() {
        return this.cellMaxLat;
    }

    public void setCellMaxLat(double d) {
        this.cellMaxLat = d;
    }

    public static XPPoiInfo toXPPoiInfo(Level500CellInfo level500CellInfo) {
        if (level500CellInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setPoiId(level500CellInfo.getChargeIdList());
        xPPoiInfo.setDisplayLon(level500CellInfo.getLon());
        xPPoiInfo.setDisplayLat(level500CellInfo.getLat());
        ArrayList<Coord2DDouble> arrayList = new ArrayList<>();
        Coord2DDouble coord2DDouble = new Coord2DDouble(level500CellInfo.getPoiMinLon(), level500CellInfo.getPoiMinLat());
        Coord2DDouble coord2DDouble2 = new Coord2DDouble(level500CellInfo.getPoiMaxLon(), level500CellInfo.getPoiMaxLat());
        arrayList.add(coord2DDouble);
        arrayList.add(coord2DDouble2);
        xPPoiInfo.setPoiPolygonBounds(arrayList);
        if (level500CellInfo.getContainXPFlag() == 1) {
            xPPoiInfo.setCategory(107);
        } else if (level500CellInfo.getContainXPFlag() == 2) {
            xPPoiInfo.setCategory(116);
        } else if (level500CellInfo.getContainXPFlag() == 3) {
            xPPoiInfo.setCategory(117);
        } else if (level500CellInfo.getContainXPFlag() == 0) {
            xPPoiInfo.setCategory(108);
        }
        xPPoiInfo.setOffline(true);
        XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
        if (currentLocation != null) {
            xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(level500CellInfo.getLon(), level500CellInfo.getLat()), currentLocation));
        }
        return xPPoiInfo;
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<Level500CellInfo> list, List<CPInfo> list2) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (CollectionUtils.isNotEmpty(list2)) {
            for (CPInfo cPInfo : list2) {
                hashMap.put(cPInfo.getStationId(), cPInfo);
            }
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
        for (Level500CellInfo level500CellInfo : list) {
            if (1 == level500CellInfo.getChargeNum()) {
                CPInfo cPInfo2 = (CPInfo) hashMap.get(level500CellInfo.getChargeIdList());
                if (cPInfo2 != null) {
                    arrayList.add(CPInfo.toXPPoiInfo(cPInfo2));
                } else {
                    arrayList.add(toXPPoiInfo(level500CellInfo));
                }
            } else {
                arrayList.add(toXPPoiInfo(level500CellInfo));
            }
        }
        Collections.sort(arrayList, new ChargeComparatorUtil());
        return arrayList;
    }
}
