package com.xiaopeng.montecarlo.navcore.mapdisplay;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.map.model.MapviewMode;
/* loaded from: classes2.dex */
public class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = new Parcelable.Creator<MapStatus>() { // from class: com.xiaopeng.montecarlo.navcore.mapdisplay.MapStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapStatus createFromParcel(@NonNull Parcel parcel) {
            return new MapStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapStatus[] newArray(int i) {
            return new MapStatus[i];
        }
    };
    public int mFollowMode;
    public double mMapCenterLat;
    public int mMapCenterLeft;
    public double mMapCenterLon;
    public int mMapCenterTop;
    public float mMapLevel;
    @MapviewMode.MapviewMode1
    public int mMapMode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MapStatus() {
        this.mMapMode = Integer.MIN_VALUE;
        this.mMapLevel = -1000.0f;
        this.mFollowMode = -1;
        this.mMapCenterLon = Double.NaN;
        this.mMapCenterLat = Double.NaN;
        this.mMapCenterLeft = -1;
        this.mMapCenterTop = -1;
    }

    protected MapStatus(Parcel parcel) {
        this.mMapMode = Integer.MIN_VALUE;
        this.mMapLevel = -1000.0f;
        this.mFollowMode = -1;
        this.mMapCenterLon = Double.NaN;
        this.mMapCenterLat = Double.NaN;
        this.mMapCenterLeft = -1;
        this.mMapCenterTop = -1;
        this.mMapMode = parcel.readInt();
        this.mMapLevel = parcel.readFloat();
        this.mFollowMode = parcel.readInt();
        this.mMapCenterLon = parcel.readDouble();
        this.mMapCenterLat = parcel.readDouble();
        this.mMapCenterLeft = parcel.readInt();
        this.mMapCenterTop = parcel.readInt();
    }

    public void setMapStatus(MapStatus mapStatus) {
        if (mapStatus == null) {
            return;
        }
        int i = mapStatus.mMapMode;
        if (i != Integer.MIN_VALUE) {
            this.mMapMode = i;
        }
        float f = mapStatus.mMapLevel;
        if (f != -1000.0f) {
            this.mMapLevel = f;
        }
        int i2 = mapStatus.mFollowMode;
        if (i2 != -1) {
            this.mFollowMode = i2;
        }
        double d = mapStatus.mMapCenterLat;
        if (d != Double.NaN) {
            this.mMapCenterLat = d;
        }
        double d2 = mapStatus.mMapCenterLon;
        if (d2 != Double.NaN) {
            this.mMapCenterLon = d2;
        }
        int i3 = mapStatus.mMapCenterLeft;
        if (i3 != -1) {
            this.mMapCenterLeft = i3;
        }
        int i4 = mapStatus.mMapCenterTop;
        if (i4 != -1) {
            this.mMapCenterTop = i4;
        }
    }

    public void reset() {
        this.mMapMode = Integer.MIN_VALUE;
        this.mMapLevel = -1000.0f;
        this.mFollowMode = -1;
        this.mMapCenterLat = Double.NaN;
        this.mMapCenterLon = Double.NaN;
        this.mMapCenterLeft = -1;
        this.mMapCenterTop = -1;
    }

    public boolean isValid() {
        return (this.mMapMode == Integer.MIN_VALUE && this.mMapLevel == -1000.0f && this.mFollowMode == -1 && this.mMapCenterLat == Double.NaN && this.mMapCenterLon == Double.NaN && this.mMapCenterTop == -1 && this.mMapCenterLeft == -1) ? false : true;
    }

    @NonNull
    public String toString() {
        return "mMapCenterPoint : : [ lon -> " + this.mMapCenterLon + " lat -> " + this.mMapCenterLat + "];Map leftTop : [ left -> " + this.mMapCenterLeft + " , top -> " + this.mMapCenterTop + "] , mMapMode :" + this.mMapMode + "; mMapLevel : " + this.mMapLevel + "; mFollowMode:" + this.mFollowMode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.mMapMode);
        parcel.writeFloat(this.mMapLevel);
        parcel.writeInt(this.mFollowMode);
        parcel.writeDouble(this.mMapCenterLon);
        parcel.writeDouble(this.mMapCenterLat);
        parcel.writeInt(this.mMapCenterLeft);
        parcel.writeInt(this.mMapCenterTop);
    }
}
