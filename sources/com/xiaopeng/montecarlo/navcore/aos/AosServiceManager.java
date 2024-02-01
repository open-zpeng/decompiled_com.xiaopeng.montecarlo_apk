package com.xiaopeng.montecarlo.navcore.aos;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherRequestParam;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaRequestParam;
import com.autonavi.gbl.aosclient.model.GSendToPhoneRequestParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailRequestParam;
import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteAosResponseObserver;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public class AosServiceManager {
    private static final L.Tag TAG = new L.Tag("AosServiceManager");
    private static final AosServiceManager sInstance = new AosServiceManager();
    @NonNull
    private RouteAosResponseObserver mBLAosResponseObserver = new RouteAosResponseObserver();

    private AosServiceManager() {
        AosServiceWrapper.getInstance().register();
    }

    @NonNull
    public static AosServiceManager getInstance() {
        return sInstance;
    }

    public void requestSendToPhone(GSendToPhoneRequestParam gSendToPhoneRequestParam) {
        AosServiceWrapper.getInstance().getBLAosService().sendReqSendToPhone(gSendToPhoneRequestParam, this.mBLAosResponseObserver);
    }

    public void requestQueryPersentWeather(GQueryPersentWeatherRequestParam gQueryPersentWeatherRequestParam, IBaseAosCallBack<GQueryPersentWeatherResponseParam> iBaseAosCallBack) {
        AosServiceWrapper.getInstance().requestQueryPersentWeather(gQueryPersentWeatherRequestParam, iBaseAosCallBack, this.mBLAosResponseObserver);
    }

    public void setSend2PhoneListener(GuideManager.ISend2PhoneListener iSend2PhoneListener) {
        RouteAosResponseObserver routeAosResponseObserver = this.mBLAosResponseObserver;
        if (routeAosResponseObserver != null) {
            routeAosResponseObserver.setSend2PhoneListener(iSend2PhoneListener);
        }
    }

    public void requestRestrictedAreaByAdcode(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            L.Tag tag = TAG;
            L.w(tag, "error arguments  vehicleId:" + str + " ad:" + str2);
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.aos.AosServiceManager.1
            @Override // java.lang.Runnable
            public void run() {
                GReStrictedAreaRequestParam gReStrictedAreaRequestParam = new GReStrictedAreaRequestParam();
                gReStrictedAreaRequestParam.adcodes = str2;
                gReStrictedAreaRequestParam.plate = str;
                gReStrictedAreaRequestParam.restrict_type = 1;
                gReStrictedAreaRequestParam.truck_height = "0.0";
                gReStrictedAreaRequestParam.truck_load = "0.0";
                gReStrictedAreaRequestParam.vehicle_type = 0;
                AosServiceWrapper.getInstance().getBLAosService().sendReqReStrictedArea(gReStrictedAreaRequestParam, AosServiceManager.this.mBLAosResponseObserver);
            }
        });
    }

    public long requestTrafficEventDetail(GTrafficEventDetailRequestParam gTrafficEventDetailRequestParam) {
        return AosServiceWrapper.getInstance().getBLAosService().sendReqTrafficEventDetail(gTrafficEventDetailRequestParam, this.mBLAosResponseObserver);
    }
}
