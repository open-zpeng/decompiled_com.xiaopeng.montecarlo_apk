package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes2.dex */
public class ActivateBridge extends BaseBridge {
    public ActivateBridge() {
        super(StatusConst.Mode.ACTIVATE);
        enableSingleNotDestroyMode();
    }
}
