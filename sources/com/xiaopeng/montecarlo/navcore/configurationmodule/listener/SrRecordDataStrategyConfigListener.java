package com.xiaopeng.montecarlo.navcore.configurationmodule.listener;

import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.datarecord.SrDataRecordStrategyInfo;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SrRecordDataStrategyConfigListener implements IOnWebConfigurationChangeListener {
    private static final L.Tag TAG = new L.Tag("SrRecordDataStrategyConfigListener");

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public WebConfigurationEnum getTargetConfiguration() {
        return WebConfigurationEnum.RECORD_DATA_STRATEGY;
    }

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public boolean isNeedReply(String str, String str2) {
        SrDataRecordStrategyInfo srDataRecordStrategyInfo = (SrDataRecordStrategyInfo) GsonUtil.fromJson(str, (Class<Object>) SrDataRecordStrategyInfo.class);
        if (srDataRecordStrategyInfo == null) {
            L.i(TAG, "oldInfo is null");
            return true;
        }
        SrDataRecordStrategyInfo srDataRecordStrategyInfo2 = (SrDataRecordStrategyInfo) GsonUtil.fromJson(str2, (Class<Object>) SrDataRecordStrategyInfo.class);
        if (srDataRecordStrategyInfo2 == null) {
            L.i(TAG, "newInfo is null");
            return false;
        }
        L.Tag tag = TAG;
        L.i(tag, "isNeedReply, oldUserRole=" + srDataRecordStrategyInfo.getUserRole() + ", newUserRole=" + srDataRecordStrategyInfo2.getUserRole());
        return !srDataRecordStrategyInfo.getUserRole().equalsIgnoreCase(srDataRecordStrategyInfo2.getUserRole());
    }

    @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener
    public void onConfigurationChange(WebConfigurationEnum webConfigurationEnum, String str) {
        L.i(TAG, "onConfigurationChange, user changed");
        SRNaviManager.getInstance().updateRecordStrategy();
    }
}
