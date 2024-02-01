package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviClearDataRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviSyncSettingsRequest;
import com.xiaopeng.montecarlo.root.httpclient.annotations.GetMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.Header;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestParam;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import java.util.Map;
@Header(requireOpenId = true, requireSid = true)
@RemoteClient(path = "/v2/navigation/settings", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes3.dex */
public interface INaviSettingService {
    @PostMapping(path = "/clear")
    ResponseWrapper<String> clearData(@RequestBody NaviClearDataRequest naviClearDataRequest, @Header Map<String, String> map);

    @GetMapping(path = "/get")
    ResponseWrapper<String> getSettings(@RequestParam("localVersion") String str, @Header Map<String, String> map);

    @PostMapping(path = "/sync")
    ResponseWrapper<String> syncSettings(@RequestBody NaviSyncSettingsRequest naviSyncSettingsRequest, @Header Map<String, String> map);
}
