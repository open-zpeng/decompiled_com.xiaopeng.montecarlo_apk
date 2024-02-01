package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepAirportRti;
import com.autonavi.gbl.search.model.DeepAirportTerminalInfo;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class XPDeepAirportRti implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepAirportRti> CREATOR = new Parcelable.Creator<XPDeepAirportRti>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepAirportRti.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepAirportRti createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepAirportRti(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepAirportRti[] newArray(int i) {
            return new XPDeepAirportRti[i];
        }
    };
    @SerializedName("mTerminalInfo")
    private XPDeepAirportTerminalInfo[] mTerminalInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setTerminalInfo(XPDeepAirportTerminalInfo[] xPDeepAirportTerminalInfoArr) {
        this.mTerminalInfo = xPDeepAirportTerminalInfoArr;
    }

    public XPDeepAirportTerminalInfo[] getTerminalInfo() {
        return this.mTerminalInfo;
    }

    public XPDeepAirportRti() {
    }

    public XPDeepAirportRti(DeepAirportRti deepAirportRti) {
        ArrayList<DeepAirportTerminalInfo> arrayList = deepAirportRti.terminalInfo;
        if (CollectionUtils.isEmpty(arrayList)) {
            this.mTerminalInfo = new XPDeepAirportTerminalInfo[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.mTerminalInfo[i] = new XPDeepAirportTerminalInfo(arrayList.get(i));
            }
        }
    }

    protected XPDeepAirportRti(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepAirportTerminalInfo.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mTerminalInfo = (XPDeepAirportTerminalInfo[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepAirportTerminalInfo[].class);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelableArray(this.mTerminalInfo, i);
    }
}
