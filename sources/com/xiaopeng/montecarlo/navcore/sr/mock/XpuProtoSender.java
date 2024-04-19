package com.xiaopeng.montecarlo.navcore.sr.mock;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.navcore.location.LocationServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.LaneServiceManager;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.L;
import lane.auto_pilot.data.AutoPilotDataOuterClass;
import xpilot.sr.proto.Imudata;
import xpilot.sr.proto.Nmeadata;
import xpilot.sr.proto.Overall;
/* loaded from: classes3.dex */
public class XpuProtoSender extends BaseProtoSender {
    final Overall.total_xpu_overall.Builder mProto;

    public XpuProtoSender(@NonNull Overall.total_xpu_overall.Builder builder) {
        this.mProto = builder;
        setDataCount(getProtoDataCount());
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public int getProtoDataCount() {
        return this.mProto.getXpuOverallCount();
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public boolean sendNextFrame() {
        byte[] byteArray;
        if (this.mCurrentFrameIndex >= getProtoDataCount() - 1) {
            this.mCurrentFrameIndex = 0;
        } else {
            this.mCurrentFrameIndex++;
        }
        Overall.xpu_data_to_app xpuOverall = this.mProto.getXpuOverall(this.mCurrentFrameIndex);
        if (xpuOverall != null) {
            long cduTime = xpuOverall.getCduTime();
            Imudata.ImuInfo imuInfo = xpuOverall.getImuInfo();
            Nmeadata.NmeadataInfo nmeadataInfo = xpuOverall.getNmeadataInfo();
            Overall.overall overall = xpuOverall.getOverall();
            AutoPilotDataOuterClass.AutoPilotData autoPilotData = xpuOverall.getAutoPilotData();
            if (cduTime != this.mProtoRecordTime) {
                this.mProtoRecordTime = cduTime;
                if (this.mProgressListener != null) {
                    this.mProgressListener.onRelayTimeChange(this.mProtoRecordTime);
                }
            }
            if (overall != null && overall.toByteArray().length > 0) {
                if (canInjectProto()) {
                    overall = injectProto(overall);
                }
                SRNaviManager.getInstance().simulatorProto(overall);
            }
            if (autoPilotData != null && (byteArray = autoPilotData.toByteArray()) != null && byteArray.length > 0) {
                LaneServiceManager.getInstance().setAutopilotData(byteArray);
            }
            if (imuInfo != null && imuInfo.getImusysstList() != null && !imuInfo.getImusysstList().isEmpty()) {
                CarServiceManager.getInstance().mockScuCarSpeed((Float[]) imuInfo.getImusysstList().toArray(new Float[0]), imuInfo.getTime());
            }
            if (nmeadataInfo != null && nmeadataInfo.getData() != null) {
                LocationServiceManager.getInstance().onMockNmeaMessage(nmeadataInfo.getData().getMessage(), nmeadataInfo.getData().getTimeStamp(), nmeadataInfo.getTimeStamp());
            }
            this.mLastFrameTime = cduTime;
            return true;
        }
        return sendNextFrame();
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public void scheduleNextFrame(Handler handler) {
        long cduTime;
        if (handler != null) {
            if (this.mCurrentFrameIndex >= getProtoDataCount() - 1) {
                cduTime = this.mLastFrameTime + 1000;
            } else {
                cduTime = this.mProto.getXpuOverall(this.mCurrentFrameIndex + 1).getCduTime();
            }
            long j = cduTime - this.mLastFrameTime;
            if (j <= 0) {
                L.e(this.TAG, "error nextFrameDelay is smaller than 0!");
                j = 100;
            }
            handler.sendEmptyMessageDelayed(2, j);
        }
    }
}
