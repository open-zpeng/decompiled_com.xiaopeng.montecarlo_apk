package com.xiaopeng.montecarlo.navcore.aos;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.aosclient.model.GTraEventDetail;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailRequestParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailResponseParam;
import com.xiaopeng.montecarlo.navcore.event.RouteAosEvent;
import com.xiaopeng.montecarlo.navcore.util.NaviLogUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes2.dex */
public class TrafficEventServiceWrapper {
    private static final int ABORT_SUCCESS = 0;
    public static final int NET_ERROR_CODE_EXPIRE = 11;
    public static final String RESULT_FAIL = "false";
    public static final String RESULT_SUCCESS = "true";
    public static final int SERVICE_CODE_EXPIRE = 7;
    private static final int TRAFFIC_EVENT_BARRIERS = 505;
    private static final int TRAFFIC_EVENT_CLOSURE_FLOOD = 505;
    private static final int TRAFFIC_EVENT_CLOSURE_FROG = 505;
    private static final int TRAFFIC_EVENT_CONSTRUCTION = 201;
    private static final int TRAFFIC_EVENT_CONSTRUCTION_AFFECT_TRAVEL = 202;
    private static final int TRAFFIC_EVENT_CONSTRUCTION_TRAVEL_NOT_SUGGESTION = 203;
    private static final int TRAFFIC_EVENT_FLOOD = 501;
    private static final int TRAFFIC_EVENT_NORMAL = 101;
    private static final int TRAFFIC_EVENT_SERIOUS = 102;
    private static final int TRAFFIC_EVENT_SUSPECT = 104;
    private static final L.Tag TAG = new L.Tag("TrafficEventServiceWrapper");
    private static final TrafficEventServiceWrapper sInstance = new TrafficEventServiceWrapper();
    @NonNull
    private static ConcurrentHashMap<Long, ITrafficEventRequestCallback> sCallbackList = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public interface ITrafficEventRequestCallback {
        void onTrafficRequestFailed(long j, int i, int i2);

        void onTrafficResponse(long j, GTraEventDetail gTraEventDetail);
    }

    @NonNull
    public static TrafficEventServiceWrapper getInstance() {
        return sInstance;
    }

    public void init() {
        EventBus.getDefault().register(sInstance);
    }

    public void unInit() {
        EventBus.getDefault().unregister(sInstance);
    }

    @Nullable
    public long requestTrafficIncident(String str, @NonNull ITrafficEventRequestCallback iTrafficEventRequestCallback) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "requestTrafficIncident eventId: " + str);
        }
        GTrafficEventDetailRequestParam gTrafficEventDetailRequestParam = new GTrafficEventDetailRequestParam();
        gTrafficEventDetailRequestParam.eventid = str;
        long requestTrafficEventDetail = AosServiceManager.getInstance().requestTrafficEventDetail(gTrafficEventDetailRequestParam);
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "request traffic handle: " + requestTrafficEventDetail);
        }
        if (requestTrafficEventDetail <= 0) {
            iTrafficEventRequestCallback.onTrafficRequestFailed(requestTrafficEventDetail, -1, -1);
        } else {
            sCallbackList.put(Long.valueOf(requestTrafficEventDetail), iTrafficEventRequestCallback);
        }
        return requestTrafficEventDetail;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onAosEvent(@NonNull RouteAosEvent routeAosEvent) {
        if (routeAosEvent.getParam() instanceof GTrafficEventDetailResponseParam) {
            GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam = (GTrafficEventDetailResponseParam) routeAosEvent.getParam();
            long j = gTrafficEventDetailResponseParam.mReqHandle;
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onAosEvent handle: " + j + ", traffic: " + NaviLogUtil.getTrafficParamString(gTrafficEventDetailResponseParam));
            }
            ITrafficEventRequestCallback remove = sCallbackList.remove(Long.valueOf(gTrafficEventDetailResponseParam.mReqHandle));
            if (remove != null) {
                if (!TextUtils.isEmpty(gTrafficEventDetailResponseParam.result) && gTrafficEventDetailResponseParam.result.equals("true") && gTrafficEventDetailResponseParam.EventData != null) {
                    remove.onTrafficResponse(j, gTrafficEventDetailResponseParam.EventData);
                } else {
                    remove.onTrafficRequestFailed(j, gTrafficEventDetailResponseParam.mNetErrorCode, gTrafficEventDetailResponseParam.code);
                }
            }
        }
    }

    public void cancel(long j) {
        if (sCallbackList.get(Long.valueOf(j)) == null) {
            L.Tag tag = TAG;
            L.i(tag, "abort request: " + j + ", not exist !");
        } else if (AosServiceWrapper.getInstance().abortRequest(j) == 0) {
            L.Tag tag2 = TAG;
            L.i(tag2, "abort request: " + j + ", success !");
        } else {
            L.Tag tag3 = TAG;
            L.i(tag3, "abort request: " + j + ", failed !");
            sCallbackList.remove(Long.valueOf(j));
        }
    }
}
