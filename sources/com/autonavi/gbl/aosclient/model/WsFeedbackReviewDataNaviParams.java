package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsFeedbackReviewDataNaviParams implements Serializable {
    public int accelerateCount;
    public int brakesCount;
    public int distance;
    public int drivenTime;
    public String endPOIID;
    public int estimateTime;
    public int maxSpeed;
    public String nativeVoiceBroadcast;
    public int overSpeedCount;
    public int pathMethod;
    public int rerouteCount;
    public ArrayList<Integer> roadDist;
    public String startPOIID;
    public ArrayList<Integer> trafficDist;
    public int turnCount;

    public WsFeedbackReviewDataNaviParams() {
        this.accelerateCount = 0;
        this.brakesCount = 0;
        this.distance = 0;
        this.drivenTime = 0;
        this.endPOIID = "";
        this.estimateTime = 0;
        this.maxSpeed = 0;
        this.nativeVoiceBroadcast = "";
        this.overSpeedCount = 0;
        this.pathMethod = 0;
        this.rerouteCount = 0;
        this.roadDist = new ArrayList<>();
        this.startPOIID = "";
        this.trafficDist = new ArrayList<>();
        this.turnCount = 0;
    }

    public WsFeedbackReviewDataNaviParams(int i, int i2, int i3, int i4, String str, int i5, int i6, String str2, int i7, int i8, int i9, ArrayList<Integer> arrayList, String str3, ArrayList<Integer> arrayList2, int i10) {
        this.accelerateCount = i;
        this.brakesCount = i2;
        this.distance = i3;
        this.drivenTime = i4;
        this.endPOIID = str;
        this.estimateTime = i5;
        this.maxSpeed = i6;
        this.nativeVoiceBroadcast = str2;
        this.overSpeedCount = i7;
        this.pathMethod = i8;
        this.rerouteCount = i9;
        this.roadDist = arrayList;
        this.startPOIID = str3;
        this.trafficDist = arrayList2;
        this.turnCount = i10;
    }
}
