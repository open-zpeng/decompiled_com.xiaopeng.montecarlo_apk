package com.xiaopeng.montecarlo.navcore.xptbt.navigationinfoprovider;

import com.xiaopeng.montecarlo.navcore.bean.location.XPLocInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import java.util.List;
/* loaded from: classes3.dex */
public interface INavigationInfoUploadStrategy {
    void resetNavi();

    void updateCrossInfo(XPCrossImageInfo xPCrossImageInfo, int i, boolean z);

    void updateCruiseCameraInfo(List<XPFacilityInfo> list);

    void updateCruiseLaneInfo(XPLaneInfo xPLaneInfo, boolean z);

    void updateIntervalCameraInfo(List<XPCameraInfo> list);

    void updateLaneInfo(XPLaneInfo xPLaneInfo, XPTollGateInfo xPTollGateInfo, boolean z);

    void updateLocInfo(XPLocInfo xPLocInfo);

    void updateManeuverInfo(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo);

    void updateNaviInfo(XPNaviInfo xPNaviInfo, XPExitDirectionInfo xPExitDirectionInfo);

    void updateNaviRemainDistInfo(int i, int i2, int i3);

    void updateNaviStop();

    void updateNormalCameraInfo(List<XPCameraInfo> list);

    void updateSapaInfo(List<XPFacilityInfo> list);
}
