package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPNaviServerPoint;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class XPNaviServerPoiInfo {
    @SerializedName("address")
    private String mAddress;
    @SerializedName("brand_name")
    private String mBrandName;
    @SerializedName("busi_time")
    private String mBusiTime;
    @SerializedName("car_washer")
    private CarWasher mCarWasher;
    @SerializedName("category")
    private String mCategory;
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
    private XPNaviServerPoint mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("navi_location")
    private XPNaviServerPoint mNaviLocation;
    @SerializedName("parking_info")
    ParkInfoBean mParkInfoBean;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("price")
    private Price mPrice;
    @SerializedName("province")
    private String mProvince;
    @SerializedName("shop_info")
    private ShopInfo mShopInfo;
    @SerializedName("source")
    private String mSource;
    @SerializedName("sub_city")
    private String mSubCity;

    protected boolean canEqual(Object obj) {
        return obj instanceof XPNaviServerPoiInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XPNaviServerPoiInfo) {
            XPNaviServerPoiInfo xPNaviServerPoiInfo = (XPNaviServerPoiInfo) obj;
            if (xPNaviServerPoiInfo.canEqual(this)) {
                Double distance = getDistance();
                Double distance2 = xPNaviServerPoiInfo.getDistance();
                if (distance != null ? distance.equals(distance2) : distance2 == null) {
                    String id = getId();
                    String id2 = xPNaviServerPoiInfo.getId();
                    if (id != null ? id.equals(id2) : id2 == null) {
                        String name = getName();
                        String name2 = xPNaviServerPoiInfo.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            String source = getSource();
                            String source2 = xPNaviServerPoiInfo.getSource();
                            if (source != null ? source.equals(source2) : source2 == null) {
                                String address = getAddress();
                                String address2 = xPNaviServerPoiInfo.getAddress();
                                if (address != null ? address.equals(address2) : address2 == null) {
                                    String province = getProvince();
                                    String province2 = xPNaviServerPoiInfo.getProvince();
                                    if (province != null ? province.equals(province2) : province2 == null) {
                                        String city = getCity();
                                        String city2 = xPNaviServerPoiInfo.getCity();
                                        if (city != null ? city.equals(city2) : city2 == null) {
                                            String subCity = getSubCity();
                                            String subCity2 = xPNaviServerPoiInfo.getSubCity();
                                            if (subCity != null ? subCity.equals(subCity2) : subCity2 == null) {
                                                String cityCode = getCityCode();
                                                String cityCode2 = xPNaviServerPoiInfo.getCityCode();
                                                if (cityCode != null ? cityCode.equals(cityCode2) : cityCode2 == null) {
                                                    XPNaviServerPoint location = getLocation();
                                                    XPNaviServerPoint location2 = xPNaviServerPoiInfo.getLocation();
                                                    if (location != null ? location.equals(location2) : location2 == null) {
                                                        XPNaviServerPoint naviLocation = getNaviLocation();
                                                        XPNaviServerPoint naviLocation2 = xPNaviServerPoiInfo.getNaviLocation();
                                                        if (naviLocation != null ? naviLocation.equals(naviLocation2) : naviLocation2 == null) {
                                                            String brandName = getBrandName();
                                                            String brandName2 = xPNaviServerPoiInfo.getBrandName();
                                                            if (brandName != null ? brandName.equals(brandName2) : brandName2 == null) {
                                                                String category = getCategory();
                                                                String category2 = xPNaviServerPoiInfo.getCategory();
                                                                if (category != null ? category.equals(category2) : category2 == null) {
                                                                    String phone = getPhone();
                                                                    String phone2 = xPNaviServerPoiInfo.getPhone();
                                                                    if (phone != null ? phone.equals(phone2) : phone2 == null) {
                                                                        String busiTime = getBusiTime();
                                                                        String busiTime2 = xPNaviServerPoiInfo.getBusiTime();
                                                                        if (busiTime != null ? busiTime.equals(busiTime2) : busiTime2 == null) {
                                                                            List<String> imgs = getImgs();
                                                                            List<String> imgs2 = xPNaviServerPoiInfo.getImgs();
                                                                            if (imgs != null ? imgs.equals(imgs2) : imgs2 == null) {
                                                                                String intro = getIntro();
                                                                                String intro2 = xPNaviServerPoiInfo.getIntro();
                                                                                if (intro != null ? intro.equals(intro2) : intro2 == null) {
                                                                                    CarWasher carWasher = getCarWasher();
                                                                                    CarWasher carWasher2 = xPNaviServerPoiInfo.getCarWasher();
                                                                                    if (carWasher != null ? carWasher.equals(carWasher2) : carWasher2 == null) {
                                                                                        Price price = getPrice();
                                                                                        Price price2 = xPNaviServerPoiInfo.getPrice();
                                                                                        if (price != null ? price.equals(price2) : price2 == null) {
                                                                                            ParkInfoBean parkInfoBean = getParkInfoBean();
                                                                                            ParkInfoBean parkInfoBean2 = xPNaviServerPoiInfo.getParkInfoBean();
                                                                                            if (parkInfoBean != null ? parkInfoBean.equals(parkInfoBean2) : parkInfoBean2 == null) {
                                                                                                ShopInfo shopInfo = getShopInfo();
                                                                                                ShopInfo shopInfo2 = xPNaviServerPoiInfo.getShopInfo();
                                                                                                return shopInfo != null ? shopInfo.equals(shopInfo2) : shopInfo2 == null;
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
        String name = getName();
        int hashCode3 = (hashCode2 * 59) + (name == null ? 43 : name.hashCode());
        String source = getSource();
        int hashCode4 = (hashCode3 * 59) + (source == null ? 43 : source.hashCode());
        String address = getAddress();
        int hashCode5 = (hashCode4 * 59) + (address == null ? 43 : address.hashCode());
        String province = getProvince();
        int hashCode6 = (hashCode5 * 59) + (province == null ? 43 : province.hashCode());
        String city = getCity();
        int hashCode7 = (hashCode6 * 59) + (city == null ? 43 : city.hashCode());
        String subCity = getSubCity();
        int hashCode8 = (hashCode7 * 59) + (subCity == null ? 43 : subCity.hashCode());
        String cityCode = getCityCode();
        int hashCode9 = (hashCode8 * 59) + (cityCode == null ? 43 : cityCode.hashCode());
        XPNaviServerPoint location = getLocation();
        int hashCode10 = (hashCode9 * 59) + (location == null ? 43 : location.hashCode());
        XPNaviServerPoint naviLocation = getNaviLocation();
        int hashCode11 = (hashCode10 * 59) + (naviLocation == null ? 43 : naviLocation.hashCode());
        String brandName = getBrandName();
        int hashCode12 = (hashCode11 * 59) + (brandName == null ? 43 : brandName.hashCode());
        String category = getCategory();
        int hashCode13 = (hashCode12 * 59) + (category == null ? 43 : category.hashCode());
        String phone = getPhone();
        int hashCode14 = (hashCode13 * 59) + (phone == null ? 43 : phone.hashCode());
        String busiTime = getBusiTime();
        int hashCode15 = (hashCode14 * 59) + (busiTime == null ? 43 : busiTime.hashCode());
        List<String> imgs = getImgs();
        int hashCode16 = (hashCode15 * 59) + (imgs == null ? 43 : imgs.hashCode());
        String intro = getIntro();
        int hashCode17 = (hashCode16 * 59) + (intro == null ? 43 : intro.hashCode());
        CarWasher carWasher = getCarWasher();
        int hashCode18 = (hashCode17 * 59) + (carWasher == null ? 43 : carWasher.hashCode());
        Price price = getPrice();
        int hashCode19 = (hashCode18 * 59) + (price == null ? 43 : price.hashCode());
        ParkInfoBean parkInfoBean = getParkInfoBean();
        int hashCode20 = (hashCode19 * 59) + (parkInfoBean == null ? 43 : parkInfoBean.hashCode());
        ShopInfo shopInfo = getShopInfo();
        return (hashCode20 * 59) + (shopInfo != null ? shopInfo.hashCode() : 43);
    }

    public XPNaviServerPoiInfo setAddress(String str) {
        this.mAddress = str;
        return this;
    }

    public XPNaviServerPoiInfo setBrandName(String str) {
        this.mBrandName = str;
        return this;
    }

    public XPNaviServerPoiInfo setBusiTime(String str) {
        this.mBusiTime = str;
        return this;
    }

    public XPNaviServerPoiInfo setCarWasher(CarWasher carWasher) {
        this.mCarWasher = carWasher;
        return this;
    }

    public XPNaviServerPoiInfo setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public XPNaviServerPoiInfo setCity(String str) {
        this.mCity = str;
        return this;
    }

    public XPNaviServerPoiInfo setCityCode(String str) {
        this.mCityCode = str;
        return this;
    }

    public XPNaviServerPoiInfo setDistance(Double d) {
        this.mDistance = d;
        return this;
    }

    public XPNaviServerPoiInfo setId(String str) {
        this.mId = str;
        return this;
    }

    public XPNaviServerPoiInfo setImgs(List<String> list) {
        this.mImgs = list;
        return this;
    }

    public XPNaviServerPoiInfo setIntro(String str) {
        this.mIntro = str;
        return this;
    }

    public XPNaviServerPoiInfo setLocation(XPNaviServerPoint xPNaviServerPoint) {
        this.mLocation = xPNaviServerPoint;
        return this;
    }

    public XPNaviServerPoiInfo setName(String str) {
        this.mName = str;
        return this;
    }

    public XPNaviServerPoiInfo setNaviLocation(XPNaviServerPoint xPNaviServerPoint) {
        this.mNaviLocation = xPNaviServerPoint;
        return this;
    }

    public XPNaviServerPoiInfo setParkInfoBean(ParkInfoBean parkInfoBean) {
        this.mParkInfoBean = parkInfoBean;
        return this;
    }

    public XPNaviServerPoiInfo setPhone(String str) {
        this.mPhone = str;
        return this;
    }

    public XPNaviServerPoiInfo setPrice(Price price) {
        this.mPrice = price;
        return this;
    }

    public XPNaviServerPoiInfo setProvince(String str) {
        this.mProvince = str;
        return this;
    }

    public XPNaviServerPoiInfo setShopInfo(ShopInfo shopInfo) {
        this.mShopInfo = shopInfo;
        return this;
    }

    public XPNaviServerPoiInfo setSource(String str) {
        this.mSource = str;
        return this;
    }

    public XPNaviServerPoiInfo setSubCity(String str) {
        this.mSubCity = str;
        return this;
    }

    public String toString() {
        return "XPNaviServerPoiInfo(mId=" + getId() + ", mName=" + getName() + ", mSource=" + getSource() + ", mAddress=" + getAddress() + ", mProvince=" + getProvince() + ", mCity=" + getCity() + ", mSubCity=" + getSubCity() + ", mCityCode=" + getCityCode() + ", mLocation=" + getLocation() + ", mNaviLocation=" + getNaviLocation() + ", mBrandName=" + getBrandName() + ", mCategory=" + getCategory() + ", mDistance=" + getDistance() + ", mPhone=" + getPhone() + ", mBusiTime=" + getBusiTime() + ", mImgs=" + getImgs() + ", mIntro=" + getIntro() + ", mCarWasher=" + getCarWasher() + ", mPrice=" + getPrice() + ", mParkInfoBean=" + getParkInfoBean() + ", mShopInfo=" + getShopInfo() + ")";
    }

    public String getId() {
        return this.mId;
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

    public XPNaviServerPoint getLocation() {
        return this.mLocation;
    }

    public XPNaviServerPoint getNaviLocation() {
        return this.mNaviLocation;
    }

    public String getBrandName() {
        return this.mBrandName;
    }

    public String getCategory() {
        return this.mCategory;
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

    public ParkInfoBean getParkInfoBean() {
        return this.mParkInfoBean;
    }

    public ShopInfo getShopInfo() {
        return this.mShopInfo;
    }

    /* loaded from: classes3.dex */
    public static class CarWasher {
        @SerializedName("device_count")
        private Integer mDeviceCount;

        protected boolean canEqual(Object obj) {
            return obj instanceof CarWasher;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CarWasher) {
                CarWasher carWasher = (CarWasher) obj;
                if (carWasher.canEqual(this)) {
                    Integer deviceCount = getDeviceCount();
                    Integer deviceCount2 = carWasher.getDeviceCount();
                    return deviceCount != null ? deviceCount.equals(deviceCount2) : deviceCount2 == null;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            Integer deviceCount = getDeviceCount();
            return 59 + (deviceCount == null ? 43 : deviceCount.hashCode());
        }

        public CarWasher setDeviceCount(Integer num) {
            this.mDeviceCount = num;
            return this;
        }

        public String toString() {
            return "XPNaviServerPoiInfo.CarWasher(mDeviceCount=" + getDeviceCount() + ")";
        }

        public Integer getDeviceCount() {
            return this.mDeviceCount;
        }
    }

    /* loaded from: classes3.dex */
    public static class Price {
        @SerializedName("description")
        private String mDescription;
        @SerializedName("price_details")
        private List<PriceDetail> mPriceDetails;

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
                        List<PriceDetail> priceDetails = getPriceDetails();
                        List<PriceDetail> priceDetails2 = price.getPriceDetails();
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
            List<PriceDetail> priceDetails = getPriceDetails();
            return ((hashCode + 59) * 59) + (priceDetails != null ? priceDetails.hashCode() : 43);
        }

        public Price setDescription(String str) {
            this.mDescription = str;
            return this;
        }

        public Price setPriceDetails(List<PriceDetail> list) {
            this.mPriceDetails = list;
            return this;
        }

        public String toString() {
            return "XPNaviServerPoiInfo.Price(mDescription=" + getDescription() + ", mPriceDetails=" + getPriceDetails() + ")";
        }

        public String getDescription() {
            return this.mDescription;
        }

        public List<PriceDetail> getPriceDetails() {
            return this.mPriceDetails;
        }
    }

    /* loaded from: classes3.dex */
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
            return "XPNaviServerPoiInfo.PriceDetail(mDescription=" + getDescription() + ", mPrice=" + getPrice() + ")";
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getPrice() {
            return this.mPrice;
        }
    }

    /* loaded from: classes3.dex */
    public static class ParkInfoBean {
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
            return obj instanceof ParkInfoBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ParkInfoBean) {
                ParkInfoBean parkInfoBean = (ParkInfoBean) obj;
                if (parkInfoBean.canEqual(this) && getParkTotal() == parkInfoBean.getParkTotal() && getParkRemain() == parkInfoBean.getParkRemain() && getFastChargeTotal() == parkInfoBean.getFastChargeTotal() && getFastChargeRemain() == parkInfoBean.getFastChargeRemain() && Double.compare(getFastChargePrice(), parkInfoBean.getFastChargePrice()) == 0 && getNormalChargeTotal() == parkInfoBean.getNormalChargeTotal() && getNormalChargeRemain() == parkInfoBean.getNormalChargeRemain() && Double.compare(getNormalChargePrice(), parkInfoBean.getNormalChargePrice()) == 0 && getWalkingDistance() == parkInfoBean.getWalkingDistance() && getWalkingTime() == parkInfoBean.getWalkingTime()) {
                    String tag = getTag();
                    String tag2 = parkInfoBean.getTag();
                    if (tag != null ? tag.equals(tag2) : tag2 == null) {
                        String price = getPrice();
                        String price2 = parkInfoBean.getPrice();
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

        public ParkInfoBean setFastChargePrice(double d) {
            this.mFastChargePrice = d;
            return this;
        }

        public ParkInfoBean setFastChargeRemain(int i) {
            this.mFastChargeRemain = i;
            return this;
        }

        public ParkInfoBean setFastChargeTotal(int i) {
            this.mFastChargeTotal = i;
            return this;
        }

        public ParkInfoBean setNormalChargePrice(double d) {
            this.mNormalChargePrice = d;
            return this;
        }

        public ParkInfoBean setNormalChargeRemain(int i) {
            this.mNormalChargeRemain = i;
            return this;
        }

        public ParkInfoBean setNormalChargeTotal(int i) {
            this.mNormalChargeTotal = i;
            return this;
        }

        public ParkInfoBean setParkRemain(int i) {
            this.mParkRemain = i;
            return this;
        }

        public ParkInfoBean setParkTotal(int i) {
            this.mParkTotal = i;
            return this;
        }

        public ParkInfoBean setPrice(String str) {
            this.mPrice = str;
            return this;
        }

        public ParkInfoBean setTag(String str) {
            this.mTag = str;
            return this;
        }

        public ParkInfoBean setWalkingDistance(int i) {
            this.mWalkingDistance = i;
            return this;
        }

        public ParkInfoBean setWalkingTime(int i) {
            this.mWalkingTime = i;
            return this;
        }

        public String toString() {
            return "XPNaviServerPoiInfo.ParkInfoBean(mParkTotal=" + getParkTotal() + ", mParkRemain=" + getParkRemain() + ", mFastChargeTotal=" + getFastChargeTotal() + ", mFastChargeRemain=" + getFastChargeRemain() + ", mFastChargePrice=" + getFastChargePrice() + ", mNormalChargeTotal=" + getNormalChargeTotal() + ", mNormalChargeRemain=" + getNormalChargeRemain() + ", mNormalChargePrice=" + getNormalChargePrice() + ", mTag=" + getTag() + ", mWalkingDistance=" + getWalkingDistance() + ", mWalkingTime=" + getWalkingTime() + ", mPrice=" + getPrice() + ")";
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

        public String getTag() {
            return this.mTag;
        }

        public int getWalkingDistance() {
            return this.mWalkingDistance;
        }

        public int getWalkingTime() {
            return this.mWalkingTime;
        }

        public String getPrice() {
            return this.mPrice;
        }
    }

    /* loaded from: classes3.dex */
    public static class ShopInfo {
        @SerializedName("biz_type")
        private String mBizType;
        @SerializedName("cost")
        private String mCost;
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

        public int hashCode() {
            String tag = getTag();
            int hashCode = tag == null ? 43 : tag.hashCode();
            String bizType = getBizType();
            int hashCode2 = ((hashCode + 59) * 59) + (bizType == null ? 43 : bizType.hashCode());
            String rating = getRating();
            int hashCode3 = (hashCode2 * 59) + (rating == null ? 43 : rating.hashCode());
            String cost = getCost();
            int hashCode4 = (hashCode3 * 59) + (cost == null ? 43 : cost.hashCode());
            Set<String> openTime = getOpenTime();
            return (hashCode4 * 59) + (openTime != null ? openTime.hashCode() : 43);
        }

        public ShopInfo setBizType(String str) {
            this.mBizType = str;
            return this;
        }

        public ShopInfo setCost(String str) {
            this.mCost = str;
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
            return "XPNaviServerPoiInfo.ShopInfo(mTag=" + getTag() + ", mBizType=" + getBizType() + ", mRating=" + getRating() + ", mCost=" + getCost() + ", mOpenTime=" + getOpenTime() + ")";
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
}
