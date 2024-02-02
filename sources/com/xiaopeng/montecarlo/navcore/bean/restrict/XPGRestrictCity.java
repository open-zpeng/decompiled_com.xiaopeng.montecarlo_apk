package com.xiaopeng.montecarlo.navcore.bean.restrict;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.aosclient.model.GRestrictCity;
import com.autonavi.gbl.aosclient.model.GRestrictRule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class XPGRestrictCity implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPGRestrictCity> CREATOR = new Parcelable.Creator<XPGRestrictCity>() { // from class: com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictCity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPGRestrictCity createFromParcel(Parcel parcel) {
            return new XPGRestrictCity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPGRestrictCity[] newArray(int i) {
            return new XPGRestrictCity[i];
        }
    };
    public int mCityCode;
    public String mCityName;
    public int mRuleNums;
    public int mRuleType;
    public ArrayList<XPGRestrictRule> mRules;
    public String mTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPGRestrictCity(GRestrictCity gRestrictCity) {
        this.mCityCode = gRestrictCity.cityCode;
        this.mCityName = gRestrictCity.cityName;
        this.mTitle = gRestrictCity.title;
        this.mRuleNums = gRestrictCity.ruleNums;
        this.mRuleType = gRestrictCity.ruleType;
        this.mRules = new ArrayList<>();
        Iterator<GRestrictRule> it = gRestrictCity.rules.iterator();
        while (it.hasNext()) {
            this.mRules.add(new XPGRestrictRule(it.next()));
        }
    }

    protected XPGRestrictCity(Parcel parcel) {
        this.mCityCode = parcel.readInt();
        this.mCityName = parcel.readString();
        this.mTitle = parcel.readString();
        this.mRuleNums = parcel.readInt();
        this.mRuleType = parcel.readInt();
        this.mRules = parcel.createTypedArrayList(XPGRestrictRule.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCityCode);
        parcel.writeString(this.mCityName);
        parcel.writeString(this.mTitle);
        parcel.writeInt(this.mRuleNums);
        parcel.writeInt(this.mRuleType);
        parcel.writeTypedList(this.mRules);
    }
}
