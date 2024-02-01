package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMConversation implements Serializable {
    private static final long serialVersionUID = -349075520156336513L;
    public ArrayList<AIMUserId> admins;
    public String bizType;
    public String cid;
    public long createdAt;
    public String draft;
    public HashMap<String, String> extension;
    public boolean hasLastMsg;
    public String icon;
    public long joinTime;
    public AIMMessage lastMsg;
    public HashMap<String, String> localExtension;
    public int memberCount;
    public int memberLimit;
    public ArrayList<AIMGroupPermission> memberPermissions;
    public long modifyTime;
    public boolean muteNotification;
    public AIMUserId ownerUid;
    public String parentId;
    public int redPoint;
    public boolean silenceAll;
    public long silencedEndtime;
    public AIMGroupSilencedStatus silencedStatus;
    public AIMConvStatus status;
    public String title;
    public long topRank;
    public AIMConvType type;
    public HashMap<String, String> userExtension;
    public ArrayList<AIMUserId> userids;
    public HashMap<String, ArrayList<String>> utags;

    public AIMConversation(String str, AIMConvType aIMConvType, String str2, AIMConvStatus aIMConvStatus, ArrayList<AIMUserId> arrayList, long j, long j2, int i, String str3, boolean z, long j3, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, boolean z2, AIMMessage aIMMessage, long j4, AIMUserId aIMUserId, String str4, String str5, int i2, int i3, boolean z3, AIMGroupSilencedStatus aIMGroupSilencedStatus, long j5, ArrayList<AIMUserId> arrayList2, ArrayList<AIMGroupPermission> arrayList3, HashMap<String, ArrayList<String>> hashMap4, String str6) {
        this.type = AIMConvType.CONV_TYPE_UNKNOW;
        this.status = AIMConvStatus.CONV_STATUS_UNKNOW;
        this.createdAt = 0L;
        this.modifyTime = 0L;
        this.redPoint = 0;
        this.muteNotification = false;
        this.topRank = 0L;
        this.hasLastMsg = false;
        this.joinTime = 0L;
        this.memberCount = 0;
        this.memberLimit = 0;
        this.silenceAll = false;
        this.silencedStatus = AIMGroupSilencedStatus.GROUP_SILENCE_STATUS_NORMAL;
        this.silencedEndtime = 0L;
        this.cid = str;
        if (aIMConvType != null) {
            this.type = aIMConvType;
        }
        this.bizType = str2;
        if (aIMConvStatus != null) {
            this.status = aIMConvStatus;
        }
        this.userids = arrayList;
        this.createdAt = j;
        this.modifyTime = j2;
        this.redPoint = i;
        this.draft = str3;
        this.muteNotification = z;
        this.topRank = j3;
        this.extension = hashMap;
        this.userExtension = hashMap2;
        this.localExtension = hashMap3;
        this.hasLastMsg = z2;
        this.lastMsg = aIMMessage;
        this.joinTime = j4;
        this.ownerUid = aIMUserId;
        this.title = str4;
        this.icon = str5;
        this.memberCount = i2;
        this.memberLimit = i3;
        this.silenceAll = z3;
        if (aIMGroupSilencedStatus != null) {
            this.silencedStatus = aIMGroupSilencedStatus;
        }
        this.silencedEndtime = j5;
        this.admins = arrayList2;
        this.memberPermissions = arrayList3;
        this.utags = hashMap4;
        this.parentId = str6;
    }

    public AIMConversation() {
        this.type = AIMConvType.CONV_TYPE_UNKNOW;
        this.status = AIMConvStatus.CONV_STATUS_UNKNOW;
        this.createdAt = 0L;
        this.modifyTime = 0L;
        this.redPoint = 0;
        this.muteNotification = false;
        this.topRank = 0L;
        this.hasLastMsg = false;
        this.joinTime = 0L;
        this.memberCount = 0;
        this.memberLimit = 0;
        this.silenceAll = false;
        this.silencedStatus = AIMGroupSilencedStatus.GROUP_SILENCE_STATUS_NORMAL;
        this.silencedEndtime = 0L;
    }

    public String getCid() {
        return this.cid;
    }

    public AIMConvType getType() {
        return this.type;
    }

    public String getBizType() {
        return this.bizType;
    }

    public AIMConvStatus getStatus() {
        return this.status;
    }

    public ArrayList<AIMUserId> getUserids() {
        return this.userids;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getModifyTime() {
        return this.modifyTime;
    }

    public int getRedPoint() {
        return this.redPoint;
    }

    public String getDraft() {
        return this.draft;
    }

    public boolean getMuteNotification() {
        return this.muteNotification;
    }

    public long getTopRank() {
        return this.topRank;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public HashMap<String, String> getUserExtension() {
        return this.userExtension;
    }

    public HashMap<String, String> getLocalExtension() {
        return this.localExtension;
    }

    public boolean getHasLastMsg() {
        return this.hasLastMsg;
    }

    public AIMMessage getLastMsg() {
        return this.lastMsg;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public AIMUserId getOwnerUid() {
        return this.ownerUid;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int getMemberLimit() {
        return this.memberLimit;
    }

    public boolean getSilenceAll() {
        return this.silenceAll;
    }

    public AIMGroupSilencedStatus getSilencedStatus() {
        return this.silencedStatus;
    }

    public long getSilencedEndtime() {
        return this.silencedEndtime;
    }

    public ArrayList<AIMUserId> getAdmins() {
        return this.admins;
    }

    public ArrayList<AIMGroupPermission> getMemberPermissions() {
        return this.memberPermissions;
    }

    public HashMap<String, ArrayList<String>> getUtags() {
        return this.utags;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String toString() {
        return "AIMConversation{cid=" + this.cid + ",type=" + this.type + ",bizType=" + this.bizType + ",status=" + this.status + ",userids=" + this.userids + ",createdAt=" + this.createdAt + ",modifyTime=" + this.modifyTime + ",redPoint=" + this.redPoint + ",draft=" + this.draft + ",muteNotification=" + this.muteNotification + ",topRank=" + this.topRank + ",extension=" + this.extension + ",userExtension=" + this.userExtension + ",localExtension=" + this.localExtension + ",hasLastMsg=" + this.hasLastMsg + ",lastMsg=" + this.lastMsg + ",joinTime=" + this.joinTime + ",ownerUid=" + this.ownerUid + ",title=" + this.title + ",icon=" + this.icon + ",memberCount=" + this.memberCount + ",memberLimit=" + this.memberLimit + ",silenceAll=" + this.silenceAll + ",silencedStatus=" + this.silencedStatus + ",silencedEndtime=" + this.silencedEndtime + ",admins=" + this.admins + ",memberPermissions=" + this.memberPermissions + ",utags=" + this.utags + ",parentId=" + this.parentId + "}";
    }
}
