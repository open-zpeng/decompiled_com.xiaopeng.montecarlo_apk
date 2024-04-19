package com.xiaopeng.montecarlo.scenes.navi.dataprovider;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
/* loaded from: classes3.dex */
public class NaviReturnData extends BaseResultData implements Parcelable {
    public static final Parcelable.Creator<NaviReturnData> CREATOR = new Parcelable.Creator<NaviReturnData>() { // from class: com.xiaopeng.montecarlo.scenes.navi.dataprovider.NaviReturnData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NaviReturnData createFromParcel(Parcel parcel) {
            return new NaviReturnData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NaviReturnData[] newArray(int i) {
            return new NaviReturnData[i];
        }
    };
    private Bitmap mCrossIcon;
    private XPCrossImageInfo mCrossImageInfo;
    private int mRequestType;
    private Bitmap mTurnIcon;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected NaviReturnData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NaviReturnData() {
    }

    public void setTurnIcon(Bitmap bitmap) {
        this.mTurnIcon = bitmap;
    }

    public Bitmap getTurnIcon() {
        return this.mTurnIcon;
    }

    public void setCrossIcon(Bitmap bitmap) {
        this.mCrossIcon = bitmap;
    }

    public Bitmap getCrossIcon() {
        return this.mCrossIcon;
    }

    public XPCrossImageInfo getCrossImageInfo() {
        return this.mCrossImageInfo;
    }

    public void setCrossImageInfo(XPCrossImageInfo xPCrossImageInfo) {
        this.mCrossImageInfo = xPCrossImageInfo;
    }

    public void setRequestType(int i) {
        this.mRequestType = i;
    }

    public int getRequestType() {
        return this.mRequestType;
    }
}
