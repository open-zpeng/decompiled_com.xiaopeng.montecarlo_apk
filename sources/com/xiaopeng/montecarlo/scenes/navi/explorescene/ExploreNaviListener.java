package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviListener;
import com.xiaopeng.montecarlo.scenes.navi.explorescene.IExploreContract;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes2.dex */
public class ExploreNaviListener extends NaviListener {
    private WeakReference<IExploreContract.LogicView> mLogicView;
    private WeakReference<ExploreScenePresenter> mPresenter;

    public ExploreNaviListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = new WeakReference<>((ExploreScenePresenter) baseNaviPresenter);
        this.mLogicView = new WeakReference<>((IExploreContract.LogicView) iBaseNaviLogicView);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(final List<XPNaviInfo> list) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreNaviListener.this.mPresenter.get() == null || ExploreNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).onUpdateNaviInfo(list);
                if (System.currentTimeMillis() - ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).getLastTime() > NavRestoreManager.WAKELOCK_TIMEOUT_10SEC) {
                    ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).updatePreviewByCurrentLocation();
                    ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).setLastTime(System.currentTimeMillis());
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowNaviCamera(final List<XPCameraInfo> list) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreNaviListener.this.mPresenter.get() == null || ExploreNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((IExploreContract.LogicView) ExploreNaviListener.this.mLogicView.get()).onUpdateNaviCamera(list);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateViaPass(final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.3
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreNaviListener.this.mPresenter.get() == null || ExploreNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).updateViaPass(j);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onChangeNaviPath(final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.4
            @Override // java.lang.Runnable
            public void run() {
                ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).selectMainPath(j, false);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSelectMainPathStatus(final long j, int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.5
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreNaviListener.this.mPresenter.get() == null || ExploreNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).selectMainPath(j, false);
                if (((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).getClickStartNaviState()) {
                    ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).setClickStartNaviState(false);
                    ((ExploreScenePresenter) ExploreNaviListener.this.mPresenter.get()).startGuidance(true, true, false);
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviLaneInfo(final XPLaneInfo xPLaneInfo, final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.6
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreNaviListener.this.mPresenter.get() == null || ExploreNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                if (z) {
                    ((IExploreContract.LogicView) ExploreNaviListener.this.mLogicView.get()).onShowNaviLaneInfo(xPLaneInfo);
                } else {
                    ((IExploreContract.LogicView) ExploreNaviListener.this.mLogicView.get()).onHideNaviLaneInfo();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowTollGateLane(final XPTollGateInfo xPTollGateInfo) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.7
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreNaviListener.this.mPresenter.get() == null || ExploreNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((IExploreContract.LogicView) ExploreNaviListener.this.mLogicView.get()).onUpdateTollGateInfo(xPTollGateInfo);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onMainPathChanged() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviListener.8
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreNaviListener.this.mPresenter.get() == null || ExploreNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((IExploreContract.LogicView) ExploreNaviListener.this.mLogicView.get()).onMainPathChanged();
            }
        });
    }
}
