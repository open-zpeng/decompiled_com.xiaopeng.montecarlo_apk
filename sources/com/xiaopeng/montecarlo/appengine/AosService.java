package com.xiaopeng.montecarlo.appengine;

import com.autonavi.gbl.aosclient.model.BLRequestBase;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherRequestParam;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.aos.AosServiceManager;
import com.xiaopeng.montecarlo.navcore.aos.IBaseAosCallBack;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class AosService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("AosService");
    GQueryPersentWeatherResponseParam mGQueryPersentWeatherResponseParam;

    @Publish
    public String requestQueryPersentWeather(String str) {
        this.mGQueryPersentWeatherResponseParam = new GQueryPersentWeatherResponseParam();
        try {
            int intValue = Integer.valueOf(str).intValue();
            final GQueryPersentWeatherRequestParam gQueryPersentWeatherRequestParam = new GQueryPersentWeatherRequestParam();
            gQueryPersentWeatherRequestParam.deviceid = NavCoreUtil.getDiu();
            if (DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_ACCOUNT_SERVICE_ENV, 3) == 3) {
                gQueryPersentWeatherRequestParam.userid = "Auto_BL";
                gQueryPersentWeatherRequestParam.password = "Auto_BL";
            } else {
                gQueryPersentWeatherRequestParam.userid = "AN_Amaptest_FC";
                gQueryPersentWeatherRequestParam.password = "AN_Amaptest_FC";
            }
            gQueryPersentWeatherRequestParam.mReqData.type = 3;
            gQueryPersentWeatherRequestParam.mReqData.adcodes.add(Integer.valueOf(intValue));
            AosServiceManager.getInstance().requestQueryPersentWeather(gQueryPersentWeatherRequestParam, new IBaseAosCallBack<GQueryPersentWeatherResponseParam>() { // from class: com.xiaopeng.montecarlo.appengine.AosService.1
                @Override // com.xiaopeng.montecarlo.navcore.aos.IBaseAosCallBack
                public void onDataFetched(GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam) {
                    AosService aosService = AosService.this;
                    aosService.mGQueryPersentWeatherResponseParam = gQueryPersentWeatherResponseParam;
                    aosService.notifyParam(gQueryPersentWeatherRequestParam);
                }
            });
            lockParam(gQueryPersentWeatherRequestParam);
        } catch (Exception e) {
            GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam = this.mGQueryPersentWeatherResponseParam;
            gQueryPersentWeatherResponseParam.code = -1;
            gQueryPersentWeatherResponseParam.message = e.getMessage();
        }
        String json = GsonUtil.toJson(this.mGQueryPersentWeatherResponseParam);
        L.Tag tag = TAG;
        L.i(tag, "requestQueryPersentWeather data=" + json);
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParam(BLRequestBase bLRequestBase) {
        synchronized (bLRequestBase) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "notify  param  mEAosRequestType:" + bLRequestBase.mEAosRequestType + "   =====>param object: " + Integer.toHexString(bLRequestBase.hashCode()));
            }
            bLRequestBase.notify();
        }
    }

    private void lockParam(BLRequestBase bLRequestBase) {
        synchronized (bLRequestBase) {
            try {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "lock    param  mEAosRequestType:" + bLRequestBase.mEAosRequestType + "   =====>param object: " + Integer.toHexString(bLRequestBase.hashCode()));
                }
                bLRequestBase.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
