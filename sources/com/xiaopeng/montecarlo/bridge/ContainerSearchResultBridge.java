package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes.dex */
public class ContainerSearchResultBridge extends BaseBridge {
    public static final String SEARCH_RESULT = "search_result";

    public ContainerSearchResultBridge() {
        super(StatusConst.Mode.CONTAINER_SEARCH_RESULT);
        enableSingleMode();
    }
}
