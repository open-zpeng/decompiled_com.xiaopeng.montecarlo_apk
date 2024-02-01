package com.xiaopeng.montecarlo.navcore.bean.restrict;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.aosclient.model.GCoord3DDouble;
import com.autonavi.gbl.aosclient.model.GRestrictRule;
import com.autonavi.gbl.aosclient.model.GRestrictRulePoints;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class XPGRestrictRule implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPGRestrictRule> CREATOR = new Parcelable.Creator<XPGRestrictRule>() { // from class: com.xiaopeng.montecarlo.navcore.bean.restrict.XPGRestrictRule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPGRestrictRule createFromParcel(Parcel parcel) {
            return new XPGRestrictRule(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPGRestrictRule[] newArray(int i) {
            return new XPGRestrictRule[i];
        }
    };
    public ArrayList<ArrayList<XPCoord3DDouble>> mAreapoints;
    public XPRectDouble mBound;
    public XPCoord3DDouble mCenterpoint;
    public String mDesc;
    public int mEffect;
    public ArrayList<ArrayList<XPCoord3DDouble>> mLinepoints;
    public int mLocal;
    public String mOtherdesc;
    public String mPolicyname;
    public int mRing;
    public int mRuleid;
    public String mSummary;
    public String mTime;
    public int mVehicle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<Coord3DDouble> toBLCoord3DDoubleArrayList(ArrayList<XPCoord3DDouble> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<Coord3DDouble> arrayList2 = new ArrayList<>();
        Iterator<XPCoord3DDouble> it = arrayList.iterator();
        while (it.hasNext()) {
            XPCoord3DDouble next = it.next();
            arrayList2.add(new Coord3DDouble(next.mLon, next.mLat, next.mZ));
        }
        return arrayList2;
    }

    public XPGRestrictRule(GRestrictRule gRestrictRule) {
        if (gRestrictRule == null) {
            return;
        }
        this.mPolicyname = gRestrictRule.policyname;
        this.mRuleid = gRestrictRule.ruleid;
        this.mRing = gRestrictRule.ring;
        this.mEffect = gRestrictRule.effect;
        this.mLocal = gRestrictRule.local;
        this.mVehicle = gRestrictRule.vehicle;
        this.mTime = gRestrictRule.time;
        this.mSummary = gRestrictRule.summary;
        this.mDesc = gRestrictRule.desc;
        this.mOtherdesc = gRestrictRule.otherdesc;
        this.mCenterpoint = new XPCoord3DDouble(gRestrictRule.centerpoint);
        if (gRestrictRule.linepoints == null) {
            this.mLinepoints = null;
        } else {
            this.mLinepoints = new ArrayList<>();
            Iterator<GRestrictRulePoints> it = gRestrictRule.linepoints.iterator();
            while (it.hasNext()) {
                ArrayList<XPCoord3DDouble> arrayList = new ArrayList<>();
                Iterator<GCoord3DDouble> it2 = it.next().lstPoints.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new XPCoord3DDouble(it2.next()));
                }
                this.mLinepoints.add(arrayList);
            }
        }
        if (gRestrictRule.areapoints == null) {
            this.mAreapoints = null;
        } else {
            this.mAreapoints = new ArrayList<>();
            Iterator<GRestrictRulePoints> it3 = gRestrictRule.areapoints.iterator();
            while (it3.hasNext()) {
                ArrayList<XPCoord3DDouble> arrayList2 = new ArrayList<>();
                Iterator<GCoord3DDouble> it4 = it3.next().lstPoints.iterator();
                while (it4.hasNext()) {
                    arrayList2.add(new XPCoord3DDouble(it4.next()));
                }
                this.mAreapoints.add(arrayList2);
            }
        }
        this.mBound = new XPRectDouble(gRestrictRule.bound);
    }

    protected XPGRestrictRule(Parcel parcel) {
        this.mPolicyname = parcel.readString();
        this.mRuleid = parcel.readInt();
        this.mRing = parcel.readInt();
        this.mEffect = parcel.readInt();
        this.mLocal = parcel.readInt();
        this.mVehicle = parcel.readInt();
        this.mTime = parcel.readString();
        this.mSummary = parcel.readString();
        this.mDesc = parcel.readString();
        this.mOtherdesc = parcel.readString();
        this.mCenterpoint = (XPCoord3DDouble) parcel.readParcelable(XPCoord3DDouble.class.getClassLoader());
        int readInt = parcel.readInt();
        if (-1 == readInt) {
            this.mLinepoints = null;
        } else if (readInt == 0) {
            this.mLinepoints = new ArrayList<>();
        } else {
            this.mLinepoints = new ArrayList<>();
            for (int i = 0; i < readInt; i++) {
                ArrayList<XPCoord3DDouble> arrayList = new ArrayList<>();
                parcel.readTypedList(arrayList, XPCoord3DDouble.CREATOR);
                this.mLinepoints.add(arrayList);
            }
        }
        int readInt2 = parcel.readInt();
        if (-1 == readInt2) {
            this.mAreapoints = null;
        } else if (readInt2 == 0) {
            this.mAreapoints = new ArrayList<>();
        } else {
            this.mAreapoints = new ArrayList<>();
            for (int i2 = 0; i2 < readInt2; i2++) {
                ArrayList<XPCoord3DDouble> arrayList2 = new ArrayList<>();
                parcel.readTypedList(arrayList2, XPCoord3DDouble.CREATOR);
                this.mAreapoints.add(arrayList2);
            }
        }
        this.mBound = (XPRectDouble) parcel.readParcelable(XPRectDouble.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPolicyname);
        parcel.writeInt(this.mRuleid);
        parcel.writeInt(this.mRing);
        parcel.writeInt(this.mEffect);
        parcel.writeInt(this.mLocal);
        parcel.writeInt(this.mVehicle);
        parcel.writeString(this.mTime);
        parcel.writeString(this.mSummary);
        parcel.writeString(this.mDesc);
        parcel.writeString(this.mOtherdesc);
        parcel.writeParcelable(this.mCenterpoint, i);
        ArrayList<ArrayList<XPCoord3DDouble>> arrayList = this.mLinepoints;
        parcel.writeInt(arrayList != null ? arrayList.size() : -1);
        Iterator<ArrayList<XPCoord3DDouble>> it = this.mLinepoints.iterator();
        while (it.hasNext()) {
            parcel.writeTypedList(it.next());
        }
        ArrayList<ArrayList<XPCoord3DDouble>> arrayList2 = this.mAreapoints;
        parcel.writeInt(arrayList2 != null ? arrayList2.size() : -1);
        Iterator<ArrayList<XPCoord3DDouble>> it2 = this.mAreapoints.iterator();
        while (it2.hasNext()) {
            parcel.writeTypedList(it2.next());
        }
        parcel.writeParcelable(this.mBound, i);
    }
}
