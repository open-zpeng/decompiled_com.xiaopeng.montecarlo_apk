package com.xiaopeng.montecarlo.navcore.bean.restrict;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.aosclient.model.GRectDouble;
import com.autonavi.gbl.common.model.RectDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPRectDouble implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPRectDouble> CREATOR = new Parcelable.Creator<XPRectDouble>() { // from class: com.xiaopeng.montecarlo.navcore.bean.restrict.XPRectDouble.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPRectDouble createFromParcel(Parcel parcel) {
            return new XPRectDouble(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPRectDouble[] newArray(int i) {
            return new XPRectDouble[i];
        }
    };
    public double mBottom;
    public double mLeft;
    public double mRight;
    public double mTop;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPRectDouble(RectDouble rectDouble) {
        this.mLeft = rectDouble.left;
        this.mTop = rectDouble.top;
        this.mRight = rectDouble.right;
        this.mBottom = rectDouble.bottom;
    }

    public XPRectDouble(GRectDouble gRectDouble) {
        this.mLeft = gRectDouble.left;
        this.mTop = gRectDouble.top;
        this.mRight = gRectDouble.right;
        this.mBottom = gRectDouble.bottom;
    }

    protected XPRectDouble(Parcel parcel) {
        this.mLeft = parcel.readDouble();
        this.mTop = parcel.readDouble();
        this.mRight = parcel.readDouble();
        this.mBottom = parcel.readDouble();
    }

    public RectDouble toBLRectDouble() {
        RectDouble rectDouble = new RectDouble();
        rectDouble.left = this.mLeft;
        rectDouble.top = this.mTop;
        rectDouble.right = this.mRight;
        rectDouble.bottom = this.mBottom;
        return rectDouble;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLeft);
        parcel.writeDouble(this.mTop);
        parcel.writeDouble(this.mRight);
        parcel.writeDouble(this.mBottom);
    }
}
