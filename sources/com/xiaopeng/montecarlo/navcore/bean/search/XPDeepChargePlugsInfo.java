package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepChargePlugsInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPDeepChargePlugsInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepChargePlugsInfo> CREATOR = new Parcelable.Creator<XPDeepChargePlugsInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepChargePlugsInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepChargePlugsInfo createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepChargePlugsInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepChargePlugsInfo[] newArray(int i) {
            return new XPDeepChargePlugsInfo[i];
        }
    };
    @SerializedName("mBrandDesc")
    private String mBrandDesc;
    @SerializedName("mSpeedType")
    private int mSpeedType;
    @SerializedName("mVol")
    private int mVol;
    @SerializedName("mVolType")
    private String mVolType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setVol(int i) {
        this.mVol = i;
    }

    public int getVol() {
        return this.mVol;
    }

    public void setSpeedType(int i) {
        this.mSpeedType = i;
    }

    public int getSpeedType() {
        return this.mSpeedType;
    }

    public void setVolType(String str) {
        this.mVolType = str;
    }

    public String getVolType() {
        return this.mVolType;
    }

    public void setBrandDesc(String str) {
        this.mBrandDesc = str;
    }

    public String getBrandDesc() {
        return this.mBrandDesc;
    }

    public XPDeepChargePlugsInfo() {
    }

    public XPDeepChargePlugsInfo(DeepChargePlugsInfo deepChargePlugsInfo) {
        this.mVol = deepChargePlugsInfo.vol;
        this.mSpeedType = deepChargePlugsInfo.speed_type;
        this.mVolType = deepChargePlugsInfo.vol_type;
        this.mBrandDesc = deepChargePlugsInfo.brand_desc;
    }

    protected XPDeepChargePlugsInfo(Parcel parcel) {
        this.mVol = parcel.readInt();
        this.mSpeedType = parcel.readInt();
        this.mVolType = parcel.readString();
        this.mBrandDesc = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.mVol);
        parcel.writeInt(this.mSpeedType);
        parcel.writeString(this.mVolType);
        parcel.writeString(this.mBrandDesc);
    }
}
