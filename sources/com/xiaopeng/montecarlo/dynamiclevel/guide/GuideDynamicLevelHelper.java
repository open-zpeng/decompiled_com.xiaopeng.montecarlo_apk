package com.xiaopeng.montecarlo.dynamiclevel.guide;

import android.os.Handler;
import com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfoPanel;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class GuideDynamicLevelHelper extends DynamicLevelHelper implements Handler.Callback {
    private static final int GRADUAL_CHANGE_SECONDS = 3;
    private static final int LEVEL_KEEP_SECONDS_IN_RANGE = 1;
    private static final int LEVEL_KEEP_SECONDS_OVER_RANGE = 5;
    private static final L.Tag TAG = new L.Tag("GuideDynamicLevelHelper");
    private boolean mIsActive;
    private boolean mIsNewSeqx;
    private boolean mIsNewSeqxOverMaxDist;
    private int mLastSegIdx;
    private int mNewSeqxTimerCounts;
    private float mRemainDis;

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected boolean isNeedUpdate() {
        return false;
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void stopDynamicLevel() {
    }

    public GuideDynamicLevelHelper(MapViewWrapper mapViewWrapper) {
        super(mapViewWrapper, new GuideDynamicLevelSetting());
        this.mRemainDis = 0.0f;
        this.mNewSeqxTimerCounts = 0;
        this.mLastSegIdx = -1;
        this.mIsActive = false;
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void updateInfo(Object obj) {
        XPNaviInfoPanel[] xPNaviInfoPanelArr;
        XPNaviInfo xPNaviInfo = (XPNaviInfo) obj;
        if (CollectionUtils.isEmpty(xPNaviInfo.mNaviInfoData)) {
            return;
        }
        GuideDynamicLevelSetting guideDynamicLevelSetting = (GuideDynamicLevelSetting) this.mDynamicLevelSetting;
        this.mRemainDis = xPNaviInfoPanelArr[xPNaviInfo.mNaviInfoFlag].mSegmentRemainDist;
        guideDynamicLevelSetting.update(this.mRemainDis, xPNaviInfo.mCurRoadClass, isNorthUp());
        boolean z = false;
        if (this.mLastSegIdx != xPNaviInfo.mCurSegIdx) {
            this.mLastSegIdx = xPNaviInfo.mCurSegIdx;
            this.mIsNewSeqx = true;
            this.mNewSeqxTimerCounts = 0;
            this.mIsNewSeqxOverMaxDist = false;
            if (guideDynamicLevelSetting.isOverMaxDistanceLimit()) {
                this.mIsNewSeqxOverMaxDist = true;
            }
            this.mIsGradualChange = true;
            this.mGradualTimeCounts = 0;
            if (L.ENABLE) {
                L.v(TAG, " updateNaviInfo  Seq Change----");
            }
        }
        int i = 3;
        if (this.mIsNewSeqx) {
            if (this.mNewSeqxTimerCounts >= (this.mIsNewSeqxOverMaxDist ? 5 : 1) || this.mIsActive) {
                this.mIsActive = false;
                this.mIsNewSeqx = false;
                updateLevelInterval(3);
            }
            this.mNewSeqxTimerCounts++;
            if (L.ENABLE) {
                L.v(TAG, " updateNaviInfo mIsNewSeqx:" + this.mIsNewSeqx + "  mNewSeqxTimerCounts:" + this.mNewSeqxTimerCounts);
                return;
            }
            return;
        }
        if (this.mIsGradualChange) {
            this.mIsNewSeqxOverMaxDist = guideDynamicLevelSetting.isOverMaxDistanceLimit();
            if (this.mGradualTimeCounts >= 3) {
                this.mIsGradualChange = false;
            }
            this.mGradualTimeCounts++;
        } else {
            i = 1;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(" over gradual change:");
            if (this.mIsGradualChange && this.mIsNewSeqxOverMaxDist) {
                z = true;
            }
            sb.append(z);
            sb.append("  mLevelInterval:");
            sb.append(this.mLevelInterval);
            L.v(tag, sb.toString());
        }
        if ((this.mIsGradualChange && this.mIsNewSeqxOverMaxDist) || updateLevelInterval(i)) {
            sendLevelRefreshMsg();
        }
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void reset() {
        this.mRemainDis = 0.0f;
        this.mLastSegIdx = -1;
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void startDynamicLevel() {
        this.mIsActive = true;
    }
}
