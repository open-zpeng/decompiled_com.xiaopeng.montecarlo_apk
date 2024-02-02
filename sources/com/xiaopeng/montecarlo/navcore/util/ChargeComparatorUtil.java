package com.xiaopeng.montecarlo.navcore.util;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class ChargeComparatorUtil implements Comparator<XPPoiInfo> {
    @Override // java.util.Comparator
    public int compare(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
        if (xPPoiInfo.getCategory() < xPPoiInfo2.getCategory()) {
            return -1;
        }
        if (xPPoiInfo.getCategory() <= xPPoiInfo2.getCategory() && xPPoiInfo.getDistance() <= xPPoiInfo2.getDistance()) {
            return xPPoiInfo.getDistance() < xPPoiInfo2.getDistance() ? -1 : 0;
        }
        return 1;
    }
}
