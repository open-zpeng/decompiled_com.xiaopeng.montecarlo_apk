package com.xiaopeng.montecarlo.aimessage.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public final class MapRouteOption implements Parcelable {
    public static final Parcelable.Creator<MapRouteOption> CREATOR = new Parcelable.Creator<MapRouteOption>() { // from class: com.xiaopeng.montecarlo.aimessage.type.MapRouteOption.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapRouteOption createFromParcel(Parcel parcel) {
            return new MapRouteOption(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapRouteOption[] newArray(int i) {
            return new MapRouteOption[i];
        }
    };
    @SerializedName("mAvoidCongestion")
    private boolean mAvoidCongestion;
    @SerializedName("mAvoidFee")
    private boolean mAvoidFee;
    @SerializedName("mAvoidFreeway")
    private boolean mAvoidFreeway;
    @SerializedName("mOptionPrior")
    private String mOptionPrior;
    @SerializedName("mPreferFreeway")
    private boolean mPreferFreeway;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setOptionPrior(String str) {
        this.mOptionPrior = str;
    }

    public String getOptionPrior() {
        return this.mOptionPrior;
    }

    public void setAvoidCongestion(boolean z) {
        this.mAvoidCongestion = z;
    }

    public boolean isAvoidCongestion() {
        return this.mAvoidCongestion;
    }

    public void setAvoidFee(boolean z) {
        this.mAvoidFee = z;
    }

    public boolean isAvoidFee() {
        return this.mAvoidFee;
    }

    public void setAvoidFreeway(boolean z) {
        this.mAvoidFreeway = z;
    }

    public boolean isAvoidFreeway() {
        return this.mAvoidFreeway;
    }

    public void setPreferFreeway(boolean z) {
        this.mPreferFreeway = z;
    }

    public boolean isPreferFreeway() {
        return this.mPreferFreeway;
    }

    protected MapRouteOption(Parcel parcel) {
        this.mOptionPrior = parcel.readString();
        this.mAvoidCongestion = parcel.readByte() != 0;
        this.mAvoidFee = parcel.readByte() != 0;
        this.mAvoidFreeway = parcel.readByte() != 0;
        this.mPreferFreeway = parcel.readByte() != 0;
    }

    public String toString() {
        return "MapRouteOption{mOptionPrior='" + this.mOptionPrior + "', mAvoidCongestion=" + this.mAvoidCongestion + ", mAvoidFee=" + this.mAvoidFee + ", mAvoidFreeway=" + this.mAvoidFreeway + ", mPreferFreeway=" + this.mPreferFreeway + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mOptionPrior);
        parcel.writeByte(this.mAvoidCongestion ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mAvoidFee ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mAvoidFreeway ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mPreferFreeway ? (byte) 1 : (byte) 0);
    }
}
