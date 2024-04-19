package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.aosclient.model.GCoord3DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPCoord3DDouble implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPCoord3DDouble> CREATOR = new Parcelable.Creator<XPCoord3DDouble>() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCoord3DDouble createFromParcel(Parcel parcel) {
            return new XPCoord3DDouble(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCoord3DDouble[] newArray(int i) {
            return new XPCoord3DDouble[i];
        }
    };
    public double mLat;
    public double mLon;
    public double mZ;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPCoord3DDouble() {
    }

    public XPCoord3DDouble(Coord3DDouble coord3DDouble) {
        this.mLat = coord3DDouble.lat;
        this.mLon = coord3DDouble.lon;
        this.mZ = coord3DDouble.z;
    }

    public XPCoord3DDouble(GCoord3DDouble gCoord3DDouble) {
        this.mLat = gCoord3DDouble.lat;
        this.mLon = gCoord3DDouble.lon;
        this.mZ = gCoord3DDouble.z;
    }

    protected XPCoord3DDouble(Parcel parcel) {
        this.mLon = parcel.readDouble();
        this.mLat = parcel.readDouble();
        this.mZ = parcel.readDouble();
    }

    public Coord3DDouble toBLCoord3DDouble() {
        Coord3DDouble coord3DDouble = new Coord3DDouble();
        coord3DDouble.lon = this.mLon;
        coord3DDouble.lat = this.mLat;
        coord3DDouble.z = this.mZ;
        return coord3DDouble;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLon);
        parcel.writeDouble(this.mLat);
        parcel.writeDouble(this.mZ);
    }
}
