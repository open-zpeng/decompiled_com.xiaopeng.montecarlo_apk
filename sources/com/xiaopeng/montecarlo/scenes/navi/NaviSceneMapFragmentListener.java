package com.xiaopeng.montecarlo.scenes.navi;

import android.os.Bundle;
import com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener;
import com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreScenePresenter;
import com.xiaopeng.montecarlo.scenes.settingscene.SettingPreferencePresenter;
/* loaded from: classes2.dex */
public class NaviSceneMapFragmentListener implements ISceneMapFragmentListener {
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickOverView() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickRouteChargeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onClickZoomView(boolean z) {
    }

    public NaviSceneMapFragmentListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public void onSceneMapFragmentResult(int i, Bundle bundle) {
        if (bundle != null && 200 == i && bundle.getBoolean(SettingPreferencePresenter.ROUTE_CHANGE_TYPE)) {
            this.mBasePresenter.requestReroute(3, 1, true);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public boolean onClickRecenter() {
        if (this.mBaseLogicView.isSceneLegal()) {
            BaseNaviPresenter baseNaviPresenter = this.mBasePresenter;
            if (baseNaviPresenter instanceof ExploreScenePresenter) {
                ((ExploreScenePresenter) baseNaviPresenter).updatePreview();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.mapscene.ISceneMapFragmentListener
    public boolean onClickSRNaviMode() {
        return this.mBasePresenter.switchNaviMode(true);
    }
}
