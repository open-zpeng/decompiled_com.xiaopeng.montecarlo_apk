package com.xiaopeng.montecarlo.navcore.location;

import android.location.Location;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.model.BizLayerUtil;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCoord3DDouble;
import com.xiaopeng.montecarlo.root.util.L;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class LocationUtils {
    public static final int DR_RECORD_A3D_FIElD_NUM = 6;
    public static final String DR_RECORD_DATA_SPLIT_CHAR = ";";
    public static final int DR_RECORD_GNSS_FIElD_NUM = 19;
    public static final int DR_RECORD_GSV_FIElD_NUM = 5;
    public static final int DR_RECORD_GYRO_FIElD_NUM = 7;
    public static final int DR_RECORD_PULSE_FIElD_NUM = 4;
    public static final String DR_RECORD_TAG_DATA_TYPE = "dataType";
    public static final String DR_RECORD_TAG_DATA_TYPE_CARSERVICE = "car";
    public static final String DR_RECORD_TAG_DATA_TYPE_CARSERVICE_HEADER = "dataType:car";
    public static final String DR_RECORD_VALUE_SPLIT_CHAR = ":";
    private static final double EARTH_RADIUS = 6378.137d;
    public static final String DR_RECORD_TIMETICK_SPLIT_CHAR = "|";
    public static final String DR_RECORD_TIMETICK_SPLIT_REG_CHAR = Pattern.quote(DR_RECORD_TIMETICK_SPLIT_CHAR);
    private static final L.Tag TAG = new L.Tag("LocationUtils");

    private static double rad(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static String locationToLogString(Location location) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + DR_RECORD_DATA_SPLIT_CHAR + location.getProvider() + DR_RECORD_DATA_SPLIT_CHAR + location.getTime() + DR_RECORD_DATA_SPLIT_CHAR + location.getElapsedRealtimeNanos() + DR_RECORD_DATA_SPLIT_CHAR + location.getLatitude() + DR_RECORD_DATA_SPLIT_CHAR + location.getLongitude() + DR_RECORD_DATA_SPLIT_CHAR + location.getAltitude() + DR_RECORD_DATA_SPLIT_CHAR + location.getSpeed() + DR_RECORD_DATA_SPLIT_CHAR + location.getBearing() + DR_RECORD_DATA_SPLIT_CHAR + location.getAccuracy();
    }

    public static String latLonToLogString(@Nullable Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
        sb.append(FDManager.LINE_SEPERATOR);
        if (location != null) {
            sb.append("real GPS: ");
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append(location.getLongitude());
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append(location.getLatitude());
            sb.append(FDManager.LINE_SEPERATOR);
        }
        Coord3DDouble encryptLonLat = TBTManager.getInstance().getPosServiceWrapper().encryptLonLat(location);
        if (encryptLonLat != null) {
            sb.append("encrypt GPS: ");
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append(encryptLonLat.lon);
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append(encryptLonLat.lat);
        }
        return sb.toString();
    }

    public static String latLonToLogString(@Nullable XPLocation xPLocation) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
        sb.append(FDManager.LINE_SEPERATOR);
        if (xPLocation.getLocation() != null) {
            if (xPLocation.isTypeWGS84()) {
                return latLonToLogString(xPLocation.getLocation());
            }
            sb.append("encrypt GPS: ");
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append(xPLocation.getLocation().getLongitude());
            sb.append(FDManager.LINE_SEPERATOR);
            sb.append(xPLocation.getLocation().getLatitude());
            sb.append(FDManager.LINE_SEPERATOR);
        }
        return sb.toString();
    }

    public static Location logStringToLocation(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Location location = new Location("gps");
        String[] split = str.split(DR_RECORD_DATA_SPLIT_CHAR);
        location.setProvider(split[1]);
        location.setTime(Long.parseLong(split[2]));
        location.setElapsedRealtimeNanos(Long.parseLong(split[3]));
        location.setLatitude(Double.parseDouble(split[4]));
        location.setLongitude(Double.parseDouble(split[5]));
        location.setAltitude(Double.parseDouble(split[6]));
        location.setSpeed(Float.parseFloat(split[7]));
        location.setBearing(Float.parseFloat(split[8]));
        location.setAccuracy(Float.parseFloat(split[9]));
        return location;
    }

    public static double getDistance(XPCoordinate2DDouble xPCoordinate2DDouble, XPCoordinate2DDouble xPCoordinate2DDouble2) {
        return BizLayerUtil.calcDistanceBetweenPoints(new Coord2DDouble(xPCoordinate2DDouble.mLon, xPCoordinate2DDouble.mLat), new Coord2DDouble(xPCoordinate2DDouble2.mLon, xPCoordinate2DDouble2.mLat));
    }

    public static double getDistance(@Nullable Location location, @Nullable Location location2) {
        if (location == null || location2 == null) {
            return 0.0d;
        }
        return getDistance(new XPCoordinate2DDouble(location.getLongitude(), location.getLatitude()), new XPCoordinate2DDouble(location2.getLongitude(), location2.getLatitude()));
    }

    public static double getDistance(@Nullable XPPoiInfo xPPoiInfo, @Nullable XPPoiInfo xPPoiInfo2) {
        if (xPPoiInfo == null || xPPoiInfo2 == null) {
            return 0.0d;
        }
        return getDistance(new XPCoordinate2DDouble(xPPoiInfo), new XPCoordinate2DDouble(xPPoiInfo2));
    }

    public static double getDistance(@Nullable XPCoord3DDouble xPCoord3DDouble, @Nullable XPCoord3DDouble xPCoord3DDouble2) {
        if (xPCoord3DDouble == null || xPCoord3DDouble2 == null) {
            return 0.0d;
        }
        return getDistance(new XPCoordinate2DDouble(xPCoord3DDouble), new XPCoordinate2DDouble(xPCoord3DDouble2));
    }

    public static double getDistanceByNavi(@Nullable XPPoiInfo xPPoiInfo, @Nullable XPPoiInfo xPPoiInfo2) {
        if (xPPoiInfo == null || xPPoiInfo2 == null) {
            return 0.0d;
        }
        XPCoordinate2DDouble naviPoint = xPPoiInfo.getNaviPoint(true);
        XPCoordinate2DDouble naviPoint2 = xPPoiInfo2.getNaviPoint(false);
        return BizLayerUtil.calcDistanceBetweenPoints(new Coord2DDouble(naviPoint.mLon, naviPoint.mLat), new Coord2DDouble(naviPoint2.mLon, naviPoint2.mLat));
    }

    public static double getDistanceFromCurrentPos(XPCoordinate2DDouble xPCoordinate2DDouble) {
        return getDistance(new XPCoordinate2DDouble(TBTManager.getInstance().getStartPOIFromCurrent()), xPCoordinate2DDouble);
    }

    public static double getLinearDistance(RouteParams routeParams) {
        if (routeParams == null) {
            return 0.0d;
        }
        return getDistanceFromCurrentPos(new XPCoordinate2DDouble(routeParams.mEndInfo));
    }

    public static Map.Entry<Long, String> logStringToDRRecord(String str) {
        String[] split = str.split(DR_RECORD_TIMETICK_SPLIT_REG_CHAR);
        try {
            return new DRRecordEntry(Long.valueOf(Long.parseLong(split[0])), split[1]);
        } catch (Exception e) {
            for (String str2 : split) {
                L.i(TAG, str2);
            }
            L.w(TAG, e.getMessage());
            return null;
        }
    }
}
