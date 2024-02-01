package com.xiaopeng.montecarlo.navcore.configurationmodule.listener;

import com.xiaopeng.montecarlo.navcore.bean.sr.SrMuteNaviTtsStrategyInfo;
import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.xptbt.TTSManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SrMuteNaviTtsStrategyConfigListener implements IOnWebConfigurationChangeListener {
    private static final L.Tag TAG = new L.Tag("SrMuteNaviTtsStrategyConfigListener");

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public WebConfigurationEnum getTargetConfiguration() {
        return WebConfigurationEnum.SR_MUTE_NAVI_TTS_STRATEGY;
    }

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public boolean isNeedReply(String str, String str2) {
        SrMuteNaviTtsStrategyInfo srMuteNaviTtsStrategyInfo = (SrMuteNaviTtsStrategyInfo) GsonUtil.fromJson(str, (Class<Object>) SrMuteNaviTtsStrategyInfo.class);
        if (srMuteNaviTtsStrategyInfo == null) {
            L.i(TAG, "oldInfo is null");
            return true;
        }
        SrMuteNaviTtsStrategyInfo srMuteNaviTtsStrategyInfo2 = (SrMuteNaviTtsStrategyInfo) GsonUtil.fromJson(str2, (Class<Object>) SrMuteNaviTtsStrategyInfo.class);
        if (srMuteNaviTtsStrategyInfo2 == null) {
            L.i(TAG, "newInfo is null");
            return false;
        }
        L.Tag tag = TAG;
        L.i(tag, "isNeedReply, oldInfo=" + srMuteNaviTtsStrategyInfo.toString() + ", newInfo=" + srMuteNaviTtsStrategyInfo2.toString());
        return !srMuteNaviTtsStrategyInfo.toString().equals(srMuteNaviTtsStrategyInfo2.toString());
    }

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public void onConfigurationChange(WebConfigurationEnum webConfigurationEnum, String str) {
        L.Tag tag = TAG;
        L.i(tag, "onConfigurationChange, level changed:" + str);
        TTSManager.getInstance().updateSrMuteNaviTts((SrMuteNaviTtsStrategyInfo) GsonUtil.fromJson(str, (Class<Object>) SrMuteNaviTtsStrategyInfo.class));
    }
}
