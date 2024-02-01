package com.xiaopeng.montecarlo.navcore.xptbt;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class ViasHelper {
    private static final L.Tag TAG = new L.Tag("ViasHelper");
    private static final ViasHelper sViasHelper = new ViasHelper();
    private boolean mIsNeedUpdateViaInfos;
    private long mLastNaviId = 0;
    private ViasStatus[] mViasStatusArray;

    /* loaded from: classes3.dex */
    public static class ViasStatus {
        long mPathId;
        int[] mViasRemainFromStartPoint;
    }

    private ViasHelper() {
    }

    public static final ViasHelper getInstance() {
        return sViasHelper;
    }

    public void updateViaDist(List<XPNaviInfo> list, boolean z) {
        this.mIsNeedUpdateViaInfos = false;
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        if (this.mLastNaviId != currentNaviId || z) {
            this.mLastNaviId = currentNaviId;
            if (CollectionUtils.isEmpty(TBTManager.getInstance().getViaInfos(currentNaviId))) {
                return;
            }
            this.mViasStatusArray = new ViasStatus[list.size()];
            for (int i = 0; i < list.size(); i++) {
                XPNaviInfo xPNaviInfo = list.get(i);
                if (xPNaviInfo.mViaRemainDist == null) {
                    return;
                }
                ViasStatus viasStatus = new ViasStatus();
                viasStatus.mPathId = xPNaviInfo.mPathID;
                viasStatus.mViasRemainFromStartPoint = Arrays.copyOf(xPNaviInfo.mViaRemainDist, xPNaviInfo.mViaRemainDist.length);
                this.mViasStatusArray[i] = viasStatus;
            }
            this.mIsNeedUpdateViaInfos = true;
        }
    }

    public void updateViaDist(List<XPNaviInfo> list, long j) {
        XPNaviInfo xPNaviInfo;
        updateViaDist(list, true);
        if (this.mIsNeedUpdateViaInfos) {
            RouteResult.RouteInfo routeResultInfo = TBTManager.getInstance().getRouteResultInfo(TBTManager.getInstance().getCurrentNaviId(), j);
            if (routeResultInfo == null || !CollectionUtils.isNotEmpty(list) || (xPNaviInfo = list.get(0)) == null) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.v(tag, " updateViaDist pathLength:" + routeResultInfo.mPathLength + "   routeRemain:" + xPNaviInfo.mRouteRemainDist);
            }
            if (Math.abs(routeResultInfo.mPathLength - xPNaviInfo.mRouteRemainDist) < 5.0d) {
                updateViaInfos(j);
            }
        }
    }

    public void updateViaInfos(long j) {
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        if (CollectionUtils.isEmpty(this.mViasStatusArray)) {
            return;
        }
        int[] iArr = null;
        int i = 0;
        while (true) {
            ViasStatus[] viasStatusArr = this.mViasStatusArray;
            if (i >= viasStatusArr.length) {
                break;
            }
            if (viasStatusArr[i] != null && viasStatusArr[i].mPathId == j) {
                iArr = this.mViasStatusArray[i].mViasRemainFromStartPoint;
                break;
            }
            i++;
        }
        if (CollectionUtils.isEmpty(iArr)) {
            return;
        }
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(currentNaviId);
        int lastPassedIndexDiff = TBTManager.getInstance().getLastPassedIndexDiff();
        if (CollectionUtils.isNotEmpty(viaInfos) && viaInfos.size() - lastPassedIndexDiff == iArr.length) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = i2 + lastPassedIndexDiff;
                if (i3 < viaInfos.size()) {
                    viaInfos.get(i3).setDistance(iArr[i2]);
                }
            }
        }
    }
}
