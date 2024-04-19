package com.xiaopeng.montecarlo.navcore.sr.mock;

import com.xiaopeng.montecarlo.navcore.sr.ProtoSimulator;
import com.xiaopeng.montecarlo.root.util.L;
import xpilot.sr.proto.DynamicEnvironmentOuterClass;
import xpilot.sr.proto.Overall;
import xpilot.sr.proto.Primitives;
/* loaded from: classes3.dex */
public abstract class BaseProtoSender implements IProtoSender {
    protected ModifyProtoBean mModifyProto;
    protected ProtoSimulator.ProgressListener mProgressListener;
    protected final L.Tag TAG = new L.Tag(getClass().getSimpleName());
    private int mDataCount = 0;
    protected int mCurrentFrameIndex = 0;
    protected long mLastFrameTime = 0;
    protected long mProtoRecordTime = 0;

    public void setDataCount(int i) {
        this.mDataCount = i;
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public boolean hasProtoData() {
        return this.mDataCount > 0;
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public int getProtoSendProgress() {
        return (this.mCurrentFrameIndex * 100) / this.mDataCount;
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public void jumpToProgress(int i) {
        this.mCurrentFrameIndex = (int) ((this.mDataCount * i) / 100.0f);
        if (L.ENABLE) {
            L.Tag tag = this.TAG;
            L.d(tag, "seekTo, progress = " + i + ", mDataCount = " + this.mDataCount + ", mCurrentFrameIndex = " + this.mCurrentFrameIndex);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.sr.mock.IProtoSender
    public void setProgressListener(ProtoSimulator.ProgressListener progressListener) {
        this.mProgressListener = progressListener;
    }

    public void startModify(boolean z) {
        if (z) {
            this.mModifyProto = new ModifyProtoBean();
        } else {
            this.mModifyProto = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canInjectProto() {
        return this.mModifyProto != null;
    }

    public void modifyRd(int i, int i2) {
        L.Tag tag = this.TAG;
        L.i(tag, "modify rd = " + i + " value = " + i2);
        if (canInjectProto()) {
            this.mModifyProto.modifyRd(i, i2);
            return;
        }
        L.Tag tag2 = this.TAG;
        L.e(tag2, "you should send start cmd first, modify rd = " + i + " value = " + i2);
    }

    public void modifySm(int i, int i2) {
        L.Tag tag = this.TAG;
        L.i(tag, "modify sm = " + i + " value = " + i2);
        if (canInjectProto()) {
            this.mModifyProto.modifySm(i, i2);
            return;
        }
        L.Tag tag2 = this.TAG;
        L.e(tag2, "you should send start cmd first, modify sm = " + i + " value = " + i2);
    }

    public void modifyDisplaySt(int i) {
        L.Tag tag = this.TAG;
        L.i(tag, "modifyDisplaySt value = " + i);
        if (canInjectProto()) {
            this.mModifyProto.display_st = i;
            return;
        }
        L.Tag tag2 = this.TAG;
        L.e(tag2, "you should send start cmd first, modifyDisplaySt value = " + i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Overall.overall injectProto(Overall.overall overallVar) {
        Overall.overall.Builder newBuilder = Overall.overall.newBuilder(overallVar);
        Primitives.StateManagement.Builder newBuilder2 = Primitives.StateManagement.newBuilder(overallVar.getSmInfo());
        DynamicEnvironmentOuterClass.BPoutput.Builder newBuilder3 = DynamicEnvironmentOuterClass.BPoutput.newBuilder(overallVar.getBpInfo());
        if (this.mModifyProto.rd_10 > 0) {
            newBuilder2.setRdmodulecom10State(this.mModifyProto.rd_10);
        }
        if (this.mModifyProto.rd_11 > 0) {
            newBuilder2.setRdmodulecom11State(this.mModifyProto.rd_11);
        }
        if (this.mModifyProto.rd_14 > 0) {
            newBuilder2.setRdmodulecom14State(this.mModifyProto.rd_14);
        }
        if (this.mModifyProto.rd_15 > 0) {
            newBuilder2.setRdmodulecom15State(this.mModifyProto.rd_15);
        }
        if (this.mModifyProto.rd_16 > 0) {
            newBuilder2.setRdmodulecom16State(this.mModifyProto.rd_16);
        }
        if (this.mModifyProto.rd_30 > 0) {
            newBuilder2.setRdmodulecom30State(this.mModifyProto.rd_30);
        }
        if (this.mModifyProto.sm_16 >= 0) {
            newBuilder3.setBpToSm16(this.mModifyProto.sm_16);
        }
        if (this.mModifyProto.sm_20 > 0) {
            newBuilder3.setBpToSm20(this.mModifyProto.sm_20);
        }
        if (this.mModifyProto.sm_22 >= 0) {
            newBuilder3.setBpToSm22(this.mModifyProto.sm_22);
        }
        if (this.mModifyProto.sm_24 >= 0) {
            newBuilder3.setBpToSm24(this.mModifyProto.sm_24);
        }
        if (this.mModifyProto.sm_25 > 0) {
            newBuilder3.setBpToSm25(this.mModifyProto.sm_25);
        }
        if (this.mModifyProto.display_st >= 0) {
            newBuilder.setSrDisplaySt(this.mModifyProto.display_st);
        }
        newBuilder.setSmInfo(newBuilder2);
        newBuilder.setBpInfo(newBuilder3);
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class ModifyProtoBean {
        int rd_10 = -1;
        int rd_11 = -1;
        int rd_14 = -1;
        int rd_15 = -1;
        int rd_16 = -1;
        int rd_30 = -1;
        int sm_16 = -1;
        int sm_20 = -1;
        int sm_22 = -1;
        int sm_24 = -1;
        int sm_25 = -1;
        int display_st = -1;

        protected ModifyProtoBean() {
        }

        void modifyRd(int i, int i2) {
            if (i == 10) {
                this.rd_10 = i2;
            } else if (i == 11) {
                this.rd_11 = i2;
            } else if (i != 30) {
                switch (i) {
                    case 14:
                        this.rd_14 = i2;
                        return;
                    case 15:
                        this.rd_15 = i2;
                        return;
                    case 16:
                        this.rd_16 = i2;
                        return;
                    default:
                        return;
                }
            } else {
                this.rd_30 = i2;
            }
        }

        void modifySm(int i, int i2) {
            if (i == 16) {
                this.sm_16 = i2;
            } else if (i == 20) {
                this.sm_20 = i2;
            } else if (i == 22) {
                this.sm_22 = i2;
            } else if (i == 24) {
                this.sm_24 = i2;
            } else if (i != 25) {
            } else {
                this.sm_25 = i2;
            }
        }
    }
}
