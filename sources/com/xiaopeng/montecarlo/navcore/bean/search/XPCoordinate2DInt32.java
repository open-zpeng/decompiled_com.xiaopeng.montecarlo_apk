package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPCoordinate2DInt32 implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPCoordinate2DInt32> CREATOR = new Parcelable.Creator<XPCoordinate2DInt32>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DInt32.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCoordinate2DInt32 createFromParcel(@NonNull Parcel parcel) {
            return new XPCoordinate2DInt32(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCoordinate2DInt32[] newArray(int i) {
            return new XPCoordinate2DInt32[i];
        }
    };
    private static final long serialVersionUID = 9204221791691945379L;
    @SerializedName("mLat")
    public int mLat;
    @SerializedName("mLon")
    public int mLon;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setLon(int i) {
        this.mLon = i;
    }

    public int getLon() {
        return this.mLon;
    }

    public void setLat(int i) {
        this.mLat = i;
    }

    public int getLat() {
        return this.mLat;
    }

    public XPCoordinate2DInt32() {
    }

    public XPCoordinate2DInt32(int i, int i2) {
        this.mLon = i;
        this.mLat = i2;
    }

    public XPCoordinate2DInt32(Coord2DInt32 coord2DInt32) {
        this.mLon = coord2DInt32.lon;
        this.mLat = coord2DInt32.lat;
    }

    public XPCoordinate2DInt32(XPPoiInfo xPPoiInfo) {
        this.mLon = (int) xPPoiInfo.getDisplayLon();
        this.mLat = (int) xPPoiInfo.getDisplayLat();
    }

    protected XPCoordinate2DInt32(Parcel parcel) {
        this.mLon = parcel.readInt();
        this.mLat = parcel.readInt();
    }

    @NonNull
    public Coord2DInt32 toBLCoord2D() {
        Coord2DInt32 coord2DInt32 = new Coord2DInt32();
        coord2DInt32.lon = this.mLon;
        coord2DInt32.lat = this.mLat;
        return coord2DInt32;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeDouble(this.mLon);
        parcel.writeDouble(this.mLat);
    }
}
