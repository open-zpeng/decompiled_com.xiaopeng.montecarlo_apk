package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMConvGetSingleConvListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(AIMConversation aIMConversation);
}
