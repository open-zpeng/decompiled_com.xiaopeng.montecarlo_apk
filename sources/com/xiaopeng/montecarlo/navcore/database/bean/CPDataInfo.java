package com.xiaopeng.montecarlo.navcore.database.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* loaded from: classes2.dex */
public class CPDataInfo {
    public static final int DATA_OPERATION_ADD = 1;
    public static final int DATA_OPERATION_DELETE = 3;
    public static final int DATA_OPERATION_UPDATE = 2;
    @SerializedName("address")
    String mAddress;
    @SerializedName("brand_name")
    String mBrandName;
    @SerializedName("category")
    String mCategory;
    @SerializedName("charge_station")
    ChargeStation mChargeStation;
    @SerializedName("city_code")
    String mCityCode;
    @SerializedName(VuiConstants.ELEMENT_ID)
    String mId;
    @SerializedName("location")
    Location mLocation;
    @SerializedName("name")
    String mName;
    @SerializedName("operate")
    int mOperate;
    @SerializedName("source")
    int mSource;
    @SerializedName("version")
    String mVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof CPDataInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CPDataInfo) {
            CPDataInfo cPDataInfo = (CPDataInfo) obj;
            if (cPDataInfo.canEqual(this) && getSource() == cPDataInfo.getSource() && getOperate() == cPDataInfo.getOperate()) {
                String id = getId();
                String id2 = cPDataInfo.getId();
                if (id != null ? id.equals(id2) : id2 == null) {
                    String version = getVersion();
                    String version2 = cPDataInfo.getVersion();
                    if (version != null ? version.equals(version2) : version2 == null) {
                        String name = getName();
                        String name2 = cPDataInfo.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            String address = getAddress();
                            String address2 = cPDataInfo.getAddress();
                            if (address != null ? address.equals(address2) : address2 == null) {
                                Location location = getLocation();
                                Location location2 = cPDataInfo.getLocation();
                                if (location != null ? location.equals(location2) : location2 == null) {
                                    String category = getCategory();
                                    String category2 = cPDataInfo.getCategory();
                                    if (category != null ? category.equals(category2) : category2 == null) {
                                        String cityCode = getCityCode();
                                        String cityCode2 = cPDataInfo.getCityCode();
                                        if (cityCode != null ? cityCode.equals(cityCode2) : cityCode2 == null) {
                                            String brandName = getBrandName();
                                            String brandName2 = cPDataInfo.getBrandName();
                                            if (brandName != null ? brandName.equals(brandName2) : brandName2 == null) {
                                                ChargeStation chargeStation = getChargeStation();
                                                ChargeStation chargeStation2 = cPDataInfo.getChargeStation();
                                                return chargeStation != null ? chargeStation.equals(chargeStation2) : chargeStation2 == null;
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
        int source = ((getSource() + 59) * 59) + getOperate();
        String id = getId();
        int hashCode = (source * 59) + (id == null ? 43 : id.hashCode());
        String version = getVersion();
        int hashCode2 = (hashCode * 59) + (version == null ? 43 : version.hashCode());
        String name = getName();
        int hashCode3 = (hashCode2 * 59) + (name == null ? 43 : name.hashCode());
        String address = getAddress();
        int hashCode4 = (hashCode3 * 59) + (address == null ? 43 : address.hashCode());
        Location location = getLocation();
        int hashCode5 = (hashCode4 * 59) + (location == null ? 43 : location.hashCode());
        String category = getCategory();
        int hashCode6 = (hashCode5 * 59) + (category == null ? 43 : category.hashCode());
        String cityCode = getCityCode();
        int hashCode7 = (hashCode6 * 59) + (cityCode == null ? 43 : cityCode.hashCode());
        String brandName = getBrandName();
        int hashCode8 = (hashCode7 * 59) + (brandName == null ? 43 : brandName.hashCode());
        ChargeStation chargeStation = getChargeStation();
        return (hashCode8 * 59) + (chargeStation != null ? chargeStation.hashCode() : 43);
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setBrandName(String str) {
        this.mBrandName = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setChargeStation(ChargeStation chargeStation) {
        this.mChargeStation = chargeStation;
    }

    public void setCityCode(String str) {
        this.mCityCode = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setOperate(int i) {
        this.mOperate = i;
    }

    public void setSource(int i) {
        this.mSource = i;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "CPDataInfo(mId=" + getId() + ", mVersion=" + getVersion() + ", mName=" + getName() + ", mSource=" + getSource() + ", mAddress=" + getAddress() + ", mLocation=" + getLocation() + ", mCategory=" + getCategory() + ", mCityCode=" + getCityCode() + ", mBrandName=" + getBrandName() + ", mChargeStation=" + getChargeStation() + ", mOperate=" + getOperate() + ")";
    }

    public String getId() {
        return this.mId;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getName() {
        return this.mName;
    }

    public int getSource() {
        return this.mSource;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public String getBrandName() {
        return this.mBrandName;
    }

    public ChargeStation getChargeStation() {
        return this.mChargeStation;
    }

    public int getOperate() {
        return this.mOperate;
    }

    public double getLon() {
        Location location = this.mLocation;
        if (location != null) {
            return location.getLon();
        }
        return 0.0d;
    }

    public double getLat() {
        Location location = this.mLocation;
        if (location != null) {
            return location.getLat();
        }
        return 0.0d;
    }

    public String getSelfSupportFlag() {
        ChargeStation chargeStation = this.mChargeStation;
        return chargeStation != null ? String.valueOf(chargeStation.getOperationMode()) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Location {
        @SerializedName(CPSearchParam.PARAM_KEY_LAT)
        double mLat;
        @SerializedName(CPSearchParam.PARAM_KEY_LON)
        double mLon;

        protected boolean canEqual(Object obj) {
            return obj instanceof Location;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Location) {
                Location location = (Location) obj;
                return location.canEqual(this) && Double.compare(getLat(), location.getLat()) == 0 && Double.compare(getLon(), location.getLon()) == 0;
            }
            return false;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(getLat());
            long doubleToLongBits2 = Double.doubleToLongBits(getLon());
            return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
        }

        public void setLat(double d) {
            this.mLat = d;
        }

        public void setLon(double d) {
            this.mLon = d;
        }

        public String toString() {
            return "CPDataInfo.Location(mLat=" + getLat() + ", mLon=" + getLon() + ")";
        }

        public double getLat() {
            return this.mLat;
        }

        public double getLon() {
            return this.mLon;
        }
    }

    /* loaded from: classes2.dex */
    public static class ChargeStation {
        @SerializedName("ac_num")
        int mAcNum;
        @SerializedName("dc_num")
        int mDcNum;
        @SerializedName("operation_mode")
        int mOperationMode;
        @SerializedName("s4_num")
        int mS4Num;

        protected boolean canEqual(Object obj) {
            return obj instanceof ChargeStation;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ChargeStation) {
                ChargeStation chargeStation = (ChargeStation) obj;
                return chargeStation.canEqual(this) && getDcNum() == chargeStation.getDcNum() && getAcNum() == chargeStation.getAcNum() && getS4Num() == chargeStation.getS4Num() && getOperationMode() == chargeStation.getOperationMode();
            }
            return false;
        }

        public int hashCode() {
            return ((((((getDcNum() + 59) * 59) + getAcNum()) * 59) + getS4Num()) * 59) + getOperationMode();
        }

        public void setAcNum(int i) {
            this.mAcNum = i;
        }

        public void setDcNum(int i) {
            this.mDcNum = i;
        }

        public void setOperationMode(int i) {
            this.mOperationMode = i;
        }

        public void setS4Num(int i) {
            this.mS4Num = i;
        }

        public String toString() {
            return "CPDataInfo.ChargeStation(mDcNum=" + getDcNum() + ", mAcNum=" + getAcNum() + ", mS4Num=" + getS4Num() + ", mOperationMode=" + getOperationMode() + ")";
        }

        public int getDcNum() {
            return this.mDcNum;
        }

        public int getAcNum() {
            return this.mAcNum;
        }

        public int getS4Num() {
            return this.mS4Num;
        }

        public int getOperationMode() {
            return this.mOperationMode;
        }
    }
}
