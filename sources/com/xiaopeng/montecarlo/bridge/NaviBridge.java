package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class NaviBridge extends BaseBridge {
    private static final L.Tag TAG = new L.Tag("NaviBridge");

    public NaviBridge() {
        super(StatusConst.Mode.NAVI);
        enableSingleMode();
    }
}
