package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class LinkSeamlessWechatQrCodeData extends LinkSeamlessBaseData {
    public static final Parcelable.Creator<LinkSeamlessWechatQrCodeData> CREATOR = new Parcelable.Creator<LinkSeamlessWechatQrCodeData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessWechatQrCodeData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessWechatQrCodeData createFromParcel(Parcel parcel) {
            LinkSeamlessWechatQrCodeData linkSeamlessWechatQrCodeData = new LinkSeamlessWechatQrCodeData();
            linkSeamlessWechatQrCodeData.setQrCode(parcel.readString());
            return linkSeamlessWechatQrCodeData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessWechatQrCodeData[] newArray(int i) {
            return new LinkSeamlessWechatQrCodeData[i];
        }
    };
    private String mQrCode;

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LinkSeamlessWechatQrCodeData() {
    }

    public String getQrCode() {
        return this.mQrCode;
    }

    public void setQrCode(String str) {
        this.mQrCode = str;
    }

    protected LinkSeamlessWechatQrCodeData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData, com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mQrCode);
    }
}
