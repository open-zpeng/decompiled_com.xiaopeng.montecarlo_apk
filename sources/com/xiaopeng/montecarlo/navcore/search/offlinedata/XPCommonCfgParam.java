package com.xiaopeng.montecarlo.navcore.search.offlinedata;

import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class XPCommonCfgParam {
    public static final String PARAM_KEY_CFG_CODE = "cfgCode";
    private static final L.Tag TAG = new L.Tag("XPCommonCfgParam");

    public static String getCfgKey(Configuration configuration) {
        return configuration == null ? "" : configuration.mKey;
    }

    public static String getAllCfgKey() {
        StringBuilder sb = new StringBuilder();
        if (!CollectionUtils.isEmpty(Configuration.values())) {
            for (int i = 0; i < Configuration.values().length; i++) {
                sb.append(Configuration.values()[i].mKey);
                if (i != Configuration.values().length - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    enum Configuration {
        APP_NAVI_KEYWORD("APP_NAVI_KEYWORD");
        
        private String mKey;

        Configuration(String str) {
            this.mKey = str;
        }
    }
}
