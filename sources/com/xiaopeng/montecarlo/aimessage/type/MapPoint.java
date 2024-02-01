package com.xiaopeng.montecarlo.aimessage.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* loaded from: classes.dex */
public final class MapPoint implements Parcelable {
    public static final Parcelable.Creator<MapPoint> CREATOR = new Parcelable.Creator<MapPoint>() { // from class: com.xiaopeng.montecarlo.aimessage.type.MapPoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapPoint createFromParcel(Parcel parcel) {
            return new MapPoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapPoint[] newArray(int i) {
            return new MapPoint[i];
        }
    };
    public static final String WAY_POINT_TYPE_CHARGE = "2";
    public static final String WAY_POINT_TYPE_NORMAL = "1";
    @SerializedName("adcode")
    private String mAdcode;
    @SerializedName("address")
    private String mAddress;
    @SerializedName(CPSearchParam.PARAM_KEY_CITY)
    private String mCity;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private String mId;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    private double mLat;
    @SerializedName(CPSearchParam.PARAM_KEY_LON)
    private double mLon;
    @SerializedName("name")
    private String mName;
    @SerializedName("poiId")
    private String mPoiId;
    @SerializedName("poiType")
    private String mPoiType;
    @SerializedName("province")
    private String mProvince;
    @SerializedName("type")
    private String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getLat() {
        return this.mLat;
    }

    public void setLat(double d) {
        this.mLat = d;
    }

    public double getLon() {
        return this.mLon;
    }

    public void setLon(double d) {
        this.mLon = d;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getCity() {
        return this.mCity;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public String getProvince() {
        return this.mProvince;
    }

    public void setProvince(String str) {
        this.mProvince = str;
    }

    public String getAdcode() {
        return this.mAdcode;
    }

    public void setAdcode(String str) {
        this.mAdcode = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getPoiType() {
        return this.mPoiType;
    }

    public void setPoiType(String str) {
        this.mPoiType = str;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public MapPoint() {
    }

    protected MapPoint(Parcel parcel) {
        this.mLat = parcel.readDouble();
        this.mLon = parcel.readDouble();
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mCity = parcel.readString();
        this.mProvince = parcel.readString();
        this.mAdcode = parcel.readString();
        this.mType = parcel.readString();
        this.mPoiType = parcel.readString();
    }

    public String toString() {
        return "Point{mLat=" + this.mLat + ", mLon=" + this.mLon + ", mId='" + this.mId + "', mName='" + this.mName + "', mAddress='" + this.mAddress + "', mCity='" + this.mCity + "', mProvince='" + this.mProvince + "', mAdcode='" + this.mAdcode + "', mType='" + this.mType + "', mPoiType='" + this.mPoiType + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLat);
        parcel.writeDouble(this.mLon);
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mProvince);
        parcel.writeString(this.mAdcode);
        parcel.writeString(this.mType);
        parcel.writeString(this.mPoiType);
    }
}
