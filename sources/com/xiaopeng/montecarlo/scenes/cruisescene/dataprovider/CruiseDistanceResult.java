package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CruiseDistanceResult implements Parcelable {
    public static final Parcelable.Creator<CruiseDistanceResult> CREATOR = new Parcelable.Creator<CruiseDistanceResult>() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CruiseDistanceResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CruiseDistanceResult createFromParcel(Parcel parcel) {
            return new CruiseDistanceResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CruiseDistanceResult[] newArray(int i) {
            return new CruiseDistanceResult[i];
        }
    };
    private long mDistance;
    private long mRequestId;
    private long mTravelTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CruiseDistanceResult() {
    }

    protected CruiseDistanceResult(Parcel parcel) {
        this.mDistance = parcel.readLong();
        this.mRequestId = parcel.readLong();
        this.mTravelTime = parcel.readLong();
    }

    public long getRequestId() {
        return this.mRequestId;
    }

    public void setRequestId(long j) {
        this.mRequestId = j;
    }

    public long getTravelTime() {
        return this.mTravelTime;
    }

    public void setTravelTime(long j) {
        this.mTravelTime = j;
    }

    public long getDistance() {
        return this.mDistance;
    }

    public void setDistance(long j) {
        this.mDistance = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mDistance);
        parcel.writeLong(this.mRequestId);
        parcel.writeLong(this.mTravelTime);
    }
}
