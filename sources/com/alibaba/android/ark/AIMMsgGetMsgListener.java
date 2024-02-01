package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMMsgGetMsgListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(AIMMessage aIMMessage);
}
