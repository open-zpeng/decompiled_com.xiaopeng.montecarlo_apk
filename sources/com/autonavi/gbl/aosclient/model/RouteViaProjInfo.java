package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RouteViaProjInfo implements Serializable {
    public String lat;
    public String link_id;
    public String lon;

    public RouteViaProjInfo() {
        this.link_id = "";
        this.lon = "";
        this.lat = "";
    }

    public RouteViaProjInfo(String str, String str2, String str3) {
        this.link_id = str;
        this.lon = str2;
        this.lat = str3;
    }
}
