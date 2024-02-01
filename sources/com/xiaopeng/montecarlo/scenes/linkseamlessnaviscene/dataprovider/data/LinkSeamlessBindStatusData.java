package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class LinkSeamlessBindStatusData extends LinkSeamlessBaseData {
    public static final Parcelable.Creator<LinkSeamlessBindStatusData> CREATOR = new Parcelable.Creator<LinkSeamlessBindStatusData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBindStatusData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessBindStatusData createFromParcel(Parcel parcel) {
            new LinkSeamlessBindStatusData().setBind(parcel.readByte() == 0);
            return new LinkSeamlessBindStatusData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessBindStatusData[] newArray(int i) {
            return new LinkSeamlessBindStatusData[i];
        }
    };
    private boolean mIsBind;

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isBind() {
        return this.mIsBind;
    }

    public void setBind(boolean z) {
        this.mIsBind = z;
    }

    public LinkSeamlessBindStatusData() {
    }

    protected LinkSeamlessBindStatusData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (!this.mIsBind ? 1 : 0));
    }
}
