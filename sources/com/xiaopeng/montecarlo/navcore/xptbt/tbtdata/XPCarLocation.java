package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.map.layer.model.CarLoc;
import com.autonavi.gbl.map.layer.model.PathMatchInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPCarLocation implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPCarLocation> CREATOR = new Parcelable.Creator<XPCarLocation>() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCarLocation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCarLocation createFromParcel(Parcel parcel) {
            return new XPCarLocation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPCarLocation[] newArray(int i) {
            return new XPCarLocation[i];
        }
    };
    public float mCarDir;
    public int mIsOnGuideRoad;
    public double mLat3D;
    public double mLatitude;
    public int mLinkCur;
    public double mLon3D;
    public double mLongitude;
    public int mMatchStatus;
    public long mNaviRouteId;
    public int mPostCur;
    public int mSegmCur;
    public int mSpeed;
    public boolean mVaild3D;
    public double mZ3D;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPCarLocation() {
    }

    public XPCarLocation(CarLoc carLoc) {
        if (carLoc == null || !CollectionUtils.isNotEmpty(carLoc.vecPathMatchInfo) || carLoc.vecPathMatchInfo.get(0) == null) {
            return;
        }
        PathMatchInfo pathMatchInfo = carLoc.vecPathMatchInfo.get(0);
        this.mLongitude = pathMatchInfo.longitude;
        this.mLatitude = pathMatchInfo.latitude;
        this.mCarDir = pathMatchInfo.carDir;
        this.mSpeed = carLoc.speed;
        this.mMatchStatus = pathMatchInfo.matchStatus;
        this.mSegmCur = pathMatchInfo.nSegmCur;
        this.mLinkCur = pathMatchInfo.nLinkCur;
        this.mPostCur = pathMatchInfo.nPostCur;
        this.mIsOnGuideRoad = pathMatchInfo.nIsOnGuideRoad;
        this.mNaviRouteId = pathMatchInfo.nNaviRouteId;
        this.mLon3D = pathMatchInfo.lon3D;
        this.mLat3D = pathMatchInfo.lat3D;
        this.mZ3D = pathMatchInfo.z3D;
        this.mVaild3D = pathMatchInfo.bVaild3D;
    }

    public XPCarLocation(double d, double d2, float f) {
        this.mLongitude = d;
        this.mLatitude = d2;
        this.mCarDir = f;
    }

    protected XPCarLocation(Parcel parcel) {
        this.mLongitude = parcel.readDouble();
        this.mLatitude = parcel.readDouble();
        this.mCarDir = parcel.readFloat();
        this.mSpeed = parcel.readInt();
        this.mMatchStatus = parcel.readInt();
        this.mSegmCur = parcel.readInt();
        this.mLinkCur = parcel.readInt();
        this.mPostCur = parcel.readInt();
        this.mIsOnGuideRoad = parcel.readInt();
        this.mNaviRouteId = parcel.readLong();
        this.mLon3D = parcel.readDouble();
        this.mLat3D = parcel.readDouble();
        this.mZ3D = parcel.readDouble();
        this.mVaild3D = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLongitude);
        parcel.writeDouble(this.mLatitude);
        parcel.writeFloat(this.mCarDir);
        parcel.writeInt(this.mSpeed);
        parcel.writeInt(this.mMatchStatus);
        parcel.writeInt(this.mSegmCur);
        parcel.writeInt(this.mLinkCur);
        parcel.writeInt(this.mPostCur);
        parcel.writeInt(this.mIsOnGuideRoad);
        parcel.writeLong(this.mNaviRouteId);
        parcel.writeDouble(this.mLon3D);
        parcel.writeDouble(this.mLat3D);
        parcel.writeDouble(this.mZ3D);
        parcel.writeByte(this.mVaild3D ? (byte) 1 : (byte) 0);
    }
}
