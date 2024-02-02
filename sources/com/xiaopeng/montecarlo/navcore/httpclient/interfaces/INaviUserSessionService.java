package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviLoginRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviGetBoundAccountsResponse;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviLoginResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.GetMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.Header;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import java.util.Map;
@Header(requireOpenId = true, requireSid = true)
@RemoteClient(path = "/v2/users/sessions", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes2.dex */
public interface INaviUserSessionService {
    @GetMapping(path = "/getBoundAccounts")
    ResponseWrapper<NaviGetBoundAccountsResponse> getBoundAccounts(@Header Map<String, String> map);

    @PostMapping(path = "/login")
    NaviLoginResponse login(@RequestBody NaviLoginRequest naviLoginRequest);

    @GetMapping(path = "/logout")
    Boolean logout(@Header Map<String, String> map);
}
