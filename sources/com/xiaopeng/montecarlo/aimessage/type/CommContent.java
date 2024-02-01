package com.xiaopeng.montecarlo.aimessage.type;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public final class CommContent {
    @SerializedName("content")
    private String mContent;
    @SerializedName("opportunity")
    private int mOpportunity;
    @SerializedName("position")
    private int mPosition;
    @SerializedName("type")
    private int mType;

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setOpportunity(int i) {
        this.mOpportunity = i;
    }

    public int getOpportunity() {
        return this.mOpportunity;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }

    public String toString() {
        return "CommContent{mContent='" + this.mContent + "', mOpportunity=" + this.mOpportunity + ", mPosition=" + this.mPosition + ", mType=" + this.mType + '}';
    }
}
