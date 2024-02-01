package com.xiaopeng.montecarlo.navcore.setting;

import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SettingVersionHelper {
    public static final int SETTING_VERSION = 1;
    private static final L.Tag TAG = new L.Tag(SettingVersionHelper.class.getSimpleName());
    private final int mNewSettingVersion;

    public SettingVersionHelper(int i) {
        this.mNewSettingVersion = i;
    }

    public void checkAndUpdateUserSettingVersion() {
        int accountSettingVersion = SettingWrapper.getAccountSettingVersion();
        int i = this.mNewSettingVersion;
        if (accountSettingVersion < i) {
            onUpgrade(accountSettingVersion, i);
        } else if (accountSettingVersion > i) {
            onDowngrade(accountSettingVersion, i);
        }
    }

    public void onUpgrade(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "onUpgrade oldVersion:" + i + ",newVersion:" + i2);
        if (i == 0) {
            int modifyAccountSettingVersion = SettingWrapper.modifyAccountSettingVersion(modifySettingValue(16777216, true), i2);
            L.Tag tag2 = TAG;
            L.i(tag2, "modifySettingValue, mSettingPreferenceValue =" + Integer.toBinaryString(modifyAccountSettingVersion));
            SettingWrapper.saveSettingPreference(0, modifyAccountSettingVersion);
        }
    }

    public void onDowngrade(int i, int i2) {
        L.Tag tag = TAG;
        L.i(tag, "onDowngrade oldVersion:" + i + ",newVersion:" + i2);
    }

    private int modifySettingValue(int i, boolean z) {
        return SettingWrapper.modifySettingPreference(SettingWrapper.getAllSettingValue(), i, z);
    }
}
