package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepAirport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPDeepAirport implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepAirport> CREATOR = new Parcelable.Creator<XPDeepAirport>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepAirport.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepAirport createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepAirport(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepAirport[] newArray(int i) {
            return new XPDeepAirport[i];
        }
    };
    @SerializedName("mDynInfo")
    private XPDeepAirportRti mDynInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setDynInfo(XPDeepAirportRti xPDeepAirportRti) {
        this.mDynInfo = xPDeepAirportRti;
    }

    public XPDeepAirportRti getDynInfo() {
        return this.mDynInfo;
    }

    public XPDeepAirport() {
    }

    public XPDeepAirport(DeepAirport deepAirport) {
        this.mDynInfo = new XPDeepAirportRti(deepAirport.dynInfo);
    }

    protected XPDeepAirport(Parcel parcel) {
        this.mDynInfo = (XPDeepAirportRti) parcel.readParcelable(XPDeepAirportRti.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.mDynInfo, i);
    }
}
