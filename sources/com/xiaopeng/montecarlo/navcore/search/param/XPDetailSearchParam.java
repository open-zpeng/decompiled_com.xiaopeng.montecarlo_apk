package com.xiaopeng.montecarlo.navcore.search.param;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.bean.search.XPNaviServerPoint;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
/* loaded from: classes2.dex */
public class XPDetailSearchParam {
    @SerializedName("current_location")
    private XPNaviServerPoint mCurrentLocation;
    @SerializedName("poi_id_list")
    private List<PoiIdParam> mPoiIdList;

    protected boolean canEqual(Object obj) {
        return obj instanceof XPDetailSearchParam;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XPDetailSearchParam) {
            XPDetailSearchParam xPDetailSearchParam = (XPDetailSearchParam) obj;
            if (xPDetailSearchParam.canEqual(this)) {
                List<PoiIdParam> poiIdList = getPoiIdList();
                List<PoiIdParam> poiIdList2 = xPDetailSearchParam.getPoiIdList();
                if (poiIdList != null ? poiIdList.equals(poiIdList2) : poiIdList2 == null) {
                    XPNaviServerPoint currentLocation = getCurrentLocation();
                    XPNaviServerPoint currentLocation2 = xPDetailSearchParam.getCurrentLocation();
                    return currentLocation != null ? currentLocation.equals(currentLocation2) : currentLocation2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<PoiIdParam> poiIdList = getPoiIdList();
        int hashCode = poiIdList == null ? 43 : poiIdList.hashCode();
        XPNaviServerPoint currentLocation = getCurrentLocation();
        return ((hashCode + 59) * 59) + (currentLocation != null ? currentLocation.hashCode() : 43);
    }

    public void setCurrentLocation(XPNaviServerPoint xPNaviServerPoint) {
        this.mCurrentLocation = xPNaviServerPoint;
    }

    public void setPoiIdList(List<PoiIdParam> list) {
        this.mPoiIdList = list;
    }

    public String toString() {
        return "XPDetailSearchParam(mPoiIdList=" + getPoiIdList() + ", mCurrentLocation=" + getCurrentLocation() + ")";
    }

    public List<PoiIdParam> getPoiIdList() {
        return this.mPoiIdList;
    }

    public XPNaviServerPoint getCurrentLocation() {
        return this.mCurrentLocation;
    }

    /* loaded from: classes2.dex */
    public static class PoiIdParam {
        @SerializedName(VuiConstants.ELEMENT_ID)
        private String mId;
        @SerializedName("source")
        private int mSource = 1;

        protected boolean canEqual(Object obj) {
            return obj instanceof PoiIdParam;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PoiIdParam) {
                PoiIdParam poiIdParam = (PoiIdParam) obj;
                if (poiIdParam.canEqual(this) && getSource() == poiIdParam.getSource()) {
                    String id = getId();
                    String id2 = poiIdParam.getId();
                    return id != null ? id.equals(id2) : id2 == null;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String id = getId();
            return ((getSource() + 59) * 59) + (id == null ? 43 : id.hashCode());
        }

        public void setId(String str) {
            this.mId = str;
        }

        public void setSource(int i) {
            this.mSource = i;
        }

        public String toString() {
            return "XPDetailSearchParam.PoiIdParam(mId=" + getId() + ", mSource=" + getSource() + ")";
        }

        public String getId() {
            return this.mId;
        }

        public int getSource() {
            return this.mSource;
        }

        public PoiIdParam(String str) {
            this.mId = str;
        }
    }
}
