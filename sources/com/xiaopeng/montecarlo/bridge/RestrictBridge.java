package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class RestrictBridge extends BaseBridge {
    public static final String RESTRICT_REQUEST = "restrict_request";
    private static final L.Tag TAG = new L.Tag("RestrictBridge");

    public RestrictBridge() {
        super(StatusConst.Mode.RESTRICT);
    }
}
