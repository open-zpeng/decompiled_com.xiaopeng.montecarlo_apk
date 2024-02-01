package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class MapDownloadBridge extends BaseBridge {
    private static final L.Tag TAG = new L.Tag("MapDownloadBridge");

    public MapDownloadBridge() {
        super(StatusConst.Mode.SETTING_MAP_DOWNLOAD);
        enableOverMode();
    }
}
