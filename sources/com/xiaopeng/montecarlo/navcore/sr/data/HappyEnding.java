package com.xiaopeng.montecarlo.navcore.sr.data;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.root.account.UserInfo;
/* loaded from: classes3.dex */
public class HappyEnding {
    private String mAvatar;
    private int mDetourObstacleCount;
    private int mLaneChangeCount;
    private String mName;
    private int mRoundaboutCount;
    private long mTime;
    private double mTotalMileage;
    private int mTrafficLightsCount;

    public HappyEnding() {
        init();
    }

    public HappyEnding(int i, int i2, int i3, int i4, int i5) {
        init();
        this.mTime = System.currentTimeMillis();
        this.mTrafficLightsCount = i;
        this.mLaneChangeCount = i2;
        this.mRoundaboutCount = i3;
        this.mDetourObstacleCount = i4;
        this.mTotalMileage = i5;
    }

    private void init() {
        UserInfo userInfo = XPAccountServiceWrapper.getInstance().getUserInfo();
        if (userInfo != null) {
            this.mName = userInfo.getUserName();
            this.mAvatar = userInfo.getAvatar();
        }
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public double getTotalMileage() {
        return this.mTotalMileage;
    }

    public void setTotalMileage(double d) {
        this.mTotalMileage = d;
    }

    public int getTrafficLightsCount() {
        return this.mTrafficLightsCount;
    }

    public void setTrafficLightsCount(int i) {
        this.mTrafficLightsCount = i;
    }

    public int getLaneChangeCount() {
        return this.mLaneChangeCount;
    }

    public void setLaneChangeCount(int i) {
        this.mLaneChangeCount = i;
    }

    public int getRoundaboutCount() {
        return this.mRoundaboutCount;
    }

    public void setRoundaboutCount(int i) {
        this.mRoundaboutCount = i;
    }

    public int getDetourObstacleCount() {
        return this.mDetourObstacleCount;
    }

    public void setDetourObstacleCount(int i) {
        this.mDetourObstacleCount = i;
    }

    @NonNull
    public String toString() {
        return "HappyEnding{mTime=" + this.mTime + ", mName='" + this.mName + "', mAvatar='" + this.mAvatar + "', mTrafficLightsCount=" + this.mTrafficLightsCount + ", mLaneChangeCount=" + this.mLaneChangeCount + ", mRoundaboutCount=" + this.mRoundaboutCount + ", mDetourObstacleCount=" + this.mDetourObstacleCount + ", mTotalMileage=" + this.mTotalMileage + '}';
    }
}
