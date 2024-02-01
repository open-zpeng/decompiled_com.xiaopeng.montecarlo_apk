package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class LinkSeamlessUserInfoData extends LinkSeamlessBaseData implements Parcelable {
    public static final Parcelable.Creator<LinkSeamlessUserInfoData> CREATOR = new Parcelable.Creator<LinkSeamlessUserInfoData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessUserInfoData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessUserInfoData createFromParcel(Parcel parcel) {
            LinkSeamlessUserInfoData linkSeamlessUserInfoData = new LinkSeamlessUserInfoData();
            linkSeamlessUserInfoData.setUserName(parcel.readString());
            linkSeamlessUserInfoData.setTemp(parcel.readByte() == 0);
            return linkSeamlessUserInfoData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessUserInfoData[] newArray(int i) {
            return new LinkSeamlessUserInfoData[i];
        }
    };
    private boolean mIsTemp;
    private String mUserName;

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LinkSeamlessUserInfoData() {
    }

    public String getUserName() {
        return this.mUserName;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public boolean isTemp() {
        return this.mIsTemp;
    }

    public void setTemp(boolean z) {
        this.mIsTemp = z;
    }

    protected LinkSeamlessUserInfoData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mUserName);
        parcel.writeByte((byte) (!this.mIsTemp ? 1 : 0));
    }
}
