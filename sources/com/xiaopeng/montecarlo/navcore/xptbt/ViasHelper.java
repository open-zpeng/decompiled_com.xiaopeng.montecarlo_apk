package com.xiaopeng.montecarlo.navcore.xptbt;

import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
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

    public static ViasHelper getInstance() {
        return sViasHelper;
    }

    public void updateViaDist(List<XPNaviInfo> list, boolean z) {
        RouteResult.RouteInfo routeResultInfo;
        this.mIsNeedUpdateViaInfos = false;
        if (CollectionUtils.isEmpty(list)) {
            L.w(TAG, "updateViaDist list:" + list);
            return;
        }
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        if (this.mLastNaviId == currentNaviId && !z) {
            L.w(TAG, "mLastNaviId:" + this.mLastNaviId + ", naviId:" + currentNaviId);
            return;
        }
        this.mLastNaviId = currentNaviId;
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(currentNaviId);
        if (CollectionUtils.isEmpty(viaInfos)) {
            L.w(TAG, "updateViaDist xpViaPoints:" + viaInfos);
            return;
        }
        this.mViasStatusArray = new ViasStatus[list.size()];
        for (int i = 0; i < list.size(); i++) {
            XPNaviInfo xPNaviInfo = list.get(i);
            if (xPNaviInfo.mViaRemainDist == null || xPNaviInfo.mViaRemainDist.length == 0) {
                L.w(TAG, i + "：xpNaviInfo.mViaRemainDist is null");
                return;
            }
            if (TBTManager.getInstance().getRouteResultInfo(currentNaviId, xPNaviInfo.mPathID) == null) {
                L.w(TAG, "routeInfo == null");
                return;
            }
            ViasStatus viasStatus = new ViasStatus();
            viasStatus.mPathId = xPNaviInfo.mPathID;
            int i2 = (int) (routeResultInfo.mPathLength - xPNaviInfo.mRouteRemainDist);
            viasStatus.mViasRemainFromStartPoint = new int[xPNaviInfo.mViaRemainDist.length];
            for (int i3 = 0; i3 < xPNaviInfo.mViaRemainDist.length; i3++) {
                viasStatus.mViasRemainFromStartPoint[i3] = xPNaviInfo.mViaRemainDist[i3] + i2;
            }
            this.mViasStatusArray[i] = viasStatus;
        }
        this.mIsNeedUpdateViaInfos = true;
    }

    public void updateViaDist(List<XPNaviInfo> list, long j) {
        XPNaviInfo xPNaviInfo;
        updateViaDist(list, true);
        L.Tag tag = TAG;
        L.i(tag, "updateViaDist " + this.mIsNeedUpdateViaInfos);
        if (this.mIsNeedUpdateViaInfos) {
            long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
            RouteResult.RouteInfo routeResultInfo = TBTManager.getInstance().getRouteResultInfo(currentNaviId, j);
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "routeInfo:" + routeResultInfo + " " + currentNaviId + " " + j);
            }
            if (routeResultInfo == null || !CollectionUtils.isNotEmpty(list) || (xPNaviInfo = list.get(0)) == null) {
                return;
            }
            if (L.ENABLE) {
                L.Tag tag3 = TAG;
                L.v(tag3, " updateViaDist pathLength:" + routeResultInfo.mPathLength + "   routeRemain:" + xPNaviInfo.mRouteRemainDist);
            }
            updateViaInfos(j);
        }
    }

    public void updateViaInfos(long j) {
        long currentNaviId = TBTManager.getInstance().getCurrentNaviId();
        L.i(TAG, "updateViaInfos naviId : " + currentNaviId + ", pathId" + j);
        if (CollectionUtils.isEmpty(this.mViasStatusArray)) {
            L.w(TAG, "mViasStatusArray:" + Arrays.toString(this.mViasStatusArray));
            return;
        }
        int[] iArr = null;
        ViasStatus[] viasStatusArr = this.mViasStatusArray;
        int length = viasStatusArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            ViasStatus viasStatus = viasStatusArr[i];
            if (viasStatus != null && viasStatus.mPathId == j) {
                iArr = viasStatus.mViasRemainFromStartPoint;
                break;
            }
            i++;
        }
        if (CollectionUtils.isEmpty(iArr)) {
            L.w(TAG, "viaRemainArr:" + Arrays.toString(iArr));
            return;
        }
        List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(currentNaviId);
        int lastPassedIndexDiff = TBTManager.getInstance().getLastPassedIndexDiff();
        if (CollectionUtils.isNotEmpty(viaInfos) && viaInfos.size() - lastPassedIndexDiff == iArr.length) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = i2 + lastPassedIndexDiff;
                if (i3 < viaInfos.size()) {
                    viaInfos.get(i3).setDistance(iArr[i2]);
                    if (L.ENABLE) {
                        L.d(TAG, i3 + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + iArr[i2]);
                    }
                }
            }
        }
    }
}
