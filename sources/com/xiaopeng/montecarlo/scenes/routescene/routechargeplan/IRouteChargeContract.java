package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelperContainer;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.views.ChargeRouteView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public interface IRouteChargeContract {

    /* loaded from: classes3.dex */
    public interface IRouteChargeHelper extends RoutePowerDisHelperContainer.IRouteExternalDataListener {
        void enableChargeFunction(boolean z);

        XPPointBaseData[] getDecoratorData();

        int getSelectedChargeNum();

        Set<GeneralChargeInfo> getSelectedCharges();

        boolean isCurrentRoutePlanSuccess();

        boolean isRouteChargeEnable();

        boolean isRouteChargeLoading();

        void onFocusCharge(String str, int i, int i2);

        void onMainRouteChange(int i);

        void onRouteUpdate(IPathResult iPathResult, int i, RouteParams routeParams);

        void onStartNavi(boolean z);

        void onUnInit();

        void onUpdateChargePlan(String str, boolean z);

        void stopAutoOverViewTimer();
    }

    /* loaded from: classes3.dex */
    public interface IRouteChargePresenter {
        void addRouteChargeToBar(ChargeRouteView.ChargePoint chargePoint, double d, boolean z);

        void addRouteKeyPintsTestDecorator(List<Coord2DDouble> list);

        void focusRouteChargeOnBar(ChargeRouteView.ChargePoint chargePoint);

        RectDouble getPreviewRect(ArrayList<XPPointBaseData> arrayList);

        void initRouteChargeBar(long j, long j2, long j3, double d, boolean z);

        void notifyOverViewRouteChargeDecorator(RectDouble rectDouble);

        void onNetworkError(int i);

        void removeRouteChargeDecorators(XPPointBaseData[] xPPointBaseDataArr);

        void removeRouteChargesOnBar(List<String> list, double d, boolean z);

        void requestRouteWithCharges(int i, boolean z, boolean z2, RouteRequest routeRequest);

        void showChargeLoading(boolean z);

        void showRouteChargeDetailView(boolean z, boolean z2, boolean z3, String str, String str2, long j, long j2, boolean z4, long j3, boolean z5, boolean z6);

        void showRouteChargePlanDialog(String str, String str2, IRoutePlanConfirmCallBack iRoutePlanConfirmCallBack);

        void showRouteChargeToast(String str);

        void showRouteChargerDecorator(XPPointBaseData[] xPPointBaseDataArr, int i);

        void startNaviNoCharge(boolean z, int i, boolean z2);

        void updatePathK(double d);

        void updateRouteChargePlanSwitchStatus(boolean z, boolean z2);

        void updateRouteChargesBar(long j, long j2, long j3, List<ChargeRouteView.ChargePoint> list, double d, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface IRoutePlanConfirmCallBack {
        void onConfirm(String str);
    }
}
