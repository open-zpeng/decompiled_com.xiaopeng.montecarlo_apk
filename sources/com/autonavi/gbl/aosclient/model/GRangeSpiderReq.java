package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderReq implements Serializable {
    public String div;
    public int encoder;
    public GRangeSpiderPointList end;
    public int insertpoints;
    public int join;
    public int pointslimit;
    public int quality;
    public String returnvers;
    public String source;
    public GRangeSpiderPointList start;
    public GRangeSpiderStrategy strategy;
    public int travel;
    public String uuid;
    public GRangeSpiderVehicle vehicle;
    public String vers;

    public GRangeSpiderReq() {
        this.uuid = "";
        this.vers = "";
        this.returnvers = "";
        this.source = "";
        this.div = "";
        this.encoder = 0;
        this.travel = 0;
        this.quality = 0;
        this.insertpoints = 0;
        this.pointslimit = 0;
        this.join = 0;
        this.strategy = new GRangeSpiderStrategy();
        this.start = new GRangeSpiderPointList();
        this.end = new GRangeSpiderPointList();
        this.vehicle = new GRangeSpiderVehicle();
    }

    public GRangeSpiderReq(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5, int i6, GRangeSpiderStrategy gRangeSpiderStrategy, GRangeSpiderPointList gRangeSpiderPointList, GRangeSpiderPointList gRangeSpiderPointList2, GRangeSpiderVehicle gRangeSpiderVehicle) {
        this.uuid = str;
        this.vers = str2;
        this.returnvers = str3;
        this.source = str4;
        this.div = str5;
        this.encoder = i;
        this.travel = i2;
        this.quality = i3;
        this.insertpoints = i4;
        this.pointslimit = i5;
        this.join = i6;
        this.strategy = gRangeSpiderStrategy;
        this.start = gRangeSpiderPointList;
        this.end = gRangeSpiderPointList2;
        this.vehicle = gRangeSpiderVehicle;
    }
}
