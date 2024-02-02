package com.xiaopeng.montecarlo.navcore.xptbt;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCruiseInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import java.util.List;
/* loaded from: classes2.dex */
public interface ICruiseListener {
    void onUpdateCruiseCongestionInfo(XPCruiseCongestionInfo xPCruiseCongestionInfo);

    void onUpdateCruiseFacility(List<XPFacilityInfo> list);

    void onUpdateCruiseInfo(XPCruiseInfo xPCruiseInfo);

    void onUpdateCruiseLaneInfo(XPLaneInfo xPLaneInfo, boolean z);
}
