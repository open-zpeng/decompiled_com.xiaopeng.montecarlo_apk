package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepinfoPoiGasinfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPDeepInfoPoiGasInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepInfoPoiGasInfo> CREATOR = new Parcelable.Creator<XPDeepInfoPoiGasInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoiGasInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepInfoPoiGasInfo createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepInfoPoiGasInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepInfoPoiGasInfo[] newArray(int i) {
            return new XPDeepInfoPoiGasInfo[i];
        }
    };
    @SerializedName("mPrice")
    private String mPrice;
    @SerializedName("mType")
    private String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public XPDeepInfoPoiGasInfo() {
    }

    public XPDeepInfoPoiGasInfo(DeepinfoPoiGasinfo deepinfoPoiGasinfo) {
        this.mType = deepinfoPoiGasinfo.type;
        this.mPrice = deepinfoPoiGasinfo.price;
    }

    protected XPDeepInfoPoiGasInfo(Parcel parcel) {
        this.mType = parcel.readString();
        this.mPrice = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mType);
        parcel.writeString(this.mPrice);
    }
}
