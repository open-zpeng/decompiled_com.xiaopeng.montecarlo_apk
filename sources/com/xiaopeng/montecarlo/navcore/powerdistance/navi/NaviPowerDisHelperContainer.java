package com.xiaopeng.montecarlo.navcore.powerdistance.navi;

import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class NaviPowerDisHelperContainer implements OnUpdateRemainDisListener {
    private static final int EXPLORE_HELPER_COUNT = 3;
    private static final int GUIDE_HELPER_COUNT = 1;
    public static final L.Tag TAG = new L.Tag("navi_pd_helper");
    private OnUpdateRemainDisListener mOnLineRemainListener;
    private int mTbtStatus;
    private boolean mIsStopped = false;
    private final ArrayList<NaviPowerDisHelper> mPresenterArrayList = new ArrayList<>();
    private ConcurrentHashMap<Long, NaviPowerDisData> mNaviRemainDisMap = new ConcurrentHashMap<>();
    private LongSparseArray<NaviPowerDisHelper> mDisHelperSparseArray = new LongSparseArray<>();

    public NaviPowerDisHelperContainer(@NonNull OnUpdateRemainDisListener onUpdateRemainDisListener) {
        this.mOnLineRemainListener = onUpdateRemainDisListener;
    }

    public void createNaviPowerDisHelper() {
        boolean isGuide = isGuide();
        closeNaviPowerDisHelper();
        int i = this.mTbtStatus != 1 ? 3 : 1;
        L.Tag tag = TAG;
        L.i(tag, "createNaviPowerDisHelper isGuide:" + isGuide + " size:" + i);
        for (int i2 = 0; i2 < i; i2++) {
            this.mPresenterArrayList.add(new NaviPowerDisHelper(isGuide, this));
        }
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviPathResult != null) {
            if (isGuide) {
                IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
                if (currentNaviVariantPath != null) {
                    changePath(this.mPresenterArrayList.get(0), currentNaviPathResult, currentNaviVariantPath);
                    return;
                }
                return;
            }
            for (int i3 = 0; i3 < Math.min(this.mPresenterArrayList.size(), currentNaviPathResult.getPathCount()); i3++) {
                changePath(this.mPresenterArrayList.get(i3), currentNaviPathResult, currentNaviPathResult.getPath(i3));
            }
        }
    }

    public void updateTBTStatus(int i) {
        int i2 = this.mTbtStatus;
        this.mTbtStatus = i;
        if (i2 == 2 && this.mTbtStatus == 1) {
            L.i(TAG, "updateTBTStatus change from explore to guide");
            createNaviPowerDisHelper();
        }
    }

    private boolean isGuide() {
        return this.mTbtStatus == 1;
    }

    public void updateNaviPdHelper(List<XPNaviInfo> list) {
        if (CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(this.mPresenterArrayList)) {
            return;
        }
        int size = isGuide() ? 1 : list.size();
        if (this.mIsStopped) {
            for (int i = size; i < this.mPresenterArrayList.size(); i++) {
                NaviPowerDisHelper naviPowerDisHelper = this.mPresenterArrayList.get(i);
                if (naviPowerDisHelper.isRunning()) {
                    naviPowerDisHelper.stop();
                }
            }
            for (int i2 = 0; i2 < size; i2++) {
                udpatePdNaviInfo(list.get(i2), this.mPresenterArrayList.get(i2));
            }
            this.mIsStopped = false;
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            XPNaviInfo xPNaviInfo = list.get(i3);
            if (xPNaviInfo != null) {
                NaviPowerDisHelper naviPowerDisHelper2 = this.mDisHelperSparseArray.get(xPNaviInfo.mPathID);
                if (naviPowerDisHelper2 != null) {
                    udpatePdNaviInfo(xPNaviInfo, naviPowerDisHelper2);
                } else {
                    L.i(TAG, "updateNaviPdHelper pathId:" + xPNaviInfo.mPathID + " not exists try to stop");
                    stopNaviPowerDisHelper();
                }
            }
        }
    }

    public void refreshPowerDistance(long j) {
        NaviPowerDisHelper naviPowerDisHelper;
        LongSparseArray<NaviPowerDisHelper> longSparseArray = this.mDisHelperSparseArray;
        if (longSparseArray == null || (naviPowerDisHelper = longSparseArray.get(j)) == null) {
            return;
        }
        naviPowerDisHelper.refreshRemainDis();
    }

    private void changePath(@NonNull NaviPowerDisHelper naviPowerDisHelper, @NonNull IPathResult iPathResult, @NonNull IVariantPath iVariantPath) {
        this.mDisHelperSparseArray.remove(naviPowerDisHelper.getPathId());
        naviPowerDisHelper.changePath(iPathResult, iVariantPath);
        this.mDisHelperSparseArray.put(naviPowerDisHelper.getPathId(), naviPowerDisHelper);
    }

    private void udpatePdNaviInfo(XPNaviInfo xPNaviInfo, NaviPowerDisHelper naviPowerDisHelper) {
        IPathResult currentNaviPathResult;
        IVariantPath path;
        if (xPNaviInfo == null || naviPowerDisHelper == null) {
            return;
        }
        if (xPNaviInfo.mPathID != naviPowerDisHelper.getPathId() && (currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult()) != null && (path = currentNaviPathResult.getPath(xPNaviInfo.mPathID)) != null) {
            L.i(TAG, "udpatePdNaviInfo changePath--");
            changePath(naviPowerDisHelper, currentNaviPathResult, path);
        }
        naviPowerDisHelper.updateNaviInfo(xPNaviInfo);
    }

    public void closeNaviPowerDisHelper() {
        if (CollectionUtils.isNotEmpty(this.mPresenterArrayList)) {
            L.i(TAG, "closeNaviPowerDisHelper-size-" + this.mPresenterArrayList.size());
            for (int size = this.mPresenterArrayList.size() + (-1); size >= 0; size--) {
                NaviPowerDisHelper remove = this.mPresenterArrayList.remove(size);
                if (remove != null) {
                    remove.close();
                }
            }
            this.mDisHelperSparseArray.clear();
        }
        this.mNaviRemainDisMap.clear();
    }

    public void stopNaviPowerDisHelper() {
        if (CollectionUtils.isNotEmpty(this.mPresenterArrayList)) {
            L.i(TAG, "stopNaviPowerDisHelper--" + this.mPresenterArrayList.size());
            for (int size = this.mPresenterArrayList.size() - 1; size >= 0; size--) {
                NaviPowerDisHelper naviPowerDisHelper = this.mPresenterArrayList.get(size);
                if (naviPowerDisHelper != null) {
                    this.mDisHelperSparseArray.remove(naviPowerDisHelper.getPathId());
                    naviPowerDisHelper.stop();
                }
            }
            this.mIsStopped = true;
        }
        this.mNaviRemainDisMap.clear();
    }

    public int size() {
        return this.mPresenterArrayList.size();
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
    public void onUpdateRemainDis(long j, int i, int i2) {
        this.mOnLineRemainListener.onUpdateRemainDis(j, i, i2);
        this.mNaviRemainDisMap.put(Long.valueOf(j), new NaviPowerDisData(i, i2));
    }

    public ConcurrentHashMap<Long, NaviPowerDisData> getNaviRemainDisMap() {
        return this.mNaviRemainDisMap;
    }

    /* loaded from: classes3.dex */
    public static class NaviPowerDisData {
        private int mRemainDis;
        private int mRouteRemainDis;

        public NaviPowerDisData(int i, int i2) {
            this.mRouteRemainDis = i;
            this.mRemainDis = i2;
        }

        public int getRouteRemainDis() {
            return this.mRouteRemainDis;
        }

        public void setRouteRemainDis(int i) {
            this.mRouteRemainDis = i;
        }

        public int getRemainDis() {
            return this.mRemainDis;
        }

        public void setRemainDis(int i) {
            this.mRemainDis = i;
        }
    }
}
