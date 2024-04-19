package com.xiaopeng.montecarlo.navcore.configurationmodule.listener;

import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.speech.request.SpeechRequestFactory;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class ScratchSpotConfigListener implements IOnWebConfigurationChangeListener {
    private static final L.Tag TAG = new L.Tag("ScratchSpotConfigListener");

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public WebConfigurationEnum getTargetConfiguration() {
        return WebConfigurationEnum.SCRATCH_SPOT;
    }

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public boolean isNeedReply(String str, String str2) {
        Boolean bool = "true".equalsIgnoreCase(str2) ? Boolean.TRUE : "false".equalsIgnoreCase(str2) ? Boolean.FALSE : null;
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public void onConfigurationChange(WebConfigurationEnum webConfigurationEnum, String str) {
        L.i(TAG, "onConfigurationChange");
        SpeechRequestFactory.getInstance().postRequest(57, false);
    }
}
