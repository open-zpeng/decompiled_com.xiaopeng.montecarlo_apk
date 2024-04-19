package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
/* loaded from: classes3.dex */
public class SearchLoadDistanceResult implements Parcelable {
    public static final Parcelable.Creator<SearchLoadDistanceResult> CREATOR = new Parcelable.Creator<SearchLoadDistanceResult>() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.dataprovider.SearchLoadDistanceResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchLoadDistanceResult createFromParcel(Parcel parcel) {
            return new SearchLoadDistanceResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchLoadDistanceResult[] newArray(int i) {
            return new SearchLoadDistanceResult[i];
        }
    };
    private long mDistance;
    private boolean mIsHome;
    private ILightBarInfo mLightBarInfo;
    private long mTravelTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SearchLoadDistanceResult() {
    }

    protected SearchLoadDistanceResult(Parcel parcel) {
        this.mTravelTime = parcel.readLong();
        this.mDistance = parcel.readLong();
        this.mIsHome = parcel.readByte() != 0;
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

    public boolean isHome() {
        return this.mIsHome;
    }

    public void setHome(boolean z) {
        this.mIsHome = z;
    }

    public ILightBarInfo getLightBarInfo() {
        return this.mLightBarInfo;
    }

    public void setLightBarInfo(ILightBarInfo iLightBarInfo) {
        this.mLightBarInfo = iLightBarInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mTravelTime);
        parcel.writeLong(this.mDistance);
        parcel.writeByte(this.mIsHome ? (byte) 1 : (byte) 0);
    }
}
