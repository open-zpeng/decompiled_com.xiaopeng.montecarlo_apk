package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class DebugBridge extends BaseBridge {
    private static final L.Tag TAG = new L.Tag("DebugBridge");

    public DebugBridge() {
        super(StatusConst.Mode.DEBUG);
    }
}
