package com.xiaopeng.montecarlo.util;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PriceUtils {
    private static final L.Tag TAG = new L.Tag("PriceUtils");

    public static List<String[]> parsePrice(String str) {
        if (L.ENABLE) {
            L.d(TAG, "price:" + str);
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR)) {
                arrayList.add(str2.split(","));
            }
        }
        return arrayList;
    }

    public static int getMatchedIndex(List<String[]> list, String str) {
        if (CollectionUtils.isEmpty(list) || TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            String[] strArr = list.get(i);
            if (!CollectionUtils.isEmpty(strArr) && OpenTimeUtils.isTimeMatch(strArr[0], str)) {
                return i;
            }
        }
        return 0;
    }
}
