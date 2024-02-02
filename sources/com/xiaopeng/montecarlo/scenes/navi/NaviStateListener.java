package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.stat.MapStateChangeStatUtil;
/* loaded from: classes2.dex */
public class NaviStateListener implements IStateListener {
    private static final L.Tag TAG = new L.Tag("NaviStateListener");
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviStateListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, ">>>onStateChange  state = " + i);
        }
        if (this.mBaseLogicView != null && ((StatusConst.Mode.EXPLORE == this.mBaseLogicView.getCurrentSceneMode() || StatusConst.Mode.NAVI == this.mBaseLogicView.getCurrentSceneMode()) && this.mBaseLogicView.isSceneLegal() && !((BaseScene) this.mBaseLogicView).hasChildScene())) {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "onStateChange State current scene is " + this.mBaseLogicView.getCurrentSceneMode().toString());
            }
            MapStateChangeStatUtil.sendStatData(this.mBaseLogicView.getMainContext(), i);
        }
        if (i == 0) {
            this.mBaseLogicView.onStateActive();
        } else {
            this.mBaseLogicView.onStateImmersion();
        }
    }
}
