package com.xiaopeng.montecarlo.navcore.xptbt;

import com.autonavi.gbl.aosclient.model.BLAosCookie;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.autonavi.gbl.aosclient.model.GReStrictedAreaResponseParam;
import com.autonavi.gbl.aosclient.model.GSendToPhoneResponseParam;
import com.autonavi.gbl.aosclient.model.GTrafficEventDetailResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryPersentWeather;
import com.autonavi.gbl.aosclient.observer.ICallBackReStrictedArea;
import com.autonavi.gbl.aosclient.observer.ICallBackSendToPhone;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventDetail;
import com.google.gson.Gson;
import com.xiaopeng.montecarlo.navcore.aos.AosEvent;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceWrapper;
import com.xiaopeng.montecarlo.navcore.event.RouteAosEvent;
import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes2.dex */
public class RouteAosResponseObserver implements ICallBackSendToPhone, ICallBackReStrictedArea, ICallBackTrafficEventDetail, ICallBackQueryPersentWeather {
    private static final int LOG_MAX_LEN = 4000;
    private static final L.Tag TAG = new L.Tag("RtAosRespObs");
    private GuideManager.ISend2PhoneListener mSend2PhoneListener;

    @Override // com.autonavi.gbl.aosclient.observer.ICallBackReStrictedArea
    public void onRecvAck(GReStrictedAreaResponseParam gReStrictedAreaResponseParam) {
        L.Tag tag = TAG;
        L.longLog(tag, "高德给的数据===" + new Gson().toJson(gReStrictedAreaResponseParam.data));
        EventBus.getDefault().post(new RouteAosEvent(gReStrictedAreaResponseParam));
    }

    @Override // com.autonavi.gbl.aosclient.observer.ICallBackQueryPersentWeather
    public void onRecvAck(GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam) {
        EventBus.getDefault().post(new AosEvent(gQueryPersentWeatherResponseParam));
        L.Tag tag = TAG;
        L.i(tag, " OnQueryPersentWeatherResponse-----" + gQueryPersentWeatherResponseParam.mAckData.weathers + "  message:" + gQueryPersentWeatherResponseParam.message);
    }

    @Override // com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventDetail
    public void onRecvAck(GTrafficEventDetailResponseParam gTrafficEventDetailResponseParam) {
        EventBus.getDefault().post(new RouteAosEvent(gTrafficEventDetailResponseParam));
    }

    @Override // com.autonavi.gbl.aosclient.observer.ICallBackSendToPhone
    public void onRecvAck(GSendToPhoneResponseParam gSendToPhoneResponseParam) {
        String json = GsonUtil.toJson(gSendToPhoneResponseParam);
        if (L.ENABLE) {
            BLAosCookie cookie = AosServiceWrapper.getInstance().getCookie();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "lastmile bindmap  blAosCookie=" + GsonUtil.toJson(cookie));
                L.Tag tag2 = TAG;
                L.d(tag2, "lastmile OnSendToPhoneResponse gSendToPhoneResponseParam = [" + json + "]");
            }
        }
        if (gSendToPhoneResponseParam == null || gSendToPhoneResponseParam.code != 1) {
            return;
        }
        if (L.ENABLE) {
            L.d(TAG, "lastmile send2phone success!!!");
        }
        GuideManager.ISend2PhoneListener iSend2PhoneListener = this.mSend2PhoneListener;
        if (iSend2PhoneListener != null) {
            iSend2PhoneListener.onSuccess();
        }
    }

    public void setSend2PhoneListener(GuideManager.ISend2PhoneListener iSend2PhoneListener) {
        if (this.mSend2PhoneListener == null) {
            this.mSend2PhoneListener = iSend2PhoneListener;
        }
    }
}
