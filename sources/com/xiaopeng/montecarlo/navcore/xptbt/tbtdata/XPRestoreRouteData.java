package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.autonavi.gbl.common.path.DrivePathDecoder;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.route.model.PathResultData;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class XPRestoreRouteData implements Serializable {
    private static final long INVALID_ID = -1;
    private static final L.Tag TAG = new L.Tag("XPRestoreRouteData");
    private long[] mAllPathId;
    private final PathResultData[] mPathResultData = new PathResultData[2];
    private long mMainPathId = -1;
    private boolean mMainPathInFirst = false;

    public synchronized void addPathResultData(PathResultData pathResultData) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreFromByteData >>> addPathResultData mMainPathInFirst = " + this.mMainPathInFirst + " , thread = " + Thread.currentThread().getName());
        }
        this.mPathResultData[getNextDataIndex()] = pathResultData;
    }

    public synchronized PathResultData getMainPathResultData() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreFromByteData >>> getMainPathResultData mMainPathInFirst = " + this.mMainPathInFirst + " , thread = " + Thread.currentThread().getName());
        }
        return this.mPathResultData[this.mMainPathInFirst ? (char) 0 : (char) 1];
    }

    public synchronized void updatePathID(RouteResult routeResult, long j) {
        L.i(TAG, "RestoreFromByteData >>> updatePathID currentPathId =" + j + " , thread = " + Thread.currentThread().getName());
        if (routeResult != null && routeResult.mRouteInfos != null) {
            int size = routeResult.mRouteInfos.size();
            this.mAllPathId = new long[size];
            for (int i = 0; i < size; i++) {
                RouteResult.RouteInfo routeInfo = routeResult.getRouteInfo(i);
                if (routeInfo != null) {
                    this.mAllPathId[i] = routeInfo.mPathId;
                    if (L.ENABLE) {
                        L.d(TAG, "RestoreFromByteData >>> updatePathID mAllPathId[" + i + "] =" + routeInfo.mPathId + " ,count = " + size);
                    }
                }
            }
            this.mMainPathId = j;
            ArrayList<PathInfo> decodeRouteData = decodeRouteData(this.mPathResultData[0]);
            this.mMainPathInFirst = isPathInList(decodeRouteData, this.mMainPathId);
            releaseDecodePathInfo(decodeRouteData);
            L.i(TAG, "RestoreFromByteData >>> updatePathID mMainPathId =" + this.mMainPathId + " , mMainPathInFirst = " + this.mMainPathInFirst + " , thread = " + Thread.currentThread().getName());
        }
    }

    public boolean isClear() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreFromByteData >>> isClear ," + Arrays.toString(this.mAllPathId) + " , thread = " + Thread.currentThread().getName());
        }
        return this.mAllPathId == null;
    }

    public synchronized void clear() {
        L.Tag tag = TAG;
        L.i(tag, "RestoreFromByteData >>> clear , thread = " + Thread.currentThread().getName());
        this.mAllPathId = null;
        this.mMainPathId = -1L;
        this.mPathResultData[0] = null;
        this.mPathResultData[1] = null;
    }

    public synchronized XPPathResult getPathResult() {
        long[] jArr;
        if (L.ENABLE) {
            L.d(TAG, "RestoreFromByteData >>> getPathResult , mMainPathInFirst = " + this.mMainPathInFirst + " , thread = " + Thread.currentThread().getName());
        }
        if (this.mAllPathId == null) {
            L.i(TAG, "RestoreFromByteData >>> getPathResult mAllPathId == null");
            return null;
        }
        ArrayList<PathInfo> arrayList = new ArrayList<>();
        ArrayList<PathInfo> decodeRouteData = decodeRouteData(this.mPathResultData[0]);
        ArrayList<PathInfo> decodeRouteData2 = decodeRouteData(this.mPathResultData[1]);
        for (long j : this.mAllPathId) {
            addPath(arrayList, decodeRouteData, j);
            addPath(arrayList, decodeRouteData2, j);
        }
        if (arrayList.isEmpty()) {
            L.i(TAG, "RestoreFromByteData >>> getPathResult realPaths isEmpty , thread = " + Thread.currentThread().getName());
            releaseDecodePathInfo(decodeRouteData);
            releaseDecodePathInfo(decodeRouteData2);
            return null;
        }
        XPPathResult xPPathResult = new XPPathResult(arrayList);
        releaseDecodePathInfo(decodeRouteData);
        releaseDecodePathInfo(decodeRouteData2);
        return xPPathResult;
    }

    public synchronized int getPathIndex(XPPathResult xPPathResult) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreFromByteData >>> getPathIndex pathResult = " + xPPathResult + " , mMainPathId = " + this.mMainPathId + " , thread = " + Thread.currentThread().getName());
        }
        if (xPPathResult != null) {
            return xPPathResult.getPathIndex(this.mMainPathId);
        }
        return -1;
    }

    private int getNextDataIndex() {
        if (this.mMainPathId == -1) {
            return 0;
        }
        return this.mMainPathInFirst ? 1 : 0;
    }

    private ArrayList<PathInfo> decodeRouteData(PathResultData pathResultData) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreFromByteData >>> decodeRouteData pathResultData = " + pathResultData);
        }
        if (pathResultData != null) {
            return DrivePathDecoder.decodeMultiRouteData(pathResultData.calcRouteResultData);
        }
        return null;
    }

    private void releaseDecodePathInfo(ArrayList<PathInfo> arrayList) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RestoreFromByteData >>> releaseDecodePathInfo paths = " + arrayList);
        }
        if (arrayList != null) {
            Iterator<PathInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PathInfo next = it.next();
                if (next != null) {
                    if (L.ENABLE) {
                        L.Tag tag2 = TAG;
                        L.d(tag2, "RestoreFromByteData >>> releasePathInfo info = " + next.getPathID());
                    }
                    next.delete();
                }
            }
        }
    }

    private void addPath(ArrayList<PathInfo> arrayList, ArrayList<PathInfo> arrayList2, long j) {
        PathInfo findPathInfo = findPathInfo(arrayList2, j);
        if (findPathInfo != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "RestoreFromByteData >>> addPath id = " + j);
            }
            arrayList.add(findPathInfo);
        }
    }

    private boolean isPathInList(ArrayList<PathInfo> arrayList, long j) {
        return (arrayList == null || findPathInfo(arrayList, j) == null) ? false : true;
    }

    private PathInfo findPathInfo(ArrayList<PathInfo> arrayList, long j) {
        L.Tag tag = TAG;
        L.i(tag, "RestoreFromByteData >>> findPathInfo pathId = " + j);
        if (arrayList != null) {
            Iterator<PathInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PathInfo next = it.next();
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "RestoreFromByteData >>> findPathInfo info = " + next.getPathID());
                }
                if (next.getPathID() == j) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }
}
