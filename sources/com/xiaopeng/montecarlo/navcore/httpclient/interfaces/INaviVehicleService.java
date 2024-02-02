package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviFeedbackResultRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetSdkActivationCodeResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetVehicleInfoResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.GetMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestParam;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
@RemoteClient(path = "/v2/vehicle", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes2.dex */
public interface INaviVehicleService {
    @PostMapping(path = "/sdk/activation/feedback")
    ResponseWrapper feedbackSdkActivation(@RequestBody NaviFeedbackResultRequest naviFeedbackResultRequest);

    @GetMapping(path = "/sdk/activation/getCode")
    NaviGetSdkActivationCodeResponse getSdkActivationCode();

    @GetMapping(path = "/info/get")
    NaviGetVehicleInfoResponse getVehicleInfoByVin(@RequestParam("vin") String str);
}
