package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes.dex */
public class LinkPlatformBridge extends BaseBridge {
    public static final String PLATFORM_TYPE_KEY = "platform_type_key";

    public LinkPlatformBridge() {
        super(StatusConst.Mode.LINK_PLATFORM);
        enableOverMode();
    }
}
