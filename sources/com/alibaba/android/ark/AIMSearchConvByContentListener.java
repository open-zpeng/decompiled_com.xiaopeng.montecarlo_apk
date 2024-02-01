package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMSearchConvByContentListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(ArrayList<AIMSearchConversationResult> arrayList, int i);
}
