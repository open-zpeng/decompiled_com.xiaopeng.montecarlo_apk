package com.xiaopeng.montecarlo.navcore.bean.search;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class XPPoiCategory {
    public static final int AFTER_SALE_CENTER = 113;
    private static final String BL_CATEGORY_CAR_SERVICE = ";010000;020000;030000";
    private static final String BL_CATEGORY_CHARGING_STATION = ";011100;";
    private static final String BL_CATEGORY_CITY_NAME = ";190100;190101;190102;190103;190104;";
    private static final String BL_CATEGORY_FILL_STATION = ";010100;010101;010102;010103;010104;010105;010107;010108;010109;010110;010111;010112;";
    private static final String BL_CATEGORY_FOOD_PREFIX = "050";
    public static final String BL_CATEGORY_INVALID = "000000";
    private static final String BL_CATEGORY_PARK = ";150900;150903;150904;150905;150906;150907;150908;150909;41;";
    public static final String BL_CATEGORY_PLACE_NAME = ";190000;190100;190101;190102;190103;190104;190105;190106;190107;190108;190109;";
    private static final String BL_CATEGORY_RESIDENTIAL_PREFIX = "1203";
    private static final String BL_CATEGORY_SERVICE_AREA = ";180300;180301;180302;";
    private static final String BL_CATEGORY_TOLL_GATE = ";180200;180201;180202;180203;";
    public static final int CAR_WASHER = 111;
    public static final int CHARGING_STATION = 103;
    public static final int CITY_NAME = 106;
    public static final int CP_CHARGE = 108;
    public static final int FILL_STATION = 102;
    public static final int FOOD = 115;
    public static final int GROUP_CHARGE = 109;
    public static final int PARK = 101;
    public static final int RESIDENTIAL = 112;
    public static final String SEARCH_CATEGORY_CARWASH = "010500";
    public static final String SEARCH_CATEGORY_CHARGE = "0111";
    public static final String SEARCH_CATEGORY_FIXSHOP = "03";
    public static final String SEARCH_CATEGORY_FIXSHOP_OFFLINE = "30000";
    public static final String SEARCH_CATEGORY_FOOD = "05";
    public static final String SEARCH_CATEGORY_PARK = "1509";
    public static final String SEARCH_CATEGORY_WC = "200300";
    public static final int SERVICE_AREA = 104;
    public static final int SOCIAL_TEAM_TRIP = 114;
    private static final L.Tag TAG = new L.Tag("XPPoiCategory");
    public static final int TOLL_GATE = 105;
    public static final int UNKNOWN = 100;
    public static final int XP_CAR_WASHER = 110;
    public static final int XP_CHARGE = 107;
    public static final int XP_COOPERATE_CHARGE = 117;
    public static final int XP_INTEGRATED_SERVICE_CENTER = 118;
    public static final int XP_JOIN_CHARGE = 116;
    public static final int XP_SCRATCH_SPOT = 119;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Category {
    }

    public static boolean isBLCharge(int i) {
        return i == 103;
    }

    public static boolean isCarWasher(int i) {
        return i == 111;
    }

    public static boolean isCharge(int i) {
        return i == 103 || i == 108 || i == 107 || i == 116 || i == 117;
    }

    public static boolean isCityName(int i) {
        return i == 106;
    }

    public static boolean isCommonCharge(int i) {
        return i == 108;
    }

    public static boolean isParking(int i) {
        return i == 101;
    }

    private static boolean isPetrolStation(int i) {
        return i == 102;
    }

    private static boolean isResidential(int i) {
        return i == 112;
    }

    private static boolean isServiceArea(int i) {
        return i == 104;
    }

    private static boolean isTollStation(int i) {
        return i == 105;
    }

    public static boolean isXPCooperateCharge(int i) {
        return i == 117;
    }

    public static boolean isXPJoinCharge(int i) {
        return i == 116;
    }

    public static boolean isXPSelfCharge(int i) {
        return i == 107;
    }

    public static int transformCategory(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            L.w(TAG, "transformCategory categoryCode:" + str);
            return 100;
        }
        if (str.contains(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR)) {
            str = str.split("\\|")[0];
        }
        String str2 = LocationUtils.DR_RECORD_DATA_SPLIT_CHAR + str + LocationUtils.DR_RECORD_DATA_SPLIT_CHAR;
        if (BL_CATEGORY_PARK.contains(str2)) {
            return 101;
        }
        if (BL_CATEGORY_FILL_STATION.contains(str2)) {
            return 102;
        }
        if (BL_CATEGORY_CHARGING_STATION.contains(str2)) {
            return 103;
        }
        if (BL_CATEGORY_SERVICE_AREA.contains(str2)) {
            return 104;
        }
        if (BL_CATEGORY_TOLL_GATE.contains(str2)) {
            return 105;
        }
        if (BL_CATEGORY_CITY_NAME.contains(str2)) {
            return 106;
        }
        if (str2.contains(BL_CATEGORY_RESIDENTIAL_PREFIX)) {
            return 112;
        }
        return str2.contains(BL_CATEGORY_FOOD_PREFIX) ? 115 : 100;
    }

    public static boolean isRecommendParking(int i) {
        return (isParking(i) || isServiceArea(i) || isPetrolStation(i) || isCharge(i) || isTollStation(i) || isResidential(i)) ? false : true;
    }

    public static boolean isBLCarService(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return BL_CATEGORY_CAR_SERVICE.contains(str);
    }

    public static boolean isValidBLPoi(String str) {
        return (TextUtils.isEmpty(str) || BL_CATEGORY_INVALID.equalsIgnoreCase(str)) ? false : true;
    }
}
