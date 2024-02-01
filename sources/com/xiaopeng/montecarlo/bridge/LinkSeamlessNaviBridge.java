package com.xiaopeng.montecarlo.bridge;

import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes.dex */
public class LinkSeamlessNaviBridge extends BaseBridge {
    public static final String KEY_FROM_WHERE = "key_from_where";
    public static final int KEY_SHOW_BOTTOM_EXPLAIN_FROM_CRUISE = 1;
    public static final int KEY_SHOW_BOTTOM_EXPLAIN_FROM_SETTING = 0;
    public static final int KEY_SHOW_BOTTOM_EXPLAIN_FROM_USER_CENTER_WE_CHAT = 2;

    public LinkSeamlessNaviBridge() {
        super(StatusConst.Mode.LINK_SEAMLESS_NAVI);
        enableOverMode();
    }
}
