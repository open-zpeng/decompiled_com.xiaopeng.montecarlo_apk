package com.xiaopeng.montecarlo.navcore.parking.bean;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.mapoverlay.poidetail.PoiDetailDecorator;
import com.xiaopeng.montecarlo.navcore.bean.search.XPNaviServerPoint;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.XPNaviServerPoiInfo;
import com.xiaopeng.speech.speechwidget.SpeechWidget;
import java.util.List;
/* loaded from: classes3.dex */
public class DestinationBean {
    @SerializedName("address")
    private String mAddress;
    @SerializedName("aoi")
    private XPNaviServerPoiInfo mAoi;
    @SerializedName("category")
    private String mCategory;
    @SerializedName(SpeechWidget.WIDGET_EXTRA)
    private DestinationExtraBean mExtraInfo;
    @SerializedName("location")
    private XPNaviServerPoint mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("navi_location")
    private XPNaviServerPoint mNaviLocation;
    @SerializedName(PoiDetailDecorator.SEARCH_POI_ID)
    private String mPoi;
    @SerializedName("source")
    private String mSource;
    @SerializedName("sub_pois")
    private List<XPNaviServerPoiInfo> mSubPois;
    @SerializedName("coord_type")
    private String mCoordType = "gcj02";
    @SerializedName("favorite_type")
    private int mFavoriteType = 1;

    protected boolean canEqual(Object obj) {
        return obj instanceof DestinationBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DestinationBean) {
            DestinationBean destinationBean = (DestinationBean) obj;
            if (destinationBean.canEqual(this) && getFavoriteType() == destinationBean.getFavoriteType()) {
                String poi = getPoi();
                String poi2 = destinationBean.getPoi();
                if (poi != null ? poi.equals(poi2) : poi2 == null) {
                    String name = getName();
                    String name2 = destinationBean.getName();
                    if (name != null ? name.equals(name2) : name2 == null) {
                        String address = getAddress();
                        String address2 = destinationBean.getAddress();
                        if (address != null ? address.equals(address2) : address2 == null) {
                            XPNaviServerPoint location = getLocation();
                            XPNaviServerPoint location2 = destinationBean.getLocation();
                            if (location != null ? location.equals(location2) : location2 == null) {
                                XPNaviServerPoint naviLocation = getNaviLocation();
                                XPNaviServerPoint naviLocation2 = destinationBean.getNaviLocation();
                                if (naviLocation != null ? naviLocation.equals(naviLocation2) : naviLocation2 == null) {
                                    String category = getCategory();
                                    String category2 = destinationBean.getCategory();
                                    if (category != null ? category.equals(category2) : category2 == null) {
                                        String source = getSource();
                                        String source2 = destinationBean.getSource();
                                        if (source != null ? source.equals(source2) : source2 == null) {
                                            String coordType = getCoordType();
                                            String coordType2 = destinationBean.getCoordType();
                                            if (coordType != null ? coordType.equals(coordType2) : coordType2 == null) {
                                                XPNaviServerPoiInfo aoi = getAoi();
                                                XPNaviServerPoiInfo aoi2 = destinationBean.getAoi();
                                                if (aoi != null ? aoi.equals(aoi2) : aoi2 == null) {
                                                    List<XPNaviServerPoiInfo> subPois = getSubPois();
                                                    List<XPNaviServerPoiInfo> subPois2 = destinationBean.getSubPois();
                                                    if (subPois != null ? subPois.equals(subPois2) : subPois2 == null) {
                                                        DestinationExtraBean extraInfo = getExtraInfo();
                                                        DestinationExtraBean extraInfo2 = destinationBean.getExtraInfo();
                                                        return extraInfo != null ? extraInfo.equals(extraInfo2) : extraInfo2 == null;
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
        String poi = getPoi();
        int favoriteType = ((getFavoriteType() + 59) * 59) + (poi == null ? 43 : poi.hashCode());
        String name = getName();
        int hashCode = (favoriteType * 59) + (name == null ? 43 : name.hashCode());
        String address = getAddress();
        int hashCode2 = (hashCode * 59) + (address == null ? 43 : address.hashCode());
        XPNaviServerPoint location = getLocation();
        int hashCode3 = (hashCode2 * 59) + (location == null ? 43 : location.hashCode());
        XPNaviServerPoint naviLocation = getNaviLocation();
        int hashCode4 = (hashCode3 * 59) + (naviLocation == null ? 43 : naviLocation.hashCode());
        String category = getCategory();
        int hashCode5 = (hashCode4 * 59) + (category == null ? 43 : category.hashCode());
        String source = getSource();
        int hashCode6 = (hashCode5 * 59) + (source == null ? 43 : source.hashCode());
        String coordType = getCoordType();
        int hashCode7 = (hashCode6 * 59) + (coordType == null ? 43 : coordType.hashCode());
        XPNaviServerPoiInfo aoi = getAoi();
        int hashCode8 = (hashCode7 * 59) + (aoi == null ? 43 : aoi.hashCode());
        List<XPNaviServerPoiInfo> subPois = getSubPois();
        int hashCode9 = (hashCode8 * 59) + (subPois == null ? 43 : subPois.hashCode());
        DestinationExtraBean extraInfo = getExtraInfo();
        return (hashCode9 * 59) + (extraInfo != null ? extraInfo.hashCode() : 43);
    }

    public DestinationBean setAddress(String str) {
        this.mAddress = str;
        return this;
    }

    public DestinationBean setAoi(XPNaviServerPoiInfo xPNaviServerPoiInfo) {
        this.mAoi = xPNaviServerPoiInfo;
        return this;
    }

    public DestinationBean setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public DestinationBean setCoordType(String str) {
        this.mCoordType = str;
        return this;
    }

    public DestinationBean setExtraInfo(DestinationExtraBean destinationExtraBean) {
        this.mExtraInfo = destinationExtraBean;
        return this;
    }

    public DestinationBean setFavoriteType(int i) {
        this.mFavoriteType = i;
        return this;
    }

    public DestinationBean setLocation(XPNaviServerPoint xPNaviServerPoint) {
        this.mLocation = xPNaviServerPoint;
        return this;
    }

    public DestinationBean setName(String str) {
        this.mName = str;
        return this;
    }

    public DestinationBean setNaviLocation(XPNaviServerPoint xPNaviServerPoint) {
        this.mNaviLocation = xPNaviServerPoint;
        return this;
    }

    public DestinationBean setPoi(String str) {
        this.mPoi = str;
        return this;
    }

    public DestinationBean setSource(String str) {
        this.mSource = str;
        return this;
    }

    public DestinationBean setSubPois(List<XPNaviServerPoiInfo> list) {
        this.mSubPois = list;
        return this;
    }

    public String toString() {
        return "DestinationBean(mPoi=" + getPoi() + ", mName=" + getName() + ", mAddress=" + getAddress() + ", mLocation=" + getLocation() + ", mNaviLocation=" + getNaviLocation() + ", mCategory=" + getCategory() + ", mSource=" + getSource() + ", mCoordType=" + getCoordType() + ", mFavoriteType=" + getFavoriteType() + ", mAoi=" + getAoi() + ", mSubPois=" + getSubPois() + ", mExtraInfo=" + getExtraInfo() + ")";
    }

    public String getPoi() {
        return this.mPoi;
    }

    public String getName() {
        return this.mName;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public XPNaviServerPoint getLocation() {
        return this.mLocation;
    }

    public XPNaviServerPoint getNaviLocation() {
        return this.mNaviLocation;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getSource() {
        return this.mSource;
    }

    public String getCoordType() {
        return this.mCoordType;
    }

    public int getFavoriteType() {
        return this.mFavoriteType;
    }

    public XPNaviServerPoiInfo getAoi() {
        return this.mAoi;
    }

    public List<XPNaviServerPoiInfo> getSubPois() {
        return this.mSubPois;
    }

    public DestinationExtraBean getExtraInfo() {
        return this.mExtraInfo;
    }
}
