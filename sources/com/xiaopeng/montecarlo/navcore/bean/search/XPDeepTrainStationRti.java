package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepStationEntranceInfo;
import com.autonavi.gbl.search.model.DeepStationPoisList;
import com.autonavi.gbl.search.model.DeepTrainStationRti;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class XPDeepTrainStationRti implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepTrainStationRti> CREATOR = new Parcelable.Creator<XPDeepTrainStationRti>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepTrainStationRti.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepTrainStationRti createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepTrainStationRti(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepTrainStationRti[] newArray(int i) {
            return new XPDeepTrainStationRti[i];
        }
    };
    @SerializedName("mStationEntranceInfo")
    private XPDeepStationEntranceInfo[] mStationEntranceInfo;
    @SerializedName("mStationPoisList")
    private XPDeepStationPoisList[] mStationPoisList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPDeepStationPoisList[] getStationPoisList() {
        return this.mStationPoisList;
    }

    public void setStationPoisList(XPDeepStationPoisList[] xPDeepStationPoisListArr) {
        this.mStationPoisList = xPDeepStationPoisListArr;
    }

    public XPDeepStationEntranceInfo[] getStationEntranceInfo() {
        return this.mStationEntranceInfo;
    }

    public void setStationEntranceInfo(XPDeepStationEntranceInfo[] xPDeepStationEntranceInfoArr) {
        this.mStationEntranceInfo = xPDeepStationEntranceInfoArr;
    }

    public XPDeepTrainStationRti() {
    }

    public XPDeepTrainStationRti(DeepTrainStationRti deepTrainStationRti) {
        ArrayList<DeepStationPoisList> arrayList = deepTrainStationRti.stationPoisList;
        if (CollectionUtils.isEmpty(arrayList)) {
            this.mStationPoisList = new XPDeepStationPoisList[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.mStationPoisList[i] = new XPDeepStationPoisList(arrayList.get(i));
            }
        }
        ArrayList<DeepStationEntranceInfo> arrayList2 = deepTrainStationRti.stationEntranceInfo;
        if (CollectionUtils.isEmpty(arrayList2)) {
            this.mStationEntranceInfo = new XPDeepStationEntranceInfo[arrayList2.size()];
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                this.mStationEntranceInfo[i2] = new XPDeepStationEntranceInfo(arrayList2.get(i2));
            }
        }
    }

    protected XPDeepTrainStationRti(@NonNull Parcel parcel) {
        settingStationPoisList(parcel);
        settingStationEntranceInfo(parcel);
    }

    private void settingStationEntranceInfo(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepStationEntranceInfo.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mStationEntranceInfo = (XPDeepStationEntranceInfo[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepStationEntranceInfo[].class);
        }
    }

    private void settingStationPoisList(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepStationPoisList.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mStationPoisList = (XPDeepStationPoisList[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepStationPoisList[].class);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelableArray(this.mStationPoisList, i);
        parcel.writeParcelableArray(this.mStationEntranceInfo, i);
    }
}
