package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.BLDataModelUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class OddDataHelper {
    private static final int ODD_LEN_100 = 100;
    private static final int ODD_LEN_1000 = 1000;
    private static final int ODD_LEN_10000 = 10000;
    private static final int ODD_LEN_2000 = 2000;
    private static final int ODD_LEN_3000 = 3000;
    private static final int ODD_LEN_5000 = 5000;
    private static final L.Tag TAG = new L.Tag("OddDataHelper");
    private static OddDataHelper sOddDataHelper = new OddDataHelper();
    private HashMap<Integer, Integer> mLevelMap;
    private volatile int mCurrentLen = 0;
    private List<OddHelperListener> mListener = new ArrayList();
    private TBTManager mTBTManager = TBTManager.getInstance();

    /* loaded from: classes2.dex */
    public interface OddHelperListener {
        void updateOddInfo(List<XPOddInfo> list);
    }

    private OddDataHelper() {
    }

    public static OddDataHelper getInstance() {
        return sOddDataHelper;
    }

    private List<XPOddInfo> mergeOddInfo(int i, List<XPOddInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            if (L.ENABLE) {
                L.d(TAG, "odd default info size" + list.size());
            }
            if (list.size() == 1) {
                arrayList.addAll(list);
                return arrayList;
            }
            XPOddInfo copyXPOddInfo = BLDataModelUtil.copyXPOddInfo(list.get(0));
            for (int i2 = 1; i2 < list.size(); i2++) {
                XPOddInfo xPOddInfo = list.get(i2);
                if (LocationUtils.getDistance(copyXPOddInfo.mPoints.get(copyXPOddInfo.mPoints.size() - 1), xPOddInfo.mPoints.get(0)) < i) {
                    copyXPOddInfo.mEndSegIdx = xPOddInfo.mEndSegIdx;
                    copyXPOddInfo.mEndLinkIdx = xPOddInfo.mEndLinkIdx;
                    copyXPOddInfo.mEndOffSet = xPOddInfo.mEndOffSet;
                    copyXPOddInfo.mPoints.addAll(xPOddInfo.mPoints);
                } else {
                    arrayList.add(copyXPOddInfo);
                    copyXPOddInfo = BLDataModelUtil.copyXPOddInfo(xPOddInfo);
                }
                if (i2 == list.size() - 1) {
                    arrayList.add(copyXPOddInfo);
                }
            }
            if (L.ENABLE) {
                L.d(TAG, "mCurrentOddInfo size " + arrayList.size());
            }
        }
        return arrayList;
    }

    private int getDisplayLen(int i) {
        if (this.mLevelMap == null) {
            this.mLevelMap = new HashMap<>();
            this.mLevelMap.put(10, 1000);
            this.mLevelMap.put(9, 2000);
            this.mLevelMap.put(8, 3000);
            this.mLevelMap.put(7, 5000);
            this.mLevelMap.put(6, 10000);
        }
        if (i > 10) {
            return 100;
        }
        if (i <= 6) {
            return 10000;
        }
        return this.mLevelMap.get(Integer.valueOf(i)).intValue();
    }

    private List<XPOddInfo> getOddInfo(int i, boolean z, int i2) {
        List<XPOddInfo> routeOddInfos = this.mTBTManager.getRouteOddInfos(TBTManager.getInstance().getCurrentRouteRequestId(), i2);
        int displayLen = getDisplayLen(i);
        if (displayLen != this.mCurrentLen || z) {
            this.mCurrentLen = displayLen;
            return mergeOddInfo(displayLen, routeOddInfos);
        }
        return null;
    }

    private boolean checkLevelChange(int i) {
        return getDisplayLen(i) != this.mCurrentLen;
    }

    public void addUpdateOddInfoListener(OddHelperListener oddHelperListener) {
        if (oddHelperListener != null) {
            this.mListener.add(oddHelperListener);
        }
    }

    public void removeUpdateOddInfoListener(OddHelperListener oddHelperListener) {
        if (oddHelperListener != null) {
            this.mListener.remove(oddHelperListener);
        }
    }

    public void updateOddInfo() {
        if (L.ENABLE) {
            L.d(TAG, "updateOddInfo ");
        }
        if (CollectionUtils.isNotEmpty(this.mListener)) {
            WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.-$$Lambda$OddDataHelper$x19I-ajNI15w7-oYm7guDqkCewk
                @Override // java.lang.Runnable
                public final void run() {
                    OddDataHelper.this.lambda$updateOddInfo$0$OddDataHelper();
                }
            });
        }
    }

    public /* synthetic */ void lambda$updateOddInfo$0$OddDataHelper() {
        List<XPOddInfo> oddInfo = getOddInfo(this.mTBTManager.getMap().getMapLevel(), true, getIndex());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "odd info size " + oddInfo.size());
        }
        for (OddHelperListener oddHelperListener : this.mListener) {
            oddHelperListener.updateOddInfo(oddInfo);
        }
    }

    public void onMapLevelChange() {
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.-$$Lambda$OddDataHelper$KHxWBS8Fy4SbtqkciTKaE7nHZb8
            @Override // java.lang.Runnable
            public final void run() {
                OddDataHelper.this.lambda$onMapLevelChange$1$OddDataHelper();
            }
        });
    }

    public /* synthetic */ void lambda$onMapLevelChange$1$OddDataHelper() {
        if (checkLevelChange(this.mTBTManager.getMap().getMapLevel())) {
            List<XPOddInfo> oddInfo = getOddInfo(this.mTBTManager.getMap().getMapLevel(), false, getIndex());
            for (OddHelperListener oddHelperListener : this.mListener) {
                oddHelperListener.updateOddInfo(oddInfo);
            }
        }
    }

    private int getIndex() {
        if (TBTManager.getInstance().getCurrentStatus() == 0) {
            return TBTManager.getInstance().getCurrentRoutePathIndex();
        }
        return TBTManager.getInstance().getCurrentNaviPathIndex();
    }
}
