package com.alibaba.android.ark;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMSearchChatContentParams implements Serializable {
    private static final long serialVersionUID = 2055029518010373106L;
    public ArrayList<String> bizTags;
    public ArrayList<String> cids;
    public long endTime;
    public boolean isAsc;
    public boolean isAutoHighlight;
    public String keyword;
    public int maxNum;
    public int offset;
    public ArrayList<AIMUserId> senderIds;
    public long startTime;
    public ArrayList<AIMMsgContentType> supportMsgTypes;
    public ArrayList<Integer> supportSubTypes;

    public AIMSearchChatContentParams(String str, int i, int i2, long j, long j2, boolean z, boolean z2, ArrayList<AIMMsgContentType> arrayList, ArrayList<Integer> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayList<AIMUserId> arrayList5) {
        this.offset = 0;
        this.maxNum = 20;
        this.startTime = 0L;
        this.endTime = Long.MAX_VALUE;
        this.isAutoHighlight = true;
        this.isAsc = true;
        this.keyword = str;
        this.offset = i;
        this.maxNum = i2;
        this.startTime = j;
        this.endTime = j2;
        this.isAutoHighlight = z;
        this.isAsc = z2;
        this.supportMsgTypes = arrayList;
        this.supportSubTypes = arrayList2;
        this.bizTags = arrayList3;
        this.cids = arrayList4;
        this.senderIds = arrayList5;
    }

    public AIMSearchChatContentParams() {
        this.offset = 0;
        this.maxNum = 20;
        this.startTime = 0L;
        this.endTime = Long.MAX_VALUE;
        this.isAutoHighlight = true;
        this.isAsc = true;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public boolean getIsAutoHighlight() {
        return this.isAutoHighlight;
    }

    public boolean getIsAsc() {
        return this.isAsc;
    }

    public ArrayList<AIMMsgContentType> getSupportMsgTypes() {
        return this.supportMsgTypes;
    }

    public ArrayList<Integer> getSupportSubTypes() {
        return this.supportSubTypes;
    }

    public ArrayList<String> getBizTags() {
        return this.bizTags;
    }

    public ArrayList<String> getCids() {
        return this.cids;
    }

    public ArrayList<AIMUserId> getSenderIds() {
        return this.senderIds;
    }

    public String toString() {
        return "AIMSearchChatContentParams{keyword=" + this.keyword + ",offset=" + this.offset + ",maxNum=" + this.maxNum + ",startTime=" + this.startTime + ",endTime=" + this.endTime + ",isAutoHighlight=" + this.isAutoHighlight + ",isAsc=" + this.isAsc + ",supportMsgTypes=" + this.supportMsgTypes + ",supportSubTypes=" + this.supportSubTypes + ",bizTags=" + this.bizTags + ",cids=" + this.cids + ",senderIds=" + this.senderIds + "}";
    }
}
