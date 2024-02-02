package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class QueryByLinksAckDataPathsWeathersItem implements Serializable {
    public int adcode;
    public int isBadWeather;
    public ArrayList<Long> linkIds;
    public long pubTime;
    public int rank;
    public String text;
    public String weatherName;
    public int weatherType;

    public QueryByLinksAckDataPathsWeathersItem() {
        this.adcode = 0;
        this.linkIds = new ArrayList<>();
        this.weatherType = 0;
        this.weatherName = "";
        this.pubTime = 0L;
        this.text = "";
        this.isBadWeather = 0;
        this.rank = 0;
    }

    public QueryByLinksAckDataPathsWeathersItem(int i, ArrayList<Long> arrayList, int i2, String str, long j, String str2, int i3, int i4) {
        this.adcode = i;
        this.linkIds = arrayList;
        this.weatherType = i2;
        this.weatherName = str;
        this.pubTime = j;
        this.text = str2;
        this.isBadWeather = i3;
        this.rank = i4;
    }
}
