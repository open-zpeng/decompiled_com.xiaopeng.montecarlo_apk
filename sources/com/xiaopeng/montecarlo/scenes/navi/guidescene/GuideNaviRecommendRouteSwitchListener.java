package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import androidx.annotation.MainThread;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviRecommendRouteSwitchListener;
/* loaded from: classes2.dex */
public class GuideNaviRecommendRouteSwitchListener extends NaviRecommendRouteSwitchListener {
    private NaviScenePresenter mPresenter;

    public GuideNaviRecommendRouteSwitchListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = (NaviScenePresenter) baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRecommendRouteSwitchListener, com.xiaopeng.montecarlo.views.RecommendRoutePop.IRecommendRouteSwitchListener
    @MainThread
    public void onIgnore() {
        super.onIgnore();
        DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_ROUTE_IGNORE, new Object[0]);
        this.mPresenter.ignoreRecommendRoute();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRecommendRouteSwitchListener, com.xiaopeng.montecarlo.views.RecommendRoutePop.IRecommendRouteSwitchListener
    @MainThread
    public void onSwitch(IVariantPath iVariantPath, int i) {
        super.onSwitch(iVariantPath, i);
        DataLogUtil.sendStatData(PageType.NAVI_GUIDANCE, BtnType.RECOMMEND_ROUTE_SWITCH, new Object[0]);
        if (this.mPresenter.getIsLastRadarOpen()) {
            SettingWrapper.setRadarStatus(true);
            this.mPresenter.setIsLastRadarOpen(false);
        }
        if (this.mPresenter.switchRecommendRoute(iVariantPath, i)) {
            this.mPresenter.updateRoute(TBTManager.getInstance().getCurrentNaviPathResult(), TBTManager.getInstance().getCurrentNaviPathIndex(), false, true);
            if (1 == this.mPresenter.getCurrentMode()) {
                this.mPresenter.exitOverviewMode();
            }
        }
    }
}
