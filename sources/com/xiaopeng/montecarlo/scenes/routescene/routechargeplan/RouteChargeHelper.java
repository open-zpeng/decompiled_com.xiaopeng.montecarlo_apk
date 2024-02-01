package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.convert.HttpResponseConverter;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.GeneralChargeInfo;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PdExternalData;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.util.TBTUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeModel;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecorator;
import com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.views.ChargeRouteView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class RouteChargeHelper implements IRouteChargeContract.IRouteChargeHelper, RouteChargeDecoratorModel.IRouteChargeDecoratorCallBack, RouteChargeModel.IRouteChargeModelCallBack, XCountDownTimer.ITimerCallback {
    private static final int HIGHWAY_DISTANCE_MIN = 50000;
    private static final int MAX_CAR_REMAIN = 300000;
    public static final float MAX_CHARGE_PERCENT = 0.9f;
    private static final L.Tag TAG = new L.Tag("ROUTE_CHARGE_Helper");
    private IVariantPath mCurrentPath;
    private IPathResult mIPathResult;
    private boolean mIsFirstEnable;
    private IRouteChargeContract.IRouteChargePresenter mPresenter;
    private final HashMap<Long, RouteChargeResultData> mChargeResultList = new HashMap<>();
    private final TreeSet<GeneralChargeInfo> mSelectedCharges = new TreeSet<>();
    private final XCountDownTimer mTimer = new XCountDownTimer(UILooperObserver.ANR_TRIGGER_TIME, this);
    private ConcurrentHashMap<Long, PdExternalData> mDataMap = new ConcurrentHashMap<>();
    private boolean mIsHighway = false;
    private boolean mFunctionEnable = false;
    private int mLastReachableIndex = -1;
    private boolean mIsLoadingCharge = false;
    private List<Integer> mToastSpeak = new ArrayList();
    private RouteChargeModel mModel = new RouteChargeModel(this);
    private RouteChargeDecoratorModel mChargeDecoratorModel = new RouteChargeDecoratorModel(this);

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTick(long j) {
    }

    public RouteChargeHelper(IRouteChargeContract.IRouteChargePresenter iRouteChargePresenter) {
        this.mIsFirstEnable = true;
        this.mPresenter = iRouteChargePresenter;
        this.mIsFirstEnable = DataSetHelper.AccountSet.getBoolean(DataSetHelper.AccountSet.KEY_ROUTE_CHARGE_FIRST_ENABLE, true);
        this.mToastSpeak.clear();
    }

    public static long getMaxRemainAfterCharge() {
        return CarServiceManager.getInstance().getMaxMileAge() * 0.9f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Coord2DDouble> getRouteKeyPoints(@NonNull ConcurrentHashMap<Long, PdExternalData> concurrentHashMap, long j) {
        PdExternalData pdExternalData = concurrentHashMap.get(Long.valueOf(j));
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getRouteKeyPoints for path: ");
            sb.append(j);
            sb.append(", is points null: ");
            sb.append(pdExternalData == null);
            L.d(tag, sb.toString());
        }
        if (pdExternalData == null || pdExternalData.getData(PdExternalData.KEY_ROUTE_POINTS) == null) {
            return null;
        }
        return (List) pdExternalData.getData(PdExternalData.KEY_ROUTE_POINTS);
    }

    public static boolean isChargeArrival(GeneralChargeInfo generalChargeInfo, TreeSet<GeneralChargeInfo> treeSet) {
        return ((long) generalChargeInfo.getCostDistance()) - (CollectionUtils.isEmpty(treeSet) ? 0L : (long) treeSet.last().getCostDistance()) <= (CollectionUtils.isEmpty(treeSet) ? (long) CarServiceManager.getInstance().getCarRemainDistance() : getMaxRemainAfterCharge());
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public boolean isRouteChargeEnable() {
        return this.mFunctionEnable;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public boolean isRouteChargeLoading() {
        return this.mIsLoadingCharge;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public void onRouteUpdate(IPathResult iPathResult, int i, RouteParams routeParams) {
        this.mChargeDecoratorModel.removeAllCharges();
        this.mModel.stop();
        stopAutoOverViewTimer();
        this.mIPathResult = iPathResult;
        this.mCurrentPath = iPathResult.getPath(i);
        this.mIsHighway = (routeParams.mConstrainCode & 64) == 64;
        this.mChargeResultList.clear();
        this.mSelectedCharges.clear();
        this.mDataMap.clear();
        L.Tag tag = TAG;
        L.i(tag, " onRouteUpdate index: " + i + ", path: " + this.mCurrentPath.getPathId() + ", path count: " + this.mIPathResult.getPathCount() + ", mIsHighway: " + this.mIsHighway);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public void enableChargeFunction(boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "enable route charge function: " + z + ",mIsFirstEnable :" + this.mIsFirstEnable);
        if (z != this.mFunctionEnable) {
            this.mFunctionEnable = z;
            if (this.mIsFirstEnable) {
                this.mIsFirstEnable = false;
                DataSetHelper.AccountSet.set(DataSetHelper.AccountSet.KEY_ROUTE_CHARGE_FIRST_ENABLE, this.mIsFirstEnable);
            }
            if (this.mCurrentPath == null) {
                L.e(TAG, " current path null on enableChargeFunction");
            } else if (z) {
                startRouteChargeProcess();
            } else {
                this.mModel.stop();
                this.mChargeDecoratorModel.stop();
                showChargeLoading(false);
                stopAutoOverViewTimer();
            }
        }
    }

    @MainThread
    private void showChargeLoading(boolean z) {
        this.mIsLoadingCharge = z;
        this.mPresenter.showChargeLoading(z);
    }

    private void startRouteChargeProcess() {
        RouteChargeResultData routeChargesOfPath = getRouteChargesOfPath(this.mCurrentPath.getPathId());
        if (routeChargesOfPath == null) {
            if (isDataValid()) {
                showChargeLoading(true);
                this.mModel.startChargeRequest(this.mDataMap);
                return;
            }
            return;
        }
        notifyChargeResultStatus(routeChargesOfPath);
    }

    private boolean isDataValid() {
        if (this.mDataMap.size() > 0) {
            for (Long l : this.mDataMap.keySet()) {
                if (!CollectionUtils.isEmpty(getRouteKeyPoints(this.mDataMap, l.longValue()))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public void onMainRouteChange(int i) {
        this.mChargeDecoratorModel.removeAllCharges();
        IPathResult iPathResult = this.mIPathResult;
        if (iPathResult == null || i < 0 || i > iPathResult.getPathCount() - 1) {
            L.Tag tag = TAG;
            L.e(tag, " onMainRouteChange index: " + i + " not in current paths or mIPathResult is null");
            return;
        }
        stopAutoOverViewTimer();
        this.mCurrentPath = this.mIPathResult.getPath(i);
        L.Tag tag2 = TAG;
        L.i(tag2, " onMainRouteChange  index: " + i + ", mFunctionEnable: " + this.mFunctionEnable + ", pathId: " + this.mCurrentPath.getPathId());
        RouteChargeResultData routeChargeResultData = this.mChargeResultList.get(Long.valueOf(this.mCurrentPath.getPathId()));
        if (routeChargeResultData == null) {
            L.Tag tag3 = TAG;
            L.e(tag3, " onMainRouteChange null data, path: " + this.mCurrentPath.getPathId());
            return;
        }
        filterSelectedCharges(routeChargeResultData.getChargesMap());
        if (this.mFunctionEnable) {
            notifyChargeResultStatus(routeChargeResultData);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    @MainThread
    public void onUpdateChargePlan(String str, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "onUpdateChargePlan: " + str + ", isAdded: " + z);
        if (this.mCurrentPath != null) {
            if (z) {
                onToAddChargesToPlan(str);
            } else {
                onToRemoveChargesToPlan(str);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelperContainer.IRouteExternalDataListener
    public void onKeyPointsFetched(Map<Long, PdExternalData> map) {
        boolean z;
        boolean z2;
        if (this.mIPathResult == null) {
            L.e(TAG, "onKeyPointsFetched: mIPathResult is null");
            return;
        }
        boolean z3 = false;
        if (this.mDataMap.size() > 0) {
            boolean z4 = true;
            boolean z5 = true;
            for (int i = 0; i < this.mIPathResult.getPathCount(); i++) {
                long pathId = this.mIPathResult.getPath(i) != null ? this.mIPathResult.getPath(i).getPathId() : -1L;
                if (pathId > 0 && this.mDataMap.get(Long.valueOf(pathId)) == null) {
                    IVariantPath iVariantPath = this.mCurrentPath;
                    if (iVariantPath == null || pathId != iVariantPath.getPathId()) {
                        z4 = false;
                    } else {
                        z4 = false;
                        z5 = false;
                    }
                }
            }
            z = !z4;
            z2 = !z5;
        } else {
            z = true;
            z2 = true;
        }
        if (z) {
            if (this.mDataMap.size() > 0) {
                this.mDataMap.clear();
            }
            this.mDataMap.putAll(map);
        }
        boolean isRouteCanPlanCharge = isRouteCanPlanCharge();
        L.i(TAG, " route key points fetched, can charge: " + isRouteCanPlanCharge + ", dataMap: " + map.size() + ",isNotify: " + z2 + ", isPointsUpdate： " + z);
        if (z2) {
            IRouteChargeContract.IRouteChargePresenter iRouteChargePresenter = this.mPresenter;
            boolean z6 = this.mFunctionEnable;
            if (this.mIsFirstEnable && isRouteCanPlanCharge) {
                z3 = true;
            }
            iRouteChargePresenter.updateRouteChargePlanSwitchStatus(z6, z3);
            if (this.mFunctionEnable) {
                startRouteChargeProcess();
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public void onFocusCharge(String str, int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "onFocusCharge:" + str);
        boolean isReachable = RouteChargeDecorator.isReachable(i2);
        showDetailOfCharge(str, isReachable, isReachable, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showDetailOfCharge(java.lang.String r27, boolean r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper.showDetailOfCharge(java.lang.String, boolean, boolean, boolean):void");
    }

    private boolean isRouteCanPlanCharge() {
        long j;
        int i;
        IVariantPath iVariantPath = this.mCurrentPath;
        if (iVariantPath == null) {
            return false;
        }
        PdExternalData pdExternalData = this.mDataMap.get(Long.valueOf(iVariantPath.getPathId()));
        if (pdExternalData == null || pdExternalData.getData(PdExternalData.KEY_ROUTE_REMAIN_DIS) == null || pdExternalData.getData(PdExternalData.KEY_HIGHWAY_DIS) == null) {
            j = 0;
            i = 0;
        } else {
            i = ((Integer) pdExternalData.getData(PdExternalData.KEY_ROUTE_REMAIN_DIS)).intValue();
            j = ((Long) pdExternalData.getData(PdExternalData.KEY_HIGHWAY_DIS)).longValue();
        }
        L.i(TAG, " routeRemainDis: " + i + ", highwayDis: " + j + ",mIsHighway:" + this.mIsHighway);
        return i <= 0;
    }

    private boolean isDestinationRemainArrival() {
        IVariantPath iVariantPath = this.mCurrentPath;
        if (iVariantPath == null) {
            return false;
        }
        PdExternalData pdExternalData = this.mDataMap.get(Long.valueOf(iVariantPath.getPathId()));
        int intValue = (pdExternalData == null || pdExternalData.getData(PdExternalData.KEY_ROUTE_REMAIN_DIS) == null) ? 0 : ((Integer) pdExternalData.getData(PdExternalData.KEY_ROUTE_REMAIN_DIS)).intValue();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, " routeRemainDis: " + intValue);
        }
        return intValue > 0;
    }

    private boolean isDestinationArrival() {
        return isDestinationRemainArrival() || isCurrentRoutePlanSuccess();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public boolean isCurrentRoutePlanSuccess() {
        return !this.mSelectedCharges.isEmpty() && ((long) (getPathCostDis() - this.mSelectedCharges.last().getCostDistance())) < getMaxRemainAfterCharge();
    }

    private long getFirstDisGap(GeneralChargeInfo generalChargeInfo) {
        return generalChargeInfo.getCostDistance() - CarServiceManager.getInstance().getCarRemainDistance();
    }

    private void notifyChargeResultStatus(@NonNull RouteChargeResultData routeChargeResultData) {
        String string;
        String[] remainDistanceArray;
        boolean z = false;
        showChargeLoading(false);
        int routeChargeResultStatus = getRouteChargeResultStatus(routeChargeResultData);
        L.i(TAG, "notifyChargeResultStatus: " + routeChargeResultStatus);
        if (routeChargeResultStatus == 0) {
            string = ContextUtils.getString(R.string.route_charge_plan_low_power);
        } else if (routeChargeResultStatus == 1) {
            string = ContextUtils.getString(R.string.route_charge_plan_power_warning);
        } else if (routeChargeResultStatus == 2) {
            string = ContextUtils.getString(R.string.route_charge_plan_power_first_unreachable);
        } else {
            string = routeChargeResultStatus != 3 ? "" : ContextUtils.getString(R.string.route_charge_plan_power_safe);
        }
        boolean isDestinationRemainArrival = isDestinationRemainArrival();
        if (!TextUtils.isEmpty(string) && !isDestinationRemainArrival) {
            if ((routeChargeResultStatus == 2 || routeChargeResultStatus == 1) && !this.mToastSpeak.contains(Integer.valueOf(routeChargeResultStatus))) {
                this.mToastSpeak.add(Integer.valueOf(routeChargeResultStatus));
                TTSProxy.getInstance().speak(string, null);
            }
            this.mPresenter.showRouteChargeToast(string);
        } else if (isDestinationRemainArrival && (remainDistanceArray = NaviUtil.getRemainDistanceArray(getCurrentPathRemainDis())) != null && remainDistanceArray.length >= 2) {
            this.mPresenter.showRouteChargeToast(ContextUtils.getString(R.string.route_charge_switch_message, remainDistanceArray[0] + remainDistanceArray[1]));
        }
        boolean isCurrentRoutePlanSuccess = isCurrentRoutePlanSuccess();
        if (this.mIsFirstEnable) {
            if (CollectionUtils.isNotEmpty(routeChargeResultData.getCharges())) {
                this.mChargeDecoratorModel.initCharges(routeChargeResultData.getCharges(), isDestinationRemainArrival);
            }
        } else if (CollectionUtils.isNotEmpty(routeChargeResultData.getCharges())) {
            RouteChargeDecoratorModel routeChargeDecoratorModel = this.mChargeDecoratorModel;
            List<GeneralChargeInfo> charges = routeChargeResultData.getCharges();
            TreeSet<GeneralChargeInfo> treeSet = this.mSelectedCharges;
            if (isDestinationRemainArrival || isCurrentRoutePlanSuccess) {
                z = true;
            }
            routeChargeDecoratorModel.updateCharges(charges, treeSet, z);
        }
    }

    private double getPathK() {
        GeneralChargeInfo charge;
        RouteChargeResultData currentRouteCharges = getCurrentRouteCharges();
        if (currentRouteCharges != null) {
            int i = this.mLastReachableIndex;
            if (i > -1 && i < currentRouteCharges.getChargeSize()) {
                charge = currentRouteCharges.getCharge(this.mLastReachableIndex);
            } else {
                charge = currentRouteCharges.getCharge(currentRouteCharges.getChargeSize() - 1);
            }
            if (charge != null) {
                return (charge.getCostDistance() * 1.0d) / charge.getDistance();
            }
        }
        return 1.0d;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public void stopAutoOverViewTimer() {
        XCountDownTimer xCountDownTimer = this.mTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.stop();
        }
    }

    private void filterSelectedCharges(LinkedHashMap<String, GeneralChargeInfo> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            this.mSelectedCharges.clear();
        } else if (CollectionUtils.isEmpty(this.mSelectedCharges)) {
        } else {
            HashSet hashSet = new HashSet();
            Iterator<GeneralChargeInfo> it = this.mSelectedCharges.iterator();
            while (it.hasNext()) {
                GeneralChargeInfo next = it.next();
                if (!TextUtils.isEmpty(next.getStationId())) {
                    GeneralChargeInfo generalChargeInfo = linkedHashMap.get(next.getStationId());
                    if (generalChargeInfo == null) {
                        break;
                    }
                    hashSet.add(generalChargeInfo);
                }
            }
            this.mSelectedCharges.clear();
            this.mSelectedCharges.addAll(hashSet);
        }
    }

    private RouteChargeResultData getCurrentRouteCharges() {
        IVariantPath iVariantPath = this.mCurrentPath;
        if (iVariantPath == null) {
            L.i(TAG, " current path null on enableChargeFunction");
            return null;
        }
        return getRouteChargesOfPath(iVariantPath.getPathId());
    }

    private RouteChargeResultData getRouteChargesOfPath(long j) {
        if (this.mChargeResultList.size() > 0) {
            return this.mChargeResultList.get(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GeneralChargeInfo getCharge(String str) {
        RouteChargeResultData routeChargeResultData = this.mChargeResultList.get(Long.valueOf(this.mCurrentPath.getPathId()));
        if (routeChargeResultData != null) {
            return routeChargeResultData.getCharge(str);
        }
        return null;
    }

    private void onToAddChargesToPlan(String str) {
        GeneralChargeInfo charge = getCharge(str);
        if (charge == null) {
            return;
        }
        long carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        if (this.mSelectedCharges.isEmpty() && charge.getCostDistance() > carRemainDistance) {
            this.mPresenter.showRouteChargePlanDialog(ContextUtils.getString(R.string.route_charge_plan_warning, NaviUtil.getDistanceString(charge.getCostDistance())), str, new IRouteChargeContract.IRoutePlanConfirmCallBack() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper.1
                @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRoutePlanConfirmCallBack
                public void onConfirm(String str2) {
                    GeneralChargeInfo charge2 = RouteChargeHelper.this.getCharge(str2);
                    if (charge2 == null) {
                        return;
                    }
                    RouteChargeHelper.this.addChargesToPlan(charge2);
                }
            });
        } else if (this.mSelectedCharges.size() >= 9) {
            this.mPresenter.showRouteChargePlanDialog(ContextUtils.getString(R.string.route_fail_reason_charge_waypoint_exceed), str, null);
        } else {
            addChargesToPlan(charge);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChargesToPlan(GeneralChargeInfo generalChargeInfo) {
        RouteChargeResultData currentRouteCharges = getCurrentRouteCharges();
        if (currentRouteCharges == null || CollectionUtils.isEmpty(currentRouteCharges.getCharges())) {
            return;
        }
        this.mSelectedCharges.add(generalChargeInfo);
        boolean isCurrentRoutePlanSuccess = isCurrentRoutePlanSuccess();
        if (CollectionUtils.isNotEmpty(currentRouteCharges.getCharges())) {
            this.mChargeDecoratorModel.addSelectedCharge(currentRouteCharges.getCharges(), generalChargeInfo, this.mSelectedCharges, isCurrentRoutePlanSuccess);
        }
        this.mPresenter.showRouteChargeToast(ContextUtils.getString(R.string.route_charge_plan_success));
        this.mPresenter.addRouteChargeToBar(transferToChargePoint(generalChargeInfo), getPathK(), isCurrentRoutePlanSuccess);
        sendChargeUpdateData(true, currentRouteCharges, generalChargeInfo);
        L.Tag tag = TAG;
        L.i(tag, "add charge success, stationId: " + generalChargeInfo.getStationId());
    }

    private ChargeRouteView.ChargePoint transferToChargePoint(GeneralChargeInfo generalChargeInfo) {
        ChargeRouteView.ChargePoint chargePoint = new ChargeRouteView.ChargePoint();
        chargePoint.mChargePointRouteDistance = generalChargeInfo.getDistance();
        chargePoint.mChargePointState = 2;
        chargePoint.mIsSelected = false;
        chargePoint.mPoiId = generalChargeInfo.getStationId();
        return chargePoint;
    }

    private List<ChargeRouteView.ChargePoint> transferToChargePoints(TreeSet<GeneralChargeInfo> treeSet) {
        ArrayList arrayList = new ArrayList();
        Iterator<GeneralChargeInfo> it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(transferToChargePoint(it.next()));
        }
        return arrayList;
    }

    private void onToRemoveChargesToPlan(String str) {
        final RouteChargeResultData currentRouteCharges = getCurrentRouteCharges();
        if (currentRouteCharges == null || CollectionUtils.isEmpty(currentRouteCharges.getCharges()) || this.mSelectedCharges.isEmpty() || getCharge(str) == null) {
            return;
        }
        if (this.mSelectedCharges.last().getStationId().equals(str)) {
            removeChargeFromPlan(true, currentRouteCharges, str);
        } else {
            this.mPresenter.showRouteChargePlanDialog(ContextUtils.getString(R.string.route_charge_plan_delete_post), str, new IRouteChargeContract.IRoutePlanConfirmCallBack() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper.2
                @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRoutePlanConfirmCallBack
                public void onConfirm(String str2) {
                    RouteChargeHelper.this.removeChargeFromPlan(false, currentRouteCharges, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeChargeFromPlan(boolean z, RouteChargeResultData routeChargeResultData, String str) {
        GeneralChargeInfo charge = getCharge(str);
        if (charge == null || this.mSelectedCharges.isEmpty()) {
            return;
        }
        TreeSet<GeneralChargeInfo> treeSet = new TreeSet<>();
        ArrayList arrayList = new ArrayList();
        if (z) {
            this.mSelectedCharges.remove(charge);
            treeSet.add(charge);
            arrayList.add(charge.getStationId());
        } else {
            Iterator<GeneralChargeInfo> it = this.mSelectedCharges.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                GeneralChargeInfo next = it.next();
                if (!z2 && next.getStationId().equals(charge.getStationId())) {
                    z2 = true;
                    treeSet.add(next);
                    arrayList.add(next.getStationId());
                    it.remove();
                } else if (z2) {
                    it.remove();
                    treeSet.add(next);
                    arrayList.add(next.getStationId());
                }
            }
        }
        boolean isChargeArrival = isChargeArrival(charge, this.mSelectedCharges);
        if (CollectionUtils.isNotEmpty(routeChargeResultData.getCharges())) {
            this.mChargeDecoratorModel.removeSelectedCharges(routeChargeResultData.getCharges(), this.mSelectedCharges, treeSet, isDestinationArrival());
        }
        this.mPresenter.removeRouteChargesOnBar(arrayList, getPathK(), isCurrentRoutePlanSuccess());
        showDetailOfCharge(str, isChargeArrival, isChargeArrival, false);
        sendChargeUpdateData(false, routeChargeResultData, charge);
        L.i(TAG, "remove charge success: " + str + ", name: " + charge.getStationName());
    }

    private void sendChargeUpdateData(boolean z, @NonNull RouteChargeResultData routeChargeResultData, @NonNull GeneralChargeInfo generalChargeInfo) {
        int indexOf = CollectionUtils.isEmpty(routeChargeResultData.getCharges()) ? -1 : routeChargeResultData.getCharges().indexOf(generalChargeInfo);
        int i = this.mLastReachableIndex;
        String str = "";
        if (i >= 0 && i < routeChargeResultData.getChargeSize() && routeChargeResultData.getCharge(this.mLastReachableIndex) != null) {
            str = routeChargeResultData.getCharge(this.mLastReachableIndex).getStationId();
        }
        long carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance() - generalChargeInfo.getCostDistance();
        if (z) {
            PageType pageType = PageType.NAVI_ROUTING;
            BtnType btnType = BtnType.ROUTE_CHARGE_ADD;
            Object[] objArr = new Object[9];
            objArr[0] = generalChargeInfo.getStationId();
            objArr[1] = generalChargeInfo.getLat() + "," + generalChargeInfo.getLon();
            objArr[2] = Integer.valueOf(indexOf);
            objArr[3] = Integer.valueOf(generalChargeInfo.getDistance());
            objArr[4] = Integer.valueOf(generalChargeInfo.getCostDistance());
            objArr[5] = Long.valueOf(carRemainDistance);
            objArr[6] = 1;
            objArr[7] = Boolean.valueOf(indexOf == this.mLastReachableIndex);
            objArr[8] = str;
            DataLogUtil.sendStatData(pageType, btnType, objArr);
            return;
        }
        PageType pageType2 = PageType.NAVI_ROUTING;
        BtnType btnType2 = BtnType.ROUTE_CHARGE_REMOVE;
        Object[] objArr2 = new Object[8];
        objArr2[0] = generalChargeInfo.getStationId();
        objArr2[1] = generalChargeInfo.getLat() + "," + generalChargeInfo.getLon();
        objArr2[2] = Integer.valueOf(indexOf);
        objArr2[3] = Integer.valueOf(generalChargeInfo.getDistance());
        objArr2[4] = Integer.valueOf(generalChargeInfo.getCostDistance());
        objArr2[5] = Long.valueOf(carRemainDistance);
        objArr2[6] = 1;
        objArr2[7] = Boolean.valueOf(indexOf == this.mLastReachableIndex);
        DataLogUtil.sendStatData(pageType2, btnType2, objArr2);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeModel.IRouteChargeModelCallBack
    public void onNetworkError() {
        this.mPresenter.onNetworkError(R.string.network_busy);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeModel.IRouteChargeModelCallBack
    public void onRouteChargesError() {
        showChargeLoading(false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeModel.IRouteChargeModelCallBack
    public void onRouteChargesFetched(@NonNull RouteChargeResultData routeChargeResultData) {
        L.Tag tag = TAG;
        L.i(tag, "charges fetched for path: " + routeChargeResultData.getPathId());
        if (isPathOutOfDate(routeChargeResultData.getPathId())) {
            showChargeLoading(false);
            return;
        }
        L.Tag tag2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("charges fetched for path: ");
        sb.append(routeChargeResultData.getPathId());
        sb.append(", size: ");
        sb.append(routeChargeResultData.getCharges() == null ? "0" : Integer.valueOf(routeChargeResultData.getCharges().size()));
        sb.append(", mFunctionEnable: ");
        sb.append(this.mFunctionEnable);
        L.i(tag2, sb.toString());
        this.mChargeResultList.put(Long.valueOf(routeChargeResultData.getPathId()), routeChargeResultData);
        if (this.mFunctionEnable && this.mCurrentPath != null && routeChargeResultData.getPathId() == this.mCurrentPath.getPathId()) {
            showChargeLoading(false);
            notifyChargeResultStatus(routeChargeResultData);
        }
    }

    private boolean isPathOutOfDate(long j) {
        if (this.mIPathResult != null) {
            for (int i = 0; i < this.mIPathResult.getPathCount(); i++) {
                if (this.mIPathResult.getPath(i).getPathId() == j) {
                    return false;
                }
            }
        }
        L.e(TAG, "onRouteChargesFetched charges out of date: " + j);
        return true;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel.IRouteChargeDecoratorCallBack
    public void updateDecorators(int i, XPPointBaseData[] xPPointBaseDataArr, int i2, int i3) {
        int i4;
        GeneralChargeInfo charge;
        double parseDouble;
        double parseDouble2;
        stopAutoOverViewTimer();
        if (xPPointBaseDataArr == null || this.mCurrentPath == null) {
            return;
        }
        this.mLastReachableIndex = i2;
        this.mPresenter.showRouteChargerDecorator(xPPointBaseDataArr, i3);
        RouteChargeResultData routeChargesOfPath = getRouteChargesOfPath(this.mCurrentPath.getPathId());
        if (routeChargesOfPath == null) {
            return;
        }
        boolean isCurrentRoutePlanSuccess = isCurrentRoutePlanSuccess();
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        if (i == 0 || i == 1) {
            if (i == 0) {
                i4 = 1;
                this.mPresenter.initRouteChargeBar(this.mCurrentPath.getPathLength(), this.mCurrentPath.getPathLength(), carRemainDistance, getPathK(), isCurrentRoutePlanSuccess);
            } else {
                i4 = 1;
                this.mPresenter.updateRouteChargesBar(this.mCurrentPath.getPathLength(), this.mCurrentPath.getPathLength(), carRemainDistance, transferToChargePoints(this.mSelectedCharges), getPathK(), isCurrentRoutePlanSuccess);
            }
            int routeChargeResultStatus = getRouteChargeResultStatus(routeChargesOfPath);
            if (routeChargeResultStatus != 0) {
                this.mPresenter.notifyOverViewRouteChargeDecorator(null);
            }
            if (isDestinationRemainArrival() || i2 < 0 || routeChargeResultStatus == i4 || this.mTimer == null) {
                return;
            }
            if (L.ENABLE) {
                L.d(TAG, "preview timer start");
            }
            this.mTimer.start();
        } else if (i == 2 || i == 3) {
            this.mPresenter.updatePathK(getPathK());
            if (isDestinationArrival()) {
                this.mPresenter.notifyOverViewRouteChargeDecorator(null);
                return;
            }
            if (i == 3) {
                if (this.mSelectedCharges.size() > 0) {
                    GeneralChargeInfo last = this.mSelectedCharges.last();
                    parseDouble = Double.parseDouble(last.getLon());
                    parseDouble2 = Double.parseDouble(last.getLat());
                } else {
                    XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
                    parseDouble = startPOIFromCurrent.getDisplayLon();
                    parseDouble2 = startPOIFromCurrent.getDisplayLat();
                }
            } else if (i3 < 0 || i3 > routeChargesOfPath.getChargeSize() - 1 || i3 == this.mLastReachableIndex || (charge = routeChargesOfPath.getCharge(i3)) == null) {
                return;
            } else {
                parseDouble = Double.parseDouble(charge.getLon());
                parseDouble2 = Double.parseDouble(charge.getLat());
            }
            updatePreviewToLastReachable(parseDouble, parseDouble2, routeChargesOfPath);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.decorator.RouteChargeDecoratorModel.IRouteChargeDecoratorCallBack
    public void removeDecorators(XPPointBaseData[] xPPointBaseDataArr) {
        this.mPresenter.removeRouteChargeDecorators(xPPointBaseDataArr);
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public TreeSet<GeneralChargeInfo> getSelectedCharges() {
        return this.mSelectedCharges;
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public void onStartNavi(boolean z) {
        RouteChargeResultData routeChargeResultData;
        stopAutoOverViewTimer();
        this.mChargeDecoratorModel.stop();
        this.mModel.stop();
        L.i(TAG, "onStartNavi mFunctionEnable: " + this.mFunctionEnable + ", isExplore: " + z);
        if (this.mFunctionEnable) {
            int i = -1;
            boolean z2 = true;
            boolean z3 = !isDestinationRemainArrival();
            if (this.mCurrentPath != null && this.mChargeResultList.size() > 0 && (routeChargeResultData = this.mChargeResultList.get(Long.valueOf(this.mCurrentPath.getPathId()))) != null) {
                if (isCurrentRoutePlanSuccess()) {
                    z3 = this.mSelectedCharges.first().getCostDistance() > CarServiceManager.getInstance().getCarRemainDistance();
                    if (z3) {
                        i = R.string.route_charge_remind_first_on_navi_start;
                    }
                } else {
                    int routeChargeResultStatus = getRouteChargeResultStatus(routeChargeResultData);
                    z3 = (this.mSelectedCharges.isEmpty() && routeChargeResultStatus == 2) || routeChargeResultStatus == 1;
                    if (z3) {
                        i = R.string.route_charge_remind_warning_on_navi_start;
                    }
                }
            }
            TreeSet<GeneralChargeInfo> selectedCharges = getSelectedCharges();
            ArrayList arrayList = new ArrayList();
            List<XPViaPoint> viaInfos = TBTManager.getInstance().getViaInfos(TBTManager.getInstance().getCurrentRouteRequestId());
            if (viaInfos != null) {
                arrayList.addAll(viaInfos);
            }
            if (selectedCharges.size() > 0) {
                if (CollectionUtils.isNotEmpty(arrayList)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        long pathViaDistance = TBTUtil.getPathViaDistance(this.mCurrentPath.getPathId(), i2);
                        if (pathViaDistance >= 0) {
                            ((XPViaPoint) arrayList.get(i2)).setDistance((int) pathViaDistance);
                        }
                    }
                } else {
                    z2 = false;
                }
                Iterator<GeneralChargeInfo> it = selectedCharges.iterator();
                while (it.hasNext()) {
                    GeneralChargeInfo next = it.next();
                    XPViaPoint xPViaPoint = new XPViaPoint(HttpResponseConverter.generalChargeInfo2XPPoiInfo(next));
                    xPViaPoint.setViaType(4);
                    xPViaPoint.setDistance(next.getDistance());
                    arrayList.add(xPViaPoint);
                }
                if (z2) {
                    Collections.sort(arrayList, new Comparator<XPViaPoint>() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeHelper.3
                        @Override // java.util.Comparator
                        public int compare(XPViaPoint xPViaPoint2, XPViaPoint xPViaPoint3) {
                            return Integer.compare(xPViaPoint2.getDistance(), xPViaPoint3.getDistance());
                        }
                    });
                }
                this.mPresenter.requestRouteWithCharges(i, z, z3, RouteRequest.createUpdateViaRequest(arrayList, TBTManager.getInstance().getCurrentRouteRequestId()));
                return;
            }
            this.mPresenter.startNaviNoCharge(z, i, z3);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public XPPointBaseData[] getDecoratorData() {
        return this.mChargeDecoratorModel.getBizData();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public void onUnInit() {
        L.i(TAG, "onUnInit");
        stopAutoOverViewTimer();
        this.mModel.unInit();
        this.mChargeDecoratorModel.unInit();
        this.mPresenter = null;
        this.mToastSpeak.clear();
    }

    @Override // com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.IRouteChargeContract.IRouteChargeHelper
    public int getSelectedChargeNum() {
        return this.mSelectedCharges.size();
    }

    private void updatePreviewToLastReachable(double d, double d2, RouteChargeResultData routeChargeResultData) {
        L.i(TAG, "updatePreviewToLastReachable: " + this.mLastReachableIndex);
        ArrayList<XPPointBaseData> arrayList = new ArrayList<>();
        XPPointBaseData xPPointBaseData = new XPPointBaseData();
        xPPointBaseData.position.lon = d;
        xPPointBaseData.position.lat = d2;
        arrayList.add(xPPointBaseData);
        XPPointBaseData xPPointBaseData2 = new XPPointBaseData();
        if (this.mLastReachableIndex == routeChargeResultData.getChargeSize() - 1) {
            XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
            if (endInfo == null) {
                return;
            }
            xPPointBaseData2.position.lon = endInfo.getDisplayLon();
            xPPointBaseData2.position.lat = endInfo.getDisplayLat();
        } else {
            int i = this.mLastReachableIndex;
            if (i < 0 || i >= routeChargeResultData.getChargeSize()) {
                i = routeChargeResultData.getChargeSize() - 1;
            }
            GeneralChargeInfo charge = routeChargeResultData.getCharge(i);
            if (charge != null) {
                xPPointBaseData2.position.lon = Double.parseDouble(charge.getLon());
                xPPointBaseData2.position.lat = Double.parseDouble(charge.getLat());
            }
        }
        arrayList.add(xPPointBaseData2);
        IRouteChargeContract.IRouteChargePresenter iRouteChargePresenter = this.mPresenter;
        iRouteChargePresenter.notifyOverViewRouteChargeDecorator(iRouteChargePresenter.getPreviewRect(arrayList));
    }

    private int getRouteChargeResultStatus(RouteChargeResultData routeChargeResultData) {
        GeneralChargeInfo charge;
        if (routeChargeResultData.getStatus() == 3) {
            long pathCostDis = getPathCostDis();
            if (routeChargeResultData.getChargeSize() > 0 && (charge = routeChargeResultData.getCharge(routeChargeResultData.getChargeSize() - 1)) != null && pathCostDis - charge.getCostDistance() > getMaxRemainAfterCharge()) {
                return 1;
            }
        }
        return routeChargeResultData.getStatus();
    }

    private int getCurrentPathRemainDis() {
        PdExternalData pdExternalData = this.mDataMap.get(Long.valueOf(this.mCurrentPath.getPathId()));
        if (pdExternalData == null || pdExternalData.getData(PdExternalData.KEY_ROUTE_REMAIN_DIS) == null) {
            return 0;
        }
        return ((Integer) pdExternalData.getData(PdExternalData.KEY_ROUTE_REMAIN_DIS)).intValue();
    }

    private int getPathCostDis() {
        return (int) (getPathK() * this.mCurrentPath.getPathLength());
    }

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTimeOut() {
        RouteChargeResultData routeChargesOfPath = getRouteChargesOfPath(this.mCurrentPath.getPathId());
        if (routeChargesOfPath == null) {
            return;
        }
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        updatePreviewToLastReachable(startPOIFromCurrent.getDisplayLon(), startPOIFromCurrent.getDisplayLat(), routeChargesOfPath);
    }
}
