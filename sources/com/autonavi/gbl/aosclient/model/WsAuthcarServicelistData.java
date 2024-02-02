package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsAuthcarServicelistData implements Serializable {
    public String brand;
    public String channel;
    public String end_time;
    public String market;
    public String pid;
    public String project_name;
    public ArrayList<WsAuthcarServicelistDataService> services;
    public String version;

    public WsAuthcarServicelistData() {
        this.project_name = "";
        this.pid = "";
        this.channel = "";
        this.brand = "";
        this.market = "";
        this.end_time = "";
        this.version = "";
        this.services = new ArrayList<>();
    }

    public WsAuthcarServicelistData(String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList<WsAuthcarServicelistDataService> arrayList) {
        this.project_name = str;
        this.pid = str2;
        this.channel = str3;
        this.brand = str4;
        this.market = str5;
        this.end_time = str6;
        this.version = str7;
        this.services = arrayList;
    }
}
