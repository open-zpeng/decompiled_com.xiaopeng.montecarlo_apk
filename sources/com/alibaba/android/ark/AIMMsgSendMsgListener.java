package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMMsgSendMsgListener {
    void OnFailure(AIMError aIMError);

    void OnProgress(double d);

    void OnSuccess(AIMMessage aIMMessage);
}
