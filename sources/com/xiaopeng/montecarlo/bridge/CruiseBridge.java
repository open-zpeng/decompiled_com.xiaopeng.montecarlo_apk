package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes2.dex */
public class CruiseBridge extends BaseBridge {
    public CruiseBridge() {
        super(StatusConst.Mode.CRUISE);
        enableSingleNotDestroyMode();
    }
}
