package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMTraceListener {
    void OnCommitBasePoint(AIMFullLinkPointBase aIMFullLinkPointBase);

    void OnCommitConvPoint(AIMFullLinkPointConv aIMFullLinkPointConv);

    void OnCommitMsgPoint(AIMFullLinkPointMsg aIMFullLinkPointMsg);
}
