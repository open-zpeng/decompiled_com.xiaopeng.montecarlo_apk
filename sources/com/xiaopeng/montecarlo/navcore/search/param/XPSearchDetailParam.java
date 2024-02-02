package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.SearchDetailInfoParam;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes2.dex */
public class XPSearchDetailParam implements Parcelable {
    public static final Parcelable.Creator<XPSearchDetailParam> CREATOR = new Parcelable.Creator<XPSearchDetailParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.XPSearchDetailParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchDetailParam createFromParcel(Parcel parcel) {
            return new XPSearchDetailParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchDetailParam[] newArray(int i) {
            return new XPSearchDetailParam[i];
        }
    };
    private String mPoiId;
    private XPCoordinate2DDouble mPoiLocation;
    private String mPoiName;
    private XPCoordinate2DDouble mUserLocation;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPSearchDetailParam() {
    }

    protected XPSearchDetailParam(Parcel parcel) {
        this.mPoiId = parcel.readString();
        this.mPoiName = parcel.readString();
        this.mUserLocation = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mPoiLocation = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
    }

    @NonNull
    public SearchDetailInfoParam toSearchDetailInfoParam() {
        SearchDetailInfoParam searchDetailInfoParam = new SearchDetailInfoParam();
        searchDetailInfoParam.id = this.mPoiId;
        searchDetailInfoParam.poi_name = this.mPoiName;
        searchDetailInfoParam.poi_loc = this.mPoiLocation.toBLCoord2D();
        searchDetailInfoParam.user_loc = this.mUserLocation.toBLCoord2D();
        return searchDetailInfoParam;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mPoiName);
        parcel.writeParcelable(this.mUserLocation, i);
        parcel.writeParcelable(this.mPoiLocation, i);
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getPoiName() {
        return this.mPoiName;
    }

    public void setPoiName(String str) {
        this.mPoiName = str;
    }

    public XPCoordinate2DDouble getUserLocation() {
        return this.mUserLocation;
    }

    public void setUserLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mUserLocation = xPCoordinate2DDouble;
    }

    public XPCoordinate2DDouble getPoiLocation() {
        return this.mPoiLocation;
    }

    public void setPoiLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLocation = xPCoordinate2DDouble;
    }
}
