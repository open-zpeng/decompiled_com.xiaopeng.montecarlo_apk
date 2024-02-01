package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.gbl.search.model.SearchDeepInfoParam;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes3.dex */
public class XPSearchDeepParam implements Parcelable {
    public static final Parcelable.Creator<XPSearchDeepParam> CREATOR = new Parcelable.Creator<XPSearchDeepParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.XPSearchDeepParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchDeepParam createFromParcel(Parcel parcel) {
            return new XPSearchDeepParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchDeepParam[] newArray(int i) {
            return new XPSearchDeepParam[i];
        }
    };
    private String mPoiId;
    private XPCoordinate2DDouble mPoiLocation;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPSearchDeepParam() {
    }

    protected XPSearchDeepParam(Parcel parcel) {
        this.mPoiId = parcel.readString();
        this.mPoiLocation = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPoiId);
        parcel.writeParcelable(this.mPoiLocation, i);
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public XPCoordinate2DDouble getPoiLocation() {
        return this.mPoiLocation;
    }

    public void setPoiLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLocation = xPCoordinate2DDouble;
    }

    public SearchDeepInfoParam toSearchDeepInfoParam() {
        SearchDeepInfoParam searchDeepInfoParam = new SearchDeepInfoParam();
        searchDeepInfoParam.poiid = this.mPoiId;
        searchDeepInfoParam.poi_loc = this.mPoiLocation.toBLCoord2D();
        return searchDeepInfoParam;
    }
}
