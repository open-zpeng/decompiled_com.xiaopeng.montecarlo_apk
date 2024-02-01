package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMSyncData implements Serializable {
    private static final long serialVersionUID = -5140664992717792812L;
    public byte[] binaryData;
    public int bizType;
    public String data;
    public boolean isOffline;
    public int objectType;
    public String serveId;

    public AIMSyncData(int i, String str, byte[] bArr, int i2, String str2, boolean z) {
        this.objectType = -1;
        this.bizType = -1;
        this.isOffline = false;
        this.objectType = i;
        this.data = str;
        this.binaryData = bArr;
        this.bizType = i2;
        this.serveId = str2;
        this.isOffline = z;
    }

    public AIMSyncData() {
        this.objectType = -1;
        this.bizType = -1;
        this.isOffline = false;
    }

    public int getObjectType() {
        return this.objectType;
    }

    public String getData() {
        return this.data;
    }

    public byte[] getBinaryData() {
        return this.binaryData;
    }

    public int getBizType() {
        return this.bizType;
    }

    public String getServeId() {
        return this.serveId;
    }

    public boolean getIsOffline() {
        return this.isOffline;
    }

    public String toString() {
        return "AIMSyncData{objectType=" + this.objectType + ",data=" + this.data + ",binaryData=" + this.binaryData + ",bizType=" + this.bizType + ",serveId=" + this.serveId + ",isOffline=" + this.isOffline + "}";
    }
}
