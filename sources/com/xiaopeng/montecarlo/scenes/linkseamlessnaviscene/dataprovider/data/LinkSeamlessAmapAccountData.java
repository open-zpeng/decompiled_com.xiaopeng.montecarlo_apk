package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class LinkSeamlessAmapAccountData extends LinkSeamlessBaseData {
    public static final Parcelable.Creator<LinkSeamlessAmapAccountData> CREATOR = new Parcelable.Creator<LinkSeamlessAmapAccountData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessAmapAccountData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessAmapAccountData createFromParcel(Parcel parcel) {
            LinkSeamlessAmapAccountData linkSeamlessAmapAccountData = new LinkSeamlessAmapAccountData();
            linkSeamlessAmapAccountData.setNickName(parcel.readString());
            return linkSeamlessAmapAccountData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessAmapAccountData[] newArray(int i) {
            return new LinkSeamlessAmapAccountData[i];
        }
    };
    private String mNickName;

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public LinkSeamlessAmapAccountData() {
    }

    protected LinkSeamlessAmapAccountData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mNickName);
    }
}
