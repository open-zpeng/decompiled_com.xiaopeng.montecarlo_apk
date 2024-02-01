package com.xiaopeng.montecarlo.scenes.cruisescene;

import com.xiaopeng.montecarlo.navcore.httpclient.dto.AssistantDateInfo;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class CruiseSceneDataHelper {
    private static final L.Tag TAG = new L.Tag("CruiseSceneDataHelper");
    public static final int TYPE_COMPANY = 2;
    public static final int TYPE_HOME = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_VIN_LICENSE_PLATE = 3;

    public static Calendar makeTimeToZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public int checkGoHomeOrCompany(AssistantDateInfo assistantDateInfo) {
        int i = 0;
        if (assistantDateInfo == null) {
            return 0;
        }
        long timeInMillis = makeTimeToZero().getTimeInMillis();
        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        if (!assistantDateInfo.isWorkingDay()) {
            return (timeInMillis2 < 72000000 + timeInMillis || timeInMillis2 > timeInMillis + 100800000) ? 0 : 1;
        }
        long j = 100800000 + timeInMillis;
        if (timeInMillis2 >= 57600000 + timeInMillis && timeInMillis2 <= j) {
            i = 1;
        }
        long j2 = 18000000 + timeInMillis;
        long j3 = timeInMillis + 36000000;
        if (timeInMillis2 < j2 || timeInMillis2 > j3) {
            return i;
        }
        return 2;
    }

    public boolean isInADay(int i) {
        long j;
        if (1 == i) {
            j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_HOME, 0L);
        } else if (2 == i) {
            j = DataSetHelper.AccountSet.getLong(DataSetHelper.AccountSet.CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_COMPANY, 0L);
        } else {
            j = 3 == i ? DataSetHelper.GlobalSet.getLong(DataSetHelper.GlobalSet.CACHE_LAST_TIME_FOR_VIN_LICENSE_PLATE, 0L) : 0L;
        }
        boolean z = makeTimeToZero().getTimeInMillis() - j < 0;
        if (!z) {
            if (1 == i) {
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_HOME, 0);
            } else if (2 == i) {
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_COMPANY, 0);
            } else if (3 == i) {
                DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_LAST_TIME_FOR_VIN_LICENSE_PLATE, 0);
            }
        }
        L.Tag tag = TAG;
        L.i(tag, "isInADay type:" + i + ",isSameDayWithLastTime:" + z);
        return z;
    }

    public void saveCommutingForecastLastShowTime(int i) {
        if (1 == i) {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_HOME, System.currentTimeMillis());
        } else {
            DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.CACHE_COMMUTING_FORECAST_LAST_SHOWING_TIME_FOR_COMPANY, System.currentTimeMillis());
        }
    }

    public static void saveLastGetLicensePlateSuccessTime() {
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_LAST_TIME_FOR_VIN_LICENSE_PLATE, System.currentTimeMillis());
    }
}
