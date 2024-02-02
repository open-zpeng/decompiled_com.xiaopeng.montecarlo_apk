package com.xiaopeng.montecarlo.appengine;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class LicensePlateService implements IServicePublisher {
    private static final L.Tag TAG = new L.Tag("LicensePlateService");

    @Publish
    public String getLicensePlate() {
        String licensePlate = SettingWrapper.getLicensePlate();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getLicensePlate licensePlate: " + licensePlate);
        }
        return licensePlate;
    }
}
