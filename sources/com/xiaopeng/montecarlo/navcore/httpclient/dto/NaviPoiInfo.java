package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotNull;
/* loaded from: classes2.dex */
public class NaviPoiInfo {
    @SerializedName("address")
    private String mAddress;
    @SerializedName("auto_id")
    private String mAutoId;
    @SerializedName("brand_name")
    private String mBrandName;
    @SerializedName("busi_time")
    private String mBusiTime;
    @SerializedName("car_service")
    private CarService mCarService;
    @SerializedName("car_washer")
    private CarWasher mCarWasher;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("category_label")
    private String mCategoryLabel;
    @SerializedName("charge_station")
    private NaviPoiChargeStationInfo mChargeStation;
    @SerializedName(CPSearchParam.PARAM_KEY_CITY)
    private String mCity;
    @SerializedName("city_code")
    private String mCityCode;
    @SerializedName("distance")
    private Double mDistance;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private String mId;
    @SerializedName("imgs")
    private List<String> mImgs;
    @SerializedName("intro")
    private String mIntro;
    @SerializedName("location")
    @NotNull
    private NaviLocationInfo mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("nav_location")
    private NaviLocationInfo mNavLocation;
    @SerializedName("parking_info")
    ParkingInfo mParkingInfo;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("price")
    private Price mPrice;
    @SerializedName("province")
    private String mProvince;
    @SerializedName("shop_info")
    ShopInfo mShopInfo;
    @SerializedName("source")
    private String mSource;
    @SerializedName("sub_city")
    private String mSubCity;
    @SerializedName("version")
    private String mVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviPoiInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviPoiInfo) {
            NaviPoiInfo naviPoiInfo = (NaviPoiInfo) obj;
            if (naviPoiInfo.canEqual(this)) {
                Double distance = getDistance();
                Double distance2 = naviPoiInfo.getDistance();
                if (distance != null ? distance.equals(distance2) : distance2 == null) {
                    String id = getId();
                    String id2 = naviPoiInfo.getId();
                    if (id != null ? id.equals(id2) : id2 == null) {
                        String autoId = getAutoId();
                        String autoId2 = naviPoiInfo.getAutoId();
                        if (autoId != null ? autoId.equals(autoId2) : autoId2 == null) {
                            String version = getVersion();
                            String version2 = naviPoiInfo.getVersion();
                            if (version != null ? version.equals(version2) : version2 == null) {
                                String name = getName();
                                String name2 = naviPoiInfo.getName();
                                if (name != null ? name.equals(name2) : name2 == null) {
                                    String source = getSource();
                                    String source2 = naviPoiInfo.getSource();
                                    if (source != null ? source.equals(source2) : source2 == null) {
                                        String address = getAddress();
                                        String address2 = naviPoiInfo.getAddress();
                                        if (address != null ? address.equals(address2) : address2 == null) {
                                            String province = getProvince();
                                            String province2 = naviPoiInfo.getProvince();
                                            if (province != null ? province.equals(province2) : province2 == null) {
                                                String city = getCity();
                                                String city2 = naviPoiInfo.getCity();
                                                if (city != null ? city.equals(city2) : city2 == null) {
                                                    String subCity = getSubCity();
                                                    String subCity2 = naviPoiInfo.getSubCity();
                                                    if (subCity != null ? subCity.equals(subCity2) : subCity2 == null) {
                                                        String cityCode = getCityCode();
                                                        String cityCode2 = naviPoiInfo.getCityCode();
                                                        if (cityCode != null ? cityCode.equals(cityCode2) : cityCode2 == null) {
                                                            NaviLocationInfo location = getLocation();
                                                            NaviLocationInfo location2 = naviPoiInfo.getLocation();
                                                            if (location != null ? location.equals(location2) : location2 == null) {
                                                                NaviLocationInfo navLocation = getNavLocation();
                                                                NaviLocationInfo navLocation2 = naviPoiInfo.getNavLocation();
                                                                if (navLocation != null ? navLocation.equals(navLocation2) : navLocation2 == null) {
                                                                    String brandName = getBrandName();
                                                                    String brandName2 = naviPoiInfo.getBrandName();
                                                                    if (brandName != null ? brandName.equals(brandName2) : brandName2 == null) {
                                                                        String category = getCategory();
                                                                        String category2 = naviPoiInfo.getCategory();
                                                                        if (category != null ? category.equals(category2) : category2 == null) {
                                                                            String categoryLabel = getCategoryLabel();
                                                                            String categoryLabel2 = naviPoiInfo.getCategoryLabel();
                                                                            if (categoryLabel != null ? categoryLabel.equals(categoryLabel2) : categoryLabel2 == null) {
                                                                                String phone = getPhone();
                                                                                String phone2 = naviPoiInfo.getPhone();
                                                                                if (phone != null ? phone.equals(phone2) : phone2 == null) {
                                                                                    String busiTime = getBusiTime();
                                                                                    String busiTime2 = naviPoiInfo.getBusiTime();
                                                                                    if (busiTime != null ? busiTime.equals(busiTime2) : busiTime2 == null) {
                                                                                        List<String> imgs = getImgs();
                                                                                        List<String> imgs2 = naviPoiInfo.getImgs();
                                                                                        if (imgs != null ? imgs.equals(imgs2) : imgs2 == null) {
                                                                                            String intro = getIntro();
                                                                                            String intro2 = naviPoiInfo.getIntro();
                                                                                            if (intro != null ? intro.equals(intro2) : intro2 == null) {
                                                                                                CarWasher carWasher = getCarWasher();
                                                                                                CarWasher carWasher2 = naviPoiInfo.getCarWasher();
                                                                                                if (carWasher != null ? carWasher.equals(carWasher2) : carWasher2 == null) {
                                                                                                    Price price = getPrice();
                                                                                                    Price price2 = naviPoiInfo.getPrice();
                                                                                                    if (price != null ? price.equals(price2) : price2 == null) {
                                                                                                        ParkingInfo parkingInfo = getParkingInfo();
                                                                                                        ParkingInfo parkingInfo2 = naviPoiInfo.getParkingInfo();
                                                                                                        if (parkingInfo != null ? parkingInfo.equals(parkingInfo2) : parkingInfo2 == null) {
                                                                                                            ShopInfo shopInfo = getShopInfo();
                                                                                                            ShopInfo shopInfo2 = naviPoiInfo.getShopInfo();
                                                                                                            if (shopInfo != null ? shopInfo.equals(shopInfo2) : shopInfo2 == null) {
                                                                                                                CarService carService = getCarService();
                                                                                                                CarService carService2 = naviPoiInfo.getCarService();
                                                                                                                if (carService != null ? carService.equals(carService2) : carService2 == null) {
                                                                                                                    NaviPoiChargeStationInfo chargeStation = getChargeStation();
                                                                                                                    NaviPoiChargeStationInfo chargeStation2 = naviPoiInfo.getChargeStation();
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
        Double distance = getDistance();
        int hashCode = distance == null ? 43 : distance.hashCode();
        String id = getId();
        int hashCode2 = ((hashCode + 59) * 59) + (id == null ? 43 : id.hashCode());
        String autoId = getAutoId();
        int hashCode3 = (hashCode2 * 59) + (autoId == null ? 43 : autoId.hashCode());
        String version = getVersion();
        int hashCode4 = (hashCode3 * 59) + (version == null ? 43 : version.hashCode());
        String name = getName();
        int hashCode5 = (hashCode4 * 59) + (name == null ? 43 : name.hashCode());
        String source = getSource();
        int hashCode6 = (hashCode5 * 59) + (source == null ? 43 : source.hashCode());
        String address = getAddress();
        int hashCode7 = (hashCode6 * 59) + (address == null ? 43 : address.hashCode());
        String province = getProvince();
        int hashCode8 = (hashCode7 * 59) + (province == null ? 43 : province.hashCode());
        String city = getCity();
        int hashCode9 = (hashCode8 * 59) + (city == null ? 43 : city.hashCode());
        String subCity = getSubCity();
        int hashCode10 = (hashCode9 * 59) + (subCity == null ? 43 : subCity.hashCode());
        String cityCode = getCityCode();
        int hashCode11 = (hashCode10 * 59) + (cityCode == null ? 43 : cityCode.hashCode());
        NaviLocationInfo location = getLocation();
        int hashCode12 = (hashCode11 * 59) + (location == null ? 43 : location.hashCode());
        NaviLocationInfo navLocation = getNavLocation();
        int hashCode13 = (hashCode12 * 59) + (navLocation == null ? 43 : navLocation.hashCode());
        String brandName = getBrandName();
        int hashCode14 = (hashCode13 * 59) + (brandName == null ? 43 : brandName.hashCode());
        String category = getCategory();
        int hashCode15 = (hashCode14 * 59) + (category == null ? 43 : category.hashCode());
        String categoryLabel = getCategoryLabel();
        int hashCode16 = (hashCode15 * 59) + (categoryLabel == null ? 43 : categoryLabel.hashCode());
        String phone = getPhone();
        int hashCode17 = (hashCode16 * 59) + (phone == null ? 43 : phone.hashCode());
        String busiTime = getBusiTime();
        int hashCode18 = (hashCode17 * 59) + (busiTime == null ? 43 : busiTime.hashCode());
        List<String> imgs = getImgs();
        int hashCode19 = (hashCode18 * 59) + (imgs == null ? 43 : imgs.hashCode());
        String intro = getIntro();
        int hashCode20 = (hashCode19 * 59) + (intro == null ? 43 : intro.hashCode());
        CarWasher carWasher = getCarWasher();
        int hashCode21 = (hashCode20 * 59) + (carWasher == null ? 43 : carWasher.hashCode());
        Price price = getPrice();
        int hashCode22 = (hashCode21 * 59) + (price == null ? 43 : price.hashCode());
        ParkingInfo parkingInfo = getParkingInfo();
        int hashCode23 = (hashCode22 * 59) + (parkingInfo == null ? 43 : parkingInfo.hashCode());
        ShopInfo shopInfo = getShopInfo();
        int hashCode24 = (hashCode23 * 59) + (shopInfo == null ? 43 : shopInfo.hashCode());
        CarService carService = getCarService();
        int hashCode25 = (hashCode24 * 59) + (carService == null ? 43 : carService.hashCode());
        NaviPoiChargeStationInfo chargeStation = getChargeStation();
        return (hashCode25 * 59) + (chargeStation != null ? chargeStation.hashCode() : 43);
    }

    public NaviPoiInfo setAddress(String str) {
        this.mAddress = str;
        return this;
    }

    public NaviPoiInfo setAutoId(String str) {
        this.mAutoId = str;
        return this;
    }

    public NaviPoiInfo setBrandName(String str) {
        this.mBrandName = str;
        return this;
    }

    public NaviPoiInfo setBusiTime(String str) {
        this.mBusiTime = str;
        return this;
    }

    public NaviPoiInfo setCarService(CarService carService) {
        this.mCarService = carService;
        return this;
    }

    public NaviPoiInfo setCarWasher(CarWasher carWasher) {
        this.mCarWasher = carWasher;
        return this;
    }

    public NaviPoiInfo setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public NaviPoiInfo setCategoryLabel(String str) {
        this.mCategoryLabel = str;
        return this;
    }

    public NaviPoiInfo setChargeStation(NaviPoiChargeStationInfo naviPoiChargeStationInfo) {
        this.mChargeStation = naviPoiChargeStationInfo;
        return this;
    }

    public NaviPoiInfo setCity(String str) {
        this.mCity = str;
        return this;
    }

    public NaviPoiInfo setCityCode(String str) {
        this.mCityCode = str;
        return this;
    }

    public NaviPoiInfo setDistance(Double d) {
        this.mDistance = d;
        return this;
    }

    public NaviPoiInfo setId(String str) {
        this.mId = str;
        return this;
    }

    public NaviPoiInfo setImgs(List<String> list) {
        this.mImgs = list;
        return this;
    }

    public NaviPoiInfo setIntro(String str) {
        this.mIntro = str;
        return this;
    }

    public NaviPoiInfo setLocation(NaviLocationInfo naviLocationInfo) {
        this.mLocation = naviLocationInfo;
        return this;
    }

    public NaviPoiInfo setName(String str) {
        this.mName = str;
        return this;
    }

    public NaviPoiInfo setNavLocation(NaviLocationInfo naviLocationInfo) {
        this.mNavLocation = naviLocationInfo;
        return this;
    }

    public NaviPoiInfo setParkingInfo(ParkingInfo parkingInfo) {
        this.mParkingInfo = parkingInfo;
        return this;
    }

    public NaviPoiInfo setPhone(String str) {
        this.mPhone = str;
        return this;
    }

    public NaviPoiInfo setPrice(Price price) {
        this.mPrice = price;
        return this;
    }

    public NaviPoiInfo setProvince(String str) {
        this.mProvince = str;
        return this;
    }

    public NaviPoiInfo setShopInfo(ShopInfo shopInfo) {
        this.mShopInfo = shopInfo;
        return this;
    }

    public NaviPoiInfo setSource(String str) {
        this.mSource = str;
        return this;
    }

    public NaviPoiInfo setSubCity(String str) {
        this.mSubCity = str;
        return this;
    }

    public NaviPoiInfo setVersion(String str) {
        this.mVersion = str;
        return this;
    }

    public String toString() {
        return "NaviPoiInfo(mId=" + getId() + ", mAutoId=" + getAutoId() + ", mVersion=" + getVersion() + ", mName=" + getName() + ", mSource=" + getSource() + ", mAddress=" + getAddress() + ", mProvince=" + getProvince() + ", mCity=" + getCity() + ", mSubCity=" + getSubCity() + ", mCityCode=" + getCityCode() + ", mLocation=" + getLocation() + ", mNavLocation=" + getNavLocation() + ", mBrandName=" + getBrandName() + ", mCategory=" + getCategory() + ", mCategoryLabel=" + getCategoryLabel() + ", mDistance=" + getDistance() + ", mPhone=" + getPhone() + ", mBusiTime=" + getBusiTime() + ", mImgs=" + getImgs() + ", mIntro=" + getIntro() + ", mCarWasher=" + getCarWasher() + ", mPrice=" + getPrice() + ", mParkingInfo=" + getParkingInfo() + ", mShopInfo=" + getShopInfo() + ", mCarService=" + getCarService() + ", mChargeStation=" + getChargeStation() + ")";
    }

    public String getId() {
        return this.mId;
    }

    public String getAutoId() {
        return this.mAutoId;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getName() {
        return this.mName;
    }

    public String getSource() {
        return this.mSource;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getProvince() {
        return this.mProvince;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getSubCity() {
        return this.mSubCity;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public NaviLocationInfo getLocation() {
        return this.mLocation;
    }

    public NaviLocationInfo getNavLocation() {
        return this.mNavLocation;
    }

    public String getBrandName() {
        return this.mBrandName;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getCategoryLabel() {
        return this.mCategoryLabel;
    }

    public Double getDistance() {
        return this.mDistance;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public String getBusiTime() {
        return this.mBusiTime;
    }

    public List<String> getImgs() {
        return this.mImgs;
    }

    public String getIntro() {
        return this.mIntro;
    }

    public CarWasher getCarWasher() {
        return this.mCarWasher;
    }

    public Price getPrice() {
        return this.mPrice;
    }

    public ParkingInfo getParkingInfo() {
        return this.mParkingInfo;
    }

    public ShopInfo getShopInfo() {
        return this.mShopInfo;
    }

    public CarService getCarService() {
        return this.mCarService;
    }

    public NaviPoiChargeStationInfo getChargeStation() {
        return this.mChargeStation;
    }

    /* loaded from: classes2.dex */
    public static class Price {
        @SerializedName("description")
        private String mDescription;
        @SerializedName("price_details")
        private Set<PriceDetail> mPriceDetails;

        protected boolean canEqual(Object obj) {
            return obj instanceof Price;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Price) {
                Price price = (Price) obj;
                if (price.canEqual(this)) {
                    String description = getDescription();
                    String description2 = price.getDescription();
                    if (description != null ? description.equals(description2) : description2 == null) {
                        Set<PriceDetail> priceDetails = getPriceDetails();
                        Set<PriceDetail> priceDetails2 = price.getPriceDetails();
                        return priceDetails != null ? priceDetails.equals(priceDetails2) : priceDetails2 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String description = getDescription();
            int hashCode = description == null ? 43 : description.hashCode();
            Set<PriceDetail> priceDetails = getPriceDetails();
            return ((hashCode + 59) * 59) + (priceDetails != null ? priceDetails.hashCode() : 43);
        }

        public Price setDescription(String str) {
            this.mDescription = str;
            return this;
        }

        public Price setPriceDetails(Set<PriceDetail> set) {
            this.mPriceDetails = set;
            return this;
        }

        public String toString() {
            return "NaviPoiInfo.Price(mDescription=" + getDescription() + ", mPriceDetails=" + getPriceDetails() + ")";
        }

        public String getDescription() {
            return this.mDescription;
        }

        public Set<PriceDetail> getPriceDetails() {
            return this.mPriceDetails;
        }

        /* loaded from: classes2.dex */
        public static class PriceDetail {
            @SerializedName("description")
            private String mDescription;
            @SerializedName("price")
            private String mPrice;

            protected boolean canEqual(Object obj) {
                return obj instanceof PriceDetail;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof PriceDetail) {
                    PriceDetail priceDetail = (PriceDetail) obj;
                    if (priceDetail.canEqual(this)) {
                        String description = getDescription();
                        String description2 = priceDetail.getDescription();
                        if (description != null ? description.equals(description2) : description2 == null) {
                            String price = getPrice();
                            String price2 = priceDetail.getPrice();
                            return price != null ? price.equals(price2) : price2 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            public int hashCode() {
                String description = getDescription();
                int hashCode = description == null ? 43 : description.hashCode();
                String price = getPrice();
                return ((hashCode + 59) * 59) + (price != null ? price.hashCode() : 43);
            }

            public PriceDetail setDescription(String str) {
                this.mDescription = str;
                return this;
            }

            public PriceDetail setPrice(String str) {
                this.mPrice = str;
                return this;
            }

            public String toString() {
                return "NaviPoiInfo.Price.PriceDetail(mDescription=" + getDescription() + ", mPrice=" + getPrice() + ")";
            }

            public String getDescription() {
                return this.mDescription;
            }

            public String getPrice() {
                return this.mPrice;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ParkingInfo {
        @SerializedName("fast_charge_price")
        private double mFastChargePrice;
        @SerializedName("fast_charge_remain")
        private int mFastChargeRemain;
        @SerializedName("fast_charge_total")
        private int mFastChargeTotal;
        @SerializedName("normal_charge_price")
        private double mNormalChargePrice;
        @SerializedName("normal_charge_remain")
        private int mNormalChargeRemain;
        @SerializedName("normal_charge_total")
        private int mNormalChargeTotal;
        @SerializedName("park_remain")
        private int mParkRemain;
        @SerializedName("park_total")
        private int mParkTotal;
        @SerializedName("price")
        private String mPrice;
        @SerializedName("tag")
        private String mTag;
        @SerializedName("walking_distance")
        private int mWalkingDistance;
        @SerializedName("walking_time")
        private int mWalkingTime;

        protected boolean canEqual(Object obj) {
            return obj instanceof ParkingInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ParkingInfo) {
                ParkingInfo parkingInfo = (ParkingInfo) obj;
                if (parkingInfo.canEqual(this) && getParkTotal() == parkingInfo.getParkTotal() && getParkRemain() == parkingInfo.getParkRemain() && getFastChargeTotal() == parkingInfo.getFastChargeTotal() && getFastChargeRemain() == parkingInfo.getFastChargeRemain() && Double.compare(getFastChargePrice(), parkingInfo.getFastChargePrice()) == 0 && getNormalChargeTotal() == parkingInfo.getNormalChargeTotal() && getNormalChargeRemain() == parkingInfo.getNormalChargeRemain() && Double.compare(getNormalChargePrice(), parkingInfo.getNormalChargePrice()) == 0 && getWalkingDistance() == parkingInfo.getWalkingDistance() && getWalkingTime() == parkingInfo.getWalkingTime()) {
                    String tag = getTag();
                    String tag2 = parkingInfo.getTag();
                    if (tag != null ? tag.equals(tag2) : tag2 == null) {
                        String price = getPrice();
                        String price2 = parkingInfo.getPrice();
                        return price != null ? price.equals(price2) : price2 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int parkTotal = ((((((getParkTotal() + 59) * 59) + getParkRemain()) * 59) + getFastChargeTotal()) * 59) + getFastChargeRemain();
            long doubleToLongBits = Double.doubleToLongBits(getFastChargePrice());
            int normalChargeTotal = (((((parkTotal * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + getNormalChargeTotal()) * 59) + getNormalChargeRemain();
            long doubleToLongBits2 = Double.doubleToLongBits(getNormalChargePrice());
            int walkingDistance = (((((normalChargeTotal * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + getWalkingDistance()) * 59) + getWalkingTime();
            String tag = getTag();
            int hashCode = (walkingDistance * 59) + (tag == null ? 43 : tag.hashCode());
            String price = getPrice();
            return (hashCode * 59) + (price != null ? price.hashCode() : 43);
        }

        public ParkingInfo setFastChargePrice(double d) {
            this.mFastChargePrice = d;
            return this;
        }

        public ParkingInfo setFastChargeRemain(int i) {
            this.mFastChargeRemain = i;
            return this;
        }

        public ParkingInfo setFastChargeTotal(int i) {
            this.mFastChargeTotal = i;
            return this;
        }

        public ParkingInfo setNormalChargePrice(double d) {
            this.mNormalChargePrice = d;
            return this;
        }

        public ParkingInfo setNormalChargeRemain(int i) {
            this.mNormalChargeRemain = i;
            return this;
        }

        public ParkingInfo setNormalChargeTotal(int i) {
            this.mNormalChargeTotal = i;
            return this;
        }

        public ParkingInfo setParkRemain(int i) {
            this.mParkRemain = i;
            return this;
        }

        public ParkingInfo setParkTotal(int i) {
            this.mParkTotal = i;
            return this;
        }

        public ParkingInfo setPrice(String str) {
            this.mPrice = str;
            return this;
        }

        public ParkingInfo setTag(String str) {
            this.mTag = str;
            return this;
        }

        public ParkingInfo setWalkingDistance(int i) {
            this.mWalkingDistance = i;
            return this;
        }

        public ParkingInfo setWalkingTime(int i) {
            this.mWalkingTime = i;
            return this;
        }

        public String toString() {
            return "NaviPoiInfo.ParkingInfo(mTag=" + getTag() + ", mPrice=" + getPrice() + ", mParkTotal=" + getParkTotal() + ", mParkRemain=" + getParkRemain() + ", mFastChargeTotal=" + getFastChargeTotal() + ", mFastChargeRemain=" + getFastChargeRemain() + ", mFastChargePrice=" + getFastChargePrice() + ", mNormalChargeTotal=" + getNormalChargeTotal() + ", mNormalChargeRemain=" + getNormalChargeRemain() + ", mNormalChargePrice=" + getNormalChargePrice() + ", mWalkingDistance=" + getWalkingDistance() + ", mWalkingTime=" + getWalkingTime() + ")";
        }

        public String getTag() {
            return this.mTag;
        }

        public String getPrice() {
            return this.mPrice;
        }

        public int getParkTotal() {
            return this.mParkTotal;
        }

        public int getParkRemain() {
            return this.mParkRemain;
        }

        public int getFastChargeTotal() {
            return this.mFastChargeTotal;
        }

        public int getFastChargeRemain() {
            return this.mFastChargeRemain;
        }

        public double getFastChargePrice() {
            return this.mFastChargePrice;
        }

        public int getNormalChargeTotal() {
            return this.mNormalChargeTotal;
        }

        public int getNormalChargeRemain() {
            return this.mNormalChargeRemain;
        }

        public double getNormalChargePrice() {
            return this.mNormalChargePrice;
        }

        public int getWalkingDistance() {
            return this.mWalkingDistance;
        }

        public int getWalkingTime() {
            return this.mWalkingTime;
        }
    }

    /* loaded from: classes2.dex */
    public static class ShopInfo {
        @SerializedName("biz_type")
        private String mBizType;
        @SerializedName("cost")
        private String mCost;
        @SerializedName("dishes")
        private List<String> mDishes;
        @SerializedName("open_time")
        private Set<String> mOpenTime;
        @SerializedName("rating")
        private String mRating;
        @SerializedName("tag")
        private String mTag;

        protected boolean canEqual(Object obj) {
            return obj instanceof ShopInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShopInfo) {
                ShopInfo shopInfo = (ShopInfo) obj;
                if (shopInfo.canEqual(this)) {
                    List<String> dishes = getDishes();
                    List<String> dishes2 = shopInfo.getDishes();
                    if (dishes != null ? dishes.equals(dishes2) : dishes2 == null) {
                        String tag = getTag();
                        String tag2 = shopInfo.getTag();
                        if (tag != null ? tag.equals(tag2) : tag2 == null) {
                            String bizType = getBizType();
                            String bizType2 = shopInfo.getBizType();
                            if (bizType != null ? bizType.equals(bizType2) : bizType2 == null) {
                                String rating = getRating();
                                String rating2 = shopInfo.getRating();
                                if (rating != null ? rating.equals(rating2) : rating2 == null) {
                                    String cost = getCost();
                                    String cost2 = shopInfo.getCost();
                                    if (cost != null ? cost.equals(cost2) : cost2 == null) {
                                        Set<String> openTime = getOpenTime();
                                        Set<String> openTime2 = shopInfo.getOpenTime();
                                        return openTime != null ? openTime.equals(openTime2) : openTime2 == null;
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
            List<String> dishes = getDishes();
            int hashCode = dishes == null ? 43 : dishes.hashCode();
            String tag = getTag();
            int hashCode2 = ((hashCode + 59) * 59) + (tag == null ? 43 : tag.hashCode());
            String bizType = getBizType();
            int hashCode3 = (hashCode2 * 59) + (bizType == null ? 43 : bizType.hashCode());
            String rating = getRating();
            int hashCode4 = (hashCode3 * 59) + (rating == null ? 43 : rating.hashCode());
            String cost = getCost();
            int hashCode5 = (hashCode4 * 59) + (cost == null ? 43 : cost.hashCode());
            Set<String> openTime = getOpenTime();
            return (hashCode5 * 59) + (openTime != null ? openTime.hashCode() : 43);
        }

        public ShopInfo setBizType(String str) {
            this.mBizType = str;
            return this;
        }

        public ShopInfo setCost(String str) {
            this.mCost = str;
            return this;
        }

        public ShopInfo setDishes(List<String> list) {
            this.mDishes = list;
            return this;
        }

        public ShopInfo setOpenTime(Set<String> set) {
            this.mOpenTime = set;
            return this;
        }

        public ShopInfo setRating(String str) {
            this.mRating = str;
            return this;
        }

        public ShopInfo setTag(String str) {
            this.mTag = str;
            return this;
        }

        public String toString() {
            return "NaviPoiInfo.ShopInfo(mDishes=" + getDishes() + ", mTag=" + getTag() + ", mBizType=" + getBizType() + ", mRating=" + getRating() + ", mCost=" + getCost() + ", mOpenTime=" + getOpenTime() + ")";
        }

        public List<String> getDishes() {
            return this.mDishes;
        }

        public String getTag() {
            return this.mTag;
        }

        public String getBizType() {
            return this.mBizType;
        }

        public String getRating() {
            return this.mRating;
        }

        public String getCost() {
            return this.mCost;
        }

        public Set<String> getOpenTime() {
            return this.mOpenTime;
        }
    }

    /* loaded from: classes2.dex */
    public static class CarWasher {
        @SerializedName("device_count")
        private int mDeviceCount;

        protected boolean canEqual(Object obj) {
            return obj instanceof CarWasher;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CarWasher) {
                CarWasher carWasher = (CarWasher) obj;
                return carWasher.canEqual(this) && getDeviceCount() == carWasher.getDeviceCount();
            }
            return false;
        }

        public int hashCode() {
            return 59 + getDeviceCount();
        }

        public CarWasher setDeviceCount(int i) {
            this.mDeviceCount = i;
            return this;
        }

        public String toString() {
            return "NaviPoiInfo.CarWasher(mDeviceCount=" + getDeviceCount() + ")";
        }

        public int getDeviceCount() {
            return this.mDeviceCount;
        }
    }

    /* loaded from: classes2.dex */
    public static class CarService {
        @SerializedName("chargeable")
        private boolean mIsChargeable;
        @SerializedName("visible")
        private boolean mIsVisible;
        @SerializedName("status")
        private int mStatus;
        @SerializedName("type")
        private int mType;

        protected boolean canEqual(Object obj) {
            return obj instanceof CarService;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CarService) {
                CarService carService = (CarService) obj;
                return carService.canEqual(this) && isChargeable() == carService.isChargeable() && isVisible() == carService.isVisible() && getStatus() == carService.getStatus() && getType() == carService.getType();
            }
            return false;
        }

        public int hashCode() {
            return (((((((isChargeable() ? 79 : 97) + 59) * 59) + (isVisible() ? 79 : 97)) * 59) + getStatus()) * 59) + getType();
        }

        public CarService setChargeable(boolean z) {
            this.mIsChargeable = z;
            return this;
        }

        public CarService setStatus(int i) {
            this.mStatus = i;
            return this;
        }

        public CarService setType(int i) {
            this.mType = i;
            return this;
        }

        public CarService setVisible(boolean z) {
            this.mIsVisible = z;
            return this;
        }

        public String toString() {
            return "NaviPoiInfo.CarService(mIsChargeable=" + isChargeable() + ", mIsVisible=" + isVisible() + ", mStatus=" + getStatus() + ", mType=" + getType() + ")";
        }

        public boolean isChargeable() {
            return this.mIsChargeable;
        }

        public boolean isVisible() {
            return this.mIsVisible;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public int getType() {
            return this.mType;
        }
    }
}
