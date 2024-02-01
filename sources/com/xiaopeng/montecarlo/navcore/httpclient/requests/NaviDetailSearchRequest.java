package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.NaviLocationInfo;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class NaviDetailSearchRequest {
    @SerializedName("current_location")
    private NaviLocationInfo mCurrentLocation;
    @SerializedName("poi_id_list")
    private List<PoiIdInfoForDetailRequest> mPoiIdList;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviDetailSearchRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviDetailSearchRequest) {
            NaviDetailSearchRequest naviDetailSearchRequest = (NaviDetailSearchRequest) obj;
            if (naviDetailSearchRequest.canEqual(this)) {
                List<PoiIdInfoForDetailRequest> poiIdList = getPoiIdList();
                List<PoiIdInfoForDetailRequest> poiIdList2 = naviDetailSearchRequest.getPoiIdList();
                if (poiIdList != null ? poiIdList.equals(poiIdList2) : poiIdList2 == null) {
                    NaviLocationInfo currentLocation = getCurrentLocation();
                    NaviLocationInfo currentLocation2 = naviDetailSearchRequest.getCurrentLocation();
                    return currentLocation != null ? currentLocation.equals(currentLocation2) : currentLocation2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<PoiIdInfoForDetailRequest> poiIdList = getPoiIdList();
        int hashCode = poiIdList == null ? 43 : poiIdList.hashCode();
        NaviLocationInfo currentLocation = getCurrentLocation();
        return ((hashCode + 59) * 59) + (currentLocation != null ? currentLocation.hashCode() : 43);
    }

    public NaviDetailSearchRequest setCurrentLocation(NaviLocationInfo naviLocationInfo) {
        this.mCurrentLocation = naviLocationInfo;
        return this;
    }

    public NaviDetailSearchRequest setPoiIdList(List<PoiIdInfoForDetailRequest> list) {
        this.mPoiIdList = list;
        return this;
    }

    public String toString() {
        return "NaviDetailSearchRequest(mPoiIdList=" + getPoiIdList() + ", mCurrentLocation=" + getCurrentLocation() + ")";
    }

    public List<PoiIdInfoForDetailRequest> getPoiIdList() {
        return this.mPoiIdList;
    }

    public NaviLocationInfo getCurrentLocation() {
        return this.mCurrentLocation;
    }

    /* loaded from: classes3.dex */
    public static class PoiIdInfoForDetailRequest {
        @SerializedName("filter")
        private Map<String, String> mFilter;
        @SerializedName(VuiConstants.ELEMENT_ID)
        private String mId;
        @SerializedName("source")
        private Integer mSource = 1;

        protected boolean canEqual(Object obj) {
            return obj instanceof PoiIdInfoForDetailRequest;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PoiIdInfoForDetailRequest) {
                PoiIdInfoForDetailRequest poiIdInfoForDetailRequest = (PoiIdInfoForDetailRequest) obj;
                if (poiIdInfoForDetailRequest.canEqual(this)) {
                    Integer source = getSource();
                    Integer source2 = poiIdInfoForDetailRequest.getSource();
                    if (source != null ? source.equals(source2) : source2 == null) {
                        String id = getId();
                        String id2 = poiIdInfoForDetailRequest.getId();
                        if (id != null ? id.equals(id2) : id2 == null) {
                            Map<String, String> filter = getFilter();
                            Map<String, String> filter2 = poiIdInfoForDetailRequest.getFilter();
                            return filter != null ? filter.equals(filter2) : filter2 == null;
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
            Integer source = getSource();
            int hashCode = source == null ? 43 : source.hashCode();
            String id = getId();
            int hashCode2 = ((hashCode + 59) * 59) + (id == null ? 43 : id.hashCode());
            Map<String, String> filter = getFilter();
            return (hashCode2 * 59) + (filter != null ? filter.hashCode() : 43);
        }

        public PoiIdInfoForDetailRequest setFilter(Map<String, String> map) {
            this.mFilter = map;
            return this;
        }

        public PoiIdInfoForDetailRequest setId(String str) {
            this.mId = str;
            return this;
        }

        public PoiIdInfoForDetailRequest setSource(Integer num) {
            this.mSource = num;
            return this;
        }

        public String toString() {
            return "NaviDetailSearchRequest.PoiIdInfoForDetailRequest(mId=" + getId() + ", mSource=" + getSource() + ", mFilter=" + getFilter() + ")";
        }

        public String getId() {
            return this.mId;
        }

        public Integer getSource() {
            return this.mSource;
        }

        public Map<String, String> getFilter() {
            return this.mFilter;
        }
    }
}
