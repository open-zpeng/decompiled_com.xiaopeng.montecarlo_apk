package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMMsgListMsgsReadStatus {
    void OnFailure(AIMError aIMError);

    void OnSuccess(AIMMsgReadStatus aIMMsgReadStatus);
}
