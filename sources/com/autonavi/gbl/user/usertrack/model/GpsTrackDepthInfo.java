package com.autonavi.gbl.user.usertrack.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GpsTrackDepthInfo implements Serializable {
    public float averageSpeed;
    public long distance;
    public long duration;
    public int fastestIndex;
    public String fileName;
    public String filePath;
    public ArrayList<GpsTrackPoint> trackPoints;

    public GpsTrackDepthInfo() {
        this.filePath = "";
        this.fileName = "";
        this.fastestIndex = 0;
        this.trackPoints = new ArrayList<>();
        this.duration = 0L;
        this.distance = 0L;
        this.averageSpeed = 0.0f;
    }

    public GpsTrackDepthInfo(String str, String str2, int i, ArrayList<GpsTrackPoint> arrayList, long j, long j2, float f) {
        this.filePath = str;
        this.fileName = str2;
        this.fastestIndex = i;
        this.trackPoints = arrayList;
        this.duration = j;
        this.distance = j2;
        this.averageSpeed = f;
    }
}
