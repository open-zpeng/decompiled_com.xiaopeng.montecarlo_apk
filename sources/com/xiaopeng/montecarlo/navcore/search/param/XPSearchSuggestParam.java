package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.SearchSuggestParam;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes2.dex */
public class XPSearchSuggestParam implements Parcelable {
    public static final Parcelable.Creator<XPSearchSuggestParam> CREATOR = new Parcelable.Creator<XPSearchSuggestParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.XPSearchSuggestParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchSuggestParam createFromParcel(Parcel parcel) {
            return new XPSearchSuggestParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPSearchSuggestParam[] newArray(int i) {
            return new XPSearchSuggestParam[i];
        }
    };
    private boolean mAdcode;
    private String mCategory;
    private int mCity;
    private String mDataType;
    private String mGeoobj;
    private String mKeyword;
    private String mNeedVir;
    private boolean mNeedXy;
    private int mOfflineAdminCode;
    private int mOfflineResultMaxCount;
    private XPCoordinate2DDouble mPoiLoc;
    private int mSearchType;
    private int mSession;
    private String mSiv;
    private String mStepId;
    private int mSugType;
    private String mSuperId;
    private String mUserCity;
    private XPCoordinate2DDouble mUserLoc;
    private String mVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XPSearchSuggestParam() {
    }

    protected XPSearchSuggestParam(Parcel parcel) {
        this.mKeyword = parcel.readString();
        this.mCity = parcel.readInt();
        this.mPoiLoc = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mCategory = parcel.readString();
        this.mDataType = parcel.readString();
        this.mAdcode = parcel.readByte() != 0;
        this.mUserLoc = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mGeoobj = parcel.readString();
        this.mSession = parcel.readInt();
        this.mStepId = parcel.readString();
        this.mUserCity = parcel.readString();
        this.mNeedVir = parcel.readString();
        this.mNeedXy = parcel.readByte() != 0;
        this.mOfflineAdminCode = parcel.readInt();
        this.mSugType = parcel.readInt();
        this.mSuperId = parcel.readString();
        this.mVersion = parcel.readString();
        this.mSiv = parcel.readString();
        this.mOfflineResultMaxCount = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKeyword);
        parcel.writeInt(this.mCity);
        parcel.writeParcelable(this.mPoiLoc, i);
        parcel.writeString(this.mCategory);
        parcel.writeString(this.mDataType);
        parcel.writeByte(this.mAdcode ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.mUserLoc, i);
        parcel.writeString(this.mGeoobj);
        parcel.writeInt(this.mSession);
        parcel.writeString(this.mStepId);
        parcel.writeString(this.mUserCity);
        parcel.writeString(this.mNeedVir);
        parcel.writeByte(this.mNeedXy ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mOfflineAdminCode);
        parcel.writeInt(this.mSugType);
        parcel.writeString(this.mSuperId);
        parcel.writeString(this.mVersion);
        parcel.writeString(this.mSiv);
        parcel.writeInt(this.mOfflineResultMaxCount);
    }

    @NonNull
    public SearchSuggestParam toSearchSuggestParam() {
        SearchSuggestParam searchSuggestParam = new SearchSuggestParam();
        searchSuggestParam.keyword = this.mKeyword;
        searchSuggestParam.city = this.mCity;
        searchSuggestParam.poi_loc = this.mPoiLoc.toBLCoord2D();
        searchSuggestParam.category = this.mCategory;
        searchSuggestParam.datatype = this.mDataType;
        searchSuggestParam.adcode = this.mAdcode;
        searchSuggestParam.user_loc = this.mUserLoc.toBLCoord2D();
        searchSuggestParam.geoobj = this.mGeoobj;
        int i = this.mSession;
        if (i > 0) {
            searchSuggestParam.session = i;
        }
        searchSuggestParam.stepid = this.mStepId;
        searchSuggestParam.user_city = this.mUserCity;
        searchSuggestParam.need_vir = this.mNeedVir;
        searchSuggestParam.need_xy = this.mNeedXy;
        searchSuggestParam.offlineAdminCode = this.mOfflineAdminCode;
        searchSuggestParam.sugType = this.mSugType;
        searchSuggestParam.superid = this.mSuperId;
        searchSuggestParam.version = this.mVersion;
        searchSuggestParam.siv = this.mSiv;
        int i2 = this.mOfflineResultMaxCount;
        if (i2 > 0) {
            searchSuggestParam.offlineResultMaxCount = i2;
        }
        return searchSuggestParam;
    }

    public String getKeyword() {
        return this.mKeyword;
    }

    public void setKeyword(String str) {
        this.mKeyword = str;
    }

    public int getCity() {
        return this.mCity;
    }

    public void setCity(int i) {
        this.mCity = i;
    }

    public XPCoordinate2DDouble getPoiLoc() {
        return this.mPoiLoc;
    }

    public void setPoiLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLoc = xPCoordinate2DDouble;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getDataType() {
        return this.mDataType;
    }

    public void setDataType(String str) {
        this.mDataType = str;
    }

    public boolean isAdcode() {
        return this.mAdcode;
    }

    public void setAdcode(boolean z) {
        this.mAdcode = z;
    }

    public XPCoordinate2DDouble getUserLoc() {
        return this.mUserLoc;
    }

    public void setUserLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mUserLoc = xPCoordinate2DDouble;
    }

    public String getGeoobj() {
        return this.mGeoobj;
    }

    public void setGeoobj(String str) {
        this.mGeoobj = str;
    }

    public int getSession() {
        return this.mSession;
    }

    public void setSession(int i) {
        this.mSession = i;
    }

    public String getStepId() {
        return this.mStepId;
    }

    public void setStepId(String str) {
        this.mStepId = str;
    }

    public String getUserCity() {
        return this.mUserCity;
    }

    public void setUserCity(String str) {
        this.mUserCity = str;
    }

    public String getNeedVir() {
        return this.mNeedVir;
    }

    public void setNeedVir(String str) {
        this.mNeedVir = str;
    }

    public boolean isNeedXy() {
        return this.mNeedXy;
    }

    public void setNeedXy(boolean z) {
        this.mNeedXy = z;
    }

    public int getOfflineAdminCode() {
        return this.mOfflineAdminCode;
    }

    public void setOfflineAdminCode(int i) {
        this.mOfflineAdminCode = i;
    }

    public int getSugType() {
        return this.mSugType;
    }

    public void setSugType(int i) {
        this.mSugType = i;
    }

    public String getSuperId() {
        return this.mSuperId;
    }

    public void setSuperId(String str) {
        this.mSuperId = str;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getSiv() {
        return this.mSiv;
    }

    public void setSiv(String str) {
        this.mSiv = str;
    }

    public int getOfflineResultMaxCount() {
        return this.mOfflineResultMaxCount;
    }

    public void setOfflineResultMaxCount(int i) {
        this.mOfflineResultMaxCount = i;
    }
}
