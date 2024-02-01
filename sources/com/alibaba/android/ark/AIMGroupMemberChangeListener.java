package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMGroupMemberChangeListener {
    void OnAddedMembers(ArrayList<AIMGroupMember> arrayList);

    void OnRemovedMembers(ArrayList<AIMGroupMember> arrayList);

    void OnUpdatedMembers(ArrayList<AIMGroupMember> arrayList);
}
