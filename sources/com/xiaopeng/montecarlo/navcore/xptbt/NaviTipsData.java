package com.xiaopeng.montecarlo.navcore.xptbt;
/* loaded from: classes3.dex */
public class NaviTipsData {
    private int mDistance;
    private int mManeuverID;
    private int mNextDistance;
    private int mNextManeuverID;
    private String mNextRouteName;
    private int mRemainTime;

    public int getDistance() {
        return this.mDistance;
    }

    public void setDistance(int i) {
        this.mDistance = i;
    }

    public int getRemainTime() {
        return this.mRemainTime;
    }

    public void setRemainTime(int i) {
        this.mRemainTime = i;
    }

    public int getManeuverID() {
        return this.mManeuverID;
    }

    public void setManeuverID(int i) {
        this.mManeuverID = i;
    }

    public String getNextRouteName() {
        return this.mNextRouteName;
    }

    public void setNextRouteName(String str) {
        this.mNextRouteName = str;
    }

    public int getNextDistance() {
        return this.mNextDistance;
    }

    public void setNextDistance(int i) {
        this.mNextDistance = i;
    }

    public int getNextManeuverID() {
        return this.mNextManeuverID;
    }

    public void setNextManeuverID(int i) {
        this.mNextManeuverID = i;
    }
}
