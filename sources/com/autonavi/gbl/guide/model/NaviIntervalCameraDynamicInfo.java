package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NaviIntervalCameraDynamicInfo implements Serializable {
    public int averageSpeed;
    public int distance;
    public int reasonableSpeedInRemainDist;
    public int remainDistance;
    public ArrayList<Short> speed;

    public NaviIntervalCameraDynamicInfo() {
        this.speed = new ArrayList<>();
        this.distance = 0;
        this.remainDistance = 0;
        this.averageSpeed = 0;
        this.reasonableSpeedInRemainDist = 0;
    }

    public NaviIntervalCameraDynamicInfo(ArrayList<Short> arrayList, int i, int i2, int i3, int i4) {
        this.speed = arrayList;
        this.distance = i;
        this.remainDistance = i2;
        this.averageSpeed = i3;
        this.reasonableSpeedInRemainDist = i4;
    }
}
