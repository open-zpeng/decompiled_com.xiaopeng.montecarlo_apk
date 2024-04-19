package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepAirportTerminalInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPDeepAirportTerminalInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepAirportTerminalInfo> CREATOR = new Parcelable.Creator<XPDeepAirportTerminalInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepAirportTerminalInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepAirportTerminalInfo createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepAirportTerminalInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepAirportTerminalInfo[] newArray(int i) {
            return new XPDeepAirportTerminalInfo[i];
        }
    };
    @SerializedName("mAddress")
    private String mAddress;
    @SerializedName("mChildShortName")
    private String mChildShortName;
    @SerializedName("mName")
    private String mName;
    @SerializedName("mPoiId")
    private String mPoiId;
    @SerializedName("mX")
    private String mX;
    @SerializedName("mY")
    private String mY;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setChildShortName(String str) {
        this.mChildShortName = str;
    }

    public String getChildShortName() {
        return this.mChildShortName;
    }

    public void setX(String str) {
        this.mX = str;
    }

    public String getX() {
        return this.mX;
    }

    public void setY(String str) {
        this.mY = str;
    }

    public String getY() {
        return this.mY;
    }

    public XPDeepAirportTerminalInfo() {
    }

    public XPDeepAirportTerminalInfo(DeepAirportTerminalInfo deepAirportTerminalInfo) {
        this.mPoiId = deepAirportTerminalInfo.poiid;
        this.mName = deepAirportTerminalInfo.name;
        this.mAddress = deepAirportTerminalInfo.address;
        this.mChildShortName = deepAirportTerminalInfo.child_shortname;
        this.mX = deepAirportTerminalInfo.x;
        this.mY = deepAirportTerminalInfo.y;
    }

    protected XPDeepAirportTerminalInfo(Parcel parcel) {
        this.mPoiId = parcel.readString();
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mChildShortName = parcel.readString();
        this.mX = parcel.readString();
        this.mY = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mChildShortName);
        parcel.writeString(this.mY);
        parcel.writeString(this.mY);
    }
}
