package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPCoordinate2DDouble implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPCoordinate2DDouble> CREATOR = new Parcelable.Creator<XPCoordinate2DDouble>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCoordinate2DDouble createFromParcel(@NonNull Parcel parcel) {
            return new XPCoordinate2DDouble(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCoordinate2DDouble[] newArray(int i) {
            return new XPCoordinate2DDouble[i];
        }
    };
    private static final long serialVersionUID = 9204221791691945379L;
    @SerializedName("mLat")
    public double mLat;
    @SerializedName("mLon")
    public double mLon;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setLon(double d) {
        this.mLon = d;
    }

    public double getLon() {
        return this.mLon;
    }

    public void setLat(double d) {
        this.mLat = d;
    }

    public double getLat() {
        return this.mLat;
    }

    public XPCoordinate2DDouble() {
    }

    public XPCoordinate2DDouble(double d, double d2) {
        this.mLon = d;
        this.mLat = d2;
    }

    public XPCoordinate2DDouble(Coord2DDouble coord2DDouble) {
        this.mLon = coord2DDouble.lon;
        this.mLat = coord2DDouble.lat;
    }

    public XPCoordinate2DDouble(XPPoiInfo xPPoiInfo) {
        this.mLon = xPPoiInfo.getDisplayLon();
        this.mLat = xPPoiInfo.getDisplayLat();
    }

    public XPCoordinate2DDouble(XPCoord3DDouble xPCoord3DDouble) {
        this.mLon = xPCoord3DDouble.mLon;
        this.mLat = xPCoord3DDouble.mLat;
    }

    protected XPCoordinate2DDouble(Parcel parcel) {
        this.mLon = parcel.readDouble();
        this.mLat = parcel.readDouble();
    }

    @NonNull
    public Coord2DDouble toBLCoord2D() {
        Coord2DDouble coord2DDouble = new Coord2DDouble();
        coord2DDouble.lon = this.mLon;
        coord2DDouble.lat = this.mLat;
        return coord2DDouble;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeDouble(this.mLon);
        parcel.writeDouble(this.mLat);
    }
}
