package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepChargeInfo;
import com.autonavi.gbl.search.model.DeepChargePlugsInfo;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class XPDeepChargeInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepChargeInfo> CREATOR = new Parcelable.Creator<XPDeepChargeInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepChargeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepChargeInfo createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepChargeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepChargeInfo[] newArray(int i) {
            return new XPDeepChargeInfo[i];
        }
    };
    @SerializedName("mChargePlugsInfo")
    private XPDeepChargePlugsInfo[] mChargePlugsInfo;
    @SerializedName("mMaxVol")
    private int mMaxVol;
    @SerializedName("mMinVol")
    private int mMinVol;
    @SerializedName("mPlugsType")
    private String mPlugsType;
    @SerializedName("mVolType")
    private String mVolType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setChargePlugsInfo(XPDeepChargePlugsInfo[] xPDeepChargePlugsInfoArr) {
        this.mChargePlugsInfo = xPDeepChargePlugsInfoArr;
    }

    public XPDeepChargePlugsInfo[] getChargePlugsInfo() {
        return this.mChargePlugsInfo;
    }

    public void setMaxVol(int i) {
        this.mMaxVol = i;
    }

    public int getMaxVol() {
        return this.mMaxVol;
    }

    public void setMinVol(int i) {
        this.mMinVol = i;
    }

    public int getMinVol() {
        return this.mMinVol;
    }

    public void setPlugsType(String str) {
        this.mPlugsType = str;
    }

    public String getPlugsType() {
        return this.mPlugsType;
    }

    public void setVolType(String str) {
        this.mVolType = str;
    }

    public String getVolType() {
        return this.mVolType;
    }

    public XPDeepChargeInfo() {
    }

    public XPDeepChargeInfo(DeepChargeInfo deepChargeInfo) {
        ArrayList<DeepChargePlugsInfo> arrayList = deepChargeInfo.charge_Plugs_Info;
        if (CollectionUtils.isEmpty(arrayList)) {
            this.mChargePlugsInfo = new XPDeepChargePlugsInfo[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.mChargePlugsInfo[i] = new XPDeepChargePlugsInfo(arrayList.get(i));
            }
        }
        this.mMaxVol = deepChargeInfo.max_vol;
        this.mMinVol = deepChargeInfo.min_vol;
        this.mPlugsType = deepChargeInfo.plugstype;
        this.mVolType = deepChargeInfo.vol_type;
    }

    protected XPDeepChargeInfo(@NonNull Parcel parcel) {
        settingChargePlugsInfo(parcel);
        this.mMaxVol = parcel.readInt();
        this.mMinVol = parcel.readInt();
        this.mPlugsType = parcel.readString();
        this.mVolType = parcel.readString();
    }

    private void settingChargePlugsInfo(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepChargePlugsInfo.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mChargePlugsInfo = (XPDeepChargePlugsInfo[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepChargePlugsInfo[].class);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelableArray(this.mChargePlugsInfo, i);
        parcel.writeInt(this.mMaxVol);
        parcel.writeInt(this.mMinVol);
        parcel.writeString(this.mPlugsType);
        parcel.writeString(this.mVolType);
    }
}
