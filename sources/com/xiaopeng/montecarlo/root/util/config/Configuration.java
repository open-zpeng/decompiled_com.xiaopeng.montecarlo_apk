package com.xiaopeng.montecarlo.root.util.config;

import com.xiaopeng.montecarlo.root.util.RootUtil;
/* loaded from: classes3.dex */
public final class Configuration {
    private static final SettingProperties sSettings = SettingProperties.getInstance();

    /* loaded from: classes3.dex */
    public static final class Dependency {
        public static final boolean AIASSISTANT_ENABLE = Configuration.sSettings.getBoolean("aiassistant.enable", false);
        public static final boolean LAUNCHER_HIDE = Configuration.sSettings.getBoolean("launcher.hide", false);
    }

    /* loaded from: classes3.dex */
    public static final class Path {
        public static final String PATH_DEV = Configuration.sSettings.get("path.dev", RootUtil.MNT_VMAP);
        public static final String PATH_NAVI = Configuration.sSettings.get("path.navi", RootUtil.MNT_VMAP);
        public static final String PATH_NAVI_MONTECARLO = Configuration.sSettings.get("path.navi.montecarlo", "/mnt/vmap/montecarlo");
    }
}
