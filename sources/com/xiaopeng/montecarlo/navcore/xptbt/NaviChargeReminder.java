package com.xiaopeng.montecarlo.navcore.xptbt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.bean.direction.XPViaPoint;
import com.xiaopeng.montecarlo.navcore.tts.TTSProxy;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class NaviChargeReminder extends BaseNaviListener {
    private static final int CHARGE_VIA_DISTANCE = 1500;
    private static final int MSG_UPDATE_NAVI_INFO = 1;
    private static final int MSG_UPDATE_SAPA = 0;
    private static final int SAPA_DESTINATION_UNARRIVAL_DISTANCE = 20000;
    private static final int SAPA_DESTINATION_WARNING_BATTERY_DISTANCE = 3000;
    private static final int SAPA_LOW_BATTERY_DISTANCE = 60000;
    private static final int SAPA_LOW_BATTERY_REMIND_DISTANCE = 3000;
    private static final int SAPA_MISSED_WARNING_BATTERY_DISTANCE = 1000;
    private static final int SAPA_VIA_COLLAPSE_DISTANCE = 1000;
    private static final int SAPA_WARNING_BATTERY_DISTANCE_1 = 3000;
    private static final int SAPA_WARNING_BATTERY_DISTANCE_2 = 1000;
    private static final L.Tag TAG = new L.Tag("NaviChargeReminder");
    private static final XPFacilityInfo[] sRemindRecordArray = new XPFacilityInfo[5];
    private XPNaviInfo mCurrentNaviInfo;
    private XPFacilityInfo mLastArrivalSa;
    private XPNaviInfo mLastNaviInfo;
    private XPViaPoint mLastRemindXPViaPoint;
    private volatile boolean mStop = false;
    private final Handler mHandler = new ChargeRemindHandler(WorkThreadUtil.getInstance().getStatusThreadLooper());

    private static boolean isSapaHasCharge(long j) {
        return (j & 64) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        reset();
        this.mStop = false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.BaseNaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onNaviStop(int i, boolean z) {
        super.onNaviStop(i, z);
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.BaseNaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateSAPA(List<XPFacilityInfo> list) {
        super.onUpdateSAPA(list);
        this.mHandler.obtainMessage(0, list).sendToTarget();
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.BaseNaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onUpdateNaviInfo(List<XPNaviInfo> list) {
        super.onUpdateNaviInfo(list);
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        this.mCurrentNaviInfo = list.get(0);
        this.mHandler.obtainMessage(1, this.mCurrentNaviInfo).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        L.i(TAG, "reset");
        this.mStop = true;
        this.mLastNaviInfo = null;
        this.mCurrentNaviInfo = null;
        this.mLastRemindXPViaPoint = null;
        this.mLastArrivalSa = null;
        int i = 0;
        while (true) {
            XPFacilityInfo[] xPFacilityInfoArr = sRemindRecordArray;
            if (i < xPFacilityInfoArr.length) {
                xPFacilityInfoArr[i] = null;
                i++;
            } else {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
                return;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.BaseNaviListener, com.xiaopeng.montecarlo.navcore.xptbt.INaviListener
    public void onMainPathChanged() {
        super.onMainPathChanged();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSAPA(List<XPFacilityInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        int i = 0;
        for (XPFacilityInfo xPFacilityInfo : list) {
            if (xPFacilityInfo.mType == 0 && isSapaHasCharge(xPFacilityInfo.mSapaDetail)) {
                arrayList.add(xPFacilityInfo);
                if (carRemainDistance - xPFacilityInfo.mRemainDist > 0) {
                    i++;
                }
            }
        }
        if (i <= 0) {
            XPFacilityInfo xPFacilityInfo2 = list.get(list.size() - 1);
            if (this.mLastArrivalSa != null) {
                if ((arrayList.size() != 0 || carRemainDistance - xPFacilityInfo2.mRemainDist > 0) && (arrayList.size() <= 0 || this.mLastArrivalSa.equals(arrayList.get(0)))) {
                    return;
                }
                if (this.mLastNaviInfo == null) {
                    this.mLastNaviInfo = TBTManager.getInstance().getNaviInfo();
                    L.i(TAG, "mLastNaviInfo: " + this.mLastNaviInfo.mRouteRemainDist);
                }
                XPNaviInfo xPNaviInfo = this.mLastNaviInfo;
                if (xPNaviInfo == null || this.mCurrentNaviInfo == null || xPNaviInfo.mRouteRemainDist - this.mCurrentNaviInfo.mRouteRemainDist < 1000.0d || this.mLastArrivalSa.equals(sRemindRecordArray[0])) {
                    return;
                }
                TTSProxy.getInstance().speak(ContextUtils.getString(R.string.navi_charge_remind_missed_warning), null);
                sRemindRecordArray[0] = this.mLastArrivalSa;
                L.i(TAG, "错过的服务区: " + this.mLastArrivalSa.mName);
                return;
            }
            return;
        }
        if (i <= arrayList.size()) {
            this.mLastArrivalSa = (XPFacilityInfo) arrayList.get(i - 1);
        }
        if (i == 1) {
            XPFacilityInfo xPFacilityInfo3 = (XPFacilityInfo) arrayList.get(0);
            if (carRemainDistance - xPFacilityInfo3.mRemainDist <= 0) {
                return;
            }
            if (xPFacilityInfo3.mRemainDist <= 3000 && xPFacilityInfo3.mRemainDist > 1000 && !xPFacilityInfo3.equals(sRemindRecordArray[1])) {
                z = true;
            }
            if (z || (xPFacilityInfo3.mRemainDist <= 1000 && !xPFacilityInfo3.equals(sRemindRecordArray[2]))) {
                if (z) {
                    sRemindRecordArray[1] = xPFacilityInfo3;
                    L.i(TAG, "可以达到前方第一个充电站服务区 3KM: " + xPFacilityInfo3.mName);
                } else {
                    sRemindRecordArray[2] = xPFacilityInfo3;
                    L.i(TAG, "可以达到前方第一个充电站服务区 1KM: " + xPFacilityInfo3.mName);
                }
                if (isSaVia(xPFacilityInfo3)) {
                    return;
                }
                TTSProxy.getInstance().speak(ContextUtils.getString(R.string.navi_charge_remind_first_arrival), null);
            }
        } else if (TBTManager.getInstance().getCurrentNaviVariantPath() != null) {
            XPFacilityInfo xPFacilityInfo4 = (XPFacilityInfo) arrayList.get(0);
            int i2 = carRemainDistance - xPFacilityInfo4.mRemainDist;
            if (!xPFacilityInfo4.equals(sRemindRecordArray[3]) && xPFacilityInfo4.mRemainDist < 3000 && i2 < 60000) {
                sRemindRecordArray[3] = xPFacilityInfo4;
                L.i(TAG, "用户可以到达多个充电站服务区: " + xPFacilityInfo4.mName);
                if (!isSaVia(xPFacilityInfo4)) {
                    TTSProxy.getInstance().speak(ContextUtils.getString(R.string.charge_in_service_area), null);
                }
            }
            XPFacilityInfo xPFacilityInfo5 = (XPFacilityInfo) arrayList.get(arrayList.size() - 1);
        }
    }

    private boolean isSaVia(XPFacilityInfo xPFacilityInfo) {
        XPNaviInfo xPNaviInfo = this.mCurrentNaviInfo;
        if (xPNaviInfo == null || xPNaviInfo.mViaRemainDist == null || this.mCurrentNaviInfo.mViaRemainDist.length <= 0 || Math.abs(xPFacilityInfo.mRemainDist - this.mCurrentNaviInfo.mViaRemainDist[0]) > 1000) {
            return false;
        }
        L.Tag tag = TAG;
        L.i(tag, "next sa " + xPFacilityInfo.mName + " is via, via distance: " + this.mCurrentNaviInfo.mViaRemainDist[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNaviInfo(XPNaviInfo xPNaviInfo) {
        int[] iArr;
        int i;
        boolean z;
        String string;
        if (xPNaviInfo == null) {
            return;
        }
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        List<XPViaPoint> unPassedViasPoiInfo = TBTManager.getInstance().getUnPassedViasPoiInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        if (CollectionUtils.isNotEmpty(unPassedViasPoiInfo)) {
            XPViaPoint xPViaPoint = unPassedViasPoiInfo.get(0);
            if (!xPViaPoint.isChargeVia() || (iArr = xPNaviInfo.mViaRemainDist) == null || iArr.length <= 0 || iArr.length != unPassedViasPoiInfo.size() || (i = iArr[0]) > 1500 || this.mLastRemindXPViaPoint == xPViaPoint) {
                return;
            }
            int i2 = (int) (xPNaviInfo.mRouteRemainDist - i);
            int i3 = 1;
            while (true) {
                if (i3 >= iArr.length) {
                    z = true;
                    break;
                } else if (i3 < unPassedViasPoiInfo.size() && unPassedViasPoiInfo.get(i3).isChargeVia()) {
                    i2 = iArr[i3] - i;
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (carRemainDistance - i2 > 0) {
                string = ContextUtils.getString(z ? R.string.navi_charge_via_remind_no_charge_end : R.string.navi_charge_via_remind_no_charge_normal);
            } else {
                int i4 = z ? R.string.navi_charge_via_remind_end : R.string.navi_charge_via_remind_normal;
                Object[] objArr = new Object[1];
                int i5 = i2 < 1000 ? R.string.meters_no_space : R.string.km100_no_space;
                Object[] objArr2 = new Object[1];
                if (i2 >= 1000) {
                    i2 /= 1000;
                }
                objArr2[0] = Integer.valueOf(i2);
                objArr[0] = ContextUtils.getString(i5, objArr2);
                string = ContextUtils.getString(i4, objArr);
            }
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("remind charge via: ");
            sb.append(string);
            sb.append(", via index: ");
            sb.append(TBTManager.getInstance().getPassingViaIndex());
            sb.append(", name: ");
            sb.append(xPViaPoint.getPoiPoint() != null ? xPViaPoint.getPoiPoint().getName() : "");
            sb.append(", via distance: ");
            sb.append(i);
            L.i(tag, sb.toString());
            TTSProxy.getInstance().speak(string, null);
            this.mLastRemindXPViaPoint = xPViaPoint;
        }
    }

    /* loaded from: classes3.dex */
    class ChargeRemindHandler extends Handler {
        public ChargeRemindHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (NaviChargeReminder.this.mStop) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                if (message.obj != null) {
                    NaviChargeReminder.this.updateSAPA((List) message.obj);
                }
            } else if (i == 1 && message.obj != null) {
                NaviChargeReminder.this.updateNaviInfo((XPNaviInfo) message.obj);
            }
        }
    }
}
