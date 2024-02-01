package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMGetParentConvInfoListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(ArrayList<AIMParentConversationInfo> arrayList);
}
