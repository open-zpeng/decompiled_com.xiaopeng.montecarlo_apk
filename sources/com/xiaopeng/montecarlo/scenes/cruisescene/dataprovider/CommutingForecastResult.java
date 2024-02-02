package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CommutingForecastResult implements Parcelable {
    public static final Parcelable.Creator<CommutingForecastResult> CREATOR = new Parcelable.Creator<CommutingForecastResult>() { // from class: com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider.CommutingForecastResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommutingForecastResult createFromParcel(Parcel parcel) {
            return new CommutingForecastResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommutingForecastResult[] newArray(int i) {
            return new CommutingForecastResult[i];
        }
    };
    private int mCommutingForecastType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CommutingForecastResult() {
        this.mCommutingForecastType = 0;
    }

    protected CommutingForecastResult(Parcel parcel) {
        this.mCommutingForecastType = 0;
        this.mCommutingForecastType = parcel.readInt();
    }

    public int getCommutingForecastType() {
        return this.mCommutingForecastType;
    }

    public void setCommutingForecastType(int i) {
        this.mCommutingForecastType = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCommutingForecastType);
    }
}
