package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviPoiChargeStationInfo {
    @SerializedName("all_xp_pile")
    private boolean mAllXpPile;
    @SerializedName("charge_count")
    private Integer mChargeCount;
    @SerializedName("charge_item_list")
    private List<ChargeFeeInfo> mChargeFeeInfoList;
    @SerializedName("electricity_fee")
    private String mElectricityFee;
    @SerializedName("dc_free_num")
    private int mFastFreeNum;
    @SerializedName("dc_num")
    private int mFastNum;
    @SerializedName("free_charging")
    private boolean mFreeCharging;
    @SerializedName("free_num")
    private int mFreeNum;
    @SerializedName("free_parking")
    private boolean mFreeParking;
    @SerializedName("free_parking_type")
    private Integer mFreeParkingType;
    @SerializedName("gun_list")
    private List<GunInfo> mGunInfoList;
    @SerializedName("increment_item_list")
    private List<IncrementFeeInfo> mIncrementFeeInfoList;
    @SerializedName("operation_mode")
    private int mOperationMode;
    @SerializedName("park_fee")
    private String mParkFee;
    @SerializedName("xp_pile_num")
    private Integer mPileNum;
    @SerializedName("remark")
    private String mRemark;
    @SerializedName("service_fee")
    private String mServiceFee;
    @SerializedName("ac_free_num")
    private int mSlowFreeNum;
    @SerializedName("ac_num")
    private int mSlowNum;
    @SerializedName("source")
    private String mSource;
    @SerializedName("station_location_guide")
    private String mStationLocationGuide;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviPoiChargeStationInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviPoiChargeStationInfo) {
            NaviPoiChargeStationInfo naviPoiChargeStationInfo = (NaviPoiChargeStationInfo) obj;
            if (naviPoiChargeStationInfo.canEqual(this) && getFastNum() == naviPoiChargeStationInfo.getFastNum() && getFastFreeNum() == naviPoiChargeStationInfo.getFastFreeNum() && getSlowNum() == naviPoiChargeStationInfo.getSlowNum() && getSlowFreeNum() == naviPoiChargeStationInfo.getSlowFreeNum() && getFreeNum() == naviPoiChargeStationInfo.getFreeNum() && isFreeCharging() == naviPoiChargeStationInfo.isFreeCharging() && getOperationMode() == naviPoiChargeStationInfo.getOperationMode() && isFreeParking() == naviPoiChargeStationInfo.isFreeParking() && isAllXpPile() == naviPoiChargeStationInfo.isAllXpPile()) {
                Integer freeParkingType = getFreeParkingType();
                Integer freeParkingType2 = naviPoiChargeStationInfo.getFreeParkingType();
                if (freeParkingType != null ? freeParkingType.equals(freeParkingType2) : freeParkingType2 == null) {
                    Integer pileNum = getPileNum();
                    Integer pileNum2 = naviPoiChargeStationInfo.getPileNum();
                    if (pileNum != null ? pileNum.equals(pileNum2) : pileNum2 == null) {
                        Integer chargeCount = getChargeCount();
                        Integer chargeCount2 = naviPoiChargeStationInfo.getChargeCount();
                        if (chargeCount != null ? chargeCount.equals(chargeCount2) : chargeCount2 == null) {
                            String electricityFee = getElectricityFee();
                            String electricityFee2 = naviPoiChargeStationInfo.getElectricityFee();
                            if (electricityFee != null ? electricityFee.equals(electricityFee2) : electricityFee2 == null) {
                                String serviceFee = getServiceFee();
                                String serviceFee2 = naviPoiChargeStationInfo.getServiceFee();
                                if (serviceFee != null ? serviceFee.equals(serviceFee2) : serviceFee2 == null) {
                                    String parkFee = getParkFee();
                                    String parkFee2 = naviPoiChargeStationInfo.getParkFee();
                                    if (parkFee != null ? parkFee.equals(parkFee2) : parkFee2 == null) {
                                        String stationLocationGuide = getStationLocationGuide();
                                        String stationLocationGuide2 = naviPoiChargeStationInfo.getStationLocationGuide();
                                        if (stationLocationGuide != null ? stationLocationGuide.equals(stationLocationGuide2) : stationLocationGuide2 == null) {
                                            List<ChargeFeeInfo> chargeFeeInfoList = getChargeFeeInfoList();
                                            List<ChargeFeeInfo> chargeFeeInfoList2 = naviPoiChargeStationInfo.getChargeFeeInfoList();
                                            if (chargeFeeInfoList != null ? chargeFeeInfoList.equals(chargeFeeInfoList2) : chargeFeeInfoList2 == null) {
                                                List<IncrementFeeInfo> incrementFeeInfoList = getIncrementFeeInfoList();
                                                List<IncrementFeeInfo> incrementFeeInfoList2 = naviPoiChargeStationInfo.getIncrementFeeInfoList();
                                                if (incrementFeeInfoList != null ? incrementFeeInfoList.equals(incrementFeeInfoList2) : incrementFeeInfoList2 == null) {
                                                    String source = getSource();
                                                    String source2 = naviPoiChargeStationInfo.getSource();
                                                    if (source != null ? source.equals(source2) : source2 == null) {
                                                        String remark = getRemark();
                                                        String remark2 = naviPoiChargeStationInfo.getRemark();
                                                        if (remark != null ? remark.equals(remark2) : remark2 == null) {
                                                            List<GunInfo> gunInfoList = getGunInfoList();
                                                            List<GunInfo> gunInfoList2 = naviPoiChargeStationInfo.getGunInfoList();
                                                            return gunInfoList != null ? gunInfoList.equals(gunInfoList2) : gunInfoList2 == null;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int fastNum = (((((((((((((((getFastNum() + 59) * 59) + getFastFreeNum()) * 59) + getSlowNum()) * 59) + getSlowFreeNum()) * 59) + getFreeNum()) * 59) + (isFreeCharging() ? 79 : 97)) * 59) + getOperationMode()) * 59) + (isFreeParking() ? 79 : 97)) * 59;
        int i = isAllXpPile() ? 79 : 97;
        Integer freeParkingType = getFreeParkingType();
        int hashCode = ((fastNum + i) * 59) + (freeParkingType == null ? 43 : freeParkingType.hashCode());
        Integer pileNum = getPileNum();
        int hashCode2 = (hashCode * 59) + (pileNum == null ? 43 : pileNum.hashCode());
        Integer chargeCount = getChargeCount();
        int hashCode3 = (hashCode2 * 59) + (chargeCount == null ? 43 : chargeCount.hashCode());
        String electricityFee = getElectricityFee();
        int hashCode4 = (hashCode3 * 59) + (electricityFee == null ? 43 : electricityFee.hashCode());
        String serviceFee = getServiceFee();
        int hashCode5 = (hashCode4 * 59) + (serviceFee == null ? 43 : serviceFee.hashCode());
        String parkFee = getParkFee();
        int hashCode6 = (hashCode5 * 59) + (parkFee == null ? 43 : parkFee.hashCode());
        String stationLocationGuide = getStationLocationGuide();
        int hashCode7 = (hashCode6 * 59) + (stationLocationGuide == null ? 43 : stationLocationGuide.hashCode());
        List<ChargeFeeInfo> chargeFeeInfoList = getChargeFeeInfoList();
        int hashCode8 = (hashCode7 * 59) + (chargeFeeInfoList == null ? 43 : chargeFeeInfoList.hashCode());
        List<IncrementFeeInfo> incrementFeeInfoList = getIncrementFeeInfoList();
        int hashCode9 = (hashCode8 * 59) + (incrementFeeInfoList == null ? 43 : incrementFeeInfoList.hashCode());
        String source = getSource();
        int hashCode10 = (hashCode9 * 59) + (source == null ? 43 : source.hashCode());
        String remark = getRemark();
        int hashCode11 = (hashCode10 * 59) + (remark == null ? 43 : remark.hashCode());
        List<GunInfo> gunInfoList = getGunInfoList();
        return (hashCode11 * 59) + (gunInfoList != null ? gunInfoList.hashCode() : 43);
    }

    public NaviPoiChargeStationInfo setAllXpPile(boolean z) {
        this.mAllXpPile = z;
        return this;
    }

    public NaviPoiChargeStationInfo setChargeCount(Integer num) {
        this.mChargeCount = num;
        return this;
    }

    public NaviPoiChargeStationInfo setChargeFeeInfoList(List<ChargeFeeInfo> list) {
        this.mChargeFeeInfoList = list;
        return this;
    }

    public NaviPoiChargeStationInfo setElectricityFee(String str) {
        this.mElectricityFee = str;
        return this;
    }

    public NaviPoiChargeStationInfo setFastFreeNum(int i) {
        this.mFastFreeNum = i;
        return this;
    }

    public NaviPoiChargeStationInfo setFastNum(int i) {
        this.mFastNum = i;
        return this;
    }

    public NaviPoiChargeStationInfo setFreeCharging(boolean z) {
        this.mFreeCharging = z;
        return this;
    }

    public NaviPoiChargeStationInfo setFreeNum(int i) {
        this.mFreeNum = i;
        return this;
    }

    public NaviPoiChargeStationInfo setFreeParking(boolean z) {
        this.mFreeParking = z;
        return this;
    }

    public NaviPoiChargeStationInfo setFreeParkingType(Integer num) {
        this.mFreeParkingType = num;
        return this;
    }

    public NaviPoiChargeStationInfo setGunInfoList(List<GunInfo> list) {
        this.mGunInfoList = list;
        return this;
    }

    public NaviPoiChargeStationInfo setIncrementFeeInfoList(List<IncrementFeeInfo> list) {
        this.mIncrementFeeInfoList = list;
        return this;
    }

    public NaviPoiChargeStationInfo setOperationMode(int i) {
        this.mOperationMode = i;
        return this;
    }

    public NaviPoiChargeStationInfo setParkFee(String str) {
        this.mParkFee = str;
        return this;
    }

    public NaviPoiChargeStationInfo setPileNum(Integer num) {
        this.mPileNum = num;
        return this;
    }

    public NaviPoiChargeStationInfo setRemark(String str) {
        this.mRemark = str;
        return this;
    }

    public NaviPoiChargeStationInfo setServiceFee(String str) {
        this.mServiceFee = str;
        return this;
    }

    public NaviPoiChargeStationInfo setSlowFreeNum(int i) {
        this.mSlowFreeNum = i;
        return this;
    }

    public NaviPoiChargeStationInfo setSlowNum(int i) {
        this.mSlowNum = i;
        return this;
    }

    public NaviPoiChargeStationInfo setSource(String str) {
        this.mSource = str;
        return this;
    }

    public NaviPoiChargeStationInfo setStationLocationGuide(String str) {
        this.mStationLocationGuide = str;
        return this;
    }

    public String toString() {
        return "NaviPoiChargeStationInfo(mElectricityFee=" + getElectricityFee() + ", mServiceFee=" + getServiceFee() + ", mParkFee=" + getParkFee() + ", mFastNum=" + getFastNum() + ", mFastFreeNum=" + getFastFreeNum() + ", mSlowNum=" + getSlowNum() + ", mSlowFreeNum=" + getSlowFreeNum() + ", mFreeNum=" + getFreeNum() + ", mStationLocationGuide=" + getStationLocationGuide() + ", mFreeCharging=" + isFreeCharging() + ", mOperationMode=" + getOperationMode() + ", mFreeParking=" + isFreeParking() + ", mFreeParkingType=" + getFreeParkingType() + ", mPileNum=" + getPileNum() + ", mAllXpPile=" + isAllXpPile() + ", mChargeFeeInfoList=" + getChargeFeeInfoList() + ", mIncrementFeeInfoList=" + getIncrementFeeInfoList() + ", mChargeCount=" + getChargeCount() + ", mSource=" + getSource() + ", mRemark=" + getRemark() + ", mGunInfoList=" + getGunInfoList() + ")";
    }

    public String getElectricityFee() {
        return this.mElectricityFee;
    }

    public String getServiceFee() {
        return this.mServiceFee;
    }

    public String getParkFee() {
        return this.mParkFee;
    }

    public int getFastNum() {
        return this.mFastNum;
    }

    public int getFastFreeNum() {
        return this.mFastFreeNum;
    }

    public int getSlowNum() {
        return this.mSlowNum;
    }

    public int getSlowFreeNum() {
        return this.mSlowFreeNum;
    }

    public int getFreeNum() {
        return this.mFreeNum;
    }

    public String getStationLocationGuide() {
        return this.mStationLocationGuide;
    }

    public boolean isFreeCharging() {
        return this.mFreeCharging;
    }

    public int getOperationMode() {
        return this.mOperationMode;
    }

    public boolean isFreeParking() {
        return this.mFreeParking;
    }

    public Integer getFreeParkingType() {
        return this.mFreeParkingType;
    }

    public Integer getPileNum() {
        return this.mPileNum;
    }

    public boolean isAllXpPile() {
        return this.mAllXpPile;
    }

    public List<ChargeFeeInfo> getChargeFeeInfoList() {
        return this.mChargeFeeInfoList;
    }

    public List<IncrementFeeInfo> getIncrementFeeInfoList() {
        return this.mIncrementFeeInfoList;
    }

    public Integer getChargeCount() {
        return this.mChargeCount;
    }

    public String getSource() {
        return this.mSource;
    }

    public String getRemark() {
        return this.mRemark;
    }

    public List<GunInfo> getGunInfoList() {
        return this.mGunInfoList;
    }

    /* loaded from: classes2.dex */
    public static class ChargeFeeInfo {
        @SerializedName("charge_price")
        private String mChargePrice;
        @SerializedName("end_value")
        private String mEndTime;
        @SerializedName("service_amt")
        private float mServicePrice;
        @SerializedName("start_value")
        private String mStartTime;
        @SerializedName("time_flag")
        private String mTimeFlag;

        protected boolean canEqual(Object obj) {
            return obj instanceof ChargeFeeInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChargeFeeInfo) {
                ChargeFeeInfo chargeFeeInfo = (ChargeFeeInfo) obj;
                if (chargeFeeInfo.canEqual(this) && Float.compare(getServicePrice(), chargeFeeInfo.getServicePrice()) == 0) {
                    String timeFlag = getTimeFlag();
                    String timeFlag2 = chargeFeeInfo.getTimeFlag();
                    if (timeFlag != null ? timeFlag.equals(timeFlag2) : timeFlag2 == null) {
                        String startTime = getStartTime();
                        String startTime2 = chargeFeeInfo.getStartTime();
                        if (startTime != null ? startTime.equals(startTime2) : startTime2 == null) {
                            String endTime = getEndTime();
                            String endTime2 = chargeFeeInfo.getEndTime();
                            if (endTime != null ? endTime.equals(endTime2) : endTime2 == null) {
                                String chargePrice = getChargePrice();
                                String chargePrice2 = chargeFeeInfo.getChargePrice();
                                return chargePrice != null ? chargePrice.equals(chargePrice2) : chargePrice2 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String timeFlag = getTimeFlag();
            int floatToIntBits = ((Float.floatToIntBits(getServicePrice()) + 59) * 59) + (timeFlag == null ? 43 : timeFlag.hashCode());
            String startTime = getStartTime();
            int hashCode = (floatToIntBits * 59) + (startTime == null ? 43 : startTime.hashCode());
            String endTime = getEndTime();
            int hashCode2 = (hashCode * 59) + (endTime == null ? 43 : endTime.hashCode());
            String chargePrice = getChargePrice();
            return (hashCode2 * 59) + (chargePrice != null ? chargePrice.hashCode() : 43);
        }

        public ChargeFeeInfo setChargePrice(String str) {
            this.mChargePrice = str;
            return this;
        }

        public ChargeFeeInfo setEndTime(String str) {
            this.mEndTime = str;
            return this;
        }

        public ChargeFeeInfo setServicePrice(float f) {
            this.mServicePrice = f;
            return this;
        }

        public ChargeFeeInfo setStartTime(String str) {
            this.mStartTime = str;
            return this;
        }

        public ChargeFeeInfo setTimeFlag(String str) {
            this.mTimeFlag = str;
            return this;
        }

        public String toString() {
            return "NaviPoiChargeStationInfo.ChargeFeeInfo(mTimeFlag=" + getTimeFlag() + ", mStartTime=" + getStartTime() + ", mEndTime=" + getEndTime() + ", mChargePrice=" + getChargePrice() + ", mServicePrice=" + getServicePrice() + ")";
        }

        public String getTimeFlag() {
            return this.mTimeFlag;
        }

        public String getStartTime() {
            return this.mStartTime;
        }

        public String getEndTime() {
            return this.mEndTime;
        }

        public String getChargePrice() {
            return this.mChargePrice;
        }

        public float getServicePrice() {
            return this.mServicePrice;
        }
    }

    /* loaded from: classes2.dex */
    public static class IncrementFeeInfo {
        @SerializedName("end_value")
        private String mEndValue;
        @SerializedName("item_code")
        private String mItemCode;
        @SerializedName("item_desc")
        private String mItemDesc;
        @SerializedName("item_name")
        private String mItemName;
        @SerializedName("item_price")
        private String mItemPrice;
        @SerializedName("item_unit")
        private String mItemUnit;
        @SerializedName("start_value")
        private String mStartValue;

        protected boolean canEqual(Object obj) {
            return obj instanceof IncrementFeeInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof IncrementFeeInfo) {
                IncrementFeeInfo incrementFeeInfo = (IncrementFeeInfo) obj;
                if (incrementFeeInfo.canEqual(this)) {
                    String itemCode = getItemCode();
                    String itemCode2 = incrementFeeInfo.getItemCode();
                    if (itemCode != null ? itemCode.equals(itemCode2) : itemCode2 == null) {
                        String itemName = getItemName();
                        String itemName2 = incrementFeeInfo.getItemName();
                        if (itemName != null ? itemName.equals(itemName2) : itemName2 == null) {
                            String itemUnit = getItemUnit();
                            String itemUnit2 = incrementFeeInfo.getItemUnit();
                            if (itemUnit != null ? itemUnit.equals(itemUnit2) : itemUnit2 == null) {
                                String itemPrice = getItemPrice();
                                String itemPrice2 = incrementFeeInfo.getItemPrice();
                                if (itemPrice != null ? itemPrice.equals(itemPrice2) : itemPrice2 == null) {
                                    String itemDesc = getItemDesc();
                                    String itemDesc2 = incrementFeeInfo.getItemDesc();
                                    if (itemDesc != null ? itemDesc.equals(itemDesc2) : itemDesc2 == null) {
                                        String startValue = getStartValue();
                                        String startValue2 = incrementFeeInfo.getStartValue();
                                        if (startValue != null ? startValue.equals(startValue2) : startValue2 == null) {
                                            String endValue = getEndValue();
                                            String endValue2 = incrementFeeInfo.getEndValue();
                                            return endValue != null ? endValue.equals(endValue2) : endValue2 == null;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String itemCode = getItemCode();
            int hashCode = itemCode == null ? 43 : itemCode.hashCode();
            String itemName = getItemName();
            int hashCode2 = ((hashCode + 59) * 59) + (itemName == null ? 43 : itemName.hashCode());
            String itemUnit = getItemUnit();
            int hashCode3 = (hashCode2 * 59) + (itemUnit == null ? 43 : itemUnit.hashCode());
            String itemPrice = getItemPrice();
            int hashCode4 = (hashCode3 * 59) + (itemPrice == null ? 43 : itemPrice.hashCode());
            String itemDesc = getItemDesc();
            int hashCode5 = (hashCode4 * 59) + (itemDesc == null ? 43 : itemDesc.hashCode());
            String startValue = getStartValue();
            int hashCode6 = (hashCode5 * 59) + (startValue == null ? 43 : startValue.hashCode());
            String endValue = getEndValue();
            return (hashCode6 * 59) + (endValue != null ? endValue.hashCode() : 43);
        }

        public IncrementFeeInfo setEndValue(String str) {
            this.mEndValue = str;
            return this;
        }

        public IncrementFeeInfo setItemCode(String str) {
            this.mItemCode = str;
            return this;
        }

        public IncrementFeeInfo setItemDesc(String str) {
            this.mItemDesc = str;
            return this;
        }

        public IncrementFeeInfo setItemName(String str) {
            this.mItemName = str;
            return this;
        }

        public IncrementFeeInfo setItemPrice(String str) {
            this.mItemPrice = str;
            return this;
        }

        public IncrementFeeInfo setItemUnit(String str) {
            this.mItemUnit = str;
            return this;
        }

        public IncrementFeeInfo setStartValue(String str) {
            this.mStartValue = str;
            return this;
        }

        public String toString() {
            return "NaviPoiChargeStationInfo.IncrementFeeInfo(mItemCode=" + getItemCode() + ", mItemName=" + getItemName() + ", mItemUnit=" + getItemUnit() + ", mItemPrice=" + getItemPrice() + ", mItemDesc=" + getItemDesc() + ", mStartValue=" + getStartValue() + ", mEndValue=" + getEndValue() + ")";
        }

        public String getItemCode() {
            return this.mItemCode;
        }

        public String getItemName() {
            return this.mItemName;
        }

        public String getItemUnit() {
            return this.mItemUnit;
        }

        public String getItemPrice() {
            return this.mItemPrice;
        }

        public String getItemDesc() {
            return this.mItemDesc;
        }

        public String getStartValue() {
            return this.mStartValue;
        }

        public String getEndValue() {
            return this.mEndValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class GunInfo implements Parcelable, Serializable {
        public static final Parcelable.Creator<GunInfo> CREATOR = new Parcelable.Creator<GunInfo>() { // from class: com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiChargeStationInfo.GunInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GunInfo createFromParcel(Parcel parcel) {
                return new GunInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GunInfo[] newArray(int i) {
                return new GunInfo[i];
            }
        };
        @SerializedName("booking_order_no")
        private String mBookingOrderNo;
        @SerializedName("booking_type")
        private String mBookingType;
        @SerializedName("display_gun_name")
        private String mDisplayGunName;
        @SerializedName("gun_busi_status")
        private String mGunBusiStatus;
        @SerializedName("gun_id")
        private int mGunId;
        @SerializedName("gun_name")
        private String mGunName;
        @SerializedName("gun_sub_type")
        private String mGunSubtype;
        @SerializedName("keep_booking_time")
        private long mKeepBookingTime;
        @SerializedName("latestChargeTimeMillis")
        private Integer mLatestChargeTimeMillis;
        @SerializedName("lock_list")
        private List<ChargeLock> mLockList;
        @SerializedName("normal_cancel_time")
        private long mNormalCancelTime;
        @SerializedName("pile_name")
        private String mPileName;
        @SerializedName("pile_no")
        private String mPileNo;
        @SerializedName("qr_code")
        private String mQrCode;
        @SerializedName("run_status")
        private String mRunStatus;
        @SerializedName("soc")
        private String mSoc;
        @SerializedName("surplus_booking_time")
        private long mSurplusBookingTime;
        @SerializedName("xp_flag")
        private String mXpFlag;
        @SerializedName("xp_now_flag")
        private String mXpNowFlag;
        @SerializedName("xp_time")
        private String mXpTime;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof GunInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof GunInfo) {
                GunInfo gunInfo = (GunInfo) obj;
                if (gunInfo.canEqual(this) && getGunId() == gunInfo.getGunId() && getKeepBookingTime() == gunInfo.getKeepBookingTime() && getSurplusBookingTime() == gunInfo.getSurplusBookingTime() && getNormalCancelTime() == gunInfo.getNormalCancelTime()) {
                    Integer latestChargeTimeMillis = getLatestChargeTimeMillis();
                    Integer latestChargeTimeMillis2 = gunInfo.getLatestChargeTimeMillis();
                    if (latestChargeTimeMillis != null ? latestChargeTimeMillis.equals(latestChargeTimeMillis2) : latestChargeTimeMillis2 == null) {
                        String pileNo = getPileNo();
                        String pileNo2 = gunInfo.getPileNo();
                        if (pileNo != null ? pileNo.equals(pileNo2) : pileNo2 == null) {
                            String pileName = getPileName();
                            String pileName2 = gunInfo.getPileName();
                            if (pileName != null ? pileName.equals(pileName2) : pileName2 == null) {
                                String gunName = getGunName();
                                String gunName2 = gunInfo.getGunName();
                                if (gunName != null ? gunName.equals(gunName2) : gunName2 == null) {
                                    String displayGunName = getDisplayGunName();
                                    String displayGunName2 = gunInfo.getDisplayGunName();
                                    if (displayGunName != null ? displayGunName.equals(displayGunName2) : displayGunName2 == null) {
                                        String gunSubtype = getGunSubtype();
                                        String gunSubtype2 = gunInfo.getGunSubtype();
                                        if (gunSubtype != null ? gunSubtype.equals(gunSubtype2) : gunSubtype2 == null) {
                                            String runStatus = getRunStatus();
                                            String runStatus2 = gunInfo.getRunStatus();
                                            if (runStatus != null ? runStatus.equals(runStatus2) : runStatus2 == null) {
                                                String gunBusiStatus = getGunBusiStatus();
                                                String gunBusiStatus2 = gunInfo.getGunBusiStatus();
                                                if (gunBusiStatus != null ? gunBusiStatus.equals(gunBusiStatus2) : gunBusiStatus2 == null) {
                                                    String bookingType = getBookingType();
                                                    String bookingType2 = gunInfo.getBookingType();
                                                    if (bookingType != null ? bookingType.equals(bookingType2) : bookingType2 == null) {
                                                        String bookingOrderNo = getBookingOrderNo();
                                                        String bookingOrderNo2 = gunInfo.getBookingOrderNo();
                                                        if (bookingOrderNo != null ? bookingOrderNo.equals(bookingOrderNo2) : bookingOrderNo2 == null) {
                                                            String qrCode = getQrCode();
                                                            String qrCode2 = gunInfo.getQrCode();
                                                            if (qrCode != null ? qrCode.equals(qrCode2) : qrCode2 == null) {
                                                                String soc = getSoc();
                                                                String soc2 = gunInfo.getSoc();
                                                                if (soc != null ? soc.equals(soc2) : soc2 == null) {
                                                                    String xpFlag = getXpFlag();
                                                                    String xpFlag2 = gunInfo.getXpFlag();
                                                                    if (xpFlag != null ? xpFlag.equals(xpFlag2) : xpFlag2 == null) {
                                                                        String xpNowFlag = getXpNowFlag();
                                                                        String xpNowFlag2 = gunInfo.getXpNowFlag();
                                                                        if (xpNowFlag != null ? xpNowFlag.equals(xpNowFlag2) : xpNowFlag2 == null) {
                                                                            String xpTime = getXpTime();
                                                                            String xpTime2 = gunInfo.getXpTime();
                                                                            if (xpTime != null ? xpTime.equals(xpTime2) : xpTime2 == null) {
                                                                                List<ChargeLock> lockList = getLockList();
                                                                                List<ChargeLock> lockList2 = gunInfo.getLockList();
                                                                                return lockList != null ? lockList.equals(lockList2) : lockList2 == null;
                                                                            }
                                                                            return false;
                                                                        }
                                                                        return false;
                                                                    }
                                                                    return false;
                                                                }
                                                                return false;
                                                            }
                                                            return false;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            long keepBookingTime = getKeepBookingTime();
            int gunId = ((getGunId() + 59) * 59) + ((int) (keepBookingTime ^ (keepBookingTime >>> 32)));
            long surplusBookingTime = getSurplusBookingTime();
            int i = (gunId * 59) + ((int) (surplusBookingTime ^ (surplusBookingTime >>> 32)));
            long normalCancelTime = getNormalCancelTime();
            int i2 = (i * 59) + ((int) (normalCancelTime ^ (normalCancelTime >>> 32)));
            Integer latestChargeTimeMillis = getLatestChargeTimeMillis();
            int hashCode = (i2 * 59) + (latestChargeTimeMillis == null ? 43 : latestChargeTimeMillis.hashCode());
            String pileNo = getPileNo();
            int hashCode2 = (hashCode * 59) + (pileNo == null ? 43 : pileNo.hashCode());
            String pileName = getPileName();
            int hashCode3 = (hashCode2 * 59) + (pileName == null ? 43 : pileName.hashCode());
            String gunName = getGunName();
            int hashCode4 = (hashCode3 * 59) + (gunName == null ? 43 : gunName.hashCode());
            String displayGunName = getDisplayGunName();
            int hashCode5 = (hashCode4 * 59) + (displayGunName == null ? 43 : displayGunName.hashCode());
            String gunSubtype = getGunSubtype();
            int hashCode6 = (hashCode5 * 59) + (gunSubtype == null ? 43 : gunSubtype.hashCode());
            String runStatus = getRunStatus();
            int hashCode7 = (hashCode6 * 59) + (runStatus == null ? 43 : runStatus.hashCode());
            String gunBusiStatus = getGunBusiStatus();
            int hashCode8 = (hashCode7 * 59) + (gunBusiStatus == null ? 43 : gunBusiStatus.hashCode());
            String bookingType = getBookingType();
            int hashCode9 = (hashCode8 * 59) + (bookingType == null ? 43 : bookingType.hashCode());
            String bookingOrderNo = getBookingOrderNo();
            int hashCode10 = (hashCode9 * 59) + (bookingOrderNo == null ? 43 : bookingOrderNo.hashCode());
            String qrCode = getQrCode();
            int hashCode11 = (hashCode10 * 59) + (qrCode == null ? 43 : qrCode.hashCode());
            String soc = getSoc();
            int hashCode12 = (hashCode11 * 59) + (soc == null ? 43 : soc.hashCode());
            String xpFlag = getXpFlag();
            int hashCode13 = (hashCode12 * 59) + (xpFlag == null ? 43 : xpFlag.hashCode());
            String xpNowFlag = getXpNowFlag();
            int hashCode14 = (hashCode13 * 59) + (xpNowFlag == null ? 43 : xpNowFlag.hashCode());
            String xpTime = getXpTime();
            int hashCode15 = (hashCode14 * 59) + (xpTime == null ? 43 : xpTime.hashCode());
            List<ChargeLock> lockList = getLockList();
            return (hashCode15 * 59) + (lockList != null ? lockList.hashCode() : 43);
        }

        public GunInfo setBookingOrderNo(String str) {
            this.mBookingOrderNo = str;
            return this;
        }

        public GunInfo setBookingType(String str) {
            this.mBookingType = str;
            return this;
        }

        public GunInfo setDisplayGunName(String str) {
            this.mDisplayGunName = str;
            return this;
        }

        public GunInfo setGunBusiStatus(String str) {
            this.mGunBusiStatus = str;
            return this;
        }

        public GunInfo setGunId(int i) {
            this.mGunId = i;
            return this;
        }

        public GunInfo setGunName(String str) {
            this.mGunName = str;
            return this;
        }

        public GunInfo setGunSubtype(String str) {
            this.mGunSubtype = str;
            return this;
        }

        public GunInfo setKeepBookingTime(long j) {
            this.mKeepBookingTime = j;
            return this;
        }

        public GunInfo setLatestChargeTimeMillis(Integer num) {
            this.mLatestChargeTimeMillis = num;
            return this;
        }

        public GunInfo setLockList(List<ChargeLock> list) {
            this.mLockList = list;
            return this;
        }

        public GunInfo setNormalCancelTime(long j) {
            this.mNormalCancelTime = j;
            return this;
        }

        public GunInfo setPileName(String str) {
            this.mPileName = str;
            return this;
        }

        public GunInfo setPileNo(String str) {
            this.mPileNo = str;
            return this;
        }

        public GunInfo setQrCode(String str) {
            this.mQrCode = str;
            return this;
        }

        public GunInfo setRunStatus(String str) {
            this.mRunStatus = str;
            return this;
        }

        public GunInfo setSoc(String str) {
            this.mSoc = str;
            return this;
        }

        public GunInfo setSurplusBookingTime(long j) {
            this.mSurplusBookingTime = j;
            return this;
        }

        public GunInfo setXpFlag(String str) {
            this.mXpFlag = str;
            return this;
        }

        public GunInfo setXpNowFlag(String str) {
            this.mXpNowFlag = str;
            return this;
        }

        public GunInfo setXpTime(String str) {
            this.mXpTime = str;
            return this;
        }

        public String toString() {
            return "NaviPoiChargeStationInfo.GunInfo(mPileNo=" + getPileNo() + ", mPileName=" + getPileName() + ", mGunId=" + getGunId() + ", mGunName=" + getGunName() + ", mDisplayGunName=" + getDisplayGunName() + ", mGunSubtype=" + getGunSubtype() + ", mRunStatus=" + getRunStatus() + ", mGunBusiStatus=" + getGunBusiStatus() + ", mBookingType=" + getBookingType() + ", mKeepBookingTime=" + getKeepBookingTime() + ", mSurplusBookingTime=" + getSurplusBookingTime() + ", mNormalCancelTime=" + getNormalCancelTime() + ", mBookingOrderNo=" + getBookingOrderNo() + ", mQrCode=" + getQrCode() + ", mSoc=" + getSoc() + ", mXpFlag=" + getXpFlag() + ", mXpNowFlag=" + getXpNowFlag() + ", mXpTime=" + getXpTime() + ", mLockList=" + getLockList() + ", mLatestChargeTimeMillis=" + getLatestChargeTimeMillis() + ")";
        }

        public GunInfo() {
        }

        public String getPileNo() {
            return this.mPileNo;
        }

        public String getPileName() {
            return this.mPileName;
        }

        public int getGunId() {
            return this.mGunId;
        }

        public String getGunName() {
            return this.mGunName;
        }

        public String getDisplayGunName() {
            return this.mDisplayGunName;
        }

        public String getGunSubtype() {
            return this.mGunSubtype;
        }

        public String getRunStatus() {
            return this.mRunStatus;
        }

        public String getGunBusiStatus() {
            return this.mGunBusiStatus;
        }

        public String getBookingType() {
            return this.mBookingType;
        }

        public long getKeepBookingTime() {
            return this.mKeepBookingTime;
        }

        public long getSurplusBookingTime() {
            return this.mSurplusBookingTime;
        }

        public long getNormalCancelTime() {
            return this.mNormalCancelTime;
        }

        public String getBookingOrderNo() {
            return this.mBookingOrderNo;
        }

        public String getQrCode() {
            return this.mQrCode;
        }

        public String getSoc() {
            return this.mSoc;
        }

        public String getXpFlag() {
            return this.mXpFlag;
        }

        public String getXpNowFlag() {
            return this.mXpNowFlag;
        }

        public String getXpTime() {
            return this.mXpTime;
        }

        public List<ChargeLock> getLockList() {
            return this.mLockList;
        }

        public Integer getLatestChargeTimeMillis() {
            return this.mLatestChargeTimeMillis;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mPileNo);
            parcel.writeString(this.mPileName);
            parcel.writeInt(this.mGunId);
            parcel.writeString(this.mGunName);
            parcel.writeString(this.mDisplayGunName);
            parcel.writeString(this.mGunSubtype);
            parcel.writeString(this.mRunStatus);
            parcel.writeString(this.mGunBusiStatus);
            parcel.writeString(this.mBookingType);
            parcel.writeLong(this.mKeepBookingTime);
            parcel.writeLong(this.mSurplusBookingTime);
            parcel.writeLong(this.mNormalCancelTime);
            parcel.writeString(this.mBookingOrderNo);
            parcel.writeString(this.mQrCode);
            parcel.writeString(this.mSoc);
            parcel.writeString(this.mXpFlag);
            parcel.writeString(this.mXpNowFlag);
            parcel.writeString(this.mXpTime);
            parcel.writeList(this.mLockList);
            parcel.writeValue(this.mLatestChargeTimeMillis);
        }

        protected GunInfo(Parcel parcel) {
            this.mPileNo = parcel.readString();
            this.mPileName = parcel.readString();
            this.mGunId = parcel.readInt();
            this.mGunName = parcel.readString();
            this.mDisplayGunName = parcel.readString();
            this.mGunSubtype = parcel.readString();
            this.mRunStatus = parcel.readString();
            this.mGunBusiStatus = parcel.readString();
            this.mBookingType = parcel.readString();
            this.mKeepBookingTime = parcel.readLong();
            this.mSurplusBookingTime = parcel.readLong();
            this.mNormalCancelTime = parcel.readLong();
            this.mBookingOrderNo = parcel.readString();
            this.mQrCode = parcel.readString();
            this.mSoc = parcel.readString();
            this.mXpFlag = parcel.readString();
            this.mXpNowFlag = parcel.readString();
            this.mXpTime = parcel.readString();
            this.mLockList = new ArrayList();
            parcel.readList(this.mLockList, ChargeLock.class.getClassLoader());
            this.mLatestChargeTimeMillis = (Integer) parcel.readValue(Integer.class.getClassLoader());
        }
    }

    /* loaded from: classes2.dex */
    public static class ChargeLock implements Parcelable, Serializable {
        public static final Parcelable.Creator<ChargeLock> CREATOR = new Parcelable.Creator<ChargeLock>() { // from class: com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviPoiChargeStationInfo.ChargeLock.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ChargeLock createFromParcel(Parcel parcel) {
                return new ChargeLock(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ChargeLock[] newArray(int i) {
                return new ChargeLock[i];
            }
        };
        @SerializedName("latest_charge_timemillis")
        private Integer mLatestChargeTimemillis;
        @SerializedName("lock_name")
        private String mLockName;
        @SerializedName("lock_no")
        private String mLockNo;
        @SerializedName("lock_oper_status")
        private String mLockOperStatus;
        @SerializedName("lock_run_status")
        private String mLockRunStatus;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof ChargeLock;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChargeLock) {
                ChargeLock chargeLock = (ChargeLock) obj;
                if (chargeLock.canEqual(this)) {
                    Integer latestChargeTimemillis = getLatestChargeTimemillis();
                    Integer latestChargeTimemillis2 = chargeLock.getLatestChargeTimemillis();
                    if (latestChargeTimemillis != null ? latestChargeTimemillis.equals(latestChargeTimemillis2) : latestChargeTimemillis2 == null) {
                        String lockNo = getLockNo();
                        String lockNo2 = chargeLock.getLockNo();
                        if (lockNo != null ? lockNo.equals(lockNo2) : lockNo2 == null) {
                            String lockName = getLockName();
                            String lockName2 = chargeLock.getLockName();
                            if (lockName != null ? lockName.equals(lockName2) : lockName2 == null) {
                                String lockOperStatus = getLockOperStatus();
                                String lockOperStatus2 = chargeLock.getLockOperStatus();
                                if (lockOperStatus != null ? lockOperStatus.equals(lockOperStatus2) : lockOperStatus2 == null) {
                                    String lockRunStatus = getLockRunStatus();
                                    String lockRunStatus2 = chargeLock.getLockRunStatus();
                                    return lockRunStatus != null ? lockRunStatus.equals(lockRunStatus2) : lockRunStatus2 == null;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            Integer latestChargeTimemillis = getLatestChargeTimemillis();
            int hashCode = latestChargeTimemillis == null ? 43 : latestChargeTimemillis.hashCode();
            String lockNo = getLockNo();
            int hashCode2 = ((hashCode + 59) * 59) + (lockNo == null ? 43 : lockNo.hashCode());
            String lockName = getLockName();
            int hashCode3 = (hashCode2 * 59) + (lockName == null ? 43 : lockName.hashCode());
            String lockOperStatus = getLockOperStatus();
            int hashCode4 = (hashCode3 * 59) + (lockOperStatus == null ? 43 : lockOperStatus.hashCode());
            String lockRunStatus = getLockRunStatus();
            return (hashCode4 * 59) + (lockRunStatus != null ? lockRunStatus.hashCode() : 43);
        }

        public ChargeLock setLatestChargeTimemillis(Integer num) {
            this.mLatestChargeTimemillis = num;
            return this;
        }

        public ChargeLock setLockName(String str) {
            this.mLockName = str;
            return this;
        }

        public ChargeLock setLockNo(String str) {
            this.mLockNo = str;
            return this;
        }

        public ChargeLock setLockOperStatus(String str) {
            this.mLockOperStatus = str;
            return this;
        }

        public ChargeLock setLockRunStatus(String str) {
            this.mLockRunStatus = str;
            return this;
        }

        public String toString() {
            return "NaviPoiChargeStationInfo.ChargeLock(mLockNo=" + getLockNo() + ", mLockName=" + getLockName() + ", mLockOperStatus=" + getLockOperStatus() + ", mLockRunStatus=" + getLockRunStatus() + ", mLatestChargeTimemillis=" + getLatestChargeTimemillis() + ")";
        }

        public String getLockNo() {
            return this.mLockNo;
        }

        public String getLockName() {
            return this.mLockName;
        }

        public String getLockOperStatus() {
            return this.mLockOperStatus;
        }

        public String getLockRunStatus() {
            return this.mLockRunStatus;
        }

        public Integer getLatestChargeTimemillis() {
            return this.mLatestChargeTimemillis;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mLockNo);
            parcel.writeString(this.mLockName);
            parcel.writeString(this.mLockOperStatus);
            parcel.writeString(this.mLockRunStatus);
            parcel.writeValue(this.mLatestChargeTimemillis);
        }

        public ChargeLock() {
        }

        protected ChargeLock(Parcel parcel) {
            this.mLockNo = parcel.readString();
            this.mLockName = parcel.readString();
            this.mLockOperStatus = parcel.readString();
            this.mLockRunStatus = parcel.readString();
            this.mLatestChargeTimemillis = (Integer) parcel.readValue(Integer.class.getClassLoader());
        }
    }
}
