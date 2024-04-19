package com.xiaopeng.montecarlo.navcore.sr.mock;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.bean.location.XPPosInfo;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import xpilot.sr.proto.Overall;
/* loaded from: classes3.dex */
public class NaviProtoSender extends BaseProtoSender {
    public static final int SR_DATA_INTERVAL = 100;
    final Overall.total_overall.Builder mProto;

    public NaviProtoSender(@NonNull Overall.total_overall.Builder builder) {
        this.mProto = builder;
        setDataCount(getProtoDataCount());
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public int getProtoDataCount() {
        return this.mProto.getOverallCount();
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public boolean sendNextFrame() {
        if (this.mCurrentFrameIndex >= getProtoDataCount() - 1) {
            this.mCurrentFrameIndex = 0;
        } else {
            this.mCurrentFrameIndex++;
        }
        Overall.overall overall = this.mProto.getOverall(this.mCurrentFrameIndex);
        if (overall != null) {
            if (canInjectProto()) {
                overall = injectProto(overall);
            }
            SRNaviManager.getInstance().simulatorProto(overall);
            String stringUtf8 = overall.getXpPosInfo() == null ? "" : overall.getXpPosInfo().toStringUtf8();
            String stringUtf82 = overall.getXpEhpVersion() != null ? overall.getXpEhpVersion().toStringUtf8() : "";
            if (!TextUtils.isEmpty(stringUtf82)) {
                LaneServiceManager.getInstance().setEHPVersion(stringUtf82);
            } else {
                L.w(this.TAG, "The version of proto data is too old, please use newer. ehpVersion == null");
            }
            if (!TextUtils.isEmpty(stringUtf8)) {
                XPPosInfo xPPosInfo = (XPPosInfo) GsonUtil.fromJson(stringUtf8, (Class<Object>) XPPosInfo.class);
                if (xPPosInfo != null) {
                    TBTManager.getInstance().getPosServiceWrapper().setAllPos(xPPosInfo);
                } else {
                    L.w(this.TAG, "The version of proto data is too old, please use newer. xpPosInfo = " + stringUtf8);
                }
            } else {
                L.w(this.TAG, "The version of proto data is too old, please use newer. xpPosInfo == null");
            }
            long datetime = overall.getGaodeInfo().getBrief9().getDatetime() / 1000000;
            if (datetime != this.mProtoRecordTime) {
                this.mProtoRecordTime = datetime;
                if (this.mProgressListener != null) {
                    this.mProgressListener.onRelayTimeChange(this.mProtoRecordTime);
                }
            }
            this.mLastFrameTime = System.currentTimeMillis();
            return true;
        }
        return sendNextFrame();
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public void scheduleNextFrame(Handler handler) {
        if (handler != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = (this.mLastFrameTime + 100) - currentTimeMillis;
            this.mLastFrameTime = currentTimeMillis;
            if (j < -100 && L.ENABLE) {
                L.w(this.TAG, "nextFrame cost too much time = " + (100 - j));
            }
            if (j < 0) {
                j = 0;
            }
            handler.sendEmptyMessageDelayed(2, j);
        }
    }
}
