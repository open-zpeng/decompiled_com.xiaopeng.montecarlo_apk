package com.xiaopeng.montecarlo.navcore.bean.direction;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.protocol.node.navi.bean.ViaBean;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* loaded from: classes2.dex */
public class XPViaPoint implements Parcelable, Serializable {
    public static final int WAYPOINT_TYPE_CHARGING_STATION = 1;
    public static final int WAYPOINT_TYPE_EXTRA = 0;
    public static final int WAYPOINT_TYPE_ROUTE_CHARGE = 4;
    public static final int WAYPOINT_TYPE_USER_POI = 2;
    public static final int WAYPOINT_TYPE_USER_ROAD = 3;
    private int mDistance;
    private boolean mIsPassedVia;
    private XPPoiInfo mPoiInfo;
    private int mViaType;
    private static final L.Tag TAG = new L.Tag("XPViaPoint");
    public static final Parcelable.Creator<XPViaPoint> CREATOR = new Parcelable.Creator<XPViaPoint>() { // from class: com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPViaPoint createFromParcel(Parcel parcel) {
            return new XPViaPoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPViaPoint[] newArray(int i) {
            return new XPViaPoint[i];
        }
    };

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ViaType {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private XPViaPoint() {
        this.mPoiInfo = null;
        this.mIsPassedVia = false;
        this.mViaType = 2;
        this.mDistance = 0;
    }

    public String toString() {
        return "XPViaPoint{mPoiInfo=" + this.mPoiInfo + ", mIsPassedVia=" + this.mIsPassedVia + ", mViaType=" + this.mViaType + ", mDistance=" + this.mDistance + '}';
    }

    protected XPViaPoint(Parcel parcel) {
        this.mPoiInfo = null;
        this.mIsPassedVia = false;
        this.mViaType = 2;
        this.mDistance = 0;
        this.mPoiInfo = (XPPoiInfo) parcel.readParcelable(XPPoiInfo.class.getClassLoader());
        this.mIsPassedVia = parcel.readByte() != 0;
        this.mViaType = parcel.readInt();
        this.mDistance = parcel.readInt();
    }

    public boolean getIsPassedVia() {
        return this.mIsPassedVia;
    }

    public XPViaPoint(XPPoiInfo xPPoiInfo) {
        this.mPoiInfo = null;
        this.mIsPassedVia = false;
        this.mViaType = 2;
        this.mDistance = 0;
        this.mPoiInfo = xPPoiInfo;
    }

    public XPViaPoint(ViaBean viaBean) {
        this.mPoiInfo = null;
        this.mIsPassedVia = false;
        this.mViaType = 2;
        this.mDistance = 0;
        if (viaBean != null) {
            this.mPoiInfo = new XPPoiInfo(viaBean.getPointInfo());
            this.mViaType = viaBean.getViaType();
        }
    }

    public POIInfo toBLPOIInfo(boolean z) {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo != null) {
            return xPPoiInfo.toBLPOIInfo(z);
        }
        L.e(TAG, "NULL POIInfo in VIA");
        return null;
    }

    public XPPoiInfo getPoiPoint() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo != null) {
            return xPPoiInfo;
        }
        L.e(TAG, "NULL POIInfo in VIA");
        return null;
    }

    public void setIsPassedVia(boolean z) {
        this.mIsPassedVia = z;
    }

    public void setViaType(int i) {
        this.mViaType = i;
    }

    public int getViaType() {
        return this.mViaType;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public void setDistance(int i) {
        this.mDistance = i;
    }

    public boolean isChargeVia() {
        return getViaType() == 4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPoiInfo, i);
        parcel.writeByte(this.mIsPassedVia ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mViaType);
        parcel.writeInt(this.mDistance);
    }

    public XPViaPoint deepClone() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        XPViaPoint createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}
