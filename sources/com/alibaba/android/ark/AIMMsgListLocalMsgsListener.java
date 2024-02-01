package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMMsgListLocalMsgsListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(ArrayList<AIMMessage> arrayList, boolean z);
}
