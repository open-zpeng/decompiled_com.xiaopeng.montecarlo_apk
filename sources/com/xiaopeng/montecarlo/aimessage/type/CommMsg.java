package com.xiaopeng.montecarlo.aimessage.type;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.protocol.bean.stats.SceneSwitchStatisticsBean;
import org.eclipse.paho.android.service.MqttServiceConstants;
/* loaded from: classes.dex */
public final class CommMsg {
    @SerializedName("bizType")
    private int mBizType;
    @SerializedName("content")
    private String mContent;
    @SerializedName("content_opportunity")
    private int mContentOpportunity;
    @SerializedName(MqttServiceConstants.MESSAGE_ID)
    private String mMessageId;
    @SerializedName("messageType")
    private int mMessageType;
    @SerializedName("priority")
    private int mPriority;
    @SerializedName(SceneSwitchStatisticsBean.NAME_SCENE)
    private int mScene;
    @SerializedName("ts")
    private long mTs;
    @SerializedName("type")
    private int mType;
    @SerializedName("uid")
    private int mUid;
    @SerializedName("validEndTs")
    private long mValidEndTs;
    @SerializedName("validStartTs")
    private long mValidStartTs;

    public String getMessageId() {
        return this.mMessageId;
    }

    public void setMessageId(String str) {
        this.mMessageId = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public int getContentOpportunity() {
        return this.mContentOpportunity;
    }

    public void setContentOpportunity(int i) {
        this.mContentOpportunity = i;
    }

    public long getValidStartTs() {
        return this.mValidStartTs;
    }

    public void setValidStartTs(long j) {
        this.mValidStartTs = j;
    }

    public long getValidEndTs() {
        return this.mValidEndTs;
    }

    public void setValidEndTs(long j) {
        this.mValidEndTs = j;
    }

    public long getTs() {
        return this.mTs;
    }

    public void setTs(long j) {
        this.mTs = j;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public void setMessageType(int i) {
        this.mMessageType = i;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public int getScene() {
        return this.mScene;
    }

    public void setScene(int i) {
        this.mScene = i;
    }

    public int getBizType() {
        return this.mBizType;
    }

    public void setBizType(int i) {
        this.mBizType = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getUid() {
        return this.mUid;
    }

    public void setUid(int i) {
        this.mUid = i;
    }

    public String toString() {
        return "CommMsg{mMessageId='" + this.mMessageId + "', mContent='" + this.mContent + "', mContentOpportunity=" + this.mContentOpportunity + ", mValidStartTs=" + this.mValidStartTs + ", mValidEndTs=" + this.mValidEndTs + ", mTs=" + this.mTs + ", mMessageType=" + this.mMessageType + ", mPriority=" + this.mPriority + ", mScene=" + this.mScene + ", mBizType=" + this.mBizType + ", mType=" + this.mType + ", mUid=" + this.mUid + '}';
    }
}
