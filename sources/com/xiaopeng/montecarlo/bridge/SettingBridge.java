package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class SettingBridge extends BaseBridge {
    private static final L.Tag TAG = new L.Tag("SettingBridge");

    public SettingBridge() {
        super(StatusConst.Mode.SETTING);
        enableOverMode();
    }
}
