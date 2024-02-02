package com.xiaopeng.montecarlo.navcore.search.charge;

import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.Objects;
/* loaded from: classes2.dex */
public class ChargeCacheInfo {
    private byte mFastFreeNums;
    private boolean mIsAllXpPile;
    private boolean mIsFreeStation;
    private byte mSlowFreeNums;
    private long mUpdateTime;

    public ChargeCacheInfo(byte b, byte b2, long j) {
        this.mFastFreeNums = b;
        this.mSlowFreeNums = b2;
        this.mUpdateTime = j;
    }

    public static ChargeCacheInfo parse(XPPoiInfo xPPoiInfo) {
        try {
            XPDeepCharging xPDeepCharging = xPPoiInfo.getXPDeepInfoPoi().getChargeData()[0];
            ChargeCacheInfo chargeCacheInfo = new ChargeCacheInfo((byte) xPDeepCharging.getNumFastFree(), (byte) xPDeepCharging.getNumSlowFree(), System.currentTimeMillis());
            chargeCacheInfo.setIsAllXpPile(xPDeepCharging.isAllXpPile());
            chargeCacheInfo.setIsFreeStation(xPDeepCharging.isFreeStation());
            return chargeCacheInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public int getFastFreeNums() {
        return this.mFastFreeNums;
    }

    public void setFastFreeNums(byte b) {
        this.mFastFreeNums = b;
    }

    public int getSlowFreeNums() {
        return this.mSlowFreeNums;
    }

    public void setSlowFreeNums(byte b) {
        this.mSlowFreeNums = b;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setUpdateTime(long j) {
        this.mUpdateTime = j;
    }

    public boolean isFreeStation() {
        return this.mIsFreeStation;
    }

    public void setIsFreeStation(boolean z) {
        this.mIsFreeStation = z;
    }

    public boolean isAllXpPile() {
        return this.mIsAllXpPile;
    }

    public void setIsAllXpPile(boolean z) {
        this.mIsAllXpPile = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChargeCacheInfo chargeCacheInfo = (ChargeCacheInfo) obj;
        return this.mFastFreeNums == chargeCacheInfo.mFastFreeNums && this.mSlowFreeNums == chargeCacheInfo.mSlowFreeNums && this.mIsFreeStation == chargeCacheInfo.mIsFreeStation && this.mIsAllXpPile == chargeCacheInfo.mIsAllXpPile;
    }

    public int hashCode() {
        return Objects.hash(Byte.valueOf(this.mFastFreeNums), Byte.valueOf(this.mSlowFreeNums), Boolean.valueOf(this.mIsFreeStation), Boolean.valueOf(this.mIsAllXpPile));
    }
}
