package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class ChargeIncrementInfo {
    public static final String CODE_PARK_SERVICE1 = "1000002001";
    public static final String CODE_PARK_SERVICE2 = "1000002002";
    public static final String CODE_SERVICE = "1000001000";
    public static final String CODE_SLOW_CHARGE_SERVICE = "1000003000";
    @SerializedName("chargePrice")
    public String mChargePrice;
    @SerializedName("endValue")
    public String mEndValue;
    @SerializedName("itemCode")
    @Deprecated
    public String mItemCode;
    @SerializedName("itemDesc")
    @Deprecated
    public String mItemDesc;
    @SerializedName("itemName")
    @Deprecated
    public String mItemName;
    @SerializedName("itemPrice")
    @Deprecated
    public String mItemPrice;
    @SerializedName("itemUnitName")
    @Deprecated
    public String mItemUnitName;
    @SerializedName("serviceAmt")
    public String mServiceAmt;
    @SerializedName("startValue")
    public String mStartValue;
    @SerializedName("timeFlag")
    public String mTimeFlag;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeIncrementInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeIncrementInfo) {
            ChargeIncrementInfo chargeIncrementInfo = (ChargeIncrementInfo) obj;
            if (chargeIncrementInfo.canEqual(this)) {
                String itemCode = getItemCode();
                String itemCode2 = chargeIncrementInfo.getItemCode();
                if (itemCode != null ? itemCode.equals(itemCode2) : itemCode2 == null) {
                    String itemName = getItemName();
                    String itemName2 = chargeIncrementInfo.getItemName();
                    if (itemName != null ? itemName.equals(itemName2) : itemName2 == null) {
                        String startValue = getStartValue();
                        String startValue2 = chargeIncrementInfo.getStartValue();
                        if (startValue != null ? startValue.equals(startValue2) : startValue2 == null) {
                            String endValue = getEndValue();
                            String endValue2 = chargeIncrementInfo.getEndValue();
                            if (endValue != null ? endValue.equals(endValue2) : endValue2 == null) {
                                String itemPrice = getItemPrice();
                                String itemPrice2 = chargeIncrementInfo.getItemPrice();
                                if (itemPrice != null ? itemPrice.equals(itemPrice2) : itemPrice2 == null) {
                                    String itemUnitName = getItemUnitName();
                                    String itemUnitName2 = chargeIncrementInfo.getItemUnitName();
                                    if (itemUnitName != null ? itemUnitName.equals(itemUnitName2) : itemUnitName2 == null) {
                                        String itemDesc = getItemDesc();
                                        String itemDesc2 = chargeIncrementInfo.getItemDesc();
                                        if (itemDesc != null ? itemDesc.equals(itemDesc2) : itemDesc2 == null) {
                                            String timeFlag = getTimeFlag();
                                            String timeFlag2 = chargeIncrementInfo.getTimeFlag();
                                            if (timeFlag != null ? timeFlag.equals(timeFlag2) : timeFlag2 == null) {
                                                String chargePrice = getChargePrice();
                                                String chargePrice2 = chargeIncrementInfo.getChargePrice();
                                                if (chargePrice != null ? chargePrice.equals(chargePrice2) : chargePrice2 == null) {
                                                    String serviceAmt = getServiceAmt();
                                                    String serviceAmt2 = chargeIncrementInfo.getServiceAmt();
                                                    return serviceAmt != null ? serviceAmt.equals(serviceAmt2) : serviceAmt2 == null;
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
        String itemCode = getItemCode();
        int hashCode = itemCode == null ? 43 : itemCode.hashCode();
        String itemName = getItemName();
        int hashCode2 = ((hashCode + 59) * 59) + (itemName == null ? 43 : itemName.hashCode());
        String startValue = getStartValue();
        int hashCode3 = (hashCode2 * 59) + (startValue == null ? 43 : startValue.hashCode());
        String endValue = getEndValue();
        int hashCode4 = (hashCode3 * 59) + (endValue == null ? 43 : endValue.hashCode());
        String itemPrice = getItemPrice();
        int hashCode5 = (hashCode4 * 59) + (itemPrice == null ? 43 : itemPrice.hashCode());
        String itemUnitName = getItemUnitName();
        int hashCode6 = (hashCode5 * 59) + (itemUnitName == null ? 43 : itemUnitName.hashCode());
        String itemDesc = getItemDesc();
        int hashCode7 = (hashCode6 * 59) + (itemDesc == null ? 43 : itemDesc.hashCode());
        String timeFlag = getTimeFlag();
        int hashCode8 = (hashCode7 * 59) + (timeFlag == null ? 43 : timeFlag.hashCode());
        String chargePrice = getChargePrice();
        int hashCode9 = (hashCode8 * 59) + (chargePrice == null ? 43 : chargePrice.hashCode());
        String serviceAmt = getServiceAmt();
        return (hashCode9 * 59) + (serviceAmt != null ? serviceAmt.hashCode() : 43);
    }

    public ChargeIncrementInfo setChargePrice(String str) {
        this.mChargePrice = str;
        return this;
    }

    public ChargeIncrementInfo setEndValue(String str) {
        this.mEndValue = str;
        return this;
    }

    @Deprecated
    public ChargeIncrementInfo setItemCode(String str) {
        this.mItemCode = str;
        return this;
    }

    @Deprecated
    public ChargeIncrementInfo setItemDesc(String str) {
        this.mItemDesc = str;
        return this;
    }

    @Deprecated
    public ChargeIncrementInfo setItemName(String str) {
        this.mItemName = str;
        return this;
    }

    @Deprecated
    public ChargeIncrementInfo setItemPrice(String str) {
        this.mItemPrice = str;
        return this;
    }

    @Deprecated
    public ChargeIncrementInfo setItemUnitName(String str) {
        this.mItemUnitName = str;
        return this;
    }

    public ChargeIncrementInfo setServiceAmt(String str) {
        this.mServiceAmt = str;
        return this;
    }

    public ChargeIncrementInfo setStartValue(String str) {
        this.mStartValue = str;
        return this;
    }

    public ChargeIncrementInfo setTimeFlag(String str) {
        this.mTimeFlag = str;
        return this;
    }

    public String toString() {
        return "ChargeIncrementInfo(mItemCode=" + getItemCode() + ", mItemName=" + getItemName() + ", mStartValue=" + getStartValue() + ", mEndValue=" + getEndValue() + ", mItemPrice=" + getItemPrice() + ", mItemUnitName=" + getItemUnitName() + ", mItemDesc=" + getItemDesc() + ", mTimeFlag=" + getTimeFlag() + ", mChargePrice=" + getChargePrice() + ", mServiceAmt=" + getServiceAmt() + ")";
    }

    @Deprecated
    public String getItemCode() {
        return this.mItemCode;
    }

    @Deprecated
    public String getItemName() {
        return this.mItemName;
    }

    public String getStartValue() {
        return this.mStartValue;
    }

    public String getEndValue() {
        return this.mEndValue;
    }

    @Deprecated
    public String getItemPrice() {
        return this.mItemPrice;
    }

    @Deprecated
    public String getItemUnitName() {
        return this.mItemUnitName;
    }

    @Deprecated
    public String getItemDesc() {
        return this.mItemDesc;
    }

    public String getTimeFlag() {
        return this.mTimeFlag;
    }

    public String getChargePrice() {
        return this.mChargePrice;
    }

    public String getServiceAmt() {
        return this.mServiceAmt;
    }
}
