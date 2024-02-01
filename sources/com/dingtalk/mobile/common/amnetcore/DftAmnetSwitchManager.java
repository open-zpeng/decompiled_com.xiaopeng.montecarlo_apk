package com.dingtalk.mobile.common.amnetcore;
/* loaded from: classes2.dex */
public class DftAmnetSwitchManager implements AmnetSwitchManager {
    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public long downgradePeriod() {
        return 7200L;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableBifrostUseAlarm() {
        return true;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableBifrostUseProxy() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableBifrostUseWakeLock() {
        return true;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableCollectInitAsync() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableGetgateway6() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableHighPriorityThread() {
        return true;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableListenNetworkSignalStrength() {
        return true;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableShrinkSecondRandomTimer() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean enableSpannerShrink() {
        return true;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean forceTlsVerify() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public int getLonglinkConnMax() {
        return 3;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public String getQuicHost() {
        return "";
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public int getRpcPkgSizeOfDetecRpc() {
        return 0;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean getSdtCheckerMode() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnableInitMergeSync() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnableSFC() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnableST() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnableShortLink(boolean z) {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnableZstd(boolean z) {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnabledLocalAmneQuisSwitch() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnabledMasterQuicSwitch() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isEnabledQuicDetectRpc() {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isOnlyQuicByOperationType(String str) {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean isSupportQuicByOperationType(String str) {
        return false;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean needCheckSpannerZstd() {
        return true;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public <T> T pullSwitch(String str, T t) {
        return t;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean useBifrost() {
        return true;
    }

    @Override // com.dingtalk.mobile.common.amnetcore.AmnetSwitchManager
    public boolean useNewHpackFunction() {
        return false;
    }
}
