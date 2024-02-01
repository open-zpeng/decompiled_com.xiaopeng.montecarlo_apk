package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AIMMessage implements Serializable {
    private static final long serialVersionUID = 7968033095458216770L;
    public AIMMsgBizInfo bizInfo;
    public String cid;
    public AIMMsgContent content;
    public long createdAt;
    public AIMMsgDisplayStyle displayStyle;
    public HashMap<String, String> extension;
    public boolean isDelete;
    public boolean isDisableRead;
    public boolean isLocal;
    public boolean isRead;
    public boolean isRecall;
    public HashMap<String, String> localExtension;
    public String localid;
    public String mid;
    public AIMMsgRecallFeature recallFeature;
    public int receiverCount;
    public ArrayList<AIMUserId> receivers;
    public AIMUserId sender;
    public long senderTag;
    public AIMMsgSendStatus status;
    public int unreadCount;
    public HashMap<String, String> userExtension;

    public AIMMessage(String str, String str2, String str3, AIMUserId aIMUserId, long j, long j2, int i, int i2, ArrayList<AIMUserId> arrayList, boolean z, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, String> hashMap3, AIMMsgContent aIMMsgContent, AIMMsgSendStatus aIMMsgSendStatus, boolean z2, boolean z3, boolean z4, boolean z5, AIMMsgBizInfo aIMMsgBizInfo, AIMMsgDisplayStyle aIMMsgDisplayStyle, AIMMsgRecallFeature aIMMsgRecallFeature) {
        this.senderTag = 0L;
        this.createdAt = -1L;
        this.unreadCount = -1;
        this.receiverCount = -1;
        this.isRead = false;
        this.status = AIMMsgSendStatus.SEND_STATUS_UNKNOWN;
        this.isDelete = false;
        this.isRecall = false;
        this.isDisableRead = false;
        this.isLocal = false;
        this.displayStyle = AIMMsgDisplayStyle.DISPLAY_STYLE_USER;
        this.cid = str;
        this.mid = str2;
        this.localid = str3;
        this.sender = aIMUserId;
        this.senderTag = j;
        this.createdAt = j2;
        this.unreadCount = i;
        this.receiverCount = i2;
        this.receivers = arrayList;
        this.isRead = z;
        this.extension = hashMap;
        this.localExtension = hashMap2;
        this.userExtension = hashMap3;
        this.content = aIMMsgContent;
        if (aIMMsgSendStatus != null) {
            this.status = aIMMsgSendStatus;
        }
        this.isDelete = z2;
        this.isRecall = z3;
        this.isDisableRead = z4;
        this.isLocal = z5;
        this.bizInfo = aIMMsgBizInfo;
        if (aIMMsgDisplayStyle != null) {
            this.displayStyle = aIMMsgDisplayStyle;
        }
        this.recallFeature = aIMMsgRecallFeature;
    }

    public AIMMessage() {
        this.senderTag = 0L;
        this.createdAt = -1L;
        this.unreadCount = -1;
        this.receiverCount = -1;
        this.isRead = false;
        this.status = AIMMsgSendStatus.SEND_STATUS_UNKNOWN;
        this.isDelete = false;
        this.isRecall = false;
        this.isDisableRead = false;
        this.isLocal = false;
        this.displayStyle = AIMMsgDisplayStyle.DISPLAY_STYLE_USER;
    }

    public String getCid() {
        return this.cid;
    }

    public String getMid() {
        return this.mid;
    }

    public String getLocalid() {
        return this.localid;
    }

    public AIMUserId getSender() {
        return this.sender;
    }

    public long getSenderTag() {
        return this.senderTag;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public int getReceiverCount() {
        return this.receiverCount;
    }

    public ArrayList<AIMUserId> getReceivers() {
        return this.receivers;
    }

    public boolean getIsRead() {
        return this.isRead;
    }

    public HashMap<String, String> getExtension() {
        return this.extension;
    }

    public HashMap<String, String> getLocalExtension() {
        return this.localExtension;
    }

    public HashMap<String, String> getUserExtension() {
        return this.userExtension;
    }

    public AIMMsgContent getContent() {
        return this.content;
    }

    public AIMMsgSendStatus getStatus() {
        return this.status;
    }

    public boolean getIsDelete() {
        return this.isDelete;
    }

    public boolean getIsRecall() {
        return this.isRecall;
    }

    public boolean getIsDisableRead() {
        return this.isDisableRead;
    }

    public boolean getIsLocal() {
        return this.isLocal;
    }

    public AIMMsgBizInfo getBizInfo() {
        return this.bizInfo;
    }

    public AIMMsgDisplayStyle getDisplayStyle() {
        return this.displayStyle;
    }

    public AIMMsgRecallFeature getRecallFeature() {
        return this.recallFeature;
    }

    public String toString() {
        return "AIMMessage{cid=" + this.cid + ",mid=" + this.mid + ",localid=" + this.localid + ",sender=" + this.sender + ",senderTag=" + this.senderTag + ",createdAt=" + this.createdAt + ",unreadCount=" + this.unreadCount + ",receiverCount=" + this.receiverCount + ",receivers=" + this.receivers + ",isRead=" + this.isRead + ",extension=" + this.extension + ",localExtension=" + this.localExtension + ",userExtension=" + this.userExtension + ",content=" + this.content + ",status=" + this.status + ",isDelete=" + this.isDelete + ",isRecall=" + this.isRecall + ",isDisableRead=" + this.isDisableRead + ",isLocal=" + this.isLocal + ",bizInfo=" + this.bizInfo + ",displayStyle=" + this.displayStyle + ",recallFeature=" + this.recallFeature + "}";
    }
}
