package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
/* loaded from: classes2.dex */
public class LinkSeamlessBaseData extends BaseResultData implements Parcelable {
    public static final Parcelable.Creator<LinkSeamlessBaseData> CREATOR = new Parcelable.Creator<LinkSeamlessBaseData>() { // from class: com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider.data.LinkSeamlessBaseData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessBaseData createFromParcel(Parcel parcel) {
            LinkSeamlessBaseData linkSeamlessBaseData = new LinkSeamlessBaseData();
            linkSeamlessBaseData.mParamType = parcel.readInt();
            linkSeamlessBaseData.mIsSuccess = parcel.readByte() == 0;
            return linkSeamlessBaseData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkSeamlessBaseData[] newArray(int i) {
            return new LinkSeamlessBaseData[i];
        }
    };
    boolean mIsSuccess;
    private int mParamType;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setIsSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public int getParamType() {
        return this.mParamType;
    }

    public void setParamType(int i) {
        this.mParamType = i;
    }

    public LinkSeamlessBaseData() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkSeamlessBaseData(Parcel parcel) {
        super(parcel);
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mParamType);
        parcel.writeByte((byte) (!this.mIsSuccess ? 1 : 0));
    }
}
