package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMGroupGetMembersListener {
    void OnFailure(AIMError aIMError);

    void OnLocal(ArrayList<AIMGroupMember> arrayList);

    void OnRefresh(ArrayList<AIMGroupMember> arrayList);
}
