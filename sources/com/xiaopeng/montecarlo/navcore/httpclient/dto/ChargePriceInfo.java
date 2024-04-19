package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class ChargePriceInfo {
    @SerializedName("chargePrice")
    @Deprecated
    public String mChargePrice;
    @SerializedName("endValue")
    @Deprecated
    public String mEndValue;
    @SerializedName("serviceAmt")
    public double mServiceAmt;
    @SerializedName("startValue")
    @Deprecated
    public String mStartValue;
    @SerializedName("timeFlag")
    @Deprecated
    public String mTimeFlag;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargePriceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargePriceInfo) {
            ChargePriceInfo chargePriceInfo = (ChargePriceInfo) obj;
            if (chargePriceInfo.canEqual(this) && Double.compare(getServiceAmt(), chargePriceInfo.getServiceAmt()) == 0) {
                String timeFlag = getTimeFlag();
                String timeFlag2 = chargePriceInfo.getTimeFlag();
                if (timeFlag != null ? timeFlag.equals(timeFlag2) : timeFlag2 == null) {
                    String startValue = getStartValue();
                    String startValue2 = chargePriceInfo.getStartValue();
                    if (startValue != null ? startValue.equals(startValue2) : startValue2 == null) {
                        String endValue = getEndValue();
                        String endValue2 = chargePriceInfo.getEndValue();
                        if (endValue != null ? endValue.equals(endValue2) : endValue2 == null) {
                            String chargePrice = getChargePrice();
                            String chargePrice2 = chargePriceInfo.getChargePrice();
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
        long doubleToLongBits = Double.doubleToLongBits(getServiceAmt());
        String timeFlag = getTimeFlag();
        int hashCode = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + (timeFlag == null ? 43 : timeFlag.hashCode());
        String startValue = getStartValue();
        int hashCode2 = (hashCode * 59) + (startValue == null ? 43 : startValue.hashCode());
        String endValue = getEndValue();
        int hashCode3 = (hashCode2 * 59) + (endValue == null ? 43 : endValue.hashCode());
        String chargePrice = getChargePrice();
        return (hashCode3 * 59) + (chargePrice != null ? chargePrice.hashCode() : 43);
    }

    @Deprecated
    public ChargePriceInfo setChargePrice(String str) {
        this.mChargePrice = str;
        return this;
    }

    @Deprecated
    public ChargePriceInfo setEndValue(String str) {
        this.mEndValue = str;
        return this;
    }

    public ChargePriceInfo setServiceAmt(double d) {
        this.mServiceAmt = d;
        return this;
    }

    @Deprecated
    public ChargePriceInfo setStartValue(String str) {
        this.mStartValue = str;
        return this;
    }

    @Deprecated
    public ChargePriceInfo setTimeFlag(String str) {
        this.mTimeFlag = str;
        return this;
    }

    public String toString() {
        return "ChargePriceInfo(mTimeFlag=" + getTimeFlag() + ", mStartValue=" + getStartValue() + ", mEndValue=" + getEndValue() + ", mChargePrice=" + getChargePrice() + ", mServiceAmt=" + getServiceAmt() + ")";
    }

    @Deprecated
    public String getTimeFlag() {
        return this.mTimeFlag;
    }

    @Deprecated
    public String getStartValue() {
        return this.mStartValue;
    }

    @Deprecated
    public String getEndValue() {
        return this.mEndValue;
    }

    @Deprecated
    public String getChargePrice() {
        return this.mChargePrice;
    }

    public double getServiceAmt() {
        return this.mServiceAmt;
    }
}
