package com.xiaopeng.montecarlo.navcore.parking;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class RequestConstant {
    public static final String COORD_TYPE_BD09LL = "bd09ll";
    public static final String COORD_TYPE_GCJ02 = "gcj02";
    public static final String COORD_TYPE_WGS84 = "wgs84";
    public static final int FAVORITE_TYPE_COMPANY = 3;
    public static final int FAVORITE_TYPE_HOME = 2;
    public static final int FAVORITE_TYPE_NORMAL = 1;
    public static final int FAVORITE_TYPE_OTHER = 4;
    public static final int LinkTypeBridge = 3;
    public static final int LinkTypeCommon = 0;
    public static final int LinkTypeCount = 5;
    public static final int LinkTypeElevatedRd = 4;
    public static final int LinkTypeFerry = 1;
    public static final int LinkTypeNull = -1;
    public static final int LinkTypeTunnel = 2;
    public static final int POI_CATEGORY_CAR_WASHER = 110;
    public static final int POI_CATEGORY_CHARGING_STATION = 103;
    public static final int POI_CATEGORY_CITY_NAME = 106;
    public static final int POI_CATEGORY_CP_CHARGE = 108;
    public static final int POI_CATEGORY_FILL_STATION = 102;
    public static final int POI_CATEGORY_GROUP_CHARGE = 109;
    public static final int POI_CATEGORY_PARK = 101;
    public static final int POI_CATEGORY_SERVICE_AREA = 104;
    public static final int POI_CATEGORY_TOLL_GATE = 105;
    public static final int POI_CATEGORY_UNKNOWN = 100;
    public static final int POI_CATEGORY_XP_CHARGE = 107;
    public static final int VENDOR_TYPE_4S = 8;
    public static final int VENDOR_TYPE_BAIDU = 4;
    public static final int VENDOR_TYPE_BL = 2;
    public static final int VENDOR_TYPE_CAR_WASH = 7;
    public static final int VENDOR_TYPE_OTHER = 1;
    public static final int VENDOR_TYPE_RGC = 5;
    public static final int VENDOR_TYPE_WECHAT = 3;
    public static final int VENDOR_TYPE_XP_CHARGE = 6;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface CoordType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface FavoriteType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LinkType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface PoiCategory {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface VendorSourceType {
    }
}
