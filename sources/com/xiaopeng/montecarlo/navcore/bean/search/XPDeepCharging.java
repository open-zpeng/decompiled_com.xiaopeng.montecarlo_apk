package com.xiaopeng.montecarlo.navcore.bean.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.autonavi.gbl.search.model.DeepChargeInfo;
import com.autonavi.gbl.search.model.DeepCharging;
import com.autonavi.gbl.search.model.DeepChargingPrice;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiChargeStationInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class XPDeepCharging implements Parcelable, Serializable {
    public static final Parcelable.Creator<XPDeepCharging> CREATOR = new Parcelable.Creator<XPDeepCharging>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepCharging createFromParcel(@NonNull Parcel parcel) {
            return new XPDeepCharging(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPDeepCharging[] newArray(int i) {
            return new XPDeepCharging[i];
        }
    };
    public static final String PAY_TYPE_BANK_CARD = "2";
    public static final String PAY_TYPE_CASH = "1";
    public static final String PAY_TYPE_MOBILE_WALLET = "3";
    public static final String PAY_TYPE_ONLINE = "5";
    public static final String PAY_TYPE_RECHARGE_CARD = "4";
    @SerializedName("mBusiness")
    private String mBusiness;
    @SerializedName("mChargeInfo")
    private XPDeepChargeInfo[] mChargeInfo;
    @SerializedName("mChargeSrcName")
    private String mChargeSrcName;
    @SerializedName("mChargingPrice")
    private XPDeepChargingPrice[] mChargingPrice;
    @SerializedName("mCscf")
    private String mCscf;
    @SerializedName("mGunInfoList")
    private List<NaviPoiChargeStationInfo.GunInfo> mGunInfoList;
    @SerializedName("mIsAllXpPile")
    private boolean mIsAllXpPile;
    @SerializedName("mIsFreeStation")
    private boolean mIsFreeStation;
    @SerializedName("mNumFast")
    private int mNumFast;
    @SerializedName("mNumFastFree")
    private int mNumFastFree;
    @SerializedName("mNumSlow")
    private int mNumSlow;
    @SerializedName("mNumSlowFree")
    private int mNumSlowFree;
    @SerializedName("mNumUltra")
    private int mNumUltra;
    @SerializedName("mNumUltraFree")
    private int mNumUltraFree;
    @SerializedName("mPayType")
    private String mPayType;
    @SerializedName("mPriceParking")
    private String mPriceParking;
    @SerializedName("mSrcId")
    private String mSrcId;
    @SerializedName("mSrcType")
    private String mSrcType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setChargeInfo(XPDeepChargeInfo[] xPDeepChargeInfoArr) {
        this.mChargeInfo = xPDeepChargeInfoArr;
    }

    public XPDeepChargeInfo[] getChargeInfo() {
        return this.mChargeInfo;
    }

    public void setPayType(String str) {
        this.mPayType = str;
    }

    public String getPayType() {
        return this.mPayType;
    }

    public void setNumUltra(int i) {
        this.mNumUltra = i;
    }

    public int getNumUltra() {
        return this.mNumUltra;
    }

    public void setNumUltraFree(int i) {
        this.mNumUltraFree = i;
    }

    public int getNumUltraFree() {
        return this.mNumUltraFree;
    }

    public void setNumFast(int i) {
        this.mNumFast = i;
    }

    public int getNumFast() {
        return this.mNumFast;
    }

    public void setNumFastFree(int i) {
        this.mNumFastFree = i;
    }

    public int getNumFastFree() {
        return this.mNumFastFree;
    }

    public void setBusiness(String str) {
        this.mBusiness = str;
    }

    public String getBusiness() {
        return this.mBusiness;
    }

    public void setNumSlow(int i) {
        this.mNumSlow = i;
    }

    public int getNumSlow() {
        return this.mNumSlow;
    }

    public void setNumSlowFree(int i) {
        this.mNumSlowFree = i;
    }

    public int getNumSlowFree() {
        return this.mNumSlowFree;
    }

    public void setSrcId(String str) {
        this.mSrcId = str;
    }

    public String getSrcId() {
        return this.mSrcId;
    }

    public void setSrcType(String str) {
        this.mSrcType = str;
    }

    public String getSrcType() {
        return this.mSrcType;
    }

    public void setChargeSrcName(String str) {
        this.mChargeSrcName = str;
    }

    public String getChargeSrcName() {
        return this.mChargeSrcName;
    }

    public void setCscf(String str) {
        this.mCscf = str;
    }

    public String getCscf() {
        return this.mCscf;
    }

    public void setPriceParking(String str) {
        this.mPriceParking = str;
    }

    public String getPriceParking() {
        return this.mPriceParking;
    }

    public void setChargingPrice(XPDeepChargingPrice[] xPDeepChargingPriceArr) {
        this.mChargingPrice = xPDeepChargingPriceArr;
    }

    public XPDeepChargingPrice[] getChargingPrice() {
        return this.mChargingPrice;
    }

    public void setAllXpPile(boolean z) {
        this.mIsAllXpPile = z;
    }

    public boolean isAllXpPile() {
        return this.mIsAllXpPile;
    }

    public void setFreeStation(boolean z) {
        this.mIsFreeStation = z;
    }

    public boolean isFreeStation() {
        return this.mIsFreeStation;
    }

    public void setGunInfoList(List<NaviPoiChargeStationInfo.GunInfo> list) {
        this.mGunInfoList = list;
    }

    public List<NaviPoiChargeStationInfo.GunInfo> getGunInfoList() {
        return this.mGunInfoList;
    }

    public XPDeepCharging() {
    }

    public XPDeepCharging(DeepCharging deepCharging) {
        ArrayList<DeepChargeInfo> arrayList = deepCharging.chargeInfo;
        if (CollectionUtils.isEmpty(arrayList)) {
            this.mChargeInfo = new XPDeepChargeInfo[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.mChargeInfo[i] = new XPDeepChargeInfo(arrayList.get(0));
            }
        }
        this.mPayType = deepCharging.pay_type;
        this.mNumFast = deepCharging.num_fast;
        this.mNumFastFree = -1;
        this.mBusiness = deepCharging.business;
        this.mNumSlow = deepCharging.num_slow;
        this.mNumSlowFree = -1;
        this.mSrcId = deepCharging.src_id;
        this.mSrcType = deepCharging.src_type;
        this.mChargeSrcName = deepCharging.charge_src_name;
        this.mCscf = deepCharging.cscf;
        this.mPriceParking = deepCharging.price_parking;
        ArrayList<DeepChargingPrice> arrayList2 = deepCharging.chargingPrice;
        if (CollectionUtils.isEmpty(arrayList2)) {
            this.mChargingPrice = new XPDeepChargingPrice[arrayList2.size()];
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                this.mChargingPrice[i2] = new XPDeepChargingPrice(arrayList2.get(i2));
            }
        }
    }

    protected XPDeepCharging(@NonNull Parcel parcel) {
        settingChargeInfo(parcel);
        this.mPayType = parcel.readString();
        this.mNumFast = parcel.readInt();
        this.mNumFastFree = parcel.readInt();
        this.mBusiness = parcel.readString();
        this.mNumSlow = parcel.readInt();
        this.mNumSlowFree = parcel.readInt();
        this.mSrcId = parcel.readString();
        this.mSrcType = parcel.readString();
        this.mChargeSrcName = parcel.readString();
        this.mCscf = parcel.readString();
        this.mPriceParking = parcel.readString();
        settingChargingPrice(parcel);
    }

    private void settingChargingPrice(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepChargingPrice.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mChargingPrice = (XPDeepChargingPrice[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepChargingPrice[].class);
        }
    }

    private void settingChargeInfo(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(XPDeepChargeInfo.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mChargeInfo = (XPDeepChargeInfo[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, XPDeepChargeInfo[].class);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelableArray(this.mChargeInfo, i);
        parcel.writeString(this.mPayType);
        parcel.writeInt(this.mNumFast);
        parcel.writeInt(this.mNumFastFree);
        parcel.writeString(this.mBusiness);
        parcel.writeInt(this.mNumSlow);
        parcel.writeInt(this.mNumSlowFree);
        parcel.writeString(this.mSrcId);
        parcel.writeString(this.mSrcType);
        parcel.writeString(this.mChargeSrcName);
        parcel.writeString(this.mCscf);
        parcel.writeString(this.mPriceParking);
        parcel.writeParcelableArray(this.mChargingPrice, i);
    }
}
