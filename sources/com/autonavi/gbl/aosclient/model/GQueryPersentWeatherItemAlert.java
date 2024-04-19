package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQueryPersentWeatherItemAlert implements Serializable {
    public int alertId;
    public String alertName;
    public String levelName;
    public long pubtime;
    public String title;

    public GQueryPersentWeatherItemAlert() {
        this.title = "";
        this.alertName = "";
        this.alertId = 0;
        this.levelName = "";
        this.pubtime = 0L;
    }

    public GQueryPersentWeatherItemAlert(String str, String str2, int i, String str3, long j) {
        this.title = str;
        this.alertName = str2;
        this.alertId = i;
        this.levelName = str3;
        this.pubtime = j;
    }
}
