package com.xiaopeng.montecarlo.navcore.util;

import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class MapModeUtil {
    private static final L.Tag TAG = new L.Tag("MapModeUtil");

    public static int getDefaultMapMode() {
        return 2;
    }

    public static String getStoreKeyName(boolean z) {
        return z ? DataSetHelper.AccountSet.NAV_MODULE_DEFAULT_MAP_MODE : DataSetHelper.AccountSet.MAP_MODULE_DEFAULT_MAP_MODE;
    }

    public static void saveMapMode(int i, boolean z) {
        saveMapMode(1, i, z);
    }

    public static void saveMapMode(int i, int i2, boolean z) {
        if (i == 1) {
            DataSetHelper.AccountSet.set(getStoreKeyName(z), i2);
        } else if (i == 3) {
            DataSetHelper.AccountSet.setXP(getStoreKeyName(z), i2);
        } else if (i == 2) {
            DataSetHelper.AccountSet.setBL(getStoreKeyName(z), i2);
        } else if (i == 0) {
            DataSetHelper.AccountSet.setNone(getStoreKeyName(z), i2);
        }
    }

    public static int getSavedMapMode(boolean z) {
        return DataSetHelper.AccountSet.getInt(getStoreKeyName(z), getDefaultMapMode());
    }
}
