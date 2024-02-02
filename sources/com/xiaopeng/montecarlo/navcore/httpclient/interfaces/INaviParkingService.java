package com.xiaopeng.montecarlo.navcore.httpclient.interfaces;

import com.xiaopeng.montecarlo.navcore.httpclient.requests.NaviParkRecommendRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.NaviParkRecommendResponse;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
@RemoteClient(path = "/v2/parking", serviceName = RemoteServiceNameEnum.SERVICE_MAP_NAVI_SERVER)
/* loaded from: classes2.dex */
public interface INaviParkingService {
    @PostMapping(path = "/recommend")
    NaviParkRecommendResponse recommend(@RequestBody NaviParkRecommendRequest naviParkRecommendRequest);
}
