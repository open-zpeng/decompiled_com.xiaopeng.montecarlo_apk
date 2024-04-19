package com.xiaopeng.montecarlo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.common.path.model.AvoidTrafficJamInfo;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import com.autonavi.gbl.guide.model.NaviCongestionDetailInfo;
import com.autonavi.gbl.guide.model.NaviCongestionInfo;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.aimessage.type.MapPoint;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.bean.NaviRouteInfo;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider.XUINavigationInfoUpload;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseLinkAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionDetailInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TimeFormatUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class NaviUtil {
    public static final int CAR_BATTERY_INVALID = -1;
    public static final int CAR_BATTERY_NORMAL = 0;
    public static final int CAR_BATTERY_RED_WARNING = 2;
    public static final int CAR_BATTERY_WARNING = 1;
    public static final int DISTANCE_10M = 10;
    public static final int DISTANCE_120KM = 120000;
    public static final int DISTANCE_1KM = 1000;
    public static final int DISTANCE_20KM = 20000;
    public static final int DISTANCE_30KM = 30000;
    public static final int DISTANCE_60KM = 60000;
    public static final String IS_NEED_START_NAVI_KEY = "key_is_need_start_navi";
    public static final String IS_NEED_TO_SR = "key_is_need_to_sr_nav";
    public static final String IS_NEED_TTSPROXY_SPEAK = "nead_TTSProxy_speak";
    public static final int ORANGE_REMAIN_DISTANCE = 30000;
    public static final int RADIAN_ALL = 15;
    public static final int RADIAN_LEFT_DOWN_SHOW = 2;
    public static final int RADIAN_LEFT_UP_SHOW = 1;
    public static final int RADIAN_NO = 0;
    public static final int RADIAN_RIGHT_DOWN_SHOW = 8;
    public static final int RADIAN_RIGHT_UP_SHOW = 4;
    public static final String ROUTE_URI_SCHEME = "xpengmap";
    public static final int STATUS_DISTANCE_LOW_POWER = 2;
    public static final int STATUS_DISTANCE_REACHABLE = 1;
    public static final int STATUS_DISTANCE_UNREACHABLE = 0;
    public static final String TRAFFIC_STRING_SPLITTER = "@SPLIT;";
    private static final L.Tag TAG = new L.Tag("NaviUtil");
    private static final Rect sRoutePathOffsetRect = new Rect(ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_left), ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_top), ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_right), ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_bottom));
    private static final Rect sRoutePathOffsetRectForVoiceFusion = new Rect(ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_left_voice_fusion), ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_top_voice_fusion), ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_right_voice_fusion), ContextUtils.getDimensionPixelSize(R.dimen.route_path_offset_bottom_voice_fusion));
    private static final Rect sExplorePathOffsetRect = new Rect(ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_left), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_top), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_right), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_bottom));
    private static final Rect sExplorePathOffsetRectOnLeftPanelShow = new Rect(ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_left_have_panel), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_top), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_right), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_bottom));
    private static final Rect sExploreOffsetRectImmersio = new Rect(ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_left_immersion), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_top_immersion), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_right), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_bottom));
    private static final Rect sExploreOffsetRectImmersioWhenLeftPanelShow = new Rect(ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_left_have_panel), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_top_immersion), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_right), ContextUtils.getDimensionPixelSize(R.dimen.explore_route_path_offset_bottom));
    private static final Rect sPoiCardoffsetRect = new Rect(ContextUtils.getDimensionPixelSize(R.dimen.poi_card_offset_left), ContextUtils.getDimensionPixelSize(R.dimen.poi_card_offset_top), ContextUtils.getDimensionPixelSize(R.dimen.poi_card_offset_right), ContextUtils.getDimensionPixelSize(R.dimen.poi_card_offset_bottom));
    public static boolean sIsMapFirstFrameDrew = false;

    public static int getRemainedDistanceState(long j, long j2) {
        int i = ((j2 - 1000) > j ? 1 : ((j2 - 1000) == j ? 0 : -1));
        if (i < 0) {
            return 2;
        }
        return (i < 0 || j2 - 30000 > j) ? 0 : 1;
    }

    public static boolean isSapaHasCharge(long j) {
        return (j & 64) != 0;
    }

    public static long getHours(@Nullable XPDrivePathAccessor xPDrivePathAccessor) {
        if (xPDrivePathAccessor == null) {
            return 0L;
        }
        return (xPDrivePathAccessor.getTravelTime() >= 0 ? xPDrivePathAccessor.getTravelTime() : 0L) / TimeFormatUtil.ONE_HOUR;
    }

    public static long getMinutes(XPDrivePathAccessor xPDrivePathAccessor) {
        if (xPDrivePathAccessor == null) {
            return 0L;
        }
        return ((xPDrivePathAccessor.getTravelTime() >= 0 ? xPDrivePathAccessor.getTravelTime() : 0L) % TimeFormatUtil.ONE_HOUR) / 60;
    }

    public static String getTimeString(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        long j = (long) (d / 3600.0d);
        long j2 = (long) ((d % 3600.0d) / 60.0d);
        StringBuilder sb = new StringBuilder();
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            sb.append(ContextUtils.getString(R.string.hour, Long.valueOf(j)));
        }
        if (d >= 0.0d && j2 == 0 && i == 0) {
            j2 = 1;
        }
        if (j2 > 0) {
            sb.append(ContextUtils.getString(R.string.minute, Long.valueOf(j2)));
        }
        return sb.toString();
    }

    @Nullable
    public static List<String> getTimeListString(double d) {
        if (L.ENABLE) {
            L.d(TAG, ">>>>>> time: " + d);
        }
        if (d < 0.0d) {
            d = 0.0d;
        }
        long j = (long) (d / 3600.0d);
        long j2 = (long) ((d % 3600.0d) / 60.0d);
        ArrayList arrayList = new ArrayList();
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            arrayList.add(String.valueOf(j));
            arrayList.add(ContextUtils.getString(R.string.hour_forxml));
        }
        if (d >= 0.0d && j2 == 0 && i == 0) {
            j2 = 1;
        }
        if (j2 > 0) {
            arrayList.add(String.valueOf(j2));
            arrayList.add(ContextUtils.getString(R.string.minute_forxml));
        }
        return arrayList;
    }

    @Nullable
    public static List<String> getTimeListString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String string = ContextUtils.getString(R.string.hour_forxml);
        String string2 = ContextUtils.getString(R.string.minute_forxml);
        int indexOf = str.indexOf(string);
        int i = 0;
        if (indexOf > 0) {
            arrayList.add(str.substring(0, indexOf));
            arrayList.add(string);
            i = indexOf + string.length();
        }
        int indexOf2 = str.indexOf(string2);
        if (indexOf2 > 0) {
            arrayList.add(str.substring(i, indexOf2));
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static SpannableString getTimeSizedSpannedString(long j, int i, int i2) {
        return getTimeSizedSpannedString(getTimeString(j), i, i2);
    }

    public static SpannableString getTimeSizedSpannedString(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        float f = i2 / i;
        return getTimeSpannedString(str, new RelativeSizeSpan(f), new RelativeSizeSpan(f));
    }

    public static SpannableString getTimeSpannedString(String str, Object obj, Object obj2) {
        SpannableString spannableString = new SpannableString(str);
        String string = ContextUtils.getString(R.string.hour_forxml);
        String string2 = ContextUtils.getString(R.string.minute_forxml);
        int indexOf = str.indexOf(string);
        int length = string.length() + indexOf;
        int indexOf2 = str.indexOf(string2);
        int length2 = string2.length() + indexOf2;
        if (indexOf > -1 && length <= str.length()) {
            spannableString.setSpan(obj, indexOf, length, 17);
        }
        if (indexOf2 > -1 && length2 <= str.length()) {
            spannableString.setSpan(obj2, indexOf2, length2, 17);
        }
        return spannableString;
    }

    public static String getTimeXmlString(double d) {
        return getTimeXmlString(d, 48, 24);
    }

    public static String getTimeXmlString(double d, int i, int i2) {
        int i3;
        long j;
        long j2 = (long) (d / 3600.0d);
        long j3 = (long) ((d % 3600.0d) / 60.0d);
        StringBuilder sb = new StringBuilder();
        sb.append("<font>");
        int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i4 > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<font><xpface value = ");
            i3 = i4;
            sb2.append(ContextUtils.getString(R.string.xp_font_medium));
            sb2.append("><xpsize value=\"");
            sb2.append(i);
            sb2.append("\">%1$d");
            sb2.append("</xpsize></xpface></font>");
            sb2.append("<font><xpface value = ");
            sb2.append(ContextUtils.getString(R.string.xp_font_medium));
            sb2.append("><xpsize value=\"");
            sb2.append(i2);
            sb2.append("\">&nbsp;");
            sb2.append(ContextUtils.getString(R.string.hour_forxml));
            sb2.append("&nbsp;</xpsize></xpface></font>");
            sb.append(String.format(sb2.toString(), Long.valueOf(j2)));
        } else {
            i3 = i4;
        }
        if (d > 0.0d) {
            j = 0;
            if (j3 == 0 && i3 == 0) {
                j3 = 1;
            }
        } else {
            j = 0;
        }
        if (j3 > j && j2 < 100) {
            sb.append(String.format("<font><xpface value = " + ContextUtils.getString(R.string.xp_font_medium) + "><xpsize value=\"" + i + "\">%1$d</xpsize></xpface></font><font><xpface value = " + ContextUtils.getString(R.string.xp_font_medium) + "><xpsize value=\"" + i2 + "\">&nbsp;" + ContextUtils.getString(R.string.minute_forxml) + "&nbsp;</xpsize></xpface></font>", Long.valueOf(j3)));
        }
        sb.append("</font>");
        return sb.toString();
    }

    public static String getNaviTimeXmlString(double d) {
        long j = (long) (d / 3600.0d);
        long j2 = (long) ((d % 3600.0d) / 60.0d);
        StringBuilder sb = new StringBuilder();
        sb.append("<font>");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            sb.append(String.format("<xpsize value=\"24\">%1$d</xpsize><xpsize value=\"20\">&nbsp;" + ContextUtils.getString(R.string.unit_hours) + "</xpsize>", Long.valueOf(j)));
        }
        if (d > 0.0d && j2 == 0 && i == 0) {
            j2 = 1;
        }
        if (j2 > 0 && j < 100) {
            sb.append(String.format("<xpsize value=\"24\">%1$d</xpsize><xpsize value=\"20\">&nbsp;" + ContextUtils.getString(R.string.minute_forxml) + "</xpsize>", Long.valueOf(j2)));
        }
        sb.append("</font>");
        return sb.toString();
    }

    @Nullable
    public static List<String> getTravelTime(long j) {
        Time time = new Time();
        time.setToNow();
        Time time2 = new Time();
        time2.set(System.currentTimeMillis() + (j * 1000));
        int i = time2.yearDay - time.yearDay;
        String format = time2.format(ContextUtils.getString(R.string.route_time_format));
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        switch (i) {
            case 0:
                arrayList.add(ContextUtils.getString(R.string.route_time_prefix));
                arrayList.add(format);
                arrayList.add(ContextUtils.getString(R.string.route_time_suffix));
                break;
            case 1:
                arrayList.add(ContextUtils.getString(R.string.route_time_prefix2));
                arrayList.add(format);
                arrayList.add(ContextUtils.getString(R.string.route_time_suffix));
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                arrayList.add(getDayOfWeekOfTravelTime(i));
                arrayList.add(format);
                arrayList.add(ContextUtils.getString(R.string.route_time_suffix));
                break;
            default:
                arrayList.add(ContextUtils.getString(R.string.route_time_prefix));
                arrayList.add(format);
                arrayList.add(ContextUtils.getString(R.string.route_time_suffix));
                break;
        }
        return arrayList;
    }

    @Nullable
    private static String getDayOfWeekOfTravelTime(int i) {
        if (i <= 0 || i >= 7) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        switch ((calendar.get(7) + i) % 7) {
            case 0:
                return ContextUtils.getString(R.string.route_time_prefix_dayofweek6);
            case 1:
                return ContextUtils.getString(R.string.route_time_prefix_dayofweek7);
            case 2:
                return ContextUtils.getString(R.string.route_time_prefix_dayofweek1);
            case 3:
                return ContextUtils.getString(R.string.route_time_prefix_dayofweek2);
            case 4:
                return ContextUtils.getString(R.string.route_time_prefix_dayofweek3);
            case 5:
                return ContextUtils.getString(R.string.route_time_prefix_dayofweek4);
            case 6:
                return ContextUtils.getString(R.string.route_time_prefix_dayofweek5);
            default:
                return "";
        }
    }

    public static String getInfoFlowDistanceRemain(double d) {
        String string;
        if (d >= 1000.0d) {
            string = ContextUtils.getString(R.string.unit_km);
        } else {
            string = ContextUtils.getString(R.string.unit_meter);
        }
        return XUINavigationInfoUpload.getDistanceDisplay(d, false) + string;
    }

    public static String getTimeShortString(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        long j = (long) (d / 3600.0d);
        long j2 = (long) ((d % 3600.0d) / 60.0d);
        StringBuilder sb = new StringBuilder();
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            sb.append(ContextUtils.getString(R.string.info_flow_hour, String.valueOf(j)));
        }
        if (d >= 0.0d && j2 == 0 && i == 0) {
            j2 = 1;
        }
        if (j2 > 0) {
            sb.append(ContextUtils.getString(R.string.info_flow_minute, String.valueOf(j2)));
        }
        return sb.toString();
    }

    public static SpannableString getSpannableString(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 17);
        return spannableString;
    }

    public static XPPointBaseData transformPOIToBizPoint(POIInfo pOIInfo) {
        XPPointBaseData xPPointBaseData = new XPPointBaseData();
        xPPointBaseData.id = pOIInfo.toString();
        if (pOIInfo.realPos != null) {
            xPPointBaseData.position.lon = pOIInfo.realPos.lon;
            xPPointBaseData.position.lat = pOIInfo.realPos.lat;
        } else {
            xPPointBaseData.position.lon = 0.0d;
            xPPointBaseData.position.lat = 0.0d;
        }
        return xPPointBaseData;
    }

    @NonNull
    public static XPPointBaseData transformXPPOIToBizPoint(@NonNull XPPoiInfo xPPoiInfo) {
        XPPointBaseData xPPointBaseData = new XPPointBaseData();
        xPPointBaseData.id = xPPoiInfo.getPoiId();
        xPPointBaseData.position.lon = xPPoiInfo.getDisplayLon();
        xPPointBaseData.position.lat = xPPoiInfo.getDisplayLat();
        return xPPointBaseData;
    }

    public static XPPointBaseData[] transformXPPOIListToBizPointArray(List<XPPoiInfo> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            XPPointBaseData[] xPPointBaseDataArr = new XPPointBaseData[list.size()];
            int i = 0;
            for (XPPoiInfo xPPoiInfo : list) {
                if (xPPoiInfo != null) {
                    xPPointBaseDataArr[i] = transformXPPOIToBizPoint(xPPoiInfo);
                    i++;
                }
            }
            return xPPointBaseDataArr;
        }
        return null;
    }

    @Nullable
    public static Coord3DDouble transformCoord2DDoubleToCoord3DDouble(@Nullable XPCoordinate2DDouble xPCoordinate2DDouble) {
        if (xPCoordinate2DDouble == null) {
            return null;
        }
        return new Coord3DDouble(xPCoordinate2DDouble.mLon, xPCoordinate2DDouble.mLat, 0.0d);
    }

    public static int getNaviRouteOverviewOffsetLeft(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.navi_overview_offset_left);
    }

    public static int getNaviRouteOverviewOffsetLeftSpecial(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.navi_overview_offset_left_special);
    }

    public static int getNaviRouteOverviewOffsetTop(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.navi_overview_offset_top);
    }

    public static int getNaviRouteOverviewOffsetRight(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.navi_overview_offset_right);
    }

    public static int getNaviRouteOverviewOffsetBottom(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.navi_overview_offset_bottom);
    }

    public static Rect getRoutePathOffsetRect() {
        return sRoutePathOffsetRect;
    }

    public static Rect getRoutePathOffsetRectForVoiceFusion() {
        return sRoutePathOffsetRectForVoiceFusion;
    }

    public static Rect getExploreRouteOffsetRect(boolean z) {
        return z ? sExplorePathOffsetRectOnLeftPanelShow : sExplorePathOffsetRect;
    }

    public static Rect getPoiCardOffsetRect() {
        return sPoiCardoffsetRect;
    }

    public static Rect getExploreOffsetRectImmersio(boolean z) {
        return z ? sExploreOffsetRectImmersioWhenLeftPanelShow : sExploreOffsetRectImmersio;
    }

    public static int getRouteRoadCardOverviewOffsetBottom(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.route_overview_have_road_offset_bottom);
    }

    public static Bitmap eraseArrayBackground(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = width * height;
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] == -65281) {
                iArr[i5] = iArr2[i5];
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.RGB_565);
        Bitmap crossRoundBitmap = getCrossRoundBitmap(createBitmap, i, i2, i3);
        if (createBitmap != null && !createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
        return crossRoundBitmap;
    }

    public static Bitmap getCrossRoundBitmap(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        canvas.drawARGB(0, 0, 0, 0);
        float f = i;
        float f2 = i2;
        canvas.drawRoundRect(rectF, f, f2, paint);
        if ((i3 & 1) == 0) {
            canvas.drawRect(new RectF(0.0f, 0.0f, f, f2), paint);
        }
        if ((i3 & 2) == 0) {
            canvas.drawRect(new RectF(0.0f, height - i2, f, height), paint);
        }
        if ((i3 & 4) == 0) {
            canvas.drawRect(new RectF(width - i, 0.0f, width, f2), paint);
        }
        if ((i3 & 8) == 0) {
            canvas.drawRect(new RectF(width - i, height - i2, width, height), paint);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static boolean isDestinationInVia(List<XPViaPoint> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        for (XPViaPoint xPViaPoint : list) {
            if (xPViaPoint != null && xPViaPoint.getPoiPoint() != null && isSamePOI(endInfo, xPViaPoint.getPoiPoint())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isViaPassed(XPPoiInfo xPPoiInfo) {
        List<XPViaPoint> viaInfos;
        if (xPPoiInfo == null || !isExistedViaPoi(xPPoiInfo, false) || (viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId())) == null) {
            return false;
        }
        for (int size = viaInfos.size() - 1; size >= 0; size--) {
            XPViaPoint xPViaPoint = viaInfos.get(size);
            if (xPViaPoint != null && isSamePOI(xPPoiInfo, xPViaPoint.getPoiPoint())) {
                return xPViaPoint.getIsPassedVia();
            }
        }
        return false;
    }

    public static boolean isExistedViaPoi(List<XPViaPoint> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (!CollectionUtils.isNotEmpty(viaInfos) || list.size() < viaInfos.size()) {
            return false;
        }
        int i = 0;
        for (XPViaPoint xPViaPoint : list) {
            for (XPViaPoint xPViaPoint2 : viaInfos) {
                if (xPViaPoint2.getPoiPoint() != null && isSamePOI(xPViaPoint.getPoiPoint(), xPViaPoint2.getPoiPoint()) && !xPViaPoint2.getIsPassedVia()) {
                    i++;
                }
            }
        }
        return i == list.size();
    }

    public static boolean isExistedViaPoi(XPPoiInfo xPPoiInfo) {
        boolean isExistedViaPoi = isExistedViaPoi(xPPoiInfo, true);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isExistedViaPoi return " + isExistedViaPoi);
        }
        return isExistedViaPoi;
    }

    public static boolean isExistedViaPoi(XPPoiInfo xPPoiInfo, boolean z) {
        if (xPPoiInfo == null) {
            return false;
        }
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
        if (CollectionUtils.isNotEmpty(viaInfos)) {
            Iterator<XPViaPoint> it = viaInfos.iterator();
            while (it.hasNext()) {
                XPViaPoint next = it.next();
                boolean z2 = next != null && isSamePOI(xPPoiInfo, next.getPoiPoint());
                if (z) {
                    z2 &= !next.getIsPassedVia();
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSamePOI(@NonNull XPPoiInfo xPPoiInfo, @NonNull XPPoiInfo xPPoiInfo2, boolean z) {
        return NavCoreUtil.isSamePOI(xPPoiInfo, xPPoiInfo2, z);
    }

    public static boolean isSamePOI(@NonNull XPPoiInfo xPPoiInfo, @NonNull XPPoiInfo xPPoiInfo2) {
        return NavCoreUtil.isSamePOI(xPPoiInfo, xPPoiInfo2);
    }

    public static int getNaviConestionDis(NaviCongestionInfo naviCongestionInfo, int i) {
        int size;
        if (naviCongestionInfo == null || naviCongestionInfo.congestionInfos == null || (size = naviCongestionInfo.congestionInfos.size()) <= 0) {
            return 0;
        }
        for (int i2 = 0; i2 < size; i2++) {
            NaviCongestionDetailInfo naviCongestionDetailInfo = naviCongestionInfo.congestionInfos.get(i2);
            if (naviCongestionDetailInfo != null && i == naviCongestionDetailInfo.status) {
                return naviCongestionDetailInfo.remainDist;
            }
        }
        return 0;
    }

    public static XPNaviCongestionDetailInfo getNaviCongestionDetailInfo(XPNaviCongestionInfo xPNaviCongestionInfo, int i) {
        if (xPNaviCongestionInfo == null || xPNaviCongestionInfo.mCongestionInfos == null) {
            return null;
        }
        for (int i2 = 0; i2 < xPNaviCongestionInfo.mCongestionInfos.length; i2++) {
            XPNaviCongestionDetailInfo xPNaviCongestionDetailInfo = xPNaviCongestionInfo.mCongestionInfos[i2];
            if (xPNaviCongestionDetailInfo != null && i == xPNaviCongestionDetailInfo.mStatus) {
                return xPNaviCongestionDetailInfo;
            }
        }
        return null;
    }

    public static String getIncidentDesc(Context context, TrafficIncident trafficIncident) {
        short s = trafficIncident.titleType;
        if (s != 0) {
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        return s != 4 ? "" : context.getString(R.string.avoid_traffic_out_rout_tips_content_elem, trafficIncident.title);
                    }
                    return trafficIncident.title;
                }
                return context.getString(R.string.road_end_close);
            }
            return context.getString(R.string.road_via_close);
        }
        return context.getString(R.string.road_start_close);
    }

    public static String getAvoidJamDesc(Context context, AvoidTrafficJamInfo avoidTrafficJamInfo) {
        String str = "";
        if (avoidTrafficJamInfo == null || TextUtils.isEmpty(avoidTrafficJamInfo.roadName)) {
            return "";
        }
        short s = avoidTrafficJamInfo.status;
        if (s == 2) {
            str = context.getString(R.string.jam_status_2);
        } else if (s == 3) {
            str = context.getString(R.string.jam_status_3);
        } else if (s == 4) {
            str = context.getString(R.string.jam_status_4);
        }
        return ContextUtils.getString(R.string.avoid_traffic_avoid_jam_tips_title, avoidTrafficJamInfo.roadName, str) + TRAFFIC_STRING_SPLITTER + ContextUtils.getString(R.string.avoid_traffic_avoid_jam_tips_content, NavCoreUtil.getDistanceString(avoidTrafficJamInfo.length), getTimeString(avoidTrafficJamInfo.travelTime));
    }

    public static NaviRouteInfo parseNaviUri(Uri uri) {
        MapRouteMsg mapRouteMsg;
        XPPoiInfo startPOIFromCurrent;
        if (uri == null || !ROUTE_URI_SCHEME.equals(uri.getScheme())) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("data");
        if (TextUtils.isEmpty(queryParameter) || (mapRouteMsg = (MapRouteMsg) GsonUtil.fromJson(queryParameter, (Class<Object>) MapRouteMsg.class)) == null) {
            return null;
        }
        NaviRouteInfo naviRouteInfo = new NaviRouteInfo();
        MapPoint start = mapRouteMsg.getStart();
        MapPoint dest = mapRouteMsg.getDest();
        MapPoint[] via = mapRouteMsg.getVia();
        if (start != null) {
            startPOIFromCurrent = new XPPoiInfo();
            startPOIFromCurrent.setDisplayLat(start.getLat());
            startPOIFromCurrent.setDisplayLon(start.getLon());
            startPOIFromCurrent.setName(start.getName());
            startPOIFromCurrent.setAddress(start.getAddress());
        } else {
            startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        }
        naviRouteInfo.setStartInfo(startPOIFromCurrent);
        if (dest != null) {
            XPPoiInfo xPPoiInfo = new XPPoiInfo();
            xPPoiInfo.setDisplayLat(dest.getLat());
            xPPoiInfo.setDisplayLon(dest.getLon());
            xPPoiInfo.setNaviLat(dest.getLat());
            xPPoiInfo.setNaviLat(dest.getLat());
            xPPoiInfo.setName(xPPoiInfo.getName());
            xPPoiInfo.setAddress(xPPoiInfo.getAddress());
            XPPoiInfo.generatePoiIdIfEmpty(xPPoiInfo, 6);
            naviRouteInfo.setEndInfo(xPPoiInfo);
        }
        if (via != null) {
            ArrayList arrayList = new ArrayList();
            for (MapPoint mapPoint : via) {
                XPPoiInfo xPPoiInfo2 = new XPPoiInfo();
                xPPoiInfo2.setDisplayLat(mapPoint.getLat());
                xPPoiInfo2.setDisplayLon(mapPoint.getLon());
                xPPoiInfo2.setNaviLat(mapPoint.getLat());
                xPPoiInfo2.setNaviLat(mapPoint.getLat());
                xPPoiInfo2.setName(mapPoint.getName());
                xPPoiInfo2.setAddress(mapPoint.getAddress());
                XPPoiInfo.generatePoiIdIfEmpty(xPPoiInfo2, 6);
                arrayList.add(new XPViaPoint(xPPoiInfo2));
            }
            naviRouteInfo.setViaList(arrayList);
        }
        return naviRouteInfo;
    }

    public static ArrayList<XPPoiInfo> transformXPViaPointToXPPoiInfo(List<XPViaPoint> list) {
        if (list != null) {
            ArrayList<XPPoiInfo> arrayList = new ArrayList<>();
            for (XPViaPoint xPViaPoint : list) {
                arrayList.add(xPViaPoint.getPoiPoint());
            }
            return arrayList;
        }
        return null;
    }

    public static int checkBatteryStatus(long j, int i) {
        int i2;
        try {
            i2 = checkDistanceReachableStatus(j, i);
        } catch (DistanceStatusIllegalArgumentException unused) {
            if (L.ENABLE) {
                L.d(TAG, "INVALID remain dis and leftDistance remain dis: " + j + " leftDis: " + i);
            }
            i2 = -1;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return -1;
                }
            } else if (i > 30000) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    public static int checkColorStatus(long j, int i) {
        return ContextUtils.getContext().getResources().getColor(getRemainDisColorStatusResId(j, i));
    }

    public static int getRemainDisColorStatusResId(long j, int i) {
        int i2;
        try {
            i2 = checkDistanceReachableStatus(j, i);
        } catch (DistanceStatusIllegalArgumentException unused) {
            if (L.ENABLE) {
                L.d(TAG, "INVALID remain dis and leftDistance remain dis: " + j + " leftDis: " + i);
            }
            i2 = 2;
        }
        int colorResId = ThemeWatcherUtil.getColorResId(R.color.batter_status_normal);
        if (i2 != 0) {
            if (i2 == 1) {
                if (i <= 30000) {
                    return ThemeWatcherUtil.getColorResId(R.color.batter_status_warning);
                }
                return ThemeWatcherUtil.getColorResId(R.color.batter_status_normal);
            } else if (i2 != 2) {
                return colorResId;
            } else {
                if (i <= 1000) {
                    return ThemeWatcherUtil.getColorResId(R.color.batter_status_low_power);
                }
                return ThemeWatcherUtil.getColorResId(R.color.batter_status_warning);
            }
        }
        return ThemeWatcherUtil.getColorResId(R.color.batter_status_unreachable);
    }

    public static int checkDistanceReachableStatus(long j, int i) throws DistanceStatusIllegalArgumentException {
        if (j >= i) {
            if (i >= 30000) {
                return 1;
            }
            return i <= 1000 ? 0 : 2;
        }
        throw new DistanceStatusIllegalArgumentException("carRemainDis is greater than remainDis ");
    }

    private static String getRoutePointArrivals() {
        int passingViaIndex = TBTManager.getInstance().getPassingViaIndex();
        return ContextUtils.getString(passingViaIndex != 0 ? passingViaIndex != 1 ? passingViaIndex != 2 ? R.string.tv_power_endurance_name : R.string.tv_power_via3_endurance_name : R.string.tv_power_via2_endurance_name : R.string.tv_power_via1_endurance_name);
    }

    public static String getRoutePointSuffix() {
        int i;
        switch (TBTManager.getInstance().getPassingViaIndex()) {
            case 0:
                i = R.string.navi_reach_via1_suffix;
                break;
            case 1:
                i = R.string.navi_reach_via2_suffix;
                break;
            case 2:
                i = R.string.navi_reach_via3_suffix;
                break;
            case 3:
                i = R.string.navi_reach_via4_suffix;
                break;
            case 4:
                i = R.string.navi_reach_via5_suffix;
                break;
            case 5:
                i = R.string.navi_reach_via6_suffix;
                break;
            case 6:
                i = R.string.navi_reach_via7_suffix;
                break;
            case 7:
                i = R.string.navi_reach_via8_suffix;
                break;
            case 8:
                i = R.string.navi_reach_via9_suffix;
                break;
            case 9:
                i = R.string.navi_reach_via10_suffix;
                break;
            case 10:
                i = R.string.navi_reach_via11_suffix;
                break;
            case 11:
                i = R.string.navi_reach_via12_suffix;
                break;
            default:
                i = -1;
                break;
        }
        return i == -1 ? "" : ContextUtils.getString(i);
    }

    private static String getRoutePointUnArrivals() {
        int passingViaIndex = TBTManager.getInstance().getPassingViaIndex();
        return ContextUtils.getString(passingViaIndex != 0 ? passingViaIndex != 1 ? passingViaIndex != 2 ? R.string.navi_unable_reach_des : R.string.navi_unable_reach_via3_des : R.string.navi_unable_reach_via2_des : R.string.navi_unable_reach_via1_des);
    }

    public static String getRemainDistanceDescription(long j, int i) throws IllegalArgumentException {
        int i2;
        try {
            i2 = checkDistanceReachableStatus(j, i);
        } catch (DistanceStatusIllegalArgumentException unused) {
            if (L.ENABLE) {
                L.d(TAG, "INVALID remain dis and leftDistance remain dis: " + j + " leftDis: " + i);
            }
            i2 = 2;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                return i2 != 2 ? "" : ContextUtils.getString(R.string.navi_lower_power_des);
            }
            return getRoutePointArrivals();
        }
        return getRoutePointUnArrivals();
    }

    public static int getCrossViewLeft(boolean z) {
        return ContextUtils.getDimensionPixelSize(R.dimen.guide_cross_view_left_immersion);
    }

    public static int getCrossViewTop(boolean z) {
        return ContextUtils.getDimensionPixelSize(z ? R.dimen.guide_cross_view_top_immersion : R.dimen.guide_cross_view_top);
    }

    public static int getCrossViewWidth() {
        return ContextUtils.getDimensionPixelSize(R.dimen.guide_cross_view_width);
    }

    public static int getCrossViewHeight() {
        return ContextUtils.getDimensionPixelSize(R.dimen.guide_cross_view_height);
    }

    public static void checkRestore(int i, long j, NavRestoreManager.CheckRestoreCallback checkRestoreCallback) {
        String name;
        if (i != 0) {
            if (checkRestoreCallback != null) {
                checkRestoreCallback.restoreNone();
                return;
            }
            return;
        }
        RouteParams restoreRouteParams = getRestoreRouteParams();
        int i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.KEY_ROUTE_LAST_DISTANCE, 0);
        double d = DataSetHelper.GlobalSet.getDouble(DataSetHelper.GlobalSet.KEY_ROUTE_LAST_LINEAR_DISTANCE, 0.0d);
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("screen on ==> tbt routeParams: ");
        if (restoreRouteParams == null) {
            name = "null";
        } else {
            name = restoreRouteParams.mEndInfo == null ? "" : restoreRouteParams.mEndInfo.getName();
        }
        sb.append(name);
        sb.append(", lastLeftDistance: ");
        sb.append(i2);
        sb.append(", lastLinearDistance: ");
        sb.append(d);
        sb.append("timespan:");
        sb.append(j);
        L.i(tag, sb.toString());
        if (d <= 1000.0d) {
            if (checkRestoreCallback != null) {
                checkRestoreCallback.restoreNone();
            }
        } else if (j <= NavRestoreManager.SILENCE_TIME_SPAN_90MIN) {
            if (checkRestoreCallback != null) {
                checkRestoreCallback.restoreNavImmediate(restoreRouteParams);
            }
        } else if ((d >= 100000.0d || j >= NavRestoreManager.SILENCE_TIME_SPAN_3H) && (d < 100000.0d || j >= NavRestoreManager.SILENCE_TIME_SPAN_12H)) {
            if (checkRestoreCallback != null) {
                checkRestoreCallback.restoreNone();
            }
        } else if (checkRestoreCallback != null) {
            checkRestoreCallback.restoreNavLater();
        }
    }

    public static RouteParams getRestoreRouteParams() {
        FileIOUtil fileIOUtil = new FileIOUtil();
        return (RouteParams) fileIOUtil.readObjectFromSDCard(RootUtil.SD_CARD_DIR_GUIDE + NavRestoreManager.NAV_RESTORE_FILE_NAME);
    }

    public static long getTravelDistance(IVariantPath iVariantPath) {
        if (iVariantPath == null) {
            return getTravelDistance();
        }
        XPDrivePathAccessor drivePathAccessor = iVariantPath.getDrivePathAccessor();
        if (drivePathAccessor != null) {
            long length = drivePathAccessor.getLength();
            drivePathAccessor.recycle();
            return length;
        }
        return 0L;
    }

    public static long getTravelDistance() {
        XPDrivePathAccessor drivePathAccessor = getDrivePathAccessor();
        if (drivePathAccessor == null) {
            return 0L;
        }
        long length = drivePathAccessor.getLength();
        drivePathAccessor.recycle();
        return length;
    }

    public static long getTravelTime(IVariantPath iVariantPath) {
        if (iVariantPath == null) {
            return getTravelTime();
        }
        XPDrivePathAccessor drivePathAccessor = iVariantPath.getDrivePathAccessor();
        if (drivePathAccessor != null) {
            long travelTime = drivePathAccessor.getTravelTime();
            drivePathAccessor.recycle();
            return travelTime;
        }
        return 0L;
    }

    public static long getTravelTime() {
        XPDrivePathAccessor drivePathAccessor = getDrivePathAccessor();
        if (drivePathAccessor == null) {
            return 0L;
        }
        long travelTime = drivePathAccessor.getTravelTime();
        drivePathAccessor.recycle();
        return travelTime;
    }

    public static long getTrafficLightCount(IVariantPath iVariantPath) {
        if (iVariantPath == null) {
            return getTrafficLightCount();
        }
        XPDrivePathAccessor drivePathAccessor = iVariantPath.getDrivePathAccessor();
        if (drivePathAccessor != null) {
            long trafficLightCount = drivePathAccessor.getTrafficLightCount();
            drivePathAccessor.recycle();
            return trafficLightCount;
        }
        return 0L;
    }

    public static long getTrafficLightCount() {
        XPDrivePathAccessor drivePathAccessor = getDrivePathAccessor();
        if (drivePathAccessor == null) {
            return 0L;
        }
        long trafficLightCount = drivePathAccessor.getTrafficLightCount();
        drivePathAccessor.recycle();
        return trafficLightCount;
    }

    public static int getTollCost(IVariantPath iVariantPath) {
        if (iVariantPath == null) {
            return getTollCost();
        }
        XPDrivePathAccessor drivePathAccessor = iVariantPath.getDrivePathAccessor();
        if (drivePathAccessor != null) {
            int tollCost = drivePathAccessor.getTollCost();
            drivePathAccessor.recycle();
            return tollCost;
        }
        return 0;
    }

    public static int getTollCost() {
        XPDrivePathAccessor drivePathAccessor = getDrivePathAccessor();
        if (drivePathAccessor == null) {
            return 0;
        }
        int tollCost = drivePathAccessor.getTollCost();
        drivePathAccessor.recycle();
        return tollCost;
    }

    public static int getTollCost(long j, long j2, IVariantPath iVariantPath) {
        XPDrivePathAccessor drivePathAccessor;
        XPBaseSegmentAccessor segmentAccessor;
        XPBaseLinkAccessor linkAccessor;
        int i = 0;
        if (iVariantPath == null || j < 0 || (drivePathAccessor = iVariantPath.getDrivePathAccessor()) == null) {
            return 0;
        }
        int tollCost = drivePathAccessor.getTollCost();
        if (j < drivePathAccessor.getSegmentCount() && (segmentAccessor = drivePathAccessor.getSegmentAccessor(j)) != null && j2 > -1 && j2 < segmentAccessor.getLinkCount() && (linkAccessor = segmentAccessor.getLinkAccessor(j2)) != null && linkAccessor.isToll()) {
            j--;
        }
        while (true) {
            long j3 = i;
            if (j3 < Math.min(j, drivePathAccessor.getSegmentCount())) {
                XPBaseSegmentAccessor segmentAccessor2 = drivePathAccessor.getSegmentAccessor(j3);
                if (segmentAccessor2 != null) {
                    tollCost -= segmentAccessor2.getTollCost();
                }
                i++;
            } else {
                drivePathAccessor.recycle();
                return tollCost;
            }
        }
    }

    @NonNull
    public static StringBuilder getEndPosition() {
        StringBuilder sb = new StringBuilder();
        XPDrivePathAccessor drivePathAccessor = getDrivePathAccessor();
        if (drivePathAccessor == null) {
            return sb;
        }
        POIInfo endPoi = drivePathAccessor.getEndPoi();
        if (endPoi != null && endPoi.realPos != null) {
            sb.append(endPoi.realPos.lon);
            sb.append(",");
            sb.append(endPoi.realPos.lat);
        }
        drivePathAccessor.recycle();
        return sb;
    }

    @Nullable
    private static XPDrivePathAccessor getDrivePathAccessor() {
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        if (currentNaviVariantPath == null) {
            IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
            int currentNaviPathIndex = TBTManager.getInstance().getCurrentNaviPathIndex();
            if (currentNaviPathResult != null) {
                currentNaviVariantPath = currentNaviPathResult.getPath(currentNaviPathIndex);
            }
        }
        if (currentNaviVariantPath != null) {
            return currentNaviVariantPath.getDrivePathAccessor();
        }
        return null;
    }

    public static boolean isNeedReroute(int i, int i2) {
        int itemGroupSelectedValue = SettingWrapper.getItemGroupSelectedValue(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE);
        int i3 = i2 & itemGroupSelectedValue;
        int i4 = itemGroupSelectedValue & i;
        int itemGroupSelectedValue2 = SettingWrapper.getItemGroupSelectedValue(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_AVOID_RESTRICTION_ROUTE);
        int i5 = i2 & itemGroupSelectedValue2;
        int i6 = itemGroupSelectedValue2 & i;
        int itemGroupSelectedValue3 = SettingWrapper.getItemGroupSelectedValue(DataSetHelper.AccountSet.KEY_SETTING_CHANGE_ROUTE_RADER);
        int i7 = i2 & itemGroupSelectedValue3;
        int i8 = i & itemGroupSelectedValue3;
        if (i3 == i4 && i5 == i6 && i7 == i8) {
            return false;
        }
        L.i(TAG, "refresh_setting_change isNeedReroute isRouteSettingStatusChange true");
        return true;
    }

    public static String[] getRemainDistanceArray(int i) {
        return NavCoreUtil.getRemainDistanceArray(i);
    }

    public static String[] getDistanceArray(double d) {
        return NavCoreUtil.getDistanceArray(d);
    }

    public static String getDistanceString(long j) {
        return NavCoreUtil.getDistanceString(j);
    }

    public static String getDistanceString(double d) {
        return NavCoreUtil.getDistanceString(d);
    }

    public static String[] getRemainDistanceArray(double d) {
        return NavCoreUtil.getRemainDistanceArray(d);
    }

    public static List<String> getNaviTimeString(long j) {
        return NavCoreUtil.getNaviTimeString(j);
    }

    public static String getDistanceNoSpaceString(long j) {
        return NavCoreUtil.getDistanceNoSpaceString(j);
    }

    public static String[] getDistanceArray(int i, boolean z) {
        return NavCoreUtil.getDistanceArray(i, z);
    }

    public static boolean checkShowAllTime(int i) {
        return NavCoreUtil.checkShowAllTime(i);
    }

    public static List<String> getNaviTimeString(double d, int i) {
        return NavCoreUtil.getNaviTimeString(d, i);
    }

    /* loaded from: classes3.dex */
    public static class DistanceStatusIllegalArgumentException extends Exception {
        public DistanceStatusIllegalArgumentException(String str) {
            super(str);
        }
    }
}
