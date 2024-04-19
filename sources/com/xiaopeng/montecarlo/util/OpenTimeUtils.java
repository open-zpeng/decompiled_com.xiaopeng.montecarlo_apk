package com.xiaopeng.montecarlo.util;

import android.text.TextUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class OpenTimeUtils {
    private static final L.Tag TAG = new L.Tag("OpenTimeUtils");
    private static final String[] ALL_24HOUR_CASE = {"00:00-24:00", "00:00-23:59", "周一-周日00:00-24:00", "周一-周日00:00-23:59", "工作日:00:00-23:59,节假日:00:00-23:59", "00:00-00:00", "0:00-24:00", "00:00:00-23:59:59", "每天00:00-24:00", "周一至周日00:00-24:00", "营业开始时间：00:00:00营业结束时间：23:59:59"};
    private static final String[] ENDWITH_24HOUR_CASE = {"#00:00-24:00"};

    public static boolean is24Hour(String str) {
        if (L.ENABLE) {
            L.d(TAG, "openTime:" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = str.replaceAll("~", "-").replaceAll("至", "-").replaceAll(" ", "");
            if (CollectionUtils.isNotEmpty(ALL_24HOUR_CASE)) {
                for (String str2 : ALL_24HOUR_CASE) {
                    if (replaceAll.equalsIgnoreCase(str2)) {
                        return true;
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(ENDWITH_24HOUR_CASE)) {
                for (String str3 : ENDWITH_24HOUR_CASE) {
                    if (replaceAll.endsWith(str3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isOpenTime(String str, String str2, String str3) {
        String[] split;
        if (L.ENABLE) {
            L.d(TAG, "openTime:" + str + " weekday:" + str2 + " time:" + str3);
        }
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = str.replaceAll("~", "-").replaceAll("至", "-");
            if (replaceAll.contains("周")) {
                for (String str4 : replaceAll.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR)) {
                    if (str4.length() > 5 && isWeekdayMatch(str4.substring(0, 5), str2) && isOpenTime(str4.substring(5), str2, str3)) {
                        return true;
                    }
                }
            } else {
                for (String str5 : replaceAll.split("、")) {
                    if (isTimeMatch(str5, str3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isWeekdayMatch(String str, String str2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openWeekday:" + str + " weekday:" + str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String numFromWeekday = getNumFromWeekday(str);
            String numFromWeekday2 = getNumFromWeekday(str2);
            String[] split = numFromWeekday.split("-");
            if (split.length == 1) {
                if (split[0].equalsIgnoreCase(numFromWeekday2)) {
                    return true;
                }
            } else if (split.length == 2 && split[0].compareToIgnoreCase(numFromWeekday2) <= 0 && split[1].compareToIgnoreCase(numFromWeekday2) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTimeMatch(String str, String str2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "openTime:" + str + " time:" + str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.replace("~", "-").replace("至", "-").replaceAll(" ", "").split("-");
            if (split.length == 2 && split[0].compareToIgnoreCase(str2) <= 0 && split[1].compareToIgnoreCase(str2) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static String getNumFromWeekday(String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "weekday:" + str);
        }
        return !TextUtils.isEmpty(str) ? str.replace("一", "1").replace("二", "2").replace("三", "3").replace("四", "4").replace("五", "5").replace("六", BuildInfoUtils.BID_PT_SPECIAL_2).replace("日", "7").replace("天", "7").replace("至", "-").replace("~", "-").replace("周", "").replace("星期", "") : "";
    }
}
