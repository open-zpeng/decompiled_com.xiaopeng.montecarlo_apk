package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class ChargeGunInfo {
    @SerializedName("displayGunName")
    @Deprecated
    public String mDisplayGunName;
    @SerializedName("gunBusiStatus")
    @Deprecated
    public String mGunBusiStatus;
    @SerializedName("gunBusiStatusName")
    @Deprecated
    public String mGunBusiStatusName;
    @SerializedName("gunId")
    @Deprecated
    public int mGunId;
    @SerializedName("gunName")
    @Deprecated
    public String mGunName;
    @SerializedName("gunSubtype")
    @Deprecated
    public String mGunSubtype;
    @SerializedName("pileName")
    @Deprecated
    public String mPileName;
    @SerializedName("pileNo")
    @Deprecated
    public String mPileNo;
    @SerializedName("qrCode")
    @Deprecated
    public String mQrCode;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeGunInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeGunInfo) {
            ChargeGunInfo chargeGunInfo = (ChargeGunInfo) obj;
            if (chargeGunInfo.canEqual(this) && getGunId() == chargeGunInfo.getGunId()) {
                String pileNo = getPileNo();
                String pileNo2 = chargeGunInfo.getPileNo();
                if (pileNo != null ? pileNo.equals(pileNo2) : pileNo2 == null) {
                    String pileName = getPileName();
                    String pileName2 = chargeGunInfo.getPileName();
                    if (pileName != null ? pileName.equals(pileName2) : pileName2 == null) {
                        String gunName = getGunName();
                        String gunName2 = chargeGunInfo.getGunName();
                        if (gunName != null ? gunName.equals(gunName2) : gunName2 == null) {
                            String displayGunName = getDisplayGunName();
                            String displayGunName2 = chargeGunInfo.getDisplayGunName();
                            if (displayGunName != null ? displayGunName.equals(displayGunName2) : displayGunName2 == null) {
                                String gunSubtype = getGunSubtype();
                                String gunSubtype2 = chargeGunInfo.getGunSubtype();
                                if (gunSubtype != null ? gunSubtype.equals(gunSubtype2) : gunSubtype2 == null) {
                                    String gunBusiStatus = getGunBusiStatus();
                                    String gunBusiStatus2 = chargeGunInfo.getGunBusiStatus();
                                    if (gunBusiStatus != null ? gunBusiStatus.equals(gunBusiStatus2) : gunBusiStatus2 == null) {
                                        String gunBusiStatusName = getGunBusiStatusName();
                                        String gunBusiStatusName2 = chargeGunInfo.getGunBusiStatusName();
                                        if (gunBusiStatusName != null ? gunBusiStatusName.equals(gunBusiStatusName2) : gunBusiStatusName2 == null) {
                                            String qrCode = getQrCode();
                                            String qrCode2 = chargeGunInfo.getQrCode();
                                            return qrCode != null ? qrCode.equals(qrCode2) : qrCode2 == null;
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
        String pileNo = getPileNo();
        int gunId = ((getGunId() + 59) * 59) + (pileNo == null ? 43 : pileNo.hashCode());
        String pileName = getPileName();
        int hashCode = (gunId * 59) + (pileName == null ? 43 : pileName.hashCode());
        String gunName = getGunName();
        int hashCode2 = (hashCode * 59) + (gunName == null ? 43 : gunName.hashCode());
        String displayGunName = getDisplayGunName();
        int hashCode3 = (hashCode2 * 59) + (displayGunName == null ? 43 : displayGunName.hashCode());
        String gunSubtype = getGunSubtype();
        int hashCode4 = (hashCode3 * 59) + (gunSubtype == null ? 43 : gunSubtype.hashCode());
        String gunBusiStatus = getGunBusiStatus();
        int hashCode5 = (hashCode4 * 59) + (gunBusiStatus == null ? 43 : gunBusiStatus.hashCode());
        String gunBusiStatusName = getGunBusiStatusName();
        int hashCode6 = (hashCode5 * 59) + (gunBusiStatusName == null ? 43 : gunBusiStatusName.hashCode());
        String qrCode = getQrCode();
        return (hashCode6 * 59) + (qrCode != null ? qrCode.hashCode() : 43);
    }

    @Deprecated
    public ChargeGunInfo setDisplayGunName(String str) {
        this.mDisplayGunName = str;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setGunBusiStatus(String str) {
        this.mGunBusiStatus = str;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setGunBusiStatusName(String str) {
        this.mGunBusiStatusName = str;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setGunId(int i) {
        this.mGunId = i;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setGunName(String str) {
        this.mGunName = str;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setGunSubtype(String str) {
        this.mGunSubtype = str;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setPileName(String str) {
        this.mPileName = str;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setPileNo(String str) {
        this.mPileNo = str;
        return this;
    }

    @Deprecated
    public ChargeGunInfo setQrCode(String str) {
        this.mQrCode = str;
        return this;
    }

    public String toString() {
        return "ChargeGunInfo(mPileNo=" + getPileNo() + ", mPileName=" + getPileName() + ", mGunId=" + getGunId() + ", mGunName=" + getGunName() + ", mDisplayGunName=" + getDisplayGunName() + ", mGunSubtype=" + getGunSubtype() + ", mGunBusiStatus=" + getGunBusiStatus() + ", mGunBusiStatusName=" + getGunBusiStatusName() + ", mQrCode=" + getQrCode() + ")";
    }

    @Deprecated
    public String getPileNo() {
        return this.mPileNo;
    }

    @Deprecated
    public String getPileName() {
        return this.mPileName;
    }

    @Deprecated
    public int getGunId() {
        return this.mGunId;
    }

    @Deprecated
    public String getGunName() {
        return this.mGunName;
    }

    @Deprecated
    public String getDisplayGunName() {
        return this.mDisplayGunName;
    }

    @Deprecated
    public String getGunSubtype() {
        return this.mGunSubtype;
    }

    @Deprecated
    public String getGunBusiStatus() {
        return this.mGunBusiStatus;
    }

    @Deprecated
    public String getGunBusiStatusName() {
        return this.mGunBusiStatusName;
    }

    @Deprecated
    public String getQrCode() {
        return this.mQrCode;
    }
}
