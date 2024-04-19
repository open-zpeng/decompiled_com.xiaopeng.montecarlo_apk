package com.xiaopeng.montecarlo.util;

import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.sr.SRDataUtil;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SRUtil {
    private static final L.Tag TAG = new L.Tag("SRUtil");

    public static int getNgpInfoTipsIcon(int i) {
        if (i == 1 || i == 2) {
            return R.drawable.vector_ic_ngp_warn_steering;
        }
        return -1;
    }

    public static boolean isNgpStrongAlertTypeByLcTipsOrOddStatus(int i, int i2) {
        return 34 == i || 35 == i || 40 == i || 47 == i || 57 == i || 60 == i || 59 == i || 63 == i || 53 == i || 16 == i || 113 == i || 121 == i;
    }

    public static boolean isPlayTTS(int i) {
        return 4 == i || 5 == i;
    }

    private static boolean isSignalShow(int i) {
        if (i != 3 && i != 4 && i != 5 && i != 17 && i != 18 && i != 45 && i != 46 && i != 50 && i != 51) {
            switch (i) {
                case 1:
                case 28:
                case 32:
                case 41:
                case 62:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 115:
                case 118:
                case 120:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 129:
                case 131:
                case 132:
                case 133:
                case 134:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 158:
                case 159:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                    break;
                default:
                    switch (i) {
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            switch (i) {
                                case 37:
                                case 38:
                                case 39:
                                    break;
                                default:
                                    switch (i) {
                                        case 64:
                                        case 65:
                                        case 66:
                                            break;
                                        default:
                                            switch (i) {
                                                case 68:
                                                case 69:
                                                case 70:
                                                case 71:
                                                case 72:
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 76:
                                                        case 77:
                                                        case 78:
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return true;
    }

    public static boolean isTakeOverWeakByQuitNgpOddStatus(int i) {
        return i >= 1 && i <= 7;
    }

    public static boolean isTakeOverWeakByTipStatus(int i) {
        return 51 == i || 39 == i || 41 == i || 65 == i || 139 == i || 140 == i || 141 == i || 142 == i || 127 == i || 150 == i || 151 == i || 163 == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r4 != 6) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
        if (r6 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r6 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        return 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getNgpPanelStatus(int r4, int r5, boolean r6) {
        /*
            r0 = 5
            r1 = 2
            r2 = 4
            r3 = 3
            if (r4 != 0) goto L9
            if (r2 != r5) goto L9
            goto L3b
        L9:
            boolean r4 = isSignalShow(r4)
            if (r4 != 0) goto L28
            com.xiaopeng.montecarlo.navcore.sr.SRNaviManager r4 = com.xiaopeng.montecarlo.navcore.sr.SRNaviManager.getInstance()
            int r4 = r4.getDriveMode()
            if (r4 == r1) goto L25
            if (r4 == r3) goto L23
            if (r4 == r2) goto L25
            if (r4 == r0) goto L23
            r5 = 6
            if (r4 == r5) goto L25
            goto L3a
        L23:
            r0 = r1
            goto L3b
        L25:
            if (r6 != 0) goto L3a
            goto L38
        L28:
            com.xiaopeng.montecarlo.navcore.sr.SRNaviManager r4 = com.xiaopeng.montecarlo.navcore.sr.SRNaviManager.getInstance()
            int r4 = r4.getDriveMode()
            boolean r4 = com.xiaopeng.montecarlo.navcore.sr.SRDataUtil.isLccStatus(r4)
            if (r4 != 0) goto L3a
            if (r6 != 0) goto L3a
        L38:
            r0 = r3
            goto L3b
        L3a:
            r0 = 0
        L3b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.util.SRUtil.getNgpPanelStatus(int, int, boolean):int");
    }

    public static boolean isIconAnimator(int i, int i2) {
        return (i == 0 || SRDataUtil.isLcTipsCancelChangeLane(i2)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getLcTipsIconResId(int r3, int r4, int r5, boolean r6, int r7) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.util.SRUtil.getLcTipsIconResId(int, int, int, boolean, int):int");
    }

    public static boolean isLcTipsPriorToOddStatus(int i, int i2, boolean z) {
        if (isTakeOverWeakByQuitNgpOddStatus(i2)) {
            if (isTakeOverWeakByTipStatus(i)) {
                return z;
            }
            return false;
        }
        return true;
    }

    public static boolean isNgpPanelShow() {
        int scuNgpLcTips1Status = SRNaviManager.getInstance().getScuNgpLcTips1Status();
        int scuNgpOpeButtonStatus = SRNaviManager.getInstance().getScuNgpOpeButtonStatus();
        int scuQuitNgpOddStatus = SRNaviManager.getInstance().getScuQuitNgpOddStatus();
        int driveMode = SRNaviManager.getInstance().getDriveMode();
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "isNgpPanelShow lcTipsStatus:" + scuNgpLcTips1Status + ",opeBtnStatus:" + scuNgpOpeButtonStatus + ",oddStatus:" + scuQuitNgpOddStatus + ",driveMode:" + driveMode);
        }
        if (isLoadingShow(scuNgpLcTips1Status, scuNgpOpeButtonStatus, SRNaviManager.getInstance().getSRDisplayState())) {
            return true;
        }
        if (isNgpStrongAlertTypeByLcTipsOrOddStatus(scuNgpLcTips1Status, scuQuitNgpOddStatus)) {
            return false;
        }
        boolean isXpuFunctionIconShow = SRDataUtil.isXpuFunctionIconShow(driveMode, SRNaviManager.getInstance().isXpuShowSREnabled());
        return (isXpuFunctionIconShow || scuNgpLcTips1Status <= 0) ? isXpuFunctionIconShow : isSignalShow(scuNgpLcTips1Status);
    }

    public static boolean isLoadingShow(int i, int i2, int i3) {
        return i == 0 && 4 == i2 && SRNaviManager.getInstance().isXpuShowSREnabled();
    }

    public static boolean isNgpPanelNeedAnimator(int i, int i2) {
        return isTakeOverWeakByQuitNgpOddStatus(i2) || 32 == i || 39 == i || 41 == i || 45 == i || 50 == i || 51 == i || 62 == i || 64 == i || 65 == i || 70 == i || 68 == i || 69 == i || 72 == i || 78 == i || 118 == i || 127 == i || 132 == i || 134 == i || 139 == i || 140 == i || 141 == i || 142 == i || 150 == i || 151 == i || 152 == i || 163 == i;
    }

    public static boolean isShowOperateStatusByTipsStatus(int i) {
        return SRDataUtil.isLccStatus(SRNaviManager.getInstance().getDriveMode()) || 1 == i || 3 == i || 13 == i || 18 == i;
    }

    public static boolean isLaneMode() {
        MapViewWrapper map = TBTManager.getInstance().getMap();
        return map != null && map.isLaneMode();
    }
}
