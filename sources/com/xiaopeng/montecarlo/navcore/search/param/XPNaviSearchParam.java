package com.xiaopeng.montecarlo.navcore.search.param;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class XPNaviSearchParam implements Parcelable {
    public static final String CATEGORY_DELIVERY_CENTER = "1000102";
    public static final String CATEGORY_EXPERIENCE_CENTER = "1000101";
    public static final String CATEGORY_INTEGRATED_SERVER_CENTER = "1000100";
    public static final String CATEGORY_SERVER_CENTER = "1000103";
    public static final Parcelable.Creator<XPNaviSearchParam> CREATOR = new Parcelable.Creator<XPNaviSearchParam>() { // from class: com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPNaviSearchParam createFromParcel(Parcel parcel) {
            return new XPNaviSearchParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XPNaviSearchParam[] newArray(int i) {
            return new XPNaviSearchParam[i];
        }
    };
    public static final String PARAM_CATEGORY = "category";
    public static final String PARAM_CATEGORY_VALUE_CARWASH = "010500";
    public static final String PARAM_CATEGORY_VALUE_CHARGE = "011100";
    public static final String PARAM_CATEGORY_VALUE_FOOD = "050000";
    public static final String PARAM_LOCATION = "location";
    public static final String PARAM_PAGE = "page";
    public static final String PARAM_PATH = "path";
    public static final String PARAM_QUERY = "query";
    public static final String PARAM_RADIUS = "radius";
    public static final String PARAM_REMAININGMILEAGE = "remainingMileage";
    public static final String PARAM_SIZE = "size";
    public static final String PARAM_TYPE = "type";
    public static final String PARAM_TYPE_VALUE_ALONGWAY = "200";
    public static final String PARAM_TYPE_VALUE_AOI = "300";
    public static final String PARAM_TYPE_VALUE_AROUND = "100";
    private String mCategory;
    private int mPage;
    private List<String> mPath;
    private XPCoordinate2DDouble mPoiLocation;
    private String mQuery;
    private int mRadius;
    private int mRemainDistance;
    private int mSize;
    private String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCategory);
        parcel.writeString(this.mType);
        parcel.writeParcelable(this.mPoiLocation, i);
        parcel.writeString(this.mQuery);
        parcel.writeStringList(this.mPath);
        parcel.writeInt(this.mRadius);
        parcel.writeInt(this.mRemainDistance);
        parcel.writeInt(this.mSize);
        parcel.writeInt(this.mPage);
    }

    public XPNaviSearchParam() {
        this.mRadius = 3000;
        this.mSize = 20;
        this.mPage = 1;
    }

    protected XPNaviSearchParam(Parcel parcel) {
        this.mRadius = 3000;
        this.mSize = 20;
        this.mPage = 1;
        this.mCategory = parcel.readString();
        this.mType = parcel.readString();
        this.mPoiLocation = (XPCoordinate2DDouble) parcel.readParcelable(XPCoordinate2DDouble.class.getClassLoader());
        this.mQuery = parcel.readString();
        this.mPath = parcel.createStringArrayList();
        this.mRadius = parcel.readInt();
        this.mRemainDistance = parcel.readInt();
        this.mSize = parcel.readInt();
        this.mPage = parcel.readInt();
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public XPCoordinate2DDouble getPoiLocation() {
        return this.mPoiLocation;
    }

    public void setPoiLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mPoiLocation = xPCoordinate2DDouble;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public void setQuery(String str) {
        this.mQuery = str;
    }

    public List<String> getPath() {
        return this.mPath;
    }

    public void setPath(List<String> list) {
        this.mPath = list;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setRadius(int i) {
        this.mRadius = i;
    }

    public int getRemainDistance() {
        return this.mRemainDistance;
    }

    public void setRemainDistance(int i) {
        this.mRemainDistance = i;
    }

    public int getSize() {
        return this.mSize;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public int getPage() {
        return this.mPage;
    }

    public void setPage(int i) {
        this.mPage = i;
    }

    public void nextPage() {
        this.mPage++;
    }

    public void obtainPath() {
        this.mPath = new ArrayList();
        List<XPCoordinate2DDouble> currentRoutePoints = TBTManager.getInstance().getCurrentRoutePoints();
        if (CollectionUtils.isNotEmpty(currentRoutePoints)) {
            DecimalFormat decimalFormat = new DecimalFormat("#.000000");
            int size = currentRoutePoints.size() < 16 ? currentRoutePoints.size() : 16;
            for (int i = 0; i < size; i++) {
                List<String> list = this.mPath;
                list.add(decimalFormat.format(currentRoutePoints.get(i).mLon) + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + decimalFormat.format(currentRoutePoints.get(i).mLat));
            }
            XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
            if (endInfo == null || endInfo.getDisplayLon() <= 0.0d || endInfo.getDisplayLat() <= 0.0d) {
                return;
            }
            List<String> list2 = this.mPath;
            list2.add(decimalFormat.format(endInfo.getDisplayLon()) + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + decimalFormat.format(endInfo.getDisplayLat()));
        }
    }

    public Map<String, Object> toParamMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", getCategory());
        hashMap.put("type", getType());
        if (getPoiLocation() != null) {
            hashMap.put("location", getPoiLocation().mLon + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + getPoiLocation().mLat);
        }
        hashMap.put("query", getQuery());
        if (PARAM_TYPE_VALUE_ALONGWAY.equalsIgnoreCase(getType()) && CollectionUtils.isNotEmpty(getPath())) {
            hashMap.put("path", getPath());
        }
        hashMap.put("radius", Integer.valueOf(getRadius()));
        if (getRemainDistance() > 1000) {
            hashMap.put(PARAM_REMAININGMILEAGE, Integer.valueOf(getRemainDistance() / 1000));
        }
        hashMap.put("size", Integer.valueOf(getSize()));
        hashMap.put(PARAM_PAGE, Integer.valueOf(getPage()));
        return hashMap;
    }

    public boolean is4SCategory() {
        return CATEGORY_EXPERIENCE_CENTER.equalsIgnoreCase(this.mCategory) || CATEGORY_DELIVERY_CENTER.equalsIgnoreCase(this.mCategory) || CATEGORY_SERVER_CENTER.equalsIgnoreCase(this.mCategory) || CATEGORY_INTEGRATED_SERVER_CENTER.equalsIgnoreCase(this.mCategory);
    }
}
