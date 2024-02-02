package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class ExploreBridge extends BaseBridge {
    private static final L.Tag TAG = new L.Tag("ExploreBridge");

    public ExploreBridge() {
        super(StatusConst.Mode.EXPLORE);
        enableSingleNotDestroyMode();
    }
}
