package com.xiaopeng.montecarlo.navcore.sr;
/* loaded from: classes3.dex */
public class SRDataUtil {
    public static boolean isCNGPDriveMode(int i) {
        return i == 6;
    }

    public static boolean isLcTipsCancelChangeLane(int i) {
        return i == 28 || i == 122;
    }

    public static boolean isLccStatus(int i) {
        return 2 == i;
    }

    public static boolean isNgpDriveMode(int i) {
        return i == 4 || i == 6;
    }

    public static boolean isXpuFunctionIconShow(int i, boolean z) {
        return isLccStatus(i) ? z : i > 1;
    }

    public static boolean isDriveModeChangeToNgp(int i, int i2) {
        return !isNgpDriveMode(i) && isNgpDriveMode(i2);
    }
}
