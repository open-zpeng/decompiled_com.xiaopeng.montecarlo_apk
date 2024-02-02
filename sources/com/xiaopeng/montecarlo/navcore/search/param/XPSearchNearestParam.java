package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.SearchNearestParam;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes2.dex */
public class XPSearchNearestParam implements Parcelable {
    public static final Parcelable.Creator<XPSearchNearestParam> CREATOR = new Parcelable.Creator<XPSearchNearestParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.XPSearchNearestParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchNearestParam createFromParcel(Parcel parcel) {
            return new XPSearchNearestParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchNearestParam[] newArray(int i) {
            return new XPSearchNearestParam[i];
        }
    };
    private XPCoordinate2DDouble mPoiLocation;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPSearchNearestParam() {
    }

    protected XPSearchNearestParam(Parcel parcel) {
        this.mPoiLocation = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
    }

    @NonNull
    public SearchNearestParam toSearchNearestParam() {
        SearchNearestParam searchNearestParam = new SearchNearestParam();
        searchNearestParam.poi_loc = this.mPoiLocation.toBLCoord2D();
        return searchNearestParam;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPoiLocation, i);
    }

    public XPCoordinate2DDouble getPoiLocation() {
        return this.mPoiLocation;
    }

    public void setPoiLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLocation = xPCoordinate2DDouble;
    }
}
