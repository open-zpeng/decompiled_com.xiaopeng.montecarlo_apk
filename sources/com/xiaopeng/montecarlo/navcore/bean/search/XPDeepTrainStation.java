package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepTrainStation;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPDeepTrainStation implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepTrainStation> CREATOR = new Parcelable.Creator<XPDeepTrainStation>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepTrainStation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepTrainStation createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepTrainStation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepTrainStation[] newArray(int i) {
            return new XPDeepTrainStation[i];
        }
    };
    @SerializedName("mDynInfo")
    private XPDeepTrainStationRti mDynInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setDynInfo(XPDeepTrainStationRti xPDeepTrainStationRti) {
        this.mDynInfo = xPDeepTrainStationRti;
    }

    public XPDeepTrainStationRti getDynInfo() {
        return this.mDynInfo;
    }

    public XPDeepTrainStation() {
    }

    public XPDeepTrainStation(DeepTrainStation deepTrainStation) {
        this.mDynInfo = new XPDeepTrainStationRti(deepTrainStation.dynInfo);
    }

    protected XPDeepTrainStation(Parcel parcel) {
        this.mDynInfo = (XPDeepTrainStationRti) parcel.readParcelable(XPDeepTrainStationRti.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.mDynInfo, i);
    }
}
