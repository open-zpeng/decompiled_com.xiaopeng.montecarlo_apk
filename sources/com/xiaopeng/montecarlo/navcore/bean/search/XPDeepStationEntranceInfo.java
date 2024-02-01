package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepStationEntranceInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPDeepStationEntranceInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepStationEntranceInfo> CREATOR = new Parcelable.Creator<XPDeepStationEntranceInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepStationEntranceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepStationEntranceInfo createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepStationEntranceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepStationEntranceInfo[] newArray(int i) {
            return new XPDeepStationEntranceInfo[i];
        }
    };
    @SerializedName("mGuideInfo")
    private String mGuideInfo;
    @SerializedName("mName")
    private String mName;
    @SerializedName("mPoiId")
    private String mPoiId;
    @SerializedName("mRecoCode")
    private String mRecoCode;
    @SerializedName("mRecoInfo")
    private String mRecoInfo;
    @SerializedName("mRelPoiId")
    private String mRelPoiId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setRecoCode(String str) {
        this.mRecoCode = str;
    }

    public String getRecoCode() {
        return this.mRecoCode;
    }

    public void setRecoInfo(String str) {
        this.mRecoInfo = str;
    }

    public String getRecoInfo() {
        return this.mRecoInfo;
    }

    public void setGuideInfo(String str) {
        this.mGuideInfo = str;
    }

    public String getGuideInfo() {
        return this.mGuideInfo;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setRelPoiId(String str) {
        this.mRelPoiId = str;
    }

    public String getRelPoiId() {
        return this.mRelPoiId;
    }

    public XPDeepStationEntranceInfo() {
    }

    public XPDeepStationEntranceInfo(DeepStationEntranceInfo deepStationEntranceInfo) {
        this.mRecoCode = deepStationEntranceInfo.reco_code;
        this.mRecoInfo = deepStationEntranceInfo.reco_info;
        this.mGuideInfo = deepStationEntranceInfo.guide_info;
        this.mName = deepStationEntranceInfo.name;
        this.mPoiId = deepStationEntranceInfo.poiid;
        this.mRelPoiId = deepStationEntranceInfo.rel_poiid;
    }

    protected XPDeepStationEntranceInfo(Parcel parcel) {
        this.mRecoCode = parcel.readString();
        this.mRecoInfo = parcel.readString();
        this.mGuideInfo = parcel.readString();
        this.mName = parcel.readString();
        this.mPoiId = parcel.readString();
        this.mRelPoiId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.mRecoCode);
        parcel.writeString(this.mRecoInfo);
        parcel.writeString(this.mGuideInfo);
        parcel.writeString(this.mName);
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mRelPoiId);
    }
}
