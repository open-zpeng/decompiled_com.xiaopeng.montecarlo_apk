package com.xiaopeng.montecarlo.scenes.mapscene;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class MapUIStatus implements Parcelable {
    public static final Parcelable.Creator<MapUIStatus> CREATOR = new Parcelable.Creator<MapUIStatus>() { // from class: com.xiaopeng.montecarlo.scenes.mapscene.MapUIStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapUIStatus createFromParcel(Parcel parcel) {
            MapUIStatus mapUIStatus = new MapUIStatus();
            mapUIStatus.mZoomButtonVisibility = parcel.readInt();
            mapUIStatus.mScaleVisibility = parcel.readInt();
            mapUIStatus.mVolumeVisibility = parcel.readInt();
            mapUIStatus.mMapRenderModeVisibility = parcel.readInt();
            mapUIStatus.mSettingVisibility = parcel.readInt();
            mapUIStatus.mOverViewVisibility = parcel.readInt();
            mapUIStatus.mOverViewSelected = parcel.readInt();
            mapUIStatus.mRouteChargeVisibility = parcel.readInt();
            mapUIStatus.mRouteChargeTipsVisibility = parcel.readInt();
            mapUIStatus.mRouteChargeEnable = parcel.readInt();
            return mapUIStatus;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapUIStatus[] newArray(int i) {
            return new MapUIStatus[i];
        }
    };
    public int mZoomButtonVisibility = 8;
    public int mScaleVisibility = 0;
    public int mVolumeVisibility = 0;
    public int mMapRenderModeVisibility = 0;
    public int mSettingVisibility = 0;
    public int mOverViewVisibility = 8;
    public int mOverViewSelected = 0;
    public int mRouteChargeVisibility = 8;
    public int mRouteChargeTipsVisibility = 8;
    public int mRouteChargeEnable = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MapUIStatus copy() {
        MapUIStatus mapUIStatus = new MapUIStatus();
        mapUIStatus.mZoomButtonVisibility = this.mZoomButtonVisibility;
        mapUIStatus.mScaleVisibility = this.mScaleVisibility;
        mapUIStatus.mVolumeVisibility = this.mVolumeVisibility;
        mapUIStatus.mMapRenderModeVisibility = this.mMapRenderModeVisibility;
        mapUIStatus.mSettingVisibility = this.mSettingVisibility;
        mapUIStatus.mOverViewVisibility = this.mOverViewVisibility;
        mapUIStatus.mOverViewSelected = this.mOverViewSelected;
        mapUIStatus.mRouteChargeVisibility = this.mRouteChargeVisibility;
        mapUIStatus.mRouteChargeTipsVisibility = this.mRouteChargeTipsVisibility;
        mapUIStatus.mRouteChargeEnable = this.mRouteChargeEnable;
        return mapUIStatus;
    }

    public int[] toIntArray() {
        return new int[]{this.mZoomButtonVisibility, this.mScaleVisibility, this.mVolumeVisibility, this.mMapRenderModeVisibility, this.mSettingVisibility, this.mOverViewVisibility, this.mOverViewSelected, this.mRouteChargeVisibility, this.mRouteChargeTipsVisibility, this.mRouteChargeEnable};
    }

    public void updateFromIntArray(int[] iArr) {
        this.mZoomButtonVisibility = iArr[0];
        this.mScaleVisibility = iArr[1];
        this.mVolumeVisibility = iArr[2];
        this.mMapRenderModeVisibility = iArr[3];
        this.mSettingVisibility = iArr[4];
        this.mOverViewVisibility = iArr[5];
        this.mOverViewSelected = iArr[6];
        this.mRouteChargeVisibility = iArr[7];
        this.mRouteChargeTipsVisibility = iArr[8];
        this.mRouteChargeEnable = iArr[9];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mZoomButtonVisibility:");
        sb.append(this.mZoomButtonVisibility == 0 ? "VISIBLE" : "GONE");
        sb.append(",");
        sb.append("mScaleVisibility:");
        sb.append(this.mScaleVisibility == 0 ? "VISIBLE" : "GONE");
        sb.append(",");
        sb.append("mVolumeVisibility:");
        sb.append(this.mVolumeVisibility == 0 ? "VISIBLE" : "GONE");
        sb.append(",");
        sb.append("mMapRenderModeVisibility:");
        sb.append(this.mMapRenderModeVisibility == 0 ? "VISIBLE" : "GONE");
        sb.append(",");
        sb.append("mSettingVisibility:");
        sb.append(this.mSettingVisibility == 0 ? "VISIBLE" : "GONE");
        sb.append(",");
        sb.append("mOverViewVisibility:");
        sb.append(this.mOverViewVisibility == 0 ? "VISIBLE" : "GONE");
        sb.append(",");
        sb.append("mOverViewSelected:");
        sb.append(this.mOverViewSelected == 0 ? "NON_SELECTED" : "SELECTED");
        sb.append(", ");
        sb.append("mRouteChargeVisibility:");
        sb.append(this.mRouteChargeVisibility == 0 ? "VISIBLE" : "GONE");
        sb.append(", ");
        sb.append("mRouteChargeTipsVisibility:");
        sb.append(this.mRouteChargeTipsVisibility != 0 ? "GONE" : "VISIBLE");
        sb.append(", ");
        sb.append("mRouteChargeEnable:");
        sb.append(this.mRouteChargeEnable != 0 ? "SELECTED" : "NON_SELECTED");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mZoomButtonVisibility);
        parcel.writeInt(this.mScaleVisibility);
        parcel.writeInt(this.mVolumeVisibility);
        parcel.writeInt(this.mMapRenderModeVisibility);
        parcel.writeInt(this.mSettingVisibility);
        parcel.writeInt(this.mOverViewVisibility);
        parcel.writeInt(this.mOverViewSelected);
        parcel.writeInt(this.mRouteChargeVisibility);
        parcel.writeInt(this.mRouteChargeTipsVisibility);
        parcel.writeInt(this.mRouteChargeEnable);
    }
}
