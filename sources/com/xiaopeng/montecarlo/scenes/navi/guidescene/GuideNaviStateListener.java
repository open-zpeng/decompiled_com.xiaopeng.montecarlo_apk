package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviStateListener;
/* loaded from: classes3.dex */
public class GuideNaviStateListener extends NaviStateListener {
    private static final L.Tag TAG = new L.Tag("GuideNaviStateListener");
    private NaviScenePresenter mPresenter;

    public GuideNaviStateListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = (NaviScenePresenter) baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviStateListener, com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        super.onStateChange(i);
        if (i == 0) {
            this.mPresenter.disableDynamicLevel();
            LaneServiceManager.getInstance().updateDynamicViewAngle(1, false);
            this.mBaseLogicView.getMapView().getBizControlManager().setFollowMode(false);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " onStateChange : mPresenter.isLaneViewShow() = " + this.mPresenter.isLaneViewShow() + " , mPresenter.getCurrentMode() = " + this.mPresenter.getCurrentMode() + " , mPresenter.getAiMessageId() = " + this.mPresenter.getAiMessageId());
        }
        if (this.mPresenter.isLaneViewShow()) {
            LaneServiceManager.getInstance().updateDynamicViewAngle(1, true);
            LaneServiceManager.getInstance().openFollowMode(1, true);
        } else if (1 == this.mPresenter.getCurrentMode()) {
            if (TextUtils.isEmpty(this.mPresenter.getAiMessageId())) {
                this.mBasePresenter.exitOverviewMode();
            }
        } else {
            this.mPresenter.enableDynamicLevel();
            this.mBaseLogicView.getMapView().restoreCarPosition();
            this.mBaseLogicView.getMapView().goBackCenter();
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, " GuideCarUp : " + this.mBaseLogicView.getMapView().getBizControlManager().getCarUpMode());
            }
        }
    }
}
