package com.dingtalk.mobile.common.amnetcore;
/* loaded from: classes2.dex */
public interface AmnetSwitchManager {
    long downgradePeriod();

    boolean enableBifrostUseAlarm();

    boolean enableBifrostUseProxy();

    boolean enableBifrostUseWakeLock();

    boolean enableCollectInitAsync();

    boolean enableGetgateway6();

    boolean enableHighPriorityThread();

    boolean enableListenNetworkSignalStrength();

    boolean enableShrinkSecondRandomTimer();

    boolean enableSpannerShrink();

    boolean forceTlsVerify();

    int getLonglinkConnMax();

    String getQuicHost();

    int getRpcPkgSizeOfDetecRpc();

    boolean getSdtCheckerMode();

    boolean isEnableInitMergeSync();

    boolean isEnableSFC();

    boolean isEnableST();

    boolean isEnableShortLink(boolean z);

    boolean isEnableZstd(boolean z);

    boolean isEnabledLocalAmneQuisSwitch();

    boolean isEnabledMasterQuicSwitch();

    boolean isEnabledQuicDetectRpc();

    boolean isOnlyQuicByOperationType(String str);

    boolean isSupportQuicByOperationType(String str);

    boolean needCheckSpannerZstd();

    <T> T pullSwitch(String str, T t);

    boolean useBifrost();

    boolean useNewHpackFunction();
}
