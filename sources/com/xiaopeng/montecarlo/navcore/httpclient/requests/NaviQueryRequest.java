package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class NaviQueryRequest {
    @SerializedName("aoi_info")
    private NaviQueryAoiInfo mAoiInfo;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("filter")
    private Map<String, String> mFilter;
    @SerializedName("location")
    private String mLocation;
    @SerializedName(XPNaviSearchParam.PARAM_PAGE)
    private int mPage;
    @SerializedName("path")
    private List<String> mPath;
    @SerializedName("query")
    private String mQuery;
    @SerializedName("radius")
    private int mRadius;
    @SerializedName(XPNaviSearchParam.PARAM_REMAININGMILEAGE)
    private int mRemainingMileage;
    @SerializedName("size")
    private int mSize;
    @SerializedName("type")
    private int mType;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviQueryRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviQueryRequest) {
            NaviQueryRequest naviQueryRequest = (NaviQueryRequest) obj;
            if (naviQueryRequest.canEqual(this) && getType() == naviQueryRequest.getType() && getRadius() == naviQueryRequest.getRadius() && getRemainingMileage() == naviQueryRequest.getRemainingMileage() && getSize() == naviQueryRequest.getSize() && getPage() == naviQueryRequest.getPage()) {
                String category = getCategory();
                String category2 = naviQueryRequest.getCategory();
                if (category != null ? category.equals(category2) : category2 == null) {
                    String location = getLocation();
                    String location2 = naviQueryRequest.getLocation();
                    if (location != null ? location.equals(location2) : location2 == null) {
                        String query = getQuery();
                        String query2 = naviQueryRequest.getQuery();
                        if (query != null ? query.equals(query2) : query2 == null) {
                            NaviQueryAoiInfo aoiInfo = getAoiInfo();
                            NaviQueryAoiInfo aoiInfo2 = naviQueryRequest.getAoiInfo();
                            if (aoiInfo != null ? aoiInfo.equals(aoiInfo2) : aoiInfo2 == null) {
                                List<String> path = getPath();
                                List<String> path2 = naviQueryRequest.getPath();
                                if (path != null ? path.equals(path2) : path2 == null) {
                                    Map<String, String> filter = getFilter();
                                    Map<String, String> filter2 = naviQueryRequest.getFilter();
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
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int type = ((((((((getType() + 59) * 59) + getRadius()) * 59) + getRemainingMileage()) * 59) + getSize()) * 59) + getPage();
        String category = getCategory();
        int hashCode = (type * 59) + (category == null ? 43 : category.hashCode());
        String location = getLocation();
        int hashCode2 = (hashCode * 59) + (location == null ? 43 : location.hashCode());
        String query = getQuery();
        int hashCode3 = (hashCode2 * 59) + (query == null ? 43 : query.hashCode());
        NaviQueryAoiInfo aoiInfo = getAoiInfo();
        int hashCode4 = (hashCode3 * 59) + (aoiInfo == null ? 43 : aoiInfo.hashCode());
        List<String> path = getPath();
        int hashCode5 = (hashCode4 * 59) + (path == null ? 43 : path.hashCode());
        Map<String, String> filter = getFilter();
        return (hashCode5 * 59) + (filter != null ? filter.hashCode() : 43);
    }

    public NaviQueryRequest setAoiInfo(NaviQueryAoiInfo naviQueryAoiInfo) {
        this.mAoiInfo = naviQueryAoiInfo;
        return this;
    }

    public NaviQueryRequest setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public NaviQueryRequest setFilter(Map<String, String> map) {
        this.mFilter = map;
        return this;
    }

    public NaviQueryRequest setLocation(String str) {
        this.mLocation = str;
        return this;
    }

    public NaviQueryRequest setPage(int i) {
        this.mPage = i;
        return this;
    }

    public NaviQueryRequest setPath(List<String> list) {
        this.mPath = list;
        return this;
    }

    public NaviQueryRequest setQuery(String str) {
        this.mQuery = str;
        return this;
    }

    public NaviQueryRequest setRadius(int i) {
        this.mRadius = i;
        return this;
    }

    public NaviQueryRequest setRemainingMileage(int i) {
        this.mRemainingMileage = i;
        return this;
    }

    public NaviQueryRequest setSize(int i) {
        this.mSize = i;
        return this;
    }

    public NaviQueryRequest setType(int i) {
        this.mType = i;
        return this;
    }

    public String toString() {
        return "NaviQueryRequest(mCategory=" + getCategory() + ", mType=" + getType() + ", mLocation=" + getLocation() + ", mQuery=" + getQuery() + ", mAoiInfo=" + getAoiInfo() + ", mPath=" + getPath() + ", mRadius=" + getRadius() + ", mRemainingMileage=" + getRemainingMileage() + ", mSize=" + getSize() + ", mPage=" + getPage() + ", mFilter=" + getFilter() + ")";
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int getType() {
        return this.mType;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public NaviQueryAoiInfo getAoiInfo() {
        return this.mAoiInfo;
    }

    public List<String> getPath() {
        return this.mPath;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public int getRemainingMileage() {
        return this.mRemainingMileage;
    }

    public int getSize() {
        return this.mSize;
    }

    public int getPage() {
        return this.mPage;
    }

    public Map<String, String> getFilter() {
        return this.mFilter;
    }

    /* loaded from: classes2.dex */
    public static class NaviQueryAoiInfo {
        @SerializedName("aoi_id")
        private String mAoiId;
        @SerializedName("category")
        private String mCategory;
        @SerializedName(CPSearchParam.PARAM_KEY_LAT)
        private double mLat;
        @SerializedName(CPSearchParam.PARAM_KEY_LON)
        private double mLon;
        @SerializedName("name")
        private String mName;

        protected boolean canEqual(Object obj) {
            return obj instanceof NaviQueryAoiInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof NaviQueryAoiInfo) {
                NaviQueryAoiInfo naviQueryAoiInfo = (NaviQueryAoiInfo) obj;
                if (naviQueryAoiInfo.canEqual(this) && Double.compare(getLat(), naviQueryAoiInfo.getLat()) == 0 && Double.compare(getLon(), naviQueryAoiInfo.getLon()) == 0) {
                    String aoiId = getAoiId();
                    String aoiId2 = naviQueryAoiInfo.getAoiId();
                    if (aoiId != null ? aoiId.equals(aoiId2) : aoiId2 == null) {
                        String name = getName();
                        String name2 = naviQueryAoiInfo.getName();
                        if (name != null ? name.equals(name2) : name2 == null) {
                            String category = getCategory();
                            String category2 = naviQueryAoiInfo.getCategory();
                            return category != null ? category.equals(category2) : category2 == null;
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
            long doubleToLongBits = Double.doubleToLongBits(getLat());
            long doubleToLongBits2 = Double.doubleToLongBits(getLon());
            String aoiId = getAoiId();
            int hashCode = ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2))) * 59) + (aoiId == null ? 43 : aoiId.hashCode());
            String name = getName();
            int hashCode2 = (hashCode * 59) + (name == null ? 43 : name.hashCode());
            String category = getCategory();
            return (hashCode2 * 59) + (category != null ? category.hashCode() : 43);
        }

        public NaviQueryAoiInfo setAoiId(String str) {
            this.mAoiId = str;
            return this;
        }

        public NaviQueryAoiInfo setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public NaviQueryAoiInfo setLat(double d) {
            this.mLat = d;
            return this;
        }

        public NaviQueryAoiInfo setLon(double d) {
            this.mLon = d;
            return this;
        }

        public NaviQueryAoiInfo setName(String str) {
            this.mName = str;
            return this;
        }

        public String toString() {
            return "NaviQueryRequest.NaviQueryAoiInfo(mAoiId=" + getAoiId() + ", mLat=" + getLat() + ", mLon=" + getLon() + ", mName=" + getName() + ", mCategory=" + getCategory() + ")";
        }

        public String getAoiId() {
            return this.mAoiId;
        }

        public double getLat() {
            return this.mLat;
        }

        public double getLon() {
            return this.mLon;
        }

        public String getName() {
            return this.mName;
        }

        public String getCategory() {
            return this.mCategory;
        }
    }
}
