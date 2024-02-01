package com.xiaopeng.montecarlo.navcore.download.autodownload.strategy;

import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
/* loaded from: classes3.dex */
public class DownloadStrategyFactory {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.navcore.download.autodownload.strategy.DownloadStrategyFactory$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType = new int[XPNetworkManager.XPNetworkType.values().length];

        static {
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_TBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_MOBILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.XPNetworkType.NETWORK_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static IDownloadStartStrategy createDownloadStrategy() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$root$network$XPNetworkManager$XPNetworkType[XPNetworkManager.INSTANCE.getNetworkType().ordinal()];
        if (i == 1 || i == 2) {
            return new DownloadStrategy4G();
        }
        if (i == 3) {
            return new DownloadStrategyWifi();
        }
        return new DownloadStrategyNoNet();
    }
}
