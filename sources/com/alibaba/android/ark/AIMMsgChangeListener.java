package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMMsgChangeListener {
    void OnMsgExtensionChanged(ArrayList<AIMMessage> arrayList);

    void OnMsgLocalExtensionChanged(ArrayList<AIMMessage> arrayList);

    void OnMsgReadStatusChanged(ArrayList<AIMMessage> arrayList);

    void OnMsgRecalled(ArrayList<AIMMessage> arrayList);

    void OnMsgSendMediaProgressChanged(AIMMsgSendMediaProgress aIMMsgSendMediaProgress);

    void OnMsgStatusChanged(ArrayList<AIMMessage> arrayList);

    void OnMsgUnreadCountChanged(ArrayList<AIMMessage> arrayList);

    void OnMsgUserExtensionChanged(ArrayList<AIMMessage> arrayList);
}
