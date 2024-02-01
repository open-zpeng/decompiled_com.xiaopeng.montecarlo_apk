package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMMsgServiceHook {
    ArrayList<AIMMessage> PreQueryMessage(ArrayList<AIMMessage> arrayList);

    ArrayList<AIMMessage> PreReceiveMessage(ArrayList<AIMMessage> arrayList);

    void PreSendMessage(AIMMessage aIMMessage, AIMMsgHookPreSendMsgListener aIMMsgHookPreSendMsgListener);
}
