package com.xiaopeng.montecarlo.scenes.settingscene.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.root.dataprovider.BaseResultData;
/* loaded from: classes3.dex */
public class SettingResultData extends BaseResultData {
    public static final Parcelable.Creator<SettingResultData> CREATOR = new Parcelable.Creator<SettingResultData>() { // from class: com.xiaopeng.montecarlo.scenes.settingscene.dataprovider.SettingResultData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingResultData createFromParcel(Parcel parcel) {
            return new SettingResultData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SettingResultData[] newArray(int i) {
            return new SettingResultData[i];
        }
    };
    private boolean mBindReulst;
    protected int mSettingType;

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SettingResultData() {
        this.mBindReulst = false;
    }

    protected SettingResultData(Parcel parcel) {
        super(parcel);
        this.mBindReulst = false;
        this.mSettingType = parcel.readInt();
    }

    public boolean getBindReulst() {
        return this.mBindReulst;
    }

    public void setBindReulst(boolean z) {
        this.mBindReulst = z;
    }

    public int getType() {
        return this.mSettingType;
    }

    public void setType(int i) {
        this.mSettingType = i;
    }

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseResultData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mSettingType);
    }
}
