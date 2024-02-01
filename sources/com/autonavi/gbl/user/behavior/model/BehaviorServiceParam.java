package com.autonavi.gbl.user.behavior.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class BehaviorServiceParam implements Serializable {
    public ConfigSetting defaultConfig;

    public BehaviorServiceParam() {
        this.defaultConfig = new ConfigSetting();
    }

    public BehaviorServiceParam(ConfigSetting configSetting) {
        this.defaultConfig = configSetting;
    }
}
