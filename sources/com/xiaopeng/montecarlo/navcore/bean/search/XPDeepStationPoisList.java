package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepStationPoisList;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPDeepStationPoisList implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepStationPoisList> CREATOR = new Parcelable.Creator<XPDeepStationPoisList>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepStationPoisList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepStationPoisList createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepStationPoisList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepStationPoisList[] newArray(int i) {
            return new XPDeepStationPoisList[i];
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
    @SerializedName("mType")
    private String mType;
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

    public void setType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    public XPDeepStationPoisList() {
    }

    public XPDeepStationPoisList(DeepStationPoisList deepStationPoisList) {
        this.mPoiId = deepStationPoisList.poiid;
        this.mName = deepStationPoisList.name;
        this.mAddress = deepStationPoisList.address;
        this.mChildShortName = deepStationPoisList.child_shortname;
        this.mX = deepStationPoisList.x;
        this.mY = deepStationPoisList.y;
        this.mType = deepStationPoisList.type;
    }

    protected XPDeepStationPoisList(Parcel parcel) {
        this.mPoiId = parcel.readString();
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mChildShortName = parcel.readString();
        this.mX = parcel.readString();
        this.mY = parcel.readString();
        this.mType = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mChildShortName);
        parcel.writeString(this.mX);
        parcel.writeString(this.mY);
        parcel.writeString(this.mType);
    }
}
