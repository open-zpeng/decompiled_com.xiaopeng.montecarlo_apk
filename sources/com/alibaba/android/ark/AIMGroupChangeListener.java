package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface AIMGroupChangeListener {
    void OnGroupAdminChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupDismissed(ArrayList<String> arrayList);

    void OnGroupIconChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupKicked(ArrayList<String> arrayList);

    void OnGroupMemberCountChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupMemberPermissionsChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupMemberRoleChanged(AIMGroupRoleChangedNotify aIMGroupRoleChangedNotify);

    void OnGroupOwnerChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupSilenceAllChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupSilencedEndtimeChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupSilencedStatusChanged(ArrayList<AIMConversation> arrayList);

    void OnGroupTitleChanged(ArrayList<AIMConversation> arrayList);
}
