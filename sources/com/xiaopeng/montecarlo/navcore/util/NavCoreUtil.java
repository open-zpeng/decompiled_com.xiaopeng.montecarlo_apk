package com.xiaopeng.montecarlo.navcore.util;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.data.model.MapDataAction;
import com.autonavi.gbl.layer.model.BizAGroupBusinessInfo;
import com.autonavi.gbl.layer.model.BizSearchType;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.PointLayerItem;
import com.autonavi.gbl.pos.PosService;
import com.autonavi.gbl.util.BlToolPoiID;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.route.RouteDetailInfo;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.event.SearchResponseEvent;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.search.XPSearchResult;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfoPanel;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.speech.protocol.node.navi.bean.RouteSelectBean;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NavCoreUtil {
    private static final int BETWEEN_1KM_AND_100KM_INTEGRE = 2;
    private static final int BETWEEN_1KM_AND_100KM_REMAINER = 3;
    private static final double BL_DOUBLE_TRANSFORM_VALUE = 3600000.0d;
    public static final long BL_LOG_MAX_FILES_NUM = 200;
    public static final long BL_LOG_MAX_FILE_SIZE = 20971520;
    @VisibleForTesting
    protected static final int DISTANCE_FORMAT_TYPE_BIG_NUM = 4;
    @VisibleForTesting
    protected static final int DISTANCE_FORMAT_TYPE_HEADER_ABOUT = 1;
    @VisibleForTesting
    protected static final int DISTANCE_FORMAT_TYPE_NO_HEADER = 2;
    @VisibleForTesting
    protected static final int DISTANCE_FORMAT_TYPE_NO_HEADER_ARRAY = 3;
    @VisibleForTesting
    protected static final int DISTANCE_FORMAT_TYPE_NO_SPACE = 5;
    public static final int DISTANCE_RANGE = 200000;
    @VisibleForTesting
    protected static final int DISTANCE_TYPE_ARRIVED_REMAIN = 2;
    @VisibleForTesting
    protected static final int DISTANCE_TYPE_NAV = 1;
    public static final String DIU = "defultXP1498635cd464d9150b27b7486e436a2f";
    public static final int FAST_CHARGE_REMAIN_NUM = 2;
    public static final int FAST_CHARGE_TOTAL_NUM = 1;
    public static final int ID_OPEN_LAYER_SYSTEM_TRAFFIC = 9001;
    public static final int ID_OPEN_LAYER_USER_TRAFFIC = 9003;
    private static final int LESS_THAN_1KM = 4;
    private static final double MAX_CHINA_LAT = 55.5783446722d;
    private static final double MAX_CHINA_LON = 140.2734375d;
    private static final double MIN_CHINA_LAT = -0.8788717828d;
    private static final double MIN_CHINA_LON = 69.08203125d;
    public static final int MIN_DISTANCE_THRESHOLD_FOR_SAME_POI = 50;
    private static final int MORE_THAN_100KM = 1;
    public static final int NAV_START_AUTO_EXPLORE = 2;
    public static final int NAV_START_AUTO_NAVI = 1;
    public static final int NAV_START_NORMAL = 0;
    public static final int NORMAL_CHARGE_REMAIN_NUM = 4;
    public static final int NORMAL_CHARGE_TOTAL_NUM = 3;
    public static final String OPEN_LAYER_SYSTEM_TRAFFIC_JSON = "{\"update_period\": 30,\"cachemode\":2, \"url\": \"http://maps.testing.amap.com/ws/mps/lyrdata/ugc\",\"bounds\":[{\"y1\": 122421247,\"x2\": 235405312, \"x1\": 188874751, \"y2\": 85065727}], \"sublyr\": [{\"type\": 4, \"sid\": 9000004, \"zlevel\": 2}], \"minzoom\": 6, \"maxzoom\": 20, \"id\": 9001}";
    public static final String OPEN_LAYER_USER_TRAFFIC_JSON = "{\"update_period\": 90, \"cachemode\":1, \"url\": \"http://maps.testing.amap.com/ws/mps/lyrdata/ugc\",\"bounds\":[{\"y1\": 122421247,\"x2\": 235405312, \"x1\": 188874751, \"y2\": 85065727}], \"sublyr\": [{\"type\": 4, \"sid\": 9000003}], \"minzoom\": 6, \"maxzoom\": 20, \"id\": 9003}";
    public static final int ROUTE_SELECT_STRATEGY_NEARBY = 10;
    public static final int ROUTE_SELECT_STRATEGY_NONE = 0;
    public static final int ROUTE_SELECT_STRATEGY_TRAFFIC_LIGHT_LEAST = 11;
    public static final int TIGHT_TURN_DISTANCE = 200;
    public static final int TRAFFIC_STATE_DISABLE = 2;
    public static final int TRAFFIC_STATE_FREE = 0;
    public static final int TRAFFIC_STATE_SYSTEM_LAYER_ONLY = 1;
    private static final L.Tag TAG = new L.Tag("NavCoreUtil");
    private static final String sAboutMetersSign = ContextUtils.getString(R.string.about_meters_sign);
    private static final String sAboutMeters = ContextUtils.getString(R.string.about_meters);
    private static final String sMetersSign = ContextUtils.getString(R.string.meters_sign);
    private static final String sMeters = ContextUtils.getString(R.string.meters);
    private static final String sMetersBignumSign = ContextUtils.getString(R.string.meters_bignum_sign);
    private static final String sMetersBignum = ContextUtils.getString(R.string.meters_bignum);
    private static final String sUnitMetreSign = ContextUtils.getString(R.string.unit_meter_sign);
    private static final String sUnitMetre = ContextUtils.getString(R.string.unit_meter);
    private static final String sMetersNoSpaceSign = ContextUtils.getString(R.string.meters_no_space_sign);
    private static final String sMetersNoSpace = ContextUtils.getString(R.string.meters_no_space);
    private static final String sAboutKmSign = ContextUtils.getString(R.string.about_km_sign);
    private static final String sAboutKm = ContextUtils.getString(R.string.about_km);
    private static final String sKmSign = ContextUtils.getString(R.string.km_sign);
    private static final String sKm = ContextUtils.getString(R.string.km);
    private static final String skmBignumSign = ContextUtils.getString(R.string.km_bignum_sign);
    private static final String skmBignum = ContextUtils.getString(R.string.km_bignum);
    private static final String sUnitKmSign = ContextUtils.getString(R.string.unit_km_sign);
    private static final String sUnitKm = ContextUtils.getString(R.string.unit_km);
    private static final String sKmNoSpaceSign = ContextUtils.getString(R.string.km_no_space_sign);
    private static final String sKmNoSpace = ContextUtils.getString(R.string.km_no_space);
    private static final String sAboutKm100Sign = ContextUtils.getString(R.string.about_km100_sign);
    private static final String sAboutKm100 = ContextUtils.getString(R.string.about_km100);
    private static final String sKm100Sign = ContextUtils.getString(R.string.km100_sign);
    private static final String sKm100 = ContextUtils.getString(R.string.km100);
    private static final String sKm100BignumSign = ContextUtils.getString(R.string.km100_bignum_sign);
    private static final String sKm100Bignum = ContextUtils.getString(R.string.km100_bignum);
    private static final String sKm100NoSpaceSign = ContextUtils.getString(R.string.km100_no_space_sign);
    private static final String sKm100NoSpace = ContextUtils.getString(R.string.km100_no_space);

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ChargeType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DistanceFormatType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DistanceRange {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DistanceType {
    }

    private static int convertBLIconToICMIcon(int i) {
        switch (i) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
            case 10:
            case 13:
            default:
                return 8;
            case 11:
                return 9;
            case 12:
                return 10;
            case 14:
                return 11;
            case 15:
                return 12;
            case 16:
                return 13;
        }
    }

    public static int ehpMapDataAction2OperateType(@MapDataAction.MapDataAction1 int i) {
        if (i != Integer.MIN_VALUE) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 0 : 1;
                }
                return 2;
            }
            return 3;
        }
        return Integer.MIN_VALUE;
    }

    public static boolean isInChina(double d, double d2) {
        return MIN_CHINA_LAT < d2 && MAX_CHINA_LAT > d2 && MIN_CHINA_LON < d && MAX_CHINA_LON > d;
    }

    public static boolean isNetworkError(int i) {
        return 2 == i || 16 == i || 17 == i;
    }

    public static boolean isShutUpRerouteType(int i) {
        return i == 4;
    }

    public static boolean isSilentCalcRoute(int i) {
        return i == 5 || i == 6 || i == 7 || i == 11 || i == 9001 || i == 13 || i == 14;
    }

    public static double translationInt32ToDouble(int i) {
        return i / 3600000.0d;
    }

    public static String getEventID(String str) {
        new BlToolPoiID();
        return BlToolPoiID.poiIDToEventID(str, 0L);
    }

    public static boolean isLicencePlateNo(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领]{1}[A-Z]{1}[A-Z0-9]{5,6}$");
    }

    public static boolean isNormalCalcRoute(int i) {
        return (isSilentCalcRoute(i) || i == 2) ? false : true;
    }

    public static String getDiu() {
        String hardwareId = SystemPropertyUtil.getHardwareId();
        if (TextUtils.isEmpty(hardwareId)) {
            hardwareId = DIU;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "diu=" + hardwareId);
        }
        return hardwareId;
    }

    public static boolean isExploreNeedPlayTTS(@NonNull String str) {
        for (String str2 : ContextUtils.getStringArray(R.array.explore_tts_filter_data)) {
            if (str.contains(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStartNaviTTS(@NonNull String str) {
        for (String str2 : ContextUtils.getStringArray(R.array.start_nav_tts_filter_data)) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String generatePoiIdWithInfo(XPPoiInfo xPPoiInfo) {
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(xPPoiInfo.getName())) {
            sb.append(xPPoiInfo.getName());
        }
        if (!TextUtils.isEmpty(xPPoiInfo.getAddress())) {
            sb.append(xPPoiInfo.getAddress());
        }
        if (!TextUtils.isEmpty(xPPoiInfo.getDistrictName())) {
            sb.append(xPPoiInfo.getDistrictName());
        }
        if (!TextUtils.isEmpty(xPPoiInfo.getCityCode())) {
            sb.append(xPPoiInfo.getCityCode());
        }
        if (Double.compare(xPPoiInfo.getDisplayLon(), 0.0d) != 0) {
            sb.append(xPPoiInfo.getDisplayLon());
        }
        if (Double.compare(xPPoiInfo.getDisplayLat(), 0.0d) != 0) {
            sb.append(xPPoiInfo.getDisplayLat());
        }
        return Base64.encodeToString(sb.toString().getBytes(), 0);
    }

    public static boolean isBlValidPoiId(XPPoiInfo xPPoiInfo) {
        return (xPPoiInfo == null || 5 == xPPoiInfo.getPoiSource() || xPPoiInfo.matchCustomPoiIdHeader()) ? false : true;
    }

    public static boolean isGpsDebugMode() {
        return DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_DR_MODE, 0) == 1;
    }

    public static void setGpsDebugMode(boolean z) {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.KEY_NAVI_REBOOT_DR_MODE, z ? 1 : 0);
    }

    public static double calcuCarLocationDistance(XPPoiInfo xPPoiInfo, XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (xPPoiInfo == null || xPCoordinate2DDouble == null) {
            return 0.0d;
        }
        return LocationUtils.getDistance(new XPCoordinate2DDouble(xPPoiInfo), xPCoordinate2DDouble);
    }

    public static boolean isNeedOfflineReroute(int i, boolean z, boolean z2, int i2, int i3) {
        return (z || z2 || !isNetworkError(i) || isSilentCalcRoute(i2) || 2 != i3) ? false : true;
    }

    @Nullable
    public static JSONObject constructNaviInfoForICM(@Nullable XPNaviInfo xPNaviInfo, String str) {
        if (xPNaviInfo == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("SegRemainDis", "" + xPNaviInfo.mRouteRemainDist);
            jSONObject2.put("SegRemaintime", "" + xPNaviInfo.mRouteRemainTime + 30);
            int i = (int) xPNaviInfo.mRouteRemainDist;
            jSONObject2.put("SegRemainDis1", getSegRemainDis1ForICM(i));
            jSONObject2.put("SegRemaintime1", getSegRemaintime1ForICM(xPNaviInfo.mRouteRemainTime, i));
            jSONObject2.put("CurRoadName", xPNaviInfo.mCurRouteName);
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("NexRoadName", str);
            } else {
                jSONObject2.put("NexRoadName", xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mNextRouteName);
            }
            int convertBLIconToICMIcon = convertBLIconToICMIcon(xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mManeuverID);
            jSONObject2.put("NavIcon", "" + convertBLIconToICMIcon);
            jSONObject2.put("RoadRemainDis", "" + xPNaviInfo.mNaviInfoData[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist);
            List<XPCameraInfo> naviCamera = TBTManager.getInstance().getNaviCamera();
            int i2 = CollectionUtils.isNotEmpty(naviCamera) ? naviCamera.get(0).mType : -1;
            if (i2 == -1) {
                jSONObject2.put("CameraType", "");
            } else {
                jSONObject2.put("CameraType", "" + i2);
                jSONObject2.put("CameraSpeed", "" + naviCamera.get(0).mSpeed);
                jSONObject2.put("CameraDis", "" + naviCamera.get(0).mDistance);
            }
            jSONObject2.put("LimitedSpeed", "" + getLimitSpeed());
            if (convertBLIconToICMIcon == 9 || convertBLIconToICMIcon == 10) {
                jSONObject2.put("RoadAllNum", "0");
                jSONObject2.put("RoadAboutNum", "0");
            }
            jSONObject.put("nav", jSONObject2);
            jSONObject.put("msgtype", "1");
            jSONObject.put("enable", "1");
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "json:\n" + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            L.Tag tag2 = TAG;
            L.e(tag2, "constructNaviInfoForICM failed because naviInfo is : " + xPNaviInfo);
            return null;
        }
    }

    private static int getLimitSpeed() {
        XPCameraInfo next;
        List<XPCameraInfo> naviCamera = TBTManager.getInstance().getNaviCamera();
        if (naviCamera == null || naviCamera.size() == 0) {
            return 0;
        }
        Iterator<XPCameraInfo> it = naviCamera.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.mType == 0 || 8 == next.mType || 10 == next.mType) {
                if (next.mSpeed != null && next.mSpeed.length != 0) {
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, "getLimitSpeed:" + next.mSpeed[0] + ", type:" + next.mType);
                    }
                    return next.mSpeed[0];
                }
            }
        }
        return 0;
    }

    public static boolean doesTightTurnExist(@NonNull XPNaviInfo xPNaviInfo) {
        XPNaviInfoPanel[] xPNaviInfoPanelArr = xPNaviInfo.mNaviInfoData;
        XPCrossNaviInfo[] xPCrossNaviInfoArr = xPNaviInfo.mNextCrossInfo;
        if (xPNaviInfoPanelArr != null && xPCrossNaviInfoArr != null && xPNaviInfoPanelArr.length != 0 && xPCrossNaviInfoArr.length != 0) {
            XPNaviInfoPanel xPNaviInfoPanel = xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag];
            if (20 == xPNaviInfoPanel.mManeuverID) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "ignore tight turn by maneuverID:" + xPNaviInfoPanel.mManeuverID);
                }
                return false;
            }
            XPCrossNaviInfo xPCrossNaviInfo = xPCrossNaviInfoArr[0];
            if (xPCrossNaviInfo.mCurToSegmentDist <= 200) {
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "tight turn dis:" + xPCrossNaviInfo.mCurToSegmentDist);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static SearchResponseEvent convertXpResultToResponseEvent(int i, int i2, @Nullable XPSearchResult xPSearchResult) {
        if (xPSearchResult == null) {
            return new SearchResponseEvent(i, null, i2, 0);
        }
        SearchResponseEvent searchResponseEvent = new SearchResponseEvent(i, xPSearchResult.getXPPoiInfos() != null ? new ArrayList(xPSearchResult.getXPPoiInfos()) : null, xPSearchResult.getRectFloat(), xPSearchResult.getRequestId(), xPSearchResult.getResultCode());
        searchResponseEvent.setCityLocation(xPSearchResult.isNeedLocation());
        return searchResponseEvent;
    }

    public static void sortXPPoiInfosByDistance(ArrayList<XPPoiInfo> arrayList, int i) {
        if (arrayList == null || arrayList.size() < 2) {
            return;
        }
        if (i == 2) {
            Collections.sort(arrayList, new Comparator<XPPoiInfo>() { // from class: com.xiaopeng.montecarlo.navcore.util.NavCoreUtil.1
                @Override // java.util.Comparator
                public int compare(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
                    return Double.compare(xPPoiInfo.getDistance(), xPPoiInfo2.getDistance());
                }
            });
        }
    }

    public static int getChargeNums(XPPoiInfo xPPoiInfo, int i) {
        XPDeepCharging[] chargeData;
        XPDeepInfoPoi xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi();
        if (xPDeepInfoPoi == null || (chargeData = xPDeepInfoPoi.getChargeData()) == null || chargeData.length == 0) {
            return -1;
        }
        if (1 == i) {
            return chargeData[0].getNumFast();
        }
        if (2 == i) {
            return chargeData[0].getNumFastFree();
        }
        if (3 == i) {
            return chargeData[0].getNumSlow();
        }
        if (4 == i) {
            return chargeData[0].getNumSlowFree();
        }
        return -1;
    }

    public static boolean isValidLatLon(double d, double d2) {
        return (Double.compare(d, 0.0d) == 0 && Double.compare(d2, 0.0d) == 0) ? false : true;
    }

    public static boolean isSamePOI(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
        return isSamePOI(xPPoiInfo, xPPoiInfo2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r8.getPoiId().equals(r9.getPoiId()) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0196, code lost:
        if (r2 <= 50.0d) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isSamePOI(com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r8, com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.util.NavCoreUtil.isSamePOI(com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo, com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo, boolean):boolean");
    }

    public static boolean isSameXPPosition(XPCoordinate2DDouble xPCoordinate2DDouble, XPCoordinate2DDouble xPCoordinate2DDouble2) {
        return xPCoordinate2DDouble != null && xPCoordinate2DDouble2 != null && isValidLatLon(xPCoordinate2DDouble.mLat, xPCoordinate2DDouble.mLon) && isValidLatLon(xPCoordinate2DDouble2.mLat, xPCoordinate2DDouble2.mLon) && RootUtil.compareDouble(xPCoordinate2DDouble.mLat, xPCoordinate2DDouble2.mLat) && RootUtil.compareDouble(xPCoordinate2DDouble.mLon, xPCoordinate2DDouble2.mLon);
    }

    public static void setNavPositionWithEnters(@NonNull XPPoiInfo xPPoiInfo) {
        XPCoordinate2DDouble xPCoordinate2DDouble;
        if (isValidLatLon(xPPoiInfo.getNaviLat(), xPPoiInfo.getNaviLon()) || !CollectionUtils.isNotEmpty(xPPoiInfo.getEnters())) {
            return;
        }
        ArrayList<XPCoordinate2DDouble> enters = xPPoiInfo.getEnters();
        if (enters != null && enters.size() > 0) {
            xPCoordinate2DDouble = enters.get(0);
        } else {
            xPCoordinate2DDouble = new XPCoordinate2DDouble();
        }
        xPPoiInfo.setNaviLon(xPCoordinate2DDouble.mLon);
        xPPoiInfo.setNaviLat(xPCoordinate2DDouble.mLat);
    }

    public static void postCrashToast() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.util.NavCoreUtil.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.showToast(ContextUtils.getContext(), R.string.crash_warning);
            }
        });
    }

    public static XPPoiInfo getXPPoiByString(String str, boolean z) {
        XPPoiInfo xPPoiInfo = new XPPoiInfo();
        String[] split = str.split(",");
        if (split.length != 2) {
            L.w(TAG, "point para error:" + str);
            return null;
        }
        int i = 0;
        try {
            double doubleValue = Double.valueOf(split[0]).doubleValue();
            double doubleValue2 = Double.valueOf(split[1]).doubleValue();
            xPPoiInfo.setName("test point");
            xPPoiInfo.setDisplayLat(doubleValue);
            xPPoiInfo.setDisplayLon(doubleValue2);
            if (!z) {
                i = 2;
            }
            xPPoiInfo.setType(i);
            return xPPoiInfo;
        } catch (NumberFormatException e) {
            L.w(TAG, "point para error:" + e.getMessage());
            return null;
        }
    }

    public static ArrayList<XPViaPoint> getVIAsByString(String str) {
        ArrayList<XPViaPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT)) {
            XPPoiInfo xPPoiByString = getXPPoiByString(str2, false);
            if (xPPoiByString != null) {
                arrayList.add(new XPViaPoint(xPPoiByString));
            }
        }
        return arrayList;
    }

    public static void syncRouteInfoToVoice(final List<RouteDetailInfo> list, final long j, final boolean z) {
        WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.util.NavCoreUtil.3
            @Override // java.lang.Runnable
            public void run() {
                if (L.ENABLE) {
                    L.Tag tag = NavCoreUtil.TAG;
                    L.d(tag, "syncRouteInfoToVoice infos:" + list + "requestId:" + j + ",isBaseInfo:" + z);
                }
                try {
                    if (CollectionUtils.isNotEmpty(list)) {
                        ArrayList arrayList = new ArrayList();
                        for (RouteDetailInfo routeDetailInfo : list) {
                            RouteSelectBean routeSelectBean = new RouteSelectBean();
                            routeSelectBean.routeTypeNo = routeDetailInfo.getRouteTypeNo();
                            routeSelectBean.routeTypeName = routeDetailInfo.getRouteTypeName();
                            routeSelectBean.trafficSignal = routeDetailInfo.getTrafficSignal();
                            routeSelectBean.trafficCost = routeDetailInfo.getTrafficCost();
                            routeSelectBean.totalTimeLine1 = routeDetailInfo.getTotalTimeLine1();
                            routeSelectBean.totalTimeLine1Value = routeDetailInfo.getTotalTimeLine1Value();
                            routeSelectBean.totalTimeLine2 = routeDetailInfo.getTotalTimeLine2();
                            routeSelectBean.routeLeftDistance = routeDetailInfo.getRouteLeftDistance();
                            routeSelectBean.routeLeftDistanceValue = routeDetailInfo.getRouteLeftDistanceValue();
                            routeSelectBean.batteryStatus = routeDetailInfo.getBatteryStatus();
                            routeSelectBean.batteryStatusTips = routeDetailInfo.getBatteryStatusTips();
                            routeSelectBean.remainDistance = routeDetailInfo.getRemainDistance();
                            routeSelectBean.remainDistanceValue = routeDetailInfo.getRemainDistanceValue();
                            arrayList.add(routeSelectBean);
                        }
                        NaviModel.getInstance().syncRoute(arrayList, String.valueOf(j), z);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static byte[] convertBmp2PngWithAlpha(byte[] bArr) {
        return convertBmp2PngWithAlpha(bArr, 0);
    }

    @Nullable
    public static byte[] convertBmp2PngWithAlpha(byte[] bArr, int i) {
        int[] byte2ColorInt;
        if (bArr == null || bArr.length == 0 || (bArr.length - 54) % 4 != 0 || (byte2ColorInt = byte2ColorInt(bArr, i)) == null || byte2ColorInt.length <= 0) {
            return null;
        }
        return BMPDataUtil.bitmap2PngData(Bitmap.createBitmap(byte2ColorInt, 90, 90, Bitmap.Config.ARGB_8888));
    }

    @Nullable
    private static int[] byte2ColorInt(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0 || (bArr.length - 54) % 4 != 0) {
            return null;
        }
        int length = (bArr.length - 54) / 4;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = (i2 * 4) + 53;
            byte b = bArr[i3];
            int i4 = bArr[i3 + 1];
            int i5 = bArr[i3 + 2];
            int i6 = (bArr[i3 + 3] & 255) << 16;
            int i7 = (i5 & 255) << 8;
            int i8 = i4 & 255;
            if (((((b & 255) << 24) | i6 | i7 | i8) & (-1)) == TBTManager.getInstance().getManeuverBackColor()) {
                b = (byte) (b & i);
            }
            iArr[i2] = (i6 | ((b & 255) << 24) | i7 | i8) & (-1);
        }
        return iArr;
    }

    public static boolean isHomeOrCompanyScope(double d) {
        boolean z = isFavoriteScope(FavoriteDataManager.getInstance().getCompany(), d) || isFavoriteScope(FavoriteDataManager.getInstance().getHome(), d);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isHomeOrCompanyScope: " + z);
        }
        return z;
    }

    public static boolean isFavoriteScope(FavoriteAddress favoriteAddress, double d) {
        XPPoiInfo xPPoiInfo;
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentNaviId());
        if (endInfo == null || favoriteAddress == null || (xPPoiInfo = favoriteAddress.getXPPoiInfo()) == null) {
            return false;
        }
        XPCoordinate2DDouble xPCoordinate2DDouble = new XPCoordinate2DDouble(endInfo);
        XPCoordinate2DDouble xPCoordinate2DDouble2 = new XPCoordinate2DDouble(xPPoiInfo);
        if (Double.compare(d, 0.0d) == 0) {
            return isSameXPPosition(xPCoordinate2DDouble, xPCoordinate2DDouble2);
        }
        return Double.compare(LocationUtils.getDistance(xPCoordinate2DDouble, xPCoordinate2DDouble2), d) <= 0;
    }

    public static ArrayList<LayerItem> translationLayerItems(int i, XPPointBaseData[] xPPointBaseDataArr) {
        ArrayList<LayerItem> arrayList = new ArrayList<>();
        for (XPPointBaseData xPPointBaseData : xPPointBaseDataArr) {
            PointLayerItem pointLayerItem = new PointLayerItem();
            pointLayerItem.setBusinessType(i);
            pointLayerItem.setID(xPPointBaseData.id);
            pointLayerItem.setPosition(xPPointBaseData.position);
            pointLayerItem.setPriority(xPPointBaseData.priority);
            arrayList.add(pointLayerItem);
        }
        return arrayList;
    }

    public static ArrayList<LayerItem> translateBizAGroupBusiness2LayerItems(ArrayList<BizAGroupBusinessInfo> arrayList) {
        ArrayList<LayerItem> arrayList2 = new ArrayList<>();
        Iterator<BizAGroupBusinessInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            BizAGroupBusinessInfo next = it.next();
            PointLayerItem pointLayerItem = new PointLayerItem();
            pointLayerItem.setID(next.id);
            Coord3DDouble coord3DDouble = new Coord3DDouble();
            coord3DDouble.lon = next.mPos3D.lon;
            coord3DDouble.lat = next.mPos3D.lat;
            pointLayerItem.setPosition(coord3DDouble);
            pointLayerItem.setPriority(next.priority);
            pointLayerItem.setBusinessType(BizSearchType.BizSearchTypePoiParkRoute);
            arrayList2.add(pointLayerItem);
        }
        return arrayList2;
    }

    public static ArrayList<BizAGroupBusinessInfo> translationBizAGroupBusinessInfos(ArrayList<XPPointBaseData> arrayList) {
        ArrayList<BizAGroupBusinessInfo> arrayList2 = new ArrayList<>();
        Iterator<XPPointBaseData> it = arrayList.iterator();
        while (it.hasNext()) {
            XPPointBaseData next = it.next();
            if (next != null) {
                BizAGroupBusinessInfo bizAGroupBusinessInfo = new BizAGroupBusinessInfo();
                bizAGroupBusinessInfo.mPos3D = next.position;
                bizAGroupBusinessInfo.priority = next.priority;
                bizAGroupBusinessInfo.id = next.id;
                arrayList2.add(bizAGroupBusinessInfo);
            }
        }
        return arrayList2;
    }

    public static ArrayList<BizAGroupBusinessInfo> translationBizAGroupBusinessInfos(XPPointBaseData[] xPPointBaseDataArr) {
        ArrayList<BizAGroupBusinessInfo> arrayList = new ArrayList<>();
        for (XPPointBaseData xPPointBaseData : xPPointBaseDataArr) {
            BizAGroupBusinessInfo bizAGroupBusinessInfo = new BizAGroupBusinessInfo();
            bizAGroupBusinessInfo.id = xPPointBaseData.id;
            bizAGroupBusinessInfo.priority = xPPointBaseData.priority;
            bizAGroupBusinessInfo.mPos3D = xPPointBaseData.position;
            arrayList.add(bizAGroupBusinessInfo);
        }
        return arrayList;
    }

    public static ArrayList<Coord2DDouble> translationInt32ToDouble(ArrayList<Coord2DInt32> arrayList) {
        if (arrayList != null) {
            ArrayList<Coord2DDouble> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    Coord2DDouble coord2DDouble = new Coord2DDouble();
                    coord2DDouble.lon = arrayList.get(i).lon / 3600000.0d;
                    coord2DDouble.lat = arrayList.get(i).lat / 3600000.0d;
                    arrayList2.add(coord2DDouble);
                }
                return arrayList2;
            }
            return arrayList2;
        }
        return null;
    }

    private static String getSegRemainDis1ForICM(int i) {
        StringBuilder sb = new StringBuilder();
        String[] distanceArray = getDistanceArray(i);
        sb.append(distanceArray[0]);
        sb.append(distanceArray[1]);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getSegRemainDis1ForICM routeRemainDis:" + i + ",displayStr:" + sb.toString());
        }
        return sb.toString();
    }

    public static String[] getDistanceArray(double d) {
        return getDistanceArray(d, false);
    }

    public static String[] getDistanceArray(double d, boolean z) {
        return getDistanceString(d, 3, 1, z);
    }

    public static String getDistanceString(long j) {
        return getDistanceString(j, false);
    }

    public static String getDistanceString(float f) {
        return getDistanceString(f, false);
    }

    public static String getDistanceString(double d) {
        return getDistanceString(d, false);
    }

    public static String getDistanceString(long j, boolean z) {
        return getDistanceString(j, z);
    }

    public static String getDistanceString(float f, boolean z) {
        return getDistanceString(f, z);
    }

    public static String getDistanceString(double d, boolean z) {
        return getDistanceString(d, 2, z)[0];
    }

    public static String getDistanceNoSpaceString(long j) {
        return getDistanceString(j, 5)[0];
    }

    public static String getDistanceStringWithAboutHeader(double d) {
        return getDistanceString(d, 1)[0];
    }

    public static String[] getDistanceString(double d, int i) {
        return getDistanceString(d, i, false);
    }

    public static String[] getDistanceString(double d, int i, boolean z) {
        return getDistanceString(d, i, 1, z);
    }

    public static String[] getDistanceString(double d, int i, int i2) {
        return getDistanceString(d, i, i2, false);
    }

    public static String[] getDistanceString(double d, int i, int i2, boolean z) {
        int distanceState = getDistanceState(d, i2);
        if (distanceState != 4) {
            double round = ((float) Math.round((d / 1000.0d) * 10.0d)) / 10.0f;
            if (distanceState == 1 || distanceState == 2) {
                return getStringMoreOneKM(round, i, z);
            }
            if (distanceState == 3) {
                if (i == 1) {
                    String[] strArr = new String[1];
                    strArr[0] = String.format(z ? sAboutKmSign : sAboutKm, Double.valueOf(round));
                    return strArr;
                } else if (i == 2) {
                    String[] strArr2 = new String[1];
                    strArr2[0] = String.format(z ? sKmSign : sKm, Double.valueOf(round));
                    return strArr2;
                } else if (i == 4) {
                    String[] strArr3 = new String[1];
                    strArr3[0] = String.format(z ? skmBignumSign : skmBignum, Double.valueOf(round));
                    return strArr3;
                } else if (i == 3) {
                    String[] strArr4 = new String[2];
                    strArr4[0] = new DecimalFormat("#.0").format(round);
                    strArr4[1] = z ? sUnitKmSign : sUnitKm;
                    return strArr4;
                } else if (i == 5) {
                    String[] strArr5 = new String[1];
                    strArr5[0] = String.format(z ? sKmNoSpaceSign : sKmNoSpace, Double.valueOf(round));
                    return strArr5;
                }
            }
        } else if (i == 1) {
            String[] strArr6 = new String[1];
            strArr6[0] = String.format(z ? sAboutMetersSign : sAboutMeters, Integer.valueOf((int) d));
            return strArr6;
        } else if (i == 2) {
            String[] strArr7 = new String[1];
            strArr7[0] = String.format(z ? sMetersSign : sMeters, Integer.valueOf((int) d));
            return strArr7;
        } else if (i == 4) {
            String[] strArr8 = new String[1];
            strArr8[0] = String.format(z ? sMetersBignumSign : sMetersBignum, Integer.valueOf((int) d));
            return strArr8;
        } else if (i == 3) {
            String[] strArr9 = new String[2];
            strArr9[0] = "" + ((int) d);
            strArr9[1] = z ? sUnitMetreSign : sUnitMetre;
            return strArr9;
        } else if (i == 5) {
            String[] strArr10 = new String[1];
            strArr10[0] = String.format(z ? sMetersNoSpaceSign : sMetersNoSpace, Integer.valueOf((int) d));
            return strArr10;
        }
        return new String[]{""};
    }

    public static String[] getRemainDistanceArray(double d) {
        return getDistanceString(d, 3, 2);
    }

    public static SpannableString getDistanceSizedSpannedString(double d, float f, float f2) {
        String distanceString = getDistanceString(d);
        if (TextUtils.isEmpty(distanceString)) {
            return null;
        }
        float f3 = f2 / f;
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f3);
        RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(f3);
        SpannableString spannableString = new SpannableString(distanceString);
        String string = ContextUtils.getString(R.string.unit_km);
        String string2 = ContextUtils.getString(R.string.unit_meter);
        int indexOf = distanceString.indexOf(string);
        int length = string.length() + indexOf;
        int indexOf2 = distanceString.indexOf(string2);
        int length2 = string2.length() + indexOf2;
        if (indexOf > -1 && length <= distanceString.length()) {
            spannableString.setSpan(relativeSizeSpan, indexOf, length, 17);
        }
        if (indexOf2 > -1 && length2 <= distanceString.length()) {
            spannableString.setSpan(relativeSizeSpan2, indexOf2, length2, 17);
        }
        return spannableString;
    }

    public static String getDistanceStringWithBigNum(double d) {
        return getDistanceString(d, 4)[0];
    }

    private static int getDistanceState(double d, int i) {
        if (d >= 1000.0d) {
            if (d >= 100000.0d) {
                return 1;
            }
            return (i == 2 || (((double) (((float) Math.round((d / 1000.0d) * 10.0d)) / 10.0f)) * 10.0d) % 10.0d == 0.0d) ? 2 : 3;
        }
        return 4;
    }

    private static String[] getStringMoreOneKM(double d, int i) {
        return getStringMoreOneKM(d, i, false);
    }

    private static String[] getStringMoreOneKM(double d, int i, boolean z) {
        if (i == 1) {
            String[] strArr = new String[1];
            strArr[0] = String.format(z ? sAboutKm100Sign : sAboutKm100, Integer.valueOf((int) d));
            return strArr;
        } else if (i == 2) {
            String[] strArr2 = new String[1];
            strArr2[0] = String.format(z ? sKm100Sign : sKm100, Integer.valueOf((int) d));
            return strArr2;
        } else if (i == 4) {
            String[] strArr3 = new String[1];
            strArr3[0] = String.format(z ? sKm100BignumSign : sKm100Bignum, Integer.valueOf((int) d));
            return strArr3;
        } else if (i != 3) {
            if (i == 5) {
                String[] strArr4 = new String[1];
                strArr4[0] = String.format(z ? sKm100NoSpaceSign : sKm100NoSpace, Integer.valueOf((int) d));
                return strArr4;
            }
            return new String[]{""};
        } else {
            String[] strArr5 = new String[2];
            strArr5[0] = "" + ((int) d);
            strArr5[1] = z ? sUnitKmSign : sUnitKm;
            return strArr5;
        }
    }

    private static String getSegRemaintime1ForICM(double d, int i) {
        StringBuilder sb = new StringBuilder();
        List<String> naviTimeString = getNaviTimeString(d, i);
        if (!CollectionUtils.isEmpty(naviTimeString)) {
            for (String str : naviTimeString) {
                sb.append(str);
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getSegRemaintime1ForICM remainTime:" + d + ",distance:" + i + ",displayStr:" + sb.toString());
        }
        return sb.toString();
    }

    @Nullable
    public static List<String> getNaviTimeString(double d) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>>>> getNaviTimeString time: " + d);
        }
        if (d <= 0.0d) {
            return null;
        }
        long j = (long) (d / 3600.0d);
        long j2 = (long) ((d % 3600.0d) / 60.0d);
        ArrayList arrayList = new ArrayList();
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            arrayList.add(String.valueOf(j));
            arrayList.add(ContextUtils.getString(R.string.hour_forxml));
        }
        if (d > 0.0d && j2 == 0 && i == 0) {
            j2 = 1;
        }
        if (j2 > 0 && j < 100) {
            arrayList.add(String.valueOf(j2));
            arrayList.add(ContextUtils.getString(R.string.minute_forxml));
        }
        return arrayList;
    }

    public static List<String> getNaviTimeString(double d, int i) {
        boolean checkShowAllTime = checkShowAllTime(i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>>>> getNaviTimeString time: " + d + " showAllTime: " + checkShowAllTime);
        }
        if (checkShowAllTime) {
            return getNaviTimeString(d);
        }
        if (d <= 0.0d) {
            return null;
        }
        long j = (long) (d / 3600.0d);
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            arrayList.add(String.valueOf(j));
            arrayList.add(ContextUtils.getString(R.string.hour_forxml));
        }
        return arrayList;
    }

    public static double getCompleteTimeSeconds(double d, int i) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        boolean checkShowAllTime = checkShowAllTime(i);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>>>> getCompleteTimeSeconds time: " + d + " showAllTime: " + checkShowAllTime);
        }
        return checkShowAllTime ? d : ((long) (d / 3600.0d)) * TimeFormatUtil.ONE_HOUR;
    }

    public static boolean checkShowAllTime(int i) {
        return i / 1000 < 1000;
    }

    public static void convertAmapPositionData() {
        String[] strArr;
        int i = 0;
        int i2 = 1;
        boolean z = true;
        for (String str : RootUtil.TO_CALIBRATION_FILE_LIST) {
            if (!new File(RootUtil.SD_CARD_DIR_POS_520_CONTEXT, str).exists()) {
                L.i(TAG, RootUtil.SD_CARD_DIR_POS_520_CONTEXT + str + " does not exist");
                z = false;
            }
        }
        if (z) {
            L.i(TAG, "no need to convert");
            return;
        }
        String str2 = null;
        String[] strArr2 = RootUtil.TO_CALIBRATION_FILE_LIST;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                i2 = -1;
                break;
            }
            String str3 = strArr2[i];
            if (new File(RootUtil.SD_CARD_DIR_POS_430_CONTEXT, str3).exists()) {
                L.i(TAG, RootUtil.SD_CARD_DIR_POS_430_CONTEXT + str3 + " exist");
                i2 = 2;
                str2 = RootUtil.SD_CARD_DIR_POS_430_CONTEXT;
                break;
            } else if (new File(RootUtil.SD_CARD_DIR_POS_320_CONTEXT, str3).exists()) {
                L.i(TAG, RootUtil.SD_CARD_DIR_POS_320_CONTEXT + str3 + " exist");
                str2 = RootUtil.SD_CARD_DIR_POS_320_CONTEXT;
                break;
            } else {
                i++;
            }
        }
        if (-1 == i2) {
            L.i(TAG, "no raw pos file");
            return;
        }
        L.i(TAG, "convert loc ret = " + PosService.regenerateLocStorageFromOldVersion(str2, RootUtil.SD_CARD_DIR_POS_520_CONTEXT, i2));
    }
}
