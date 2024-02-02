package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepCharging;
import com.autonavi.gbl.search.model.DeepinfoPoi;
import com.autonavi.gbl.search.model.DeepinfoPoiGasinfo;
import com.autonavi.gbl.search.model.SearchDeepInfoBusinessType;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class XPDeepInfoPoi implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepInfoPoi> CREATOR = new Parcelable.Creator<XPDeepInfoPoi>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepInfoPoi createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepInfoPoi(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepInfoPoi[] newArray(int i) {
            return new XPDeepInfoPoi[i];
        }
    };
    @SerializedName("mAdCode")
    private int mAdCode;
    @SerializedName("mAddress")
    private String mAddress;
    @SerializedName("mAirportInfo")
    private XPDeepAirport mAirportInfo;
    @SerializedName("mBrand")
    private String mBrand;
    @SerializedName("mBusiness")
    private String mBusiness;
    @SerializedName("mChargeData")
    private XPDeepCharging[] mChargeData;
    @SerializedName("mCityAdCode")
    private int mCityAdCode;
    @SerializedName("mEBusinessType")
    @SearchDeepInfoBusinessType.SearchDeepInfoBusinessType1
    private int mEBusinessType;
    @SerializedName("mGasInfoList")
    private XPDeepInfoPoiGasInfo[] mGasInfoList;
    @SerializedName("mName")
    private String mName;
    @SerializedName("mOpenTime")
    private String mOpenTime;
    @SerializedName("mParkInfo")
    private XPDeepInfoPoiParkInfo mParkInfo;
    @SerializedName("mPoiId")
    private String mPoiId;
    @SerializedName("mPoiLoc")
    private XPCoordinate2DDouble mPoiLoc;
    @SerializedName("mPoiNavi")
    private XPCoordinate2DDouble mPoiNavi;
    @SerializedName("mTag")
    private String mTag;
    @SerializedName("mTel")
    private String mTel;
    @SerializedName("mTrainStation")
    private XPDeepTrainStation mTrainStation;
    @SerializedName("mTypeCode")
    private String mTypeCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setPoiLoc(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLoc = xPCoordinate2DDouble;
    }

    public XPCoordinate2DDouble getPoiLoc() {
        return this.mPoiLoc;
    }

    public void setPoiNavi(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiNavi = xPCoordinate2DDouble;
    }

    public XPCoordinate2DDouble getPoiNavi() {
        return this.mPoiNavi;
    }

    public void setCityAdCode(int i) {
        this.mCityAdCode = i;
    }

    public int getCityAdCode() {
        return this.mCityAdCode;
    }

    public void setAdCode(int i) {
        this.mAdCode = i;
    }

    public int getAdCode() {
        return this.mAdCode;
    }

    public void setPoiId(String str) {
        this.mPoiId = str;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setTypeCode(String str) {
        this.mTypeCode = str;
    }

    public String getTypeCode() {
        return this.mTypeCode;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setTel(String str) {
        this.mTel = str;
    }

    public String getTel() {
        return this.mTel;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setBusiness(String str) {
        this.mBusiness = str;
    }

    public String getBusiness() {
        return this.mBusiness;
    }

    public void setBrand(String str) {
        this.mBrand = str;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public void setOpenTime(String str) {
        this.mOpenTime = str;
    }

    public String getOpenTime() {
        return this.mOpenTime;
    }

    public void setEBusinessType(int i) {
        this.mEBusinessType = i;
    }

    public int getEBusinessType() {
        return this.mEBusinessType;
    }

    public void setParkInfo(XPDeepInfoPoiParkInfo xPDeepInfoPoiParkInfo) {
        this.mParkInfo = xPDeepInfoPoiParkInfo;
    }

    public XPDeepInfoPoiParkInfo getParkInfo() {
        return this.mParkInfo;
    }

    public void setChargeData(XPDeepCharging[] xPDeepChargingArr) {
        this.mChargeData = xPDeepChargingArr;
    }

    public XPDeepCharging[] getChargeData() {
        return this.mChargeData;
    }

    public void setGasInfoList(XPDeepInfoPoiGasInfo[] xPDeepInfoPoiGasInfoArr) {
        this.mGasInfoList = xPDeepInfoPoiGasInfoArr;
    }

    public XPDeepInfoPoiGasInfo[] getGasInfoList() {
        return this.mGasInfoList;
    }

    public void setAirportInfo(XPDeepAirport xPDeepAirport) {
        this.mAirportInfo = xPDeepAirport;
    }

    public XPDeepAirport getAirportInfo() {
        return this.mAirportInfo;
    }

    public void setTrainStation(XPDeepTrainStation xPDeepTrainStation) {
        this.mTrainStation = xPDeepTrainStation;
    }

    public XPDeepTrainStation getTrainStation() {
        return this.mTrainStation;
    }

    public XPDeepInfoPoi() {
    }

    public XPDeepInfoPoi(DeepinfoPoi deepinfoPoi) {
        this.mPoiLoc = new XPCoordinate2DDouble(deepinfoPoi.poi_loc);
        this.mPoiNavi = new XPCoordinate2DDouble(deepinfoPoi.poi_navi);
        this.mCityAdCode = deepinfoPoi.city_adcode;
        this.mAdCode = deepinfoPoi.adcode;
        this.mPoiId = deepinfoPoi.poiid;
        this.mName = deepinfoPoi.name;
        this.mTypeCode = deepinfoPoi.typecode;
        this.mAddress = deepinfoPoi.address;
        this.mTel = deepinfoPoi.tel;
        this.mTag = deepinfoPoi.tag;
        this.mBusiness = deepinfoPoi.business;
        this.mBrand = deepinfoPoi.brand;
        this.mOpenTime = deepinfoPoi.opentime;
        this.mEBusinessType = deepinfoPoi.eBusinessType;
        this.mParkInfo = new XPDeepInfoPoiParkInfo(deepinfoPoi.parkinfo);
        ArrayList<DeepCharging> arrayList = deepinfoPoi.chargeData;
        if (CollectionUtils.isEmpty(arrayList)) {
            this.mChargeData = new XPDeepCharging[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.mChargeData[i] = new XPDeepCharging(arrayList.get(i));
            }
        }
        ArrayList<DeepinfoPoiGasinfo> arrayList2 = deepinfoPoi.gasinfoList;
        if (CollectionUtils.isEmpty(arrayList2)) {
            this.mGasInfoList = new XPDeepInfoPoiGasInfo[arrayList2.size()];
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                this.mGasInfoList[i2] = new XPDeepInfoPoiGasInfo(arrayList2.get(i2));
            }
        }
        this.mAirportInfo = new XPDeepAirport(deepinfoPoi.airportInfo);
        this.mTrainStation = new XPDeepTrainStation(deepinfoPoi.trainStation);
    }

    protected XPDeepInfoPoi(Parcel parcel) {
        this.mPoiLoc = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mPoiNavi = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mCityAdCode = parcel.readInt();
        this.mAdCode = parcel.readInt();
        this.mPoiId = parcel.readString();
        this.mName = parcel.readString();
        this.mTypeCode = parcel.readString();
        this.mAddress = parcel.readString();
        this.mTel = parcel.readString();
        this.mTag = parcel.readString();
        this.mBusiness = parcel.readString();
        this.mBrand = parcel.readString();
        this.mOpenTime = parcel.readString();
        this.mEBusinessType = parcel.readInt();
        this.mParkInfo = (XPDeepInfoPoiParkInfo) parcel.readParcelable(XPDeepInfoPoiParkInfo.class.getClassLoader());
        settingChargeData(parcel);
        settingGasInfoList(parcel);
        this.mAirportInfo = (XPDeepAirport) parcel.readParcelable(XPDeepAirport.class.getClassLoader());
        this.mTrainStation = (XPDeepTrainStation) parcel.readParcelable(XPDeepTrainStation.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.mPoiLoc, i);
        parcel.writeParcelable(this.mPoiNavi, i);
        parcel.writeInt(this.mCityAdCode);
        parcel.writeInt(this.mAdCode);
        parcel.writeString(this.mPoiId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mTypeCode);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mTel);
        parcel.writeString(this.mTag);
        parcel.writeString(this.mBusiness);
        parcel.writeString(this.mBrand);
        parcel.writeString(this.mOpenTime);
        parcel.writeInt(this.mEBusinessType);
        parcel.writeParcelable(this.mParkInfo, i);
        parcel.writeParcelableArray(this.mChargeData, i);
        parcel.writeParcelableArray(this.mGasInfoList, i);
        parcel.writeParcelable(this.mAirportInfo, i);
        parcel.writeParcelable(this.mTrainStation, i);
    }

    private void settingGasInfoList(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepInfoPoiGasInfo.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mGasInfoList = (XPDeepInfoPoiGasInfo[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepInfoPoiGasInfo[].class);
        }
    }

    private void settingChargeData(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepCharging.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mChargeData = (XPDeepCharging[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepCharging[].class);
        }
    }
}
