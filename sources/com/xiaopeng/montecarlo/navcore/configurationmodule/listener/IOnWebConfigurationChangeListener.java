package com.xiaopeng.montecarlo.navcore.configurationmodule.listener;

import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
/* loaded from: classes2.dex */
public interface IOnWebConfigurationChangeListener {
    WebConfigurationEnum getTargetConfiguration();

    boolean isNeedReply(String str, String str2);

    void onConfigurationChange(WebConfigurationEnum webConfigurationEnum, String str);
}
