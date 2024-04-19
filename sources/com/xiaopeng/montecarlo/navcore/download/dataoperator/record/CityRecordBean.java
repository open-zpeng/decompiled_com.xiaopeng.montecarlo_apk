package com.xiaopeng.montecarlo.navcore.download.dataoperator.record;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.download.constant.MapDataStatusEnum;
/* loaded from: classes2.dex */
public class CityRecordBean {
    @SerializedName("adCode")
    int mAdCode;
    @SerializedName("dataStatus")
    long mDataStatus;
    @SerializedName("deleteTimeInMillis")
    long mDeleteTimeInMillis;
    @SerializedName("downloadTimeInMillis")
    long mDownloadTimeInMillis;
    @SerializedName("isCurrentCity")
    boolean mIsCurrentCity;
    @SerializedName("lastUseTimeInMillis")
    long mLastUseTimeInMillis;
    @SerializedName("mapDataVersion")
    String mMapDataVersion;
    @SerializedName("recordCount")
    long mRecordCount;

    protected boolean canEqual(Object obj) {
        return obj instanceof CityRecordBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CityRecordBean) {
            CityRecordBean cityRecordBean = (CityRecordBean) obj;
            if (cityRecordBean.canEqual(this) && getAdCode() == cityRecordBean.getAdCode() && getRecordCount() == cityRecordBean.getRecordCount() && getDataStatus() == cityRecordBean.getDataStatus() && getDownloadTimeInMillis() == cityRecordBean.getDownloadTimeInMillis() && getLastUseTimeInMillis() == cityRecordBean.getLastUseTimeInMillis() && getDeleteTimeInMillis() == cityRecordBean.getDeleteTimeInMillis() && isCurrentCity() == cityRecordBean.isCurrentCity()) {
                String mapDataVersion = getMapDataVersion();
                String mapDataVersion2 = cityRecordBean.getMapDataVersion();
                return mapDataVersion != null ? mapDataVersion.equals(mapDataVersion2) : mapDataVersion2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long recordCount = getRecordCount();
        int adCode = ((getAdCode() + 59) * 59) + ((int) (recordCount ^ (recordCount >>> 32)));
        long dataStatus = getDataStatus();
        int i = (adCode * 59) + ((int) (dataStatus ^ (dataStatus >>> 32)));
        long downloadTimeInMillis = getDownloadTimeInMillis();
        int i2 = (i * 59) + ((int) (downloadTimeInMillis ^ (downloadTimeInMillis >>> 32)));
        long lastUseTimeInMillis = getLastUseTimeInMillis();
        int i3 = (i2 * 59) + ((int) (lastUseTimeInMillis ^ (lastUseTimeInMillis >>> 32)));
        long deleteTimeInMillis = getDeleteTimeInMillis();
        int i4 = (((i3 * 59) + ((int) (deleteTimeInMillis ^ (deleteTimeInMillis >>> 32)))) * 59) + (isCurrentCity() ? 79 : 97);
        String mapDataVersion = getMapDataVersion();
        return (i4 * 59) + (mapDataVersion == null ? 43 : mapDataVersion.hashCode());
    }

    public void setAdCode(int i) {
        this.mAdCode = i;
    }

    public void setCurrentCity(boolean z) {
        this.mIsCurrentCity = z;
    }

    public void setDataStatus(long j) {
        this.mDataStatus = j;
    }

    public void setDeleteTimeInMillis(long j) {
        this.mDeleteTimeInMillis = j;
    }

    public void setDownloadTimeInMillis(long j) {
        this.mDownloadTimeInMillis = j;
    }

    public void setLastUseTimeInMillis(long j) {
        this.mLastUseTimeInMillis = j;
    }

    public void setMapDataVersion(String str) {
        this.mMapDataVersion = str;
    }

    public void setRecordCount(long j) {
        this.mRecordCount = j;
    }

    public String toString() {
        return "CityRecordBean(mAdCode=" + getAdCode() + ", mRecordCount=" + getRecordCount() + ", mDataStatus=" + getDataStatus() + ", mMapDataVersion=" + getMapDataVersion() + ", mDownloadTimeInMillis=" + getDownloadTimeInMillis() + ", mLastUseTimeInMillis=" + getLastUseTimeInMillis() + ", mDeleteTimeInMillis=" + getDeleteTimeInMillis() + ", mIsCurrentCity=" + isCurrentCity() + ")";
    }

    public int getAdCode() {
        return this.mAdCode;
    }

    public long getRecordCount() {
        return this.mRecordCount;
    }

    public long getDataStatus() {
        return this.mDataStatus;
    }

    public String getMapDataVersion() {
        return this.mMapDataVersion;
    }

    public long getDownloadTimeInMillis() {
        return this.mDownloadTimeInMillis;
    }

    public long getLastUseTimeInMillis() {
        return this.mLastUseTimeInMillis;
    }

    public long getDeleteTimeInMillis() {
        return this.mDeleteTimeInMillis;
    }

    public boolean isCurrentCity() {
        return this.mIsCurrentCity;
    }

    public long getLastOperateTime() {
        long j = this.mLastUseTimeInMillis;
        long j2 = this.mDownloadTimeInMillis;
        return j > j2 ? j : j2;
    }

    public boolean isDataDeleted() {
        return this.mDataStatus == ((long) MapDataStatusEnum.STATUS_DELETED.getStatus());
    }
}
