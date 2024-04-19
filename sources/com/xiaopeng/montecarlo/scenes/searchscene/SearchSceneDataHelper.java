package com.xiaopeng.montecarlo.scenes.searchscene;

import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bean.LocationRecognitionInfo;
import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.favorite.FavoriteDataManager;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.HomeOrCompanyInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IAssistantLocationService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantGetHomeOrCompanyRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.AssistantGetHomeOrCompanyResponse;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.speech.data.SpeechCacheData;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.cruisescene.CruiseSceneDataHelper;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class SearchSceneDataHelper {
    public static LocationRecognitionInfo company;
    public static LocationRecognitionInfo home;
    private static final L.Tag TAG = new L.Tag("SearchSceneDataHelper");
    private static IAssistantLocationService sAssistantLocationService = (IAssistantLocationService) HttpClientManager.getInstance().getService(IAssistantLocationService.class);

    public static boolean isXpAccountLogon() {
        return true;
    }

    public static boolean isSettingHome() {
        FavoriteAddress home2 = FavoriteDataManager.getInstance().getHome();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isSettingHome home:" + home2);
        }
        boolean z = home2 != null;
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "isSettingHome flag:" + z);
        }
        return z;
    }

    public static boolean isSettingCompany() {
        FavoriteAddress company2 = FavoriteDataManager.getInstance().getCompany();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isSettingCompany company:" + company2);
        }
        boolean z = company2 != null;
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "isSettingCompany flag:" + z);
        }
        return z;
    }

    public static boolean isInADay(int i) {
        long j;
        if (1 == i) {
            j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.CACHE_LAST_ALERT_FOR_SETTING_HOME_BY_CLOUD, 0L);
        } else {
            j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.CACHE_LAST_ALERT_FOR_SETTING_COMPANY_BY_CLOUD, 0L);
        }
        boolean z = CruiseSceneDataHelper.makeTimeToZero().getTimeInMillis() - j < 0;
        if (!z) {
            if (1 == i) {
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_LAST_ALERT_FOR_SETTING_HOME_BY_CLOUD, 0);
            } else {
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_LAST_ALERT_FOR_SETTING_COMPANY_BY_CLOUD, 0);
            }
        }
        L.Tag tag = TAG;
        L.i(tag, "isInADay type:" + i + ",flag:" + z);
        return z;
    }

    public static Calendar makeTimeToBase(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
        if (r1 >= com.xiaopeng.montecarlo.util.XpCacheConsts.ONE_WEEK) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00af, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b1, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (r1 >= 432000000) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isShouldShowSystemAlert(int r21) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.searchscene.SearchSceneDataHelper.isShouldShowSystemAlert(int):boolean");
    }

    public static boolean isOffDay() {
        return isSaturday() || isSunday();
    }

    public static boolean isWorkingDay() {
        return isMonday() || isTuesday();
    }

    public static boolean isSaturday() {
        return Calendar.getInstance().get(7) == 7;
    }

    public static boolean isSunday() {
        return Calendar.getInstance().get(7) == 1;
    }

    public static boolean isMonday() {
        return Calendar.getInstance().get(7) == 2;
    }

    public static boolean isTuesday() {
        return Calendar.getInstance().get(7) == 3;
    }

    public static void release() {
        home = null;
        company = null;
    }

    public static void fetchHomeFromCloud() {
        if (isSettingHome() || isInADay(1)) {
            L.i(TAG, "home already set or fetched in one day");
        } else if (!isXpAccountLogon()) {
            L.i(TAG, "getHomeFromCloud xp account not logon");
        } else {
            AssistantGetHomeOrCompanyResponse home2 = sAssistantLocationService.getHome(new AssistantGetHomeOrCompanyRequest().setUserId(0L).setVin(RootUtil.getVin()).setTs(Long.valueOf(System.currentTimeMillis())));
            if (home2 == null) {
                L.e(TAG, "fetchHomeFromCloud onFailure");
            } else {
                handlerFetchFromCloudSuccess(home2, 1);
            }
        }
    }

    private static void handlerFetchFromCloudSuccess(AssistantGetHomeOrCompanyResponse assistantGetHomeOrCompanyResponse, int i) {
        if (assistantGetHomeOrCompanyResponse == null) {
            L.Tag tag = TAG;
            L.i(tag, "handlerFetchFromCloudSuccess type:" + i + ",data is null");
            return;
        }
        L.Tag tag2 = TAG;
        L.i(tag2, "handlerFetchFromCloudSuccess type:1,data:" + GsonUtil.toJson(assistantGetHomeOrCompanyResponse));
        if (assistantGetHomeOrCompanyResponse.isFind()) {
            HomeOrCompanyInfo info = assistantGetHomeOrCompanyResponse.getInfo();
            LocationRecognitionInfo locationRecognitionInfo = new LocationRecognitionInfo();
            locationRecognitionInfo.setAddress(info.getAddress());
            locationRecognitionInfo.setPoiId(info.getPoiId());
            locationRecognitionInfo.setName(info.getName());
            locationRecognitionInfo.setLon(info.getLng());
            locationRecognitionInfo.setLat(info.getLat());
            locationRecognitionInfo.setGeoHash(info.getGeoHash());
            if (1 == i) {
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_LAST_ALERT_FOR_SETTING_HOME_BY_CLOUD, System.currentTimeMillis());
                home = locationRecognitionInfo;
                SpeechCacheData.getInstance().setHomeFromBigData(locationRecognitionInfo.toPoiBean());
                return;
            }
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_LAST_ALERT_FOR_SETTING_COMPANY_BY_CLOUD, System.currentTimeMillis());
            company = locationRecognitionInfo;
            SpeechCacheData.getInstance().setCompanyFromBigData(locationRecognitionInfo.toPoiBean());
        }
    }

    public static void fetchCompanyFromCloud() {
        if (isSettingCompany() || isInADay(2)) {
            L.i(TAG, "company already set or fetched in one day");
        } else if (!isXpAccountLogon()) {
            L.i(TAG, "getHomeFromCloud xp account not logon");
        } else {
            AssistantGetHomeOrCompanyResponse company2 = sAssistantLocationService.getCompany(new AssistantGetHomeOrCompanyRequest().setUserId(0L).setVin(RootUtil.getVin()).setTs(Long.valueOf(System.currentTimeMillis())));
            if (company2 == null) {
                L.e(TAG, "fetchHomeFromCloud onFailure");
            } else {
                handlerFetchFromCloudSuccess(company2, 2);
            }
        }
    }

    public static SpannableString formatBLRoadInfo(XPPoiInfo xPPoiInfo) {
        String roadInfo = xPPoiInfo.getRoadInfo();
        String replace = Html.fromHtml(roadInfo).toString().replace(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR, FDManager.LINE_SEPERATOR);
        String[] split = roadInfo.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        String str = replace;
        for (int i2 = 0; i2 < split.length; i2++) {
            String substring = split[i2].substring(split[i2].indexOf("\">") + 2, split[i2].indexOf("</font>"));
            str = str.replace(substring, "    " + substring);
            arrayList.add(substring);
        }
        SpannableString spannableString = new SpannableString(str.replace("m", ContextUtils.getString(R.string.unit_meter)));
        int i3 = 0;
        while (i < arrayList.size()) {
            String str2 = (String) arrayList.get(i);
            int indexOf = str.indexOf(str2, i3);
            int length = str2.length() + indexOf;
            if (indexOf >= 0) {
                if (str2.contains(ContextUtils.getString(R.string.road_info_congestion))) {
                    spannableString.setSpan(new ForegroundColorSpan(ContextUtils.getColor(R.color.search_road_info_congestion)), indexOf, length, 33);
                } else {
                    spannableString.setSpan(new ForegroundColorSpan(ContextUtils.getColor(R.color.palette_tag_light_green)), indexOf, length, 33);
                }
            }
            i++;
            i3 = length;
        }
        return spannableString;
    }

    public static String formatContactTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "formatContactTime originTime:" + str);
        }
        String string = ContextUtils.getString(R.string.time_prefix_open_time);
        if (str.indexOf(string) >= 0) {
            str = str.replaceAll(string, "");
        }
        String string2 = ContextUtils.getString(R.string.time_prefix_business_time);
        if (str.indexOf(string2) >= 0) {
            str = str.replaceAll(string2, "");
        }
        return str.replaceAll("\t", "").replaceAll(" ", "");
    }
}
