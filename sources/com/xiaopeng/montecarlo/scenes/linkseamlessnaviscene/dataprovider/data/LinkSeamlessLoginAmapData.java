package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class LinkSeamlessLoginAmapData extends LinkSeamlessBaseData {
    public static final Parcelable.Creator<LinkSeamlessLoginAmapData> CREATOR = new Parcelable.Creator<LinkSeamlessLoginAmapData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessLoginAmapData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessLoginAmapData createFromParcel(Parcel parcel) {
            LinkSeamlessLoginAmapData linkSeamlessLoginAmapData = new LinkSeamlessLoginAmapData();
            linkSeamlessLoginAmapData.setLogin(parcel.readByte() == 0);
            return linkSeamlessLoginAmapData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessLoginAmapData[] newArray(int i) {
            return new LinkSeamlessLoginAmapData[i];
        }
    };
    private boolean mIsLogin;

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isLogin() {
        return this.mIsLogin;
    }

    public void setLogin(boolean z) {
        this.mIsLogin = z;
    }

    public LinkSeamlessLoginAmapData() {
    }

    protected LinkSeamlessLoginAmapData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (!this.mIsLogin ? 1 : 0));
    }
}
