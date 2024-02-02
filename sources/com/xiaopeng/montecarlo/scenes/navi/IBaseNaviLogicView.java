package com.xiaopeng.montecarlo.scenes.navi;

import android.graphics.Bitmap;
import android.text.SpannableString;
import com.autonavi.gbl.common.model.RectDouble;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPManeuverInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPopParam;
import java.util.List;
/* loaded from: classes2.dex */
public interface IBaseNaviLogicView<T extends AbstractBasePresenter> extends IBaseNgpLogicView<T> {
    long getCurrentRequestingId();

    RestrictHelper getRestrictHelper();

    void goToMap();

    void hideCruiseTollGateInfo();

    void hideMapDecorators();

    void hideRouteChargePanelView(boolean z);

    boolean isLeftPanelShow();

    boolean isRecommendComparing();

    void onAsyncManeuverInfo(XPManeuverInfo xPManeuverInfo);

    void onHideRecommendRoutePop();

    void onHideRouting();

    void onHideSimulatePanel();

    void onMapRecenterUpdate();

    void onMotionEvent();

    void onMoveEvent();

    void onNaviStop(int i);

    void onRecommendRoutePopTick(long j);

    void onSRNaviHide();

    void onSRNaviShow();

    void onSelectRoute(int i);

    void onShowChargeViaDetail(XPViaPoint xPViaPoint, int i);

    void onShowNaviIntervalCamera(List<XPCameraInfo> list);

    void onShowNaviManeuver(XPManeuverInfo xPManeuverInfo, XPObtainInfo xPObtainInfo);

    void onShowOfflineRouteMsg(int i, int i2);

    void onShowRecommendRoutePop(String str, int i, String str2, String str3, SpannableString spannableString, IVariantPath iVariantPath, int i2, boolean z);

    void onShowRoute(IPathResult iPathResult, int i);

    void onShowRouteFailMsg(int i);

    void onShowRouting(boolean z);

    void onShowSimulatePanel();

    void onStateActive();

    void onStateImmersion();

    void onUpdateIntervalCameraDynamicInfo(List<XPCameraInfo> list);

    void onUpdateNaviInfo(List<XPNaviInfo> list);

    @Override // com.xiaopeng.montecarlo.scenes.navi.IBaseNgpLogicView
    void onUpdateNgpLcTipsProgress(boolean z, long j, int i, boolean z2);

    void onUpdatePreview(RectDouble rectDouble);

    void onUpdateSimulatePanel();

    void onUpdateViaPass(long j);

    void openFavourite();

    void openSearchNormal();

    void removeChildScene();

    void saveCurrentRequestingId(long j);

    void showCrossIcon(Bitmap bitmap, XPCrossImageInfo xPCrossImageInfo);

    void showCruiseTollGateInfo(List<Integer> list);

    void showNavTrafficEventPop(TrafficEventPopParam trafficEventPopParam);

    void showTurnIcon(Bitmap bitmap);
}
