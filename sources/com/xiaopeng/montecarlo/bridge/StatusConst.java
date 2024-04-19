package com.xiaopeng.montecarlo.bridge;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.base.BaseBridge;
/* loaded from: classes2.dex */
public class StatusConst {

    /* loaded from: classes2.dex */
    public enum Mode {
        EMPTY,
        ROUTE,
        CONTAINER_ROUTE,
        NAVI,
        DRIVING,
        SEARCH,
        SEARCH_RESULT,
        CONTAINER_SEARCH_RESULT,
        SET_HOME_OFFICE,
        SETTING,
        SETTING_LICENCE_PLATE,
        SETTING_MAP_DOWNLOAD,
        DEBUG,
        SCAN_SEARCH,
        EXPLORE,
        CONTAINER_EXPLORE,
        RESTRICT,
        NAVI_GUIDER,
        CRUISE,
        LINK_SEAMLESS_NAVI,
        LINK_PLATFORM,
        POPDIALOG,
        ACTIVATE,
        SET_CAR_LOGO;

        public static BaseBridge createBridge(BaseBridge baseBridge) {
            String childClassName = baseBridge.getChildClassName();
            if (TextUtils.isEmpty(childClassName)) {
                return null;
            }
            try {
                ClassLoader classLoader = StatusConst.class.getClassLoader();
                if (classLoader != null) {
                    BaseBridge baseBridge2 = (BaseBridge) classLoader.loadClass(childClassName).newInstance();
                    baseBridge2.update(baseBridge);
                    return baseBridge2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
