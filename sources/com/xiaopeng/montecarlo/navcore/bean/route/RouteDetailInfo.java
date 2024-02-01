package com.xiaopeng.montecarlo.navcore.bean.route;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class RouteDetailInfo implements Serializable {
    private int mBatteryStatus;
    private String mBatteryStatusTips;
    private String mRemainDistance;
    private long mRemainDistanceValue;
    private String mRouteLeftDistance;
    private long mRouteLeftDistanceValue;
    private String mRouteTypeName;
    private String mRouteTypeNo;
    private String mTotalTimeLine1;
    private long mTotalTimeLine1Value;
    private String mTotalTimeLine2;
    private String mTrafficCost;
    private long mTrafficCostValue;
    private String mTrafficSignal;
    private long mTrafficSignalValue;

    public String getRouteTypeNo() {
        return this.mRouteTypeNo;
    }

    public void setRouteTypeNo(String str) {
        this.mRouteTypeNo = str;
    }

    public String getRouteTypeName() {
        return this.mRouteTypeName;
    }

    public void setRouteTypeName(String str) {
        this.mRouteTypeName = str;
    }

    public String getTrafficSignal() {
        return this.mTrafficSignal;
    }

    public void setTrafficSignal(String str) {
        this.mTrafficSignal = str;
    }

    public String getTrafficCost() {
        return this.mTrafficCost;
    }

    public void setTrafficCost(String str) {
        this.mTrafficCost = str;
    }

    public String getRouteLeftDistance() {
        return this.mRouteLeftDistance;
    }

    public void setRouteLeftDistance(String str) {
        this.mRouteLeftDistance = str;
    }

    public String getTotalTimeLine1() {
        return this.mTotalTimeLine1;
    }

    public void setTotalTimeLine1(String str) {
        this.mTotalTimeLine1 = str;
    }

    public String getTotalTimeLine2() {
        return this.mTotalTimeLine2;
    }

    public void setTotalTimeLine2(String str) {
        this.mTotalTimeLine2 = str;
    }

    public String getRemainDistance() {
        return this.mRemainDistance;
    }

    public void setRemainDistance(String str) {
        this.mRemainDistance = str;
    }

    public int getBatteryStatus() {
        return this.mBatteryStatus;
    }

    public void setBatteryStatus(int i) {
        this.mBatteryStatus = i;
    }

    public String getBatteryStatusTips() {
        return this.mBatteryStatusTips;
    }

    public void setBatteryStatusTips(String str) {
        this.mBatteryStatusTips = str;
    }

    public long getRouteLeftDistanceValue() {
        return this.mRouteLeftDistanceValue;
    }

    public void setRouteLeftDistanceValue(long j) {
        this.mRouteLeftDistanceValue = j;
    }

    public long getTotalTimeLine1Value() {
        return this.mTotalTimeLine1Value;
    }

    public void setTotalTimeLine1Value(long j) {
        this.mTotalTimeLine1Value = j;
    }

    public long getRemainDistanceValue() {
        return this.mRemainDistanceValue;
    }

    public void setRemainDistanceValue(long j) {
        this.mRemainDistanceValue = j;
    }

    public long getTrafficSignalValue() {
        return this.mTrafficSignalValue;
    }

    public void setTrafficSignalValue(long j) {
        this.mTrafficSignalValue = j;
    }

    public long getTrafficCostValue() {
        return this.mTrafficCostValue;
    }

    public void setTrafficCostValue(long j) {
        this.mTrafficCostValue = j;
    }

    public String toString() {
        return "RouteDetailInfo{mRouteTypeNo='" + this.mRouteTypeNo + "', mRouteTypeName='" + this.mRouteTypeName + "', mTrafficSignal='" + this.mTrafficSignal + "', mTrafficSignalValue=" + this.mTrafficSignalValue + ", mTrafficCost='" + this.mTrafficCost + "', mTrafficCostValue=" + this.mTrafficCostValue + ", mRouteLeftDistance='" + this.mRouteLeftDistance + "', mRouteLeftDistanceValue=" + this.mRouteLeftDistanceValue + ", mTotalTimeLine1='" + this.mTotalTimeLine1 + "', mTotalTimeLine1Value=" + this.mTotalTimeLine1Value + ", mTotalTimeLine2='" + this.mTotalTimeLine2 + "', mRemainDistance='" + this.mRemainDistance + "', mRemainDistanceValue=" + this.mRemainDistanceValue + ", mBatteryStatus=" + this.mBatteryStatus + ", mBatteryStatusTips='" + this.mBatteryStatusTips + "'}";
    }
}
