package com.xiaopeng.montecarlo.scenes.navi;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.navcore.powerdistance.navi.NaviPowerDisHelperContainer;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRDataUtil;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.XUIServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.SRUtil;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public abstract class BaseNgpPresenter extends BasePresenter {
    private static final L.Tag TAG = new L.Tag("BaseNgpPresenter");
    private int mSRDynamicLevelMode = 1;

    @NonNull
    protected abstract IBaseNgpLogicView<?> getLogicView();

    public void updateNgpPanelInfo() {
        int scuNgpLcTips1Status = SRNaviManager.getInstance().getScuNgpLcTips1Status();
        int driveMode = SRNaviManager.getInstance().getDriveMode();
        if (SRDataUtil.isLccStatus(driveMode)) {
            updateDriveModeStatus(driveMode);
        } else {
            updateNgpLcTipsAndOddStatus(scuNgpLcTips1Status, SRNaviManager.getInstance().getScuQuitNgpOddStatus());
        }
        if (SRUtil.isShowOperateStatusByTipsStatus(scuNgpLcTips1Status)) {
            updateNgpOperate(SRNaviManager.getInstance().getScuNgpOpeButtonStatus());
        }
    }

    public void updateNgpLcTipsAndOddStatus(int i, int i2) {
        if (L.ENABLE) {
            L.d(TAG, "updateNgpLcTipsAndOddStatus lcTipsStatus = " + i + " oddStatus = " + i2);
        }
        int lcTipsIconResId = SRUtil.getLcTipsIconResId(SRNaviManager.getInstance().getDriveMode(), i, i2, SRNaviManager.getInstance().isLcTipsChange(), SRNaviManager.getInstance().getNGPLaneChangedStatus());
        boolean isNgpStrongAlertTypeByLcTipsOrOddStatus = SRUtil.isNgpStrongAlertTypeByLcTipsOrOddStatus(i, i2);
        boolean z = false;
        if (i2 > 0 && i2 <= 7) {
            int i3 = i2 - 1;
            getLogicView().onUpdateNgpQuitTips(true, i3 * 20, i2, lcTipsIconResId, i3);
            IBaseNgpLogicView<?> logicView = getLogicView();
            if (!isNgpStrongAlertTypeByLcTipsOrOddStatus && SRUtil.isTakeOverWeakByQuitNgpOddStatus(i2)) {
                z = true;
            }
            logicView.onUpdateTakeOverWeakStatus(z);
        } else {
            IBaseNgpLogicView<?> logicView2 = getLogicView();
            if (!isNgpStrongAlertTypeByLcTipsOrOddStatus && SRUtil.isTakeOverWeakByTipStatus(i)) {
                z = true;
            }
            logicView2.onUpdateTakeOverWeakStatus(z);
            getLogicView().onUpdateNgpLcTips(i - 1, lcTipsIconResId, i, SRUtil.isNgpPanelNeedAnimator(i, i2), SRUtil.isIconAnimator(SRNaviManager.getInstance().getNGPLaneChangedStatus(), i));
        }
        getLogicView().refreshNgpPanelView();
    }

    public void updateNgpLaneChanged(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateNgpLaneChanged status = " + i);
        }
        int scuNgpLcTips1Status = SRNaviManager.getInstance().getScuNgpLcTips1Status();
        int scuQuitNgpOddStatus = SRNaviManager.getInstance().getScuQuitNgpOddStatus();
        getLogicView().onUpdateNgpLcTips(scuNgpLcTips1Status - 1, SRUtil.getLcTipsIconResId(SRNaviManager.getInstance().getDriveMode(), scuNgpLcTips1Status, scuQuitNgpOddStatus, SRNaviManager.getInstance().isLcTipsChange(), i), scuNgpLcTips1Status, SRUtil.isNgpPanelNeedAnimator(scuNgpLcTips1Status, scuQuitNgpOddStatus), SRUtil.isIconAnimator(i, scuNgpLcTips1Status));
        getLogicView().refreshNgpPanelView();
    }

    public void updateNgpInfoTips(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateNgpInfoTips status = " + i);
        }
        getLogicView().onUpdateNgpInfoTips(i > 0, i, i - 1, SRUtil.getNgpInfoTipsIcon(i));
    }

    public void updateNgpOperate(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateNgpOperate status = " + i);
        }
        getLogicView().onUpdateNgpOperateStatus(i > 0, i, i - 1, i == 1);
        getLogicView().refreshNgpPanelView();
    }

    public void updateDriveModeStatus(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateDriveModeStatus status = " + i);
        }
        int scuNgpLcTips1Status = SRNaviManager.getInstance().getScuNgpLcTips1Status();
        int nGPLaneChangedStatus = SRNaviManager.getInstance().getNGPLaneChangedStatus();
        int scuQuitNgpOddStatus = SRNaviManager.getInstance().getScuQuitNgpOddStatus();
        boolean isLcTipsChange = SRNaviManager.getInstance().isLcTipsChange();
        if (SRDataUtil.isLccStatus(i)) {
            getLogicView().onUpdateNgpLcTipsToLccMode(SRUtil.getLcTipsIconResId(i, scuNgpLcTips1Status, scuQuitNgpOddStatus, isLcTipsChange, nGPLaneChangedStatus), SRUtil.isIconAnimator(nGPLaneChangedStatus, scuNgpLcTips1Status), scuNgpLcTips1Status);
        } else {
            getLogicView().onUpdateNgpLcTips(scuNgpLcTips1Status - 1, SRUtil.getLcTipsIconResId(i, scuNgpLcTips1Status, scuQuitNgpOddStatus, isLcTipsChange, nGPLaneChangedStatus), scuNgpLcTips1Status, SRUtil.isNgpPanelNeedAnimator(scuNgpLcTips1Status, scuQuitNgpOddStatus), SRUtil.isIconAnimator(nGPLaneChangedStatus, scuNgpLcTips1Status));
        }
        LaneServiceManager.getInstance().openNaviLineRender(1, !SRDataUtil.isNgpDriveMode(i) && getLogicView().getMapView().isLaneMode() && SRNaviManager.getInstance().isLaneEnabled());
        getLogicView().refreshNgpPanelView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRemainDis() {
        ConcurrentHashMap<Long, NaviPowerDisHelperContainer.NaviPowerDisData> naviRemainDisMap = TBTManager.getInstance().getNaviRemainDisMap();
        if (naviRemainDisMap != null) {
            for (Long l : naviRemainDisMap.keySet()) {
                long longValue = l.longValue();
                NaviPowerDisHelperContainer.NaviPowerDisData naviPowerDisData = naviRemainDisMap.get(Long.valueOf(longValue));
                if (naviPowerDisData != null) {
                    getLogicView().onUpdateRemainDis(longValue, naviPowerDisData.getRouteRemainDis(), naviPowerDisData.getRemainDis());
                }
            }
        }
    }

    public void updateSRTrafficView(int i) {
        L.Tag tag = TAG;
        L.i(tag, "updateSRTrafficView eventType:" + i);
        if (i == 0) {
            getLogicView().onHideTrafficPanel();
        } else {
            getLogicView().onShowTrafficPanel(i);
        }
    }

    public void clickOperate(final int i, final int i2) {
        if (SRUtil.isPlayTTS(i2)) {
            WorkThreadUtil.getInstance().executeSpeechTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.-$$Lambda$BaseNgpPresenter$PdiiqDfYQ-fsFY89_dkk77duimQ
                @Override // java.lang.Runnable
                public final void run() {
                    BaseNgpPresenter.lambda$clickOperate$0(i2);
                }
            });
        } else if (i > 0) {
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.-$$Lambda$BaseNgpPresenter$1LaFpotNJ7Zv-utW2ZjzvwwKBSg
                @Override // java.lang.Runnable
                public final void run() {
                    SRNaviManager.getInstance().setScuNgpOpeButtonStatus(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$clickOperate$0(int i) {
        if (4 == i) {
            XUIServiceManager.getInstance().sendNavTTS(1);
        } else {
            XUIServiceManager.getInstance().sendNavTTS(2);
        }
    }

    public void setLevelUp() {
        LaneServiceManager.getInstance().setLevelUp(getSRDynamicLevelMode());
    }

    public void setLevelDown() {
        LaneServiceManager.getInstance().setLevelDown(getSRDynamicLevelMode());
    }

    public int getSRDynamicLevelMode() {
        return this.mSRDynamicLevelMode;
    }

    public void changeDynamicLevelSubMode() {
        int i = this.mSRDynamicLevelMode;
        if (i == 0) {
            this.mSRDynamicLevelMode = 1;
        } else if (i != 1) {
        } else {
            this.mSRDynamicLevelMode = 0;
        }
    }
}
