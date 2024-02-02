package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.ILightBarInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPExitDirectionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPLaneInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviCongestionInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPTollGateInfo;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviListener;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class GuideNaviListener extends NaviListener {
    private static final L.Tag TAG = new L.Tag("GuideNaviListener");
    private WeakReference<INaviContract.LogicView> mLogicView;
    private WeakReference<NaviScenePresenter> mPresenter;

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCCongestionInfo(XPNaviCongestionInfo xPNaviCongestionInfo) {
    }

    public GuideNaviListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mLogicView = new WeakReference<>((INaviContract.LogicView) iBaseNaviLogicView);
        this.mPresenter = new WeakReference<>((NaviScenePresenter) baseNaviPresenter);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(final List<XPNaviInfo> list) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mLogicView.get() == null || GuideNaviListener.this.mPresenter.get() == null) {
                    return;
                }
                if (!((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).getMapView().isFollowMode()) {
                    ((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).getMainContext().updateRecenterBtn();
                }
                ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).updateNaviInfo(list, false);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateExitDirectionInfo(final XPExitDirectionInfo xPExitDirectionInfo) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).onShowExitInfo(xPExitDirectionInfo);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateCrossImage(final XPCrossImageInfo xPCrossImageInfo, final int i, final boolean z) {
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(">>> onUpdateCrossImage isShow = ");
        sb.append(z);
        sb.append(", type: ");
        sb.append(xPCrossImageInfo != null ? xPCrossImageInfo.mType : i);
        L.i(tag, sb.toString());
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.-$$Lambda$GuideNaviListener$oOEOdTe0n0O4rBDgm1TGJylpGvc
            @Override // java.lang.Runnable
            public final void run() {
                GuideNaviListener.this.lambda$onUpdateCrossImage$0$GuideNaviListener(z, xPCrossImageInfo, i);
            }
        });
    }

    public /* synthetic */ void lambda$onUpdateCrossImage$0$GuideNaviListener(boolean z, XPCrossImageInfo xPCrossImageInfo, int i) {
        if (this.mLogicView.get() == null) {
            return;
        }
        if (z) {
            this.mLogicView.get().onShowCrossImage(xPCrossImageInfo);
        } else {
            this.mLogicView.get().onHideCrossImage(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviLaneInfo(final XPLaneInfo xPLaneInfo, final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.3
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                if (z) {
                    ((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).onShowNaviLaneInfo(xPLaneInfo);
                } else {
                    ((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).onHideNaviLaneInfo();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateSAPA(final List<XPFacilityInfo> list) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.4
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mPresenter.get() == null) {
                    return;
                }
                ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).onUpdateSAPA(list);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateTMCLightBar(List<ILightBarInfo> list, final int i, final boolean z) {
        if (this.mPresenter.get() == null) {
            return;
        }
        final ILightBarInfo iLightBarInfo = null;
        Iterator<ILightBarInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ILightBarInfo next = it.next();
            if (next.getPathId() == this.mPresenter.get().getLastPathID()) {
                iLightBarInfo = next;
                break;
            }
        }
        if (iLightBarInfo != null) {
            UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.5
                @Override // java.lang.Runnable
                public void run() {
                    ((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).onUpdateTMCLightBar(iLightBarInfo, i, z);
                }
            });
        }
        if (z) {
            this.mLogicView.get().getMapView().getBizControlManager().updateRouteTmc(list);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onShowTollGateLane(final XPTollGateInfo xPTollGateInfo) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.6
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).onUpdateTollGateInfo(xPTollGateInfo);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateViaPass(final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.7
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                PostChargeStationStatus.getInstance().postUpdateRouteStatus();
                ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).onUpdateViaPass(j);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onReroute(RouteParams routeParams) {
        super.onReroute(routeParams);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onChangeNaviPath(final long j) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.8
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mPresenter.get() == null) {
                    return;
                }
                boolean isOpenRadar = SettingWrapper.isOpenRadar();
                ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).selectMainPath(j, false);
                if (!isOpenRadar) {
                    ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).updateTBTAndRoute(false, TBTManager.getInstance().getCurrentNaviId(), TBTManager.getInstance().getCurrentNaviPathIndex());
                }
                ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).setIsNeedShowRecommendRoute(false);
                ((IBaseNaviLogicView) GuideNaviListener.this.mBaseLogicView.get()).onHideRecommendRoutePop();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onSelectMainPathStatus(final long j, int i) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.9
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mPresenter.get() == null || GuideNaviListener.this.mLogicView.get() == null) {
                    return;
                }
                ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).selectMainPath(j, true);
                ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).setIsNeedShowRecommendRoute(false);
                ((INaviContract.LogicView) GuideNaviListener.this.mLogicView.get()).onHideRecommendRoutePop();
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onBeforePathChanged(final boolean z) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviListener.10
            @Override // java.lang.Runnable
            public void run() {
                if (GuideNaviListener.this.mPresenter.get() != null && z) {
                    ((NaviScenePresenter) GuideNaviListener.this.mPresenter.get()).hideCrossImage();
                }
            }
        });
    }
}
