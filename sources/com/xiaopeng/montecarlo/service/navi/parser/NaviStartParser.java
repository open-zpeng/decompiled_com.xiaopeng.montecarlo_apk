package com.xiaopeng.montecarlo.service.navi.parser;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.service.navi.INaviParser;
import com.xiaopeng.montecarlo.service.navi.IRequestEventCallback;
/* loaded from: classes3.dex */
public final class NaviStartParser implements INaviParser {
    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onCreate(@NonNull Context context) {
    }

    @Override // com.xiaopeng.montecarlo.service.navi.INaviParser
    public void onHandleEvent(@NonNull Context context, @NonNull String str, @NonNull IRequestEventCallback iRequestEventCallback) {
        MapRouteMsg mapRouteMsg = (MapRouteMsg) GsonUtil.fromJson(str, (Class<Object>) MapRouteMsg.class);
        iRequestEventCallback.setNeedReturnResult(false, null);
        iRequestEventCallback.setNeedStartMainActivity(true);
        Bundle bundle = new Bundle();
        bundle.putDouble(CPSearchParam.PARAM_KEY_LAT, mapRouteMsg.getDest().getLat());
        bundle.putDouble(CPSearchParam.PARAM_KEY_LON, mapRouteMsg.getDest().getLon());
        iRequestEventCallback.setDataToMainActivity(bundle);
        iRequestEventCallback.allWorkEnd();
    }
}
