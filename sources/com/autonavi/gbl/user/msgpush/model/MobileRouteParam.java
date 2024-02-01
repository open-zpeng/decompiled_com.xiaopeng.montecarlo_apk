package com.autonavi.gbl.user.msgpush.model;

import com.autonavi.gbl.aosclient.model.RoutepathrestorationPointInfo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MobileRouteParam implements Serializable {
    public String contentOption;
    public MobileDestination destination;
    public ArrayList<RoutepathrestorationPointInfo> endPoints;
    public String flag;
    public int isOnline;
    public MobileLocation location;
    public String naviId;
    public int playStyle;
    public int routeMode;
    public ArrayList<MobileRouteViaPoint> routeViaPoints;
    public int sendMode;
    public int soundType;
    public ArrayList<RoutepathrestorationPointInfo> startPoints;
    public String type;
    public MobileVehicleInfo vehicle;
    public ArrayList<RoutepathrestorationPointInfo> viaPoints;

    public MobileRouteParam() {
        this.sendMode = 0;
        this.isOnline = 1;
        this.playStyle = 0;
        this.soundType = 0;
        this.routeMode = 0;
        this.naviId = "";
        this.type = "";
        this.flag = "";
        this.contentOption = "";
        this.vehicle = new MobileVehicleInfo();
        this.location = new MobileLocation();
        this.destination = new MobileDestination();
        this.routeViaPoints = new ArrayList<>();
        this.startPoints = new ArrayList<>();
        this.viaPoints = new ArrayList<>();
        this.endPoints = new ArrayList<>();
    }

    public MobileRouteParam(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4, MobileVehicleInfo mobileVehicleInfo, MobileLocation mobileLocation, MobileDestination mobileDestination, ArrayList<MobileRouteViaPoint> arrayList, ArrayList<RoutepathrestorationPointInfo> arrayList2, ArrayList<RoutepathrestorationPointInfo> arrayList3, ArrayList<RoutepathrestorationPointInfo> arrayList4) {
        this.sendMode = i;
        this.isOnline = i2;
        this.playStyle = i3;
        this.soundType = i4;
        this.routeMode = i5;
        this.naviId = str;
        this.type = str2;
        this.flag = str3;
        this.contentOption = str4;
        this.vehicle = mobileVehicleInfo;
        this.location = mobileLocation;
        this.destination = mobileDestination;
        this.routeViaPoints = arrayList;
        this.startPoints = arrayList2;
        this.viaPoints = arrayList3;
        this.endPoints = arrayList4;
    }
}
