package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class SRNaviListener implements ISRInfoChangedListener {
    protected WeakReference<IBaseNaviLogicView> mBaseLogicView;
    protected WeakReference<BaseNaviPresenter> mBasePresenter;

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onXpuSRLCViewChanged(int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onXpuSRSpdViewChanged(int i) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onXpuVehSpeedChanged(float f) {
    }

    public SRNaviListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = new WeakReference<>(iBaseNaviLogicView);
        this.mBasePresenter = new WeakReference<>(baseNaviPresenter);
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onXpuSRDisplayStChanged(int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBaseLogicView.get() == null || SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().stopSwitchToSRTimer();
                if (SRNaviManager.getInstance().canShowSRScene()) {
                    SRNaviListener.this.mBasePresenter.get().enterSRNaviMode();
                } else {
                    SRNaviListener.this.mBasePresenter.get().disableSRNaviMode();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onLaneViewDisplayChanged(int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBaseLogicView.get() == null || SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().stopSwitchToSRTimer();
                if (SRNaviManager.getInstance().canShowSRScene()) {
                    SRNaviListener.this.mBasePresenter.get().enableLaneNaviMode();
                } else {
                    SRNaviListener.this.mBasePresenter.get().disableSRNaviMode();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onDriveModeChanged(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.3
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBaseLogicView.get() == null || SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().updateDriveModeStatus(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onScuNgpOpeButton(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.4
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBaseLogicView.get() == null || SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().updateNgpOperate(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onScuNgpLcTips1AndNgpOddStatus(final int i, final int i2) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.5
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBaseLogicView.get() == null || SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().updateNgpLcTipsAndOddStatus(i, i2);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onScuNgpInfoTips1(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.6
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBaseLogicView.get() == null || SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().updateNgpInfoTips(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onScuNgpLaneChanged(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.7
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBaseLogicView.get() == null || SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().updateNgpLaneChanged(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onScuLimitSpeed(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.8
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().updateLimitSpeed(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void onScuCruiseSpeed(final int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.SRNaviListener.9
            @Override // java.lang.Runnable
            public void run() {
                if (SRNaviListener.this.mBasePresenter.get() == null) {
                    return;
                }
                SRNaviListener.this.mBasePresenter.get().updateAccSpeed(i);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.ISRInfoChangedListener
    public void outBLRenderFPS() {
        if (this.mBasePresenter.get() == null) {
            return;
        }
        this.mBasePresenter.get().outBLRenderFPS();
    }
}
