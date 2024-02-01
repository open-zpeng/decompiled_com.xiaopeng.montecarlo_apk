package com.xiaopeng.montecarlo.navcore.bean.restrict;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaDataRuleRes;
import com.autonavi.gbl.aosclient.model.GRestrictCity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class XPGReStrictedAreaDataRuleRes implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPGReStrictedAreaDataRuleRes> CREATOR = new Parcelable.Creator<XPGReStrictedAreaDataRuleRes>() { // from class: com.xiaopeng.montecarlo.navcore.bean.restrict.XPGReStrictedAreaDataRuleRes.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPGReStrictedAreaDataRuleRes createFromParcel(Parcel parcel) {
            return new XPGReStrictedAreaDataRuleRes(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPGReStrictedAreaDataRuleRes[] newArray(int i) {
            return new XPGReStrictedAreaDataRuleRes[i];
        }
    };
    public ArrayList<XPGRestrictCity> mCities;
    public int mCitynums;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPGReStrictedAreaDataRuleRes(GReStrictedAreaDataRuleRes gReStrictedAreaDataRuleRes) {
        this.mCitynums = gReStrictedAreaDataRuleRes.citynums;
        this.mCities = new ArrayList<>();
        Iterator<GRestrictCity> it = gReStrictedAreaDataRuleRes.cities.iterator();
        while (it.hasNext()) {
            this.mCities.add(new XPGRestrictCity(it.next()));
        }
    }

    protected XPGReStrictedAreaDataRuleRes(Parcel parcel) {
        this.mCitynums = parcel.readInt();
        this.mCities = parcel.createTypedArrayList(XPGRestrictCity.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCitynums);
        parcel.writeTypedList(this.mCities);
    }
}
