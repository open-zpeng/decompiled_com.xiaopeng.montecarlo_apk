package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepChargingPrice;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPDeepChargingPrice implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepChargingPrice> CREATOR = new Parcelable.Creator<XPDeepChargingPrice>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepChargingPrice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepChargingPrice createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepChargingPrice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepChargingPrice[] newArray(int i) {
            return new XPDeepChargingPrice[i];
        }
    };
    @SerializedName("mElePrice")
    private String mElePrice;
    @SerializedName("mSerPrice")
    private String mSerPrice;
    @SerializedName("mTime")
    private String mTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public String getTime() {
        return this.mTime;
    }

    public void setElePrice(String str) {
        this.mElePrice = str;
    }

    public String getElePrice() {
        return this.mElePrice;
    }

    public void setSerPrice(String str) {
        this.mSerPrice = str;
    }

    public String getSerPrice() {
        return this.mSerPrice;
    }

    public XPDeepChargingPrice() {
    }

    public XPDeepChargingPrice(DeepChargingPrice deepChargingPrice) {
        this.mTime = deepChargingPrice.time;
        this.mElePrice = deepChargingPrice.ele_price;
        this.mSerPrice = deepChargingPrice.ser_price;
    }

    protected XPDeepChargingPrice(Parcel parcel) {
        this.mTime = parcel.readString();
        this.mElePrice = parcel.readString();
        this.mSerPrice = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mTime);
        parcel.writeString(this.mElePrice);
        parcel.writeString(this.mSerPrice);
    }
}
