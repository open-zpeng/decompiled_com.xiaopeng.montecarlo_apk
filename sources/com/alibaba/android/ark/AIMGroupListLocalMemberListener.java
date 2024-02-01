package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMGroupListLocalMemberListener {
    void OnFailure(AIMError aIMError);

    void OnSuccess(ArrayList<AIMGroupMember> arrayList);
}
