package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMMsgListener {
    void OnAddedMessages(ArrayList<AIMNewMessage> arrayList);

    void OnRemovedMessages(ArrayList<AIMMessage> arrayList);

    void OnStoredMessages(ArrayList<AIMMessage> arrayList);
}
