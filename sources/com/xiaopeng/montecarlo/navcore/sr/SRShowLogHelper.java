package com.xiaopeng.montecarlo.navcore.sr;

import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SRShowLogHelper {
    private static final L.Tag TAG = new L.Tag(SRShowLogHelper.class.getSimpleName());
    SRAvailableTimePiece mCurrentSRAvailablePiece;
    boolean mIsLogEnabled = false;
    List<SRAvailableTimePiece> mSRAvailablePieceList;

    public synchronized void logNaviStart() {
        if (CarServiceManager.getInstance().isNGPOn()) {
            clean();
            this.mIsLogEnabled = true;
            L.i(TAG, "1..logNaviStart");
        }
    }

    public synchronized void logNaviStop() {
        if (CarServiceManager.getInstance().isNGPOn()) {
            if (!this.mIsLogEnabled) {
                L.e(TAG, "logNaviStop but log is not enabled!");
                return;
            }
            if (this.mSRAvailablePieceList != null && !this.mSRAvailablePieceList.isEmpty()) {
                float f = 0.0f;
                float f2 = 0.0f;
                for (SRAvailableTimePiece sRAvailableTimePiece : this.mSRAvailablePieceList) {
                    long sRAvailableTimeLength = sRAvailableTimePiece.getSRAvailableTimeLength();
                    if (sRAvailableTimeLength < 0) {
                        L.e(TAG, "7..SRAvailableTimeLength less than 0!");
                    } else {
                        long sRTotalShowTimeLength = sRAvailableTimePiece.getSRTotalShowTimeLength();
                        if (sRTotalShowTimeLength < 0) {
                            L.e(TAG, "7..srShowTimeLen less than 0!");
                        } else if (sRTotalShowTimeLength > sRAvailableTimeLength) {
                            L.e(TAG, " 7..srShowTimeLen greater than availableTimeLen!");
                        } else {
                            f2 += (float) sRAvailableTimeLength;
                            f += (float) sRTotalShowTimeLength;
                        }
                    }
                }
                if (f >= 0.0f && f2 > 0.0f) {
                    if (L.ENABLE) {
                        L.d(TAG, "totalSRShowTime:" + f + ",totalSRAvailableTime:" + f2);
                    }
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    numberFormat.setMaximumFractionDigits(1);
                    sendLog(numberFormat.format((f / f2) * 100.0f));
                }
            }
            clean();
            this.mIsLogEnabled = false;
            L.i(TAG, "7..logNaviStop");
        }
    }

    public synchronized void logSRAvailable() {
        if (!this.mIsLogEnabled) {
            L.e(TAG, "logSRDisabled but log is not enabled!");
        } else if (this.mCurrentSRAvailablePiece != null && !this.mCurrentSRAvailablePiece.isPieceFinished()) {
            L.e(TAG, "2..sr available piece is not finished yet, no need to log!");
        } else {
            this.mCurrentSRAvailablePiece = new SRAvailableTimePiece();
            this.mCurrentSRAvailablePiece.mSRAvailableStartTimeInMillis = System.currentTimeMillis();
            L.i(TAG, "2..logSRAvailable");
        }
    }

    public synchronized void logSRDisabled() {
        if (!this.mIsLogEnabled) {
            L.e(TAG, "logSRDisabled but log is not enabled!");
            return;
        }
        if (this.mCurrentSRAvailablePiece != null && !this.mCurrentSRAvailablePiece.isPieceFinished()) {
            this.mCurrentSRAvailablePiece.logSRHide();
            this.mCurrentSRAvailablePiece.mSRAvailableEndTimeInMillis = System.currentTimeMillis();
            if (this.mSRAvailablePieceList == null) {
                this.mSRAvailablePieceList = new ArrayList();
            }
            this.mSRAvailablePieceList.add(this.mCurrentSRAvailablePiece);
            L.i(TAG, "5..logSRDisabled add currentPiece");
            return;
        }
        L.e(TAG, "5..logSRDisabled but mCurrentSRAvailablePiece is null or finished!");
    }

    public synchronized void logSRShow() {
        if (!this.mIsLogEnabled) {
            L.e(TAG, "logSRShow but log is not enabled!");
            return;
        }
        if (this.mCurrentSRAvailablePiece != null && !this.mCurrentSRAvailablePiece.isPieceFinished()) {
            this.mCurrentSRAvailablePiece.logSRShow();
            L.i(TAG, "3..logSRShow");
            return;
        }
        L.e(TAG, "3..logSRShow but mCurrentSRAvailablePiece is null or finished!");
    }

    public synchronized void logSRHide() {
        if (!this.mIsLogEnabled) {
            L.e(TAG, "logSRHide but log is not enabled!");
            return;
        }
        if (this.mCurrentSRAvailablePiece != null && !this.mCurrentSRAvailablePiece.isPieceFinished()) {
            this.mCurrentSRAvailablePiece.logSRHide();
            L.i(TAG, "4..logSRHide");
            return;
        }
        L.e(TAG, "4..logSRHide but mCurrentSRAvailablePiece is null or finished!");
    }

    private void clean() {
        List<SRAvailableTimePiece> list = this.mSRAvailablePieceList;
        if (list != null) {
            list.clear();
        }
        this.mCurrentSRAvailablePiece = null;
    }

    private void sendLog(String str) {
        L.Tag tag = TAG;
        L.i(tag, "6..sendLog timePercent:" + str);
        DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.SR_SHOW_TIME_PERCENT, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SRAvailableTimePiece {
        SRShowTimePiece mCurrentSRShowTimePiece;
        List<SRShowTimePiece> mSRShowTimePieces;
        long mSRAvailableStartTimeInMillis = -1;
        long mSRAvailableEndTimeInMillis = -1;

        SRAvailableTimePiece() {
        }

        public void logSRShow() {
            SRShowTimePiece sRShowTimePiece = this.mCurrentSRShowTimePiece;
            if (sRShowTimePiece != null && !sRShowTimePiece.isPieceFinished()) {
                L.e(SRShowLogHelper.TAG, "logSRShow mCurrentSRShowTimePiece is not finished yet, no need to log!");
                return;
            }
            this.mCurrentSRShowTimePiece = new SRShowTimePiece();
            this.mCurrentSRShowTimePiece.mSRShowTimeInMillis = System.currentTimeMillis();
        }

        public void logSRHide() {
            SRShowTimePiece sRShowTimePiece = this.mCurrentSRShowTimePiece;
            if (sRShowTimePiece == null || sRShowTimePiece.isPieceFinished()) {
                L.e(SRShowLogHelper.TAG, "logSRHide but mCurrentSRShowTimePiece is null or finished!");
                return;
            }
            this.mCurrentSRShowTimePiece.mSRHideTimeInMillis = System.currentTimeMillis();
            if (this.mSRShowTimePieces == null) {
                this.mSRShowTimePieces = new ArrayList();
            }
            this.mSRShowTimePieces.add(this.mCurrentSRShowTimePiece);
        }

        public boolean isPieceFinished() {
            return this.mSRAvailableEndTimeInMillis > 0;
        }

        public long getSRAvailableTimeLength() {
            return this.mSRAvailableEndTimeInMillis - this.mSRAvailableStartTimeInMillis;
        }

        public long getSRTotalShowTimeLength() {
            List<SRShowTimePiece> list = this.mSRShowTimePieces;
            long j = 0;
            if (list != null && !list.isEmpty()) {
                for (SRShowTimePiece sRShowTimePiece : this.mSRShowTimePieces) {
                    j += sRShowTimePiece.getSRShowTimeLength();
                }
            }
            return j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SRShowTimePiece {
        long mSRShowTimeInMillis = -1;
        long mSRHideTimeInMillis = -1;

        SRShowTimePiece() {
        }

        public boolean isPieceFinished() {
            return this.mSRHideTimeInMillis > 0;
        }

        public long getSRShowTimeLength() {
            if (this.mSRShowTimeInMillis < 0 || this.mSRHideTimeInMillis < 0) {
                L.e(SRShowLogHelper.TAG, "SRShowTimePiece getSRShowTimeLength error!! time is not set!");
            }
            return this.mSRHideTimeInMillis - this.mSRShowTimeInMillis;
        }
    }
}
