package com.xiaopeng.montecarlo.navcore.xptbt;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteDataModel;
import java.util.Map;
/* loaded from: classes2.dex */
public interface IRequestLevelStrategy {
    public static final int REQUEST_CANCELING_WAIT = 2;
    public static final int REQUEST_CANCEL_LAST = 1;
    public static final int REQUEST_IGNORE = 0;
    public static final int REQUEST_ROUTING_WAIT = 3;

    int getRequestPriority(Map<Long, RouteDataModel> map, long j, int i, long j2);
}
