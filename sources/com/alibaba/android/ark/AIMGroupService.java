package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMGroupService {
    public static final byte AIM_MAX_GROUP_MEMBER_CURSOR = -1;

    public abstract void AddAdmins(AIMGroupUpdateAdmins aIMGroupUpdateAdmins, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void AddGroupChangeListener(AIMGroupChangeListener aIMGroupChangeListener);

    public abstract void AddGroupMemberChangeListener(AIMGroupMemberChangeListener aIMGroupMemberChangeListener);

    public abstract void AddMembers(AIMGroupJoin aIMGroupJoin, AIMGroupAddMembersListener aIMGroupAddMembersListener);

    public abstract void AddSilencedBlacklist(AIMGroupUpdateSilencedBlackList aIMGroupUpdateSilencedBlackList, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void AddSilencedWhitelist(AIMGroupUpdateSilencedWhiteList aIMGroupUpdateSilencedWhiteList, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void CancelSilenceAll(AIMGroupUpdateSilenceAll aIMGroupUpdateSilenceAll, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void CreateGroupConversation(AIMGroupCreateGroupConvParam aIMGroupCreateGroupConvParam, AIMGroupCreateGroupConvListener aIMGroupCreateGroupConvListener);

    public abstract void Dismiss(String str, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void GetMembers(String str, ArrayList<AIMUserId> arrayList, AIMGroupGetMembersListener aIMGroupGetMembersListener);

    public abstract void GetSilencedInfo(String str, AIMGroupGetSilencedInfoListener aIMGroupGetSilencedInfoListener);

    public abstract void Leave(AIMGroupLeave aIMGroupLeave, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void ListAllAdmins(String str, AIMGroupListAllAdminsListener aIMGroupListAllAdminsListener);

    public abstract void ListAllMembers(String str, AIMGroupListAllMemberListener aIMGroupListAllMemberListener);

    public abstract void ListLocalMembers(String str, long j, long j2, AIMGroupListLocalMemberListener aIMGroupListLocalMemberListener);

    public abstract void RemoveAdmins(AIMGroupUpdateAdmins aIMGroupUpdateAdmins, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void RemoveAllGroupChangeListener();

    public abstract void RemoveAllGroupMemberChangeListener();

    public abstract void RemoveGroupChangeListener(AIMGroupChangeListener aIMGroupChangeListener);

    public abstract void RemoveGroupMemberChangeListener(AIMGroupMemberChangeListener aIMGroupMemberChangeListener);

    public abstract void RemoveMembers(AIMGroupKick aIMGroupKick, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void RemoveSilencedBlacklist(AIMGroupUpdateSilencedBlackList aIMGroupUpdateSilencedBlackList, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void RemoveSilencedWhitelist(AIMGroupUpdateSilencedWhiteList aIMGroupUpdateSilencedWhiteList, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void SetMemberPermission(AIMGroupSetMemberPermission aIMGroupSetMemberPermission, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void SetOwner(AIMGroupSetOwner aIMGroupSetOwner, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void SilenceAll(AIMGroupUpdateSilenceAll aIMGroupUpdateSilenceAll, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void UpdateDefaultTitle(AIMGroupUpdateTitle aIMGroupUpdateTitle, AIMGroupUpdateListener aIMGroupUpdateListener);

    public abstract void UpdateGroupMemberNick(AIMGroupMemberUpdateNick aIMGroupMemberUpdateNick, AIMGroupMemberNickUpdateListener aIMGroupMemberNickUpdateListener);

    public abstract void UpdateIcon(AIMGroupUpdateIcon aIMGroupUpdateIcon, AIMGroupUpdateListener aIMGroupUpdateListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMGroupService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void AddAdminsNative(long j, AIMGroupUpdateAdmins aIMGroupUpdateAdmins, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void AddGroupChangeListenerNative(long j, AIMGroupChangeListener aIMGroupChangeListener);

        private native void AddGroupMemberChangeListenerNative(long j, AIMGroupMemberChangeListener aIMGroupMemberChangeListener);

        private native void AddMembersNative(long j, AIMGroupJoin aIMGroupJoin, AIMGroupAddMembersListener aIMGroupAddMembersListener);

        private native void AddSilencedBlacklistNative(long j, AIMGroupUpdateSilencedBlackList aIMGroupUpdateSilencedBlackList, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void AddSilencedWhitelistNative(long j, AIMGroupUpdateSilencedWhiteList aIMGroupUpdateSilencedWhiteList, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void CancelSilenceAllNative(long j, AIMGroupUpdateSilenceAll aIMGroupUpdateSilenceAll, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void CreateGroupConversationNative(long j, AIMGroupCreateGroupConvParam aIMGroupCreateGroupConvParam, AIMGroupCreateGroupConvListener aIMGroupCreateGroupConvListener);

        private native void DismissNative(long j, String str, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void GetMembersNative(long j, String str, ArrayList<AIMUserId> arrayList, AIMGroupGetMembersListener aIMGroupGetMembersListener);

        private native void GetSilencedInfoNative(long j, String str, AIMGroupGetSilencedInfoListener aIMGroupGetSilencedInfoListener);

        private native void LeaveNative(long j, AIMGroupLeave aIMGroupLeave, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void ListAllAdminsNative(long j, String str, AIMGroupListAllAdminsListener aIMGroupListAllAdminsListener);

        private native void ListAllMembersNative(long j, String str, AIMGroupListAllMemberListener aIMGroupListAllMemberListener);

        private native void ListLocalMembersNative(long j, String str, long j2, long j3, AIMGroupListLocalMemberListener aIMGroupListLocalMemberListener);

        private native void RemoveAdminsNative(long j, AIMGroupUpdateAdmins aIMGroupUpdateAdmins, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void RemoveAllGroupChangeListenerNative(long j);

        private native void RemoveAllGroupMemberChangeListenerNative(long j);

        private native void RemoveGroupChangeListenerNative(long j, AIMGroupChangeListener aIMGroupChangeListener);

        private native void RemoveGroupMemberChangeListenerNative(long j, AIMGroupMemberChangeListener aIMGroupMemberChangeListener);

        private native void RemoveMembersNative(long j, AIMGroupKick aIMGroupKick, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void RemoveSilencedBlacklistNative(long j, AIMGroupUpdateSilencedBlackList aIMGroupUpdateSilencedBlackList, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void RemoveSilencedWhitelistNative(long j, AIMGroupUpdateSilencedWhiteList aIMGroupUpdateSilencedWhiteList, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void SetMemberPermissionNative(long j, AIMGroupSetMemberPermission aIMGroupSetMemberPermission, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void SetOwnerNative(long j, AIMGroupSetOwner aIMGroupSetOwner, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void SilenceAllNative(long j, AIMGroupUpdateSilenceAll aIMGroupUpdateSilenceAll, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void UpdateDefaultTitleNative(long j, AIMGroupUpdateTitle aIMGroupUpdateTitle, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void UpdateGroupMemberNickNative(long j, AIMGroupMemberUpdateNick aIMGroupMemberUpdateNick, AIMGroupMemberNickUpdateListener aIMGroupMemberNickUpdateListener);

        private native void UpdateIconNative(long j, AIMGroupUpdateIcon aIMGroupUpdateIcon, AIMGroupUpdateListener aIMGroupUpdateListener);

        private native void nativeDestroy(long j);

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public void djinniPrivateDestroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            djinniPrivateDestroy();
            super.finalize();
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void CreateGroupConversation(AIMGroupCreateGroupConvParam aIMGroupCreateGroupConvParam, AIMGroupCreateGroupConvListener aIMGroupCreateGroupConvListener) {
            CreateGroupConversationNative(this.nativeRef, aIMGroupCreateGroupConvParam, aIMGroupCreateGroupConvListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void UpdateDefaultTitle(AIMGroupUpdateTitle aIMGroupUpdateTitle, AIMGroupUpdateListener aIMGroupUpdateListener) {
            UpdateDefaultTitleNative(this.nativeRef, aIMGroupUpdateTitle, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void UpdateIcon(AIMGroupUpdateIcon aIMGroupUpdateIcon, AIMGroupUpdateListener aIMGroupUpdateListener) {
            UpdateIconNative(this.nativeRef, aIMGroupUpdateIcon, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void Dismiss(String str, AIMGroupUpdateListener aIMGroupUpdateListener) {
            DismissNative(this.nativeRef, str, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void Leave(AIMGroupLeave aIMGroupLeave, AIMGroupUpdateListener aIMGroupUpdateListener) {
            LeaveNative(this.nativeRef, aIMGroupLeave, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void ListLocalMembers(String str, long j, long j2, AIMGroupListLocalMemberListener aIMGroupListLocalMemberListener) {
            ListLocalMembersNative(this.nativeRef, str, j, j2, aIMGroupListLocalMemberListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void ListAllMembers(String str, AIMGroupListAllMemberListener aIMGroupListAllMemberListener) {
            ListAllMembersNative(this.nativeRef, str, aIMGroupListAllMemberListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void GetMembers(String str, ArrayList<AIMUserId> arrayList, AIMGroupGetMembersListener aIMGroupGetMembersListener) {
            GetMembersNative(this.nativeRef, str, arrayList, aIMGroupGetMembersListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void AddMembers(AIMGroupJoin aIMGroupJoin, AIMGroupAddMembersListener aIMGroupAddMembersListener) {
            AddMembersNative(this.nativeRef, aIMGroupJoin, aIMGroupAddMembersListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveMembers(AIMGroupKick aIMGroupKick, AIMGroupUpdateListener aIMGroupUpdateListener) {
            RemoveMembersNative(this.nativeRef, aIMGroupKick, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void UpdateGroupMemberNick(AIMGroupMemberUpdateNick aIMGroupMemberUpdateNick, AIMGroupMemberNickUpdateListener aIMGroupMemberNickUpdateListener) {
            UpdateGroupMemberNickNative(this.nativeRef, aIMGroupMemberUpdateNick, aIMGroupMemberNickUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void SilenceAll(AIMGroupUpdateSilenceAll aIMGroupUpdateSilenceAll, AIMGroupUpdateListener aIMGroupUpdateListener) {
            SilenceAllNative(this.nativeRef, aIMGroupUpdateSilenceAll, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void CancelSilenceAll(AIMGroupUpdateSilenceAll aIMGroupUpdateSilenceAll, AIMGroupUpdateListener aIMGroupUpdateListener) {
            CancelSilenceAllNative(this.nativeRef, aIMGroupUpdateSilenceAll, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void AddSilencedWhitelist(AIMGroupUpdateSilencedWhiteList aIMGroupUpdateSilencedWhiteList, AIMGroupUpdateListener aIMGroupUpdateListener) {
            AddSilencedWhitelistNative(this.nativeRef, aIMGroupUpdateSilencedWhiteList, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveSilencedWhitelist(AIMGroupUpdateSilencedWhiteList aIMGroupUpdateSilencedWhiteList, AIMGroupUpdateListener aIMGroupUpdateListener) {
            RemoveSilencedWhitelistNative(this.nativeRef, aIMGroupUpdateSilencedWhiteList, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void AddSilencedBlacklist(AIMGroupUpdateSilencedBlackList aIMGroupUpdateSilencedBlackList, AIMGroupUpdateListener aIMGroupUpdateListener) {
            AddSilencedBlacklistNative(this.nativeRef, aIMGroupUpdateSilencedBlackList, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveSilencedBlacklist(AIMGroupUpdateSilencedBlackList aIMGroupUpdateSilencedBlackList, AIMGroupUpdateListener aIMGroupUpdateListener) {
            RemoveSilencedBlacklistNative(this.nativeRef, aIMGroupUpdateSilencedBlackList, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void GetSilencedInfo(String str, AIMGroupGetSilencedInfoListener aIMGroupGetSilencedInfoListener) {
            GetSilencedInfoNative(this.nativeRef, str, aIMGroupGetSilencedInfoListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void AddAdmins(AIMGroupUpdateAdmins aIMGroupUpdateAdmins, AIMGroupUpdateListener aIMGroupUpdateListener) {
            AddAdminsNative(this.nativeRef, aIMGroupUpdateAdmins, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveAdmins(AIMGroupUpdateAdmins aIMGroupUpdateAdmins, AIMGroupUpdateListener aIMGroupUpdateListener) {
            RemoveAdminsNative(this.nativeRef, aIMGroupUpdateAdmins, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void ListAllAdmins(String str, AIMGroupListAllAdminsListener aIMGroupListAllAdminsListener) {
            ListAllAdminsNative(this.nativeRef, str, aIMGroupListAllAdminsListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void SetOwner(AIMGroupSetOwner aIMGroupSetOwner, AIMGroupUpdateListener aIMGroupUpdateListener) {
            SetOwnerNative(this.nativeRef, aIMGroupSetOwner, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void SetMemberPermission(AIMGroupSetMemberPermission aIMGroupSetMemberPermission, AIMGroupUpdateListener aIMGroupUpdateListener) {
            SetMemberPermissionNative(this.nativeRef, aIMGroupSetMemberPermission, aIMGroupUpdateListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void AddGroupChangeListener(AIMGroupChangeListener aIMGroupChangeListener) {
            AddGroupChangeListenerNative(this.nativeRef, aIMGroupChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveGroupChangeListener(AIMGroupChangeListener aIMGroupChangeListener) {
            RemoveGroupChangeListenerNative(this.nativeRef, aIMGroupChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveAllGroupChangeListener() {
            RemoveAllGroupChangeListenerNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void AddGroupMemberChangeListener(AIMGroupMemberChangeListener aIMGroupMemberChangeListener) {
            AddGroupMemberChangeListenerNative(this.nativeRef, aIMGroupMemberChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveGroupMemberChangeListener(AIMGroupMemberChangeListener aIMGroupMemberChangeListener) {
            RemoveGroupMemberChangeListenerNative(this.nativeRef, aIMGroupMemberChangeListener);
        }

        @Override // com.alibaba.android.ark.AIMGroupService
        public void RemoveAllGroupMemberChangeListener() {
            RemoveAllGroupMemberChangeListenerNative(this.nativeRef);
        }
    }
}
