package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LightInfo implements Serializable {
    public String desc;
    public int dir;
    public ArrayList<LightState> lightStates;
    public long waitNum;

    public LightInfo() {
        this.waitNum = 0L;
        this.dir = 8;
        this.lightStates = new ArrayList<>();
        this.desc = "";
    }

    public LightInfo(long j, int i, ArrayList<LightState> arrayList, String str) {
        this.waitNum = j;
        this.dir = i;
        this.lightStates = arrayList;
        this.desc = str;
    }
}
