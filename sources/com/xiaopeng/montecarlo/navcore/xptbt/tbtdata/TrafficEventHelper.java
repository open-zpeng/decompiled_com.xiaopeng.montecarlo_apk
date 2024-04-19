package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import android.os.Handler;
import android.os.Message;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.List;
/* loaded from: classes3.dex */
public class TrafficEventHelper {
    private static final long INTERVAL_CHECK_TRAFFIC_DIS_ONE_SEC = 1000;
    private static final long INTERVAL_CHECK_TRAFFIC_DIS_TEN_SEC = 10000;
    private static final long INTERVAL_CHECK_TRAFFIC_DIS_THREE_SEC = 3000;
    private static final int MSG_CHECK_XPU_CRUISE_EVENT_DIS = 420002;
    private static final int MSG_CHECK_XPU_TRAFFIC_EVENT_DIS = 420001;
    private static final int SCU_EVENT_INFO_RD_CONSTRUCTION = 2;
    private static final int SCU_EVENT_INFO_RD_NOT_DEFINED = 0;
    private static final int SCU_EVENT_INFO_RD_TRAFFIC_ACCIDENT = 1;
    private static final double XPU_TRAFFIC_EVENT_DIS_NORMAL = 1000.0d;
    private static final double XPU_TRAFFIC_EVENT_DIS_SEND = 500.0d;
    private static final double XPU_TRAFFIC_EVENT_DIS_WARN = 600.0d;
    private final Handler mListenerHandler = new Handler(WorkThreadUtil.getInstance().getSpeechAndAiThreadLooper()) { // from class: com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.TrafficEventHelper.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            L.Tag tag = TrafficEventHelper.TAG;
            L.i(tag, ">>> mListenerHandler handleMessage what=" + message.what);
            switch (message.what) {
                case TrafficEventHelper.MSG_CHECK_XPU_TRAFFIC_EVENT_DIS /* 420001 */:
                    TrafficEventHelper.this.checkTrafficEventStatusForXpu((XPTrafficEventInfo) message.obj);
                    return;
                case TrafficEventHelper.MSG_CHECK_XPU_CRUISE_EVENT_DIS /* 420002 */:
                    TrafficEventHelper.this.checkCruiseEventStatusForXpu((XPCruiseEventInfo) message.obj);
                    return;
                default:
                    return;
            }
        }
    };
    private List<XPTrafficEventInfo> mTrafficEventInfoList;
    private static final L.Tag TAG = new L.Tag("TrafficEventHelper");
    private static volatile TrafficEventHelper sInstance = new TrafficEventHelper();

    public boolean isEventInfoForXpu(int i) {
        if (i != 101 && i != 102 && i != 104 && i != 102302 && i != 201302) {
            switch (i) {
                case 201:
                case 202:
                case 203:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static TrafficEventHelper getInstance() {
        return sInstance;
    }

    public boolean isCruise() {
        return TBTManager.getInstance().getCurrentStatus() == 0;
    }

    public boolean isNavi() {
        return TBTManager.getInstance().getCurrentStatus() == 1 || TBTManager.getInstance().getCurrentStatus() == 2;
    }

    public void startCheckingTrafficEventStatusForXpu() {
        if (this.mTrafficEventInfoList.isEmpty()) {
            return;
        }
        Handler handler = this.mListenerHandler;
        handler.sendMessage(handler.obtainMessage(MSG_CHECK_XPU_TRAFFIC_EVENT_DIS, this.mTrafficEventInfoList.get(0)));
    }

    public void startCheckingCruiseEventStatusForXpu(XPCruiseEventInfo xPCruiseEventInfo) {
        Handler handler = this.mListenerHandler;
        handler.sendMessage(handler.obtainMessage(MSG_CHECK_XPU_CRUISE_EVENT_DIS, xPCruiseEventInfo));
    }

    public void startCheckTrafficEventListForXpu(List<XPTrafficEventInfo> list) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startCheckTrafficEventListForXpu, trafficEventInfoList size = " + list.size());
        }
        this.mTrafficEventInfoList = list;
        startCheckingTrafficEventStatusForXpu();
    }

    public void checkTrafficEventStatusForXpu(XPTrafficEventInfo xPTrafficEventInfo) {
        if (!isNavi()) {
            if (L.ENABLE) {
                L.d(TAG, "checkTrafficEventStatusForXpu, not navigating");
            }
        } else if (this.mTrafficEventInfoList.contains(xPTrafficEventInfo)) {
            double distance = LocationUtils.getDistance(xPTrafficEventInfo.mCoord2D, TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "checkTrafficEventStatusForXpu, id = " + xPTrafficEventInfo.mId + ", type = " + xPTrafficEventInfo.mType + ", distance = " + distance);
            }
            if (distance > XPU_TRAFFIC_EVENT_DIS_NORMAL) {
                Handler handler = this.mListenerHandler;
                handler.sendMessageDelayed(handler.obtainMessage(MSG_CHECK_XPU_TRAFFIC_EVENT_DIS, xPTrafficEventInfo), 10000L);
            } else if (distance > XPU_TRAFFIC_EVENT_DIS_WARN) {
                Handler handler2 = this.mListenerHandler;
                handler2.sendMessageDelayed(handler2.obtainMessage(MSG_CHECK_XPU_TRAFFIC_EVENT_DIS, xPTrafficEventInfo), INTERVAL_CHECK_TRAFFIC_DIS_THREE_SEC);
            } else if (distance > XPU_TRAFFIC_EVENT_DIS_SEND) {
                Handler handler3 = this.mListenerHandler;
                handler3.sendMessageDelayed(handler3.obtainMessage(MSG_CHECK_XPU_TRAFFIC_EVENT_DIS, xPTrafficEventInfo), 1000L);
            } else {
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, "send traffic event info  to xpu, id = " + xPTrafficEventInfo.mId + ", type = " + xPTrafficEventInfo.mType);
                }
                CarServiceManager.getInstance().setEventInfoRD(1);
                List<XPTrafficEventInfo> list = this.mTrafficEventInfoList;
                if (list != null) {
                    if (list.contains(xPTrafficEventInfo)) {
                        this.mTrafficEventInfoList.remove(xPTrafficEventInfo);
                    } else {
                        for (XPTrafficEventInfo xPTrafficEventInfo2 : this.mTrafficEventInfoList) {
                            if (xPTrafficEventInfo2.mId == xPTrafficEventInfo.mId) {
                                List<XPTrafficEventInfo> list2 = this.mTrafficEventInfoList;
                                list2.removeAll(list2.subList(0, list2.indexOf(Integer.valueOf(xPTrafficEventInfo2.mId)) + 1));
                            }
                        }
                    }
                }
                startCheckingTrafficEventStatusForXpu();
            }
        }
    }

    public void checkCruiseEventStatusForXpu(XPCruiseEventInfo xPCruiseEventInfo) {
        if (isNavi()) {
            if (L.ENABLE) {
                L.d(TAG, "checkCruiseEventStatusForXpu, not cruising");
                return;
            }
            return;
        }
        double distance = LocationUtils.getDistance(xPCruiseEventInfo.mEventPos, TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation());
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "checkCruiseEventStatusForXpu, cruiseEventInfo id = " + xPCruiseEventInfo.mEventID + ", type = " + xPCruiseEventInfo.mEventType + ", distance = " + distance);
        }
        if (distance > XPU_TRAFFIC_EVENT_DIS_NORMAL) {
            Handler handler = this.mListenerHandler;
            handler.sendMessageDelayed(handler.obtainMessage(MSG_CHECK_XPU_CRUISE_EVENT_DIS, xPCruiseEventInfo), 10000L);
        } else if (distance > XPU_TRAFFIC_EVENT_DIS_WARN) {
            Handler handler2 = this.mListenerHandler;
            handler2.sendMessageDelayed(handler2.obtainMessage(MSG_CHECK_XPU_CRUISE_EVENT_DIS, xPCruiseEventInfo), INTERVAL_CHECK_TRAFFIC_DIS_THREE_SEC);
        } else if (distance > XPU_TRAFFIC_EVENT_DIS_SEND) {
            Handler handler3 = this.mListenerHandler;
            handler3.sendMessageDelayed(handler3.obtainMessage(MSG_CHECK_XPU_CRUISE_EVENT_DIS, xPCruiseEventInfo), 1000L);
        } else {
            if (L.ENABLE) {
                L.Tag tag2 = TAG;
                L.d(tag2, "send cruise event info  to xpu, id = " + xPCruiseEventInfo.mEventID + ", type = " + xPCruiseEventInfo.mEventType);
            }
            CarServiceManager.getInstance().setEventInfoRD(1);
        }
    }
}
