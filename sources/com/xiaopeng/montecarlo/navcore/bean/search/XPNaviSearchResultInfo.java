package com.xiaopeng.montecarlo.navcore.bean.search;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class XPNaviSearchResultInfo {
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
    @SerializedName("category_level")
    private String mCategoryLevel;
    @SerializedName(CPSearchParam.PARAM_KEY_CITY)
    private String mCity;
    @SerializedName("city_code")
    private String mCityCode;
    @SerializedName("distance")
    private int mDistance;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private String mId;
    @SerializedName("imgs")
    private List<String> mImgs;
    @SerializedName("intro")
    private String mIntro;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("nav_location")
    private Location mNaviLocation;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("price")
    private Price mPrice;
    @SerializedName("province")
    private String mProvince;
    @SerializedName("source")
    private String mSource;
    @SerializedName("sub_city")
    private String mSubCity;

    protected boolean canEqual(Object obj) {
        return obj instanceof XPNaviSearchResultInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XPNaviSearchResultInfo) {
            XPNaviSearchResultInfo xPNaviSearchResultInfo = (XPNaviSearchResultInfo) obj;
            if (xPNaviSearchResultInfo.canEqual(this) && getDistance() == xPNaviSearchResultInfo.getDistance()) {
                String id = getId();
                String id2 = xPNaviSearchResultInfo.getId();
                if (id != null ? id.equals(id2) : id2 == null) {
                    String autoId = getAutoId();
                    String autoId2 = xPNaviSearchResultInfo.getAutoId();
                    if (autoId != null ? autoId.equals(autoId2) : autoId2 == null) {
                        String name = getName();
                        String name2 = xPNaviSearchResultInfo.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            String address = getAddress();
                            String address2 = xPNaviSearchResultInfo.getAddress();
                            if (address != null ? address.equals(address2) : address2 == null) {
                                String province = getProvince();
                                String province2 = xPNaviSearchResultInfo.getProvince();
                                if (province != null ? province.equals(province2) : province2 == null) {
                                    String city = getCity();
                                    String city2 = xPNaviSearchResultInfo.getCity();
                                    if (city != null ? city.equals(city2) : city2 == null) {
                                        String subCity = getSubCity();
                                        String subCity2 = xPNaviSearchResultInfo.getSubCity();
                                        if (subCity != null ? subCity.equals(subCity2) : subCity2 == null) {
                                            String cityCode = getCityCode();
                                            String cityCode2 = xPNaviSearchResultInfo.getCityCode();
                                            if (cityCode != null ? cityCode.equals(cityCode2) : cityCode2 == null) {
                                                Location location = getLocation();
                                                Location location2 = xPNaviSearchResultInfo.getLocation();
                                                if (location != null ? location.equals(location2) : location2 == null) {
                                                    Location naviLocation = getNaviLocation();
                                                    Location naviLocation2 = xPNaviSearchResultInfo.getNaviLocation();
                                                    if (naviLocation != null ? naviLocation.equals(naviLocation2) : naviLocation2 == null) {
                                                        String source = getSource();
                                                        String source2 = xPNaviSearchResultInfo.getSource();
                                                        if (source != null ? source.equals(source2) : source2 == null) {
                                                            String category = getCategory();
                                                            String category2 = xPNaviSearchResultInfo.getCategory();
                                                            if (category != null ? category.equals(category2) : category2 == null) {
                                                                String categoryLevel = getCategoryLevel();
                                                                String categoryLevel2 = xPNaviSearchResultInfo.getCategoryLevel();
                                                                if (categoryLevel != null ? categoryLevel.equals(categoryLevel2) : categoryLevel2 == null) {
                                                                    String brandName = getBrandName();
                                                                    String brandName2 = xPNaviSearchResultInfo.getBrandName();
                                                                    if (brandName != null ? brandName.equals(brandName2) : brandName2 == null) {
                                                                        String busiTime = getBusiTime();
                                                                        String busiTime2 = xPNaviSearchResultInfo.getBusiTime();
                                                                        if (busiTime != null ? busiTime.equals(busiTime2) : busiTime2 == null) {
                                                                            String phone = getPhone();
                                                                            String phone2 = xPNaviSearchResultInfo.getPhone();
                                                                            if (phone != null ? phone.equals(phone2) : phone2 == null) {
                                                                                List<String> imgs = getImgs();
                                                                                List<String> imgs2 = xPNaviSearchResultInfo.getImgs();
                                                                                if (imgs != null ? imgs.equals(imgs2) : imgs2 == null) {
                                                                                    String intro = getIntro();
                                                                                    String intro2 = xPNaviSearchResultInfo.getIntro();
                                                                                    if (intro != null ? intro.equals(intro2) : intro2 == null) {
                                                                                        Price price = getPrice();
                                                                                        Price price2 = xPNaviSearchResultInfo.getPrice();
                                                                                        if (price != null ? price.equals(price2) : price2 == null) {
                                                                                            CarWasher carWasher = getCarWasher();
                                                                                            CarWasher carWasher2 = xPNaviSearchResultInfo.getCarWasher();
                                                                                            if (carWasher != null ? carWasher.equals(carWasher2) : carWasher2 == null) {
                                                                                                CarService carService = getCarService();
                                                                                                CarService carService2 = xPNaviSearchResultInfo.getCarService();
                                                                                                return carService != null ? carService.equals(carService2) : carService2 == null;
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
        String id = getId();
        int distance = ((getDistance() + 59) * 59) + (id == null ? 43 : id.hashCode());
        String autoId = getAutoId();
        int hashCode = (distance * 59) + (autoId == null ? 43 : autoId.hashCode());
        String name = getName();
        int hashCode2 = (hashCode * 59) + (name == null ? 43 : name.hashCode());
        String address = getAddress();
        int hashCode3 = (hashCode2 * 59) + (address == null ? 43 : address.hashCode());
        String province = getProvince();
        int hashCode4 = (hashCode3 * 59) + (province == null ? 43 : province.hashCode());
        String city = getCity();
        int hashCode5 = (hashCode4 * 59) + (city == null ? 43 : city.hashCode());
        String subCity = getSubCity();
        int hashCode6 = (hashCode5 * 59) + (subCity == null ? 43 : subCity.hashCode());
        String cityCode = getCityCode();
        int hashCode7 = (hashCode6 * 59) + (cityCode == null ? 43 : cityCode.hashCode());
        Location location = getLocation();
        int hashCode8 = (hashCode7 * 59) + (location == null ? 43 : location.hashCode());
        Location naviLocation = getNaviLocation();
        int hashCode9 = (hashCode8 * 59) + (naviLocation == null ? 43 : naviLocation.hashCode());
        String source = getSource();
        int hashCode10 = (hashCode9 * 59) + (source == null ? 43 : source.hashCode());
        String category = getCategory();
        int hashCode11 = (hashCode10 * 59) + (category == null ? 43 : category.hashCode());
        String categoryLevel = getCategoryLevel();
        int hashCode12 = (hashCode11 * 59) + (categoryLevel == null ? 43 : categoryLevel.hashCode());
        String brandName = getBrandName();
        int hashCode13 = (hashCode12 * 59) + (brandName == null ? 43 : brandName.hashCode());
        String busiTime = getBusiTime();
        int hashCode14 = (hashCode13 * 59) + (busiTime == null ? 43 : busiTime.hashCode());
        String phone = getPhone();
        int hashCode15 = (hashCode14 * 59) + (phone == null ? 43 : phone.hashCode());
        List<String> imgs = getImgs();
        int hashCode16 = (hashCode15 * 59) + (imgs == null ? 43 : imgs.hashCode());
        String intro = getIntro();
        int hashCode17 = (hashCode16 * 59) + (intro == null ? 43 : intro.hashCode());
        Price price = getPrice();
        int hashCode18 = (hashCode17 * 59) + (price == null ? 43 : price.hashCode());
        CarWasher carWasher = getCarWasher();
        int hashCode19 = (hashCode18 * 59) + (carWasher == null ? 43 : carWasher.hashCode());
        CarService carService = getCarService();
        return (hashCode19 * 59) + (carService != null ? carService.hashCode() : 43);
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setAutoId(String str) {
        this.mAutoId = str;
    }

    public void setBrandName(String str) {
        this.mBrandName = str;
    }

    public void setBusiTime(String str) {
        this.mBusiTime = str;
    }

    public void setCarService(CarService carService) {
        this.mCarService = carService;
    }

    public void setCarWasher(CarWasher carWasher) {
        this.mCarWasher = carWasher;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setCategoryLevel(String str) {
        this.mCategoryLevel = str;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public void setCityCode(String str) {
        this.mCityCode = str;
    }

    public void setDistance(int i) {
        this.mDistance = i;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setImgs(List<String> list) {
        this.mImgs = list;
    }

    public void setIntro(String str) {
        this.mIntro = str;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNaviLocation(Location location) {
        this.mNaviLocation = location;
    }

    public void setPhone(String str) {
        this.mPhone = str;
    }

    public void setPrice(Price price) {
        this.mPrice = price;
    }

    public void setProvince(String str) {
        this.mProvince = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setSubCity(String str) {
        this.mSubCity = str;
    }

    public String toString() {
        return "XPNaviSearchResultInfo(mId=" + getId() + ", mAutoId=" + getAutoId() + ", mName=" + getName() + ", mAddress=" + getAddress() + ", mProvince=" + getProvince() + ", mCity=" + getCity() + ", mSubCity=" + getSubCity() + ", mCityCode=" + getCityCode() + ", mLocation=" + getLocation() + ", mNaviLocation=" + getNaviLocation() + ", mSource=" + getSource() + ", mCategory=" + getCategory() + ", mCategoryLevel=" + getCategoryLevel() + ", mBrandName=" + getBrandName() + ", mBusiTime=" + getBusiTime() + ", mDistance=" + getDistance() + ", mPhone=" + getPhone() + ", mImgs=" + getImgs() + ", mIntro=" + getIntro() + ", mPrice=" + getPrice() + ", mCarWasher=" + getCarWasher() + ", mCarService=" + getCarService() + ")";
    }

    public String getId() {
        return this.mId;
    }

    public String getAutoId() {
        return this.mAutoId;
    }

    public String getName() {
        return this.mName;
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

    public Location getLocation() {
        return this.mLocation;
    }

    public Location getNaviLocation() {
        return this.mNaviLocation;
    }

    public String getSource() {
        return this.mSource;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getCategoryLevel() {
        return this.mCategoryLevel;
    }

    public String getBrandName() {
        return this.mBrandName;
    }

    public String getBusiTime() {
        return this.mBusiTime;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public List<String> getImgs() {
        return this.mImgs;
    }

    public String getIntro() {
        return this.mIntro;
    }

    public Price getPrice() {
        return this.mPrice;
    }

    public CarWasher getCarWasher() {
        return this.mCarWasher;
    }

    public CarService getCarService() {
        return this.mCarService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class Location {
        @SerializedName(CPSearchParam.PARAM_KEY_LAT)
        private double mLat;
        @SerializedName(CPSearchParam.PARAM_KEY_LON)
        private double mLon;

        public Location() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof Location;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Location) {
                Location location = (Location) obj;
                return location.canEqual(this) && Double.compare(getLon(), location.getLon()) == 0 && Double.compare(getLat(), location.getLat()) == 0;
            }
            return false;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(getLon());
            long doubleToLongBits2 = Double.doubleToLongBits(getLat());
            return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
        }

        public void setLat(double d) {
            this.mLat = d;
        }

        public void setLon(double d) {
            this.mLon = d;
        }

        public String toString() {
            return "XPNaviSearchResultInfo.Location(mLon=" + getLon() + ", mLat=" + getLat() + ")";
        }

        public double getLon() {
            return this.mLon;
        }

        public double getLat() {
            return this.mLat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class Price {
        @SerializedName("description")
        private String mDescription;
        @SerializedName("price_details")
        private List<PriceDetails> mPriceDetailsList;

        public Price() {
        }

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
                        List<PriceDetails> priceDetailsList = getPriceDetailsList();
                        List<PriceDetails> priceDetailsList2 = price.getPriceDetailsList();
                        return priceDetailsList != null ? priceDetailsList.equals(priceDetailsList2) : priceDetailsList2 == null;
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
            List<PriceDetails> priceDetailsList = getPriceDetailsList();
            return ((hashCode + 59) * 59) + (priceDetailsList != null ? priceDetailsList.hashCode() : 43);
        }

        public void setDescription(String str) {
            this.mDescription = str;
        }

        public void setPriceDetailsList(List<PriceDetails> list) {
            this.mPriceDetailsList = list;
        }

        public String toString() {
            return "XPNaviSearchResultInfo.Price(mDescription=" + getDescription() + ", mPriceDetailsList=" + getPriceDetailsList() + ")";
        }

        public String getDescription() {
            return this.mDescription;
        }

        public List<PriceDetails> getPriceDetailsList() {
            return this.mPriceDetailsList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class PriceDetails {
        @SerializedName("description")
        private String mDescription;
        @SerializedName("price")
        private String mPrice;

        public PriceDetails() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof PriceDetails;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PriceDetails) {
                PriceDetails priceDetails = (PriceDetails) obj;
                if (priceDetails.canEqual(this)) {
                    String description = getDescription();
                    String description2 = priceDetails.getDescription();
                    if (description != null ? description.equals(description2) : description2 == null) {
                        String price = getPrice();
                        String price2 = priceDetails.getPrice();
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

        public void setDescription(String str) {
            this.mDescription = str;
        }

        public void setPrice(String str) {
            this.mPrice = str;
        }

        public String toString() {
            return "XPNaviSearchResultInfo.PriceDetails(mDescription=" + getDescription() + ", mPrice=" + getPrice() + ")";
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getPrice() {
            return this.mPrice;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class CarWasher {
        @SerializedName("device_count")
        private int mDeviceCount;

        public CarWasher() {
        }

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

        public void setDeviceCount(int i) {
            this.mDeviceCount = i;
        }

        public String toString() {
            return "XPNaviSearchResultInfo.CarWasher(mDeviceCount=" + getDeviceCount() + ")";
        }

        public int getDeviceCount() {
            return this.mDeviceCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class CarService {
        @SerializedName("chargeable")
        private boolean mChargeable;
        @SerializedName("status")
        private int mStatus;
        @SerializedName("type")
        private int mType;
        @SerializedName("visible")
        private boolean mVisible;

        public CarService() {
        }

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

        public void setChargeable(boolean z) {
            this.mChargeable = z;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public void setType(int i) {
            this.mType = i;
        }

        public void setVisible(boolean z) {
            this.mVisible = z;
        }

        public String toString() {
            return "XPNaviSearchResultInfo.CarService(mChargeable=" + isChargeable() + ", mVisible=" + isVisible() + ", mStatus=" + getStatus() + ", mType=" + getType() + ")";
        }

        public boolean isChargeable() {
            return this.mChargeable;
        }

        public boolean isVisible() {
            return this.mVisible;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public int getType() {
            return this.mType;
        }
    }

    public static XPPoiInfo toXPPoiInfo(XPNaviSearchResultInfo xPNaviSearchResultInfo) {
        if (xPNaviSearchResultInfo == null) {
            return null;
        }
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        xPPoiInfo.setPoiId(xPNaviSearchResultInfo.mId);
        xPPoiInfo.setName(xPNaviSearchResultInfo.mName);
        xPPoiInfo.setAddress(xPNaviSearchResultInfo.mAddress);
        xPPoiInfo.setProvinceName(xPNaviSearchResultInfo.mProvince);
        xPPoiInfo.setCityName(xPNaviSearchResultInfo.mCity);
        xPPoiInfo.setDistrictName(xPNaviSearchResultInfo.mSubCity);
        xPPoiInfo.setCityCode(xPNaviSearchResultInfo.mCityCode);
        xPPoiInfo.setTag(xPNaviSearchResultInfo.mBrandName);
        xPPoiInfo.setOpenTime(xPNaviSearchResultInfo.mBusiTime);
        xPPoiInfo.setTel(xPNaviSearchResultInfo.mPhone);
        xPPoiInfo.setImageUrlList(xPNaviSearchResultInfo.mImgs);
        Location location = xPNaviSearchResultInfo.mLocation;
        if (location != null) {
            xPPoiInfo.setDisplayLon(location.mLon);
            xPPoiInfo.setDisplayLat(xPNaviSearchResultInfo.mLocation.mLat);
            XPCoordinate2DDouble currentLocation = TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation();
            if (currentLocation != null) {
                xPPoiInfo.setDistance(LocationUtils.getDistance(new XPCoordinate2DDouble(xPNaviSearchResultInfo.mLocation.mLon, xPNaviSearchResultInfo.mLocation.mLat), currentLocation));
            }
        }
        Location location2 = xPNaviSearchResultInfo.mNaviLocation;
        if (location2 != null) {
            xPPoiInfo.setNaviLon(location2.mLon);
            xPPoiInfo.setNaviLat(xPNaviSearchResultInfo.mNaviLocation.mLat);
        }
        if (xPNaviSearchResultInfo.mPrice != null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(xPNaviSearchResultInfo.mPrice.mDescription)) {
                sb.append(xPNaviSearchResultInfo.mPrice.mDescription);
            }
            if (CollectionUtils.isNotEmpty(xPNaviSearchResultInfo.mPrice.mPriceDetailsList)) {
                for (PriceDetails priceDetails : xPNaviSearchResultInfo.mPrice.mPriceDetailsList) {
                    if (priceDetails != null) {
                        if (!TextUtils.isEmpty(priceDetails.mDescription)) {
                            sb.append(priceDetails.mDescription);
                        }
                        if (!TextUtils.isEmpty(priceDetails.mPrice)) {
                            sb.append(priceDetails.mPrice);
                        }
                    }
                }
            }
            xPPoiInfo.setPrice(sb.toString());
        }
        if ("1".equalsIgnoreCase(xPNaviSearchResultInfo.mSource)) {
            xPPoiInfo.setPoiSource(1);
        } else if ("3".equalsIgnoreCase(xPNaviSearchResultInfo.mSource)) {
            xPPoiInfo.setPoiSource(3);
        } else if ("7".equalsIgnoreCase(xPNaviSearchResultInfo.mSource)) {
            xPPoiInfo.setPoiSource(7);
        } else if (BLParams.AOS_ROUTE_TYPE_NO_FREEWAY.equalsIgnoreCase(xPNaviSearchResultInfo.mSource)) {
            xPPoiInfo.setPoiSource(9);
        } else if ("9".equalsIgnoreCase(xPNaviSearchResultInfo.mSource)) {
            xPPoiInfo.setPoiSource(10);
        }
        if (!TextUtils.isEmpty(xPNaviSearchResultInfo.mCategory)) {
            String str = xPNaviSearchResultInfo.mCategory;
            if (str.contains(XPNaviSearchParam.PARAM_CATEGORY_VALUE_CHARGE)) {
                xPPoiInfo.setCategory(108);
            } else if (str.contains("010500")) {
                xPPoiInfo.setCategory(111);
            } else if (str.contains(XPNaviSearchParam.PARAM_CATEGORY_VALUE_FOOD)) {
                xPPoiInfo.setCategory(115);
            } else if (str.contains(XPNaviSearchParam.CATEGORY_INTEGRATED_SERVER_CENTER) || str.contains(XPNaviSearchParam.CATEGORY_EXPERIENCE_CENTER) || str.contains(XPNaviSearchParam.CATEGORY_DELIVERY_CENTER) || str.contains(XPNaviSearchParam.CATEGORY_SERVER_CENTER)) {
                xPPoiInfo.setCategory(118);
            }
        }
        CarService carService = xPNaviSearchResultInfo.mCarService;
        if (carService != null) {
            XPCarServiceInfo xPCarServiceInfo = new XPCarServiceInfo();
            xPCarServiceInfo.setAutoId(xPNaviSearchResultInfo.mAutoId);
            xPCarServiceInfo.setChargeable(carService.mChargeable);
            xPCarServiceInfo.setVisible(carService.mVisible);
            xPCarServiceInfo.setStatus(carService.mStatus);
            xPCarServiceInfo.setType(carService.mType);
            if (!TextUtils.isEmpty(xPNaviSearchResultInfo.mCategory)) {
                String str2 = xPNaviSearchResultInfo.mCategory;
                if (str2.contains(XPNaviSearchParam.CATEGORY_EXPERIENCE_CENTER)) {
                    xPCarServiceInfo.setExpCenter(true);
                }
                if (str2.contains(XPNaviSearchParam.CATEGORY_DELIVERY_CENTER)) {
                    xPCarServiceInfo.setDelCenter(true);
                }
                if (str2.contains(XPNaviSearchParam.CATEGORY_SERVER_CENTER)) {
                    xPCarServiceInfo.setSerCenter(true);
                }
            }
            xPPoiInfo.setXPCarServiceInfo(xPCarServiceInfo);
        }
        xPPoiInfo.setOffline(false);
        return xPPoiInfo;
    }

    public static ArrayList<XPPoiInfo> toXPPoiInfo(List<XPNaviSearchResultInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(toXPPoiInfo(list.get(i)));
        }
        Collections.sort(arrayList, new Comparator<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.navcore.bean.search.XPNaviSearchResultInfo.1
            @Override // java.util.Comparator
            public int compare(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
                if (xPPoiInfo.getDistance() > xPPoiInfo2.getDistance()) {
                    return 1;
                }
                return xPPoiInfo.getDistance() < xPPoiInfo2.getDistance() ? -1 : 0;
            }
        });
        return arrayList;
    }
}
