package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CarLoc implements Serializable {
    public int speed;
    public long un32Time;
    public ArrayList<PathMatchInfo> vecPathMatchInfo;

    public CarLoc() {
        this.speed = 0;
        this.un32Time = 0L;
        this.vecPathMatchInfo = new ArrayList<>();
    }

    public CarLoc(int i, long j, ArrayList<PathMatchInfo> arrayList) {
        this.speed = i;
        this.un32Time = j;
        this.vecPathMatchInfo = arrayList;
    }
}
