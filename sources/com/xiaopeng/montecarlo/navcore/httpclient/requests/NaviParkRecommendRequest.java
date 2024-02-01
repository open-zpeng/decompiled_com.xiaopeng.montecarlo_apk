package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPNaviServerPoint;
import com.xiaopeng.montecarlo.navcore.parking.bean.DestinationBean;
/* loaded from: classes3.dex */
public class NaviParkRecommendRequest {
    @SerializedName("current_location")
    private XPNaviServerPoint mCurrentLocation;
    @SerializedName("destination")
    private DestinationBean mDestination;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviParkRecommendRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviParkRecommendRequest) {
            NaviParkRecommendRequest naviParkRecommendRequest = (NaviParkRecommendRequest) obj;
            if (naviParkRecommendRequest.canEqual(this)) {
                XPNaviServerPoint currentLocation = getCurrentLocation();
                XPNaviServerPoint currentLocation2 = naviParkRecommendRequest.getCurrentLocation();
                if (currentLocation != null ? currentLocation.equals(currentLocation2) : currentLocation2 == null) {
                    DestinationBean destination = getDestination();
                    DestinationBean destination2 = naviParkRecommendRequest.getDestination();
                    return destination != null ? destination.equals(destination2) : destination2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        XPNaviServerPoint currentLocation = getCurrentLocation();
        int hashCode = currentLocation == null ? 43 : currentLocation.hashCode();
        DestinationBean destination = getDestination();
        return ((hashCode + 59) * 59) + (destination != null ? destination.hashCode() : 43);
    }

    public NaviParkRecommendRequest setCurrentLocation(XPNaviServerPoint xPNaviServerPoint) {
        this.mCurrentLocation = xPNaviServerPoint;
        return this;
    }

    public NaviParkRecommendRequest setDestination(DestinationBean destinationBean) {
        this.mDestination = destinationBean;
        return this;
    }

    public String toString() {
        return "NaviParkRecommendRequest(mCurrentLocation=" + getCurrentLocation() + ", mDestination=" + getDestination() + ")";
    }

    public XPNaviServerPoint getCurrentLocation() {
        return this.mCurrentLocation;
    }

    public DestinationBean getDestination() {
        return this.mDestination;
    }
}
