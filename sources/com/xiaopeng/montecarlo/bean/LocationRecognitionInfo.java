package com.xiaopeng.montecarlo.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
/* loaded from: classes2.dex */
public class LocationRecognitionInfo implements Parcelable {
    public static final Parcelable.Creator<LocationRecognitionInfo> CREATOR = new Parcelable.Creator<LocationRecognitionInfo>() { // from class: com.xiaopeng.montecarlo.bean.LocationRecognitionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationRecognitionInfo createFromParcel(Parcel parcel) {
            return new LocationRecognitionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationRecognitionInfo[] newArray(int i) {
            return new LocationRecognitionInfo[i];
        }
    };
    private String mAddress;
    private String mGeoHash;
    private String mLat;
    private String mLon;
    private String mName;
    private String mPoiId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationRecognitionInfo() {
    }

    protected LocationRecognitionInfo(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mPoiId = parcel.readString();
        this.mName = parcel.readString();
        this.mLon = parcel.readString();
        this.mLat = parcel.readString();
        this.mGeoHash = parcel.readString();
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getLon() {
        return this.mLon;
    }

    public void setLon(String str) {
        this.mLon = str;
    }

    public String getLat() {
        return this.mLat;
    }

    public void setLat(String str) {
        this.mLat = str;
    }

    public String getGeoHash() {
        return this.mGeoHash;
    }

    public void setGeoHash(String str) {
        this.mGeoHash = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mLon);
        parcel.writeString(this.mLat);
        parcel.writeString(this.mGeoHash);
    }

    public PoiBean toPoiBean() {
        PoiBean poiBean = new PoiBean();
        poiBean.setAddress(getAddress());
        poiBean.setPoiId(getPoiId());
        poiBean.setName(getName());
        poiBean.setLongitude(Float.parseFloat(getLon()));
        poiBean.setLatitude(Float.parseFloat(getLat()));
        return poiBean;
    }
}
