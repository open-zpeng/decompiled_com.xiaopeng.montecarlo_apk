package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class LinkSeamlessIsAmapData extends LinkSeamlessBaseData {
    public static final Parcelable.Creator<LinkSeamlessIsAmapData> CREATOR = new Parcelable.Creator<LinkSeamlessIsAmapData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessIsAmapData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessIsAmapData createFromParcel(Parcel parcel) {
            LinkSeamlessIsAmapData linkSeamlessIsAmapData = new LinkSeamlessIsAmapData();
            linkSeamlessIsAmapData.setAccount(parcel.readByte() == 0);
            return linkSeamlessIsAmapData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessIsAmapData[] newArray(int i) {
            return new LinkSeamlessIsAmapData[i];
        }
    };
    private boolean mIsAccount;

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isAccount() {
        return this.mIsAccount;
    }

    public void setAccount(boolean z) {
        this.mIsAccount = z;
    }

    public LinkSeamlessIsAmapData() {
    }

    protected LinkSeamlessIsAmapData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (!this.mIsAccount ? 1 : 0));
    }
}
