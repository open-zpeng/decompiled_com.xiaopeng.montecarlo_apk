package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepinfoPoiParkinfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPDeepInfoPoiParkInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepInfoPoiParkInfo> CREATOR = new Parcelable.Creator<XPDeepInfoPoiParkInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoiParkInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepInfoPoiParkInfo createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepInfoPoiParkInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepInfoPoiParkInfo[] newArray(int i) {
            return new XPDeepInfoPoiParkInfo[i];
        }
    };
    @SerializedName("mFreeSpace")
    private int mFreeSpace;
    @SerializedName("mParkColor")
    private int mParkColor;
    @SerializedName("mSumSpace")
    private int mSumSpace;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setSumSpace(int i) {
        this.mSumSpace = i;
    }

    public int getSumSpace() {
        return this.mSumSpace;
    }

    public void setFreeSpace(int i) {
        this.mFreeSpace = i;
    }

    public int getFreeSpace() {
        return this.mFreeSpace;
    }

    public void setParkColor(int i) {
        this.mParkColor = i;
    }

    public int getParkColor() {
        return this.mParkColor;
    }

    public XPDeepInfoPoiParkInfo() {
    }

    public XPDeepInfoPoiParkInfo(DeepinfoPoiParkinfo deepinfoPoiParkinfo) {
        this.mSumSpace = deepinfoPoiParkinfo.sumSpace;
        this.mFreeSpace = deepinfoPoiParkinfo.freeSpace;
        this.mParkColor = deepinfoPoiParkinfo.parkColor;
    }

    protected XPDeepInfoPoiParkInfo(Parcel parcel) {
        this.mSumSpace = parcel.readInt();
        this.mFreeSpace = parcel.readInt();
        this.mParkColor = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.mSumSpace);
        parcel.writeInt(this.mFreeSpace);
        parcel.writeInt(this.mParkColor);
    }
}
