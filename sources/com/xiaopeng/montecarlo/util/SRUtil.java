package com.xiaopeng.montecarlo.util;

import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
/* loaded from: classes3.dex */
public class SRUtil {
    private static final long LC_TIPS_PROGRESS_SHOW_TIMER = 3000;

    public static long getLcTipsProgressTimer(int i) {
        return 0L;
    }

    public static int getLcTipsSubIndex(int i) {
        return -1;
    }

    public static int getNgpInfoTipsIcon(int i) {
        if (i == 1 || i == 2) {
            return R.drawable.ic_lanechange_sug;
        }
        return -1;
    }

    public static int getNgpLcTipsMainTextColorId(int i) {
        return 40 == i ? R.color.ngp_panel_lc_tips_main_text_color_remind : R.color.ngp_panel_lc_tips_main_text_color_normal;
    }

    public static int getNgpProgressBarResId(int i) {
        return 40 == i ? R.drawable.ngp_panel_progerss_bg_remind : 28 == i ? R.drawable.ngp_panel_progerss_bg_cancel : R.drawable.ngp_panel_progerss_bg_normal;
    }

    public static boolean isAccIconShow(int i, int i2) {
        return 5 == i || 6 == i || 3 == i || 4 == i || 2 == i;
    }

    public static boolean isIconAnimator(int i, int i2) {
        return (i == 0 || 28 == i2) ? false : true;
    }

    public static boolean isLcTipsProgressShow(int i) {
        return false;
    }

    public static boolean isLccStatus(int i) {
        return 3 == i || 4 == i;
    }

    public static boolean isLoadingShow(int i, int i2, int i3) {
        return i == 0 && 4 == i2 && 2 != i3;
    }

    public static boolean isNgpPanelNeedAnimatorByQuitNgpOddStatus(int i) {
        return i >= 1 && i <= 5;
    }

    public static boolean isNgpPanelNeedAnimatorByTipStatus(int i) {
        return 32 == i || 39 == i || 51 == i || 47 == i || 48 == i || 53 == i || 41 == i || 64 == i || 65 == i || 70 == i || 78 == i;
    }

    public static boolean isNgpStatus(int i) {
        return 5 == i || 6 == i;
    }

    private static boolean isNgpStrongAlertTypeByLcTipsOrOddStatus(int i, int i2) {
        return 34 == i || 35 == i || 40 == i || 47 == i || 57 == i || 60 == i || 59 == i || 63 == i || 53 == i || 16 == i || 6 == i2;
    }

    public static boolean isPlayTTS(int i) {
        return 4 == i || 5 == i;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0030 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean isSignalSupport(int r3) {
        /*
            r0 = 14
            r1 = 0
            if (r3 == r0) goto L30
            r0 = 15
            if (r3 == r0) goto L30
            r0 = 29
            if (r3 == r0) goto L30
            r0 = 30
            if (r3 == r0) goto L30
            r0 = 47
            if (r3 == r0) goto L30
            r0 = 49
            if (r3 == r0) goto L30
            r0 = 61
            if (r3 == r0) goto L30
            r0 = 52
            if (r3 == r0) goto L30
            r0 = 53
            if (r3 == r0) goto L30
            switch(r3) {
                case 6: goto L30;
                case 7: goto L30;
                case 8: goto L30;
                case 9: goto L30;
                case 10: goto L30;
                default: goto L28;
            }
        L28:
            switch(r3) {
                case 19: goto L30;
                case 20: goto L30;
                case 21: goto L30;
                case 22: goto L30;
                case 23: goto L30;
                case 24: goto L30;
                case 25: goto L30;
                case 26: goto L30;
                case 27: goto L30;
                default: goto L2b;
            }
        L2b:
            switch(r3) {
                case 42: goto L30;
                case 43: goto L30;
                case 44: goto L30;
                default: goto L2e;
            }
        L2e:
            r0 = 1
            goto L31
        L30:
            r0 = r1
        L31:
            r2 = 57
            if (r3 >= r2) goto L39
            r2 = 54
            if (r3 > r2) goto L41
        L39:
            r2 = 71
            if (r3 == r2) goto L41
            r2 = 82
            if (r3 < r2) goto L42
        L41:
            r0 = r1
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.util.SRUtil.isSignalSupport(int):boolean");
    }

    public static boolean isTakeOverWeakByQuitNgpOddStatus(int i) {
        return i >= 1 && i <= 5;
    }

    public static boolean isTakeOverWeakByTipStatus(int i) {
        return 51 == i || 41 == i || 39 == i || 48 == i || 64 == i || 65 == i || 70 == i;
    }

    public static int getNgpPanelStatus(int i, int i2) {
        if (i == 0 && 4 == i2) {
            return 5;
        }
        if (!isLccStatus(SRNaviManager.getInstance().getDriveMode())) {
            if (i == 2) {
                return 2;
            }
            if (i == 3 || i == 54 || i == 58) {
                return 3;
            }
        }
        return 0;
    }

    public static int getLcTipsIconResId(int i, int i2) {
        boolean isLccStatus = isLccStatus(SRNaviManager.getInstance().getDriveMode());
        int i3 = R.drawable.vector_ic_lcc_normal;
        if (!isLccStatus && 1 != i) {
            i3 = (4 == i || 5 == i) ? R.drawable.vector_ic_ngp_turnoff : 32 == i ? R.drawable.vector_ic_warn_avoid : (39 == i || 43 == i || 40 == i || 51 == i || 48 == i || 50 == i || 31 == i || 65 == i || 69 == i || 79 == i || 81 == i) ? R.drawable.ic_lanechange_sug : 41 == i ? R.drawable.vector_ic_warn_construction : 46 == i ? R.drawable.vector_ic_warn_rain : 64 == i ? R.drawable.vector_ic_warn_pedestrian : (68 == i || 78 == i) ? R.drawable.vector_ic_warn_sharpturn : 70 == i ? R.drawable.vector_ic_warn_frontcar : 72 == i ? R.drawable.vector_ic_warn_avoid_van : R.drawable.vector_ic_ngp_turnon;
        }
        return i2 == 0 ? i3 : 1 == i2 ? 28 == i ? R.drawable.bg_lanechange_left_cancel : 39 == i ? R.drawable.arow_red_l : R.drawable.arow_blue_l : 2 == i2 ? 28 == i ? R.drawable.bg_lanechange_right_cancel : 39 == i ? R.drawable.arow_red_r : R.drawable.arow_blue_r : i3;
    }

    public static int getPanelIconByNgpOddStatus(int i) {
        return isNgpPanelNeedAnimatorByQuitNgpOddStatus(i) ? R.drawable.ic_lanechange_sug : R.drawable.vector_ic_ngp_turnon;
    }

    public static boolean isShowGuideLine() {
        int driveMode = SRNaviManager.getInstance().getDriveMode();
        return 5 == driveMode || 6 == driveMode;
    }

    public static boolean isNgpPanelShow() {
        int scuNgpLcTips1Status = SRNaviManager.getInstance().getScuNgpLcTips1Status();
        int scuNgpOpeButtonStatus = SRNaviManager.getInstance().getScuNgpOpeButtonStatus();
        int scuQuitNgpOddStatus = SRNaviManager.getInstance().getScuQuitNgpOddStatus();
        int driveMode = SRNaviManager.getInstance().getDriveMode();
        if (isLoadingShow(scuNgpLcTips1Status, scuNgpOpeButtonStatus, SRNaviManager.getInstance().getSRDisplayState())) {
            return true;
        }
        if (!isNgpStrongAlertTypeByLcTipsOrOddStatus(scuNgpLcTips1Status, scuQuitNgpOddStatus)) {
            if (isLccStatus(driveMode)) {
                if (2 != SRNaviManager.getInstance().getSRDisplayState()) {
                    return true;
                }
            } else if ((scuNgpLcTips1Status > 0 || scuNgpOpeButtonStatus > 0 || scuQuitNgpOddStatus > 0) && scuNgpLcTips1Status != 0 && 33 != scuNgpLcTips1Status) {
                return isSignalSupport(scuNgpLcTips1Status);
            }
        }
        return false;
    }

    public static boolean isShowOperateStatusByTipsStatus(int i) {
        return isLccStatus(SRNaviManager.getInstance().getDriveMode()) || 1 == i || 3 == i || 13 == i || 18 == i;
    }

    public static boolean isLaneMode() {
        MapViewWrapper map = TBTManager.getInstance().getMap();
        return map != null && map.isLaneMode();
    }
}
