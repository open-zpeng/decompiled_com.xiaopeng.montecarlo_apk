package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class SetCarLogoBridge extends BaseBridge {
    private static final L.Tag TAG = new L.Tag("SetCarLogoBridge");

    public SetCarLogoBridge() {
        super(StatusConst.Mode.SET_CAR_LOGO);
        enableOverMode();
    }
}
