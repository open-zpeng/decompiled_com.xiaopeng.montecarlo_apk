package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GVoiceTrafficResult implements Serializable {
    public String citycode;
    public String descriptions;
    public String endAddr;
    public double endLat;
    public double endLon;
    public double latitude;
    public double longitude;
    public String navidata;
    public ArrayList<GVoiceNode> nodes;
    public ArrayList<GVoicePath> paths;
    public String poiname;
    public String startAddr;
    public double startLat;
    public double startLon;
    public String typecode;

    public GVoiceTrafficResult() {
        this.citycode = "";
        this.typecode = "";
        this.poiname = "";
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.descriptions = "";
        this.startLon = 0.0d;
        this.startLat = 0.0d;
        this.endLon = 0.0d;
        this.endLat = 0.0d;
        this.startAddr = "";
        this.endAddr = "";
        this.navidata = "";
        this.paths = new ArrayList<>();
        this.nodes = new ArrayList<>();
    }

    public GVoiceTrafficResult(String str, String str2, String str3, double d, double d2, String str4, double d3, double d4, double d5, double d6, String str5, String str6, String str7, ArrayList<GVoicePath> arrayList, ArrayList<GVoiceNode> arrayList2) {
        this.citycode = str;
        this.typecode = str2;
        this.poiname = str3;
        this.longitude = d;
        this.latitude = d2;
        this.descriptions = str4;
        this.startLon = d3;
        this.startLat = d4;
        this.endLon = d5;
        this.endLat = d6;
        this.startAddr = str5;
        this.endAddr = str6;
        this.navidata = str7;
        this.paths = arrayList;
        this.nodes = arrayList2;
    }
}
